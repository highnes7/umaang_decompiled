package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class AxisBase
  extends ComponentBase
{
  public int mAxisLineColor = -7829368;
  public float mAxisLineWidth = 1.0F;
  public float mAxisMaximum = 0.0F;
  public float mAxisMinimum = 0.0F;
  public float mAxisRange = 0.0F;
  public boolean mCustomAxisMax = false;
  public boolean mCustomAxisMin = false;
  public boolean mDrawAxisLine = true;
  public boolean mDrawGridLines = true;
  public boolean mDrawLabels = true;
  public boolean mDrawLimitLineBehindData = false;
  public int mGridColor = -7829368;
  public DashPathEffect mGridDashPathEffect = null;
  public float mGridLineWidth = 1.0F;
  public List<LimitLine> mLimitLines;
  
  public AxisBase()
  {
    mTextSize = Utils.convertDpToPixel(10.0F);
    mXOffset = Utils.convertDpToPixel(5.0F);
    mYOffset = Utils.convertDpToPixel(5.0F);
    mLimitLines = new ArrayList();
  }
  
  public void addLimitLine(LimitLine paramLimitLine)
  {
    mLimitLines.add(paramLimitLine);
    mLimitLines.size();
  }
  
  public void disableGridDashedLine()
  {
    mGridDashPathEffect = null;
  }
  
  public void enableGridDashedLine(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    mGridDashPathEffect = new DashPathEffect(new float[] { paramFloat1, paramFloat2 }, paramFloat3);
  }
  
  public int getAxisLineColor()
  {
    return mAxisLineColor;
  }
  
  public float getAxisLineWidth()
  {
    return mAxisLineWidth;
  }
  
  public float getAxisMaximum()
  {
    return mAxisMaximum;
  }
  
  public float getAxisMinimum()
  {
    return mAxisMinimum;
  }
  
  public int getGridColor()
  {
    return mGridColor;
  }
  
  public DashPathEffect getGridDashPathEffect()
  {
    return mGridDashPathEffect;
  }
  
  public float getGridLineWidth()
  {
    return mGridLineWidth;
  }
  
  public List getLimitLines()
  {
    return mLimitLines;
  }
  
  public abstract String getLongestLabel();
  
  public boolean isAxisMaxCustom()
  {
    return mCustomAxisMax;
  }
  
  public boolean isAxisMinCustom()
  {
    return mCustomAxisMin;
  }
  
  public boolean isDrawAxisLineEnabled()
  {
    return mDrawAxisLine;
  }
  
  public boolean isDrawGridLinesEnabled()
  {
    return mDrawGridLines;
  }
  
  public boolean isDrawLabelsEnabled()
  {
    return mDrawLabels;
  }
  
  public boolean isDrawLimitLinesBehindDataEnabled()
  {
    return mDrawLimitLineBehindData;
  }
  
  public boolean isGridDashedLineEnabled()
  {
    return mGridDashPathEffect != null;
  }
  
  public void removeAllLimitLines()
  {
    mLimitLines.clear();
  }
  
  public void removeLimitLine(LimitLine paramLimitLine)
  {
    mLimitLines.remove(paramLimitLine);
  }
  
  public void resetAxisMaxValue()
  {
    mCustomAxisMax = false;
  }
  
  public void resetAxisMinValue()
  {
    mCustomAxisMin = false;
  }
  
  public void setAxisLineColor(int paramInt)
  {
    mAxisLineColor = paramInt;
  }
  
  public void setAxisLineWidth(float paramFloat)
  {
    mAxisLineWidth = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setAxisMaxValue(float paramFloat)
  {
    mCustomAxisMax = true;
    mAxisMaximum = paramFloat;
  }
  
  public void setAxisMinValue(float paramFloat)
  {
    mCustomAxisMin = true;
    mAxisMinimum = paramFloat;
  }
  
  public void setDrawAxisLine(boolean paramBoolean)
  {
    mDrawAxisLine = paramBoolean;
  }
  
  public void setDrawGridLines(boolean paramBoolean)
  {
    mDrawGridLines = paramBoolean;
  }
  
  public void setDrawLabels(boolean paramBoolean)
  {
    mDrawLabels = paramBoolean;
  }
  
  public void setDrawLimitLinesBehindData(boolean paramBoolean)
  {
    mDrawLimitLineBehindData = paramBoolean;
  }
  
  public void setGridColor(int paramInt)
  {
    mGridColor = paramInt;
  }
  
  public void setGridLineWidth(float paramFloat)
  {
    mGridLineWidth = Utils.convertDpToPixel(paramFloat);
  }
}
