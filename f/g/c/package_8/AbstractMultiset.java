package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ye;
import f.g.c.d.bf.b;
import f.g.c.d.bf.c;
import f.g.c.package_10.Objects;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@b
public abstract class AbstractMultiset<E>
  extends AbstractCollection<E>
  implements Ye<E>
{
  public transient Set<E> elementSet;
  public transient Set<f.g.c.d.Ye.a<E>> entrySet;
  
  public AbstractMultiset() {}
  
  public int add(Object paramObject, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean add(Object paramObject)
  {
    add(paramObject, 1);
    return true;
  }
  
  public boolean addAll(Collection paramCollection)
  {
    return Multisets.addAllImpl(this, paramCollection);
  }
  
  public void clear()
  {
    Iterators.clear(entryIterator());
  }
  
  public boolean contains(Object paramObject)
  {
    return count(paramObject) > 0;
  }
  
  public int count(Object paramObject)
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
  
  public Set createElementSet()
  {
    return new ElementSet();
  }
  
  public Set createEntrySet()
  {
    return new EntrySet();
  }
  
  public abstract int distinctElements();
  
  public Set elementSet()
  {
    Set localSet2 = elementSet;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = createElementSet();
      elementSet = localSet1;
    }
    return localSet1;
  }
  
  public abstract Iterator entryIterator();
  
  public Set entrySet()
  {
    Set localSet2 = entrySet;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = createEntrySet();
      entrySet = localSet1;
    }
    return localSet1;
  }
  
  public boolean equals(Object paramObject)
  {
    return Multisets.equalsImpl(this, paramObject);
  }
  
  public int hashCode()
  {
    return entrySet().hashCode();
  }
  
  public boolean isEmpty()
  {
    return entrySet().isEmpty();
  }
  
  public Iterator iterator()
  {
    return Multisets.iteratorImpl(this);
  }
  
  public int remove(Object paramObject, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean remove(Object paramObject)
  {
    return remove(paramObject, 1) > 0;
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    return Multisets.removeAllImpl(this, paramCollection);
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    return Multisets.retainAllImpl(this, paramCollection);
  }
  
  public int setCount(Object paramObject, int paramInt)
  {
    return Multisets.setCountImpl(this, paramObject, paramInt);
  }
  
  public boolean setCount(Object paramObject, int paramInt1, int paramInt2)
  {
    return Multisets.setCountImpl(this, paramObject, paramInt1, paramInt2);
  }
  
  public int size()
  {
    return Multisets.sizeImpl(this);
  }
  
  public String toString()
  {
    return entrySet().toString();
  }
  
  public class ElementSet
    extends bf.b<E>
  {
    public ElementSet() {}
    
    public Multiset multiset()
    {
      return AbstractMultiset.this;
    }
  }
  
  public class EntrySet
    extends bf.c<E>
  {
    public EntrySet() {}
    
    public Iterator iterator()
    {
      return entryIterator();
    }
    
    public Multiset multiset()
    {
      return AbstractMultiset.this;
    }
    
    public int size()
    {
      return distinctElements();
    }
  }
}
