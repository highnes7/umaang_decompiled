package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class FileLruCache
{
  public static final String HEADER_CACHEKEY_KEY = "key";
  public static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
  public static final AtomicLong bufferIndex = new AtomicLong();
  public static final String size = "FileLruCache";
  public final File directory;
  public final String identity;
  public boolean isTrimInProgress;
  public boolean isTrimPending;
  public AtomicLong lastClearCacheTime = new AtomicLong(0L);
  public final Limits limits;
  public final Object lock;
  
  public FileLruCache(String paramString, Limits paramLimits)
  {
    identity = paramString;
    limits = paramLimits;
    directory = new File(FacebookSdk.getCacheDir(), paramString);
    lock = new Object();
    if ((directory.mkdirs()) || (directory.isDirectory())) {
      BufferFile.deleteAll(directory);
    }
  }
  
  private void postTrim()
  {
    Object localObject = lock;
    try
    {
      if (!isTrimPending)
      {
        isTrimPending = true;
        FacebookSdk.getExecutor().execute(new Runnable()
        {
          public void run()
          {
            FileLruCache.access$200(FileLruCache.this);
          }
        });
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private void renameToTargetAndTrim(String paramString, File paramFile)
  {
    if (!paramFile.renameTo(new File(directory, Utility.md5hash(paramString)))) {
      paramFile.delete();
    }
    postTrim();
  }
  
  /* Error */
  private void trim()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   4: astore 9
    //   6: aload 9
    //   8: monitorenter
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 125	com/facebook/internal/FileLruCache:isTrimPending	Z
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 154	com/facebook/internal/FileLruCache:isTrimInProgress	Z
    //   19: aload 9
    //   21: monitorexit
    //   22: getstatic 160	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   25: iconst_3
    //   26: getstatic 162	com/facebook/internal/FileLruCache:size	Ljava/lang/String;
    //   29: ldc -92
    //   31: invokestatic 170	com/facebook/internal/Logger:e	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
    //   34: new 172	java/util/PriorityQueue
    //   37: dup
    //   38: invokespecial 173	java/util/PriorityQueue:<init>	()V
    //   41: astore 9
    //   43: aload_0
    //   44: getfield 92	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
    //   47: getstatic 177	com/facebook/internal/FileLruCache$BufferFile:filterExcludeBufferFiles	Ljava/io/FilenameFilter;
    //   50: invokevirtual 181	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   53: astore 10
    //   55: lconst_0
    //   56: lstore 5
    //   58: aload 10
    //   60: ifnull +148 -> 208
    //   63: aload 10
    //   65: arraylength
    //   66: istore_2
    //   67: lconst_0
    //   68: lstore_3
    //   69: lconst_0
    //   70: lstore 5
    //   72: iconst_0
    //   73: istore_1
    //   74: iload_1
    //   75: iload_2
    //   76: if_icmpge +129 -> 205
    //   79: aload 10
    //   81: iload_1
    //   82: aaload
    //   83: astore 11
    //   85: new 28	com/facebook/internal/FileLruCache$ModifiedFile
    //   88: dup
    //   89: aload 11
    //   91: invokespecial 183	com/facebook/internal/FileLruCache$ModifiedFile:<init>	(Ljava/io/File;)V
    //   94: astore 12
    //   96: aload 9
    //   98: aload 12
    //   100: invokevirtual 187	java/util/PriorityQueue:add	(Ljava/lang/Object;)Z
    //   103: pop
    //   104: getstatic 160	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   107: astore 13
    //   109: getstatic 162	com/facebook/internal/FileLruCache:size	Ljava/lang/String;
    //   112: astore 14
    //   114: new 189	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   121: astore 15
    //   123: aload 15
    //   125: ldc -64
    //   127: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 15
    //   133: aload 12
    //   135: invokevirtual 200	com/facebook/internal/FileLruCache$ModifiedFile:getModified	()J
    //   138: invokestatic 206	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   141: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 15
    //   147: ldc -45
    //   149: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 15
    //   155: aload 12
    //   157: invokevirtual 214	com/facebook/internal/FileLruCache$ModifiedFile:getFile	()Ljava/io/File;
    //   160: invokevirtual 218	java/io/File:getName	()Ljava/lang/String;
    //   163: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 13
    //   169: iconst_3
    //   170: aload 14
    //   172: aload 15
    //   174: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 170	com/facebook/internal/Logger:e	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
    //   180: aload 11
    //   182: invokevirtual 224	java/io/File:length	()J
    //   185: lstore 7
    //   187: lload 5
    //   189: lload 7
    //   191: ladd
    //   192: lstore 5
    //   194: lload_3
    //   195: lconst_1
    //   196: ladd
    //   197: lstore_3
    //   198: iload_1
    //   199: iconst_1
    //   200: iadd
    //   201: istore_1
    //   202: goto -128 -> 74
    //   205: goto +5 -> 210
    //   208: lconst_0
    //   209: lstore_3
    //   210: aload_0
    //   211: getfield 79	com/facebook/internal/FileLruCache:limits	Lcom/facebook/internal/FileLruCache$Limits;
    //   214: invokevirtual 228	com/facebook/internal/FileLruCache$Limits:getByteCount	()I
    //   217: i2l
    //   218: lstore 7
    //   220: lload 5
    //   222: lload 7
    //   224: lcmp
    //   225: ifgt +54 -> 279
    //   228: aload_0
    //   229: getfield 79	com/facebook/internal/FileLruCache:limits	Lcom/facebook/internal/FileLruCache$Limits;
    //   232: invokevirtual 231	com/facebook/internal/FileLruCache$Limits:getFileCount	()I
    //   235: istore_1
    //   236: lload_3
    //   237: iload_1
    //   238: i2l
    //   239: lcmp
    //   240: ifle +6 -> 246
    //   243: goto +36 -> 279
    //   246: aload_0
    //   247: getfield 94	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   250: astore 9
    //   252: aload 9
    //   254: monitorenter
    //   255: aload_0
    //   256: iconst_0
    //   257: putfield 154	com/facebook/internal/FileLruCache:isTrimInProgress	Z
    //   260: aload_0
    //   261: getfield 94	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   264: invokevirtual 234	java/lang/Object:notifyAll	()V
    //   267: aload 9
    //   269: monitorexit
    //   270: return
    //   271: astore 10
    //   273: aload 9
    //   275: monitorexit
    //   276: aload 10
    //   278: athrow
    //   279: aload 9
    //   281: invokevirtual 238	java/util/PriorityQueue:remove	()Ljava/lang/Object;
    //   284: checkcast 28	com/facebook/internal/FileLruCache$ModifiedFile
    //   287: invokevirtual 214	com/facebook/internal/FileLruCache$ModifiedFile:getFile	()Ljava/io/File;
    //   290: astore 10
    //   292: getstatic 160	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   295: astore 11
    //   297: getstatic 162	com/facebook/internal/FileLruCache:size	Ljava/lang/String;
    //   300: astore 12
    //   302: new 189	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   309: astore 13
    //   311: aload 13
    //   313: ldc -16
    //   315: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 13
    //   321: aload 10
    //   323: invokevirtual 218	java/io/File:getName	()Ljava/lang/String;
    //   326: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 11
    //   332: iconst_3
    //   333: aload 12
    //   335: aload 13
    //   337: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 170	com/facebook/internal/Logger:e	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
    //   343: aload 10
    //   345: invokevirtual 224	java/io/File:length	()J
    //   348: lstore 7
    //   350: lload 5
    //   352: lload 7
    //   354: lsub
    //   355: lstore 5
    //   357: lload_3
    //   358: lconst_1
    //   359: lsub
    //   360: lstore_3
    //   361: aload 10
    //   363: invokevirtual 150	java/io/File:delete	()Z
    //   366: pop
    //   367: goto -157 -> 210
    //   370: astore 10
    //   372: aload_0
    //   373: getfield 94	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   376: astore 9
    //   378: aload 9
    //   380: monitorenter
    //   381: aload_0
    //   382: iconst_0
    //   383: putfield 154	com/facebook/internal/FileLruCache:isTrimInProgress	Z
    //   386: aload_0
    //   387: getfield 94	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   390: invokevirtual 234	java/lang/Object:notifyAll	()V
    //   393: aload 9
    //   395: monitorexit
    //   396: aload 10
    //   398: athrow
    //   399: astore 10
    //   401: aload 9
    //   403: monitorexit
    //   404: aload 10
    //   406: athrow
    //   407: astore 10
    //   409: aload 9
    //   411: monitorexit
    //   412: goto +3 -> 415
    //   415: aload 10
    //   417: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	FileLruCache
    //   73	165	1	i	int
    //   66	11	2	j	int
    //   68	293	3	l1	long
    //   56	300	5	l2	long
    //   185	168	7	l3	long
    //   4	406	9	localObject1	Object
    //   53	27	10	arrayOfFile	File[]
    //   271	6	10	localThrowable1	Throwable
    //   290	72	10	localFile	File
    //   370	27	10	localThrowable2	Throwable
    //   399	6	10	localThrowable3	Throwable
    //   407	9	10	localThrowable4	Throwable
    //   83	248	11	localObject2	Object
    //   94	240	12	localObject3	Object
    //   107	229	13	localObject4	Object
    //   112	59	14	str	String
    //   121	52	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   255	270	271	java/lang/Throwable
    //   273	276	271	java/lang/Throwable
    //   22	55	370	java/lang/Throwable
    //   63	67	370	java/lang/Throwable
    //   85	187	370	java/lang/Throwable
    //   210	220	370	java/lang/Throwable
    //   228	236	370	java/lang/Throwable
    //   279	350	370	java/lang/Throwable
    //   361	367	370	java/lang/Throwable
    //   381	396	399	java/lang/Throwable
    //   401	404	399	java/lang/Throwable
    //   9	22	407	java/lang/Throwable
    //   409	412	407	java/lang/Throwable
  }
  
  public void clearCache()
  {
    final File[] arrayOfFile = directory.listFiles(BufferFile.filterExcludeBufferFiles);
    lastClearCacheTime.set(System.currentTimeMillis());
    if (arrayOfFile != null) {
      FacebookSdk.getExecutor().execute(new Runnable()
      {
        public void run()
        {
          File[] arrayOfFile = arrayOfFile;
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            arrayOfFile[i].delete();
            i += 1;
          }
        }
      });
    }
  }
  
  public InputStream get(String paramString1, String paramString2)
    throws IOException
  {
    File localFile = new File(directory, Utility.md5hash(paramString1));
    try
    {
      Object localObject1 = new FileInputStream(localFile);
      localObject1 = new BufferedInputStream((InputStream)localObject1, 8192);
      try
      {
        Object localObject2 = StreamHeader.readHeader((InputStream)localObject1);
        if (localObject2 == null)
        {
          ((BufferedInputStream)localObject1).close();
          return null;
        }
        String str = ((JSONObject)localObject2).optString("key");
        if (str != null)
        {
          boolean bool = str.equals(paramString1);
          if (bool)
          {
            paramString1 = ((JSONObject)localObject2).optString("tag", null);
            if ((paramString2 != null) || (paramString1 == null))
            {
              if (paramString2 != null)
              {
                bool = paramString2.equals(paramString1);
                if (bool) {}
              }
            }
            else
            {
              ((BufferedInputStream)localObject1).close();
              return null;
            }
            long l = new Date().getTime();
            paramString1 = LoggingBehavior.CACHE;
            paramString2 = size;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Setting lastModified to ");
            ((StringBuilder)localObject2).append(Long.valueOf(l));
            ((StringBuilder)localObject2).append(" for ");
            ((StringBuilder)localObject2).append(localFile.getName());
            Logger.e(paramString1, 3, paramString2, ((StringBuilder)localObject2).toString());
            localFile.setLastModified(l);
            return localObject1;
          }
        }
      }
      catch (Throwable paramString1)
      {
        break label229;
        ((BufferedInputStream)localObject1).close();
        return null;
        label229:
        ((BufferedInputStream)localObject1).close();
        throw paramString1;
      }
      return null;
    }
    catch (IOException paramString1) {}
  }
  
  public InputStream getFile(String paramString)
    throws IOException
  {
    return get(paramString, null);
  }
  
  public String getLocation()
  {
    return directory.getPath();
  }
  
  public InputStream interceptAndPut(String paramString, InputStream paramInputStream)
    throws IOException
  {
    return new CopyingInputStream(paramInputStream, openPutStream(paramString));
  }
  
  public OutputStream openPutStream(String paramString)
    throws IOException
  {
    return openPutStream(paramString, null);
  }
  
  public OutputStream openPutStream(final String paramString1, String paramString2)
    throws IOException
  {
    Object localObject1 = BufferFile.newFile(directory);
    ((File)localObject1).delete();
    if (((File)localObject1).createNewFile()) {
      try
      {
        localObject2 = new FileOutputStream((File)localObject1);
        localObject1 = new BufferedOutputStream(new CloseCallbackOutputStream((OutputStream)localObject2, new StreamCloseCallback()
        {
          public void onClose()
          {
            if (val$bufferFileCreateTime < FileLruCache.access$000(FileLruCache.this).get())
            {
              paramString1.delete();
              return;
            }
            FileLruCache.access$100(FileLruCache.this, val$key, paramString1);
          }
        }), 8192);
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("key", paramString1);
          boolean bool = Utility.isNullOrEmpty(paramString2);
          if (!bool) {
            ((JSONObject)localObject2).put("tag", paramString2);
          }
          StreamHeader.writeHeader((OutputStream)localObject1, (JSONObject)localObject2);
          return localObject1;
        }
        catch (Throwable paramString1) {}catch (JSONException paramString1)
        {
          paramString2 = LoggingBehavior.CACHE;
          localObject2 = size;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Error creating JSON header for cache file: ");
          localStringBuilder.append(paramString1);
          Logger.e(paramString2, 5, (String)localObject2, localStringBuilder.toString());
          throw new IOException(paramString1.getMessage());
        }
        ((BufferedOutputStream)localObject1).close();
        throw paramString1;
      }
      catch (FileNotFoundException paramString1)
      {
        paramString2 = LoggingBehavior.CACHE;
        localObject1 = size;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Error creating buffer output stream: ");
        ((StringBuilder)localObject2).append(paramString1);
        Logger.e(paramString2, 5, (String)localObject1, ((StringBuilder)localObject2).toString());
        throw new IOException(paramString1.getMessage());
      }
    }
    paramString1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Could not create file at ");
    paramString1.append(((File)localObject1).getAbsolutePath());
    throw new IOException(paramString1.toString());
  }
  
  /* Error */
  public long sizeInBytesForTest()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 125	com/facebook/internal/FileLruCache:isTrimPending	Z
    //   13: ifne +62 -> 75
    //   16: aload_0
    //   17: getfield 154	com/facebook/internal/FileLruCache:isTrimInProgress	Z
    //   20: ifeq +6 -> 26
    //   23: goto +52 -> 75
    //   26: aload 5
    //   28: monitorexit
    //   29: aload_0
    //   30: getfield 92	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
    //   33: invokevirtual 384	java/io/File:listFiles	()[Ljava/io/File;
    //   36: astore 5
    //   38: lconst_0
    //   39: lstore_3
    //   40: aload 5
    //   42: ifnull +31 -> 73
    //   45: aload 5
    //   47: arraylength
    //   48: istore_2
    //   49: iconst_0
    //   50: istore_1
    //   51: iload_1
    //   52: iload_2
    //   53: if_icmpge +52 -> 105
    //   56: lload_3
    //   57: aload 5
    //   59: iload_1
    //   60: aaload
    //   61: invokevirtual 224	java/io/File:length	()J
    //   64: ladd
    //   65: lstore_3
    //   66: iload_1
    //   67: iconst_1
    //   68: iadd
    //   69: istore_1
    //   70: goto -19 -> 51
    //   73: lconst_0
    //   74: lreturn
    //   75: aload_0
    //   76: getfield 94	com/facebook/internal/FileLruCache:lock	Ljava/lang/Object;
    //   79: astore 6
    //   81: aload 6
    //   83: invokevirtual 387	java/lang/Object:wait	()V
    //   86: goto -77 -> 9
    //   89: astore 6
    //   91: aload 5
    //   93: monitorexit
    //   94: goto +3 -> 97
    //   97: aload 6
    //   99: athrow
    //   100: astore 6
    //   102: goto -93 -> 9
    //   105: lload_3
    //   106: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	FileLruCache
    //   50	20	1	i	int
    //   48	6	2	j	int
    //   39	67	3	l	long
    //   4	88	5	localObject1	Object
    //   79	3	6	localObject2	Object
    //   89	9	6	localThrowable	Throwable
    //   100	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   9	23	89	java/lang/Throwable
    //   26	29	89	java/lang/Throwable
    //   81	86	89	java/lang/Throwable
    //   91	94	89	java/lang/Throwable
    //   81	86	100	java/lang/InterruptedException
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("{FileLruCache: tag:");
    localStringBuilder.append(identity);
    localStringBuilder.append(" file:");
    localStringBuilder.append(directory.getName());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private static class BufferFile
  {
    public static final String FILE_NAME_PREFIX = "buffer";
    public static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.startsWith("buffer") ^ true;
      }
    };
    public static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.startsWith("buffer");
      }
    };
    
    public BufferFile() {}
    
    public static void deleteAll(File paramFile)
    {
      paramFile = paramFile.listFiles(filterExcludeNonBufferFiles);
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          paramFile[i].delete();
          i += 1;
        }
      }
    }
    
    public static FilenameFilter excludeBufferFiles()
    {
      return filterExcludeBufferFiles;
    }
    
    public static FilenameFilter excludeNonBufferFiles()
    {
      return filterExcludeNonBufferFiles;
    }
    
    public static File newFile(File paramFile)
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("buffer");
      localStringBuilder.append(Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
      return new File(paramFile, localStringBuilder.toString());
    }
  }
  
  private static class CloseCallbackOutputStream
    extends OutputStream
  {
    public final FileLruCache.StreamCloseCallback callback;
    public final OutputStream innerStream;
    
    public CloseCallbackOutputStream(OutputStream paramOutputStream, FileLruCache.StreamCloseCallback paramStreamCloseCallback)
    {
      innerStream = paramOutputStream;
      callback = paramStreamCloseCallback;
    }
    
    public void close()
      throws IOException
    {
      try
      {
        innerStream.close();
        callback.onClose();
        return;
      }
      catch (Throwable localThrowable)
      {
        callback.onClose();
        throw localThrowable;
      }
    }
    
    public void flush()
      throws IOException
    {
      innerStream.flush();
    }
    
    public void write(int paramInt)
      throws IOException
    {
      innerStream.write(paramInt);
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      innerStream.write(paramArrayOfByte);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      innerStream.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  private static final class CopyingInputStream
    extends InputStream
  {
    public final InputStream input;
    public final OutputStream output;
    
    public CopyingInputStream(InputStream paramInputStream, OutputStream paramOutputStream)
    {
      input = paramInputStream;
      output = paramOutputStream;
    }
    
    public int available()
      throws IOException
    {
      return input.available();
    }
    
    public void close()
      throws IOException
    {
      try
      {
        input.close();
        output.close();
        return;
      }
      catch (Throwable localThrowable)
      {
        output.close();
        throw localThrowable;
      }
    }
    
    public void mark(int paramInt)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean markSupported()
    {
      return false;
    }
    
    public int read()
      throws IOException
    {
      int i = input.read();
      if (i >= 0) {
        output.write(i);
      }
      return i;
    }
    
    public int read(byte[] paramArrayOfByte)
      throws IOException
    {
      int i = input.read(paramArrayOfByte);
      if (i > 0) {
        output.write(paramArrayOfByte, 0, i);
      }
      return i;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt2 = input.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt2 > 0) {
        output.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      return paramInt2;
    }
    
    public void reset()
    {
      try
      {
        throw new UnsupportedOperationException();
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    
    public long skip(long paramLong)
      throws IOException
    {
      byte[] arrayOfByte = new byte['?'];
      int i;
      for (long l = 0L; l < paramLong; l += i)
      {
        i = read(arrayOfByte, 0, (int)Math.min(paramLong - l, arrayOfByte.length));
        if (i < 0) {
          return l;
        }
      }
      return l;
    }
  }
  
  public static final class Limits
  {
    public int byteCount = 1048576;
    public int fileCount = 1024;
    
    public Limits() {}
    
    public int getByteCount()
    {
      return byteCount;
    }
    
    public int getFileCount()
    {
      return fileCount;
    }
    
    public void setByteCount(int paramInt)
    {
      if (paramInt >= 0)
      {
        byteCount = paramInt;
        return;
      }
      throw new InvalidParameterException("Cache byte-count limit must be >= 0");
    }
    
    public void setFileCount(int paramInt)
    {
      if (paramInt >= 0)
      {
        fileCount = paramInt;
        return;
      }
      throw new InvalidParameterException("Cache file count limit must be >= 0");
    }
  }
  
  private static final class ModifiedFile
    implements Comparable<ModifiedFile>
  {
    public static final int HASH_MULTIPLIER = 37;
    public static final int HASH_SEED = 29;
    public final File file;
    public final long modified;
    
    public ModifiedFile(File paramFile)
    {
      file = paramFile;
      modified = paramFile.lastModified();
    }
    
    public int compareTo(ModifiedFile paramModifiedFile)
    {
      if (getModified() < paramModifiedFile.getModified()) {
        return -1;
      }
      if (getModified() > paramModifiedFile.getModified()) {
        return 1;
      }
      return getFile().compareTo(paramModifiedFile.getFile());
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof ModifiedFile)) && (compareTo((ModifiedFile)paramObject) == 0);
    }
    
    public File getFile()
    {
      return file;
    }
    
    public long getModified()
    {
      return modified;
    }
    
    public int hashCode()
    {
      return (file.hashCode() + 1073) * 37 + (int)(modified % 2147483647L);
    }
  }
  
  private static abstract interface StreamCloseCallback
  {
    public abstract void onClose();
  }
  
  private static final class StreamHeader
  {
    public static final int HEADER_VERSION = 0;
    
    public StreamHeader() {}
    
    public static JSONObject readHeader(InputStream paramInputStream)
      throws IOException
    {
      if (paramInputStream.read() != 0) {
        return null;
      }
      int k = 0;
      int i = 0;
      int j = 0;
      while (i < 3)
      {
        int m = paramInputStream.read();
        if (m == -1)
        {
          Logger.e(LoggingBehavior.CACHE, 3, FileLruCache.size, "readHeader: stream.read returned -1 while reading header size");
          return null;
        }
        j = (j << 8) + (m & 0xFF);
        i += 1;
      }
      Object localObject = new byte[j];
      i = k;
      String str;
      StringBuilder localStringBuilder;
      while (i < localObject.length)
      {
        j = paramInputStream.read((byte[])localObject, i, localObject.length - i);
        if (j < 1)
        {
          paramInputStream = LoggingBehavior.CACHE;
          str = FileLruCache.size;
          localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("readHeader: stream.read stopped at ");
          localStringBuilder.append(Integer.valueOf(i));
          localStringBuilder.append(" when expected ");
          localStringBuilder.append(localObject.length);
          Logger.e(paramInputStream, 3, str, localStringBuilder.toString());
          return null;
        }
        i += j;
      }
      paramInputStream = new JSONTokener(new String((byte[])localObject));
      try
      {
        paramInputStream = paramInputStream.nextValue();
        if (!(paramInputStream instanceof JSONObject))
        {
          localObject = LoggingBehavior.CACHE;
          str = FileLruCache.size;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("readHeader: expected JSONObject, got ");
          localStringBuilder.append(paramInputStream.getClass().getCanonicalName());
          Logger.e((LoggingBehavior)localObject, 3, str, localStringBuilder.toString());
          return null;
        }
        return (JSONObject)paramInputStream;
      }
      catch (JSONException paramInputStream)
      {
        paramInputStream = new IOException(paramInputStream.getMessage());
        throw paramInputStream;
      }
    }
    
    public static void writeHeader(OutputStream paramOutputStream, JSONObject paramJSONObject)
      throws IOException
    {
      paramJSONObject = paramJSONObject.toString().getBytes();
      paramOutputStream.write(0);
      paramOutputStream.write(paramJSONObject.length >> 16 & 0xFF);
      paramOutputStream.write(paramJSONObject.length >> 8 & 0xFF);
      paramOutputStream.write(paramJSONObject.length >> 0 & 0xFF);
      paramOutputStream.write(paramJSONObject);
    }
  }
}
