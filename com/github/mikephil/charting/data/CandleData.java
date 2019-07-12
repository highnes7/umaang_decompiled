package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.List;

public class CandleData
  extends BarLineScatterCandleBubbleData<ICandleDataSet>
{
  public CandleData() {}
  
  public CandleData(List paramList)
  {
    super(paramList);
  }
  
  public CandleData(List paramList, ICandleDataSet paramICandleDataSet)
  {
    super(paramList, toList(paramICandleDataSet));
  }
  
  public CandleData(List paramList1, List paramList2)
  {
    super(paramList1, paramList2);
  }
  
  public CandleData(String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  public CandleData(String[] paramArrayOfString, ICandleDataSet paramICandleDataSet)
  {
    super(paramArrayOfString, toList(paramICandleDataSet));
  }
  
  public CandleData(String[] paramArrayOfString, List paramList)
  {
    super(paramArrayOfString, paramList);
  }
  
  public static List toList(ICandleDataSet paramICandleDataSet)
  {
    return StringBuilder.newArrayList(paramICandleDataSet);
  }
}
