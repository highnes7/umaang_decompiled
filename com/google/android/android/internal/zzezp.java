package com.google.android.android.internal;

import java.io.IOException;

public final class zzezp
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzezp>
{
  public long zzgcc = 0L;
  public String zzoxs = "";
  public String zzoxt = "";
  public long zzoxu = 0L;
  public String zzoxv = "";
  public long zzoxw = 0L;
  public String zzoxx = "";
  public String zzoxy = "";
  public String zzoxz = "";
  public String zzoya = "";
  public String zzoyb = "";
  public int zzoyc = 0;
  public zzezo[] zzoyd = zzezo.zzcwx();
  
  public zzezp()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzezp zzbi(byte[] paramArrayOfByte)
    throws zzeym
  {
    zzezp localZzezp = new zzezp();
    zzeyn.decrypt(localZzezp, paramArrayOfByte, 0, paramArrayOfByte.length);
    return localZzezp;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    Object localObject = zzoxs;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(1, zzoxs);
    }
    localObject = zzoxt;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(2, zzoxt);
    }
    long l = zzoxu;
    if (l != 0L) {
      paramZzeyf.writeHeader(3, l);
    }
    localObject = zzoxv;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(4, zzoxv);
    }
    l = zzoxw;
    if (l != 0L) {
      paramZzeyf.writeHeader(5, l);
    }
    l = zzgcc;
    if (l != 0L) {
      paramZzeyf.writeHeader(6, l);
    }
    localObject = zzoxx;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(7, zzoxx);
    }
    localObject = zzoxy;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(8, zzoxy);
    }
    localObject = zzoxz;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(9, zzoxz);
    }
    localObject = zzoya;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(10, zzoya);
    }
    localObject = zzoyb;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(11, zzoyb);
    }
    int i = zzoyc;
    if (i != 0) {
      paramZzeyf.writeHeader(12, i);
    }
    localObject = zzoyd;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = zzoyd;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.writeHeader(13, (zzeyn)localObject);
        }
        i += 1;
      }
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int k = super.updateBookmarks();
    int j = k;
    Object localObject = zzoxs;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (!((String)localObject).equals("")) {
        i = k + zzeyf.computeStringSize(1, zzoxs);
      }
    }
    localObject = zzoxt;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((String)localObject).equals("")) {
        j = i + zzeyf.computeStringSize(2, zzoxt);
      }
    }
    long l = zzoxu;
    i = j;
    if (l != 0L) {
      i = j + zzeyf.setupButton(3, l);
    }
    localObject = zzoxv;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((String)localObject).equals("")) {
        j = i + zzeyf.computeStringSize(4, zzoxv);
      }
    }
    l = zzoxw;
    i = j;
    if (l != 0L) {
      i = j + zzeyf.setupButton(5, l);
    }
    l = zzgcc;
    j = i;
    if (l != 0L) {
      j = i + zzeyf.setupButton(6, l);
    }
    localObject = zzoxx;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (!((String)localObject).equals("")) {
        i = j + zzeyf.computeStringSize(7, zzoxx);
      }
    }
    localObject = zzoxy;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((String)localObject).equals("")) {
        j = i + zzeyf.computeStringSize(8, zzoxy);
      }
    }
    localObject = zzoxz;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (!((String)localObject).equals("")) {
        i = j + zzeyf.computeStringSize(9, zzoxz);
      }
    }
    localObject = zzoya;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (!((String)localObject).equals("")) {
        k = i + zzeyf.computeStringSize(10, zzoya);
      }
    }
    localObject = zzoyb;
    j = k;
    if (localObject != null)
    {
      j = k;
      if (!((String)localObject).equals("")) {
        j = k + zzeyf.computeStringSize(11, zzoyb);
      }
    }
    k = zzoyc;
    i = j;
    if (k != 0) {
      i = j + zzeyf.zzaa(12, k);
    }
    localObject = zzoyd;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = zzoyd;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + zzeyf.addMenuItem(13, (zzeyn)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
}
