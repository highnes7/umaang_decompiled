package f.g.org.org.org.osmdroid.api.util;

import f.g.b.a.b.i.a.b;
import f.g.b.a.g.h;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.org.internal.util.i;

@h
public class Element<T>
  extends b<T>
{
  public Element(i paramI, String paramString1, String paramString2, Object paramObject, Class paramClass)
  {
    super(paramI, paramString1, paramString2, paramObject, paramClass);
  }
  
  public Type equals()
  {
    return (Type)this$0;
  }
  
  public Element setAttribute(HttpHeaders paramHttpHeaders)
  {
    attributes = paramHttpHeaders;
    return this;
  }
  
  public Element setAttributes(boolean paramBoolean)
  {
    value = paramBoolean;
    return this;
  }
}
