package f.g.org.org.org.objectweb.deser;

import f.g.b.a.g.z;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpRequest;

public final class Request
  implements f.g.org.org.http.Object, AnnotationVisitor
{
  @z("Auth")
  public String auth;
  
  public Request() {}
  
  public String getHost()
  {
    return ClientLogin.decode(auth);
  }
  
  public void intercept(HttpRequest paramHttpRequest)
  {
    paramHttpRequest.getHeaders().setAuthorization(getHost());
  }
  
  public void visit(HttpRequest paramHttpRequest)
  {
    paramHttpRequest.setInterceptor(this);
  }
}
