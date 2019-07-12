package com.google.android.android.vision;

import android.util.SparseArray;

public final class MergedCells
{
  public static final Object zzaqd = new Object();
  public static int zzkib = 0;
  public SparseArray<Integer> zzkic = new SparseArray();
  public SparseArray<Integer> zzkid = new SparseArray();
  
  public MergedCells() {}
  
  public final int zzes(int paramInt)
  {
    Object localObject = zzaqd;
    try
    {
      Integer localInteger = (Integer)zzkic.get(paramInt);
      if (localInteger != null)
      {
        paramInt = localInteger.intValue();
        return paramInt;
      }
      int i = zzkib;
      zzkib += 1;
      zzkic.append(paramInt, Integer.valueOf(i));
      zzkid.append(i, Integer.valueOf(paramInt));
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final int zzet(int paramInt)
  {
    Object localObject = zzaqd;
    try
    {
      paramInt = ((Integer)zzkid.get(paramInt)).intValue();
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
