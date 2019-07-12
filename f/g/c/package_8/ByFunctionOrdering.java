package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.b.J;
import f.g.c.d.mf;
import f.g.c.package_10.Function;
import java.io.Serializable;
import java.util.Arrays;

@b(serializable=true)
public final class ByFunctionOrdering<F, T>
  extends mf<F>
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public final J<F, ? extends T> function;
  public final mf<T> ordering;
  
  public ByFunctionOrdering(Function paramFunction, Ordering paramOrdering)
  {
    if (paramFunction != null)
    {
      function = paramFunction;
      if (paramOrdering != null)
      {
        ordering = paramOrdering;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return ordering.compare(function.apply(paramObject1), function.apply(paramObject2));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ByFunctionOrdering))
    {
      paramObject = (ByFunctionOrdering)paramObject;
      return (function.equals(function)) && (ordering.equals(ordering));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { function, ordering });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ordering);
    localStringBuilder.append(".onResultOf(");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, function, ")");
  }
}
