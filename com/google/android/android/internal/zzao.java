package com.google.android.android.internal;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public final class zzao
  implements zzan
{
  public final zzap zzcc = null;
  public final SSLSocketFactory zzcd = null;
  
  public zzao()
  {
    this(null, null);
  }
  
  public zzao(zzap paramZzap)
  {
    this(null, null);
  }
  
  public zzao(zzap paramZzap, SSLSocketFactory paramSSLSocketFactory) {}
  
  public static HttpEntity entityFromConnection(HttpURLConnection paramHttpURLConnection)
  {
    BasicHttpEntity localBasicHttpEntity = new BasicHttpEntity();
    try
    {
      localInputStream = paramHttpURLConnection.getInputStream();
    }
    catch (IOException localIOException)
    {
      InputStream localInputStream;
      for (;;) {}
    }
    localInputStream = paramHttpURLConnection.getErrorStream();
    localBasicHttpEntity.setContent(localInputStream);
    localBasicHttpEntity.setContentLength(paramHttpURLConnection.getContentLength());
    localBasicHttpEntity.setContentEncoding(paramHttpURLConnection.getContentEncoding());
    localBasicHttpEntity.setContentType(paramHttpURLConnection.getContentType());
    return localBasicHttpEntity;
  }
  
  public static void setConnectionParametersForRequest(HttpURLConnection paramHttpURLConnection, Request paramRequest)
    throws IOException, AtomicBoolean
  {
    paramRequest = paramRequest.getPostBody();
    if (paramRequest != null)
    {
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.addRequestProperty("Content-Type", Request.getBodyContentType());
      paramHttpURLConnection = new DataOutputStream(paramHttpURLConnection.getOutputStream());
      paramHttpURLConnection.write(paramRequest);
      paramHttpURLConnection.close();
    }
  }
  
  public final HttpResponse performRequest(Request paramRequest, Map paramMap)
    throws IOException, AtomicBoolean
  {
    Object localObject1 = paramRequest.getUrl();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramRequest.getHeaders());
    localHashMap.putAll(paramMap);
    paramMap = zzcc;
    Object localObject2;
    if (paramMap != null)
    {
      localObject2 = paramMap.rewriteUrl((String)localObject1);
      paramMap = (Map)localObject2;
      if (localObject2 == null)
      {
        paramRequest = String.valueOf(localObject1);
        if (paramRequest.length() != 0) {
          paramRequest = "URL blocked by rewriter: ".concat(paramRequest);
        } else {
          paramRequest = new String("URL blocked by rewriter: ");
        }
        throw new IOException(paramRequest);
      }
    }
    else
    {
      paramMap = (Map)localObject1;
    }
    paramMap = new URL(paramMap);
    localObject1 = (HttpURLConnection)paramMap.openConnection();
    ((HttpURLConnection)localObject1).setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
    int i = paramRequest.getTimeoutMs();
    ((HttpURLConnection)localObject1).setConnectTimeout(i);
    ((HttpURLConnection)localObject1).setReadTimeout(i);
    ((HttpURLConnection)localObject1).setUseCaches(false);
    i = 1;
    ((HttpURLConnection)localObject1).setDoInput(true);
    "https".equals(paramMap.getProtocol());
    paramMap = localHashMap.keySet().iterator();
    while (paramMap.hasNext())
    {
      localObject2 = (String)paramMap.next();
      ((HttpURLConnection)localObject1).addRequestProperty((String)localObject2, (String)localHashMap.get(localObject2));
    }
    switch (paramRequest.getMethod())
    {
    default: 
      throw new IllegalStateException("Unknown method type.");
    case 7: 
      paramMap = "PATCH";
      break;
    case 6: 
      paramMap = "TRACE";
      break;
    case 5: 
      paramMap = "OPTIONS";
      break;
    case 4: 
      paramMap = "HEAD";
      break;
    case 3: 
      paramMap = "DELETE";
      break;
    case 2: 
      paramMap = "PUT";
      break;
    case 1: 
      paramMap = "POST";
      ((HttpURLConnection)localObject1).setRequestMethod(paramMap);
      setConnectionParametersForRequest((HttpURLConnection)localObject1, paramRequest);
      break;
    case 0: 
      paramMap = "GET";
      ((HttpURLConnection)localObject1).setRequestMethod(paramMap);
    }
    paramMap = new ProtocolVersion("HTTP", 1, 1);
    if (((HttpURLConnection)localObject1).getResponseCode() != -1)
    {
      localObject2 = new BasicStatusLine(paramMap, ((HttpURLConnection)localObject1).getResponseCode(), ((HttpURLConnection)localObject1).getResponseMessage());
      paramMap = new BasicHttpResponse((StatusLine)localObject2);
      int j = paramRequest.getMethod();
      int k = ((StatusLine)localObject2).getStatusCode();
      if ((j == 4) || ((100 <= k) && (k < 200)) || (k == 204) || (k == 304)) {
        i = 0;
      }
      if (i != 0) {
        paramMap.setEntity(entityFromConnection((HttpURLConnection)localObject1));
      }
      paramRequest = ((HttpURLConnection)localObject1).getHeaderFields().entrySet().iterator();
      while (paramRequest.hasNext())
      {
        localObject1 = (Map.Entry)paramRequest.next();
        if (((Map.Entry)localObject1).getKey() != null) {
          paramMap.addHeader(new BasicHeader((String)((Map.Entry)localObject1).getKey(), (String)((List)((Map.Entry)localObject1).getValue()).get(0)));
        }
      }
      return paramMap;
    }
    paramRequest = new IOException("Could not retrieve response code from HttpUrlConnection.");
    throw paramRequest;
  }
}
