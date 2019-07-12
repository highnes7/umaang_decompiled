package f.g.c.package_8;

import f.g.c.a.b;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@b
public abstract interface Table<R, C, V>
{
  public abstract Set cellSet();
  
  public abstract void clear();
  
  public abstract Map column(Object paramObject);
  
  public abstract Set columnKeySet();
  
  public abstract Map columnMap();
  
  public abstract boolean contains(Object paramObject1, Object paramObject2);
  
  public abstract boolean containsColumn(Object paramObject);
  
  public abstract boolean containsRow(Object paramObject);
  
  public abstract boolean containsValue(Object paramObject);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract Object get(Object paramObject1, Object paramObject2);
  
  public abstract int hashCode();
  
  public abstract boolean isEmpty();
  
  public abstract Object put(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract void putAll(Table paramTable);
  
  public abstract Object remove(Object paramObject1, Object paramObject2);
  
  public abstract Map row(Object paramObject);
  
  public abstract Set rowKeySet();
  
  public abstract Map rowMap();
  
  public abstract int size();
  
  public abstract Collection values();
}
