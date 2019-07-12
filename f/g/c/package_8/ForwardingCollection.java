package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Wa;
import f.g.c.package_10.Objects;
import java.util.Collection;
import java.util.Iterator;

@b
public abstract class ForwardingCollection<E>
  extends Wa
  implements Collection<E>
{
  public ForwardingCollection() {}
  
  public boolean add()
  {
    return iterator().hasNext() ^ true;
  }
  
  public boolean add(Object paramObject)
  {
    return delegate().add(paramObject);
  }
  
  public boolean addAll(Collection paramCollection)
  {
    return delegate().addAll(paramCollection);
  }
  
  public void clear()
  {
    delegate().clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return delegate().contains(paramObject);
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    return delegate().containsAll(paramCollection);
  }
  
  public abstract Collection delegate();
  
  public boolean isEmpty()
  {
    return delegate().isEmpty();
  }
  
  public Iterator iterator()
  {
    return delegate().iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    return delegate().remove(paramObject);
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    return delegate().removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    return delegate().retainAll(paramCollection);
  }
  
  public int size()
  {
    return delegate().size();
  }
  
  public boolean standardAddAll(Collection paramCollection)
  {
    return Iterators.addAll(this, paramCollection.iterator());
  }
  
  public void standardClear()
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      localIterator.remove();
    }
  }
  
  public boolean standardContains(Object paramObject)
  {
    return Iterators.contains(iterator(), paramObject);
  }
  
  public boolean standardContainsAll(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean standardRemove(Object paramObject)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      if (Objects.equal(localIterator.next(), paramObject))
      {
        localIterator.remove();
        return true;
      }
    }
    return false;
  }
  
  public boolean standardRemoveAll(Collection paramCollection)
  {
    return Iterators.removeAll(iterator(), paramCollection);
  }
  
  public boolean standardRetainAll(Collection paramCollection)
  {
    return Iterators.retainAll(iterator(), paramCollection);
  }
  
  public Object[] standardToArray()
  {
    return toArray(new Object[size()]);
  }
  
  public Object[] standardToArray(Object[] paramArrayOfObject)
  {
    return ObjectArrays.toArrayImpl(this, paramArrayOfObject);
  }
  
  public String standardToString()
  {
    return Collections2.toStringImpl(this);
  }
  
  public Object[] toArray()
  {
    return delegate().toArray();
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    return delegate().toArray(paramArrayOfObject);
  }
}
