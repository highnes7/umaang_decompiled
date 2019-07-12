package f.g.org.org.dom4j.asm;

import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import java.util.Collection;

public class XHTMLElement
  extends Buffer
{
  public XHTMLElement(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, GenericUrl paramGenericUrl)
  {
    super(paramHttpTransport, paramJsonFactory, paramGenericUrl, "client_credentials");
  }
  
  public XHTMLElement clone(String paramString, Object paramObject)
  {
    return (XHTMLElement)super.clone(paramString, paramObject);
  }
  
  public XHTMLElement setTitle(AnnotationVisitor paramAnnotationVisitor)
  {
    av = paramAnnotationVisitor;
    return this;
  }
  
  public XHTMLElement setTitle(GenericUrl paramGenericUrl)
  {
    super.setTitle(paramGenericUrl);
    return (XHTMLElement)this;
  }
  
  public XHTMLElement setTitle(f.g.org.org.http.Object paramObject)
  {
    command = paramObject;
    return this;
  }
  
  public XHTMLElement setTitle(String paramString)
  {
    if (paramString != null)
    {
      grantType = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public XHTMLElement setTitle(Collection paramCollection)
  {
    super.setTitle(paramCollection);
    return (XHTMLElement)this;
  }
}
