package com.google.android.android.internal;

public final class zzeun
  extends zzeur
{
  public final int zzona;
  public final int zzonb;
  
  public zzeun(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    zzeuk.add(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    zzona = paramInt1;
    zzonb = paramInt2;
  }
  
  public final void ensureCapacity(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(bytes, zzcsk() + paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public final int size()
  {
    return zzonb;
  }
  
  public final int zzcsk()
  {
    return zzona;
  }
  
  public final byte zzji(int paramInt)
  {
    zzeuk.append(paramInt, size());
    return bytes[(zzona + paramInt)];
  }
}
