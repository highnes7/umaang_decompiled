package f.g.org.org.dom4j.asm;

import f.g.b.a.g.z;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import java.util.Collection;

public class InputDialog
  extends Buffer
{
  @z
  public String password;
  @z
  public String username;
  
  public InputDialog(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, GenericUrl paramGenericUrl, String paramString1, String paramString2)
  {
    super(paramHttpTransport, paramJsonFactory, paramGenericUrl, "password");
    setMessage(paramString1);
    setIcon(paramString2);
  }
  
  public InputDialog clone(String paramString, Object paramObject)
  {
    return (InputDialog)super.clone(paramString, paramObject);
  }
  
  public final String getName()
  {
    return username;
  }
  
  public final String getPassword()
  {
    return password;
  }
  
  public InputDialog setIcon(String paramString)
  {
    if (paramString != null)
    {
      password = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public InputDialog setMessage(String paramString)
  {
    if (paramString != null)
    {
      username = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public InputDialog setTitle(AnnotationVisitor paramAnnotationVisitor)
  {
    av = paramAnnotationVisitor;
    return this;
  }
  
  public InputDialog setTitle(GenericUrl paramGenericUrl)
  {
    super.setTitle(paramGenericUrl);
    return (InputDialog)this;
  }
  
  public InputDialog setTitle(f.g.org.org.http.Object paramObject)
  {
    command = paramObject;
    return this;
  }
  
  public InputDialog setTitle(String paramString)
  {
    if (paramString != null)
    {
      grantType = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public InputDialog setTitle(Collection paramCollection)
  {
    super.setTitle(paramCollection);
    return (InputDialog)this;
  }
}
