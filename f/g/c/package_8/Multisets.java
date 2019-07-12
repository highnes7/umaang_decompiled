package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.mf;
import f.g.c.j.g;
import f.g.c.package_10.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@b
public final class Multisets
{
  public static final mf<f.g.c.d.Ye.a<?>> DECREASING_COUNT_ORDERING = new Ordering()
  {
    public int a(Ye.a paramAnonymousA1, Ye.a paramAnonymousA2)
    {
      return g.a(paramAnonymousA2.getCount(), paramAnonymousA1.getCount());
    }
  };
  
  public Multisets() {}
  
  public static boolean addAllImpl(Multiset paramMultiset, Collection paramCollection)
  {
    if (paramCollection.isEmpty()) {
      return false;
    }
    if ((paramCollection instanceof Multiset))
    {
      paramCollection = ((Multiset)paramCollection).entrySet().iterator();
      while (paramCollection.hasNext())
      {
        Ye.a localA = (Ye.a)paramCollection.next();
        paramMultiset.add(localA.getElement(), localA.getCount());
      }
    }
    Iterators.addAll(paramMultiset, paramCollection.iterator());
    return true;
  }
  
  public static Multiset cast(Iterable paramIterable)
  {
    return (Multiset)paramIterable;
  }
  
  public static void checkNonnegative(int paramInt, String paramString)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "%s cannot be negative: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public static ImmutableMultiset copyHighestCountFirst(Multiset paramMultiset)
  {
    return ImmutableMultiset.copyFromEntries(DECREASING_COUNT_ORDERING.sortedCopy(paramMultiset.entrySet()));
  }
  
  public static boolean count(Multiset paramMultiset1, Multiset paramMultiset2)
  {
    if (paramMultiset1 != null)
    {
      if (paramMultiset2 != null)
      {
        paramMultiset2 = paramMultiset2.entrySet().iterator();
        while (paramMultiset2.hasNext())
        {
          Ye.a localA = (Ye.a)paramMultiset2.next();
          if (paramMultiset1.count(localA.getElement()) < localA.getCount()) {
            return false;
          }
        }
        return true;
      }
      throw new NullPointerException();
    }
    paramMultiset1 = new NullPointerException();
    throw paramMultiset1;
  }
  
