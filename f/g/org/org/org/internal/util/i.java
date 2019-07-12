package f.g.org.org.org.internal.util;

import f.g.org.org.org.internal.f;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.JsonObjectParser;

public abstract class i
  extends f
{
  public i(h paramH)
  {
    super(paramH);
  }
  
  public JsonObjectParser e()
  {
    return (JsonObjectParser)j;
  }
  
  public final JsonFactory getJsonFactory()
  {
    return e().getJsonFactory();
  }
}
