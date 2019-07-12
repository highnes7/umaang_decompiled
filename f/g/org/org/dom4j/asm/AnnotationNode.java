package f.g.org.org.dom4j.asm;

import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.UrlEncodedContent;
import f.g.org.org.util.Data;
import java.io.IOException;
import java.util.Map;

public class AnnotationNode
  implements AnnotationVisitor, f.g.org.org.http.Object
{
  public final String value;
  public final String values;
  
  public AnnotationNode(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      values = paramString1;
      value = paramString2;
      return;
    }
    throw new NullPointerException();
  }
  
  public void intercept(HttpRequest paramHttpRequest)
    throws IOException
  {
    paramHttpRequest = Data.mapOf(UrlEncodedContent.getContent(paramHttpRequest).getData());
    paramHttpRequest.put("client_id", values);
    String str = value;
    if (str != null) {
      paramHttpRequest.put("client_secret", str);
    }
  }
  
  public final String visit()
  {
    return value;
  }
  
  public void visit(HttpRequest paramHttpRequest)
    throws IOException
  {
    paramHttpRequest.setInterceptor(this);
  }
  
  public final String visitEnum()
  {
    return values;
  }
}
