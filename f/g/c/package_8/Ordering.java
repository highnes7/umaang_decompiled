package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.b.J;
import f.g.c.package_10.Function;
import f.g.c.package_10.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@b
public abstract class Ordering<T>
  implements Comparator<T>
{
  public static final int LEFT_IS_GREATER = 1;
  public static final int RIGHT_IS_GREATER = -1;
  
  public Ordering() {}
  
  public static Ordering allEqual()
  {
    return AllEqualOrdering.INSTANCE;
  }
  
  public static Ordering compareTo()
  {
    return ModuleInformation.mModulePackage;
  }
  
  public static Ordering compound(Iterable paramIterable)
  {
    return new CompoundOrdering(paramIterable);
  }
  
  public static Ordering explicit(Object paramObject, Object... paramVarArgs)
  {
    return new ExplicitOrdering(new fd.c(paramObject, paramVarArgs));
  }
  
  public static Ordering explicit(List paramList)
  {
    return new ExplicitOrdering(paramList);
  }
  
  public static Ordering from(Ordering paramOrdering)
  {
    if (paramOrdering != null) {
      return paramOrdering;
    }
    throw new NullPointerException();
  }
  
  public static Ordering from(Comparator paramComparator)
  {
    if ((paramComparator instanceof Ordering)) {
      return (Ordering)paramComparator;
    }
    return new ComparatorOrdering(paramComparator);
  }
  
  public static Ordering getCovers()
  {
    return mf.b.covers;
  }
  
  public static Ordering natural()
  {
    return NaturalOrdering.INSTANCE;
  }
  
  private int partition(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = paramArrayOfObject[paramInt3];
    paramArrayOfObject[paramInt3] = paramArrayOfObject[paramInt2];
    paramArrayOfObject[paramInt2] = localObject;
    int i;
    for (paramInt3 = paramInt1; paramInt1 < paramInt2; paramInt3 = i)
    {
      i = paramInt3;
      if (compare(paramArrayOfObject[paramInt1], localObject) < 0)
      {
        ObjectArrays.swap(paramArrayOfObject, paramInt3, paramInt1);
        i = paramInt3 + 1;
      }
      paramInt1 += 1;
    }
    ObjectArrays.swap(paramArrayOfObject, paramInt2, paramInt3);
    return paramInt3;
  }
  
  private void quicksortLeastK(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > paramInt1)
    {
      int i = partition(paramArrayOfObject, paramInt1, paramInt2, paramInt1 + paramInt2 >>> 1);
      quicksortLeastK(paramArrayOfObject, paramInt1, i - 1, paramInt3);
      if (i < paramInt3) {
        quicksortLeastK(paramArrayOfObject, i + 1, paramInt2, paramInt3);
      }
    }
  }
  
  public int binarySearch(List paramList, Object paramObject)
  {
    return Collections.binarySearch(paramList, paramObject, this);
  }
  
  public abstract int compare(Object paramObject1, Object paramObject2);
  
  public List greatestOf(Iterable paramIterable, int paramInt)
  {
    return reverse().leastOf(paramIterable, paramInt);
  }
  
  public ImmutableList immutableSortedCopy(Iterable paramIterable)
  {
    paramIterable = Iterables.toArray(paramIterable);
    int j = paramIterable.length;
    int i = 0;
    while (i < j)
    {
      Preconditions.checkNotNull(paramIterable[i]);
      i += 1;
    }
    Arrays.sort(paramIterable, this);
    return ImmutableList.of(paramIterable);
  }
  
  public boolean isOrdered(Iterable paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext())
    {
      Object localObject;
      for (paramIterable = localIterator.next(); localIterator.hasNext(); paramIterable = localObject)
      {
        localObject = localIterator.next();
        if (compare(paramIterable, localObject) > 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean isStrictlyOrdered(Iterable paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext())
    {
      Object localObject;
      for (paramIterable = localIterator.next(); localIterator.hasNext(); paramIterable = localObject)
      {
        localObject = localIterator.next();
        if (compare(paramIterable, localObject) >= 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  public List leastOf(Iterable paramIterable, int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "%d is negative", new Object[] { Integer.valueOf(paramInt) });
    Object[] arrayOfObject = Iterables.toArray(paramIterable);
    paramIterable = arrayOfObject;
    if (arrayOfObject.length <= paramInt)
    {
      Arrays.sort(arrayOfObject, this);
    }
    else
    {
      quicksortLeastK(arrayOfObject, 0, arrayOfObject.length - 1, paramInt);
      paramIterable = new Object[paramInt];
      System.arraycopy(arrayOfObject, 0, paramIterable, 0, paramInt);
    }
    return Collections.unmodifiableList(Arrays.asList(paramIterable));
  }
  
  public Ordering lexicographical()
  {
    return new LexicographicalOrdering(this);
  }
  
  public Object max(Iterable paramIterable)
  {
    return min(paramIterable.iterator());
  }
  
  public Object max(Object paramObject1, Object paramObject2)
  {
    if (compare(paramObject1, paramObject2) >= 0) {
      return paramObject1;
    }
    return paramObject2;
  }
  
  public Object max(Object paramObject1, Object paramObject2, Object paramObject3, Object... paramVarArgs)
  {
    paramObject1 = max(max(paramObject1, paramObject2), paramObject3);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramObject1 = max(paramObject1, paramVarArgs[i]);
      i += 1;
    }
    return paramObject1;
  }
  
  public Object max(Iterator paramIterator)
  {
    for (Object localObject = paramIterator.next(); paramIterator.hasNext(); localObject = max(localObject, paramIterator.next())) {}
    return localObject;
  }
  
  public Object min(Iterable paramIterable)
  {
    return max(paramIterable.iterator());
  }
  
  public Object min(Object paramObject1, Object paramObject2)
  {
    if (compare(paramObject1, paramObject2) <= 0) {
      return paramObject1;
    }
    return paramObject2;
  }
  
  public Object min(Object paramObject1, Object paramObject2, Object paramObject3, Object... paramVarArgs)
  {
    paramObject1 = min(min(paramObject1, paramObject2), paramObject3);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramObject1 = min(paramObject1, paramVarArgs[i]);
      i += 1;
    }
    return paramObject1;
  }
  
  public Object min(Iterator paramIterator)
  {
    for (Object localObject = paramIterator.next(); paramIterator.hasNext(); localObject = min(localObject, paramIterator.next())) {}
    return localObject;
  }
  
  public Ordering nullsFirst()
  {
    return new NullsFirstOrdering(this);
  }
  
  public Ordering nullsLast()
  {
    return new NullsLastOrdering(this);
  }
  
  public Ordering onResultOf(Function paramFunction)
  {
    return new ByFunctionOrdering(paramFunction, this);
  }
  
  public Ordering reverse()
  {
    return new ReverseOrdering(this);
  }
  
  public Ordering reverse(Comparator paramComparator)
  {
    if (paramComparator != null) {
      return new CompoundOrdering(this, paramComparator);
    }
    throw new NullPointerException();
  }
  
  public List sortedCopy(Iterable paramIterable)
  {
    paramIterable = Iterables.toArray(paramIterable);
    Arrays.sort(paramIterable, this);
    return Lists.newArrayList(Arrays.asList(paramIterable));
  }
}
