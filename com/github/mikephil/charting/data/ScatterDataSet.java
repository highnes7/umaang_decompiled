package com.github.mikephil.charting.data;

import com.github.mikephil.charting.charts.ScatterChart.ScatterShape;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.ArrayList;
import java.util.List;

public class ScatterDataSet
  extends LineScatterCandleRadarDataSet<Entry>
  implements IScatterDataSet
{
  public ScatterChart.ScatterShape mScatterShape = ScatterChart.ScatterShape.SQUARE;
  public int mScatterShapeHoleColor = 1122867;
  public float mScatterShapeHoleRadius = 0.0F;
  public float mShapeSize = 15.0F;
  
  public ScatterDataSet(List paramList, String paramString)
  {
    super(paramList, paramString);
  }
  
  public DataSet copy()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < mYVals.size())
    {
      ((List)localObject).add(((Entry)mYVals.get(i)).copy());
      i += 1;
    }
    localObject = new ScatterDataSet((List)localObject, getLabel());
    mColors = mColors;
    mShapeSize = mShapeSize;
    mScatterShape = mScatterShape;
    mScatterShapeHoleRadius = mScatterShapeHoleRadius;
    mScatterShapeHoleColor = mScatterShapeHoleColor;
    mHighLightColor = mHighLightColor;
    return localObject;
  }
  
  public ScatterChart.ScatterShape getScatterShape()
  {
    return mScatterShape;
  }
  
  public int getScatterShapeHoleColor()
  {
    return mScatterShapeHoleColor;
  }
  
  public float getScatterShapeHoleRadius()
  {
    return mScatterShapeHoleRadius;
  }
  
  public float getScatterShapeSize()
  {
    return mShapeSize;
  }
  
  public void setScatterShape(ScatterChart.ScatterShape paramScatterShape)
  {
    mScatterShape = paramScatterShape;
  }
  
  public void setScatterShapeHoleColor(int paramInt)
  {
    mScatterShapeHoleColor = paramInt;
  }
  
  public void setScatterShapeHoleRadius(float paramFloat)
  {
    mScatterShapeHoleRadius = paramFloat;
  }
  
  public void setScatterShapeSize(float paramFloat)
  {
    mShapeSize = paramFloat;
  }
}
