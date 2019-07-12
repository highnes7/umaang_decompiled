package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.ve;
import java.util.Map;
import java.util.Set;

@b
public abstract interface SetMultimap<K, V>
  extends ve<K, V>
{
  public abstract Map asMap();
  
  public abstract Set entries();
  
  public abstract boolean equals(Object paramObject);
  
  public abstract Set get(Object paramObject);
  
  public abstract Set removeAll(Object paramObject);
  
  public abstract Set replaceValues(Object paramObject, Iterable paramIterable);
}
