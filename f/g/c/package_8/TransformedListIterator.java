package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.gh;
import java.util.ListIterator;

@b
public abstract class TransformedListIterator<F, T>
  extends gh<F, T>
  implements ListIterator<T>
{
  public TransformedListIterator(ListIterator paramListIterator)
  {
    super(paramListIterator);
  }
  
  private ListIterator backingIterator()
  {
    return Iterators.cast(backingIterator);
  }
  
  public void add(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean hasPrevious()
  {
    return backingIterator().hasPrevious();
  }
  
  public final int nextIndex()
  {
    return backingIterator().nextIndex();
  }
  
  public final Object previous()
  {
    return transform(backingIterator().previous());
  }
  
  public final int previousIndex()
  {
    return backingIterator().previousIndex();
  }
  
  public void set(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
}
