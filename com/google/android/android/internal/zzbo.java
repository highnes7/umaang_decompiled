package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzbo
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzbo>
{
  public zzbn[] zzxw = zzbn.getEquipment();
  public zzbl zzxx = null;
  public String zzxy = "";
  
  public zzbo()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzbo)) {
      return false;
    }
    paramObject = (zzbo)paramObject;
    if (!zzeyl.equals(zzxw, zzxw)) {
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
    localObject = zzxy;
    if (localObject == null)
    {
      if (zzxy != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzxy)) {
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
    int n = StringBuilder.add(com.google.android.gms.internal.zzbo.class, 527, 31);
    int i1 = zzeyl.hashCode(zzxw);
    Object localObject = zzxx;
    int m = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((zzbl)localObject).hashCode();
    }
    localObject = zzxy;
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
    return (((i1 + n) * 31 + i) * 31 + j) * 31 + k;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    Object localObject = zzxw;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = zzxw;
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
    localObject = zzxx;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, (zzeyn)localObject);
    }
    localObject = zzxy;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(3, zzxy);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int i = super.updateBookmarks();
    Object localObject = zzxw;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = zzxw;
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
    localObject = zzxx;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.addMenuItem(2, (zzeyn)localObject);
    }
    localObject = zzxy;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((String)localObject).equals("")) {
        j = i + zzeyf.computeStringSize(3, zzxy);
      }
    }
    return j;
  }
}
