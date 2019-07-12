package com.github.mikephil.charting.data;

import android.graphics.Paint.Style;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CandleDataSet
  extends LineScatterCandleRadarDataSet<CandleEntry>
  implements ICandleDataSet
{
  public float mBarSpace = 0.1F;
  public int mDecreasingColor = 1122867;
  public Paint.Style mDecreasingPaintStyle = Paint.Style.FILL;
  public int mIncreasingColor = 1122867;
  public Paint.Style mIncreasingPaintStyle = Paint.Style.STROKE;
  public int mNeutralColor = 1122867;
  public int mShadowColor = 1122867;
  public boolean mShadowColorSameAsCandle = false;
  public float mShadowWidth = 3.0F;
  public boolean mShowCandleBar = true;
  
  public CandleDataSet(List paramList, String paramString)
  {
    super(paramList, paramString);
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
    mYMin = Float.MAX_VALUE;
    mYMax = -3.4028235E38F;
    while (paramInt1 <= i)
    {
      localObject = (CandleEntry)mYVals.get(paramInt1);
      if (((CandleEntry)localObject).getLow() < mYMin) {
        mYMin = ((CandleEntry)localObject).getLow();
      }
      if (((CandleEntry)localObject).getHigh() > mYMax) {
        mYMax = ((CandleEntry)localObject).getHigh();
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
      ((List)localObject).add(((CandleEntry)mYVals.get(i)).copy());
      i += 1;
    }
    localObject = new CandleDataSet((List)localObject, getLabel());
    mColors = mColors;
    mShadowWidth = mShadowWidth;
    mShowCandleBar = mShowCandleBar;
    mBarSpace = mBarSpace;
    mHighLightColor = mHighLightColor;
    mIncreasingPaintStyle = mIncreasingPaintStyle;
    mDecreasingPaintStyle = mDecreasingPaintStyle;
    mShadowColor = mShadowColor;
    return localObject;
  }
  
  public float getBarSpace()
  {
    return mBarSpace;
  }
  
  public int getDecreasingColor()
  {
    return mDecreasingColor;
  }
  
  public Paint.Style getDecreasingPaintStyle()
  {
    return mDecreasingPaintStyle;
  }
  
  public int getIncreasingColor()
  {
    return mIncreasingColor;
  }
  
  public Paint.Style getIncreasingPaintStyle()
  {
    return mIncreasingPaintStyle;
  }
  
  public int getNeutralColor()
  {
    return mNeutralColor;
  }
  
  public int getShadowColor()
  {
    return mShadowColor;
  }
  
  public boolean getShadowColorSameAsCandle()
  {
    return mShadowColorSameAsCandle;
  }
  
  public float getShadowWidth()
  {
    return mShadowWidth;
  }
  
  public boolean getShowCandleBar()
  {
    return mShowCandleBar;
  }
  
  public void setBarSpace(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    paramFloat = f;
    if (f > 0.45F) {
      paramFloat = 0.45F;
    }
    mBarSpace = paramFloat;
  }
  
  public void setDecreasingColor(int paramInt)
  {
    mDecreasingColor = paramInt;
  }
  
  public void setDecreasingPaintStyle(Paint.Style paramStyle)
  {
    mDecreasingPaintStyle = paramStyle;
  }
  
  public void setIncreasingColor(int paramInt)
  {
    mIncreasingColor = paramInt;
  }
  
  public void setIncreasingPaintStyle(Paint.Style paramStyle)
  {
    mIncreasingPaintStyle = paramStyle;
  }
  
  public void setNeutralColor(int paramInt)
  {
    mNeutralColor = paramInt;
  }
  
  public void setShadowColor(int paramInt)
  {
    mShadowColor = paramInt;
  }
  
  public void setShadowColorSameAsCandle(boolean paramBoolean)
  {
    mShadowColorSameAsCandle = paramBoolean;
  }
  
  public void setShadowWidth(float paramFloat)
  {
    mShadowWidth = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setShowCandleBar(boolean paramBoolean)
  {
    mShowCandleBar = paramBoolean;
  }
}
