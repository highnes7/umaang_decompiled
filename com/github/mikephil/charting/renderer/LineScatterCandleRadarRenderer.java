package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class LineScatterCandleRadarRenderer
  extends DataRenderer
{
  public Path mHighlightLinePath = new Path();
  
  public LineScatterCandleRadarRenderer(ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
  }
  
  public void drawHighlightLines(Canvas paramCanvas, float[] paramArrayOfFloat, ILineScatterCandleRadarDataSet paramILineScatterCandleRadarDataSet)
  {
    mHighlightPaint.setColor(paramILineScatterCandleRadarDataSet.getHighLightColor());
    mHighlightPaint.setStrokeWidth(paramILineScatterCandleRadarDataSet.getHighlightLineWidth());
    mHighlightPaint.setPathEffect(paramILineScatterCandleRadarDataSet.getDashPathEffectHighlight());
    if (paramILineScatterCandleRadarDataSet.isVerticalHighlightIndicatorEnabled())
    {
      mHighlightLinePath.reset();
      mHighlightLinePath.moveTo(paramArrayOfFloat[0], mViewPortHandler.contentTop());
      mHighlightLinePath.lineTo(paramArrayOfFloat[0], mViewPortHandler.contentBottom());
      paramCanvas.drawPath(mHighlightLinePath, mHighlightPaint);
    }
    if (paramILineScatterCandleRadarDataSet.isHorizontalHighlightIndicatorEnabled())
    {
      mHighlightLinePath.reset();
      mHighlightLinePath.moveTo(mViewPortHandler.contentLeft(), paramArrayOfFloat[1]);
      mHighlightLinePath.lineTo(mViewPortHandler.contentRight(), paramArrayOfFloat[1]);
      paramCanvas.drawPath(mHighlightLinePath, mHighlightPaint);
    }
  }
}
