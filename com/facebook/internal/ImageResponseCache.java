package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageResponseCache
{
  public static final String CACHE = "ImageResponseCache";
  public static volatile FileLruCache imageCache;
  
  public ImageResponseCache() {}
  
  public static void clearCache(Context paramContext)
  {
    try
    {
      getCache(paramContext).clearCache();
      return;
    }
    catch (IOException paramContext)
    {
      LoggingBehavior localLoggingBehavior = LoggingBehavior.CACHE;
      String str = CACHE;
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("clearCache failed ");
      localStringBuilder.append(paramContext.getMessage());
      Logger.e(localLoggingBehavior, 5, str, localStringBuilder.toString());
    }
  }
  
  public static FileLruCache getCache(Context paramContext)
    throws IOException
  {
    try
    {
      if (imageCache == null) {
        imageCache = new FileLruCache(CACHE, new FileLruCache.Limits());
      }
      paramContext = imageCache;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static InputStream getCachedImageStream(Uri paramUri, Context paramContext)
  {
    if ((paramUri != null) && (isCDNURL(paramUri))) {
      try
      {
        paramUri = getCache(paramContext).getFile(paramUri.toString());
        return paramUri;
      }
      catch (IOException paramUri)
      {
        Logger.e(LoggingBehavior.CACHE, 5, CACHE, paramUri.toString());
      }
    }
    return null;
  }
  
  public static InputStream interceptAndCacheImageStream(Context paramContext, HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    Object localObject;
    InputStream localInputStream;
    if (paramHttpURLConnection.getResponseCode() == 200)
    {
      localObject = Uri.parse(paramHttpURLConnection.getURL().toString());
      localInputStream = paramHttpURLConnection.getInputStream();
    }
    try
    {
      boolean bool = isCDNURL((Uri)localObject);
      if (!bool) {
        return localInputStream;
      }
      paramContext = getCache(paramContext);
      localObject = ((Uri)localObject).toString();
      paramContext = paramContext.interceptAndPut((String)localObject, new BufferedHttpInputStream(localInputStream, paramHttpURLConnection));
      return paramContext;
    }
    catch (IOException paramContext) {}
    return null;
    return localInputStream;
  }
  
  public static boolean isCDNURL(Uri paramUri)
  {
    if (paramUri != null)
    {
      paramUri = paramUri.getHost();
      if (paramUri.endsWith("fbcdn.net")) {
        return true;
      }
      if ((paramUri.startsWith("fbcdn")) && (paramUri.endsWith("akamaihd.net"))) {
        return true;
      }
    }
    return false;
  }
  
  private static class BufferedHttpInputStream
    extends BufferedInputStream
  {
    public HttpURLConnection connection;
    
    public BufferedHttpInputStream(InputStream paramInputStream, HttpURLConnection paramHttpURLConnection)
    {
      super(8192);
      connection = paramHttpURLConnection;
    }
    
    public void close()
      throws IOException
    {
      super.close();
      Utility.disconnectQuietly(connection);
    }
  }
}
