package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class XAxisRendererRadarChart
  extends XAxisRenderer
{
  public RadarChart mChart;
  
  public XAxisRendererRadarChart(ViewPortHandler paramViewPortHandler, XAxis paramXAxis, RadarChart paramRadarChart)
  {
    super(paramViewPortHandler, paramXAxis, null);
    mChart = paramRadarChart;
  }
  
  public void renderAxisLabels(Canvas paramCanvas)
  {
    if (mXAxis.isEnabled())
    {
      if (!mXAxis.isDrawLabelsEnabled()) {
        return;
      }
      float f1 = mXAxis.getLabelRotationAngle();
      PointF localPointF1 = new PointF(0.5F, 0.0F);
      mAxisLabelPaint.setTypeface(mXAxis.getTypeface());
      mAxisLabelPaint.setTextSize(mXAxis.getTextSize());
      mAxisLabelPaint.setColor(mXAxis.getTextColor());
      float f2 = mChart.getSliceAngle();
      float f3 = mChart.getFactor();
      PointF localPointF2 = mChart.getCenterOffsets();
      int j = mXAxis.mAxisLabelModulus;
      int i = 0;
      while (i < mXAxis.getValues().size())
      {
        String str = (String)mXAxis.getValues().get(i);
        float f4 = i;
        float f5 = mChart.getRotationAngle();
        float f6 = mChart.getYRange();
        PointF localPointF3 = Utils.getPosition(localPointF2, mXAxis.mLabelRotatedWidth / 2.0F + f6 * f3, (f5 + f4 * f2) % 360.0F);
        drawLabel(paramCanvas, str, i, x, y - mXAxis.mLabelRotatedHeight / 2.0F, localPointF1, f1);
        i += j;
      }
    }
  }
  
  public void renderLimitLines(Canvas paramCanvas) {}
}
