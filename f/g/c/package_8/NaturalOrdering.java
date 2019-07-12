package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.mf;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@b(serializable=true)
public final class NaturalOrdering
  extends mf<Comparable>
  implements Serializable
{
  public static final NaturalOrdering INSTANCE = new NaturalOrdering();
  public static final long serialVersionUID = 0L;
  
  public NaturalOrdering() {}
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public int binarySearch(List paramList, Comparable paramComparable)
  {
    return Collections.binarySearch(paramList, paramComparable);
  }
  
  public int compare(Comparable paramComparable1, Comparable paramComparable2)
  {
    if (paramComparable1 != null)
    {
      if (paramComparable2 != null)
      {
        if (paramComparable1 == paramComparable2) {
          return 0;
        }
        return paramComparable1.compareTo(paramComparable2);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public Ordering reverse()
  {
    return ReverseNaturalOrdering.INSTANCE;
  }
  
  public List sortedCopy(Iterable paramIterable)
  {
    paramIterable = Lists.newArrayList(paramIterable);
    Collections.sort(paramIterable);
    return paramIterable;
  }
  
  public String toString()
  {
    return "Ordering.natural()";
  }
}
