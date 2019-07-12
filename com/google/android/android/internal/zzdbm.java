package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzdbm
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzdbm>
{
  public long zzkfj = 0L;
  public zzbo zzkfk = null;
  public zzbl zzxx = null;
  
  public zzdbm()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzdbm)) {
      return false;
    }
    paramObject = (zzdbm)paramObject;
    if (zzkfj != zzkfj) {
      return false;
    }
    Object localObject = zzxx;
    if (localObject == null)
    {
      if (zzxx != null) {
        return false;
      }
    }
    else if (!((zzbl)localObject).equals(zzxx)) {
      return false;
    }
    localObject = zzkfk;
    if (localObject == null)
    {
      if (zzkfk != null) {
        return false;
      }
    }
    else if (!((zzbo)localObject).equals(zzkfk)) {
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
    int n = StringBuilder.add(com.google.android.gms.internal.zzdbm.class, 527, 31);
    long l = zzkfj;
    int i1 = (int)(l ^ l >>> 32);
    Object localObject = zzxx;
    int m = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((zzbl)localObject).hashCode();
    }
    localObject = zzkfk;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((zzbo)localObject).hashCode();
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
    return (((n + i1) * 31 + i) * 31 + j) * 31 + k;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    paramZzeyf.writeHeader(1, zzkfj);
    Object localObject = zzxx;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, (zzeyn)localObject);
    }
    localObject = zzkfk;
    if (localObject != null) {
      paramZzeyf.writeHeader(3, (zzeyn)localObject);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int i = super.updateBookmarks();
    int j = zzeyf.setupButton(1, zzkfj) + i;
    Object localObject = zzxx;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.addMenuItem(2, (zzeyn)localObject);
    }
    localObject = zzkfk;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.addMenuItem(3, (zzeyn)localObject);
    }
    return j;
  }
}
