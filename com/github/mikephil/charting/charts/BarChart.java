package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererBarChart;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class BarChart
  extends BarLineChartBase<BarData>
  implements BarDataProvider
{
  public boolean mDrawBarShadow = false;
  public boolean mDrawHighlightArrow = false;
  public boolean mDrawValueAboveBar = true;
  
  public BarChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public BarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void calcMinMax()
  {
    super.calcMinMax();
    XAxis localXAxis = mXAxis;
    mAxisRange += 0.5F;
    mAxisRange *= ((BarData)mData).getDataSetCount();
    float f1 = ((BarData)mData).getGroupSpace();
    localXAxis = mXAxis;
    float f2 = mAxisRange;
    mAxisRange = (((BarData)mData).getXValCount() * f1 + f2);
    localXAxis = mXAxis;
    mAxisMaximum = (mAxisRange - mAxisMinimum);
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
    paramBarEntry = new RectF(f4 - 0.5F + f5, f2, f4 + 0.5F - f5, f3);
    getTransformer(localIBarDataSet.getAxisDependency()).rectValueToPixel(paramBarEntry);
    return paramBarEntry;
  }
  
  public BarData getBarData()
  {
    return (BarData)mData;
  }
  
  public int getHighestVisibleXIndex()
  {
    float f2 = ((BarData)mData).getDataSetCount();
    float f1 = 1.0F;
    if (f2 > 1.0F) {
      f1 = ((BarData)mData).getGroupSpace() + f2;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = mViewPortHandler.contentRight();
    arrayOfFloat[1] = mViewPortHandler.contentBottom();
    getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(arrayOfFloat);
    if (arrayOfFloat[0] >= getXChartMax()) {
      f2 = getXChartMax();
    } else {
      f2 = arrayOfFloat[0];
    }
    return (int)(f2 / f1);
  }
  
  public Highlight getHighlightByTouchPoint(float paramFloat1, float paramFloat2)
  {
    if (mData == null) {
      return null;
    }
    return getHighlighter().getHighlight(paramFloat1, paramFloat2);
  }
  
  public int getLowestVisibleXIndex()
  {
    float f = ((BarData)mData).getDataSetCount();
    if (f <= 1.0F) {
      f = 1.0F;
    } else {
      f += ((BarData)mData).getGroupSpace();
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = mViewPortHandler.contentLeft();
    arrayOfFloat[1] = mViewPortHandler.contentBottom();
    getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(arrayOfFloat);
    if (arrayOfFloat[0] <= getXChartMin()) {
      f = 0.0F;
    } else {
      f = arrayOfFloat[0] / f + 1.0F;
    }
    return (int)f;
  }
  
  public void init()
  {
    super.init();
    mRenderer = new BarChartRenderer(this, mAnimator, mViewPortHandler);
    mXAxisRenderer = new XAxisRendererBarChart(mViewPortHandler, mXAxis, mLeftAxisTransformer, this);
    setHighlighter(new BarHighlighter(this));
    mXAxis.mAxisMinimum = -0.5F;
  }
  
  public boolean isDrawBarShadowEnabled()
  {
    return mDrawBarShadow;
  }
  
  public boolean isDrawHighlightArrowEnabled()
  {
    return mDrawHighlightArrow;
  }
  
  public boolean isDrawValueAboveBarEnabled()
  {
    return mDrawValueAboveBar;
  }
  
  public void setDrawBarShadow(boolean paramBoolean)
  {
    mDrawBarShadow = paramBoolean;
  }
  
  public void setDrawHighlightArrow(boolean paramBoolean)
  {
    mDrawHighlightArrow = paramBoolean;
  }
  
  public void setDrawValueAboveBar(boolean paramBoolean)
  {
    mDrawValueAboveBar = paramBoolean;
  }
}
