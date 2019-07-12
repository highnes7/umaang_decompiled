package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ye;
import f.g.c.d.r;
import f.g.c.d.ve;
import f.g.c.package_10.Preconditions;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@b
public abstract class AbstractMultimap<K, V>
  implements ve<K, V>, Serializable
{
  public static final long serialVersionUID = 2447537837011683357L;
  public transient Map<K, Collection<V>> asMap;
  public transient Collection<Map.Entry<K, V>> entries;
  public transient Set<K> keySet;
  public transient Ye<K> keys;
  public transient Map<K, Collection<V>> map;
  public transient int totalSize;
  public transient Collection<V> values;
  
  public AbstractMultimap(Map paramMap)
  {
    Preconditions.checkArgument(paramMap.isEmpty());
    map = paramMap;
  }
  
  private Map createAsMap()
  {
    Map localMap = map;
    if ((localMap instanceof SortedMap)) {
      return new SortedAsMap((SortedMap)localMap);
    }
    return new AsMap(localMap);
  }
  
  private Set createKeySet()
  {
    Map localMap = map;
    if ((localMap instanceof SortedMap)) {
      return new AbstractMapBasedMultimap.SortedKeySet(this, (SortedMap)localMap);
    }
    return new AbstractMapBasedMultimap.KeySet(this, localMap);
  }
  
  private Collection getOrCreateCollection(Object paramObject)
  {
    Collection localCollection2 = (Collection)map.get(paramObject);
    Collection localCollection1 = localCollection2;
    if (localCollection2 == null)
    {
      localCollection1 = createCollection(paramObject);
      map.put(paramObject, localCollection1);
    }
    return localCollection1;
  }
  
  private Iterator iteratorOrListIterator(Collection paramCollection)
  {
    if ((paramCollection instanceof List)) {
      return ((List)paramCollection).listIterator();
    }
    return paramCollection.iterator();
  }
  
  private int removeValuesForKey(Object paramObject)
  {
    try
    {
      Map localMap = map;
      int i;
      return 0;
    }
    catch (NullPointerException paramObject)
    {
      try
      {
        paramObject = localMap.remove(paramObject);
        paramObject = (Collection)paramObject;
        if (paramObject == null) {
          break label51;
        }
        i = paramObject.size();
        paramObject.clear();
        totalSize -= i;
        return i;
      }
      catch (ClassCastException paramObject) {}
      paramObject = paramObject;
      return 0;
    }
  }
  
  private Collection unmodifiableCollectionSubclass(Collection paramCollection)
  {
    if ((paramCollection instanceof SortedSet)) {
      return Collections.unmodifiableSortedSet((SortedSet)paramCollection);
    }
    if ((paramCollection instanceof Set)) {
      return Collections.unmodifiableSet((Set)paramCollection);
    }
    if ((paramCollection instanceof List)) {
      return Collections.unmodifiableList((List)paramCollection);
    }
    return Collections.unmodifiableCollection(paramCollection);
  }
  
  private Collection wrapCollection(Object paramObject, Collection paramCollection)
  {
    if ((paramCollection instanceof SortedSet)) {
      return new AbstractMapBasedMultimap.WrappedSortedSet(this, paramObject, (SortedSet)paramCollection, null);
    }
    if ((paramCollection instanceof Set)) {
      return new AbstractMapBasedMultimap.WrappedSet(this, paramObject, (Set)paramCollection);
    }
    if ((paramCollection instanceof List)) {
      return wrapList(paramObject, (List)paramCollection, null);
    }
    return new AbstractMapBasedMultimap.WrappedCollection(this, paramObject, paramCollection, null);
  }
  
  private List wrapList(Object paramObject, List paramList, AbstractMapBasedMultimap.WrappedCollection paramWrappedCollection)
  {
    if ((paramList instanceof RandomAccess)) {
      return new AbstractMapBasedMultimap.RandomAccessWrappedList(this, paramObject, paramList, paramWrappedCollection);
    }
    return new AbstractMapBasedMultimap.WrappedList(this, paramObject, paramList, paramWrappedCollection);
  }
  
  public Map asMap()
  {
    Map localMap2 = asMap;
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = createAsMap();
      asMap = localMap1;
    }
    return localMap1;
  }
  
  public Map backingMap()
  {
    return map;
  }
  
  public void clear()
  {
    Iterator localIterator = map.values().iterator();
    while (localIterator.hasNext()) {
      ((Collection)localIterator.next()).clear();
    }
    map.clear();
    totalSize = 0;
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
      if (((Collection)localIterator.next()).contains(paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public abstract Collection createCollection();
  
  public Collection createCollection(Object paramObject)
  {
    return createCollection();
  }
  
  public Collection createEntries()
  {
    if ((this instanceof SetMultimap)) {
      return new AbstractMultimap.Entries(this);
    }
    return new AbstractMultimap.1(this);
  }
  
  public Collection entries()
  {
    Collection localCollection2 = entries;
    Collection localCollection1 = localCollection2;
    if (localCollection2 == null)
    {
      localCollection1 = createEntries();
      entries = localCollection1;
    }
    return localCollection1;
  }
  
  public Iterator entryIterator()
  {
    return new AbstractMapBasedMultimap.EntryIterator(this);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Multimap))
    {
      paramObject = (Multimap)paramObject;
      return map.equals(paramObject.asMap());
    }
    return false;
  }
  
  public Collection get(Object paramObject)
  {
    Collection localCollection2 = (Collection)map.get(paramObject);
    Collection localCollection1 = localCollection2;
    if (localCollection2 == null) {
      localCollection1 = createCollection(paramObject);
    }
    return wrapCollection(paramObject, localCollection1);
  }
  
  public int hashCode()
  {
    return map.hashCode();
  }
  
  public boolean isEmpty()
  {
    return totalSize == 0;
  }
  
  public Set keySet()
  {
    Set localSet2 = keySet;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = createKeySet();
      keySet = localSet1;
    }
    return localSet1;
  }
  
  public Multiset keys()
  {
    Object localObject = keys;
    if (localObject == null)
    {
      localObject = new Multimaps.FilteredMultimap.Keys(this);
      keys = ((Multiset)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public boolean put(Object paramObject1, Object paramObject2)
  {
    Collection localCollection = (Collection)map.get(paramObject1);
    if (localCollection == null)
    {
      localCollection = createCollection(paramObject1);
      if (localCollection.add(paramObject2))
      {
        totalSize += 1;
        map.put(paramObject1, localCollection);
        return true;
      }
      throw new AssertionError("New Collection violated the Collection spec");
    }
    if (localCollection.add(paramObject2))
    {
      totalSize += 1;
      return true;
    }
    return false;
  }
  
  public boolean putAll(Multimap paramMultimap)
  {
    paramMultimap = paramMultimap.entries().iterator();
    boolean bool = false;
    while (paramMultimap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMultimap.next();
      bool |= put(localEntry.getKey(), localEntry.getValue());
    }
    return bool;
  }
  
  public boolean putAll(Object paramObject, Iterable paramIterable)
  {
    boolean bool2 = paramIterable.iterator().hasNext();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    paramObject = getOrCreateCollection(paramObject);
    int i = paramObject.size();
    if ((paramIterable instanceof Collection))
    {
      bool2 = paramObject.addAll(Collections2.cast(paramIterable));
    }
    else
    {
      paramIterable = paramIterable.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!paramIterable.hasNext()) {
          break;
        }
        bool1 |= paramObject.add(paramIterable.next());
      }
    }
    int j = totalSize;
    totalSize = (paramObject.size() - i + j);
    return bool2;
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    Collection localCollection = (Collection)map.get(paramObject1);
    if (localCollection == null) {
      return false;
    }
    boolean bool = localCollection.remove(paramObject2);
    if (bool)
    {
      totalSize -= 1;
      if (localCollection.isEmpty()) {
        map.remove(paramObject1);
      }
    }
    return bool;
  }
  
  public Collection removeAll(Object paramObject)
  {
    paramObject = (Collection)map.remove(paramObject);
    Collection localCollection = createCollection();
    if (paramObject != null)
    {
      localCollection.addAll(paramObject);
      totalSize -= paramObject.size();
      paramObject.clear();
    }
    return unmodifiableCollectionSubclass(localCollection);
  }
  
  public Collection replaceValues(Object paramObject, Iterable paramIterable)
  {
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return removeAll(paramObject);
    }
    paramObject = getOrCreateCollection(paramObject);
    Collection localCollection = createCollection();
    localCollection.addAll(paramObject);
    totalSize -= paramObject.size();
    paramObject.clear();
    while (paramIterable.hasNext()) {
      if (paramObject.add(paramIterable.next())) {
        totalSize += 1;
      }
    }
    return unmodifiableCollectionSubclass(localCollection);
  }
  
  public final void setMap(Map paramMap)
  {
    map = paramMap;
    totalSize = 0;
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Collection localCollection = (Collection)paramMap.next();
      Preconditions.checkArgument(localCollection.isEmpty() ^ true);
      int i = totalSize;
      totalSize = (localCollection.size() + i);
    }
  }
  
  public int size()
  {
    return totalSize;
  }
  
  public String toString()
  {
    return map.toString();
  }
  
  public Collection values()
  {
    Object localObject = values;
    if (localObject == null)
    {
      localObject = new MapConstraints.ConstrainedMultimap.1AsMap(this);
      values = ((Collection)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public class AsMap
    extends AbstractMap<K, Collection<V>>
  {
    public transient Set<Map.Entry<K, Collection<V>>> entrySet;
    public final transient Map<K, Collection<V>> submap;
    
    public AsMap(Map paramMap)
    {
      submap = paramMap;
    }
    
    public void clear()
    {
      Map localMap = submap;
      AbstractMultimap localAbstractMultimap = AbstractMultimap.this;
      if (localMap == map)
      {
        localAbstractMultimap.clear();
        return;
      }
      Iterators.clear(new r.a.b(this));
    }
    
    public boolean containsKey(Object paramObject)
    {
      return Maps.safeContainsKey(submap, paramObject);
    }
    
    public Set entrySet()
    {
      Object localObject = entrySet;
      if (localObject == null)
      {
        localObject = new r.a.a(this);
        entrySet = ((Set)localObject);
        return localObject;
      }
      return localObject;
    }
    
    public boolean equals(Object paramObject)
    {
      return (this == paramObject) || (submap.equals(paramObject));
    }
    
    public Collection get(Object paramObject)
    {
      Collection localCollection = (Collection)Maps.safeGet(submap, paramObject);
      if (localCollection == null) {
        return null;
      }
      return AbstractMultimap.access$getWrapCollection(AbstractMultimap.this, paramObject, localCollection);
    }
    
    public int hashCode()
    {
      return submap.hashCode();
    }
    
    public Set keySet()
    {
      return AbstractMultimap.this.keySet();
    }
    
    public Collection remove(Object paramObject)
    {
      paramObject = (Collection)submap.remove(paramObject);
      if (paramObject == null) {
        return null;
      }
      Collection localCollection = createCollection();
      localCollection.addAll(paramObject);
      AbstractMultimap.access$220(AbstractMultimap.this, paramObject.size());
      paramObject.clear();
      return localCollection;
    }
    
    public int size()
    {
      return submap.size();
    }
    
    public String toString()
    {
      return submap.toString();
    }
  }
  
  public class SortedAsMap
    extends r<K, V>.a
    implements SortedMap<K, Collection<V>>
  {
    public SortedSet<K> sortedKeySet;
    
    public SortedAsMap(SortedMap paramSortedMap)
    {
      super(paramSortedMap);
    }
    
    public Comparator comparator()
    {
      return sortedMap().comparator();
    }
    
    public Object firstKey()
    {
      return sortedMap().firstKey();
    }
    
    public SortedMap headMap(Object paramObject)
    {
      return new SortedAsMap(AbstractMultimap.this, sortedMap().headMap(paramObject));
    }
    
    public SortedSet keySet()
    {
      Object localObject = sortedKeySet;
      if (localObject == null)
      {
        localObject = new AbstractMapBasedMultimap.SortedKeySet(AbstractMultimap.this, sortedMap());
        sortedKeySet = ((SortedSet)localObject);
        return localObject;
      }
      return localObject;
    }
    
    public Object lastKey()
    {
      return sortedMap().lastKey();
    }
    
    public SortedMap sortedMap()
    {
      return (SortedMap)submap;
    }
    
    public SortedMap subMap(Object paramObject1, Object paramObject2)
    {
      return new SortedAsMap(AbstractMultimap.this, sortedMap().subMap(paramObject1, paramObject2));
    }
    
    public SortedMap tailMap(Object paramObject)
    {
      return new SortedAsMap(AbstractMultimap.this, sortedMap().tailMap(paramObject));
    }
  }
}
