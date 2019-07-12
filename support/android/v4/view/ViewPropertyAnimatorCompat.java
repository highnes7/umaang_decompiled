package support.android.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat
{
  public static final int LISTENER_TAG_ID = 2113929216;
  public static final String TAG = "ViewAnimatorCompat";
  public int currentPage = -1;
  public Runnable mEndAction = null;
  public Runnable mStartAction = null;
  public WeakReference<View> mView;
  
  public ViewPropertyAnimatorCompat(View paramView)
  {
    mView = new WeakReference(paramView);
  }
  
  private void setListener(View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    if (paramViewPropertyAnimatorListener != null)
    {
      paramView.animate().setListener(new ValueAnimatorCompatImplHoneycombMr1.2(this, paramViewPropertyAnimatorListener, paramView));
      return;
    }
    paramView.animate().setListener(null);
  }
  
  public ViewPropertyAnimatorCompat alpha()
  {
    View localView = (View)mView.get();
    if (localView != null)
    {
      int i = Build.VERSION.SDK_INT;
      localView.animate().withLayer();
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat alpha(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().alpha(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat alphaBy(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().alphaBy(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat cancel(float paramFloat)
  {
    View localView = (View)mView.get();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 21)) {
      localView.animate().translationZBy(paramFloat);
    }
    return this;
  }
  
  public void cancel()
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().cancel();
    }
  }
  
  public long getDuration()
  {
    View localView = (View)mView.get();
    if (localView != null) {
      return localView.animate().getDuration();
    }
    return 0L;
  }
  
  public Interpolator getInterpolator()
  {
    View localView = (View)mView.get();
    if (localView != null)
    {
      int i = Build.VERSION.SDK_INT;
      return (Interpolator)localView.animate().getInterpolator();
    }
    return null;
  }
  
  public long getStartDelay()
  {
    View localView = (View)mView.get();
    if (localView != null) {
      return localView.animate().getStartDelay();
    }
    return 0L;
  }
  
  public ViewPropertyAnimatorCompat rotation(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().rotation(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationBy(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().rotationBy(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationX(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().rotationX(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationXBy(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().rotationXBy(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationY(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().rotationY(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationYBy(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().rotationYBy(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleX(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().scaleX(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleXBy(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().scaleXBy(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleY(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().scaleY(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleYBy(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().scaleYBy(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setDuration(long paramLong)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().setDuration(paramLong);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setInterpolator(Interpolator paramInterpolator)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().setInterpolator(paramInterpolator);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    View localView = (View)mView.get();
    if (localView != null)
    {
      int i = Build.VERSION.SDK_INT;
      setListener(localView, paramViewPropertyAnimatorListener);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setStartDelay(long paramLong)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().setStartDelay(paramLong);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener)
  {
    View localView = (View)mView.get();
    if (localView != null)
    {
      int i = Build.VERSION.SDK_INT;
      ViewPropertyAnimatorCompatKK.1 local1 = null;
      if (paramViewPropertyAnimatorUpdateListener != null) {
        local1 = new ViewPropertyAnimatorCompatKK.1(this, paramViewPropertyAnimatorUpdateListener, localView);
      }
      localView.animate().setUpdateListener(local1);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat start(float paramFloat)
  {
    View localView = (View)mView.get();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 21)) {
      localView.animate().translationZ(paramFloat);
    }
    return this;
  }
  
  public void start()
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().start();
    }
  }
  
  public ViewPropertyAnimatorCompat translationX(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().translationX(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationXBy(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().translationXBy(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationY(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().translationY(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationYBy(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().translationYBy(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat withEndAction(Runnable paramRunnable)
  {
    View localView = (View)mView.get();
    if (localView != null)
    {
      int i = Build.VERSION.SDK_INT;
      localView.animate().withEndAction(paramRunnable);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat withStartAction(Runnable paramRunnable)
  {
    View localView = (View)mView.get();
    if (localView != null)
    {
      int i = Build.VERSION.SDK_INT;
      localView.animate().withStartAction(paramRunnable);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat x(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().x(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat xBy(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().xBy(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat y(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().y(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat yBy(float paramFloat)
  {
    View localView = (View)mView.get();
    if (localView != null) {
      localView.animate().yBy(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat z(float paramFloat)
  {
    View localView = (View)mView.get();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 21)) {
      localView.animate().z(paramFloat);
    }
    return this;
  }
  
  public ViewPropertyAnimatorCompat zBy(float paramFloat)
  {
    View localView = (View)mView.get();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 21)) {
      localView.animate().zBy(paramFloat);
    }
    return this;
  }
}
