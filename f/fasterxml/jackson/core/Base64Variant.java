package f.fasterxml.jackson.core;

import java.io.Serializable;
import java.util.Arrays;

public final class Base64Variant
  implements Serializable
{
  public static final int BASE64_VALUE_INVALID = -1;
  public static final int BASE64_VALUE_PADDING = -2;
  public static final char PADDING_CHAR_NONE = '\000';
  public static final long serialVersionUID = 1L;
  public final transient int[] _asciiToBase64 = new int['?'];
  public final transient byte[] _base64ToAsciiB = new byte[64];
  public final transient char[] _base64ToAsciiC = new char[64];
  public final transient int _maxLineLength;
  public final String _name;
  public final transient char _paddingChar;
  public final transient boolean _usesPadding;
  
  public Base64Variant(Base64Variant paramBase64Variant, String paramString, int paramInt)
  {
    this(paramBase64Variant, paramString, _usesPadding, _paddingChar, paramInt);
  }
  
  public Base64Variant(Base64Variant paramBase64Variant, String paramString, boolean paramBoolean, char paramChar, int paramInt)
  {
    _name = paramString;
    paramString = _base64ToAsciiB;
    System.arraycopy(paramString, 0, _base64ToAsciiB, 0, paramString.length);
    paramString = _base64ToAsciiC;
    System.arraycopy(paramString, 0, _base64ToAsciiC, 0, paramString.length);
    paramBase64Variant = _asciiToBase64;
    System.arraycopy(paramBase64Variant, 0, _asciiToBase64, 0, paramBase64Variant.length);
    _usesPadding = paramBoolean;
    _paddingChar = paramChar;
    _maxLineLength = paramInt;
  }
  
  public Base64Variant(String paramString1, String paramString2, boolean paramBoolean, char paramChar, int paramInt)
  {
    _name = paramString1;
    _usesPadding = paramBoolean;
    _paddingChar = paramChar;
    _maxLineLength = paramInt;
    int i = paramString2.length();
    if (i == 64)
    {
      paramString1 = _base64ToAsciiC;
      paramInt = 0;
      paramString2.getChars(0, i, paramString1, 0);
      Arrays.fill(_asciiToBase64, -1);
      while (paramInt < i)
      {
        int j = _base64ToAsciiC[paramInt];
        _base64ToAsciiB[paramInt] = ((byte)j);
        _asciiToBase64[j] = paramInt;
        paramInt += 1;
      }
      if (paramBoolean) {
        _asciiToBase64[paramChar] = -2;
      }
    }
    else
    {
      paramString1 = new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Base64Alphabet length must be exactly 64 (was ", i, ")"));
      throw paramString1;
    }
  }
  
  public int decodeBase64Byte(byte paramByte)
  {
    if (paramByte <= Byte.MAX_VALUE) {
      return _asciiToBase64[paramByte];
    }
    return -1;
  }
  
  public int decodeBase64Char(char paramChar)
  {
    if (paramChar <= '') {
      return _asciiToBase64[paramChar];
    }
    return -1;
  }
  
  public int decodeBase64Char(int paramInt)
  {
    if (paramInt <= 127) {
      return _asciiToBase64[paramInt];
    }
    return -1;
  }
  
  public String encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, false);
  }
  
  public String encode(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int m = paramArrayOfByte.length;
    StringBuilder localStringBuilder = new StringBuilder((m >> 2) + m + (m >> 3));
    if (paramBoolean) {
      localStringBuilder.append('"');
    }
    int j = getMaxLineLength() >> 2;
    int k;
    for (int i = 0; i <= m - 3; i = k)
    {
      int n = i + 1;
      i = paramArrayOfByte[i];
      k = n + 1;
      encodeBase64Chunk(localStringBuilder, (i << 8 | paramArrayOfByte[n] & 0xFF) << 8 | paramArrayOfByte[k] & 0xFF);
      j -= 1;
      i = j;
      if (j <= 0)
      {
        localStringBuilder.append('\\');
        localStringBuilder.append('n');
        i = getMaxLineLength() >> 2;
      }
      k += 1;
      j = i;
    }
    m -= i;
    if (m > 0)
    {
      k = paramArrayOfByte[i] << 16;
      j = k;
      if (m == 2) {
        j = k | (paramArrayOfByte[(i + 1)] & 0xFF) << 8;
      }
      encodeBase64Partial(localStringBuilder, j, m);
    }
    if (paramBoolean) {
      localStringBuilder.append('"');
    }
    return localStringBuilder.toString();
  }
  
  public byte encodeBase64BitsAsByte(int paramInt)
  {
    return _base64ToAsciiB[paramInt];
  }
  
  public char encodeBase64BitsAsChar(int paramInt)
  {
    return _base64ToAsciiC[paramInt];
  }
  
  public int encodeBase64Chunk(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    byte[] arrayOfByte = _base64ToAsciiB;
    paramArrayOfByte[paramInt2] = arrayOfByte[(paramInt1 >> 18 & 0x3F)];
    paramInt2 = i + 1;
    paramArrayOfByte[i] = arrayOfByte[(paramInt1 >> 12 & 0x3F)];
    i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = arrayOfByte[(paramInt1 >> 6 & 0x3F)];
    paramArrayOfByte[i] = arrayOfByte[(paramInt1 & 0x3F)];
    return i + 1;
  }
  
  public int encodeBase64Chunk(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    int i = paramInt2 + 1;
    char[] arrayOfChar = _base64ToAsciiC;
    paramArrayOfChar[paramInt2] = arrayOfChar[(paramInt1 >> 18 & 0x3F)];
    paramInt2 = i + 1;
    paramArrayOfChar[i] = arrayOfChar[(paramInt1 >> 12 & 0x3F)];
    i = paramInt2 + 1;
    paramArrayOfChar[paramInt2] = arrayOfChar[(paramInt1 >> 6 & 0x3F)];
    paramArrayOfChar[i] = arrayOfChar[(paramInt1 & 0x3F)];
    return i + 1;
  }
  
  public void encodeBase64Chunk(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append(_base64ToAsciiC[(paramInt >> 18 & 0x3F)]);
    paramStringBuilder.append(_base64ToAsciiC[(paramInt >> 12 & 0x3F)]);
    paramStringBuilder.append(_base64ToAsciiC[(paramInt >> 6 & 0x3F)]);
    paramStringBuilder.append(_base64ToAsciiC[(paramInt & 0x3F)]);
  }
  
  public int encodeBase64Partial(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    int k = paramInt3 + 1;
    byte[] arrayOfByte = _base64ToAsciiB;
    paramArrayOfByte[paramInt3] = arrayOfByte[(paramInt1 >> 18 & 0x3F)];
    paramInt3 = k + 1;
    paramArrayOfByte[k] = arrayOfByte[(paramInt1 >> 12 & 0x3F)];
    if (_usesPadding)
    {
      int j = (byte)_paddingChar;
      k = paramInt3 + 1;
      int i;
      if (paramInt2 == 2) {
        i = arrayOfByte[(paramInt1 >> 6 & 0x3F)];
      } else {
        i = j;
      }
      paramArrayOfByte[paramInt3] = i;
      paramArrayOfByte[k] = j;
      return k + 1;
    }
    if (paramInt2 == 2)
    {
      paramArrayOfByte[paramInt3] = arrayOfByte[(paramInt1 >> 6 & 0x3F)];
      return paramInt3 + 1;
    }
    return paramInt3;
  }
  
  public int encodeBase64Partial(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    int j = paramInt3 + 1;
    char[] arrayOfChar = _base64ToAsciiC;
    paramArrayOfChar[paramInt3] = arrayOfChar[(paramInt1 >> 18 & 0x3F)];
    paramInt3 = j + 1;
    paramArrayOfChar[j] = arrayOfChar[(paramInt1 >> 12 & 0x3F)];
    if (_usesPadding)
    {
      j = paramInt3 + 1;
      int i;
      if (paramInt2 == 2) {
        i = arrayOfChar[(paramInt1 >> 6 & 0x3F)];
      } else {
        i = _paddingChar;
      }
      paramArrayOfChar[paramInt3] = i;
      paramArrayOfChar[j] = _paddingChar;
      return j + 1;
    }
    if (paramInt2 == 2)
    {
      paramArrayOfChar[paramInt3] = arrayOfChar[(paramInt1 >> 6 & 0x3F)];
      return paramInt3 + 1;
    }
    return paramInt3;
  }
  
  public void encodeBase64Partial(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    paramStringBuilder.append(_base64ToAsciiC[(paramInt1 >> 18 & 0x3F)]);
    paramStringBuilder.append(_base64ToAsciiC[(paramInt1 >> 12 & 0x3F)]);
    if (_usesPadding)
    {
      char c;
      if (paramInt2 == 2) {
        c = _base64ToAsciiC[(paramInt1 >> 6 & 0x3F)];
      } else {
        c = _paddingChar;
      }
      paramStringBuilder.append(c);
      paramStringBuilder.append(_paddingChar);
      return;
    }
    if (paramInt2 == 2) {
      paramStringBuilder.append(_base64ToAsciiC[(paramInt1 >> 6 & 0x3F)]);
    }
  }
  
  public int getMaxLineLength()
  {
    return _maxLineLength;
  }
  
  public String getName()
  {
    return _name;
  }
  
  public byte getPaddingByte()
  {
    return (byte)_paddingChar;
  }
  
  public char getPaddingChar()
  {
    return _paddingChar;
  }
  
  public Object readResolve()
  {
    return Base64Variants.valueOf(_name);
  }
  
  public String toString()
  {
    return _name;
  }
  
  public boolean usesPadding()
  {
    return _usesPadding;
  }
  
  public boolean usesPaddingChar(char paramChar)
  {
    return paramChar == _paddingChar;
  }
  
  public boolean usesPaddingChar(int paramInt)
  {
    return paramInt == _paddingChar;
  }
}
