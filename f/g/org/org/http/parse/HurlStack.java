package f.g.org.org.http.parse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public class HurlStack
  implements ConnectionFactory
{
  public final Proxy proxy;
  
  public HurlStack()
  {
    proxy = null;
  }
  
  public HurlStack(Proxy paramProxy)
  {
    proxy = paramProxy;
  }
  
  public HttpURLConnection openConnection(URL paramURL)
    throws IOException
  {
    Proxy localProxy = proxy;
    if (localProxy == null) {
      paramURL = paramURL.openConnection();
    } else {
      paramURL = paramURL.openConnection(localProxy);
    }
    return (HttpURLConnection)paramURL;
  }
}
