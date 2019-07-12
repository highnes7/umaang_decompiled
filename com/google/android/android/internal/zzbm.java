package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzbm
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzbm>
{
  public static volatile zzbm[] zzwz;
  public int[] zzxa;
  public int[] zzxb;
  public int[] zzxc;
  public int[] zzxd;
  public int[] zzxe;
  public int[] zzxf;
  public int[] zzxg;
  public int[] zzxh;
  public int[] zzxi;
  public int[] zzxj;
  
  public zzbm()
  {
    int[] arrayOfInt = zzeyq.zzoty;
    zzxa = arrayOfInt;
    zzxb = arrayOfInt;
    zzxc = arrayOfInt;
    zzxd = arrayOfInt;
    zzxe = arrayOfInt;
    zzxf = arrayOfInt;
    zzxg = arrayOfInt;
    zzxh = arrayOfInt;
    zzxi = arrayOfInt;
    zzxj = arrayOfInt;
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzbm[] getEquipment()
  {
    if (zzwz == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zzwz == null) {
          zzwz = new zzbm[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zzwz;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzbm)) {
      return false;
    }
    paramObject = (zzbm)paramObject;
    if (!zzeyl.equals(zzxa, zzxa)) {
      return false;
    }
    if (!zzeyl.equals(zzxb, zzxb)) {
      return false;
    }
    if (!zzeyl.equals(zzxc, zzxc)) {
      return false;
    }
    if (!zzeyl.equals(zzxd, zzxd)) {
      return false;
    }
    if (!zzeyl.equals(zzxe, zzxe)) {
      return false;
    }
    if (!zzeyl.equals(zzxf, zzxf)) {
      return false;
    }
    if (!zzeyl.equals(zzxg, zzxg)) {
      return false;
    }
    if (!zzeyl.equals(zzxh, zzxh)) {
      return false;
    }
    if (!zzeyl.equals(zzxi, zzxi)) {
      return false;
    }
    if (!zzeyl.equals(zzxj, zzxj)) {
      return false;
    }
    zzeyj localZzeyj = zzotl;
    if ((localZzeyj != null) && (!localZzeyj.isEmpty())) {
      return zzotl.equals(zzotl);
    }
    paramObject = zzotl;
    if (paramObject != null) {
      return paramObject.isEmpty();
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = StringBuilder.add(com.google.android.gms.internal.zzbm.class, 527, 31);
    int k = zzeyl.hashCode(zzxa);
    int m = zzeyl.hashCode(zzxb);
    int n = zzeyl.hashCode(zzxc);
    int i1 = zzeyl.hashCode(zzxd);
    int i2 = zzeyl.hashCode(zzxe);
    int i3 = zzeyl.hashCode(zzxf);
    int i4 = zzeyl.hashCode(zzxg);
    int i5 = zzeyl.hashCode(zzxh);
    int i6 = zzeyl.hashCode(zzxi);
    int i7 = zzeyl.hashCode(zzxj);
    zzeyj localZzeyj = zzotl;
    int i;
    if ((localZzeyj != null) && (!localZzeyj.isEmpty())) {
      i = zzotl.hashCode();
    } else {
      i = 0;
    }
    return (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + j) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    int[] arrayOfInt = zzxa;
    int j = 0;
    int i;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = zzxa;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramZzeyf.writeHeader(1, arrayOfInt[i]);
        i += 1;
      }
    }
    arrayOfInt = zzxb;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = zzxb;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramZzeyf.writeHeader(2, arrayOfInt[i]);
        i += 1;
      }
    }
    arrayOfInt = zzxc;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = zzxc;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramZzeyf.writeHeader(3, arrayOfInt[i]);
        i += 1;
      }
    }
    arrayOfInt = zzxd;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = zzxd;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramZzeyf.writeHeader(4, arrayOfInt[i]);
        i += 1;
      }
    }
    arrayOfInt = zzxe;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = zzxe;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramZzeyf.writeHeader(5, arrayOfInt[i]);
        i += 1;
      }
    }
    arrayOfInt = zzxf;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = zzxf;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramZzeyf.writeHeader(6, arrayOfInt[i]);
        i += 1;
      }
    }
    arrayOfInt = zzxg;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = zzxg;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramZzeyf.writeHeader(7, arrayOfInt[i]);
        i += 1;
      }
    }
    arrayOfInt = zzxh;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = zzxh;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramZzeyf.writeHeader(8, arrayOfInt[i]);
        i += 1;
      }
    }
    arrayOfInt = zzxi;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = zzxi;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramZzeyf.writeHeader(9, arrayOfInt[i]);
        i += 1;
      }
    }
    arrayOfInt = zzxj;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = j;
      for (;;)
      {
        arrayOfInt = zzxj;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramZzeyf.writeHeader(10, arrayOfInt[i]);
        i += 1;
      }
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int k = super.updateBookmarks();
    int j = k;
    int[] arrayOfInt = zzxa;
    int m = 0;
    int i = j;
    if (arrayOfInt != null)
    {
      i = j;
      if (arrayOfInt.length > 0)
      {
        i = 0;
        j = 0;
        for (;;)
        {
          arrayOfInt = zzxa;
          if (i >= arrayOfInt.length) {
            break;
          }
          j += zzeyf.zzkc(arrayOfInt[i]);
          i += 1;
        }
        i = k + j + arrayOfInt.length * 1;
      }
    }
    arrayOfInt = zzxb;
    j = i;
    if (arrayOfInt != null)
    {
      j = i;
      if (arrayOfInt.length > 0)
      {
        j = 0;
        k = 0;
        for (;;)
        {
          arrayOfInt = zzxb;
          if (j >= arrayOfInt.length) {
            break;
          }
          k += zzeyf.zzkc(arrayOfInt[j]);
          j += 1;
        }
        j = i + k + arrayOfInt.length * 1;
      }
    }
    arrayOfInt = zzxc;
    i = j;
    if (arrayOfInt != null)
    {
      i = j;
      if (arrayOfInt.length > 0)
      {
        i = 0;
        k = 0;
        for (;;)
        {
          arrayOfInt = zzxc;
          if (i >= arrayOfInt.length) {
            break;
          }
          k += zzeyf.zzkc(arrayOfInt[i]);
          i += 1;
        }
        i = j + k + arrayOfInt.length * 1;
      }
    }
    arrayOfInt = zzxd;
    j = i;
    if (arrayOfInt != null)
    {
      j = i;
      if (arrayOfInt.length > 0)
      {
        j = 0;
        k = 0;
        for (;;)
        {
          arrayOfInt = zzxd;
          if (j >= arrayOfInt.length) {
            break;
          }
          k += zzeyf.zzkc(arrayOfInt[j]);
          j += 1;
        }
        j = i + k + arrayOfInt.length * 1;
      }
    }
    arrayOfInt = zzxe;
    i = j;
    if (arrayOfInt != null)
    {
      i = j;
      if (arrayOfInt.length > 0)
      {
        i = 0;
        k = 0;
        for (;;)
        {
          arrayOfInt = zzxe;
          if (i >= arrayOfInt.length) {
            break;
          }
          k += zzeyf.zzkc(arrayOfInt[i]);
          i += 1;
        }
        i = j + k + arrayOfInt.length * 1;
      }
    }
    arrayOfInt = zzxf;
    j = i;
    if (arrayOfInt != null)
    {
      j = i;
      if (arrayOfInt.length > 0)
      {
        j = 0;
        k = 0;
        for (;;)
        {
          arrayOfInt = zzxf;
          if (j >= arrayOfInt.length) {
            break;
          }
          k += zzeyf.zzkc(arrayOfInt[j]);
          j += 1;
        }
        j = i + k + arrayOfInt.length * 1;
      }
    }
    arrayOfInt = zzxg;
    i = j;
    if (arrayOfInt != null)
    {
      i = j;
      if (arrayOfInt.length > 0)
      {
        i = 0;
        k = 0;
        for (;;)
        {
          arrayOfInt = zzxg;
          if (i >= arrayOfInt.length) {
            break;
          }
          k += zzeyf.zzkc(arrayOfInt[i]);
          i += 1;
        }
        i = j + k + arrayOfInt.length * 1;
      }
    }
    arrayOfInt = zzxh;
    j = i;
    if (arrayOfInt != null)
    {
      j = i;
      if (arrayOfInt.length > 0)
      {
        j = 0;
        k = 0;
        for (;;)
        {
          arrayOfInt = zzxh;
          if (j >= arrayOfInt.length) {
            break;
          }
          k += zzeyf.zzkc(arrayOfInt[j]);
          j += 1;
        }
        j = i + k + arrayOfInt.length * 1;
      }
    }
    arrayOfInt = zzxi;
    i = j;
    if (arrayOfInt != null)
    {
      i = j;
      if (arrayOfInt.length > 0)
      {
        i = 0;
        k = 0;
        for (;;)
        {
          arrayOfInt = zzxi;
          if (i >= arrayOfInt.length) {
            break;
          }
          k += zzeyf.zzkc(arrayOfInt[i]);
          i += 1;
        }
        i = j + k + arrayOfInt.length * 1;
      }
    }
    arrayOfInt = zzxj;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      k = 0;
      j = m;
      for (;;)
      {
        arrayOfInt = zzxj;
        if (j >= arrayOfInt.length) {
          break;
        }
        k += zzeyf.zzkc(arrayOfInt[j]);
        j += 1;
      }
      return i + k + arrayOfInt.length * 1;
    }
    return i;
  }
}
