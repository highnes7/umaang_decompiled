package android.support.v7.widget.helper;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.recyclerview.R.dimen;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import b.b.a.F;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.ArrayList;
import java.util.List;
import support.android.v4.view.GestureDetectorCompat;
import support.android.v4.view.ViewCompat;

public class ItemTouchHelper
  extends RecyclerView.ItemDecoration
  implements RecyclerView.OnChildAttachStateChangeListener
{
  public static final int ACTION_MODE_DRAG_MASK = 16711680;
  public static final int ACTION_MODE_IDLE_MASK = 255;
  public static final int ACTION_MODE_SWIPE_MASK = 65280;
  public static final int ACTION_STATE_DRAG = 2;
  public static final int ACTION_STATE_IDLE = 0;
  public static final int ACTION_STATE_SWIPE = 1;
  public static final int ACTIVE_POINTER_ID_NONE = -1;
  public static final int ANIMATION_TYPE_DRAG = 8;
  public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
  public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
  public static final boolean DEBUG = false;
  public static final int DIRECTION_FLAG_COUNT = 8;
  public static final int DOWN = 2;
  public static final int END = 32;
  public static final int LEFT = 4;
  public static final int PIXELS_PER_SECOND = 1000;
  public static final int RIGHT = 8;
  public static final int START = 16;
  public static final String TAG = "ItemTouchHelper";
  public static final int UP = 1;
  public int mActionState = 0;
  public int mActivePointerId = -1;
  @F
  public Callback mCallback;
  public RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
  public List<Integer> mDistances;
  public long mDragScrollStartTimeInMs;
  public float mDx;
  public float mDy;
  public GestureDetectorCompat mGestureDetector;
  public float mInitialTouchX;
  public float mInitialTouchY;
  public ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
  public float mMaxSwipeVelocity;
  public final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener()
  {
    public boolean onInterceptTouchEvent(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
    {
      mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
      int i = paramAnonymousMotionEvent.getActionMasked();
      Object localObject2;
      if (i == 0)
      {
        mActivePointerId = paramAnonymousMotionEvent.getPointerId(0);
        mInitialTouchX = paramAnonymousMotionEvent.getX();
        mInitialTouchY = paramAnonymousMotionEvent.getY();
        obtainVelocityTracker();
        localObject2 = ItemTouchHelper.this;
        localObject1 = this;
        paramAnonymousRecyclerView = (RecyclerView)localObject1;
        if (mSelected == null)
        {
          localObject2 = ((ItemTouchHelper)localObject2).findAnimation(paramAnonymousMotionEvent);
          paramAnonymousRecyclerView = (RecyclerView)localObject1;
          if (localObject2 != null)
          {
            paramAnonymousRecyclerView = this$0;
            mInitialTouchX -= mX;
            mInitialTouchY -= mY;
            paramAnonymousRecyclerView.endRecoverAnimation(mViewHolder, true);
            paramAnonymousRecyclerView = this$0;
            if (mPendingCleanup.remove(mViewHolder.itemView))
            {
              paramAnonymousRecyclerView = this$0;
              mCallback.clearView(mRecyclerView, mViewHolder);
            }
            paramAnonymousRecyclerView = this;
            this$0.select(mViewHolder, mActionState);
            localObject1 = this$0;
            ((ItemTouchHelper)localObject1).updateDxDy(paramAnonymousMotionEvent, mSelectedFlags, 0);
          }
        }
      }
      else if ((i != 3) && (i != 1))
      {
        paramAnonymousRecyclerView = ItemTouchHelper.this;
        localObject1 = this;
        int j = mActivePointerId;
        paramAnonymousRecyclerView = (RecyclerView)localObject1;
        if (j != -1)
        {
          j = paramAnonymousMotionEvent.findPointerIndex(j);
          paramAnonymousRecyclerView = (RecyclerView)localObject1;
          if (j >= 0)
          {
            localObject2 = this$0;
            paramAnonymousRecyclerView = (RecyclerView)localObject1;
            ((ItemTouchHelper)localObject2).checkSelectForSwipe(i, paramAnonymousMotionEvent, j);
          }
        }
      }
      else
      {
        localObject1 = ItemTouchHelper.this;
        paramAnonymousRecyclerView = this;
        mActivePointerId = -1;
        ((ItemTouchHelper)localObject1).select(null, 0);
      }
      Object localObject1 = this$0.mVelocityTracker;
      if (localObject1 != null) {
        ((VelocityTracker)localObject1).addMovement(paramAnonymousMotionEvent);
      }
      return this$0.mSelected != null;
    }
    
    public void onRequestDisallowInterceptTouchEvent(boolean paramAnonymousBoolean)
    {
      if (!paramAnonymousBoolean) {
        return;
      }
      select(null, 0);
    }
    
    public void onTouchEvent(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
    {
      mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
      paramAnonymousRecyclerView = mVelocityTracker;
      if (paramAnonymousRecyclerView != null) {
        paramAnonymousRecyclerView.addMovement(paramAnonymousMotionEvent);
      }
      if (mActivePointerId == -1) {
        return;
      }
      int j = paramAnonymousMotionEvent.getActionMasked();
      int k = paramAnonymousMotionEvent.findPointerIndex(mActivePointerId);
      if (k >= 0) {
        checkSelectForSwipe(j, paramAnonymousMotionEvent, k);
      }
      paramAnonymousRecyclerView = ItemTouchHelper.this;
      RecyclerView.ViewHolder localViewHolder = mSelected;
      if (localViewHolder == null) {
        return;
      }
      int i = 0;
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 6) {
              return;
            }
            j = paramAnonymousMotionEvent.getActionIndex();
            if (paramAnonymousMotionEvent.getPointerId(j) != mActivePointerId) {
              return;
            }
            if (j == 0) {
              i = 1;
            }
            mActivePointerId = paramAnonymousMotionEvent.getPointerId(i);
            paramAnonymousRecyclerView = ItemTouchHelper.this;
            paramAnonymousRecyclerView.updateDxDy(paramAnonymousMotionEvent, mSelectedFlags, j);
            return;
          }
          paramAnonymousRecyclerView = mVelocityTracker;
          if (paramAnonymousRecyclerView != null) {
            paramAnonymousRecyclerView.clear();
          }
        }
        else
        {
          if (k < 0) {
            return;
          }
          paramAnonymousRecyclerView.updateDxDy(paramAnonymousMotionEvent, mSelectedFlags, k);
          moveIfNecessary(localViewHolder);
          paramAnonymousRecyclerView = ItemTouchHelper.this;
          mRecyclerView.removeCallbacks(mScrollRunnable);
          mScrollRunnable.run();
          mRecyclerView.invalidate();
          return;
        }
      }
      select(null, 0);
      mActivePointerId = -1;
    }
  };
  public View mOverdrawChild = null;
  public int mOverdrawChildPosition = -1;
  public final List<View> mPendingCleanup = new ArrayList();
  public List<RecoverAnimation> mRecoverAnimations = new ArrayList();
  public RecyclerView mRecyclerView;
  public final Runnable mScrollRunnable = new Runnable()
  {
    public void run()
    {
      ItemTouchHelper localItemTouchHelper = ItemTouchHelper.this;
      if ((mSelected != null) && (localItemTouchHelper.scrollIfNecessary()))
      {
        localItemTouchHelper = ItemTouchHelper.this;
        RecyclerView.ViewHolder localViewHolder = mSelected;
        if (localViewHolder != null) {
          localItemTouchHelper.moveIfNecessary(localViewHolder);
        }
        localItemTouchHelper = ItemTouchHelper.this;
        mRecyclerView.removeCallbacks(mScrollRunnable);
        ViewCompat.postOnAnimation(mRecyclerView, this);
      }
    }
  };
  public RecyclerView.ViewHolder mSelected = null;
  public int mSelectedFlags;
  public float mSelectedStartX;
  public float mSelectedStartY;
  public int mSlop;
  public List<RecyclerView.ViewHolder> mSwapTargets;
  public float mSwipeEscapeVelocity;
  public final float[] mTmpPosition = new float[2];
  public Rect mTmpRect;
  public VelocityTracker mVelocityTracker;
  
  public ItemTouchHelper(Callback paramCallback)
  {
    mCallback = paramCallback;
  }
  
  private void addChildDrawingOrderCallback()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return;
    }
    if (mChildDrawingOrderCallback == null) {
      mChildDrawingOrderCallback = new RecyclerView.ChildDrawingOrderCallback()
      {
        public int onGetChildDrawingOrder(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          ItemTouchHelper localItemTouchHelper = ItemTouchHelper.this;
          View localView = mOverdrawChild;
          if (localView == null) {
            return paramAnonymousInt2;
          }
          int j = mOverdrawChildPosition;
          int i = j;
          if (j == -1)
          {
            j = mRecyclerView.indexOfChild(localView);
            i = j;
            mOverdrawChildPosition = j;
          }
          if (paramAnonymousInt2 == paramAnonymousInt1 - 1) {
            return i;
          }
          if (paramAnonymousInt2 < i) {
            return paramAnonymousInt2;
          }
          return paramAnonymousInt2 + 1;
        }
      };
    }
    mRecyclerView.setChildDrawingOrderCallback(mChildDrawingOrderCallback);
  }
  
  private int checkHorizontalSwipe(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt & 0xC) != 0)
    {
      float f1 = mDx;
      int j = 8;
      int i;
      if (f1 > 0.0F) {
        i = 8;
      } else {
        i = 4;
      }
      VelocityTracker localVelocityTracker = mVelocityTracker;
      if ((localVelocityTracker != null) && (mActivePointerId > -1))
      {
        localVelocityTracker.computeCurrentVelocity(1000, mCallback.getSwipeVelocityThreshold(mMaxSwipeVelocity));
        f2 = mVelocityTracker.getXVelocity(mActivePointerId);
        f1 = mVelocityTracker.getYVelocity(mActivePointerId);
        if (f2 <= 0.0F) {
          j = 4;
        }
        f2 = Math.abs(f2);
        if (((j & paramInt) != 0) && (i == j) && (f2 >= mCallback.getSwipeEscapeVelocity(mSwipeEscapeVelocity)) && (f2 > Math.abs(f1))) {
          return j;
        }
      }
      f1 = mRecyclerView.getWidth();
      float f2 = mCallback.getSwipeThreshold(paramViewHolder);
      if (((paramInt & i) != 0) && (Math.abs(mDx) > f2 * f1)) {
        return i;
      }
    }
    return 0;
  }
  
  private int checkVerticalSwipe(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt & 0x3) != 0)
    {
      float f1 = mDy;
      int j = 2;
      int i;
      if (f1 > 0.0F) {
        i = 2;
      } else {
        i = 1;
      }
      VelocityTracker localVelocityTracker = mVelocityTracker;
      if ((localVelocityTracker != null) && (mActivePointerId > -1))
      {
        localVelocityTracker.computeCurrentVelocity(1000, mCallback.getSwipeVelocityThreshold(mMaxSwipeVelocity));
        f1 = mVelocityTracker.getXVelocity(mActivePointerId);
        f2 = mVelocityTracker.getYVelocity(mActivePointerId);
        if (f2 <= 0.0F) {
          j = 1;
        }
        f2 = Math.abs(f2);
        if (((j & paramInt) != 0) && (j == i) && (f2 >= mCallback.getSwipeEscapeVelocity(mSwipeEscapeVelocity)) && (f2 > Math.abs(f1))) {
          return j;
        }
      }
      f1 = mRecyclerView.getHeight();
      float f2 = mCallback.getSwipeThreshold(paramViewHolder);
      if (((paramInt & i) != 0) && (Math.abs(mDy) > f2 * f1)) {
        return i;
      }
    }
    return 0;
  }
  
  private void destroyCallbacks()
  {
    mRecyclerView.removeItemDecoration(this);
    mRecyclerView.removeOnItemTouchListener(mOnItemTouchListener);
    mRecyclerView.removeOnChildAttachStateChangeListener(this);
    int i = mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)mRecoverAnimations.get(0);
      mCallback.clearView(mRecyclerView, mViewHolder);
      i -= 1;
    }
    mRecoverAnimations.clear();
    mOverdrawChild = null;
    mOverdrawChildPosition = -1;
    releaseVelocityTracker();
    stopGestureDetection();
  }
  
  private List findSwapTargets(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = mSwapTargets;
    if (localObject == null)
    {
      mSwapTargets = new ArrayList();
      mDistances = new ArrayList();
    }
    else
    {
      ((List)localObject).clear();
      mDistances.clear();
    }
    int j = mCallback.getBoundingBoxMargin();
    int m = Math.round(mSelectedStartX + mDx) - j;
    int n = Math.round(mSelectedStartY + mDy) - j;
    int i = itemView.getWidth();
    j *= 2;
    int i1 = i + m + j;
    int i2 = itemView.getHeight() + n + j;
    int i3 = (m + i1) / 2;
    int i4 = (n + i2) / 2;
    localObject = mRecyclerView.getLayoutManager();
    int i5 = ((RecyclerView.LayoutManager)localObject).getChildCount();
    i = 0;
    while (i < i5)
    {
      View localView = ((RecyclerView.LayoutManager)localObject).getChildAt(i);
      if ((localView != itemView) && (localView.getBottom() >= n) && (localView.getTop() <= i2) && (localView.getRight() >= m) && (localView.getLeft() <= i1))
      {
        RecyclerView.ViewHolder localViewHolder = mRecyclerView.getChildViewHolder(localView);
        if (mCallback.canDropOver(mRecyclerView, mSelected, localViewHolder))
        {
          j = localView.getLeft();
          j = Math.abs(i3 - (localView.getRight() + j) / 2);
          int k = localView.getTop();
          k = Math.abs(i4 - (localView.getBottom() + k) / 2);
          int i6 = k * k + j * j;
          int i7 = mSwapTargets.size();
          j = 0;
          k = 0;
          while ((j < i7) && (i6 > ((Integer)mDistances.get(j)).intValue()))
          {
            k += 1;
            j += 1;
          }
          mSwapTargets.add(k, localViewHolder);
          mDistances.add(k, Integer.valueOf(i6));
        }
      }
      i += 1;
    }
    return mSwapTargets;
  }
  
  private RecyclerView.ViewHolder findSwipedView(MotionEvent paramMotionEvent)
  {
    RecyclerView.LayoutManager localLayoutManager = mRecyclerView.getLayoutManager();
    int i = mActivePointerId;
    if (i == -1) {
      return null;
    }
    i = paramMotionEvent.findPointerIndex(i);
    float f3 = paramMotionEvent.getX(i);
    float f4 = mInitialTouchX;
    float f1 = paramMotionEvent.getY(i);
    float f2 = mInitialTouchY;
    f3 = Math.abs(f3 - f4);
    f1 = Math.abs(f1 - f2);
    i = mSlop;
    if ((f3 < i) && (f1 < i)) {
      return null;
    }
    if ((f3 > f1) && (localLayoutManager.canScrollHorizontally())) {
      return null;
    }
    if ((f1 > f3) && (localLayoutManager.canScrollVertically())) {
      return null;
    }
    paramMotionEvent = findChildView(paramMotionEvent);
    if (paramMotionEvent == null) {
      return null;
    }
    return mRecyclerView.getChildViewHolder(paramMotionEvent);
  }
  
  private void getSelectedDxDy(float[] paramArrayOfFloat)
  {
    if ((mSelectedFlags & 0xC) != 0) {
      paramArrayOfFloat[0] = (mSelectedStartX + mDx - mSelected.itemView.getLeft());
    } else {
      paramArrayOfFloat[0] = mSelected.itemView.getTranslationX();
    }
    if ((mSelectedFlags & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (mSelectedStartY + mDy - mSelected.itemView.getTop());
      return;
    }
    paramArrayOfFloat[1] = mSelected.itemView.getTranslationY();
  }
  
  public static boolean hitTest(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramFloat3 + paramView.getWidth()) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramFloat4 + paramView.getHeight());
  }
  
  private void releaseVelocityTracker()
  {
    VelocityTracker localVelocityTracker = mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      mVelocityTracker = null;
    }
  }
  
  private void setupCallbacks()
  {
    mSlop = ViewConfiguration.get(mRecyclerView.getContext()).getScaledTouchSlop();
    mRecyclerView.addItemDecoration(this);
    mRecyclerView.addOnItemTouchListener(mOnItemTouchListener);
    mRecyclerView.addOnChildAttachStateChangeListener(this);
    startGestureDetection();
  }
  
  private void startGestureDetection()
  {
    mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener();
    mGestureDetector = new GestureDetectorCompat(mRecyclerView.getContext(), mItemTouchHelperGestureListener);
  }
  
  private void stopGestureDetection()
  {
    ItemTouchHelperGestureListener localItemTouchHelperGestureListener = mItemTouchHelperGestureListener;
    if (localItemTouchHelperGestureListener != null)
    {
      localItemTouchHelperGestureListener.doNotReactToLongPress();
      mItemTouchHelperGestureListener = null;
    }
    if (mGestureDetector != null) {
      mGestureDetector = null;
    }
  }
  
  private int swipeIfNecessary(RecyclerView.ViewHolder paramViewHolder)
  {
    if (mActionState == 2) {
      return 0;
    }
    int j = mCallback.getMovementFlags(mRecyclerView, paramViewHolder);
    int i = (mCallback.convertToAbsoluteDirection(j, ViewCompat.getLayoutDirection(mRecyclerView)) & 0xFF00) >> 8;
    if (i == 0) {
      return 0;
    }
    j = (j & 0xFF00) >> 8;
    int k;
    if (Math.abs(mDx) > Math.abs(mDy))
    {
      k = checkHorizontalSwipe(paramViewHolder, i);
      if (k > 0)
      {
        if ((j & k) == 0) {
          return Callback.convertToRelativeDirection(k, ViewCompat.getLayoutDirection(mRecyclerView));
        }
        return k;
      }
      i = checkVerticalSwipe(paramViewHolder, i);
      if (i > 0) {
        return i;
      }
    }
    else
    {
      k = checkVerticalSwipe(paramViewHolder, i);
      if (k > 0) {
        return k;
      }
      i = checkHorizontalSwipe(paramViewHolder, i);
      if (i > 0)
      {
        if ((j & i) != 0) {
          return i;
        }
        return Callback.convertToRelativeDirection(i, ViewCompat.getLayoutDirection(mRecyclerView));
      }
    }
    return 0;
    return i;
  }
  
  public void attachToRecyclerView(RecyclerView paramRecyclerView)
  {
    RecyclerView localRecyclerView = mRecyclerView;
    if (localRecyclerView == paramRecyclerView) {
      return;
    }
    if (localRecyclerView != null) {
      destroyCallbacks();
    }
    mRecyclerView = paramRecyclerView;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getResources();
      mSwipeEscapeVelocity = paramRecyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
      mMaxSwipeVelocity = paramRecyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
      setupCallbacks();
    }
  }
  
  public void checkSelectForSwipe(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if ((mSelected == null) && (paramInt1 == 2) && (mActionState != 2))
    {
      if (!mCallback.isItemViewSwipeEnabled()) {
        return;
      }
      if (mRecyclerView.getScrollState() == 1) {
        return;
      }
      RecyclerView.ViewHolder localViewHolder = findSwipedView(paramMotionEvent);
      if (localViewHolder == null) {
        return;
      }
      paramInt1 = (mCallback.getAbsoluteMovementFlags(mRecyclerView, localViewHolder) & 0xFF00) >> 8;
      if (paramInt1 == 0) {
        return;
      }
      float f1 = paramMotionEvent.getX(paramInt2);
      float f2 = paramMotionEvent.getY(paramInt2);
      f1 -= mInitialTouchX;
      f2 -= mInitialTouchY;
      float f3 = Math.abs(f1);
      float f4 = Math.abs(f2);
      paramInt2 = mSlop;
      if ((f3 < paramInt2) && (f4 < paramInt2)) {
        return;
      }
      if (f3 > f4)
      {
        if ((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) {
          return;
        }
        if ((f1 <= 0.0F) || ((paramInt1 & 0x8) != 0)) {}
      }
      else
      {
        if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
          return;
        }
        if ((f2 > 0.0F) && ((paramInt1 & 0x2) == 0)) {
          return;
        }
      }
      mDy = 0.0F;
      mDx = 0.0F;
      mActivePointerId = paramMotionEvent.getPointerId(0);
      select(localViewHolder, 1);
    }
  }
  
  public void endRecoverAnimation(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    int i = mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)mRecoverAnimations.get(i);
      if (mViewHolder == paramViewHolder)
      {
        mOverridden |= paramBoolean;
        if (!mEnded) {
          localRecoverAnimation.cancel();
        }
        mRecoverAnimations.remove(i);
        return;
      }
      i -= 1;
    }
  }
  
  public RecoverAnimation findAnimation(MotionEvent paramMotionEvent)
  {
    if (mRecoverAnimations.isEmpty()) {
      return null;
    }
    paramMotionEvent = findChildView(paramMotionEvent);
    int i = mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)mRecoverAnimations.get(i);
      if (mViewHolder.itemView == paramMotionEvent) {
        return localRecoverAnimation;
      }
      i -= 1;
    }
    return null;
  }
  
  public View findChildView(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent = mSelected;
    if (paramMotionEvent != null)
    {
      paramMotionEvent = itemView;
      if (hitTest(paramMotionEvent, f1, f2, mSelectedStartX + mDx, mSelectedStartY + mDy)) {
        return paramMotionEvent;
      }
    }
    int i = mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (RecoverAnimation)mRecoverAnimations.get(i);
      View localView = mViewHolder.itemView;
      if (hitTest(localView, f1, f2, mX, mY)) {
        return localView;
      }
      i -= 1;
    }
    return mRecyclerView.findChildViewUnder(f1, f2);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.setEmpty();
  }
  
  public boolean hasRunningRecoverAnim()
  {
    int j = mRecoverAnimations.size();
    int i = 0;
    while (i < j)
    {
      if (!mRecoverAnimations.get(i)).mEnded) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void moveIfNecessary(RecyclerView.ViewHolder paramViewHolder)
  {
    if (mRecyclerView.isLayoutRequested()) {
      return;
    }
    if (mActionState != 2) {
      return;
    }
    float f = mCallback.getMoveThreshold(paramViewHolder);
    int i = (int)(mSelectedStartX + mDx);
    int j = (int)(mSelectedStartY + mDy);
    if ((Math.abs(j - itemView.getTop()) < itemView.getHeight() * f) && (Math.abs(i - itemView.getLeft()) < itemView.getWidth() * f)) {
      return;
    }
    Object localObject = findSwapTargets(paramViewHolder);
    if (((List)localObject).size() == 0) {
      return;
    }
    localObject = mCallback.chooseDropTarget(paramViewHolder, (List)localObject, i, j);
    if (localObject == null)
    {
      mSwapTargets.clear();
      mDistances.clear();
      return;
    }
    int k = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
    int m = paramViewHolder.getAdapterPosition();
    if (mCallback.onMove(mRecyclerView, paramViewHolder, (RecyclerView.ViewHolder)localObject)) {
      mCallback.onMoved(mRecyclerView, paramViewHolder, m, (RecyclerView.ViewHolder)localObject, k, i, j);
    }
  }
  
  public void obtainVelocityTracker()
  {
    VelocityTracker localVelocityTracker = mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.recycle();
    }
    mVelocityTracker = VelocityTracker.obtain();
  }
  
  public void onChildViewAttachedToWindow(View paramView) {}
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    removeChildDrawingOrderCallbackIfNecessary(paramView);
    paramView = mRecyclerView.getChildViewHolder(paramView);
    if (paramView == null) {
      return;
    }
    RecyclerView.ViewHolder localViewHolder = mSelected;
    if ((localViewHolder != null) && (paramView == localViewHolder))
    {
      select(null, 0);
      return;
    }
    endRecoverAnimation(paramView, false);
    if (mPendingCleanup.remove(itemView)) {
      mCallback.clearView(mRecyclerView, paramView);
    }
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    mOverdrawChildPosition = -1;
    float f1;
    float f2;
    if (mSelected != null)
    {
      getSelectedDxDy(mTmpPosition);
      paramState = mTmpPosition;
      f1 = paramState[1];
      f2 = paramState[0];
    }
    else
    {
      f2 = 0.0F;
      f1 = 0.0F;
    }
    mCallback.onDraw(paramCanvas, paramRecyclerView, mSelected, mRecoverAnimations, mActionState, f2, f1);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    float f1;
    float f2;
    if (mSelected != null)
    {
      getSelectedDxDy(mTmpPosition);
      paramState = mTmpPosition;
      f1 = paramState[1];
      f2 = paramState[0];
    }
    else
    {
      f2 = 0.0F;
      f1 = 0.0F;
    }
    mCallback.onDrawOver(paramCanvas, paramRecyclerView, mSelected, mRecoverAnimations, mActionState, f2, f1);
  }
  
  public void postDispatchSwipe(final RecoverAnimation paramRecoverAnimation, final int paramInt)
  {
    mRecyclerView.post(new Runnable()
    {
      public void run()
      {
        Object localObject = mRecyclerView;
        if ((localObject != null) && (((RecyclerView)localObject).isAttachedToWindow()))
        {
          localObject = paramRecoverAnimation;
          if ((!mOverridden) && (mViewHolder.getAdapterPosition() != -1))
          {
            localObject = mRecyclerView.getItemAnimator();
            if (((localObject == null) || (!((RecyclerView.ItemAnimator)localObject).isRunning(null))) && (!hasRunningRecoverAnim()))
            {
              mCallback.onSwiped(paramRecoverAnimationmViewHolder, paramInt);
              return;
            }
            mRecyclerView.post(this);
          }
        }
      }
    });
  }
  
  public void removeChildDrawingOrderCallbackIfNecessary(View paramView)
  {
    if (paramView == mOverdrawChild)
    {
      mOverdrawChild = null;
      if (mChildDrawingOrderCallback != null) {
        mRecyclerView.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  public boolean scrollIfNecessary()
  {
    if (mSelected == null)
    {
      mDragScrollStartTimeInMs = Long.MIN_VALUE;
      return false;
    }
    long l2 = System.currentTimeMillis();
    long l1 = mDragScrollStartTimeInMs;
    if (l1 == Long.MIN_VALUE) {
      l1 = 0L;
    } else {
      l1 = l2 - l1;
    }
    RecyclerView.LayoutManager localLayoutManager = mRecyclerView.getLayoutManager();
    if (mTmpRect == null) {
      mTmpRect = new Rect();
    }
    localLayoutManager.calculateItemDecorationsForChild(mSelected.itemView, mTmpRect);
    if (localLayoutManager.canScrollHorizontally())
    {
      j = (int)(mSelectedStartX + mDx);
      i = j - mTmpRect.left - mRecyclerView.getPaddingLeft();
      if ((mDx < 0.0F) && (i < 0)) {
        break label200;
      }
      if (mDx > 0.0F)
      {
        i = mSelected.itemView.getWidth() + j + mTmpRect.right - (mRecyclerView.getWidth() - mRecyclerView.getPaddingRight());
        if (i > 0) {
          break label200;
        }
      }
    }
    int i = 0;
    label200:
    if (localLayoutManager.canScrollVertically())
    {
      k = (int)(mSelectedStartY + mDy);
      j = k - mTmpRect.top - mRecyclerView.getPaddingTop();
      if ((mDy < 0.0F) && (j < 0)) {
        break label308;
      }
      if (mDy > 0.0F)
      {
        j = mSelected.itemView.getHeight() + k + mTmpRect.bottom - (mRecyclerView.getHeight() - mRecyclerView.getPaddingBottom());
        if (j > 0) {
          break label308;
        }
      }
    }
    int j = 0;
    label308:
    int k = i;
    if (i != 0) {
      k = mCallback.interpolateOutOfBoundsScroll(mRecyclerView, mSelected.itemView.getWidth(), i, mRecyclerView.getWidth(), l1);
    }
    i = j;
    if (j != 0) {
      i = mCallback.interpolateOutOfBoundsScroll(mRecyclerView, mSelected.itemView.getHeight(), j, mRecyclerView.getHeight(), l1);
    }
    if ((k == 0) && (i == 0))
    {
      mDragScrollStartTimeInMs = Long.MIN_VALUE;
      return false;
    }
    if (mDragScrollStartTimeInMs == Long.MIN_VALUE) {
      mDragScrollStartTimeInMs = l2;
    }
    mRecyclerView.scrollBy(k, i);
    return true;
  }
  
  public void select(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder == mSelected) && (paramInt == mActionState)) {
      return;
    }
    mDragScrollStartTimeInMs = Long.MIN_VALUE;
    int k = mActionState;
    endRecoverAnimation(paramViewHolder, true);
    mActionState = paramInt;
    if (paramInt == 2) {
      if (paramViewHolder != null)
      {
        mOverdrawChild = itemView;
        addChildDrawingOrderCallback();
      }
      else
      {
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
      }
    }
    Object localObject = mSelected;
    int i;
    if (localObject != null)
    {
      if (itemView.getParent() != null)
      {
        final int j;
        if (k == 2) {
          j = 0;
        } else {
          j = swipeIfNecessary((RecyclerView.ViewHolder)localObject);
        }
        releaseVelocityTracker();
        if ((j != 1) && (j != 2))
        {
          if ((j != 4) && (j != 8) && (j != 16) && (j != 32)) {}
          for (f1 = 0.0F;; f1 = Math.signum(mDx) * mRecyclerView.getWidth())
          {
            f2 = 0.0F;
            break;
          }
        }
        float f2 = Math.signum(mDy) * mRecyclerView.getHeight();
        float f1 = 0.0F;
        if (k == 2) {
          i = 8;
        } else if (j > 0) {
          i = 2;
        } else {
          i = 4;
        }
        getSelectedDxDy(mTmpPosition);
        float[] arrayOfFloat = mTmpPosition;
        float f3 = arrayOfFloat[0];
        float f4 = arrayOfFloat[1];
        localObject = new RecoverAnimation((RecyclerView.ViewHolder)localObject, i, k, f3, f4, f1, f2)
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            if (!mEnded) {
              mViewHolder.setIsRecyclable(true);
            }
            mEnded = true;
            if (mOverridden) {
              return;
            }
            if (j <= 0)
            {
              paramAnonymousAnimator = ItemTouchHelper.this;
              mCallback.clearView(mRecyclerView, val$prevSelected);
            }
            else
            {
              mPendingCleanup.add(val$prevSelected.itemView);
              mIsPendingCleanup = true;
              int i = j;
              if (i > 0) {
                postDispatchSwipe(this, i);
              }
            }
            paramAnonymousAnimator = ItemTouchHelper.this;
            View localView1 = mOverdrawChild;
            View localView2 = val$prevSelected.itemView;
            if (localView1 == localView2) {
              paramAnonymousAnimator.removeChildDrawingOrderCallbackIfNecessary(localView2);
            }
          }
        };
        ((RecoverAnimation)localObject).setDuration(mCallback.getAnimationDuration(mRecyclerView, i, f1 - f3, f2 - f4));
        mRecoverAnimations.add(localObject);
        ((RecoverAnimation)localObject).start();
        i = 1;
      }
      else
      {
        removeChildDrawingOrderCallbackIfNecessary(itemView);
        mCallback.clearView(mRecyclerView, (RecyclerView.ViewHolder)localObject);
        i = 0;
      }
      mSelected = null;
    }
    else
    {
      i = 0;
    }
    if (paramViewHolder != null)
    {
      mSelectedFlags = ((mCallback.getAbsoluteMovementFlags(mRecyclerView, paramViewHolder) & (1 << paramInt * 8 + 8) - 1) >> mActionState * 8);
      mSelectedStartX = itemView.getLeft();
      mSelectedStartY = itemView.getTop();
      mSelected = paramViewHolder;
      if (paramInt == 2) {
        mSelected.itemView.performHapticFeedback(0);
      }
    }
    boolean bool = false;
    paramViewHolder = mRecyclerView.getParent();
    if (paramViewHolder != null)
    {
      if (mSelected != null) {
        bool = true;
      }
      paramViewHolder.requestDisallowInterceptTouchEvent(bool);
    }
    if (i == 0) {
      mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
    }
    mCallback.onSelectedChanged(mSelected, mActionState);
    mRecyclerView.invalidate();
  }
  
  public void startDrag(RecyclerView.ViewHolder paramViewHolder)
  {
    if (!mCallback.hasDragFlag(mRecyclerView, paramViewHolder)) {
      return;
    }
    if (itemView.getParent() != mRecyclerView) {
      return;
    }
    obtainVelocityTracker();
    mDy = 0.0F;
    mDx = 0.0F;
    select(paramViewHolder, 2);
  }
  
  public void startSwipe(RecyclerView.ViewHolder paramViewHolder)
  {
    if (!mCallback.hasSwipeFlag(mRecyclerView, paramViewHolder)) {
      return;
    }
    if (itemView.getParent() != mRecyclerView) {
      return;
    }
    obtainVelocityTracker();
    mDy = 0.0F;
    mDx = 0.0F;
    select(paramViewHolder, 1);
  }
  
  public void updateDxDy(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    mDx = (f1 - mInitialTouchX);
    mDy = (f2 - mInitialTouchY);
    if ((paramInt1 & 0x4) == 0) {
      mDx = Math.max(0.0F, mDx);
    }
    if ((paramInt1 & 0x8) == 0) {
      mDx = Math.min(0.0F, mDx);
    }
    if ((paramInt1 & 0x1) == 0) {
      mDy = Math.max(0.0F, mDy);
    }
    if ((paramInt1 & 0x2) == 0) {
      mDy = Math.min(0.0F, mDy);
    }
  }
  
  public static abstract class Callback
  {
    public static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
    public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
    public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
    public static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000L;
    public static final int RELATIVE_DIR_FLAGS = 3158064;
    public static final Interpolator sDragScrollInterpolator = new Interpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat;
      }
    };
    public static final Interpolator sDragViewScrollCapInterpolator = new Interpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
      }
    };
    public int mCachedMaxScrollSpeed = -1;
    
    public Callback() {}
    
    public static int convertToRelativeDirection(int paramInt1, int paramInt2)
    {
      int i = paramInt1 & 0xC0C0C;
      if (i == 0) {
        return paramInt1;
      }
      paramInt1 &= i;
      if (paramInt2 == 0) {}
      for (paramInt2 = i << 2;; paramInt2 = (paramInt2 & 0xC0C0C) << 2)
      {
        return paramInt1 | paramInt2;
        paramInt2 = i << 1;
        paramInt1 |= 0xFFF3F3F3 & paramInt2;
      }
    }
    
    public static ItemTouchUIUtil getDefaultUIUtil()
    {
      return ItemTouchUIUtilImpl.INSTANCE;
    }
    
    private int getMaxDragScroll(RecyclerView paramRecyclerView)
    {
      if (mCachedMaxScrollSpeed == -1) {
        mCachedMaxScrollSpeed = paramRecyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
      }
      return mCachedMaxScrollSpeed;
    }
    
    public static int makeFlag(int paramInt1, int paramInt2)
    {
      return paramInt2 << paramInt1 * 8;
    }
    
    public static int makeMovementFlags(int paramInt1, int paramInt2)
    {
      return paramInt1 << 16 | paramInt2 << 8 | (paramInt2 | paramInt1) << 0;
    }
    
    public boolean canDropOver(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
    {
      return true;
    }
    
    public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder paramViewHolder, List paramList, int paramInt1, int paramInt2)
    {
      int n = itemView.getWidth();
      int i1 = itemView.getHeight();
      int i2 = paramInt1 - itemView.getLeft();
      Object localObject1 = itemView;
      int i3 = paramInt2 - ((View)localObject1).getTop();
      int i4 = paramList.size();
      Object localObject3 = null;
      int i = -1;
      int k = 0;
      localObject1 = paramViewHolder;
      while (k < i4)
      {
        paramViewHolder = (RecyclerView.ViewHolder)paramList.get(k);
        Object localObject2 = localObject1;
        int m;
        if (i2 > 0)
        {
          j = itemView.getRight() - (n + paramInt1);
          localObject2 = localObject1;
          if (j < 0)
          {
            m = itemView.getRight();
            localObject4 = itemView;
            localObject2 = localObject1;
            if (m > ((View)localObject4).getRight())
            {
              m = Math.abs(j);
              j = m;
              localObject2 = localObject1;
              if (m > i)
              {
                localObject4 = paramViewHolder;
                localObject2 = localObject1;
                break label186;
              }
            }
          }
        }
        int j = i;
        Object localObject4 = localObject3;
        label186:
        localObject3 = localObject4;
        i = j;
        localObject1 = localObject2;
        int i5;
        View localView;
        if (i2 < 0)
        {
          m = itemView.getLeft() - paramInt1;
          localObject3 = localObject4;
          i = j;
          localObject1 = localObject2;
          if (m > 0)
          {
            i5 = itemView.getLeft();
            localView = itemView;
            localObject3 = localObject4;
            i = j;
            localObject1 = localObject2;
            if (i5 < localView.getLeft())
            {
              m = Math.abs(m);
              localObject3 = localObject4;
              i = j;
              localObject1 = localObject2;
              if (m > j)
              {
                i = m;
                localObject3 = paramViewHolder;
                localObject1 = localObject2;
              }
            }
          }
        }
        localObject4 = localObject3;
        j = i;
        localObject2 = localObject1;
        if (i3 < 0)
        {
          m = itemView.getTop() - paramInt2;
          localObject4 = localObject3;
          j = i;
          localObject2 = localObject1;
          if (m > 0)
          {
            i5 = itemView.getTop();
            localView = itemView;
            localObject4 = localObject3;
            j = i;
            localObject2 = localObject1;
            if (i5 < localView.getTop())
            {
              m = Math.abs(m);
              localObject4 = localObject3;
              j = i;
              localObject2 = localObject1;
              if (m > i)
              {
                j = m;
                localObject4 = paramViewHolder;
                localObject2 = localObject1;
              }
            }
          }
        }
        localObject1 = localObject2;
        if (i3 > 0)
        {
          i = itemView.getBottom() - (i1 + paramInt2);
          localObject1 = localObject2;
          if (i < 0)
          {
            m = itemView.getBottom();
            localObject3 = itemView;
            localObject1 = localObject2;
            if (m > ((View)localObject3).getBottom())
            {
              m = Math.abs(i);
              i = m;
              localObject1 = localObject2;
              if (m > j)
              {
                localObject3 = paramViewHolder;
                localObject1 = localObject2;
                break label530;
              }
            }
          }
        }
        i = j;
        localObject3 = localObject4;
        label530:
        k += 1;
      }
      return localObject3;
    }
    
    public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      ItemTouchUIUtilImpl.INSTANCE.clearView(itemView);
    }
    
    public int convertToAbsoluteDirection(int paramInt1, int paramInt2)
    {
      int i = paramInt1 & 0x303030;
      if (i == 0) {
        return paramInt1;
      }
      paramInt1 &= i;
      if (paramInt2 == 0) {}
      for (paramInt2 = i >> 2;; paramInt2 = (paramInt2 & 0x303030) >> 2)
      {
        return paramInt1 | paramInt2;
        paramInt2 = i >> 1;
        paramInt1 |= 0xFFCFCFCF & paramInt2;
      }
    }
    
    public final int getAbsoluteMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return convertToAbsoluteDirection(getMovementFlags(paramRecyclerView, paramViewHolder), ViewCompat.getLayoutDirection(paramRecyclerView));
    }
    
    public long getAnimationDuration(RecyclerView paramRecyclerView, int paramInt, float paramFloat1, float paramFloat2)
    {
      paramRecyclerView = paramRecyclerView.getItemAnimator();
      if (paramRecyclerView == null)
      {
        if (paramInt == 8) {
          return 200L;
        }
        return 250L;
      }
      if (paramInt == 8) {
        return paramRecyclerView.getMoveDuration();
      }
      return paramRecyclerView.getRemoveDuration();
    }
    
    public int getBoundingBoxMargin()
    {
      return 0;
    }
    
    public float getMoveThreshold(RecyclerView.ViewHolder paramViewHolder)
    {
      return 0.5F;
    }
    
    public abstract int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder);
    
    public float getSwipeEscapeVelocity(float paramFloat)
    {
      return paramFloat;
    }
    
    public float getSwipeThreshold(RecyclerView.ViewHolder paramViewHolder)
    {
      return 0.5F;
    }
    
    public float getSwipeVelocityThreshold(float paramFloat)
    {
      return paramFloat;
    }
    
    public boolean hasDragFlag(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return (getAbsoluteMovementFlags(paramRecyclerView, paramViewHolder) & 0xFF0000) != 0;
    }
    
    public boolean hasSwipeFlag(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return (getAbsoluteMovementFlags(paramRecyclerView, paramViewHolder) & 0xFF00) != 0;
    }
    
    public int interpolateOutOfBoundsScroll(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      paramInt3 = getMaxDragScroll(paramRecyclerView);
      int i = Math.abs(paramInt2);
      int j = (int)Math.signum(paramInt2);
      float f2 = i;
      float f1 = 1.0F;
      f2 = Math.min(1.0F, f2 * 1.0F / paramInt1);
      float f3 = j * paramInt3;
      paramInt1 = (int)(sDragViewScrollCapInterpolator.getInterpolation(f2) * f3);
      if (paramLong <= 2000L) {
        f1 = (float)paramLong / 2000.0F;
      }
      f2 = paramInt1;
      paramInt1 = (int)(sDragScrollInterpolator.getInterpolation(f1) * f2);
      if (paramInt1 == 0)
      {
        if (paramInt2 > 0) {
          return 1;
        }
        return -1;
      }
      return paramInt1;
    }
    
    public boolean isItemViewSwipeEnabled()
    {
      return true;
    }
    
    public boolean isLongPressDragEnabled()
    {
      return true;
    }
    
    public void onChildDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      ItemTouchUIUtilImpl.INSTANCE.onDraw(paramCanvas, paramRecyclerView, itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
    }
    
    public void onChildDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      ItemTouchUIUtilImpl.INSTANCE.onDrawOver(paramCanvas, paramRecyclerView, itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
    }
    
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List paramList, int paramInt, float paramFloat1, float paramFloat2)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
        localRecoverAnimation.update();
        int k = paramCanvas.save();
        onChildDraw(paramCanvas, paramRecyclerView, mViewHolder, mX, mY, mActionState, false);
        paramCanvas.restoreToCount(k);
        i += 1;
      }
      if (paramViewHolder != null)
      {
        i = paramCanvas.save();
        onChildDraw(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
        paramCanvas.restoreToCount(i);
      }
    }
    
    public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List paramList, int paramInt, float paramFloat1, float paramFloat2)
    {
      int k = paramList.size();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
        int m = paramCanvas.save();
        onChildDrawOver(paramCanvas, paramRecyclerView, mViewHolder, mX, mY, mActionState, false);
        paramCanvas.restoreToCount(m);
        i += 1;
      }
      if (paramViewHolder != null)
      {
        i = paramCanvas.save();
        onChildDrawOver(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
        paramCanvas.restoreToCount(i);
      }
      paramInt = k - 1;
      i = j;
      while (paramInt >= 0)
      {
        paramCanvas = (ItemTouchHelper.RecoverAnimation)paramList.get(paramInt);
        if ((mEnded) && (!mIsPendingCleanup)) {
          paramList.remove(paramInt);
        } else if (!mEnded) {
          i = 1;
        }
        paramInt -= 1;
      }
      if (i != 0) {
        paramRecyclerView.invalidate();
      }
    }
    
    public abstract boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2);
    
    public void onMoved(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, int paramInt1, RecyclerView.ViewHolder paramViewHolder2, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
      if ((localLayoutManager instanceof ItemTouchHelper.ViewDropHandler))
      {
        ((ItemTouchHelper.ViewDropHandler)localLayoutManager).prepareForDrop(itemView, itemView, paramInt3, paramInt4);
        return;
      }
      if (localLayoutManager.canScrollHorizontally())
      {
        if (localLayoutManager.getDecoratedLeft(itemView) <= paramRecyclerView.getPaddingLeft()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
        if (localLayoutManager.getDecoratedRight(itemView) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
      }
      if (localLayoutManager.canScrollVertically())
      {
        if (localLayoutManager.getDecoratedTop(itemView) <= paramRecyclerView.getPaddingTop()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
        if (localLayoutManager.getDecoratedBottom(itemView) >= paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
      }
    }
    
    public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      if (paramViewHolder != null) {
        ItemTouchUIUtilImpl.INSTANCE.onSelected(itemView);
      }
    }
    
    public abstract void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  }
  
  private class ItemTouchHelperGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    public boolean mShouldReactToLongPress = true;
    
    public ItemTouchHelperGestureListener() {}
    
    public void doNotReactToLongPress()
    {
      mShouldReactToLongPress = false;
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      if (!mShouldReactToLongPress) {
        return;
      }
      Object localObject = findChildView(paramMotionEvent);
      if (localObject != null)
      {
        localObject = mRecyclerView.getChildViewHolder((View)localObject);
        if (localObject != null)
        {
          ItemTouchHelper localItemTouchHelper = ItemTouchHelper.this;
          if (!mCallback.hasDragFlag(mRecyclerView, (RecyclerView.ViewHolder)localObject)) {
            return;
          }
          int i = paramMotionEvent.getPointerId(0);
          int j = mActivePointerId;
          if (i == j)
          {
            i = paramMotionEvent.findPointerIndex(j);
            float f1 = paramMotionEvent.getX(i);
            float f2 = paramMotionEvent.getY(i);
            paramMotionEvent = ItemTouchHelper.this;
            mInitialTouchX = f1;
            mInitialTouchY = f2;
            mDy = 0.0F;
            mDx = 0.0F;
            if (mCallback.isLongPressDragEnabled()) {
              select((RecyclerView.ViewHolder)localObject, 2);
            }
          }
        }
      }
    }
  }
  
  private static class RecoverAnimation
    implements Animator.AnimatorListener
  {
    public final int mActionState;
    public final int mAnimationType;
    public boolean mEnded = false;
    public float mFraction;
    public boolean mIsPendingCleanup;
    public boolean mOverridden = false;
    public final float mStartDx;
    public final float mStartDy;
    public final float mTargetX;
    public final float mTargetY;
    public final ValueAnimator mValueAnimator;
    public final RecyclerView.ViewHolder mViewHolder;
    public float mX;
    public float mY;
    
    public RecoverAnimation(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      mActionState = paramInt2;
      mAnimationType = paramInt1;
      mViewHolder = paramViewHolder;
      mStartDx = paramFloat1;
      mStartDy = paramFloat2;
      mTargetX = paramFloat3;
      mTargetY = paramFloat4;
      mValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          setFraction(paramAnonymousValueAnimator.getAnimatedFraction());
        }
      });
      mValueAnimator.setTarget(itemView);
      mValueAnimator.addListener(this);
      setFraction(0.0F);
    }
    
    public void cancel()
    {
      mValueAnimator.cancel();
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      setFraction(1.0F);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!mEnded) {
        mViewHolder.setIsRecyclable(true);
      }
      mEnded = true;
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
    
    public void setDuration(long paramLong)
    {
      mValueAnimator.setDuration(paramLong);
    }
    
    public void setFraction(float paramFloat)
    {
      mFraction = paramFloat;
    }
    
    public void start()
    {
      mViewHolder.setIsRecyclable(false);
      mValueAnimator.start();
    }
    
    public void update()
    {
      float f1 = mStartDx;
      float f2 = mTargetX;
      if (f1 == f2) {
        mX = mViewHolder.itemView.getTranslationX();
      } else {
        mX = StringBuilder.append(f2, f1, mFraction, f1);
      }
      f1 = mStartDy;
      f2 = mTargetY;
      if (f1 == f2)
      {
        mY = mViewHolder.itemView.getTranslationY();
        return;
      }
      mY = StringBuilder.append(f2, f1, mFraction, f1);
    }
  }
  
  public static abstract class SimpleCallback
    extends ItemTouchHelper.Callback
  {
    public int mDefaultDragDirs;
    public int mDefaultSwipeDirs;
    
    public SimpleCallback(int paramInt1, int paramInt2)
    {
      mDefaultSwipeDirs = paramInt2;
      mDefaultDragDirs = paramInt1;
    }
    
    public int getDragDirs(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return mDefaultDragDirs;
    }
    
    public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return ItemTouchHelper.Callback.makeMovementFlags(getDragDirs(paramRecyclerView, paramViewHolder), getSwipeDirs(paramRecyclerView, paramViewHolder));
    }
    
    public int getSwipeDirs(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return mDefaultSwipeDirs;
    }
    
    public void setDefaultDragDirs(int paramInt)
    {
      mDefaultDragDirs = paramInt;
    }
    
    public void setDefaultSwipeDirs(int paramInt)
    {
      mDefaultSwipeDirs = paramInt;
    }
  }
  
  public static abstract interface ViewDropHandler
  {
    public abstract void prepareForDrop(View paramView1, View paramView2, int paramInt1, int paramInt2);
  }
}
