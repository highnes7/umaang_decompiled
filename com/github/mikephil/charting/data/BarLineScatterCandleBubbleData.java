package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.List;

public abstract class BarLineScatterCandleBubbleData<T extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>
  extends ChartData<T>
{
  public BarLineScatterCandleBubbleData() {}
  
  public BarLineScatterCandleBubbleData(List paramList)
  {
    super(paramList);
  }
  
  public BarLineScatterCandleBubbleData(List paramList1, List paramList2)
  {
    super(paramList1, paramList2);
  }
  
  public BarLineScatterCandleBubbleData(String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  public BarLineScatterCandleBubbleData(String[] paramArrayOfString, List paramList)
  {
    super(paramArrayOfString, paramList);
  }
}
