package f.g.org.org.org.osmdroid.http;

import f.g.org.org.apache.http.MockLowLevelHttpRequest;
import f.g.org.org.apache.http.MockLowLevelHttpResponse;
import f.g.org.org.http.LowLevelHttpResponse;
import f.g.org.org.util.GenericData;
import java.io.IOException;

public class NetHttpRequest
  extends MockLowLevelHttpRequest
{
  public NetHttpRequest(HttpTransport paramHttpTransport, String paramString)
  {
    super(paramString);
  }
  
  public LowLevelHttpResponse execute()
    throws IOException
  {
    if (connection.transport != null) {
      return new MockLowLevelHttpResponse().setStatusCode(connection.transport.intValue()).setContent("Token Fetch Error");
    }
    if ("true".equals(getFirstHeaderValue("X-Google-Metadata-Request")))
    {
      Object localObject = new f.g.org.org.stream.Object();
      ((f.g.org.org.stream.Object)localObject).put(HttpTransport.INSTANCE);
      ((GenericData)localObject).put("access_token", connection.project);
      ((GenericData)localObject).put("expires_in", Integer.valueOf(3600000));
      ((GenericData)localObject).put("token_type", "Bearer");
      localObject = ((f.g.org.org.stream.Object)localObject).toPrettyString();
      return new MockLowLevelHttpResponse().setContentType("application/json; charset=UTF-8").setContent((String)localObject);
    }
    throw new IOException("Metadata request header not found.");
  }
}
