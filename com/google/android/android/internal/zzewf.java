package com.google.android.android.internal;

public class zzewf
{
  public static final zzevd zzomv = ;
  public zzeuk zzopi;
  public volatile zzewl zzopj;
  public volatile zzeuk zzopk;
  
  public zzewf() {}
  
  private zzeuk toByteString()
  {
    if (zzopk != null) {
      return zzopk;
    }
    try
    {
      if (zzopk != null)
      {
        localZzeuk = zzopk;
        return localZzeuk;
      }
      if (zzopj == null) {}
      for (zzeuk localZzeuk = zzeuk.zzomx;; localZzeuk = zzopj.toByteString())
      {
        zzopk = localZzeuk;
        break;
      }
      localZzeuk = zzopk;
      return localZzeuk;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private zzewl xor(zzewl paramZzewl)
  {
    if (zzopj == null) {
      try
      {
        if (zzopj != null) {}
        for (;;)
        {
          break;
          zzopj = paramZzewl;
          zzopk = zzeuk.zzomx;
        }
        return zzopj;
      }
      catch (Throwable paramZzewl)
      {
        throw paramZzewl;
      }
    }
  }
  
  public final zzewl addValue(zzewl paramZzewl)
  {
    zzewl localZzewl = zzopj;
    zzopi = null;
    zzopk = null;
    zzopj = paramZzewl;
    return localZzewl;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzewf)) {
      return false;
    }
    paramObject = (zzewf)paramObject;
    zzewl localZzewl1 = zzopj;
    zzewl localZzewl2 = zzopj;
    if ((localZzewl1 == null) && (localZzewl2 == null)) {
      return toByteString().equals(paramObject.toByteString());
    }
    if ((localZzewl1 != null) && (localZzewl2 != null)) {
      return localZzewl1.equals(localZzewl2);
    }
    if (localZzewl1 != null) {
      return localZzewl1.equals(paramObject.xor(localZzewl1.zzcuc()));
    }
    return xor(localZzewl2.zzcuc()).equals(localZzewl2);
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final int zzhi()
  {
    if (zzopk != null) {
      return zzopk.size();
    }
    if (zzopj != null) {
      return zzopj.zzhi();
    }
    return 0;
  }
}
