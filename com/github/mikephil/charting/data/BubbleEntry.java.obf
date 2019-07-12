package com.github.mikephil.charting.data;

public class BubbleEntry
  extends Entry
{
  public float mSize;
  
  public BubbleEntry(int paramInt, float paramFloat1, float paramFloat2)
  {
    super(paramFloat1, paramInt);
    mSize = 0.0F;
    mSize = paramFloat2;
  }
  
  public BubbleEntry(int paramInt, float paramFloat1, float paramFloat2, Object paramObject)
  {
    super(paramFloat1, paramInt);
    mData = paramObject;
    mSize = 0.0F;
    mSize = paramFloat2;
  }
  
  public BubbleEntry copy()
  {
    return new BubbleEntry(getXIndex(), getVal(), mSize, getData());
  }
  
  public float getSize()
  {
    return mSize;
  }
  
  public void setSize(float paramFloat)
  {
    mSize = paramFloat;
  }
}
