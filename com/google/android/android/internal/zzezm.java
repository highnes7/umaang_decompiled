package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzezm
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzezm>
  implements Cloneable
{
  public static volatile zzezm[] zzoxo;
  public String name = "";
  public String value = "";
  
  public zzezm()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzezm[] zzcwu()
  {
    if (zzoxo == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zzoxo == null) {
          zzoxo = new zzezm[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zzoxo;
  }
  
  private zzezm zzcwv()
  {
    try
    {
      zzeyh localZzeyh = super.zzcvz();
      return (zzezm)localZzeyh;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzezm)) {
      return false;
    }
    paramObject = (zzezm)paramObject;
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
    localObject = value;
    if (localObject == null)
    {
      if (value != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(value)) {
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
    int n = StringBuilder.add(com.google.android.gms.internal.zzezm.class, 527, 31);
    Object localObject = name;
    int m = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    localObject = value;
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
    return ((n + i) * 31 + j) * 31 + k;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    String str = name;
    if ((str != null) && (!str.equals(""))) {
      paramZzeyf.writeHeader(1, name);
    }
    str = value;
    if ((str != null) && (!str.equals(""))) {
      paramZzeyf.writeHeader(2, value);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int k = super.updateBookmarks();
    int i = k;
    String str = name;
    int j = i;
    if (str != null)
    {
      j = i;
      if (!str.equals("")) {
        j = k + zzeyf.computeStringSize(1, name);
      }
    }
    str = value;
    if ((str != null) && (!str.equals(""))) {
      return j + zzeyf.computeStringSize(2, value);
    }
    return j;
  }
}
