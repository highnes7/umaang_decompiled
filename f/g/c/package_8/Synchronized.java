package f.g.c.package_8;

import f.g.c.a.b;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@b(emulated=true)
public final class Synchronized
{
  public Synchronized() {}
  
  public static SortedSet access$getSortedSet(SortedSet paramSortedSet, Object paramObject)
  {
    return new Ug.p(paramSortedSet, paramObject);
  }
  
  public static BiMap biMap(BiMap paramBiMap, Object paramObject)
  {
    if (!(paramBiMap instanceof Ug.d))
    {
      if ((paramBiMap instanceof ImmutableBiMap)) {
        return paramBiMap;
      }
      return new Ug.d(paramBiMap, paramObject, null, null);
    }
    return paramBiMap;
  }
  
  public static Collection collection(Collection paramCollection, Object paramObject)
  {
    return new Ug.e(paramCollection, paramObject, null);
  }
  
  public static Collection get(Collection paramCollection, Object paramObject)
  {
    if ((paramCollection instanceof SortedSet)) {
      return new Ug.p((SortedSet)paramCollection, paramObject);
    }
    if ((paramCollection instanceof Set)) {
      return new Ug.m((Set)paramCollection, paramObject);
    }
    if ((paramCollection instanceof List)) {
      return list((List)paramCollection, paramObject);
    }
    return collection(paramCollection, paramObject);
  }
  
  public static List list(List paramList, Object paramObject)
  {
    if ((paramList instanceof RandomAccess)) {
      return new Ug.l(paramList, paramObject);
    }
    return new Ug.f(paramList, paramObject);
  }
  
  public static ListMultimap listMultimap(ListMultimap paramListMultimap, Object paramObject)
  {
    if (!(paramListMultimap instanceof Ug.g))
    {
      if ((paramListMultimap instanceof ImmutableListMultimap)) {
        return paramListMultimap;
      }
      return new Ug.g(paramListMultimap, paramObject);
    }
    return paramListMultimap;
  }
  
  public static Map map(Map paramMap, Object paramObject)
  {
    return new Ug.h(paramMap, paramObject);
  }
  
  public static Multimap multimap(Multimap paramMultimap, Object paramObject)
  {
    if (!(paramMultimap instanceof Ug.i))
    {
      if ((paramMultimap instanceof ImmutableMultimap)) {
        return paramMultimap;
      }
      return new Ug.i(paramMultimap, paramObject);
    }
    return paramMultimap;
  }
  
  public static Multiset multiset(Multiset paramMultiset, Object paramObject)
  {
    if (!(paramMultiset instanceof Ug.j))
    {
      if ((paramMultiset instanceof ImmutableMultiset)) {
        return paramMultiset;
      }
      return new Ug.j(paramMultiset, paramObject);
    }
    return paramMultiset;
  }
  
  public static Set set(Set paramSet, Object paramObject)
  {
    return new Ug.m(paramSet, paramObject);
  }
  
  public static SetMultimap setMultimap(SetMultimap paramSetMultimap, Object paramObject)
  {
    if (!(paramSetMultimap instanceof Ug.n))
    {
      if ((paramSetMultimap instanceof ImmutableSetMultimap)) {
        return paramSetMultimap;
      }
      return new Ug.n(paramSetMultimap, paramObject);
    }
    return paramSetMultimap;
  }
  
  public static SortedMap sortedMap(SortedMap paramSortedMap, Object paramObject)
  {
    return new Ug.o(paramSortedMap, paramObject);
  }
  
  public static SortedSetMultimap sortedSetMultimap(SortedSetMultimap paramSortedSetMultimap, Object paramObject)
  {
    if ((paramSortedSetMultimap instanceof Ug.q)) {
      return paramSortedSetMultimap;
    }
    return new Ug.q(paramSortedSetMultimap, paramObject);
  }
  
  public static Set typePreservingSet(Set paramSet, Object paramObject)
  {
    if ((paramSet instanceof SortedSet)) {
      return new Ug.p((SortedSet)paramSet, paramObject);
    }
    return new Ug.m(paramSet, paramObject);
  }
}
