package com.google.android.android.internal;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public final class zzag
  implements Cache
{
  public final Map<String, com.google.android.gms.internal.zzai> zzbv = new LinkedHashMap(16, 0.75F, true);
  public long zzbw = 0L;
  public final File zzbx;
  public final int zzby;
  
  public zzag(File paramFile)
  {
    this(paramFile, 5242880);
  }
  
  public zzag(File paramFile, int paramInt)
  {
    zzbx = paramFile;
    zzby = 5242880;
  }
  
  public static String append(String paramString)
  {
    int i = paramString.length() / 2;
    String str = String.valueOf(String.valueOf(paramString.substring(0, i).hashCode()));
    paramString = String.valueOf(String.valueOf(paramString.substring(i).hashCode()));
    if (paramString.length() != 0) {
      return str.concat(paramString);
    }
    return new String(str);
  }
  
  private final File getFileForKey(String paramString)
  {
    return new File(zzbx, append(paramString));
  }
  
  private final void putEntry(String paramString, zzai paramZzai)
  {
    if (!zzbv.containsKey(paramString))
    {
      zzbw += zzbz;
    }
    else
    {
      zzai localZzai = (zzai)zzbv.get(paramString);
      long l = zzbw;
      zzbw = (zzbz - zzbz + l);
    }
    zzbv.put(paramString, paramZzai);
  }
  
  public static int readInt(InputStream paramInputStream)
    throws IOException
  {
    int i = readLength(paramInputStream);
    int j = readLength(paramInputStream);
    int k = readLength(paramInputStream);
    return readLength(paramInputStream) << 24 | i | 0x0 | j << 8 | k << 16;
  }
  
  public static int readLength(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i != -1) {
      return i;
    }
    throw new EOFException();
  }
  
  public static long readLong(InputStream paramInputStream)
    throws IOException
  {
    return readLength(paramInputStream) & 0xFF | 0L | (readLength(paramInputStream) & 0xFF) << 8 | (readLength(paramInputStream) & 0xFF) << 16 | (readLength(paramInputStream) & 0xFF) << 24 | (readLength(paramInputStream) & 0xFF) << 32 | (readLength(paramInputStream) & 0xFF) << 40 | (readLength(paramInputStream) & 0xFF) << 48 | (0xFF & readLength(paramInputStream)) << 56;
  }
  
  public static String readString(InputStream paramInputStream)
    throws IOException
  {
    return new String(streamToBytes(paramInputStream, (int)readLong(paramInputStream)), "UTF-8");
  }
  
  public static Map readStringStringMap(InputStream paramInputStream)
    throws IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a4 = a3\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private final void remove(String paramString)
  {
    try
    {
      boolean bool = getFileForKey(paramString).delete();
      Object localObject = (zzai)zzbv.get(paramString);
      if (localObject != null)
      {
        zzbw -= zzbz;
        zzbv.remove(paramString);
      }
      if (!bool)
      {
        localObject = append(paramString);
        String str = zzab.data;
        zzab.get("Could not delete cache entry for key=%s, filename=%s", new Object[] { paramString, localObject });
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public static byte[] streamToBytes(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1) {
        break;
      }
      i += j;
    }
    if (i == paramInt) {
      return arrayOfByte;
    }
    paramInputStream = new StringBuilder(50);
    paramInputStream.append("Expected ");
    paramInputStream.append(paramInt);
    paramInputStream.append(" bytes, read ");
    paramInputStream.append(i);
    paramInputStream.append(" bytes");
    paramInputStream = new IOException(paramInputStream.toString());
    throw paramInputStream;
  }
  
  public static void writeInt(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >>> 24);
  }
  
  public static void writeLong(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    paramOutputStream.write((byte)(int)paramLong);
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }
  
  public static void writeString(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    writeLong(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  public final Cache.Entry get(String paramString)
  {
    try
    {
      zzai localZzai = (zzai)zzbv.get(paramString);
      if (localZzai == null) {
        return null;
      }
      Object localObject1 = getFileForKey(paramString);
      for (;;)
      {
        zzaj localZzaj2;
        Object localObject2;
        try
        {
          localZzaj2 = new zzaj(new BufferedInputStream(new FileInputStream((File)localObject1)), null);
          localZzaj1 = localZzaj2;
        }
        catch (Throwable paramString)
        {
          long l;
          int i;
          Cache.Entry localEntry;
          localZzaj1 = null;
        }
        catch (NegativeArraySizeException localNegativeArraySizeException2)
        {
          localZzaj2 = null;
          localZzaj1 = localZzaj2;
          localObject1 = ((File)localObject1).getAbsolutePath();
          localZzaj1 = localZzaj2;
          String str1 = localNegativeArraySizeException2.toString();
          localZzaj1 = localZzaj2;
          localObject2 = zzab.data;
          localZzaj1 = localZzaj2;
          zzab.get("%s: %s", new Object[] { localObject1, str1 });
          localZzaj1 = localZzaj2;
          remove(paramString);
          if (localZzaj2 != null) {}
          try
          {
            localZzaj2.close();
          }
          catch (IOException paramString)
          {
            String str2;
            continue;
          }
          return null;
          return null;
        }
        catch (IOException localIOException2)
        {
          label225:
          localZzaj2 = null;
        }
        try
        {
          try
          {
            zzai.readHeader(localZzaj2);
            localZzaj1 = localZzaj2;
            l = ((File)localObject1).length();
            localZzaj1 = localZzaj2;
            i = zzaj.access$2608(localZzaj2);
            i = (int)(l - i);
            localZzaj1 = localZzaj2;
            localObject2 = streamToBytes(localZzaj2, i);
            localZzaj1 = localZzaj2;
            localEntry = new Cache.Entry();
            localZzaj1 = localZzaj2;
            data = ((byte[])localObject2);
            localZzaj1 = localZzaj2;
            etag = etag;
            localZzaj1 = localZzaj2;
            serverDate = serverDate;
            localZzaj1 = localZzaj2;
            lastModified = lastModified;
            localZzaj1 = localZzaj2;
            ttl = ttl;
            localZzaj1 = localZzaj2;
            softTtl = softTtl;
            localZzaj1 = localZzaj2;
            responseHeaders = responseHeaders;
          }
          catch (NegativeArraySizeException localNegativeArraySizeException1) {}catch (IOException localIOException1) {}
        }
        catch (Throwable paramString) {}
      }
    }
    catch (Throwable paramString)
    {
      zzaj localZzaj1;
      throw paramString;
    }
    try
    {
      localZzaj2.close();
      return localEntry;
    }
    catch (IOException paramString)
    {
      break label225;
    }
    return null;
    localZzaj1 = localZzaj2;
    localObject1 = ((File)localObject1).getAbsolutePath();
    localZzaj1 = localZzaj2;
    str2 = localIOException2.toString();
    localZzaj1 = localZzaj2;
    localObject2 = zzab.data;
    localZzaj1 = localZzaj2;
    zzab.get("%s: %s", new Object[] { localObject1, str2 });
    localZzaj1 = localZzaj2;
    remove(paramString);
    if (localZzaj2 != null) {}
    try
    {
      localZzaj2.close();
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
    return null;
    return null;
    if (localZzaj1 != null) {}
    try
    {
      localZzaj1.close();
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
    return null;
    throw paramString;
  }
  
  /* Error */
  public final void initialize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: astore 6
    //   5: aload_0
    //   6: getfield 37	com/google/android/android/internal/zzag:zzbx	Ljava/io/File;
    //   9: astore 8
    //   11: aload_0
    //   12: astore 7
    //   14: aload 7
    //   16: astore 6
    //   18: aload 8
    //   20: invokevirtual 286	java/io/File:exists	()Z
    //   23: istore_3
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_3
    //   27: ifne +80 -> 107
    //   30: aload 7
    //   32: astore 6
    //   34: aload 7
    //   36: getfield 37	com/google/android/android/internal/zzag:zzbx	Ljava/io/File;
    //   39: astore 8
    //   41: aload 7
    //   43: astore 6
    //   45: aload 8
    //   47: invokevirtual 289	java/io/File:mkdirs	()Z
    //   50: ifne +54 -> 104
    //   53: aload 7
    //   55: astore 6
    //   57: aload 7
    //   59: getfield 37	com/google/android/android/internal/zzag:zzbx	Ljava/io/File;
    //   62: astore 8
    //   64: aload 7
    //   66: astore 6
    //   68: aload 8
    //   70: invokevirtual 274	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   73: astore 8
    //   75: aload 7
    //   77: astore 6
    //   79: getstatic 158	com/google/android/android/internal/zzab:data	Ljava/lang/String;
    //   82: astore 9
    //   84: aload 7
    //   86: astore 6
    //   88: ldc_w 291
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload 8
    //   99: aastore
    //   100: invokestatic 163	com/google/android/android/internal/zzab:get	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   103: pop
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: aload 7
    //   109: astore 6
    //   111: aload 7
    //   113: getfield 37	com/google/android/android/internal/zzag:zzbx	Ljava/io/File;
    //   116: astore 9
    //   118: aload 7
    //   120: astore 8
    //   122: aload 8
    //   124: astore 6
    //   126: aload 9
    //   128: invokevirtual 295	java/io/File:listFiles	()[Ljava/io/File;
    //   131: astore 10
    //   133: aload 10
    //   135: ifnonnull +7 -> 142
    //   138: aload 8
    //   140: monitorexit
    //   141: return
    //   142: aload 8
    //   144: astore 6
    //   146: aload 10
    //   148: arraylength
    //   149: istore_2
    //   150: iload_1
    //   151: iload_2
    //   152: if_icmpge +159 -> 311
    //   155: aload 10
    //   157: iload_1
    //   158: aaload
    //   159: astore 11
    //   161: aconst_null
    //   162: astore 9
    //   164: aconst_null
    //   165: astore 6
    //   167: new 215	java/io/BufferedInputStream
    //   170: dup
    //   171: new 217	java/io/FileInputStream
    //   174: dup
    //   175: aload 11
    //   177: invokespecial 219	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   180: invokespecial 222	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   183: astore 7
    //   185: aload 7
    //   187: invokestatic 229	com/google/android/android/internal/zzai:readHeader	(Ljava/io/InputStream;)Lcom/google/android/android/internal/zzai;
    //   190: astore 6
    //   192: aload 11
    //   194: invokevirtual 232	java/io/File:length	()J
    //   197: lstore 4
    //   199: aload 6
    //   201: lload 4
    //   203: putfield 91	com/google/android/android/internal/zzai:zzbz	J
    //   206: aload 6
    //   208: getfield 298	com/google/android/android/internal/zzai:key	Ljava/lang/String;
    //   211: astore 9
    //   213: aload 8
    //   215: aload 9
    //   217: aload 6
    //   219: invokespecial 300	com/google/android/android/internal/zzag:putEntry	(Ljava/lang/String;Lcom/google/android/android/internal/zzai;)V
    //   222: aload 8
    //   224: astore 6
    //   226: aload 7
    //   228: invokevirtual 301	java/io/BufferedInputStream:close	()V
    //   231: goto +73 -> 304
    //   234: astore 9
    //   236: goto +33 -> 269
    //   239: goto +12 -> 251
    //   242: astore 9
    //   244: aload 6
    //   246: astore 7
    //   248: goto +21 -> 269
    //   251: aload 11
    //   253: ifnull +37 -> 290
    //   256: aload 7
    //   258: astore 6
    //   260: aload 11
    //   262: invokevirtual 150	java/io/File:delete	()Z
    //   265: pop
    //   266: goto +24 -> 290
    //   269: aload 7
    //   271: ifnull +12 -> 283
    //   274: aload 8
    //   276: astore 6
    //   278: aload 7
    //   280: invokevirtual 301	java/io/BufferedInputStream:close	()V
    //   283: aload 8
    //   285: astore 6
    //   287: aload 9
    //   289: athrow
    //   290: aload 7
    //   292: ifnull +12 -> 304
    //   295: aload 8
    //   297: astore 6
    //   299: aload 7
    //   301: invokevirtual 301	java/io/BufferedInputStream:close	()V
    //   304: iload_1
    //   305: iconst_1
    //   306: iadd
    //   307: istore_1
    //   308: goto -158 -> 150
    //   311: aload 8
    //   313: monitorexit
    //   314: return
    //   315: astore 7
    //   317: aload 6
    //   319: monitorexit
    //   320: goto +3 -> 323
    //   323: aload 7
    //   325: athrow
    //   326: astore 6
    //   328: aload 9
    //   330: astore 7
    //   332: goto -81 -> 251
    //   335: astore 6
    //   337: goto -98 -> 239
    //   340: astore 6
    //   342: goto -38 -> 304
    //   345: astore 6
    //   347: goto -64 -> 283
    //   350: astore 6
    //   352: goto -48 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	zzag
    //   25	283	1	i	int
    //   149	4	2	j	int
    //   23	4	3	bool	boolean
    //   197	5	4	l	long
    //   3	315	6	localObject1	Object
    //   326	1	6	localIOException1	IOException
    //   335	1	6	localIOException2	IOException
    //   340	1	6	localIOException3	IOException
    //   345	1	6	localIOException4	IOException
    //   350	1	6	localIOException5	IOException
    //   12	288	7	localObject2	Object
    //   315	9	7	localThrowable1	Throwable
    //   330	1	7	localObject3	Object
    //   9	303	8	localObject4	Object
    //   82	134	9	localObject5	Object
    //   234	1	9	localThrowable2	Throwable
    //   242	87	9	localThrowable3	Throwable
    //   131	25	10	arrayOfFile	File[]
    //   159	102	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   185	199	234	java/lang/Throwable
    //   213	222	234	java/lang/Throwable
    //   167	185	242	java/lang/Throwable
    //   260	266	242	java/lang/Throwable
    //   5	11	315	java/lang/Throwable
    //   18	24	315	java/lang/Throwable
    //   34	41	315	java/lang/Throwable
    //   45	53	315	java/lang/Throwable
    //   57	64	315	java/lang/Throwable
    //   68	75	315	java/lang/Throwable
    //   79	84	315	java/lang/Throwable
    //   88	104	315	java/lang/Throwable
    //   111	118	315	java/lang/Throwable
    //   126	133	315	java/lang/Throwable
    //   146	150	315	java/lang/Throwable
    //   226	231	315	java/lang/Throwable
    //   278	283	315	java/lang/Throwable
    //   287	290	315	java/lang/Throwable
    //   299	304	315	java/lang/Throwable
    //   167	185	326	java/io/IOException
    //   185	199	335	java/io/IOException
    //   213	222	335	java/io/IOException
    //   226	231	340	java/io/IOException
    //   278	283	345	java/io/IOException
    //   299	304	350	java/io/IOException
  }
  
  /* Error */
  public final void put(String paramString, Cache.Entry paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 242	com/google/android/android/internal/Cache$Entry:data	[B
    //   6: arraylength
    //   7: istore_3
    //   8: aload_0
    //   9: getfield 35	com/google/android/android/internal/zzag:zzbw	J
    //   12: lstore 7
    //   14: iload_3
    //   15: i2l
    //   16: lstore 5
    //   18: lload 7
    //   20: lload 5
    //   22: ladd
    //   23: aload_0
    //   24: getfield 39	com/google/android/android/internal/zzag:zzby	I
    //   27: i2l
    //   28: lcmp
    //   29: iflt +239 -> 268
    //   32: getstatic 306	com/google/android/android/internal/zzab:DEBUG	Z
    //   35: ifeq +13 -> 48
    //   38: ldc_w 308
    //   41: iconst_0
    //   42: anewarray 4	java/lang/Object
    //   45: invokestatic 312	com/google/android/android/internal/zzab:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: aload_0
    //   49: getfield 35	com/google/android/android/internal/zzag:zzbw	J
    //   52: lstore 7
    //   54: invokestatic 317	android/os/SystemClock:elapsedRealtime	()J
    //   57: lstore 9
    //   59: aload_0
    //   60: getfield 33	com/google/android/android/internal/zzag:zzbv	Ljava/util/Map;
    //   63: invokeinterface 321 1 0
    //   68: invokeinterface 327 1 0
    //   73: astore 12
    //   75: iconst_0
    //   76: istore_3
    //   77: iload_3
    //   78: istore 4
    //   80: aload 12
    //   82: invokeinterface 332 1 0
    //   87: ifeq +132 -> 219
    //   90: aload 12
    //   92: invokeinterface 336 1 0
    //   97: checkcast 338	java/util/Map$Entry
    //   100: invokeinterface 341 1 0
    //   105: checkcast 88	com/google/android/android/internal/zzai
    //   108: astore 13
    //   110: aload_0
    //   111: aload 13
    //   113: getfield 298	com/google/android/android/internal/zzai:key	Ljava/lang/String;
    //   116: invokespecial 146	com/google/android/android/internal/zzag:getFileForKey	(Ljava/lang/String;)Ljava/io/File;
    //   119: invokevirtual 150	java/io/File:delete	()Z
    //   122: ifeq +20 -> 142
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 35	com/google/android/android/internal/zzag:zzbw	J
    //   130: aload 13
    //   132: getfield 91	com/google/android/android/internal/zzai:zzbz	J
    //   135: lsub
    //   136: putfield 35	com/google/android/android/internal/zzag:zzbw	J
    //   139: goto +42 -> 181
    //   142: aload 13
    //   144: getfield 298	com/google/android/android/internal/zzai:key	Ljava/lang/String;
    //   147: astore 13
    //   149: aload 13
    //   151: invokestatic 75	com/google/android/android/internal/zzag:append	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore 14
    //   156: getstatic 158	com/google/android/android/internal/zzab:data	Ljava/lang/String;
    //   159: astore 15
    //   161: ldc -96
    //   163: iconst_2
    //   164: anewarray 4	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload 13
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: aload 14
    //   176: aastore
    //   177: invokestatic 163	com/google/android/android/internal/zzab:get	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   180: pop
    //   181: aload 12
    //   183: invokeinterface 343 1 0
    //   188: iload_3
    //   189: iconst_1
    //   190: iadd
    //   191: istore_3
    //   192: aload_0
    //   193: getfield 35	com/google/android/android/internal/zzag:zzbw	J
    //   196: lload 5
    //   198: ladd
    //   199: l2f
    //   200: aload_0
    //   201: getfield 39	com/google/android/android/internal/zzag:zzby	I
    //   204: i2f
    //   205: ldc_w 344
    //   208: fmul
    //   209: fcmpg
    //   210: ifge +224 -> 434
    //   213: iload_3
    //   214: istore 4
    //   216: goto +3 -> 219
    //   219: getstatic 306	com/google/android/android/internal/zzab:DEBUG	Z
    //   222: ifeq +46 -> 268
    //   225: ldc_w 346
    //   228: iconst_3
    //   229: anewarray 4	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: iload 4
    //   236: invokestatic 351	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: aload_0
    //   243: getfield 35	com/google/android/android/internal/zzag:zzbw	J
    //   246: lload 7
    //   248: lsub
    //   249: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   252: aastore
    //   253: dup
    //   254: iconst_2
    //   255: invokestatic 317	android/os/SystemClock:elapsedRealtime	()J
    //   258: lload 9
    //   260: lsub
    //   261: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   264: aastore
    //   265: invokestatic 312	com/google/android/android/internal/zzab:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: aload_0
    //   269: aload_1
    //   270: invokespecial 146	com/google/android/android/internal/zzag:getFileForKey	(Ljava/lang/String;)Ljava/io/File;
    //   273: astore 12
    //   275: new 358	java/io/BufferedOutputStream
    //   278: dup
    //   279: new 360	java/io/FileOutputStream
    //   282: dup
    //   283: aload 12
    //   285: invokespecial 361	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   288: invokespecial 364	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   291: astore 13
    //   293: new 88	com/google/android/android/internal/zzai
    //   296: dup
    //   297: aload_1
    //   298: aload_2
    //   299: invokespecial 366	com/google/android/android/internal/zzai:<init>	(Ljava/lang/String;Lcom/google/android/android/internal/Cache$Entry;)V
    //   302: astore 14
    //   304: aload 14
    //   306: aload 13
    //   308: invokevirtual 369	com/google/android/android/internal/zzai:write	(Ljava/io/OutputStream;)Z
    //   311: istore 11
    //   313: iload 11
    //   315: ifeq +29 -> 344
    //   318: aload_2
    //   319: getfield 242	com/google/android/android/internal/Cache$Entry:data	[B
    //   322: astore_2
    //   323: aload 13
    //   325: aload_2
    //   326: invokevirtual 372	java/io/BufferedOutputStream:write	([B)V
    //   329: aload 13
    //   331: invokevirtual 373	java/io/BufferedOutputStream:close	()V
    //   334: aload_0
    //   335: aload_1
    //   336: aload 14
    //   338: invokespecial 300	com/google/android/android/internal/zzag:putEntry	(Ljava/lang/String;Lcom/google/android/android/internal/zzai;)V
    //   341: aload_0
    //   342: monitorexit
    //   343: return
    //   344: aload 13
    //   346: invokevirtual 373	java/io/BufferedOutputStream:close	()V
    //   349: aload 12
    //   351: invokevirtual 274	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   354: astore_1
    //   355: getstatic 158	com/google/android/android/internal/zzab:data	Ljava/lang/String;
    //   358: astore_2
    //   359: ldc_w 375
    //   362: iconst_1
    //   363: anewarray 4	java/lang/Object
    //   366: dup
    //   367: iconst_0
    //   368: aload_1
    //   369: aastore
    //   370: invokestatic 163	com/google/android/android/internal/zzab:get	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   373: pop
    //   374: new 103	java/io/IOException
    //   377: dup
    //   378: invokespecial 376	java/io/IOException:<init>	()V
    //   381: athrow
    //   382: aload 12
    //   384: invokevirtual 150	java/io/File:delete	()Z
    //   387: ifne +28 -> 415
    //   390: aload 12
    //   392: invokevirtual 274	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   395: astore_1
    //   396: getstatic 158	com/google/android/android/internal/zzab:data	Ljava/lang/String;
    //   399: astore_2
    //   400: ldc_w 378
    //   403: iconst_1
    //   404: anewarray 4	java/lang/Object
    //   407: dup
    //   408: iconst_0
    //   409: aload_1
    //   410: aastore
    //   411: invokestatic 163	com/google/android/android/internal/zzab:get	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   414: pop
    //   415: aload_0
    //   416: monitorexit
    //   417: return
    //   418: astore_1
    //   419: aload_0
    //   420: monitorexit
    //   421: goto +3 -> 424
    //   424: aload_1
    //   425: athrow
    //   426: astore_1
    //   427: goto -45 -> 382
    //   430: astore_1
    //   431: goto -49 -> 382
    //   434: goto -357 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	this	zzag
    //   0	437	1	paramString	String
    //   0	437	2	paramEntry	Cache.Entry
    //   7	207	3	i	int
    //   78	157	4	j	int
    //   16	181	5	l1	long
    //   12	235	7	l2	long
    //   57	202	9	l3	long
    //   311	3	11	bool	boolean
    //   73	318	12	localObject1	Object
    //   108	237	13	localObject2	Object
    //   154	183	14	localObject3	Object
    //   159	1	15	str	String
    // Exception table:
    //   from	to	target	type
    //   2	14	418	java/lang/Throwable
    //   18	48	418	java/lang/Throwable
    //   48	75	418	java/lang/Throwable
    //   80	139	418	java/lang/Throwable
    //   142	181	418	java/lang/Throwable
    //   181	188	418	java/lang/Throwable
    //   192	213	418	java/lang/Throwable
    //   219	268	418	java/lang/Throwable
    //   268	275	418	java/lang/Throwable
    //   275	293	418	java/lang/Throwable
    //   293	313	418	java/lang/Throwable
    //   323	341	418	java/lang/Throwable
    //   344	349	418	java/lang/Throwable
    //   349	355	418	java/lang/Throwable
    //   355	359	418	java/lang/Throwable
    //   359	374	418	java/lang/Throwable
    //   374	382	418	java/lang/Throwable
    //   382	415	418	java/lang/Throwable
    //   275	293	426	java/io/IOException
    //   293	313	426	java/io/IOException
    //   323	341	426	java/io/IOException
    //   344	349	430	java/io/IOException
    //   349	355	430	java/io/IOException
    //   359	374	430	java/io/IOException
    //   374	382	430	java/io/IOException
  }
}
