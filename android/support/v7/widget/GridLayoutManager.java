package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;
import support.android.v4.view.accessibility.AccessibilityNodeInfoCompat;
import support.android.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;

public class GridLayoutManager
  extends LinearLayoutManager
{
  public static final boolean DEBUG = false;
  public static final int DEFAULT_SPAN_COUNT = -1;
  public static final String TAG = "GridLayoutManager";
  public int[] mCachedBorders;
  public final Rect mDecorInsets = new Rect();
  public boolean mPendingSpanCountChange = false;
  public final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
  public final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
  public View[] mSet;
  public int mSpanCount = -1;
  public SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();
  
  public GridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext, 1, false);
    setSpanCount(paramInt);
  }
  
  public GridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt2, paramBoolean);
    setSpanCount(paramInt1);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setSpanCount(getPropertiesspanCount);
  }
  
  private void assignSpans(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 0;
    paramInt2 = -1;
    int i;
    if (paramBoolean)
    {
      int k = 0;
      i = 1;
      paramInt2 = paramInt1;
      paramInt1 = k;
    }
    else
    {
      paramInt1 -= 1;
      i = -1;
    }
    while (paramInt1 != paramInt2)
    {
      View localView = mSet[paramInt1];
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      mSpanSize = getSpanSize(paramRecycler, paramState, getPosition(localView));
      mSpanIndex = j;
      j += mSpanSize;
      paramInt1 += i;
    }
  }
  
  private void cachePreLayoutSpanMapping()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
      int k = localLayoutParams.getViewLayoutPosition();
      mPreLayoutSpanSizeCache.put(k, localLayoutParams.getSpanSize());
      mPreLayoutSpanIndexCache.put(k, localLayoutParams.getSpanIndex());
      i += 1;
    }
  }
  
  private void calculateItemBorders(int paramInt)
  {
    mCachedBorders = calculateItemBorders(mCachedBorders, mSpanCount, paramInt);
  }
  
  public static int[] calculateItemBorders(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int j = 1;
    int[] arrayOfInt;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length == paramInt1 + 1))
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt[(paramArrayOfInt.length - 1)] == paramInt2) {}
    }
    else
    {
      arrayOfInt = new int[paramInt1 + 1];
    }
    int k = 0;
    arrayOfInt[0] = 0;
    int m = paramInt2 / paramInt1;
    int n = paramInt2 % paramInt1;
    int i = 0;
    paramInt2 = k;
    while (j <= paramInt1)
    {
      paramInt2 += n;
      if ((paramInt2 > 0) && (paramInt1 - paramInt2 < n))
      {
        k = m + 1;
        paramInt2 -= paramInt1;
      }
      else
      {
        k = m;
      }
      i += k;
      arrayOfInt[j] = i;
      j += 1;
    }
    return arrayOfInt;
  }
  
  private void clearPreLayoutSpanMappingCache()
  {
    mPreLayoutSpanSizeCache.clear();
    mPreLayoutSpanIndexCache.clear();
  }
  
  private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt)
  {
    if (paramInt == 1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i = getSpanIndex(paramRecycler, paramState, mPosition);
    if (paramInt != 0) {
      while (i > 0)
      {
        paramInt = mPosition;
        if (paramInt <= 0) {
          break;
        }
        mPosition = (paramInt - 1);
        i = getSpanIndex(paramRecycler, paramState, mPosition);
      }
    }
    int m = paramState.getItemCount();
    paramInt = mPosition;
    while (paramInt < m - 1)
    {
      int k = paramInt + 1;
      int j = getSpanIndex(paramRecycler, paramState, k);
      if (j <= i) {
        break;
      }
      paramInt = k;
      i = j;
    }
    mPosition = paramInt;
  }
  
  private void ensureViewSet()
  {
    View[] arrayOfView = mSet;
    if ((arrayOfView == null) || (arrayOfView.length != mSpanCount)) {
      mSet = new View[mSpanCount];
    }
  }
  
  private int getSpanGroupIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      return mSpanSizeLookup.getSpanGroupIndex(paramInt, mSpanCount);
    }
    int i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      f.sufficientlysecure.rootcommands.util.StringBuilder.append("Cannot find span size for pre layout position. ", paramInt);
      return 0;
    }
    return mSpanSizeLookup.getSpanGroupIndex(i, mSpanCount);
  }
  
  private int getSpanIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      return mSpanSizeLookup.getCachedSpanIndex(paramInt, mSpanCount);
    }
    int i = mPreLayoutSpanIndexCache.get(paramInt, -1);
    if (i != -1) {
      return i;
    }
    i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      f.sufficientlysecure.rootcommands.util.StringBuilder.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:", paramInt);
      return 0;
    }
    return mSpanSizeLookup.getCachedSpanIndex(i, mSpanCount);
  }
  
  private int getSpanSize(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      return mSpanSizeLookup.getSpanSize(paramInt);
    }
    int i = mPreLayoutSpanSizeCache.get(paramInt, -1);
    if (i != -1) {
      return i;
    }
    i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      f.sufficientlysecure.rootcommands.util.StringBuilder.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:", paramInt);
      return 1;
    }
    return mSpanSizeLookup.getSpanSize(i);
  }
  
  private void guessMeasurement(float paramFloat, int paramInt)
  {
    calculateItemBorders(Math.max(Math.round(paramFloat * mSpanCount), paramInt));
  }
  
  private void measureChild(View paramView, int paramInt, boolean paramBoolean)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = mDecorInsets;
    int j = top + bottom + topMargin + bottomMargin;
    int i = left + right + leftMargin + rightMargin;
    int k = getSpaceForSpanRange(mSpanIndex, mSpanSize);
    if (mOrientation == 1)
    {
      i = RecyclerView.LayoutManager.getChildMeasureSpec(k, paramInt, i, width, false);
      paramInt = RecyclerView.LayoutManager.getChildMeasureSpec(mOrientationHelper.getTotalSpace(), getHeightMode(), j, height, true);
    }
    else
    {
      paramInt = RecyclerView.LayoutManager.getChildMeasureSpec(k, paramInt, j, height, false);
      i = RecyclerView.LayoutManager.getChildMeasureSpec(mOrientationHelper.getTotalSpace(), getWidthMode(), i, width, true);
    }
    measureChildWithDecorationsAndMargin(paramView, i, paramInt, paramBoolean);
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {
      paramBoolean = shouldReMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    } else {
      paramBoolean = shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    }
    if (paramBoolean) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private void updateMeasurements()
  {
    int i;
    int j;
    if (getOrientation() == 1)
    {
      i = getWidth() - getPaddingRight();
      j = getPaddingLeft();
    }
    else
    {
      i = getHeight() - getPaddingBottom();
      j = getPaddingTop();
    }
    calculateItemBorders(i - j);
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void collectPrefetchPositionsForLayoutState(RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    int j = mSpanCount;
    int i = 0;
    while ((i < mSpanCount) && (paramLayoutState.hasMore(paramState)) && (j > 0))
    {
      int k = mCurrentPosition;
      paramLayoutPrefetchRegistry.addPosition(k, Math.max(0, mScrollingOffset));
      j -= mSpanSizeLookup.getSpanSize(k);
      mCurrentPosition += mItemDirection;
      i += 1;
    }
  }
  
  public View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3)
  {
    ensureLayoutState();
    int j = mOrientationHelper.getStartAfterPadding();
    int k = mOrientationHelper.getEndAfterPadding();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else {
      i = -1;
    }
    Object localObject2 = null;
    Object localObject4;
    for (Object localObject1 = null; paramInt1 != paramInt2; localObject1 = localObject4)
    {
      View localView = getChildAt(paramInt1);
      int m = getPosition(localView);
      Object localObject3 = localObject2;
      localObject4 = localObject1;
      if (m >= 0)
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (m < paramInt3) {
          if (getSpanIndex(paramRecycler, paramState, m) != 0)
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
          }
          else if (((RecyclerView.LayoutParams)localView.getLayoutParams()).isItemRemoved())
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject1 == null)
            {
              localObject4 = localView;
              localObject3 = localObject2;
            }
          }
          else
          {
            if ((mOrientationHelper.getDecoratedStart(localView) < k) && (mOrientationHelper.getDecoratedEnd(localView) >= j)) {
              return localView;
            }
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject2 == null)
            {
              localObject3 = localView;
              localObject4 = localObject1;
            }
          }
        }
      }
      paramInt1 += i;
      localObject2 = localObject3;
    }
    if (localObject2 != null) {
      return localObject2;
    }
    return localObject1;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (mOrientation == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (mOrientation == 1) {
      return mSpanCount;
    }
    if (paramState.getItemCount() < 1) {
      return 0;
    }
    return getSpanGroupIndex(paramRecycler, paramState, paramState.getItemCount() - 1) + 1;
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (mOrientation == 0) {
      return mSpanCount;
    }
    if (paramState.getItemCount() < 1) {
      return 0;
    }
    return getSpanGroupIndex(paramRecycler, paramState, paramState.getItemCount() - 1) + 1;
  }
  
  public int getSpaceForSpanRange(int paramInt1, int paramInt2)
  {
    if ((mOrientation == 1) && (isLayoutRTL()))
    {
      arrayOfInt = mCachedBorders;
      int i = mSpanCount;
      return arrayOfInt[(i - paramInt1)] - arrayOfInt[(i - paramInt1 - paramInt2)];
    }
    int[] arrayOfInt = mCachedBorders;
    return arrayOfInt[(paramInt2 + paramInt1)] - arrayOfInt[paramInt1];
  }
  
  public int getSpanCount()
  {
    return mSpanCount;
  }
  
  public SpanSizeLookup getSpanSizeLookup()
  {
    return mSpanSizeLookup;
  }
  
  public void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, LinearLayoutManager.LayoutChunkResult paramLayoutChunkResult)
  {
    int i3 = mOrientationHelper.getModeInOther();
    int j;
    if (i3 != 1073741824) {
      j = 1;
    } else {
      j = 0;
    }
    if (getChildCount() > 0) {
      k = mCachedBorders[mSpanCount];
    } else {
      k = 0;
    }
    if (j != 0) {
      updateMeasurements();
    }
    boolean bool;
    if (mItemDirection == 1) {
      bool = true;
    } else {
      bool = false;
    }
    int i = mSpanCount;
    if (!bool) {
      i = getSpanIndex(paramRecycler, paramState, mCurrentPosition) + getSpanSize(paramRecycler, paramState, mCurrentPosition);
    }
    int m = 0;
    int n = 0;
    Object localObject;
    while ((n < mSpanCount) && (paramLayoutState.hasMore(paramState)) && (i > 0))
    {
      i2 = mCurrentPosition;
      i1 = getSpanSize(paramRecycler, paramState, i2);
      if (i1 <= mSpanCount)
      {
        i -= i1;
        if (i >= 0)
        {
          localObject = paramLayoutState.next(paramRecycler);
          if (localObject != null)
          {
            m += i1;
            mSet[n] = localObject;
            n += 1;
          }
        }
      }
      else
      {
        paramRecycler = new StringBuilder();
        paramRecycler.append("Item at position ");
        paramRecycler.append(i2);
        paramRecycler.append(" requires ");
        paramRecycler.append(i1);
        paramRecycler.append(" spans but GridLayoutManager has only ");
        throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramRecycler, mSpanCount, " spans."));
      }
    }
    if (n == 0)
    {
      mFinished = true;
      return;
    }
    float f1 = 0.0F;
    assignSpans(paramRecycler, paramState, n, m, bool);
    m = 0;
    i = 0;
    while (m < n)
    {
      paramRecycler = mSet[m];
      if (mScrapList == null)
      {
        if (bool) {
          addView(paramRecycler);
        } else {
          addView(paramRecycler, 0);
        }
      }
      else if (bool) {
        addDisappearingView(paramRecycler);
      } else {
        addDisappearingView(paramRecycler, 0);
      }
      calculateItemDecorationsForChild(paramRecycler, mDecorInsets);
      measureChild(paramRecycler, i3, false);
      i2 = mOrientationHelper.getDecoratedMeasurement(paramRecycler);
      i1 = i;
      if (i2 > i) {
        i1 = i2;
      }
      paramState = (LayoutParams)paramRecycler.getLayoutParams();
      float f3 = mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) * 1.0F / mSpanSize;
      float f2 = f1;
      if (f3 > f1) {
        f2 = f3;
      }
      m += 1;
      i = i1;
      f1 = f2;
    }
    m = i;
    if (j != 0)
    {
      guessMeasurement(f1, k);
      j = 0;
      for (i = 0;; i = k)
      {
        m = i;
        if (j >= n) {
          break;
        }
        paramRecycler = mSet[j];
        measureChild(paramRecycler, 1073741824, true);
        m = mOrientationHelper.getDecoratedMeasurement(paramRecycler);
        k = i;
        if (m > i) {
          k = m;
        }
        j += 1;
      }
    }
    i = 0;
    while (i < n)
    {
      paramRecycler = mSet[i];
      if (mOrientationHelper.getDecoratedMeasurement(paramRecycler) != m)
      {
        paramState = (LayoutParams)paramRecycler.getLayoutParams();
        localObject = mDecorInsets;
        j = top + bottom + topMargin + bottomMargin;
        k = left + right + leftMargin + rightMargin;
        i1 = getSpaceForSpanRange(mSpanIndex, mSpanSize);
        if (mOrientation == 1)
        {
          k = RecyclerView.LayoutManager.getChildMeasureSpec(i1, 1073741824, k, width, false);
          j = View.MeasureSpec.makeMeasureSpec(m - j, 1073741824);
        }
        else
        {
          k = View.MeasureSpec.makeMeasureSpec(m - k, 1073741824);
          j = RecyclerView.LayoutManager.getChildMeasureSpec(i1, 1073741824, j, height, false);
        }
        measureChildWithDecorationsAndMargin(paramRecycler, k, j, true);
      }
      i += 1;
    }
    mConsumed = m;
    if (mOrientation == 1)
    {
      if (mLayoutDirection == -1)
      {
        i = mOffset;
        j = i - m;
      }
      else
      {
        j = mOffset;
        i = m + j;
      }
      k = 0;
      m = 0;
    }
    else
    {
      if (mLayoutDirection == -1)
      {
        i = mOffset;
        k = i - m;
        m = i;
      }
      else
      {
        k = mOffset;
        m += k;
      }
      j = 0;
      i = 0;
    }
    int i1 = 0;
    i3 = m;
    int i2 = k;
    int k = i1;
    m = j;
    i1 = i;
    while (k < n)
    {
      paramRecycler = mSet[k];
      paramState = (LayoutParams)paramRecycler.getLayoutParams();
      if (mOrientation == 1)
      {
        if (isLayoutRTL())
        {
          j = getPaddingLeft() + mCachedBorders[(mSpanCount - mSpanIndex)];
          i = j - mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
        }
        else
        {
          i = getPaddingLeft();
          i = mCachedBorders[mSpanIndex] + i;
          j = mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + i;
        }
      }
      else
      {
        i = getPaddingTop();
        m = mCachedBorders[mSpanIndex] + i;
        i1 = mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + m;
        j = i3;
        i = i2;
      }
      layoutDecoratedWithMargins(paramRecycler, i, m, j, i1);
      if ((paramState.isItemRemoved()) || (paramState.isItemChanged())) {
        mIgnoreConsumed = true;
      }
      mFocusable |= paramRecycler.hasFocusable();
      k += 1;
      i2 = i;
      i3 = j;
    }
    Arrays.fill(mSet, null);
  }
  
  public void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt)
  {
    updateMeasurements();
    if ((paramState.getItemCount() > 0) && (!paramState.isPreLayout())) {
      ensureAnchorIsInCorrectSpan(paramRecycler, paramState, paramAnchorInfo, paramInt);
    }
    ensureViewSet();
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    View localView = findContainingItemView(paramView);
    Object localObject1 = null;
    if (localView == null) {
      return null;
    }
    Object localObject2 = (LayoutParams)localView.getLayoutParams();
    int i5 = mSpanIndex;
    int i6 = mSpanSize + i5;
    if (super.onFocusSearchFailed(paramView, paramInt, paramRecycler, paramState) == null) {
      return null;
    }
    int i11;
    if (convertFocusDirectionToLayoutDirection(paramInt) == 1) {
      i11 = 1;
    } else {
      i11 = 0;
    }
    if (i11 != mShouldReverseLayout) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int k;
    int m;
    if (paramInt != 0)
    {
      paramInt = getChildCount() - 1;
      k = -1;
      m = -1;
    }
    else
    {
      k = getChildCount();
      paramInt = 0;
      m = 1;
    }
    int n;
    if ((mOrientation == 1) && (isLayoutRTL())) {
      n = 1;
    } else {
      n = 0;
    }
    int i7 = getSpanGroupIndex(paramRecycler, paramState, paramInt);
    localObject2 = null;
    int i3 = -1;
    int i2 = 0;
    int i = 0;
    int j = -1;
    int i1 = paramInt;
    paramInt = j;
    paramView = localObject1;
    localObject1 = localObject2;
    while (i1 != k)
    {
      j = getSpanGroupIndex(paramRecycler, paramState, i1);
      localObject2 = getChildAt(i1);
      if (localObject2 == localView) {
        break;
      }
      if ((((View)localObject2).hasFocusable()) && (j != i7))
      {
        if (paramView != null) {
          break;
        }
      }
      else
      {
        LayoutParams localLayoutParams = (LayoutParams)((View)localObject2).getLayoutParams();
        int i8 = mSpanIndex;
        int i9 = mSpanSize + i8;
        if ((((View)localObject2).hasFocusable()) && (i8 == i5) && (i9 == i6)) {
          return localObject2;
        }
        if (((((View)localObject2).hasFocusable()) && (paramView == null)) || ((!((View)localObject2).hasFocusable()) && (localObject1 == null))) {}
        do
        {
          int i10;
          do
          {
            j = 1;
            break label468;
            j = Math.max(i8, i5);
            i10 = Math.min(i9, i6) - j;
            if (!((View)localObject2).hasFocusable()) {
              break;
            }
          } while (i10 > i2);
          while (i10 == i2)
          {
            if (i8 > i3) {
              j = 1;
            } else {
              j = 0;
            }
            if (n != j) {
              break;
            }
          }
          if (paramView != null) {
            break;
          }
          int i4 = 1;
          j = 1;
          if (!isViewPartiallyVisible((View)localObject2, false, true)) {
            break;
          }
          if (i10 > i)
          {
            j = i4;
            break label468;
          }
          if (i10 != i) {
            break;
          }
          if (i8 <= paramInt) {
            j = 0;
          }
        } while (n == j);
        j = 0;
        label468:
        if (j != 0) {
          if (((View)localObject2).hasFocusable())
          {
            i3 = mSpanIndex;
            i2 = Math.min(i9, i6) - Math.max(i8, i5);
            paramView = (View)localObject2;
          }
          else
          {
            paramInt = mSpanIndex;
            i = Math.min(i9, i6);
            j = Math.max(i8, i5);
            localObject1 = localObject2;
            i -= j;
          }
        }
      }
      i1 += m;
    }
    if (paramView != null) {
      return paramView;
    }
    return localObject1;
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = getSpanGroupIndex(paramRecycler, paramState, paramView.getViewLayoutPosition());
    boolean bool;
    if (mOrientation == 0)
    {
      j = paramView.getSpanIndex();
      k = paramView.getSpanSize();
      if ((mSpanCount > 1) && (paramView.getSpanSize() == mSpanCount)) {
        bool = true;
      } else {
        bool = false;
      }
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(j, k, i, 1, bool, false));
      return;
    }
    int j = paramView.getSpanIndex();
    int k = paramView.getSpanSize();
    if ((mSpanCount > 1) && (paramView.getSpanSize() == mSpanCount)) {
      bool = true;
    } else {
      bool = false;
    }
    paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, k, bool, false));
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (paramState.isPreLayout()) {
      cachePreLayoutSpanMapping();
    }
    super.onLayoutChildren(paramRecycler, paramState);
    clearPreLayoutSpanMappingCache();
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    mPendingSpanCountChange = false;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    updateMeasurements();
    ensureViewSet();
    return super.scrollHorizontallyBy(paramInt, paramRecycler, paramState);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    updateMeasurements();
    ensureViewSet();
    if (mOrientation == 0) {
      return 0;
    }
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (mCachedBorders == null) {
      super.setMeasuredDimension(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft();
    i = getPaddingRight() + i;
    int j = getPaddingTop();
    j = getPaddingBottom() + j;
    if (mOrientation == 1)
    {
      paramInt2 = RecyclerView.LayoutManager.chooseSize(paramInt2, paramRect.height() + j, getMinimumHeight());
      paramRect = mCachedBorders;
      paramInt1 = RecyclerView.LayoutManager.chooseSize(paramInt1, paramRect[(paramRect.length - 1)] + i, getMinimumWidth());
    }
    else
    {
      paramInt1 = RecyclerView.LayoutManager.chooseSize(paramInt1, paramRect.width() + i, getMinimumWidth());
      paramRect = mCachedBorders;
      paramInt2 = RecyclerView.LayoutManager.chooseSize(paramInt2, paramRect[(paramRect.length - 1)] + j, getMinimumHeight());
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setSpanCount(int paramInt)
  {
    if (paramInt == mSpanCount) {
      return;
    }
    mPendingSpanCountChange = true;
    if (paramInt >= 1)
    {
      mSpanCount = paramInt;
      mSpanSizeLookup.invalidateSpanIndexCache();
      requestLayout();
      return;
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Span count should be at least 1. Provided ", paramInt));
  }
  
  public void setSpanSizeLookup(SpanSizeLookup paramSpanSizeLookup)
  {
    mSpanSizeLookup = paramSpanSizeLookup;
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      super.setStackFromEnd(false);
      return;
    }
    throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (mPendingSavedState == null) && (!mPendingSpanCountChange);
  }
  
  public static final class DefaultSpanSizeLookup
    extends GridLayoutManager.SpanSizeLookup
  {
    public DefaultSpanSizeLookup() {}
    
    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      return paramInt1 % paramInt2;
    }
    
    public int getSpanSize(int paramInt)
    {
      return 1;
    }
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    public static final int INVALID_SPAN_ID = -1;
    public int mSpanIndex = -1;
    public int mSpanSize = 0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public int getSpanIndex()
    {
      return mSpanIndex;
    }
    
    public int getSpanSize()
    {
      return mSpanSize;
    }
  }
  
  public static abstract class SpanSizeLookup
  {
    public boolean mCacheSpanIndices = false;
    public final SparseIntArray mSpanIndexCache = new SparseIntArray();
    
    public SpanSizeLookup() {}
    
    public int findReferenceIndexFromCache(int paramInt)
    {
      int j = mSpanIndexCache.size() - 1;
      int i = 0;
      while (i <= j)
      {
        int k = i + j >>> 1;
        if (mSpanIndexCache.keyAt(k) < paramInt) {
          i = k + 1;
        } else {
          j = k - 1;
        }
      }
      paramInt = i - 1;
      if ((paramInt >= 0) && (paramInt < mSpanIndexCache.size())) {
        return mSpanIndexCache.keyAt(paramInt);
      }
      return -1;
    }
    
    public int getCachedSpanIndex(int paramInt1, int paramInt2)
    {
      if (!mCacheSpanIndices) {
        return getSpanIndex(paramInt1, paramInt2);
      }
      int i = mSpanIndexCache.get(paramInt1, -1);
      if (i != -1) {
        return i;
      }
      paramInt2 = getSpanIndex(paramInt1, paramInt2);
      mSpanIndexCache.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    public int getSpanGroupIndex(int paramInt1, int paramInt2)
    {
      int i2 = getSpanSize(paramInt1);
      int k = 0;
      int i = 0;
      int j;
      for (int m = 0; k < paramInt1; m = j)
      {
        int n = getSpanSize(k);
        int i1 = i + n;
        if (i1 == paramInt2)
        {
          j = m + 1;
          i = 0;
        }
        else
        {
          i = i1;
          j = m;
          if (i1 > paramInt2)
          {
            j = m + 1;
            i = n;
          }
        }
        k += 1;
      }
      if (i + i2 > paramInt2) {
        return m + 1;
      }
      return m;
    }
    
    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      int i1 = getSpanSize(paramInt1);
      if (i1 == paramInt2) {
        return 0;
      }
      int k;
      if ((mCacheSpanIndices) && (mSpanIndexCache.size() > 0))
      {
        i = findReferenceIndexFromCache(paramInt1);
        k = i;
        if (i >= 0)
        {
          i = mSpanIndexCache.get(i) + getSpanSize(i);
          break label123;
        }
      }
      int j = 0;
      int i = 0;
      while (j < paramInt1)
      {
        int m = getSpanSize(j);
        int n = i + m;
        if (n == paramInt2)
        {
          i = 0;
          k = j;
        }
        else
        {
          k = j;
          i = n;
          if (n > paramInt2)
          {
            i = m;
            k = j;
          }
        }
        label123:
        j = k + 1;
      }
      if (i1 + i <= paramInt2) {
        return i;
      }
      return 0;
    }
    
    public abstract int getSpanSize(int paramInt);
    
    public void invalidateSpanIndexCache()
    {
      mSpanIndexCache.clear();
    }
    
    public boolean isSpanIndexCacheEnabled()
    {
      return mCacheSpanIndices;
    }
    
    public void setSpanIndexCacheEnabled(boolean paramBoolean)
    {
      mCacheSpanIndices = paramBoolean;
    }
  }
}
