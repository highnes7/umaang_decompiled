package com.google.android.android.common;

import java.lang.ref.WeakReference;

public abstract class ParseItem
  extends Vector2D
{
  public static final WeakReference<byte[]> zzffr = new WeakReference(null);
  public WeakReference<byte[]> zzffq = zzffr;
  
  public ParseItem(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public final byte[] getBytes()
  {
    try
    {
      byte[] arrayOfByte2 = (byte[])zzffq.get();
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte2 = zzafb();
        arrayOfByte1 = arrayOfByte2;
        zzffq = new WeakReference(arrayOfByte2);
      }
      return arrayOfByte1;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public abstract byte[] zzafb();
}
