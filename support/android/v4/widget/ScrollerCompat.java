package support.android.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class ScrollerCompat
{
  public OverScroller mImpl;
  
  public ScrollerCompat(Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {
      paramContext = new OverScroller(paramContext, paramInterpolator);
    } else {
      paramContext = new OverScroller(paramContext);
    }
    mImpl = paramContext;
  }
  
  public static ScrollerCompat create(Context paramContext)
  {
    return new ScrollerCompat(paramContext, null);
  }
  
  public static ScrollerCompat create(Context paramContext, Interpolator paramInterpolator)
  {
    return new ScrollerCompat(paramContext, paramInterpolator);
  }
  
  public void abortAnimation()
  {
    mImpl.abortAnimation();
  }
  
  public boolean computeScrollOffset()
  {
    return mImpl.computeScrollOffset();
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    mImpl.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    mImpl.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public float getCurrVelocity()
  {
    return mImpl.getCurrVelocity();
  }
  
  public int getCurrX()
  {
    return mImpl.getCurrX();
  }
  
  public int getCurrY()
  {
    return mImpl.getCurrY();
  }
  
  public int getFinalX()
  {
    return mImpl.getFinalX();
  }
  
  public int getFinalY()
  {
    return mImpl.getFinalY();
  }
  
  public boolean isFinished()
  {
    return mImpl.isFinished();
  }
  
  public boolean isOverScrolled()
  {
    return mImpl.isOverScrolled();
  }
  
  public void notifyHorizontalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    mImpl.notifyHorizontalEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  public void notifyVerticalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    mImpl.notifyVerticalEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean springBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return mImpl.springBack(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mImpl.startScroll(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    mImpl.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}
