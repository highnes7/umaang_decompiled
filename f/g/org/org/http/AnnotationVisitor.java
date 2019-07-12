package f.g.org.org.http;

import java.io.IOException;

public abstract interface AnnotationVisitor
{
  public abstract void visit(HttpRequest paramHttpRequest)
    throws IOException;
}
