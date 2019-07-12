package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LineChartRenderer;

public class LineChart
  extends BarLineChartBase<LineData>
  implements LineDataProvider
{
  public LineChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public LineChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LineChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void calcMinMax()
  {
    super.calcMinMax();
    if ((mXAxis.mAxisRange == 0.0F) && (((LineData)mData).getYValCount() > 0)) {
      mXAxis.mAxisRange = 1.0F;
    }
  }
  
  public LineData getLineData()
  {
    return (LineData)mData;
  }
  
  public void init()
  {
    super.init();
    mRenderer = new LineChartRenderer(this, mAnimator, mViewPortHandler);
  }
  
  public void onDetachedFromWindow()
  {
    DataRenderer localDataRenderer = mRenderer;
    if ((localDataRenderer != null) && ((localDataRenderer instanceof LineChartRenderer))) {
      ((LineChartRenderer)localDataRenderer).releaseBitmap();
    }
    super.onDetachedFromWindow();
  }
}
