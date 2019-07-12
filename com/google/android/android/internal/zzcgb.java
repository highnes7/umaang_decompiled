package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcgb
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcgb>
{
  public static volatile zzcgb[] zziyc;
  public Integer zzixn = null;
  public String zziyd = null;
  public zzcfz zziye = null;
  
  public zzcgb()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzcgb[] zzbac()
  {
    if (zziyc == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zziyc == null) {
          zziyc = new zzcgb[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zziyc;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcgb)) {
      return false;
    }
    paramObject = (zzcgb)paramObject;
    Object localObject = zzixn;
    if (localObject == null)
    {
      if (zzixn != null) {
        return false;
      }
    }
    else if (!((Integer)localObject).equals(zzixn)) {
      return false;
    }
    localObject = zziyd;
    if (localObject == null)
    {
      if (zziyd != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zziyd)) {
      return false;
    }
    localObject = zziye;
    if (localObject == null)
    {
      if (zziye != null) {
        return false;
      }
    }
    else if (!((zzcfz)localObject).equals(zziye)) {
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
    int i1 = StringBuilder.add(com.google.android.gms.internal.zzcgb.class, 527, 31);
    Object localObject = zzixn;
    int n = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Integer)localObject).hashCode();
    }
    localObject = zziyd;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = zziye;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((zzcfz)localObject).hashCode();
    }
    localObject = zzotl;
    int m = n;
    if (localObject != null) {
      if (((zzeyj)localObject).isEmpty()) {
        m = n;
      } else {
        m = zzotl.hashCode();
      }
    }
    return (((i1 + i) * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    Object localObject = zzixn;
    if (localObject != null) {
      paramZzeyf.writeHeader(1, ((Integer)localObject).intValue());
    }
    localObject = zziyd;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, (String)localObject);
    }
    localObject = zziye;
    if (localObject != null) {
      paramZzeyf.writeHeader(3, (zzeyn)localObject);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    int i = j;
    Object localObject = zzixn;
    if (localObject != null) {
      i = j + zzeyf.zzaa(1, ((Integer)localObject).intValue());
    }
    localObject = zziyd;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.computeStringSize(2, (String)localObject);
    }
    localObject = zziye;
    if (localObject != null) {
      return j + zzeyf.addMenuItem(3, (zzeyn)localObject);
    }
    return j;
  }
}
