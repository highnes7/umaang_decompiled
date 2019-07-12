package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.List;

public class PieData
  extends ChartData<IPieDataSet>
{
  public PieData() {}
  
  public PieData(List paramList)
  {
    super(paramList);
  }
  
  public PieData(List paramList, IPieDataSet paramIPieDataSet)
  {
    super(paramList, toList(paramIPieDataSet));
  }
  
  public PieData(String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  public PieData(String[] paramArrayOfString, IPieDataSet paramIPieDataSet)
  {
    super(paramArrayOfString, toList(paramIPieDataSet));
  }
  
  public static List toList(IPieDataSet paramIPieDataSet)
  {
    return StringBuilder.newArrayList(paramIPieDataSet);
  }
  
  public IPieDataSet getDataSet()
  {
    return (IPieDataSet)mDataSets.get(0);
  }
  
  public IPieDataSet getDataSetByIndex(int paramInt)
  {
    if (paramInt == 0) {
      return getDataSet();
    }
    return null;
  }
  
  public IPieDataSet getDataSetByLabel(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramString.equalsIgnoreCase(((IPieDataSet)mDataSets.get(0)).getLabel())) {
        return (IPieDataSet)mDataSets.get(0);
      }
    }
    else if (paramString.equals(((IPieDataSet)mDataSets.get(0)).getLabel())) {
      return (IPieDataSet)mDataSets.get(0);
    }
    return null;
  }
  
  public float getYValueSum()
  {
    float f = 0.0F;
    int i = 0;
    while (i < getDataSet().getEntryCount())
    {
      f += getDataSet().getEntryForIndex(i).getVal();
      i += 1;
    }
    return f;
  }
  
  public void setDataSet(IPieDataSet paramIPieDataSet)
  {
    mDataSets.clear();
    mDataSets.add(paramIPieDataSet);
    init();
  }
}
