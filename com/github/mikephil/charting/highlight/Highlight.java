package com.github.mikephil.charting.highlight;

public class Highlight
{
  public int mDataSetIndex;
  public Range mRange;
  public int mStackIndex = -1;
  public int mXIndex;
  
  public Highlight(int paramInt1, int paramInt2)
  {
    mXIndex = paramInt1;
    mDataSetIndex = paramInt2;
  }
  
  public Highlight(int paramInt1, int paramInt2, int paramInt3)
  {
    mXIndex = paramInt1;
    mDataSetIndex = paramInt2;
    mStackIndex = paramInt3;
  }
  
  public Highlight(int paramInt1, int paramInt2, int paramInt3, Range paramRange)
  {
    mXIndex = paramInt1;
    mDataSetIndex = paramInt2;
    mStackIndex = paramInt3;
    mRange = paramRange;
  }
  
  public boolean equalTo(Highlight paramHighlight)
  {
    if (paramHighlight == null) {
      return false;
    }
    return (mDataSetIndex == mDataSetIndex) && (mXIndex == mXIndex) && (mStackIndex == mStackIndex);
  }
  
  public int getDataSetIndex()
  {
    return mDataSetIndex;
  }
  
  public Range getRange()
  {
    return mRange;
  }
  
  public int getStackIndex()
  {
    return mStackIndex;
  }
  
  public int getXIndex()
  {
    return mXIndex;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Highlight, xIndex: ");
    localStringBuilder.append(mXIndex);
    localStringBuilder.append(", dataSetIndex: ");
    localStringBuilder.append(mDataSetIndex);
    localStringBuilder.append(", stackIndex (only stacked barentry): ");
    localStringBuilder.append(mStackIndex);
    return localStringBuilder.toString();
  }
}
