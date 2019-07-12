package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsSeekBar;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import support.android.v4.internal.drawable.DrawableCompat;
import support.android.v4.view.ViewCompat;

public class AppCompatSeekBarHelper
  extends AppCompatProgressBarHelper
{
  public boolean mHasTickMarkTint = false;
  public boolean mHasTickMarkTintMode = false;
  public Drawable mTickMark;
  public ColorStateList mTickMarkTintList = null;
  public PorterDuff.Mode mTickMarkTintMode = null;
  public final SeekBar mView;
  
  public AppCompatSeekBarHelper(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    mView = paramSeekBar;
  }
  
  private void applyTickMarkTint()
  {
    if ((mTickMark != null) && ((mHasTickMarkTint) || (mHasTickMarkTintMode)))
    {
      mTickMark = DrawableCompat.wrap(mTickMark.mutate());
      if (mHasTickMarkTint) {
        DrawableCompat.setTintList(mTickMark, mTickMarkTintList);
      }
      if (mHasTickMarkTintMode) {
        DrawableCompat.setTintMode(mTickMark, mTickMarkTintMode);
      }
      if (mTickMark.isStateful()) {
        mTickMark.setState(mView.getDrawableState());
      }
    }
  }
  
  public void drawTickMarks(Canvas paramCanvas)
  {
    if (mTickMark != null)
    {
      int k = mView.getMax();
      int j = 1;
      if (k > 1)
      {
        int i = mTickMark.getIntrinsicWidth();
        int m = mTickMark.getIntrinsicHeight();
        if (i >= 0) {
          i /= 2;
        } else {
          i = 1;
        }
        if (m >= 0) {
          j = m / 2;
        }
        mTickMark.setBounds(-i, -j, i, j);
        float f = (mView.getWidth() - mView.getPaddingLeft() - mView.getPaddingRight()) / k;
        j = paramCanvas.save();
        paramCanvas.translate(mView.getPaddingLeft(), mView.getHeight() / 2);
        i = 0;
        while (i <= k)
        {
          mTickMark.draw(paramCanvas);
          paramCanvas.translate(f, 0.0F);
          i += 1;
        }
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  public void drawableStateChanged()
  {
    Drawable localDrawable = mTickMark;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(mView.getDrawableState()))) {
      mView.invalidateDrawable(localDrawable);
    }
  }
  
  public Drawable getTickMark()
  {
    return mTickMark;
  }
  
  public ColorStateList getTickMarkTintList()
  {
    return mTickMarkTintList;
  }
  
  public PorterDuff.Mode getTickMarkTintMode()
  {
    return mTickMarkTintMode;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    Drawable localDrawable = mTickMark;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  public void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    super.loadFromAttributes(paramAttributeSet, paramInt);
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(mView.getContext(), paramAttributeSet, R.styleable.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
    if (localDrawable != null) {
      mView.setThumb(localDrawable);
    }
    setTickMark(paramAttributeSet.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
    if (paramAttributeSet.hasValue(R.styleable.AppCompatSeekBar_tickMarkTintMode))
    {
      mTickMarkTintMode = DrawableUtils.parseTintMode(paramAttributeSet.getInt(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), mTickMarkTintMode);
      mHasTickMarkTintMode = true;
    }
    if (paramAttributeSet.hasValue(R.styleable.AppCompatSeekBar_tickMarkTint))
    {
      mTickMarkTintList = paramAttributeSet.getColorStateList(R.styleable.AppCompatSeekBar_tickMarkTint);
      mHasTickMarkTint = true;
    }
    paramAttributeSet.recycle();
    applyTickMarkTint();
  }
  
  public void setTickMark(Drawable paramDrawable)
  {
    Drawable localDrawable = mTickMark;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    mTickMark = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(mView);
      DrawableCompat.setLayoutDirection(paramDrawable, ViewCompat.getLayoutDirection(mView));
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(mView.getDrawableState());
      }
      applyTickMarkTint();
    }
    mView.invalidate();
  }
  
  public void setTickMarkTintList(ColorStateList paramColorStateList)
  {
    mTickMarkTintList = paramColorStateList;
    mHasTickMarkTint = true;
    applyTickMarkTint();
  }
  
  public void setTickMarkTintMode(PorterDuff.Mode paramMode)
  {
    mTickMarkTintMode = paramMode;
    mHasTickMarkTintMode = true;
    applyTickMarkTint();
  }
}
