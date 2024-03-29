package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.animation.AnimatorSetCompat;
import android.support.design.animation.MotionTiming;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class FabTransformationScrimBehavior
  extends ExpandableTransformationBehavior
{
  public static final long COLLAPSE_DELAY = 0L;
  public static final long COLLAPSE_DURATION = 150L;
  public static final long EXPAND_DELAY = 75L;
  public static final long EXPAND_DURATION = 150L;
  public final MotionTiming collapseTiming = new MotionTiming(0L, 150L);
  public final MotionTiming expandTiming = new MotionTiming(75L, 150L);
  
  public FabTransformationScrimBehavior() {}
  
  public FabTransformationScrimBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void createScrimAnimation(View paramView, boolean paramBoolean1, boolean paramBoolean2, List paramList1, List paramList2)
  {
    if (paramBoolean1) {
      paramList2 = expandTiming;
    } else {
      paramList2 = collapseTiming;
    }
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        paramView.setAlpha(0.0F);
      }
      paramView = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F });
    }
    else
    {
      paramView = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 0.0F });
    }
    paramList2.apply(paramView);
    paramList1.add(paramView);
  }
  
  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return paramView2 instanceof FloatingActionButton;
  }
  
  public AnimatorSet onCreateExpandedStateChangeAnimation(View paramView1, final View paramView2, final boolean paramBoolean1, boolean paramBoolean2)
  {
    paramView1 = new ArrayList();
    createScrimAnimation(paramView2, paramBoolean1, paramBoolean2, paramView1, new ArrayList());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    AnimatorSetCompat.playTogether(localAnimatorSet, paramView1);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!paramBoolean1) {
          paramView2.setVisibility(4);
        }
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        if (paramBoolean1) {
          paramView2.setVisibility(0);
        }
      }
    });
    return localAnimatorSet;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
}
