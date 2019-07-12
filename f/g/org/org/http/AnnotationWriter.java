package f.g.org.org.http;

import java.io.IOException;

public final class AnnotationWriter
  implements AnnotationVisitor, Object
{
  public final String a;
  public final String b;
  
  public AnnotationWriter(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      a = paramString1;
      if (paramString2 != null)
      {
        b = paramString2;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public String a()
  {
    return a;
  }
  
  public void intercept(HttpRequest paramHttpRequest)
    throws IOException
  {
    paramHttpRequest.getHeaders().setBasicAuthentication(a, b);
  }
  
  public String put()
  {
    return b;
  }
  
  public void visit(HttpRequest paramHttpRequest)
    throws IOException
  {
    paramHttpRequest.setInterceptor(this);
  }
}
