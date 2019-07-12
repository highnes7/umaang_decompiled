package f.g.org.org.apache.http.cache;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.RequestDirector;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.protocol.HttpContext;

public class DefaultRequestDirector
  implements RequestDirector
{
  public DefaultRequestDirector(HttpRequest paramHttpRequest) {}
  
  public HttpResponse execute(HttpHost paramHttpHost, org.apache.http.HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    throws HttpException, IOException
  {
    return new BasicHttpResponse(HttpVersion.HTTP_1_1, log.contentLoggingLimit, null);
  }
}
