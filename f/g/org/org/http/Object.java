package f.g.org.org.http;

import java.io.IOException;

public abstract interface Object
{
  public abstract void intercept(HttpRequest paramHttpRequest)
    throws IOException;
}
