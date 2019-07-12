package f.g.org.org.dom4j.asm;

import f.g.org.org.http.HttpRequest;
import java.io.IOException;

public class AnnotationVisitor
  implements f.g.org.org.http.AnnotationVisitor
{
  public AnnotationVisitor(Buffer paramBuffer) {}
  
  public void visit(HttpRequest paramHttpRequest)
    throws IOException
  {
    f.g.org.org.http.AnnotationVisitor localAnnotationVisitor = av.av;
    if (localAnnotationVisitor != null) {
      localAnnotationVisitor.visit(paramHttpRequest);
    }
    paramHttpRequest.setInterceptor(new RequestInterceptorTape(this, paramHttpRequest.getInterceptor()));
  }
}
