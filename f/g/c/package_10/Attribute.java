package f.g.c.package_10;

import f.g.c.a.b;
import java.util.Iterator;
import java.util.NoSuchElementException;

@b
public abstract class Attribute<T>
  implements Iterator<T>
{
  public c a = c.a;
  public T b;
  
  public Attribute() {}
  
  private boolean b()
  {
    a = c.d;
    b = a();
    if (a != c.b)
    {
      a = c.c;
      return true;
    }
    return false;
  }
  
  public abstract Object a();
  
  public final boolean hasNext()
  {
    boolean bool;
    if (a != c.d) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    int i = a.ordinal();
    if (i != 0)
    {
      if (i != 2) {
        return b();
      }
      return false;
    }
    return true;
  }
  
  public final Object next()
  {
    if (hasNext())
    {
      a = c.a;
      return b;
    }
    throw new NoSuchElementException();
  }
  
  public final Object read()
  {
    a = c.b;
    return null;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}
