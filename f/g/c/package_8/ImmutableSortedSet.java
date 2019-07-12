package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.Wb;
import f.g.c.d.Xb;
import f.g.c.d.ng;
import f.g.c.package_10.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

@b(emulated=true, serializable=true)
public abstract class ImmutableSortedSet<E>
  extends Xb<E>
  implements SortedSet<E>, ng<E>
{
  public static final Wb<Comparable> NATURAL_EMPTY_SET = new EmptyImmutableSortedSet(NATURAL_ORDER);
  public static final Comparator<Comparable> NATURAL_ORDER = ;
  public final transient Comparator<? super E> comparator;
  @c("NavigableSet")
  public transient Wb<E> descendingSet;
  
  public ImmutableSortedSet(Comparator paramComparator)
  {
    comparator = paramComparator;
  }
  
  public static ImmutableSortedSet construct(Comparator paramComparator, int paramInt, Object... paramVarArgs)
  {
    paramInt = sortAndUnique(paramComparator, paramInt, paramVarArgs);
    if (paramInt == 0) {
      return emptySet(paramComparator);
    }
    Object[] arrayOfObject = paramVarArgs;
    if (paramInt < paramVarArgs.length) {
      arrayOfObject = ObjectArrays.add(paramVarArgs, paramInt);
    }
    return new RegularImmutableSortedSet(ImmutableList.of(arrayOfObject), paramComparator);
  }
  
  public static ImmutableSortedSet copyOf(Iterable paramIterable)
  {
    return copyOf(Ordering.natural(), paramIterable);
  }
  
  public static ImmutableSortedSet copyOf(Collection paramCollection)
  {
    return copyOf(Ordering.natural(), paramCollection);
  }
  
  public static ImmutableSortedSet copyOf(Comparator paramComparator, Iterable paramIterable)
  {
    if (paramComparator != null)
    {
      if ((SortedIterables.hasSameComparator(paramComparator, paramIterable)) && ((paramIterable instanceof ImmutableSortedSet)))
      {
        ImmutableSortedSet localImmutableSortedSet = (ImmutableSortedSet)paramIterable;
        if (!localImmutableSortedSet.isPartialView()) {
          return localImmutableSortedSet;
        }
      }
      paramIterable = Iterables.toArray(paramIterable);
      return construct(paramComparator, paramIterable.length, paramIterable);
    }
    throw new NullPointerException();
  }
  
  public static ImmutableSortedSet copyOf(Comparator paramComparator, Collection paramCollection)
  {
    return copyOf(paramComparator, paramCollection);
  }
  
  public static ImmutableSortedSet copyOf(Comparator paramComparator, Iterator paramIterator)
  {
    return copyOf(paramComparator, Lists.newArrayList(paramIterator));
  }
  
  public static ImmutableSortedSet copyOf(Comparable[] paramArrayOfComparable)
  {
    return copyOf(Ordering.natural(), Arrays.asList(paramArrayOfComparable));
  }
  
  public static Wb.a copyOf()
  {
    return new Wb.a(Ordering.natural());
  }
  
  public static ImmutableSortedSet copyOfSorted(SortedSet paramSortedSet)
  {
    Comparator localComparator = paramSortedSet.comparator();
    Object localObject = localComparator;
    if (localComparator == null) {
      localObject = Ordering.natural();
    }
    paramSortedSet = paramSortedSet.toArray();
    if (paramSortedSet.length == 0) {
      return emptySet((Comparator)localObject);
    }
    return new RegularImmutableSortedSet(ImmutableList.of(paramSortedSet), (Comparator)localObject);
  }
  
  public static ImmutableSortedSet emptySet()
  {
    return NATURAL_EMPTY_SET;
  }
  
  public static ImmutableSortedSet emptySet(Comparator paramComparator)
  {
    if (NATURAL_ORDER.equals(paramComparator)) {
      return NATURAL_EMPTY_SET;
    }
    return new EmptyImmutableSortedSet(paramComparator);
  }
  
  public static Wb.a floor(Comparator paramComparator)
  {
    return new Wb.a(paramComparator);
  }
  
  public static ImmutableSortedSet of()
  {
    return NATURAL_EMPTY_SET;
  }
  
  public static ImmutableSortedSet of(Comparable paramComparable)
  {
    return new RegularImmutableSortedSet(ImmutableList.of(paramComparable), Ordering.natural());
  }
  
  public static ImmutableSortedSet of(Comparable paramComparable1, Comparable paramComparable2)
  {
    return copyOf(Ordering.natural(), Arrays.asList(new Comparable[] { paramComparable1, paramComparable2 }));
  }
  
  public static ImmutableSortedSet of(Comparable paramComparable1, Comparable paramComparable2, Comparable paramComparable3)
  {
    return copyOf(Ordering.natural(), Arrays.asList(new Comparable[] { paramComparable1, paramComparable2, paramComparable3 }));
  }
  
  public static ImmutableSortedSet of(Comparable paramComparable1, Comparable paramComparable2, Comparable paramComparable3, Comparable paramComparable4)
  {
    return copyOf(Ordering.natural(), Arrays.asList(new Comparable[] { paramComparable1, paramComparable2, paramComparable3, paramComparable4 }));
  }
  
  public static ImmutableSortedSet of(Comparable paramComparable1, Comparable paramComparable2, Comparable paramComparable3, Comparable paramComparable4, Comparable paramComparable5)
  {
    return copyOf(Ordering.natural(), Arrays.asList(new Comparable[] { paramComparable1, paramComparable2, paramComparable3, paramComparable4, paramComparable5 }));
  }
  
  public static ImmutableSortedSet of(Comparable paramComparable1, Comparable paramComparable2, Comparable paramComparable3, Comparable paramComparable4, Comparable paramComparable5, Comparable paramComparable6, Comparable... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length + 6);
    Collections.addAll(localArrayList, new Comparable[] { paramComparable1, paramComparable2, paramComparable3, paramComparable4, paramComparable5, paramComparable6 });
    Collections.addAll(localArrayList, paramVarArgs);
    return copyOf(Ordering.natural(), localArrayList);
  }
  
  public static ImmutableSortedSet of(Iterator paramIterator)
  {
    return copyOf(Ordering.natural(), paramIterator);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws InvalidObjectException
  {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  public static Wb.a reverseOrder()
  {
    return new Wb.a(Ordering.natural().reverse());
  }
  
  public static int sortAndUnique(Comparator paramComparator, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0) {
      return 0;
    }
    int i = 0;
    while (i < paramInt)
    {
      ObjectArrays.get(paramVarArgs[i], i);
      i += 1;
    }
    Arrays.sort(paramVarArgs, 0, paramInt, paramComparator);
    i = 1;
    int k;
    for (int j = 1; i < paramInt; j = k)
    {
      Object localObject = paramVarArgs[i];
      k = j;
      if (paramComparator.compare(localObject, paramVarArgs[(j - 1)]) != 0)
      {
        paramVarArgs[j] = localObject;
        k = j + 1;
      }
      i += 1;
    }
    Arrays.fill(paramVarArgs, j, paramInt, null);
    return j;
  }
  
  public static int unsafeCompare(Comparator paramComparator, Object paramObject1, Object paramObject2)
  {
    return paramComparator.compare(paramObject1, paramObject2);
  }
  
  public Object ceiling(Object paramObject)
  {
    return Iterables.getFirst(tailSet(paramObject, true), null);
  }
  
  public Comparator comparator()
  {
    return comparator;
  }
  
  public abstract ImmutableSortedSet createDescendingSet();
  
  public UnmodifiableIterator descendingIterator()
  {
    return descendingSet().iterator();
  }
  
  public ImmutableSortedSet descendingSet()
  {
    ImmutableSortedSet localImmutableSortedSet2 = descendingSet;
    ImmutableSortedSet localImmutableSortedSet1 = localImmutableSortedSet2;
    if (localImmutableSortedSet2 == null)
    {
      localImmutableSortedSet1 = createDescendingSet();
      descendingSet = localImmutableSortedSet1;
      descendingSet = this;
    }
    return localImmutableSortedSet1;
  }
  
  public Object floor(Object paramObject)
  {
    return Iterables.getFirst(headSet(paramObject, true).descendingSet(), null);
  }
  
  public ImmutableSortedSet headSet(Object paramObject)
  {
    return headSet(paramObject, false);
  }
  
  public ImmutableSortedSet headSet(Object paramObject, boolean paramBoolean)
  {
    if (paramObject != null) {
      return headSetImpl(paramObject, paramBoolean);
    }
    throw new NullPointerException();
  }
  
  public abstract ImmutableSortedSet headSetImpl(Object paramObject, boolean paramBoolean);
  
  public Object higher(Object paramObject)
  {
    return Iterables.getFirst(tailSet(paramObject, false), null);
  }
  
  public abstract int indexOf(Object paramObject);
  
  public abstract UnmodifiableIterator iterator();
  
  public Object lower(Object paramObject)
  {
    return Iterables.getFirst(headSet(paramObject, false).descendingSet(), null);
  }
  
  public final Object pollFirst()
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object pollLast()
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableSortedSet subSet(Object paramObject1, Object paramObject2)
  {
    return subSet(paramObject1, true, paramObject2, false);
  }
  
  public ImmutableSortedSet subSet(Object paramObject1, boolean paramBoolean1, Object paramObject2, boolean paramBoolean2)
  {
    if (paramObject1 != null)
    {
      if (paramObject2 != null)
      {
        boolean bool;
        if (comparator.compare(paramObject1, paramObject2) <= 0) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkArgument(bool);
        return subSetImpl(paramObject1, paramBoolean1, paramObject2, paramBoolean2);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public abstract ImmutableSortedSet subSetImpl(Object paramObject1, boolean paramBoolean1, Object paramObject2, boolean paramBoolean2);
  
  public ImmutableSortedSet tailSet(Object paramObject)
  {
    return tailSet(paramObject, true);
  }
  
  public ImmutableSortedSet tailSet(Object paramObject, boolean paramBoolean)
  {
    if (paramObject != null) {
      return tailSetImpl(paramObject, paramBoolean);
    }
    throw new NullPointerException();
  }
  
  public abstract ImmutableSortedSet tailSetImpl(Object paramObject, boolean paramBoolean);
  
  public int unsafeCompare(Object paramObject1, Object paramObject2)
  {
    return comparator.compare(paramObject1, paramObject2);
  }
  
  public Object writeReplace()
  {
    return new Wb.b(comparator, toArray());
  }
}
