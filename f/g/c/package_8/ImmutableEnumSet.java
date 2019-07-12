package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Nb;
import java.util.Collection;
import java.util.EnumSet;

@b(emulated=true, serializable=true)
public final class ImmutableEnumSet<E extends Enum<E>>
  extends Nb<E>
{
  public final transient EnumSet<E> delegate;
  public transient int hashCode;
  
  public ImmutableEnumSet(EnumSet paramEnumSet)
  {
    delegate = paramEnumSet;
  }
  
  public boolean contains(Object paramObject)
  {
    return delegate.contains(paramObject);
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    return delegate.containsAll(paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (delegate.equals(paramObject));
  }
  
  public int hashCode()
  {
    int j = hashCode;
    int i = j;
    if (j == 0)
    {
      i = delegate.hashCode();
      hashCode = i;
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    return delegate.isEmpty();
  }
  
  public boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator iterator()
  {
    return Iterators.unmodifiableIterator(delegate.iterator());
  }
  
  public int size()
  {
    return delegate.size();
  }
  
  public Object[] toArray()
  {
    return delegate.toArray();
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    return delegate.toArray(paramArrayOfObject);
  }
  
  public String toString()
  {
    return delegate.toString();
  }
  
  public Object writeReplace()
  {
    return new tb.a(delegate);
  }
}
