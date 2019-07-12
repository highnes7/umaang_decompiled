package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ja;
import f.g.c.d.Ye;
import f.g.c.package_10.Objects;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@b
public abstract class ForwardingMultiset<E>
  extends Ja<E>
  implements Ye<E>
{
  public ForwardingMultiset() {}
  
  public int add(Object paramObject, int paramInt)
  {
    return delegate().add(paramObject, paramInt);
  }
  
  public int count(Object paramObject)
  {
    return delegate().count(paramObject);
  }
  
  public abstract Multiset delegate();
  
  public Set elementSet()
  {
    return delegate().elementSet();
  }
  
  public Set entrySet()
  {
    return delegate().entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (delegate().equals(paramObject));
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  public int remove(Object paramObject, int paramInt)
  {
    return delegate().remove(paramObject, paramInt);
  }
  
  public int setCount(Object paramObject, int paramInt)
  {
    return delegate().setCount(paramObject, paramInt);
  }
  
  public boolean setCount(Object paramObject, int paramInt1, int paramInt2)
  {
    return delegate().setCount(paramObject, paramInt1, paramInt2);
  }
  
  public boolean standardAdd(Object paramObject)
  {
    add(paramObject, 1);
    return true;
  }
  
  public boolean standardAddAll(Collection paramCollection)
  {
    return Multisets.addAllImpl(this, paramCollection);
  }
  
  public void standardClear()
  {
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      localIterator.remove();
    }
  }
  
  public boolean standardContains(Object paramObject)
  {
    return count(paramObject) > 0;
  }
  
  public int standardCount(Object paramObject)
  {
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Ye.a localA = (Ye.a)localIterator.next();
      if (Objects.equal(localA.getElement(), paramObject)) {
        return localA.getCount();
      }
    }
    return 0;
  }
  
  public boolean standardEquals(Object paramObject)
  {
    return Multisets.equalsImpl(this, paramObject);
  }
  
  public int standardHashCode()
  {
    return entrySet().hashCode();
  }
  
  public Iterator standardIterator()
  {
    return Multisets.iteratorImpl(this);
  }
  
  public boolean standardRemove(Object paramObject)
  {
    return remove(paramObject, 1) > 0;
  }
  
  public boolean standardRemoveAll(Collection paramCollection)
  {
    return Multisets.removeAllImpl(this, paramCollection);
  }
  
  public boolean standardRetainAll(Collection paramCollection)
  {
    return Multisets.retainAllImpl(this, paramCollection);
  }
  
  public int standardSetCount(Object paramObject, int paramInt)
  {
    return Multisets.setCountImpl(this, paramObject, paramInt);
  }
  
  public boolean standardSetCount(Object paramObject, int paramInt1, int paramInt2)
  {
    return Multisets.setCountImpl(this, paramObject, paramInt1, paramInt2);
  }
  
  public int standardSize()
  {
    return Multisets.sizeImpl(this);
  }
  
  public String standardToString()
  {
    return entrySet().toString();
  }
}
