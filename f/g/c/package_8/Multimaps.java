package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.package_10.Function;
import f.g.c.package_10.Preconditions;
import f.g.c.package_10.Predicate;
import f.g.c.package_10.Predicates;
import f.g.c.package_10.Supplier;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;

@b(emulated=true)
public final class Multimaps
{
  public Multimaps() {}
  
  public static Multimap filterEntries(Multimap paramMultimap, Predicate paramPredicate)
  {
    if (paramPredicate != null)
    {
      if ((paramMultimap instanceof Be.h)) {
        return filterFiltered((Be.h)paramMultimap, paramPredicate);
      }
      if (paramMultimap != null) {
        return new Be.h(paramMultimap, paramPredicate);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static SetMultimap filterEntries(Map paramMap)
  {
    return new Be.j(paramMap);
  }
  
  public static Multimap filterFiltered(Be.h paramH, Predicate paramPredicate)
  {
    paramPredicate = Predicates.and(predicate, paramPredicate);
    return new Be.h(unfiltered, paramPredicate);
  }
  
  public static ListMultimap filterKeys(ListMultimap paramListMultimap, fe.d paramD)
  {
    return new Be.k(paramListMultimap, paramD);
  }
  
  public static Multimap filterKeys(Multimap paramMultimap, Predicate paramPredicate)
  {
    if (paramPredicate != null) {
      return filterEntries(paramMultimap, new Maps.FilteredEntryBiMap.1(paramPredicate));
    }
    throw new NullPointerException();
  }
  
  public static Multimap filterValues(Multimap paramMultimap, Predicate paramPredicate)
  {
    if (paramPredicate != null) {
      return filterEntries(paramMultimap, new BeanPredicate(paramPredicate));
    }
    throw new NullPointerException();
  }
  
  public static Multimap filterValues(Multimap paramMultimap, fe.d paramD)
  {
    return new Be.l(paramMultimap, paramD);
  }
  
  public static Collection get(Collection paramCollection)
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
  
  public static ImmutableListMultimap index(Iterable paramIterable, Function paramFunction)
  {
    return index(paramIterable.iterator(), paramFunction);
  }
  
  public static ImmutableListMultimap index(Iterator paramIterator, Function paramFunction)
  {
    if (paramFunction != null)
    {
      xb.a localA = new xb.a();
      while (paramIterator.hasNext())
      {
        Object localObject = paramIterator.next();
        Preconditions.checkNotNull(localObject, paramIterator);
        localA.put(paramFunction.apply(localObject), localObject);
      }
      return localA.build();
    }
    paramIterator = new NullPointerException();
    throw paramIterator;
  }
  
  public static Multimap invertFrom(Multimap paramMultimap1, Multimap paramMultimap2)
  {
    if (paramMultimap2 != null)
    {
      paramMultimap1 = paramMultimap1.entries().iterator();
      while (paramMultimap1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMultimap1.next();
        paramMultimap2.put(localEntry.getValue(), localEntry.getKey());
      }
      return paramMultimap2;
    }
    paramMultimap1 = new NullPointerException();
    throw paramMultimap1;
  }
  
  public static ListMultimap newListMultimap(Map paramMap, Supplier paramSupplier)
  {
    return new Be.b(paramMap, paramSupplier);
  }
  
  public static Multimap newMultimap(Map paramMap, Supplier paramSupplier)
  {
    return new Be.c(paramMap, paramSupplier);
  }
  
  public static SetMultimap newSetMultimap(Map paramMap, Supplier paramSupplier)
  {
    return new Be.d(paramMap, paramSupplier);
  }
  
  public static SortedSetMultimap newSortedSetMultimap(Map paramMap, Supplier paramSupplier)
  {
    return new Be.e(paramMap, paramSupplier);
  }
  
  public static Map.Entry put(Map.Entry paramEntry)
  {
    if (paramEntry != null) {
      return new TreeRangeMap.RangeMapEntry(paramEntry);
    }
    throw new NullPointerException();
  }
  
  public static ListMultimap synchronizedListMultimap(ListMultimap paramListMultimap)
  {
    return Synchronized.listMultimap(paramListMultimap, null);
  }
  
  public static Multimap synchronizedMultimap(Multimap paramMultimap)
  {
    return Synchronized.multimap(paramMultimap, null);
  }
  
  public static SetMultimap synchronizedSetMultimap(SetMultimap paramSetMultimap)
  {
    return Synchronized.setMultimap(paramSetMultimap, null);
  }
  
  public static SortedSetMultimap synchronizedSortedSetMultimap(SortedSetMultimap paramSortedSetMultimap)
  {
    return Synchronized.sortedSetMultimap(paramSortedSetMultimap, null);
  }
  
  public static ListMultimap transformValues(ListMultimap paramListMultimap, Function paramFunction)
  {
    if (paramFunction != null) {
      return new Be.k(paramListMultimap, new Multimaps.2(paramFunction));
    }
    throw new NullPointerException();
  }
  
  public static Multimap transformValues(Multimap paramMultimap, Function paramFunction)
  {
    if (paramFunction != null) {
      return new Be.l(paramMultimap, new Maps.3(paramFunction));
    }
    throw new NullPointerException();
  }
  
  public static Collection unmodifiableEntries(Collection paramCollection)
  {
    if ((paramCollection instanceof Set)) {
      return Maps.unmodifiableEntrySet((Set)paramCollection);
    }
    return new fe.p(Collections.unmodifiableCollection(paramCollection));
  }
  
  public static ListMultimap unmodifiableListMultimap(ImmutableListMultimap paramImmutableListMultimap)
  {
    if (paramImmutableListMultimap != null) {
      return paramImmutableListMultimap;
    }
    throw new NullPointerException();
  }
  
  public static ListMultimap unmodifiableListMultimap(ListMultimap paramListMultimap)
  {
    if (!(paramListMultimap instanceof Be.o))
    {
      if ((paramListMultimap instanceof ImmutableListMultimap)) {
        return paramListMultimap;
      }
      return new Be.o(paramListMultimap);
    }
    return paramListMultimap;
  }
  
  public static Multimap unmodifiableMultimap(ImmutableMultimap paramImmutableMultimap)
  {
    if (paramImmutableMultimap != null) {
      return paramImmutableMultimap;
    }
    throw new NullPointerException();
  }
  
  public static Multimap unmodifiableMultimap(Multimap paramMultimap)
  {
    if (!(paramMultimap instanceof Be.p))
    {
      if ((paramMultimap instanceof ImmutableMultimap)) {
        return paramMultimap;
      }
      return new Be.p(paramMultimap);
    }
    return paramMultimap;
  }
  
  public static Set unmodifiableSet(Set paramSet)
  {
    return new Be.m(Collections.unmodifiableSet(paramSet));
  }
  
  public static SetMultimap unmodifiableSetMultimap(ImmutableSetMultimap paramImmutableSetMultimap)
  {
    if (paramImmutableSetMultimap != null) {
      return paramImmutableSetMultimap;
    }
    throw new NullPointerException();
  }
  
  public static SetMultimap unmodifiableSetMultimap(SetMultimap paramSetMultimap)
  {
    if (!(paramSetMultimap instanceof Be.q))
    {
      if ((paramSetMultimap instanceof ImmutableSetMultimap)) {
        return paramSetMultimap;
      }
      return new Be.q(paramSetMultimap);
    }
    return paramSetMultimap;
  }
  
  public static SortedSetMultimap unmodifiableSortedSetMultimap(SortedSetMultimap paramSortedSetMultimap)
  {
    if ((paramSortedSetMultimap instanceof Be.r)) {
      return paramSortedSetMultimap;
    }
    return new Be.r(paramSortedSetMultimap);
  }
}
