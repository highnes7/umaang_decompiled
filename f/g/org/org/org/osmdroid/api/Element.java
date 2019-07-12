package f.g.org.org.org.osmdroid.api;

import f.g.b.a.b.i.c;
import f.g.b.a.g.h;
import f.g.org.org.http.HttpContent;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.org.internal.f;

@h
public class Element<T>
  extends c<T>
{
  public Element(f paramF, String paramString1, String paramString2, HttpContent paramHttpContent, Class paramClass)
  {
    super(paramF, paramString1, paramString2, paramHttpContent, paramClass);
  }
  
  public Element clone(String paramString, Object paramObject)
  {
    return (Element)super.clone(paramString, paramObject);
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
