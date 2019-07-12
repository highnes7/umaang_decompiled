package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzbi
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzbi>
{
  public static volatile zzbi[] zzwa;
  public String name = "";
  public long zzwb = 0L;
  public long zzwc = 2147483647L;
  public boolean zzwd = false;
  public long zzwe = 0L;
  
  public zzbi()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzbi[] getEquipment()
  {
    if (zzwa == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zzwa == null) {
          zzwa = new zzbi[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zzwa;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzbi)) {
      return false;
    }
    paramObject = (zzbi)paramObject;
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
    if (zzwb != zzwb) {
      return false;
    }
    if (zzwc != zzwc) {
      return false;
    }
    if (zzwd != zzwd) {
      return false;
    }
    if (zzwe != zzwe) {
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
    int n = StringBuilder.add(com.google.android.gms.internal.zzbi.class, 527, 31);
    Object localObject = name;
    int m = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    long l = zzwb;
    int i1 = (int)(l ^ l >>> 32);
    l = zzwc;
    int i2 = (int)(l ^ l >>> 32);
    int j;
    if (zzwd) {
      j = 1231;
    } else {
      j = 1237;
    }
    l = zzwe;
    int i3 = (int)(l ^ l >>> 32);
    localObject = zzotl;
    int k = m;
    if (localObject != null) {
      if (((zzeyj)localObject).isEmpty()) {
        k = m;
      } else {
        k = zzotl.hashCode();
      }
    }
    return (((((n + i) * 31 + i1) * 31 + i2) * 31 + j) * 31 + i3) * 31 + k;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    String str = name;
    if ((str != null) && (!str.equals(""))) {
      paramZzeyf.writeHeader(1, name);
    }
    long l = zzwb;
    if (l != 0L) {
      paramZzeyf.writeHeader(2, l);
    }
    l = zzwc;
    if (l != 2147483647L) {
      paramZzeyf.writeHeader(3, l);
    }
    boolean bool = zzwd;
    if (bool) {
      paramZzeyf.writeHeader(4, bool);
    }
    l = zzwe;
    if (l != 0L) {
      paramZzeyf.writeHeader(5, l);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int k = super.updateBookmarks();
    int j = k;
    String str = name;
    int i = j;
    if (str != null)
    {
      i = j;
      if (!str.equals("")) {
        i = k + zzeyf.computeStringSize(1, name);
      }
    }
    long l = zzwb;
    j = i;
    if (l != 0L) {
      j = i + zzeyf.setupButton(2, l);
    }
    l = zzwc;
    i = j;
    if (l != 2147483647L) {
      i = j + zzeyf.setupButton(3, l);
    }
    j = i;
    if (zzwd) {
      j = i + (zzeyf.zzkb(4) + 1);
    }
    l = zzwe;
    i = j;
    if (l != 0L) {
      i = j + zzeyf.setupButton(5, l);
    }
    return i;
  }
}
