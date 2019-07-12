package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Sa;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@b
public final class WellBehavedMap<K, V>
  extends Sa<K, V>
{
  public final Map<K, V> delegate;
  public Set<Map.Entry<K, V>> entrySet;
  
  public WellBehavedMap(Map paramMap)
  {
    delegate = paramMap;
  }
  
  public static WellBehavedMap wrap(Map paramMap)
  {
    return new WellBehavedMap(paramMap);
  }
  
  public Map delegate()
  {
    return delegate;
  }
  
  public Set entrySet()
  {
    Object localObject = entrySet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new zh.a(this, null);
    entrySet = ((Set)localObject);
    return localObject;
  }
}
