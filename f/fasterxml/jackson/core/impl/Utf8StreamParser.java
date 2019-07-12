package f.fasterxml.jackson.core.impl;

import java.util.Arrays;

public final class Utf8StreamParser
{
  public static final int[] ALLOW_SINGLE_QUOTES;
  public static final byte[] HEX_BYTES;
  public static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();
  public static final int[] _inputBuffer;
  public static final int[] _inputPtr;
  public static final int[] _quadBuffer;
  public static final int[] sHexValues;
  public static final int[] sInputCodesLatin1;
  public static final int[] sOutputEscapes128;
  
  static
  {
    int j = HEX_CHARS.length;
    HEX_BYTES = new byte[j];
    int k = 0;
    int i = 0;
    while (i < j)
    {
      HEX_BYTES[i] = ((byte)HEX_CHARS[i]);
      i += 1;
    }
    int[] arrayOfInt1 = new int['?'];
    i = 0;
    while (i < 32)
    {
      arrayOfInt1[i] = -1;
      i += 1;
    }
    arrayOfInt1[34] = 1;
    arrayOfInt1[92] = 1;
    _inputPtr = arrayOfInt1;
    arrayOfInt1 = _inputPtr;
    int[] arrayOfInt2 = new int[arrayOfInt1.length];
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
    j = 128;
    while (j < 256)
    {
      if ((j & 0xE0) == 192) {
        i = 2;
      } else if ((j & 0xF0) == 224) {
        i = 3;
      } else if ((j & 0xF8) == 240) {
        i = 4;
      } else {
        i = -1;
      }
      arrayOfInt2[j] = i;
      j += 1;
    }
    sInputCodesLatin1 = arrayOfInt2;
    arrayOfInt1 = new int['?'];
    Arrays.fill(arrayOfInt1, -1);
    i = 33;
    while (i < 256)
    {
      if (Character.isJavaIdentifierPart((char)i)) {
        arrayOfInt1[i] = 0;
      }
      i += 1;
    }
    arrayOfInt1[64] = 0;
    arrayOfInt1[35] = 0;
    arrayOfInt1[42] = 0;
    arrayOfInt1[45] = 0;
    arrayOfInt1[43] = 0;
    _quadBuffer = arrayOfInt1;
    arrayOfInt1 = new int['?'];
    arrayOfInt2 = _quadBuffer;
    System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, arrayOfInt2.length);
    Arrays.fill(arrayOfInt1, 128, 128, 0);
    ALLOW_SINGLE_QUOTES = arrayOfInt1;
    _inputBuffer = new int['?'];
    System.arraycopy(sInputCodesLatin1, 128, _inputBuffer, 128, 128);
    Arrays.fill(_inputBuffer, 0, 32, -1);
    arrayOfInt1 = _inputBuffer;
    arrayOfInt1[9] = 0;
    arrayOfInt1[10] = 10;
    arrayOfInt1[13] = 13;
    arrayOfInt1[42] = 42;
    arrayOfInt1 = new int['?'];
    i = 0;
    while (i < 32)
    {
      arrayOfInt1[i] = -1;
      i += 1;
    }
    arrayOfInt1[34] = 34;
    arrayOfInt1[92] = 92;
    arrayOfInt1[8] = 98;
    arrayOfInt1[9] = 116;
    arrayOfInt1[12] = 102;
    arrayOfInt1[10] = 110;
    arrayOfInt1[13] = 114;
    sOutputEscapes128 = arrayOfInt1;
    sHexValues = new int['?'];
    Arrays.fill(sHexValues, -1);
    j = 0;
    for (;;)
    {
      i = k;
      if (j >= 10) {
        break;
      }
      sHexValues[(j + 48)] = j;
      j += 1;
    }
    while (i < 6)
    {
      arrayOfInt1 = sHexValues;
      j = i + 10;
      arrayOfInt1[(i + 97)] = j;
      arrayOfInt1[(i + 65)] = j;
      i += 1;
    }
  }
  
  public Utf8StreamParser() {}
  
  public static int[] _handleUnexpectedValue()
  {
    return ALLOW_SINGLE_QUOTES;
  }
  
  public static int[] _skipWSOrEnd()
  {
    return _inputBuffer;
  }
  
  public static void appendQuoted(StringBuilder paramStringBuilder, String paramString)
  {
    int[] arrayOfInt = sOutputEscapes128;
    int k = arrayOfInt.length;
    int m = paramString.length();
    int j = 0;
    while (j < m)
    {
      int i = paramString.charAt(j);
      if ((i < k) && (arrayOfInt[i] != 0))
      {
        paramStringBuilder.append('\\');
        int n = arrayOfInt[i];
        if (n < 0)
        {
          paramStringBuilder.append('u');
          paramStringBuilder.append('0');
          paramStringBuilder.append('0');
          n = -(n + 1);
          paramStringBuilder.append(HEX_CHARS[(n >> 4)]);
          paramStringBuilder.append(HEX_CHARS[(n & 0xF)]);
        }
        else
        {
          paramStringBuilder.append((char)n);
        }
      }
      else
      {
        paramStringBuilder.append(i);
      }
      j += 1;
    }
  }
  
  public static int charToHex(int paramInt)
  {
    if (paramInt > 127) {
      return -1;
    }
    return sHexValues[paramInt];
  }
  
  public static byte[] copyHexBytes()
  {
    return (byte[])HEX_BYTES.clone();
  }
  
  public static char[] copyHexChars()
  {
    return (char[])HEX_CHARS.clone();
  }
  
  public static int[] get7BitOutputEscapes()
  {
    return sOutputEscapes128;
  }
  
  public static int[] parseEscapedFieldName()
  {
    return sInputCodesLatin1;
  }
  
  public static int[] parseLongFieldName()
  {
    return _quadBuffer;
  }
  
  public static int[] parseMediumFieldName()
  {
    return _inputPtr;
  }
}
