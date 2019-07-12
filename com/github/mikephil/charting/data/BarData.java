package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.List;

public class BarData
  extends BarLineScatterCandleBubbleData<IBarDataSet>
{
  public float mGroupSpace = 0.8F;
  
  public BarData() {}
  
  public BarData(List paramList)
  {
    super(paramList);
  }
  
  public BarData(List paramList, IBarDataSet paramIBarDataSet)
  {
    super(paramList, toList(paramIBarDataSet));
  }
  
  public BarData(List paramList1, List paramList2)
  {
    super(paramList1, paramList2);
  }
  
  public BarData(String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  public BarData(String[] paramArrayOfString, IBarDataSet paramIBarDataSet)
  {
    super(paramArrayOfString, toList(paramIBarDataSet));
  }
  
  public BarData(String[] paramArrayOfString, List paramList)
  {
    super(paramArrayOfString, paramList);
  }
  
  public static List toList(IBarDataSet paramIBarDataSet)
  {
    return StringBuilder.newArrayList(paramIBarDataSet);
  }
  
  public float getGroupSpace()
  {
    if (mDataSets.size() <= 1) {
      return 0.0F;
    }
    return mGroupSpace;
  }
  
  public boolean isGrouped()
  {
    return mDataSets.size() > 1;
  }
  
  public void setGroupSpace(float paramFloat)
  {
    mGroupSpace = (paramFloat / 100.0F);
  }
}
