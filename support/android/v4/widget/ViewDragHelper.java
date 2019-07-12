package support.android.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import support.android.v4.view.ViewCompat;

public class ViewDragHelper
{
  public static final int BASE_SETTLE_DURATION = 256;
  public static final int DIRECTION_ALL = 3;
  public static final int DIRECTION_HORIZONTAL = 1;
  public static final int DIRECTION_VERTICAL = 2;
  public static final int EDGE_ALL = 15;
  public static final int EDGE_BOTTOM = 8;
  public static final int EDGE_LEFT = 0;
  public static final int EDGE_RIGHT = 1;
  public static final int EDGE_SIZE = 20;
  public static final int EDGE_TOP = 4;
  public static final int INVALID_POINTER = -1;
  public static final int MAX_SETTLE_DURATION = 600;
  public static final int STATE_DRAGGING = 2;
  public static final int STATE_IDLE = 1;
  public static final int STATE_SETTLING = 2;
  public static final String TAG = "ViewDragHelper";
  public static final Interpolator sInterpolator = new BakedBezierInterpolator();
  public int mActivePointerId = -1;
  public final Callback mCallback;
  public View mCapturedView;
  public int mDragState;
  public int[] mEdgeDragsInProgress;
  public int[] mEdgeDragsLocked;
  public int mEdgeSize;
  public int[] mInitialEdgesTouched;
  public float[] mInitialMotionX;
  public float[] mInitialMotionY;
  public float[] mLastMotionX;
  public float[] mLastMotionY;
  public float mMaxVelocity;
  public float mMinVelocity;
  public final ViewGroup mParentView;
  public int mPointersDown;
  public boolean mReleaseInProgress;
  public OverScroller mScroller;
  public final Runnable mSetIdleRunnable = new DayFragment.1(this);
  public int mTouchSlop;
  public int mTrackingEdges;
  public VelocityTracker mVelocityTracker;
  
  public ViewDragHelper(Context paramContext, ViewGroup paramViewGroup, Callback paramCallback)
  {
    if (paramViewGroup != null)
    {
      if (paramCallback != null)
      {
        mParentView = paramViewGroup;
        mCallback = paramCallback;
        paramViewGroup = ViewConfiguration.get(paramContext);
        mEdgeSize = ((int)(getResourcesgetDisplayMetricsdensity * 20.0F + 0.5F));
        mTouchSlop = paramViewGroup.getScaledTouchSlop();
        mMaxVelocity = paramViewGroup.getScaledMaximumFlingVelocity();
        mMinVelocity = paramViewGroup.getScaledMinimumFlingVelocity();
        mScroller = new OverScroller(paramContext, sInterpolator);
        return;
      }
      throw new IllegalArgumentException("Callback may not be null");
    }
    throw new IllegalArgumentException("Parent view may not be null");
  }
  
