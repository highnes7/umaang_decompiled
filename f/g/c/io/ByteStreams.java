package f.g.c.io;

import f.g.c.a.a;
import f.g.c.hash.Funnels.SinkAsStream;
import f.g.c.hash.HashCode;
import f.g.c.hash.HashFunction;
import f.g.c.hash.Hasher;
import f.g.c.package_10.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.zip.Checksum;

@a
public final class ByteStreams
{
  public static final int BUF_SIZE = 4096;
  
  public ByteStreams() {}
  
  /* Error */
  public static long copy(InputSupplier paramInputSupplier, Object paramObject)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 29 1 0
    //   6: checkcast 31	java/io/InputStream
    //   9: astore 6
    //   11: iconst_1
    //   12: istore_3
    //   13: aload_1
    //   14: invokeinterface 36 1 0
    //   19: checkcast 38	java/io/OutputStream
    //   22: astore_0
    //   23: aload 6
    //   25: aload_0
    //   26: invokestatic 41	f/g/c/io/ByteStreams:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   29: lstore 4
    //   31: aload_0
    //   32: iconst_0
    //   33: invokestatic 47	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   36: aload 6
    //   38: iconst_0
    //   39: invokestatic 47	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   42: lload 4
    //   44: lreturn
    //   45: astore_0
    //   46: iconst_1
    //   47: istore_2
    //   48: goto +14 -> 62
    //   51: astore_1
    //   52: aload_0
    //   53: iconst_1
    //   54: invokestatic 47	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   57: aload_1
    //   58: athrow
    //   59: astore_0
    //   60: iconst_0
    //   61: istore_2
    //   62: iload_2
    //   63: iconst_2
    //   64: if_icmpge +6 -> 70
    //   67: goto +5 -> 72
    //   70: iconst_0
    //   71: istore_3
    //   72: aload 6
    //   74: iload_3
    //   75: invokestatic 47	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   78: aload_0
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramInputSupplier	InputSupplier
    //   0	80	1	paramObject	Object
    //   47	18	2	i	int
    //   12	63	3	bool	boolean
    //   29	14	4	l	long
    //   9	64	6	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   31	36	45	java/lang/Throwable
    //   57	59	45	java/lang/Throwable
    //   23	31	51	java/lang/Throwable
    //   13	23	59	java/lang/Throwable
    //   52	57	59	java/lang/Throwable
  }
  
  public static long copy(InputSupplier paramInputSupplier, OutputStream paramOutputStream)
    throws IOException
  {
    paramInputSupplier = (InputStream)paramInputSupplier.getInput();
    try
    {
      long l = copy(paramInputSupplier, paramOutputStream);
      Closeables.close(paramInputSupplier, false);
      return l;
    }
    catch (Throwable paramOutputStream)
    {
      Closeables.close(paramInputSupplier, true);
      throw paramOutputStream;
    }
  }
  
  public static long copy(InputStream paramInputStream, Object paramObject)
    throws IOException
  {
    paramObject = (OutputStream)paramObject.write();
    try
    {
      long l = copy(paramInputStream, paramObject);
      Closeables.close(paramObject, false);
      return l;
    }
    catch (Throwable paramInputStream)
    {
      Closeables.close(paramObject, true);
      throw paramInputStream;
    }
  }
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['?'];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return l;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static long copy(ReadableByteChannel paramReadableByteChannel, WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4096);
    long l = 0L;
    while (paramReadableByteChannel.read(localByteBuffer) != -1)
    {
      localByteBuffer.flip();
      while (localByteBuffer.hasRemaining()) {
        l += paramWritableByteChannel.write(localByteBuffer);
      }
      localByteBuffer.clear();
    }
    return l;
  }
  
  public static void copy(byte[] paramArrayOfByte, Object paramObject)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      paramObject = (OutputStream)paramObject.write();
      try
      {
        paramObject.write(paramArrayOfByte);
        Closeables.close(paramObject, false);
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        Closeables.close(paramObject, true);
        throw paramArrayOfByte;
      }
    }
    throw new NullPointerException();
  }
  
  /* Error */
  public static boolean equal(InputSupplier paramInputSupplier1, InputSupplier paramInputSupplier2)
    throws IOException
  {
    // Byte code:
    //   0: sipush 4096
    //   3: newarray byte
    //   5: astore 7
    //   7: sipush 4096
    //   10: newarray byte
    //   12: astore 8
    //   14: aload_0
    //   15: invokeinterface 29 1 0
    //   20: checkcast 31	java/io/InputStream
    //   23: astore 6
    //   25: iconst_1
    //   26: istore 4
    //   28: aload_1
    //   29: invokeinterface 29 1 0
    //   34: checkcast 31	java/io/InputStream
    //   37: astore_0
    //   38: aload 6
    //   40: aload 7
    //   42: iconst_0
    //   43: sipush 4096
    //   46: invokestatic 96	f/g/c/io/ByteStreams:read	(Ljava/io/InputStream;[BII)I
    //   49: istore_2
    //   50: aload_0
    //   51: aload 8
    //   53: iconst_0
    //   54: sipush 4096
    //   57: invokestatic 96	f/g/c/io/ByteStreams:read	(Ljava/io/InputStream;[BII)I
    //   60: istore_3
    //   61: iload_2
    //   62: iload_3
    //   63: if_icmpne +40 -> 103
    //   66: aload 7
    //   68: aload 8
    //   70: invokestatic 102	java/util/Arrays:equals	([B[B)Z
    //   73: istore 5
    //   75: iload 5
    //   77: ifne +6 -> 83
    //   80: goto +23 -> 103
    //   83: iload_2
    //   84: sipush 4096
    //   87: if_icmpeq -49 -> 38
    //   90: aload_0
    //   91: iconst_0
    //   92: invokestatic 47	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   95: aload 6
    //   97: iconst_0
    //   98: invokestatic 47	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   101: iconst_1
    //   102: ireturn
    //   103: aload_0
    //   104: iconst_0
    //   105: invokestatic 47	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   108: aload 6
    //   110: iconst_0
    //   111: invokestatic 47	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   114: iconst_0
    //   115: ireturn
    //   116: astore_0
    //   117: iconst_0
    //   118: istore 4
    //   120: goto +12 -> 132
    //   123: astore_1
    //   124: aload_0
    //   125: iconst_1
    //   126: invokestatic 47	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   129: aload_1
    //   130: athrow
    //   131: astore_0
    //   132: aload 6
    //   134: iload 4
    //   136: invokestatic 47	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   139: goto +3 -> 142
    //   142: aload_0
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramInputSupplier1	InputSupplier
    //   0	144	1	paramInputSupplier2	InputSupplier
    //   49	39	2	i	int
    //   60	4	3	j	int
    //   26	109	4	bool1	boolean
    //   73	3	5	bool2	boolean
    //   23	110	6	localInputStream	InputStream
    //   5	62	7	arrayOfByte1	byte[]
    //   12	57	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   90	95	116	java/lang/Throwable
    //   103	108	116	java/lang/Throwable
    //   38	61	123	java/lang/Throwable
    //   66	75	123	java/lang/Throwable
    //   28	38	131	java/lang/Throwable
    //   124	131	131	java/lang/Throwable
  }
  
  public static long getChecksum(InputSupplier paramInputSupplier, Checksum paramChecksum)
    throws IOException
  {
    return ((Long)readBytes(paramInputSupplier, new ByteStreams.2(paramChecksum))).longValue();
  }
  
  public static HashCode hash(InputSupplier paramInputSupplier, HashFunction paramHashFunction)
    throws IOException
  {
    paramHashFunction = paramHashFunction.newHasher();
    copy(paramInputSupplier, new Funnels.SinkAsStream(paramHashFunction));
    return paramHashFunction.hash();
  }
  
  public static InputSupplier join(Iterable paramIterable)
  {
    return new CharStreams.1(paramIterable);
  }
  
  public static InputSupplier join(InputSupplier... paramVarArgs)
  {
    return new CharStreams.1(Arrays.asList(paramVarArgs));
  }
  
  /* Error */
  public static long length(InputSupplier paramInputSupplier)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 29 1 0
    //   6: checkcast 31	java/io/InputStream
    //   9: astore_0
    //   10: lconst_0
    //   11: lstore_2
    //   12: aload_0
    //   13: ldc2_w 154
    //   16: invokevirtual 159	java/io/InputStream:skip	(J)J
    //   19: lstore 6
    //   21: lload 6
    //   23: lstore 4
    //   25: lload 6
    //   27: lconst_0
    //   28: lcmp
    //   29: ifne +23 -> 52
    //   32: aload_0
    //   33: invokevirtual 162	java/io/InputStream:read	()I
    //   36: istore_1
    //   37: iload_1
    //   38: iconst_m1
    //   39: if_icmpne +10 -> 49
    //   42: aload_0
    //   43: iconst_0
    //   44: invokestatic 47	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   47: lload_2
    //   48: lreturn
    //   49: lconst_1
    //   50: lstore 4
    //   52: lload_2
    //   53: lload 4
    //   55: ladd
    //   56: lstore_2
    //   57: goto -45 -> 12
    //   60: astore 8
    //   62: aload_0
    //   63: iconst_1
    //   64: invokestatic 47	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   67: goto +3 -> 70
    //   70: aload 8
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramInputSupplier	InputSupplier
    //   36	4	1	i	int
    //   11	46	2	l1	long
    //   23	31	4	l2	long
    //   19	7	6	l3	long
    //   60	11	8	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   12	21	60	java/lang/Throwable
    //   32	37	60	java/lang/Throwable
  }
  
  public static ByteArrayDataInput newDataInput(byte[] paramArrayOfByte)
  {
    return new ByteArrayDataInputStream();
  }
  
  public static ByteArrayDataInput newDataInput(byte[] paramArrayOfByte, int paramInt)
  {
    Preconditions.checkPositionIndex(paramInt, paramArrayOfByte.length, "index");
    return new ByteArrayDataInputStream(paramInt);
  }
  
  public static ByteArrayDataOutput newDataOutput()
  {
    return new ByteArrayDataOutputStream();
  }
  
  public static ByteArrayDataOutput newDataOutput(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Invalid size: %s", new java.lang.Object[] { Integer.valueOf(paramInt) });
    return new ByteArrayDataOutputStream(paramInt);
  }
  
  public static InputSupplier newInputStreamSupplier(byte[] paramArrayOfByte)
  {
    return new ByteStreams.1(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static InputSupplier newInputStreamSupplier(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ByteStreams.1(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int read(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 >= 0)
    {
      int i = 0;
      while (i < paramInt2)
      {
        int j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
        if (j == -1) {
          return i;
        }
        i += j;
      }
      return i;
    }
    paramInputStream = new IndexOutOfBoundsException("len is negative");
    throw paramInputStream;
  }
  
  public static java.lang.Object readBytes(InputSupplier paramInputSupplier, ByteProcessor paramByteProcessor)
    throws IOException
  {
    byte[] arrayOfByte = new byte['?'];
    paramInputSupplier = (InputStream)paramInputSupplier.getInput();
    for (;;)
    {
      boolean bool3 = true;
      boolean bool1 = true;
      boolean bool2 = bool3;
      try
      {
        int i = paramInputSupplier.read(arrayOfByte);
        if (i == -1)
        {
          bool1 = false;
        }
        else
        {
          bool2 = bool3;
          bool3 = paramByteProcessor.processBytes(arrayOfByte, 0, i);
          if (bool3) {
            continue;
          }
        }
        bool2 = bool1;
        paramByteProcessor = paramByteProcessor.getResult();
        Closeables.close(paramInputSupplier, bool1);
        return paramByteProcessor;
      }
      catch (Throwable paramByteProcessor)
      {
        Closeables.close(paramInputSupplier, bool2);
        throw paramByteProcessor;
      }
    }
  }
  
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    readFully(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (read(paramInputStream, paramArrayOfByte, paramInt1, paramInt2) == paramInt2) {
      return;
    }
    throw new EOFException();
  }
  
  public static void skipFully(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    while (paramLong > 0L)
    {
      long l = paramInputStream.skip(paramLong);
      if (l == 0L)
      {
        if (paramInputStream.read() != -1) {
          paramLong -= 1L;
        } else {
          throw new EOFException();
        }
      }
      else {
        paramLong -= l;
      }
    }
  }
  
  public static InputSupplier slice(InputSupplier paramInputSupplier, long paramLong1, long paramLong2)
  {
    if (paramInputSupplier != null)
    {
      boolean bool2 = true;
      boolean bool1;
      if (paramLong1 >= 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "offset is negative");
      if (paramLong2 >= 0L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "length is negative");
      return new ByteStreams.3(paramInputSupplier, paramLong1, paramLong2);
    }
    throw new NullPointerException();
  }
  
  public static byte[] toByteArray(InputSupplier paramInputSupplier)
    throws IOException
  {
    paramInputSupplier = (InputStream)paramInputSupplier.getInput();
    try
    {
      byte[] arrayOfByte = toByteArray(paramInputSupplier);
      Closeables.close(paramInputSupplier, false);
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      Closeables.close(paramInputSupplier, true);
      throw localThrowable;
    }
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public class ByteArrayDataInputStream
    implements ByteArrayDataInput
  {
    public final DataInput input;
    
    public ByteArrayDataInputStream()
    {
      input = new DataInputStream(new ByteArrayInputStream(this$1));
    }
    
    public ByteArrayDataInputStream(int paramInt)
    {
      input = new DataInputStream(new ByteArrayInputStream(this$1, paramInt, this$1.length - paramInt));
    }
    
    public boolean readBoolean()
    {
      DataInput localDataInput = input;
      try
      {
        boolean bool = localDataInput.readBoolean();
        return bool;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public byte readByte()
    {
      DataInput localDataInput = input;
      try
      {
        byte b = localDataInput.readByte();
        return b;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
      catch (EOFException localEOFException)
      {
        throw new IllegalStateException(localEOFException);
      }
    }
    
    public char readChar()
    {
      DataInput localDataInput = input;
      try
      {
        char c = localDataInput.readChar();
        return c;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public double readDouble()
    {
      DataInput localDataInput = input;
      try
      {
        double d = localDataInput.readDouble();
        return d;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public float readFloat()
    {
      DataInput localDataInput = input;
      try
      {
        float f = localDataInput.readFloat();
        return f;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public void readFully(byte[] paramArrayOfByte)
    {
      DataInput localDataInput = input;
      try
      {
        localDataInput.readFully(paramArrayOfByte);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new IllegalStateException(paramArrayOfByte);
      }
    }
    
    public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      DataInput localDataInput = input;
      try
      {
        localDataInput.readFully(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new IllegalStateException(paramArrayOfByte);
      }
    }
    
    public int readInt()
    {
      DataInput localDataInput = input;
      try
      {
        int i = localDataInput.readInt();
        return i;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public String readLine()
    {
      java.lang.Object localObject = input;
      try
      {
        localObject = ((DataInput)localObject).readLine();
        return localObject;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public long readLong()
    {
      DataInput localDataInput = input;
      try
      {
        long l = localDataInput.readLong();
        return l;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public short readShort()
    {
      DataInput localDataInput = input;
      try
      {
        short s = localDataInput.readShort();
        return s;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public String readUTF()
    {
      java.lang.Object localObject = input;
      try
      {
        localObject = ((DataInput)localObject).readUTF();
        return localObject;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public int readUnsignedByte()
    {
      DataInput localDataInput = input;
      try
      {
        int i = localDataInput.readUnsignedByte();
        return i;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public int readUnsignedShort()
    {
      DataInput localDataInput = input;
      try
      {
        int i = localDataInput.readUnsignedShort();
        return i;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
    
    public int skipBytes(int paramInt)
    {
      DataInput localDataInput = input;
      try
      {
        paramInt = localDataInput.skipBytes(paramInt);
        return paramInt;
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException(localIOException);
      }
    }
  }
  
  public class ByteArrayDataOutputStream
    implements ByteArrayDataOutput
  {
    public final DataOutput output;
    
    public ByteArrayDataOutputStream()
    {
      output = new DataOutputStream(ByteStreams.this);
    }
    
    public ByteArrayDataOutputStream()
    {
      output = new DataOutputStream(localByteArrayOutputStream);
    }
    
    public ByteArrayDataOutputStream()
    {
      output = new DataOutputStream(ByteStreams.this);
    }
    
    public byte[] toByteArray()
    {
      return ByteStreams.this.toByteArray();
    }
    
    public void write(int paramInt)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.write(paramInt);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void write(byte[] paramArrayOfByte)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.write(paramArrayOfByte);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new AssertionError(paramArrayOfByte);
      }
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.write(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new AssertionError(paramArrayOfByte);
      }
    }
    
    public void writeBoolean(boolean paramBoolean)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.writeBoolean(paramBoolean);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeByte(int paramInt)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.writeByte(paramInt);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeBytes(String paramString)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.writeBytes(paramString);
        return;
      }
      catch (IOException paramString)
      {
        throw new AssertionError(paramString);
      }
    }
    
    public void writeChar(int paramInt)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.writeChar(paramInt);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeChars(String paramString)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.writeChars(paramString);
        return;
      }
      catch (IOException paramString)
      {
        throw new AssertionError(paramString);
      }
    }
    
    public void writeDouble(double paramDouble)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.writeDouble(paramDouble);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeFloat(float paramFloat)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.writeFloat(paramFloat);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeInt(int paramInt)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.writeInt(paramInt);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeLong(long paramLong)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.writeLong(paramLong);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeShort(int paramInt)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.writeShort(paramInt);
        return;
      }
      catch (IOException localIOException)
      {
        throw new AssertionError(localIOException);
      }
    }
    
    public void writeUTF(String paramString)
    {
      DataOutput localDataOutput = output;
      try
      {
        localDataOutput.writeUTF(paramString);
        return;
      }
      catch (IOException paramString)
      {
        throw new AssertionError(paramString);
      }
    }
  }
}
