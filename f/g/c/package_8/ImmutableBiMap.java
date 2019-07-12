package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ab;
import f.g.c.d.L;
import java.util.Map;

@b(emulated=true, serializable=true)
public abstract class ImmutableBiMap<K, V>
  extends Ab<K, V>
  implements L<K, V>
{
  public ImmutableBiMap() {}
  
  public static nb.a builder()
  {
    return new nb.a();
  }
  
  public static ImmutableBiMap copyOf(Map paramMap)
  {
    if ((paramMap instanceof ImmutableBiMap))
    {
      ImmutableBiMap localImmutableBiMap = (ImmutableBiMap)paramMap;
      if (!localImmutableBiMap.isPartialView()) {
        return localImmutableBiMap;
      }
    }
    if (paramMap.isEmpty()) {
      return EmptyImmutableBiMap.INSTANCE;
    }
    return new RegularImmutableBiMap(ImmutableMap.copyOf(paramMap));
  }
  
  public static ImmutableBiMap of()
  {
    return EmptyImmutableBiMap.INSTANCE;
  }
  
  public static ImmutableBiMap of(Object paramObject1, Object paramObject2)
  {
    return new RegularImmutableBiMap(ImmutableMap.of(paramObject1, paramObject2));
  }
  
  public static ImmutableBiMap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return new RegularImmutableBiMap(ImmutableMap.of(paramObject1, paramObject2, paramObject3, paramObject4));
  }
  
  public static ImmutableBiMap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    return new RegularImmutableBiMap(ImmutableMap.of(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6));
  }
  
  public static ImmutableBiMap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8)
  {
    return new RegularImmutableBiMap(ImmutableMap.of(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8));
  }
  
  public static ImmutableBiMap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10)
  {
    return new RegularImmutableBiMap(ImmutableMap.of(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10));
  }
  
  public boolean containsKey(Object paramObject)
  {
    return delegate().containsKey(paramObject);
  }
  
  public Object containsValue()
  {
    return new nb.b(this);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return inverse().containsKey(paramObject);
  }
  
  public ImmutableSet createEntrySet()
  {
    return delegate().entrySet();
  }
  
  public abstract ImmutableMap delegate();
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (delegate().equals(paramObject));
  }
  
  public Object forcePut(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }
  
  public Object get(Object paramObject)
  {
    return delegate().get(paramObject);
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  public abstract ImmutableBiMap inverse();
  
  public boolean isEmpty()
  {
    return delegate().isEmpty();
  }
  
  public ImmutableSet keySet()
  {
    return delegate().keySet();
  }
  
  public int size()
  {
    return delegate().size();
  }
  
  public String toString()
  {
    return delegate().toString();
  }
  
  public ImmutableSet values()
  {
    return inverse().keySet();
  }
}
