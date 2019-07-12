package f.g.org.org.dom4j.asm;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.UrlEncodedContent;
import f.g.org.org.util.Data;
import java.io.IOException;
import java.util.Map;

public final class Credential
  implements ResponseHandler
{
  public Credential() {}
  
  public static Map getData(HttpRequest paramHttpRequest)
  {
    return Data.mapOf(UrlEncodedContent.getContent(paramHttpRequest).getData());
  }
  
  public String handleResponse(HttpRequest paramHttpRequest)
  {
    paramHttpRequest = getData(paramHttpRequest).get("access_token");
    if (paramHttpRequest == null) {
      return null;
    }
    return paramHttpRequest.toString();
  }
  
  public void intercept(HttpRequest paramHttpRequest, String paramString)
    throws IOException
  {
    Preconditions.checkArgument("GET".equals(paramHttpRequest.getRequestMethod()) ^ true, "HTTP GET method is not supported");
    getData(paramHttpRequest).put("access_token", paramString);
  }
}
