package f.g.c.package_8;

import f.g.c.b.J;
import f.g.c.package_10.Function;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class Stack<F, T>
  extends AbstractCollection<T>
{
  public final Collection<F> c;
  public final J<? super F, ? extends T> entries;
  
  public Stack(Collection paramCollection, Function paramFunction)
  {
    if (paramCollection != null)
    {
      c = paramCollection;
      if (paramFunction != null)
      {
        entries = paramFunction;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public void clear()
  {
    c.clear();
  }
  
  public boolean isEmpty()
  {
    return c.isEmpty();
  }
  
  public Iterator iterator()
  {
    return Iterators.transform(c.iterator(), entries);
  }
  
  public int size()
  {
    return c.size();
  }
}
