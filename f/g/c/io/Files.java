package f.g.c.io;

import f.g.c.a.a;
import f.g.c.hash.HashCode;
import f.g.c.hash.HashFunction;
import f.g.c.package_10.Joiner;
import f.g.c.package_10.Preconditions;
import f.g.c.package_10.Splitter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Checksum;

@a
public final class Files
{
  public static final int TEMP_DIR_ATTEMPTS = 10000;
  
  public Files() {}
  
  public static void append(CharSequence paramCharSequence, File paramFile, Charset paramCharset)
    throws IOException
  {
    write(paramCharSequence, paramFile, paramCharset, true);
  }
  
  public static InputSupplier copy(File paramFile)
  {
    if (paramFile != null) {
      return new ByteSource(paramFile);
    }
    throw new NullPointerException();
  }
  
  public static Object copy(File paramFile, Charset paramCharset)
  {
    return get(paramFile, paramCharset, false);
  }
  
  public static Object copy(File paramFile, boolean paramBoolean)
  {
    if (paramFile != null) {
      return new Label(paramFile, paramBoolean);
    }
    throw new NullPointerException();
  }
  
  public static void copy(InputSupplier paramInputSupplier, File paramFile)
    throws IOException
  {
    ByteStreams.copy(paramInputSupplier, get(paramFile));
  }
  
  public static void copy(InputSupplier paramInputSupplier, File paramFile, Charset paramCharset)
    throws IOException
  {
    CharStreams.copy(paramInputSupplier, copy(paramFile, paramCharset));
  }
  
  public static void copy(File paramFile, Object paramObject)
    throws IOException
  {
    if (paramFile != null)
    {
      ByteStreams.copy(new ByteSource(paramFile), paramObject);
      return;
    }
    throw new NullPointerException();
  }
  
  public static void copy(File paramFile1, File paramFile2)
    throws IOException
  {
    Preconditions.checkArgument(paramFile1.equals(paramFile2) ^ true, "Source %s and destination %s must be different", new java.lang.Object[] { paramFile1, paramFile2 });
    copy(new ByteSource(paramFile1), paramFile2);
  }
  
