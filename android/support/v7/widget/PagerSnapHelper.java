package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import b.b.a.G;

public class PagerSnapHelper
  extends SnapHelper
{
  public static final int MAX_SCROLL_ON_FLING_DURATION = 100;
  @G
  public OrientationHelper mHorizontalHelper;
  @G
  public OrientationHelper mVerticalHelper;
  
  public PagerSnapHelper() {}
  
  private int distanceToCenter(RecyclerView.LayoutManager paramLayoutManager, View paramView, OrientationHelper paramOrientationHelper)
  {
    int j = paramOrientationHelper.getDecoratedStart(paramView);
    int k = paramOrientationHelper.getDecoratedMeasurement(paramView) / 2;
    int i;
    if (paramLayoutManager.getClipToPadding())
    {
      i = paramOrientationHelper.getStartAfterPadding();
      i = paramOrientationHelper.getTotalSpace() / 2 + i;
    }
    else
    {
      i = paramOrientationHelper.getEnd() / 2;
    }
    return k + j - i;
  }
  
  private View findCenterView(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int i1 = paramLayoutManager.getChildCount();
    Object localObject = null;
    if (i1 == 0) {
      return null;
    }
    int i;
    if (paramLayoutManager.getClipToPadding())
    {
      i = paramOrientationHelper.getStartAfterPadding();
      i = paramOrientationHelper.getTotalSpace() / 2 + i;
    }
    else
    {
      i = paramOrientationHelper.getEnd() / 2;
    }
    int k = Integer.MAX_VALUE;
    int j = 0;
    while (j < i1)
    {
      View localView = paramLayoutManager.getChildAt(j);
      int m = paramOrientationHelper.getDecoratedStart(localView);
      int n = Math.abs(paramOrientationHelper.getDecoratedMeasurement(localView) / 2 + m - i);
      m = k;
      if (n < k)
      {
        localObject = localView;
        m = n;
      }
      j += 1;
      k = m;
    }
    return localObject;
  }
  
  private View findStartView(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int n = paramLayoutManager.getChildCount();
    Object localObject = null;
    if (n == 0) {
      return null;
    }
    int j = Integer.MAX_VALUE;
    int i = 0;
    while (i < n)
    {
      View localView = paramLayoutManager.getChildAt(i);
      int m = paramOrientationHelper.getDecoratedStart(localView);
      int k = j;
      if (m < j)
      {
        localObject = localView;
        k = m;
      }
      i += 1;
      j = k;
    }
    return localObject;
  }
  
  private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    OrientationHelper localOrientationHelper = mHorizontalHelper;
    if ((localOrientationHelper == null) || (mLayoutManager != paramLayoutManager)) {
      mHorizontalHelper = new OrientationHelper.1(paramLayoutManager);
    }
    return mHorizontalHelper;
  }
  
  private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    OrientationHelper localOrientationHelper = mVerticalHelper;
    if ((localOrientationHelper == null) || (mLayoutManager != paramLayoutManager)) {
      mVerticalHelper = new OrientationHelper.2(paramLayoutManager);
    }
    return mVerticalHelper;
  }
  
  public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = distanceToCenter(paramLayoutManager, paramView, getHorizontalHelper(paramLayoutManager));
    } else {
      arrayOfInt[0] = 0;
    }
    if (paramLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = distanceToCenter(paramLayoutManager, paramView, getVerticalHelper(paramLayoutManager));
      return arrayOfInt;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
      return null;
    }
    new LinearSmoothScroller(mRecyclerView.getContext())
    {
      public float calculateSpeedPerPixel(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / densityDpi;
      }
      
      public int calculateTimeForScrolling(int paramAnonymousInt)
      {
        return Math.min(100, super.calculateTimeForScrolling(paramAnonymousInt));
      }
      
      public void onTargetFound(View paramAnonymousView, RecyclerView.State paramAnonymousState, RecyclerView.SmoothScroller.Action paramAnonymousAction)
      {
        paramAnonymousState = PagerSnapHelper.this;
        paramAnonymousView = paramAnonymousState.calculateDistanceToFinalSnap(mRecyclerView.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousAction.update(i, j, k, mDecelerateInterpolator);
        }
      }
    };
  }
  
  public View findSnapView(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager.canScrollVertically()) {
      return findCenterView(paramLayoutManager, getVerticalHelper(paramLayoutManager));
    }
    if (paramLayoutManager.canScrollHorizontally()) {
      return findCenterView(paramLayoutManager, getHorizontalHelper(paramLayoutManager));
    }
    return null;
  }
  
  public int findTargetSnapPosition(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int k = paramLayoutManager.getItemCount();
    if (k == 0) {
      return -1;
    }
    View localView = null;
    if (paramLayoutManager.canScrollVertically()) {
      localView = findStartView(paramLayoutManager, getVerticalHelper(paramLayoutManager));
    } else if (paramLayoutManager.canScrollHorizontally()) {
      localView = findStartView(paramLayoutManager, getHorizontalHelper(paramLayoutManager));
    }
    if (localView == null) {
      return -1;
    }
    int j = paramLayoutManager.getPosition(localView);
    if (j == -1) {
      return -1;
    }
    boolean bool = paramLayoutManager.canScrollHorizontally();
    int i = 0;
    if (bool) {
      if (paramInt1 <= 0) {}
    }
    for (;;)
    {
      paramInt1 = 1;
      break;
      do
      {
        paramInt1 = 0;
        break;
      } while (paramInt2 <= 0);
    }
    paramInt2 = i;
    if ((paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider))
    {
      paramLayoutManager = ((RecyclerView.SmoothScroller.ScrollVectorProvider)paramLayoutManager).computeScrollVectorForPosition(k - 1);
      paramInt2 = i;
      if (paramLayoutManager != null) {
        if (x >= 0.0F)
        {
          paramInt2 = i;
          if (y >= 0.0F) {}
        }
        else
        {
          paramInt2 = 1;
        }
      }
    }
    if (paramInt2 != 0)
    {
      if (paramInt1 != 0) {
        return j - 1;
      }
    }
    else if (paramInt1 != 0) {
      return j + 1;
    }
    return j;
  }
}
