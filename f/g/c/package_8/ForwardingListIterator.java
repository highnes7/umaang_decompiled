package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Oa;
import java.util.ListIterator;

@b
public abstract class ForwardingListIterator<E>
  extends Oa<E>
  implements ListIterator<E>
{
  public ForwardingListIterator() {}
  
  public void add(Object paramObject)
  {
    delegate().add(paramObject);
  }
  
  public abstract ListIterator delegate();
  
  public boolean hasPrevious()
  {
    return delegate().hasPrevious();
  }
  
  public int nextIndex()
  {
    return delegate().nextIndex();
  }
  
  public Object previous()
  {
    return delegate().previous();
  }
  
  public int previousIndex()
  {
    return delegate().previousIndex();
  }
  
  public void set(Object paramObject)
  {
    delegate().set(paramObject);
  }
}
