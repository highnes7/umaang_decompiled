package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Nb;
import java.util.Collection;
import java.util.Set;

@b(emulated=true, serializable=true)
public final class EmptyImmutableSet
  extends Nb<Object>
{
  public static final EmptyImmutableSet INSTANCE = new EmptyImmutableSet();
  public static final long serialVersionUID = 0L;
  
  public EmptyImmutableSet() {}
  
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
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Set)) {
      return ((Set)paramObject).isEmpty();
    }
    return false;
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean isHashCodeFast()
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
  
  public String toString()
  {
    return "[]";
  }
}