  public static void copy(File paramFile, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramFile != null)
    {
      ByteStreams.copy(new ByteSource(paramFile), paramOutputStream);
      return;
    }
    throw new NullPointerException();
  }
  
  public static void copy(File paramFile, Charset paramCharset, Object paramObject)
    throws IOException
  {
    CharStreams.copy(newReaderSupplier(paramFile, paramCharset), paramObject);
  }
  
  public static void copy(File paramFile, Charset paramCharset, Appendable paramAppendable)
    throws IOException
  {
    CharStreams.copy(newReaderSupplier(paramFile, paramCharset), paramAppendable);
  }
  
  public static void createParentDirs(File paramFile)
    throws IOException
  {
    File localFile = paramFile.getCanonicalFile().getParentFile();
    if (localFile == null) {
      return;
    }
    localFile.mkdirs();
    if (localFile.isDirectory()) {
      return;
    }
    throw new IOException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Unable to create parent directories of ", paramFile));
  }
  
  public static File createTempDir()
  {
    java.lang.Object localObject1 = new File(System.getProperty("java.io.tmpdir"));
    java.lang.Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append("-");
    localObject2 = ((StringBuilder)localObject2).toString();
    int i = 0;
    while (i < 10000)
    {
      File localFile = new File((File)localObject1, f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject2, i));
      if (localFile.mkdir()) {
        return localFile;
      }
      i += 1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Failed to create directory within 10000 attempts (tried ");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("0 to ");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(9999);
    ((StringBuilder)localObject1).append(')');
    localObject1 = new IllegalStateException(((StringBuilder)localObject1).toString());
    throw ((Throwable)localObject1);
  }
  
  public static boolean equal(File paramFile1, File paramFile2)
    throws IOException
  {
    if ((paramFile1 != paramFile2) && (!paramFile1.equals(paramFile2)))
    {
      long l1 = paramFile1.length();
      long l2 = paramFile2.length();
      if ((l1 != 0L) && (l2 != 0L) && (l1 != l2)) {
        return false;
      }
      return ByteStreams.equal(new ByteSource(paramFile1), new ByteSource(paramFile2));
    }
    return true;
  }
  
  public static Object get(File paramFile)
  {
    if (paramFile != null) {
      return new Label(paramFile, false);
    }
    throw new NullPointerException();
  }
  
  public static Object get(File paramFile, Charset paramCharset, boolean paramBoolean)
  {
    if (paramFile != null)
    {
      paramFile = new Label(paramFile, paramBoolean);
      if (paramCharset != null) {
        return new ByteVector(paramFile, paramCharset);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static long getChecksum(File paramFile, Checksum paramChecksum)
    throws IOException
  {
    if (paramFile != null) {
      return ByteStreams.getChecksum(new ByteSource(paramFile), paramChecksum);
    }
    throw new NullPointerException();
  }
  
  public static String getFileExtension(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.lastIndexOf('.');
      if (i == -1) {
        return "";
      }
      return paramString.substring(i + 1);
    }
    throw new NullPointerException();
  }
  
  public static HashCode hash(File paramFile, HashFunction paramHashFunction)
    throws IOException
  {
    if (paramFile != null) {
      return ByteStreams.hash(new ByteSource(paramFile), paramHashFunction);
    }
    throw new NullPointerException();
  }
  
  public static void hash(byte[] paramArrayOfByte, File paramFile)
    throws IOException
  {
    ByteStreams.copy(paramArrayOfByte, get(paramFile));
  }
  
  public static MappedByteBuffer map(File paramFile)
    throws IOException
  {
    return map(paramFile, FileChannel.MapMode.READ_ONLY);
  }
  
  public static MappedByteBuffer map(File paramFile, FileChannel.MapMode paramMapMode)
    throws IOException
  {
    if (paramFile.exists()) {
      return map(paramFile, paramMapMode, paramFile.length());
    }
    throw new FileNotFoundException(paramFile.toString());
  }
  
  public static MappedByteBuffer map(File paramFile, FileChannel.MapMode paramMapMode, long paramLong)
    throws FileNotFoundException, IOException
  {
    String str;
    if (paramMapMode == FileChannel.MapMode.READ_ONLY) {
      str = "r";
    } else {
      str = "rw";
    }
    paramFile = new RandomAccessFile(paramFile, str);
    try
    {
      paramMapMode = map(paramFile, paramMapMode, paramLong);
      Closeables.close(paramFile, false);
      return paramMapMode;
    }
    catch (Throwable paramMapMode)
    {
      Closeables.close(paramFile, true);
      throw paramMapMode;
    }
  }
  
  public static MappedByteBuffer map(RandomAccessFile paramRandomAccessFile, FileChannel.MapMode paramMapMode, long paramLong)
    throws IOException
  {
    paramRandomAccessFile = paramRandomAccessFile.getChannel();
    try
    {
      paramMapMode = paramRandomAccessFile.map(paramMapMode, 0L, paramLong);
      Closeables.close(paramRandomAccessFile, false);
      return paramMapMode;
    }
    catch (Throwable paramMapMode)
    {
      Closeables.close(paramRandomAccessFile, true);
      throw paramMapMode;
    }
  }
  
  public static void move(File paramFile1, File paramFile2)
    throws IOException
  {
    if (paramFile2 != null)
    {
      Preconditions.checkArgument(paramFile1.equals(paramFile2) ^ true, "Source %s and destination %s must be different", new java.lang.Object[] { paramFile1, paramFile2 });
      if (!paramFile1.renameTo(paramFile2))
      {
        copy(paramFile1, paramFile2);
        if (!paramFile1.delete())
        {
          if (!paramFile2.delete()) {
            throw new IOException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Unable to delete ", paramFile2));
          }
          throw new IOException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Unable to delete ", paramFile1));
        }
      }
    }
    else
    {
      throw new NullPointerException();
    }
  }
  
  public static BufferedReader newReader(File paramFile, Charset paramCharset)
    throws FileNotFoundException
  {
    return new BufferedReader(new InputStreamReader(new FileInputStream(paramFile), paramCharset));
  }
  
  public static InputSupplier newReaderSupplier(File paramFile, Charset paramCharset)
  {
    if (paramFile != null)
    {
      paramFile = new ByteSource(paramFile);
      if (paramCharset != null) {
        return new CharStreams.2(paramFile, paramCharset);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static BufferedWriter newWriter(File paramFile, Charset paramCharset)
    throws FileNotFoundException
  {
    return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(paramFile), paramCharset));
  }
  
  public static java.lang.Object read(File paramFile, ByteProcessor paramByteProcessor)
    throws IOException
  {
    if (paramFile != null) {
      return ByteStreams.readBytes(new ByteSource(paramFile), paramByteProcessor);
    }
    throw new NullPointerException();
  }
  
  public static String readFirstLine(File paramFile, Charset paramCharset)
    throws IOException
  {
    return CharStreams.readFirstLine(newReaderSupplier(paramFile, paramCharset));
  }
  
  public static java.lang.Object readLines(File paramFile, Charset paramCharset, LineProcessor paramLineProcessor)
    throws IOException
  {
    return CharStreams.readLines(newReaderSupplier(paramFile, paramCharset), paramLineProcessor);
  }
  
  public static List readLines(File paramFile, Charset paramCharset)
    throws IOException
  {
    return CharStreams.readLines(newReaderSupplier(paramFile, paramCharset));
  }
  
  public static String simplifyPath(String paramString)
  {
    if (paramString.length() == 0) {
      return ".";
    }
    java.lang.Object localObject2 = Splitter.on('/').omitEmptyStrings().split(paramString);
    java.lang.Object localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if (!str.equals(".")) {
        if (str.equals(".."))
        {
          if ((((List)localObject1).size() > 0) && (!((String)f.sufficientlysecure.rootcommands.util.StringBuilder.get((List)localObject1, -1)).equals(".."))) {
            ((List)localObject1).remove(((List)localObject1).size() - 1);
          } else {
            ((List)localObject1).add("..");
          }
        }
        else {
          ((List)localObject1).add(str);
        }
      }
    }
    localObject1 = Joiner.on('/').join((Iterable)localObject1);
    if (paramString.charAt(0) == '/') {
      paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.toString("/", (String)localObject1);
    }
    for (paramString = (String)localObject1; paramString.startsWith("/../"); paramString = paramString.substring(3)) {}
    if (paramString.equals("/..")) {
      return "/";
    }
    if ("".equals(paramString)) {
      return ".";
    }
    return paramString;
  }
  
  public static byte[] toByteArray(File paramFile)
    throws IOException
  {
    boolean bool;
    if (paramFile.length() <= 2147483647L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    if (paramFile.length() == 0L) {
      return ByteStreams.toByteArray(new ByteSource(paramFile));
    }
    byte[] arrayOfByte = new byte[(int)paramFile.length()];
    paramFile = new FileInputStream(paramFile);
    try
    {
      ByteStreams.readFully(paramFile, arrayOfByte, 0, arrayOfByte.length);
      Closeables.close(paramFile, false);
      return arrayOfByte;
    }
    catch (Throwable localThrowable)
    {
      Closeables.close(paramFile, true);
      throw localThrowable;
    }
  }
  
  public static void touch(File paramFile)
    throws IOException
  {
    if (!paramFile.createNewFile())
    {
      if (paramFile.setLastModified(System.currentTimeMillis())) {
        return;
      }
      throw new IOException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Unable to update modification time of ", paramFile));
    }
  }
  
  public static String write(File paramFile, Charset paramCharset)
    throws IOException
  {
    return new String(toByteArray(paramFile), paramCharset.name());
  }
  
  public static void write(CharSequence paramCharSequence, File paramFile, Charset paramCharset)
    throws IOException
  {
    write(paramCharSequence, paramFile, paramCharset, false);
  }
  
  public static void write(CharSequence paramCharSequence, File paramFile, Charset paramCharset, boolean paramBoolean)
    throws IOException
  {
    CharStreams.write(paramCharSequence, get(paramFile, paramCharset, paramBoolean));
  }
}