  public static boolean equalsImpl(Multiset paramMultiset, Object paramObject)
  {
    if (paramObject == paramMultiset) {
      return true;
    }
    if ((paramObject instanceof Multiset))
    {
      paramObject = (Multiset)paramObject;
      if (paramMultiset.size() == paramObject.size())
      {
        if (paramMultiset.entrySet().size() != paramObject.entrySet().size()) {
          return false;
        }
        paramObject = paramObject.entrySet().iterator();
        while (paramObject.hasNext())
        {
          Ye.a localA = (Ye.a)paramObject.next();
          if (paramMultiset.count(localA.getElement()) != localA.getCount()) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public static Multiset filter(ImmutableMultiset paramImmutableMultiset)
  {
    if (paramImmutableMultiset != null) {
      return paramImmutableMultiset;
    }
    throw new NullPointerException();
  }
  
  public static Multiset forSet(Set paramSet)
  {
    return new bf.f(paramSet);
  }
  
  public static Ye.a immutableEntry(Object paramObject, int paramInt)
  {
    return new bf.d(paramObject, paramInt);
  }
  
  public static int inferDistinctElements(Iterable paramIterable)
  {
    if ((paramIterable instanceof Multiset)) {
      return ((Multiset)paramIterable).elementSet().size();
    }
    return 11;
  }
  
  public static Iterator iteratorImpl(Multiset paramMultiset)
  {
    return new bf.e(paramMultiset, paramMultiset.entrySet().iterator());
  }
  
  public static boolean removeAllImpl(Multiset paramMultiset, Collection paramCollection)
  {
    Object localObject = paramCollection;
    if ((paramCollection instanceof Multiset)) {
      localObject = ((Multiset)paramCollection).elementSet();
    }
    return paramMultiset.elementSet().removeAll((Collection)localObject);
  }
  
  public static boolean removeOccurrences(Multiset paramMultiset1, Multiset paramMultiset2)
  {
    return removeOccurrencesImpl(paramMultiset1, paramMultiset2);
  }
  
  public static boolean removeOccurrencesImpl(Multiset paramMultiset1, Multiset paramMultiset2)
  {
    if (paramMultiset1 != null)
    {
      if (paramMultiset2 != null)
      {
        boolean bool = false;
        Iterator localIterator = paramMultiset1.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Ye.a localA = (Ye.a)localIterator.next();
          int i = paramMultiset2.count(localA.getElement());
          if (i >= localA.getCount()) {
            localIterator.remove();
          }
          for (;;)
          {
            bool = true;
            break;
            if (i <= 0) {
              break;
            }
            paramMultiset1.remove(localA.getElement(), i);
          }
        }
        return bool;
      }
      throw new NullPointerException();
    }
    paramMultiset1 = new NullPointerException();
    throw paramMultiset1;
  }
  
  public static boolean retainAllImpl(Multiset paramMultiset, Collection paramCollection)
  {
    if (paramCollection != null)
    {
      Object localObject = paramCollection;
      if ((paramCollection instanceof Multiset)) {
        localObject = ((Multiset)paramCollection).elementSet();
      }
      return paramMultiset.elementSet().retainAll((Collection)localObject);
    }
    throw new NullPointerException();
  }
  
  public static boolean retainOccurrences(Multiset paramMultiset1, Multiset paramMultiset2)
  {
    return retainOccurrencesImpl(paramMultiset1, paramMultiset2);
  }
  
  public static boolean retainOccurrencesImpl(Multiset paramMultiset1, Multiset paramMultiset2)
  {
    if (paramMultiset1 != null)
    {
      if (paramMultiset2 != null)
      {
        Iterator localIterator = paramMultiset1.entrySet().iterator();
        boolean bool = false;
        if (localIterator.hasNext())
        {
          Ye.a localA = (Ye.a)localIterator.next();
          int i = paramMultiset2.count(localA.getElement());
          if (i == 0) {
            localIterator.remove();
          }
          for (;;)
          {
            bool = true;
            break;
            if (i >= localA.getCount()) {
              break;
            }
            paramMultiset1.setCount(localA.getElement(), i);
          }
        }
        return bool;
      }
      throw new NullPointerException();
    }
    paramMultiset1 = new NullPointerException();
    throw paramMultiset1;
  }
  
  public static int setCountImpl(Multiset paramMultiset, Object paramObject, int paramInt)
  {
    checkNonnegative(paramInt, "count");
    int i = paramMultiset.count(paramObject);
    paramInt -= i;
    if (paramInt > 0)
    {
      paramMultiset.add(paramObject, paramInt);
      return i;
    }
    if (paramInt < 0) {
      paramMultiset.remove(paramObject, -paramInt);
    }
    return i;
  }
  
  public static boolean setCountImpl(Multiset paramMultiset, Object paramObject, int paramInt1, int paramInt2)
  {
    checkNonnegative(paramInt1, "oldCount");
    checkNonnegative(paramInt2, "newCount");
    if (paramMultiset.count(paramObject) == paramInt1)
    {
      paramMultiset.setCount(paramObject, paramInt2);
      return true;
    }
    return false;
  }
  
  public static int sizeImpl(Multiset paramMultiset)
  {
    paramMultiset = paramMultiset.entrySet().iterator();
    for (long l = 0L; paramMultiset.hasNext(); l += ((Ye.a)paramMultiset.next()).getCount()) {}
    return g.b(l);
  }
  
  public static Multiset union(Multiset paramMultiset1, Multiset paramMultiset2)
  {
    if (paramMultiset1 != null)
    {
      if (paramMultiset2 != null) {
        return new Multisets.1(paramMultiset1, paramMultiset2);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static Multiset unmodifiableMultiset(Multiset paramMultiset)
  {
    if (!(paramMultiset instanceof bf.g))
    {
      if ((paramMultiset instanceof ImmutableMultiset)) {
        return paramMultiset;
      }
      if (paramMultiset != null) {
        return new bf.g(paramMultiset);
      }
      throw new NullPointerException();
    }
    return paramMultiset;
  }
  
  public static SortedMultiset unmodifiableSortedMultiset(SortedMultiset paramSortedMultiset)
  {
    if (paramSortedMultiset != null) {
      return new bf.h(paramSortedMultiset, null);
    }
    throw new NullPointerException();
  }
}
