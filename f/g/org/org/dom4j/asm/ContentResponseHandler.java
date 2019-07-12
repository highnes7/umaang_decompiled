package f.g.org.org.dom4j.asm;

import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpRequest;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public final class ContentResponseHandler
  implements ResponseHandler
{
  public static final String a = "Bearer ";
  
  public ContentResponseHandler() {}
  
  public String handleResponse(HttpRequest paramHttpRequest)
  {
    paramHttpRequest = paramHttpRequest.getHeaders().getAuthorizationAsList();
    if (paramHttpRequest != null)
    {
      paramHttpRequest = paramHttpRequest.iterator();
      while (paramHttpRequest.hasNext())
      {
        String str = (String)paramHttpRequest.next();
        if (str.startsWith("Bearer ")) {
          return str.substring(7);
        }
      }
    }
    return null;
  }
  
  public void intercept(HttpRequest paramHttpRequest, String paramString)
    throws IOException
  {
    HttpHeaders localHttpHeaders = paramHttpRequest.getHeaders();
    paramHttpRequest = String.valueOf(paramString);
    if (paramHttpRequest.length() != 0) {
      paramHttpRequest = "Bearer ".concat(paramHttpRequest);
    } else {
      paramHttpRequest = new String("Bearer ");
    }
    localHttpHeaders.setAuthorization(paramHttpRequest);
  }
}
