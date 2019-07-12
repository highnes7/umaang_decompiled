package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import support.android.v4.content.ContextCompat;
import support.android.v4.view.AccessibilityDelegateCompat;
import support.android.v4.view.ViewCompat;
import support.android.v4.view.accessibility.AccessibilityNodeInfoCompat;
import support.android.v4.widget.DiscreteSeekBar.CustomState.1;
import support.android.v4.widget.ViewDragHelper;
import support.android.v4.widget.ViewDragHelper.Callback;

public class SlidingPaneLayout
  extends ViewGroup
{
  public static final int DEFAULT_FADE_COLOR = -858993460;
  public static final int DEFAULT_OVERHANG_SIZE = 32;
  public static final int MIN_FLING_VELOCITY = 400;
  public static final String TAG = "SlidingPaneLayout";
  public Field expression;
  public boolean mCanSlide;
  public int mCoveredFadeColor;
  public final ViewDragHelper mDragHelper;
  public boolean mFirstLayout = true;
  public float mInitialMotionX;
  public float mInitialMotionY;
  public boolean mIsUnableToDrag;
  public boolean mNoCrossFade;
  public final int mOverhangSize;
  public d mPanelSlideListener;
  public int mParallaxBy;
  public float mParallaxOffset;
  public final ArrayList<b> mPostedRunnables = new ArrayList();
  public boolean mPreservedOpenState;
  public Drawable mShadowDrawableLeft;
  public Drawable mShadowDrawableRight;
  public float mSlideOffset;
  public int mSlideRange;
  public View mSlideableView;
  public int mSliderFadeColor = -858993460;
  public final Rect mTmpRect = new Rect();
  public Method rulesMethod;
  
  public SlidingPaneLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = getResourcesgetDisplayMetricsdensity;
    mOverhangSize = ((int)(32.0F * f + 0.5F));
    setWillNotDraw(false);
    ViewCompat.setAccessibilityDelegate(this, new a());
    ViewCompat.setImportantForAccessibility(this, 1);
    mDragHelper = ViewDragHelper.create(this, 0.5F, new c());
    mDragHelper.setMinVelocity(f * 400.0F);
  }
  
  private boolean closePane(View paramView, int paramInt)
  {
    if ((!mFirstLayout) && (!smoothSlideTo(0.0F, paramInt))) {
      return false;
    }
    mPreservedOpenState = false;
    return true;
  }
  
  private void dimChildView(View paramView, float paramFloat, int paramInt)
  {
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      int i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (dimPaint == null) {
        dimPaint = new Paint();
      }
      dimPaint.setColorFilter(new PorterDuffColorFilter(i << 24 | paramInt & 0xFFFFFF, PorterDuff.Mode.SRC_OVER));
      if (paramView.getLayerType() != 2) {
        paramView.setLayerType(2, dimPaint);
      }
      invalidateChildRegion(paramView);
      return;
    }
    if (paramView.getLayerType() != 0)
    {
      localObject = dimPaint;
      if (localObject != null) {
        ((Paint)localObject).setColorFilter(null);
      }
      paramView = new b(paramView);
      mPostedRunnables.add(paramView);
      ViewCompat.postOnAnimation(this, paramView);
    }
  }
  
  private boolean openPane(View paramView, int paramInt)
  {
    if ((!mFirstLayout) && (!smoothSlideTo(1.0F, paramInt))) {
      return false;
    }
    mPreservedOpenState = true;
    return true;
  }
  
  private void parallaxOtherViews(float paramFloat)
  {
    boolean bool1 = isLayoutRtlSupport();
    Object localObject = (LayoutParams)mSlideableView.getLayoutParams();
    boolean bool2 = dimWhenOffset;
    int j = 0;
    if (bool2)
    {
      if (bool1) {
        i = rightMargin;
      } else {
        i = leftMargin;
      }
      if (i <= 0)
      {
        i = 1;
        break label64;
      }
    }
    int i = 0;
    label64:
    int n = getChildCount();
    while (j < n)
    {
      localObject = getChildAt(j);
      if (localObject != mSlideableView)
      {
        float f = mParallaxOffset;
        int k = mParallaxBy;
        int m = (int)((1.0F - f) * k);
        mParallaxOffset = paramFloat;
        m -= (int)((1.0F - paramFloat) * k);
        k = m;
        if (bool1) {
          k = -m;
        }
        ((View)localObject).offsetLeftAndRight(k);
        if (i != 0)
        {
          if (bool1) {
            f = mParallaxOffset - 1.0F;
          } else {
            f = 1.0F - mParallaxOffset;
          }
          dimChildView((View)localObject, f, mCoveredFadeColor);
        }
      }
      j += 1;
    }
  }
  
  public static boolean viewIsOpaque(View paramView)
  {
    if (paramView.isOpaque()) {
      return true;
    }
    int i = Build.VERSION.SDK_INT;
    return false;
  }
  
  public boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i = localViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = localViewGroup.getChildAt(i);
        int m = paramInt2 + j;
        if ((m >= localView.getLeft()) && (m < localView.getRight()))
        {
          int n = paramInt3 + k;
          if ((n >= localView.getTop()) && (n < localView.getBottom()) && (canScroll(localView, true, paramInt1, m - localView.getLeft(), n - localView.getTop()))) {
            return true;
          }
        }
        i -= 1;
      }
    }
    if (paramBoolean)
    {
      if (!isLayoutRtlSupport()) {
        paramInt1 = -paramInt1;
      }
      if (paramView.canScrollHorizontally(paramInt1)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean canSlide()
  {
    return mCanSlide;
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public boolean closePane()
  {
    return closePane(mSlideableView, 0);
  }
  
  public void computeScroll()
  {
    if (mDragHelper.continueSettling(true))
    {
      if (!mCanSlide)
      {
        mDragHelper.abort();
        return;
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void dispatchOnPanelClosed(View paramView)
  {
    d localD = mPanelSlideListener;
    if (localD != null) {
      localD.onPanelClosed(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  public void dispatchOnPanelOpened(View paramView)
  {
    d localD = mPanelSlideListener;
    if (localD != null) {
      localD.onPanelOpened(paramView);
    }
    sendAccessibilityEvent(32);
  }
  
  public void dispatchOnPanelSlide(View paramView)
  {
    d localD = mPanelSlideListener;
    if (localD != null) {
      localD.onPanelSlide(paramView, mSlideOffset);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    if (isLayoutRtlSupport()) {
      localDrawable = mShadowDrawableRight;
    } else {
      localDrawable = mShadowDrawableLeft;
    }
    View localView;
    if (getChildCount() > 1) {
      localView = getChildAt(1);
    } else {
      localView = null;
    }
    if (localView != null)
    {
      if (localDrawable == null) {
        return;
      }
      int m = localView.getTop();
      int n = localView.getBottom();
      int k = localDrawable.getIntrinsicWidth();
      int j;
      int i;
      if (isLayoutRtlSupport())
      {
        j = localView.getRight();
        i = j;
        j = k + j;
        k = i;
      }
      else
      {
        j = localView.getLeft();
        i = j;
        k = j - k;
        j = i;
      }
      localDrawable.setBounds(k, m, j, n);
      localDrawable.draw(paramCanvas);
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save();
    if ((mCanSlide) && (!slideable) && (mSlideableView != null))
    {
      paramCanvas.getClipBounds(mTmpRect);
      if (isLayoutRtlSupport())
      {
        localObject = mTmpRect;
        left = Math.max(left, mSlideableView.getRight());
      }
      else
      {
        localObject = mTmpRect;
        right = Math.min(right, mSlideableView.getLeft());
      }
      paramCanvas.clipRect(mTmpRect);
    }
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i);
    return bool;
  }
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getCoveredFadeColor()
  {
    return mCoveredFadeColor;
  }
  
  public int getParallaxDistance()
  {
    return mParallaxBy;
  }
  
  public int getSliderFadeColor()
  {
    return mSliderFadeColor;
  }
  
  public void invalidateChildRegion(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    ViewCompat.setLayerPaint(paramView, getLayoutParamsdimPaint);
  }
  
  public boolean isDimmed(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView = (LayoutParams)paramView.getLayoutParams();
    return (mCanSlide) && (dimWhenOffset) && (mSlideOffset > 0.0F);
  }
  
  public boolean isLayoutRtlSupport()
  {
    return ViewCompat.getLayoutDirection(this) == 1;
  }
  
  public boolean isOpen()
  {
    return (!mCanSlide) || (mSlideOffset == 1.0F);
  }
  
  public boolean isSlideable()
  {
    return mCanSlide;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    mFirstLayout = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    mFirstLayout = true;
    int j = mPostedRunnables.size();
    int i = 0;
    while (i < j)
    {
      ((b)mPostedRunnables.get(i)).run();
      i += 1;
    }
    mPostedRunnables.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((!mCanSlide) && (i == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null) {
        mPreservedOpenState = (mDragHelper.isViewUnder(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) ^ true);
      }
    }
    if ((mCanSlide) && ((!mIsUnableToDrag) || (i == 0)))
    {
      if ((i != 3) && (i != 1))
      {
        float f2;
        float f1;
        if (i != 0)
        {
          if (i == 2)
          {
            f2 = paramMotionEvent.getX();
            f1 = paramMotionEvent.getY();
            f2 = Math.abs(f2 - mInitialMotionX);
            f1 = Math.abs(f1 - mInitialMotionY);
            if ((f2 > mDragHelper.getTouchSlop()) && (f1 > f2))
            {
              mDragHelper.cancel();
              mIsUnableToDrag = true;
              return false;
            }
          }
        }
        else
        {
          mIsUnableToDrag = false;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          mInitialMotionX = f1;
          mInitialMotionY = f2;
          if ((mDragHelper.isViewUnder(mSlideableView, (int)f1, (int)f2)) && (isDimmed(mSlideableView)))
          {
            i = 1;
            break label240;
          }
        }
        i = 0;
        label240:
        if (!mDragHelper.shouldInterceptTouchEvent(paramMotionEvent)) {
          return i != 0;
        }
      }
      else
      {
        mDragHelper.cancel();
        return false;
      }
    }
    else
    {
      mDragHelper.cancel();
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = isLayoutRtlSupport();
    if (bool) {
      mDragHelper.setEdgeTrackingEnabled(2);
    } else {
      mDragHelper.setEdgeTrackingEnabled(1);
    }
    int k = paramInt3 - paramInt1;
    if (bool) {
      paramInt1 = getPaddingRight();
    } else {
      paramInt1 = getPaddingLeft();
    }
    if (bool) {
      paramInt4 = getPaddingLeft();
    } else {
      paramInt4 = getPaddingRight();
    }
    int n = getPaddingTop();
    int m = getChildCount();
    if (mFirstLayout)
    {
      float f;
      if ((mCanSlide) && (mPreservedOpenState)) {
        f = 1.0F;
      } else {
        f = 0.0F;
      }
      mSlideOffset = f;
    }
    paramInt3 = paramInt1;
    int i = 0;
    paramInt2 = paramInt1;
    paramInt1 = paramInt3;
    while (i < m)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i1 = localView.getMeasuredWidth();
        int j;
        if (slideable)
        {
          paramInt3 = leftMargin;
          int i2 = rightMargin;
          j = k - paramInt4;
          i2 = Math.min(paramInt1, j - mOverhangSize) - paramInt2 - (paramInt3 + i2);
          mSlideRange = i2;
          if (bool) {
            paramInt3 = rightMargin;
          } else {
            paramInt3 = leftMargin;
          }
          if (i1 / 2 + (paramInt2 + paramInt3 + i2) > j) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          dimWhenOffset = paramBoolean;
          j = (int)(i2 * mSlideOffset);
          paramInt2 = paramInt3 + j + paramInt2;
          mSlideOffset = (j / mSlideRange);
          paramInt3 = 0;
        }
        else
        {
          if (mCanSlide)
          {
            paramInt2 = mParallaxBy;
            if (paramInt2 != 0)
            {
              paramInt3 = (int)((1.0F - mSlideOffset) * paramInt2);
              paramInt2 = paramInt1;
              break label362;
            }
          }
          paramInt2 = paramInt1;
          paramInt3 = 0;
        }
        label362:
        if (bool)
        {
          paramInt3 = k - paramInt2 + paramInt3;
          j = paramInt3 - i1;
        }
        else
        {
          j = paramInt2 - paramInt3;
          paramInt3 = j + i1;
        }
        localView.layout(j, n, paramInt3, localView.getMeasuredHeight() + n);
        paramInt1 = localView.getWidth() + paramInt1;
      }
      i += 1;
    }
    if (mFirstLayout)
    {
      if (mCanSlide)
      {
        if (mParallaxBy != 0) {
          parallaxOtherViews(mSlideOffset);
        }
        if (mSlideableView.getLayoutParams()).dimWhenOffset) {
          dimChildView(mSlideableView, mSlideOffset, mSliderFadeColor);
        }
      }
      else
      {
        paramInt1 = 0;
        while (paramInt1 < m)
        {
          dimChildView(getChildAt(paramInt1), 0.0F, mSliderFadeColor);
          paramInt1 += 1;
        }
      }
      updateObscuredViewsVisibility(mSlideableView);
    }
    mFirstLayout = false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = j;
    int m = View.MeasureSpec.getSize(paramInt2);
    int n;
    int k;
    if (i1 != 1073741824)
    {
      if (isInEditMode())
      {
        if (i1 == Integer.MIN_VALUE)
        {
          n = paramInt1;
          k = i;
          paramInt2 = m;
        }
        else
        {
          n = paramInt1;
          k = i;
          paramInt2 = m;
          if (i1 == 0)
          {
            k = 300;
            n = paramInt1;
            paramInt2 = m;
          }
        }
      }
      else {
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
      }
    }
    else
    {
      n = paramInt1;
      k = i;
      paramInt2 = m;
      if (j == 0) {
        if (isInEditMode())
        {
          n = paramInt1;
          k = i;
          paramInt2 = m;
          if (j == 0)
          {
            n = Integer.MIN_VALUE;
            paramInt2 = 300;
            k = i;
          }
        }
        else
        {
          throw new IllegalStateException("Height must not be UNSPECIFIED");
        }
      }
    }
    if (n != Integer.MIN_VALUE)
    {
      if (n != 1073741824)
      {
        paramInt1 = 0;
        paramInt2 = 0;
      }
      else
      {
        paramInt1 = paramInt2 - getPaddingTop() - getPaddingBottom();
        paramInt2 = paramInt1;
      }
    }
    else
    {
      paramInt2 = paramInt2 - getPaddingTop() - getPaddingBottom();
      paramInt1 = 0;
    }
    int i2 = k - getPaddingLeft() - getPaddingRight();
    int i3 = getChildCount();
    mSlideableView = null;
    m = i2;
    i1 = 0;
    boolean bool1 = false;
    float f2 = 0.0F;
    i = paramInt1;
    View localView;
    LayoutParams localLayoutParams;
    int i4;
    while (i1 < i3)
    {
      localView = getChildAt(i1);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (localView.getVisibility() == 8)
      {
        dimWhenOffset = false;
      }
      else
      {
        float f3 = weight;
        float f1 = f2;
        if (f3 > 0.0F)
        {
          f2 += f3;
          f1 = f2;
          if (width == 0) {}
        }
        else
        {
          paramInt1 = leftMargin + rightMargin;
          if (width == -2) {
            paramInt1 = View.MeasureSpec.makeMeasureSpec(i2 - paramInt1, Integer.MIN_VALUE);
          } else if (width == -1) {
            paramInt1 = View.MeasureSpec.makeMeasureSpec(i2 - paramInt1, 1073741824);
          } else {
            paramInt1 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
          }
          if (height == -2) {
            j = View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE);
          } else if (height == -1) {
            j = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
          } else {
            j = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
          }
          localView.measure(paramInt1, j);
          j = localView.getMeasuredWidth();
          i4 = localView.getMeasuredHeight();
          paramInt1 = i;
          if (n == Integer.MIN_VALUE)
          {
            paramInt1 = i;
            if (i4 > i) {
              paramInt1 = Math.min(i4, paramInt2);
            }
          }
          j = m - j;
          boolean bool2;
          if (j < 0) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          slideable = bool2;
          bool2 |= bool1;
          bool1 = bool2;
          i = paramInt1;
          m = j;
          f2 = f1;
          if (slideable)
          {
            mSlideableView = localView;
            f2 = f1;
            m = j;
            i = paramInt1;
            bool1 = bool2;
          }
        }
      }
      i1 += 1;
    }
    if ((bool1) || (f2 > 0.0F))
    {
      i1 = i2 - mOverhangSize;
      j = 0;
      while (j < i3)
      {
        localView = getChildAt(j);
        if (localView.getVisibility() != 8)
        {
          for (;;)
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if (localView.getVisibility() != 8)
            {
              if ((width == 0) && (weight > 0.0F)) {
                paramInt1 = 1;
              } else {
                paramInt1 = 0;
              }
              if (paramInt1 != 0) {
                n = 0;
              } else {
                n = localView.getMeasuredWidth();
              }
              if ((bool1) && (localView != mSlideableView))
              {
                if ((width < 0) && ((n > i1) || (weight > 0.0F)))
                {
                  if (paramInt1 != 0)
                  {
                    if (height == -2) {
                      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE);
                    } else if (height == -1) {
                      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
                    } else {
                      paramInt1 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
                    }
                  }
                  else {
                    paramInt1 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                  }
                  localView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), paramInt1);
                }
              }
              else if (weight > 0.0F)
              {
                if (width == 0)
                {
                  if (height == -2) {
                    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE);
                  } else if (height == -1) {
                    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
                  } else {
                    paramInt1 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
                  }
                }
                else {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                }
                if (!bool1) {
                  break;
                }
                i4 = i2 - (leftMargin + rightMargin);
                int i5 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                if (n != i4) {
                  localView.measure(i5, paramInt1);
                }
              }
            }
          }
          i4 = Math.max(0, m);
          localView.measure(View.MeasureSpec.makeMeasureSpec(n + (int)(weight * i4 / f2), 1073741824), paramInt1);
        }
        j += 1;
      }
    }
    paramInt1 = getPaddingTop();
    setMeasuredDimension(k, getPaddingBottom() + (paramInt1 + i));
    mCanSlide = bool1;
    if ((mDragHelper.getViewDragState() != 0) && (!bool1)) {
      mDragHelper.abort();
    }
  }
  
  public void onPanelDragged(int paramInt)
  {
    if (mSlideableView == null)
    {
      mSlideOffset = 0.0F;
      return;
    }
    boolean bool = isLayoutRtlSupport();
    LayoutParams localLayoutParams = (LayoutParams)mSlideableView.getLayoutParams();
    int j = mSlideableView.getWidth();
    int i = paramInt;
    if (bool) {
      i = getWidth() - paramInt - j;
    }
    if (bool) {
      paramInt = getPaddingRight();
    } else {
      paramInt = getPaddingLeft();
    }
    if (bool) {
      j = rightMargin;
    } else {
      j = leftMargin;
    }
    mSlideOffset = ((i - (paramInt + j)) / mSlideRange);
    if (mParallaxBy != 0) {
      parallaxOtherViews(mSlideOffset);
    }
    if (dimWhenOffset) {
      dimChildView(mSlideableView, mSlideOffset, mSliderFadeColor);
    }
    dispatchOnPanelSlide(mSlideableView);
  }
  
  public void onRestoreInstanceState()
  {
    closePane();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (isOpen) {
      openPane();
    } else {
      closePane();
    }
    mPreservedOpenState = isOpen;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    boolean bool;
    if (isSlideable()) {
      bool = isOpen();
    } else {
      bool = mPreservedOpenState;
    }
    isOpen = bool;
    return localSavedState;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      mFirstLayout = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!mCanSlide) {
      return super.onTouchEvent(paramMotionEvent);
    }
    mDragHelper.processTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    float f1;
    float f2;
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      if (isDimmed(mSlideableView))
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        float f3 = f1 - mInitialMotionX;
        float f4 = f2 - mInitialMotionY;
        i = mDragHelper.getTouchSlop();
        if ((f4 * f4 + f3 * f3 < i * i) && (mDragHelper.isViewUnder(mSlideableView, (int)f1, (int)f2)))
        {
          closePane(mSlideableView, 0);
          return true;
        }
      }
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      mInitialMotionX = f1;
      mInitialMotionY = f2;
    }
    return true;
  }
  
  public boolean openPane()
  {
    return openPane(mSlideableView, 0);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!mCanSlide))
    {
      boolean bool;
      if (paramView1 == mSlideableView) {
        bool = true;
      } else {
        bool = false;
      }
      mPreservedOpenState = bool;
    }
  }
  
  public void setAllChildrenVisible()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i += 1;
    }
  }
  
  public void setCoveredFadeColor(int paramInt)
  {
    mCoveredFadeColor = paramInt;
  }
  
  public void setPanelSlideListener(d paramD)
  {
    mPanelSlideListener = paramD;
  }
  
  public void setParallaxDistance(int paramInt)
  {
    mParallaxBy = paramInt;
    requestLayout();
  }
  
  public void setShadowDrawable(Drawable paramDrawable)
  {
    setShadowDrawableLeft(paramDrawable);
  }
  
  public void setShadowDrawableLeft(Drawable paramDrawable)
  {
    mShadowDrawableLeft = paramDrawable;
  }
  
  public void setShadowDrawableRight(Drawable paramDrawable)
  {
    mShadowDrawableRight = paramDrawable;
  }
  
  public void setShadowResource(int paramInt)
  {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setShadowResourceLeft(int paramInt)
  {
    setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setShadowResourceRight(int paramInt)
  {
    setShadowDrawableRight(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setSliderFadeColor(int paramInt)
  {
    mSliderFadeColor = paramInt;
  }
  
  public void smoothSlideOpen()
  {
    openPane();
  }
  
  public boolean smoothSlideTo(float paramFloat, int paramInt)
  {
    if (!mCanSlide) {
      return false;
    }
    boolean bool = isLayoutRtlSupport();
    Object localObject = (LayoutParams)mSlideableView.getLayoutParams();
    float f1;
    if (bool)
    {
      paramInt = getPaddingRight();
      int i = rightMargin;
      int j = mSlideableView.getWidth();
      f1 = getWidth();
      float f2 = paramInt + i;
      paramInt = (int)(f1 - (paramFloat * mSlideRange + f2 + j));
    }
    else
    {
      f1 = getPaddingLeft() + leftMargin;
      paramInt = (int)(paramFloat * mSlideRange + f1);
    }
    localObject = mDragHelper;
    View localView = mSlideableView;
    if (((ViewDragHelper)localObject).smoothSlideViewTo(localView, paramInt, localView.getTop()))
    {
      setAllChildrenVisible();
      ViewCompat.postInvalidateOnAnimation(this);
      return true;
    }
    return false;
  }
  
  public void updateObscuredViewsVisibility(View paramView)
  {
    boolean bool = isLayoutRtlSupport();
    int i;
    if (bool) {
      i = getWidth() - getPaddingRight();
    } else {
      i = getPaddingLeft();
    }
    int j;
    if (bool) {
      j = getPaddingLeft();
    } else {
      j = getWidth() - getPaddingRight();
    }
    int i4 = getPaddingTop();
    int i5 = getHeight();
    int i6 = getPaddingBottom();
    int k;
    int m;
    int n;
    int i1;
    if ((paramView != null) && (viewIsOpaque(paramView)))
    {
      k = paramView.getLeft();
      m = paramView.getRight();
      n = paramView.getTop();
      i1 = paramView.getBottom();
    }
    else
    {
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
    }
    int i7 = getChildCount();
    int i2 = 0;
    while (i2 < i7)
    {
      View localView = getChildAt(i2);
      if (localView == paramView) {
        return;
      }
      if (localView.getVisibility() != 8)
      {
        if (bool) {
          i3 = j;
        } else {
          i3 = i;
        }
        int i8 = Math.max(i3, localView.getLeft());
        int i9 = Math.max(i4, localView.getTop());
        if (bool) {
          i3 = i;
        } else {
          i3 = j;
        }
        int i3 = Math.min(i3, localView.getRight());
        int i10 = Math.min(i5 - i6, localView.getBottom());
        if ((i8 >= k) && (i9 >= n) && (i3 <= m) && (i10 <= i1)) {
          i3 = 4;
        } else {
          i3 = 0;
        }
        localView.setVisibility(i3);
      }
      i2 += 1;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public static final int[] ATTRS = { 16843137 };
    public Paint dimPaint;
    public boolean dimWhenOffset;
    public boolean slideable;
    public float weight = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
      weight = paramContext.getFloat(0, 0.0F);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      weight = weight;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new DiscreteSeekBar.CustomState.1();
    public boolean isOpen;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      isOpen = bool;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
  }
  
  public class a
    extends AccessibilityDelegateCompat
  {
    public final Rect mTmpRect = new Rect();
    
    public a() {}
    
    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat2)
    {
      Rect localRect = mTmpRect;
      paramAccessibilityNodeInfoCompat2.getBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat2.getBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setVisibleToUser(paramAccessibilityNodeInfoCompat2.isVisibleToUser());
      paramAccessibilityNodeInfoCompat1.setPackageName(paramAccessibilityNodeInfoCompat2.getPackageName());
      paramAccessibilityNodeInfoCompat1.setClassName(paramAccessibilityNodeInfoCompat2.getClassName());
      paramAccessibilityNodeInfoCompat1.setContentDescription(paramAccessibilityNodeInfoCompat2.getContentDescription());
      paramAccessibilityNodeInfoCompat1.setEnabled(paramAccessibilityNodeInfoCompat2.isEnabled());
      paramAccessibilityNodeInfoCompat1.setClickable(paramAccessibilityNodeInfoCompat2.isClickable());
      paramAccessibilityNodeInfoCompat1.setFocusable(paramAccessibilityNodeInfoCompat2.isFocusable());
      paramAccessibilityNodeInfoCompat1.setFocused(paramAccessibilityNodeInfoCompat2.isFocused());
      paramAccessibilityNodeInfoCompat1.setAccessibilityFocused(paramAccessibilityNodeInfoCompat2.isAccessibilityFocused());
      paramAccessibilityNodeInfoCompat1.setSelected(paramAccessibilityNodeInfoCompat2.isSelected());
      paramAccessibilityNodeInfoCompat1.setLongClickable(paramAccessibilityNodeInfoCompat2.isLongClickable());
      paramAccessibilityNodeInfoCompat1.addAction(paramAccessibilityNodeInfoCompat2.getActions());
      paramAccessibilityNodeInfoCompat1.setMovementGranularities(paramAccessibilityNodeInfoCompat2.getMovementGranularities());
    }
    
    public boolean filter(View paramView)
    {
      return isDimmed(paramView);
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AccessibilityDelegateCompat.DEFAULT_DELEGATE.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
      super.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
      copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, localAccessibilityNodeInfoCompat);
      localAccessibilityNodeInfoCompat.setClassName();
      paramAccessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
      paramAccessibilityNodeInfoCompat.setSource(paramView);
      paramView = ViewCompat.getParentForAccessibility(paramView);
      if ((paramView instanceof View)) {
        paramAccessibilityNodeInfoCompat.setParent((View)paramView);
      }
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        paramView = getChildAt(i);
        if ((!filter(paramView)) && (paramView.getVisibility() == 0))
        {
          ViewCompat.setImportantForAccessibility(paramView, 1);
          paramAccessibilityNodeInfoCompat.addChild(paramView);
        }
        i += 1;
      }
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (!filter(paramView)) {
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
  }
  
  private class b
    implements Runnable
  {
    public final View val$view;
    
    public b(View paramView)
    {
      val$view = paramView;
    }
    
    public void run()
    {
      if (val$view.getParent() == SlidingPaneLayout.this)
      {
        val$view.setLayerType(0, null);
        invalidateChildRegion(val$view);
      }
      mPostedRunnables.remove(this);
    }
  }
  
  private class c
    extends ViewDragHelper.Callback
  {
    public c() {}
    
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      paramView = (SlidingPaneLayout.LayoutParams)mSlideableView.getLayoutParams();
      if (isLayoutRtlSupport())
      {
        paramInt2 = getWidth();
        i = getPaddingRight();
        int j = rightMargin;
        paramInt2 -= mSlideableView.getWidth() + (i + j);
        i = mSlideRange;
        return Math.max(Math.min(paramInt1, paramInt2), paramInt2 - i);
      }
      paramInt2 = getPaddingLeft() + leftMargin;
      int i = mSlideRange;
      return Math.min(Math.max(paramInt1, paramInt2), i + paramInt2);
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      return mSlideRange;
    }
    
    public void onEdgeDragStarted(int paramInt1, int paramInt2)
    {
      SlidingPaneLayout localSlidingPaneLayout = SlidingPaneLayout.this;
      mDragHelper.captureChildView(mSlideableView, paramInt2);
    }
    
    public void onViewCaptured(View paramView, int paramInt)
    {
      setAllChildrenVisible();
    }
    
    public void onViewDragStateChanged(int paramInt)
    {
      if (mDragHelper.getViewDragState() == 0)
      {
        SlidingPaneLayout localSlidingPaneLayout = SlidingPaneLayout.this;
        if (mSlideOffset == 0.0F)
        {
          localSlidingPaneLayout.updateObscuredViewsVisibility(mSlideableView);
          localSlidingPaneLayout = SlidingPaneLayout.this;
          localSlidingPaneLayout.dispatchOnPanelClosed(mSlideableView);
          mPreservedOpenState = false;
          return;
        }
        localSlidingPaneLayout.dispatchOnPanelOpened(mSlideableView);
        mPreservedOpenState = true;
      }
    }
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      onPanelDragged(paramInt1);
      invalidate();
    }
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
      int j;
      int i;
      if (isLayoutRtlSupport())
      {
        j = getPaddingRight() + rightMargin;
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (mSlideOffset <= 0.5F) {}
          }
        }
        else
        {
          i = j + mSlideRange;
        }
        j = mSlideableView.getWidth();
        i = getWidth() - i - j;
      }
      else
      {
        i = getPaddingLeft();
        j = leftMargin + i;
        if (paramFloat1 <= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (mSlideOffset <= 0.5F) {}
          }
        }
        else
        {
          i = j + mSlideRange;
        }
      }
      mDragHelper.settleCapturedViewAt(i, paramView.getTop());
      invalidate();
    }
    
    public boolean tryCaptureView(View paramView, int paramInt)
    {
      if (mIsUnableToDrag) {
        return false;
      }
      return getLayoutParamsslideable;
    }
  }
  
  public static abstract interface d
  {
    public abstract void onPanelClosed(View paramView);
    
    public abstract void onPanelOpened(View paramView);
    
    public abstract void onPanelSlide(View paramView, float paramFloat);
  }
  
  public static class e
    implements SlidingPaneLayout.d
  {
    public e() {}
    
    public void onPanelClosed(View paramView) {}
    
    public void onPanelOpened(View paramView) {}
    
    public void onPanelSlide(View paramView, float paramFloat) {}
  }
}
