package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.package_10.Preconditions;
import f.g.c.package_10.Predicate;
import f.g.c.package_10.Predicates;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

@b(emulated=true)
public final class Sets
{
  public Sets() {}
  
  public static Set cartesianProduct(List paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (((Set)localIterator.next()).isEmpty()) {
        return ImmutableSet.of();
      }
    }
    return new gg.a(paramList);
  }
  
  public static Set cartesianProduct(Set... paramVarArgs)
  {
    return cartesianProduct(Arrays.asList(paramVarArgs));
  }
  
  public static EnumSet complementOf(Collection paramCollection)
  {
    if ((paramCollection instanceof EnumSet)) {
      return EnumSet.complementOf((EnumSet)paramCollection);
    }
    Preconditions.checkArgument(paramCollection.isEmpty() ^ true, "collection is empty; use the other version of this method");
    return makeComplementByHand(paramCollection, ((Enum)paramCollection.iterator().next()).getDeclaringClass());
  }
  
  public static EnumSet complementOf(Collection paramCollection, Class paramClass)
  {
    if (paramCollection != null)
    {
      if ((paramCollection instanceof EnumSet)) {
        return EnumSet.complementOf((EnumSet)paramCollection);
      }
      return makeComplementByHand(paramCollection, paramClass);
    }
    throw new NullPointerException();
  }
  
  public static TreeSet create(Comparator paramComparator)
  {
    if (paramComparator != null) {
      return new TreeSet(paramComparator);
    }
    throw new NullPointerException();
  }
  
  public static gg.g difference(Set paramSet1, Set paramSet2)
  {
    Preconditions.checkNotNull(paramSet1, "set1");
    Preconditions.checkNotNull(paramSet2, "set2");
    return new Sets.3(paramSet1, Predicates.not(Predicates.in(paramSet2)), paramSet2);
  }
  
  public static boolean equalsImpl(Set paramSet, Object paramObject)
  {
    if (paramSet == paramObject) {
      return true;
    }
    if ((paramObject instanceof Set)) {
      paramObject = (Set)paramObject;
    }
    try
    {
      int i = paramSet.size();
      int j = paramObject.size();
      if (i == j)
      {
        boolean bool = paramSet.containsAll(paramObject);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (NullPointerException paramSet)
    {
      return false;
    }
    catch (ClassCastException paramSet) {}
    return false;
    return false;
  }
  
  public static EnumSet filter(Iterable paramIterable, Class paramClass)
  {
    if (paramIterable != null)
    {
      paramClass = EnumSet.noneOf(paramClass);
      Iterables.addAll(paramClass, paramIterable);
      return paramClass;
    }
    throw new NullPointerException();
  }
  
  public static Set filter(Set paramSet, Predicate paramPredicate)
  {
    if ((paramSet instanceof SortedSet)) {
      return filter((SortedSet)paramSet, paramPredicate);
    }
    if ((paramSet instanceof gg.b))
    {
      paramSet = (gg.b)paramSet;
      paramPredicate = Predicates.and(predicate, paramPredicate);
      return new gg.b((Set)unfiltered, paramPredicate);
    }
    if (paramSet != null)
    {
      if (paramPredicate != null) {
        return new gg.b(paramSet, paramPredicate);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static SortedSet filter(Iterable paramIterable)
  {
    return (SortedSet)paramIterable;
  }
  
  public static SortedSet filter(SortedSet paramSortedSet, Predicate paramPredicate)
  {
    if ((paramSortedSet instanceof gg.b))
    {
      paramSortedSet = (gg.b)paramSortedSet;
      paramPredicate = Predicates.and(predicate, paramPredicate);
      return new gg.c((SortedSet)unfiltered, paramPredicate);
    }
    if (paramSortedSet != null)
    {
      if (paramPredicate != null) {
        return new gg.c(paramSortedSet, paramPredicate);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static int hashCodeImpl(Set paramSet)
  {
    paramSet = paramSet.iterator();
    int i = 0;
    while (paramSet.hasNext())
    {
      Object localObject = paramSet.next();
      int j;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      i += j;
    }
    return i;
  }
  
  public static ImmutableSet immutableEnumSet(Enum paramEnum, Enum... paramVarArgs)
  {
    return new ImmutableEnumSet(EnumSet.of(paramEnum, paramVarArgs));
  }
  
  public static ImmutableSet immutableEnumSet(Iterable paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext()) {
      return ImmutableSet.of();
    }
    if ((paramIterable instanceof EnumSet)) {
      return new ImmutableEnumSet(EnumSet.copyOf((EnumSet)paramIterable));
    }
    paramIterable = EnumSet.of((Enum)localIterator.next());
    while (localIterator.hasNext()) {
      paramIterable.add(localIterator.next());
    }
    return new ImmutableEnumSet(paramIterable);
  }
  
  public static gg.g intersection(Set paramSet1, Set paramSet2)
  {
    Preconditions.checkNotNull(paramSet1, "set1");
    Preconditions.checkNotNull(paramSet2, "set2");
    return new Sets.2(paramSet1, Predicates.in(paramSet2), paramSet2);
  }
  
  public static EnumSet makeComplementByHand(Collection paramCollection, Class paramClass)
  {
    paramClass = EnumSet.allOf(paramClass);
    paramClass.removeAll(paramCollection);
    return paramClass;
  }
  
  public static CopyOnWriteArraySet newCopyOnWriteArraySet()
  {
    return new CopyOnWriteArraySet();
  }
  
  public static CopyOnWriteArraySet newCopyOnWriteArraySet(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      paramIterable = Collections2.cast(paramIterable);
    } else {
      paramIterable = Lists.newArrayList(paramIterable);
    }
    return new CopyOnWriteArraySet((Collection)paramIterable);
  }
  
  public static HashSet newHashSet()
  {
    return new HashSet();
  }
  
  public static HashSet newHashSet(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new HashSet(Collections2.cast(paramIterable));
    }
    return newHashSet(paramIterable.iterator());
  }
  
  public static HashSet newHashSet(Iterator paramIterator)
  {
    HashSet localHashSet = new HashSet();
    while (paramIterator.hasNext()) {
      localHashSet.add(paramIterator.next());
    }
    return localHashSet;
  }
  
  public static HashSet newHashSet(Object... paramVarArgs)
  {
    HashSet localHashSet = newHashSetWithExpectedSize(paramVarArgs.length);
    Collections.addAll(localHashSet, paramVarArgs);
    return localHashSet;
  }
  
  public static HashSet newHashSetWithExpectedSize(int paramInt)
  {
    return new HashSet(Maps.capacity(paramInt));
  }
  
  public static Set newIdentityHashSet()
  {
    return new gg.f(Maps.newIdentityHashMap());
  }
  
  public static LinkedHashSet newLinkedHashSet()
  {
    return new LinkedHashSet();
  }
  
  public static LinkedHashSet newLinkedHashSet(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new LinkedHashSet(Collections2.cast(paramIterable));
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localLinkedHashSet.add(paramIterable.next());
    }
    return localLinkedHashSet;
  }
  
  public static LinkedHashSet newLinkedHashSetWithExpectedSize(int paramInt)
  {
    return new LinkedHashSet(Maps.capacity(paramInt));
  }
  
  public static Set newSetFromMap(Map paramMap)
  {
    return new gg.f(paramMap);
  }
  
  public static TreeSet newTreeSet()
  {
    return new TreeSet();
  }
  
  public static TreeSet newTreeSet(Iterable paramIterable)
  {
    TreeSet localTreeSet = new TreeSet();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localTreeSet.add((Comparable)paramIterable.next());
    }
    return localTreeSet;
  }
  
  public static Set powerSet(Set paramSet)
  {
    paramSet = ImmutableSet.copyOf(paramSet);
    boolean bool;
    if (paramSet.size() <= 30) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Too many elements to create power set: %s > 30", new Object[] { Integer.valueOf(paramSet.size()) });
    return new gg.e(paramSet);
  }
  
  public static boolean removeAllImpl(Set paramSet, Collection paramCollection)
  {
    if (paramCollection != null)
    {
      Object localObject = paramCollection;
      if ((paramCollection instanceof Multiset)) {
        localObject = ((Multiset)paramCollection).elementSet();
      }
      if (((localObject instanceof Set)) && (((Collection)localObject).size() > paramSet.size()))
      {
        paramSet = paramSet.iterator();
        boolean bool = false;
        while (paramSet.hasNext())
        {
          paramCollection = paramSet.next();
          if (((Collection)localObject).contains(paramCollection))
          {
            bool = true;
            paramSet.remove();
          }
        }
        return bool;
      }
      return removeAllImpl(paramSet, ((Collection)localObject).iterator());
    }
    paramSet = new NullPointerException();
    throw paramSet;
  }
  
  public static boolean removeAllImpl(Set paramSet, Iterator paramIterator)
  {
    boolean bool = false;
    while (paramIterator.hasNext()) {
      bool |= paramSet.remove(paramIterator.next());
    }
    return bool;
  }
  
  public static gg.g symmetricDifference(Set paramSet1, Set paramSet2)
  {
    Preconditions.checkNotNull(paramSet1, "set1");
    Preconditions.checkNotNull(paramSet2, "set2");
    return difference(union(paramSet1, paramSet2), intersection(paramSet1, paramSet2));
  }
  
  public static gg.g union(Set paramSet1, Set paramSet2)
  {
    Preconditions.checkNotNull(paramSet1, "set1");
    Preconditions.checkNotNull(paramSet2, "set2");
    return new Signature(paramSet1, difference(paramSet2, paramSet1), paramSet2);
  }
}
