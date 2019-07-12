package f.libs.asm.menu;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class ByteVector
  implements Flushable
{
  public static final int DEFAULT_BLOCK_SIZE = 4096;
  public static final int FORMAT_ISO_8859_7 = 8;
  public static final int size = 4;
  public final int a;
  public final byte[] b;
  public int c;
  public final OutputStream f;
  
  public ByteVector(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    f = paramOutputStream;
    b = paramArrayOfByte;
    c = 0;
    a = paramArrayOfByte.length;
  }
  
  public ByteVector(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    f = null;
    b = paramArrayOfByte;
    c = paramInt1;
    a = (paramInt1 + paramInt2);
  }
  
  public static int a(int paramInt)
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
  
  public static int a(int paramInt, double paramDouble)
  {
    return get(paramInt) + 8;
  }
  
  public static int a(int paramInt, float paramFloat)
  {
    return get(paramInt) + 4;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return get(paramInt1) + b(paramInt2);
  }
  
  public static int a(int paramInt, long paramLong)
  {
    paramInt = get(paramInt);
    return computeSInt64SizeNoTag(paramLong) + paramInt;
  }
  
  public static int a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int i = paramString.length;
      i = a(i);
      return i + paramString.length;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.", paramString);
    }
  }
  
  public static ByteVector a(OutputStream paramOutputStream)
  {
    return b(paramOutputStream, 4096);
  }
  
  public static int add(int paramInt, long paramLong)
  {
    return get(paramInt) + computeRawVarint64Size(paramLong);
  }
  
  public static int add(int paramInt, String paramString)
  {
    paramInt = get(paramInt);
    return a(paramString) + paramInt;
  }
  
  public static int add(int paramInt, boolean paramBoolean)
  {
    return get(paramInt) + 1;
  }
  
  public static int add(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int alloc(int paramInt1, int paramInt2)
  {
    return get(paramInt1) + 4;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt >= 0) {
      return a(paramInt);
    }
    return 10;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return get(paramInt1) + 4;
  }
  
  public static int b(int paramInt, long paramLong)
  {
    return get(paramInt) + 8;
  }
  
  public static int b(int paramInt, Label paramLabel)
  {
    int i = get(1);
    paramInt = write(2, paramInt);
    return write(3, paramLabel) + (paramInt + i * 2);
  }
  
  public static ByteVector b(OutputStream paramOutputStream, int paramInt)
  {
    return new ByteVector(paramOutputStream, new byte[paramInt]);
  }
  
  private void b()
    throws IOException
  {
    OutputStream localOutputStream = f;
    if (localOutputStream != null)
    {
      localOutputStream.write(b, 0, c);
      c = 0;
      return;
    }
    throw new ObjectWritingException();
  }
  
  public static int c(int paramInt)
  {
    return a(paramInt);
  }
  
  public static int computeInt64SizeNoTag(long paramLong)
  {
    return computeRawVarint64Size(paramLong);
  }
  
  public static int computePreferredBufferSize(int paramInt)
  {
    if (paramInt > 4096) {
      return 4096;
    }
    return paramInt;
  }
  
  public static int computeRawVarint64Size(long paramLong)
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
  
  public static int computeSInt64SizeNoTag(long paramLong)
  {
    return computeRawVarint64Size(encodeZigZag64(paramLong));
  }
  
  public static int computeUInt64SizeNoTag(long paramLong)
  {
    return computeRawVarint64Size(paramLong);
  }
  
  public static int d(int paramInt)
  {
    return a(getValue(paramInt));
  }
  
  public static long encodeZigZag64(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  public static int get(int paramInt)
  {
    return a(paramInt << 3 | 0x0);
  }
  
  public static int get(int paramInt, long paramLong)
  {
    return get(paramInt) + computeRawVarint64Size(paramLong);
  }
  
  public static int getItemViewType(int paramInt1, int paramInt2)
  {
    paramInt1 = get(paramInt1);
    return b(paramInt2) + paramInt1;
  }
  
  public static int getPixelValue(int paramInt)
  {
    return b(paramInt);
  }
  
  public static int getSize(long paramLong)
  {
    return 8;
  }
  
  public static int getValue(int paramInt)
  {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  public static int newBpc(int paramInt)
  {
    return 4;
  }
  
  public static ByteVector putByte(byte[] paramArrayOfByte)
  {
    return new ByteVector(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static ByteVector putByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ByteVector(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int read(double paramDouble)
  {
    return 8;
  }
  
  public static int read(int paramInt)
  {
    return 4;
  }
  
  public static int read(int paramInt1, int paramInt2)
  {
    paramInt1 = get(paramInt1);
    return d(paramInt2) + paramInt1;
  }
  
  public static int read(int paramInt, long paramLong)
  {
    return get(paramInt) + 8;
  }
  
  public static int read(long paramLong)
  {
    return 8;
  }
  
  public static int write(float paramFloat)
  {
    return 4;
  }
  
  public static int write(int paramInt1, int paramInt2)
  {
    return get(paramInt1) + a(paramInt2);
  }
  
  public static int write(int paramInt, Label paramLabel)
  {
    paramInt = get(paramInt);
    return write(paramLabel) + paramInt;
  }
  
  public static int write(Label paramLabel)
  {
    int i = a(paramLabel.a());
    return paramLabel.a() + i;
  }
  
  public int a()
  {
    if (f == null) {
      return a - c;
    }
    throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
  }
  
  public void a(byte paramByte)
    throws IOException
  {
    if (c == a) {
      b();
    }
    byte[] arrayOfByte = b;
    int i = c;
    c = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void a(double paramDouble)
    throws IOException
  {
    putLong(Double.doubleToRawLongBits(paramDouble));
  }
  
  public void a(float paramFloat)
    throws IOException
  {
    putInt(Float.floatToRawIntBits(paramFloat));
  }
  
  public void a(int paramInt, Label paramLabel)
    throws IOException
  {
    add(1, 3);
    put(2, paramInt);
    add(3, paramLabel);
    add(1, 4);
  }
  
  public void a(long paramLong)
    throws IOException
  {
    putLong(paramLong);
  }
  
  public void a(Label paramLabel)
    throws IOException
  {
    add(paramLabel.a());
    b(paramLabel);
  }
  
  public void a(Label paramLabel, int paramInt1, int paramInt2)
    throws IOException
  {
    int j = a;
    int i = c;
    if (j - i >= paramInt2)
    {
      paramLabel.a(b, paramInt1, i, paramInt2);
      c += paramInt2;
      return;
    }
    j -= i;
    paramLabel.a(b, paramInt1, i, j);
    i = paramInt1 + j;
    paramInt1 = paramInt2 - j;
    c = a;
    b();
    if (paramInt1 <= a)
    {
      paramLabel.a(b, i, 0, paramInt1);
      c = paramInt1;
      return;
    }
    paramLabel = paramLabel.getInputStream();
    long l = i;
    if (l == paramLabel.skip(l))
    {
      for (;;)
      {
        if (paramInt1 <= 0) {
          return;
        }
        paramInt2 = Math.min(paramInt1, a);
        i = paramLabel.read(b, 0, paramInt2);
        if (i != paramInt2) {
          break;
        }
        f.write(b, 0, i);
        paramInt1 -= i;
      }
      throw new IllegalStateException("Read failed.");
    }
    paramLabel = new IllegalStateException("Skip failed.");
    throw paramLabel;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int j = a;
    int i = c;
    if (j - i >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, b, i, paramInt2);
      c += paramInt2;
      return;
    }
    j -= i;
    System.arraycopy(paramArrayOfByte, paramInt1, b, i, j);
    paramInt1 += j;
    paramInt2 -= j;
    c = a;
    b();
    if (paramInt2 <= a)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, b, 0, paramInt2);
      c = paramInt2;
      return;
    }
    f.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void add()
  {
    if (a() == 0) {
      return;
    }
    throw new IllegalStateException("Did not write as much data as expected.");
  }
  
  public void add(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        put(paramInt);
        return;
      }
      put(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public void add(int paramInt, double paramDouble)
    throws IOException
  {
    add(paramInt, 1);
    a(paramDouble);
  }
  
  public void add(int paramInt, float paramFloat)
    throws IOException
  {
    add(paramInt, 5);
    a(paramFloat);
  }
  
  public void add(int paramInt1, int paramInt2)
    throws IOException
  {
    add(paramInt1 << 3 | paramInt2);
  }
  
  public void add(int paramInt, Label paramLabel)
    throws IOException
  {
    add(paramInt, 2);
    a(paramLabel);
  }
  
  public void add(long paramLong)
    throws IOException
  {
    putLong(paramLong);
  }
  
  public void add(byte[] paramArrayOfByte)
    throws IOException
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void append(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      add(paramInt);
      return;
    }
    encode(paramInt);
  }
  
  public void b(Label paramLabel)
    throws IOException
  {
    a(paramLabel, 0, paramLabel.a());
  }
  
  public void copy(int paramInt1, int paramInt2)
    throws IOException
  {
    add(paramInt1, 5);
    putByte(paramInt2);
  }
  
  public void copy(int paramInt, long paramLong)
    throws IOException
  {
    add(paramInt, 1);
    add(paramLong);
  }
  
  public void encode(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        put((int)paramLong);
        return;
      }
      put((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void flush()
    throws IOException
  {
    if (f != null) {
      b();
    }
  }
  
  public void get(int paramInt1, int paramInt2)
    throws IOException
  {
    add(paramInt1, 0);
    trimToSize(paramInt2);
  }
  
  public void get(long paramLong)
    throws IOException
  {
    encode(encodeZigZag64(paramLong));
  }
  
  public void put(int paramInt)
    throws IOException
  {
    a((byte)paramInt);
  }
  
  public void put(int paramInt1, int paramInt2)
    throws IOException
  {
    add(paramInt1, 0);
    putLong(paramInt2);
  }
  
  public void put(int paramInt, long paramLong)
    throws IOException
  {
    add(paramInt, 0);
    put(paramLong);
  }
  
  public void put(int paramInt, String paramString)
    throws IOException
  {
    add(paramInt, 2);
    write(paramString);
  }
  
  public void put(int paramInt, boolean paramBoolean)
    throws IOException
  {
    add(paramInt, 0);
    put(paramBoolean);
  }
  
  public void put(long paramLong)
    throws IOException
  {
    encode(paramLong);
  }
  
  public void put(boolean paramBoolean)
    throws IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public void putByte(int paramInt)
    throws IOException
  {
    putInt(paramInt);
  }
  
  public void putInt(int paramInt)
    throws IOException
  {
    put(paramInt & 0xFF);
    put(paramInt >> 8 & 0xFF);
    put(paramInt >> 16 & 0xFF);
    put(paramInt >> 24 & 0xFF);
  }
  
  public void putInt(int paramInt1, int paramInt2)
    throws IOException
  {
    add(paramInt1, 0);
    write(paramInt2);
  }
  
  public void putInt(int paramInt, long paramLong)
    throws IOException
  {
    add(paramInt, 1);
    a(paramLong);
  }
  
  public void putLong(int paramInt)
    throws IOException
  {
    add(paramInt);
  }
  
  public void putLong(int paramInt, long paramLong)
    throws IOException
  {
    add(paramInt, 0);
    get(paramLong);
  }
  
  public void putLong(long paramLong)
    throws IOException
  {
    put((int)paramLong & 0xFF);
    put((int)(paramLong >> 8) & 0xFF);
    put((int)(paramLong >> 16) & 0xFF);
    put((int)(paramLong >> 24) & 0xFF);
    put((int)(paramLong >> 32) & 0xFF);
    put((int)(paramLong >> 40) & 0xFF);
    put((int)(paramLong >> 48) & 0xFF);
    put((int)(paramLong >> 56) & 0xFF);
  }
  
  public void putShort(int paramInt)
    throws IOException
  {
    putInt(paramInt);
  }
  
  public void trimToSize(int paramInt)
    throws IOException
  {
    append(paramInt);
  }
  
  public void visit(int paramInt1, int paramInt2)
    throws IOException
  {
    add(paramInt1, 5);
    putShort(paramInt2);
  }
  
  public void visitIntInsn(int paramInt1, int paramInt2)
    throws IOException
  {
    add(paramInt1, 0);
    append(paramInt2);
  }
  
  public void write(int paramInt)
    throws IOException
  {
    add(getValue(paramInt));
  }
  
  public void write(int paramInt, long paramLong)
    throws IOException
  {
    add(paramInt, 0);
    write(paramLong);
  }
  
  public void write(long paramLong)
    throws IOException
  {
    encode(paramLong);
  }
  
  public void write(String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    add(paramString.length);
    add(paramString);
  }
}
