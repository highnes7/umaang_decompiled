package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class BubbleDataSet
  extends BarLineScatterCandleBubbleDataSet<BubbleEntry>
  implements IBubbleDataSet
{
  public float mHighlightCircleWidth = 2.5F;
  public float mMaxSize;
  public float mXMax;
  public float mXMin;
  
  public BubbleDataSet(List paramList, String paramString)
  {
    super(paramList, paramString);
  }
  
  private float largestSize(BubbleEntry paramBubbleEntry)
  {
    return paramBubbleEntry.getSize();
  }
  
  private float xMax(BubbleEntry paramBubbleEntry)
  {
    return paramBubbleEntry.getXIndex();
  }
  
  private float xMin(BubbleEntry paramBubbleEntry)
  {
    return paramBubbleEntry.getXIndex();
  }
  
  private float yMax(BubbleEntry paramBubbleEntry)
  {
    return paramBubbleEntry.getVal();
  }
  
  private float yMin(BubbleEntry paramBubbleEntry)
  {
    return paramBubbleEntry.getVal();
  }
  
  public void calcMinMax(int paramInt1, int paramInt2)
  {
    Object localObject = mYVals;
    if (localObject == null) {
      return;
    }
    if (((List)localObject).size() == 0) {
      return;
    }
    int i;
    if (paramInt2 != 0)
    {
      i = paramInt2;
      if (paramInt2 < mYVals.size()) {}
    }
    else
    {
      i = mYVals.size() - 1;
    }
    mYMin = ((BubbleEntry)mYVals.get(paramInt1)).getVal();
    mYMax = ((BubbleEntry)mYVals.get(paramInt1)).getVal();
    while (paramInt1 <= i)
    {
      localObject = (BubbleEntry)mYVals.get(paramInt1);
      float f1 = ((Entry)localObject).getVal();
      float f2 = ((Entry)localObject).getVal();
      if (f1 < mYMin) {
        mYMin = f1;
      }
      if (f2 > mYMax) {
        mYMax = f2;
      }
      f1 = xMin((BubbleEntry)localObject);
      f2 = xMax((BubbleEntry)localObject);
      if (f1 < mXMin) {
        mXMin = f1;
      }
      if (f2 > mXMax) {
        mXMax = f2;
      }
      f1 = ((BubbleEntry)localObject).getSize();
      if (f1 > mMaxSize) {
        mMaxSize = f1;
      }
      paramInt1 += 1;
    }
  }
  
  public DataSet copy()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < mYVals.size())
    {
      ((List)localObject).add(((BubbleEntry)mYVals.get(i)).copy());
      i += 1;
    }
    localObject = new BubbleDataSet((List)localObject, getLabel());
    mColors = mColors;
    mHighLightColor = mHighLightColor;
    return localObject;
  }
  
  public float getHighlightCircleWidth()
  {
    return mHighlightCircleWidth;
  }
  
  public float getMaxSize()
  {
    return mMaxSize;
  }
  
  public float getXMax()
  {
    return mXMax;
  }
  
  public float getXMin()
  {
    return mXMin;
  }
  
  public void setHighlightCircleWidth(float paramFloat)
  {
    mHighlightCircleWidth = Utils.convertDpToPixel(paramFloat);
  }
}
