package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.cd;
import f.g.c.d.r;
import java.util.List;
import java.util.Map;

@b
public abstract class AbstractListMultimap<K, V>
  extends r<K, V>
  implements cd<K, V>
{
  public static final long serialVersionUID = 6588350623831699109L;
  
  public AbstractListMultimap(Map paramMap)
  {
    super(paramMap);
  }
  
  public Map asMap()
  {
    return super.asMap();
  }
  
  public abstract List createCollection();
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public List get(Object paramObject)
  {
    return (List)super.get(paramObject);
  }
  
  public boolean put(Object paramObject1, Object paramObject2)
  {
    return super.put(paramObject1, paramObject2);
  }
  
  public List removeAll(Object paramObject)
  {
    return (List)super.removeAll(paramObject);
  }
  
  public List replaceValues(Object paramObject, Iterable paramIterable)
  {
    return (List)super.replaceValues(paramObject, paramIterable);
  }
}
