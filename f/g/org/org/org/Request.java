package f.g.org.org.org;

import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.EmptyContent;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.UrlEncodedContent;
import java.io.IOException;
import java.util.AbstractMap;

public final class Request
  implements f.g.org.org.http.Object, AnnotationVisitor
{
  public static final int MARK_LIMIT_BYTES = 2048;
  public static final String stableKey = "X-HTTP-Method-Override";
  public final boolean optimize;
  
  public Request()
  {
    optimize = false;
  }
  
  public Request(boolean paramBoolean)
  {
    optimize = paramBoolean;
  }
  
  private boolean execute(HttpRequest paramHttpRequest)
    throws IOException
  {
    String str = paramHttpRequest.getRequestMethod();
    if (str.equals("POST")) {
      return false;
    }
    if (str.equals("GET"))
    {
      if (paramHttpRequest.getUrl().build().length() > 2048) {
        return true;
      }
    }
    else if (optimize) {
      return true;
    }
    return paramHttpRequest.getTransport().supportsMethod(str) ^ true;
  }
  
  public void intercept(HttpRequest paramHttpRequest)
    throws IOException
  {
    if (execute(paramHttpRequest))
    {
      String str = paramHttpRequest.getRequestMethod();
      paramHttpRequest.setRequestMethod("POST");
      paramHttpRequest.getHeaders().clone("X-HTTP-Method-Override", str);
      if (str.equals("GET"))
      {
        paramHttpRequest.setContent(new UrlEncodedContent(paramHttpRequest.getUrl().clone()));
        paramHttpRequest.getUrl().clear();
        return;
      }
      if (paramHttpRequest.getContent() == null) {
        paramHttpRequest.setContent(new EmptyContent());
      }
    }
  }
  
  public void visit(HttpRequest paramHttpRequest)
  {
    paramHttpRequest.setInterceptor(this);
  }
}
