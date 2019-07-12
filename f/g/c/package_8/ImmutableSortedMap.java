package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Sb;
import f.g.c.d.Tb;
import f.g.c.package_10.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@b(emulated=true, serializable=true)
public abstract class ImmutableSortedMap<K, V>
  extends Tb<K, V>
  implements SortedMap<K, V>
{
  public static final Sb<Comparable, Object> NATURAL_EMPTY_MAP = new EmptyImmutableSortedMap(NATURAL_ORDER);
  public static final Comparator<Comparable> NATURAL_ORDER = ;
  public static final long serialVersionUID = 0L;
  public transient Sb<K, V> descendingMap;
  
  public ImmutableSortedMap() {}
  
  public ImmutableSortedMap(ImmutableSortedMap paramImmutableSortedMap)
  {
    descendingMap = paramImmutableSortedMap;
  }
  
  public static ImmutableSortedMap copyOf(Map paramMap)
  {
    return copyOfInternal(paramMap, Ordering.natural());
  }
  
  public static ImmutableSortedMap copyOf(Map paramMap, Comparator paramComparator)
  {
    if (paramComparator != null) {
      return copyOfInternal(paramMap, paramComparator);
    }
    throw new NullPointerException();
  }
  
  public static Sb.a copyOf()
  {
    return new Sb.a(Ordering.natural());
  }
  
  public static Sb.a copyOf(Comparator paramComparator)
  {
    return new Sb.a(paramComparator);
  }
  
  public static ImmutableSortedMap copyOfInternal(Map paramMap, Comparator paramComparator)
  {
    boolean bool = paramMap instanceof SortedMap;
    int i = 0;
    Object localObject;
    if (bool)
    {
      localObject = ((SortedMap)paramMap).comparator();
      if (localObject == null)
      {
        if (paramComparator == NATURAL_ORDER)
        {
          bool = true;
          break label51;
        }
      }
      else
      {
        bool = paramComparator.equals(localObject);
        break label51;
      }
    }
    bool = false;
    label51:
    if ((bool) && ((paramMap instanceof ImmutableSortedMap)))
    {
      localObject = (ImmutableSortedMap)paramMap;
      if (!((ImmutableSortedMap)localObject).isPartialView()) {
        return localObject;
      }
    }
    paramMap = (Map.Entry[])paramMap.entrySet().toArray(new Map.Entry[0]);
    while (i < paramMap.length)
    {
      localObject = paramMap[i];
      paramMap[i] = ImmutableMap.entryOf(((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i += 1;
    }
    paramMap = Arrays.asList(paramMap);
    if (!bool)
    {
      sortEntries(paramMap, paramComparator);
      validateEntries(paramMap, paramComparator);
    }
    return fromSortedEntries(paramComparator, paramMap);
  }
  
  public static ImmutableSortedMap copyOfSorted(SortedMap paramSortedMap)
  {
    Comparator localComparator2 = paramSortedMap.comparator();
    Comparator localComparator1 = localComparator2;
    if (localComparator2 == null) {
      localComparator1 = NATURAL_ORDER;
    }
    return copyOfInternal(paramSortedMap, localComparator1);
  }
  
  public static ImmutableSortedMap emptyMap(Comparator paramComparator)
  {
    if (Ordering.natural().equals(paramComparator)) {
      return NATURAL_EMPTY_MAP;
    }
    return new EmptyImmutableSortedMap(paramComparator);
  }
  
  public static ImmutableSortedMap from(ImmutableSortedSet paramImmutableSortedSet, ImmutableList paramImmutableList)
  {
    if (paramImmutableSortedSet.isEmpty()) {
      return emptyMap(paramImmutableSortedSet.comparator());
    }
    return new RegularImmutableSortedMap((RegularImmutableSortedSet)paramImmutableSortedSet, paramImmutableList);
  }
  
  public static ImmutableSortedMap fromSortedEntries(Comparator paramComparator, Collection paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return emptyMap(paramComparator);
    }
    vb.a localA1 = ImmutableList.add();
    vb.a localA2 = ImmutableList.add();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramCollection.next();
      localA1.add(localEntry.getKey());
      localA2.add(localEntry.getValue());
    }
    return new RegularImmutableSortedMap(new RegularImmutableSortedSet(localA1.build(), paramComparator), localA2.build());
  }
  
  public static ImmutableSortedMap of()
  {
    return NATURAL_EMPTY_MAP;
  }
  
  public static ImmutableSortedMap of(Comparable paramComparable, Object paramObject)
  {
    return from(ImmutableSortedSet.of(paramComparable), ImmutableList.of(paramObject));
  }
  
  public static ImmutableSortedMap of(Comparable paramComparable1, Object paramObject1, Comparable paramComparable2, Object paramObject2)
  {
    return new Sb.a(Ordering.natural()).put(paramComparable1, paramObject1).put(paramComparable2, paramObject2).build();
  }
  
  public static ImmutableSortedMap of(Comparable paramComparable1, Object paramObject1, Comparable paramComparable2, Object paramObject2, Comparable paramComparable3, Object paramObject3)
  {
    return new Sb.a(Ordering.natural()).put(paramComparable1, paramObject1).put(paramComparable2, paramObject2).put(paramComparable3, paramObject3).build();
  }
  
  public static ImmutableSortedMap of(Comparable paramComparable1, Object paramObject1, Comparable paramComparable2, Object paramObject2, Comparable paramComparable3, Object paramObject3, Comparable paramComparable4, Object paramObject4)
  {
    return new Sb.a(Ordering.natural()).put(paramComparable1, paramObject1).put(paramComparable2, paramObject2).put(paramComparable3, paramObject3).put(paramComparable4, paramObject4).build();
  }
  
  public static ImmutableSortedMap of(Comparable paramComparable1, Object paramObject1, Comparable paramComparable2, Object paramObject2, Comparable paramComparable3, Object paramObject3, Comparable paramComparable4, Object paramObject4, Comparable paramComparable5, Object paramObject5)
  {
    return new Sb.a(Ordering.natural()).put(paramComparable1, paramObject1).put(paramComparable2, paramObject2).put(paramComparable3, paramObject3).put(paramComparable4, paramObject4).put(paramComparable5, paramObject5).build();
  }
  
  public static Sb.a reverseOrder()
  {
    return new Sb.a(Ordering.natural().reverse());
  }
  
  public static void sortEntries(List paramList, Comparator paramComparator)
  {
    Collections.sort(paramList, new ImmutableSortedMap.1(paramComparator));
  }
  
  public static void validateEntries(List paramList, Comparator paramComparator)
  {
    int i = 1;
    while (i < paramList.size())
    {
      int j = i - 1;
      if (paramComparator.compare(((Map.Entry)paramList.get(j)).getKey(), ((Map.Entry)paramList.get(i)).getKey()) != 0)
      {
        i += 1;
      }
      else
      {
        paramComparator = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Duplicate keys in mappings ");
        paramComparator.append(paramList.get(j));
        paramComparator.append(" and ");
        paramComparator.append(paramList.get(i));
        throw new IllegalArgumentException(paramComparator.toString());
      }
    }
  }
  
  public Map.Entry ceilingEntry(Object paramObject)
  {
    return tailMap(paramObject, true).firstEntry();
  }
  
  public Object ceilingKey(Object paramObject)
  {
    return Maps.keyOrNull(ceilingEntry(paramObject));
  }
  
  public Comparator comparator()
  {
    return keySet().comparator();
  }
  
  public Object containsValue()
  {
    return new Sb.b(this);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return values().contains(paramObject);
  }
  
  public abstract ImmutableSortedMap createDescendingMap();
  
  public ImmutableSortedSet descendingKeySet()
  {
    return keySet().descendingSet();
  }
  
  public ImmutableSortedMap descendingMap()
  {
    ImmutableSortedMap localImmutableSortedMap2 = descendingMap;
    ImmutableSortedMap localImmutableSortedMap1 = localImmutableSortedMap2;
    if (localImmutableSortedMap2 == null)
    {
      localImmutableSortedMap1 = createDescendingMap();
      descendingMap = localImmutableSortedMap1;
    }
    return localImmutableSortedMap1;
  }
  
  public ImmutableSet entrySet()
  {
    return super.entrySet();
  }
  
  public Map.Entry firstEntry()
  {
    if (isEmpty()) {
      return null;
    }
    return (Map.Entry)entrySet().asList().get(0);
  }
  
  public Object firstKey()
  {
    return keySet().first();
  }
  
  public Map.Entry floorEntry(Object paramObject)
  {
    return headMap(paramObject, true).lastEntry();
  }
  
  public Object floorKey(Object paramObject)
  {
    return Maps.keyOrNull(floorEntry(paramObject));
  }
  
  public ImmutableSortedMap headMap(Object paramObject)
  {
    return headMap(paramObject, false);
  }
  
  public abstract ImmutableSortedMap headMap(Object paramObject, boolean paramBoolean);
  
  public Map.Entry higherEntry(Object paramObject)
  {
    return tailMap(paramObject, false).firstEntry();
  }
  
  public Object higherKey(Object paramObject)
  {
    return Maps.keyOrNull(higherEntry(paramObject));
  }
  
  public boolean isPartialView()
  {
    return (keySet().isPartialView()) || (values().isPartialView());
  }
  
  public abstract ImmutableSortedSet keySet();
  
  public Map.Entry lastEntry()
  {
    if (isEmpty()) {
      return null;
    }
    return (Map.Entry)entrySet().asList().get(size() - 1);
  }
  
  public Object lastKey()
  {
    return keySet().last();
  }
  
  public Map.Entry lowerEntry(Object paramObject)
  {
    return headMap(paramObject, false).lastEntry();
  }
  
  public Object lowerKey(Object paramObject)
  {
    return Maps.keyOrNull(lowerEntry(paramObject));
  }
  
  public ImmutableSortedSet navigableKeySet()
  {
    return keySet();
  }
  
  public final Map.Entry pollFirstEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  public final Map.Entry pollLastEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  public int size()
  {
    return values().size();
  }
  
  public ImmutableSortedMap subMap(Object paramObject1, Object paramObject2)
  {
    return subMap(paramObject1, true, paramObject2, false);
  }
  
  public ImmutableSortedMap subMap(Object paramObject1, boolean paramBoolean1, Object paramObject2, boolean paramBoolean2)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 != null)
      {
        boolean bool;
        if (comparator().compare(paramObject1, paramObject2) <= 0) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkArgument(bool, "expected fromKey <= toKey but %s > %s", new Object[] { paramObject1, paramObject2 });
        return headMap(paramObject2, paramBoolean2).tailMap(paramObject1, paramBoolean1);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public ImmutableSortedMap tailMap(Object paramObject)
  {
    return tailMap(paramObject, true);
  }
  
  public abstract ImmutableSortedMap tailMap(Object paramObject, boolean paramBoolean);
  
  public abstract ImmutableCollection values();
}
