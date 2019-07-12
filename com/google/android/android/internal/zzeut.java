package com.google.android.android.internal;

import java.io.IOException;
import java.io.InputStream;

public abstract class zzeut
{
  public static volatile boolean zzonh;
  public int zzond;
  public int zzone = 100;
  public int zzonf = Integer.MAX_VALUE;
  public boolean zzong = false;
  
  public zzeut() {}
  
  public static zzeut append(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new zzeuv(paramArrayOfByte, paramInt1, paramInt2, paramBoolean);
    try
    {
      paramArrayOfByte.zzjn(paramInt2);
      return paramArrayOfByte;
    }
    catch (zzevz paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  public static zzeut getName(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return append(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public static zzeut readInputStream(InputStream paramInputStream)
  {
    if (paramInputStream == null)
    {
      paramInputStream = zzevu.EMPTY_BYTE_ARRAY;
      return append(paramInputStream, 0, paramInputStream.length, false);
    }
    return new zzeuw(paramInputStream, 4096);
  }
  
  public static zzeut zzbb(byte[] paramArrayOfByte)
  {
    return append(paramArrayOfByte, 0, paramArrayOfByte.length, false);
  }
  
  public static long zzcq(long paramLong)
  {
    return -(paramLong & 1L) ^ paramLong >>> 1;
  }
  
  public static int zzjq(int paramInt)
  {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  public abstract void blur(zzewm paramZzewm, zzevd paramZzevd)
    throws IOException;
  
  public abstract zzevh items(zzevh paramZzevh, zzevd paramZzevd)
    throws IOException;
  
  public abstract double readDouble()
    throws IOException;
  
  public abstract float readFloat()
    throws IOException;
  
  public abstract String readString()
    throws IOException;
  
  public abstract int zzcsn()
    throws IOException;
  
  public abstract long zzcso()
    throws IOException;
  
  public abstract long zzcsp()
    throws IOException;
  
  public abstract int zzcsq()
    throws IOException;
  
  public abstract long zzcsr()
    throws IOException;
  
  public abstract int zzcss()
    throws IOException;
  
  public abstract boolean zzcst()
    throws IOException;
  
  public abstract String zzcsu()
    throws IOException;
  
  public abstract zzeuk zzcsv()
    throws IOException;
  
  public abstract int zzcsw()
    throws IOException;
  
  public abstract int zzcsx()
    throws IOException;
  
  public abstract int zzcsy()
    throws IOException;
  
  public abstract long zzcsz()
    throws IOException;
  
  public abstract int zzcta()
    throws IOException;
  
  public abstract long zzctb()
    throws IOException;
  
  public abstract int zzctc()
    throws IOException;
  
  public abstract long zzctd()
    throws IOException;
  
  public abstract int zzcte();
  
  public abstract boolean zzctf()
    throws IOException;
  
  public abstract int zzctg();
  
  public abstract void zzjk(int paramInt)
    throws zzevz;
  
  public abstract boolean zzjl(int paramInt)
    throws IOException;
  
  public final int zzjm(int paramInt)
  {
    paramInt = zzonf;
    zzonf = Integer.MAX_VALUE;
    return paramInt;
  }
  
  public abstract int zzjn(int paramInt)
    throws zzevz;
  
  public abstract void zzjo(int paramInt);
  
  public abstract void zzjp(int paramInt)
    throws IOException;
}
