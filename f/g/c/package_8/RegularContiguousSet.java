package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.ia;
import f.g.c.d.qf;
import f.g.c.package_10.Preconditions;
import java.util.Collection;
import java.util.SortedSet;

@b(emulated=true)
public final class RegularContiguousSet<C extends Comparable>
  extends ia<C>
{
  public static final long serialVersionUID = 0L;
  public final qf<C> range;
  
  public RegularContiguousSet(Range paramRange, DiscreteDomain paramDiscreteDomain)
  {
    super(paramDiscreteDomain);
    range = paramRange;
  }
  
  public static boolean add(Comparable paramComparable1, Comparable paramComparable2)
  {
    return (paramComparable2 != null) && (paramComparable1.compareTo(paramComparable2) == 0);
  }
  
  private ContiguousSet intersectionInCurrentDomain(Range paramRange)
  {
    if (range.isConnected(paramRange)) {
      return range.intersection(paramRange).asSet(domain);
    }
    return new EmptyContiguousSet(domain);
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    Range localRange = range;
    try
    {
      boolean bool = localRange.contains((Comparable)paramObject);
      return bool;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    return Collections2.containsAllImpl(this, paramCollection);
  }
  
  public ImmutableSortedSet createDescendingSet()
  {
    return new yf.a(this, null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof RegularContiguousSet))
    {
      RegularContiguousSet localRegularContiguousSet = (RegularContiguousSet)paramObject;
      if (domain.equals(domain)) {
        return (first().equals(localRegularContiguousSet.first())) && (last().equals(localRegularContiguousSet.last()));
      }
    }
    return super.equals(paramObject);
  }
  
  public Comparable first()
  {
    return range.lowerBound.leastValueAbove(domain);
  }
  
  public int hashCode()
  {
    return Sets.hashCodeImpl(this);
  }
  
  public ContiguousSet headSetImpl(Comparable paramComparable, boolean paramBoolean)
  {
    return intersectionInCurrentDomain(Ranges.upTo(paramComparable, BoundType.forBoolean(paramBoolean)));
  }
  
  public int indexOf(Object paramObject)
  {
    if (contains(paramObject)) {
      return (int)domain.distance(first(), (Comparable)paramObject);
    }
    return -1;
  }
  
  public ContiguousSet intersection(ContiguousSet paramContiguousSet)
  {
    if (paramContiguousSet != null)
    {
      Preconditions.checkArgument(domain.equals(domain));
      if (paramContiguousSet.isEmpty()) {
        return paramContiguousSet;
      }
      Comparable localComparable = (Comparable)Ordering.natural().max(first(), paramContiguousSet.first());
      paramContiguousSet = (Comparable)Ordering.natural().min(last(), paramContiguousSet.last());
      if (localComparable.compareTo(paramContiguousSet) < 0) {
        return Ranges.closed(localComparable, paramContiguousSet).asSet(domain);
      }
      return new EmptyContiguousSet(domain);
    }
    throw new NullPointerException();
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator iterator()
  {
    return new RegularContiguousSet.1(this, first());
  }
  
  public Comparable last()
  {
    return range.upperBound.greatestValueBelow(domain);
  }
  
  public Range range()
  {
    BoundType localBoundType = BoundType.CLOSED;
    return range(localBoundType, localBoundType);
  }
  
  public Range range(BoundType paramBoundType1, BoundType paramBoundType2)
  {
    return new Range(range.lowerBound.withLowerBoundType(paramBoundType1, domain), range.upperBound.withUpperBoundType(paramBoundType2, domain));
  }
  
  public int size()
  {
    long l = domain.distance(first(), last());
    if (l >= 2147483647L) {
      return Integer.MAX_VALUE;
    }
    return (int)l + 1;
  }
  
  public ContiguousSet subSetImpl(Comparable paramComparable1, boolean paramBoolean1, Comparable paramComparable2, boolean paramBoolean2)
  {
    if ((paramComparable1.compareTo(paramComparable2) == 0) && (!paramBoolean1) && (!paramBoolean2)) {
      return new EmptyContiguousSet(domain);
    }
    return intersectionInCurrentDomain(Ranges.range(paramComparable1, BoundType.forBoolean(paramBoolean1), paramComparable2, BoundType.forBoolean(paramBoolean2)));
  }
  
  public ContiguousSet tailSetImpl(Comparable paramComparable, boolean paramBoolean)
  {
    return intersectionInCurrentDomain(Ranges.downTo(paramComparable, BoundType.forBoolean(paramBoolean)));
  }
  
  public Object[] toArray()
  {
    return ObjectArrays.toArrayImpl(this);
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    return ObjectArrays.toArrayImpl(this, paramArrayOfObject);
  }
  
  public Object writeReplace()
  {
    return new yf.b(range, domain, null);
  }
}
