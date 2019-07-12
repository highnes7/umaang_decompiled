package f.g.org.org.org.internal;

import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpResponseInterceptor;
import java.io.IOException;

public class b
  implements HttpResponseInterceptor
{
  public b(Element paramElement, HttpResponseInterceptor paramHttpResponseInterceptor, HttpRequest paramHttpRequest) {}
  
  public void close(HttpResponse paramHttpResponse)
    throws IOException
  {
    HttpResponseInterceptor localHttpResponseInterceptor = c;
    if (localHttpResponseInterceptor != null) {
      localHttpResponseInterceptor.close(paramHttpResponse);
    }
    if (!paramHttpResponse.isSuccessStatusCode())
    {
      if (!b.getThrowExceptionOnExecuteError()) {
        return;
      }
      throw a.add(paramHttpResponse);
    }
  }
}
