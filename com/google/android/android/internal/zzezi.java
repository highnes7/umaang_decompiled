package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzezi
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzezi>
  implements Cloneable
{
  public String[] zzowl;
  public String[] zzowm;
  public int[] zzown;
  public long[] zzowo;
  public long[] zzowp;
  
  public zzezi()
  {
    Object localObject = zzeyq.EMPTY_STRING_ARRAY;
    zzowl = ((String[])localObject);
    zzowm = ((String[])localObject);
    zzown = zzeyq.zzoty;
    localObject = zzeyq.zzotz;
    zzowo = ((long[])localObject);
    zzowp = ((long[])localObject);
    zzotl = null;
    zzomu = -1;
  }
  
  private zzezi zzcwq()
  {
    try
    {
      Object localObject1 = super.zzcvz();
      localObject1 = (zzezi)localObject1;
      Object localObject2 = zzowl;
      if ((localObject2 != null) && (localObject2.length > 0)) {
        zzowl = ((String[])localObject2.clone());
      }
      localObject2 = zzowm;
      if ((localObject2 != null) && (localObject2.length > 0)) {
        zzowm = ((String[])localObject2.clone());
      }
      localObject2 = zzown;
      if ((localObject2 != null) && (localObject2.length > 0)) {
        zzown = ((int[])localObject2.clone());
      }
      localObject2 = zzowo;
      if ((localObject2 != null) && (localObject2.length > 0)) {
        zzowo = ((long[])localObject2.clone());
      }
      localObject2 = zzowp;
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        zzowp = ((long[])localObject2.clone());
        return localObject1;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    return localCloneNotSupportedException;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzezi)) {
      return false;
    }
    paramObject = (zzezi)paramObject;
    if (!zzeyl.equals(zzowl, zzowl)) {
      return false;
    }
    if (!zzeyl.equals(zzowm, zzowm)) {
      return false;
    }
    if (!zzeyl.equals(zzown, zzown)) {
      return false;
    }
    if (!zzeyl.equals(zzowo, zzowo)) {
      return false;
    }
    if (!zzeyl.equals(zzowp, zzowp)) {
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
    int i = StringBuilder.add(com.google.android.gms.internal.zzezi.class, 527, 31);
    i = StringBuilder.size(zzowl, i, 31);
    int j = StringBuilder.size(zzowm, i, 31);
    int k = zzeyl.hashCode(zzown);
    int m = zzeyl.hashCode(zzowo);
    int n = zzeyl.hashCode(zzowp);
    zzeyj localZzeyj = zzotl;
    if ((localZzeyj != null) && (!localZzeyj.isEmpty())) {
      i = zzotl.hashCode();
    } else {
      i = 0;
    }
    return (n + (m + (k + j) * 31) * 31) * 31 + i;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    Object localObject = zzowl;
    int j = 0;
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzowl;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(1, (String)localObject);
        }
        i += 1;
      }
    }
    localObject = zzowm;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzowm;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(2, (String)localObject);
        }
        i += 1;
      }
    }
    localObject = zzown;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzown;
        if (i >= localObject.length) {
          break;
        }
        paramZzeyf.writeHeader(3, localObject[i]);
        i += 1;
      }
    }
    localObject = zzowo;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzowo;
        if (i >= localObject.length) {
          break;
        }
        paramZzeyf.writeHeader(4, localObject[i]);
        i += 1;
      }
    }
    localObject = zzowp;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = zzowp;
        if (i >= localObject.length) {
          break;
        }
        paramZzeyf.writeHeader(5, localObject[i]);
        i += 1;
      }
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int i1 = super.updateBookmarks();
    int j = i1;
    Object localObject = zzowl;
    int i2 = 0;
    int i = j;
    int m;
    int n;
    int k;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = 0;
        j = 0;
        m = 0;
        for (;;)
        {
          localObject = zzowl;
          if (i >= localObject.length) {
            break;
          }
          localObject = localObject[i];
          n = m;
          k = j;
          if (localObject != null)
          {
            n = m + 1;
            k = zzeyf.zztk((String)localObject) + j;
          }
          i += 1;
          m = n;
          j = k;
        }
        i = i1 + j + m * 1;
      }
    }
    localObject = zzowm;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        k = 0;
        n = 0;
        for (;;)
        {
          localObject = zzowm;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          i1 = n;
          m = k;
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
    localObject = zzown;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = 0;
        k = 0;
        for (;;)
        {
          localObject = zzown;
          if (i >= localObject.length) {
            break;
          }
          k += zzeyf.zzkc(localObject[i]);
          i += 1;
        }
        i = j + k + localObject.length * 1;
      }
    }
    localObject = zzowo;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        k = 0;
        for (;;)
        {
          localObject = zzowo;
          if (j >= localObject.length) {
            break;
          }
          k += zzeyf.zzdg(localObject[j]);
          j += 1;
        }
        j = i + k + localObject.length * 1;
      }
    }
    localObject = zzowp;
    if ((localObject != null) && (localObject.length > 0))
    {
      k = 0;
      i = i2;
      for (;;)
      {
        localObject = zzowp;
        if (i >= localObject.length) {
          break;
        }
        k += zzeyf.zzdg(localObject[i]);
        i += 1;
      }
      return j + k + localObject.length * 1;
    }
    return j;
  }
}
