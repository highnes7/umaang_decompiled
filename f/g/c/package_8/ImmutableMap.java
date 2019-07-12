package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Nb;
import f.g.c.d.rb;
import f.g.c.package_10.Preconditions;
import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@b(emulated=true, serializable=true)
public abstract class ImmutableMap<K, V>
  implements Map<K, V>, Serializable
{
  public transient Nb<Map.Entry<K, V>> entrySet;
  public transient Nb<K> keySet;
  public transient rb<V> values;
  
  public ImmutableMap() {}
  
  public static Ab.a builder()
  {
    return new Ab.a();
  }
  
  public static ImmutableMap copyOf(Map paramMap)
  {
    boolean bool = paramMap instanceof ImmutableMap;
    Object localObject = paramMap;
    if ((bool) && (!(localObject instanceof ImmutableSortedMap)))
    {
      localObject = (ImmutableMap)localObject;
      if (!((ImmutableMap)localObject).isPartialView()) {
        return localObject;
      }
    }
    paramMap = paramMap.entrySet();
    int i = 0;
    paramMap = (Map.Entry[])paramMap.toArray(new Map.Entry[0]);
    int j = paramMap.length;
    if (j != 0)
    {
      if (j != 1)
      {
        while (i < paramMap.length)
        {
          paramMap[i] = entryOf(paramMap[i].getKey(), paramMap[i].getValue());
          i += 1;
        }
        return new RegularImmutableMap(paramMap);
      }
      return new SingletonImmutableMap(entryOf(paramMap[0].getKey(), paramMap[0].getValue()));
    }
    return EmptyImmutableMap.INSTANCE;
  }
  
  public static Map.Entry entryOf(Object paramObject1, Object paramObject2)
  {
    Preconditions.checkNotNull(paramObject1, "null key in entry: null=%s", new Object[] { paramObject2 });
    Preconditions.checkNotNull(paramObject2, "null value in entry: %s=null", new Object[] { paramObject1 });
    return Maps.immutableEntry(paramObject1, paramObject2);
  }
  
  public static ImmutableMap of()
  {
    return EmptyImmutableMap.INSTANCE;
  }
  
  public static ImmutableMap of(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 != null) {
        return new SingletonImmutableMap(paramObject1, paramObject2);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static ImmutableMap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return new RegularImmutableMap(new Map.Entry[] { entryOf(paramObject1, paramObject2), entryOf(paramObject3, paramObject4) });
  }
  
  public static ImmutableMap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    return new RegularImmutableMap(new Map.Entry[] { entryOf(paramObject1, paramObject2), entryOf(paramObject3, paramObject4), entryOf(paramObject5, paramObject6) });
  }
  
  public static ImmutableMap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8)
  {
    return new RegularImmutableMap(new Map.Entry[] { entryOf(paramObject1, paramObject2), entryOf(paramObject3, paramObject4), entryOf(paramObject5, paramObject6), entryOf(paramObject7, paramObject8) });
  }
  
  public static ImmutableMap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10)
  {
    return new RegularImmutableMap(new Map.Entry[] { entryOf(paramObject1, paramObject2), entryOf(paramObject3, paramObject4), entryOf(paramObject5, paramObject6), entryOf(paramObject7, paramObject8), entryOf(paramObject9, paramObject10) });
  }
  
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return get(paramObject) != null;
  }
  
  public Object containsValue()
  {
    return new Ab.b(this);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return (paramObject != null) && (Maps.containsValueImpl(this, paramObject));
  }
  
  public abstract ImmutableSet createEntrySet();
  
  public ImmutableSet createKeySet()
  {
    return new ImmutableMap.1(this, entrySet());
  }
  
  public ImmutableCollection createValues()
  {
    return new ImmutableMap.2(this);
  }
  
  public ImmutableSet entrySet()
  {
    ImmutableSet localImmutableSet2 = entrySet;
    ImmutableSet localImmutableSet1 = localImmutableSet2;
    if (localImmutableSet2 == null)
    {
      localImmutableSet1 = createEntrySet();
      entrySet = localImmutableSet1;
    }
    return localImmutableSet1;
  }
  
  public boolean equals(Object paramObject)
  {
    return Maps.equalsImpl(this, paramObject);
  }
  
  public abstract Object get(Object paramObject);
  
  public int hashCode()
  {
    return entrySet().hashCode();
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public abstract boolean isPartialView();
  
  public ImmutableSet keySet()
  {
    ImmutableSet localImmutableSet2 = keySet;
    ImmutableSet localImmutableSet1 = localImmutableSet2;
    if (localImmutableSet2 == null)
    {
      localImmutableSet1 = createKeySet();
      keySet = localImmutableSet1;
    }
    return localImmutableSet1;
  }
  
  public final Object put(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void putAll(Map paramMap)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return Maps.toStringImpl(this);
  }
  
  public ImmutableCollection values()
  {
    ImmutableCollection localImmutableCollection2 = values;
    ImmutableCollection localImmutableCollection1 = localImmutableCollection2;
    if (localImmutableCollection2 == null)
    {
      localImmutableCollection1 = createValues();
      values = localImmutableCollection1;
    }
    return localImmutableCollection1;
  }
}
