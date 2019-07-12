package f.g.org.org.org.network;

import f.g.org.org.http.HttpRequest;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Token
  implements f.g.org.org.http.Object
{
  public f.g.org.org.http.Object value;
  
  public Token(f paramF, f.g.org.org.http.Object paramObject)
  {
    value = paramObject;
  }
  
  public void intercept(HttpRequest paramHttpRequest)
    throws IOException
  {
    Object localObject = value;
    if (localObject != null) {
      ((f.g.org.org.http.Object)localObject).intercept(paramHttpRequest);
    }
    paramHttpRequest = name.c.iterator();
    while (paramHttpRequest.hasNext())
    {
      localObject = (Item)paramHttpRequest.next();
      f.g.org.org.http.Object localObject1 = request.getInterceptor();
      if (localObject1 != null) {
        localObject1.intercept(request);
      }
    }
  }
}
