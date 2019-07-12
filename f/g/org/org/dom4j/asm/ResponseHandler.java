package f.g.org.org.dom4j.asm;

import f.g.org.org.http.HttpRequest;
import java.io.IOException;

public abstract interface ResponseHandler
{
  public abstract String handleResponse(HttpRequest paramHttpRequest);
  
  public abstract void intercept(HttpRequest paramHttpRequest, String paramString)
    throws IOException;
}
