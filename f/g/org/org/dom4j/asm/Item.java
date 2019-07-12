package f.g.org.org.dom4j.asm;

import f.g.b.a.g.z;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import java.util.Collection;

public class Item
  extends Buffer
{
  @z("refresh_token")
  public String refreshToken;
  
  public Item(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, GenericUrl paramGenericUrl, String paramString)
  {
    super(paramHttpTransport, paramJsonFactory, paramGenericUrl, "refresh_token");
    a(paramString);
  }
  
  public Item a(String paramString)
  {
    if (paramString != null)
    {
      refreshToken = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Item clone(String paramString, Object paramObject)
  {
    return (Item)super.clone(paramString, paramObject);
  }
  
  public final String getArmorDupeNameFix()
  {
    return refreshToken;
  }
  
  public Item setTitle(AnnotationVisitor paramAnnotationVisitor)
  {
    av = paramAnnotationVisitor;
    return this;
  }
  
  public Item setTitle(GenericUrl paramGenericUrl)
  {
    super.setTitle(paramGenericUrl);
    return (Item)this;
  }
  
  public Item setTitle(f.g.org.org.http.Object paramObject)
  {
    command = paramObject;
    return this;
  }
  
  public Item setTitle(String paramString)
  {
    if (paramString != null)
    {
      grantType = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Item setTitle(Collection paramCollection)
  {
    super.setTitle(paramCollection);
    return (Item)this;
  }
}
