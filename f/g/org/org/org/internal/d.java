package f.g.org.org.org.internal;

import f.g.org.org.util.GenericData;
import java.io.IOException;

public class d
  implements c
{
  public final String c;
  public final String d;
  
  public d()
  {
    this(null);
  }
  
  public d(String paramString)
  {
    c = paramString;
    d = null;
  }
  
  public d(String paramString1, String paramString2)
  {
    c = paramString1;
    d = paramString2;
  }
  
  public void a(Element paramElement)
    throws IOException
  {
    String str = c;
    if (str != null) {
      paramElement.put("key", str);
    }
    str = d;
    if (str != null) {
      paramElement.put("userIp", str);
    }
  }
  
  public final String c()
  {
    return c;
  }
  
  public final String e()
  {
    return d;
  }
}
