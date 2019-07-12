package f.g.org.org.codehaus.jackson.objectweb.asm.signature.signature;

import java.math.BigInteger;

public class Base64
  extends BaseNCodec
{
  public static final int BITS_PER_ENCODED_BYTE = 6;
  public static final int BYTES_PER_UNENCODED_BLOCK = 3;
  public static final byte[] CHUNK_SEPARATOR = { 13, 10 };
  public static final byte[] DECODE_TABLE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
  public static final int DONT_GUNZIP = 4;
  public static final int MASK_6BITS = 63;
  public static final byte[] STANDARD_ENCODE_TABLE = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  public static final byte[] URL_SAFE_ENCODE_TABLE = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  public int bitWorkArea;
  public final int decodeSize;
  public final byte[] decodeTable = DECODE_TABLE;
  public final int encodeSize;
  public final byte[] encodeTable;
  public final byte[] lineSeparator;
  
  public Base64()
  {
    this(0);
  }
  
  public Base64(int paramInt)
  {
    this(paramInt, CHUNK_SEPARATOR, false);
  }
  
  public Base64(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, false);
  }
  
  public Base64(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    super(3, 4, paramInt, i);
    if (paramArrayOfByte != null)
    {
      if (!containsAlphabetOrPad(paramArrayOfByte))
      {
        if (paramInt > 0)
        {
          encodeSize = (paramArrayOfByte.length + 4);
          lineSeparator = new byte[paramArrayOfByte.length];
          System.arraycopy(paramArrayOfByte, 0, lineSeparator, 0, paramArrayOfByte.length);
        }
        else
        {
          encodeSize = 4;
          lineSeparator = null;
        }
      }
      else {
        throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append("lineSeparator must not contain base64 characters: [", StringUtils.newStringUtf8(paramArrayOfByte), "]"));
      }
    }
    else
    {
      encodeSize = 4;
      lineSeparator = null;
    }
    decodeSize = (encodeSize - 1);
    if (paramBoolean) {
      paramArrayOfByte = URL_SAFE_ENCODE_TABLE;
    } else {
      paramArrayOfByte = STANDARD_ENCODE_TABLE;
    }
    encodeTable = paramArrayOfByte;
  }
  
  public Base64(boolean paramBoolean)
  {
    this(76, CHUNK_SEPARATOR, paramBoolean);
  }
  
  public static byte[] decodeBase64(String paramString)
  {
    return new Base64(0).decode(paramString);
  }
  
  public static byte[] decodeBase64(byte[] paramArrayOfByte)
  {
    return new Base64(0).decode(paramArrayOfByte);
  }
  
  public static BigInteger decodeInteger(byte[] paramArrayOfByte)
  {
    return new BigInteger(1, decodeBase64(paramArrayOfByte));
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return encodeBase64(paramArrayOfByte, paramBoolean, false);
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    return encodeBase64(paramArrayOfByte, paramBoolean1, paramBoolean2, Integer.MAX_VALUE);
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return paramArrayOfByte;
      }
      Base64 localBase64;
      if (paramBoolean1) {
        localBase64 = new Base64(paramBoolean2);
      } else {
        localBase64 = new Base64(0, CHUNK_SEPARATOR, paramBoolean2);
      }
      long l = localBase64.getEncodedLength(paramArrayOfByte);
      if (l <= paramInt) {
        return localBase64.encode(paramArrayOfByte);
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Input array too big, the output array would be bigger (");
      paramArrayOfByte.append(l);
      paramArrayOfByte.append(") than the specified maximum size of ");
      paramArrayOfByte.append(paramInt);
      throw new IllegalArgumentException(paramArrayOfByte.toString());
    }
    return paramArrayOfByte;
  }
  
  public static byte[] encodeBase64Chunked(byte[] paramArrayOfByte)
  {
    return encodeBase64(paramArrayOfByte, true);
  }
  
  public static String encodeBase64String(byte[] paramArrayOfByte)
  {
    return StringUtils.newStringUtf8(encodeBase64(paramArrayOfByte, false));
  }
  
  public static byte[] encodeBase64URLSafe(byte[] paramArrayOfByte)
  {
    return encodeBase64(paramArrayOfByte, false, true);
  }
  
  public static String encodeBase64URLSafeString(byte[] paramArrayOfByte)
  {
    return StringUtils.newStringUtf8(encodeBase64(paramArrayOfByte, false, true));
  }
  
  public static byte[] encodeBytesToBytes(byte[] paramArrayOfByte)
  {
    return encodeBase64(paramArrayOfByte, false);
  }
  
  public static byte[] encodeInteger(BigInteger paramBigInteger)
  {
    if (paramBigInteger != null) {
      return encodeBase64(toIntegerBytes(paramBigInteger), false);
    }
    throw new NullPointerException("encodeInteger called with null parameter");
  }
  
  public static boolean isArrayByteBase64(byte[] paramArrayOfByte)
  {
    return isBase64(paramArrayOfByte);
  }
  
  public static boolean isBase64(byte paramByte)
  {
    if (paramByte != 61) {
      if (paramByte >= 0)
      {
        byte[] arrayOfByte = DECODE_TABLE;
        if ((paramByte < arrayOfByte.length) && (arrayOfByte[paramByte] != -1)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public static boolean isBase64(String paramString)
  {
    return isBase64(StringUtils.getBytesUtf8(paramString));
  }
  
  public static boolean isBase64(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if ((!isBase64(paramArrayOfByte[i])) && (!BaseNCodec.isWhiteSpace(paramArrayOfByte[i]))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static byte[] toIntegerBytes(BigInteger paramBigInteger)
  {
    int m = paramBigInteger.bitLength() + 7 >> 3 << 3;
    byte[] arrayOfByte = paramBigInteger.toByteArray();
    if ((paramBigInteger.bitLength() % 8 != 0) && (paramBigInteger.bitLength() / 8 + 1 == m / 8)) {
      return arrayOfByte;
    }
    int j = 0;
    int k = arrayOfByte.length;
    int i = k;
    if (paramBigInteger.bitLength() % 8 == 0)
    {
      i = k - 1;
      j = 1;
    }
    k = m / 8;
    paramBigInteger = new byte[k];
    System.arraycopy(arrayOfByte, j, paramBigInteger, k - i, i);
    return paramBigInteger;
  }
  
  public void decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (eof) {
      return;
    }
    if (paramInt2 < 0) {
      eof = true;
    }
    int i = 0;
    while (i < paramInt2)
    {
      ensureBufferSize(decodeSize);
      int j = paramArrayOfByte[paramInt1];
      if (j == 61)
      {
        eof = true;
        break;
      }
      if (j >= 0)
      {
        byte[] arrayOfByte = DECODE_TABLE;
        if (j < arrayOfByte.length)
        {
          j = arrayOfByte[j];
          if (j >= 0)
          {
            modulus = ((modulus + 1) % 4);
            bitWorkArea = ((bitWorkArea << 6) + j);
            if (modulus == 0)
            {
              arrayOfByte = buffer;
              int k = pos;
              pos = (k + 1);
              j = bitWorkArea;
              arrayOfByte[k] = ((byte)(j >> 16 & 0xFF));
              k = pos;
              pos = (k + 1);
              arrayOfByte[k] = ((byte)(j >> 8 & 0xFF));
              k = pos;
              pos = (k + 1);
              arrayOfByte[k] = ((byte)(j & 0xFF));
            }
          }
        }
      }
      i += 1;
      paramInt1 += 1;
    }
    if ((eof) && (modulus != 0))
    {
      ensureBufferSize(decodeSize);
      paramInt1 = modulus;
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return;
        }
        bitWorkArea >>= 2;
        paramArrayOfByte = buffer;
        paramInt2 = pos;
        pos = (paramInt2 + 1);
        paramInt1 = bitWorkArea;
        paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 8 & 0xFF));
        paramInt2 = pos;
        pos = (paramInt2 + 1);
        paramArrayOfByte[paramInt2] = ((byte)(paramInt1 & 0xFF));
        return;
      }
      bitWorkArea >>= 4;
      paramArrayOfByte = buffer;
      paramInt1 = pos;
      pos = (paramInt1 + 1);
      paramArrayOfByte[paramInt1] = ((byte)(bitWorkArea & 0xFF));
    }
  }
  
  public void encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (eof) {
      return;
    }
    byte[] arrayOfByte1;
    int i;
    if (paramInt2 < 0)
    {
      eof = true;
      if ((modulus == 0) && (lineLength == 0)) {
        return;
      }
      ensureBufferSize(encodeSize);
      paramInt1 = pos;
      paramInt2 = modulus;
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2)
        {
          paramArrayOfByte = buffer;
          pos = (paramInt1 + 1);
          arrayOfByte1 = encodeTable;
          paramInt2 = bitWorkArea;
          paramArrayOfByte[paramInt1] = arrayOfByte1[(paramInt2 >> 10 & 0x3F)];
          i = pos;
          pos = (i + 1);
          paramArrayOfByte[i] = arrayOfByte1[(paramInt2 >> 4 & 0x3F)];
          i = pos;
          pos = (i + 1);
          paramArrayOfByte[i] = arrayOfByte1[(paramInt2 << 2 & 0x3F)];
          if (arrayOfByte1 == STANDARD_ENCODE_TABLE)
          {
            paramInt2 = pos;
            pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = 61;
          }
        }
      }
      else
      {
        paramArrayOfByte = buffer;
        pos = (paramInt1 + 1);
        arrayOfByte1 = encodeTable;
        paramInt2 = bitWorkArea;
        paramArrayOfByte[paramInt1] = arrayOfByte1[(paramInt2 >> 2 & 0x3F)];
        i = pos;
        pos = (i + 1);
        paramArrayOfByte[i] = arrayOfByte1[(paramInt2 << 4 & 0x3F)];
        if (arrayOfByte1 == STANDARD_ENCODE_TABLE)
        {
          paramInt2 = pos;
          pos = (paramInt2 + 1);
          paramArrayOfByte[paramInt2] = 61;
          paramInt2 = pos;
          pos = (paramInt2 + 1);
          paramArrayOfByte[paramInt2] = 61;
        }
      }
      paramInt2 = currentLinePos;
      i = pos;
      currentLinePos = (i - paramInt1 + paramInt2);
      if ((lineLength > 0) && (currentLinePos > 0))
      {
        paramArrayOfByte = lineSeparator;
        System.arraycopy(paramArrayOfByte, 0, buffer, i, paramArrayOfByte.length);
        pos += lineSeparator.length;
      }
    }
    else
    {
      i = 0;
      while (i < paramInt2)
      {
        ensureBufferSize(encodeSize);
        modulus = ((modulus + 1) % 3);
        int k = paramArrayOfByte[paramInt1];
        int j = k;
        if (k < 0) {
          j = k + 256;
        }
        bitWorkArea = ((bitWorkArea << 8) + j);
        if (modulus == 0)
        {
          arrayOfByte1 = buffer;
          k = pos;
          pos = (k + 1);
          byte[] arrayOfByte2 = encodeTable;
          j = bitWorkArea;
          arrayOfByte1[k] = arrayOfByte2[(j >> 18 & 0x3F)];
          k = pos;
          pos = (k + 1);
          arrayOfByte1[k] = arrayOfByte2[(j >> 12 & 0x3F)];
          k = pos;
          pos = (k + 1);
          arrayOfByte1[k] = arrayOfByte2[(j >> 6 & 0x3F)];
          k = pos;
          pos = (k + 1);
          arrayOfByte1[k] = arrayOfByte2[(j & 0x3F)];
          currentLinePos += 4;
          j = lineLength;
          if ((j > 0) && (j <= currentLinePos))
          {
            arrayOfByte2 = lineSeparator;
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, pos, arrayOfByte2.length);
            pos += lineSeparator.length;
            currentLinePos = 0;
          }
        }
        i += 1;
        paramInt1 += 1;
      }
    }
  }
  
  public boolean isInAlphabet(byte paramByte)
  {
    if (paramByte >= 0)
    {
      byte[] arrayOfByte = decodeTable;
      if ((paramByte < arrayOfByte.length) && (arrayOfByte[paramByte] != -1)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isUrlSafe()
  {
    return encodeTable == URL_SAFE_ENCODE_TABLE;
  }
}
