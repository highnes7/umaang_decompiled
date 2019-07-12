package f.g.org.org.apache.http;

import f.g.b.a.g.h;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpUnsuccessfulResponseHandler;
import java.io.IOException;

@h
public class MockHttpUnsuccessfulResponseHandler
  implements HttpUnsuccessfulResponseHandler
{
  public boolean isCalled;
  public boolean successfullyHandleResponse;
  
  public MockHttpUnsuccessfulResponseHandler(boolean paramBoolean)
  {
    successfullyHandleResponse = paramBoolean;
  }
  
  public boolean handleResponse(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, boolean paramBoolean)
    throws IOException
  {
    isCalled = true;
    return successfullyHandleResponse;
  }
  
  public boolean isCalled()
  {
    return isCalled;
  }
}
