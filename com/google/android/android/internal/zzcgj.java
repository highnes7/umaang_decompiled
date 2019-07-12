package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcgj
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcgj>
{
  public zzcgk[] zzizc = zzcgk.zzbai();
  
  public zzcgj()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcgj)) {
      return false;
    }
    paramObject = (zzcgj)paramObject;
    if (!zzeyl.equals(zzizc, zzizc)) {
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
    int i = StringBuilder.add(com.google.android.gms.internal.zzcgj.class, 527, 31);
    int j = StringBuilder.size(zzizc, i, 31);
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
    Object localObject = zzizc;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = zzizc;
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
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int i = super.updateBookmarks();
    int j = i;
    Object localObject = zzizc;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzizc;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        int k = j;
        if (localObject != null) {
          k = j + zzeyf.addMenuItem(1, (zzeyn)localObject);
        }
        i += 1;
        j = k;
      }
    }
    return i;
    return j;
  }
}
