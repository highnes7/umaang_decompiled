package support.android.asm;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;

public class MapController
{
  public MapController() {}
  
  public static void onAnimationEnd(Animator paramAnimator)
  {
    int i = Build.VERSION.SDK_INT;
    paramAnimator.resume();
  }
  
  public static void onAnimationEnd(Animator paramAnimator, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    int i = Build.VERSION.SDK_INT;
    paramAnimator.addPauseListener(paramAnimatorListenerAdapter);
  }
  
  public static void stopAnimation(Animator paramAnimator)
  {
    int i = Build.VERSION.SDK_INT;
    paramAnimator.pause();
  }
}
