package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

public class UrlRedirectCache
{
  public static final String CACHE = "UrlRedirectCache";
  public static final String REDIRECT_CONTENT_TAG = f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(), CACHE, "_Redirect");
  public static volatile FileLruCache urlRedirectCache;
  
  public UrlRedirectCache() {}
  
  public static void cacheUriRedirect(Uri paramUri1, Uri paramUri2)
  {
    Object localObject1;
    if (paramUri1 != null)
    {
      if (paramUri2 == null) {
        return;
      }
      Object localObject3 = null;
      OutputStream localOutputStream = null;
      Object localObject2 = localOutputStream;
      localObject1 = localObject3;
      try
      {
        try
        {
          FileLruCache localFileLruCache = getCache();
          localObject2 = localOutputStream;
          localObject1 = localObject3;
          paramUri1 = paramUri1.toString();
          String str = REDIRECT_CONTENT_TAG;
          localObject2 = localOutputStream;
          localObject1 = localObject3;
          localOutputStream = localFileLruCache.openPutStream(paramUri1, str);
          paramUri1 = localOutputStream;
          localObject2 = paramUri1;
          localObject1 = paramUri1;
          localOutputStream.write(paramUri2.toString().getBytes());
        }
        catch (Throwable paramUri1)
        {
          Utility.closeQuietly((Closeable)localObject2);
          throw paramUri1;
        }
      }
      catch (IOException paramUri1)
      {
        for (;;)
        {
          paramUri1 = (Uri)localObject1;
        }
      }
      Utility.closeQuietly(paramUri1);
      return;
    }
  }
  
  public static void clearCache()
  {
    try
    {
      getCache().clearCache();
      return;
    }
    catch (IOException localIOException)
    {
      LoggingBehavior localLoggingBehavior = LoggingBehavior.CACHE;
      String str = CACHE;
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("clearCache failed ");
      localStringBuilder.append(localIOException.getMessage());
      Logger.e(localLoggingBehavior, 5, str, localStringBuilder.toString());
    }
  }
  
  public static FileLruCache getCache()
    throws IOException
  {
    try
    {
      if (urlRedirectCache == null) {
        urlRedirectCache = new FileLruCache(CACHE, new FileLruCache.Limits());
      }
      FileLruCache localFileLruCache = urlRedirectCache;
      return localFileLruCache;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  /* Error */
  public static Uri getRedirectedUri(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokevirtual 48	android/net/Uri:toString	()Ljava/lang/String;
    //   10: astore_3
    //   11: invokestatic 42	com/facebook/internal/UrlRedirectCache:getCache	()Lcom/facebook/internal/FileLruCache;
    //   14: astore 5
    //   16: aconst_null
    //   17: astore_0
    //   18: iconst_0
    //   19: istore_1
    //   20: getstatic 30	com/facebook/internal/UrlRedirectCache:REDIRECT_CONTENT_TAG	Ljava/lang/String;
    //   23: astore 4
    //   25: aload 5
    //   27: aload_3
    //   28: aload 4
    //   30: invokevirtual 111	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   33: astore 4
    //   35: aload 4
    //   37: ifnull +80 -> 117
    //   40: iconst_1
    //   41: istore_1
    //   42: new 113	java/io/InputStreamReader
    //   45: dup
    //   46: aload 4
    //   48: invokespecial 116	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   51: astore_3
    //   52: sipush 128
    //   55: newarray char
    //   57: astore_0
    //   58: new 15	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   65: astore 4
    //   67: aload_0
    //   68: arraylength
    //   69: istore_2
    //   70: aload_3
    //   71: aload_0
    //   72: iconst_0
    //   73: iload_2
    //   74: invokevirtual 120	java/io/InputStreamReader:read	([CII)I
    //   77: istore_2
    //   78: iload_2
    //   79: ifle +15 -> 94
    //   82: aload 4
    //   84: aload_0
    //   85: iconst_0
    //   86: iload_2
    //   87: invokevirtual 123	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: goto -24 -> 67
    //   94: aload_3
    //   95: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   98: aload 4
    //   100: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore 4
    //   105: aload_3
    //   106: astore_0
    //   107: aload 4
    //   109: astore_3
    //   110: goto -90 -> 20
    //   113: astore_0
    //   114: goto +42 -> 156
    //   117: iload_1
    //   118: ifeq +14 -> 132
    //   121: aload_3
    //   122: invokestatic 127	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   125: astore_3
    //   126: aload_0
    //   127: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   130: aload_3
    //   131: areturn
    //   132: aload_0
    //   133: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore 4
    //   140: aload_0
    //   141: astore_3
    //   142: aload 4
    //   144: astore_0
    //   145: goto +11 -> 156
    //   148: aload_0
    //   149: astore_3
    //   150: goto +14 -> 164
    //   153: astore_0
    //   154: aconst_null
    //   155: astore_3
    //   156: aload_3
    //   157: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   160: aload_0
    //   161: athrow
    //   162: aconst_null
    //   163: astore_3
    //   164: aload_3
    //   165: invokestatic 72	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   168: aconst_null
    //   169: areturn
    //   170: astore_0
    //   171: goto -9 -> 162
    //   174: astore_3
    //   175: goto -27 -> 148
    //   178: astore_0
    //   179: goto -15 -> 164
    //   182: astore_3
    //   183: goto -35 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramUri	Uri
    //   19	99	1	i	int
    //   69	18	2	j	int
    //   10	155	3	localObject1	Object
    //   174	1	3	localIOException1	IOException
    //   182	1	3	localIOException2	IOException
    //   23	85	4	localObject2	Object
    //   138	5	4	localThrowable	Throwable
    //   14	12	5	localFileLruCache	FileLruCache
    // Exception table:
    //   from	to	target	type
    //   52	58	113	java/lang/Throwable
    //   58	67	113	java/lang/Throwable
    //   70	78	113	java/lang/Throwable
    //   82	91	113	java/lang/Throwable
    //   94	105	113	java/lang/Throwable
    //   25	35	138	java/lang/Throwable
    //   42	52	138	java/lang/Throwable
    //   121	126	138	java/lang/Throwable
    //   11	16	153	java/lang/Throwable
    //   11	16	170	java/io/IOException
    //   25	35	174	java/io/IOException
    //   42	52	174	java/io/IOException
    //   58	67	178	java/io/IOException
    //   70	78	178	java/io/IOException
    //   82	91	178	java/io/IOException
    //   94	105	178	java/io/IOException
    //   121	126	182	java/io/IOException
  }
}
