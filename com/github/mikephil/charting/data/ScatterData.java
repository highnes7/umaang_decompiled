package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Iterator;
import java.util.List;

public class ScatterData
  extends BarLineScatterCandleBubbleData<IScatterDataSet>
{
  public ScatterData() {}
  
  public ScatterData(List paramList)
  {
    super(paramList);
  }
  
  public ScatterData(List paramList, IScatterDataSet paramIScatterDataSet)
  {
    super(paramList, toList(paramIScatterDataSet));
  }
  
  public ScatterData(List paramList1, List paramList2)
  {
    super(paramList1, paramList2);
  }
  
  public ScatterData(String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  public ScatterData(String[] paramArrayOfString, IScatterDataSet paramIScatterDataSet)
  {
    super(paramArrayOfString, toList(paramIScatterDataSet));
  }
  
  public ScatterData(String[] paramArrayOfString, List paramList)
  {
    super(paramArrayOfString, paramList);
  }
  
  public static List toList(IScatterDataSet paramIScatterDataSet)
  {
    return StringBuilder.newArrayList(paramIScatterDataSet);
  }
  
  public float getGreatestShapeSize()
  {
    Iterator localIterator = mDataSets.iterator();
    float f1 = 0.0F;
    while (localIterator.hasNext())
    {
      float f2 = ((IScatterDataSet)localIterator.next()).getScatterShapeSize();
      if (f2 > f1) {
        f1 = f2;
      }
    }
    return f1;
  }
}
