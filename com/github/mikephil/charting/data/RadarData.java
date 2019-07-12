package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.List;

public class RadarData
  extends ChartData<IRadarDataSet>
{
  public RadarData() {}
  
  public RadarData(List paramList)
  {
    super(paramList);
  }
  
  public RadarData(List paramList, IRadarDataSet paramIRadarDataSet)
  {
    super(paramList, toList(paramIRadarDataSet));
  }
  
  public RadarData(List paramList1, List paramList2)
  {
    super(paramList1, paramList2);
  }
  
  public RadarData(String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  public RadarData(String[] paramArrayOfString, IRadarDataSet paramIRadarDataSet)
  {
    super(paramArrayOfString, toList(paramIRadarDataSet));
  }
  
  public RadarData(String[] paramArrayOfString, List paramList)
  {
    super(paramArrayOfString, paramList);
  }
  
  public static List toList(IRadarDataSet paramIRadarDataSet)
  {
    return StringBuilder.newArrayList(paramIRadarDataSet);
  }
}
