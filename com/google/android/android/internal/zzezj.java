package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzezj
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzezj>
  implements Cloneable
{
  public String version = "";
  public int zzimf = 0;
  public String zzowq = "";
  
  public zzezj()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  private zzezj zzcwr()
  {
    try
    {
      zzeyh localZzeyh = super.zzcvz();
      return (zzezj)localZzeyh;
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
    if (!(paramObject instanceof zzezj)) {
      return false;
    }
    paramObject = (zzezj)paramObject;
    if (zzimf != zzimf) {
      return false;
    }
    Object localObject = zzowq;
    if (localObject == null)
    {
      if (zzowq != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzowq)) {
      return false;
    }
    localObject = version;
    if (localObject == null)
    {
      if (version != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(version)) {
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
    int n = StringBuilder.add(com.google.android.gms.internal.zzezj.class, 527, 31);
    int i1 = zzimf;
    Object localObject = zzowq;
    int m = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    localObject = version;
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
    return (((n + i1) * 31 + i) * 31 + j) * 31 + k;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    int i = zzimf;
    if (i != 0) {
      paramZzeyf.writeHeader(1, i);
    }
    String str = zzowq;
    if ((str != null) && (!str.equals(""))) {
      paramZzeyf.writeHeader(2, zzowq);
    }
    str = version;
    if ((str != null) && (!str.equals(""))) {
      paramZzeyf.writeHeader(3, version);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    int i = j;
    int k = zzimf;
    if (k != 0) {
      i = j + zzeyf.zzaa(1, k);
    }
    String str = zzowq;
    j = i;
    if (str != null)
    {
      j = i;
      if (!str.equals("")) {
        j = i + zzeyf.computeStringSize(2, zzowq);
      }
    }
    str = version;
    i = j;
    if (str != null)
    {
      i = j;
      if (!str.equals("")) {
        i = j + zzeyf.computeStringSize(3, version);
      }
    }
    return i;
  }
}
