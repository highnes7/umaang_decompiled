package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@a
@b
public final class MapConstraints
{
  public MapConstraints() {}
  
  public static Map checkMap(Map paramMap, MapConstraint paramMapConstraint)
  {
    paramMap = new LinkedHashMap(paramMap);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMapConstraint.checkKeyValue(localEntry.getKey(), localEntry.getValue());
    }
    return paramMap;
  }
  
  public static Collection checkValues(Object paramObject, Iterable paramIterable, MapConstraint paramMapConstraint)
  {
    paramIterable = Lists.newArrayList(paramIterable);
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext()) {
      paramMapConstraint.checkKeyValue(paramObject, localIterator.next());
    }
    return paramIterable;
  }
  
  public static Set constrainedAsMapEntries(Set paramSet, MapConstraint paramMapConstraint)
  {
    return new nd.a(paramSet, paramMapConstraint);
  }
  
  public static Map.Entry constrainedAsMapEntry(Map.Entry paramEntry, MapConstraint paramMapConstraint)
  {
    if (paramEntry != null)
    {
      if (paramMapConstraint != null) {
        return new MapConstraints.2(paramEntry, paramMapConstraint);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static BiMap constrainedBiMap(BiMap paramBiMap, MapConstraint paramMapConstraint)
  {
    return new nd.c(paramBiMap, null, paramMapConstraint);
  }
  
  public static Map.Entry constrainedEntry(Map.Entry paramEntry, MapConstraint paramMapConstraint)
  {
    if (paramEntry != null)
    {
      if (paramMapConstraint != null) {
        return new MapConstraints.1(paramEntry, paramMapConstraint);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Set constrainedEntrySet(Set paramSet, MapConstraint paramMapConstraint)
  {
    return new nd.e(paramSet, paramMapConstraint);
  }
  
  public static ListMultimap constrainedListMultimap(ListMultimap paramListMultimap, MapConstraint paramMapConstraint)
  {
    return new nd.f(paramListMultimap, paramMapConstraint);
  }
  
  public static Map constrainedMap(Map paramMap, MapConstraint paramMapConstraint)
  {
    return new nd.g(paramMap, paramMapConstraint);
  }
  
  public static Multimap constrainedMultimap(Multimap paramMultimap, MapConstraint paramMapConstraint)
  {
    return new nd.h(paramMultimap, paramMapConstraint);
  }
  
  public static SetMultimap constrainedSetMultimap(SetMultimap paramSetMultimap, MapConstraint paramMapConstraint)
  {
    return new nd.i(paramSetMultimap, paramMapConstraint);
  }
  
  public static SortedSetMultimap constrainedSortedSetMultimap(SortedSetMultimap paramSortedSetMultimap, MapConstraint paramMapConstraint)
  {
    return new nd.j(paramSortedSetMultimap, paramMapConstraint);
  }
  
  public static Collection filter(Collection paramCollection, MapConstraint paramMapConstraint)
  {
    if ((paramCollection instanceof Set)) {
      return new nd.e((Set)paramCollection, paramMapConstraint);
    }
    return new nd.d(paramCollection, paramMapConstraint);
  }
  
  public static MapConstraint notNull()
  {
    return nd.l.INSTANCE;
  }
}
