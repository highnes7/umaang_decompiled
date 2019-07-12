package com.google.android.android.internal;

import com.google.android.gms.internal.zzewq;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class zzevt
  extends com.google.android.gms.internal.zzeug<Integer>
  implements com.google.android.gms.internal.zzevx, zzewq, RandomAccess
{
  public static final zzevt zzopc;
  public int size;
  public int[] zzopd;
  
  static
  {
    zzevt localZzevt = new zzevt();
    zzopc = localZzevt;
    localZzevt.zzbhs();
  }
  
  public zzevt()
  {
    zzopd = arrayOfInt;
    size = 0;
  }
  
  public zzevt(int[] paramArrayOfInt, int paramInt)
  {
    zzopd = paramArrayOfInt;
    size = paramInt;
  }
  
  private final void zzaf(int paramInt1, int paramInt2)
  {
    zzcsd();
    if (paramInt1 >= 0)
    {
      int i = size;
      if (paramInt1 <= i)
      {
        int[] arrayOfInt1 = zzopd;
        if (i < arrayOfInt1.length)
        {
          System.arraycopy(arrayOfInt1, paramInt1, arrayOfInt1, paramInt1 + 1, i - paramInt1);
        }
        else
        {
          int[] arrayOfInt2 = new int[i * 3 / 2 + 1];
          System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, paramInt1);
          System.arraycopy(zzopd, paramInt1, arrayOfInt2, paramInt1 + 1, size - paramInt1);
          zzopd = arrayOfInt2;
        }
        zzopd[paramInt1] = paramInt2;
        size += 1;
        modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(zzkr(paramInt1));
  }
  
  public static zzevt zzcul()
  {
    return zzopc;
  }
  
  private final void zzkq(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < size)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzkr(paramInt));
  }
  
  private final String zzkr(int paramInt)
  {
    int i = size;
    StringBuilder localStringBuilder = new StringBuilder(35);
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    zzcsd();
    zzevu.add(paramCollection);
    if (!(paramCollection instanceof zzevt)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzevt)paramCollection;
    int i = size;
    if (i == 0) {
      return false;
    }
    int j = size;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      int[] arrayOfInt = zzopd;
      if (i > arrayOfInt.length) {
        zzopd = Arrays.copyOf(arrayOfInt, i);
      }
      System.arraycopy(zzopd, 0, zzopd, size, size);
      size = i;
      modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzevt)) {
      return super.equals(paramObject);
    }
    paramObject = (zzevt)paramObject;
    if (size != size) {
      return false;
    }
    paramObject = zzopd;
    int i = 0;
    while (i < size)
    {
      if (zzopd[i] != paramObject[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final int getInt(int paramInt)
  {
    zzkq(paramInt);
    return zzopd[paramInt];
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < size)
    {
      j = j * 31 + zzopd[i];
      i += 1;
    }
    return j;
  }
  
  public final boolean remove(Object paramObject)
  {
    zzcsd();
    int i = 0;
    while (i < size)
    {
      if (paramObject.equals(Integer.valueOf(zzopd[i])))
      {
        paramObject = zzopd;
        System.arraycopy(paramObject, i + 1, paramObject, i, size - i);
        size -= 1;
        modCount += 1;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final int size()
  {
    return size;
  }
  
  public final zzevx zzko(int paramInt)
  {
    if (paramInt >= size) {
      return new zzevt(Arrays.copyOf(zzopd, paramInt), size);
    }
    throw new IllegalArgumentException();
  }
  
  public final void zzkp(int paramInt)
  {
    zzaf(size, paramInt);
  }
}
