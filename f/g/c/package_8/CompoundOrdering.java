package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.mf;
import f.g.c.d.vb;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@b(serializable=true)
public final class CompoundOrdering<T>
  extends mf<T>
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public final vb<Comparator<? super T>> comparators;
  
  public CompoundOrdering(Iterable paramIterable)
  {
    comparators = ImmutableList.copyOf(paramIterable);
  }
  
  public CompoundOrdering(Comparator paramComparator1, Comparator paramComparator2)
  {
    comparators = ImmutableList.of(paramComparator1, paramComparator2);
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    int j = comparators.size();
    int i = 0;
    while (i < j)
    {
      int k = ((Comparator)comparators.get(i)).compare(paramObject1, paramObject2);
      if (k != 0) {
        return k;
      }
      i += 1;
    }
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CompoundOrdering))
    {
      paramObject = (CompoundOrdering)paramObject;
      return comparators.equals(comparators);
    }
    return false;
  }
  
  public int hashCode()
  {
    return comparators.hashCode();
  }
  
  public String toString()
  {
    return StringBuilder.append(StringBuilder.append("Ordering.compound("), comparators, ")");
  }
}
