package f.g.org.org.org.objectweb.asm;

import f.g.b.a.b.b.b.m;
import f.g.org.org.dom4j.asm.AnnotationNode;
import f.g.org.org.dom4j.asm.Buffer;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import java.io.IOException;
import java.util.Collection;

public class DialogBuilder
  extends f.g.org.org.dom4j.asm.DialogBuilder
{
  public DialogBuilder(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramHttpTransport, paramJsonFactory, "https://accounts.google.com/o/oauth2/token", paramString1, paramString2, paramString3, paramString4);
  }
  
  public DialogBuilder(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramHttpTransport, paramJsonFactory, new GenericUrl(paramString1), paramString4);
    setTitle(new AnnotationNode(paramString2, paramString3));
    setIcon(paramString5);
  }
  
  public DialogBuilder clone(String paramString, Object paramObject)
  {
    return (DialogBuilder)super.clone(paramString, paramObject);
  }
  
  public ByteVector execute()
    throws IOException
  {
    return (ByteVector)authenticate().parseAs(m.class);
  }
  
  public DialogBuilder setIcon(String paramString)
  {
    if (paramString != null)
    {
      redirectUri = paramString;
      return this;
    }
    throw new NullPointerException();
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
    return (DialogBuilder)super.setTitle(paramGenericUrl);
  }
  
  public DialogBuilder setTitle(f.g.org.org.http.Object paramObject)
  {
    if (paramObject != null)
    {
      command = paramObject;
      return this;
    }
    throw new NullPointerException();
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
    return (DialogBuilder)super.setTitle(paramCollection);
  }
}
