package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzbk
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzbk>
{
  public static volatile zzbk[] zzwi;
  public int length = 0;
  public int value = 0;
  
  public zzbk()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzbk[] getEquipment()
  {
    if (zzwi == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zzwi == null) {
          zzwi = new zzbk[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zzwi;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzbk)) {
      return false;
    }
    paramObject = (zzbk)paramObject;
    if (length != length) {
      return false;
    }
    if (value != value) {
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
    int j = StringBuilder.add(com.google.android.gms.internal.zzbk.class, 527, 31);
    int k = length;
    int m = value;
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
    paramZzeyf.writeHeader(1, length);
    paramZzeyf.writeHeader(2, value);
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int i = super.updateBookmarks();
    int j = zzeyf.zzaa(1, length);
    return zzeyf.zzaa(2, value) + (j + i);
  }
}
