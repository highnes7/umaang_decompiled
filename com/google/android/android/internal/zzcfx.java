package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcfx
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcfx>
{
  public static volatile zzcfx[] zzixi;
  public Integer zzixj = null;
  public zzcgb[] zzixk = zzcgb.zzbac();
  public zzcfy[] zzixl = zzcfy.zzbaa();
  
  public zzcfx()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzcfx[] zzazz()
  {
    if (zzixi == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zzixi == null) {
          zzixi = new zzcfx[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zzixi;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcfx)) {
      return false;
    }
    paramObject = (zzcfx)paramObject;
    Object localObject = zzixj;
    if (localObject == null)
    {
      if (zzixj != null) {
        return false;
      }
    }
    else if (!((Integer)localObject).equals(zzixj)) {
      return false;
    }
    if (!zzeyl.equals(zzixk, zzixk)) {
      return false;
    }
    if (!zzeyl.equals(zzixl, zzixl)) {
      return false;
    }
    localObject = zzotl;
    if ((localObject != null) && (!((zzeyj)localObject).isEmpty())) {
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
    int k = StringBuilder.add(com.google.android.gms.internal.zzcfx.class, 527, 31);
    Object localObject = zzixj;
    int j = 0;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Integer)localObject).hashCode();
    }
    int i = StringBuilder.size(zzixk, (k + i) * 31, 31);
    k = StringBuilder.size(zzixl, i, 31);
    localObject = zzotl;
    i = j;
    if (localObject != null) {
      if (((zzeyj)localObject).isEmpty()) {
        i = j;
      } else {
        i = zzotl.hashCode();
      }
    }
    return k + i;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    Object localObject = zzixj;
    if (localObject != null) {
      paramZzeyf.writeHeader(1, ((Integer)localObject).intValue());
    }
    localObject = zzixk;
    int j = 0;
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzixk;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(2, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    localObject = zzixl;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = zzixl;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(3, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    int i = j;
    Object localObject = zzixj;
    if (localObject != null) {
      i = j + zzeyf.zzaa(1, ((Integer)localObject).intValue());
    }
    localObject = zzixk;
    int m = 0;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = zzixk;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + zzeyf.addMenuItem(2, (zzeyn)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    localObject = zzixl;
    int k = j;
    if (localObject != null)
    {
      k = j;
      if (localObject.length > 0)
      {
        i = m;
        for (;;)
        {
          localObject = zzixl;
          k = j;
          if (i >= localObject.length) {
            break;
          }
          localObject = localObject[i];
          k = j;
          if (localObject != null) {
            k = j + zzeyf.addMenuItem(3, (zzeyn)localObject);
          }
          i += 1;
          j = k;
        }
      }
    }
    return k;
  }
}
