package f.g.org.org.org.asm;

import f.g.b.a.g.h;
import f.g.org.org.util.Objects.ToStringHelper;
import java.io.InputStream;

@h
public class m
  extends f
{
  public String f;
  public InputStream stream;
  
  public m(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramLong, paramString1, paramString2, paramString3, paramString4);
  }
  
  public m a(long paramLong)
  {
    super.a(paramLong);
    return (m)this;
  }
  
  public m a(InputStream paramInputStream)
  {
    stream = paramInputStream;
    return this;
  }
  
  public m a(String paramString)
  {
    p = paramString;
    return this;
  }
  
  public m b(String paramString)
  {
    if (paramString != null)
    {
      a = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public m c(String paramString)
  {
    if (paramString != null)
    {
      f = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public m d(String paramString)
  {
    b = paramString;
    return this;
  }
  
  public m e(String paramString)
  {
    g = paramString;
    return this;
  }
  
  public m f(String paramString)
  {
    if (paramString != null)
    {
      m = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final String f()
  {
    return f;
  }
  
  public final InputStream getContentStream()
  {
    return stream;
  }
  
  public m i(String paramString)
  {
    if (paramString != null)
    {
      l = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public m setShortcut(String paramString)
  {
    f = paramString;
    return this;
  }
  
  public String toString()
  {
    return super.add().add("contentType", f).toString();
  }
}
