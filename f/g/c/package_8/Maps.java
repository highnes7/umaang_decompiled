package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.package_10.Equivalence;
import f.g.c.package_10.Equivalence.Equals;
import f.g.c.package_10.Function;
import f.g.c.package_10.Joiner;
import f.g.c.package_10.Joiner.MapJoiner;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Preconditions;
import f.g.c.package_10.Predicate;
import f.g.c.package_10.Predicates;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

@b(emulated=true)
public final class Maps
{
  public static final Joiner.MapJoiner STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");
  
  public Maps() {}
  
  public static Map asMap(Set paramSet, Function paramFunction)
  {
    if ((paramSet instanceof SortedSet)) {
      return new fe.k((SortedSet)paramSet, paramFunction);
    }
    return new fe.b(paramSet, paramFunction);
  }
  
  public static SortedMap asMap(SortedSet paramSortedSet, Function paramFunction)
  {
    return new fe.k(paramSortedSet, paramFunction);
  }
  
  public static int capacity(int paramInt)
  {
    if (paramInt < 3)
    {
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool);
      return paramInt + 1;
    }
    if (paramInt < 1073741824) {
      return paramInt / 3 + paramInt;
    }
    return Integer.MAX_VALUE;
  }
  
  public static boolean containsEntryImpl(Collection paramCollection, Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    return paramCollection.contains(unmodifiableEntry((Map.Entry)paramObject));
  }
  
  public static boolean containsKeyImpl(Map paramMap, Object paramObject)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      if (Objects.equal(((Map.Entry)paramMap.next()).getKey(), paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean containsValueImpl(Map paramMap, Object paramObject)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      if (Objects.equal(((Map.Entry)paramMap.next()).getValue(), paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public static EnumMap deserialize(Class paramClass)
  {
    if (paramClass != null) {
      return new EnumMap(paramClass);
    }
    throw new NullPointerException();
  }
  
  public static MapDifference difference(Map paramMap1, Map paramMap2)
  {
    if ((paramMap1 instanceof SortedMap)) {
      return difference((SortedMap)paramMap1, paramMap2);
    }
    return difference(paramMap1, paramMap2, Equivalence.Equals.INSTANCE);
  }
  
  public static MapDifference difference(Map paramMap1, Map paramMap2, Equivalence paramEquivalence)
  {
    if (paramEquivalence != null)
    {
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = new HashMap(paramMap2);
      HashMap localHashMap3 = new HashMap();
      HashMap localHashMap4 = new HashMap();
      paramMap1 = paramMap1.entrySet().iterator();
      boolean bool = true;
      int i = 1;
      while (paramMap1.hasNext())
      {
        Object localObject2 = (Map.Entry)paramMap1.next();
        Object localObject1 = ((Map.Entry)localObject2).getKey();
        localObject2 = ((Map.Entry)localObject2).getValue();
        if (paramMap2.containsKey(localObject1))
        {
          Object localObject3 = localHashMap2.remove(localObject1);
          if (paramEquivalence.equivalent(localObject2, localObject3)) {
            localHashMap3.put(localObject1, localObject2);
          } else {
            localHashMap4.put(localObject1, new fe.r(localObject2, localObject3));
          }
        }
        else
        {
          for (;;)
          {
            i = 0;
            break;
            localHashMap1.put(localObject1, localObject2);
          }
        }
      }
      if ((i == 0) || (!localHashMap2.isEmpty())) {
        bool = false;
      }
      return mapDifference(bool, localHashMap1, localHashMap2, localHashMap3, localHashMap4);
    }
    paramMap1 = new NullPointerException();
    throw paramMap1;
  }
  
  public static SortedMapDifference difference(SortedMap paramSortedMap, Map paramMap)
  {
    if (paramSortedMap != null)
    {
      if (paramMap != null)
      {
        Object localObject1 = orNaturalOrder(paramSortedMap.comparator());
        TreeMap localTreeMap1 = new TreeMap((Comparator)localObject1);
        TreeMap localTreeMap2 = new TreeMap((Comparator)localObject1);
        localTreeMap2.putAll(paramMap);
        TreeMap localTreeMap3 = new TreeMap((Comparator)localObject1);
        localObject1 = new TreeMap((Comparator)localObject1);
        paramSortedMap = paramSortedMap.entrySet().iterator();
        boolean bool = true;
        int i = 1;
        while (paramSortedMap.hasNext())
        {
          Object localObject3 = (Map.Entry)paramSortedMap.next();
          Object localObject2 = ((Map.Entry)localObject3).getKey();
          localObject3 = ((Map.Entry)localObject3).getValue();
          if (paramMap.containsKey(localObject2))
          {
            Object localObject4 = localTreeMap2.remove(localObject2);
            if (Objects.equal(localObject3, localObject4)) {
              localTreeMap3.put(localObject2, localObject3);
            } else {
              ((SortedMap)localObject1).put(localObject2, new fe.r(localObject3, localObject4));
            }
          }
          else
          {
            for (;;)
            {
              i = 0;
              break;
              localTreeMap1.put(localObject2, localObject3);
            }
          }
        }
        if ((i == 0) || (!localTreeMap2.isEmpty())) {
          bool = false;
        }
        return sortedMapDifference(bool, localTreeMap1, localTreeMap2, localTreeMap3, (SortedMap)localObject1);
      }
      throw new NullPointerException();
    }
    paramSortedMap = new NullPointerException();
    throw paramSortedMap;
  }
  
  public static boolean equalsImpl(Map paramMap, Object paramObject)
  {
    if (paramMap == paramObject) {
      return true;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      return paramMap.entrySet().equals(paramObject.entrySet());
    }
    return false;
  }
  
  public static Map filterEntries(Map paramMap, Predicate paramPredicate)
  {
    if ((paramMap instanceof SortedMap)) {
      return filterEntries((SortedMap)paramMap, paramPredicate);
    }
    if (paramPredicate != null)
    {
      if ((paramMap instanceof fe.a)) {
        return filterFiltered((fe.a)paramMap, paramPredicate);
      }
      if (paramMap != null) {
        return new fe.e(paramMap, paramPredicate);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static SortedMap filterEntries(SortedMap paramSortedMap, Predicate paramPredicate)
  {
    if (paramPredicate != null)
    {
      if ((paramSortedMap instanceof fe.f)) {
        return filterFiltered((fe.f)paramSortedMap, paramPredicate);
      }
      if (paramSortedMap != null) {
        return new fe.f(paramSortedMap, paramPredicate);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Map filterFiltered(fe.a paramA, Predicate paramPredicate)
  {
    paramPredicate = Predicates.and(predicate, paramPredicate);
    return new fe.e(unfiltered, paramPredicate);
  }
  
  public static SortedMap filterFiltered(fe.f paramF, Predicate paramPredicate)
  {
    paramPredicate = Predicates.and(predicate, paramPredicate);
    return new fe.f(paramF.sortedMap(), paramPredicate);
  }
  
  public static BiMap filterKeys(BiMap paramBiMap)
  {
    return new fe.o(paramBiMap, null);
  }
  
  public static Map filterKeys(Map paramMap, Predicate paramPredicate)
  {
    if ((paramMap instanceof SortedMap)) {
      return filterKeys((SortedMap)paramMap, paramPredicate);
    }
    if (paramPredicate != null)
    {
      Maps.4 local4 = new Maps.4(paramPredicate);
      if ((paramMap instanceof fe.a)) {
        return filterFiltered((fe.a)paramMap, local4);
      }
      if (paramMap != null) {
        return new fe.g(paramMap, paramPredicate, local4);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static SortedMap filterKeys(SortedMap paramSortedMap, Predicate paramPredicate)
  {
    if (paramPredicate != null) {
      return filterEntries(paramSortedMap, new Maps.KeyPredicate(paramPredicate));
    }
    throw new NullPointerException();
  }
  
  public static Map filterValues(Map paramMap, Predicate paramPredicate)
  {
    if ((paramMap instanceof SortedMap)) {
      return filterValues((SortedMap)paramMap, paramPredicate);
    }
    if (paramPredicate != null) {
      return filterEntries(paramMap, new Maps.6(paramPredicate));
    }
    throw new NullPointerException();
  }
  
  public static SortedMap filterValues(SortedMap paramSortedMap, Predicate paramPredicate)
  {
    if (paramPredicate != null) {
      return filterEntries(paramSortedMap, new Maps.5(paramPredicate));
    }
    throw new NullPointerException();
  }
  
  public static ImmutableMap fromProperties(Properties paramProperties)
  {
    Ab.a localA = ImmutableMap.builder();
    Enumeration localEnumeration = paramProperties.propertyNames();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      localA.put(str, paramProperties.getProperty(str));
    }
    return localA.build();
  }
  
  public static HashMap getString()
  {
    return new HashMap();
  }
  
  public static int hashCodeImpl(Map paramMap)
  {
    return Sets.hashCodeImpl(paramMap.entrySet());
  }
  
  public static Map.Entry immutableEntry(Object paramObject1, Object paramObject2)
  {
    return new ImmutableEntry(paramObject1, paramObject2);
  }
  
  public static Iterator keyIterator(Iterator paramIterator)
  {
    return new Maps.7(paramIterator);
  }
  
  public static Object keyOrNull(Map.Entry paramEntry)
  {
    if (paramEntry == null) {
      return null;
    }
    return paramEntry.getKey();
  }
  
  public static MapDifference mapDifference(boolean paramBoolean, Map paramMap1, Map paramMap2, Map paramMap3, Map paramMap4)
  {
    return new fe.j(paramBoolean, Collections.unmodifiableMap(paramMap1), Collections.unmodifiableMap(paramMap2), Collections.unmodifiableMap(paramMap3), Collections.unmodifiableMap(paramMap4));
  }
  
  public static ConcurrentMap newConcurrentMap()
  {
    return new MapMaker().makeMap();
  }
  
  public static EnumMap newEnumMap(Map paramMap)
  {
    return new EnumMap(paramMap);
  }
  
  public static HashMap newHashMap(Map paramMap)
  {
    return new HashMap(paramMap);
  }
  
  public static HashMap newHashMapWithExpectedSize(int paramInt)
  {
    return new HashMap(capacity(paramInt));
  }
  
  public static IdentityHashMap newIdentityHashMap()
  {
    return new IdentityHashMap();
  }
  
  public static LinkedHashMap newLinkedHashMap()
  {
    return new LinkedHashMap();
  }
  
  public static LinkedHashMap newLinkedHashMap(Map paramMap)
  {
    return new LinkedHashMap(paramMap);
  }
  
  public static TreeMap newTreeMap()
  {
    return new TreeMap();
  }
  
  public static TreeMap newTreeMap(Comparator paramComparator)
  {
    return new TreeMap(paramComparator);
  }
  
  public static TreeMap newTreeMap(SortedMap paramSortedMap)
  {
    return new TreeMap(paramSortedMap);
  }
  
  public static Comparator orNaturalOrder(Comparator paramComparator)
  {
    if (paramComparator != null) {
      return paramComparator;
    }
    return Ordering.natural();
  }
  
  public static void putAllImpl(Map paramMap1, Map paramMap2)
  {
    paramMap2 = paramMap2.entrySet().iterator();
    while (paramMap2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap2.next();
      paramMap1.put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public static boolean removeEntryImpl(Collection paramCollection, Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    return paramCollection.remove(unmodifiableEntry((Map.Entry)paramObject));
  }
  
  public static boolean safeContainsKey(Map paramMap, Object paramObject)
  {
    try
    {
      boolean bool = paramMap.containsKey(paramObject);
      return bool;
    }
    catch (ClassCastException paramMap)
    {
      for (;;) {}
    }
    return false;
  }
  
  public static Object safeGet(Map paramMap, Object paramObject)
  {
    try
    {
      paramMap = paramMap.get(paramObject);
      return paramMap;
    }
    catch (ClassCastException paramMap)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static SortedMapDifference sortedMapDifference(boolean paramBoolean, SortedMap paramSortedMap1, SortedMap paramSortedMap2, SortedMap paramSortedMap3, SortedMap paramSortedMap4)
  {
    return new fe.l(paramBoolean, Collections.unmodifiableSortedMap(paramSortedMap1), Collections.unmodifiableSortedMap(paramSortedMap2), Collections.unmodifiableSortedMap(paramSortedMap3), Collections.unmodifiableSortedMap(paramSortedMap4));
  }
  
  public static BiMap synchronizedBiMap(BiMap paramBiMap)
  {
    return Synchronized.biMap(paramBiMap, null);
  }
  
  public static fe.d toMap(Function paramFunction)
  {
    if (paramFunction != null) {
      return new Multimaps.3(paramFunction);
    }
    throw new NullPointerException();
  }
  
  public static String toStringImpl(Map paramMap)
  {
    StringBuilder localStringBuilder = Collections2.append(paramMap.size());
    localStringBuilder.append('{');
    STANDARD_JOINER.appendTo(localStringBuilder, paramMap);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static Map transformEntries(Map paramMap, fe.d paramD)
  {
    if ((paramMap instanceof SortedMap)) {
      return new fe.n((SortedMap)paramMap, paramD);
    }
    return new fe.m(paramMap, paramD);
  }
  
  public static SortedMap transformEntries(SortedMap paramSortedMap, fe.d paramD)
  {
    return new fe.n(paramSortedMap, paramD);
  }
  
  public static Map.Entry transformEntry(Map.Entry paramEntry)
  {
    if (paramEntry == null) {
      return null;
    }
    return new Maps.10(paramEntry);
  }
  
  public static Map transformValues(Map paramMap, Function paramFunction)
  {
    if (paramFunction != null) {
      return transformEntries(paramMap, new Multimaps.3(paramFunction));
    }
    throw new NullPointerException();
  }
  
  public static SortedMap transformValues(SortedMap paramSortedMap, Function paramFunction)
  {
    if (paramFunction != null) {
      return new fe.n(paramSortedMap, new Multimaps.3(paramFunction));
    }
    throw new NullPointerException();
  }
  
  public static ImmutableMap uniqueIndex(Iterable paramIterable, Function paramFunction)
  {
    return uniqueIndex(paramIterable.iterator(), paramFunction);
  }
  
  public static ImmutableMap uniqueIndex(Iterator paramIterator, Function paramFunction)
  {
    if (paramFunction != null)
    {
      Ab.a localA = ImmutableMap.builder();
      while (paramIterator.hasNext())
      {
        Object localObject = paramIterator.next();
        localA.put(paramFunction.apply(localObject), localObject);
      }
      return localA.build();
    }
    paramIterator = new NullPointerException();
    throw paramIterator;
  }
  
  public static Map.Entry unmodifiableEntry(Map.Entry paramEntry)
  {
    if (paramEntry != null) {
      return new Maps.10(paramEntry);
    }
    throw new NullPointerException();
  }
  
  public static Set unmodifiableEntrySet(Set paramSet)
  {
    return new fe.q(Collections.unmodifiableSet(paramSet));
  }
  
  public static UnmodifiableIterator valueIterator(UnmodifiableIterator paramUnmodifiableIterator)
  {
    return new Maps.1(paramUnmodifiableIterator);
  }
  
  public static Iterator valueIterator(Iterator paramIterator)
  {
    return new Maps.8(paramIterator);
  }
}
