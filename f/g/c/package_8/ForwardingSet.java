package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ja;
import java.util.Collection;
import java.util.Set;

@b
public abstract class ForwardingSet<E>
  extends Ja<E>
  implements Set<E>
{
  public ForwardingSet() {}
  
  public abstract Set delegate();
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (delegate().equals(paramObject));
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  public boolean standardEquals(Object paramObject)
  {
    return Sets.equalsImpl(this, paramObject);
  }
  
  public int standardHashCode()
  {
    return Sets.hashCodeImpl(this);
  }
  
  public boolean standardRemoveAll(Collection paramCollection)
  {
    if (paramCollection != null) {
      return Sets.removeAllImpl(this, paramCollection);
    }
    throw new NullPointerException();
  }
}
