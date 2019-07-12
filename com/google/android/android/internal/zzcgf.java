package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcgf
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcgf>
{
  public static volatile zzcgf[] zziyr;
  public String name = null;
  public String value = null;
  
  public zzcgf()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzcgf[] zzbae()
  {
    if (zziyr == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zziyr == null) {
          zziyr = new zzcgf[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zziyr;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcgf)) {
      return false;
    }
    paramObject = (zzcgf)paramObject;
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
    localObject = value;
    if (localObject == null)
    {
      if (value != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(value)) {
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
    int n = StringBuilder.add(com.google.android.gms.internal.zzcgf.class, 527, 31);
    Object localObject = name;
    int m = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    localObject = value;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = zzotl;
    int k = m;
    if (localObject != null) {
      if (((zzeyj)localObject).isEmpty()) {
        k = m;
      } else {
        k = zzotl.hashCode();
      }
    }
    return ((n + i) * 31 + j) * 31 + k;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    String str = name;
    if (str != null) {
      paramZzeyf.writeHeader(1, str);
    }
    str = value;
    if (str != null) {
      paramZzeyf.writeHeader(2, str);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    int i = j;
    String str = name;
    if (str != null) {
      i = j + zzeyf.computeStringSize(1, str);
    }
    str = value;
    if (str != null) {
      return i + zzeyf.computeStringSize(2, str);
    }
    return i;
  }
}
