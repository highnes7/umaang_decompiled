package com.github.mikephil.charting.jobs;

import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class ZoomJob
  extends ViewPortJob
{
  public YAxis.AxisDependency axisDependency;
  public float scaleX;
  public float scaleY;
  
  public ZoomJob(ViewPortHandler paramViewPortHandler, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Transformer paramTransformer, YAxis.AxisDependency paramAxisDependency, View paramView)
  {
    super(paramViewPortHandler, paramFloat3, paramFloat4, paramTransformer, paramView);
    scaleX = paramFloat1;
    scaleY = paramFloat2;
    axisDependency = paramAxisDependency;
  }
  
  public void run()
  {
    Object localObject = mViewPortHandler.zoom(scaleX, scaleY);
    mViewPortHandler.refresh((Matrix)localObject, view, false);
    float f1 = ((BarLineChartBase)view).getDeltaY(axisDependency) / mViewPortHandler.getScaleY();
    float f2 = ((BarLineChartBase)view).getXAxis().getValues().size() / mViewPortHandler.getScaleX();
    localObject = pts;
    localObject[0] = (xValue - f2 / 2.0F);
    f2 = yValue;
    localObject[1] = (f1 / 2.0F + f2);
    mTrans.pointValuesToPixel((float[])localObject);
    localObject = mViewPortHandler.translate(pts);
    mViewPortHandler.refresh((Matrix)localObject, view, false);
    ((BarLineChartBase)view).calculateOffsets();
    view.postInvalidate();
  }
}
