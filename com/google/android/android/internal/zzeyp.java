package com.google.android.android.internal;

import java.util.Arrays;

public final class zzeyp
{
  public final byte[] bytes;
  public final int offset;
  
  public zzeyp(int paramInt, byte[] paramArrayOfByte)
  {
    offset = paramInt;
    bytes = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzeyp)) {
      return false;
    }
    paramObject = (zzeyp)paramObject;
    return (offset == offset) && (Arrays.equals(bytes, bytes));
  }
  
  public final int hashCode()
  {
    int i = offset;
    return Arrays.hashCode(bytes) + (i + 527) * 31;
  }
}
