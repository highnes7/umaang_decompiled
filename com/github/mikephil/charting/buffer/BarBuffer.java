package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;

public class BarBuffer
  extends AbstractBuffer<IBarDataSet>
{
  public float mBarSpace = 0.0F;
  public boolean mContainsStacks = false;
  public int mDataSetCount = 1;
  public int mDataSetIndex = 0;
  public float mGroupSpace = 0.0F;
  public boolean mInverted = false;
  
  public BarBuffer(int paramInt1, float paramFloat, int paramInt2, boolean paramBoolean)
  {
    super(paramInt1);
    mGroupSpace = paramFloat;
    mDataSetCount = paramInt2;
    mContainsStacks = paramBoolean;
  }
  
  public void addBar(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = buffer;
    int i = index;
    index = (i + 1);
    arrayOfFloat[i] = paramFloat1;
    i = index;
    index = (i + 1);
    arrayOfFloat[i] = paramFloat2;
    i = index;
    index = (i + 1);
    arrayOfFloat[i] = paramFloat3;
    i = index;
    index = (i + 1);
    arrayOfFloat[i] = paramFloat4;
  }
  
  public void feed(IBarDataSet paramIBarDataSet)
  {
    float f8 = paramIBarDataSet.getEntryCount();
    float f9 = phaseX;
    int k = mDataSetCount;
    float f10 = mBarSpace / 2.0F;
    float f11 = mGroupSpace / 2.0F;
    int i = 0;
    while (i < f8 * f9)
    {
      BarEntry localBarEntry = (BarEntry)paramIBarDataSet.getEntryForIndex(i);
      int j = localBarEntry.getXIndex();
      float f1 = localBarEntry.getXIndex() * (k - 1) + j + mDataSetIndex;
      float f12 = mGroupSpace * localBarEntry.getXIndex() + f1 + f11;
      f1 = localBarEntry.getVal();
      float f2 = f1;
      float[] arrayOfFloat = localBarEntry.getVals();
      float f4;
      if ((mContainsStacks) && (arrayOfFloat != null))
      {
        f1 = -localBarEntry.getNegativeSum();
        j = 0;
        f4 = 0.0F;
      }
      while (j < arrayOfFloat.length)
      {
        float f3 = arrayOfFloat[j];
        float f6;
        if (f3 >= 0.0F)
        {
          f2 = f3 + f4;
          f3 = f1;
          f1 = f4;
          f6 = f2;
        }
        else
        {
          f2 = Math.abs(f3);
          f3 = Math.abs(f3) + f1;
          f2 += f1;
          f6 = f4;
        }
        float f5;
        float f7;
        if (mInverted)
        {
          if (f1 >= f2) {
            f4 = f1;
          } else {
            f4 = f2;
          }
          f5 = f2;
          if (f1 <= f2) {
            f5 = f1;
          }
          f7 = f5;
        }
        else
        {
          if (f1 >= f2) {
            f5 = f1;
          } else {
            f5 = f2;
          }
          f4 = f2;
          f7 = f5;
          if (f1 <= f2)
          {
            f7 = f5;
            f4 = f1;
          }
        }
        f1 = phaseY;
        addBar(f12 - 0.5F + f10, f7 * f1, f12 + 0.5F - f10, f4 * f1);
        j += 1;
        f1 = f3;
        f4 = f6;
        continue;
        if (mInverted)
        {
          if (f1 >= 0.0F) {
            f3 = f1;
          } else {
            f3 = 0.0F;
          }
          if (f1 <= 0.0F) {
            f1 = f2;
          } else {
            f1 = 0.0F;
          }
        }
        else
        {
          if (f1 >= 0.0F) {
            f3 = f1;
          } else {
            f3 = 0.0F;
          }
          if (f1 > 0.0F) {
            f2 = 0.0F;
          }
          f1 = f3;
          f3 = f2;
        }
        if (f1 > 0.0F) {
          f1 *= phaseY;
        } else {
          f3 *= phaseY;
        }
        addBar(f12 - 0.5F + f10, f1, f12 + 0.5F - f10, f3);
      }
      i += 1;
    }
    reset();
  }
  
  public void setBarSpace(float paramFloat)
  {
    mBarSpace = paramFloat;
  }
  
  public void setDataSet(int paramInt)
  {
    mDataSetIndex = paramInt;
  }
  
  public void setInverted(boolean paramBoolean)
  {
    mInverted = paramBoolean;
  }
}
