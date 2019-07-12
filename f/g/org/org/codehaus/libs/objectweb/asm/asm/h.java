package f.g.org.org.codehaus.libs.objectweb.asm.asm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  public final String c;
  public boolean e = false;
  public final List<f.g.b.a.e.a.a.a.b.f.a.a> f = new LinkedList();
  
  public h(String paramString)
  {
    if (paramString != null)
    {
      c = paramString;
      return;
    }
    throw new NullPointerException();
  }
  
  private StringBuilder a(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = if;
      localStringBuilder.append(paramString);
      localStringBuilder.append('=');
      return localStringBuilder;
    }
    throw new NullPointerException();
  }
  
  private f.a.a i()
  {
    f.a.a localA = new f.a.a();
    f.add(localA);
    return localA;
  }
  
  private f.a.a i(Object paramObject)
  {
    f.a.a localA = i();
    boolean bool;
    if (paramObject == null) {
      bool = true;
    } else {
      bool = false;
    }
    e = bool;
    return localA;
  }
  
  public h a()
  {
    e = true;
    return this;
  }
  
  public h a(char paramChar)
  {
    if.append(paramChar);
    return this;
  }
  
  public h a(double paramDouble)
  {
    if.append(paramDouble);
    return this;
  }
  
  public h a(float paramFloat)
  {
    if.append(paramFloat);
    return this;
  }
  
  public h a(long paramLong)
  {
    if.append(paramLong);
    return this;
  }
  
  public h a(Object paramObject)
  {
    if.append(paramObject);
    return this;
  }
  
  public h a(String paramString, char paramChar)
  {
    a(paramString).append(paramChar);
    return this;
  }
  
  public h a(String paramString, double paramDouble)
  {
    a(paramString).append(paramDouble);
    return this;
  }
  
  public h a(String paramString, float paramFloat)
  {
    a(paramString).append(paramFloat);
    return this;
  }
  
  public h a(String paramString, int paramInt)
  {
    a(paramString).append(paramInt);
    return this;
  }
  
  public h a(String paramString, long paramLong)
  {
    a(paramString).append(paramLong);
    return this;
  }
  
  public h a(String paramString, Object paramObject)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = if;
      localStringBuilder.append(paramString);
      localStringBuilder.append('=');
      localStringBuilder.append(paramObject);
      return this;
    }
    throw new NullPointerException();
  }
  
  public h a(String paramString, boolean paramBoolean)
  {
    a(paramString).append(paramBoolean);
    return this;
  }
  
  public h c(int paramInt)
  {
    if.append(paramInt);
    return this;
  }
  
  public h c(boolean paramBoolean)
  {
    if.append(paramBoolean);
    return this;
  }
  
  public String toString()
  {
    boolean bool = e;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(c);
    localStringBuilder.append('{');
    Iterator localIterator = f.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      f.a.a localA = (f.a.a)localIterator.next();
      if ((!bool) || (!e))
      {
        if (i != 0) {
          localStringBuilder.append(", ");
        } else {
          i = 1;
        }
        localStringBuilder.append(f);
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
