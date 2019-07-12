package f.g.org.org.org.network;

import f.g.org.org.http.LowLevelHttpRequest;
import f.g.org.org.http.LowLevelHttpResponse;
import java.io.InputStream;
import java.util.List;

public class NetHttpRequest
  extends LowLevelHttpRequest
{
  public InputStream b;
  public List<String> connection;
  public int first;
  public List<String> queue;
  
  public NetHttpRequest(InputStream paramInputStream, int paramInt, List paramList1, List paramList2)
  {
    b = paramInputStream;
    first = paramInt;
    queue = paramList1;
    connection = paramList2;
  }
  
  public void addHeader(String paramString1, String paramString2) {}
  
  public LowLevelHttpResponse execute()
  {
    return new NetHttpResponse(b, first, queue, connection);
  }
}
