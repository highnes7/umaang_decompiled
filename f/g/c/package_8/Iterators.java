package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.uh;
import f.g.c.package_10.Absent;
import f.g.c.package_10.Function;
import f.g.c.package_10.Joiner;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Optional;
import f.g.c.package_10.Preconditions;
import f.g.c.package_10.Predicate;
import f.g.c.package_10.Predicates;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

@b(emulated=true)
public final class Iterators
{
  public static final Iterator<Object> EMPTY_ITERATOR = new AbstractFormattedWalker.1();
  public static final uh<Object> EMPTY_LIST_ITERATOR = new UnmodifiableListIterator()
  {
    public boolean hasNext()
    {
      return false;
    }
    
    public boolean hasPrevious()
    {
      return false;
    }
    
    public Object next()
    {
      throw new NoSuchElementException();
    }
    
    public int nextIndex()
    {
      return 0;
    }
    
    public Object previous()
    {
      throw new NoSuchElementException();
    }
    
    public int previousIndex()
    {
      return -1;
    }
  };
  
  public Iterators() {}
  
  public static boolean addAll(Collection paramCollection, Iterator paramIterator)
  {
    if (paramCollection != null)
    {
      boolean bool = false;
      while (paramIterator.hasNext()) {
        bool |= paramCollection.add(paramIterator.next());
      }
      return bool;
    }
    paramCollection = new NullPointerException();
    throw paramCollection;
  }
  
