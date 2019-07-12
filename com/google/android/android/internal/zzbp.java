package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzbp
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzbp>
{
  public static volatile zzbp[] zzxz;
  public String string = "";
  public int type = 1;
  public zzbp[] zzya = getEquipment();
  public zzbp[] zzyb = getEquipment();
  public zzbp[] zzyc = getEquipment();
  public String zzyd = "";
  public String zzye = "";
  public long zzyf = 0L;
  public boolean zzyg = false;
  public zzbp[] zzyh = getEquipment();
  public int[] zzyi = zzeyq.zzoty;
  public boolean zzyj = false;
  
  public zzbp()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzbp[] getEquipment()
  {
    if (zzxz == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zzxz == null) {
          zzxz = new zzbp[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zzxz;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzbp)) {
      return false;
    }
    paramObject = (zzbp)paramObject;
    if (type != type) {
      return false;
    }
    Object localObject = string;
    if (localObject == null)
    {
      if (string != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(string)) {
      return false;
    }
    if (!zzeyl.equals(zzya, zzya)) {
      return false;
    }
    if (!zzeyl.equals(zzyb, zzyb)) {
      return false;
    }
    if (!zzeyl.equals(zzyc, zzyc)) {
      return false;
    }
    localObject = zzyd;
    if (localObject == null)
    {
      if (zzyd != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzyd)) {
      return false;
    }
    localObject = zzye;
    if (localObject == null)
    {
      if (zzye != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzye)) {
      return false;
    }
    if (zzyf != zzyf) {
      return false;
    }
    if (zzyg != zzyg) {
      return false;
    }
    if (!zzeyl.equals(zzyh, zzyh)) {
      return false;
    }
    if (!zzeyl.equals(zzyi, zzyi)) {
      return false;
    }
    if (zzyj != zzyj) {
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
    int j = StringBuilder.add(com.google.android.gms.internal.zzbp.class, 527, 31);
    int k = type;
    Object localObject = string;
    int m = 0;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    int i = StringBuilder.size(zzya, ((j + k) * 31 + i) * 31, 31);
    i = StringBuilder.size(zzyb, i, 31);
    int i1 = StringBuilder.size(zzyc, i, 31);
    localObject = zzyd;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    localObject = zzye;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    long l = zzyf;
    int i2 = (int)(l ^ l >>> 32);
    boolean bool = zzyg;
    int n = 1231;
    if (bool) {
      k = 1231;
    } else {
      k = 1237;
    }
    k = StringBuilder.size(zzyh, ((((i1 + i) * 31 + j) * 31 + i2) * 31 + k) * 31, 31);
    i1 = zzeyl.hashCode(zzyi);
    if (zzyj) {
      i = n;
    } else {
      i = 1237;
    }
    localObject = zzotl;
    j = m;
    if (localObject != null) {
      if (((zzeyj)localObject).isEmpty()) {
        j = m;
      } else {
        j = zzotl.hashCode();
      }
    }
    return ((i1 + k) * 31 + i) * 31 + j;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    paramZzeyf.writeHeader(1, type);
    Object localObject = string;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(2, string);
    }
    localObject = zzya;
    int j = 0;
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzya;
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
    localObject = zzyb;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzyb;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(4, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    localObject = zzyc;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzyc;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(5, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    localObject = zzyd;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(6, zzyd);
    }
    localObject = zzye;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(7, zzye);
    }
    long l = zzyf;
    if (l != 0L) {
      paramZzeyf.writeHeader(8, l);
    }
    boolean bool = zzyj;
    if (bool) {
      paramZzeyf.writeHeader(9, bool);
    }
    localObject = zzyi;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzyi;
        if (i >= localObject.length) {
          break;
        }
        paramZzeyf.writeHeader(10, localObject[i]);
        i += 1;
      }
    }
    localObject = zzyh;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = zzyh;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(11, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    bool = zzyg;
    if (bool) {
      paramZzeyf.writeHeader(12, bool);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int i = super.updateBookmarks();
    i = zzeyf.zzaa(1, type) + i;
    Object localObject = string;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (!((String)localObject).equals("")) {
        j = i + zzeyf.computeStringSize(2, string);
      }
    }
    localObject = zzya;
    int m = 0;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = zzya;
          i = j;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          i = j;
          if (localObject != null) {
            i = zzeyf.addMenuItem(3, (zzeyn)localObject) + j;
          }
          k += 1;
          j = i;
        }
      }
    }
    localObject = zzyb;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = zzyb;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + zzeyf.addMenuItem(4, (zzeyn)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    localObject = zzyc;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = zzyc;
          i = j;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          i = j;
          if (localObject != null) {
            i = j + zzeyf.addMenuItem(5, (zzeyn)localObject);
          }
          k += 1;
          j = i;
        }
      }
    }
    localObject = zzyd;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((String)localObject).equals("")) {
        j = i + zzeyf.computeStringSize(6, zzyd);
      }
    }
    localObject = zzye;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (!((String)localObject).equals("")) {
        i = j + zzeyf.computeStringSize(7, zzye);
      }
    }
    long l = zzyf;
    int k = i;
    if (l != 0L) {
      k = i + zzeyf.setupButton(8, l);
    }
    j = k;
    if (zzyj) {
      j = k + (zzeyf.zzkb(9) + 1);
    }
    localObject = zzyi;
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
          localObject = zzyi;
          if (i >= localObject.length) {
            break;
          }
          k += zzeyf.zzkc(localObject[i]);
          i += 1;
        }
        i = j + k + localObject.length * 1;
      }
    }
    localObject = zzyh;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = m;
        for (;;)
        {
          localObject = zzyh;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + zzeyf.addMenuItem(11, (zzeyn)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    if (zzyg) {
      return k + (zzeyf.zzkb(12) + 1);
    }
    return k;
  }
}
