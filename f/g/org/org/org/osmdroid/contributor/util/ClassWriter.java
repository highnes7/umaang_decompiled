package f.g.org.org.org.osmdroid.contributor.util;

import f.g.b.a.g.h;
import f.g.org.org.apache.http.MockHttpTransport;
import f.g.org.org.http.LowLevelHttpRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@h
public class ClassWriter
  extends MockHttpTransport
{
  public static final f.g.org.org.stream.JsonFactory h = new f.g.org.org.stream.util.JsonFactory();
  public static final String threshold = "urn:ietf:params:oauth:grant-type:jwt-bearer";
  public Map<String, String> b = new HashMap();
  public Map<String, String> c = new HashMap();
  public Map<String, String> m = new HashMap();
  
  public ClassWriter() {}
  
  public void a(String paramString1, String paramString2)
  {
    m.put(paramString1, paramString2);
  }
  
  public LowLevelHttpRequest buildRequest(String paramString1, String paramString2)
    throws IOException
  {
    if (paramString2.equals("https://accounts.google.com/o/oauth2/token")) {
      return new HttpRequest(this, paramString2);
    }
    return super.buildRequest(paramString1, paramString2);
  }
  
  public void c(String paramString1, String paramString2)
  {
    c.put(paramString1, paramString2);
  }
  
  public void put(String paramString1, String paramString2)
  {
    b.put(paramString1, paramString2);
  }
}
