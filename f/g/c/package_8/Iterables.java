package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.package_10.Function;
import f.g.c.package_10.Optional;
import f.g.c.package_10.Preconditions;
import f.g.c.package_10.Predicate;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.SortedSet;

@b(emulated=true)
public final class Iterables
{
  public Iterables() {}
  
  public static boolean addAll(Collection paramCollection, Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return paramCollection.addAll(Collections2.cast(paramIterable));
    }
    return Iterators.addAll(paramCollection, paramIterable.iterator());
  }
  
  public static boolean all(Iterable paramIterable, Predicate paramPredicate)
  {
    return Iterators.all(paramIterable.iterator(), paramPredicate);
  }
  
  public static void checkNonnegativeIndex(int paramInt)
  {
    if (paramInt >= 0) {
      return;
    }
    throw new IndexOutOfBoundsException(StringBuilder.toString("position cannot be negative: ", paramInt));
  }
  
  public static Iterable concat(Iterable paramIterable)
  {
    if (paramIterable != null) {
      return new Iterables.2(paramIterable);
    }
    throw new NullPointerException();
  }
  
  public static Iterable concat(Iterable paramIterable1, Iterable paramIterable2)
  {
    if (paramIterable1 != null)
    {
      if (paramIterable2 != null) {
        return concat(Arrays.asList(new Iterable[] { paramIterable1, paramIterable2 }));
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Iterable concat(Iterable paramIterable1, Iterable paramIterable2, Iterable paramIterable3)
  {
    if (paramIterable1 != null)
    {
      if (paramIterable2 != null)
      {
        if (paramIterable3 != null) {
          return concat(Arrays.asList(new Iterable[] { paramIterable1, paramIterable2, paramIterable3 }));
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Iterable concat(Iterable paramIterable1, Iterable paramIterable2, Iterable paramIterable3, Iterable paramIterable4)
  {
    if (paramIterable1 != null)
    {
      if (paramIterable2 != null)
      {
        if (paramIterable3 != null)
        {
          if (paramIterable4 != null) {
            return concat(Arrays.asList(new Iterable[] { paramIterable1, paramIterable2, paramIterable3, paramIterable4 }));
          }
          throw new NullPointerException();
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Iterable concat(Iterable... paramVarArgs)
  {
    return concat(ImmutableList.copyOf(paramVarArgs));
  }
  
  public static boolean contains(Iterable paramIterable, Object paramObject)
  {
    if ((paramIterable instanceof Collection)) {
      paramIterable = (Collection)paramIterable;
    }
    try
    {
      boolean bool = paramIterable.contains(paramObject);
      return bool;
    }
    catch (NullPointerException paramIterable)
    {
      return false;
    }
    catch (ClassCastException paramIterable) {}
    return Iterators.contains(paramIterable.iterator(), paramObject);
    return false;
  }
  
  public static Iterable cycle(Iterable paramIterable)
  {
    if (paramIterable != null) {
      return new Iterables.1(paramIterable);
    }
    throw new NullPointerException();
  }
  
  public static Iterable cycle(Object... paramVarArgs)
  {
    return new Iterables.1(Lists.newArrayList(paramVarArgs));
  }
  
  public static boolean elementsEqual(Iterable paramIterable1, Iterable paramIterable2)
  {
    return Iterators.elementsEqual(paramIterable1.iterator(), paramIterable2.iterator());
  }
  
  public static Iterable filter(Iterable paramIterable)
  {
    if ((paramIterable instanceof Queue)) {
      return new Iterables.6(paramIterable);
    }
    if (paramIterable != null) {
      return new Iterables.UnmodifiableIterable(paramIterable);
    }
    throw new NullPointerException();
  }
  
  public static Iterable filter(Iterable paramIterable, int paramInt)
  {
    if (paramIterable != null)
    {
      boolean bool;
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool);
      return new Iterables.7(paramIterable, paramInt);
    }
    throw new NullPointerException();
  }
  
  public static Iterable filter(Iterable paramIterable, Class paramClass)
  {
    if (paramIterable != null)
    {
      if (paramClass != null) {
        return new Iterators.7(paramIterable, paramClass);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static boolean filter(Iterable paramIterable, Predicate paramPredicate)
  {
    return Iterators.exists(paramIterable.iterator(), paramPredicate);
  }
  
  public static Object find(Iterable paramIterable, Predicate paramPredicate)
  {
    return Iterators.find(paramIterable.iterator(), paramPredicate);
  }
  
  public static Object find(Iterable paramIterable, Predicate paramPredicate, Object paramObject)
  {
    return Iterators.find(paramIterable.iterator(), paramPredicate, paramObject);
  }
  
  public static int frequency(Iterable paramIterable, Object paramObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public static Iterable get(Iterable paramIterable)
  {
    if (paramIterable != null)
    {
      if (!(paramIterable instanceof rc.b))
      {
        if ((paramIterable instanceof ImmutableCollection)) {
          return paramIterable;
        }
        return new rc.b(paramIterable, null);
      }
      return paramIterable;
    }
    throw new NullPointerException();
  }
  
  public static Iterable get(Iterable paramIterable, Predicate paramPredicate)
  {
    if (paramIterable != null)
    {
      if (paramPredicate != null) {
        return new PhoneNumberUtil.1(paramIterable, paramPredicate);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Object get(Iterable paramIterable, int paramInt)
  {
    if (paramIterable != null)
    {
      if ((paramIterable instanceof List)) {
        return ((List)paramIterable).get(paramInt);
      }
      if ((paramIterable instanceof Collection)) {
        Preconditions.checkElementIndex(paramInt, ((Collection)paramIterable).size(), "index");
      } else {
        checkNonnegativeIndex(paramInt);
      }
      return Iterators.get(paramIterable.iterator(), paramInt);
    }
    throw new NullPointerException();
  }
  
  public static Object get(Iterable paramIterable, int paramInt, Object paramObject)
  {
    if (paramIterable != null) {
      checkNonnegativeIndex(paramInt);
    }
    try
    {
      paramIterable = get(paramIterable, paramInt);
      return paramIterable;
    }
    catch (IndexOutOfBoundsException paramIterable) {}
    throw new NullPointerException();
    return paramObject;
  }
  
  public static Object getFirst(Iterable paramIterable, Object paramObject)
  {
    return Iterators.getNext(paramIterable.iterator(), paramObject);
  }
  
  public static Object getLast(Iterable paramIterable)
  {
    if ((paramIterable instanceof List))
    {
      paramIterable = (List)paramIterable;
      if (!paramIterable.isEmpty()) {
        return paramIterable.get(paramIterable.size() - 1);
      }
      throw new NoSuchElementException();
    }
    if ((paramIterable instanceof SortedSet)) {
      return ((SortedSet)paramIterable).last();
    }
    return Iterators.getLast(paramIterable.iterator());
  }
  
  public static Object getLast(Iterable paramIterable, Object paramObject)
  {
    if (((paramIterable instanceof Collection)) && (Collections2.cast(paramIterable).isEmpty())) {
      return paramObject;
    }
    if ((paramIterable instanceof List)) {
      return getLast((List)paramIterable);
    }
    if ((paramIterable instanceof SortedSet)) {
      return ((SortedSet)paramIterable).last();
    }
    return Iterators.get(paramIterable.iterator(), paramObject);
  }
  
  public static Object getLast(List paramList)
  {
    return StringBuilder.get(paramList, -1);
  }
  
  public static Function getOnlyElement()
  {
    return new Iterables.15();
  }
  
  public static Object getOnlyElement(Iterable paramIterable)
  {
    return Iterators.getOnlyElement(paramIterable.iterator());
  }
  
  public static Object getOnlyElement(Iterable paramIterable, Object paramObject)
  {
    return Iterators.getOnlyElement(paramIterable.iterator(), paramObject);
  }
  
  public static int indexOf(Iterable paramIterable, Predicate paramPredicate)
  {
    return Iterators.indexOf(paramIterable.iterator(), paramPredicate);
  }
  
  public static boolean isEmpty(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).isEmpty();
    }
    return paramIterable.iterator().hasNext() ^ true;
  }
  
  public static UnmodifiableIterator iterators(Iterable paramIterable)
  {
    return new Iterables.3(paramIterable.iterator());
  }
  
  public static Iterable limit(Iterable paramIterable, int paramInt)
  {
    if (paramIterable != null)
    {
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "limit is negative");
      return new Iterables.11(paramIterable, paramInt);
    }
    throw new NullPointerException();
  }
  
  public static Iterable mergeSorted(Iterable paramIterable, Comparator paramComparator)
  {
    Preconditions.checkNotNull(paramIterable, "iterables");
    Preconditions.checkNotNull(paramComparator, "comparator");
    return new rc.b(new Iterables.14(paramIterable, paramComparator), null);
  }
  
  public static Iterable partition(Iterable paramIterable, int paramInt)
  {
    if (paramIterable != null)
    {
      boolean bool;
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool);
      return new Iterables.4(paramIterable, paramInt);
    }
    throw new NullPointerException();
  }
  
  public static boolean remove(Iterable paramIterable, Collection paramCollection)
  {
    if ((paramIterable instanceof Collection))
    {
      paramIterable = (Collection)paramIterable;
      if (paramCollection != null) {
        return paramIterable.removeAll(paramCollection);
      }
      throw new NullPointerException();
    }
    return Iterators.removeAll(paramIterable.iterator(), paramCollection);
  }
  
  public static boolean removeIf(Iterable paramIterable, Predicate paramPredicate)
  {
    if (((paramIterable instanceof RandomAccess)) && ((paramIterable instanceof List)))
    {
      paramIterable = (List)paramIterable;
      if (paramPredicate != null) {
        return removeIfFromRandomAccessList(paramIterable, paramPredicate);
      }
      throw new NullPointerException();
    }
    return Iterators.removeIf(paramIterable.iterator(), paramPredicate);
  }
  
  public static boolean removeIfFromRandomAccessList(List paramList, Predicate paramPredicate)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramList.size(); j = k)
    {
      Object localObject = paramList.get(i);
      k = j;
      if ((paramPredicate.apply(localObject)) || (i > j)) {}
      try
      {
        paramList.set(j, localObject);
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        for (;;) {}
      }
      slowRemoveIfForRemainingElements(paramList, paramPredicate, j, i);
      return true;
      k = j + 1;
      i += 1;
    }
    paramList.subList(j, paramList.size()).clear();
    return i != j;
  }
  
  public static boolean retainAll(Iterable paramIterable, Collection paramCollection)
  {
    if ((paramIterable instanceof Collection))
    {
      paramIterable = (Collection)paramIterable;
      if (paramCollection != null) {
        return paramIterable.retainAll(paramCollection);
      }
      throw new NullPointerException();
    }
    return Iterators.retainAll(paramIterable.iterator(), paramCollection);
  }
  
  public static int size(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).size();
    }
    return Iterators.size(paramIterable.iterator());
  }
  
  public static Iterable skip(Iterable paramIterable, int paramInt)
  {
    if (paramIterable != null)
    {
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "number to skip cannot be negative");
      if ((paramIterable instanceof List)) {
        return new Iterables.9(paramInt, (List)paramIterable);
      }
      return new Iterables.10(paramIterable, paramInt);
    }
    throw new NullPointerException();
  }
  
  public static void slowRemoveIfForRemainingElements(List paramList, Predicate paramPredicate, int paramInt1, int paramInt2)
  {
    int i = paramList.size() - 1;
    while (i > paramInt2)
    {
      if (paramPredicate.apply(paramList.get(i))) {
        paramList.remove(i);
      }
      i -= 1;
    }
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      paramList.remove(paramInt2);
      paramInt2 -= 1;
    }
  }
  
  public static Object[] toArray(Iterable paramIterable)
  {
    return toCollection(paramIterable).toArray();
  }
  
  public static Object[] toArray(Iterable paramIterable, Class paramClass)
  {
    paramIterable = toCollection(paramIterable);
    return paramIterable.toArray(ObjectArrays.newArray(paramClass, paramIterable.size()));
  }
  
  public static Collection toCollection(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return (Collection)paramIterable;
    }
    return Lists.newArrayList(paramIterable.iterator());
  }
  
  public static String toString(Iterable paramIterable)
  {
    return Iterators.toString(paramIterable.iterator());
  }
  
  public static Iterable transform(Iterable paramIterable, Function paramFunction)
  {
    if (paramIterable != null)
    {
      if (paramFunction != null) {
        return new PhoneNumberUtil.2(paramIterable, paramFunction);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Optional tryFind(Iterable paramIterable, Predicate paramPredicate)
  {
    return Iterators.get(paramIterable.iterator(), paramPredicate);
  }
  
  public static Iterable unmodifiableIterable(ImmutableCollection paramImmutableCollection)
  {
    if (paramImmutableCollection != null) {
      return paramImmutableCollection;
    }
    throw new NullPointerException();
  }
}
