package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.ve;
import java.util.List;
import java.util.Map;

@b
public abstract interface ListMultimap<K, V>
  extends ve<K, V>
{
  public abstract Map asMap();
  
  public abstract boolean equals(Object paramObject);
  
  public abstract List get(Object paramObject);
  
  public abstract List removeAll(Object paramObject);
  
  public abstract List replaceValues(Object paramObject, Iterable paramIterable);
}
