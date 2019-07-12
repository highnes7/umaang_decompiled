package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import support.android.v4.view.ViewCompat;

public class AppCompatBackgroundHelper
{
  public int mBackgroundResId = -1;
  public TintInfo mBackgroundTint;
  public final AppCompatDrawableManager mDrawableManager;
  public TintInfo mInternalBackgroundTint;
  public TintInfo mTmpInfo;
  public final View mView;
  
  public AppCompatBackgroundHelper(View paramView)
  {
    mView = paramView;
    mDrawableManager = AppCompatDrawableManager.get();
  }
  
  private boolean applyFrameworkTintUsingColorFilter(Drawable paramDrawable)
  {
    if (mTmpInfo == null) {
      mTmpInfo = new TintInfo();
    }
    TintInfo localTintInfo = mTmpInfo;
    localTintInfo.clear();
    Object localObject = ViewCompat.getBackgroundTintList(mView);
    if (localObject != null)
    {
      mHasTintList = true;
      mTintList = ((ColorStateList)localObject);
    }
    localObject = ViewCompat.getBackgroundTintMode(mView);
    if (localObject != null)
    {
      mHasTintMode = true;
      mTintMode = ((PorterDuff.Mode)localObject);
    }
    if ((!mHasTintList) && (!mHasTintMode)) {
      return false;
    }
    AppCompatDrawableManager.tintDrawable(paramDrawable, localTintInfo, mView.getDrawableState());
    return true;
  }
  
  private boolean shouldApplyFrameworkTintUsingColorFilter()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      return mInternalBackgroundTint != null;
    }
    return i == 21;
  }
  
  public void applySupportBackgroundTint()
  {
    Drawable localDrawable = mView.getBackground();
    if (localDrawable != null)
    {
      if ((shouldApplyFrameworkTintUsingColorFilter()) && (applyFrameworkTintUsingColorFilter(localDrawable))) {
        return;
      }
      TintInfo localTintInfo = mBackgroundTint;
      if (localTintInfo != null)
      {
        AppCompatDrawableManager.tintDrawable(localDrawable, localTintInfo, mView.getDrawableState());
        return;
      }
      localTintInfo = mInternalBackgroundTint;
      if (localTintInfo != null) {
        AppCompatDrawableManager.tintDrawable(localDrawable, localTintInfo, mView.getDrawableState());
      }
    }
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    TintInfo localTintInfo = mBackgroundTint;
    if (localTintInfo != null) {
      return mTintList;
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    TintInfo localTintInfo = mBackgroundTint;
    if (localTintInfo != null) {
      return mTintMode;
    }
    return null;
  }
  
  public void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(mView.getContext(), paramAttributeSet, R.styleable.ViewBackgroundHelper, paramInt, 0);
    try
    {
      boolean bool = paramAttributeSet.hasValue(R.styleable.ViewBackgroundHelper_android_background);
      if (bool)
      {
        mBackgroundResId = paramAttributeSet.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);
        ColorStateList localColorStateList = mDrawableManager.getTintList(mView.getContext(), mBackgroundResId);
        if (localColorStateList != null) {
          setInternalBackgroundTint(localColorStateList);
        }
      }
      bool = paramAttributeSet.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint);
      if (bool) {
        ViewCompat.setBackgroundTintList(mView, paramAttributeSet.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint));
      }
      bool = paramAttributeSet.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode);
      if (bool) {
        ViewCompat.setBackgroundTintMode(mView, DrawableUtils.parseTintMode(paramAttributeSet.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
      }
      paramAttributeSet.recycle();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramAttributeSet.recycle();
      throw localThrowable;
    }
  }
  
  public void onSetBackgroundDrawable(Drawable paramDrawable)
  {
    mBackgroundResId = -1;
    setInternalBackgroundTint(null);
    applySupportBackgroundTint();
  }
  
  public void onSetBackgroundResource(int paramInt)
  {
    mBackgroundResId = paramInt;
    Object localObject = mDrawableManager;
    if (localObject != null) {
      localObject = ((AppCompatDrawableManager)localObject).getTintList(mView.getContext(), paramInt);
    } else {
      localObject = null;
    }
    setInternalBackgroundTint((ColorStateList)localObject);
    applySupportBackgroundTint();
  }
  
  public void setInternalBackgroundTint(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (mInternalBackgroundTint == null) {
        mInternalBackgroundTint = new TintInfo();
      }
      TintInfo localTintInfo = mInternalBackgroundTint;
      mTintList = paramColorStateList;
      mHasTintList = true;
    }
    else
    {
      mInternalBackgroundTint = null;
    }
    applySupportBackgroundTint();
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (mBackgroundTint == null) {
      mBackgroundTint = new TintInfo();
    }
    TintInfo localTintInfo = mBackgroundTint;
    mTintList = paramColorStateList;
    mHasTintList = true;
    applySupportBackgroundTint();
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (mBackgroundTint == null) {
      mBackgroundTint = new TintInfo();
    }
    TintInfo localTintInfo = mBackgroundTint;
    mTintMode = paramMode;
    mHasTintMode = true;
    applySupportBackgroundTint();
  }
}
