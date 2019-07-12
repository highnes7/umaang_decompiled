package f.g.org.org.org.network;

import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.LowLevelHttpRequest;
import java.io.InputStream;
import java.util.List;

public class NetHttpTransport
  extends HttpTransport
{
  public int connectionFactory;
  public List<String> hostnameVerifier;
  public InputStream proxy;
  public List<String> sslSocketFactory;
  
  public NetHttpTransport(int paramInt, InputStream paramInputStream, List paramList1, List paramList2)
  {
    connectionFactory = paramInt;
    proxy = paramInputStream;
    sslSocketFactory = paramList1;
    hostnameVerifier = paramList2;
  }
  
  public LowLevelHttpRequest buildRequest(String paramString1, String paramString2)
  {
    return new NetHttpRequest(proxy, connectionFactory, sslSocketFactory, hostnameVerifier);
  }
}
