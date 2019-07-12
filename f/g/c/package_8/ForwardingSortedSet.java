package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ya;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

@b
public abstract class ForwardingSortedSet<E>
  extends Ya<E>
  implements SortedSet<E>
{
  public ForwardingSortedSet() {}
  
  private int unsafeCompare(Object paramObject1, Object paramObject2)
  {
    Comparator localComparator = comparator();
    if (localComparator == null) {
      return ((Comparable)paramObject1).compareTo(paramObject2);
    }
    return localComparator.compare(paramObject1, paramObject2);
  }
  
  public Comparator comparator()
  {
    return delegate().comparator();
  }
  
  public abstract SortedSet delegate();
  
  public Object first()
  {
    return delegate().first();
  }
  
  public SortedSet headSet(Object paramObject)
  {
    return delegate().headSet(paramObject);
  }
  
  public Object last()
  {
    return delegate().last();
  }
  
  public boolean standardContains(Object paramObject)
  {
    try
    {
      int i = unsafeCompare(tailSet(paramObject).first(), paramObject);
      if (i == 0) {
        return true;
      }
    }
    catch (ClassCastException paramObject)
    {
      return false;
    }
    catch (NoSuchElementException paramObject)
    {
      return false;
    }
    catch (NullPointerException paramObject) {}
    return false;
  }
  
  public boolean standardRemove(Object paramObject)
  {
    try
    {
      Iterator localIterator = tailSet(paramObject).iterator();
      boolean bool = localIterator.hasNext();
      if (bool)
      {
        int i = unsafeCompare(localIterator.next(), paramObject);
        if (i == 0)
        {
          localIterator.remove();
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    catch (ClassCastException paramObject)
    {
      return false;
    }
    catch (NullPointerException paramObject) {}
    return false;
  }
  
  public SortedSet standardSubSet(Object paramObject1, Object paramObject2)
  {
    return tailSet(paramObject1).headSet(paramObject2);
  }
  
  public SortedSet subSet(Object paramObject1, Object paramObject2)
  {
    return delegate().subSet(paramObject1, paramObject2);
  }
  
  public SortedSet tailSet(Object paramObject)
  {
    return delegate().tailSet(paramObject);
  }
}
