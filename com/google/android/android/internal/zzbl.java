package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;

public final class zzbl
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzbl>
{
  public String version;
  public String[] zzwj;
  public String[] zzwk;
  public zzbp[] zzwl;
  public zzbk[] zzwm;
  public zzbh[] zzwn;
  public zzbh[] zzwo;
  public zzbh[] zzwp;
  public zzbm[] zzwq;
  public String zzwr;
  public String zzws;
  public String zzwt;
  public zzbg zzwu;
  public float zzwv;
  public boolean zzww;
  public String[] zzwx;
  public int zzwy;
  
  public zzbl()
  {
    String[] arrayOfString = zzeyq.EMPTY_STRING_ARRAY;
    zzwj = arrayOfString;
    zzwk = arrayOfString;
    zzwl = zzbp.getEquipment();
    zzwm = zzbk.getEquipment();
    zzwn = zzbh.getEquipment();
    zzwo = zzbh.getEquipment();
    zzwp = zzbh.getEquipment();
    zzwq = zzbm.getEquipment();
    zzwr = "";
    zzws = "";
    zzwt = "0";
    version = "";
    zzwu = null;
    zzwv = 0.0F;
    zzww = false;
    zzwx = zzeyq.EMPTY_STRING_ARRAY;
    zzwy = 0;
    zzotl = null;
    zzomu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzbl)) {
      return false;
    }
    paramObject = (zzbl)paramObject;
    if (!zzeyl.equals(zzwj, zzwj)) {
      return false;
    }
    if (!zzeyl.equals(zzwk, zzwk)) {
      return false;
    }
    if (!zzeyl.equals(zzwl, zzwl)) {
      return false;
    }
    if (!zzeyl.equals(zzwm, zzwm)) {
      return false;
    }
    if (!zzeyl.equals(zzwn, zzwn)) {
      return false;
    }
    if (!zzeyl.equals(zzwo, zzwo)) {
      return false;
    }
    if (!zzeyl.equals(zzwp, zzwp)) {
      return false;
    }
    if (!zzeyl.equals(zzwq, zzwq)) {
      return false;
    }
    Object localObject = zzwr;
    if (localObject == null)
    {
      if (zzwr != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzwr)) {
      return false;
    }
    localObject = zzws;
    if (localObject == null)
    {
      if (zzws != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzws)) {
      return false;
    }
    localObject = zzwt;
    if (localObject == null)
    {
      if (zzwt != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzwt)) {
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
    localObject = zzwu;
    if (localObject == null)
    {
      if (zzwu != null) {
        return false;
      }
    }
    else if (!((zzbg)localObject).equals(zzwu)) {
      return false;
    }
    if (Float.floatToIntBits(zzwv) != Float.floatToIntBits(zzwv)) {
      return false;
    }
    if (zzww != zzww) {
      return false;
    }
    if (!zzeyl.equals(zzwx, zzwx)) {
      return false;
    }
    if (zzwy != zzwy) {
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
    int i = StringBuilder.add(com.google.android.gms.internal.zzbl.class, 527, 31);
    i = StringBuilder.size(zzwj, i, 31);
    i = StringBuilder.size(zzwk, i, 31);
    i = StringBuilder.size(zzwl, i, 31);
    i = StringBuilder.size(zzwm, i, 31);
    i = StringBuilder.size(zzwn, i, 31);
    i = StringBuilder.size(zzwo, i, 31);
    i = StringBuilder.size(zzwp, i, 31);
    int i3 = StringBuilder.size(zzwq, i, 31);
    Object localObject = zzwr;
    int i2 = 0;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    localObject = zzws;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = zzwt;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((String)localObject).hashCode();
    }
    localObject = version;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((String)localObject).hashCode();
    }
    localObject = zzwu;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = ((zzbg)localObject).hashCode();
    }
    int i4 = Float.floatToIntBits(zzwv);
    int i1;
    if (zzww) {
      i1 = 1231;
    } else {
      i1 = 1237;
    }
    int j = StringBuilder.size(zzwx, ((i4 + (((((i3 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31) * 31 + i1) * 31, 31);
    int k = zzwy;
    localObject = zzotl;
    i = i2;
    if (localObject != null) {
      if (((zzeyj)localObject).isEmpty()) {
        i = i2;
      } else {
        i = zzotl.hashCode();
      }
    }
    return (j + k) * 31 + i;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    Object localObject = zzwk;
    int j = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzwk;
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
    localObject = zzwl;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzwl;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(2, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    localObject = zzwm;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzwm;
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
    localObject = zzwn;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzwn;
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
    localObject = zzwo;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzwo;
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
    localObject = zzwp;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzwp;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(6, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    localObject = zzwq;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzwq;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(7, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    localObject = zzwr;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(9, zzwr);
    }
    localObject = zzws;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(10, zzws);
    }
    localObject = zzwt;
    if ((localObject != null) && (!((String)localObject).equals("0"))) {
      paramZzeyf.writeHeader(12, zzwt);
    }
    localObject = version;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(13, version);
    }
    localObject = zzwu;
    if (localObject != null) {
      paramZzeyf.writeHeader(14, (zzeyn)localObject);
    }
    if (Float.floatToIntBits(zzwv) != Float.floatToIntBits(0.0F)) {
      paramZzeyf.put(15, zzwv);
    }
    localObject = zzwx;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzwx;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(16, (String)localObject);
        }
        i += 1;
      }
    }
    int i = zzwy;
    if (i != 0) {
      paramZzeyf.writeHeader(17, i);
    }
    boolean bool = zzww;
    if (bool) {
      paramZzeyf.writeHeader(18, bool);
    }
    localObject = zzwj;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = zzwj;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(19, (String)localObject);
        }
        i += 1;
      }
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int i1 = super.updateBookmarks();
    int j = i1;
    Object localObject = zzwk;
    int i2 = 0;
    int i = j;
    int m;
    int n;
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
          localObject = zzwk;
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
    localObject = zzwl;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = zzwl;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = zzeyf.addMenuItem(2, (zzeyn)localObject) + i;
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    localObject = zzwm;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        i = j;
        j = 0;
        for (;;)
        {
          localObject = zzwm;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = zzeyf.addMenuItem(3, (zzeyn)localObject) + i;
          }
          j += 1;
          i = k;
        }
      }
    }
    localObject = zzwn;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = zzwn;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = zzeyf.addMenuItem(4, (zzeyn)localObject) + i;
          }
          j += 1;
          i = k;
        }
        k = i;
      }
    }
    localObject = zzwo;
    j = k;
    if (localObject != null)
    {
      j = k;
      if (localObject.length > 0)
      {
        i = k;
        j = 0;
        for (;;)
        {
          localObject = zzwo;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = zzeyf.addMenuItem(5, (zzeyn)localObject) + i;
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    localObject = zzwp;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = zzwp;
          i = j;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          i = j;
          if (localObject != null) {
            i = j + zzeyf.addMenuItem(6, (zzeyn)localObject);
          }
          k += 1;
          j = i;
        }
      }
    }
    localObject = zzwq;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = zzwq;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + zzeyf.addMenuItem(7, (zzeyn)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    localObject = zzwr;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (!((String)localObject).equals("")) {
        i = j + zzeyf.computeStringSize(9, zzwr);
      }
    }
    localObject = zzws;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((String)localObject).equals("")) {
        j = i + zzeyf.computeStringSize(10, zzws);
      }
    }
    localObject = zzwt;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (!((String)localObject).equals("0")) {
        i = j + zzeyf.computeStringSize(12, zzwt);
      }
    }
    localObject = version;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((String)localObject).equals("")) {
        j = i + zzeyf.computeStringSize(13, version);
      }
    }
    localObject = zzwu;
    k = j;
    if (localObject != null) {
      k = j + zzeyf.addMenuItem(14, (zzeyn)localObject);
    }
    i = k;
    if (Float.floatToIntBits(zzwv) != Float.floatToIntBits(0.0F)) {
      i = k + (zzeyf.zzkb(15) + 4);
    }
    localObject = zzwx;
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
          localObject = zzwx;
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
        j = i + k + n * 2;
      }
    }
    k = zzwy;
    i = j;
    if (k != 0) {
      i = j + zzeyf.zzaa(17, k);
    }
    j = i;
    if (zzww) {
      j = i + (zzeyf.zzkb(18) + 1);
    }
    localObject = zzwj;
    if ((localObject != null) && (localObject.length > 0))
    {
      k = 0;
      n = 0;
      i = i2;
      for (;;)
      {
        localObject = zzwj;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        i1 = n;
        m = k;
        if (localObject != null)
        {
          i1 = n + 1;
          m = zzeyf.zztk((String)localObject) + k;
        }
        i += 1;
        n = i1;
        k = m;
      }
      return j + k + n * 2;
    }
    return j;
  }
}
