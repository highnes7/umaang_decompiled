package com.google.android.android.internal;

import android.content.Context;
import com.google.android.android.analytics.TerminalManager;
import com.google.android.android.common.internal.zzbp;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class zzanm
  extends zzams
{
  public volatile String zzdmx;
  public Future<String> zzdqh;
  
  public zzanm(zzamu paramZzamu)
  {
    super(paramZzamu);
  }
  
  private final boolean writeToFile(Context paramContext, String paramString)
  {
    zzbp.zzgg(paramString);
    zzbp.zzgh("ClientId should be saved from worker thread");
    Object localObject4 = null;
    Object localObject5 = null;
    FileOutputStream localFileOutputStream = null;
    Object localObject1 = localFileOutputStream;
    Object localObject2 = localObject4;
    Object localObject3 = localObject5;
    try
    {
      d("Storing clientId", paramString);
      localObject1 = localFileOutputStream;
      localObject2 = localObject4;
      localObject3 = localObject5;
      localFileOutputStream = paramContext.openFileOutput("gaClientId", 0);
      paramContext = localFileOutputStream;
      localObject1 = paramContext;
      localObject2 = paramContext;
      localObject3 = paramContext;
      localFileOutputStream.write(paramString.getBytes());
      try
      {
        localFileOutputStream.close();
      }
      catch (IOException paramContext)
      {
        toString("Failed to close clientId writing stream", paramContext);
      }
      return true;
    }
    catch (Throwable paramContext) {}catch (IOException paramContext)
    {
      localObject1 = localObject2;
      toString("Error writing to clientId file", paramContext);
      if (localObject2 == null) {
        break label186;
      }
      try
      {
        ((FileOutputStream)localObject2).close();
        return false;
      }
      catch (IOException paramContext)
      {
        toString("Failed to close clientId writing stream", paramContext);
        return false;
      }
    }
    catch (FileNotFoundException paramContext)
    {
      localObject1 = localObject3;
      toString("Error creating clientId file", paramContext);
      if (localObject3 == null) {
        break label186;
      }
    }
    try
    {
      ((FileOutputStream)localObject3).close();
      return false;
    }
    catch (IOException paramContext)
    {
      toString("Failed to close clientId writing stream", paramContext);
      return false;
    }
    if (localObject1 != null) {
      try
      {
        ((FileOutputStream)localObject1).close();
      }
      catch (IOException paramString)
      {
        toString("Failed to close clientId writing stream", paramString);
      }
    }
    throw paramContext;
    label186:
    return false;
  }
  
  /* Error */
  private final String zzbh(Context paramContext)
  {
    // Byte code:
    //   0: ldc 85
    //   2: invokestatic 40	com/google/android/android/common/internal/zzbp:zzgh	(Ljava/lang/String;)V
    //   5: aload_1
    //   6: ldc 50
    //   8: invokevirtual 89	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore 6
    //   13: aload 6
    //   15: astore 4
    //   17: bipush 36
    //   19: newarray byte
    //   21: astore 7
    //   23: aload 4
    //   25: astore 5
    //   27: aload 6
    //   29: aload 7
    //   31: iconst_0
    //   32: bipush 36
    //   34: invokevirtual 95	java/io/FileInputStream:read	([BII)I
    //   37: istore_2
    //   38: aload 4
    //   40: astore 5
    //   42: aload 6
    //   44: invokevirtual 99	java/io/FileInputStream:available	()I
    //   47: istore_3
    //   48: iload_3
    //   49: ifle +50 -> 99
    //   52: aload 4
    //   54: astore 5
    //   56: aload_0
    //   57: ldc 101
    //   59: invokevirtual 104	com/google/android/android/internal/zzamr:zzdp	(Ljava/lang/String;)V
    //   62: aload 4
    //   64: astore 5
    //   66: aload 6
    //   68: invokevirtual 105	java/io/FileInputStream:close	()V
    //   71: aload 4
    //   73: astore 5
    //   75: aload_1
    //   76: ldc 50
    //   78: invokevirtual 109	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   81: pop
    //   82: aload 6
    //   84: invokevirtual 105	java/io/FileInputStream:close	()V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: aload_0
    //   91: ldc 111
    //   93: aload_1
    //   94: invokevirtual 77	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   97: aconst_null
    //   98: areturn
    //   99: iload_2
    //   100: bipush 14
    //   102: if_icmpge +50 -> 152
    //   105: aload 4
    //   107: astore 5
    //   109: aload_0
    //   110: ldc 113
    //   112: invokevirtual 104	com/google/android/android/internal/zzamr:zzdp	(Ljava/lang/String;)V
    //   115: aload 4
    //   117: astore 5
    //   119: aload 6
    //   121: invokevirtual 105	java/io/FileInputStream:close	()V
    //   124: aload 4
    //   126: astore 5
    //   128: aload_1
    //   129: ldc 50
    //   131: invokevirtual 109	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   134: pop
    //   135: aload 6
    //   137: invokevirtual 105	java/io/FileInputStream:close	()V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aload_0
    //   144: ldc 111
    //   146: aload_1
    //   147: invokevirtual 77	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   150: aconst_null
    //   151: areturn
    //   152: aload 4
    //   154: astore 5
    //   156: aload 6
    //   158: invokevirtual 105	java/io/FileInputStream:close	()V
    //   161: aload 4
    //   163: astore 5
    //   165: new 58	java/lang/String
    //   168: dup
    //   169: aload 7
    //   171: iconst_0
    //   172: iload_2
    //   173: invokespecial 116	java/lang/String:<init>	([BII)V
    //   176: astore 7
    //   178: aload 4
    //   180: astore 5
    //   182: aload_0
    //   183: ldc 118
    //   185: aload 7
    //   187: invokevirtual 48	com/google/android/android/internal/zzamr:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   190: aload 6
    //   192: invokevirtual 105	java/io/FileInputStream:close	()V
    //   195: aload 7
    //   197: areturn
    //   198: astore_1
    //   199: aload_0
    //   200: ldc 111
    //   202: aload_1
    //   203: invokevirtual 77	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   206: aload 7
    //   208: areturn
    //   209: astore 6
    //   211: goto +15 -> 226
    //   214: astore_1
    //   215: aconst_null
    //   216: astore 5
    //   218: goto +54 -> 272
    //   221: astore 6
    //   223: aconst_null
    //   224: astore 4
    //   226: aload 4
    //   228: astore 5
    //   230: aload_0
    //   231: ldc 120
    //   233: aload 6
    //   235: invokevirtual 77	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   238: aload 4
    //   240: astore 5
    //   242: aload_1
    //   243: ldc 50
    //   245: invokevirtual 109	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   248: pop
    //   249: aload 4
    //   251: ifnull +87 -> 338
    //   254: aload 4
    //   256: invokevirtual 105	java/io/FileInputStream:close	()V
    //   259: aconst_null
    //   260: areturn
    //   261: astore_1
    //   262: aload_0
    //   263: ldc 111
    //   265: aload_1
    //   266: invokevirtual 77	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   269: aconst_null
    //   270: areturn
    //   271: astore_1
    //   272: aload 5
    //   274: ifnull +21 -> 295
    //   277: aload 5
    //   279: invokevirtual 105	java/io/FileInputStream:close	()V
    //   282: goto +13 -> 295
    //   285: astore 4
    //   287: aload_0
    //   288: ldc 111
    //   290: aload 4
    //   292: invokevirtual 77	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   295: aload_1
    //   296: athrow
    //   297: aconst_null
    //   298: astore 4
    //   300: aload 4
    //   302: ifnull +36 -> 338
    //   305: aload 4
    //   307: invokevirtual 105	java/io/FileInputStream:close	()V
    //   310: aconst_null
    //   311: areturn
    //   312: astore_1
    //   313: aload_0
    //   314: ldc 111
    //   316: aload_1
    //   317: invokevirtual 77	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   320: aconst_null
    //   321: areturn
    //   322: astore_1
    //   323: goto -26 -> 297
    //   326: astore_1
    //   327: goto -27 -> 300
    //   330: astore_1
    //   331: goto -31 -> 300
    //   334: astore_1
    //   335: goto -35 -> 300
    //   338: aconst_null
    //   339: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	this	zzanm
    //   0	340	1	paramContext	Context
    //   37	136	2	i	int
    //   47	2	3	j	int
    //   15	240	4	localFileInputStream1	java.io.FileInputStream
    //   285	6	4	localIOException1	IOException
    //   298	8	4	localObject1	Object
    //   25	253	5	localFileInputStream2	java.io.FileInputStream
    //   11	180	6	localFileInputStream3	java.io.FileInputStream
    //   209	1	6	localIOException2	IOException
    //   221	13	6	localIOException3	IOException
    //   21	186	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   82	87	89	java/io/IOException
    //   135	140	142	java/io/IOException
    //   190	195	198	java/io/IOException
    //   27	38	209	java/io/IOException
    //   42	48	209	java/io/IOException
    //   56	62	209	java/io/IOException
    //   66	71	209	java/io/IOException
    //   75	82	209	java/io/IOException
    //   109	115	209	java/io/IOException
    //   119	124	209	java/io/IOException
    //   128	135	209	java/io/IOException
    //   156	161	209	java/io/IOException
    //   165	178	209	java/io/IOException
    //   182	190	209	java/io/IOException
    //   5	13	214	java/lang/Throwable
    //   5	13	221	java/io/IOException
    //   254	259	261	java/io/IOException
    //   27	38	271	java/lang/Throwable
    //   42	48	271	java/lang/Throwable
    //   56	62	271	java/lang/Throwable
    //   66	71	271	java/lang/Throwable
    //   75	82	271	java/lang/Throwable
    //   109	115	271	java/lang/Throwable
    //   119	124	271	java/lang/Throwable
    //   128	135	271	java/lang/Throwable
    //   156	161	271	java/lang/Throwable
    //   165	178	271	java/lang/Throwable
    //   182	190	271	java/lang/Throwable
    //   230	238	271	java/lang/Throwable
    //   242	249	271	java/lang/Throwable
    //   277	282	285	java/io/IOException
    //   305	310	312	java/io/IOException
    //   5	13	322	java/io/FileNotFoundException
    //   27	38	326	java/io/FileNotFoundException
    //   42	48	326	java/io/FileNotFoundException
    //   56	62	326	java/io/FileNotFoundException
    //   66	71	326	java/io/FileNotFoundException
    //   75	82	326	java/io/FileNotFoundException
    //   109	115	330	java/io/FileNotFoundException
    //   119	124	330	java/io/FileNotFoundException
    //   128	135	330	java/io/FileNotFoundException
    //   156	161	334	java/io/FileNotFoundException
    //   165	178	334	java/io/FileNotFoundException
    //   182	190	334	java/io/FileNotFoundException
  }
  
  private final String zzxs()
  {
    String str = UUID.randomUUID().toString().toLowerCase();
    try
    {
      boolean bool = writeToFile(zzwa().getContext(), str);
      if (!bool) {
        return "0";
      }
      return str;
    }
    catch (Exception localException)
    {
      toString("Error saving clientId file", localException);
    }
    return "0";
  }
  
  public final void zzuk() {}
  
  public final String zzxp()
  {
    zzwk();
    try
    {
      if (zzdmx == null) {
        zzdqh = zzwa().execute(new zzann(this));
      }
      Object localObject = zzdqh;
      if (localObject != null)
      {
        localObject = zzdqh;
        try
        {
          localObject = ((Future)localObject).get();
          zzdmx = ((String)localObject);
        }
        catch (ExecutionException localExecutionException)
        {
          toString("Failed to load or generate client id", localExecutionException);
          zzdmx = "0";
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            append("ClientId loading or generation was interrupted", localInterruptedException);
          }
        }
        if (zzdmx == null) {
          zzdmx = "0";
        }
        d("Loaded clientId", zzdmx);
        zzdqh = null;
      }
      String str = zzdmx;
      return str;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final String zzxq()
  {
    try
    {
      zzdmx = null;
      zzdqh = zzwa().execute(new zzano(this));
      return zzxp();
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final String zzxr()
  {
    String str2 = zzbh(zzwa().getContext());
    String str1 = str2;
    if (str2 == null) {
      str1 = zzxs();
    }
    return str1;
  }
}
