package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import support.android.v4.content.ContextCompat;
import support.android.v4.view.AccessibilityDelegateCompat;
import support.android.v4.view.DiscreteSeekBar.CustomState.1;
import support.android.v4.view.MonthByWeekFragment.2;
import support.android.v4.view.PagerAdapter;
import support.android.v4.view.RecyclerView.3;
import support.android.v4.view.Version.BuildAwareOrder;
import support.android.v4.view.ViewCompat;
import support.android.v4.view.ViewPager.4;
import support.android.v4.view.accessibility.AccessibilityNodeInfoCompat;

public class ViewPager
  extends ViewGroup
{
  public static final int CLOSE_ENOUGH = 2;
  public static final Comparator<b> COMPARATOR = new Version.BuildAwareOrder();
  public static final int DEFAULT_GUTTER_SIZE = 16;
  public static final int DEFAULT_OFFSCREEN_PAGES = 1;
  public static final boolean DEFAULT_SHOW_WEEK_NUM = false;
  public static final int DRAW_ORDER_DEFAULT = 0;
  public static final int DRAW_ORDER_FORWARD = 1;
  public static final int DRAW_ORDER_REVERSE = 2;
  public static final int Icode_DUP = -1;
  public static final int[] LAYOUT_ATTRS = { 16842931 };
  public static final int MAX_SETTLE_DURATION = 600;
  public static final int MIN_DISTANCE_FOR_FLING = 25;
  public static final int MIN_FLING_VELOCITY = 400;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  public static final String TAG = "ViewPager";
  public static final boolean mIgnoreGutter = false;
  public static final Interpolator sInterpolator = new RecyclerView.3();
  public static final i sPositionComparator = new i();
  public int mActivePointerId = -1;
  public PagerAdapter mAdapter;
  public int mBottomPageBounds;
  public boolean mCalledSuper;
  public int mChildHeightMeasureSpec;
  public int mChildWidthMeasureSpec;
  public int mCloseEnough;
  public int mCurItem;
  public int mDecorChildCount;
  public int mDefaultGutterSize;
  public int mDrawingOrder;
  public ArrayList<View> mDrawingOrderedChildren;
  public final Runnable mEndScrollRunnable = new MonthByWeekFragment.2(this);
  public int mExpectedAdapterCount;
  public long mFakeDragBeginTime;
  public boolean mFakeDragging;
  public boolean mFirstLayout = true;
  public float mFirstOffset = -3.4028235E38F;
  public int mFlingDistance;
  public List<d> mGroups;
  public int mGutterSize;
  public boolean mInLayout;
  public float mInitialMotionX;
  public float mInitialMotionY;
  public e mInternalPageChangeListener;
  public boolean mIsBeingDragged;
  public boolean mIsScrollStarted;
  public boolean mIsUnableToDrag;
  public final ArrayList<b> mItems = new ArrayList();
  public float mLastMotionX;
  public float mLastMotionY;
  public float mLastOffset = Float.MAX_VALUE;
  public EdgeEffect mLeftEdge;
  public Drawable mMarginDrawable;
  public int mMaximumVelocity;
  public int mMinimumVelocity;
  public boolean mNeedCalculatePageOffsets = false;
  public g mObserver;
  public int mOffscreenPageLimit = 1;
  public e mOnPageChangeListener;
  public List<e> mOnPageChangeListeners;
  public int mPageMargin;
  public f mPageTransformer;
  public boolean mPopulatePending;
  public Parcelable mRestoredAdapterState = null;
  public ClassLoader mRestoredClassLoader = null;
  public int mRestoredCurItem = -1;
  public EdgeEffect mRightEdge;
  public int mScrollState = 0;
  public Scroller mScroller;
  public boolean mScrollingCacheEnabled;
  public final b mTempItem = new b();
  public final Rect mTempRect = new Rect();
  public int mTopPageBounds;
  public int mTouchSlop;
  public VelocityTracker mVelocityTracker;
  public int position;
  
  public ViewPager(Context paramContext)
  {
    super(paramContext);
    initViewPager();
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViewPager();
  }
  
  public static boolean add(View paramView)
  {
    return paramView.getClass().getAnnotation(a.class) != null;
  }
  
  private void calculatePageOffsets(b paramB1, int paramInt, b paramB2)
  {
    int m = mAdapter.getCount();
    int i = getClientWidth();
    float f2;
    if (i > 0) {
      f2 = mPageMargin / i;
    } else {
      f2 = 0.0F;
    }
    float f3;
    if (paramB2 != null)
    {
      i = position;
      j = position;
      if (i < j)
      {
        f1 = offset + widthFactor + f2;
        i += 1;
        j = 0;
        while ((i <= position) && (j < mItems.size()))
        {
          for (paramB2 = (b)mItems.get(j);; paramB2 = (b)mItems.get(j))
          {
            k = i;
            f3 = f1;
            if (i <= position) {
              break;
            }
            k = i;
            f3 = f1;
            if (j >= mItems.size() - 1) {
              break;
            }
            j += 1;
          }
          while (k < position)
          {
            f3 += mAdapter.getPageWidth(k) + f2;
            k += 1;
          }
          offset = f3;
          f1 = f3 + (widthFactor + f2);
          i = k + 1;
        }
      }
      if (i > j)
      {
        j = mItems.size() - 1;
        f1 = offset;
        i -= 1;
        while ((i >= position) && (j >= 0))
        {
          for (paramB2 = (b)mItems.get(j);; paramB2 = (b)mItems.get(j))
          {
            k = i;
            f3 = f1;
            if (i >= position) {
              break;
            }
            k = i;
            f3 = f1;
            if (j <= 0) {
              break;
            }
            j -= 1;
          }
          while (k > position)
          {
            f3 -= mAdapter.getPageWidth(k) + f2;
            k -= 1;
          }
          f1 = f3 - (widthFactor + f2);
          offset = f1;
          i = k - 1;
        }
      }
    }
    int k = mItems.size();
    float f1 = offset;
    int j = position;
    i = j - 1;
    if (j == 0) {
      f3 = f1;
    } else {
      f3 = -3.4028235E38F;
    }
    mFirstOffset = f3;
    j = position;
    m -= 1;
    if (j == m) {
      f3 = offset + widthFactor - 1.0F;
    } else {
      f3 = Float.MAX_VALUE;
    }
    mLastOffset = f3;
    j = paramInt - 1;
    while (j >= 0)
    {
      paramB2 = (b)mItems.get(j);
      int n;
      for (;;)
      {
        n = position;
        if (i <= n) {
          break;
        }
        f1 -= mAdapter.getPageWidth(i) + f2;
        i -= 1;
      }
      f1 -= widthFactor + f2;
      offset = f1;
      if (n == 0) {
        mFirstOffset = f1;
      }
      j -= 1;
      i -= 1;
    }
    f1 = offset + widthFactor + f2;
    j = position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramB1 = (b)mItems.get(i);
      for (;;)
      {
        j = position;
        if (paramInt >= j) {
          break;
        }
        f1 += mAdapter.getPageWidth(paramInt) + f2;
        paramInt += 1;
      }
      if (j == m) {
        mLastOffset = (widthFactor + f1 - 1.0F);
      }
      offset = f1;
      f1 += widthFactor + f2;
      i += 1;
      paramInt += 1;
    }
    mNeedCalculatePageOffsets = false;
  }
  
  private void completeScroll(boolean paramBoolean)
  {
    if (mScrollState == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      setScrollingCacheEnabled(false);
      if ((mScroller.isFinished() ^ true))
      {
        mScroller.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = mScroller.getCurrX();
        int n = mScroller.getCurrY();
        if ((j != m) || (k != n))
        {
          scrollTo(m, n);
          if (m != j) {
            pageScrolled(m);
          }
        }
      }
    }
    mPopulatePending = false;
    int k = 0;
    int j = i;
    int i = k;
    while (i < mItems.size())
    {
      b localB = (b)mItems.get(i);
      if (scrolling)
      {
        scrolling = false;
        j = 1;
      }
      i += 1;
    }
    if (j != 0)
    {
      if (paramBoolean)
      {
        ViewCompat.postOnAnimation(this, mEndScrollRunnable);
        return;
      }
      mEndScrollRunnable.run();
    }
  }
  
  private int determineTargetPage(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > mFlingDistance) && (Math.abs(paramInt2) > mMinimumVelocity))
    {
      if (paramInt2 <= 0) {
        paramInt1 += 1;
      }
    }
    else
    {
      float f;
      if (paramInt1 >= mCurItem) {
        f = 0.4F;
      } else {
        f = 0.6F;
      }
      paramInt1 += (int)(paramFloat + f);
    }
    paramInt2 = paramInt1;
    if (mItems.size() > 0)
    {
      b localB = (b)mItems.get(0);
      Object localObject = mItems;
      localObject = (b)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      paramInt2 = Math.max(position, Math.min(paramInt1, position));
    }
    return paramInt2;
  }
  
  private void dispatchOnPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject = mOnPageChangeListener;
    if (localObject != null) {
      ((e)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    localObject = mOnPageChangeListeners;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (e)mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((e)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
        }
        i += 1;
      }
    }
    localObject = mInternalPageChangeListener;
    if (localObject != null) {
      ((e)localObject).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  private void dispatchOnPageSelected(int paramInt)
  {
    Object localObject = mOnPageChangeListener;
    if (localObject != null) {
      ((e)localObject).onPageSelected(paramInt);
    }
    localObject = mOnPageChangeListeners;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (e)mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((e)localObject).onPageSelected(paramInt);
        }
        i += 1;
      }
    }
    localObject = mInternalPageChangeListener;
    if (localObject != null) {
      ((e)localObject).onPageSelected(paramInt);
    }
  }
  
  private void dispatchOnScrollStateChanged(int paramInt)
  {
    Object localObject = mOnPageChangeListener;
    if (localObject != null) {
      ((e)localObject).onPageScrollStateChanged(paramInt);
    }
    localObject = mOnPageChangeListeners;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (e)mOnPageChangeListeners.get(i);
        if (localObject != null) {
          ((e)localObject).onPageScrollStateChanged(paramInt);
        }
        i += 1;
      }
    }
    localObject = mInternalPageChangeListener;
    if (localObject != null) {
      ((e)localObject).onPageScrollStateChanged(paramInt);
    }
  }
  
  private void enableLayers(boolean paramBoolean)
  {
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      int j;
      if (paramBoolean) {
        j = position;
      } else {
        j = 0;
      }
      getChildAt(i).setLayerType(j, null);
      i += 1;
    }
  }
  
  private void endDrag()
  {
    mIsBeingDragged = false;
    mIsUnableToDrag = false;
    VelocityTracker localVelocityTracker = mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      mVelocityTracker = null;
    }
  }
  
  private Rect getChildRectInPagerCoordinates(Rect paramRect, View paramView)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    if (paramView == null)
    {
      localRect.set(0, 0, 0, 0);
      return localRect;
    }
    left = paramView.getLeft();
    right = paramView.getRight();
    top = paramView.getTop();
    bottom = paramView.getBottom();
    for (paramRect = paramView.getParent(); ((paramRect instanceof ViewGroup)) && (paramRect != this); paramRect = paramRect.getParent())
    {
      paramRect = (ViewGroup)paramRect;
      int i = left;
      left = (paramRect.getLeft() + i);
      i = right;
      right = (paramRect.getRight() + i);
      i = top;
      top = (paramRect.getTop() + i);
      i = bottom;
      bottom = (paramRect.getBottom() + i);
    }
    return localRect;
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private b infoForCurrentScrollPosition()
  {
    int i = getClientWidth();
    float f1;
    if (i > 0) {
      f1 = getScrollX() / i;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (i > 0) {
      f2 = mPageMargin / i;
    } else {
      f2 = 0.0F;
    }
    Object localObject = null;
    i = 0;
    int j = 1;
    int k = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i < mItems.size())
    {
      b localB2 = (b)mItems.get(i);
      int m = i;
      b localB1 = localB2;
      if (j == 0)
      {
        int n = position;
        k += 1;
        m = i;
        localB1 = localB2;
        if (n != k)
        {
          localB1 = mTempItem;
          offset = (f3 + f4 + f2);
          position = k;
          widthFactor = mAdapter.getPageWidth(position);
          m = i - 1;
        }
      }
      f3 = offset;
      f4 = widthFactor;
      if ((j == 0) && (f1 < f3)) {
        return localObject;
      }
      if (f1 >= f4 + f3 + f2)
      {
        if (m == mItems.size() - 1) {
          return localB1;
        }
        k = position;
        f4 = widthFactor;
        i = m + 1;
        j = 0;
        localObject = localB1;
      }
      else
      {
        return localB1;
      }
    }
    return localObject;
  }
  
  private boolean isGutterDrag(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < mGutterSize) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - mGutterSize) && (paramFloat2 < 0.0F));
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
      mLastMotionX = paramMotionEvent.getX(i);
      mActivePointerId = paramMotionEvent.getPointerId(i);
      paramMotionEvent = mVelocityTracker;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  private boolean onTouchEvent()
  {
    mActivePointerId = -1;
    endDrag();
    mLeftEdge.onRelease();
    mRightEdge.onRelease();
    return (mLeftEdge.isFinished()) || (mRightEdge.isFinished());
  }
  
  private boolean pageScrolled(int paramInt)
  {
    if (mItems.size() == 0)
    {
      if (mFirstLayout) {
        return false;
      }
      mCalledSuper = false;
      onPageScrolled(0, 0.0F, 0);
      if (mCalledSuper) {
        return false;
      }
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    b localB = infoForCurrentScrollPosition();
    int j = getClientWidth();
    int k = mPageMargin;
    float f2 = k;
    float f1 = j;
    f2 /= f1;
    int i = position;
    f1 = (paramInt / f1 - offset) / (widthFactor + f2);
    paramInt = (int)((j + k) * f1);
    mCalledSuper = false;
    onPageScrolled(i, f1, paramInt);
    if (mCalledSuper) {
      return true;
    }
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  private boolean performDrag(float paramFloat)
  {
    float f1 = mLastMotionX;
    mLastMotionX = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    float f3 = getClientWidth();
    paramFloat = mFirstOffset * f3;
    f1 = mLastOffset * f3;
    Object localObject1 = mItems;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    localObject1 = (b)((ArrayList)localObject1).get(0);
    Object localObject2 = mItems;
    localObject2 = (b)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
    if (position != 0)
    {
      paramFloat = offset * f3;
      i = 0;
    }
    else
    {
      i = 1;
    }
    int j;
    if (position != mAdapter.getCount() - 1)
    {
      f1 = offset * f3;
      j = 0;
    }
    else
    {
      j = 1;
    }
    if (f2 < paramFloat)
    {
      if (i != 0)
      {
        mLeftEdge.onPull(Math.abs(paramFloat - f2) / f3);
        bool1 = true;
      }
    }
    else
    {
      paramFloat = f2;
      bool1 = bool3;
      if (f2 > f1)
      {
        bool1 = bool2;
        if (j != 0)
        {
          mRightEdge.onPull(Math.abs(f2 - f1) / f3);
          bool1 = true;
        }
        paramFloat = f1;
      }
    }
    f1 = mLastMotionX;
    int i = (int)paramFloat;
    mLastMotionX = (paramFloat - i + f1);
    scrollTo(i, getScrollY());
    pageScrolled(i);
    return bool1;
  }
  
  private void recomputeScrollPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!mItems.isEmpty()))
    {
      if (!mScroller.isFinished())
      {
        mScroller.setFinalX(getCurrentItem() * getClientWidth());
        return;
      }
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      scrollTo((int)(getScrollX() / (paramInt2 - k - m + paramInt4) * (paramInt1 - i - j + paramInt3)), getScrollY());
      return;
    }
    b localB = infoForPosition(mCurItem);
    float f;
    if (localB != null) {
      f = Math.min(offset, mLastOffset);
    } else {
      f = 0.0F;
    }
    paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
    if (paramInt1 != getScrollX())
    {
      completeScroll(false);
      scrollTo(paramInt1, getScrollY());
    }
  }
  
  private void removeNonDecorViews()
  {
    int j;
    for (int i = 0; i < getChildCount(); i = j + 1)
    {
      j = i;
      if (!getChildAtgetLayoutParamsisDecor)
      {
        removeViewAt(i);
        j = i - 1;
      }
    }
  }
  
  private void requestParentDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void scrollToItem(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    b localB = infoForPosition(paramInt1);
    int i;
    if (localB != null)
    {
      float f = getClientWidth();
      i = (int)(Math.max(mFirstOffset, Math.min(offset, mLastOffset)) * f);
    }
    else
    {
      i = 0;
    }
    if (paramBoolean1)
    {
      smoothScrollTo(i, 0, paramInt2);
      if (paramBoolean2) {
        dispatchOnPageSelected(paramInt1);
      }
    }
    else
    {
      if (paramBoolean2) {
        dispatchOnPageSelected(paramInt1);
      }
      completeScroll(false);
      scrollTo(i, 0);
      pageScrolled(i);
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (mScrollingCacheEnabled != paramBoolean) {
      mScrollingCacheEnabled = paramBoolean;
    }
  }
  
  private void sortChildDrawingOrder()
  {
    if (mDrawingOrder != 0)
    {
      Object localObject = mDrawingOrderedChildren;
      if (localObject == null) {
        mDrawingOrderedChildren = new ArrayList();
      } else {
        ((ArrayList)localObject).clear();
      }
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = getChildAt(i);
        mDrawingOrderedChildren.add(localObject);
        i += 1;
      }
      Collections.sort(mDrawingOrderedChildren, sPositionComparator);
    }
  }
  
  public void addFocusables(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    int j = paramArrayList.size();
    int k = getDescendantFocusability();
    if (k != 393216)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          b localB = infoForChild(localView);
          if ((localB != null) && (position == mCurItem)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if ((k != 262144) || (j == paramArrayList.size()))
    {
      if (!isFocusable()) {
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
        return;
      }
      paramArrayList.add(this);
    }
  }
  
  public b addNewItem(int paramInt1, int paramInt2)
  {
    b localB = new b();
    position = paramInt1;
    object = mAdapter.instantiateItem(this, paramInt1);
    widthFactor = mAdapter.getPageWidth(paramInt1);
    if ((paramInt2 >= 0) && (paramInt2 < mItems.size()))
    {
      mItems.add(paramInt2, localB);
      return localB;
    }
    mItems.add(localB);
    return localB;
  }
  
  public void addOnPageChangeListener(e paramE)
  {
    if (mOnPageChangeListeners == null) {
      mOnPageChangeListeners = new ArrayList();
    }
    mOnPageChangeListeners.add(paramE);
  }
  
  public void addTouchables(ArrayList paramArrayList)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localB = infoForChild(localView);
        if ((localB != null) && (position == mCurItem)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams)) {
      localLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = (LayoutParams)localLayoutParams;
    isDecor |= add(paramView);
    if (mInLayout)
    {
      if (!isDecor)
      {
        needsMeasure = true;
        addViewInLayout(paramView, paramInt, localLayoutParams);
        return;
      }
      throw new IllegalStateException("Cannot add pager decor view during layout");
    }
    super.addView(paramView, paramInt, localLayoutParams);
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView = findFocus();
    Object localObject1 = localView;
    boolean bool = false;
    Object localObject2;
    int i;
    if (localView != this)
    {
      localObject2 = localObject1;
      if (localView != null)
      {
        for (localObject2 = localView.getParent(); (localObject2 instanceof ViewGroup); localObject2 = ((ViewParent)localObject2).getParent()) {
          if (localObject2 == this)
          {
            i = 1;
            break label71;
          }
        }
        i = 0;
        label71:
        localObject2 = localObject1;
        if (i == 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localView.getClass().getSimpleName());
          for (localObject1 = localView.getParent(); (localObject1 instanceof ViewGroup); localObject1 = ((ViewParent)localObject1).getParent())
          {
            ((StringBuilder)localObject2).append(" => ");
            ((StringBuilder)localObject2).append(localObject1.getClass().getSimpleName());
          }
          localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("arrowScroll tried to find focus based on non-child current focused view ");
          ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
          ((StringBuilder)localObject1).toString();
        }
      }
    }
    else
    {
      localObject2 = null;
    }
    localObject1 = FocusFinder.getInstance().findNextFocus(this, (View)localObject2, paramInt);
    int j;
    if ((localObject1 != null) && (localObject1 != localObject2)) {
      if (paramInt == 17)
      {
        i = getChildRectInPagerCoordinatesmTempRect, (View)localObject1).left;
        j = getChildRectInPagerCoordinatesmTempRect, (View)localObject2).left;
        if ((localObject2 != null) && (i >= j)) {
          bool = pageLeft();
        } else {
          bool = ((View)localObject1).requestFocus();
        }
      }
    }
    for (;;)
    {
      break;
      if (paramInt == 66)
      {
        i = getChildRectInPagerCoordinatesmTempRect, (View)localObject1).left;
        j = getChildRectInPagerCoordinatesmTempRect, (View)localObject2).left;
        if ((localObject2 != null) && (i <= j))
        {
          bool = pageRight();
        }
        else
        {
          bool = ((View)localObject1).requestFocus();
          continue;
          if ((paramInt != 17) && (paramInt != 1))
          {
            if ((paramInt == 66) || (paramInt == 2)) {
              bool = pageRight();
            }
          }
          else {
            bool = pageLeft();
          }
        }
      }
    }
    if (bool) {
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
    }
    return bool;
  }
  
  public boolean beginFakeDrag()
  {
    if (mIsBeingDragged) {
      return false;
    }
    mFakeDragging = true;
    setScrollState(1);
    mLastMotionX = 0.0F;
    mInitialMotionX = 0.0F;
    Object localObject = mVelocityTracker;
    if (localObject == null) {
      mVelocityTracker = VelocityTracker.obtain();
    } else {
      ((VelocityTracker)localObject).clear();
    }
    long l = SystemClock.uptimeMillis();
    localObject = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
    mVelocityTracker.addMovement((MotionEvent)localObject);
    ((MotionEvent)localObject).recycle();
    mFakeDragBeginTime = l;
    return true;
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
    return (paramBoolean) && (paramView.canScrollHorizontally(-paramInt1));
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (mAdapter == null) {
      return false;
    }
    int i = getClientWidth();
    int j = getScrollX();
    if (paramInt < 0)
    {
      if (j > (int)(i * mFirstOffset)) {
        return true;
      }
    }
    else if ((paramInt > 0) && (j < (int)(i * mLastOffset))) {
      return true;
    }
    return false;
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void clearOnPageChangeListeners()
  {
    List localList = mOnPageChangeListeners;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void computeScroll()
  {
    mIsScrollStarted = true;
    if ((!mScroller.isFinished()) && (mScroller.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = mScroller.getCurrX();
      int m = mScroller.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!pageScrolled(k))
        {
          mScroller.abortAnimation();
          scrollTo(0, m);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    completeScroll(true);
  }
  
  public void dataSetChanged()
  {
    int i4 = mAdapter.getCount();
    mExpectedAdapterCount = i4;
    if ((mItems.size() < mOffscreenPageLimit * 2 + 1) && (mItems.size() < i4)) {
      i = 1;
    } else {
      i = 0;
    }
    int m = mCurItem;
    int k = 0;
    int j = 0;
    int i1 = i;
    int i = m;
    Object localObject;
    while (k < mItems.size())
    {
      localObject = (b)mItems.get(k);
      int i3 = mAdapter.getItemPosition(object);
      int n;
      int i2;
      if (i3 == -1)
      {
        m = k;
        n = i;
        i2 = j;
      }
      else
      {
        if (i3 == -2)
        {
          mItems.remove(k);
          n = k - 1;
          m = j;
          if (j == 0)
          {
            mAdapter.startUpdate(this);
            m = 1;
          }
          mAdapter.destroyItem(this, position, object);
          i1 = mCurItem;
          k = n;
          j = m;
          if (i1 == position)
          {
            i = Math.max(0, Math.min(i1, i4 - 1));
            j = m;
            k = n;
          }
        }
        for (;;)
        {
          i1 = 1;
          m = k;
          n = i;
          i2 = j;
          break;
          int i5 = position;
          m = k;
          n = i;
          i2 = j;
          if (i5 == i3) {
            break;
          }
          if (i5 == mCurItem) {
            i = i3;
          }
          position = i3;
        }
      }
      k = m + 1;
      i = n;
      j = i2;
    }
    if (j != 0) {
      mAdapter.finishUpdate(this);
    }
    Collections.sort(mItems, COMPARATOR);
    if (i1 != 0)
    {
      k = getChildCount();
      j = 0;
      while (j < k)
      {
        localObject = (LayoutParams)getChildAt(j).getLayoutParams();
        if (!isDecor) {
          widthFactor = 0.0F;
        }
        j += 1;
      }
      setCurrentItemInternal(i, false, true);
      requestLayout();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 4096) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localB = infoForChild(localView);
        if ((localB != null) && (position == mCurItem) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  public float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.47123894F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int m = getOverScrollMode();
    int k = 0;
    int i = 0;
    if (m != 0) {
      if (m == 1)
      {
        PagerAdapter localPagerAdapter = mAdapter;
        if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 1)) {}
      }
      else
      {
        mLeftEdge.finish();
        mRightEdge.finish();
        break label260;
      }
    }
    int n;
    int j;
    if (!mLeftEdge.isFinished())
    {
      k = paramCanvas.save();
      i = getHeight() - getPaddingTop() - getPaddingBottom();
      m = getWidth();
      paramCanvas.rotate(270.0F);
      n = -i;
      paramCanvas.translate(getPaddingTop() + n, mFirstOffset * m);
      mLeftEdge.setSize(i, m);
      j = false | mLeftEdge.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
    k = j;
    boolean bool;
    if (!mRightEdge.isFinished())
    {
      m = paramCanvas.save();
      k = getWidth();
      n = getHeight();
      int i1 = getPaddingTop();
      int i2 = getPaddingBottom();
      paramCanvas.rotate(90.0F);
      paramCanvas.translate(-getPaddingTop(), -(mLastOffset + 1.0F) * k);
      mRightEdge.setSize(n - i1 - i2, k);
      bool = j | mRightEdge.draw(paramCanvas);
      paramCanvas.restoreToCount(m);
    }
    label260:
    if (bool) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = mMarginDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void endFakeDrag()
  {
    if (mFakeDragging)
    {
      if (mAdapter != null)
      {
        Object localObject = mVelocityTracker;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, mMaximumVelocity);
        int i = (int)((VelocityTracker)localObject).getXVelocity(mActivePointerId);
        mPopulatePending = true;
        int j = getClientWidth();
        int k = getScrollX();
        localObject = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(position, (k / j - offset) / widthFactor, i, (int)(mLastMotionX - mInitialMotionX)), true, true, i);
      }
      endDrag();
      mFakeDragging = false;
      return;
    }
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
    {
      int i = paramKeyEvent.getKeyCode();
      if (i != 21)
      {
        if (i != 22)
        {
          if (i == 61)
          {
            if (paramKeyEvent.hasNoModifiers()) {
              return arrowScroll(2);
            }
            if (paramKeyEvent.hasModifiers(1)) {
              return arrowScroll(1);
            }
          }
        }
        else
        {
          if (paramKeyEvent.hasModifiers(2)) {
            return pageRight();
          }
          return arrowScroll(66);
        }
      }
      else
      {
        if (paramKeyEvent.hasModifiers(2)) {
          return pageLeft();
        }
        return arrowScroll(17);
      }
    }
    return false;
  }
  
  public void fakeDragBy(float paramFloat)
  {
    if (mFakeDragging)
    {
      if (mAdapter == null) {
        return;
      }
      mLastMotionX += paramFloat;
      float f2 = getScrollX() - paramFloat;
      float f3 = getClientWidth();
      paramFloat = mFirstOffset * f3;
      float f1 = mLastOffset * f3;
      Object localObject1 = (b)mItems.get(0);
      Object localObject2 = mItems;
      localObject2 = (b)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
      if (position != 0) {
        paramFloat = offset * f3;
      }
      if (position != mAdapter.getCount() - 1) {
        f1 = offset * f3;
      }
      if (f2 >= paramFloat)
      {
        paramFloat = f2;
        if (f2 > f1) {
          paramFloat = f1;
        }
      }
      f1 = mLastMotionX;
      int i = (int)paramFloat;
      mLastMotionX = (paramFloat - i + f1);
      scrollTo(i, getScrollY());
      pageScrolled(i);
      long l = SystemClock.uptimeMillis();
      localObject1 = MotionEvent.obtain(mFakeDragBeginTime, l, 2, mLastMotionX, 0.0F, 0);
      mVelocityTracker.addMovement((MotionEvent)localObject1);
      ((MotionEvent)localObject1).recycle();
      return;
    }
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
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
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter()
  {
    return mAdapter;
  }
  
  public void getAdapter(d paramD)
  {
    List localList = mGroups;
    if (localList != null) {
      localList.remove(paramD);
    }
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (mDrawingOrder == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    return mDrawingOrderedChildren.get(i)).getLayoutParams()).childIndex;
  }
  
  public int getCurrentItem()
  {
    return mCurItem;
  }
  
  public int getOffscreenPageLimit()
  {
    return mOffscreenPageLimit;
  }
  
  public int getPageMargin()
  {
    return mPageMargin;
  }
  
  public b infoForAnyChild(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break label34;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        break;
      }
      paramView = (View)localViewParent;
    }
    return null;
    label34:
    return infoForChild(paramView);
  }
  
  public b infoForChild(View paramView)
  {
    int i = 0;
    while (i < mItems.size())
    {
      b localB = (b)mItems.get(i);
      if (mAdapter.isViewFromObject(paramView, object)) {
        return localB;
      }
      i += 1;
    }
    return null;
  }
  
  public b infoForPosition(int paramInt)
  {
    int i = 0;
    while (i < mItems.size())
    {
      b localB = (b)mItems.get(i);
      if (position == paramInt) {
        return localB;
      }
      i += 1;
    }
    return null;
  }
  
  public void initViewPager()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    mScroller = new Scroller(localContext, sInterpolator);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f = getResourcesgetDisplayMetricsdensity;
    mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
    mMinimumVelocity = ((int)(400.0F * f));
    mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    mLeftEdge = new EdgeEffect(localContext);
    mRightEdge = new EdgeEffect(localContext);
    mFlingDistance = ((int)(25.0F * f));
    mCloseEnough = ((int)(2.0F * f));
    mDefaultGutterSize = ((int)(f * 16.0F));
    ViewCompat.setAccessibilityDelegate(this, new c());
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    ViewCompat.setBackground(this, new ViewPager.4(this));
  }
  
  public boolean isFakeDragging()
  {
    return mFakeDragging;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    mFirstLayout = true;
  }
  
  public void onDetachedFromWindow()
  {
    removeCallbacks(mEndScrollRunnable);
    Scroller localScroller = mScroller;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      mScroller.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((mPageMargin > 0) && (mMarginDrawable != null) && (mItems.size() > 0) && (mAdapter != null))
    {
      int k = getScrollX();
      int m = getWidth();
      float f1 = mPageMargin;
      float f3 = m;
      float f4 = f1 / f3;
      Object localObject = mItems;
      int j = 0;
      localObject = (b)((ArrayList)localObject).get(0);
      f1 = offset;
      int n = mItems.size();
      int i = position;
      int i1 = mItems.get(n - 1)).position;
      while (i < i1)
      {
        while ((i > position) && (j < n))
        {
          localObject = mItems;
          j += 1;
          localObject = (b)((ArrayList)localObject).get(j);
        }
        float f5;
        float f2;
        if (i == position)
        {
          f1 = offset;
          f5 = widthFactor;
          f2 = (f1 + f5) * f3;
          f1 = f1 + f5 + f4;
        }
        else
        {
          f5 = mAdapter.getPageWidth(i);
          f2 = (f1 + f5) * f3;
          f1 = f5 + f4 + f1;
        }
        if (mPageMargin + f2 > k)
        {
          mMarginDrawable.setBounds(Math.round(f2), mTopPageBounds, Math.round(mPageMargin + f2), mBottomPageBounds);
          mMarginDrawable.draw(paramCanvas);
        }
        if (f2 > k + m) {
          return;
        }
        i += 1;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i != 3) && (i != 1))
    {
      if (i != 0)
      {
        if (mIsBeingDragged) {
          return true;
        }
        if (mIsUnableToDrag) {
          return false;
        }
      }
      float f1;
      if (i != 0)
      {
        if (i != 2)
        {
          if (i == 6) {
            onSecondaryPointerUp(paramMotionEvent);
          }
        }
        else
        {
          i = mActivePointerId;
          if (i != -1)
          {
            i = paramMotionEvent.findPointerIndex(i);
            float f2 = paramMotionEvent.getX(i);
            f1 = f2 - mLastMotionX;
            float f4 = Math.abs(f1);
            float f3 = paramMotionEvent.getY(i);
            float f5 = Math.abs(f3 - mInitialMotionY);
            if ((f1 != 0.0F) && (!isGutterDrag(mLastMotionX, f1)) && (canScroll(this, false, (int)f1, (int)f2, (int)f3)))
            {
              mLastMotionX = f2;
              mLastMotionY = f3;
              mIsUnableToDrag = true;
              return false;
            }
            if ((f4 > mTouchSlop) && (f4 * 0.5F > f5))
            {
              mIsBeingDragged = true;
              requestParentDisallowInterceptTouchEvent(true);
              setScrollState(1);
              if (f1 > 0.0F) {
                f1 = mInitialMotionX + mTouchSlop;
              } else {
                f1 = mInitialMotionX - mTouchSlop;
              }
              mLastMotionX = f1;
              mLastMotionY = f3;
              setScrollingCacheEnabled(true);
            }
            else if (f5 > mTouchSlop)
            {
              mIsUnableToDrag = true;
            }
            if ((mIsBeingDragged) && (performDrag(f2))) {
              ViewCompat.postInvalidateOnAnimation(this);
            }
          }
        }
      }
      else
      {
        f1 = paramMotionEvent.getX();
        mInitialMotionX = f1;
        mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        mInitialMotionY = f1;
        mLastMotionY = f1;
        mActivePointerId = paramMotionEvent.getPointerId(0);
        mIsUnableToDrag = false;
        mIsScrollStarted = true;
        mScroller.computeScrollOffset();
        if ((mScrollState == 2) && (Math.abs(mScroller.getFinalX() - mScroller.getCurrX()) > mCloseEnough))
        {
          mScroller.abortAnimation();
          mPopulatePending = false;
          populate();
          mIsBeingDragged = true;
          requestParentDisallowInterceptTouchEvent(true);
          setScrollState(1);
        }
        else
        {
          completeScroll(false);
          mIsBeingDragged = false;
        }
      }
      if (mVelocityTracker == null) {
        mVelocityTracker = VelocityTracker.obtain();
      }
      mVelocityTracker.addMovement(paramMotionEvent);
      return mIsBeingDragged;
    }
    onTouchEvent();
    return false;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = getChildCount();
    int i4 = paramInt3 - paramInt1;
    int i5 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int j = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int i6 = getScrollX();
    int k = 0;
    int m = 0;
    View localView;
    int i;
    LayoutParams localLayoutParams;
    while (m < i3)
    {
      localView = getChildAt(m);
      i = paramInt2;
      int i2 = j;
      int i1 = k;
      int n = paramInt4;
      paramInt3 = paramInt1;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = paramInt2;
        i2 = j;
        i1 = k;
        n = paramInt4;
        paramInt3 = paramInt1;
        if (isDecor)
        {
          i = gravity;
          paramInt3 = i & 0x7;
          n = i & 0x70;
          if (paramInt3 != 1)
          {
            if (paramInt3 != 3)
            {
              if (paramInt3 != 5)
              {
                paramInt3 = paramInt2;
                i = paramInt2;
              }
              else
              {
                paramInt3 = i4 - j - localView.getMeasuredWidth();
                j += localView.getMeasuredWidth();
                i = paramInt2;
              }
            }
            else
            {
              i = localView.getMeasuredWidth();
              paramInt3 = paramInt2;
              i += paramInt2;
            }
          }
          else
          {
            paramInt3 = Math.max((i4 - localView.getMeasuredWidth()) / 2, paramInt2);
            i = paramInt2;
          }
          if (n != 16)
          {
            if (n != 48)
            {
              if (n != 80)
              {
                paramInt2 = paramInt1;
              }
              else
              {
                paramInt2 = i5 - paramInt4 - localView.getMeasuredHeight();
                paramInt4 += localView.getMeasuredHeight();
              }
            }
            else
            {
              n = localView.getMeasuredHeight();
              paramInt2 = paramInt1;
              paramInt1 = n + paramInt1;
            }
          }
          else {
            paramInt2 = Math.max((i5 - localView.getMeasuredHeight()) / 2, paramInt1);
          }
          paramInt3 += i6;
          localView.layout(paramInt3, paramInt2, localView.getMeasuredWidth() + paramInt3, localView.getMeasuredHeight() + paramInt2);
          i1 = k + 1;
          paramInt3 = paramInt1;
          n = paramInt4;
          i2 = j;
        }
      }
      m += 1;
      paramInt2 = i;
      j = i2;
      k = i1;
      paramInt4 = n;
      paramInt1 = paramInt3;
    }
    paramInt3 = 0;
    while (paramInt3 < i3)
    {
      localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!isDecor)
        {
          b localB = infoForChild(localView);
          if (localB != null)
          {
            float f = i4 - paramInt2 - j;
            i = (int)(offset * f) + paramInt2;
            if (needsMeasure)
            {
              needsMeasure = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(f * widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec(i5 - paramInt1 - paramInt4, 1073741824));
            }
            localView.layout(i, paramInt1, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
    mTopPageBounds = paramInt1;
    mBottomPageBounds = (i5 - paramInt4);
    mDecorChildCount = k;
    if (mFirstLayout) {
      scrollToItem(mCurItem, false, 0, false);
    }
    mFirstLayout = false;
  }
  
  public void onLayout(boolean paramBoolean, f paramF)
  {
    populate(paramBoolean, paramF, 2);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = 0;
    setMeasuredDimension(View.getDefaultSize(0, paramInt1), View.getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    mGutterSize = Math.min(paramInt1 / 10, mDefaultGutterSize);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i6 = getChildCount();
    int k = 0;
    View localView;
    LayoutParams localLayoutParams;
    for (;;)
    {
      int i1 = 1;
      int i3 = 1073741824;
      if (k >= i6) {
        break;
      }
      localView = getChildAt(k);
      i = paramInt2;
      int j = paramInt1;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = paramInt2;
        j = paramInt1;
        if (localLayoutParams != null)
        {
          i = paramInt2;
          j = paramInt1;
          if (isDecor)
          {
            j = gravity;
            i = j & 0x7;
            j &= 0x70;
            int n;
            if ((j != 48) && (j != 80)) {
              n = 0;
            } else {
              n = 1;
            }
            int m = i1;
            if (i != 3) {
              if (i == 5) {
                m = i1;
              } else {
                m = 0;
              }
            }
            i = Integer.MIN_VALUE;
            if (n != 0)
            {
              j = 1073741824;
            }
            else
            {
              j = i;
              if (m != 0)
              {
                i1 = 1073741824;
                j = i;
                i = i1;
                break label257;
              }
            }
            i = Integer.MIN_VALUE;
            label257:
            i1 = width;
            int i2;
            if (i1 != -2)
            {
              if (i1 != -1) {
                j = i1;
              } else {
                j = paramInt1;
              }
              i1 = 1073741824;
              i2 = j;
            }
            else
            {
              i2 = paramInt1;
              i1 = j;
            }
            int i5 = height;
            if (i5 != -2)
            {
              if (i5 != -1)
              {
                j = i3;
                i = i5;
              }
              else
              {
                i = paramInt2;
                j = i3;
              }
            }
            else
            {
              j = paramInt2;
              i3 = i;
              i = j;
              j = i3;
            }
            localView.measure(View.MeasureSpec.makeMeasureSpec(i2, i1), View.MeasureSpec.makeMeasureSpec(i, j));
            if (n != 0)
            {
              i = paramInt2 - localView.getMeasuredHeight();
              j = paramInt1;
            }
            else
            {
              i = paramInt2;
              j = paramInt1;
              if (m != 0)
              {
                j = paramInt1 - localView.getMeasuredWidth();
                i = paramInt2;
              }
            }
          }
        }
      }
      k += 1;
      paramInt2 = i;
      paramInt1 = j;
    }
    mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    mInLayout = true;
    populate();
    mInLayout = false;
    int i = getChildCount();
    paramInt2 = i4;
    while (paramInt2 < i)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams == null) || (!isDecor)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * widthFactor), 1073741824), mChildHeightMeasureSpec);
        }
      }
      paramInt2 += 1;
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i = mDecorChildCount;
    int i1 = 0;
    View localView;
    if (i > 0)
    {
      int i2 = getScrollX();
      i = getPaddingLeft();
      int j = getPaddingRight();
      int i3 = getWidth();
      int i4 = getChildCount();
      int m = 0;
      while (m < i4)
      {
        localView = getChildAt(m);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (isDecor)
        {
          int k = gravity & 0x7;
          if (k != 1)
          {
            int n;
            if (k != 3)
            {
              if (k != 5)
              {
                n = i;
                k = i;
                i = n;
              }
              else
              {
                k = i3 - j - localView.getMeasuredWidth();
                j += localView.getMeasuredWidth();
              }
            }
            else
            {
              n = localView.getWidth() + i;
              k = i;
              i = n;
            }
          }
          else
          {
            k = Math.max((i3 - localView.getMeasuredWidth()) / 2, i);
          }
          k = k + i2 - localView.getLeft();
          if (k != 0) {
            localView.offsetLeftAndRight(k);
          }
        }
        m += 1;
      }
    }
    dispatchOnPageScrolled(paramInt1, paramFloat, paramInt2);
    if (mPageTransformer != null)
    {
      paramInt2 = getScrollX();
      i = getChildCount();
      paramInt1 = i1;
      while (paramInt1 < i)
      {
        localView = getChildAt(paramInt1);
        if (!getLayoutParamsisDecor)
        {
          paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
          mPageTransformer.transformPage(localView, paramFloat);
        }
        paramInt1 += 1;
      }
    }
    mCalledSuper = true;
  }
  
  public boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i = getChildCount();
    int j = -1;
    int k;
    if ((paramInt & 0x2) != 0)
    {
      j = i;
      i = 0;
      k = 1;
    }
    else
    {
      i -= 1;
      k = -1;
    }
    while (i != j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localB = infoForChild(localView);
        if ((localB != null) && (position == mCurItem) && (localView.requestFocus(paramInt, paramRect))) {
          return true;
        }
      }
      i += k;
    }
    return false;
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
    PagerAdapter localPagerAdapter = mAdapter;
    if (localPagerAdapter != null)
    {
      localPagerAdapter.restoreState(adapterState, loader);
      setCurrentItemInternal(position, false, true);
      return;
    }
    mRestoredCurItem = position;
    mRestoredAdapterState = adapterState;
    mRestoredClassLoader = loader;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    position = mCurItem;
    PagerAdapter localPagerAdapter = mAdapter;
    if (localPagerAdapter != null) {
      adapterState = localPagerAdapter.saveState();
    }
    return localSavedState;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      paramInt2 = mPageMargin;
      recomputeScrollPosition(paramInt1, paramInt3, paramInt2, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (mFakeDragging) {
      return true;
    }
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    if ((i == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    Object localObject = mAdapter;
    if (localObject != null)
    {
      if (((PagerAdapter)localObject).getCount() == 0) {
        return false;
      }
      if (mVelocityTracker == null) {
        mVelocityTracker = VelocityTracker.obtain();
      }
      mVelocityTracker.addMovement(paramMotionEvent);
      i = paramMotionEvent.getAction() & 0xFF;
      float f1;
      if (i != 0)
      {
        float f2;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 5)
              {
                if (i == 6)
                {
                  onSecondaryPointerUp(paramMotionEvent);
                  mLastMotionX = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(mActivePointerId));
                }
              }
              else
              {
                i = paramMotionEvent.getActionIndex();
                mLastMotionX = paramMotionEvent.getX(i);
                mActivePointerId = paramMotionEvent.getPointerId(i);
              }
            }
            else if (mIsBeingDragged)
            {
              scrollToItem(mCurItem, true, 0, false);
              bool = onTouchEvent();
            }
          }
          else
          {
            if (!mIsBeingDragged)
            {
              i = paramMotionEvent.findPointerIndex(mActivePointerId);
              if (i == -1)
              {
                bool = onTouchEvent();
                break label601;
              }
              f1 = paramMotionEvent.getX(i);
              float f3 = Math.abs(f1 - mLastMotionX);
              f2 = paramMotionEvent.getY(i);
              float f4 = Math.abs(f2 - mLastMotionY);
              if ((f3 > mTouchSlop) && (f3 > f4))
              {
                mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                f3 = mInitialMotionX;
                if (f1 - f3 > 0.0F) {
                  f1 = f3 + mTouchSlop;
                } else {
                  f1 = f3 - mTouchSlop;
                }
                mLastMotionX = f1;
                mLastMotionY = f2;
                setScrollState(1);
                setScrollingCacheEnabled(true);
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
              }
            }
            if (mIsBeingDragged) {
              bool = false | performDrag(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(mActivePointerId)));
            }
          }
        }
        else if (mIsBeingDragged)
        {
          localObject = mVelocityTracker;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, mMaximumVelocity);
          i = (int)((VelocityTracker)localObject).getXVelocity(mActivePointerId);
          mPopulatePending = true;
          int j = getClientWidth();
          int k = getScrollX();
          localObject = infoForCurrentScrollPosition();
          f2 = mPageMargin;
          f1 = j;
          f2 /= f1;
          setCurrentItemInternal(determineTargetPage(position, (k / f1 - offset) / (widthFactor + f2), i, (int)(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(mActivePointerId)) - mInitialMotionX)), true, true, i);
          bool = onTouchEvent();
        }
      }
      else
      {
        mScroller.abortAnimation();
        mPopulatePending = false;
        populate();
        f1 = paramMotionEvent.getX();
        mInitialMotionX = f1;
        mLastMotionX = f1;
        f1 = paramMotionEvent.getY();
        mInitialMotionY = f1;
        mLastMotionY = f1;
        mActivePointerId = paramMotionEvent.getPointerId(0);
      }
      label601:
      if (bool)
      {
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  public boolean pageLeft()
  {
    int i = mCurItem;
    if (i > 0)
    {
      setCurrentItem(i - 1, true);
      return true;
    }
    return false;
  }
  
  public boolean pageRight()
  {
    PagerAdapter localPagerAdapter = mAdapter;
    if ((localPagerAdapter != null) && (mCurItem < localPagerAdapter.getCount() - 1))
    {
      setCurrentItem(mCurItem + 1, true);
      return true;
    }
    return false;
  }
  
  public void populate()
  {
    populate(mCurItem);
  }
  
  public void populate(int paramInt)
  {
    int i = mCurItem;
    Object localObject2;
    if (i != paramInt)
    {
      localObject2 = infoForPosition(i);
      mCurItem = paramInt;
    }
    else
    {
      localObject2 = null;
    }
    if (mAdapter == null)
    {
      sortChildDrawingOrder();
      return;
    }
    if (mPopulatePending)
    {
      sortChildDrawingOrder();
      return;
    }
    if (getWindowToken() == null) {
      return;
    }
    mAdapter.startUpdate(this);
    paramInt = mOffscreenPageLimit;
    int i2 = Math.max(0, mCurItem - paramInt);
    int n = mAdapter.getCount();
    int i1 = Math.min(n - 1, mCurItem + paramInt);
    Object localObject1;
    if (n == mExpectedAdapterCount)
    {
      int j = 0;
      while (j < mItems.size())
      {
        localObject1 = (b)mItems.get(j);
        paramInt = position;
        i = mCurItem;
        if (paramInt >= i)
        {
          if (paramInt != i) {
            break;
          }
          break label189;
        }
        j += 1;
      }
      localObject1 = null;
      label189:
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (n > 0) {
          localObject3 = addNewItem(mCurItem, j);
        }
      }
      if (localObject3 != null)
      {
        int k = j - 1;
        if (k >= 0) {
          localObject1 = (b)mItems.get(k);
        } else {
          localObject1 = null;
        }
        int i3 = getClientWidth();
        float f3;
        if (i3 <= 0) {
          f3 = 0.0F;
        } else {
          f3 = 2.0F - widthFactor + getPaddingLeft() / i3;
        }
        int m = mCurItem - 1;
        float f2 = 0.0F;
        Object localObject4 = localObject1;
        while (m >= 0)
        {
          if ((f2 >= f3) && (m < i2))
          {
            if (localObject4 == null) {
              break;
            }
            paramInt = j;
            i = k;
            localObject1 = localObject4;
            f1 = f2;
            if (m != position) {
              break label587;
            }
            paramInt = j;
            i = k;
            localObject1 = localObject4;
            f1 = f2;
            if (scrolling) {
              break label587;
            }
            mItems.remove(k);
            mAdapter.destroyItem(this, m, object);
            k -= 1;
            j -= 1;
            paramInt = j;
            i = k;
            f1 = f2;
            if (k >= 0)
            {
              localObject1 = (b)mItems.get(k);
              paramInt = j;
              i = k;
              f1 = f2;
              break label587;
            }
          }
          else if ((localObject4 != null) && (m == position))
          {
            f2 += widthFactor;
            k -= 1;
            paramInt = j;
            i = k;
            f1 = f2;
            if (k >= 0)
            {
              localObject1 = (b)mItems.get(k);
              paramInt = j;
              i = k;
              f1 = f2;
              break label587;
            }
          }
          else
          {
            f2 += addNewItem1widthFactor;
            j += 1;
            paramInt = j;
            i = k;
            f1 = f2;
            if (k >= 0)
            {
              localObject1 = (b)mItems.get(k);
              paramInt = j;
              i = k;
              f1 = f2;
              break label587;
            }
          }
          localObject1 = null;
          label587:
          m -= 1;
          j = paramInt;
          k = i;
          localObject4 = localObject1;
          f2 = f1;
        }
        float f1 = widthFactor;
        paramInt = j + 1;
        if (f1 < 2.0F)
        {
          if (paramInt < mItems.size()) {
            localObject1 = (b)mItems.get(paramInt);
          } else {
            localObject1 = null;
          }
          if (i3 <= 0) {
            f3 = 0.0F;
          } else {
            f3 = getPaddingRight() / i3 + 2.0F;
          }
          i = mCurItem;
          for (;;)
          {
            k = i + 1;
            if (k >= n) {
              break;
            }
            if ((f1 >= f3) && (k > i1))
            {
              if (localObject1 == null) {
                break;
              }
              i = k;
              if (k != position) {
                continue;
              }
              i = k;
              if (scrolling) {
                continue;
              }
              mItems.remove(paramInt);
              mAdapter.destroyItem(this, k, object);
              i = paramInt;
              f2 = f1;
              if (paramInt < mItems.size())
              {
                localObject1 = (b)mItems.get(paramInt);
                i = k;
              }
            }
            else if ((localObject1 != null) && (k == position))
            {
              f1 += widthFactor;
              paramInt += 1;
              i = paramInt;
              f2 = f1;
              if (paramInt < mItems.size())
              {
                localObject1 = (b)mItems.get(paramInt);
                i = k;
              }
            }
            else
            {
              localObject1 = addNewItem(k, paramInt);
              paramInt += 1;
              f1 += widthFactor;
              i = paramInt;
              f2 = f1;
              if (paramInt < mItems.size())
              {
                localObject1 = (b)mItems.get(paramInt);
                i = k;
                continue;
              }
            }
            localObject1 = null;
            paramInt = i;
            i = k;
            f1 = f2;
          }
        }
        calculatePageOffsets((b)localObject3, j, (b)localObject2);
        mAdapter.setPrimaryItem(this, mCurItem, object);
      }
      mAdapter.finishUpdate(this);
      i = getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = getChildAt(paramInt);
        localObject1 = (LayoutParams)((View)localObject2).getLayoutParams();
        childIndex = paramInt;
        if ((!isDecor) && (widthFactor == 0.0F))
        {
          localObject2 = infoForChild((View)localObject2);
          if (localObject2 != null)
          {
            widthFactor = widthFactor;
            position = position;
          }
        }
        paramInt += 1;
      }
      sortChildDrawingOrder();
      if (hasFocus())
      {
        localObject1 = findFocus();
        if (localObject1 != null) {
          localObject1 = infoForAnyChild((View)localObject1);
        } else {
          localObject1 = null;
        }
        if ((localObject1 != null) && (position == mCurItem)) {
          return;
        }
        paramInt = 0;
        while (paramInt < getChildCount())
        {
          localObject1 = getChildAt(paramInt);
          localObject2 = infoForChild((View)localObject1);
          if ((localObject2 != null) && (position == mCurItem) && (((View)localObject1).requestFocus(2))) {
            return;
          }
          paramInt += 1;
        }
      }
    }
    else
    {
      try
      {
        localObject1 = getResources().getResourceName(getId());
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;) {}
      }
      localObject1 = Integer.toHexString(getId());
      localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
      ((StringBuilder)localObject2).append(mExpectedAdapterCount);
      ((StringBuilder)localObject2).append(", found: ");
      ((StringBuilder)localObject2).append(n);
      ((StringBuilder)localObject2).append(" Pager id: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" Pager class: ");
      ((StringBuilder)localObject2).append(getClass());
      ((StringBuilder)localObject2).append(" Problematic adapter: ");
      ((StringBuilder)localObject2).append(mAdapter.getClass());
      localObject1 = new IllegalStateException(((StringBuilder)localObject2).toString());
      throw ((Throwable)localObject1);
    }
  }
  
  public void populate(boolean paramBoolean, f paramF, int paramInt)
  {
    int j = 1;
    boolean bool1;
    if (paramF != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (mPageTransformer != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int i;
    if (bool1 != bool2) {
      i = 1;
    } else {
      i = 0;
    }
    mPageTransformer = paramF;
    setChildrenDrawingOrderEnabled(bool1);
    if (bool1)
    {
      if (paramBoolean) {
        j = 2;
      }
      mDrawingOrder = j;
      position = paramInt;
    }
    else
    {
      mDrawingOrder = 0;
    }
    if (i != 0) {
      populate();
    }
  }
  
  public void removeOnPageChangeListener(e paramE)
  {
    List localList = mOnPageChangeListeners;
    if (localList != null) {
      localList.remove(paramE);
    }
  }
  
  public void removeView(View paramView)
  {
    if (mInLayout)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void scrollToItem(int paramInt1, int paramInt2)
  {
    smoothScrollTo(paramInt1, paramInt2, 0);
  }
  
  public void setAdapter(d paramD)
  {
    if (mGroups == null) {
      mGroups = new ArrayList();
    }
    mGroups.add(paramD);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    Object localObject = mAdapter;
    int j = 0;
    int i;
    if (localObject != null)
    {
      ((PagerAdapter)localObject).setViewPagerObserver(null);
      mAdapter.startUpdate(this);
      i = 0;
      while (i < mItems.size())
      {
        localObject = (b)mItems.get(i);
        mAdapter.destroyItem(this, position, object);
        i += 1;
      }
      mAdapter.finishUpdate(this);
      mItems.clear();
      removeNonDecorViews();
      mCurItem = 0;
      scrollTo(0, 0);
    }
    localObject = mAdapter;
    mAdapter = paramPagerAdapter;
    mExpectedAdapterCount = 0;
    if (mAdapter != null)
    {
      if (mObserver == null) {
        mObserver = new g();
      }
      mAdapter.setViewPagerObserver(mObserver);
      mPopulatePending = false;
      boolean bool = mFirstLayout;
      mFirstLayout = true;
      mExpectedAdapterCount = mAdapter.getCount();
      if (mRestoredCurItem >= 0)
      {
        mAdapter.restoreState(mRestoredAdapterState, mRestoredClassLoader);
        setCurrentItemInternal(mRestoredCurItem, false, true);
        mRestoredCurItem = -1;
        mRestoredAdapterState = null;
        mRestoredClassLoader = null;
      }
      else if (!bool)
      {
        populate();
      }
      else
      {
        requestLayout();
      }
    }
    List localList = mGroups;
    if ((localList != null) && (!localList.isEmpty()))
    {
      int k = mGroups.size();
      i = j;
      while (i < k)
      {
        ((d)mGroups.get(i)).onAdapterChanged(this, (PagerAdapter)localObject, paramPagerAdapter);
        i += 1;
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    mPopulatePending = false;
    setCurrentItemInternal(paramInt, mFirstLayout ^ true, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    mPopulatePending = false;
    setCurrentItemInternal(paramInt, paramBoolean, false);
  }
  
  public void setCurrentItemInternal(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    setCurrentItemInternal(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  public void setCurrentItemInternal(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    PagerAdapter localPagerAdapter = mAdapter;
    if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 0))
    {
      if ((!paramBoolean2) && (mCurItem == paramInt1) && (mItems.size() != 0))
      {
        setScrollingCacheEnabled(false);
        return;
      }
      paramBoolean2 = true;
      int i;
      if (paramInt1 < 0)
      {
        i = 0;
      }
      else
      {
        i = paramInt1;
        if (paramInt1 >= mAdapter.getCount()) {
          i = mAdapter.getCount() - 1;
        }
      }
      paramInt1 = mOffscreenPageLimit;
      int j = mCurItem;
      if ((i > j + paramInt1) || (i < j - paramInt1))
      {
        paramInt1 = 0;
        while (paramInt1 < mItems.size())
        {
          mItems.get(paramInt1)).scrolling = true;
          paramInt1 += 1;
        }
      }
      if (mCurItem == i) {
        paramBoolean2 = false;
      }
      if (mFirstLayout)
      {
        mCurItem = i;
        if (paramBoolean2) {
          dispatchOnPageSelected(i);
        }
        requestLayout();
        return;
      }
      populate(i);
      scrollToItem(i, paramBoolean1, paramInt2, paramBoolean2);
      return;
    }
    setScrollingCacheEnabled(false);
  }
  
  public e setInternalPageChangeListener(e paramE)
  {
    e localE = mInternalPageChangeListener;
    mInternalPageChangeListener = paramE;
    return localE;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Requested offscreen page limit ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" too small; defaulting to ");
      localStringBuilder.append(1);
      localStringBuilder.toString();
      i = 1;
    }
    if (i != mOffscreenPageLimit)
    {
      mOffscreenPageLimit = i;
      populate();
    }
  }
  
  public void setOnPageChangeListener(e paramE)
  {
    mOnPageChangeListener = paramE;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i = mPageMargin;
    mPageMargin = paramInt;
    int j = getWidth();
    recomputeScrollPosition(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    mMarginDrawable = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    boolean bool;
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    }
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setScrollState(int paramInt)
  {
    if (mScrollState == paramInt) {
      return;
    }
    mScrollState = paramInt;
    if (mPageTransformer != null)
    {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      enableLayers(bool);
    }
    dispatchOnScrollStateChanged(paramInt);
  }
  
  public void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    Scroller localScroller = mScroller;
    int i;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (mIsScrollStarted) {
        i = mScroller.getCurrX();
      } else {
        i = mScroller.getStartX();
      }
      mScroller.abortAnimation();
      setScrollingCacheEnabled(false);
    }
    else
    {
      i = getScrollX();
    }
    int j = getScrollY();
    int k = paramInt1 - i;
    paramInt2 -= j;
    if ((k == 0) && (paramInt2 == 0))
    {
      completeScroll(false);
      populate();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int m = paramInt1 / 2;
    float f2 = Math.abs(k);
    float f1 = paramInt1;
    float f3 = Math.min(1.0F, f2 * 1.0F / f1);
    f2 = m;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt1 = Math.abs(paramInt3);
    if (paramInt1 > 0)
    {
      paramInt1 = Math.round(Math.abs((f3 * f2 + f2) / paramInt1) * 1000.0F) * 4;
    }
    else
    {
      f2 = mAdapter.getPageWidth(mCurItem);
      paramInt1 = (int)((Math.abs(k) / (f2 * f1 + mPageMargin) + 1.0F) * 100.0F);
    }
    paramInt1 = Math.min(paramInt1, 600);
    mIsScrollStarted = false;
    mScroller.startScroll(i, j, k, paramInt2, paramInt1);
    ViewCompat.postInvalidateOnAnimation(this);
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == mMarginDrawable);
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public int childIndex;
    public int gravity;
    public boolean isDecor;
    public boolean needsMeasure;
    public int position;
    public float widthFactor = 0.0F;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.LAYOUT_ATTRS);
      gravity = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new DiscreteSeekBar.CustomState.1();
    public Parcelable adapterState;
    public ClassLoader loader;
    public int position;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = SavedState.class.getClassLoader();
      }
      position = paramParcel.readInt();
      adapterState = paramParcel.readParcelable(localClassLoader);
      loader = localClassLoader;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("FragmentPager.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" position=");
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, position, "}");
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(mSuperState, paramInt);
      paramParcel.writeInt(position);
      paramParcel.writeParcelable(adapterState, paramInt);
    }
  }
  
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface a {}
  
  public static class b
  {
    public Object object;
    public float offset;
    public int position;
    public boolean scrolling;
    public float widthFactor;
    
    public b() {}
  }
  
  public class c
    extends AccessibilityDelegateCompat
  {
    public c() {}
    
    private boolean canScroll()
    {
      PagerAdapter localPagerAdapter = mAdapter;
      return (localPagerAdapter != null) && (localPagerAdapter.getCount() > 1);
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AccessibilityDelegateCompat.DEFAULT_DELEGATE.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ViewPager.class.getName());
      paramAccessibilityEvent.setScrollable(canScroll());
      if (paramAccessibilityEvent.getEventType() == 4096)
      {
        paramView = mAdapter;
        if (paramView != null)
        {
          paramAccessibilityEvent.setItemCount(paramView.getCount());
          paramAccessibilityEvent.setFromIndex(mCurItem);
          paramAccessibilityEvent.setToIndex(mCurItem);
        }
      }
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
      paramAccessibilityNodeInfoCompat.setScrollable(canScroll());
      if (canScrollHorizontally(1)) {
        paramAccessibilityNodeInfoCompat.addAction(4096);
      }
      if (canScrollHorizontally(-1)) {
        paramAccessibilityNodeInfoCompat.addAction(8192);
      }
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      if (paramInt != 4096)
      {
        if (paramInt != 8192) {
          return false;
        }
        if (canScrollHorizontally(-1))
        {
          paramView = ViewPager.this;
          paramView.setCurrentItem(mCurItem - 1);
          return true;
        }
        return false;
      }
      if (canScrollHorizontally(1))
      {
        paramView = ViewPager.this;
        paramView.setCurrentItem(mCurItem + 1);
        return true;
      }
      return false;
    }
  }
  
  public static abstract interface d
  {
    public abstract void onAdapterChanged(ViewPager paramViewPager, PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2);
  }
  
  public static abstract interface e
  {
    public abstract void onPageScrollStateChanged(int paramInt);
    
    public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void onPageSelected(int paramInt);
  }
  
  public static abstract interface f
  {
    public abstract void transformPage(View paramView, float paramFloat);
  }
  
  private class g
    extends DataSetObserver
  {
    public g() {}
    
    public void onChanged()
    {
      dataSetChanged();
    }
    
    public void onInvalidated()
    {
      dataSetChanged();
    }
  }
  
  public static class h
    implements ViewPager.e
  {
    public h() {}
    
    public void onPageScrollStateChanged(int paramInt) {}
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt) {}
  }
  
  public static class i
    implements Comparator<View>
  {
    public i() {}
    
    public int compare(View paramView1, View paramView2)
    {
      paramView1 = (ViewPager.LayoutParams)paramView1.getLayoutParams();
      paramView2 = (ViewPager.LayoutParams)paramView2.getLayoutParams();
      boolean bool = isDecor;
      if (bool != isDecor)
      {
        if (bool) {
          return 1;
        }
        return -1;
      }
      return position - position;
    }
  }
}
