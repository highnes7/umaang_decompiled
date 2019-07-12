package f.g.org.org.org.network.services;

import f.g.b.a.b.c.a;
import f.g.b.a.b.f.b;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.org.parser.Comment;
import f.g.org.org.org.parser.Element;
import java.io.IOException;

public abstract class Request<T>
  implements a<T, b>
{
  public Request() {}
  
  public final void onSuccess(Comment paramComment, HttpHeaders paramHttpHeaders)
    throws IOException
  {
    onSuccess(paramComment.parse(), paramHttpHeaders);
  }
  
  public abstract void onSuccess(Element paramElement, HttpHeaders paramHttpHeaders)
    throws IOException;
}
