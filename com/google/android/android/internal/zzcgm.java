package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcgm
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcgm>
{
  public static volatile zzcgm[] zzjai;
  public String name = null;
  public String zzfwo = null;
  public Float zzixb = null;
  public Double zzixc = null;
  public Long zzizb = null;
  public Long zzjaj = null;
  
  public zzcgm()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzcgm[] zzbaj()
  {
    if (zzjai == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zzjai == null) {
          zzjai = new zzcgm[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zzjai;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcgm)) {
      return false;
    }
    paramObject = (zzcgm)paramObject;
    Object localObject = zzjaj;
    if (localObject == null)
    {
      if (zzjaj != null) {
        return false;
      }
    }
    else if (!((Long)localObject).equals(zzjaj)) {
      return false;
    }
    localObject = name;
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
    int i4 = StringBuilder.add(com.google.android.gms.internal.zzcgm.class, 527, 31);
    Object localObject = zzjaj;
    int i3 = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Long)localObject).hashCode();
    }
    localObject = name;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = zzfwo;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((String)localObject).hashCode();
    }
    localObject = zzizb;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((Long)localObject).hashCode();
    }
    localObject = zzixb;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = ((Float)localObject).hashCode();
    }
    localObject = zzixc;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((Double)localObject).hashCode();
    }
    localObject = zzotl;
    int i2 = i3;
    if (localObject != null) {
      if (((zzeyj)localObject).isEmpty()) {
        i2 = i3;
      } else {
        i2 = zzotl.hashCode();
      }
    }
    return ((((((i4 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    Object localObject = zzjaj;
    if (localObject != null) {
      paramZzeyf.writeHeader(1, ((Long)localObject).longValue());
    }
    localObject = name;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, (String)localObject);
    }
    localObject = zzfwo;
    if (localObject != null) {
      paramZzeyf.writeHeader(3, (String)localObject);
    }
    localObject = zzizb;
    if (localObject != null) {
      paramZzeyf.writeHeader(4, ((Long)localObject).longValue());
    }
    localObject = zzixb;
    if (localObject != null) {
      paramZzeyf.put(5, ((Float)localObject).floatValue());
    }
    localObject = zzixc;
    if (localObject != null) {
      paramZzeyf.add(6, ((Double)localObject).doubleValue());
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    int i = j;
    Object localObject = zzjaj;
    if (localObject != null) {
      i = j + zzeyf.setupButton(1, ((Long)localObject).longValue());
    }
    localObject = name;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.computeStringSize(2, (String)localObject);
    }
    localObject = zzfwo;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.computeStringSize(3, (String)localObject);
    }
    localObject = zzizb;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.setupButton(4, ((Long)localObject).longValue());
    }
    localObject = zzixb;
    i = j;
    if (localObject != null)
    {
      ((Float)localObject).floatValue();
      i = j + (zzeyf.zzkb(5) + 4);
    }
    localObject = zzixc;
    j = i;
    if (localObject != null)
    {
      ((Double)localObject).doubleValue();
      j = i + (zzeyf.zzkb(6) + 8);
    }
    return j;
  }
}
