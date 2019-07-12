package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcga
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcga>
{
  public Integer zzixx = null;
  public Boolean zzixy = null;
  public String zzixz = null;
  public String zziya = null;
  public String zziyb = null;
  
  public zzcga()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcga)) {
      return false;
    }
    paramObject = (zzcga)paramObject;
    Object localObject = zzixx;
    if (localObject == null)
    {
      if (zzixx != null) {
        return false;
      }
    }
    else if (!((Integer)localObject).equals(zzixx)) {
      return false;
    }
    localObject = zzixy;
    if (localObject == null)
    {
      if (zzixy != null) {
        return false;
      }
    }
    else if (!((Boolean)localObject).equals(zzixy)) {
      return false;
    }
    localObject = zzixz;
    if (localObject == null)
    {
      if (zzixz != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzixz)) {
      return false;
    }
    localObject = zziya;
    if (localObject == null)
    {
      if (zziya != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zziya)) {
      return false;
    }
    localObject = zziyb;
    if (localObject == null)
    {
      if (zziyb != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zziyb)) {
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
    int i3 = StringBuilder.add(com.google.android.gms.internal.zzcga.class, 527, 31);
    Object localObject = zzixx;
    int i2 = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Integer)localObject).intValue();
    }
    localObject = zzixy;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((Boolean)localObject).hashCode();
    }
    localObject = zzixz;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((String)localObject).hashCode();
    }
    localObject = zziya;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((String)localObject).hashCode();
    }
    localObject = zziyb;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = ((String)localObject).hashCode();
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
    Object localObject = zzixx;
    if (localObject != null) {
      paramZzeyf.writeHeader(1, ((Integer)localObject).intValue());
    }
    localObject = zzixy;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, ((Boolean)localObject).booleanValue());
    }
    localObject = zzixz;
    if (localObject != null) {
      paramZzeyf.writeHeader(3, (String)localObject);
    }
    localObject = zziya;
    if (localObject != null) {
      paramZzeyf.writeHeader(4, (String)localObject);
    }
    localObject = zziyb;
    if (localObject != null) {
      paramZzeyf.writeHeader(5, (String)localObject);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    int i = j;
    Object localObject = zzixx;
    if (localObject != null) {
      i = j + zzeyf.zzaa(1, ((Integer)localObject).intValue());
    }
    localObject = zzixy;
    j = i;
    if (localObject != null)
    {
      ((Boolean)localObject).booleanValue();
      j = i + (zzeyf.zzkb(2) + 1);
    }
    localObject = zzixz;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.computeStringSize(3, (String)localObject);
    }
    localObject = zziya;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.computeStringSize(4, (String)localObject);
    }
    localObject = zziyb;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.computeStringSize(5, (String)localObject);
    }
    return i;
  }
}
