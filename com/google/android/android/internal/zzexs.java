package com.google.android.android.internal;

public final class zzexs
  extends zzexp
{
  public zzexs() {}
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          return zzexo.a(paramInt1, zzexm.readByte(paramArrayOfByte, paramLong), zzexm.readByte(paramArrayOfByte, paramLong + 1L));
        }
        throw new AssertionError();
      }
      return zzexo.zzag(paramInt1, zzexm.readByte(paramArrayOfByte, paramLong));
    }
    return zzexo.zzky(paramInt1);
  }
  
  public static int a(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    int i;
    long l1;
    if (paramInt < 16)
    {
      i = 0;
    }
    else
    {
      l1 = paramLong;
      i = 0;
      while (i < paramInt)
      {
        if (zzexm.readByte(paramArrayOfByte, l1) < 0) {
          break label54;
        }
        i += 1;
        l1 += 1L;
      }
      i = paramInt;
    }
    label54:
    paramInt -= i;
    paramLong += i;
    for (;;)
    {
      int j = 0;
      i = paramInt;
      paramInt = j;
      long l2;
      while (i > 0)
      {
        l2 = paramLong + 1L;
        j = zzexm.readByte(paramArrayOfByte, paramLong);
        paramInt = j;
        l1 = l2;
        if (j < 0) {
          break label121;
        }
        i -= 1;
        paramInt = j;
        paramLong = l2;
      }
      l1 = paramLong;
      label121:
      if (i == 0) {
        return 0;
      }
      i -= 1;
      if (paramInt < -32)
      {
        if (i == 0) {
          return paramInt;
        }
        i -= 1;
        if (paramInt < -62) {
          break;
        }
        paramLong = l1 + 1L;
        paramInt = i;
        if (zzexm.readByte(paramArrayOfByte, l1) > -65) {
          return -1;
        }
      }
      else if (paramInt < -16)
      {
        if (i < 2) {
          return a(paramArrayOfByte, paramInt, l1, i);
        }
        i -= 2;
        l2 = l1 + 1L;
        j = zzexm.readByte(paramArrayOfByte, l1);
        if ((j > -65) || ((paramInt == -32) && (j < -96)) || ((paramInt == -19) && (j >= -96))) {
          break;
        }
        paramLong = l2 + 1L;
        paramInt = i;
        if (zzexm.readByte(paramArrayOfByte, l2) > -65) {
          return -1;
        }
      }
      else
      {
        if (i < 3) {
          return a(paramArrayOfByte, paramInt, l1, i);
        }
        i -= 3;
        paramLong = l1 + 1L;
        j = zzexm.readByte(paramArrayOfByte, l1);
        if ((j > -65) || (j + 112 + (paramInt << 28) >> 30 != 0)) {
          break;
        }
        l1 = paramLong + 1L;
        if (zzexm.readByte(paramArrayOfByte, paramLong) > -65) {
          break;
        }
        if (zzexm.readByte(paramArrayOfByte, l1) > -65) {
          return -1;
        }
        paramLong = l1 + 1L;
        paramInt = i;
      }
    }
    return -1;
  }
  
  public final int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt2 | paramInt3 | paramArrayOfByte.length - paramInt3) >= 0)
    {
      long l = paramInt2;
      return a(paramArrayOfByte, l, (int)(paramInt3 - l));
    }
    throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
  }
  
  public final int decode(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = paramInt1;
    long l4 = paramInt2 + l1;
    int j = paramCharSequence.length();
    if ((j <= paramInt2) && (paramArrayOfByte.length - paramInt2 >= paramInt1))
    {
      paramInt2 = 0;
      long l2;
      for (;;)
      {
        l2 = 1L;
        if (paramInt2 >= j) {
          break;
        }
        paramInt1 = paramCharSequence.charAt(paramInt2);
        if (paramInt1 >= 128) {
          break;
        }
        zzexm.setBytes(paramArrayOfByte, l1, (byte)paramInt1);
        paramInt2 += 1;
        l1 = 1L + l1;
      }
      long l3 = l1;
      paramInt1 = paramInt2;
      if (paramInt2 == j) {
        return (int)l1;
      }
      while (paramInt1 < j)
      {
        int i = paramCharSequence.charAt(paramInt1);
        if ((i < 128) && (l3 < l4))
        {
          zzexm.setBytes(paramArrayOfByte, l3, (byte)i);
          l1 = l3 + l2;
        }
        for (;;)
        {
          break;
          if ((i < 2048) && (l3 <= l4 - 2L))
          {
            l1 = l3 + l2;
            zzexm.setBytes(paramArrayOfByte, l3, (byte)(i >>> 6 | 0x3C0));
            zzexm.setBytes(paramArrayOfByte, l1, (byte)(i & 0x3F | 0x80));
            l1 += l2;
          }
          else if (((i < 55296) || (57343 < i)) && (l3 <= l4 - 3L))
          {
            l1 = l3 + l2;
            zzexm.setBytes(paramArrayOfByte, l3, (byte)(i >>> 12 | 0x1E0));
            l2 = l1 + l2;
            zzexm.setBytes(paramArrayOfByte, l1, (byte)(i >>> 6 & 0x3F | 0x80));
            zzexm.setBytes(paramArrayOfByte, l2, (byte)(i & 0x3F | 0x80));
            l1 = l2 + 1L;
            l2 = 1L;
          }
          else
          {
            if (l3 > l4 - 4L) {
              break label503;
            }
            paramInt2 = paramInt1 + 1;
            if (paramInt2 == j) {
              break label490;
            }
            char c2 = paramCharSequence.charAt(paramInt2);
            if (!Character.isSurrogatePair(i, c2)) {
              break label487;
            }
            paramInt1 = Character.toCodePoint(i, c2);
            l1 = l3 + 1L;
            zzexm.setBytes(paramArrayOfByte, l3, (byte)(paramInt1 >>> 18 | 0xF0));
            l2 = l1 + 1L;
            zzexm.setBytes(paramArrayOfByte, l1, (byte)(paramInt1 >>> 12 & 0x3F | 0x80));
            l3 = l2 + 1L;
            zzexm.setBytes(paramArrayOfByte, l2, (byte)(paramInt1 >>> 6 & 0x3F | 0x80));
            l2 = 1L;
            l1 = l3 + 1L;
            zzexm.setBytes(paramArrayOfByte, l3, (byte)(paramInt1 & 0x3F | 0x80));
            paramInt1 = paramInt2;
          }
        }
        paramInt1 += 1;
        l3 = l1;
        continue;
        label487:
        paramInt1 = paramInt2;
        label490:
        throw new zzexr(paramInt1 - 1, j);
        label503:
        if ((55296 <= i) && (i <= 57343))
        {
          paramInt2 = paramInt1 + 1;
          if ((paramInt2 == j) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt2)))) {
            throw new zzexr(paramInt1, j);
          }
        }
        paramCharSequence = new StringBuilder(46);
        paramCharSequence.append("Failed writing ");
        paramCharSequence.append(i);
        paramCharSequence.append(" at index ");
        paramCharSequence.append(l3);
        throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
      }
      return (int)l3;
    }
    char c1 = paramCharSequence.charAt(j - 1);
    paramCharSequence = new StringBuilder(37);
    paramCharSequence.append("Failed writing ");
    paramCharSequence.append(c1);
    paramCharSequence.append(" at index ");
    paramCharSequence.append(paramInt1 + paramInt2);
    paramCharSequence = new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
    throw paramCharSequence;
  }
}
