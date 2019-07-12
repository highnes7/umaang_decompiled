package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.List;

public class LineData
  extends BarLineScatterCandleBubbleData<ILineDataSet>
{
  public LineData() {}
  
  public LineData(List paramList)
  {
    super(paramList);
  }
  
  public LineData(List paramList, ILineDataSet paramILineDataSet)
  {
    super(paramList, toList(paramILineDataSet));
  }
  
  public LineData(List paramList1, List paramList2)
  {
    super(paramList1, paramList2);
  }
  
  public LineData(String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  public LineData(String[] paramArrayOfString, ILineDataSet paramILineDataSet)
  {
    super(paramArrayOfString, toList(paramILineDataSet));
  }
  
  public LineData(String[] paramArrayOfString, List paramList)
  {
    super(paramArrayOfString, paramList);
  }
  
  public static List toList(ILineDataSet paramILineDataSet)
  {
    return StringBuilder.newArrayList(paramILineDataSet);
  }
}
