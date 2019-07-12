package com.google.android.android.tagmanager;

public final class Base16
{
  public static String encode(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      if ((k & 0xF0) == 0) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(Integer.toHexString(k & 0xFF));
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase();
  }
  
  public static byte[] zzld(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte;
    if (j % 2 == 0)
    {
      arrayOfByte = new byte[j / 2];
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label106;
        }
        int k = Character.digit(paramString.charAt(i), 16);
        int m = Character.digit(paramString.charAt(i + 1), 16);
        if ((k == -1) || (m == -1)) {
          break;
        }
        arrayOfByte[(i / 2)] = ((byte)((k << 4) + m));
        i += 2;
      }
      throw new IllegalArgumentException("purported base16 string has illegal char");
    }
    paramString = new IllegalArgumentException("purported base16 string has odd number of characters");
    throw paramString;
    label106:
    return arrayOfByte;
  }
}
