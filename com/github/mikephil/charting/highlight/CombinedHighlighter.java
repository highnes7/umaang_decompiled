package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.SelectionDetail;
import com.github.mikephil.charting.utils.Transformer;
import java.util.ArrayList;
import java.util.List;

public class CombinedHighlighter
  extends ChartHighlighter<BarLineScatterCandleBubbleDataProvider>
{
  public CombinedHighlighter(BarLineScatterCandleBubbleDataProvider paramBarLineScatterCandleBubbleDataProvider)
  {
    super(paramBarLineScatterCandleBubbleDataProvider);
  }
  
  public List getSelectionDetailsAtIndex(int paramInt)
  {
    List localList = ((CombinedData)mChart.getData()).getAllData();
    ArrayList localArrayList = new ArrayList();
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < localList.size())
    {
      int j = 0;
      while (j < ((ChartData)localList.get(i)).getDataSetCount())
      {
        IDataSet localIDataSet = ((ChartData)localList.get(i)).getDataSetByIndex(j);
        if (localIDataSet.isHighlightEnabled())
        {
          float f = localIDataSet.getYValForXIndex(paramInt);
          if (f != NaN.0F)
          {
            arrayOfFloat[1] = f;
            mChart.getTransformer(localIDataSet.getAxisDependency()).pointValuesToPixel(arrayOfFloat);
            if (!Float.isNaN(arrayOfFloat[1])) {
              localArrayList.add(new SelectionDetail(arrayOfFloat[1], j, localIDataSet));
            }
          }
        }
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
}
