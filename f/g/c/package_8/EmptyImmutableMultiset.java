package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Mb;
import java.util.Collection;

@b(serializable=true)
public final class EmptyImmutableMultiset
  extends Mb<Object>
{
  public static final EmptyImmutableMultiset INSTANCE = new EmptyImmutableMultiset();
  public static final long serialVersionUID = 0L;
  
  public EmptyImmutableMultiset() {}
  
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
  
  public ImmutableSet elementSet()
  {
    return ImmutableSet.of();
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
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator iterator()
  {
    return Iterators.EMPTY_LIST_ITERATOR;
  }
  
  public Object readResolve()
  {
    return INSTANCE;
  }
  
  public int size()
  {
    return 0;
  }
  
  public Object[] toArray()
  {
    return ObjectArrays.EMPTY_ARRAY;
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    return asList().toArray(paramArrayOfObject);
  }
}
