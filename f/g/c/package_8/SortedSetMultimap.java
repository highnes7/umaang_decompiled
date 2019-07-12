package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.bg;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;

@b
public abstract interface SortedSetMultimap<K, V>
  extends bg<K, V>
{
  public abstract Map asMap();
  
  public abstract SortedSet get(Object paramObject);
  
  public abstract SortedSet removeAll(Object paramObject);
  
  public abstract SortedSet replaceValues(Object paramObject, Iterable paramIterable);
  
  public abstract Comparator valueComparator();
}
