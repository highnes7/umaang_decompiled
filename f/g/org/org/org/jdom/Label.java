package f.g.org.org.org.jdom;

import f.g.b.a.g.h;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.dom4j.asm.ByteVector;
import f.g.org.org.dom4j.asm.Settings;
import f.g.org.org.dom4j.asm.e;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.Object;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.util.Item;
import java.util.Collection;

@h
public class Label
  extends ByteVector
{
  public Label(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
  {
    super(Settings.getJid());
    a(paramHttpTransport);
    a(paramJsonFactory);
    a("http://metadata/computeMetadata/v1/instance/service-accounts/default/token");
  }
  
  public Label a(e paramE)
  {
    Collection localCollection = c;
    if (paramE != null)
    {
      localCollection.add(paramE);
      return this;
    }
    throw new NullPointerException();
  }
  
  public Label a(AnnotationVisitor paramAnnotationVisitor)
  {
    array = paramAnnotationVisitor;
    return this;
  }
  
  public Label a(GenericUrl paramGenericUrl)
  {
    if (paramGenericUrl != null)
    {
      data = paramGenericUrl;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Label a(HttpTransport paramHttpTransport)
  {
    if (paramHttpTransport != null)
    {
      b = paramHttpTransport;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Label a(Object paramObject)
  {
    boolean bool;
    if (paramObject == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    return this;
  }
  
  public Label a(JsonFactory paramJsonFactory)
  {
    if (paramJsonFactory != null)
    {
      Q = paramJsonFactory;
      return this;
    }
    throw new NullPointerException();
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
    if (paramString != null)
    {
      super.a(paramString);
      return (Label)this;
    }
    throw new NullPointerException();
  }
  
  public Subsequence a()
  {
    return new Subsequence(this);
  }
  
  public Label b(Collection paramCollection)
  {
    if (paramCollection != null)
    {
      c = paramCollection;
      return this;
    }
    throw new NullPointerException();
  }
}
