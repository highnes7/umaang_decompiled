package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class ViewPortJob
  implements Runnable
{
  public Transformer mTrans;
  public ViewPortHandler mViewPortHandler;
  public float[] pts = new float[2];
  public View view;
  public float xValue = 0.0F;
  public float yValue = 0.0F;
  
  public ViewPortJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Transformer paramTransformer, View paramView)
  {
    mViewPortHandler = paramViewPortHandler;
    xValue = paramFloat1;
    yValue = paramFloat2;
    mTrans = paramTransformer;
    view = paramView;
  }
  
  public float getXValue()
  {
    return xValue;
  }
  
  public float getYValue()
  {
    return yValue;
  }
}
