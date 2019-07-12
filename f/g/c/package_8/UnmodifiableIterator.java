package f.g.c.package_8;

import f.g.c.a.b;
import java.util.Iterator;

@b
public abstract class UnmodifiableIterator<E>
  implements Iterator<E>
{
  public UnmodifiableIterator() {}
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}
