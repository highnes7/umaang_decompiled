package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcgh
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcgh>
{
  public static volatile zzcgh[] zziyw;
  public Integer count = null;
  public String name = null;
  public zzcgi[] zziyx = zzcgi.zzbah();
  public Long zziyy = null;
  public Long zziyz = null;
  
  public zzcgh()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzcgh[] zzbag()
  {
    if (zziyw == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zziyw == null) {
          zziyw = new zzcgh[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zziyw;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcgh)) {
      return false;
    }
    paramObject = (zzcgh)paramObject;
    if (!zzeyl.equals(zziyx, zziyx)) {
      return false;
    }
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
    localObject = zziyy;
    if (localObject == null)
    {
      if (zziyy != null) {
        return false;
      }
    }
    else if (!((Long)localObject).equals(zziyy)) {
      return false;
    }
    localObject = zziyz;
    if (localObject == null)
    {
      if (zziyz != null) {
        return false;
      }
    }
    else if (!((Long)localObject).equals(zziyz)) {
      return false;
    }
    localObject = count;
    if (localObject == null)
    {
      if (count != null) {
        return false;
      }
    }
    else if (!((Integer)localObject).equals(count)) {
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
    int i = StringBuilder.add(com.google.android.gms.internal.zzcgh.class, 527, 31);
    int i2 = StringBuilder.size(zziyx, i, 31);
    Object localObject = name;
    int i1 = 0;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    localObject = zziyy;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((Long)localObject).hashCode();
    }
    localObject = zziyz;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((Long)localObject).hashCode();
    }
    localObject = count;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((Integer)localObject).hashCode();
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
    Object localObject = zziyx;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = zziyx;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(1, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    localObject = name;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, (String)localObject);
    }
    localObject = zziyy;
    if (localObject != null) {
      paramZzeyf.writeHeader(3, ((Long)localObject).longValue());
    }
    localObject = zziyz;
    if (localObject != null) {
      paramZzeyf.writeHeader(4, ((Long)localObject).longValue());
    }
    localObject = count;
    if (localObject != null) {
      paramZzeyf.writeHeader(5, ((Integer)localObject).intValue());
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int i = super.updateBookmarks();
    Object localObject = zziyx;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = zziyx;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + zzeyf.addMenuItem(1, (zzeyn)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    localObject = name;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.computeStringSize(2, (String)localObject);
    }
    localObject = zziyy;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.setupButton(3, ((Long)localObject).longValue());
    }
    localObject = zziyz;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.setupButton(4, ((Long)localObject).longValue());
    }
    localObject = count;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.zzaa(5, ((Integer)localObject).intValue());
    }
    return j;
  }
}
