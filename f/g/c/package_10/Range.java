package f.g.c.package_10;

import f.g.c.b.J;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.Serializable;

public class Range<E>
  implements J<Object, E>, Serializable
{
  public static final long ONE_YEAR = 0L;
  public final E value;
  
  public Range(Object paramObject)
  {
    value = paramObject;
  }
  
  public Object apply(Object paramObject)
  {
    return value;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Range))
    {
      paramObject = (Range)paramObject;
      return Objects.equal(value, value);
    }
    return false;
  }
  
  public int hashCode()
  {
    Object localObject = value;
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
  
  public String toString()
  {
    return StringBuilder.append(StringBuilder.append("constant("), value, ")");
  }
}
