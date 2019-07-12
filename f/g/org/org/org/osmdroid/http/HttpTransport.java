package f.g.org.org.org.osmdroid.http;

import f.g.b.a.g.h;
import f.g.org.org.apache.http.MockHttpTransport;
import f.g.org.org.http.LowLevelHttpRequest;
import java.io.IOException;

@h
public class HttpTransport
  extends MockHttpTransport
{
  public static final f.g.org.org.stream.JsonFactory INSTANCE = new f.g.org.org.stream.util.JsonFactory();
  public static final String LOGGER = "http://metadata/computeMetadata/v1/instance/service-accounts/default/token";
  public static final String PAGE_KEY = "http://metadata.google.internal";
  public String project;
  public Integer transport;
  
  public HttpTransport(String paramString)
  {
    project = paramString;
  }
  
  public LowLevelHttpRequest buildRequest(String paramString1, String paramString2)
    throws IOException
  {
    if (paramString2.equals("http://metadata/computeMetadata/v1/instance/service-accounts/default/token")) {
      return new NetHttpRequest(this, paramString2);
    }
    if (paramString2.equals("http://metadata.google.internal")) {
      return new HttpRequest(this, paramString2);
    }
    return super.buildRequest(paramString1, paramString2);
  }
  
  public void disconnect(Integer paramInteger)
  {
    transport = paramInteger;
  }
}
