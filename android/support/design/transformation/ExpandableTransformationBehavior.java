package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import b.b.a.G;

public abstract class ExpandableTransformationBehavior
  extends ExpandableBehavior
{
  @G
  public AnimatorSet currentAnimation;
  
  public ExpandableTransformationBehavior() {}
  
  public ExpandableTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public abstract AnimatorSet onCreateExpandedStateChangeAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
  
  public boolean onExpandedStateChange(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if (currentAnimation != null) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      currentAnimation.cancel();
    }
    currentAnimation = onCreateExpandedStateChangeAnimation(paramView1, paramView2, paramBoolean1, bool);
    currentAnimation.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        currentAnimation = null;
      }
    });
    currentAnimation.start();
    if (!paramBoolean2) {
      currentAnimation.end();
    }
    return true;
  }
}
