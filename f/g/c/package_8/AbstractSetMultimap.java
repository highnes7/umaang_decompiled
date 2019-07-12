package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.bg;
import f.g.c.d.r;
import java.util.Map;
import java.util.Set;

@b
public abstract class AbstractSetMultimap<K, V>
  extends r<K, V>
  implements bg<K, V>
{
  public static final long serialVersionUID = 7431625294878419160L;
  
  public AbstractSetMultimap(Map paramMap)
  {
    super(paramMap);
  }
  
  public Map asMap()
  {
    return super.asMap();
  }
  
  public abstract Set createCollection();
  
  public Set entries()
  {
    return (Set)super.entries();
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public Set get(Object paramObject)
  {
    return (Set)super.get(paramObject);
  }
  
  public boolean put(Object paramObject1, Object paramObject2)
  {
    return super.put(paramObject1, paramObject2);
  }
  
  public Set removeAll(Object paramObject)
  {
    return (Set)super.removeAll(paramObject);
  }
  
  public Set replaceValues(Object paramObject, Iterable paramIterable)
  {
    return (Set)super.replaceValues(paramObject, paramIterable);
  }
}
