package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.ia;
import java.util.NoSuchElementException;
import java.util.Set;

@b(emulated=true)
public final class EmptyContiguousSet<C extends Comparable>
  extends ia<C>
{
  public EmptyContiguousSet(DiscreteDomain paramDiscreteDomain)
  {
    super(paramDiscreteDomain);
  }
  
  public ImmutableList asList()
  {
    return ImmutableList.of();
  }
  
  public ImmutableSortedSet createDescendingSet()
  {
    return new EmptyImmutableSortedSet(Ordering.natural().reverse());
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Set)) {
      return ((Set)paramObject).isEmpty();
    }
    return false;
  }
  
  public Comparable first()
  {
    throw new NoSuchElementException();
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public ContiguousSet headSetImpl(Comparable paramComparable, boolean paramBoolean)
  {
    return this;
  }
  
  public int indexOf(Object paramObject)
  {
    return -1;
  }
  
  public ContiguousSet intersection(ContiguousSet paramContiguousSet)
  {
    return this;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator iterator()
  {
    return Iterators.EMPTY_LIST_ITERATOR;
  }
  
  public Comparable last()
  {
    throw new NoSuchElementException();
  }
  
  public Range range()
  {
    throw new NoSuchElementException();
  }
  
  public Range range(BoundType paramBoundType1, BoundType paramBoundType2)
  {
    throw new NoSuchElementException();
  }
  
  public int size()
  {
    return 0;
  }
  
  public ContiguousSet subSetImpl(Comparable paramComparable1, boolean paramBoolean1, Comparable paramComparable2, boolean paramBoolean2)
  {
    return this;
  }
  
  public ContiguousSet tailSetImpl(Comparable paramComparable, boolean paramBoolean)
  {
    return this;
  }
  
  public String toString()
  {
    return "[]";
  }
  
  public Object writeReplace()
  {
    return new ra.a(domain, null);
  }
}
