package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Wa;
import f.g.c.d.ve;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@b
public abstract class ForwardingMultimap<K, V>
  extends Wa
  implements ve<K, V>
{
  public ForwardingMultimap() {}
  
  public Map asMap()
  {
    return delegate().asMap();
  }
  
  public void clear()
  {
    delegate().clear();
  }
  
  public boolean containsEntry(Object paramObject1, Object paramObject2)
  {
    return delegate().containsEntry(paramObject1, paramObject2);
  }
  
  public boolean containsKey(Object paramObject)
  {
    return delegate().containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return delegate().containsValue(paramObject);
  }
  
  public abstract Multimap delegate();
  
  public Collection entries()
  {
    return delegate().entries();
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (delegate().equals(paramObject));
  }
  
  public Collection get(Object paramObject)
  {
    return delegate().get(paramObject);
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  public boolean isEmpty()
  {
    return delegate().isEmpty();
  }
  
  public Set keySet()
  {
    return delegate().keySet();
  }
  
  public Multiset keys()
  {
    return delegate().keys();
  }
  
  public boolean put(Object paramObject1, Object paramObject2)
  {
    return delegate().put(paramObject1, paramObject2);
  }
  
  public boolean putAll(Multimap paramMultimap)
  {
    return delegate().putAll(paramMultimap);
  }
  
  public boolean putAll(Object paramObject, Iterable paramIterable)
  {
    return delegate().putAll(paramObject, paramIterable);
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    return delegate().remove(paramObject1, paramObject2);
  }
  
  public Collection removeAll(Object paramObject)
  {
    return delegate().removeAll(paramObject);
  }
  
  public Collection replaceValues(Object paramObject, Iterable paramIterable)
  {
    return delegate().replaceValues(paramObject, paramIterable);
  }
  
  public int size()
  {
    return delegate().size();
  }
  
  public Collection values()
  {
    return delegate().values();
  }
}
