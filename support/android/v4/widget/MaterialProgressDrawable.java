package support.android.v4.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import support.android.v4.view.animation.FastOutLinearInInterpolator;

public class MaterialProgressDrawable
  extends Drawable
  implements Animatable
{
  public static final int ANIMATION_DURATION = 1332;
  public static final int ARROW_HEIGHT = 5;
  public static final int ARROW_HEIGHT_LARGE = 6;
  public static final int ARROW_WIDTH = 10;
  public static final int ARROW_WIDTH_LARGE = 12;
  public static final int[] COLORS = { -16777216 };
  public static final float COLOR_START_DELAY_OFFSET = 0.75F;
  public static final int DEFAULT = 1;
  public static final float END_TRIM_START_DELAY_OFFSET = 0.5F;
  public static final float FULL_ROTATION = 0.01F;
  public static final int LARGE = 0;
  public static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
  public static final Interpolator MATERIAL_INTERPOLATOR = new FastOutLinearInInterpolator();
  public static final float MAX_PROGRESS_ARC = 0.8F;
  public static final float SHADOW_RADIUS = 7.5F;
  public static final float START_TRIM_DURATION_OFFSET = 11.0F;
  public static final float STROKE_WIDTH = 2.5F;
  public static final float STROKE_WIDTH_LARGE = 3.0F;
  public static final float X_OFFSET = 216.0F;
  public static final float mRotationCount = 0.20999998F;
  public Animator mAnimator;
  public boolean mFinishing;
  public Resources mResources;
  public final Ring mRing;
  public float mRotate;
  public float mRotation;
  
  public MaterialProgressDrawable(Context paramContext)
  {
    if (paramContext != null)
    {
      mResources = paramContext.getResources();
      mRing = new Ring();
      mRing.setColors(COLORS);
      setAlpha(2.5F);
      startAnimation();
      return;
    }
    throw new NullPointerException();
  }
  
  private void applyFinishTranslation(float paramFloat, Ring paramRing)
  {
    updateRingColor(paramFloat, paramRing);
    float f1 = (float)(Math.floor(paramRing.getStartingRotation() / 0.8F) + 1.0D);
    float f2 = paramRing.getStartingStartTrim();
    paramRing.setStartTrim((paramRing.getStartingEndTrim() - 0.01F - paramRing.getStartingStartTrim()) * paramFloat + f2);
    paramRing.setEndTrim(paramRing.getStartingEndTrim());
    f2 = paramRing.getStartingRotation();
    paramRing.setRotation((f1 - paramRing.getStartingRotation()) * paramFloat + f2);
  }
  
  private int evaluateColorChange(float paramFloat, int paramInt1, int paramInt2)
  {
    int i = paramInt1 >> 24 & 0xFF;
    int j = paramInt1 >> 16 & 0xFF;
    int k = paramInt1 >> 8 & 0xFF;
    paramInt1 &= 0xFF;
    return i + (int)(((paramInt2 >> 24 & 0xFF) - i) * paramFloat) << 24 | j + (int)(((paramInt2 >> 16 & 0xFF) - j) * paramFloat) << 16 | k + (int)(((paramInt2 >> 8 & 0xFF) - k) * paramFloat) << 8 | paramInt1 + (int)(paramFloat * ((paramInt2 & 0xFF) - paramInt1));
  }
  
  private float getRotation()
  {
    return mRotation;
  }
  
  private void setRotation(float paramFloat)
  {
    mRotation = paramFloat;
  }
  
  private void setSizeParameters(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Ring localRing = mRing;
    float f = mResources.getDisplayMetrics().density;
    localRing.setStrokeWidth(paramFloat2 * f);
    localRing.setColorIndex(paramFloat1 * f);
    localRing.setColorIndex(0);
    localRing.draw(paramFloat3 * f, paramFloat4 * f);
  }
  
  private void startAnimation()
  {
    Ring localRing = mRing;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat.1(this, localRing));
    localValueAnimator.setRepeatCount(-1);
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setInterpolator(LINEAR_INTERPOLATOR);
    localValueAnimator.addListener(new ScrollingTabContainerView.VisibilityAnimListener(this, localRing));
    mAnimator = localValueAnimator;
  }
  
  public void draw(float paramFloat1, float paramFloat2)
  {
    mRing.draw(paramFloat1, paramFloat2);
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(mRotation, localRect.exactCenterX(), localRect.exactCenterY());
    mRing.draw(paramCanvas, localRect);
    paramCanvas.restore();
  }
  
  public boolean draw()
  {
    return mRing.draw();
  }
  
  public int getAlpha()
  {
    return mRing.getAlpha();
  }
  
  public float getMinProgressArc()
  {
    return mRing.getStrokeWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return mAnimator.isRunning();
  }
  
  public float setAlpha()
  {
    return mRing.setColorIndex();
  }
  
  public void setAlpha(float paramFloat)
  {
    mRing.setStrokeWidth(paramFloat);
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    mRing.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public int setArrowScale()
  {
    return mRing.setArrowScale();
  }
  
  public void setArrowScale(float paramFloat)
  {
    mRing.setArrowScale(paramFloat);
    invalidateSelf();
  }
  
  public int[] setBackgroundColor()
  {
    return mRing.getColor();
  }
  
  public float setColorFilter()
  {
    return mRing.setColorFilter();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    mRing.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setColorFilter(Paint.Cap paramCap)
  {
    mRing.setColorFilter(paramCap);
    invalidateSelf();
  }
  
  public float setColorSchemeColors()
  {
    return mRing.setColors();
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    mRing.setColors(paramVarArgs);
    mRing.setColorIndex(0);
    invalidateSelf();
  }
  
  public float setProgressRotation()
  {
    return mRing.getEndTrim();
  }
  
  public void setProgressRotation(float paramFloat)
  {
    mRing.setRotation(paramFloat);
    invalidateSelf();
  }
  
  public void setRotation(float paramFloat, Ring paramRing, boolean paramBoolean)
  {
    if (mFinishing)
    {
      applyFinishTranslation(paramFloat, paramRing);
      return;
    }
    if ((paramFloat != 1.0F) || (paramBoolean))
    {
      float f3 = paramRing.getStartingRotation();
      float f1;
      float f2;
      if (paramFloat < 0.5F)
      {
        f1 = paramFloat / 0.5F;
        f2 = paramRing.getStartingStartTrim();
        f1 = MATERIAL_INTERPOLATOR.getInterpolation(f1) * 0.79F + 0.01F + f2;
      }
      else
      {
        f2 = (paramFloat - 0.5F) / 0.5F;
        f1 = paramRing.getStartingStartTrim() + 0.79F;
        f2 = f1 - ((1.0F - MATERIAL_INTERPOLATOR.getInterpolation(f2)) * 0.79F + 0.01F);
      }
      float f4 = mRotate;
      paramRing.setStartTrim(f2);
      paramRing.setEndTrim(f1);
      paramRing.setRotation(0.20999998F * paramFloat + f3);
      mRotation = ((paramFloat + f4) * 216.0F);
    }
  }
  
  public float setSizeParameters()
  {
    return mRing.setInsets();
  }
  
  public float setStartEndTrim()
  {
    return mRing.getRotation();
  }
  
  public void setStartEndTrim(float paramFloat1, float paramFloat2)
  {
    mRing.setStartTrim(paramFloat1);
    mRing.setEndTrim(paramFloat2);
    invalidateSelf();
  }
  
  public Paint.Cap setupAnimators()
  {
    return mRing.setStrokeWidth();
  }
  
  public float showArrow()
  {
    return mRing.getStartTrim();
  }
  
  public void showArrow(boolean paramBoolean)
  {
    mRing.setShowArrow(paramBoolean);
    invalidateSelf();
  }
  
  public void start()
  {
    mAnimator.cancel();
    mRing.storeOriginals();
    if (mRing.getEndTrim() != mRing.getStartTrim())
    {
      mFinishing = true;
      mAnimator.setDuration(666L);
      mAnimator.start();
      return;
    }
    mRing.setColorIndex(0);
    mRing.resetOriginals();
    mAnimator.setDuration(1332L);
    mAnimator.start();
  }
  
  public void start(float paramFloat)
  {
    mRing.setColorIndex(paramFloat);
    invalidateSelf();
  }
  
  public void start(int paramInt)
  {
    mRing.draw(paramInt);
    invalidateSelf();
  }
  
  public void stop()
  {
    mAnimator.cancel();
    mRotation = 0.0F;
    mRing.setShowArrow(false);
    mRing.setColorIndex(0);
    mRing.resetOriginals();
    invalidateSelf();
  }
  
  public void updateRingColor(float paramFloat, Ring paramRing)
  {
    if (paramFloat > 0.75F)
    {
      paramRing.setColor(evaluateColorChange((paramFloat - 0.75F) / 0.25F, paramRing.getStartingColor(), paramRing.getNextColor()));
      return;
    }
    paramRing.setColor(paramRing.getStartingColor());
  }
  
  public void updateSizes(int paramInt)
  {
    if (paramInt == 0) {
      setSizeParameters(11.0F, 3.0F, 12.0F, 6.0F);
    } else {
      setSizeParameters(7.5F, 2.5F, 10.0F, 5.0F);
    }
    invalidateSelf();
  }
  
  public class Ring
  {
    public int left;
    public int mAlpha = 255;
    public Path mArrow;
    public final Paint mArrowPaint = new Paint();
    public final Paint mCirclePaint = new Paint();
    public int mColorIndex;
    public int[] mColors;
    public int mCurrentColor;
    public float mEndTrim = 0.0F;
    public final Paint mPaint = new Paint();
    public final RectF mRect = new RectF();
    public float mRotation = 0.0F;
    public boolean mShowArrow;
    public float mStartTrim = 0.0F;
    public float mStartingEndTrim;
    public float mStartingRotation;
    public float mStartingStartTrim;
    public float mWidth;
    public int top;
    public float width = 1.0F;
    public float y = 5.0F;
    
    public Ring()
    {
      mPaint.setStrokeCap(Paint.Cap.SQUARE);
      mPaint.setAntiAlias(true);
      mPaint.setStyle(Paint.Style.STROKE);
      mArrowPaint.setStyle(Paint.Style.FILL);
      mArrowPaint.setAntiAlias(true);
      mCirclePaint.setColor(0);
    }
    
    public void draw(float paramFloat1, float paramFloat2)
    {
      top = ((int)paramFloat1);
      left = ((int)paramFloat2);
    }
    
    public void draw(int paramInt)
    {
      mCirclePaint.setColor(paramInt);
    }
    
    public void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2, RectF paramRectF)
    {
      if (mShowArrow)
      {
        Path localPath = mArrow;
        if (localPath == null)
        {
          mArrow = new Path();
          mArrow.setFillType(Path.FillType.EVEN_ODD);
        }
        else
        {
          localPath.reset();
        }
        float f1 = Math.min(paramRectF.width(), paramRectF.height()) / 2.0F;
        float f2 = top * width / 2.0F;
        mArrow.moveTo(0.0F, 0.0F);
        mArrow.lineTo(top * width, 0.0F);
        localPath = mArrow;
        float f3 = top;
        float f4 = width;
        localPath.lineTo(f3 * f4 / 2.0F, left * f4);
        localPath = mArrow;
        f3 = paramRectF.centerX();
        f4 = paramRectF.centerY();
        localPath.offset(f3 + f1 - f2, y / 2.0F + f4);
        mArrow.close();
        mArrowPaint.setColor(mCurrentColor);
        mArrowPaint.setAlpha(mAlpha);
        paramCanvas.save();
        paramCanvas.rotate(paramFloat1 + paramFloat2, paramRectF.centerX(), paramRectF.centerY());
        paramCanvas.drawPath(mArrow, mArrowPaint);
        paramCanvas.restore();
      }
    }
    
    public void draw(Canvas paramCanvas, Rect paramRect)
    {
      RectF localRectF = mRect;
      float f2 = mWidth;
      float f1 = y / 2.0F + f2;
      if (f2 <= 0.0F) {
        f1 = Math.min(paramRect.width(), paramRect.height()) / 2.0F - Math.max(top * width / 2.0F, y / 2.0F);
      }
      localRectF.set(paramRect.centerX() - f1, paramRect.centerY() - f1, paramRect.centerX() + f1, paramRect.centerY() + f1);
      f1 = mStartTrim;
      f2 = mRotation;
      f1 = (f1 + f2) * 360.0F;
      f2 = (mEndTrim + f2) * 360.0F - f1;
      mPaint.setColor(mCurrentColor);
      mPaint.setAlpha(mAlpha);
      float f3 = y / 2.0F;
      localRectF.inset(f3, f3);
      paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, mCirclePaint);
      f3 = -f3;
      localRectF.inset(f3, f3);
      paramCanvas.drawArc(localRectF, f1, f2, false, mPaint);
      draw(paramCanvas, f1, f2, localRectF);
    }
    
    public boolean draw()
    {
      return mShowArrow;
    }
    
    public int getAlpha()
    {
      return mAlpha;
    }
    
    public int[] getColor()
    {
      return mColors;
    }
    
    public float getEndTrim()
    {
      return mEndTrim;
    }
    
    public int getNextColor()
    {
      return mColors[getNextColorIndex()];
    }
    
    public int getNextColorIndex()
    {
      return (mColorIndex + 1) % mColors.length;
    }
    
    public float getRotation()
    {
      return mRotation;
    }
    
    public float getStartTrim()
    {
      return mStartTrim;
    }
    
    public int getStartingColor()
    {
      return mColors[mColorIndex];
    }
    
    public float getStartingEndTrim()
    {
      return mStartingEndTrim;
    }
    
    public float getStartingRotation()
    {
      return mStartingRotation;
    }
    
    public float getStartingStartTrim()
    {
      return mStartingStartTrim;
    }
    
    public float getStrokeWidth()
    {
      return width;
    }
    
    public void goToNextColor()
    {
      setColorIndex(getNextColorIndex());
    }
    
    public void resetOriginals()
    {
      mStartingStartTrim = 0.0F;
      mStartingEndTrim = 0.0F;
      mStartingRotation = 0.0F;
      setStartTrim(0.0F);
      setEndTrim(0.0F);
      setRotation(0.0F);
    }
    
    public void setAlpha(int paramInt)
    {
      mAlpha = paramInt;
    }
    
    public int setArrowScale()
    {
      return mCirclePaint.getColor();
    }
    
    public void setArrowScale(float paramFloat)
    {
      if (paramFloat != width) {
        width = paramFloat;
      }
    }
    
    public void setColor(int paramInt)
    {
      mCurrentColor = paramInt;
    }
    
    public float setColorFilter()
    {
      return left;
    }
    
    public void setColorFilter(ColorFilter paramColorFilter)
    {
      mPaint.setColorFilter(paramColorFilter);
    }
    
    public void setColorFilter(Paint.Cap paramCap)
    {
      mPaint.setStrokeCap(paramCap);
    }
    
    public float setColorIndex()
    {
      return mWidth;
    }
    
    public void setColorIndex(float paramFloat)
    {
      mWidth = paramFloat;
    }
    
    public void setColorIndex(int paramInt)
    {
      mColorIndex = paramInt;
      mCurrentColor = mColors[mColorIndex];
    }
    
    public float setColors()
    {
      return y;
    }
    
    public void setColors(int[] paramArrayOfInt)
    {
      mColors = paramArrayOfInt;
      setColorIndex(0);
    }
    
    public void setEndTrim(float paramFloat)
    {
      mEndTrim = paramFloat;
    }
    
    public float setInsets()
    {
      return top;
    }
    
    public void setRotation(float paramFloat)
    {
      mRotation = paramFloat;
    }
    
    public void setShowArrow(boolean paramBoolean)
    {
      if (mShowArrow != paramBoolean) {
        mShowArrow = paramBoolean;
      }
    }
    
    public void setStartTrim(float paramFloat)
    {
      mStartTrim = paramFloat;
    }
    
    public Paint.Cap setStrokeWidth()
    {
      return mPaint.getStrokeCap();
    }
    
    public void setStrokeWidth(float paramFloat)
    {
      y = paramFloat;
      mPaint.setStrokeWidth(paramFloat);
    }
    
    public void storeOriginals()
    {
      mStartingStartTrim = mStartTrim;
      mStartingEndTrim = mEndTrim;
      mStartingRotation = mRotation;
    }
  }
}
