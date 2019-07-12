package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzbh
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzbh>
{
  public static volatile zzbh[] zzvv;
  public int name = 0;
  public int[] zzvw = zzeyq.zzoty;
  public int zzvx = 0;
  public boolean zzvy = false;
  public boolean zzvz = false;
  
  public zzbh()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzbh[] getEquipment()
  {
    if (zzvv == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zzvv == null) {
          zzvv = new zzbh[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zzvv;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzbh)) {
      return false;
    }
    paramObject = (zzbh)paramObject;
    if (!zzeyl.equals(zzvw, zzvw)) {
      return false;
    }
    if (zzvx != zzvx) {
      return false;
    }
    if (name != name) {
      return false;
    }
    if (zzvy != zzvy) {
      return false;
    }
    if (zzvz != zzvz) {
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
    int m = StringBuilder.add(com.google.android.gms.internal.zzbh.class, 527, 31);
    int n = zzeyl.hashCode(zzvw);
    int i1 = zzvx;
    int i2 = name;
    boolean bool = zzvy;
    int j = 1231;
    int i;
    if (bool) {
      i = 1231;
    } else {
      i = 1237;
    }
    if (!zzvz) {
      j = 1237;
    }
    zzeyj localZzeyj = zzotl;
    int k;
    if ((localZzeyj != null) && (!localZzeyj.isEmpty())) {
      k = zzotl.hashCode();
    } else {
      k = 0;
    }
    return (((((n + m) * 31 + i1) * 31 + i2) * 31 + i) * 31 + j) * 31 + k;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    boolean bool = zzvz;
    if (bool) {
      paramZzeyf.writeHeader(1, bool);
    }
    paramZzeyf.writeHeader(2, zzvx);
    int[] arrayOfInt = zzvw;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfInt = zzvw;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramZzeyf.writeHeader(3, arrayOfInt[i]);
        i += 1;
      }
    }
    int i = name;
    if (i != 0) {
      paramZzeyf.writeHeader(4, i);
    }
    bool = zzvy;
    if (bool) {
      paramZzeyf.writeHeader(6, bool);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    int i = j;
    if (zzvz) {
      i = j + (zzeyf.zzkb(1) + 1);
    }
    int k = zzeyf.zzaa(2, zzvx) + i;
    int[] arrayOfInt = zzvw;
    i = k;
    if (arrayOfInt != null)
    {
      i = k;
      if (arrayOfInt.length > 0)
      {
        i = 0;
        j = 0;
        for (;;)
        {
          arrayOfInt = zzvw;
          if (i >= arrayOfInt.length) {
            break;
          }
          j += zzeyf.zzkc(arrayOfInt[i]);
          i += 1;
        }
        i = k + j + arrayOfInt.length * 1;
      }
    }
    k = name;
    j = i;
    if (k != 0) {
      j = i + zzeyf.zzaa(4, k);
    }
    i = j;
    if (zzvy) {
      i = j + (zzeyf.zzkb(6) + 1);
    }
    return i;
  }
}
