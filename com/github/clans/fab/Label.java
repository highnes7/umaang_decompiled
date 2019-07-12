package com.github.clans.fab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import f.commons.data.general.FloatingActionButton.2;
import f.commons.data.general.Label.1;
import f.commons.data.general.Util;

public class Label
  extends TextView
{
  public static final Xfermode PORTER_DUFF_CLEAR = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
  public int a;
  public Drawable mBackgroundDrawable;
  public int mColorNormal;
  public int mColorPressed;
  public int mColorRipple;
  public FloatingActionButton mFab;
  public GestureDetector mGestureDetector = new GestureDetector(getContext(), new FloatingActionButton.2(this));
  public boolean mHandleVisibilityChanges = true;
  public Animation mHideAnimation;
  public int mRawHeight;
  public int mRawWidth;
  public int mShadowColor;
  public int mShadowRadius;
  public int mShadowXOffset;
  public int mShadowYOffset;
  public Animation mShowAnimation;
  public boolean mShowShadow = true;
  public boolean mUsingStyle;
  
  public Label(Context paramContext)
  {
    super(paramContext);
  }
  
  public Label(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Label(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int calculateMeasuredHeight()
  {
    if (mRawHeight == 0) {
      mRawHeight = getMeasuredHeight();
    }
    int i = getMeasuredHeight();
    return calculateShadowHeight() + i;
  }
  
  private int calculateMeasuredWidth()
  {
    if (mRawWidth == 0) {
      mRawWidth = getMeasuredWidth();
    }
    int i = getMeasuredWidth();
    return calculateShadowWidth() + i;
  }
  
  private Drawable createFillDrawable()
  {
    Object localObject = new StateListDrawable();
    Drawable localDrawable = createRectDrawable(mColorNormal);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = createRectDrawable(mColorRipple);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    if (Util.hasLollipop())
    {
      int i = mColorPressed;
      localObject = new RippleDrawable(new ColorStateList(new int[][] { new int[0] }, new int[] { i }), (Drawable)localObject, null);
      setOutlineProvider(new Label.1(this));
      setClipToOutline(true);
      mBackgroundDrawable = ((Drawable)localObject);
      return (Drawable)localObject;
    }
    mBackgroundDrawable = ((Drawable)localObject);
    return localObject;
  }
  
  private Drawable createRectDrawable(int paramInt)
  {
    int i = a;
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, i, i, i, i }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt);
    return localShapeDrawable;
  }
  
  private void playHideAnimation()
  {
    if (mHideAnimation != null)
    {
      mShowAnimation.cancel();
      startAnimation(mHideAnimation);
    }
  }
  
  private void playShowAnimation()
  {
    if (mShowAnimation != null)
    {
      mHideAnimation.cancel();
      startAnimation(mShowAnimation);
    }
  }
  
  private void setBackgroundCompat(Drawable paramDrawable)
  {
    int i = Build.VERSION.SDK_INT;
    setBackground(paramDrawable);
  }
  
  private void setShadow(FloatingActionButton paramFloatingActionButton)
  {
    mShadowColor = paramFloatingActionButton.getShadowColor();
    mShadowRadius = paramFloatingActionButton.getShadowRadius();
    mShadowXOffset = paramFloatingActionButton.getShadowXOffset();
    mShadowYOffset = paramFloatingActionButton.getShadowYOffset();
    mShowShadow = paramFloatingActionButton.hasShadow();
  }
  
  public int calculateShadowHeight()
  {
    if (mShowShadow)
    {
      int i = mShadowRadius;
      return Math.abs(mShadowYOffset) + i;
    }
    return 0;
  }
  
  public int calculateShadowWidth()
  {
    if (mShowShadow)
    {
      int i = mShadowRadius;
      return Math.abs(mShadowXOffset) + i;
    }
    return 0;
  }
  
  public void hide(boolean paramBoolean)
  {
    if (paramBoolean) {
      playHideAnimation();
    }
    setVisibility(4);
  }
  
  public boolean isHandleVisibilityChanges()
  {
    return mHandleVisibilityChanges;
  }
  
  public void onActionDown()
  {
    if (mUsingStyle) {
      mBackgroundDrawable = getBackground();
    }
    Object localObject = mBackgroundDrawable;
    if ((localObject instanceof StateListDrawable))
    {
      ((StateListDrawable)localObject).setState(new int[] { 16842919 });
      return;
    }
    if (Util.hasLollipop())
    {
      localObject = mBackgroundDrawable;
      if ((localObject instanceof RippleDrawable))
      {
        localObject = (RippleDrawable)localObject;
        ((RippleDrawable)localObject).setState(new int[] { 16842910, 16842919 });
        ((RippleDrawable)localObject).setHotspot(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        ((RippleDrawable)localObject).setVisible(true, true);
      }
    }
  }
  
  public void onActionUp()
  {
    if (mUsingStyle) {
      mBackgroundDrawable = getBackground();
    }
    Object localObject = mBackgroundDrawable;
    if ((localObject instanceof StateListDrawable))
    {
      ((StateListDrawable)localObject).setState(new int[0]);
      return;
    }
    if (Util.hasLollipop())
    {
      localObject = mBackgroundDrawable;
      if ((localObject instanceof RippleDrawable))
      {
        localObject = (RippleDrawable)localObject;
        ((RippleDrawable)localObject).setState(new int[0]);
        ((RippleDrawable)localObject).setHotspot(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        ((RippleDrawable)localObject).setVisible(true, true);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(calculateMeasuredWidth(), calculateMeasuredHeight());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    FloatingActionButton localFloatingActionButton = mFab;
    if ((localFloatingActionButton != null) && (localFloatingActionButton.getOnClickListener() != null) && (mFab.isEnabled()))
    {
      int i = paramMotionEvent.getAction();
      if (i != 1)
      {
        if (i == 3)
        {
          onActionUp();
          mFab.onActionUp();
        }
      }
      else
      {
        onActionUp();
        mFab.onActionUp();
      }
      mGestureDetector.onTouchEvent(paramMotionEvent);
      return super.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setColors(int paramInt1, int paramInt2, int paramInt3)
  {
    mColorRipple = paramInt1;
    mColorNormal = paramInt2;
    mColorPressed = paramInt3;
  }
  
  public void setCornerRadius(int paramInt)
  {
    a = paramInt;
  }
  
  public void setFab(FloatingActionButton paramFloatingActionButton)
  {
    mFab = paramFloatingActionButton;
    setShadow(paramFloatingActionButton);
  }
  
  public void setHandleVisibilityChanges(boolean paramBoolean)
  {
    mHandleVisibilityChanges = paramBoolean;
  }
  
  public void setHideAnimation(Animation paramAnimation)
  {
    mHideAnimation = paramAnimation;
  }
  
  public void setShowAnimation(Animation paramAnimation)
  {
    mShowAnimation = paramAnimation;
  }
  
  public void setShowShadow(boolean paramBoolean)
  {
    mShowShadow = paramBoolean;
  }
  
  public void setUsingStyle(boolean paramBoolean)
  {
    mUsingStyle = paramBoolean;
  }
  
  public void show(boolean paramBoolean)
  {
    if (paramBoolean) {
      playShowAnimation();
    }
    setVisibility(0);
  }
  
  public void updateBackground()
  {
    LayerDrawable localLayerDrawable;
    if (mShowShadow)
    {
      localLayerDrawable = new LayerDrawable(new Drawable[] { new a(), createFillDrawable() });
      i = mShadowRadius;
      int j = Math.abs(mShadowXOffset);
      int k = mShadowRadius;
      int m = Math.abs(mShadowYOffset);
      int n = mShadowRadius;
      int i1 = Math.abs(mShadowXOffset);
      int i2 = mShadowRadius;
      localLayerDrawable.setLayerInset(1, j + i, m + k, i1 + n, Math.abs(mShadowYOffset) + i2);
    }
    else
    {
      localLayerDrawable = new LayerDrawable(new Drawable[] { createFillDrawable() });
    }
    int i = Build.VERSION.SDK_INT;
    setBackground(localLayerDrawable);
  }
  
  private class a
    extends Drawable
  {
    public Paint mErase = new Paint(1);
    public Paint mPaint = new Paint(1);
    
    public a()
    {
      init();
    }
    
    private void init()
    {
      setLayerType(1, null);
      mPaint.setStyle(Paint.Style.FILL);
      mPaint.setColor(Label.access$getMColorNormal(Label.this));
      mErase.setXfermode(Label.PORTER_DUFF_CLEAR);
      if (!isInEditMode()) {
        mPaint.setShadowLayer(Label.access$getMShadowRadius(Label.this), Label.access$getMShadowXOffset(Label.this), Label.access$getMShadowYOffset(Label.this), Label.access$getMShadowColor(Label.this));
      }
    }
    
    public void draw(Canvas paramCanvas)
    {
      int i = Label.access$getMShadowRadius(Label.this);
      float f = Math.abs(Label.access$getMShadowXOffset(Label.this)) + i;
      i = Label.access$getMShadowRadius(Label.this);
      RectF localRectF = new RectF(f, Math.abs(Label.access$getMShadowYOffset(Label.this)) + i, Label.access$getMRawWidth(Label.this), Label.access$getMRawHeight(Label.this));
      paramCanvas.drawRoundRect(localRectF, Label.a(Label.this), Label.a(Label.this), mPaint);
      paramCanvas.drawRoundRect(localRectF, Label.a(Label.this), Label.a(Label.this), mErase);
    }
    
    public int getOpacity()
    {
      return 0;
    }
    
    public void setAlpha(int paramInt) {}
    
    public void setColorFilter(ColorFilter paramColorFilter) {}
  }
}
