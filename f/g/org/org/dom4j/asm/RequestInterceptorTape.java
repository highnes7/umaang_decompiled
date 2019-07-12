package f.g.org.org.dom4j.asm;

import f.g.org.org.http.HttpRequest;
import java.io.IOException;

public class RequestInterceptorTape
  implements f.g.org.org.http.Object
{
  public RequestInterceptorTape(AnnotationVisitor paramAnnotationVisitor, f.g.org.org.http.Object paramObject) {}
  
  public void intercept(HttpRequest paramHttpRequest)
    throws IOException
  {
    f.g.org.org.http.Object localObject = c;
    if (localObject != null) {
      localObject.intercept(paramHttpRequest);
    }
    localObject = av.av.command;
    if (localObject != null) {
      localObject.intercept(paramHttpRequest);
    }
  }
}
