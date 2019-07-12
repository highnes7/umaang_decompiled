package f.g.org.org.dom4j.asm;

import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.util.GenericData;
import java.io.IOException;

public final class BasicResponseHandler
  implements ResponseHandler
{
  public BasicResponseHandler() {}
  
  public String handleResponse(HttpRequest paramHttpRequest)
  {
    paramHttpRequest = paramHttpRequest.getUrl().get("access_token");
    if (paramHttpRequest == null) {
      return null;
    }
    return paramHttpRequest.toString();
  }
  
  public void intercept(HttpRequest paramHttpRequest, String paramString)
    throws IOException
  {
    paramHttpRequest.getUrl().clone("access_token", paramString);
  }
}
