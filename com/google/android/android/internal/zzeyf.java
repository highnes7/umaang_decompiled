package com.google.android.android.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzeyf
{
  public final ByteBuffer zzotk;
  
  public zzeyf(ByteBuffer paramByteBuffer)
  {
    zzotk = paramByteBuffer;
    zzotk.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  public zzeyf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static int addMenuItem(int paramInt, zzeyn paramZzeyn)
  {
    paramInt = zzkb(paramInt);
    int i = paramZzeyn.zzhi();
    return zzld(i) + i + paramInt;
  }
  
  public static int addTo(int paramInt, byte[] paramArrayOfByte)
  {
    return zzkb(paramInt) + (zzld(paramArrayOfByte.length) + paramArrayOfByte.length);
  }
  
  public static int computeStringSize(int paramInt, String paramString)
  {
    paramInt = zzkb(paramInt);
    return zztk(paramString) + paramInt;
  }
  
  public static int decode(CharSequence paramCharSequence)
  {
    int n = paramCharSequence.length();
    int m = 0;
    int j = 0;
    while ((j < n) && (paramCharSequence.charAt(j) < '?')) {
      j += 1;
    }
    int i = n;
    for (;;)
    {
      k = i;
      if (j >= n) {
        break label213;
      }
      k = paramCharSequence.charAt(j);
      if (k >= 2048) {
        break;
      }
      i += (127 - k >>> 31);
      j += 1;
    }
    int i2 = paramCharSequence.length();
    int k = m;
    while (j < i2)
    {
      int i3 = paramCharSequence.charAt(j);
      if (i3 < 2048)
      {
        k += (127 - i3 >>> 31);
        m = j;
      }
      else
      {
        int i1 = k + 2;
        k = i1;
        m = j;
        if (55296 <= i3)
        {
          k = i1;
          m = j;
          if (i3 <= 57343) {
            if (Character.codePointAt(paramCharSequence, j) >= 65536)
            {
              m = j + 1;
              k = i1;
            }
            else
            {
              throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(39, "Unpaired surrogate at index ", j));
            }
          }
        }
      }
      j = m + 1;
    }
    k = i + k;
    label213:
    if (k >= n) {
      return k;
    }
    long l = k;
    paramCharSequence = new StringBuilder(54);
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(l + 4294967296L);
    paramCharSequence = new IllegalArgumentException(paramCharSequence.toString());
    throw paramCharSequence;
  }
  
  public static int decode(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramCharSequence.length();
    int m = paramInt2 + paramInt1;
    paramInt2 = 0;
    int n;
    while (paramInt2 < k)
    {
      j = paramInt2 + paramInt1;
      if (j >= m) {
        break;
      }
      n = paramCharSequence.charAt(paramInt2);
      if (n >= 128) {
        break;
      }
      paramArrayOfByte[j] = ((byte)n);
      paramInt2 += 1;
    }
    if (paramInt2 == k) {
      return paramInt1 + k;
    }
    int j = paramInt1 + paramInt2;
    paramInt1 = paramInt2;
    while (paramInt1 < k)
    {
      int i = paramCharSequence.charAt(paramInt1);
      if ((i < 128) && (j < m))
      {
        paramInt2 = j + 1;
        paramArrayOfByte[j] = ((byte)i);
      }
      else if ((i < 2048) && (j <= m - 2))
      {
        n = j + 1;
        paramArrayOfByte[j] = ((byte)(i >>> 6 | 0x3C0));
        paramInt2 = n + 1;
        paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
      }
      else if (((i < 55296) || (57343 < i)) && (j <= m - 3))
      {
        paramInt2 = j + 1;
        paramArrayOfByte[j] = ((byte)(i >>> 12 | 0x1E0));
        j = paramInt2 + 1;
        paramArrayOfByte[paramInt2] = ((byte)(i >>> 6 & 0x3F | 0x80));
        paramInt2 = j + 1;
        paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
      }
      if (j <= m - 4)
      {
        paramInt2 = paramInt1 + 1;
        if (paramInt2 != paramCharSequence.length())
        {
          char c = paramCharSequence.charAt(paramInt2);
          if (Character.isSurrogatePair(i, c))
          {
            paramInt1 = Character.toCodePoint(i, c);
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(paramInt1 >>> 18 | 0xF0));
            j = n + 1;
            paramArrayOfByte[n] = ((byte)(paramInt1 >>> 12 & 0x3F | 0x80));
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(paramInt1 >>> 6 & 0x3F | 0x80));
            j = n + 1;
            paramArrayOfByte[n] = ((byte)(paramInt1 & 0x3F | 0x80));
            paramInt1 = paramInt2;
            paramInt2 = j;
            paramInt1 += 1;
            j = paramInt2;
          }
          else
          {
            paramInt1 = paramInt2;
          }
        }
        else
        {
          throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(39, "Unpaired surrogate at index ", paramInt1 - 1));
        }
      }
      else
      {
        paramCharSequence = new StringBuilder(37);
        paramCharSequence.append("Failed writing ");
        paramCharSequence.append(i);
        paramCharSequence.append(" at index ");
        paramCharSequence.append(j);
        throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString());
      }
    }
    return j;
  }
  
  public static int e(int paramInt, long paramLong)
  {
    paramInt = zzkb(paramInt);
    return zzdg(zzcz(paramLong)) + paramInt;
  }
  
  public static void encode(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int n = paramCharSequence.length();
    int j = 0;
    while (j < n)
    {
      int i = paramCharSequence.charAt(j);
      int k = i;
      int m;
      if (i >= 128)
      {
        if (i < 2048)
        {
          m = i >>> 6 | 0x3C0;
        }
        else
        {
          if ((i >= 55296) && (57343 >= i))
          {
            m = j + 1;
            if (m != paramCharSequence.length())
            {
              char c = paramCharSequence.charAt(m);
              if (Character.isSurrogatePair(i, c))
              {
                j = Character.toCodePoint(i, c);
                paramByteBuffer.put((byte)(j >>> 18 | 0xF0));
                paramByteBuffer.put((byte)(j >>> 12 & 0x3F | 0x80));
                paramByteBuffer.put((byte)(j >>> 6 & 0x3F | 0x80));
                paramByteBuffer.put((byte)(j & 0x3F | 0x80));
                j = m;
                break label265;
              }
              j = m;
            }
            throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(39, "Unpaired surrogate at index ", j - 1));
          }
          paramByteBuffer.put((byte)(i >>> 12 | 0x1E0));
          m = i >>> 6 & 0x3F | 0x80;
        }
        paramByteBuffer.put((byte)m);
        m = i & 0x3F | 0x80;
      }
      else
      {
        paramByteBuffer.put((byte)m);
      }
      label265:
      j += 1;
    }
  }
  
  public static void put(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (!paramByteBuffer.isReadOnly())
    {
      if (paramByteBuffer.hasArray()) {
        try
        {
          byte[] arrayOfByte = paramByteBuffer.array();
          int i = paramByteBuffer.arrayOffset();
          int j = paramByteBuffer.position();
          i = decode(paramCharSequence, arrayOfByte, i + j, paramByteBuffer.remaining());
          j = paramByteBuffer.arrayOffset();
          paramByteBuffer.position(i - j);
          return;
        }
        catch (ArrayIndexOutOfBoundsException paramCharSequence)
        {
          paramByteBuffer = new BufferOverflowException();
          paramByteBuffer.initCause(paramCharSequence);
          throw paramByteBuffer;
        }
      }
      encode(paramCharSequence, paramByteBuffer);
      return;
    }
    throw new ReadOnlyBufferException();
  }
  
  public static int setupButton(int paramInt, long paramLong)
  {
    paramInt = zzkb(paramInt);
    return zzdg(paramLong) + paramInt;
  }
  
  public static zzeyf toString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzeyf(paramArrayOfByte, 0, paramInt2);
  }
  
  public static int zzaa(int paramInt1, int paramInt2)
  {
    paramInt1 = zzkb(paramInt1);
    return zzkc(paramInt2) + paramInt1;
  }
  
  public static zzeyf zzbf(byte[] paramArrayOfByte)
  {
    return toString(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int zzbg(byte[] paramArrayOfByte)
  {
    return zzld(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  public static long zzcz(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  private final void zzdf(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        zzlb((int)paramLong);
        return;
      }
      zzlb((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public static int zzdg(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0xFFFFFFF800000000 & paramLong) == 0L) {
      return 5;
    }
    if ((0xFFFFFC0000000000 & paramLong) == 0L) {
      return 6;
    }
    if ((0xFFFE000000000000 & paramLong) == 0L) {
      return 7;
    }
    if ((0xFF00000000000000 & paramLong) == 0L) {
      return 8;
    }
    if ((paramLong & 0x8000000000000000) == 0L) {
      return 9;
    }
    return 10;
  }
  
  private final void zzdh(long paramLong)
    throws IOException
  {
    if (zzotk.remaining() >= 8)
    {
      zzotk.putLong(paramLong);
      return;
    }
    throw new zzeyg(zzotk.position(), zzotk.limit());
  }
  
  public static int zzkb(int paramInt)
  {
    return zzld(paramInt << 3);
  }
  
  public static int zzkc(int paramInt)
  {
    if (paramInt >= 0) {
      return zzld(paramInt);
    }
    return 10;
  }
  
  public static int zzkj(int paramInt)
  {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  private final void zzlb(int paramInt)
    throws IOException
  {
    byte b = (byte)paramInt;
    if (zzotk.hasRemaining())
    {
      zzotk.put(b);
      return;
    }
    throw new zzeyg(zzotk.position(), zzotk.limit());
  }
  
  public static int zzld(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((paramInt & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int zztk(String paramString)
  {
    int i = decode(paramString);
    return zzld(i) + i;
  }
  
  public final void add(int paramInt, double paramDouble)
    throws IOException
  {
    next(paramInt, 1);
    zzdh(Double.doubleToLongBits(paramDouble));
  }
  
  public final void addMenuItem(int paramInt, long paramLong)
    throws IOException
  {
    next(paramInt, 0);
    zzdf(zzcz(paramLong));
  }
  
  public final void advance(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    next(paramInt, 2);
    zzlc(paramArrayOfByte.length);
    zzbh(paramArrayOfByte);
  }
  
  public final void insertProperties(int paramInt, long paramLong)
    throws IOException
  {
    next(paramInt, 1);
    zzdh(paramLong);
  }
  
  public final void multiply(int paramInt, long paramLong)
    throws IOException
  {
    next(paramInt, 0);
    zzdf(paramLong);
  }
  
  public final void next(int paramInt1, int paramInt2)
    throws IOException
  {
    zzlc(paramInt1 << 3 | paramInt2);
  }
  
  public final void operate(zzeyn paramZzeyn)
    throws IOException
  {
    zzlc(paramZzeyn.zzcwg());
    paramZzeyn.multiply(this);
  }
  
  public final void put(int paramInt, float paramFloat)
    throws IOException
  {
    next(paramInt, 5);
    paramInt = Float.floatToIntBits(paramFloat);
    if (zzotk.remaining() >= 4)
    {
      zzotk.putInt(paramInt);
      return;
    }
    throw new zzeyg(zzotk.position(), zzotk.limit());
  }
  
  public final void writeHeader(int paramInt1, int paramInt2)
    throws IOException
  {
    next(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      zzlc(paramInt2);
      return;
    }
    zzdf(paramInt2);
  }
  
  public final void writeHeader(int paramInt, long paramLong)
    throws IOException
  {
    next(paramInt, 0);
    zzdf(paramLong);
  }
  
  public final void writeHeader(int paramInt, zzeyn paramZzeyn)
    throws IOException
  {
    next(paramInt, 2);
    operate(paramZzeyn);
  }
  
  public final void writeHeader(int paramInt, String paramString)
    throws IOException
  {
    next(paramInt, 2);
    try
    {
      paramInt = zzld(paramString.length());
      int i = paramString.length();
      i = zzld(i * 3);
      if (paramInt == i)
      {
        localObject = zzotk;
        i = ((ByteBuffer)localObject).position();
        localObject = zzotk;
        int j = ((ByteBuffer)localObject).remaining();
        if (j >= paramInt)
        {
          localObject = zzotk;
          ((ByteBuffer)localObject).position(i + paramInt);
          localObject = zzotk;
          put(paramString, (ByteBuffer)localObject);
          paramString = zzotk;
          j = paramString.position();
          paramString = zzotk;
          paramString.position(i);
          zzlc(j - i - paramInt);
          paramString = zzotk;
          paramString.position(j);
          return;
        }
        paramString = zzotk;
        paramString = new zzeyg(i + paramInt, paramString.limit());
        throw paramString;
      }
      zzlc(decode(paramString));
      localObject = zzotk;
      put(paramString, (ByteBuffer)localObject);
      return;
    }
    catch (BufferOverflowException paramString)
    {
      Object localObject = new zzeyg(zzotk.position(), zzotk.limit());
      ((IOException)localObject).initCause(paramString);
      throw ((Throwable)localObject);
    }
  }
  
  public final void writeHeader(int paramInt, boolean paramBoolean)
    throws IOException
  {
    next(paramInt, 0);
    byte b = (byte)paramBoolean;
    if (zzotk.hasRemaining())
    {
      zzotk.put(b);
      return;
    }
    throw new zzeyg(zzotk.position(), zzotk.limit());
  }
  
  public final void zzbh(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = paramArrayOfByte.length;
    if (zzotk.remaining() >= i)
    {
      zzotk.put(paramArrayOfByte, 0, i);
      return;
    }
    throw new zzeyg(zzotk.position(), zzotk.limit());
  }
  
  public final void zzctn()
  {
    if (zzotk.remaining() == 0) {
      return;
    }
    throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[] { Integer.valueOf(zzotk.remaining()) }));
  }
  
  public final void zzlc(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        zzlb(paramInt);
        return;
      }
      zzlb(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
}
