package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import b.b.a.N;
import support.android.v4.widget.FloatingActionButtonImpl;

@N({b.b.a.N.a.b})
public class AppCompatImageHelper
{
  public TintInfo mImageTint;
  public TintInfo mInternalImageTint;
  public TintInfo mTmpInfo;
  public final ImageView mView;
  
  public AppCompatImageHelper(ImageView paramImageView)
  {
    mView = paramImageView;
  }
  
  private boolean applyFrameworkTintUsingColorFilter(Drawable paramDrawable)
  {
    if (mTmpInfo == null) {
      mTmpInfo = new TintInfo();
    }
    TintInfo localTintInfo = mTmpInfo;
    localTintInfo.clear();
    Object localObject = FloatingActionButtonImpl.createView(mView);
    if (localObject != null)
    {
      mHasTintList = true;
      mTintList = ((ColorStateList)localObject);
    }
    localObject = FloatingActionButtonImpl.getMaxWidth(mView);
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
      return mInternalImageTint != null;
    }
    return i == 21;
  }
  
  public void applySupportImageTint()
  {
    Drawable localDrawable = mView.getDrawable();
    if (localDrawable != null) {
      DrawableUtils.fixDrawable(localDrawable);
    }
    if (localDrawable != null)
    {
      if ((shouldApplyFrameworkTintUsingColorFilter()) && (applyFrameworkTintUsingColorFilter(localDrawable))) {
        return;
      }
      TintInfo localTintInfo = mImageTint;
      if (localTintInfo != null)
      {
        AppCompatDrawableManager.tintDrawable(localDrawable, localTintInfo, mView.getDrawableState());
        return;
      }
      localTintInfo = mInternalImageTint;
      if (localTintInfo != null) {
        AppCompatDrawableManager.tintDrawable(localDrawable, localTintInfo, mView.getDrawableState());
      }
    }
  }
  
  public ColorStateList getSupportImageTintList()
  {
    TintInfo localTintInfo = mImageTint;
    if (localTintInfo != null) {
      return mTintList;
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    TintInfo localTintInfo = mImageTint;
    if (localTintInfo != null) {
      return mTintMode;
    }
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    Drawable localDrawable = mView.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  public void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(mView.getContext(), paramAttributeSet, R.styleable.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable2 = mView.getDrawable();
      Drawable localDrawable1 = localDrawable2;
      paramAttributeSet = localDrawable1;
      if (localDrawable2 == null)
      {
        paramInt = localTintTypedArray.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = localDrawable1;
        if (paramInt != -1)
        {
          localDrawable2 = AppCompatResources.getDrawable(mView.getContext(), paramInt);
          localDrawable1 = localDrawable2;
          paramAttributeSet = localDrawable1;
          if (localDrawable2 != null)
          {
            mView.setImageDrawable(localDrawable2);
            paramAttributeSet = localDrawable1;
          }
        }
      }
      if (paramAttributeSet != null) {
        DrawableUtils.fixDrawable(paramAttributeSet);
      }
      boolean bool = localTintTypedArray.hasValue(R.styleable.AppCompatImageView_tint);
      if (bool) {
        FloatingActionButtonImpl.setBackgroundTintList(mView, localTintTypedArray.getColorStateList(R.styleable.AppCompatImageView_tint));
      }
      bool = localTintTypedArray.hasValue(R.styleable.AppCompatImageView_tintMode);
      if (bool) {
        FloatingActionButtonImpl.setBackgroundTintMode(mView, DrawableUtils.parseTintMode(localTintTypedArray.getInt(R.styleable.AppCompatImageView_tintMode, -1), null));
      }
      localTintTypedArray.recycle();
      return;
    }
    catch (Throwable paramAttributeSet)
    {
      localTintTypedArray.recycle();
      throw paramAttributeSet;
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = AppCompatResources.getDrawable(mView.getContext(), paramInt);
      if (localDrawable != null) {
        DrawableUtils.fixDrawable(localDrawable);
      }
      mView.setImageDrawable(localDrawable);
    }
    else
    {
      mView.setImageDrawable(null);
    }
    applySupportImageTint();
  }
  
  public void setInternalImageTint(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (mInternalImageTint == null) {
        mInternalImageTint = new TintInfo();
      }
      TintInfo localTintInfo = mInternalImageTint;
      mTintList = paramColorStateList;
      mHasTintList = true;
    }
    else
    {
      mInternalImageTint = null;
    }
    applySupportImageTint();
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (mImageTint == null) {
      mImageTint = new TintInfo();
    }
    TintInfo localTintInfo = mImageTint;
    mTintList = paramColorStateList;
    mHasTintList = true;
    applySupportImageTint();
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (mImageTint == null) {
      mImageTint = new TintInfo();
    }
    TintInfo localTintInfo = mImageTint;
    mTintMode = paramMode;
    mHasTintMode = true;
    applySupportImageTint();
  }
}
