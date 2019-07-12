package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzbj
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzbj>
{
  public zzbp[] zzwf = zzbp.getEquipment();
  public zzbp[] zzwg = zzbp.getEquipment();
  public zzbi[] zzwh = zzbi.getEquipment();
  
  public zzbj()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzbj)) {
      return false;
    }
    paramObject = (zzbj)paramObject;
    if (!zzeyl.equals(zzwf, zzwf)) {
      return false;
    }
    if (!zzeyl.equals(zzwg, zzwg)) {
      return false;
    }
    if (!zzeyl.equals(zzwh, zzwh)) {
      return false;
    }
    zzeyj localZzeyj = zzotl;
    if ((localZzeyj != null) && (!localZzeyj.isEmpty())) {
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
    int i = StringBuilder.add(com.google.android.gms.internal.zzbj.class, 527, 31);
    i = StringBuilder.size(zzwf, i, 31);
    i = StringBuilder.size(zzwg, i, 31);
    int j = StringBuilder.size(zzwh, i, 31);
    zzeyj localZzeyj = zzotl;
    if ((localZzeyj != null) && (!localZzeyj.isEmpty())) {
      i = zzotl.hashCode();
    } else {
      i = 0;
    }
    return j + i;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    Object localObject = zzwf;
    int j = 0;
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzwf;
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
    localObject = zzwg;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzwg;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(2, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    localObject = zzwh;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = zzwh;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(3, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int i = super.updateBookmarks();
    int k = i;
    Object localObject = zzwf;
    int m = 0;
    int j = k;
    if (localObject != null)
    {
      j = k;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = zzwf;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = zzeyf.addMenuItem(1, (zzeyn)localObject) + i;
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    localObject = zzwg;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = zzwg;
          i = j;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          i = j;
          if (localObject != null) {
            i = j + zzeyf.addMenuItem(2, (zzeyn)localObject);
          }
          k += 1;
          j = i;
        }
      }
    }
    localObject = zzwh;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = m;
        for (;;)
        {
          localObject = zzwh;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + zzeyf.addMenuItem(3, (zzeyn)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
}
