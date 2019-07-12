package f.g.org.org.dom4j.tree;

import f.g.b.a.a.c.b;
import f.g.b.a.g.h;
import f.g.b.a.g.z;
import f.g.org.org.dom4j.asm.Buffer;
import f.g.org.org.dom4j.asm.Plot;
import f.g.org.org.http.HttpResponse;
import java.io.IOException;

@h
public class ByteVector
  extends Plot
{
  @z("id_token")
  public String idToken;
  
  public ByteVector() {}
  
  public static ByteVector read(Buffer paramBuffer)
    throws IOException
  {
    return (ByteVector)paramBuffer.authenticate().parseAs(b.class);
  }
  
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
  
  public Item get()
    throws IOException
  {
    return Item.parse(getFactory(), idToken);
  }
  
  public final String put()
  {
    return idToken;
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
