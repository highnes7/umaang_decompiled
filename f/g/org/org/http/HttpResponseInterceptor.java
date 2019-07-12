package f.g.org.org.http;

import java.io.IOException;

public abstract interface HttpResponseInterceptor
{
  public abstract void close(HttpResponse paramHttpResponse)
    throws IOException;
}
