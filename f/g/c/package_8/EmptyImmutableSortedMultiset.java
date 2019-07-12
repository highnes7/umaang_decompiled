package f.g.c.package_8;

import f.g.c.d.Ub;
import f.g.c.d.Wb;
import java.util.Collection;
import java.util.Comparator;

public final class EmptyImmutableSortedMultiset<E>
  extends Ub<E>
{
  public final Wb<E> elementSet;
  
  public EmptyImmutableSortedMultiset(Comparator paramComparator)
  {
    elementSet = ImmutableSortedSet.emptySet(paramComparator);
  }
  
  public ImmutableList asList()
  {
    return ImmutableList.of();
  }
  
  public boolean contains(Object paramObject)
  {
    return false;
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    return paramCollection.isEmpty();
  }
  
  public int count(Object paramObject)
  {
    return 0;
  }
  
  public ImmutableSet createEntrySet()
  {
    throw new AssertionError("should never be called");
  }
  
  public ImmutableSortedSet elementSet()
  {
    return elementSet;
  }
  
  public ImmutableSet entrySet()
  {
    return ImmutableSet.of();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Multiset)) {
      return ((Multiset)paramObject).isEmpty();
    }
    return false;
  }
  
  public Ye.a firstEntry()
  {
    return null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public ImmutableSortedMultiset headMultiset(Object paramObject, BoundType paramBoundType)
  {
    if (paramObject != null)
    {
      if (paramBoundType != null) {
        return this;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator iterator()
  {
    return Iterators.EMPTY_LIST_ITERATOR;
  }
  
  public Ye.a lastEntry()
  {
    return null;
  }
  
  public int size()
  {
    return 0;
  }
  
  public ImmutableSortedMultiset tailMultiset(Object paramObject, BoundType paramBoundType)
  {
    if (paramObject != null)
    {
      if (paramBoundType != null) {
        return this;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public Object[] toArray()
  {
    return ObjectArrays.EMPTY_ARRAY;
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    return asList().toArray(paramArrayOfObject);
  }
  
  public String toString()
  {
    return "[]";
  }
}
