package f.g.c.package_10;

import f.g.c.b.J;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.Serializable;

public final class Handle<T extends Enum<T>>
  implements J<String, T>, Serializable
{
  public static final long d = 0L;
  public final Class<T> c;
  
  public Handle(Class paramClass)
  {
    if (paramClass != null)
    {
      c = paramClass;
      return;
    }
    throw new NullPointerException();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Handle)) && (c.equals(c));
  }
  
  public Enum getName(String paramString)
  {
    Class localClass = c;
    try
    {
      paramString = Enum.valueOf(localClass, paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public int hashCode()
  {
    return c.hashCode();
  }
  
  public String toString()
  {
    return StringBuilder.append(StringBuilder.append("Enums.valueOf("), c, ")");
  }
}
