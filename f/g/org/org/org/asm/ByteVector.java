package f.g.org.org.org.asm;

import f.g.org.org.http.HttpMediaType;
import f.g.org.org.util.ObjectParser;
import f.g.org.org.util.Preconditions;
import java.io.IOException;
import java.nio.charset.Charset;

@f.g.b.a.g.h
public abstract class ByteVector<T>
  implements f.g.b.a.b.h.h
{
  public static final long serialVersionUID = 1L;
  
  public ByteVector() {}
  
  public final void a(URLName paramURLName, m paramM)
    throws IOException
  {
    h localH = new h(paramM);
    Object localObject = paramM.f();
    if (localObject != null)
    {
      localObject = new HttpMediaType((String)localObject).getCharsetParameter();
      Class localClass = read();
      Preconditions.append(localClass);
      localClass = (Class)localClass;
      localH.a(getObjectParser().parseAndClose(paramM.getContentStream(), (Charset)localObject, localClass));
    }
    b(paramURLName, localH);
  }
  
  public abstract void b(URLName paramURLName, h paramH)
    throws IOException;
  
  public abstract ObjectParser getObjectParser()
    throws IOException;
  
  public abstract Class read()
    throws IOException;
}
