package com.google.android.android.internal;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzevu
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static Charset ISO_8859_1;
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  public static ByteBuffer zzope;
  public static zzeut zzopf = zzeut.zzbb(EMPTY_BYTE_ARRAY);
  
  static
  {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] arrayOfByte = new byte[0];
    EMPTY_BYTE_ARRAY = arrayOfByte;
    zzope = ByteBuffer.wrap(arrayOfByte);
  }
  
  public static Object add(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject;
    }
    throw new NullPointerException();
  }
  
  public static Object add(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return paramObject;
    }
    throw new NullPointerException(paramString);
  }
  
  public static int hashCode(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    paramInt1 = paramInt2;
    while (paramInt1 < paramInt2 + paramInt3)
    {
      i = i * 31 + paramArrayOfByte[paramInt1];
      paramInt1 += 1;
    }
    return i;
  }
  
  public static int hashCode(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    i = hashCode(i, paramArrayOfByte, 0, i);
    if (i == 0) {
      return 1;
    }
    return i;
  }
  
  public static boolean writeTag(zzewl paramZzewl)
  {
    return false;
  }
  
  public static int zzda(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  public static int zzdc(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
}
