package android.support.v7.widget;

import android.graphics.PointF;
import android.view.View;
import b.b.a.G;

public class LinearSnapHelper
  extends SnapHelper
{
  public static final float INVALID_DISTANCE = 1.0F;
  @G
  public OrientationHelper mHorizontalHelper;
  @G
  public OrientationHelper mVerticalHelper;
  
  public LinearSnapHelper() {}
  
  private float computeDistancePerChild(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int i2 = paramLayoutManager.getChildCount();
    if (i2 == 0) {
      return 1.0F;
    }
    int m = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    int i = Integer.MAX_VALUE;
    int i1;
    int j;
    for (int k = Integer.MIN_VALUE; m < i2; k = i1)
    {
      View localView = paramLayoutManager.getChildAt(m);
      int n = paramLayoutManager.getPosition(localView);
      Object localObject3;
      if (n == -1)
      {
        localObject3 = localObject1;
        i1 = k;
      }
      else
      {
        j = i;
        if (n < i)
        {
          localObject1 = localView;
          j = n;
        }
        localObject3 = localObject1;
        i = j;
        i1 = k;
        if (n > k)
        {
          localObject2 = localView;
          i1 = n;
          i = j;
          localObject3 = localObject1;
        }
      }
      m += 1;
      localObject1 = localObject3;
    }
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        return 1.0F;
      }
      j = Math.min(paramOrientationHelper.getDecoratedStart(localObject1), paramOrientationHelper.getDecoratedStart(localObject2));
      j = Math.max(paramOrientationHelper.getDecoratedEnd(localObject1), paramOrientationHelper.getDecoratedEnd(localObject2)) - j;
      if (j == 0) {
        return 1.0F;
      }
      return j * 1.0F / (k - i + 1);
    }
    return 1.0F;
  }
  
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
  
  private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = calculateScrollDistance(paramInt1, paramInt2);
    float f = computeDistancePerChild(paramLayoutManager, paramOrientationHelper);
    if (f <= 0.0F) {
      return 0;
    }
    if (Math.abs(arrayOfInt[0]) > Math.abs(arrayOfInt[1])) {
      paramInt1 = arrayOfInt[0];
    } else {
      paramInt1 = arrayOfInt[1];
    }
    return Math.round(paramInt1 / f);
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
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
      return -1;
    }
    int j = paramLayoutManager.getItemCount();
    if (j == 0) {
      return -1;
    }
    Object localObject = findSnapView(paramLayoutManager);
    if (localObject == null) {
      return -1;
    }
    int m = paramLayoutManager.getPosition((View)localObject);
    if (m == -1) {
      return -1;
    }
    localObject = (RecyclerView.SmoothScroller.ScrollVectorProvider)paramLayoutManager;
    int k = j - 1;
    localObject = ((RecyclerView.SmoothScroller.ScrollVectorProvider)localObject).computeScrollVectorForPosition(k);
    if (localObject == null) {
      return -1;
    }
    int i;
    if (paramLayoutManager.canScrollHorizontally())
    {
      i = estimateNextPositionDiffForFling(paramLayoutManager, getHorizontalHelper(paramLayoutManager), paramInt1, 0);
      paramInt1 = i;
      if (x < 0.0F) {
        paramInt1 = -i;
      }
    }
    else
    {
      paramInt1 = 0;
    }
    if (paramLayoutManager.canScrollVertically())
    {
      i = estimateNextPositionDiffForFling(paramLayoutManager, getVerticalHelper(paramLayoutManager), 0, paramInt2);
      paramInt2 = i;
      if (y < 0.0F) {
        paramInt2 = -i;
      }
    }
    else
    {
      paramInt2 = 0;
    }
    if (paramLayoutManager.canScrollVertically()) {
      paramInt1 = paramInt2;
    }
    if (paramInt1 == 0) {
      return -1;
    }
    paramInt2 = m + paramInt1;
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    if (paramInt1 >= j) {
      return k;
    }
    return paramInt1;
  }
}
