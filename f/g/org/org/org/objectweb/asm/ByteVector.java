package f.g.org.org.org.objectweb.asm;

import f.g.b.a.g.z;
import f.g.org.org.dom4j.asm.Plot;
import java.io.IOException;

public class ByteVector
  extends Plot
{
  @z("id_token")
  public String idToken;
  
  public ByteVector() {}
  
  public ByteVector a(Long paramLong)
  {
    expiresInSeconds = paramLong;
    return this;
  }
  
  public ByteVector a(String paramString)
  {
    if (paramString != null)
    {
      tokenType = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public ByteVector b(String paramString)
  {
    if (paramString != null)
    {
      accessToken = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public ByteVector clone()
  {
    return (ByteVector)super.clone();
  }
  
  public ByteVector clone(String paramString, Object paramObject)
  {
    return (ByteVector)super.clone(paramString, paramObject);
  }
  
  public ContentType get()
    throws IOException
  {
    return ContentType.parse(getFactory(), read());
  }
  
  public ByteVector putByte(String paramString)
  {
    scope = paramString;
    return this;
  }
  
  public ByteVector putLong(String paramString)
  {
    refreshToken = paramString;
    return this;
  }
  
  public final String read()
  {
    return idToken;
  }
  
  public ByteVector write(String paramString)
  {
    if (paramString != null)
    {
      idToken = paramString;
      return this;
    }
    throw new NullPointerException();
  }
}
