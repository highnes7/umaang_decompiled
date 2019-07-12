package com.google.android.android.internal;

import java.io.IOException;

public abstract class zzeyn
{
  public volatile int zzomu = -1;
  
  public zzeyn() {}
  
  public static zzeyn decrypt(zzeyn paramZzeyn, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzeym
  {
    try
    {
      paramArrayOfByte = zzeye.getBlob(paramArrayOfByte, 0, paramInt2);
      paramZzeyn.digest(paramArrayOfByte);
      paramArrayOfByte.zzjk(0);
      return paramZzeyn;
    }
    catch (IOException paramZzeyn)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", paramZzeyn);
    }
    catch (zzeym paramZzeyn)
    {
      throw paramZzeyn;
    }
  }
  
  public static final zzeyn sign(zzeyn paramZzeyn, byte[] paramArrayOfByte)
    throws zzeym
  {
    decrypt(paramZzeyn, paramArrayOfByte, 0, paramArrayOfByte.length);
    return paramZzeyn;
  }
  
  public static final byte[] toByteArray(zzeyn paramZzeyn)
  {
    byte[] arrayOfByte = new byte[paramZzeyn.zzhi()];
    int i = arrayOfByte.length;
    try
    {
      zzeyf localZzeyf = zzeyf.toString(arrayOfByte, 0, i);
      paramZzeyn.multiply(localZzeyf);
      localZzeyf.zzctn();
      return arrayOfByte;
    }
    catch (IOException paramZzeyn)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramZzeyn);
    }
  }
  
  public abstract zzeyn digest(zzeye paramZzeye)
    throws IOException;
  
  public void multiply(zzeyf paramZzeyf)
    throws IOException
  {}
  
  public String toString()
  {
    return zzeyo.print(this);
  }
  
  public int updateBookmarks()
  {
    return 0;
  }
  
  public zzeyn zzcwa()
    throws CloneNotSupportedException
  {
    return (zzeyn)super.clone();
  }
  
  public final int zzcwg()
  {
    if (zzomu < 0) {
      zzhi();
    }
    return zzomu;
  }
  
  public final int zzhi()
  {
    int i = updateBookmarks();
    zzomu = i;
    return i;
  }
}
