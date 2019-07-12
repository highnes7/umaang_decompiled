package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class MoveViewJob
  extends ViewPortJob
{
  public MoveViewJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, Transformer paramTransformer, View paramView)
  {
    super(paramViewPortHandler, paramFloat1, paramFloat2, paramTransformer, paramView);
  }
  
  public void run()
  {
    float[] arrayOfFloat = pts;
    arrayOfFloat[0] = xValue;
    arrayOfFloat[1] = yValue;
    mTrans.pointValuesToPixel(arrayOfFloat);
    mViewPortHandler.centerViewPort(pts, view);
  }
}
