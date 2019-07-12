package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcgg
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcgg>
{
  public static volatile zzcgg[] zziys;
  public Integer zzixj = null;
  public zzcgl zziyt = null;
  public zzcgl zziyu = null;
  public Boolean zziyv = null;
  
  public zzcgg()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzcgg[] zzbaf()
  {
    if (zziys == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zziys == null) {
          zziys = new zzcgg[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zziys;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcgg)) {
      return false;
    }
    paramObject = (zzcgg)paramObject;
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
    localObject = zziyt;
    if (localObject == null)
    {
      if (zziyt != null) {
        return false;
      }
    }
    else if (!((zzcgl)localObject).equals(zziyt)) {
      return false;
    }
    localObject = zziyu;
    if (localObject == null)
    {
      if (zziyu != null) {
        return false;
      }
    }
    else if (!((zzcgl)localObject).equals(zziyu)) {
      return false;
    }
    localObject = zziyv;
    if (localObject == null)
    {
      if (zziyv != null) {
        return false;
      }
    }
    else if (!((Boolean)localObject).equals(zziyv)) {
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
    int i2 = StringBuilder.add(com.google.android.gms.internal.zzcgg.class, 527, 31);
    Object localObject = zzixj;
    int i1 = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Integer)localObject).hashCode();
    }
    localObject = zziyt;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((zzcgl)localObject).hashCode();
    }
    localObject = zziyu;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((zzcgl)localObject).hashCode();
    }
    localObject = zziyv;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((Boolean)localObject).hashCode();
    }
    localObject = zzotl;
    int n = i1;
    if (localObject != null) {
      if (((zzeyj)localObject).isEmpty()) {
        n = i1;
      } else {
        n = zzotl.hashCode();
      }
    }
    return ((((i2 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    Object localObject = zzixj;
    if (localObject != null) {
      paramZzeyf.writeHeader(1, ((Integer)localObject).intValue());
    }
    localObject = zziyt;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, (zzeyn)localObject);
    }
    localObject = zziyu;
    if (localObject != null) {
      paramZzeyf.writeHeader(3, (zzeyn)localObject);
    }
    localObject = zziyv;
    if (localObject != null) {
      paramZzeyf.writeHeader(4, ((Boolean)localObject).booleanValue());
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
    localObject = zziyt;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.addMenuItem(2, (zzeyn)localObject);
    }
    localObject = zziyu;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.addMenuItem(3, (zzeyn)localObject);
    }
    localObject = zziyv;
    j = i;
    if (localObject != null)
    {
      ((Boolean)localObject).booleanValue();
      j = i + (zzeyf.zzkb(4) + 1);
    }
    return j;
  }
}
