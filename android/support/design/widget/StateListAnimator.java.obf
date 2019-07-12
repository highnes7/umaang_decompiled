package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import b.b.a.N;
import java.util.ArrayList;

@N({b.b.a.N.a.b})
public final class StateListAnimator
{
  public final Animator.AnimatorListener animationListener = new AnimatorListenerAdapter()
  {
    public void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      StateListAnimator localStateListAnimator = StateListAnimator.this;
      if (runningAnimator == paramAnonymousAnimator) {
        runningAnimator = null;
      }
    }
  };
  public Tuple lastMatch = null;
  public ValueAnimator runningAnimator = null;
  public final ArrayList<Tuple> tuples = new ArrayList();
  
  public StateListAnimator() {}
  
  private void cancel()
  {
    ValueAnimator localValueAnimator = runningAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      runningAnimator = null;
    }
  }
  
  private void start(Tuple paramTuple)
  {
    runningAnimator = animator;
    runningAnimator.start();
  }
  
  public void addState(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new Tuple(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(animationListener);
    tuples.add(paramArrayOfInt);
  }
  
  public void jumpToCurrentState()
  {
    ValueAnimator localValueAnimator = runningAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.end();
      runningAnimator = null;
    }
  }
  
  public void setState(int[] paramArrayOfInt)
  {
    int j = tuples.size();
    int i = 0;
    while (i < j)
    {
      localTuple = (Tuple)tuples.get(i);
      if (StateSet.stateSetMatches(specs, paramArrayOfInt))
      {
        paramArrayOfInt = localTuple;
        break label55;
      }
      i += 1;
    }
    paramArrayOfInt = null;
    label55:
    Tuple localTuple = lastMatch;
    if (paramArrayOfInt == localTuple) {
      return;
    }
    if (localTuple != null) {
      cancel();
    }
    lastMatch = paramArrayOfInt;
    if (paramArrayOfInt != null) {
      start(paramArrayOfInt);
    }
  }
  
  public static class Tuple
  {
    public final ValueAnimator animator;
    public final int[] specs;
    
    public Tuple(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
    {
      specs = paramArrayOfInt;
      animator = paramValueAnimator;
    }
  }
}
