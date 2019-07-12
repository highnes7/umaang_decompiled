package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import b.b.a.K;

@K(21)
public class RoundRectDrawable
  extends Drawable
{
  public ColorStateList mBackground;
  public final RectF mBoundsF;
  public final Rect mBoundsI;
  public boolean mInsetForPadding = false;
  public boolean mInsetForRadius = true;
  public float mPadding;
  public final Paint mPaint;
  public float mRadius;
  public ColorStateList mTint;
  public PorterDuffColorFilter mTintFilter;
  public PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_IN;
  
  public RoundRectDrawable(ColorStateList paramColorStateList, float paramFloat)
  {
    mRadius = paramFloat;
    mPaint = new Paint(5);
    setBackground(paramColorStateList);
    mBoundsF = new RectF();
    mBoundsI = new Rect();
  }
  
  private PorterDuffColorFilter createTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    }
    return null;
  }
  
  private void setBackground(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    mBackground = localColorStateList;
    mPaint.setColor(mBackground.getColorForState(getState(), mBackground.getDefaultColor()));
  }
  
  private void updateBounds(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    mBoundsF.set(left, top, right, bottom);
    mBoundsI.set(localRect);
    if (mInsetForPadding)
    {
      float f1 = RoundRectDrawableWithShadow.calculateVerticalPadding(mPadding, mRadius, mInsetForRadius);
      float f2 = RoundRectDrawableWithShadow.calculateHorizontalPadding(mPadding, mRadius, mInsetForRadius);
      mBoundsI.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      mBoundsF.set(mBoundsI);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = mPaint;
    int i;
    if ((mTintFilter != null) && (localPaint.getColorFilter() == null))
    {
      localPaint.setColorFilter(mTintFilter);
      i = 1;
    }
    else
    {
      i = 0;
    }
    RectF localRectF = mBoundsF;
    float f = mRadius;
    paramCanvas.drawRoundRect(localRectF, f, f, localPaint);
    if (i != 0) {
      localPaint.setColorFilter(null);
    }
  }
  
  public ColorStateList getColor()
  {
    return mBackground;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void getOutline(Outline paramOutline)
  {
    paramOutline.setRoundRect(mBoundsI, mRadius);
  }
  
  public float getPadding()
  {
    return mPadding;
  }
  
  public float getRadius()
  {
    return mRadius;
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = mTint;
    if ((localColorStateList == null) || (!localColorStateList.isStateful())) {
      localColorStateList = mBackground;
    }
    return ((localColorStateList != null) && (localColorStateList.isStateful())) || (super.isStateful());
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    updateBounds(paramRect);
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    Object localObject = mBackground;
    int i = ((ColorStateList)localObject).getColorForState(paramArrayOfInt, ((ColorStateList)localObject).getDefaultColor());
    boolean bool;
    if (i != mPaint.getColor()) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      mPaint.setColor(i);
    }
    paramArrayOfInt = mTint;
    if (paramArrayOfInt != null)
    {
      localObject = mTintMode;
      if (localObject != null)
      {
        mTintFilter = createTintFilter(paramArrayOfInt, (PorterDuff.Mode)localObject);
        return true;
      }
    }
    return bool;
  }
  
  public void setAlpha(int paramInt)
  {
    mPaint.setAlpha(paramInt);
  }
  
  public void setColor(ColorStateList paramColorStateList)
  {
    setBackground(paramColorStateList);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setPadding(float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramFloat == mPadding) && (mInsetForPadding == paramBoolean1) && (mInsetForRadius == paramBoolean2)) {
      return;
    }
    mPadding = paramFloat;
    mInsetForPadding = paramBoolean1;
    mInsetForRadius = paramBoolean2;
    updateBounds(null);
    invalidateSelf();
  }
  
  public void setRadius(float paramFloat)
  {
    if (paramFloat == mRadius) {
      return;
    }
    mRadius = paramFloat;
    updateBounds(null);
    invalidateSelf();
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    mTint = paramColorStateList;
    mTintFilter = createTintFilter(mTint, mTintMode);
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    mTintMode = paramMode;
    mTintFilter = createTintFilter(mTint, mTintMode);
    invalidateSelf();
  }
}
