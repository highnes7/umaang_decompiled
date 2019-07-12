package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzbn
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzbn>
{
  public static volatile zzbn[] zzxt;
  public String name = "";
  public zzbp zzxu = null;
  public zzbj zzxv = null;
  
  public zzbn()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzbn[] getEquipment()
  {
    if (zzxt == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zzxt == null) {
          zzxt = new zzbn[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zzxt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzbn)) {
      return false;
    }
    paramObject = (zzbn)paramObject;
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
    localObject = zzxu;
    if (localObject == null)
    {
      if (zzxu != null) {
        return false;
      }
    }
    else if (!((zzbp)localObject).equals(zzxu)) {
      return false;
    }
    localObject = zzxv;
    if (localObject == null)
    {
      if (zzxv != null) {
        return false;
      }
    }
    else if (!((zzbj)localObject).equals(zzxv)) {
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
    int i1 = StringBuilder.add(com.google.android.gms.internal.zzbn.class, 527, 31);
    Object localObject = name;
    int n = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    localObject = zzxu;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((zzbp)localObject).hashCode();
    }
    localObject = zzxv;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((zzbj)localObject).hashCode();
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
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(1, name);
    }
    localObject = zzxu;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, (zzeyn)localObject);
    }
    localObject = zzxv;
    if (localObject != null) {
      paramZzeyf.writeHeader(3, (zzeyn)localObject);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int k = super.updateBookmarks();
    int j = k;
    Object localObject = name;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (!((String)localObject).equals("")) {
        i = k + zzeyf.computeStringSize(1, name);
      }
    }
    localObject = zzxu;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.addMenuItem(2, (zzeyn)localObject);
    }
    localObject = zzxv;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.addMenuItem(3, (zzeyn)localObject);
    }
    return i;
  }
}
