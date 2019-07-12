package f.g.org.org.org.asm;

import f.g.b.a.b.h.a;
import f.g.org.org.util.Objects.ToStringHelper;

@f.g.b.a.g.h
public class h<T>
  extends a
{
  public T v;
  
  public h(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramLong, paramString1, paramString2, paramString3, paramString4);
  }
  
  public h(m paramM)
  {
    super(paramM);
  }
  
  public h a(long paramLong)
  {
    super.a(paramLong);
    return (h)this;
  }
  
  public h a(Object paramObject)
  {
    v = paramObject;
    return this;
  }
  
  public h a(String paramString)
  {
    p = paramString;
    return this;
  }
  
  public h b(String paramString)
  {
    if (paramString != null)
    {
      a = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public h c(String paramString)
  {
    if (paramString != null)
    {
      f = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public h d(String paramString)
  {
    b = paramString;
    return this;
  }
  
  public h e(String paramString)
  {
    g = paramString;
    return this;
  }
  
  public h f(String paramString)
  {
    if (paramString != null)
    {
      m = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final Object f()
  {
    return v;
  }
  
  public h i(String paramString)
  {
    if (paramString != null)
    {
      l = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public String toString()
  {
    return super.add().add("content", v).toString();
  }
}
