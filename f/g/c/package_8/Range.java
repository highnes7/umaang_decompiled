package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.b.ca;
import f.g.c.d.la;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

@a
@b
public final class Range<C extends Comparable>
  implements ca<C>, Serializable
{
  public static final long ONE_YEAR = 0L;
  public final la<C> lowerBound;
  public final la<C> upperBound;
  
  public Range(Cut paramCut1, Cut paramCut2)
  {
    if (paramCut1.compareTo(paramCut2) <= 0)
    {
      lowerBound = paramCut1;
      upperBound = paramCut2;
      return;
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Invalid range: ");
    localStringBuilder.append(toString(paramCut1, paramCut2));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static SortedSet cast(Iterable paramIterable)
  {
    return (SortedSet)paramIterable;
  }
  
  public static int compareOrThrow(Comparable paramComparable1, Comparable paramComparable2)
  {
    return paramComparable1.compareTo(paramComparable2);
  }
  
  public static String toString(Cut paramCut1, Cut paramCut2)
  {
    StringBuilder localStringBuilder = new StringBuilder(16);
    paramCut1.describeAsLowerBound(localStringBuilder);
    localStringBuilder.append('?');
    paramCut2.describeAsUpperBound(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public boolean apply(Comparable paramComparable)
  {
    return contains(paramComparable);
  }
  
  public ContiguousSet asSet(DiscreteDomain paramDiscreteDomain)
  {
    return ContiguousSet.create(this, paramDiscreteDomain);
  }
  
  public boolean contains(Comparable paramComparable)
  {
    if (paramComparable != null) {
      return (lowerBound.isLessThan(paramComparable)) && (!upperBound.isLessThan(paramComparable));
    }
    throw new NullPointerException();
  }
  
  public boolean containsAll(Iterable paramIterable)
  {
    if (Iterables.isEmpty(paramIterable)) {
      return true;
    }
    if ((paramIterable instanceof SortedSet))
    {
      SortedSet localSortedSet = (SortedSet)paramIterable;
      Comparator localComparator = localSortedSet.comparator();
      if ((Ordering.natural().equals(localComparator)) || (localComparator == null)) {
        return (contains((Comparable)localSortedSet.first())) && (contains((Comparable)localSortedSet.last()));
      }
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (!contains((Comparable)paramIterable.next())) {
        return false;
      }
    }
    return true;
  }
  
  public Range create(DiscreteDomain paramDiscreteDomain)
  {
    if (paramDiscreteDomain != null)
    {
      Cut localCut = lowerBound.canonical(paramDiscreteDomain);
      paramDiscreteDomain = upperBound.canonical(paramDiscreteDomain);
      if ((localCut == lowerBound) && (paramDiscreteDomain == upperBound)) {
        return this;
      }
      return new Range(localCut, paramDiscreteDomain);
    }
    throw new NullPointerException();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Range))
    {
      paramObject = (Range)paramObject;
      if ((lowerBound.equals(lowerBound)) && (upperBound.equals(upperBound))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean hasLowerBound()
  {
    return lowerBound != Cut.belowAll();
  }
  
  public boolean hasUpperBound()
  {
    return upperBound != Cut.aboveAll();
  }
  
  public int hashCode()
  {
    int i = lowerBound.hashCode();
    return upperBound.hashCode() + i * 31;
  }
  
  public Range intersection(Range paramRange)
  {
    return new Range((Cut)Ordering.natural().max(lowerBound, lowerBound), (Cut)Ordering.natural().min(upperBound, upperBound));
  }
  
  public boolean isConnected(Range paramRange)
  {
    return (lowerBound.compareTo(upperBound) <= 0) && (lowerBound.compareTo(upperBound) <= 0);
  }
  
  public boolean isEmpty()
  {
    return lowerBound.equals(upperBound);
  }
  
  public boolean isEmpty(Range paramRange)
  {
    return (lowerBound.compareTo(lowerBound) <= 0) && (upperBound.compareTo(upperBound) >= 0);
  }
  
  public BoundType lowerBoundType()
  {
    return lowerBound.typeAsLowerBound();
  }
  
  public Comparable lowerEndpoint()
  {
    return lowerBound.endpoint();
  }
  
  public Range span(Range paramRange)
  {
    return new Range((Cut)Ordering.natural().min(lowerBound, lowerBound), (Cut)Ordering.natural().max(upperBound, upperBound));
  }
  
  public String toString()
  {
    return toString(lowerBound, upperBound);
  }
  
  public BoundType upperBoundType()
  {
    return upperBound.typeAsUpperBound();
  }
  
  public Comparable upperEndpoint()
  {
    return upperBound.endpoint();
  }
}
