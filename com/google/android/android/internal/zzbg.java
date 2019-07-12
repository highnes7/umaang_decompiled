package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzbg
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzbg>
{
  public int level = 1;
  public int zzvt = 0;
  public int zzvu = 0;
  
  public zzbg()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzbg)) {
      return false;
    }
    paramObject = (zzbg)paramObject;
    if (level != level) {
      return false;
    }
    if (zzvt != zzvt) {
      return false;
    }
    if (zzvu != zzvu) {
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
    int j = StringBuilder.add(com.google.android.gms.internal.zzbg.class, 527, 31);
    int k = level;
    int m = zzvt;
    int n = zzvu;
    zzeyj localZzeyj = zzotl;
    int i;
    if ((localZzeyj != null) && (!localZzeyj.isEmpty())) {
      i = zzotl.hashCode();
    } else {
      i = 0;
    }
    return (((j + k) * 31 + m) * 31 + n) * 31 + i;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    int i = level;
    if (i != 1) {
      paramZzeyf.writeHeader(1, i);
    }
    i = zzvt;
    if (i != 0) {
      paramZzeyf.writeHeader(2, i);
    }
    i = zzvu;
    if (i != 0) {
      paramZzeyf.writeHeader(3, i);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    int i = j;
    int k = level;
    if (k != 1) {
      i = j + zzeyf.zzaa(1, k);
    }
    k = zzvt;
    j = i;
    if (k != 0) {
      j = i + zzeyf.zzaa(2, k);
    }
    k = zzvu;
    i = j;
    if (k != 0) {
      i = j + zzeyf.zzaa(3, k);
    }
    return i;
  }
}
