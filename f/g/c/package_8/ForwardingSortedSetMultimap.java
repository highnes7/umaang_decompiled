package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Eg;
import f.g.c.d.Za;
import java.util.Comparator;
import java.util.SortedSet;

@b
public abstract class ForwardingSortedSetMultimap<K, V>
  extends Za<K, V>
  implements Eg<K, V>
{
  public ForwardingSortedSetMultimap() {}
  
  public abstract SortedSetMultimap delegate();
  
  public SortedSet get(Object paramObject)
  {
    return delegate().get(paramObject);
  }
  
  public SortedSet removeAll(Object paramObject)
  {
    return delegate().removeAll(paramObject);
  }
  
  public SortedSet replaceValues(Object paramObject, Iterable paramIterable)
  {
    return delegate().replaceValues(paramObject, paramIterable);
  }
  
  public Comparator valueComparator()
  {
    return delegate().valueComparator();
  }
}
