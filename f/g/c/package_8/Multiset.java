package f.g.c.package_8;

import f.g.c.a.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@b
public abstract interface Multiset<E>
  extends Collection<E>
{
  public abstract int add(Object paramObject, int paramInt);
  
  public abstract boolean add(Object paramObject);
  
  public abstract boolean contains(Object paramObject);
  
  public abstract boolean containsAll(Collection paramCollection);
  
  public abstract int count(Object paramObject);
  
  public abstract Set elementSet();
  
  public abstract Set entrySet();
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
  
  public abstract Iterator iterator();
  
  public abstract int remove(Object paramObject, int paramInt);
  
  public abstract boolean remove(Object paramObject);
  
  public abstract boolean removeAll(Collection paramCollection);
  
  public abstract boolean retainAll(Collection paramCollection);
  
  public abstract int setCount(Object paramObject, int paramInt);
  
  public abstract boolean setCount(Object paramObject, int paramInt1, int paramInt2);
  
  public abstract String toString();
}
