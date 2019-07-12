package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ja;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@b
public abstract class ForwardingList<E>
  extends Ja<E>
  implements List<E>
{
  public ForwardingList() {}
  
  public void add(int paramInt, Object paramObject)
  {
    delegate().add(paramInt, paramObject);
  }
  
  public boolean addAll(int paramInt, Collection paramCollection)
  {
    return delegate().addAll(paramInt, paramCollection);
  }
  
  public abstract List delegate();
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (delegate().equals(paramObject));
  }
  
  public Object get(int paramInt)
  {
    return delegate().get(paramInt);
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  public int indexOf(Object paramObject)
  {
    return delegate().indexOf(paramObject);
  }
  
  public int lastIndexOf(Object paramObject)
  {
    return delegate().lastIndexOf(paramObject);
  }
  
  public ListIterator listIterator()
  {
    return delegate().listIterator();
  }
  
  public ListIterator listIterator(int paramInt)
  {
    return delegate().listIterator(paramInt);
  }
  
  public Object remove(int paramInt)
  {
    return delegate().remove(paramInt);
  }
  
  public Object set(int paramInt, Object paramObject)
  {
    return delegate().set(paramInt, paramObject);
  }
  
  public boolean standardAdd(Object paramObject)
  {
    add(size(), paramObject);
    return true;
  }
  
  public boolean standardAddAll(int paramInt, Iterable paramIterable)
  {
    return Lists.addAllImpl(this, paramInt, paramIterable);
  }
  
  public boolean standardEquals(Object paramObject)
  {
    return Lists.equalsImpl(this, paramObject);
  }
  
  public int standardHashCode()
  {
    return Lists.hashCodeImpl(this);
  }
  
  public int standardIndexOf(Object paramObject)
  {
    return Lists.indexOfImpl(this, paramObject);
  }
  
  public Iterator standardIterator()
  {
    return listIterator();
  }
  
  public int standardLastIndexOf(Object paramObject)
  {
    return Lists.lastIndexOfImpl(this, paramObject);
  }
  
  public ListIterator standardListIterator()
  {
    return listIterator(0);
  }
  
  public ListIterator standardListIterator(int paramInt)
  {
    return Lists.listIteratorImpl(this, paramInt);
  }
  
  public List standardSubList(int paramInt1, int paramInt2)
  {
    return Lists.subListImpl(this, paramInt1, paramInt2);
  }
  
  public List subList(int paramInt1, int paramInt2)
  {
    return delegate().subList(paramInt1, paramInt2);
  }
}
