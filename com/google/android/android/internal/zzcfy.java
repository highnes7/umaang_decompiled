package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzcfy
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzcfy>
{
  public static volatile zzcfy[] zzixm;
  public Integer zzixn = null;
  public String zzixo = null;
  public zzcfz[] zzixp = zzcfz.zzbab();
  public Boolean zzixq = null;
  public zzcga zzixr = null;
  
  public zzcfy()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzcfy[] zzbaa()
  {
    if (zzixm == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zzixm == null) {
          zzixm = new zzcfy[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zzixm;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzcfy)) {
      return false;
    }
    paramObject = (zzcfy)paramObject;
    Object localObject = zzixn;
    if (localObject == null)
    {
      if (zzixn != null) {
        return false;
      }
    }
    else if (!((Integer)localObject).equals(zzixn)) {
      return false;
    }
    localObject = zzixo;
    if (localObject == null)
    {
      if (zzixo != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzixo)) {
      return false;
    }
    if (!zzeyl.equals(zzixp, zzixp)) {
      return false;
    }
    localObject = zzixq;
    if (localObject == null)
    {
      if (zzixq != null) {
        return false;
      }
    }
    else if (!((Boolean)localObject).equals(zzixq)) {
      return false;
    }
    localObject = zzixr;
    if (localObject == null)
    {
      if (zzixr != null) {
        return false;
      }
    }
    else if (!((zzcga)localObject).equals(zzixr)) {
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
    int k = StringBuilder.add(com.google.android.gms.internal.zzcfy.class, 527, 31);
    Object localObject = zzixn;
    int m = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Integer)localObject).hashCode();
    }
    localObject = zzixo;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    int n = StringBuilder.size(zzixp, ((k + i) * 31 + j) * 31, 31);
    localObject = zzixq;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Boolean)localObject).hashCode();
    }
    localObject = zzixr;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((zzcga)localObject).hashCode();
    }
    localObject = zzotl;
    k = m;
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
    Object localObject = zzixn;
    if (localObject != null) {
      paramZzeyf.writeHeader(1, ((Integer)localObject).intValue());
    }
    localObject = zzixo;
    if (localObject != null) {
      paramZzeyf.writeHeader(2, (String)localObject);
    }
    localObject = zzixp;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = zzixp;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(3, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    localObject = zzixq;
    if (localObject != null) {
      paramZzeyf.writeHeader(4, ((Boolean)localObject).booleanValue());
    }
    localObject = zzixr;
    if (localObject != null) {
      paramZzeyf.writeHeader(5, (zzeyn)localObject);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int i = super.updateBookmarks();
    int j = i;
    Object localObject = zzixn;
    if (localObject != null) {
      j = i + zzeyf.zzaa(1, ((Integer)localObject).intValue());
    }
    localObject = zzixo;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.computeStringSize(2, (String)localObject);
    }
    localObject = zzixp;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = zzixp;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + zzeyf.addMenuItem(3, (zzeyn)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    localObject = zzixq;
    i = j;
    if (localObject != null)
    {
      ((Boolean)localObject).booleanValue();
      i = j + (zzeyf.zzkb(4) + 1);
    }
    localObject = zzixr;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.addMenuItem(5, (zzeyn)localObject);
    }
    return j;
  }
}
