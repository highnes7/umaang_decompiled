package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.c;
import f.g.c.d.Ag;
import f.g.c.d.Ub;
import f.g.c.d.Vb;
import f.g.c.package_10.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

@a
@c("hasn't been tested yet")
public abstract class ImmutableSortedMultiset<E>
  extends Vb<E>
  implements Ag<E>
{
  public static final Ub<Comparable> NATURAL_EMPTY_MULTISET = new EmptyImmutableSortedMultiset(NATURAL_ORDER);
  public static final Comparator<Comparable> NATURAL_ORDER = ;
  public transient Ub<E> descendingMultiset;
  
  public ImmutableSortedMultiset() {}
  
  public static Ub.a append(Comparator paramComparator)
  {
    return new Ub.a(paramComparator);
  }
  
  public static ImmutableSortedMultiset copyOf(Iterable paramIterable)
  {
    return copyOf(Ordering.natural(), paramIterable);
  }
  
  public static ImmutableSortedMultiset copyOf(Comparator paramComparator, Iterable paramIterable)
  {
    Object localObject;
    if ((paramIterable instanceof ImmutableSortedMultiset))
    {
      localObject = (ImmutableSortedMultiset)paramIterable;
      if (paramComparator.equals(((ImmutableSortedMultiset)localObject).comparator()))
      {
        paramIterable = (Iterable)localObject;
        if (((ImmutableCollection)localObject).isPartialView()) {
          paramIterable = copyOfSortedEntries(paramComparator, ((ImmutableMultiset)localObject).entrySet().asList());
        }
        return paramIterable;
      }
    }
    paramIterable = Lists.newArrayList(paramIterable);
    if (paramComparator != null)
    {
      localObject = TreeMultiset.create(paramComparator);
      Iterables.addAll((Collection)localObject, paramIterable);
      return copyOfSortedEntries(paramComparator, ((TreeMultiset)localObject).entrySet());
    }
    throw new NullPointerException();
  }
  
  public static ImmutableSortedMultiset copyOf(Comparator paramComparator, Iterator paramIterator)
  {
    if (paramComparator != null) {
      return new Ub.a(paramComparator).addModules(paramIterator).build();
    }
    throw new NullPointerException();
  }
  
  public static ImmutableSortedMultiset copyOf(Iterator paramIterator)
  {
    return copyOf(Ordering.natural(), paramIterator);
  }
  
  public static ImmutableSortedMultiset copyOf(Comparable[] paramArrayOfComparable)
  {
    return copyOf(Ordering.natural(), Arrays.asList(paramArrayOfComparable));
  }
  
  public static ImmutableSortedMultiset copyOfSorted(SortedMultiset paramSortedMultiset)
  {
    return copyOfSortedEntries(paramSortedMultiset.comparator(), Lists.newArrayList(paramSortedMultiset.entrySet()));
  }
  
  public static ImmutableSortedMultiset copyOfSortedEntries(Comparator paramComparator, Collection paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return emptyMultiset(paramComparator);
    }
    vb.a localA = new vb.a(paramCollection.size());
    int[] arrayOfInt = new int[paramCollection.size()];
    long[] arrayOfLong = new long[paramCollection.size() + 1];
    int i = 0;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Ye.a localA1 = (Ye.a)localIterator.next();
      localA.add(localA1.getElement());
      arrayOfInt[i] = localA1.getCount();
      int j = i + 1;
      arrayOfLong[i] += arrayOfInt[i];
      i = j;
    }
    return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(localA.build(), paramComparator), arrayOfInt, arrayOfLong, 0, paramCollection.size());
  }
  
  public static Ub.a descendingEntryIterator()
  {
    return new Ub.a(Ordering.natural());
  }
  
  public static ImmutableSortedMultiset emptyMultiset(Comparator paramComparator)
  {
    if (NATURAL_ORDER.equals(paramComparator)) {
      return NATURAL_EMPTY_MULTISET;
    }
    return new EmptyImmutableSortedMultiset(paramComparator);
  }
  
  public static ImmutableSortedMultiset of()
  {
    return NATURAL_EMPTY_MULTISET;
  }
  
  public static ImmutableSortedMultiset of(Comparable paramComparable)
  {
    return new RegularImmutableSortedMultiset((RegularImmutableSortedSet)ImmutableSortedSet.of(paramComparable), new int[] { 1 }, new long[] { 0L, 1L }, 0, 1);
  }
  
  public static ImmutableSortedMultiset of(Comparable paramComparable1, Comparable paramComparable2)
  {
    return copyOf(Ordering.natural(), Arrays.asList(new Comparable[] { paramComparable1, paramComparable2 }));
  }
  
  public static ImmutableSortedMultiset of(Comparable paramComparable1, Comparable paramComparable2, Comparable paramComparable3)
  {
    return copyOf(Ordering.natural(), Arrays.asList(new Comparable[] { paramComparable1, paramComparable2, paramComparable3 }));
  }
  
  public static ImmutableSortedMultiset of(Comparable paramComparable1, Comparable paramComparable2, Comparable paramComparable3, Comparable paramComparable4)
  {
    return copyOf(Ordering.natural(), Arrays.asList(new Comparable[] { paramComparable1, paramComparable2, paramComparable3, paramComparable4 }));
  }
  
  public static ImmutableSortedMultiset of(Comparable paramComparable1, Comparable paramComparable2, Comparable paramComparable3, Comparable paramComparable4, Comparable paramComparable5)
  {
    return copyOf(Ordering.natural(), Arrays.asList(new Comparable[] { paramComparable1, paramComparable2, paramComparable3, paramComparable4, paramComparable5 }));
  }
  
  public static ImmutableSortedMultiset of(Comparable paramComparable1, Comparable paramComparable2, Comparable paramComparable3, Comparable paramComparable4, Comparable paramComparable5, Comparable paramComparable6, Comparable... paramVarArgs)
  {
    ArrayList localArrayList = Lists.newArrayListWithCapacity(paramVarArgs.length + 6);
    Collections.addAll(localArrayList, new Comparable[] { paramComparable1, paramComparable2, paramComparable3, paramComparable4, paramComparable5, paramComparable6 });
    Collections.addAll(localArrayList, paramVarArgs);
    return copyOf(Ordering.natural(), localArrayList);
  }
  
  public static Ub.a reverseOrder()
  {
    return new Ub.a(Ordering.natural().reverse());
  }
  
  public final Comparator comparator()
  {
    return elementSet().comparator();
  }
  
  public ImmutableSortedMultiset descendingMultiset()
  {
    Object localObject = descendingMultiset;
    if (localObject == null)
    {
      localObject = new DescendingImmutableSortedMultiset(this);
      descendingMultiset = ((ImmutableSortedMultiset)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public abstract ImmutableSortedSet elementSet();
  
  public abstract ImmutableSortedMultiset headMultiset(Object paramObject, BoundType paramBoundType);
  
  public final Ye.a pollFirstEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  public final Ye.a pollLastEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableSortedMultiset subMultiset(Object paramObject1, BoundType paramBoundType1, Object paramObject2, BoundType paramBoundType2)
  {
    boolean bool;
    if (comparator().compare(paramObject1, paramObject2) <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Expected lowerBound <= upperBound but %s > %s", new Object[] { paramObject1, paramObject2 });
    return tailMultiset(paramObject1, paramBoundType1).headMultiset(paramObject2, paramBoundType2);
  }
  
  public abstract ImmutableSortedMultiset tailMultiset(Object paramObject, BoundType paramBoundType);
  
  public Object writeReplace()
  {
    return new Ub.b(this);
  }
}
