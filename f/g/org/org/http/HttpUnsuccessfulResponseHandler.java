package f.g.org.org.http;

import java.io.IOException;

public abstract interface HttpUnsuccessfulResponseHandler
{
  public abstract boolean handleResponse(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, boolean paramBoolean)
    throws IOException;
}
