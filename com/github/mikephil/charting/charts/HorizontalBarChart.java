package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.HorizontalBarHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.renderer.AxisRenderer;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class HorizontalBarChart
  extends BarChart
{
  public HorizontalBarChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalBarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalBarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void calcModulus()
  {
    Object localObject = new float[9];
    mViewPortHandler.getMatrixTouch().getValues((float[])localObject);
    mXAxis.mAxisLabelModulus = ((int)Math.ceil(((BarData)mData).getXValCount() * mXAxis.mLabelRotatedHeight / (mViewPortHandler.contentHeight() * localObject[4])));
    localObject = mXAxis;
    if (mAxisLabelModulus < 1) {
      mAxisLabelModulus = 1;
    }
  }
  
  public void calculateOffsets()
  {
    Object localObject = mLegend;
    float f3 = 0.0F;
    float f2 = 0.0F;
    float f4 = 0.0F;
    float f5 = 0.0F;
    float f1 = f5;
    if (localObject != null)
    {
      f1 = f5;
      if (((ComponentBase)localObject).isEnabled()) {
        if ((mLegend.getPosition() != Legend.LegendPosition.RIGHT_OF_CHART) && (mLegend.getPosition() != Legend.LegendPosition.RIGHT_OF_CHART_CENTER))
        {
          if ((mLegend.getPosition() != Legend.LegendPosition.LEFT_OF_CHART) && (mLegend.getPosition() != Legend.LegendPosition.LEFT_OF_CHART_CENTER))
          {
            if ((mLegend.getPosition() != Legend.LegendPosition.BELOW_CHART_LEFT) && (mLegend.getPosition() != Legend.LegendPosition.BELOW_CHART_RIGHT) && (mLegend.getPosition() != Legend.LegendPosition.BELOW_CHART_CENTER))
            {
              if ((mLegend.getPosition() != Legend.LegendPosition.ABOVE_CHART_LEFT) && (mLegend.getPosition() != Legend.LegendPosition.ABOVE_CHART_RIGHT))
              {
                f1 = f5;
                if (mLegend.getPosition() != Legend.LegendPosition.ABOVE_CHART_CENTER) {}
              }
              else
              {
                localObject = mLegend;
                f1 = mTextHeightMax;
                f2 = mNeededHeight;
                f3 = mViewPortHandler.getChartHeight();
                f1 = Math.min(f2 + f1 * 2.0F, mLegend.getMaxSizePercent() * f3) + 0.0F;
              }
            }
            else
            {
              localObject = mLegend;
              f1 = mTextHeightMax;
              f2 = mNeededHeight;
              f4 = mViewPortHandler.getChartHeight();
              f1 = Math.min(f2 + f1, mLegend.getMaxSizePercent() * f4) + 0.0F;
              f4 = f3;
              f3 = f1;
              break label388;
            }
          }
          else
          {
            f1 = mLegend.mNeededWidth;
            f3 = mViewPortHandler.getChartWidth();
            f1 = Math.min(f1, mLegend.getMaxSizePercent() * f3);
            f1 = mLegend.getXOffset() * 2.0F + f1 + 0.0F;
            f3 = 0.0F;
            f4 = f2;
            break label390;
          }
        }
        else
        {
          f1 = mLegend.mNeededWidth;
          f2 = mViewPortHandler.getChartWidth();
          f1 = Math.min(f1, mLegend.getMaxSizePercent() * f2);
          f2 = mLegend.getXOffset() * 2.0F + f1 + 0.0F;
          f3 = 0.0F;
          f1 = 0.0F;
          break label392;
        }
      }
    }
    f3 = 0.0F;
    f4 = f1;
    label388:
    f1 = 0.0F;
    label390:
    f2 = 0.0F;
    label392:
    f5 = f4;
    if (mAxisLeft.needsOffset()) {
      f5 = f4 + mAxisLeft.getRequiredHeightSpace(mAxisRendererLeft.getPaintAxisLabels());
    }
    f4 = f3;
    if (mAxisRight.needsOffset()) {
      f4 = f3 + mAxisRight.getRequiredHeightSpace(mAxisRendererRight.getPaintAxisLabels());
    }
    localObject = mXAxis;
    float f7 = mLabelRotatedWidth;
    f3 = f1;
    float f6 = f2;
    if (((ComponentBase)localObject).isEnabled()) {
      if (mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM)
      {
        f3 = f1 + f7;
        f6 = f2;
      }
      else
      {
        if (mXAxis.getPosition() == XAxis.XAxisPosition.TOP) {}
        for (;;)
        {
          f6 = f2 + f7;
          f3 = f1;
          break;
          f3 = f1;
          f6 = f2;
          if (mXAxis.getPosition() != XAxis.XAxisPosition.BOTH_SIDED) {
            break;
          }
          f1 += f7;
        }
      }
    }
    f1 = getExtraTopOffset() + f5;
    f2 = getExtraRightOffset() + f6;
    f4 = getExtraBottomOffset() + f4;
    f3 = getExtraLeftOffset() + f3;
    f5 = Utils.convertDpToPixel(mMinOffset);
    mViewPortHandler.restrainViewPort(Math.max(f5, f3), Math.max(f5, f1), Math.max(f5, f2), Math.max(f5, f4));
    if (mLogEnabled)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("offsetLeft: ");
      ((StringBuilder)localObject).append(f3);
      ((StringBuilder)localObject).append(", offsetTop: ");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(", offsetRight: ");
      ((StringBuilder)localObject).append(f2);
      ((StringBuilder)localObject).append(", offsetBottom: ");
      ((StringBuilder)localObject).append(f4);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Content: ");
      ((StringBuilder)localObject).append(mViewPortHandler.getContentRect().toString());
      ((StringBuilder)localObject).toString();
    }
    prepareOffsetMatrix();
    prepareValuePxMatrix();
  }
  
  public RectF getBarBounds(BarEntry paramBarEntry)
  {
    IBarDataSet localIBarDataSet = (IBarDataSet)((BarData)mData).getDataSetForEntry(paramBarEntry);
    if (localIBarDataSet == null) {
      return null;
    }
    float f2 = localIBarDataSet.getBarSpace();
    float f1 = paramBarEntry.getVal();
    float f4 = paramBarEntry.getXIndex();
    float f5 = f2 / 2.0F;
    float f3 = 0.0F;
    if (f1 >= 0.0F) {
      f2 = f1;
    } else {
      f2 = 0.0F;
    }
    if (f1 <= 0.0F) {
      f3 = f1;
    }
    paramBarEntry = new RectF(f2, f4 - 0.5F + f5, f3, f4 + 0.5F - f5);
    getTransformer(localIBarDataSet.getAxisDependency()).rectValueToPixel(paramBarEntry);
    return paramBarEntry;
  }
  
  public int getHighestVisibleXIndex()
  {
    float f2 = ((BarData)mData).getDataSetCount();
    float f1 = 1.0F;
    if (f2 > 1.0F) {
      f1 = ((BarData)mData).getGroupSpace() + f2;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = mViewPortHandler.contentLeft();
    arrayOfFloat[1] = mViewPortHandler.contentTop();
    getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(arrayOfFloat);
    if (arrayOfFloat[1] >= getXChartMax()) {
      f2 = getXChartMax();
    } else {
      f2 = arrayOfFloat[1];
    }
    return (int)(f2 / f1);
  }
  
  public Highlight getHighlightByTouchPoint(float paramFloat1, float paramFloat2)
  {
    if (mData == null) {
      return null;
    }
    return getHighlighter().getHighlight(paramFloat2, paramFloat1);
  }
  
  public int getLowestVisibleXIndex()
  {
    float f1 = ((BarData)mData).getDataSetCount();
    if (f1 <= 1.0F) {
      f1 = 1.0F;
    } else {
      f1 += ((BarData)mData).getGroupSpace();
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = mViewPortHandler.contentLeft();
    arrayOfFloat[1] = mViewPortHandler.contentBottom();
    getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(arrayOfFloat);
    float f3 = arrayOfFloat[1];
    float f2 = 0.0F;
    if (f3 <= 0.0F) {
      f1 = f2;
    } else {
      f1 = arrayOfFloat[1] / f1;
    }
    return (int)(f1 + 1.0F);
  }
  
  public PointF getPosition(Entry paramEntry, YAxis.AxisDependency paramAxisDependency)
  {
    if (paramEntry == null) {
      return null;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramEntry.getVal();
    arrayOfFloat[1] = paramEntry.getXIndex();
    getTransformer(paramAxisDependency).pointValuesToPixel(arrayOfFloat);
    return new PointF(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public void init()
  {
    super.init();
    mLeftAxisTransformer = new TransformerHorizontalBarChart(mViewPortHandler);
    mRightAxisTransformer = new TransformerHorizontalBarChart(mViewPortHandler);
    mRenderer = new HorizontalBarChartRenderer(this, mAnimator, mViewPortHandler);
    setHighlighter(new HorizontalBarHighlighter(this));
    mAxisRendererLeft = new YAxisRendererHorizontalBarChart(mViewPortHandler, mAxisLeft, mLeftAxisTransformer);
    mAxisRendererRight = new YAxisRendererHorizontalBarChart(mViewPortHandler, mAxisRight, mRightAxisTransformer);
    mXAxisRenderer = new XAxisRendererHorizontalBarChart(mViewPortHandler, mXAxis, mLeftAxisTransformer, this);
  }
  
  public void prepareValuePxMatrix()
  {
    Transformer localTransformer = mRightAxisTransformer;
    Object localObject = mAxisRight;
    float f1 = mAxisMinimum;
    float f2 = mAxisRange;
    localObject = mXAxis;
    localTransformer.prepareMatrixValuePx(f1, f2, mAxisRange, mAxisMinimum);
    localTransformer = mLeftAxisTransformer;
    localObject = mAxisLeft;
    f1 = mAxisMinimum;
    f2 = mAxisRange;
    localObject = mXAxis;
    localTransformer.prepareMatrixValuePx(f1, f2, mAxisRange, mAxisMinimum);
  }
}
