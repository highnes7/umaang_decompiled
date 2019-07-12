package com.google.android.android.internal;

import java.io.IOException;

public final class zzezo
  extends com.google.android.gms.internal.zzeyh<com.google.android.gms.internal.zzezo>
{
  public static volatile zzezo[] zzoxr;
  public String zzoxs = "";
  
  public zzezo()
  {
    zzotl = null;
    zzomu = -1;
  }
  
  public static zzezo[] zzcwx()
  {
    if (zzoxr == null)
    {
      Object localObject = zzeyl.zzott;
      try
      {
        if (zzoxr == null) {
          zzoxr = new zzezo[0];
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zzoxr;
  }
  
  public final void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    String str = zzoxs;
    if ((str != null) && (!str.equals(""))) {
      paramZzeyf.writeHeader(1, zzoxs);
    }
    super.multiply(paramZzeyf);
  }
  
  public final int updateBookmarks()
  {
    int j = super.updateBookmarks();
    String str = zzoxs;
    int i = j;
    if (str != null)
    {
      i = j;
      if (!str.equals("")) {
        i = j + zzeyf.computeStringSize(1, zzoxs);
      }
    }
    return i;
  }
}
