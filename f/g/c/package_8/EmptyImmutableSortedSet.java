package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Wb;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Set;

@b(emulated=true, serializable=true)
public class EmptyImmutableSortedSet<E>
  extends Wb<E>
{
  public EmptyImmutableSortedSet(Comparator paramComparator)
  {
    super(paramComparator);
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
  
  public ImmutableSortedSet createDescendingSet()
  {
    return new EmptyImmutableSortedSet(Ordering.from(comparator).reverse());
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Set)) {
      return ((Set)paramObject).isEmpty();
    }
    return false;
  }
  
  public Object first()
  {
    throw new NoSuchElementException();
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public ImmutableSortedSet headSetImpl(Object paramObject, boolean paramBoolean)
  {
    return this;
  }
  
  public int indexOf(Object paramObject)
  {
    return -1;
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
  
  public Object last()
  {
    throw new NoSuchElementException();
  }
  
  public int size()
  {
    return 0;
  }
  
  public ImmutableSortedSet subSetImpl(Object paramObject1, boolean paramBoolean1, Object paramObject2, boolean paramBoolean2)
  {
    return this;
  }
  
  public ImmutableSortedSet tailSetImpl(Object paramObject, boolean paramBoolean)
  {
    return this;
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
