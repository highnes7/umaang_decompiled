package f.g.org.org.http.gzip;

import f.g.org.org.http.LowLevelHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.AbstractExecutionAwareRequest;
import org.apache.http.client.methods.HttpRequestBase;

public final class ApacheHttpResponse
  extends LowLevelHttpResponse
{
  public final Header[] allHeaders;
  public final HttpRequestBase request;
  public final HttpResponse response;
  
  public ApacheHttpResponse(HttpRequestBase paramHttpRequestBase, HttpResponse paramHttpResponse)
  {
    request = paramHttpRequestBase;
    response = paramHttpResponse;
    allHeaders = paramHttpResponse.getAllHeaders();
  }
  
  public void disconnect()
  {
    ((AbstractExecutionAwareRequest)request).abort();
  }
  
  public InputStream getContent()
    throws IOException
  {
    HttpEntity localHttpEntity = response.getEntity();
    if (localHttpEntity == null) {
      return null;
    }
    return localHttpEntity.getContent();
  }
  
  public String getContentEncoding()
  {
    Object localObject = response.getEntity();
    if (localObject != null)
    {
      localObject = ((HttpEntity)localObject).getContentEncoding();
      if (localObject != null) {
        return ((Header)localObject).getValue();
      }
    }
    return null;
  }
  
  public long getContentLength()
  {
    HttpEntity localHttpEntity = response.getEntity();
    if (localHttpEntity == null) {
      return -1L;
    }
    return localHttpEntity.getContentLength();
  }
  
  public String getContentType()
  {
    Object localObject = response.getEntity();
    if (localObject != null)
    {
      localObject = ((HttpEntity)localObject).getContentType();
      if (localObject != null) {
        return ((Header)localObject).getValue();
      }
    }
    return null;
  }
  
  public int getHeaderCount()
  {
    return allHeaders.length;
  }
  
  public String getHeaderName(int paramInt)
  {
    return allHeaders[paramInt].getName();
  }
  
  public String getHeaderValue(int paramInt)
  {
    return allHeaders[paramInt].getValue();
  }
  
  public String getHeaderValue(String paramString)
  {
    return response.getLastHeader(paramString).getValue();
  }
  
  public String getReasonPhrase()
  {
    StatusLine localStatusLine = response.getStatusLine();
    if (localStatusLine == null) {
      return null;
    }
    return localStatusLine.getReasonPhrase();
  }
  
  public int getStatusCode()
  {
    StatusLine localStatusLine = response.getStatusLine();
    if (localStatusLine == null) {
      return 0;
    }
    return localStatusLine.getStatusCode();
  }
  
  public String getStatusLine()
  {
    StatusLine localStatusLine = response.getStatusLine();
    if (localStatusLine == null) {
      return null;
    }
    return localStatusLine.toString();
  }
}
