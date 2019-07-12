package com.github.mikephil.charting.data;

public class CandleEntry
  extends Entry
{
  public float mClose;
  public float mOpen;
  public float mShadowHigh;
  public float mShadowLow;
  
  public CandleEntry(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super((paramFloat1 + paramFloat2) / 2.0F, paramInt);
    mShadowHigh = 0.0F;
    mShadowLow = 0.0F;
    mClose = 0.0F;
    mOpen = 0.0F;
    mShadowHigh = paramFloat1;
    mShadowLow = paramFloat2;
    mOpen = paramFloat3;
    mClose = paramFloat4;
  }
  
  public CandleEntry(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Object paramObject)
  {
    super((paramFloat1 + paramFloat2) / 2.0F, paramInt);
    mData = paramObject;
    mShadowHigh = 0.0F;
    mShadowLow = 0.0F;
    mClose = 0.0F;
    mOpen = 0.0F;
    mShadowHigh = paramFloat1;
    mShadowLow = paramFloat2;
    mOpen = paramFloat3;
    mClose = paramFloat4;
  }
  
  public CandleEntry copy()
  {
    return new CandleEntry(getXIndex(), mShadowHigh, mShadowLow, mOpen, mClose, getData());
  }
  
  public float getBodyRange()
  {
    return Math.abs(mOpen - mClose);
  }
  
  public float getClose()
  {
    return mClose;
  }
  
  public float getHigh()
  {
    return mShadowHigh;
  }
  
  public float getLow()
  {
    return mShadowLow;
  }
  
  public float getOpen()
  {
    return mOpen;
  }
  
  public float getShadowRange()
  {
    return Math.abs(mShadowHigh - mShadowLow);
  }
  
  public float getVal()
  {
    return mVal;
  }
  
  public void setClose(float paramFloat)
  {
    mClose = paramFloat;
  }
  
  public void setHigh(float paramFloat)
  {
    mShadowHigh = paramFloat;
  }
  
  public void setLow(float paramFloat)
  {
    mShadowLow = paramFloat;
  }
  
  public void setOpen(float paramFloat)
  {
    mOpen = paramFloat;
  }
}
