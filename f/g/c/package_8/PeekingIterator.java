package f.g.c.package_8;

import f.g.c.a.b;
import java.util.Iterator;

@b
public abstract interface PeekingIterator<E>
  extends Iterator<E>
{
  public abstract Object next();
  
  public abstract Object peek();
  
  public abstract void remove();
}
