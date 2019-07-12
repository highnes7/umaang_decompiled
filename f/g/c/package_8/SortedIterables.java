package f.g.c.package_8;

import f.g.c.a.b;
import java.util.Comparator;
import java.util.SortedSet;

@b
public final class SortedIterables
{
  public SortedIterables() {}
  
  public static Comparator comparator(SortedSet paramSortedSet)
  {
    paramSortedSet = paramSortedSet.comparator();
    if (paramSortedSet == null) {
      return Ordering.natural();
    }
    return paramSortedSet;
  }
  
  public static boolean hasSameComparator(Comparator paramComparator, Iterable paramIterable)
  {
    if (paramComparator != null)
    {
      if (paramIterable != null)
      {
        if ((paramIterable instanceof SortedSet))
        {
          Comparator localComparator = ((SortedSet)paramIterable).comparator();
          paramIterable = localComparator;
          if (localComparator == null) {
            paramIterable = Ordering.natural();
          }
        }
        else
        {
          if (!(paramIterable instanceof SortedIterable)) {
            break label61;
          }
          paramIterable = ((SortedIterable)paramIterable).comparator();
        }
        return paramComparator.equals(paramIterable);
        label61:
        return false;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
}
