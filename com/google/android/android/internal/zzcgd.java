package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcgd
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcgd>
{
  public static volatile zzcgd[] zziyj;
  public String name = null;
  public Boolean zziyk = null;
  public Boolean zziyl = null;
  
  public zzcgd()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzcgd[] zzbad()
  {
    if (zziyj == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zziyj == null) {
          zziyj = new zzcgd[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zziyj;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcgd)) {
      return false;
    }
    paramObject = (zzcgd)paramObject;
    Object localObject = name;
    if (localObject == null)
    {
      if (name != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(name)) {
      return false;
    }
    localObject = zziyk;
    if (localObject == null)
    {
      if (zziyk != null) {
        return false;
      }
    }
    else if (!((Boolean)localObject).equals(zziyk)) {
      return false;
    }
    localObject = zziyl;
    if (localObject == null)
    {
      if (zziyl != null) {
        return false;
      }
    }
    else if (!((Boolean)localObject).equals(zziyl)) {
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
    int i1 = StringBuilder.add(com.google.android.gms.internal.zzcgd.class, 527, 31);
    Object localObject = name;
    int n = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    localObject = zziyk;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((Boolean)localObject).hashCode();
    }
    localObject = zziyl;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((Boolean)localObject).hashCode();
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
    Object localObject = name;
    if (localObject != null) {
      paramZzeyf.writeHeader(1, (String)localObject);
    }
    localObject = zziyk;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, ((Boolean)localObject).booleanValue());
    }
    localObject = zziyl;
    if (localObject != null) {
      paramZzeyf.writeHeader(3, ((Boolean)localObject).booleanValue());
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    int i = j;
    Object localObject = name;
    if (localObject != null) {
      i = j + zzeyf.computeStringSize(1, (String)localObject);
    }
    localObject = zziyk;
    j = i;
    if (localObject != null)
    {
      ((Boolean)localObject).booleanValue();
      j = i + (zzeyf.zzkb(2) + 1);
    }
    localObject = zziyl;
    i = j;
    if (localObject != null)
    {
      ((Boolean)localObject).booleanValue();
      i = j + (zzeyf.zzkb(3) + 1);
    }
    return i;
  }
}
