package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.List;

public class BarDataSet
  extends BarLineScatterCandleBubbleDataSet<BarEntry>
  implements IBarDataSet
{
  public int mBarShadowColor = Color.rgb(215, 215, 215);
  public float mBarSpace = 0.15F;
  public int mEntryCountStacks = 0;
  public int mHighLightAlpha = 120;
  public String[] mStackLabels = { "Stack" };
  public int mStackSize = 1;
  
  public BarDataSet(List paramList, String paramString)
  {
    super(paramList, paramString);
    mHighLightColor = Color.rgb(0, 0, 0);
    calcStackSize(paramList);
    calcEntryCountIncludingStacks(paramList);
  }
  
  private void calcEntryCountIncludingStacks(List paramList)
  {
    int i = 0;
    mEntryCountStacks = 0;
    while (i < paramList.size())
    {
      float[] arrayOfFloat = ((BarEntry)paramList.get(i)).getVals();
      if (arrayOfFloat == null) {
        mEntryCountStacks += 1;
      } else {
        mEntryCountStacks += arrayOfFloat.length;
      }
      i += 1;
    }
  }
  
  private void calcStackSize(List paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      float[] arrayOfFloat = ((BarEntry)paramList.get(i)).getVals();
      if ((arrayOfFloat != null) && (arrayOfFloat.length > mStackSize)) {
        mStackSize = arrayOfFloat.length;
      }
      i += 1;
    }
  }
  
  public void calcMinMax(int paramInt1, int paramInt2)
  {
    Object localObject = mYVals;
    if (localObject == null) {
      return;
    }
    int j = ((List)localObject).size();
    if (j == 0) {
      return;
    }
    int i;
    if (paramInt2 != 0)
    {
      i = paramInt2;
      if (paramInt2 < j) {}
    }
    else
    {
      i = j - 1;
    }
    mYMin = Float.MAX_VALUE;
    mYMax = -3.4028235E38F;
    while (paramInt1 <= i)
    {
      localObject = (BarEntry)mYVals.get(paramInt1);
      if ((localObject != null) && (!Float.isNaN(((BarEntry)localObject).getVal()))) {
        if (((BarEntry)localObject).getVals() == null)
        {
          if (((BarEntry)localObject).getVal() < mYMin) {
            mYMin = ((BarEntry)localObject).getVal();
          }
          if (((BarEntry)localObject).getVal() > mYMax) {
            mYMax = ((BarEntry)localObject).getVal();
          }
        }
        else
        {
          if (-((BarEntry)localObject).getNegativeSum() < mYMin) {
            mYMin = (-((BarEntry)localObject).getNegativeSum());
          }
          if (((BarEntry)localObject).getPositiveSum() > mYMax) {
            mYMax = ((BarEntry)localObject).getPositiveSum();
          }
        }
      }
      paramInt1 += 1;
    }
    if (mYMin == Float.MAX_VALUE)
    {
      mYMin = 0.0F;
      mYMax = 0.0F;
    }
  }
  
  public DataSet copy()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < mYVals.size())
    {
      ((List)localObject).add(((BarEntry)mYVals.get(i)).copy());
      i += 1;
    }
    localObject = new BarDataSet((List)localObject, getLabel());
    mColors = mColors;
    mStackSize = mStackSize;
    mBarSpace = mBarSpace;
    mBarShadowColor = mBarShadowColor;
    mStackLabels = mStackLabels;
    mHighLightColor = mHighLightColor;
    mHighLightAlpha = mHighLightAlpha;
    return localObject;
  }
  
  public int getBarShadowColor()
  {
    return mBarShadowColor;
  }
  
  public float getBarSpace()
  {
    return mBarSpace;
  }
  
  public float getBarSpacePercent()
  {
    return mBarSpace * 100.0F;
  }
  
  public int getEntryCountStacks()
  {
    return mEntryCountStacks;
  }
  
  public int getHighLightAlpha()
  {
    return mHighLightAlpha;
  }
  
  public String[] getStackLabels()
  {
    return mStackLabels;
  }
  
  public int getStackSize()
  {
    return mStackSize;
  }
  
  public boolean isStacked()
  {
    return mStackSize > 1;
  }
  
  public void setBarShadowColor(int paramInt)
  {
    mBarShadowColor = paramInt;
  }
  
  public void setBarSpacePercent(float paramFloat)
  {
    mBarSpace = (paramFloat / 100.0F);
  }
  
  public void setHighLightAlpha(int paramInt)
  {
    mHighLightAlpha = paramInt;
  }
  
  public void setStackLabels(String[] paramArrayOfString)
  {
    mStackLabels = paramArrayOfString;
  }
}
