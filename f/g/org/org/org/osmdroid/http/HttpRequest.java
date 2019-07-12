package f.g.org.org.org.osmdroid.http;

import f.g.org.org.apache.http.MockLowLevelHttpRequest;
import f.g.org.org.apache.http.MockLowLevelHttpResponse;
import f.g.org.org.http.LowLevelHttpResponse;

public class HttpRequest
  extends MockLowLevelHttpRequest
{
  public HttpRequest(HttpTransport paramHttpTransport, String paramString)
  {
    super(paramString);
  }
  
  public LowLevelHttpResponse execute()
  {
    MockLowLevelHttpResponse localMockLowLevelHttpResponse = new MockLowLevelHttpResponse();
    localMockLowLevelHttpResponse.addHeader("Metadata-Flavor", "Google");
    return localMockLowLevelHttpResponse;
  }
}
