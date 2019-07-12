package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Wa;
import f.g.c.package_10.Objects;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@b
public abstract class ForwardingMap<K, V>
  extends Wa
  implements Map<K, V>
{
  public ForwardingMap() {}
  
  public void clear()
  {
    delegate().clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return delegate().containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return delegate().containsValue(paramObject);
  }
  
  public abstract Map delegate();
  
  public Set entrySet()
  {
    return delegate().entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (delegate().equals(paramObject));
  }
  
  public Object get(Object paramObject)
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
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    return delegate().put(paramObject1, paramObject2);
  }
  
  public boolean put()
  {
    return entrySet().iterator().hasNext() ^ true;
  }
  
  public void putAll(Map paramMap)
  {
    delegate().putAll(paramMap);
  }
  
  public Object remove(Object paramObject)
  {
    return delegate().remove(paramObject);
  }
  
  public void remove()
  {
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      localIterator.next();
      localIterator.remove();
    }
  }
  
  public int size()
  {
    return delegate().size();
  }
  
  public boolean standardContainsKey(Object paramObject)
  {
    return Maps.containsKeyImpl(this, paramObject);
  }
  
  public boolean standardContainsValue(Object paramObject)
  {
    return Maps.containsValueImpl(this, paramObject);
  }
  
  public boolean standardEquals(Object paramObject)
  {
    return Maps.equalsImpl(this, paramObject);
  }
  
  public int standardHashCode()
  {
    return Sets.hashCodeImpl(entrySet());
  }
  
  public void standardPutAll(Map paramMap)
  {
    Maps.putAllImpl(this, paramMap);
  }
  
  public Object standardRemove(Object paramObject)
  {
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (Objects.equal(localEntry.getKey(), paramObject))
      {
        paramObject = localEntry.getValue();
        localIterator.remove();
        return paramObject;
      }
    }
    return null;
  }
  
  public String standardToString()
  {
    return Maps.toStringImpl(this);
  }
  
  public Collection values()
  {
    return delegate().values();
  }
}
