package f.g.org.org.dom4j.util;

import f.g.b.a.g.h;

@h
public class HttpConnection
  extends HttpRequest
{
  public String address;
  public String source;
  
  public HttpConnection(String paramString)
  {
    super(paramString);
  }
  
  public Namespace get()
  {
    Namespace localNamespace = super.get();
    token = address;
    verifier = source;
    return localNamespace;
  }
}
