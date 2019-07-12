package com.github.mikephil.charting.data;

public class BarEntry
  extends Entry
{
  public float mNegativeSum;
  public float mPositiveSum;
  public float[] mVals;
  
  public BarEntry(float paramFloat, int paramInt)
  {
    super(paramFloat, paramInt);
  }
  
  public BarEntry(float paramFloat, int paramInt, Object paramObject)
  {
    super(paramFloat, paramInt);
    mData = paramObject;
  }
  
  public BarEntry(float[] paramArrayOfFloat, int paramInt)
  {
    super(calcSum(paramArrayOfFloat), paramInt);
    mVals = paramArrayOfFloat;
    calcPosNegSum();
  }
  
  public BarEntry(float[] paramArrayOfFloat, int paramInt, String paramString)
  {
    super(calcSum(paramArrayOfFloat), paramInt);
    mData = paramString;
    mVals = paramArrayOfFloat;
    calcPosNegSum();
  }
  
  private void calcPosNegSum()
  {
    float[] arrayOfFloat = mVals;
    if (arrayOfFloat == null)
    {
      mNegativeSum = 0.0F;
      mPositiveSum = 0.0F;
      return;
    }
    int j = arrayOfFloat.length;
    int i = 0;
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (i < j)
    {
      float f3 = arrayOfFloat[i];
      if (f3 <= 0.0F) {
        f2 = Math.abs(f3) + f2;
      } else {
        f1 += f3;
      }
      i += 1;
    }
    mNegativeSum = f2;
    mPositiveSum = f1;
  }
  
  public static float calcSum(float[] paramArrayOfFloat)
  {
    float f = 0.0F;
    if (paramArrayOfFloat == null) {
      return 0.0F;
    }
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      f += paramArrayOfFloat[i];
      i += 1;
    }
    return f;
  }
  
  public BarEntry copy()
  {
    BarEntry localBarEntry = new BarEntry(getVal(), getXIndex(), getData());
    localBarEntry.setVals(mVals);
    return localBarEntry;
  }
  
  public float getBelowSum(int paramInt)
  {
    float[] arrayOfFloat = mVals;
    float f = 0.0F;
    if (arrayOfFloat == null) {
      return 0.0F;
    }
    int i = arrayOfFloat.length - 1;
    while ((i > paramInt) && (i >= 0))
    {
      f += mVals[i];
      i -= 1;
    }
    return f;
  }
  
  public float getNegativeSum()
  {
    return mNegativeSum;
  }
  
  public float getPositiveSum()
  {
    return mPositiveSum;
  }
  
  public float getVal()
  {
    return mVal;
  }
  
  public float[] getVals()
  {
    return mVals;
  }
  
  public boolean isStacked()
  {
    return mVals != null;
  }
  
  public void setVals(float[] paramArrayOfFloat)
  {
    setVal(calcSum(paramArrayOfFloat));
    mVals = paramArrayOfFloat;
    calcPosNegSum();
  }
}
