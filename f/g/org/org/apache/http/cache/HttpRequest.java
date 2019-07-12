package f.g.org.org.apache.http.cache;

import f.g.b.a.g.h;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

@h
public class HttpRequest
  extends DefaultHttpClient
{
  public int contentLoggingLimit;
  
  public HttpRequest() {}
  
  public RequestDirector createClientRequestDirector(HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectHandler paramRedirectHandler, AuthenticationHandler paramAuthenticationHandler1, AuthenticationHandler paramAuthenticationHandler2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams)
  {
    return new DefaultRequestDirector(this);
  }
  
  public final int getContentLoggingLimit()
  {
    return contentLoggingLimit;
  }
  
  public HttpRequest setContentLoggingLimit(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    contentLoggingLimit = paramInt;
    return this;
  }
}
