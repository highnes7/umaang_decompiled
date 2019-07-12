package f.g.c.package_8;

import f.g.c.package_10.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class FilterIterator
  implements Iterator<T>
{
  public Iterator<T> iterator = Iterators.EMPTY_LIST_ITERATOR;
  public Iterator<T> removeFrom;
  
  public FilterIterator(Iterable paramIterable) {}
  
  public boolean hasNext()
  {
    if (!iterator.hasNext()) {
      iterator = val$iterable.iterator();
    }
    return iterator.hasNext();
  }
  
  public Object next()
  {
    if (hasNext())
    {
      Iterator localIterator = iterator;
      removeFrom = localIterator;
      return localIterator.next();
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    boolean bool;
    if (removeFrom != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "no calls to next() since last call to remove()");
    removeFrom.remove();
    removeFrom = null;
  }
}
