package android.support.v7.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class SnapHelper
  extends RecyclerView.OnFlingListener
{
  public static final float MILLISECONDS_PER_INCH = 100.0F;
  public Scroller mGravityScroller;
  public RecyclerView mRecyclerView;
  public final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener()
  {
    public boolean mScrolled = false;
    
    public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      if ((paramAnonymousInt == 0) && (mScrolled))
      {
        mScrolled = false;
        snapToTargetExistingView();
      }
    }
    
    public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
        mScrolled = true;
      }
    }
  };
  
  public SnapHelper() {}
  
  private void destroyCallbacks()
  {
    mRecyclerView.removeOnScrollListener(mScrollListener);
    mRecyclerView.setOnFlingListener(null);
  }
  
  private void setupCallbacks()
    throws IllegalStateException
  {
    if (mRecyclerView.getOnFlingListener() == null)
    {
      mRecyclerView.addOnScrollListener(mScrollListener);
      mRecyclerView.setOnFlingListener(this);
      return;
    }
    throw new IllegalStateException("An instance of OnFlingListener already set.");
  }
  
  private boolean snapFromFling(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
      return false;
    }
    RecyclerView.SmoothScroller localSmoothScroller = createScroller(paramLayoutManager);
    if (localSmoothScroller == null) {
      return false;
    }
    paramInt1 = findTargetSnapPosition(paramLayoutManager, paramInt1, paramInt2);
    if (paramInt1 == -1) {
      return false;
    }
    localSmoothScroller.setTargetPosition(paramInt1);
    paramLayoutManager.startSmoothScroll(localSmoothScroller);
    return true;
  }
  
  public void attachToRecyclerView(RecyclerView paramRecyclerView)
    throws IllegalStateException
  {
    RecyclerView localRecyclerView = mRecyclerView;
    if (localRecyclerView == paramRecyclerView) {
      return;
    }
    if (localRecyclerView != null) {
      destroyCallbacks();
    }
    mRecyclerView = paramRecyclerView;
    if (mRecyclerView != null)
    {
      setupCallbacks();
      mGravityScroller = new Scroller(mRecyclerView.getContext(), new DecelerateInterpolator());
      snapToTargetExistingView();
    }
  }
  
  public abstract int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager paramLayoutManager, View paramView);
  
  public int[] calculateScrollDistance(int paramInt1, int paramInt2)
  {
    mGravityScroller.fling(0, 0, paramInt1, paramInt2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
    return new int[] { mGravityScroller.getFinalX(), mGravityScroller.getFinalY() };
  }
  
  public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager paramLayoutManager)
  {
    return createSnapScroller(paramLayoutManager);
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
      
      public void onTargetFound(View paramAnonymousView, RecyclerView.State paramAnonymousState, RecyclerView.SmoothScroller.Action paramAnonymousAction)
      {
        paramAnonymousState = SnapHelper.this;
        RecyclerView localRecyclerView = mRecyclerView;
        if (localRecyclerView == null) {
          return;
        }
        paramAnonymousView = paramAnonymousState.calculateDistanceToFinalSnap(localRecyclerView.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousAction.update(i, j, k, mDecelerateInterpolator);
        }
      }
    };
  }
  
  public abstract View findSnapView(RecyclerView.LayoutManager paramLayoutManager);
  
  public abstract int findTargetSnapPosition(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2);
  
  public boolean onFling(int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager localLayoutManager = mRecyclerView.getLayoutManager();
    if (localLayoutManager == null) {
      return false;
    }
    if (mRecyclerView.getAdapter() == null) {
      return false;
    }
    int i = mRecyclerView.getMinFlingVelocity();
    return ((Math.abs(paramInt2) > i) || (Math.abs(paramInt1) > i)) && (snapFromFling(localLayoutManager, paramInt1, paramInt2));
  }
  
  public void snapToTargetExistingView()
  {
    Object localObject = mRecyclerView;
    if (localObject == null) {
      return;
    }
    localObject = ((RecyclerView)localObject).getLayoutManager();
    if (localObject == null) {
      return;
    }
    View localView = findSnapView((RecyclerView.LayoutManager)localObject);
    if (localView == null) {
      return;
    }
    localObject = calculateDistanceToFinalSnap((RecyclerView.LayoutManager)localObject, localView);
    if ((localObject[0] != 0) || (localObject[1] != 0)) {
      mRecyclerView.smoothScrollBy(localObject[0], localObject[1]);
    }
  }
}
