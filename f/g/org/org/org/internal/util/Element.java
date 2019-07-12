package f.g.org.org.org.internal.util;

import f.g.b.a.b.f.b;
import f.g.b.a.b.i.c;
import f.g.org.org.http.HttpContent;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.session.JsonHttpContent;
import f.g.org.org.org.network.f;
import f.g.org.org.org.network.services.Request;
import f.g.org.org.org.parser.FormatedText;
import java.io.IOException;

public abstract class Element<T>
  extends c<T>
{
  public final Object text;
  
  public Element(i paramI, String paramString1, String paramString2, Object paramObject, Class paramClass)
  {
    super(paramI, paramString1, paramString2, (HttpContent)localObject, paramClass);
    text = paramObject;
  }
  
  public FormatedText add(HttpResponse paramHttpResponse)
  {
    return FormatedText.from(equals().getJsonFactory(), paramHttpResponse);
  }
  
  public final void appendAttributes(f paramF, Request paramRequest)
    throws IOException
  {
    super.add(paramF, b.class, paramRequest);
  }
  
  public Element clone(String paramString, Object paramObject)
  {
    return (Element)super.clone(paramString, paramObject);
  }
  
  public i equals()
  {
    return (i)this$0;
  }
  
  public Object getText()
  {
    return text;
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
