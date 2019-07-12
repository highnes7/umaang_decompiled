package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcgc
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcgc>
{
  public Integer zziyf = null;
  public String zziyg = null;
  public Boolean zziyh = null;
  public String[] zziyi = zzeyq.EMPTY_STRING_ARRAY;
  
  public zzcgc()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcgc)) {
      return false;
    }
    paramObject = (zzcgc)paramObject;
    Object localObject = zziyf;
    if (localObject == null)
    {
      if (zziyf != null) {
        return false;
      }
    }
    else if (!((Integer)localObject).equals(zziyf)) {
      return false;
    }
    localObject = zziyg;
    if (localObject == null)
    {
      if (zziyg != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zziyg)) {
      return false;
    }
    localObject = zziyh;
    if (localObject == null)
    {
      if (zziyh != null) {
        return false;
      }
    }
    else if (!((Boolean)localObject).equals(zziyh)) {
      return false;
    }
    if (!zzeyl.equals(zziyi, zziyi)) {
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
    int n = StringBuilder.add(com.google.android.gms.internal.zzcgc.class, 527, 31);
    Object localObject = zziyf;
    int m = 0;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Integer)localObject).intValue();
    }
    localObject = zziyg;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = zziyh;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((Boolean)localObject).hashCode();
    }
    int j = StringBuilder.size(zziyi, (((n + i) * 31 + j) * 31 + k) * 31, 31);
    localObject = zzotl;
    int i = m;
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
    Object localObject = zziyf;
    if (localObject != null) {
      paramZzeyf.writeHeader(1, ((Integer)localObject).intValue());
    }
    localObject = zziyg;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, (String)localObject);
    }
    localObject = zziyh;
    if (localObject != null) {
      paramZzeyf.writeHeader(3, ((Boolean)localObject).booleanValue());
    }
    localObject = zziyi;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = zziyi;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(4, (String)localObject);
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
    Object localObject = zziyf;
    if (localObject != null) {
      i = j + zzeyf.zzaa(1, ((Integer)localObject).intValue());
    }
    localObject = zziyg;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.computeStringSize(2, (String)localObject);
    }
    localObject = zziyh;
    i = j;
    if (localObject != null)
    {
      ((Boolean)localObject).booleanValue();
      i = j + (zzeyf.zzkb(3) + 1);
    }
    localObject = zziyi;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        int k = 0;
        int n = 0;
        for (;;)
        {
          localObject = zziyi;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          int i1 = n;
          int m = k;
          if (localObject != null)
          {
            i1 = n + 1;
            m = zzeyf.zztk((String)localObject) + k;
          }
          j += 1;
          n = i1;
          k = m;
        }
        j = i + k + n * 1;
      }
    }
    return j;
  }
}
