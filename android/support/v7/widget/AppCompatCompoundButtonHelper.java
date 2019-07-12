package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import support.android.v4.internal.drawable.DrawableCompat;
import support.android.v4.widget.CompoundButtonCompatDonut;

public class AppCompatCompoundButtonHelper
{
  public ColorStateList mButtonTintList = null;
  public PorterDuff.Mode mButtonTintMode = null;
  public boolean mHasButtonTint = false;
  public boolean mHasButtonTintMode = false;
  public boolean mSkipNextApply;
  public final CompoundButton mView;
  
  public AppCompatCompoundButtonHelper(CompoundButton paramCompoundButton)
  {
    mView = paramCompoundButton;
  }
  
  public void applyButtonTint()
  {
    Drawable localDrawable = CompoundButtonCompatDonut.getButtonDrawable(mView);
    if ((localDrawable != null) && ((mHasButtonTint) || (mHasButtonTintMode)))
    {
      localDrawable = DrawableCompat.wrap(localDrawable).mutate();
      if (mHasButtonTint) {
        DrawableCompat.setTintList(localDrawable, mButtonTintList);
      }
      if (mHasButtonTintMode) {
        DrawableCompat.setTintMode(localDrawable, mButtonTintMode);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(mView.getDrawableState());
      }
      mView.setButtonDrawable(localDrawable);
    }
  }
  
  public int getCompoundPaddingLeft(int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    return paramInt;
  }
  
  public ColorStateList getSupportButtonTintList()
  {
    return mButtonTintList;
  }
  
  public PorterDuff.Mode getSupportButtonTintMode()
  {
    return mButtonTintMode;
  }
  
  public void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = mView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CompoundButton, paramInt, 0);
    try
    {
      boolean bool = paramAttributeSet.hasValue(R.styleable.CompoundButton_android_button);
      if (bool)
      {
        paramInt = paramAttributeSet.getResourceId(R.styleable.CompoundButton_android_button, 0);
        if (paramInt != 0) {
          mView.setButtonDrawable(AppCompatResources.getDrawable(mView.getContext(), paramInt));
        }
      }
      bool = paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTint);
      if (bool) {
        CompoundButtonCompatDonut.setButtonTintList(mView, paramAttributeSet.getColorStateList(R.styleable.CompoundButton_buttonTint));
      }
      bool = paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTintMode);
      if (bool) {
        CompoundButtonCompatDonut.setButtonTintMode(mView, DrawableUtils.parseTintMode(paramAttributeSet.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
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
  
  public void onSetButtonDrawable()
  {
    if (mSkipNextApply)
    {
      mSkipNextApply = false;
      return;
    }
    mSkipNextApply = true;
    applyButtonTint();
  }
  
  public void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    mButtonTintList = paramColorStateList;
    mHasButtonTint = true;
    applyButtonTint();
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    mButtonTintMode = paramMode;
    mHasButtonTintMode = true;
    applyButtonTint();
  }
  
  public static abstract interface DirectSetButtonDrawableInterface
  {
    public abstract void setButtonDrawable(Drawable paramDrawable);
  }
}
