package f.g.c.package_8;

import f.g.c.a.b;
import java.util.Iterator;

@b
public abstract class TransformedIterator<F, T>
  implements Iterator<T>
{
  public final Iterator<? extends F> backingIterator;
  
  public TransformedIterator(Iterator paramIterator)
  {
    if (paramIterator != null)
    {
      backingIterator = paramIterator;
      return;
    }
    throw new NullPointerException();
  }
  
  public final boolean hasNext()
  {
    return backingIterator.hasNext();
  }
  
  public final Object next()
  {
    return transform(backingIterator.next());
  }
  
  public final void remove()
  {
    backingIterator.remove();
  }
  
  public abstract Object transform(Object paramObject);
}
