package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.renderer.RadarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererRadarChart;
import com.github.mikephil.charting.renderer.YAxisRendererRadarChart;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class RadarChart
  extends PieRadarChartBase<RadarData>
{
  public boolean mDrawWeb = true;
  public float mInnerWebLineWidth = 1.5F;
  public int mSkipWebLineCount = 0;
  public int mWebAlpha = 150;
  public int mWebColor = Color.rgb(122, 122, 122);
  public int mWebColorInner = Color.rgb(122, 122, 122);
  public float mWebLineWidth = 2.5F;
  public XAxisRendererRadarChart mXAxisRenderer;
  public YAxis mYAxis;
  public YAxisRendererRadarChart mYAxisRenderer;
  
  public RadarChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void calcMinMax()
  {
    super.calcMinMax();
    mXAxis.mAxisMaximum = (((RadarData)mData).getXVals().size() - 1);
    XAxis localXAxis = mXAxis;
    mAxisRange = Math.abs(mAxisMaximum - mAxisMinimum);
    mYAxis.calcMinMax(((RadarData)mData).getYMin(YAxis.AxisDependency.LEFT), ((RadarData)mData).getYMax(YAxis.AxisDependency.LEFT));
  }
  
  public float getFactor()
  {
    RectF localRectF = mViewPortHandler.getContentRect();
    return Math.min(localRectF.width() / 2.0F, localRectF.height() / 2.0F) / mYAxis.mAxisRange;
  }
  
  public int getIndexForAngle(float paramFloat)
  {
    paramFloat = Utils.getNormalizedAngle(paramFloat - getRotationAngle());
    float f = getSliceAngle();
    int j;
    for (int i = 0; i < ((RadarData)mData).getXValCount(); i = j)
    {
      j = i + 1;
      if (j * f - f / 2.0F > paramFloat) {
        return i;
      }
    }
    return 0;
  }
  
  public float[] getMarkerPosition(Entry paramEntry, Highlight paramHighlight)
  {
    float f1 = getSliceAngle();
    float f2 = paramEntry.getXIndex();
    float f3 = getRotationAngle();
    float f4 = paramEntry.getVal();
    float f5 = getFactor();
    paramEntry = getCenterOffsets();
    double d3 = x;
    double d1 = f5 * f4;
    double d2 = f3 + f1 * f2;
    double d4 = Math.cos(Math.toRadians(d2));
    Double.isNaN(d1);
    Double.isNaN(d3);
    f1 = (float)(d4 * d1 + d3);
    d3 = y;
    d2 = Math.sin(Math.toRadians(d2));
    Double.isNaN(d1);
    Double.isNaN(d3);
    paramEntry = new PointF(f1, (float)(d2 * d1 + d3));
    return new float[] { x, y };
  }
  
  public float getRadius()
  {
    RectF localRectF = mViewPortHandler.getContentRect();
    return Math.min(localRectF.width() / 2.0F, localRectF.height() / 2.0F);
  }
  
  public float getRequiredBaseOffset()
  {
    if ((mXAxis.isEnabled()) && (mXAxis.isDrawLabelsEnabled())) {
      return mXAxis.mLabelRotatedWidth;
    }
    return Utils.convertDpToPixel(10.0F);
  }
  
  public float getRequiredLegendOffset()
  {
    return mLegendRenderer.getLabelPaint().getTextSize() * 4.0F;
  }
  
  public int getSkipWebLineCount()
  {
    return mSkipWebLineCount;
  }
  
  public float getSliceAngle()
  {
    return 360.0F / ((RadarData)mData).getXValCount();
  }
  
  public int getWebAlpha()
  {
    return mWebAlpha;
  }
  
  public int getWebColor()
  {
    return mWebColor;
  }
  
  public int getWebColorInner()
  {
    return mWebColorInner;
  }
  
  public float getWebLineWidth()
  {
    return mWebLineWidth;
  }
  
  public float getWebLineWidthInner()
  {
    return mInnerWebLineWidth;
  }
  
  public YAxis getYAxis()
  {
    return mYAxis;
  }
  
  public float getYChartMax()
  {
    return mYAxis.mAxisMaximum;
  }
  
  public float getYChartMin()
  {
    return mYAxis.mAxisMinimum;
  }
  
  public float getYRange()
  {
    return mYAxis.mAxisRange;
  }
  
  public void init()
  {
    super.init();
    mYAxis = new YAxis(YAxis.AxisDependency.LEFT);
    mXAxis.setSpaceBetweenLabels(0);
    mWebLineWidth = Utils.convertDpToPixel(1.5F);
    mInnerWebLineWidth = Utils.convertDpToPixel(0.75F);
    mRenderer = new RadarChartRenderer(this, mAnimator, mViewPortHandler);
    mYAxisRenderer = new YAxisRendererRadarChart(mViewPortHandler, mYAxis, this);
    mXAxisRenderer = new XAxisRendererRadarChart(mViewPortHandler, mXAxis, this);
  }
  
  public void notifyDataSetChanged()
  {
    if (mData == null) {
      return;
    }
    calcMinMax();
    Object localObject = mYAxisRenderer;
    YAxis localYAxis = mYAxis;
    ((YAxisRendererRadarChart)localObject).computeAxis(mAxisMinimum, mAxisMaximum);
    mXAxisRenderer.computeAxis(((RadarData)mData).getXValMaximumLength(), ((RadarData)mData).getXVals());
    localObject = mLegend;
    if ((localObject != null) && (!((Legend)localObject).isLegendCustom())) {
      mLegendRenderer.computeLegend(mData);
    }
    calculateOffsets();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (mData == null) {
      return;
    }
    mXAxisRenderer.renderAxisLabels(paramCanvas);
    if (mDrawWeb) {
      mRenderer.drawExtras(paramCanvas);
    }
    mYAxisRenderer.renderLimitLines(paramCanvas);
    mRenderer.drawData(paramCanvas);
    if (valuesToHighlight()) {
      mRenderer.drawHighlighted(paramCanvas, mIndicesToHighlight);
    }
    mYAxisRenderer.renderAxisLabels(paramCanvas);
    mRenderer.drawValues(paramCanvas);
    mLegendRenderer.renderLegend(paramCanvas);
    drawDescription(paramCanvas);
    drawMarkers(paramCanvas);
  }
  
  public void setDrawWeb(boolean paramBoolean)
  {
    mDrawWeb = paramBoolean;
  }
  
  public void setSkipWebLineCount(int paramInt)
  {
    mSkipWebLineCount = Math.max(0, paramInt);
  }
  
  public void setWebAlpha(int paramInt)
  {
    mWebAlpha = paramInt;
  }
  
  public void setWebColor(int paramInt)
  {
    mWebColor = paramInt;
  }
  
  public void setWebColorInner(int paramInt)
  {
    mWebColorInner = paramInt;
  }
  
  public void setWebLineWidth(float paramFloat)
  {
    mWebLineWidth = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setWebLineWidthInner(float paramFloat)
  {
    mInnerWebLineWidth = Utils.convertDpToPixel(paramFloat);
  }
}
