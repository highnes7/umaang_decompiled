package f.g.org.org.http;

import java.io.IOException;
import java.io.InputStream;

public abstract class LowLevelHttpResponse
{
  public LowLevelHttpResponse() {}
  
  public void disconnect()
    throws IOException
  {}
  
  public abstract InputStream getContent()
    throws IOException;
  
  public abstract String getContentEncoding()
    throws IOException;
  
  public abstract long getContentLength()
    throws IOException;
  
  public abstract String getContentType()
    throws IOException;
  
  public abstract int getHeaderCount()
    throws IOException;
  
  public abstract String getHeaderName(int paramInt)
    throws IOException;
  
  public abstract String getHeaderValue(int paramInt)
    throws IOException;
  
  public abstract String getReasonPhrase()
    throws IOException;
  
  public abstract int getStatusCode()
    throws IOException;
  
  public abstract String getStatusLine()
    throws IOException;
}
