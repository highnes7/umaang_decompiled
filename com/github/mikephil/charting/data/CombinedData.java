package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.ArrayList;
import java.util.List;

public class CombinedData
  extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<?>>
{
  public BarData mBarData;
  public BubbleData mBubbleData;
  public CandleData mCandleData;
  public LineData mLineData;
  public ScatterData mScatterData;
  
  public CombinedData() {}
  
  public CombinedData(List paramList)
  {
    super(paramList);
  }
  
  public CombinedData(String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  public List getAllData()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = mLineData;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = mBarData;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = mScatterData;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = mCandleData;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = mBubbleData;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  public BarData getBarData()
  {
    return mBarData;
  }
  
  public BubbleData getBubbleData()
  {
    return mBubbleData;
  }
  
  public CandleData getCandleData()
  {
    return mCandleData;
  }
  
  public LineData getLineData()
  {
    return mLineData;
  }
  
  public ScatterData getScatterData()
  {
    return mScatterData;
  }
  
  public void notifyDataChanged()
  {
    Object localObject = mLineData;
    if (localObject != null) {
      ((ChartData)localObject).notifyDataChanged();
    }
    localObject = mBarData;
    if (localObject != null) {
      ((ChartData)localObject).notifyDataChanged();
    }
    localObject = mCandleData;
    if (localObject != null) {
      ((ChartData)localObject).notifyDataChanged();
    }
    localObject = mScatterData;
    if (localObject != null) {
      ((ChartData)localObject).notifyDataChanged();
    }
    localObject = mBubbleData;
    if (localObject != null) {
      ((ChartData)localObject).notifyDataChanged();
    }
    init();
  }
  
  public void setData(BarData paramBarData)
  {
    mBarData = paramBarData;
    mDataSets.addAll(paramBarData.getDataSets());
    init();
  }
  
  public void setData(BubbleData paramBubbleData)
  {
    mBubbleData = paramBubbleData;
    mDataSets.addAll(paramBubbleData.getDataSets());
    init();
  }
  
  public void setData(CandleData paramCandleData)
  {
    mCandleData = paramCandleData;
    mDataSets.addAll(paramCandleData.getDataSets());
    init();
  }
  
  public void setData(LineData paramLineData)
  {
    mLineData = paramLineData;
    mDataSets.addAll(paramLineData.getDataSets());
    init();
  }
  
  public void setData(ScatterData paramScatterData)
  {
    mScatterData = paramScatterData;
    mDataSets.addAll(paramScatterData.getDataSets());
    init();
  }
}
