package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ag;
import f.g.c.d.gb;
import f.g.c.d.t;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

@b
public abstract class AbstractSortedMultiset<E>
  extends t<E>
  implements Ag<E>
{
  @gb
  public final Comparator<? super E> comparator;
  public transient Ag<E> descendingMultiset;
  
  public AbstractSortedMultiset()
  {
    this(Ordering.natural());
  }
  
  public AbstractSortedMultiset(Comparator paramComparator)
  {
    if (paramComparator != null)
    {
      comparator = paramComparator;
      return;
    }
    throw new NullPointerException();
  }
  
  public Comparator comparator()
  {
    return comparator;
  }
  
  public SortedMultiset createDescendingMultiset()
  {
    return new AbstractSortedMultiset.1(this);
  }
  
  public SortedSet createElementSet()
  {
    return new ConcurrentHashMultiset.EntrySet(this);
  }
  
  public abstract Iterator descendingEntryIterator();
  
  public Iterator descendingIterator()
  {
    return Multisets.iteratorImpl(descendingMultiset());
  }
  
  public SortedMultiset descendingMultiset()
  {
    SortedMultiset localSortedMultiset2 = descendingMultiset;
    SortedMultiset localSortedMultiset1 = localSortedMultiset2;
    if (localSortedMultiset2 == null)
    {
      localSortedMultiset1 = createDescendingMultiset();
      descendingMultiset = localSortedMultiset1;
    }
    return localSortedMultiset1;
  }
  
  public SortedSet elementSet()
  {
    return (SortedSet)super.elementSet();
  }
  
  public Ye.a firstEntry()
  {
    Iterator localIterator = entryIterator();
    if (localIterator.hasNext()) {
      return (Ye.a)localIterator.next();
    }
    return null;
  }
  
  public Ye.a lastEntry()
  {
    Iterator localIterator = descendingEntryIterator();
    if (localIterator.hasNext()) {
      return (Ye.a)localIterator.next();
    }
    return null;
  }
  
  public Ye.a pollFirstEntry()
  {
    Iterator localIterator = entryIterator();
    if (localIterator.hasNext())
    {
      Ye.a localA = (Ye.a)localIterator.next();
      localA = Multisets.immutableEntry(localA.getElement(), localA.getCount());
      localIterator.remove();
      return localA;
    }
    return null;
  }
  
  public Ye.a pollLastEntry()
  {
    Iterator localIterator = descendingEntryIterator();
    if (localIterator.hasNext())
    {
      Ye.a localA = (Ye.a)localIterator.next();
      localA = Multisets.immutableEntry(localA.getElement(), localA.getCount());
      localIterator.remove();
      return localA;
    }
    return null;
  }
  
  public SortedMultiset subMultiset(Object paramObject1, BoundType paramBoundType1, Object paramObject2, BoundType paramBoundType2)
  {
    if (paramBoundType1 != null)
    {
      if (paramBoundType2 != null) {
        return tailMultiset(paramObject1, paramBoundType1).headMultiset(paramObject2, paramBoundType2);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
}
