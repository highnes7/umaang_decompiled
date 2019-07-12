package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.mf;
import f.g.c.package_10.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@b(serializable=true)
public final class ComparatorOrdering<T>
  extends mf<T>
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public final Comparator<T> comparator;
  
  public ComparatorOrdering(Comparator paramComparator)
  {
    if (paramComparator != null)
    {
      comparator = paramComparator;
      return;
    }
    throw new NullPointerException();
  }
  
  public int binarySearch(List paramList, Object paramObject)
  {
    return Collections.binarySearch(paramList, paramObject, comparator);
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return comparator.compare(paramObject1, paramObject2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ComparatorOrdering))
    {
      paramObject = (ComparatorOrdering)paramObject;
      return comparator.equals(comparator);
    }
    return false;
  }
  
  public int hashCode()
  {
    return comparator.hashCode();
  }
  
  public ImmutableList immutableSortedCopy(Iterable paramIterable)
  {
    paramIterable = Iterables.toArray(paramIterable);
    int j = paramIterable.length;
    int i = 0;
    while (i < j)
    {
      Preconditions.checkNotNull(paramIterable[i]);
      i += 1;
    }
    Arrays.sort(paramIterable, comparator);
    return ImmutableList.of(paramIterable);
  }
  
  public List sortedCopy(Iterable paramIterable)
  {
    paramIterable = Lists.newArrayList(paramIterable);
    Collections.sort(paramIterable, comparator);
    return paramIterable;
  }
  
  public String toString()
  {
    return comparator.toString();
  }
}
