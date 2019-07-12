package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class Renderer
{
  public int mMaxX = 0;
  public int mMinX = 0;
  public ViewPortHandler mViewPortHandler;
  
  public Renderer(ViewPortHandler paramViewPortHandler)
  {
    mViewPortHandler = paramViewPortHandler;
  }
  
  public void calcXBounds(BarLineScatterCandleBubbleDataProvider paramBarLineScatterCandleBubbleDataProvider, int paramInt)
  {
    int j = paramBarLineScatterCandleBubbleDataProvider.getLowestVisibleXIndex();
    int k = paramBarLineScatterCandleBubbleDataProvider.getHighestVisibleXIndex();
    int i;
    if (j % paramInt == 0) {
      i = paramInt;
    } else {
      i = 0;
    }
    mMinX = Math.max(j / paramInt * paramInt - i, 0);
    mMaxX = Math.min(k / paramInt * paramInt + paramInt, (int)paramBarLineScatterCandleBubbleDataProvider.getXChartMax());
  }
  
  public boolean fitsBounds(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat1 >= paramFloat2) && (paramFloat1 <= paramFloat3);
  }
}
