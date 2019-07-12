package com.google.android.android.tagmanager;

import java.util.Arrays;

public final class zzay
{
  public final String zzbff;
  public final byte[] zzjqz;
  
  public zzay(String paramString, byte[] paramArrayOfByte)
  {
    zzbff = paramString;
    zzjqz = paramArrayOfByte;
  }
  
  public final String toString()
  {
    String str = zzbff;
    int i = Arrays.hashCode(zzjqz);
    StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, 54));
    localStringBuilder.append("KeyAndSerialized: key = ");
    localStringBuilder.append(str);
    localStringBuilder.append(" serialized hash = ");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
}
