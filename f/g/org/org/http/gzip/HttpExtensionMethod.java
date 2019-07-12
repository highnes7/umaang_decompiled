package f.g.org.org.http.gzip;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;

public final class HttpExtensionMethod
  extends HttpEntityEnclosingRequestBase
{
  public final String methodName;
  
  public HttpExtensionMethod(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      methodName = paramString1;
      setURI(URI.create(paramString2));
      return;
    }
    throw new NullPointerException();
  }
  
  public String getMethod()
  {
    return methodName;
  }
}
