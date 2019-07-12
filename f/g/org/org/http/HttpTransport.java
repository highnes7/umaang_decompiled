package f.g.org.org.http;

import f.g.b.a.c.F;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public abstract class HttpTransport
{
  public static final Logger LOGGER = Logger.getLogger(F.class.getName());
  public static final String[] SUPPORTED_METHODS = { "DELETE", "GET", "POST", "PUT" };
  
  static
  {
    Arrays.sort(SUPPORTED_METHODS);
  }
  
  public HttpTransport() {}
  
  public HttpRequest buildRequest()
  {
    return new HttpRequest(this, null);
  }
  
  public abstract LowLevelHttpRequest buildRequest(String paramString1, String paramString2)
    throws IOException;
  
  public final HttpRequestFactory createRequestFactory()
  {
    return createRequestFactory(null);
  }
  
  public final HttpRequestFactory createRequestFactory(AnnotationVisitor paramAnnotationVisitor)
  {
    return new HttpRequestFactory(this, paramAnnotationVisitor);
  }
  
  public void shutdown()
    throws IOException
  {}
  
  public boolean supportsMethod(String paramString)
    throws IOException
  {
    return Arrays.binarySearch(SUPPORTED_METHODS, paramString) >= 0;
  }
}
