package com.google.android.android.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzews
  extends zzeuk
{
  public static final int[] zzopt;
  public final int zzopu;
  public final zzeuk zzopv;
  public final zzeuk zzopw;
  public final int zzopx;
  public final int zzopy;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    int j = 1;
    for (;;)
    {
      int k = j;
      if (i <= 0) {
        break;
      }
      localArrayList.add(Integer.valueOf(i));
      j = i;
      i = k + i;
    }
    localArrayList.add(Integer.valueOf(Integer.MAX_VALUE));
    zzopt = new int[localArrayList.size()];
    i = 0;
    for (;;)
    {
      int[] arrayOfInt = zzopt;
      if (i >= arrayOfInt.length) {
        break;
      }
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
  }
  
  public zzews(zzeuk paramZzeuk1, zzeuk paramZzeuk2)
  {
    zzopv = paramZzeuk1;
    zzopw = paramZzeuk2;
    zzopx = paramZzeuk1.size();
    int i = zzopx;
    zzopu = (paramZzeuk2.size() + i);
    zzopy = (Math.max(paramZzeuk1.zzcsh(), paramZzeuk2.zzcsh()) + 1);
  }
  
  public static zzeuk append(zzeuk paramZzeuk1, zzeuk paramZzeuk2)
  {
    if (paramZzeuk2.size() == 0) {
      return paramZzeuk1;
    }
    if (paramZzeuk1.size() == 0) {
      return paramZzeuk2;
    }
    int i = paramZzeuk1.size();
    i = paramZzeuk2.size() + i;
    if (i < 128) {
      return createCopy(paramZzeuk1, paramZzeuk2);
    }
    if ((paramZzeuk1 instanceof zzews))
    {
      zzews localZzews = (zzews)paramZzeuk1;
      j = zzopw.size();
      if (paramZzeuk2.size() + j < 128)
      {
        paramZzeuk1 = createCopy(zzopw, paramZzeuk2);
        return new zzews(zzopv, paramZzeuk1);
      }
      if ((zzopv.zzcsh() > zzopw.zzcsh()) && (localZzews.zzcsh() > paramZzeuk2.zzcsh()))
      {
        paramZzeuk1 = new zzews(zzopw, paramZzeuk2);
        return new zzews(zzopv, paramZzeuk1);
      }
    }
    int j = Math.max(paramZzeuk1.zzcsh(), paramZzeuk2.zzcsh());
    if (i >= zzopt[(j + 1)]) {
      return new zzews(paramZzeuk1, paramZzeuk2);
    }
    return zzewu.expand(new zzewu(), paramZzeuk1, paramZzeuk2);
  }
  
  public static zzeuk createCopy(zzeuk paramZzeuk1, zzeuk paramZzeuk2)
  {
    int i = paramZzeuk1.size();
    int j = paramZzeuk2.size();
    byte[] arrayOfByte = new byte[i + j];
    paramZzeuk1.add(arrayOfByte, 0, 0, i);
    paramZzeuk2.add(arrayOfByte, 0, i, j);
    return zzeuk.zzba(arrayOfByte);
  }
  
  public final void decrypt(zzeuj paramZzeuj)
    throws IOException
  {
    zzopv.decrypt(paramZzeuj);
    zzopw.decrypt(paramZzeuj);
  }
  
  public final void ensureCapacity(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = zzopx;
    if (paramInt1 + paramInt3 <= i)
    {
      zzopv.ensureCapacity(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      return;
    }
    if (paramInt1 >= i)
    {
      zzopw.ensureCapacity(paramArrayOfByte, paramInt1 - i, paramInt2, paramInt3);
      return;
    }
    i -= paramInt1;
    zzopv.ensureCapacity(paramArrayOfByte, paramInt1, paramInt2, i);
    zzopw.ensureCapacity(paramArrayOfByte, 0, paramInt2 + i, paramInt3 - i);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzeuk)) {
      return false;
    }
    paramObject = (zzeuk)paramObject;
    if (zzopu != paramObject.size()) {
      return false;
    }
    if (zzopu == 0) {
      return true;
    }
    int i = zzcsj();
    int j = paramObject.zzcsj();
    if ((i != 0) && (j != 0) && (i != j)) {
      return false;
    }
    zzewv localZzewv1 = new zzewv(this);
    zzeuq localZzeuq = (zzeuq)localZzewv1.next();
    zzewv localZzewv2 = new zzewv(paramObject);
    paramObject = (zzeuq)localZzewv2.next();
    j = 0;
    i = 0;
    int k = 0;
    for (;;)
    {
      int i1 = localZzeuq.size() - j;
      int m = paramObject.size() - i;
      int n = Math.min(i1, m);
      boolean bool;
      if (j == 0) {
        bool = localZzeuq.compareTo(paramObject, i, n);
      } else {
        bool = paramObject.compareTo(localZzeuq, j, n);
      }
      if (!bool) {
        return false;
      }
      k += n;
      int i2 = zzopu;
      if (k >= i2)
      {
        if (k == i2) {
          return true;
        }
        throw new IllegalStateException();
      }
      if (n == i1)
      {
        localZzeuq = (zzeuq)localZzewv1.next();
        j = 0;
      }
      else
      {
        j += n;
      }
      if (n == m)
      {
        paramObject = (zzeuq)localZzewv2.next();
        i = 0;
      }
      else
      {
        i += n;
      }
    }
  }
  
  public final int hash(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = zzopx;
    if (paramInt2 + paramInt3 <= i) {
      return zzopv.hash(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= i) {
      return zzopw.hash(paramInt1, paramInt2 - i, paramInt3);
    }
    i -= paramInt2;
    paramInt1 = zzopv.hash(paramInt1, paramInt2, i);
    return zzopw.hash(paramInt1, 0, paramInt3 - i);
  }
  
  public final zzeuk multiply(int paramInt1, int paramInt2)
  {
    int i = zzeuk.add(paramInt1, paramInt2, zzopu);
    if (i == 0) {
      return zzeuk.zzomx;
    }
    if (i == zzopu) {
      return this;
    }
    i = zzopx;
    if (paramInt2 <= i) {
      return zzopv.multiply(paramInt1, paramInt2);
    }
    if (paramInt1 >= i) {
      return zzopw.multiply(paramInt1 - i, paramInt2 - i);
    }
    zzeuk localZzeuk = zzopv;
    return new zzews(localZzeuk.multiply(paramInt1, localZzeuk.size()), zzopw.multiply(0, paramInt2 - zzopx));
  }
  
  public final int size()
  {
    return zzopu;
  }
  
  public final zzeut zzcsg()
  {
    return zzeut.readInputStream(new zzeww(this));
  }
  
  public final int zzcsh()
  {
    return zzopy;
  }
  
  public final boolean zzcsi()
  {
    return zzopu >= zzopt[zzopy];
  }
  
  public final byte zzji(int paramInt)
  {
    zzeuk.append(paramInt, zzopu);
    int i = zzopx;
    if (paramInt < i) {
      return zzopv.zzji(paramInt);
    }
    return zzopw.zzji(paramInt - i);
  }
}
