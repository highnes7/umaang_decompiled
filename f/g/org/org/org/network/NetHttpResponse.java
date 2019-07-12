package f.g.org.org.org.network;

import f.g.org.org.http.LowLevelHttpResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class NetHttpResponse
  extends LowLevelHttpResponse
{
  public InputStream content;
  public List<String> headerNames = new ArrayList();
  public List<String> headerValues = new ArrayList();
  public int responseCode;
  
  public NetHttpResponse(InputStream paramInputStream, int paramInt, List paramList1, List paramList2)
  {
    content = paramInputStream;
    responseCode = paramInt;
    headerNames = paramList1;
    headerValues = paramList2;
  }
  
  public InputStream getContent()
  {
    return content;
  }
  
  public String getContentEncoding()
  {
    return null;
  }
  
  public long getContentLength()
  {
    return 0L;
  }
  
  public String getContentType()
  {
    return null;
  }
  
  public int getHeaderCount()
  {
    return headerNames.size();
  }
  
  public String getHeaderName(int paramInt)
  {
    return (String)headerNames.get(paramInt);
  }
  
  public String getHeaderValue(int paramInt)
  {
    return (String)headerValues.get(paramInt);
  }
  
  public String getReasonPhrase()
  {
    return null;
  }
  
  public int getStatusCode()
  {
    return responseCode;
  }
  
  public String getStatusLine()
  {
    return null;
  }
}
