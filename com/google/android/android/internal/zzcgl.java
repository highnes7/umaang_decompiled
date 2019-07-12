package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcgl
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcgl>
{
  public long[] zzjag;
  public long[] zzjah;
  
  public zzcgl()
  {
    long[] arrayOfLong = zzeyq.zzotz;
    zzjag = arrayOfLong;
    zzjah = arrayOfLong;
    zzotl = null;
    zzomu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcgl)) {
      return false;
    }
    paramObject = (zzcgl)paramObject;
    if (!zzeyl.equals(zzjag, zzjag)) {
      return false;
    }
    if (!zzeyl.equals(zzjah, zzjah)) {
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
    int j = StringBuilder.add(com.google.android.gms.internal.zzcgl.class, 527, 31);
    int k = zzeyl.hashCode(zzjag);
    int m = zzeyl.hashCode(zzjah);
    zzeyj localZzeyj = zzotl;
    int i;
    if ((localZzeyj != null) && (!localZzeyj.isEmpty())) {
      i = zzotl.hashCode();
    } else {
      i = 0;
    }
    return (m + (k + j) * 31) * 31 + i;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    long[] arrayOfLong = zzjag;
    int j = 0;
    int i;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      i = 0;
      for (;;)
      {
        arrayOfLong = zzjag;
        if (i >= arrayOfLong.length) {
          break;
        }
        paramZzeyf.multiply(1, arrayOfLong[i]);
        i += 1;
      }
    }
    arrayOfLong = zzjah;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      i = j;
      for (;;)
      {
        arrayOfLong = zzjah;
        if (i >= arrayOfLong.length) {
          break;
        }
        paramZzeyf.multiply(2, arrayOfLong[i]);
        i += 1;
      }
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int m = super.updateBookmarks();
    int j = m;
    long[] arrayOfLong = zzjag;
    int k = 0;
    int i = j;
    if (arrayOfLong != null)
    {
      i = j;
      if (arrayOfLong.length > 0)
      {
        i = 0;
        j = 0;
        for (;;)
        {
          arrayOfLong = zzjag;
          if (i >= arrayOfLong.length) {
            break;
          }
          j += zzeyf.zzdg(arrayOfLong[i]);
          i += 1;
        }
        i = m + j + arrayOfLong.length * 1;
      }
    }
    arrayOfLong = zzjah;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      m = 0;
      j = k;
      k = m;
      for (;;)
      {
        arrayOfLong = zzjah;
        if (j >= arrayOfLong.length) {
          break;
        }
        k += zzeyf.zzdg(arrayOfLong[j]);
        j += 1;
      }
      return i + k + arrayOfLong.length * 1;
    }
    return i;
  }
}
