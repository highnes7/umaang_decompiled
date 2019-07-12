package f.g.org.org.org.asm;

import f.g.b.a.g.h;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.util.Objects;
import f.g.org.org.util.Objects.ToStringHelper;

@h
public abstract class f
{
  public String a;
  public String b;
  public long d;
  public String f;
  public String g;
  public String l;
  public String m;
  public String p;
  
  public f(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramLong);
    i(paramString1);
    f(paramString2);
    b(paramString3);
    c(paramString4);
  }
  
  public f(f paramF)
  {
    this(paramF.e(), paramF.i(), paramF.l(), paramF.getItem(), paramF.d());
    a(paramF.b());
    e(paramF.getId());
    d(paramF.a());
  }
  
  public f a(long paramLong)
  {
    boolean bool;
    if (paramLong >= 1L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    d = paramLong;
    return this;
  }
  
  public f a(String paramString)
  {
    p = paramString;
    return this;
  }
  
  public final String a()
  {
    return b;
  }
  
  public Objects.ToStringHelper add()
  {
    return Objects.toStringHelper(this).add("messageNumber", Long.valueOf(d)).add("resourceState", l).add("resourceId", m).add("resourceUri", a).add("channelId", f).add("channelExpiration", p).add("channelToken", g).add("changed", b);
  }
  
  public f b(String paramString)
  {
    if (paramString != null)
    {
      a = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final String b()
  {
    return p;
  }
  
  public f c(String paramString)
  {
    if (paramString != null)
    {
      f = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public f d(String paramString)
  {
    b = paramString;
    return this;
  }
  
  public final String d()
  {
    return f;
  }
  
  public final long e()
  {
    return d;
  }
  
  public f e(String paramString)
  {
    g = paramString;
    return this;
  }
  
  public f f(String paramString)
  {
    if (paramString != null)
    {
      m = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final String getId()
  {
    return g;
  }
  
  public final String getItem()
  {
    return a;
  }
  
  public f i(String paramString)
  {
    if (paramString != null)
    {
      l = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public final String i()
  {
    return l;
  }
  
  public final String l()
  {
    return m;
  }
  
  public String toString()
  {
    return add().toString();
  }
}
