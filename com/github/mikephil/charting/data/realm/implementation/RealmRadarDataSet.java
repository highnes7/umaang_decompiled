package com.github.mikephil.charting.data.realm.implementation;

import com.github.mikephil.charting.data.realm.base.RealmBaseDataSet;
import com.github.mikephil.charting.data.realm.base.RealmLineRadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class RealmRadarDataSet<T extends RealmObject>
  extends RealmLineRadarDataSet<T>
  implements IRadarDataSet
{
  public boolean mDrawHighlightCircleEnabled = false;
  public int mHighlightCircleFillColor = -1;
  public float mHighlightCircleInnerRadius = 3.0F;
  public float mHighlightCircleOuterRadius = 4.0F;
  public int mHighlightCircleStrokeAlpha = 76;
  public int mHighlightCircleStrokeColor = 1122867;
  public float mHighlightCircleStrokeWidth = 2.0F;
  
  public RealmRadarDataSet(RealmResults paramRealmResults, String paramString)
  {
    super(paramRealmResults, paramString);
    build(results);
    calcMinMax(0, results.size());
  }
  
  public RealmRadarDataSet(RealmResults paramRealmResults, String paramString1, String paramString2)
  {
    super(paramRealmResults, paramString1, paramString2);
    build(results);
    calcMinMax(0, results.size());
  }
  
  public void build(RealmResults paramRealmResults)
  {
    super.build(paramRealmResults);
  }
  
  public int getHighlightCircleFillColor()
  {
    return mHighlightCircleFillColor;
  }
  
  public float getHighlightCircleInnerRadius()
  {
    return mHighlightCircleInnerRadius;
  }
  
  public float getHighlightCircleOuterRadius()
  {
    return mHighlightCircleOuterRadius;
  }
  
  public int getHighlightCircleStrokeAlpha()
  {
    return mHighlightCircleStrokeAlpha;
  }
  
  public int getHighlightCircleStrokeColor()
  {
    return mHighlightCircleStrokeColor;
  }
  
  public float getHighlightCircleStrokeWidth()
  {
    return mHighlightCircleStrokeWidth;
  }
  
  public boolean isDrawHighlightCircleEnabled()
  {
    return mDrawHighlightCircleEnabled;
  }
  
  public void setDrawHighlightCircleEnabled(boolean paramBoolean)
  {
    mDrawHighlightCircleEnabled = paramBoolean;
  }
  
  public void setHighlightCircleFillColor(int paramInt)
  {
    mHighlightCircleFillColor = paramInt;
  }
  
  public void setHighlightCircleInnerRadius(float paramFloat)
  {
    mHighlightCircleInnerRadius = paramFloat;
  }
  
  public void setHighlightCircleOuterRadius(float paramFloat)
  {
    mHighlightCircleOuterRadius = paramFloat;
  }
  
  public void setHighlightCircleStrokeAlpha(int paramInt)
  {
    mHighlightCircleStrokeAlpha = paramInt;
  }
  
  public void setHighlightCircleStrokeColor(int paramInt)
  {
    mHighlightCircleStrokeColor = paramInt;
  }
  
  public void setHighlightCircleStrokeWidth(float paramFloat)
  {
    mHighlightCircleStrokeWidth = paramFloat;
  }
}
