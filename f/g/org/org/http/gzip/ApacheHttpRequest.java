package f.g.org.org.http.gzip;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.LowLevelHttpRequest;
import f.g.org.org.http.LowLevelHttpResponse;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class ApacheHttpRequest
  extends LowLevelHttpRequest
{
  public final HttpClient httpClient;
  public final HttpRequestBase request;
  
  public ApacheHttpRequest(HttpClient paramHttpClient, HttpRequestBase paramHttpRequestBase)
  {
    httpClient = paramHttpClient;
    request = paramHttpRequestBase;
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    request.addHeader(paramString1, paramString2);
  }
  
  public LowLevelHttpResponse execute()
    throws IOException
  {
    if (getStreamingContent() != null)
    {
      localObject = request;
      Preconditions.checkArgument(localObject instanceof HttpEntityEnclosingRequest, "Apache HTTP client does not support %s requests with content.", new Object[] { ((HttpRequestBase)localObject).getRequestLine().getMethod() });
      localObject = new InputStreamEntity(getContentLength(), getStreamingContent());
      ((AbstractHttpEntity)localObject).setContentEncoding(getContentEncoding());
      ((AbstractHttpEntity)localObject).setContentType(getContentType());
      ((HttpEntityEnclosingRequest)request).setEntity((HttpEntity)localObject);
    }
    Object localObject = request;
    return new ApacheHttpResponse((HttpRequestBase)localObject, httpClient.execute((HttpUriRequest)localObject));
  }
  
  public void setTimeout(int paramInt1, int paramInt2)
    throws IOException
  {
    HttpParams localHttpParams = request.getParams();
    ConnManagerParams.setTimeout(localHttpParams, paramInt1);
    HttpConnectionParams.setConnectionTimeout(localHttpParams, paramInt1);
    HttpConnectionParams.setSoTimeout(localHttpParams, paramInt2);
  }
}
