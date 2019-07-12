package f.g.c.package_8;

import f.g.c.a.b;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@b
public abstract interface Multimap<K, V>
{
  public abstract Map asMap();
  
  public abstract void clear();
  
  public abstract boolean containsEntry(Object paramObject1, Object paramObject2);
  
  public abstract boolean containsKey(Object paramObject);
  
  public abstract boolean containsValue(Object paramObject);
  
  public abstract Collection entries();
  
  public abstract boolean equals(Object paramObject);
  
  public abstract Collection get(Object paramObject);
  
  public abstract int hashCode();
  
  public abstract boolean isEmpty();
  
  public abstract Set keySet();
  
  public abstract Multiset keys();
  
  public abstract boolean put(Object paramObject1, Object paramObject2);
  
  public abstract boolean putAll(Multimap paramMultimap);
  
  public abstract boolean putAll(Object paramObject, Iterable paramIterable);
  
  public abstract boolean remove(Object paramObject1, Object paramObject2);
  
  public abstract Collection removeAll(Object paramObject);
  
  public abstract Collection replaceValues(Object paramObject, Iterable paramIterable);
  
  public abstract int size();
  
  public abstract Collection values();
}
