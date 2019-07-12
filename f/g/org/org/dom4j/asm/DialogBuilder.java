package f.g.org.org.dom4j.asm;

import f.g.b.a.g.z;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import java.util.Collection;

public class DialogBuilder
  extends Buffer
{
  @z
  public String code;
  @z("redirect_uri")
  public String redirectUri;
  
  public DialogBuilder(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, GenericUrl paramGenericUrl, String paramString)
  {
    super(paramHttpTransport, paramJsonFactory, paramGenericUrl, "authorization_code");
    setMessage(paramString);
  }
  
  public DialogBuilder clone(String paramString, Object paramObject)
  {
    return (DialogBuilder)super.clone(paramString, paramObject);
  }
  
  public final String getDialogId()
  {
    return redirectUri;
  }
  
  public final String getTitle()
  {
    return code;
  }
  
  public DialogBuilder setIcon(String paramString)
  {
    redirectUri = paramString;
    return this;
  }
  
  public DialogBuilder setMessage(String paramString)
  {
    if (paramString != null)
    {
      code = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public DialogBuilder setTitle(AnnotationVisitor paramAnnotationVisitor)
  {
    av = paramAnnotationVisitor;
    return this;
  }
  
  public DialogBuilder setTitle(GenericUrl paramGenericUrl)
  {
    super.setTitle(paramGenericUrl);
    return (DialogBuilder)this;
  }
  
  public DialogBuilder setTitle(f.g.org.org.http.Object paramObject)
  {
    command = paramObject;
    return this;
  }
  
  public DialogBuilder setTitle(String paramString)
  {
    if (paramString != null)
    {
      grantType = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public DialogBuilder setTitle(Collection paramCollection)
  {
    super.setTitle(paramCollection);
    return (DialogBuilder)this;
  }
}
