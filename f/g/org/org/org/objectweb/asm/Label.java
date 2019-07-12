package f.g.org.org.org.objectweb.asm;

import f.g.b.a.g.h;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.util.Item;
import java.util.Collection;

@h
public class Label
  extends f.g.org.org.dom4j.tree.Label
{
  public Log d;
  
  public Label(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
  {
    this(new Log(paramHttpTransport, paramJsonFactory));
  }
  
  public Label(Log paramLog)
  {
    if (paramLog != null)
    {
      d = paramLog;
      a("accounts.google.com");
      return;
    }
    throw new NullPointerException();
  }
  
  public Label a(long paramLong)
  {
    super.a(paramLong);
    return (Label)this;
  }
  
  public Label a(Item paramItem)
  {
    if (paramItem != null)
    {
      g = paramItem;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Label a(String paramString)
  {
    a = paramString;
    return this;
  }
  
  public Label a(Collection paramCollection)
  {
    audience = paramCollection;
    return this;
  }
  
  public Label b(String paramString)
  {
    d = new d(e(), getText()).a(paramString).a(d.b()).show();
    return this;
  }
  
  public final Log b()
  {
    return d;
  }
  
  public final String d()
  {
    return d.d();
  }
  
  public final HttpTransport e()
  {
    return d.log();
  }
  
  public final JsonFactory getText()
  {
    return d.getText();
  }
  
  public Record setIcon()
  {
    return new Record(this);
  }
}
