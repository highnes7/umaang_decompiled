package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Iterator;
import java.util.List;

public class BubbleData
  extends BarLineScatterCandleBubbleData<IBubbleDataSet>
{
  public BubbleData() {}
  
  public BubbleData(List paramList)
  {
    super(paramList);
  }
  
  public BubbleData(List paramList, IBubbleDataSet paramIBubbleDataSet)
  {
    super(paramList, toList(paramIBubbleDataSet));
  }
  
  public BubbleData(List paramList1, List paramList2)
  {
    super(paramList1, paramList2);
  }
  
  public BubbleData(String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  public BubbleData(String[] paramArrayOfString, IBubbleDataSet paramIBubbleDataSet)
  {
    super(paramArrayOfString, toList(paramIBubbleDataSet));
  }
  
  public BubbleData(String[] paramArrayOfString, List paramList)
  {
    super(paramArrayOfString, paramList);
  }
  
  public static List toList(IBubbleDataSet paramIBubbleDataSet)
  {
    return StringBuilder.newArrayList(paramIBubbleDataSet);
  }
  
  public void setHighlightCircleWidth(float paramFloat)
  {
    Iterator localIterator = mDataSets.iterator();
    while (localIterator.hasNext()) {
      ((IBubbleDataSet)localIterator.next()).setHighlightCircleWidth(paramFloat);
    }
  }
}
