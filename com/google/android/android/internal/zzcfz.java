package com.google.android.android.internal;

import java.io.IOException;

public final class zzcfz
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcfz>
{
  public static volatile zzcfz[] zzixs;
  public zzcgc zzixt = null;
  public zzcga zzixu = null;
  public Boolean zzixv = null;
  public String zzixw = null;
  
  public zzcfz()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzcfz[] zzbab()
  {
    if (zzixs == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zzixs == null) {
          zzixs = new zzcfz[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zzixs;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcfz)) {
      return false;
    }
    paramObject = (zzcfz)paramObject;
    Object localObject = zzixt;
    if (localObject == null)
    {
      if (zzixt != null) {
        return false;
      }
    }
    else if (!((zzcgc)localObject).equals(zzixt)) {
      return false;
    }
    localObject = zzixu;
    if (localObject == null)
    {
      if (zzixu != null) {
        return false;
      }
    }
    else if (!((zzcga)localObject).equals(zzixu)) {
      return false;
    }
    localObject = zzixv;
    if (localObject == null)
    {
      if (zzixv != null) {
        return false;
      }
    }
    else if (!((Boolean)localObject).equals(zzixv)) {
      return false;
    }
    localObject = zzixw;
    if (localObject == null)
    {
      if (zzixw != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzixw)) {
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
    int i2 = com.google.android.gms.internal.zzcfz.class.getName().hashCode();
    Object localObject = zzixt;
    int i1 = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((zzcgc)localObject).hashCode();
    }
    localObject = zzixu;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((zzcga)localObject).hashCode();
    }
    localObject = zzixv;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((Boolean)localObject).hashCode();
    }
    localObject = zzixw;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((String)localObject).hashCode();
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
    return (((((i2 + 527) * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    Object localObject = zzixt;
    if (localObject != null) {
      paramZzeyf.writeHeader(1, (zzeyn)localObject);
    }
    localObject = zzixu;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, (zzeyn)localObject);
    }
    localObject = zzixv;
    if (localObject != null) {
      paramZzeyf.writeHeader(3, ((Boolean)localObject).booleanValue());
    }
    localObject = zzixw;
    if (localObject != null) {
      paramZzeyf.writeHeader(4, (String)localObject);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    int i = j;
    Object localObject = zzixt;
    if (localObject != null) {
      i = j + zzeyf.addMenuItem(1, (zzeyn)localObject);
    }
    localObject = zzixu;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.addMenuItem(2, (zzeyn)localObject);
    }
    localObject = zzixv;
    i = j;
    if (localObject != null)
    {
      ((Boolean)localObject).booleanValue();
      i = j + (zzeyf.zzkb(3) + 1);
    }
    localObject = zzixw;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.computeStringSize(4, (String)localObject);
    }
    return j;
  }
}
