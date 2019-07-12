package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Eg;
import f.g.c.d.v;
import java.util.Collection;
import java.util.Map;
import java.util.SortedSet;

@b
public abstract class AbstractSortedSetMultimap<K, V>
  extends v<K, V>
  implements Eg<K, V>
{
  public static final long serialVersionUID = 430848587173315748L;
  
  public AbstractSortedSetMultimap(Map paramMap)
  {
    super(paramMap);
  }
  
  public Map asMap()
  {
    return super.asMap();
  }
  
  public abstract SortedSet createCollection();
  
  public SortedSet get(Object paramObject)
  {
    return (SortedSet)super.get(paramObject);
  }
  
  public SortedSet removeAll(Object paramObject)
  {
    return (SortedSet)super.removeAll(paramObject);
  }
  
  public SortedSet replaceValues(Object paramObject, Iterable paramIterable)
  {
    return (SortedSet)super.replaceValues(paramObject, paramIterable);
  }
  
  public Collection values()
  {
    return super.values();
  }
}
