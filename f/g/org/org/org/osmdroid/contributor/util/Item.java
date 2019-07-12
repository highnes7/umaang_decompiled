package f.g.org.org.org.osmdroid.contributor.util;

import f.g.b.a.g.h;
import f.g.org.org.apache.http.MockHttpTransport;
import f.g.org.org.apache.http.MockHttpTransport.Builder;
import f.g.org.org.apache.http.MockLowLevelHttpRequest;
import f.g.org.org.apache.http.MockLowLevelHttpResponse;
import f.g.org.org.org.objectweb.asm.f;

@h
public class Item
  extends f
{
  public static final String DUE_DATE_FORMAT = "access_xyz";
  public static final String b = "{\"access_token\": \"%s\", \"expires_in\":  %s, \"refresh_token\": \"%s\", \"token_type\": \"%s\"}";
  public static final String d = "Bearer";
  public static final String description = String.format("{\"access_token\": \"%s\", \"expires_in\":  %s, \"refresh_token\": \"%s\", \"token_type\": \"%s\"}", new Object[] { "access_xyz", "3600", "refresh123", "Bearer" });
  public static final String g = "refresh123";
  public static final String strVal2 = "3600";
  
  public Item(i paramI)
  {
    super(paramI);
  }
  
  public static MockHttpTransport build()
  {
    Object localObject = new MockLowLevelHttpResponse().setContentType("application/json; charset=UTF-8").setContent(description);
    localObject = new MockLowLevelHttpRequest().setResponse((MockLowLevelHttpResponse)localObject);
    return new MockHttpTransport.Builder().setLowLevelHttpRequest((MockLowLevelHttpRequest)localObject).build();
  }
}
