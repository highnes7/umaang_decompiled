package com.google.android.android.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class zzae
{
  public static Comparator<byte[]> zzbu = new zzaf();
  public List<byte[]> zzbq = new LinkedList();
  public List<byte[]> zzbr = new ArrayList(64);
  public int zzbs = 0;
  public final int zzbt;
  
  public zzae(int paramInt)
  {
    zzbt = paramInt;
  }
  
  private final void trim()
  {
    try
    {
      while (zzbs > zzbt)
      {
        byte[] arrayOfByte = (byte[])zzbq.remove(0);
        zzbr.remove(arrayOfByte);
        zzbs -= arrayOfByte.length;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final byte[] getBuf(int paramInt)
  {
    int i = 0;
    try
    {
      while (i < zzbr.size())
      {
        arrayOfByte = (byte[])zzbr.get(i);
        if (arrayOfByte.length >= paramInt)
        {
          zzbs -= arrayOfByte.length;
          zzbr.remove(i);
          zzbq.remove(arrayOfByte);
          return arrayOfByte;
        }
        i += 1;
      }
      byte[] arrayOfByte = new byte[paramInt];
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void returnBuf(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        if (paramArrayOfByte.length <= zzbt)
        {
          zzbq.add(paramArrayOfByte);
          int j = Collections.binarySearch(zzbr, paramArrayOfByte, zzbu);
          int i = j;
          if (j < 0) {
            i = -j - 1;
          }
          zzbr.add(i, paramArrayOfByte);
          zzbs += paramArrayOfByte.length;
          trim();
          return;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
  }
}
