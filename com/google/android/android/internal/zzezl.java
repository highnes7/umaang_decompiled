package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;
import java.util.Arrays;

public final class zzezl
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzezl>
  implements Cloneable
{
  public String fingerprint = "";
  public int zzajv = 0;
  public boolean zzlyp = false;
  public zzezn zznky;
  public long zzowv = 0L;
  public long zzoww = 0L;
  public long zzowx = 0L;
  public int zzowy = 0;
  public zzezm[] zzowz = zzezm.zzcwu();
  public byte[] zzoxa;
  public zzezj zzoxb;
  public byte[] zzoxc;
  public String zzoxd;
  public String zzoxe;
  public zzezi zzoxf;
  public String zzoxg;
  public long zzoxh;
  public zzezk zzoxi;
  public byte[] zzoxj;
  public String zzoxk;
  public int zzoxl;
  public int[] zzoxm;
  public long zzoxn;
  
  public zzezl()
  {
    byte[] arrayOfByte = zzeyq.zzoue;
    zzoxa = arrayOfByte;
    zzoxb = null;
    zzoxc = arrayOfByte;
    zzoxd = "";
    zzoxe = "";
    zzoxf = null;
    zzoxg = "";
    zzoxh = 180000L;
    zzoxi = null;
    zzoxj = arrayOfByte;
    zzoxk = "";
    zzoxl = 0;
    zzoxm = zzeyq.zzoty;
    zzoxn = 0L;
    zznky = null;
    zzotl = null;
    zzomu = -1;
  }
  
  private final zzezl zzcwt()
  {
    AssertionError localAssertionError;
    try
    {
      Object localObject1 = super.zzcvz();
      localObject1 = (zzezl)localObject1;
      Object localObject2 = zzowz;
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        zzowz = new zzezm[localObject2.length];
        int i = 0;
        for (;;)
        {
          localObject2 = zzowz;
          if (i >= localObject2.length) {
            break;
          }
          if (localObject2[i] != null) {
            zzowz[i] = ((zzezm)localObject2[i].clone());
          }
          i += 1;
        }
      }
      localObject2 = zzoxb;
      if (localObject2 != null) {
        zzoxb = ((zzezj)((zzezj)localObject2).clone());
      }
      localObject2 = zzoxf;
      if (localObject2 != null) {
        zzoxf = ((zzezi)((zzezi)localObject2).clone());
      }
      localObject2 = zzoxi;
      if (localObject2 != null) {
        zzoxi = ((zzezk)((zzezk)localObject2).clone());
      }
      localObject2 = zzoxm;
      if ((localObject2 != null) && (localObject2.length > 0)) {
        zzoxm = ((int[])localObject2.clone());
      }
      localObject2 = zznky;
      if (localObject2 != null)
      {
        zznky = ((zzezn)((zzezn)localObject2).clone());
        return localObject1;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localAssertionError = new AssertionError(localCloneNotSupportedException);
      throw localAssertionError;
    }
    return localAssertionError;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzezl)) {
      return false;
    }
    paramObject = (zzezl)paramObject;
    if (zzowv != zzowv) {
      return false;
    }
    if (zzoww != zzoww) {
      return false;
    }
    if (zzowx != zzowx) {
      return false;
    }
    Object localObject = fingerprint;
    if (localObject == null)
    {
      if (fingerprint != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(fingerprint)) {
      return false;
    }
    if (zzowy != zzowy) {
      return false;
    }
    if (zzajv != zzajv) {
      return false;
    }
    if (zzlyp != zzlyp) {
      return false;
    }
    if (!zzeyl.equals(zzowz, zzowz)) {
      return false;
    }
    if (!Arrays.equals(zzoxa, zzoxa)) {
      return false;
    }
    localObject = zzoxb;
    if (localObject == null)
    {
      if (zzoxb != null) {
        return false;
      }
    }
    else if (!((zzezj)localObject).equals(zzoxb)) {
      return false;
    }
    if (!Arrays.equals(zzoxc, zzoxc)) {
      return false;
    }
    localObject = zzoxd;
    if (localObject == null)
    {
      if (zzoxd != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzoxd)) {
      return false;
    }
    localObject = zzoxe;
    if (localObject == null)
    {
      if (zzoxe != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzoxe)) {
      return false;
    }
    localObject = zzoxf;
    if (localObject == null)
    {
      if (zzoxf != null) {
        return false;
      }
    }
    else if (!((zzezi)localObject).equals(zzoxf)) {
      return false;
    }
    localObject = zzoxg;
    if (localObject == null)
    {
      if (zzoxg != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzoxg)) {
      return false;
    }
    if (zzoxh != zzoxh) {
      return false;
    }
    localObject = zzoxi;
    if (localObject == null)
    {
      if (zzoxi != null) {
        return false;
      }
    }
    else if (!((zzezk)localObject).equals(zzoxi)) {
      return false;
    }
    if (!Arrays.equals(zzoxj, zzoxj)) {
      return false;
    }
    localObject = zzoxk;
    if (localObject == null)
    {
      if (zzoxk != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzoxk)) {
      return false;
    }
    if (zzoxl != zzoxl) {
      return false;
    }
    if (!zzeyl.equals(zzoxm, zzoxm)) {
      return false;
    }
    if (zzoxn != zzoxn) {
      return false;
    }
    localObject = zznky;
    if (localObject == null)
    {
      if (zznky != null) {
        return false;
      }
    }
    else if (!((zzezn)localObject).equals(zznky)) {
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
    int k = StringBuilder.add(com.google.android.gms.internal.zzezl.class, 527, 31);
    long l = zzowv;
    int m = (int)(l ^ l >>> 32);
    l = zzoww;
    int n = (int)(l ^ l >>> 32);
    l = zzowx;
    int i1 = (int)(l ^ l >>> 32);
    Object localObject = fingerprint;
    int i5 = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    int i2 = zzowy;
    int i3 = zzajv;
    int j;
    if (zzlyp) {
      j = 1231;
    } else {
      j = 1237;
    }
    int i6 = StringBuilder.size(zzowz, (((((((k + m) * 31 + n) * 31 + i1) * 31 + i) * 31 + i2) * 31 + i3) * 31 + j) * 31, 31);
    int i7 = Arrays.hashCode(zzoxa);
    localObject = zzoxb;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((zzezj)localObject).hashCode();
    }
    int i8 = Arrays.hashCode(zzoxc);
    localObject = zzoxd;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = zzoxe;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((String)localObject).hashCode();
    }
    localObject = zzoxf;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((zzezi)localObject).hashCode();
    }
    localObject = zzoxg;
    if (localObject == null) {
      n = 0;
    } else {
      n = ((String)localObject).hashCode();
    }
    l = zzoxh;
    int i9 = (int)(l ^ l >>> 32);
    localObject = zzoxi;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((zzezk)localObject).hashCode();
    }
    int i10 = Arrays.hashCode(zzoxj);
    localObject = zzoxk;
    if (localObject == null) {
      i2 = 0;
    } else {
      i2 = ((String)localObject).hashCode();
    }
    int i11 = zzoxl;
    int i12 = zzeyl.hashCode(zzoxm);
    l = zzoxn;
    int i13 = (int)(l ^ l >>> 32);
    localObject = zznky;
    if (localObject == null) {
      i3 = 0;
    } else {
      i3 = ((zzezn)localObject).hashCode();
    }
    localObject = zzotl;
    int i4 = i5;
    if (localObject != null) {
      if (((zzeyj)localObject).isEmpty()) {
        i4 = i5;
      } else {
        i4 = zzotl.hashCode();
      }
    }
    return (((i12 + (((i10 + (((((((i8 + ((i7 + i6) * 31 + i) * 31) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i9) * 31 + i1) * 31) * 31 + i2) * 31 + i11) * 31) * 31 + i13) * 31 + i3) * 31 + i4;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    long l = zzowv;
    if (l != 0L) {
      paramZzeyf.writeHeader(1, l);
    }
    Object localObject = fingerprint;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(2, fingerprint);
    }
    localObject = zzowz;
    int j = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzowz;
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
    if (!Arrays.equals(zzoxa, zzeyq.zzoue)) {
      paramZzeyf.advance(4, zzoxa);
    }
    if (!Arrays.equals(zzoxc, zzeyq.zzoue)) {
      paramZzeyf.advance(6, zzoxc);
    }
    localObject = zzoxf;
    if (localObject != null) {
      paramZzeyf.writeHeader(7, (zzeyn)localObject);
    }
    localObject = zzoxd;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(8, zzoxd);
    }
    localObject = zzoxb;
    if (localObject != null) {
      paramZzeyf.writeHeader(9, (zzeyn)localObject);
    }
    boolean bool = zzlyp;
    if (bool) {
      paramZzeyf.writeHeader(10, bool);
    }
    int i = zzowy;
    if (i != 0) {
      paramZzeyf.writeHeader(11, i);
    }
    i = zzajv;
    if (i != 0) {
      paramZzeyf.writeHeader(12, i);
    }
    localObject = zzoxe;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(13, zzoxe);
    }
    localObject = zzoxg;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(14, zzoxg);
    }
    l = zzoxh;
    if (l != 180000L) {
      paramZzeyf.addMenuItem(15, l);
    }
    localObject = zzoxi;
    if (localObject != null) {
      paramZzeyf.writeHeader(16, (zzeyn)localObject);
    }
    l = zzoww;
    if (l != 0L) {
      paramZzeyf.writeHeader(17, l);
    }
    if (!Arrays.equals(zzoxj, zzeyq.zzoue)) {
      paramZzeyf.advance(18, zzoxj);
    }
    i = zzoxl;
    if (i != 0) {
      paramZzeyf.writeHeader(19, i);
    }
    localObject = zzoxm;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = zzoxm;
        if (i >= localObject.length) {
          break;
        }
        paramZzeyf.writeHeader(20, localObject[i]);
        i += 1;
      }
    }
    l = zzowx;
    if (l != 0L) {
      paramZzeyf.writeHeader(21, l);
    }
    l = zzoxn;
    if (l != 0L) {
      paramZzeyf.writeHeader(22, l);
    }
    localObject = zznky;
    if (localObject != null) {
      paramZzeyf.writeHeader(23, (zzeyn)localObject);
    }
    localObject = zzoxk;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(24, zzoxk);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int i = super.updateBookmarks();
    int j = i;
    long l = zzowv;
    if (l != 0L) {
      j = i + zzeyf.setupButton(1, l);
    }
    Object localObject = fingerprint;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (!((String)localObject).equals("")) {
        i = j + zzeyf.computeStringSize(2, fingerprint);
      }
    }
    localObject = zzowz;
    int m = 0;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = zzowz;
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
    i = j;
    if (!Arrays.equals(zzoxa, zzeyq.zzoue)) {
      i = j + zzeyf.addTo(4, zzoxa);
    }
    j = i;
    if (!Arrays.equals(zzoxc, zzeyq.zzoue)) {
      j = i + zzeyf.addTo(6, zzoxc);
    }
    localObject = zzoxf;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.addMenuItem(7, (zzeyn)localObject);
    }
    localObject = zzoxd;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((String)localObject).equals("")) {
        j = i + zzeyf.computeStringSize(8, zzoxd);
      }
    }
    localObject = zzoxb;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.addMenuItem(9, (zzeyn)localObject);
    }
    j = i;
    if (zzlyp) {
      j = i + (zzeyf.zzkb(10) + 1);
    }
    int k = zzowy;
    i = j;
    if (k != 0) {
      i = j + zzeyf.zzaa(11, k);
    }
    k = zzajv;
    j = i;
    if (k != 0) {
      j = i + zzeyf.zzaa(12, k);
    }
    localObject = zzoxe;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (!((String)localObject).equals("")) {
        i = j + zzeyf.computeStringSize(13, zzoxe);
      }
    }
    localObject = zzoxg;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((String)localObject).equals("")) {
        j = i + zzeyf.computeStringSize(14, zzoxg);
      }
    }
    l = zzoxh;
    i = j;
    if (l != 180000L) {
      i = j + zzeyf.e(15, l);
    }
    localObject = zzoxi;
    j = i;
    if (localObject != null) {
      j = i + zzeyf.addMenuItem(16, (zzeyn)localObject);
    }
    l = zzoww;
    i = j;
    if (l != 0L) {
      i = j + zzeyf.setupButton(17, l);
    }
    j = i;
    if (!Arrays.equals(zzoxj, zzeyq.zzoue)) {
      j = i + zzeyf.addTo(18, zzoxj);
    }
    k = zzoxl;
    i = j;
    if (k != 0) {
      i = j + zzeyf.zzaa(19, k);
    }
    localObject = zzoxm;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        j = m;
        for (;;)
        {
          localObject = zzoxm;
          if (j >= localObject.length) {
            break;
          }
          k += zzeyf.zzkc(localObject[j]);
          j += 1;
        }
        j = i + k + localObject.length * 2;
      }
    }
    l = zzowx;
    i = j;
    if (l != 0L) {
      i = j + zzeyf.setupButton(21, l);
    }
    l = zzoxn;
    j = i;
    if (l != 0L) {
      j = i + zzeyf.setupButton(22, l);
    }
    localObject = zznky;
    i = j;
    if (localObject != null) {
      i = j + zzeyf.addMenuItem(23, (zzeyn)localObject);
    }
    localObject = zzoxk;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((String)localObject).equals("")) {
        j = i + zzeyf.computeStringSize(24, zzoxk);
      }
    }
    return j;
  }
}
