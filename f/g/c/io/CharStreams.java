package f.g.c.io;

import f.g.c.a.a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@a
public final class CharStreams
{
  public static final int BUF_SIZE = 2048;
  
  public CharStreams() {}
  
  public static Writer asWriter(Appendable paramAppendable)
  {
    if ((paramAppendable instanceof Writer)) {
      return (Writer)paramAppendable;
    }
    return new AppendableWriter(paramAppendable);
  }
  
  /* Error */
  public static long copy(InputSupplier paramInputSupplier, Object paramObject)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 34 1 0
    //   6: checkcast 36	java/lang/Readable
    //   9: astore 6
    //   11: iconst_1
    //   12: istore_3
    //   13: aload_1
    //   14: invokeinterface 41 1 0
    //   19: checkcast 43	java/lang/Appendable
    //   22: astore_0
    //   23: aload 6
    //   25: aload_0
    //   26: invokestatic 46	f/g/c/io/CharStreams:copy	(Ljava/lang/Readable;Ljava/lang/Appendable;)J
    //   29: lstore 4
    //   31: aload_0
    //   32: checkcast 48	java/io/Closeable
    //   35: iconst_0
    //   36: invokestatic 54	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   39: aload 6
    //   41: checkcast 48	java/io/Closeable
    //   44: iconst_0
    //   45: invokestatic 54	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   48: lload 4
    //   50: lreturn
    //   51: astore_0
    //   52: iconst_1
    //   53: istore_2
    //   54: goto +17 -> 71
    //   57: astore_1
    //   58: aload_0
    //   59: checkcast 48	java/io/Closeable
    //   62: iconst_1
    //   63: invokestatic 54	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   66: aload_1
    //   67: athrow
    //   68: astore_0
    //   69: iconst_0
    //   70: istore_2
    //   71: aload 6
    //   73: checkcast 48	java/io/Closeable
    //   76: astore_1
    //   77: iload_2
    //   78: iconst_2
    //   79: if_icmpge +6 -> 85
    //   82: goto +5 -> 87
    //   85: iconst_0
    //   86: istore_3
    //   87: aload_1
    //   88: iload_3
    //   89: invokestatic 54	f/g/c/io/Closeables:close	(Ljava/io/Closeable;Z)V
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramInputSupplier	InputSupplier
    //   0	94	1	paramObject	Object
    //   53	27	2	i	int
    //   12	77	3	bool	boolean
    //   29	20	4	l	long
    //   9	63	6	localReadable	Readable
    // Exception table:
    //   from	to	target	type
    //   31	39	51	java/lang/Throwable
    //   66	68	51	java/lang/Throwable
    //   23	31	57	java/lang/Throwable
    //   13	23	68	java/lang/Throwable
    //   58	66	68	java/lang/Throwable
  }
  
  public static long copy(InputSupplier paramInputSupplier, Appendable paramAppendable)
    throws IOException
  {
    paramInputSupplier = (Readable)paramInputSupplier.getInput();
    try
    {
      long l = copy(paramInputSupplier, paramAppendable);
      Closeables.close((Closeable)paramInputSupplier, false);
      return l;
    }
    catch (Throwable paramAppendable)
    {
      Closeables.close((Closeable)paramInputSupplier, true);
      throw paramAppendable;
    }
  }
  
  public static long copy(Readable paramReadable, Appendable paramAppendable)
    throws IOException
  {
    CharBuffer localCharBuffer = CharBuffer.allocate(2048);
    long l = 0L;
    while (paramReadable.read(localCharBuffer) != -1)
    {
      localCharBuffer.flip();
      paramAppendable.append(localCharBuffer);
      l += localCharBuffer.remaining();
      localCharBuffer.clear();
    }
    return l;
  }
  
  public static InputSupplier copy(InputSupplier paramInputSupplier, Charset paramCharset)
  {
    if (paramInputSupplier != null)
    {
      if (paramCharset != null) {
        return new CharStreams.2(paramInputSupplier, paramCharset);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static InputSupplier join(Iterable paramIterable)
  {
    return new ByteStreams.4(paramIterable);
  }
  
  public static InputSupplier join(String paramString)
  {
    if (paramString != null) {
      return new Resources.1(paramString);
    }
    throw new NullPointerException();
  }
  
  public static InputSupplier join(InputSupplier... paramVarArgs)
  {
    return new ByteStreams.4(Arrays.asList(paramVarArgs));
  }
  
  public static String readFirstLine(InputSupplier paramInputSupplier)
    throws IOException
  {
    paramInputSupplier = (Readable)paramInputSupplier.getInput();
    try
    {
      String str = new LineReader(paramInputSupplier).readLine();
      Closeables.close((Closeable)paramInputSupplier, false);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Closeables.close((Closeable)paramInputSupplier, true);
      throw localThrowable;
    }
  }
  
  public static java.lang.Object readLines(InputSupplier paramInputSupplier, LineProcessor paramLineProcessor)
    throws IOException
  {
    paramInputSupplier = (Readable)paramInputSupplier.getInput();
    try
    {
      LineReader localLineReader = new LineReader(paramInputSupplier);
      boolean bool;
      do
      {
        String str = localLineReader.readLine();
        if (str == null) {
          break;
        }
        bool = paramLineProcessor.processLine(str);
      } while (bool);
      Closeables.close((Closeable)paramInputSupplier, false);
      return paramLineProcessor.getResult();
    }
    catch (Throwable paramLineProcessor)
    {
      Closeables.close((Closeable)paramInputSupplier, true);
      throw paramLineProcessor;
    }
  }
  
  public static List readLines(InputSupplier paramInputSupplier)
    throws IOException
  {
    paramInputSupplier = (Readable)paramInputSupplier.getInput();
    try
    {
      List localList = readLines(paramInputSupplier);
      Closeables.close((Closeable)paramInputSupplier, false);
      return localList;
    }
    catch (Throwable localThrowable)
    {
      Closeables.close((Closeable)paramInputSupplier, true);
      throw localThrowable;
    }
  }
  
  public static List readLines(Readable paramReadable)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramReadable = new LineReader(paramReadable);
    for (;;)
    {
      String str = paramReadable.readLine();
      if (str == null) {
        break;
      }
      localArrayList.add(str);
    }
    return localArrayList;
  }
  
  public static void skipFully(Reader paramReader, long paramLong)
    throws IOException
  {
    while (paramLong > 0L)
    {
      long l = paramReader.skip(paramLong);
      if (l == 0L)
      {
        if (paramReader.read() != -1) {
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
  
  public static String toString(InputSupplier paramInputSupplier)
    throws IOException
  {
    return toStringBuilder(paramInputSupplier).toString();
  }
  
  public static String toString(Readable paramReadable)
    throws IOException
  {
    return toStringBuilder(paramReadable).toString();
  }
  
  public static StringBuilder toStringBuilder(InputSupplier paramInputSupplier)
    throws IOException
  {
    paramInputSupplier = (Readable)paramInputSupplier.getInput();
    try
    {
      StringBuilder localStringBuilder = toStringBuilder(paramInputSupplier);
      Closeables.close((Closeable)paramInputSupplier, false);
      return localStringBuilder;
    }
    catch (Throwable localThrowable)
    {
      Closeables.close((Closeable)paramInputSupplier, true);
      throw localThrowable;
    }
  }
  
  public static StringBuilder toStringBuilder(Readable paramReadable)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    copy(paramReadable, localStringBuilder);
    return localStringBuilder;
  }
  
  public static Object write(Object paramObject, Charset paramCharset)
  {
    if (paramObject != null)
    {
      if (paramCharset != null) {
        return new ByteVector(paramObject, paramCharset);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static void write(CharSequence paramCharSequence, Object paramObject)
    throws IOException
  {
    if (paramCharSequence != null)
    {
      paramObject = (Appendable)paramObject.write();
      try
      {
        paramObject.append(paramCharSequence);
        Closeables.close((Closeable)paramObject, false);
        return;
      }
      catch (Throwable paramCharSequence)
      {
        Closeables.close((Closeable)paramObject, true);
        throw paramCharSequence;
      }
    }
    throw new NullPointerException();
  }
}
