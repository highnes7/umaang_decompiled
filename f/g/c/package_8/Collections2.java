package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.b.ca;
import f.g.c.d.g;
import f.g.c.d.vb;
import f.g.c.navigation.IntMath;
import f.g.c.navigation.LongMath;
import f.g.c.package_10.Function;
import f.g.c.package_10.Joiner;
import f.g.c.package_10.Preconditions;
import f.g.c.package_10.Predicate;
import f.g.c.package_10.Predicates;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@b
public final class Collections2
{
  public static final Joiner STANDARD_JOINER = new Joiner(", ").useForNull("null");
  
  public Collections2() {}
  
  public static StringBuilder append(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "size must be non-negative");
    return new StringBuilder((int)Math.min(paramInt * 8L, 1073741824L));
  }
  
  public static Collection cast(Iterable paramIterable)
  {
    return (Collection)paramIterable;
  }
  
  public static boolean containsAllImpl(Collection paramCollection1, Collection paramCollection2)
  {
    if (paramCollection1 != null)
    {
      paramCollection2 = paramCollection2.iterator();
      while (paramCollection2.hasNext()) {
        if (!paramCollection1.contains(paramCollection2.next())) {
          return false;
        }
      }
      return true;
    }
    paramCollection1 = new NullPointerException();
    throw paramCollection1;
  }
  
  public static Collection filter(Collection paramCollection, Predicate paramPredicate)
  {
    if ((paramCollection instanceof FilteredCollection)) {
      return ((FilteredCollection)paramCollection).createCombined(paramPredicate);
    }
    if (paramCollection != null)
    {
      if (paramPredicate != null) {
        return new FilteredCollection(paramPredicate);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static boolean get(long paramLong)
  {
    return (paramLong >= 0L) && (paramLong <= 2147483647L);
  }
  
  public static boolean isPermutation(List paramList1, List paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    return HashMultiset.create(paramList1).equals(HashMultiset.create(paramList2));
  }
  
  public static Collection orderedPermutations(Iterable paramIterable)
  {
    return new OrderedPermutationCollection(Ordering.natural());
  }
  
  public static Collection orderedPermutations(Iterable paramIterable, Comparator paramComparator)
  {
    return new OrderedPermutationCollection(paramComparator);
  }
  
  public static Collection permutations(Collection paramCollection)
  {
    return new PermutationCollection(ImmutableList.copyOf(paramCollection));
  }
  
  public static boolean safeContains(Collection paramCollection, Object paramObject)
  {
    try
    {
      boolean bool = paramCollection.contains(paramObject);
      return bool;
    }
    catch (ClassCastException paramCollection)
    {
      for (;;) {}
    }
    return false;
  }
  
  public static String toStringImpl(Collection paramCollection)
  {
    StringBuilder localStringBuilder = append(paramCollection.size());
    localStringBuilder.append('[');
    STANDARD_JOINER.appendTo(localStringBuilder, new PhoneNumberUtil.2(paramCollection, new Collections2.1(paramCollection)));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static Collection transform(Collection paramCollection, Function paramFunction)
  {
    return new Stack(paramCollection, paramFunction);
  }
  
  public class FilteredCollection<E>
    implements Collection<E>
  {
    public final ca<? super E> predicate;
    
    public FilteredCollection(Predicate paramPredicate)
    {
      predicate = paramPredicate;
    }
    
    public boolean add(Object paramObject)
    {
      Preconditions.checkArgument(predicate.apply(paramObject));
      return Collections2.this.add(paramObject);
    }
    
    public boolean addAll(Collection paramCollection)
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        Preconditions.checkArgument(predicate.apply(localObject));
      }
      return Collections2.this.addAll(paramCollection);
    }
    
    public void clear()
    {
      Iterables.removeIf(Collections2.this, predicate);
    }
    
    public boolean contains(Object paramObject)
    {
      try
      {
        boolean bool = predicate.apply(paramObject);
        if (bool)
        {
          bool = Collections2.this.contains(paramObject);
          if (bool) {
            return true;
          }
        }
      }
      catch (NullPointerException paramObject)
      {
        return false;
      }
      catch (ClassCastException paramObject) {}
      return false;
    }
    
    public boolean containsAll(Collection paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public FilteredCollection createCombined(Predicate paramPredicate)
    {
      return new FilteredCollection(Collections2.this, Predicates.and(predicate, paramPredicate));
    }
    
    public boolean isEmpty()
    {
      return Iterators.exists(Collections2.this.iterator(), predicate) ^ true;
    }
    
    public Iterator iterator()
    {
      return Iterators.filter(Collections2.this.iterator(), predicate);
    }
    
    public boolean remove(Object paramObject)
    {
      try
      {
        boolean bool = predicate.apply(paramObject);
        if (bool)
        {
          bool = Collections2.this.remove(paramObject);
          if (bool) {
            return true;
          }
        }
      }
      catch (NullPointerException paramObject)
      {
        return false;
      }
      catch (ClassCastException paramObject) {}
      return false;
    }
    
    public boolean removeAll(Collection paramCollection)
    {
      if (paramCollection != null)
      {
        paramCollection = new Collections2.FilteredCollection.1(this, paramCollection);
        return Iterables.removeIf(Collections2.this, paramCollection);
      }
      throw new NullPointerException();
    }
    
    public boolean retainAll(Collection paramCollection)
    {
      if (paramCollection != null)
      {
        paramCollection = new Collections2.FilteredCollection.2(this, paramCollection);
        return Iterables.removeIf(Collections2.this, paramCollection);
      }
      throw new NullPointerException();
    }
    
    public int size()
    {
      return Iterators.size(iterator());
    }
    
    public Object[] toArray()
    {
      return Lists.newArrayList(iterator()).toArray();
    }
    
    public Object[] toArray(Object[] paramArrayOfObject)
    {
      return Lists.newArrayList(iterator()).toArray(paramArrayOfObject);
    }
    
    public String toString()
    {
      return Iterators.toString(iterator());
    }
  }
  
  public final class OrderedPermutationCollection<E>
    extends AbstractCollection<List<E>>
  {
    public final Comparator<? super E> comparator;
    public final vb<E> inputList;
    public final int size;
    
    public OrderedPermutationCollection(Comparator paramComparator)
    {
      inputList = Ordering.from(paramComparator).immutableSortedCopy(this$1);
      comparator = paramComparator;
      size = calculateSize(inputList, paramComparator);
    }
    
    public static int calculateSize(List paramList, Comparator paramComparator)
    {
      long l2 = 1L;
      int j = 1;
      int i = 1;
      while (j < paramList.size())
      {
        l1 = l2;
        int k = i;
        if (paramComparator.compare(paramList.get(j - 1), paramList.get(j)) < 0)
        {
          l2 = LongMath.binomial(j, i) * l2;
          k = 0;
          l1 = l2;
          if (!Collections2.get(l2)) {
            return Integer.MAX_VALUE;
          }
        }
        j += 1;
        i = k + 1;
        l2 = l1;
      }
      long l1 = LongMath.binomial(j, i) * l2;
      if (!Collections2.get(l1)) {
        return Integer.MAX_VALUE;
      }
      return (int)l1;
    }
    
    public boolean contains(Object paramObject)
    {
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        return Collections2.isPermutation(inputList, paramObject);
      }
      return false;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public Iterator iterator()
    {
      return new Collections2.OrderedPermutationIterator(inputList, comparator);
    }
    
    public int size()
    {
      return size;
    }
    
    public String toString()
    {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("orderedPermutationCollection("), inputList, ")");
    }
  }
  
  public final class OrderedPermutationIterator<E>
    extends g<List<E>>
  {
    public final Comparator<? super E> comparator;
    public List<E> nextPermutation;
    
    public OrderedPermutationIterator(Comparator paramComparator)
    {
      nextPermutation = Lists.newArrayList(this$1);
      comparator = paramComparator;
    }
    
    public void calculateNextPermutation()
    {
      int i = findNextJ();
      if (i == -1)
      {
        nextPermutation = null;
        return;
      }
      int j = findNextL(i);
      Collections.swap(nextPermutation, i, j);
      j = nextPermutation.size();
      Collections.reverse(nextPermutation.subList(i + 1, j));
    }
    
    public List computeNext()
    {
      Object localObject = nextPermutation;
      if (localObject == null) {
        return (List)endOfData();
      }
      localObject = ImmutableList.copyOf((Collection)localObject);
      calculateNextPermutation();
      return localObject;
    }
    
    public int findNextJ()
    {
      int i = nextPermutation.size() - 2;
      while (i >= 0)
      {
        if (comparator.compare(nextPermutation.get(i), nextPermutation.get(i + 1)) < 0) {
          return i;
        }
        i -= 1;
      }
      return -1;
    }
    
    public int findNextL(int paramInt)
    {
      Object localObject = nextPermutation.get(paramInt);
      int i = nextPermutation.size() - 1;
      while (i > paramInt)
      {
        if (comparator.compare(localObject, nextPermutation.get(i)) < 0) {
          return i;
        }
        i -= 1;
      }
      localObject = new AssertionError("this statement should be unreachable");
      throw ((Throwable)localObject);
    }
  }
  
  public final class PermutationCollection<E>
    extends AbstractCollection<List<E>>
  {
    public PermutationCollection() {}
    
    public boolean contains(Object paramObject)
    {
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        return Collections2.isPermutation(Collections2.this, paramObject);
      }
      return false;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public Iterator iterator()
    {
      return new MethodWriter(Collections2.this);
    }
    
    public int size()
    {
      return IntMath.factorial(Collections2.this.size());
    }
    
    public String toString()
    {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("permutations("), Collections2.this, ")");
    }
  }
}
