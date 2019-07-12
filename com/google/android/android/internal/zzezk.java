package com.google.android.android.internal;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;
import java.util.Arrays;

public final class zzezk
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzezk>
  implements Cloneable
{
  public byte[] zzowr = zzeyq.zzoue;
  public String zzows = "";
  public byte[][] zzowt = zzeyq.zzoud;
  public boolean zzowu = false;
  
  public zzezk()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  private zzezk zzcws()
  {
    try
    {
      Object localObject = super.zzcvz();
      localObject = (zzezk)localObject;
      byte[][] arrayOfByte = zzowt;
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        zzowt = ((byte[][])arrayOfByte.clone());
        return localObject;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    return localCloneNotSupportedException;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzezk)) {
      return false;
    }
    paramObject = (zzezk)paramObject;
    if (!Arrays.equals(zzowr, zzowr)) {
      return false;
    }
    Object localObject = zzows;
    if (localObject == null)
    {
      if (zzows != null) {
        return false;
      }
    }
    else if (!((String)localObject).equals(zzows)) {
      return false;
    }
    if (!zzeyl.equals(zzowt, zzowt)) {
      return false;
    }
    if (zzowu != zzowu) {
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
    int n = StringBuilder.add(com.google.android.gms.internal.zzezk.class, 527, 31);
    int i1 = Arrays.hashCode(zzowr);
    Object localObject = zzows;
    int m = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    int i2 = zzeyl.hashCode(zzowt);
    int j;
    if (zzowu) {
      j = 1231;
    } else {
      j = 1237;
    }
    localObject = zzotl;
    int k = m;
    if (localObject != null) {
      if (((zzeyj)localObject).isEmpty()) {
        k = m;
      } else {
        k = zzotl.hashCode();
      }
    }
    return ((i2 + ((i1 + n) * 31 + i) * 31) * 31 + j) * 31 + k;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    if (!Arrays.equals(zzowr, zzeyq.zzoue)) {
      paramZzeyf.advance(1, zzowr);
    }
    Object localObject = zzowt;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = zzowt;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramZzeyf.advance(2, (byte[])localObject);
        }
        i += 1;
      }
    }
    boolean bool = zzowu;
    if (bool) {
      paramZzeyf.writeHeader(3, bool);
    }
    localObject = zzows;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      paramZzeyf.writeHeader(4, zzows);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    int i = j;
    if (!Arrays.equals(zzowr, zzeyq.zzoue)) {
      i = j + zzeyf.addTo(1, zzowr);
    }
    Object localObject = zzowt;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        int k = 0;
        int n = 0;
        for (;;)
        {
          localObject = zzowt;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          int i1 = n;
          int m = k;
          if (localObject != null)
          {
            i1 = n + 1;
            m = k + (zzeyf.zzld(localObject.length) + localObject.length);
          }
          j += 1;
          n = i1;
          k = m;
        }
        j = i + k + n * 1;
      }
    }
    i = j;
    if (zzowu) {
      i = j + (zzeyf.zzkb(3) + 1);
    }
    localObject = zzows;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((String)localObject).equals("")) {
        j = i + zzeyf.computeStringSize(4, zzows);
      }
    }
    return j;
  }
}
