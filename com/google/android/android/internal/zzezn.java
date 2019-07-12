package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzezn
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzezn>
  implements Cloneable
{
  public int zzoxp = -1;
  public int zzoxq = 0;
  
  public zzezn()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  private zzezn zzcww()
  {
    try
    {
      zzeyh localZzeyh = super.zzcvz();
      return (zzezn)localZzeyh;
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
    if (!(paramObject instanceof zzezn)) {
      return false;
    }
    paramObject = (zzezn)paramObject;
    if (zzoxp != zzoxp) {
      return false;
    }
    if (zzoxq != zzoxq) {
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
    int j = StringBuilder.add(com.google.android.gms.internal.zzezn.class, 527, 31);
    int k = zzoxp;
    int m = zzoxq;
    zzeyj localZzeyj = zzotl;
    int i;
    if ((localZzeyj != null) && (!localZzeyj.isEmpty())) {
      i = zzotl.hashCode();
    } else {
      i = 0;
    }
    return ((j + k) * 31 + m) * 31 + i;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    int i = zzoxp;
    if (i != -1) {
      paramZzeyf.writeHeader(1, i);
    }
    i = zzoxq;
    if (i != 0) {
      paramZzeyf.writeHeader(2, i);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    int i = j;
    int k = zzoxp;
    if (k != -1) {
      i = j + zzeyf.zzaa(1, k);
    }
    k = zzoxq;
    j = i;
    if (k != 0) {
      j = i + zzeyf.zzaa(2, k);
    }
    return j;
  }
}
