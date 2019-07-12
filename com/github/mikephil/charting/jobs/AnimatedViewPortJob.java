package com.github.mikephil.charting.jobs;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.view.View;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"NewApi"})
public abstract class AnimatedViewPortJob
  extends ViewPortJob
  implements ValueAnimator.AnimatorUpdateListener
{
  public ObjectAnimator animator;
  public float phase;
  public float xOrigin;
  public float yOrigin;
  
  public AnimatedViewPortJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Transformer paramTransformer, View paramView, float paramFloat3, float paramFloat4, long paramLong)
  {
    super(paramViewPortHandler, paramFloat1, paramFloat2, paramTransformer, paramView);
    xOrigin = paramFloat3;
    yOrigin = paramFloat4;
    animator = ObjectAnimator.ofFloat(this, "phase", new float[] { 0.0F, 1.0F });
    animator.setDuration(paramLong);
    animator.addUpdateListener(this);
  }
  
  public float getPhase()
  {
    return phase;
  }
  
  public float getXOrigin()
  {
    return xOrigin;
  }
  
  public float getYOrigin()
  {
    return yOrigin;
  }
  
  public void run()
  {
    animator.start();
  }
  
  public void setPhase(float paramFloat)
  {
    phase = paramFloat;
  }
}
