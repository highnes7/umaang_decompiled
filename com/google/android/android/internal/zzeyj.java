package com.google.android.android.internal;

public final class zzeyj
  implements Cloneable
{
  public static final zzeyk zzotn = new zzeyk();
  public int mSize;
  public boolean zzoto = false;
  public int[] zzotp;
  public zzeyk[] zzotq;
  
  public zzeyj()
  {
    this(10);
  }
  
  public zzeyj(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    zzotp = new int[paramInt];
    zzotq = new zzeyk[paramInt];
    mSize = 0;
  }
  
  public static int idealIntArraySize(int paramInt)
  {
    int j = paramInt << 2;
    paramInt = 4;
    int i;
    for (;;)
    {
      i = j;
      if (paramInt >= 32) {
        break;
      }
      i = (1 << paramInt) - 12;
      if (j <= i) {
        break;
      }
      paramInt += 1;
    }
    return i / 4;
  }
  
  private final int zzlg(int paramInt)
  {
    int j = mSize - 1;
    int i = 0;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = zzotp[k];
      if (m < paramInt) {
        i = k + 1;
      } else if (m > paramInt) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i;
  }
  
  public final void digest(int paramInt, zzeyk paramZzeyk)
  {
    int i = zzlg(paramInt);
    if (i >= 0)
    {
      zzotq[i] = paramZzeyk;
      return;
    }
    i = i;
    Object localObject1;
    if (i < mSize)
    {
      localObject1 = zzotq;
      if (localObject1[i] == zzotn)
      {
        zzotp[i] = paramInt;
        localObject1[i] = paramZzeyk;
        return;
      }
    }
    int j = mSize;
    if (j >= zzotp.length)
    {
      j = idealIntArraySize(j + 1);
      localObject1 = new int[j];
      zzeyk[] arrayOfZzeyk = new zzeyk[j];
      Object localObject2 = zzotp;
      System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      localObject2 = zzotq;
      System.arraycopy(localObject2, 0, arrayOfZzeyk, 0, localObject2.length);
      zzotp = ((int[])localObject1);
      zzotq = arrayOfZzeyk;
    }
    j = mSize;
    if (j - i != 0)
    {
      localObject1 = zzotp;
      int k = i + 1;
      System.arraycopy(localObject1, i, localObject1, k, j - i);
      localObject1 = zzotq;
      System.arraycopy(localObject1, i, localObject1, k, mSize - i);
    }
    zzotp[i] = paramInt;
    zzotq[i] = paramZzeyk;
    mSize += 1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzeyj)) {
      return false;
    }
    paramObject = (zzeyj)paramObject;
    int j = mSize;
    if (j != mSize) {
      return false;
    }
    Object localObject = zzotp;
    int[] arrayOfInt = zzotp;
    int i = 0;
    while (i < j)
    {
      if (localObject[i] != arrayOfInt[i])
      {
        i = 0;
        break label80;
      }
      i += 1;
    }
    i = 1;
    label80:
    if (i != 0)
    {
      localObject = zzotq;
      paramObject = zzotq;
      j = mSize;
      i = 0;
      while (i < j)
      {
        if (!localObject[i].equals(paramObject[i]))
        {
          i = 0;
          break label134;
        }
        i += 1;
      }
      i = 1;
      label134:
      if (i != 0) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    int j = 17;
    int i = 0;
    while (i < mSize)
    {
      j = (j * 31 + zzotp[i]) * 31 + zzotq[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public final boolean isEmpty()
  {
    return mSize == 0;
  }
  
  public final int size()
  {
    return mSize;
  }
  
  public final zzeyk zzle(int paramInt)
  {
    paramInt = zzlg(paramInt);
    if (paramInt >= 0)
    {
      zzeyk[] arrayOfZzeyk = zzotq;
      if (arrayOfZzeyk[paramInt] != zzotn) {
        return arrayOfZzeyk[paramInt];
      }
    }
    return null;
  }
  
  public final zzeyk zzlf(int paramInt)
  {
    return zzotq[paramInt];
  }
}