  public static int advance(Iterator paramIterator, int paramInt)
  {
    int i;
    if (paramIterator != null)
    {
      i = 0;
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "number to advance cannot be negative");
      while (i < paramInt)
      {
        if (!paramIterator.hasNext()) {
          return i;
        }
        paramIterator.next();
        i += 1;
      }
      return i;
    }
    paramIterator = new NullPointerException();
    throw paramIterator;
    return i;
  }
  
  public static boolean all(Iterator paramIterator, Predicate paramPredicate)
  {
    if (paramPredicate != null)
    {
      while (paramIterator.hasNext()) {
        if (!paramPredicate.apply(paramIterator.next())) {
          return false;
        }
      }
      return true;
    }
    paramIterator = new NullPointerException();
    throw paramIterator;
  }
  
  public static Enumeration asEnumeration(Iterator paramIterator)
  {
    if (paramIterator != null) {
      return new Iterators.14(paramIterator);
    }
    throw new NullPointerException();
  }
  
  public static ListIterator cast(Iterator paramIterator)
  {
    return (ListIterator)paramIterator;
  }
  
  public static void checkNonnegative(int paramInt)
  {
    if (paramInt >= 0) {
      return;
    }
    throw new IndexOutOfBoundsException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("position (", paramInt, ") must not be negative"));
  }
  
  public static void checkRemove(boolean paramBoolean)
  {
    Preconditions.checkState(paramBoolean, "no calls to next() since the last call to remove()");
  }
  
  public static void clear(Iterator paramIterator)
  {
    if (paramIterator != null)
    {
      while (paramIterator.hasNext())
      {
        paramIterator.next();
        paramIterator.remove();
      }
      return;
    }
    paramIterator = new NullPointerException();
    throw paramIterator;
  }
  
  public static Iterator concat(Iterator paramIterator)
  {
    if (paramIterator != null) {
      return new Iterators.5(paramIterator);
    }
    throw new NullPointerException();
  }
  
  public static Iterator concat(Iterator paramIterator1, Iterator paramIterator2)
  {
    if (paramIterator1 != null)
    {
      if (paramIterator2 != null) {
        return concat(Arrays.asList(new Iterator[] { paramIterator1, paramIterator2 }).iterator());
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Iterator concat(Iterator paramIterator1, Iterator paramIterator2, Iterator paramIterator3)
  {
    if (paramIterator1 != null)
    {
      if (paramIterator2 != null)
      {
        if (paramIterator3 != null) {
          return concat(Arrays.asList(new Iterator[] { paramIterator1, paramIterator2, paramIterator3 }).iterator());
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Iterator concat(Iterator paramIterator1, Iterator paramIterator2, Iterator paramIterator3, Iterator paramIterator4)
  {
    if (paramIterator1 != null)
    {
      if (paramIterator2 != null)
      {
        if (paramIterator3 != null)
        {
          if (paramIterator4 != null) {
            return concat(Arrays.asList(new Iterator[] { paramIterator1, paramIterator2, paramIterator3, paramIterator4 }).iterator());
          }
          throw new NullPointerException();
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Iterator concat(Iterator... paramVarArgs)
  {
    return concat(ImmutableList.copyOf(paramVarArgs).iterator());
  }
  
  public static boolean contains(Iterator paramIterator, Object paramObject)
  {
    if (paramObject == null)
    {
      do
      {
        if (!paramIterator.hasNext()) {
          break;
        }
      } while (paramIterator.next() != null);
      return true;
    }
    while (paramIterator.hasNext()) {
      if (paramObject.equals(paramIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static Iterator cycle(Object... paramVarArgs)
  {
    return new FilterIterator(Lists.newArrayList(paramVarArgs));
  }
  
  public static boolean elementsEqual(Iterator paramIterator1, Iterator paramIterator2)
  {
    while (paramIterator1.hasNext())
    {
      if (!paramIterator2.hasNext()) {
        return false;
      }
      if (!Objects.equal(paramIterator1.next(), paramIterator2.next())) {
        return false;
      }
    }
    return paramIterator2.hasNext() ^ true;
  }
  
  public static UnmodifiableListIterator emptyListIterator()
  {
    return EMPTY_LIST_ITERATOR;
  }
  
  public static boolean exists(Iterator paramIterator, Predicate paramPredicate)
  {
    if (paramPredicate != null)
    {
      while (paramIterator.hasNext()) {
        if (paramPredicate.apply(paramIterator.next())) {
          return true;
        }
      }
      return false;
    }
    paramIterator = new NullPointerException();
    throw paramIterator;
  }
  
  public static UnmodifiableIterator filter(Iterator paramIterator, Predicate paramPredicate)
  {
    if (paramIterator != null)
    {
      if (paramPredicate != null) {
        return new TreeRangeSet.RangesByUpperBound.2(paramIterator, paramPredicate);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static UnmodifiableIterator filter(Iterator paramIterator, Class paramClass)
  {
    paramClass = Predicates.instanceOf(paramClass);
    if (paramIterator != null) {
      return new TreeRangeSet.RangesByUpperBound.2(paramIterator, paramClass);
    }
    throw new NullPointerException();
  }
  
  public static UnmodifiableIterator filter(Object... paramVarArgs)
  {
    if (paramVarArgs != null) {
      return new Option(paramVarArgs.length, paramVarArgs);
    }
    throw new NullPointerException();
  }
  
  public static Iterator filter(Iterable paramIterable)
  {
    if (paramIterable != null) {
      return new FilterIterator(paramIterable);
    }
    throw new NullPointerException();
  }
  
  public static Iterator filter(Iterator paramIterator)
  {
    if (paramIterator != null) {
      return new Iterators.10(paramIterator);
    }
    throw new NullPointerException();
  }
  
  public static Object find(Iterator paramIterator, Predicate paramPredicate)
  {
    if (paramIterator != null)
    {
      if (paramPredicate != null) {
        return new TreeRangeSet.RangesByUpperBound.2(paramIterator, paramPredicate).next();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Object find(Iterator paramIterator, Predicate paramPredicate, Object paramObject)
  {
    if (paramIterator != null)
    {
      if (paramPredicate != null)
      {
        paramIterator = new TreeRangeSet.RangesByUpperBound.2(paramIterator, paramPredicate);
        if (paramIterator.hasNext()) {
          return paramIterator.next();
        }
      }
      else
      {
        throw new NullPointerException();
      }
    }
    else {
      throw new NullPointerException();
    }
    return paramObject;
  }
  
  public static UnmodifiableListIterator forArray(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramInt2 >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfObject.length);
    return new Iterators.11(paramInt2, paramInt3, paramArrayOfObject, paramInt1);
  }
  
  public static int frequency(Iterator paramIterator, Object paramObject)
  {
    int i = 0;
    int j = 0;
    if (paramObject == null)
    {
      i = j;
      for (;;)
      {
        j = i;
        if (!paramIterator.hasNext()) {
          break;
        }
        if (paramIterator.next() == null) {
          i += 1;
        }
      }
    }
    for (;;)
    {
      j = i;
      if (!paramIterator.hasNext()) {
        break;
      }
      if (paramObject.equals(paramIterator.next())) {
        i += 1;
      }
    }
    return j;
  }
  
  public static Optional get(Iterator paramIterator, Predicate paramPredicate)
  {
    if (paramIterator != null)
    {
      if (paramPredicate != null)
      {
        paramIterator = new TreeRangeSet.RangesByUpperBound.2(paramIterator, paramPredicate);
        if (paramIterator.hasNext()) {
          return Optional.of(paramIterator.next());
        }
        return Absent.INSTANCE;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Object get(Iterator paramIterator, int paramInt)
  {
    checkNonnegative(paramInt);
    int i = 0;
    while (paramIterator.hasNext())
    {
      Object localObject = paramIterator.next();
      if (i == paramInt) {
        return localObject;
      }
      i += 1;
    }
    paramIterator = new StringBuilder();
    paramIterator.append("position (");
    paramIterator.append(paramInt);
    paramIterator.append(") must be less than the number of elements that remained (");
    paramIterator.append(i);
    paramIterator.append(")");
    paramIterator = new IndexOutOfBoundsException(paramIterator.toString());
    throw paramIterator;
  }
  
  public static Object get(Iterator paramIterator, int paramInt, Object paramObject)
  {
    checkNonnegative(paramInt);
    try
    {
      paramIterator = get(paramIterator, paramInt);
      return paramIterator;
    }
    catch (IndexOutOfBoundsException paramIterator) {}
    return paramObject;
  }
  
  public static Object get(Iterator paramIterator, Object paramObject)
  {
    if (paramIterator.hasNext()) {
      do
      {
        paramObject = paramIterator.next();
      } while (paramIterator.hasNext());
    }
    return paramObject;
  }
  
  public static Object getLast(Iterator paramIterator)
  {
    Object localObject;
    do
    {
      localObject = paramIterator.next();
    } while (paramIterator.hasNext());
    return localObject;
  }
  
  public static Object getNext(Iterator paramIterator, Object paramObject)
  {
    if (paramIterator.hasNext()) {
      paramObject = paramIterator.next();
    }
    return paramObject;
  }
  
  public static Object getOnlyElement(Iterator paramIterator)
  {
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return localObject;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("expected one element but was: <");
    localStringBuilder2.append(localObject);
    localStringBuilder1.append(localStringBuilder2.toString());
    int i = 0;
    while ((i < 4) && (paramIterator.hasNext()))
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append(", ");
      ((StringBuilder)localObject).append(paramIterator.next());
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      i += 1;
    }
    if (paramIterator.hasNext()) {
      localStringBuilder1.append(", ...");
    }
    localStringBuilder1.append('>');
    paramIterator = new IllegalArgumentException(localStringBuilder1.toString());
    throw paramIterator;
  }
  
  public static Object getOnlyElement(Iterator paramIterator, Object paramObject)
  {
    if (paramIterator.hasNext()) {
      paramObject = getOnlyElement(paramIterator);
    }
    return paramObject;
  }
  
  public static int indexOf(Iterator paramIterator, Predicate paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate, "predicate");
    int i = 0;
    while (paramIterator.hasNext())
    {
      if (paramPredicate.apply(paramIterator.next())) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static Iterator iterate()
  {
    return EMPTY_ITERATOR;
  }
  
  public static UnmodifiableIterator iterator()
  {
    return EMPTY_LIST_ITERATOR;
  }
  
  public static Iterator limit(Iterator paramIterator, int paramInt)
  {
    if (paramIterator != null)
    {
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "limit is negative");
      return new Iterators.9(paramInt, paramIterator);
    }
    throw new NullPointerException();
  }
  
  public static UnmodifiableIterator mergeSorted(Iterable paramIterable, Comparator paramComparator)
  {
    Preconditions.checkNotNull(paramIterable, "iterators");
    Preconditions.checkNotNull(paramComparator, "comparator");
    return new Jc.a(paramIterable, paramComparator);
  }
  
  public static UnmodifiableIterator paddedPartition(Iterator paramIterator, int paramInt)
  {
    return partitionImpl(paramIterator, paramInt, false);
  }
  
  public static UnmodifiableIterator partition(Iterator paramIterator, int paramInt)
  {
    return partitionImpl(paramIterator, paramInt, true);
  }
  
  public static UnmodifiableIterator partitionImpl(Iterator paramIterator, int paramInt, boolean paramBoolean)
  {
    if (paramIterator != null)
    {
      boolean bool;
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool);
      return new Iterators.6(paramIterator, paramInt, paramBoolean);
    }
    throw new NullPointerException();
  }
  
  public static PeekingIterator peekingIterator(PeekingIterator paramPeekingIterator)
  {
    if (paramPeekingIterator != null) {
      return paramPeekingIterator;
    }
    throw new NullPointerException();
  }
  
  public static PeekingIterator peekingIterator(Iterator paramIterator)
  {
    if ((paramIterator instanceof Jc.b)) {
      return (Jc.b)paramIterator;
    }
    return new Jc.b(paramIterator);
  }
  
  public static boolean removeAll(Iterator paramIterator, Collection paramCollection)
  {
    if (paramCollection != null)
    {
      boolean bool = false;
      while (paramIterator.hasNext()) {
        if (paramCollection.contains(paramIterator.next()))
        {
          paramIterator.remove();
          bool = true;
        }
      }
      return bool;
    }
    paramIterator = new NullPointerException();
    throw paramIterator;
  }
  
  public static boolean removeIf(Iterator paramIterator, Predicate paramPredicate)
  {
    if (paramPredicate != null)
    {
      boolean bool = false;
      while (paramIterator.hasNext()) {
        if (paramPredicate.apply(paramIterator.next()))
        {
          paramIterator.remove();
          bool = true;
        }
      }
      return bool;
    }
    paramIterator = new NullPointerException();
    throw paramIterator;
  }
  
  public static boolean retainAll(Iterator paramIterator, Collection paramCollection)
  {
    if (paramCollection != null)
    {
      boolean bool = false;
      while (paramIterator.hasNext()) {
        if (!paramCollection.contains(paramIterator.next()))
        {
          paramIterator.remove();
          bool = true;
        }
      }
      return bool;
    }
    paramIterator = new NullPointerException();
    throw paramIterator;
  }
  
  public static UnmodifiableIterator singletonIterator(Object paramObject)
  {
    return new Iterators.12(paramObject);
  }
  
  public static int size(Iterator paramIterator)
  {
    int i = 0;
    while (paramIterator.hasNext())
    {
      paramIterator.next();
      i += 1;
    }
    return i;
  }
  
  public static int skip(Iterator paramIterator, int paramInt)
  {
    return advance(paramIterator, paramInt);
  }
  
  public static UnmodifiableIterator take(Enumeration paramEnumeration)
  {
    if (paramEnumeration != null) {
      return new Iterators.13(paramEnumeration);
    }
    throw new NullPointerException();
  }
  
  public static Object[] toArray(Iterator paramIterator, Class paramClass)
  {
    return Iterables.toArray(Lists.newArrayList(paramIterator), paramClass);
  }
  
  public static String toString(Iterator paramIterator)
  {
    Joiner localJoiner = new Joiner(", ").useForNull("null");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    paramIterator = localJoiner.appendTo(localStringBuilder, paramIterator);
    paramIterator.append(']');
    return paramIterator.toString();
  }
  
  public static Iterator transform(Iterator paramIterator, Function paramFunction)
  {
    if (paramFunction != null) {
      return new Maps.2(paramIterator, paramFunction);
    }
    throw new NullPointerException();
  }
  
  public static UnmodifiableIterator unmodifiableIterator(UnmodifiableIterator paramUnmodifiableIterator)
  {
    if (paramUnmodifiableIterator != null) {
      return paramUnmodifiableIterator;
    }
    throw new NullPointerException();
  }
  
  public static UnmodifiableIterator unmodifiableIterator(Iterator paramIterator)
  {
    if (paramIterator != null)
    {
      if ((paramIterator instanceof UnmodifiableIterator)) {
        return (UnmodifiableIterator)paramIterator;
      }
      return new Iterators.3(paramIterator);
    }
    throw new NullPointerException();
  }
  
  public static UnmodifiableListIterator unmodifiableListIterator(ListIterator paramListIterator)
  {
    if (paramListIterator != null)
    {
      if ((paramListIterator instanceof UnmodifiableListIterator)) {
        return (UnmodifiableListIterator)paramListIterator;
      }
      return new Iterators.4(paramListIterator);
    }
    throw new NullPointerException();
  }
}
