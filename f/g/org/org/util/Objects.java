package f.g.org.org.util;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.h;

public final class Objects
{
  public Objects() {}
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return f.g.org.org.codehaus.libs.objectweb.asm.asm.Objects.equals(paramObject1, paramObject2);
  }
  
  public static ToStringHelper toStringHelper(Object paramObject)
  {
    return new ToStringHelper(f.g.org.org.codehaus.libs.objectweb.asm.asm.Objects.toStringHelper(paramObject));
  }
  
  public final class ToStringHelper
  {
    public ToStringHelper() {}
    
    public ToStringHelper add()
    {
      a();
      return this;
    }
    
    public ToStringHelper add(String paramString, Object paramObject)
    {
      a(paramString, paramObject);
      return this;
    }
    
    public String toString()
    {
      return Objects.this.toString();
    }
  }
}
