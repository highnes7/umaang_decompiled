package support.android.v4.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import b.b.a.N;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

@N({b.b.a.N.a.b})
public class a
{
  public static final String e = ".font";
  public static final String t = "TypefaceCompatUtil";
  
  public a() {}
  
  public static File a(Context paramContext)
  {
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append(".font");
    ((StringBuilder)localObject).append(Process.myPid());
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(Process.myTid());
    ((StringBuilder)localObject).append("-");
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    while (i < 100)
    {
      File localFile = new File(paramContext.getCacheDir(), f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject, i));
      try
      {
        boolean bool = localFile.createNewFile();
        if (bool) {
          return localFile;
        }
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return null;
  }
  
  public static ByteBuffer a(Context paramContext, Resources paramResources, int paramInt)
  {
    paramContext = a(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      boolean bool = b(paramContext, paramResources, paramInt);
      if (!bool)
      {
        paramContext.delete();
        return null;
      }
      paramResources = read(paramContext);
      paramContext.delete();
      return paramResources;
    }
    catch (Throwable paramResources)
    {
      paramContext.delete();
      throw paramResources;
    }
  }
  
  /* Error */
  public static boolean a(File paramFile, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: invokestatic 91	android/os/StrictMode:allowThreadDiskWrites	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_3
    //   10: new 93	java/io/FileOutputStream
    //   13: dup
    //   14: aload_0
    //   15: iconst_0
    //   16: invokespecial 96	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   19: astore_0
    //   20: sipush 1024
    //   23: newarray byte
    //   25: astore_3
    //   26: aload_1
    //   27: aload_3
    //   28: invokevirtual 101	java/io/InputStream:read	([B)I
    //   31: istore_2
    //   32: iload_2
    //   33: iconst_m1
    //   34: if_icmpeq +13 -> 47
    //   37: aload_0
    //   38: aload_3
    //   39: iconst_0
    //   40: iload_2
    //   41: invokevirtual 105	java/io/FileOutputStream:write	([BII)V
    //   44: goto -18 -> 26
    //   47: aload_0
    //   48: invokeinterface 110 1 0
    //   53: aload 5
    //   55: invokestatic 114	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   58: iconst_1
    //   59: ireturn
    //   60: astore_1
    //   61: aload_0
    //   62: astore_3
    //   63: aload_1
    //   64: astore_0
    //   65: goto +73 -> 138
    //   68: astore_1
    //   69: goto +11 -> 80
    //   72: astore_0
    //   73: goto +65 -> 138
    //   76: astore_1
    //   77: aload 4
    //   79: astore_0
    //   80: aload_0
    //   81: astore_3
    //   82: new 38	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   89: astore 4
    //   91: aload_0
    //   92: astore_3
    //   93: aload 4
    //   95: ldc 117
    //   97: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_0
    //   102: astore_3
    //   103: aload 4
    //   105: aload_1
    //   106: invokevirtual 120	java/io/IOException:getMessage	()Ljava/lang/String;
    //   109: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_0
    //   114: astore_3
    //   115: aload 4
    //   117: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: pop
    //   121: aload_0
    //   122: ifnull +9 -> 131
    //   125: aload_0
    //   126: invokeinterface 110 1 0
    //   131: aload 5
    //   133: invokestatic 114	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   136: iconst_0
    //   137: ireturn
    //   138: aload_3
    //   139: ifnull +9 -> 148
    //   142: aload_3
    //   143: invokeinterface 110 1 0
    //   148: aload 5
    //   150: invokestatic 114	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   153: goto +3 -> 156
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: goto -106 -> 53
    //   162: astore_0
    //   163: goto -32 -> 131
    //   166: astore_1
    //   167: goto -19 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramFile	File
    //   0	170	1	paramInputStream	java.io.InputStream
    //   31	10	2	i	int
    //   9	134	3	localObject	Object
    //   6	110	4	localStringBuilder	StringBuilder
    //   3	146	5	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    // Exception table:
    //   from	to	target	type
    //   26	32	60	java/lang/Throwable
    //   37	44	60	java/lang/Throwable
    //   26	32	68	java/io/IOException
    //   37	44	68	java/io/IOException
    //   10	20	72	java/lang/Throwable
    //   82	91	72	java/lang/Throwable
    //   93	101	72	java/lang/Throwable
    //   103	113	72	java/lang/Throwable
    //   115	121	72	java/lang/Throwable
    //   10	20	76	java/io/IOException
    //   47	53	158	java/io/IOException
    //   125	131	162	java/io/IOException
    //   142	148	166	java/io/IOException
  }
  
  /* Error */
  public static boolean b(File paramFile, Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: invokevirtual 126	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   5: astore 4
    //   7: aload 4
    //   9: astore_1
    //   10: aload_0
    //   11: aload 4
    //   13: invokestatic 128	support/android/v4/internal/a:a	(Ljava/io/File;Ljava/io/InputStream;)Z
    //   16: istore_3
    //   17: aload 4
    //   19: ifnull +38 -> 57
    //   22: aload 4
    //   24: invokeinterface 110 1 0
    //   29: iload_3
    //   30: ireturn
    //   31: astore_0
    //   32: goto +6 -> 38
    //   35: astore_0
    //   36: aconst_null
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull +9 -> 48
    //   42: aload_1
    //   43: invokeinterface 110 1 0
    //   48: aload_0
    //   49: athrow
    //   50: astore_0
    //   51: iload_3
    //   52: ireturn
    //   53: astore_1
    //   54: goto -6 -> 48
    //   57: iload_3
    //   58: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramFile	File
    //   0	59	1	paramResources	Resources
    //   0	59	2	paramInt	int
    //   16	42	3	bool	boolean
    //   5	18	4	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   10	17	31	java/lang/Throwable
    //   0	7	35	java/lang/Throwable
    //   22	29	50	java/io/IOException
    //   42	48	53	java/io/IOException
  }
  
  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable) {}
    }
  }
  
  /* Error */
  public static ByteBuffer read(Context paramContext, android.os.CancellationSignal paramCancellationSignal, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 134	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_2
    //   7: ldc -120
    //   9: aload_1
    //   10: invokevirtual 142	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +13 -> 28
    //   18: aload_0
    //   19: ifnull +120 -> 139
    //   22: aload_0
    //   23: invokevirtual 145	android/os/ParcelFileDescriptor:close	()V
    //   26: aconst_null
    //   27: areturn
    //   28: new 147	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokevirtual 151	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   36: invokespecial 154	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 158	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 164	java/nio/channels/FileChannel:size	()J
    //   49: lstore_3
    //   50: aload_2
    //   51: getstatic 170	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   54: lconst_0
    //   55: lload_3
    //   56: invokevirtual 174	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   59: astore_2
    //   60: aload_1
    //   61: invokevirtual 175	java/io/FileInputStream:close	()V
    //   64: aload_0
    //   65: invokevirtual 145	android/os/ParcelFileDescriptor:close	()V
    //   68: aload_2
    //   69: areturn
    //   70: astore_2
    //   71: aload_2
    //   72: athrow
    //   73: astore 5
    //   75: aload_2
    //   76: ifnull +19 -> 95
    //   79: aload_1
    //   80: invokevirtual 175	java/io/FileInputStream:close	()V
    //   83: goto +16 -> 99
    //   86: astore_1
    //   87: aload_2
    //   88: aload_1
    //   89: invokevirtual 179	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   92: goto +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 175	java/io/FileInputStream:close	()V
    //   99: aload 5
    //   101: athrow
    //   102: astore_1
    //   103: aload_1
    //   104: athrow
    //   105: astore_2
    //   106: aload_1
    //   107: ifnull +19 -> 126
    //   110: aload_0
    //   111: invokevirtual 145	android/os/ParcelFileDescriptor:close	()V
    //   114: goto +16 -> 130
    //   117: astore_0
    //   118: aload_1
    //   119: aload_0
    //   120: invokevirtual 179	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   123: goto +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 145	android/os/ParcelFileDescriptor:close	()V
    //   130: aload_2
    //   131: athrow
    //   132: astore_0
    //   133: aconst_null
    //   134: areturn
    //   135: astore_0
    //   136: aconst_null
    //   137: areturn
    //   138: astore_0
    //   139: aconst_null
    //   140: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramContext	Context
    //   0	141	1	paramCancellationSignal	android.os.CancellationSignal
    //   0	141	2	paramUri	android.net.Uri
    //   49	7	3	l	long
    //   73	27	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   40	60	70	java/lang/Throwable
    //   71	73	73	java/lang/Throwable
    //   79	83	86	java/lang/Throwable
    //   28	40	102	java/lang/Throwable
    //   60	64	102	java/lang/Throwable
    //   87	92	102	java/lang/Throwable
    //   95	99	102	java/lang/Throwable
    //   99	102	102	java/lang/Throwable
    //   103	105	105	java/lang/Throwable
    //   110	114	117	java/lang/Throwable
    //   5	14	132	java/io/IOException
    //   22	26	132	java/io/IOException
    //   64	68	135	java/io/IOException
    //   118	123	138	java/io/IOException
    //   126	130	138	java/io/IOException
    //   130	132	138	java/io/IOException
  }
  
  public static ByteBuffer read(File paramFile)
  {
    try
    {
      paramFile = new FileInputStream(paramFile);
      try
      {
        Object localObject = paramFile.getChannel();
        long l = ((FileChannel)localObject).size();
        localObject = ((FileChannel)localObject).map(FileChannel.MapMode.READ_ONLY, 0L, l);
        try
        {
          localThrowable1.addSuppressed(paramFile);
          break label64;
          paramFile.close();
          throw localThrowable2;
        }
        catch (IOException paramFile) {}
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          paramFile.close();
          return localObject;
        }
        catch (IOException paramFile)
        {
          return null;
        }
        localThrowable1 = localThrowable1;
        try
        {
          throw localThrowable1;
        }
        catch (Throwable localThrowable2)
        {
          if (localThrowable1 != null) {
            try
            {
              paramFile.close();
            }
            catch (Throwable paramFile) {}
          }
        }
      }
      label64:
      return null;
    }
    catch (IOException paramFile)
    {
      return null;
    }
  }
}
