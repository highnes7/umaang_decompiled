package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Wb;
import f.g.c.d.vb;
import f.g.c.package_10.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@b(emulated=true, serializable=true)
public final class RegularImmutableSortedSet<E>
  extends Wb<E>
{
  public final transient vb<E> elements;
  
  public RegularImmutableSortedSet(ImmutableList paramImmutableList, Comparator paramComparator)
  {
    super(paramComparator);
    elements = paramImmutableList;
    boolean bool;
    if (!paramImmutableList.isEmpty()) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
  }
  
  private int unsafeBinarySearch(Object paramObject)
    throws ClassCastException
  {
    return Collections.binarySearch(elements, paramObject, unsafeComparator());
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ImmutableList localImmutableList = elements;
    try
    {
      int i = Collections.binarySearch(localImmutableList, paramObject, unsafeComparator());
      if (i >= 0) {
        return true;
      }
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    UnmodifiableIterator localUnmodifiableIterator;
    Iterator localIterator;
    if ((SortedIterables.hasSameComparator(comparator(), paramCollection)) && (paramCollection.size() > 1))
    {
      localUnmodifiableIterator = iterator();
      localIterator = paramCollection.iterator();
      paramCollection = localIterator.next();
    }
    try
    {
      int i;
      do
      {
        for (;;)
        {
          boolean bool = localUnmodifiableIterator.hasNext();
          if (!bool) {
            break label116;
          }
          i = unsafeCompare(localUnmodifiableIterator.next(), paramCollection);
          if (i != 0) {
            break;
          }
          bool = localIterator.hasNext();
          if (!bool) {
            return true;
          }
          paramCollection = localIterator.next();
        }
      } while (i <= 0);
      return false;
    }
    catch (NullPointerException paramCollection)
    {
      return false;
    }
    catch (ClassCastException paramCollection) {}
    return Collections2.containsAllImpl(this, paramCollection);
    label116:
    return false;
  }
  
  public ImmutableList createAsList()
  {
    return new ImmutableSortedAsList(this, elements);
  }
  
  public ImmutableSortedSet createDescendingSet()
  {
    return new RegularImmutableSortedSet(elements.reverse(), Ordering.from(comparator).reverse());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Set)) {
      return false;
    }
    paramObject = (Set)paramObject;
    if (size() != paramObject.size()) {
      return false;
    }
    if (SortedIterables.hasSameComparator(comparator, paramObject)) {
      paramObject = paramObject.iterator();
    }
    try
    {
      UnmodifiableIterator localUnmodifiableIterator = iterator();
      int i;
      do
      {
        boolean bool = localUnmodifiableIterator.hasNext();
        if (!bool) {
          break;
        }
        Object localObject1 = localUnmodifiableIterator.next();
        Object localObject2 = paramObject.next();
        if (localObject2 == null) {
          break label121;
        }
        i = unsafeCompare(localObject1, localObject2);
      } while (i == 0);
      return false;
      return true;
    }
    catch (ClassCastException paramObject)
    {
      return false;
    }
    catch (NoSuchElementException paramObject) {}
    return containsAll(paramObject);
    label121:
    return false;
  }
  
  public Object first()
  {
    return elements.get(0);
  }
  
  public ImmutableSortedSet getSubSet(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == size())) {
      return this;
    }
    if (paramInt1 < paramInt2) {
      return new RegularImmutableSortedSet(elements.subList(paramInt1, paramInt2), comparator);
    }
    return ImmutableSortedSet.emptySet(comparator);
  }
  
  public int headIndex(Object paramObject, boolean paramBoolean)
  {
    ImmutableList localImmutableList = elements;
    if (paramObject != null)
    {
      Comparator localComparator = comparator();
      tg.b localB;
      if (paramBoolean) {
        localB = tg.b.s;
      } else {
        localB = tg.b.l;
      }
      return SortedLists.binarySearch(localImmutableList, paramObject, localComparator, localB, tg.a.b);
    }
    throw new NullPointerException();
  }
  
  public ImmutableSortedSet headSetImpl(Object paramObject, boolean paramBoolean)
  {
    return getSubSet(0, headIndex(paramObject, paramBoolean));
  }
  
  public int indexOf(Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    ImmutableList localImmutableList = elements;
    try
    {
      Comparator localComparator = unsafeComparator();
      tg.b localB = tg.b.E;
      tg.a localA = tg.a.N;
      int i = SortedLists.binarySearch(localImmutableList, paramObject, localComparator, localB, localA);
      if (i >= 0) {
        return i;
      }
      return -1;
    }
    catch (ClassCastException paramObject) {}
    return -1;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isPartialView()
  {
    return elements.isPartialView();
  }
  
  public UnmodifiableIterator iterator()
  {
    return elements.iterator();
  }
  
  public Object last()
  {
    return elements.get(size() - 1);
  }
  
  public int size()
  {
    return elements.size();
  }
  
  public ImmutableSortedSet subSetImpl(Object paramObject1, boolean paramBoolean1, Object paramObject2, boolean paramBoolean2)
  {
    return tailSetImpl(paramObject1, paramBoolean1).headSetImpl(paramObject2, paramBoolean2);
  }
  
  public int tailIndex(Object paramObject, boolean paramBoolean)
  {
    ImmutableList localImmutableList = elements;
    if (paramObject != null)
    {
      Comparator localComparator = comparator();
      tg.b localB;
      if (paramBoolean) {
        localB = tg.b.l;
      } else {
        localB = tg.b.s;
      }
      return SortedLists.binarySearch(localImmutableList, paramObject, localComparator, localB, tg.a.b);
    }
    throw new NullPointerException();
  }
  
  public ImmutableSortedSet tailSetImpl(Object paramObject, boolean paramBoolean)
  {
    return getSubSet(tailIndex(paramObject, paramBoolean), size());
  }
  
  public Object[] toArray()
  {
    return elements.toArray();
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    return elements.toArray(paramArrayOfObject);
  }
  
  public Comparator unsafeComparator()
  {
    return comparator;
  }
}
