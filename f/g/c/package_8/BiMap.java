package f.g.c.package_8;

import f.g.c.a.b;
import java.util.Map;
import java.util.Set;

@b
public abstract interface BiMap<K, V>
  extends Map<K, V>
{
  public abstract Object forcePut(Object paramObject1, Object paramObject2);
  
  public abstract BiMap inverse();
  
  public abstract Object put(Object paramObject1, Object paramObject2);
  
  public abstract void putAll(Map paramMap);
  
  public abstract Set values();
}
