package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcge
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcge>
{
  public String zzilu = null;
  public Long zziym = null;
  public Integer zziyn = null;
  public zzcgf[] zziyo = zzcgf.zzbae();
  public zzcgd[] zziyp = zzcgd.zzbad();
  public zzcfx[] zziyq = zzcfx.zzazz();
  
  public zzcge()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcge)) {
      return false;
    }
    paramObject = (zzcge)paramObject;
    Object localObject = zziym;
    if (localObject == null)
    {
      if (zziym != null) {
        return false;
      }
    }
    else if (!((Long)localObject).equals(zziym)) {
      return false;
    }
    localObject = zzilu;
    if (localObject == null)
    {
      if (zzilu != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzilu)) {
      return false;
    }
    localObject = zziyn;
    if (localObject == null)
    {
      if (zziyn != null) {
        return false;
      }
    }
    else if (!((Integer)localObject).equals(zziyn)) {
      return false;
    }
    if (!zzeyl.equals(zziyo, zziyo)) {
      return false;
    }
    if (!zzeyl.equals(zziyp, zziyp)) {
      return false;
    }
    if (!zzeyl.equals(zziyq, zziyq)) {
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
    int n = StringBuilder.add(com.google.android.gms.internal.zzcge.class, 527, 31);
    Object localObject = zziym;
    int m = 0;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Long)localObject).hashCode();
    }
    localObject = zzilu;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = zziyn;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((Integer)localObject).hashCode();
    }
    int i = StringBuilder.size(zziyo, (((n + i) * 31 + j) * 31 + k) * 31, 31);
    i = StringBuilder.size(zziyp, i, 31);
    int j = StringBuilder.size(zziyq, i, 31);
    localObject = zzotl;
    i = m;
    if (localObject != null) {
      if (((zzeyj)localObject).isEmpty()) {
        i = m;
      } else {
        i = zzotl.hashCode();
      }
    }
    return j + i;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    Object localObject = zziym;
    if (localObject != null) {
      paramZzeyf.writeHeader(1, ((Long)localObject).longValue());
    }
    localObject = zzilu;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, (String)localObject);
    }
    localObject = zziyn;
    if (localObject != null) {
      paramZzeyf.writeHeader(3, ((Integer)localObject).intValue());
    }
    localObject = zziyo;
    int j = 0;
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zziyo;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(4, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    localObject = zziyp;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zziyp;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(5, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    localObject = zziyq;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = zziyq;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(6, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    int i = j;
    Object localObject = zziym;
    if (localObject != null) {
      i = j + zzeyf.setupButton(1, ((Long)localObject).longValue());
    }
    localObject = zzilu;
    int k = i;
    if (localObject != null) {
      k = i + zzeyf.computeStringSize(2, (String)localObject);
    }
    localObject = zziyn;
    j = k;
    if (localObject != null) {
      j = k + zzeyf.zzaa(3, ((Integer)localObject).intValue());
    }
    localObject = zziyo;
    int m = 0;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = j;
        j = 0;
        for (;;)
        {
          localObject = zziyo;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = zzeyf.addMenuItem(4, (zzeyn)localObject) + i;
          }
          j += 1;
          i = k;
        }
      }
    }
    localObject = zziyp;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = zziyp;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + zzeyf.addMenuItem(5, (zzeyn)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    localObject = zziyq;
    k = j;
    if (localObject != null)
    {
      k = j;
      if (localObject.length > 0)
      {
        i = m;
        for (;;)
        {
          localObject = zziyq;
          k = j;
          if (i >= localObject.length) {
            break;
          }
          localObject = localObject[i];
          k = j;
          if (localObject != null) {
            k = j + zzeyf.addMenuItem(6, (zzeyn)localObject);
          }
          i += 1;
          j = k;
        }
      }
    }
    return k;
  }
}
