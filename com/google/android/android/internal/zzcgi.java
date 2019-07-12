package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcgi
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcgi>
{
  public static volatile zzcgi[] zziza;
  public String name = null;
  public String zzfwo = null;
  public Float zzixb = null;
  public Double zzixc = null;
  public Long zzizb = null;
  
  public zzcgi()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzcgi[] zzbah()
  {
    if (zziza == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zziza == null) {
          zziza = new zzcgi[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zziza;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcgi)) {
      return false;
    }
    paramObject = (zzcgi)paramObject;
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
    localObject = zzfwo;
    if (localObject == null)
    {
      if (zzfwo != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzfwo)) {
      return false;
    }
    localObject = zzizb;
    if (localObject == null)
    {
      if (zzizb != null) {
        return false;
      }
    }
    else if (!((Long)localObject).equals(zzizb)) {
      return false;
    }
    localObject = zzixb;
    if (localObject == null)
    {
      if (zzixb != null) {
        return false;
      }
    }
    else if (!((Float)localObject).equals(zzixb)) {
      return false;
    }
    localObject = zzixc;
    if (localObject == null)
    {
      if (zzixc != null) {
        return false;
      }
    }
    else if (!((Double)localObject).equals(zzixc)) {
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
    int i3 = StringBuilder.add(com.google.android.gms.internal.zzcgi.class, 527, 31);
    Object localObject = name;
    int i2 = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    localObject = zzfwo;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = zzizb;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((Long)localObject).hashCode();
    }
    localObject = zzixb;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((Float)localObject).hashCode();
    }
    localObject = zzixc;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = ((Double)localObject).hashCode();
    }
    localObject = zzotl;
    int i1 = i2;
    if (localObject != null) {
      if (((zzeyj)localObject).isEmpty()) {
        i1 = i2;
      } else {
        i1 = zzotl.hashCode();
      }
    }
    return (((((i3 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    Object localObject = name;
    if (localObject != null) {
      paramZzeyf.writeHeader(1, (String)localObject);
    }
    localObject = zzfwo;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, (String)localObject);
    }
    localObject = zzizb;
    if (localObject != null) {
      paramZzeyf.writeHeader(3, ((Long)localObject).longValue());
    }
    localObject = zzixb;
    if (localObject != null) {
      paramZzeyf.put(4, ((Float)localObject).floatValue());
    }
    localObject = zzixc;
    if (localObject != null) {
      paramZzeyf.add(5, ((Double)localObject).doubleValue());
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
    localObject = zzfwo;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.computeStringSize(2, (String)localObject);
    }
    localObject = zzizb;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.setupButton(3, ((Long)localObject).longValue());
    }
    localObject = zzixb;
    j = i;
    if (localObject != null)
    {
      ((Float)localObject).floatValue();
      j = i + (zzeyf.zzkb(4) + 4);
    }
    localObject = zzixc;
    i = j;
    if (localObject != null)
    {
      ((Double)localObject).doubleValue();
      i = j + (zzeyf.zzkb(5) + 8);
    }
    return i;
  }
}
