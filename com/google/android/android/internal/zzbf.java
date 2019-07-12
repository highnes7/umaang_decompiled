package com.google.android.android.internal;

import com.google.android.gms.internal.zzbp;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public abstract interface zzbf
{
  public final class zza
    extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzbf.zza>
  {
    public static final com.google.android.gms.internal.zzeyi<zzbp, com.google.android.gms.internal.zzbf.zza> zzxk = zzeyi.refresh(11, com.google.android.gms.internal.zzbf.zza.class, 810L);
    public static final zza[] zzxl = new zza[0];
    public int[] zzxm;
    public int[] zzxn;
    public int[] zzxo;
    public int zzxp;
    public int[] zzxq;
    public int zzxr;
    public int zzxs;
    
    public zza()
    {
      this$1 = zzeyq.zzoty;
      zzxm = this$1;
      zzxn = this$1;
      zzxo = this$1;
      zzxp = 0;
      zzxq = this$1;
      zzxr = 0;
      zzxs = 0;
      zzotl = null;
      zzomu = -1;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
      if (!zzeyl.equals(zzxm, zzxm)) {
        return false;
      }
      if (!zzeyl.equals(zzxn, zzxn)) {
        return false;
      }
      if (!zzeyl.equals(zzxo, zzxo)) {
        return false;
      }
      if (zzxp != zzxp) {
        return false;
      }
      if (!zzeyl.equals(zzxq, zzxq)) {
        return false;
      }
      if (zzxr != zzxr) {
        return false;
      }
      if (zzxs != zzxs) {
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
      int j = StringBuilder.add(com.google.android.gms.internal.zzbf.zza.class, 527, 31);
      int k = zzeyl.hashCode(zzxm);
      int m = zzeyl.hashCode(zzxn);
      int n = zzeyl.hashCode(zzxo);
      int i1 = zzxp;
      int i2 = zzeyl.hashCode(zzxq);
      int i3 = zzxr;
      int i4 = zzxs;
      zzeyj localZzeyj = zzotl;
      int i;
      if ((localZzeyj != null) && (!localZzeyj.isEmpty())) {
        i = zzotl.hashCode();
      } else {
        i = 0;
      }
      return (((i2 + ((n + (m + (k + j) * 31) * 31) * 31 + i1) * 31) * 31 + i3) * 31 + i4) * 31 + i;
    }
    
    public final void multiply(zzeyf paramZzeyf)
      throws IOException
    {
      int[] arrayOfInt = zzxm;
      int j = 0;
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        i = 0;
        for (;;)
        {
          arrayOfInt = zzxm;
          if (i >= arrayOfInt.length) {
            break;
          }
          paramZzeyf.writeHeader(1, arrayOfInt[i]);
          i += 1;
        }
      }
      arrayOfInt = zzxn;
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        i = 0;
        for (;;)
        {
          arrayOfInt = zzxn;
          if (i >= arrayOfInt.length) {
            break;
          }
          paramZzeyf.writeHeader(2, arrayOfInt[i]);
          i += 1;
        }
      }
      arrayOfInt = zzxo;
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        i = 0;
        for (;;)
        {
          arrayOfInt = zzxo;
          if (i >= arrayOfInt.length) {
            break;
          }
          paramZzeyf.writeHeader(3, arrayOfInt[i]);
          i += 1;
        }
      }
      int i = zzxp;
      if (i != 0) {
        paramZzeyf.writeHeader(4, i);
      }
      arrayOfInt = zzxq;
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        i = j;
        for (;;)
        {
          arrayOfInt = zzxq;
          if (i >= arrayOfInt.length) {
            break;
          }
          paramZzeyf.writeHeader(5, arrayOfInt[i]);
          i += 1;
        }
      }
      i = zzxr;
      if (i != 0) {
        paramZzeyf.writeHeader(6, i);
      }
      i = zzxs;
      if (i != 0) {
        paramZzeyf.writeHeader(7, i);
      }
      super.multiply(paramZzeyf);
    }
    
    public final int updateBookmarks()
    {
      int k = super.updateBookmarks();
      int j = k;
      int[] arrayOfInt = zzxm;
      int m = 0;
      int i = j;
      if (arrayOfInt != null)
      {
        i = j;
        if (arrayOfInt.length > 0)
        {
          i = 0;
          j = 0;
          for (;;)
          {
            arrayOfInt = zzxm;
            if (i >= arrayOfInt.length) {
              break;
            }
            j += zzeyf.zzkc(arrayOfInt[i]);
            i += 1;
          }
          i = k + j + arrayOfInt.length * 1;
        }
      }
      arrayOfInt = zzxn;
      j = i;
      if (arrayOfInt != null)
      {
        j = i;
        if (arrayOfInt.length > 0)
        {
          j = 0;
          k = 0;
          for (;;)
          {
            arrayOfInt = zzxn;
            if (j >= arrayOfInt.length) {
              break;
            }
            k += zzeyf.zzkc(arrayOfInt[j]);
            j += 1;
          }
          j = i + k + arrayOfInt.length * 1;
        }
      }
      arrayOfInt = zzxo;
      k = j;
      if (arrayOfInt != null)
      {
        k = j;
        if (arrayOfInt.length > 0)
        {
          i = 0;
          k = 0;
          for (;;)
          {
            arrayOfInt = zzxo;
            if (i >= arrayOfInt.length) {
              break;
            }
            k += zzeyf.zzkc(arrayOfInt[i]);
            i += 1;
          }
          k = j + k + arrayOfInt.length * 1;
        }
      }
      j = zzxp;
      i = k;
      if (j != 0) {
        i = k + zzeyf.zzaa(4, j);
      }
      arrayOfInt = zzxq;
      j = i;
      if (arrayOfInt != null)
      {
        j = i;
        if (arrayOfInt.length > 0)
        {
          k = 0;
          j = m;
          for (;;)
          {
            arrayOfInt = zzxq;
            if (j >= arrayOfInt.length) {
              break;
            }
            k += zzeyf.zzkc(arrayOfInt[j]);
            j += 1;
          }
          j = i + k + arrayOfInt.length * 1;
        }
      }
      k = zzxr;
      i = j;
      if (k != 0) {
        i = j + zzeyf.zzaa(6, k);
      }
      j = zzxs;
      if (j != 0) {
        return i + zzeyf.zzaa(7, j);
      }
      return i;
    }
  }
}
