package android.support.design.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.design.animation.AnimationUtils;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class HideBottomViewOnScrollBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  public static final int ENTER_ANIMATION_DURATION = 225;
  public static final int EXIT_ANIMATION_DURATION = 175;
  public static final int STATE_SCROLLED_DOWN = 1;
  public static final int STATE_SCROLLED_UP = 2;
  public ViewPropertyAnimator currentAnimator;
  public int currentState = 2;
  public int height = 0;
  
  public HideBottomViewOnScrollBehavior() {}
  
  public HideBottomViewOnScrollBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void animateChildTo(View paramView, int paramInt, long paramLong, TimeInterpolator paramTimeInterpolator)
  {
    currentAnimator = paramView.animate().translationY(paramInt).setInterpolator(paramTimeInterpolator).setDuration(paramLong).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        currentAnimator = null;
      }
    });
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    height = paramView.getMeasuredHeight();
    return false;
  }
  
  public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((currentState != 1) && (paramInt2 > 0))
    {
      slideDown(paramView1);
      return;
    }
    if ((currentState != 2) && (paramInt2 < 0)) {
      slideUp(paramView1);
    }
  }
  
  public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt)
  {
    return paramInt == 2;
  }
  
  public void slideDown(View paramView)
  {
    ViewPropertyAnimator localViewPropertyAnimator = currentAnimator;
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.cancel();
      paramView.clearAnimation();
    }
    currentState = 1;
    animateChildTo(paramView, height, 175L, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
  }
  
  public void slideUp(View paramView)
  {
    ViewPropertyAnimator localViewPropertyAnimator = currentAnimator;
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.cancel();
      paramView.clearAnimation();
    }
    currentState = 2;
    animateChildTo(paramView, 0, 225L, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
  }
}
