package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.renderer.BubbleChartRenderer;
import java.util.Iterator;
import java.util.List;

public class BubbleChart
  extends BarLineChartBase<BubbleData>
  implements BubbleDataProvider
{
  public BubbleChart(Context paramContext)
  {
    super(paramContext);
  }
  
  public BubbleChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BubbleChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void calcMinMax()
  {
    super.calcMinMax();
    Object localObject2 = mXAxis;
    Object localObject1 = this;
    if ((mAxisRange == 0.0F) && (((BubbleData)mData).getYValCount() > 0)) {
      mXAxis.mAxisRange = 1.0F;
    }
    localObject1 = this;
    localObject2 = mXAxis;
    mAxisMinimum = -0.5F;
    mAxisMaximum = (((BubbleData)mData).getXValCount() - 0.5F);
    localObject2 = localObject1;
    if (mRenderer != null)
    {
      Iterator localIterator = ((BubbleData)mData).getDataSets().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (IBubbleDataSet)localIterator.next();
        float f1 = ((IBubbleDataSet)localObject2).getXMin();
        float f2 = ((IBubbleDataSet)localObject2).getXMax();
        localObject2 = mXAxis;
        if (f1 < mAxisMinimum) {
          mAxisMinimum = f1;
        }
        XAxis localXAxis = mXAxis;
        localObject2 = localObject1;
        localObject1 = localObject2;
        if (f2 > mAxisMaximum)
        {
          mAxisMaximum = f2;
          localObject1 = localObject2;
        }
      }
    }
    localObject1 = mXAxis;
    mAxisRange = Math.abs(mAxisMaximum - mAxisMinimum);
  }
  
  public BubbleData getBubbleData()
  {
    return (BubbleData)mData;
  }
  
  public void init()
  {
    super.init();
    mRenderer = new BubbleChartRenderer(this, mAnimator, mViewPortHandler);
  }
}
