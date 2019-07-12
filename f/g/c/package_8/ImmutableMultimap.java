package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ab;
import f.g.c.d.Mb;
import f.g.c.d.rb;
import f.g.c.d.ve;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

@b(emulated=true)
public abstract class ImmutableMultimap<K, V>
  implements ve<K, V>, Serializable
{
  public static final long serialVersionUID = 0L;
  public transient rb<Map.Entry<K, V>> entries;
  public transient Mb<K> keys;
  public final transient Ab<K, ? extends rb<V>> map;
  public final transient int size;
  public transient rb<V> values;
  
  public ImmutableMultimap(ImmutableMap paramImmutableMap, int paramInt)
  {
    map = paramImmutableMap;
    size = paramInt;
  }
  
  public static Ib.a copyOf()
  {
    return new Ib.a();
  }
  
  public static ImmutableMultimap copyOf(Multimap paramMultimap)
  {
    if ((paramMultimap instanceof ImmutableMultimap))
    {
      ImmutableMultimap localImmutableMultimap = (ImmutableMultimap)paramMultimap;
      if (!localImmutableMultimap.isPartialView()) {
        return localImmutableMultimap;
      }
    }
    return ImmutableListMultimap.copyOf(paramMultimap);
  }
  
  private ImmutableMultiset createKeys()
  {
    return new Ib.e(this);
  }
  
  public static ImmutableMultimap of()
  {
    return EmptyImmutableListMultimap.INSTANCE;
  }
  
  public static ImmutableMultimap of(Object paramObject1, Object paramObject2)
  {
    return ImmutableListMultimap.of(paramObject1, paramObject2);
  }
  
  public static ImmutableMultimap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return ImmutableListMultimap.of(paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public static ImmutableMultimap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    return ImmutableListMultimap.of(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6);
  }
  
  public static ImmutableMultimap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8)
  {
    return ImmutableListMultimap.of(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8);
  }
  
  public static ImmutableMultimap of(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10)
  {
    return ImmutableListMultimap.of(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10);
  }
  
  public ImmutableMap asMap()
  {
    return map;
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsEntry(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Collection)map.get(paramObject1);
    return (paramObject1 != null) && (paramObject1.contains(paramObject2));
  }
  
  public boolean containsKey(Object paramObject)
  {
    return map.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    Iterator localIterator = map.values().iterator();
    while (localIterator.hasNext()) {
      if (((ImmutableCollection)localIterator.next()).contains(paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public ImmutableCollection entries()
  {
    Object localObject = entries;
    if (localObject == null)
    {
      localObject = new Ib.c(this);
      entries = ((ImmutableCollection)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Multimap))
    {
      paramObject = (Multimap)paramObject;
      return map.equals(paramObject.asMap());
    }
    return false;
  }
  
  public abstract ImmutableCollection get(Object paramObject);
  
  public int hashCode()
  {
    return map.hashCode();
  }
  
  public abstract ImmutableMultimap inverse();
  
  public boolean isEmpty()
  {
    return size == 0;
  }
  
  public boolean isPartialView()
  {
    return map.isPartialView();
  }
  
  public ImmutableSet keySet()
  {
    return map.keySet();
  }
  
  public ImmutableMultiset keys()
  {
    Object localObject = keys;
    if (localObject == null)
    {
      localObject = new Ib.e(this);
      keys = ((ImmutableMultiset)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public boolean put(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean putAll(Multimap paramMultimap)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean putAll(Object paramObject, Iterable paramIterable)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableCollection removeAll(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableCollection replaceValues(Object paramObject, Iterable paramIterable)
  {
    throw new UnsupportedOperationException();
  }
  
  public int size()
  {
    return size;
  }
  
  public String toString()
  {
    return map.toString();
  }
  
  public ImmutableCollection values()
  {
    Object localObject = values;
    if (localObject == null)
    {
      localObject = new Ib.f(this);
      values = ((ImmutableCollection)localObject);
      return localObject;
    }
    return localObject;
  }
}
