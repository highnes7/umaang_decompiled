package f.g.org.org.apache.http;

import f.g.b.a.g.h;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.LowLevelHttpRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

@h
public class MockHttpTransport
  extends HttpTransport
{
  public MockLowLevelHttpRequest lowLevelHttpRequest;
  public MockLowLevelHttpResponse lowLevelHttpResponse;
  public Set<String> supportedMethods;
  
  public MockHttpTransport() {}
  
  public MockHttpTransport(Builder paramBuilder)
  {
    supportedMethods = supportedMethods;
    lowLevelHttpRequest = lowLevelHttpRequest;
    lowLevelHttpResponse = lowLevelHttpResponse;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public LowLevelHttpRequest buildRequest(String paramString1, String paramString2)
    throws IOException
  {
    Preconditions.checkArgument(supportsMethod(paramString1), "HTTP method %s not supported", new Object[] { paramString1 });
    paramString1 = lowLevelHttpRequest;
    if (paramString1 != null) {
      return paramString1;
    }
    paramString1 = new MockLowLevelHttpRequest(paramString2);
    paramString2 = lowLevelHttpResponse;
    if (paramString2 != null) {
      paramString1.setResponse(paramString2);
    }
    return paramString1;
  }
  
  public final MockLowLevelHttpRequest getLowLevelHttpRequest()
  {
    return lowLevelHttpRequest;
  }
  
  public final Set getSupportedMethods()
  {
    Set localSet = supportedMethods;
    if (localSet == null) {
      return null;
    }
    return Collections.unmodifiableSet(localSet);
  }
  
  public boolean supportsMethod(String paramString)
    throws IOException
  {
    Set localSet = supportedMethods;
    return (localSet == null) || (localSet.contains(paramString));
  }
  
  @h
  public class Builder
  {
    public MockLowLevelHttpRequest lowLevelHttpRequest;
    public MockLowLevelHttpResponse lowLevelHttpResponse;
    public Set<String> supportedMethods;
    
    public Builder() {}
    
    public MockHttpTransport build()
    {
      return new MockHttpTransport(this);
    }
    
    public final MockLowLevelHttpRequest getLowLevelHttpRequest()
    {
      return lowLevelHttpRequest;
    }
    
    public MockLowLevelHttpResponse getLowLevelHttpResponse()
    {
      return lowLevelHttpResponse;
    }
    
    public final Set getSupportedMethods()
    {
      return supportedMethods;
    }
    
    public final Builder setLowLevelHttpRequest(MockLowLevelHttpRequest paramMockLowLevelHttpRequest)
    {
      boolean bool;
      if (lowLevelHttpResponse == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Cannnot set a low level HTTP request when a low level HTTP response has been set.");
      lowLevelHttpRequest = paramMockLowLevelHttpRequest;
      return this;
    }
    
    public final Builder setLowLevelHttpResponse(MockLowLevelHttpResponse paramMockLowLevelHttpResponse)
    {
      boolean bool;
      if (lowLevelHttpRequest == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Cannot set a low level HTTP response when a low level HTTP request has been set.");
      lowLevelHttpResponse = paramMockLowLevelHttpResponse;
      return this;
    }
    
    public final Builder setSupportedMethods(Set paramSet)
    {
      supportedMethods = paramSet;
      return this;
    }
  }
}
