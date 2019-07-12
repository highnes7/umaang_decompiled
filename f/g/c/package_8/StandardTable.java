package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.b.ya;
import f.g.c.d.Ig;
import f.g.c.d.Yg;
import f.g.c.d.gb;
import f.g.c.package_10.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@b
public class StandardTable<R, C, V>
  implements Yg<R, C, V>, Serializable
{
  public static final long serialVersionUID = 0L;
  @gb
  public final Map<R, Map<C, V>> backingMap;
  public transient Ig<R, C, V>.b cellSet;
  public transient Set<C> columnKeySet;
  public transient Ig<R, C, V>.f columnMap;
  @gb
  public final ya<? extends Map<C, V>> factory;
  public transient Ig<R, C, V>.h rowKeySet;
  public transient Ig<R, C, V>.i rowMap;
  public transient Ig<R, C, V>.l values;
  
  public StandardTable(Map paramMap, Supplier paramSupplier)
  {
    backingMap = paramMap;
    factory = paramSupplier;
  }
  
  private boolean containsMapping(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return (paramObject3 != null) && (paramObject3.equals(get(paramObject1, paramObject2)));
  }
  
  private Map getOrCreate(Object paramObject)
  {
    Map localMap = (Map)backingMap.get(paramObject);
    if (localMap == null)
    {
      localMap = (Map)factory.get();
      backingMap.put(paramObject, localMap);
      return localMap;
    }
    return localMap;
  }
  
  private Map removeColumn(Object paramObject)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = backingMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = ((Map)localEntry.getValue()).remove(paramObject);
      if (localObject != null)
      {
        localLinkedHashMap.put(localEntry.getKey(), localObject);
        if (((Map)localEntry.getValue()).isEmpty()) {
          localIterator.remove();
        }
      }
    }
    return localLinkedHashMap;
  }
  
  private boolean removeMapping(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (containsMapping(paramObject1, paramObject2, paramObject3))
    {
      remove(paramObject1, paramObject2);
      return true;
    }
    return false;
  }
  
  public Set cellSet()
  {
    Ig.b localB2 = cellSet;
    Ig.b localB1 = localB2;
    if (localB2 == null)
    {
      localB1 = new Ig.b(this, null);
      cellSet = localB1;
    }
    return localB1;
  }
  
  public void clear()
  {
    backingMap.clear();
  }
  
  public Map column(Object paramObject)
  {
    return new Ig.c(this, paramObject);
  }
  
  public Set columnKeySet()
  {
    Object localObject = columnKeySet;
    if (localObject == null)
    {
      localObject = new Ig.e(this, null);
      columnKeySet = ((Set)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public Map columnMap()
  {
    Ig.f localF2 = columnMap;
    Ig.f localF1 = localF2;
    if (localF2 == null)
    {
      localF1 = new Ig.f(this, null);
      columnMap = localF1;
    }
    return localF1;
  }
  
  public boolean contains(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 == null) {
        return false;
      }
      paramObject1 = (Map)Maps.safeGet(backingMap, paramObject1);
      if ((paramObject1 != null) && (Maps.safeContainsKey(paramObject1, paramObject2))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean containsColumn(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    Iterator localIterator = backingMap.values().iterator();
    while (localIterator.hasNext()) {
      if (Maps.safeContainsKey((Map)localIterator.next(), paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean containsRow(Object paramObject)
  {
    return (paramObject != null) && (Maps.safeContainsKey(backingMap, paramObject));
  }
  
  public boolean containsValue(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    Iterator localIterator = backingMap.values().iterator();
    while (localIterator.hasNext()) {
      if (((Map)localIterator.next()).containsValue(paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public Iterator createColumnKeyIterator()
  {
    return new Ig.d(this);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Table))
    {
      paramObject = (Table)paramObject;
      return cellSet().equals(paramObject.cellSet());
    }
    return false;
  }
  
  public Object get(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 == null) {
        return null;
      }
      paramObject1 = (Map)Maps.safeGet(backingMap, paramObject1);
      if (paramObject1 == null) {
        return null;
      }
      return Maps.safeGet(paramObject1, paramObject2);
    }
    return null;
  }
  
  public int hashCode()
  {
    return cellSet().hashCode();
  }
  
  public boolean isEmpty()
  {
    return backingMap.isEmpty();
  }
  
  public Object put(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 != null)
      {
        if (paramObject3 != null) {
          return getOrCreate(paramObject1).put(paramObject2, paramObject3);
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public void putAll(Table paramTable)
  {
    paramTable = paramTable.cellSet().iterator();
    while (paramTable.hasNext())
    {
      Yg.a localA = (Yg.a)paramTable.next();
      put(localA.getRowKey(), localA.getColumnKey(), localA.getValue());
    }
  }
  
  public Object remove(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 == null) {
        return null;
      }
      Map localMap = (Map)Maps.safeGet(backingMap, paramObject1);
      if (localMap == null) {
        return null;
      }
      paramObject2 = localMap.remove(paramObject2);
      if (localMap.isEmpty())
      {
        backingMap.remove(paramObject1);
        return paramObject2;
      }
    }
    else
    {
      return null;
    }
    return paramObject2;
  }
  
  public Map row(Object paramObject)
  {
    return new Ig.g(this, paramObject);
  }
  
  public Set rowKeySet()
  {
    Ig.h localH2 = rowKeySet;
    Ig.h localH1 = localH2;
    if (localH2 == null)
    {
      localH1 = new Ig.h(this);
      rowKeySet = localH1;
    }
    return localH1;
  }
  
  public Map rowMap()
  {
    Ig.i localI2 = rowMap;
    Ig.i localI1 = localI2;
    if (localI2 == null)
    {
      localI1 = new Ig.i(this);
      rowMap = localI1;
    }
    return localI1;
  }
  
  public int size()
  {
    Iterator localIterator = backingMap.values().iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((Map)localIterator.next()).size();
    }
    return i;
  }
  
  public String toString()
  {
    return rowMap().toString();
  }
  
  public Collection values()
  {
    Ig.l localL2 = values;
    Ig.l localL1 = localL2;
    if (localL2 == null)
    {
      localL1 = new Ig.l(this, null);
      values = localL1;
    }
    return localL1;
  }
}
