package f.g.org.org.org.objectweb.asm;

import f.g.b.a.b.b.b.m;
import f.g.org.org.dom4j.asm.AnnotationNode;
import f.g.org.org.dom4j.asm.Buffer;
import f.g.org.org.dom4j.asm.Item;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import java.io.IOException;
import java.util.Collection;

public class MenuItem
  extends Item
{
  public MenuItem(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, String paramString1, String paramString2, String paramString3)
  {
    super(paramHttpTransport, paramJsonFactory, new GenericUrl("https://accounts.google.com/o/oauth2/token"), paramString1);
    setTitle(new AnnotationNode(paramString2, paramString3));
  }
  
  public MenuItem a(String paramString)
  {
    if (paramString != null)
    {
      refreshToken = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public MenuItem clone(String paramString, Object paramObject)
  {
    return (MenuItem)super.clone(paramString, paramObject);
  }
  
  public ByteVector execute()
    throws IOException
  {
    return (ByteVector)authenticate().parseAs(m.class);
  }
  
  public MenuItem setTitle(AnnotationVisitor paramAnnotationVisitor)
  {
    av = paramAnnotationVisitor;
    return this;
  }
  
  public MenuItem setTitle(GenericUrl paramGenericUrl)
  {
    return (MenuItem)super.setTitle(paramGenericUrl);
  }
  
  public MenuItem setTitle(f.g.org.org.http.Object paramObject)
  {
    command = paramObject;
    return this;
  }
  
  public MenuItem setTitle(String paramString)
  {
    if (paramString != null)
    {
      grantType = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public MenuItem setTitle(Collection paramCollection)
  {
    return (MenuItem)super.setTitle(paramCollection);
  }
}
