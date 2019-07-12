package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ab;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@b(emulated=true, serializable=true)
public final class SingletonImmutableMap<K, V>
  extends Ab<K, V>
{
  public final transient K singleKey;
  public final transient V singleValue;
  
  public SingletonImmutableMap(Object paramObject1, Object paramObject2)
  {
    singleKey = paramObject1;
    singleValue = paramObject2;
  }
  
  public SingletonImmutableMap(Map.Entry paramEntry)
  {
    this(paramEntry.getKey(), paramEntry.getValue());
  }
  
  public boolean containsKey(Object paramObject)
  {
    return singleKey.equals(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return singleValue.equals(paramObject);
  }
  
  public ImmutableSet createEntrySet()
  {
    return ImmutableSet.of(Maps.immutableEntry(singleKey, singleValue));
  }
  
  public ImmutableSet createKeySet()
  {
    return ImmutableSet.of(singleKey);
  }
  
  public ImmutableCollection createValues()
  {
    return ImmutableList.of(singleValue);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (paramObject.size() == 1)
      {
        paramObject = (Map.Entry)paramObject.entrySet().iterator().next();
        return (singleKey.equals(paramObject.getKey())) && (singleValue.equals(paramObject.getValue()));
      }
    }
    return false;
  }
  
  public Object get(Object paramObject)
  {
    if (singleKey.equals(paramObject)) {
      return singleValue;
    }
    return null;
  }
  
  public int hashCode()
  {
    return singleKey.hashCode() ^ singleValue.hashCode();
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isPartialView()
  {
    return false;
  }
  
  public int size()
  {
    return 1;
  }
}
