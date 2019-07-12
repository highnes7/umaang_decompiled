package f.g.c.package_10;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.b.C;
import f.g.c.b.J;
import java.io.Serializable;
import java.util.Arrays;

@a
@b
public final class FunctionalEquivalence<F, T>
  extends C<F>
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public final J<F, ? extends T> function;
  public final C<T> resultEquivalence;
  
  public FunctionalEquivalence(Function paramFunction, Equivalence paramEquivalence)
  {
    if (paramFunction != null)
    {
      function = paramFunction;
      if (paramEquivalence != null)
      {
        resultEquivalence = paramEquivalence;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public boolean doEquivalent(Object paramObject1, Object paramObject2)
  {
    return resultEquivalence.equivalent(function.apply(paramObject1), function.apply(paramObject2));
  }
  
  public int doHash(Object paramObject)
  {
    return resultEquivalence.hash(function.apply(paramObject));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof FunctionalEquivalence))
    {
      paramObject = (FunctionalEquivalence)paramObject;
      return (function.equals(function)) && (resultEquivalence.equals(resultEquivalence));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { function, resultEquivalence });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(resultEquivalence);
    localStringBuilder.append(".onResultOf(");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, function, ")");
  }
}
