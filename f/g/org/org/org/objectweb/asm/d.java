package f.g.org.org.org.objectweb.asm;

import f.g.b.a.g.h;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.util.Item;

@h
public class d
{
  public final JsonFactory a;
  public final HttpTransport e;
  public String f = "https://www.googleapis.com/oauth2/v1/certs";
  public Item g = Item.g;
  
  public d(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
  {
    if (paramHttpTransport != null)
    {
      e = paramHttpTransport;
      if (paramJsonFactory != null)
      {
        a = paramJsonFactory;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public d a(Item paramItem)
  {
    if (paramItem != null)
    {
      g = paramItem;
      return this;
    }
    throw new NullPointerException();
  }
  
  public d a(String paramString)
  {
    if (paramString != null)
    {
      f = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final String a()
  {
    return f;
  }
  
  public final Item b()
  {
    return g;
  }
  
  public final JsonFactory c()
  {
    return a;
  }
  
  public final HttpTransport e()
  {
    return e;
  }
  
  public Log show()
  {
    return new Log(this);
  }
}
