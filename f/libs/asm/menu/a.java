package f.libs.asm.menu;

import android.content.Context;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import l.a.a.a.a.b.ClassWriter;

public final class a
{
  public a() {}
  
  public static byte[] a(Context paramContext, String paramString)
    throws IOException
  {
    return new c(paramContext, new ListMenuItemView()).read(paramString);
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 33	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 36	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokestatic 39	f/libs/asm/menu/a:read	(Ljava/io/InputStream;)[B
    //   15: astore_1
    //   16: aload_0
    //   17: invokestatic 45	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;)V
    //   20: aload_1
    //   21: areturn
    //   22: astore_1
    //   23: goto +6 -> 29
    //   26: astore_1
    //   27: aload_2
    //   28: astore_0
    //   29: aload_0
    //   30: invokestatic 45	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;)V
    //   33: aload_1
    //   34: athrow
    //   35: aconst_null
    //   36: astore_0
    //   37: aload_0
    //   38: invokestatic 45	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;)V
    //   41: aconst_null
    //   42: areturn
    //   43: aconst_null
    //   44: astore_0
    //   45: aload_0
    //   46: invokestatic 45	l/a/a/a/a/b/ClassWriter:close	(Ljava/io/Closeable;)V
    //   49: aconst_null
    //   50: areturn
    //   51: astore_0
    //   52: goto -9 -> 43
    //   55: astore_0
    //   56: goto -21 -> 35
    //   59: astore_1
    //   60: goto -15 -> 45
    //   63: astore_1
    //   64: goto -27 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramFile	File
    //   15	6	1	arrayOfByte	byte[]
    //   22	1	1	localThrowable1	Throwable
    //   26	8	1	localThrowable2	Throwable
    //   59	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   63	1	1	localIOException	IOException
    //   1	27	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	16	22	java/lang/Throwable
    //   2	11	26	java/lang/Throwable
    //   2	11	51	java/io/FileNotFoundException
    //   2	11	55	java/io/IOException
    //   11	16	59	java/io/FileNotFoundException
    //   11	16	63	java/io/IOException
  }
  
  public static byte[] a(File paramFile, Context paramContext)
    throws IOException
  {
    File localFile = listFiles(paramFile, ".maps");
    if (localFile != null) {
      return read(localFile, paramContext);
    }
    paramFile = listFiles(paramFile, ".binary_libs");
    if (paramFile != null) {
      return b(paramFile, paramContext);
    }
    return null;
  }
  
  public static byte[] b(File paramFile)
  {
    paramFile = listFiles(paramFile, ".device_info");
    if (paramFile == null) {
      return null;
    }
    return a(paramFile);
  }
  
  public static byte[] b(File paramFile, Context paramContext)
    throws IOException
  {
    paramFile = a(paramFile);
    if ((paramFile != null) && (paramFile.length != 0)) {
      return a(paramContext, new String(paramFile));
    }
    return null;
  }
  
  public static byte[] c(File paramFile)
  {
    return a(paramFile);
  }
  
  public static byte[] d(File paramFile)
  {
    paramFile = listFiles(paramFile, ".dmp");
    if (paramFile == null) {
      return new byte[0];
    }
    return a(paramFile);
  }
  
  public static File listFiles(File paramFile, String paramString)
  {
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramFile[i];
      if (localFile.getName().endsWith(paramString)) {
        return localFile;
      }
      i += 1;
    }
    return null;
  }
  
  public static byte[] read(File paramFile, Context paramContext)
    throws IOException
  {
    if (!paramFile.exists()) {
      return null;
    }
    try
    {
      paramFile = new BufferedReader(new FileReader(paramFile));
      try
      {
        paramContext = new c(paramContext, new ListMenuItemView()).read(paramFile);
        ClassWriter.close(paramFile);
        return paramContext;
      }
      catch (Throwable paramContext) {}
      ClassWriter.close(paramFile);
    }
    catch (Throwable paramContext)
    {
      paramFile = null;
    }
    throw paramContext;
  }
  
  public static byte[] read(InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['?'];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
}
