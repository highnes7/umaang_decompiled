package com.google.android.android.common;

import java.util.Arrays;

public final class ZipOutputStream
  extends Vector2D
{
  public final byte[] zzffp;
  
  public ZipOutputStream(byte[] paramArrayOfByte)
  {
    super(Arrays.copyOfRange(paramArrayOfByte, 0, 25));
    zzffp = paramArrayOfByte;
  }
  
  public final byte[] getBytes()
  {
    return zzffp;
  }
}
