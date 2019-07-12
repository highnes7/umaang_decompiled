package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.rb;
import f.g.c.d.vb;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

@b(emulated=true)
public abstract class ImmutableCollection<E>
  implements Collection<E>, Serializable
{
  public static final rb<Object> EMPTY_IMMUTABLE_COLLECTION = new rb.c(null);
  public transient vb<E> asList;
  
  public ImmutableCollection() {}
  
  public final boolean add(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList asList()
  {
    ImmutableList localImmutableList2 = asList;
    ImmutableList localImmutableList1 = localImmutableList2;
    if (localImmutableList2 == null)
    {
      localImmutableList1 = createAsList();
      asList = localImmutableList1;
    }
    return localImmutableList1;
  }
  
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean contains(Object paramObject)
  {
    return (paramObject != null) && (Iterators.contains(iterator(), paramObject));
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    return Collections2.containsAllImpl(this, paramCollection);
  }
  
  public ImmutableList createAsList()
  {
    int i = size();
    if (i != 0)
    {
      if (i != 1) {
        return new RegularImmutableAsList(this, toArray());
      }
      return ImmutableList.of(iterator().next());
    }
    return ImmutableList.of();
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public abstract boolean isPartialView();
  
  public abstract UnmodifiableIterator iterator();
  
  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean removeAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean retainAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public Object[] toArray()
  {
    return ObjectArrays.toArrayImpl(this);
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    return ObjectArrays.toArrayImpl(this, paramArrayOfObject);
  }
  
  public String toString()
  {
    return Collections2.toStringImpl(this);
  }
  
  public Object writeReplace()
  {
    return new rb.d(toArray());
  }
}
