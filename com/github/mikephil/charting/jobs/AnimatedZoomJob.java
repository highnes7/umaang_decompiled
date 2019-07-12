package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import f.sufficientlysecure.rootcommands.util.StringBuilder;

@SuppressLint({"NewApi"})
public class AnimatedZoomJob
  extends AnimatedViewPortJob
  implements Animator.AnimatorListener
{
  public float xValCount;
  public YAxis yAxis;
  public float zoomCenterX;
  public float zoomCenterY;
  public float zoomOriginX;
  public float zoomOriginY;
  
  public AnimatedZoomJob(ViewPortHandler paramViewPortHandler, View paramView, Transformer paramTransformer, YAxis paramYAxis, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, long paramLong)
  {
    super(paramViewPortHandler, paramFloat2, paramFloat3, paramTransformer, paramView, paramFloat4, paramFloat5, paramLong);
    zoomCenterX = paramFloat6;
    zoomCenterY = paramFloat7;
    zoomOriginX = paramFloat8;
    zoomOriginY = paramFloat9;
    animator.addListener(this);
    yAxis = paramYAxis;
    xValCount = paramFloat1;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ((BarLineChartBase)view).calculateOffsets();
    view.postInvalidate();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = xOrigin;
    float f2 = xValue;
    float f3 = phase;
    float f4 = yOrigin;
    f4 = StringBuilder.append(yValue, f4, f3, f4);
    paramValueAnimator = mViewPortHandler.setZoom((f2 - f1) * f3 + f1, f4);
    mViewPortHandler.refresh(paramValueAnimator, view, false);
    f1 = yAxis.mAxisRange / mViewPortHandler.getScaleY();
    f2 = xValCount / mViewPortHandler.getScaleX();
    paramValueAnimator = pts;
    f3 = zoomOriginX;
    f4 = zoomCenterX;
    float f5 = f2 / 2.0F;
    f2 = phase;
    paramValueAnimator[0] = ((f4 - f5 - f3) * f2 + f3);
    f3 = zoomOriginY;
    f4 = zoomCenterY;
    paramValueAnimator[1] = ((f1 / 2.0F + f4 - f3) * f2 + f3);
    mTrans.pointValuesToPixel(paramValueAnimator);
    paramValueAnimator = mViewPortHandler.translate(pts);
    mViewPortHandler.refresh(paramValueAnimator, view, true);
  }
}
