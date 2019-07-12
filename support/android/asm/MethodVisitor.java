package support.android.asm;

import android.animation.Animator;

public abstract interface MethodVisitor
{
  public abstract void onAnimationPause(Animator paramAnimator);
  
  public abstract void onAnimationResume(Animator paramAnimator);
}
