package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Wa;
import java.util.Iterator;

@b
public abstract class ForwardingIterator<T>
  extends Wa
  implements Iterator<T>
{
  public ForwardingIterator() {}
  
  public abstract Iterator delegate();
  
  public boolean hasNext()
  {
    return delegate().hasNext();
  }
  
  public Object next()
  {
    return delegate().next();
  }
  
  public void remove()
  {
    delegate().remove();
  }
}
