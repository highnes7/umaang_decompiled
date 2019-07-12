package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import b.b.a.W;
import support.android.v4.content.ContextCompat;
import support.android.v4.view.NestedScrollingChild;
import support.android.v4.view.NestedScrollingChildHelper;
import support.android.v4.view.NestedScrollingParent;
import support.android.v4.view.NestedScrollingParentHelper;
import support.android.v4.view.ViewCompat;
import support.android.v4.widget.CircleImageView;
import support.android.v4.widget.Fragment;
import support.android.v4.widget.MapController.MyZoomAnimationListener;
import support.android.v4.widget.MaterialProgressDrawable;
import support.android.v4.widget.SwipeRefreshLayout.2;
import support.android.v4.widget.SwipeRefreshLayout.3;
import support.android.v4.widget.SwipeRefreshLayout.5;
import support.android.v4.widget.SwipeRefreshLayout.6;
import support.android.v4.widget.SwipeRefreshLayout.7;
import support.android.v4.widget.SwipeRefreshLayout.8;
import support.android.v4.widget.SwitchCompat.ThumbAnimation;

public class SwipeRefreshLayout
  extends ViewGroup
  implements NestedScrollingParent, NestedScrollingChild
{
  public static final int ALPHA_ANIMATION_DURATION = 300;
  public static final int ANIMATE_TO_START_DURATION = 200;
  public static final int ANIMATE_TO_TRIGGER_DURATION = 200;
  public static final int CIRCLE_BG_LIGHT = -328966;
  @W
  public static final int CIRCLE_DIAMETER = 40;
  @W
  public static final int CIRCLE_DIAMETER_LARGE = 56;
  public static final float DECELERATE_INTERPOLATION_FACTOR = 2.0F;
  public static final int DEFAULT = 0;
  public static final int DEFAULT_CIRCLE_TARGET = 64;
  public static final float DRAG_RATE = 0.5F;
  public static final int GENERATOR_TERMINATE = -1;
  public static final int INVALID_POINTER = -1;
  public static final int[] LAYOUT_ATTRS = { 16842766 };
  public static final String LOG_TAG = "SwipeRefreshLayout";
  public static final int MAX_ALPHA = 255;
  public static final float MAX_PROGRESS_ANGLE = 0.8F;
  public static final int SCALE_DOWN_DURATION = 150;
  public static final int STARTING_PROGRESS_ALPHA = 76;
  public static final int WEEKS_BUFFER = 1;
  public int mActivePointerId = -1;
  public Animation mAlphaMaxAnimation;
  public Animation mAlphaStartAnimation;
  public final Animation mAnimateToCorrectPosition = new SwipeRefreshLayout.7(this);
  public final Animation mAnimateToStartPosition = new SwipeRefreshLayout.6(this);
  public CircleImageView mCircleView;
  public int mCircleViewIndex = -1;
  public int mCircleWidth;
  public int mCurrentTargetOffsetTop;
  public final DecelerateInterpolator mDecelerateInterpolator;
  public int mDownX;
  public int mFrom;
  public float mInitialMotionY;
  public boolean mIsBeingDragged;
  public float mLastMotionY;
  public b mListener;
  public int mMediumAnimationDuration;
  public boolean mNestedScrollInProgress;
  public final NestedScrollingChildHelper mNestedScrollingChildHelper;
  public final NestedScrollingParentHelper mNestedScrollingParentHelper;
  public boolean mNotify;
  public int mOriginalOffsetTop;
  public final int[] mParentOffsetInWindow = new int[2];
  public final int[] mParentScrollConsumed = new int[2];
  public a mPrevY;
  public MaterialProgressDrawable mProgress;
  public Animation.AnimationListener mRefreshListener = new MapController.MyZoomAnimationListener(this);
  public boolean mRefreshing = false;
  public boolean mReturningToStart;
  public boolean mScale;
  public Animation mScaleAnimation;
  public Animation mScaleDownAnimation;
  public Animation mScaleDownToStartAnimation;
  public int mSpinnerFinalOffset;
  public float mStartingScale;
  public View mTarget;
  public float mTotalDragDistance = -1.0F;
  public float mTotalUnconsumed;
  public int mTouchSlop;
  public boolean mUsingCustomStart;
  
  public SwipeRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    mMediumAnimationDuration = getResources().getInteger(17694721);
    setWillNotDraw(false);
    mDecelerateInterpolator = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    mCircleWidth = ((int)(density * 40.0F));
    createProgressView();
    setChildrenDrawingOrderEnabled(true);
    mSpinnerFinalOffset = ((int)(density * 64.0F));
    mTotalDragDistance = mSpinnerFinalOffset;
    mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
    setNestedScrollingEnabled(true);
    int i = -mCircleWidth;
    mCurrentTargetOffsetTop = i;
    mOriginalOffsetTop = i;
    reset(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, LAYOUT_ATTRS);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void animateOffsetToCorrectPosition(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    mFrom = paramInt;
    mAnimateToCorrectPosition.reset();
    mAnimateToCorrectPosition.setDuration(200L);
    mAnimateToCorrectPosition.setInterpolator(mDecelerateInterpolator);
    if (paramAnimationListener != null) {
      mCircleView.setAnimationListener(paramAnimationListener);
    }
    mCircleView.clearAnimation();
    mCircleView.startAnimation(mAnimateToCorrectPosition);
  }
  
  private void animateOffsetToStartPosition(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    if (mScale)
    {
      startScaleDownReturnToStartAnimation(paramInt, paramAnimationListener);
      return;
    }
    mFrom = paramInt;
    mAnimateToStartPosition.reset();
    mAnimateToStartPosition.setDuration(200L);
    mAnimateToStartPosition.setInterpolator(mDecelerateInterpolator);
    if (paramAnimationListener != null) {
      mCircleView.setAnimationListener(paramAnimationListener);
    }
    mCircleView.clearAnimation();
    mCircleView.startAnimation(mAnimateToStartPosition);
  }
  
  private void createProgressView()
  {
    mCircleView = new CircleImageView(getContext(), -328966);
    mProgress = new MaterialProgressDrawable(getContext());
    mProgress.updateSizes(1);
    mCircleView.setImageDrawable(mProgress);
    mCircleView.setVisibility(8);
    addView(mCircleView);
  }
  
  private void ensureTarget()
  {
    if (mTarget == null)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!localView.equals(mCircleView))
        {
          mTarget = localView;
          return;
        }
        i += 1;
      }
    }
  }
  
  private void finishSpinner(float paramFloat)
  {
    if (paramFloat > mTotalDragDistance)
    {
      setRefreshing(true, true);
      return;
    }
    mRefreshing = false;
    mProgress.setStartEndTrim(0.0F, 0.0F);
    SwipeRefreshLayout.5 local5 = null;
    if (!mScale) {
      local5 = new SwipeRefreshLayout.5(this);
    }
    animateOffsetToStartPosition(mCurrentTargetOffsetTop, local5);
    mProgress.showArrow(false);
  }
  
  private boolean isAnimationRunning(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void moveSpinner(float paramFloat)
  {
    mProgress.showArrow(true);
    float f1 = Math.min(1.0F, Math.abs(paramFloat / mTotalDragDistance));
    double d1 = f1;
    Double.isNaN(d1);
    float f2 = (float)Math.max(d1 - 0.4D, 0.0D) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = mTotalDragDistance;
    int i = mDownX;
    if (i > 0) {}
    float f3;
    for (;;)
    {
      f3 = i;
      break;
      if (mUsingCustomStart) {
        i = mSpinnerFinalOffset - mOriginalOffsetTop;
      } else {
        i = mSpinnerFinalOffset;
      }
    }
    d1 = Math.max(0.0F, Math.min(f4 - f5, f3 * 2.0F) / f3) / 4.0F;
    double d2 = Math.pow(d1, 2.0D);
    Double.isNaN(d1);
    f4 = (float)(d1 - d2) * 2.0F;
    i = mOriginalOffsetTop;
    int j = (int)(f3 * f1 + f3 * f4 * 2.0F);
    if (mCircleView.getVisibility() != 0) {
      mCircleView.setVisibility(0);
    }
    if (!mScale)
    {
      mCircleView.setScaleX(1.0F);
      mCircleView.setScaleY(1.0F);
    }
    if (mScale) {
      setAnimationProgress(Math.min(1.0F, paramFloat / mTotalDragDistance));
    }
    if (paramFloat < mTotalDragDistance)
    {
      if ((mProgress.getAlpha() > 76) && (!isAnimationRunning(mAlphaStartAnimation))) {
        startProgressAlphaStartAnimation();
      }
    }
    else if ((mProgress.getAlpha() < 255) && (!isAnimationRunning(mAlphaMaxAnimation))) {
      startProgressAlphaMaxAnimation();
    }
    mProgress.setStartEndTrim(0.0F, Math.min(0.8F, f2 * 0.8F));
    mProgress.setArrowScale(Math.min(1.0F, f2));
    mProgress.setProgressRotation((f4 * 2.0F + (f2 * 0.4F - 0.25F)) * 0.5F);
    setTargetOffsetTopAndBottom(i + j - mCurrentTargetOffsetTop);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == mActivePointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      mActivePointerId = paramMotionEvent.getPointerId(i);
    }
  }
  
  private void onTouchEvent(float paramFloat)
  {
    float f = mInitialMotionY;
    int i = mTouchSlop;
    if ((paramFloat - f > i) && (!mIsBeingDragged))
    {
      mLastMotionY = (f + i);
      mIsBeingDragged = true;
      mProgress.setAlpha(76);
    }
  }
  
  private void setColorViewAlpha(int paramInt)
  {
    mCircleView.getBackground().setAlpha(paramInt);
    mProgress.setAlpha(paramInt);
  }
  
  private void setRefreshing(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mRefreshing != paramBoolean1)
    {
      mNotify = paramBoolean2;
      ensureTarget();
      mRefreshing = paramBoolean1;
      if (mRefreshing)
      {
        animateOffsetToCorrectPosition(mCurrentTargetOffsetTop, mRefreshListener);
        return;
      }
      startScaleDownAnimation(mRefreshListener);
    }
  }
  
  private Animation startAlphaAnimation(int paramInt1, int paramInt2)
  {
    SwitchCompat.ThumbAnimation localThumbAnimation = new SwitchCompat.ThumbAnimation(this, paramInt1, paramInt2);
    localThumbAnimation.setDuration(300L);
    mCircleView.setAnimationListener(null);
    mCircleView.clearAnimation();
    mCircleView.startAnimation(localThumbAnimation);
    return localThumbAnimation;
  }
  
  private void startProgressAlphaMaxAnimation()
  {
    mAlphaMaxAnimation = startAlphaAnimation(mProgress.getAlpha(), 255);
  }
  
  private void startProgressAlphaStartAnimation()
  {
    mAlphaStartAnimation = startAlphaAnimation(mProgress.getAlpha(), 76);
  }
  
  private void startScaleDownReturnToStartAnimation(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    mFrom = paramInt;
    mStartingScale = mCircleView.getScaleX();
    mScaleDownToStartAnimation = new SwipeRefreshLayout.8(this);
    mScaleDownToStartAnimation.setDuration(150L);
    if (paramAnimationListener != null) {
      mCircleView.setAnimationListener(paramAnimationListener);
    }
    mCircleView.clearAnimation();
    mCircleView.startAnimation(mScaleDownToStartAnimation);
  }
  
  private void startScaleUpAnimation(Animation.AnimationListener paramAnimationListener)
  {
    mCircleView.setVisibility(0);
    mProgress.setAlpha(255);
    mScaleAnimation = new SwipeRefreshLayout.2(this);
    mScaleAnimation.setDuration(mMediumAnimationDuration);
    if (paramAnimationListener != null) {
      mCircleView.setAnimationListener(paramAnimationListener);
    }
    mCircleView.clearAnimation();
    mCircleView.startAnimation(mScaleAnimation);
  }
  
  public boolean canChildScrollUp()
  {
    Object localObject = mPrevY;
    if (localObject != null) {
      return ((a)localObject).canScrollVertically(this, mTarget);
    }
    localObject = mTarget;
    if ((localObject instanceof ListView)) {
      return Fragment.update((ListView)localObject, -1);
    }
    return ((View)localObject).canScrollVertically(-1);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return mNestedScrollingChildHelper.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return mNestedScrollingChildHelper.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return mNestedScrollingChildHelper.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return mNestedScrollingChildHelper.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = mCircleViewIndex;
    if (i < 0) {
      return paramInt2;
    }
    if (paramInt2 == paramInt1 - 1) {
      return i;
    }
    if (paramInt2 >= i) {
      return paramInt2 + 1;
    }
    return paramInt2;
  }
  
  public int getNestedScrollAxes()
  {
    return mNestedScrollingParentHelper.getNestedScrollAxes();
  }
  
  public int getProgressCircleDiameter()
  {
    return mCircleWidth;
  }
  
  public int getProgressViewEndOffset()
  {
    return mSpinnerFinalOffset;
  }
  
  public int getProgressViewStartOffset()
  {
    return mOriginalOffsetTop;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return mNestedScrollingChildHelper.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return mNestedScrollingChildHelper.isNestedScrollingEnabled();
  }
  
  public boolean isRefreshing()
  {
    return mRefreshing;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    reset();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ensureTarget();
    int i = paramMotionEvent.getActionMasked();
    if ((mReturningToStart) && (i == 0)) {
      mReturningToStart = false;
    }
    if ((isEnabled()) && (!mReturningToStart) && (!canChildScrollUp()) && (!mRefreshing))
    {
      if (mNestedScrollInProgress) {
        return false;
      }
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 6) {
                break label205;
              }
              onSecondaryPointerUp(paramMotionEvent);
              break label205;
            }
          }
          else
          {
            i = mActivePointerId;
            if (i == -1)
            {
              paramMotionEvent = LOG_TAG;
              return false;
            }
            i = paramMotionEvent.findPointerIndex(i);
            if (i < 0) {
              return false;
            }
            onTouchEvent(paramMotionEvent.getY(i));
            break label205;
          }
        }
        mIsBeingDragged = false;
        mActivePointerId = -1;
      }
      else
      {
        setTargetOffsetTopAndBottom(mOriginalOffsetTop - mCircleView.getTop());
        mActivePointerId = paramMotionEvent.getPointerId(0);
        mIsBeingDragged = false;
        i = paramMotionEvent.findPointerIndex(mActivePointerId);
        if (i < 0) {
          return false;
        }
        mInitialMotionY = paramMotionEvent.getY(i);
      }
      label205:
      return mIsBeingDragged;
    }
    return false;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() == 0) {
      return;
    }
    if (mTarget == null) {
      ensureTarget();
    }
    Object localObject = mTarget;
    if (localObject == null) {
      return;
    }
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    ((View)localObject).layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt3 = mCircleView.getMeasuredWidth();
    paramInt2 = mCircleView.getMeasuredHeight();
    localObject = mCircleView;
    paramInt1 /= 2;
    paramInt3 /= 2;
    paramInt4 = mCurrentTargetOffsetTop;
    ((View)localObject).layout(paramInt1 - paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (mTarget == null) {
      ensureTarget();
    }
    View localView = mTarget;
    if (localView == null) {
      return;
    }
    localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
    mCircleView.measure(View.MeasureSpec.makeMeasureSpec(mCircleWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(mCircleWidth, 1073741824));
    mCircleViewIndex = -1;
    paramInt1 = 0;
    while (paramInt1 < getChildCount())
    {
      if (getChildAt(paramInt1) == mCircleView)
      {
        mCircleViewIndex = paramInt1;
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (paramInt2 > 0)
    {
      float f1 = mTotalUnconsumed;
      if (f1 > 0.0F)
      {
        float f2 = paramInt2;
        if (f2 > f1)
        {
          paramArrayOfInt[1] = (paramInt2 - (int)f1);
          mTotalUnconsumed = 0.0F;
        }
        else
        {
          mTotalUnconsumed = (f1 - f2);
          paramArrayOfInt[1] = paramInt2;
        }
        moveSpinner(mTotalUnconsumed);
      }
    }
    if ((mUsingCustomStart) && (paramInt2 > 0) && (mTotalUnconsumed == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
      mCircleView.setVisibility(8);
    }
    paramView = mParentScrollConsumed;
    if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
    {
      paramArrayOfInt[0] += paramView[0];
      paramArrayOfInt[1] += paramView[1];
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, mParentOffsetInWindow);
    paramInt1 = paramInt4 + mParentOffsetInWindow[1];
    if ((paramInt1 < 0) && (!canChildScrollUp()))
    {
      mTotalUnconsumed += Math.abs(paramInt1);
      moveSpinner(mTotalUnconsumed);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    mNestedScrollingParentHelper.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    startNestedScroll(paramInt & 0x2);
    mTotalUnconsumed = 0.0F;
    mNestedScrollInProgress = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!mReturningToStart) && (!mRefreshing) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    mNestedScrollingParentHelper.onStopNestedScroll(paramView);
    mNestedScrollInProgress = false;
    float f = mTotalUnconsumed;
    if (f > 0.0F)
    {
      finishSpinner(f);
      mTotalUnconsumed = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((mReturningToStart) && (i == 0)) {
      mReturningToStart = false;
    }
    if ((isEnabled()) && (!mReturningToStart) && (!canChildScrollUp()) && (!mRefreshing))
    {
      if (mNestedScrollInProgress) {
        return false;
      }
      if (i != 0)
      {
        float f1;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 5)
              {
                if (i != 6) {
                  return true;
                }
                onSecondaryPointerUp(paramMotionEvent);
                return true;
              }
              i = paramMotionEvent.getActionIndex();
              if (i < 0)
              {
                paramMotionEvent = LOG_TAG;
                return false;
              }
              mActivePointerId = paramMotionEvent.getPointerId(i);
              return true;
            }
            return false;
          }
          i = paramMotionEvent.findPointerIndex(mActivePointerId);
          if (i < 0)
          {
            paramMotionEvent = LOG_TAG;
            return false;
          }
          f1 = paramMotionEvent.getY(i);
          onTouchEvent(f1);
          if (mIsBeingDragged)
          {
            f1 = (f1 - mLastMotionY) * 0.5F;
            if (f1 > 0.0F)
            {
              moveSpinner(f1);
              return true;
            }
            return false;
          }
        }
        else
        {
          i = paramMotionEvent.findPointerIndex(mActivePointerId);
          if (i < 0)
          {
            paramMotionEvent = LOG_TAG;
            return false;
          }
          if (mIsBeingDragged)
          {
            f1 = paramMotionEvent.getY(i);
            float f2 = mLastMotionY;
            mIsBeingDragged = false;
            finishSpinner((f1 - f2) * 0.5F);
          }
          mActivePointerId = -1;
          return false;
        }
      }
      else
      {
        mActivePointerId = paramMotionEvent.getPointerId(0);
        mIsBeingDragged = false;
        return true;
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 21) || (!(mTarget instanceof AbsListView)))
    {
      View localView = mTarget;
      if ((localView != null) && (!ViewCompat.isNestedScrollingEnabled(localView))) {
        return;
      }
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public void reset()
  {
    mCircleView.clearAnimation();
    mProgress.stop();
    mCircleView.setVisibility(8);
    setColorViewAlpha(255);
    if (mScale) {
      setAnimationProgress(0.0F);
    } else {
      setTargetOffsetTopAndBottom(mOriginalOffsetTop - mCurrentTargetOffsetTop);
    }
    mCurrentTargetOffsetTop = mCircleView.getTop();
  }
  
  public void reset(float paramFloat)
  {
    int i = mFrom;
    setTargetOffsetTopAndBottom(i + (int)((mOriginalOffsetTop - i) * paramFloat) - mCircleView.getTop());
  }
  
  public void setAnimationProgress(float paramFloat)
  {
    mCircleView.setScaleX(paramFloat);
    mCircleView.setScaleY(paramFloat);
  }
  
  public void setColorScheme(int... paramVarArgs)
  {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    ensureTarget();
    mProgress.setColorSchemeColors(paramVarArgs);
  }
  
  public void setColorSchemeResources(int... paramVarArgs)
  {
    Context localContext = getContext();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfInt[i] = ContextCompat.getColor(localContext, paramVarArgs[i]);
      i += 1;
    }
    setColorSchemeColors(arrayOfInt);
  }
  
  public void setDistanceToTriggerSync(int paramInt)
  {
    mTotalDragDistance = paramInt;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (!paramBoolean) {
      reset();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    mNestedScrollingChildHelper.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnChildScrollUpCallback(a paramA)
  {
    mPrevY = paramA;
  }
  
  public void setOnRefreshListener(b paramB)
  {
    mListener = paramB;
  }
  
  public void setProgressBackgroundColor(int paramInt)
  {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    mCircleView.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt)
  {
    setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  public void setProgressViewEndTarget(boolean paramBoolean, int paramInt)
  {
    mSpinnerFinalOffset = paramInt;
    mScale = paramBoolean;
    mCircleView.invalidate();
  }
  
  public void setProgressViewOffset(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    mScale = paramBoolean;
    mOriginalOffsetTop = paramInt1;
    mSpinnerFinalOffset = paramInt2;
    mUsingCustomStart = true;
    reset();
    mRefreshing = false;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (mRefreshing != paramBoolean))
    {
      mRefreshing = paramBoolean;
      int i;
      if (!mUsingCustomStart) {
        i = mSpinnerFinalOffset + mOriginalOffsetTop;
      } else {
        i = mSpinnerFinalOffset;
      }
      setTargetOffsetTopAndBottom(i - mCurrentTargetOffsetTop);
      mNotify = false;
      startScaleUpAnimation(mRefreshListener);
      return;
    }
    setRefreshing(paramBoolean, false);
  }
  
  public void setSize(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if (paramInt == 0) {
      mCircleWidth = ((int)(density * 56.0F));
    } else {
      mCircleWidth = ((int)(density * 40.0F));
    }
    mCircleView.setImageDrawable(null);
    mProgress.updateSizes(paramInt);
    mCircleView.setImageDrawable(mProgress);
  }
  
  public void setSlingshotDistance(int paramInt)
  {
    mDownX = paramInt;
  }
  
  public void setTargetOffsetTopAndBottom(int paramInt)
  {
    mCircleView.bringToFront();
    ViewCompat.offsetTopAndBottom(mCircleView, paramInt);
    mCurrentTargetOffsetTop = mCircleView.getTop();
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return mNestedScrollingChildHelper.startNestedScroll(paramInt);
  }
  
  public void startScaleDownAnimation(Animation.AnimationListener paramAnimationListener)
  {
    mScaleDownAnimation = new SwipeRefreshLayout.3(this);
    mScaleDownAnimation.setDuration(150L);
    mCircleView.setAnimationListener(paramAnimationListener);
    mCircleView.clearAnimation();
    mCircleView.startAnimation(mScaleDownAnimation);
  }
  
  public void stopNestedScroll()
  {
    mNestedScrollingChildHelper.stopNestedScroll();
  }
  
  public static abstract interface a
  {
    public abstract boolean canScrollVertically(SwipeRefreshLayout paramSwipeRefreshLayout, View paramView);
  }
  
  public static abstract interface b
  {
    public abstract void onAnimationFinished();
  }
}
