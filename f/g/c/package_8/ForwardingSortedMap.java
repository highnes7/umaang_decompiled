package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Sa;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

@b
public abstract class ForwardingSortedMap<K, V>
  extends Sa<K, V>
  implements SortedMap<K, V>
{
  public ForwardingSortedMap() {}
  
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
  
  public abstract SortedMap delegate();
  
  public Object firstKey()
  {
    return delegate().firstKey();
  }
  
  public SortedMap headMap(Object paramObject)
  {
    return delegate().headMap(paramObject);
  }
  
  public Object lastKey()
  {
    return delegate().lastKey();
  }
  
  public boolean standardContainsKey(Object paramObject)
  {
    try
    {
      int i = unsafeCompare(tailMap(paramObject).firstKey(), paramObject);
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
  
  public Object standardRemove(Object paramObject)
  {
    try
    {
      Iterator localIterator = tailMap(paramObject).entrySet().iterator();
      boolean bool = localIterator.hasNext();
      if (bool)
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        int i = unsafeCompare(localEntry.getKey(), paramObject);
        if (i == 0)
        {
          paramObject = localEntry.getValue();
          localIterator.remove();
          return paramObject;
        }
      }
      else
      {
        return null;
      }
    }
    catch (ClassCastException paramObject)
    {
      return null;
    }
    catch (NullPointerException paramObject) {}
    return null;
  }
  
  public SortedMap standardSubMap(Object paramObject1, Object paramObject2)
  {
    return tailMap(paramObject1).headMap(paramObject2);
  }
  
  public SortedMap subMap(Object paramObject1, Object paramObject2)
  {
    return delegate().subMap(paramObject1, paramObject2);
  }
  
  public SortedMap tailMap(Object paramObject)
  {
    return delegate().tailMap(paramObject);
  }
}
