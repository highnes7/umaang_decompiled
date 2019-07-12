package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.io.Closeable;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ImageDownloader
{
  public static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
  public static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
  public static WorkQueue cacheReadQueue = new WorkQueue(2);
  public static WorkQueue downloadQueue = new WorkQueue(8);
  public static Handler handler;
  public static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();
  
  public ImageDownloader() {}
  
  public static boolean cancelRequest(ImageRequest paramImageRequest)
  {
    RequestKey localRequestKey = new RequestKey(paramImageRequest.getImageUri(), paramImageRequest.getCallerTag());
    paramImageRequest = pendingRequests;
    for (;;)
    {
      try
      {
        DownloaderContext localDownloaderContext = (DownloaderContext)pendingRequests.get(localRequestKey);
        bool = true;
        if (localDownloaderContext != null)
        {
          if (workItem.cancel()) {
            pendingRequests.remove(localRequestKey);
          } else {
            isCancelled = true;
          }
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      boolean bool = false;
    }
  }
  
  public static void clearCache(Context paramContext)
  {
    ImageResponseCache.clearCache(paramContext);
    UrlRedirectCache.clearCache();
  }
  
  /* Error */
  public static void download(RequestKey paramRequestKey, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: iconst_1
    //   10: istore_3
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: getfield 117	com/facebook/internal/ImageDownloader$RequestKey:fileUri	Landroid/net/Uri;
    //   17: astore 6
    //   19: new 119	java/net/URL
    //   22: dup
    //   23: aload 6
    //   25: invokevirtual 125	android/net/Uri:toString	()Ljava/lang/String;
    //   28: invokespecial 128	java/net/URL:<init>	(Ljava/lang/String;)V
    //   31: invokevirtual 132	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   34: astore 6
    //   36: aload 6
    //   38: checkcast 134	java/net/HttpURLConnection
    //   41: astore 7
    //   43: aload 7
    //   45: iconst_0
    //   46: invokevirtual 138	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   49: aload 7
    //   51: invokevirtual 142	java/net/HttpURLConnection:getResponseCode	()I
    //   54: istore 4
    //   56: iload 4
    //   58: sipush 200
    //   61: if_icmpeq +269 -> 330
    //   64: iload 4
    //   66: sipush 301
    //   69: if_icmpeq +150 -> 219
    //   72: iload 4
    //   74: sipush 302
    //   77: if_icmpeq +142 -> 219
    //   80: aload 7
    //   82: invokevirtual 146	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   85: astore 6
    //   87: aload 6
    //   89: astore 8
    //   91: new 148	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   98: astore 10
    //   100: aload 6
    //   102: ifnull +62 -> 164
    //   105: new 151	java/io/InputStreamReader
    //   108: dup
    //   109: aload 6
    //   111: invokespecial 154	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   114: astore_1
    //   115: sipush 128
    //   118: newarray char
    //   120: astore 11
    //   122: aload 11
    //   124: arraylength
    //   125: istore 4
    //   127: aload_1
    //   128: aload 11
    //   130: iconst_0
    //   131: iload 4
    //   133: invokevirtual 158	java/io/InputStreamReader:read	([CII)I
    //   136: istore 4
    //   138: iload 4
    //   140: ifle +17 -> 157
    //   143: aload 10
    //   145: aload 11
    //   147: iconst_0
    //   148: iload 4
    //   150: invokevirtual 162	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: goto -32 -> 122
    //   157: aload_1
    //   158: invokestatic 168	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   161: goto +20 -> 181
    //   164: getstatic 173	com/facebook/R$string:com_facebook_image_download_unknown_error	I
    //   167: istore 4
    //   169: aload 10
    //   171: aload_1
    //   172: iload 4
    //   174: invokevirtual 179	android/content/Context:getString	(I)Ljava/lang/String;
    //   177: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: new 184	com/facebook/FacebookException
    //   184: dup
    //   185: aload 10
    //   187: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokespecial 186	com/facebook/FacebookException:<init>	(Ljava/lang/String;)V
    //   193: astore_1
    //   194: aload_1
    //   195: astore 8
    //   197: aconst_null
    //   198: astore_1
    //   199: goto +157 -> 356
    //   202: astore_0
    //   203: aload 6
    //   205: astore_1
    //   206: goto +206 -> 412
    //   209: astore_1
    //   210: iload_3
    //   211: istore_2
    //   212: aload 8
    //   214: astore 6
    //   216: goto +219 -> 435
    //   219: aload 7
    //   221: ldc -68
    //   223: invokevirtual 192	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore_1
    //   227: aload_1
    //   228: invokestatic 196	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   231: istore 5
    //   233: iload 5
    //   235: ifne +72 -> 307
    //   238: aload_1
    //   239: invokestatic 200	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   242: astore_1
    //   243: aload_0
    //   244: getfield 117	com/facebook/internal/ImageDownloader$RequestKey:fileUri	Landroid/net/Uri;
    //   247: astore 6
    //   249: aload 6
    //   251: aload_1
    //   252: invokestatic 204	com/facebook/internal/UrlRedirectCache:cacheUriRedirect	(Landroid/net/Uri;Landroid/net/Uri;)V
    //   255: aload_0
    //   256: invokestatic 208	com/facebook/internal/ImageDownloader:removePendingRequest	(Lcom/facebook/internal/ImageDownloader$RequestKey;)Lcom/facebook/internal/ImageDownloader$DownloaderContext;
    //   259: astore 6
    //   261: aload 6
    //   263: ifnull +44 -> 307
    //   266: aload 6
    //   268: getfield 101	com/facebook/internal/ImageDownloader$DownloaderContext:isCancelled	Z
    //   271: istore 5
    //   273: iload 5
    //   275: ifne +32 -> 307
    //   278: aload 6
    //   280: getfield 212	com/facebook/internal/ImageDownloader$DownloaderContext:request	Lcom/facebook/internal/ImageRequest;
    //   283: astore 6
    //   285: aload_0
    //   286: getfield 216	com/facebook/internal/ImageDownloader$RequestKey:activity	Ljava/lang/Object;
    //   289: astore 11
    //   291: aload 6
    //   293: new 17	com/facebook/internal/ImageDownloader$RequestKey
    //   296: dup
    //   297: aload_1
    //   298: aload 11
    //   300: invokespecial 78	com/facebook/internal/ImageDownloader$RequestKey:<init>	(Landroid/net/Uri;Ljava/lang/Object;)V
    //   303: iconst_0
    //   304: invokestatic 220	com/facebook/internal/ImageDownloader:enqueueCacheRead	(Lcom/facebook/internal/ImageRequest;Lcom/facebook/internal/ImageDownloader$RequestKey;Z)V
    //   307: aconst_null
    //   308: astore 6
    //   310: aconst_null
    //   311: astore_1
    //   312: iconst_0
    //   313: istore_2
    //   314: aload 10
    //   316: astore 8
    //   318: goto +38 -> 356
    //   321: astore_1
    //   322: aconst_null
    //   323: astore 6
    //   325: iconst_0
    //   326: istore_2
    //   327: goto +108 -> 435
    //   330: aload_1
    //   331: aload 7
    //   333: invokestatic 224	com/facebook/internal/ImageResponseCache:interceptAndCacheImageStream	(Landroid/content/Context;Ljava/net/HttpURLConnection;)Ljava/io/InputStream;
    //   336: astore 6
    //   338: aload 6
    //   340: astore 8
    //   342: aload 6
    //   344: invokestatic 230	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   347: astore_1
    //   348: aload 8
    //   350: astore 6
    //   352: aload 10
    //   354: astore 8
    //   356: aload 6
    //   358: invokestatic 168	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   361: aload 7
    //   363: invokestatic 234	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
    //   366: aload 8
    //   368: checkcast 65	java/lang/Throwable
    //   371: astore 6
    //   373: goto +78 -> 451
    //   376: astore_0
    //   377: aload 6
    //   379: astore_1
    //   380: goto +32 -> 412
    //   383: astore_1
    //   384: iload_3
    //   385: istore_2
    //   386: goto +49 -> 435
    //   389: astore_0
    //   390: aload 8
    //   392: astore_1
    //   393: goto +19 -> 412
    //   396: astore_1
    //   397: aconst_null
    //   398: astore 6
    //   400: iload_3
    //   401: istore_2
    //   402: goto +33 -> 435
    //   405: astore_0
    //   406: aconst_null
    //   407: astore 7
    //   409: aload 8
    //   411: astore_1
    //   412: aload_1
    //   413: checkcast 236	java/io/Closeable
    //   416: invokestatic 168	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   419: aload 7
    //   421: invokestatic 234	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
    //   424: aload_0
    //   425: athrow
    //   426: astore_1
    //   427: aconst_null
    //   428: astore 7
    //   430: aconst_null
    //   431: astore 6
    //   433: iload_3
    //   434: istore_2
    //   435: aload 6
    //   437: invokestatic 168	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   440: aload 7
    //   442: invokestatic 234	com/facebook/internal/Utility:disconnectQuietly	(Ljava/net/URLConnection;)V
    //   445: aload_1
    //   446: astore 6
    //   448: aload 9
    //   450: astore_1
    //   451: iload_2
    //   452: ifeq +17 -> 469
    //   455: aload_0
    //   456: aload 6
    //   458: checkcast 238	java/lang/Exception
    //   461: aload_1
    //   462: checkcast 240	android/graphics/Bitmap
    //   465: iconst_0
    //   466: invokestatic 244	com/facebook/internal/ImageDownloader:issueResponse	(Lcom/facebook/internal/ImageDownloader$RequestKey;Ljava/lang/Exception;Landroid/graphics/Bitmap;Z)V
    //   469: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	paramRequestKey	RequestKey
    //   0	470	1	paramContext	Context
    //   12	440	2	i	int
    //   10	424	3	j	int
    //   54	119	4	k	int
    //   231	43	5	bool	boolean
    //   17	440	6	localObject1	Object
    //   41	400	7	localHttpURLConnection	java.net.HttpURLConnection
    //   1	409	8	localObject2	Object
    //   4	445	9	localObject3	Object
    //   7	346	10	localStringBuilder	StringBuilder
    //   120	179	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   91	100	202	java/lang/Throwable
    //   105	115	202	java/lang/Throwable
    //   127	138	202	java/lang/Throwable
    //   143	154	202	java/lang/Throwable
    //   157	161	202	java/lang/Throwable
    //   164	169	202	java/lang/Throwable
    //   169	181	202	java/lang/Throwable
    //   181	194	202	java/lang/Throwable
    //   91	100	209	java/io/IOException
    //   105	115	209	java/io/IOException
    //   127	138	209	java/io/IOException
    //   143	154	209	java/io/IOException
    //   157	161	209	java/io/IOException
    //   169	181	209	java/io/IOException
    //   181	194	209	java/io/IOException
    //   219	233	321	java/io/IOException
    //   238	243	321	java/io/IOException
    //   249	261	321	java/io/IOException
    //   291	307	321	java/io/IOException
    //   342	348	376	java/lang/Throwable
    //   342	348	383	java/io/IOException
    //   43	56	389	java/lang/Throwable
    //   80	87	389	java/lang/Throwable
    //   219	233	389	java/lang/Throwable
    //   238	243	389	java/lang/Throwable
    //   249	261	389	java/lang/Throwable
    //   266	273	389	java/lang/Throwable
    //   278	285	389	java/lang/Throwable
    //   291	307	389	java/lang/Throwable
    //   330	338	389	java/lang/Throwable
    //   43	56	396	java/io/IOException
    //   80	87	396	java/io/IOException
    //   330	338	396	java/io/IOException
    //   13	19	405	java/lang/Throwable
    //   19	36	405	java/lang/Throwable
    //   36	43	405	java/lang/Throwable
    //   19	36	426	java/io/IOException
  }
  
  public static void downloadAsync(ImageRequest paramImageRequest)
  {
    if (paramImageRequest == null) {
      return;
    }
    RequestKey localRequestKey = new RequestKey(paramImageRequest.getImageUri(), paramImageRequest.getCallerTag());
    Map localMap = pendingRequests;
    try
    {
      DownloaderContext localDownloaderContext = (DownloaderContext)pendingRequests.get(localRequestKey);
      if (localDownloaderContext != null)
      {
        request = paramImageRequest;
        isCancelled = false;
        workItem.moveToFront();
      }
      else
      {
        enqueueCacheRead(paramImageRequest, localRequestKey, paramImageRequest.isCachedRedirectAllowed());
      }
      return;
    }
    catch (Throwable paramImageRequest)
    {
      throw paramImageRequest;
    }
  }
  
  public static void enqueueCacheRead(ImageRequest paramImageRequest, RequestKey paramRequestKey, boolean paramBoolean)
  {
    enqueueRequest(paramImageRequest, paramRequestKey, cacheReadQueue, new CacheReadWorkItem(paramImageRequest.getContext(), paramRequestKey, paramBoolean));
  }
  
  public static void enqueueDownload(ImageRequest paramImageRequest, RequestKey paramRequestKey)
  {
    enqueueRequest(paramImageRequest, paramRequestKey, downloadQueue, new DownloadImageWorkItem(paramImageRequest.getContext(), paramRequestKey));
  }
  
  public static void enqueueRequest(ImageRequest paramImageRequest, RequestKey paramRequestKey, WorkQueue paramWorkQueue, Runnable paramRunnable)
  {
    Map localMap = pendingRequests;
    try
    {
      DownloaderContext localDownloaderContext = new DownloaderContext(null);
      request = paramImageRequest;
      pendingRequests.put(paramRequestKey, localDownloaderContext);
      workItem = paramWorkQueue.addActiveWorkItem(paramRunnable);
      return;
    }
    catch (Throwable paramImageRequest)
    {
      throw paramImageRequest;
    }
  }
  
  public static Handler getHandler()
  {
    try
    {
      if (handler == null) {
        handler = new Handler(Looper.getMainLooper());
      }
      Handler localHandler = handler;
      return localHandler;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static void issueResponse(RequestKey paramRequestKey, final Exception paramException, final Bitmap paramBitmap, final boolean paramBoolean)
  {
    paramRequestKey = removePendingRequest(paramRequestKey);
    if ((paramRequestKey != null) && (!isCancelled))
    {
      paramRequestKey = request;
      final ImageRequest.Callback localCallback = paramRequestKey.getCallback();
      if (localCallback != null) {
        getHandler().post(new Runnable()
        {
          public void run()
          {
            ImageResponse localImageResponse = new ImageResponse(val$request, paramException, paramBoolean, paramBitmap);
            localCallback.onCompleted(localImageResponse);
          }
        });
      }
    }
  }
  
  public static void prioritizeRequest(ImageRequest paramImageRequest)
  {
    Object localObject = new RequestKey(paramImageRequest.getImageUri(), paramImageRequest.getCallerTag());
    paramImageRequest = pendingRequests;
    try
    {
      localObject = (DownloaderContext)pendingRequests.get(localObject);
      if (localObject != null) {
        workItem.moveToFront();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static void readFromCache(RequestKey paramRequestKey, Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean)
    {
      localObject = UrlRedirectCache.getRedirectedUri(fileUri);
      if (localObject != null)
      {
        InputStream localInputStream2 = ImageResponseCache.getCachedImageStream((Uri)localObject, paramContext);
        InputStream localInputStream1 = localInputStream2;
        paramBoolean = bool;
        localObject = localInputStream1;
        if (localInputStream2 == null) {
          break label57;
        }
        paramBoolean = true;
        localObject = localInputStream1;
        break label57;
      }
    }
    Object localObject = null;
    paramBoolean = bool;
    label57:
    if (!paramBoolean) {
      localObject = ImageResponseCache.getCachedImageStream(fileUri, paramContext);
    }
    if (localObject != null)
    {
      paramContext = BitmapFactory.decodeStream((InputStream)localObject);
      Utility.closeQuietly((Closeable)localObject);
      issueResponse(paramRequestKey, null, paramContext, paramBoolean);
      return;
    }
    paramContext = removePendingRequest(paramRequestKey);
    if ((paramContext != null) && (!isCancelled)) {
      enqueueDownload(request, paramRequestKey);
    }
  }
  
  public static DownloaderContext removePendingRequest(RequestKey paramRequestKey)
  {
    Map localMap = pendingRequests;
    try
    {
      paramRequestKey = (DownloaderContext)pendingRequests.remove(paramRequestKey);
      return paramRequestKey;
    }
    catch (Throwable paramRequestKey)
    {
      throw paramRequestKey;
    }
  }
  
  private static class CacheReadWorkItem
    implements Runnable
  {
    public ImageDownloader.RequestKey Tracer;
    public boolean allowCachedRedirects;
    public Context context;
    
    public CacheReadWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey, boolean paramBoolean)
    {
      context = paramContext;
      Tracer = paramRequestKey;
      allowCachedRedirects = paramBoolean;
    }
    
    public void run()
    {
      ImageDownloader.readFromCache(Tracer, context, allowCachedRedirects);
    }
  }
  
  private static class DownloadImageWorkItem
    implements Runnable
  {
    public Context context;
    public ImageDownloader.RequestKey uri;
    
    public DownloadImageWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey)
    {
      context = paramContext;
      uri = paramRequestKey;
    }
    
    public void run()
    {
      ImageDownloader.download(uri, context);
    }
  }
  
  private static class DownloaderContext
  {
    public boolean isCancelled;
    public ImageRequest request;
    public WorkQueue.WorkItem workItem;
    
    public DownloaderContext() {}
  }
  
  private static class RequestKey
  {
    public static final int HASH_MULTIPLIER = 37;
    public static final int HASH_SEED = 29;
    public Object activity;
    public Uri fileUri;
    
    public RequestKey(Uri paramUri, Object paramObject)
    {
      fileUri = paramUri;
      activity = paramObject;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject != null) && ((paramObject instanceof RequestKey)))
      {
        paramObject = (RequestKey)paramObject;
        if ((fileUri == fileUri) && (activity == activity)) {
          return true;
        }
      }
      return false;
    }
    
    public int hashCode()
    {
      int i = fileUri.hashCode();
      return activity.hashCode() + (i + 1073) * 37;
    }
  }
}
