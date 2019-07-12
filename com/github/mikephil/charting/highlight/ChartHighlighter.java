package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.SelectionDetail;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider>
{
  public T mChart;
  
  public ChartHighlighter(BarLineScatterCandleBubbleDataProvider paramBarLineScatterCandleBubbleDataProvider)
  {
    mChart = paramBarLineScatterCandleBubbleDataProvider;
  }
  
  public int getDataSetIndex(int paramInt, float paramFloat1, float paramFloat2)
  {
    List localList = getSelectionDetailsAtIndex(paramInt);
    YAxis.AxisDependency localAxisDependency;
    if (Utils.getMinimumDistance(localList, paramFloat2, YAxis.AxisDependency.LEFT) < Utils.getMinimumDistance(localList, paramFloat2, YAxis.AxisDependency.RIGHT)) {
      localAxisDependency = YAxis.AxisDependency.LEFT;
    } else {
      localAxisDependency = YAxis.AxisDependency.RIGHT;
    }
    return Utils.getClosestDataSetIndex(localList, paramFloat2, localAxisDependency);
  }
  
  public Highlight getHighlight(float paramFloat1, float paramFloat2)
  {
    int i = getXIndex(paramFloat1);
    if (i == -2147483647) {
      return null;
    }
    int j = getDataSetIndex(i, paramFloat1, paramFloat2);
    if (j == -2147483647) {
      return null;
    }
    return new Highlight(i, j);
  }
  
  public List getSelectionDetailsAtIndex(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < mChart.getData().getDataSetCount())
    {
      IDataSet localIDataSet = mChart.getData().getDataSetByIndex(i);
      if (localIDataSet.isHighlightEnabled())
      {
        float f = localIDataSet.getYValForXIndex(paramInt);
        if (f != NaN.0F)
        {
          arrayOfFloat[1] = f;
          mChart.getTransformer(localIDataSet.getAxisDependency()).pointValuesToPixel(arrayOfFloat);
          if (!Float.isNaN(arrayOfFloat[1])) {
            localArrayList.add(new SelectionDetail(arrayOfFloat[1], i, localIDataSet));
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public int getXIndex(float paramFloat)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat;
    mChart.getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(arrayOfFloat);
    return Math.round(arrayOfFloat[0]);
  }
}