  private boolean checkNewEdgeDrag(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((mInitialEdgesTouched[paramInt1] & paramInt2) == paramInt2) && ((mTrackingEdges & paramInt2) != 0) && ((mEdgeDragsLocked[paramInt1] & paramInt2) != paramInt2) && ((mEdgeDragsInProgress[paramInt1] & paramInt2) != paramInt2))
    {
      int i = mTouchSlop;
      if ((paramFloat1 <= i) && (paramFloat2 <= i)) {
        return false;
      }
      if ((paramFloat1 < paramFloat2 * 0.5F) && (mCallback.onEdgeLock(paramInt2)))
      {
        int[] arrayOfInt = mEdgeDragsLocked;
        arrayOfInt[paramInt1] |= paramInt2;
        return false;
      }
      if (((mEdgeDragsInProgress[paramInt1] & paramInt2) == 0) && (paramFloat1 > mTouchSlop)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean checkTouchSlop(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {
      return false;
    }
    int i;
    if (mCallback.getViewHorizontalDragRange(paramView) > 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (mCallback.getViewVerticalDragRange(paramView) > 0) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) && (j != 0))
    {
      i = mTouchSlop;
      if (paramFloat2 * paramFloat2 + paramFloat1 * paramFloat1 > i * i) {
        return true;
      }
    }
    else if (i != 0)
    {
      if (Math.abs(paramFloat1) > mTouchSlop) {
        return true;
      }
    }
    else if ((j != 0) && (Math.abs(paramFloat2) > mTouchSlop))
    {
      return true;
    }
    return false;
  }
  
  private float clampMag(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2) {
      return 0.0F;
    }
    paramFloat2 = paramFloat1;
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F) {
        return paramFloat3;
      }
      paramFloat2 = -paramFloat3;
    }
    return paramFloat2;
  }
  
  private int clampMag(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (i < paramInt2) {
      return 0;
    }
    paramInt2 = paramInt1;
    if (i > paramInt3)
    {
      if (paramInt1 > 0) {
        return paramInt3;
      }
      paramInt2 = -paramInt3;
    }
    return paramInt2;
  }
  
  private void clearMotionHistory()
  {
    float[] arrayOfFloat = mInitialMotionX;
    if (arrayOfFloat == null) {
      return;
    }
    Arrays.fill(arrayOfFloat, 0.0F);
    Arrays.fill(mInitialMotionY, 0.0F);
    Arrays.fill(mLastMotionX, 0.0F);
    Arrays.fill(mLastMotionY, 0.0F);
    Arrays.fill(mInitialEdgesTouched, 0);
    Arrays.fill(mEdgeDragsInProgress, 0);
    Arrays.fill(mEdgeDragsLocked, 0);
    mPointersDown = 0;
  }
  
  private void clearMotionHistory(int paramInt)
  {
    if (mInitialMotionX != null)
    {
      if (!isPointerDown(paramInt)) {
        return;
      }
      mInitialMotionX[paramInt] = 0.0F;
      mInitialMotionY[paramInt] = 0.0F;
      mLastMotionX[paramInt] = 0.0F;
      mLastMotionY[paramInt] = 0.0F;
      mInitialEdgesTouched[paramInt] = 0;
      mEdgeDragsInProgress[paramInt] = 0;
      mEdgeDragsLocked[paramInt] = 0;
      mPointersDown = (1 << paramInt & mPointersDown);
    }
  }
  
  private int computeAxisDuration(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = mParentView.getWidth();
    int j = i / 2;
    float f2 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    f2 = distanceInfluenceForSnapDuration(f2);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {
      paramInt1 = Math.round(Math.abs((f2 * f1 + f1) / paramInt2) * 1000.0F) * 4;
    } else {
      paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F);
    }
    return Math.min(paramInt1, 600);
  }
  
  private int computeSettleDuration(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = clampMag(paramInt3, (int)mMinVelocity, (int)mMaxVelocity);
    paramInt4 = clampMag(paramInt4, (int)mMinVelocity, (int)mMaxVelocity);
    int i = Math.abs(paramInt1);
    int j = Math.abs(paramInt2);
    int k = Math.abs(paramInt3);
    int m = Math.abs(paramInt4);
    int n = k + m;
    int i1 = i + j;
    float f1;
    if (paramInt3 != 0)
    {
      f1 = k;
      f2 = n;
    }
    else
    {
      f1 = i;
      f2 = i1;
    }
    float f3 = f1 / f2;
    if (paramInt4 != 0)
    {
      f1 = m;
      f2 = n;
    }
    else
    {
      f1 = j;
      f2 = i1;
    }
    f1 /= f2;
    paramInt1 = computeAxisDuration(paramInt1, paramInt3, mCallback.getViewHorizontalDragRange(paramView));
    paramInt2 = computeAxisDuration(paramInt2, paramInt4, mCallback.getViewVerticalDragRange(paramView));
    float f2 = paramInt1;
    return (int)(paramInt2 * f1 + f2 * f3);
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, float paramFloat, Callback paramCallback)
  {
    paramViewGroup = create(paramViewGroup, paramCallback);
    float f = mTouchSlop;
    mTouchSlop = ((int)(1.0F / paramFloat * f));
    return paramViewGroup;
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, Callback paramCallback)
  {
    return new ViewDragHelper(paramViewGroup.getContext(), paramViewGroup, paramCallback);
  }
  
  private void dispatchViewReleased(float paramFloat1, float paramFloat2)
  {
    mReleaseInProgress = true;
    mCallback.onViewReleased(mCapturedView, paramFloat1, paramFloat2);
    mReleaseInProgress = false;
    if (mDragState == 1) {
      setDragState(0);
    }
  }
  
  private float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.47123894F);
  }
  
  private void dragTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = mCapturedView.getLeft();
    int k = mCapturedView.getTop();
    int i = paramInt1;
    if (paramInt3 != 0)
    {
      paramInt1 = mCallback.clampViewPositionHorizontal(mCapturedView, paramInt1, paramInt3);
      i = paramInt1;
      ViewCompat.offsetLeftAndRight(mCapturedView, paramInt1 - j);
    }
    paramInt1 = paramInt2;
    if (paramInt4 != 0)
    {
      paramInt2 = mCallback.clampViewPositionVertical(mCapturedView, paramInt2, paramInt4);
      paramInt1 = paramInt2;
      ViewCompat.offsetTopAndBottom(mCapturedView, paramInt2 - k);
    }
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      mCallback.onViewPositionChanged(mCapturedView, i, paramInt1, i - j, paramInt1 - k);
    }
  }
  
  private void ensureMotionHistorySizeForId(int paramInt)
  {
    float[] arrayOfFloat1 = mInitialMotionX;
    if ((arrayOfFloat1 == null) || (arrayOfFloat1.length <= paramInt))
    {
      paramInt += 1;
      arrayOfFloat1 = new float[paramInt];
      float[] arrayOfFloat2 = new float[paramInt];
      float[] arrayOfFloat3 = new float[paramInt];
      float[] arrayOfFloat4 = new float[paramInt];
      int[] arrayOfInt1 = new int[paramInt];
      int[] arrayOfInt2 = new int[paramInt];
      int[] arrayOfInt3 = new int[paramInt];
      Object localObject = mInitialMotionX;
      if (localObject != null)
      {
        System.arraycopy(localObject, 0, arrayOfFloat1, 0, localObject.length);
        localObject = mInitialMotionY;
        System.arraycopy(localObject, 0, arrayOfFloat2, 0, localObject.length);
        localObject = mLastMotionX;
        System.arraycopy(localObject, 0, arrayOfFloat3, 0, localObject.length);
        localObject = mLastMotionY;
        System.arraycopy(localObject, 0, arrayOfFloat4, 0, localObject.length);
        localObject = mInitialEdgesTouched;
        System.arraycopy(localObject, 0, arrayOfInt1, 0, localObject.length);
        localObject = mEdgeDragsInProgress;
        System.arraycopy(localObject, 0, arrayOfInt2, 0, localObject.length);
        localObject = mEdgeDragsLocked;
        System.arraycopy(localObject, 0, arrayOfInt3, 0, localObject.length);
      }
      mInitialMotionX = arrayOfFloat1;
      mInitialMotionY = arrayOfFloat2;
      mLastMotionX = arrayOfFloat3;
      mLastMotionY = arrayOfFloat4;
      mInitialEdgesTouched = arrayOfInt1;
      mEdgeDragsInProgress = arrayOfInt2;
      mEdgeDragsLocked = arrayOfInt3;
    }
  }
  
  private boolean forceSettleCapturedViewAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = mCapturedView.getLeft();
    int j = mCapturedView.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      mScroller.abortAnimation();
      setDragState(0);
      return false;
    }
    paramInt3 = computeSettleDuration(mCapturedView, paramInt1, paramInt2, paramInt3, paramInt4);
    mScroller.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    setDragState(2);
    return true;
  }
  
  private int getEdgesTouched(int paramInt1, int paramInt2)
  {
    if (paramInt1 < mParentView.getLeft() + mEdgeSize) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (paramInt2 < mParentView.getTop() + mEdgeSize) {
      i = j | 0x4;
    }
    int j = i;
    if (paramInt1 > mParentView.getRight() - mEdgeSize) {
      j = i | 0x2;
    }
    paramInt1 = j;
    if (paramInt2 > mParentView.getBottom() - mEdgeSize) {
      paramInt1 = j | 0x8;
    }
    return paramInt1;
  }
  
  private boolean isValidPointerForActionMove(int paramInt)
  {
    if (!isPointerDown(paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Ignoring pointerId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" because ACTION_DOWN was not received ");
      localStringBuilder.append("for this pointer before ACTION_MOVE. It likely happened because ");
      localStringBuilder.append(" ViewDragHelper did not receive all the events in the event stream.");
      localStringBuilder.toString();
      return false;
    }
    return true;
  }
  
  private void releaseViewForPointerUp()
  {
    mVelocityTracker.computeCurrentVelocity(1000, mMaxVelocity);
    dispatchViewReleased(clampMag(mVelocityTracker.getXVelocity(mActivePointerId), mMinVelocity, mMaxVelocity), clampMag(mVelocityTracker.getYVelocity(mActivePointerId), mMinVelocity, mMaxVelocity));
  }
  
  private void reportNewEdgeDrags(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    if (!checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 1)) {
      j = 0;
    }
    int i = j;
    if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 4)) {
      i = j | 0x4;
    }
    j = i;
    if (checkNewEdgeDrag(paramFloat1, paramFloat2, paramInt, 2)) {
      j = i | 0x2;
    }
    i = j;
    if (checkNewEdgeDrag(paramFloat2, paramFloat1, paramInt, 8)) {
      i = j | 0x8;
    }
    if (i != 0)
    {
      int[] arrayOfInt = mEdgeDragsInProgress;
      arrayOfInt[paramInt] |= i;
      mCallback.onEdgeDragStarted(i, paramInt);
    }
  }
  
  private void saveInitialMotion(float paramFloat1, float paramFloat2, int paramInt)
  {
    ensureMotionHistorySizeForId(paramInt);
    float[] arrayOfFloat = mInitialMotionX;
    mLastMotionX[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = mInitialMotionY;
    mLastMotionY[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    mInitialEdgesTouched[paramInt] = getEdgesTouched((int)paramFloat1, (int)paramFloat2);
    mPointersDown |= 1 << paramInt;
  }
  
  private void saveLastMotion(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      if (isValidPointerForActionMove(k))
      {
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        mLastMotionX[k] = f1;
        mLastMotionY[k] = f2;
      }
      i += 1;
    }
  }
  
  public void abort()
  {
    cancel();
    if (mDragState == 2)
    {
      int i = mScroller.getCurrX();
      int j = mScroller.getCurrY();
      mScroller.abortAnimation();
      int k = mScroller.getCurrX();
      int m = mScroller.getCurrY();
      mCallback.onViewPositionChanged(mCapturedView, k, m, k - i, m - j);
    }
    setDragState(0);
  }
  
  public boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
        int m = paramInt3 + j;
        if ((m >= localView.getLeft()) && (m < localView.getRight()))
        {
          int n = paramInt4 + k;
          if ((n >= localView.getTop()) && (n < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2, m - localView.getLeft(), n - localView.getTop()))) {
            return true;
          }
        }
        i -= 1;
      }
    }
    if (paramBoolean)
    {
      if (paramView.canScrollHorizontally(-paramInt1)) {
        break label169;
      }
      if (paramView.canScrollVertically(-paramInt2)) {
        return true;
      }
    }
    return false;
    label169:
    return true;
  }
  
  public void cancel()
  {
    mActivePointerId = -1;
    clearMotionHistory();
    VelocityTracker localVelocityTracker = mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      mVelocityTracker = null;
    }
  }
  
  public void captureChildView(View paramView, int paramInt)
  {
    if (paramView.getParent() == mParentView)
    {
      mCapturedView = paramView;
      mActivePointerId = paramInt;
      mCallback.onViewCaptured(paramView, paramInt);
      setDragState(1);
      return;
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view ("), mParentView, ")"));
  }
  
  public boolean checkTouchSlop(int paramInt)
  {
    int j = mInitialMotionX.length;
    int i = 0;
    while (i < j)
    {
      if (checkTouchSlop(paramInt, i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean checkTouchSlop(int paramInt1, int paramInt2)
  {
    if (!isPointerDown(paramInt2)) {
      return false;
    }
    int i;
    if ((paramInt1 & 0x1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt1 & 0x2) == 2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    float f1 = mLastMotionX[paramInt2] - mInitialMotionX[paramInt2];
    float f2 = mLastMotionY[paramInt2] - mInitialMotionY[paramInt2];
    if ((i != 0) && (paramInt1 != 0))
    {
      paramInt1 = mTouchSlop;
      if (f2 * f2 + f1 * f1 > paramInt1 * paramInt1) {
        return true;
      }
    }
    else if (i != 0)
    {
      if (Math.abs(f1) > mTouchSlop) {
        return true;
      }
    }
    else if ((paramInt1 != 0) && (Math.abs(f2) > mTouchSlop))
    {
      return true;
    }
    return false;
  }
  
  public boolean continueSettling(boolean paramBoolean)
  {
    if (mDragState == 2)
    {
      boolean bool3 = mScroller.computeScrollOffset();
      boolean bool1 = bool3;
      int i = mScroller.getCurrX();
      int j = mScroller.getCurrY();
      int k = i - mCapturedView.getLeft();
      int m = j - mCapturedView.getTop();
      if (k != 0) {
        ViewCompat.offsetLeftAndRight(mCapturedView, k);
      }
      if (m != 0) {
        ViewCompat.offsetTopAndBottom(mCapturedView, m);
      }
      if ((k != 0) || (m != 0)) {
        mCallback.onViewPositionChanged(mCapturedView, i, j, k, m);
      }
      boolean bool2 = bool1;
      if (bool3)
      {
        bool2 = bool1;
        if (i == mScroller.getFinalX())
        {
          bool2 = bool1;
          if (j == mScroller.getFinalY())
          {
            mScroller.abortAnimation();
            bool2 = false;
          }
        }
      }
      if (!bool2) {
        if (paramBoolean) {
          mParentView.post(mSetIdleRunnable);
        } else {
          setDragState(0);
        }
      }
    }
    return mDragState == 2;
  }
  
  public View findTopChildUnder(int paramInt1, int paramInt2)
  {
    int i = mParentView.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = mParentView.getChildAt(mCallback.getOrderedChildIndex(i));
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public void flingCapturedView(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (mReleaseInProgress)
    {
      mScroller.fling(mCapturedView.getLeft(), mCapturedView.getTop(), (int)mVelocityTracker.getXVelocity(mActivePointerId), (int)mVelocityTracker.getYVelocity(mActivePointerId), paramInt1, paramInt3, paramInt2, paramInt4);
      setDragState(2);
      return;
    }
    throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
  }
  
  public int getActivePointerId()
  {
    return mActivePointerId;
  }
  
  public View getCapturedView()
  {
    return mCapturedView;
  }
  
  public int getEdgeSize()
  {
    return mEdgeSize;
  }
  
  public float getMinVelocity()
  {
    return mMinVelocity;
  }
  
  public int getTouchSlop()
  {
    return mTouchSlop;
  }
  
  public int getViewDragState()
  {
    return mDragState;
  }
  
  public boolean isCapturedViewUnder(int paramInt1, int paramInt2)
  {
    return isViewUnder(mCapturedView, paramInt1, paramInt2);
  }
  
  public boolean isEdgeTouched(int paramInt)
  {
    int j = mInitialEdgesTouched.length;
    int i = 0;
    while (i < j)
    {
      if (isEdgeTouched(paramInt, i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isEdgeTouched(int paramInt1, int paramInt2)
  {
    return (isPointerDown(paramInt2)) && ((paramInt1 & mInitialEdgesTouched[paramInt2]) != 0);
  }
  
  public boolean isPointerDown(int paramInt)
  {
    return (1 << paramInt & mPointersDown) != 0;
  }
  
  public boolean isViewUnder(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return false;
    }
    return (paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()) && (paramInt2 >= paramView.getTop()) && (paramInt2 < paramView.getBottom());
  }
  
  public void processTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getActionMasked();
    int k = paramMotionEvent.getActionIndex();
    if (m == 0) {
      cancel();
    }
    if (mVelocityTracker == null) {
      mVelocityTracker = VelocityTracker.obtain();
    }
    mVelocityTracker.addMovement(paramMotionEvent);
    int j = 0;
    int i = 0;
    float f1;
    float f2;
    if (m != 0)
    {
      if (m != 1)
      {
        Object localObject;
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 5)
            {
              if (m != 6) {
                return;
              }
              j = paramMotionEvent.getPointerId(k);
              if ((mDragState == 1) && (j == mActivePointerId))
              {
                k = paramMotionEvent.getPointerCount();
                while (i < k)
                {
                  m = paramMotionEvent.getPointerId(i);
                  if (m != mActivePointerId)
                  {
                    f1 = paramMotionEvent.getX(i);
                    f2 = paramMotionEvent.getY(i);
                    localObject = findTopChildUnder((int)f1, (int)f2);
                    View localView = mCapturedView;
                    if ((localObject == localView) && (tryCaptureViewForDrag(localView, m)))
                    {
                      i = mActivePointerId;
                      break label213;
                    }
                  }
                  i += 1;
                }
                i = -1;
                label213:
                if (i == -1) {
                  releaseViewForPointerUp();
                }
              }
              clearMotionHistory(j);
              return;
            }
            i = paramMotionEvent.getPointerId(k);
            f1 = paramMotionEvent.getX(k);
            f2 = paramMotionEvent.getY(k);
            saveInitialMotion(f1, f2, i);
            if (mDragState == 0)
            {
              tryCaptureViewForDrag(findTopChildUnder((int)f1, (int)f2), i);
              j = mInitialEdgesTouched[i];
              k = mTrackingEdges;
              if ((j & k) != 0) {
                mCallback.onEdgeTouched(j & k, i);
              }
            }
            else if (isCapturedViewUnder((int)f1, (int)f2))
            {
              tryCaptureViewForDrag(mCapturedView, i);
            }
          }
          else
          {
            if (mDragState == 1) {
              dispatchViewReleased(0.0F, 0.0F);
            }
            cancel();
          }
        }
        else
        {
          if (mDragState == 1)
          {
            if (!isValidPointerForActionMove(mActivePointerId)) {
              return;
            }
            i = paramMotionEvent.findPointerIndex(mActivePointerId);
            f1 = paramMotionEvent.getX(i);
            f2 = paramMotionEvent.getY(i);
            localObject = mLastMotionX;
            j = mActivePointerId;
            i = (int)(f1 - localObject[j]);
            j = (int)(f2 - mLastMotionY[j]);
            dragTo(mCapturedView.getLeft() + i, mCapturedView.getTop() + j, i, j);
            saveLastMotion(paramMotionEvent);
            return;
          }
          k = paramMotionEvent.getPointerCount();
          i = j;
          while (i < k)
          {
            j = paramMotionEvent.getPointerId(i);
            if (isValidPointerForActionMove(j))
            {
              f1 = paramMotionEvent.getX(i);
              f2 = paramMotionEvent.getY(i);
              float f3 = f1 - mInitialMotionX[j];
              float f4 = f2 - mInitialMotionY[j];
              reportNewEdgeDrags(f3, f4, j);
              if (mDragState == 1) {
                break;
              }
              localObject = findTopChildUnder((int)f1, (int)f2);
              if ((checkTouchSlop((View)localObject, f3, f4)) && (tryCaptureViewForDrag((View)localObject, j))) {
                break;
              }
            }
            i += 1;
          }
          saveLastMotion(paramMotionEvent);
        }
      }
      else
      {
        if (mDragState == 1) {
          releaseViewForPointerUp();
        }
        cancel();
      }
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      paramMotionEvent = findTopChildUnder((int)f1, (int)f2);
      saveInitialMotion(f1, f2, i);
      tryCaptureViewForDrag(paramMotionEvent, i);
      j = mInitialEdgesTouched[i];
      k = mTrackingEdges;
      if ((j & k) != 0) {
        mCallback.onEdgeTouched(j & k, i);
      }
    }
  }
  
  public void setDragState(int paramInt)
  {
    mParentView.removeCallbacks(mSetIdleRunnable);
    if (mDragState != paramInt)
    {
      mDragState = paramInt;
      mCallback.onViewDragStateChanged(paramInt);
      if (mDragState == 0) {
        mCapturedView = null;
      }
    }
  }
  
  public void setEdgeTrackingEnabled(int paramInt)
  {
    mTrackingEdges = paramInt;
  }
  
  public void setMinVelocity(float paramFloat)
  {
    mMinVelocity = paramFloat;
  }
  
  public boolean settleCapturedViewAt(int paramInt1, int paramInt2)
  {
    if (mReleaseInProgress) {
      return forceSettleCapturedViewAt(paramInt1, paramInt2, (int)mVelocityTracker.getXVelocity(mActivePointerId), (int)mVelocityTracker.getYVelocity(mActivePointerId));
    }
    throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
  }
  
  public boolean shouldInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (i == 0) {
      cancel();
    }
    if (mVelocityTracker == null) {
      mVelocityTracker = VelocityTracker.obtain();
    }
    mVelocityTracker.addMovement(paramMotionEvent);
    float f1;
    float f2;
    int k;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i == 3) {
            break label517;
          }
          if (i != 5) {
            if (i != 6) {
              break label619;
            }
          }
        }
      }
      for (;;)
      {
        clearMotionHistory(paramMotionEvent.getPointerId(j));
        continue;
        i = paramMotionEvent.getPointerId(j);
        f1 = paramMotionEvent.getX(j);
        f2 = paramMotionEvent.getY(j);
        saveInitialMotion(f1, f2, i);
        j = mDragState;
        if (j == 0)
        {
          j = mInitialEdgesTouched[i];
          k = mTrackingEdges;
          if ((j & k) != 0) {
            mCallback.onEdgeTouched(j & k, i);
          }
        }
        else if (j == 2)
        {
          paramMotionEvent = findTopChildUnder((int)f1, (int)f2);
          if (paramMotionEvent == mCapturedView)
          {
            tryCaptureViewForDrag(paramMotionEvent, i);
            continue;
            if ((mInitialMotionX != null) && (mInitialMotionY != null))
            {
              k = paramMotionEvent.getPointerCount();
              i = 0;
              while (i < k)
              {
                int m = paramMotionEvent.getPointerId(i);
                if (isValidPointerForActionMove(m))
                {
                  f1 = paramMotionEvent.getX(i);
                  f2 = paramMotionEvent.getY(i);
                  float f3 = f1 - mInitialMotionX[m];
                  float f4 = f2 - mInitialMotionY[m];
                  View localView = findTopChildUnder((int)f1, (int)f2);
                  if ((localView != null) && (checkTouchSlop(localView, f3, f4))) {
                    j = 1;
                  } else {
                    j = 0;
                  }
                  if (j != 0)
                  {
                    int n = localView.getLeft();
                    int i1 = (int)f3;
                    i1 = mCallback.clampViewPositionHorizontal(localView, n + i1, i1);
                    int i2 = localView.getTop();
                    int i3 = (int)f4;
                    i3 = mCallback.clampViewPositionVertical(localView, i2 + i3, i3);
                    int i4 = mCallback.getViewHorizontalDragRange(localView);
                    int i5 = mCallback.getViewVerticalDragRange(localView);
                    if (((i4 == 0) || ((i4 > 0) && (i1 == n))) && ((i5 == 0) || ((i5 > 0) && (i3 == i2)))) {
                      break;
                    }
                  }
                  else
                  {
                    reportNewEdgeDrags(f3, f4, m);
                    if ((mDragState == 1) || ((j != 0) && (tryCaptureViewForDrag(localView, m)))) {
                      break;
                    }
                  }
                }
                i += 1;
              }
              saveLastMotion(paramMotionEvent);
              continue;
              label517:
              cancel();
            }
          }
        }
      }
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      saveInitialMotion(f1, f2, i);
      paramMotionEvent = findTopChildUnder((int)f1, (int)f2);
      if ((paramMotionEvent == mCapturedView) && (mDragState == 2)) {
        tryCaptureViewForDrag(paramMotionEvent, i);
      }
      j = mInitialEdgesTouched[i];
      k = mTrackingEdges;
      if ((j & k) != 0) {
        mCallback.onEdgeTouched(j & k, i);
      }
    }
    label619:
    return mDragState == 1;
  }
  
  public boolean smoothSlideViewTo(View paramView, int paramInt1, int paramInt2)
  {
    mCapturedView = paramView;
    mActivePointerId = -1;
    boolean bool = forceSettleCapturedViewAt(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (mDragState == 0) && (mCapturedView != null)) {
      mCapturedView = null;
    }
    return bool;
  }
  
  public boolean tryCaptureViewForDrag(View paramView, int paramInt)
  {
    if ((paramView == mCapturedView) && (mActivePointerId == paramInt)) {
      return true;
    }
    if ((paramView != null) && (mCallback.tryCaptureView(paramView, paramInt)))
    {
      mActivePointerId = paramInt;
      captureChildView(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public abstract class Callback
  {
    public Callback() {}
    
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public int getOrderedChildIndex(int paramInt)
    {
      return paramInt;
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      return 0;
    }
    
    public int getViewVerticalDragRange(View paramView)
    {
      return 0;
    }
    
    public void onEdgeDragStarted(int paramInt1, int paramInt2) {}
    
    public boolean onEdgeLock(int paramInt)
    {
      return false;
    }
    
    public void onEdgeTouched(int paramInt1, int paramInt2) {}
    
    public void onViewCaptured(View paramView, int paramInt) {}
    
    public void onViewDragStateChanged(int paramInt) {}
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2) {}
    
    public abstract boolean tryCaptureView(View paramView, int paramInt);
  }
}
