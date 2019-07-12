package f.g.c.package_8;

import f.g.c.a.a;
import f.g.c.a.d;
import f.g.c.d.ue;
import f.g.c.navigation.IntMath;
import f.g.c.package_10.Preconditions;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

@a
public final class MinMaxPriorityQueue<E>
  extends AbstractQueue<E>
{
  public static final int DEFAULT_CAPACITY = 11;
  public static final int EVEN_POWERS_OF_TWO = 1431655765;
  public static final int ODD_POWERS_OF_TWO = -1431655766;
  public final ue<E>.b maxHeap;
  @d
  public final int maximumSize;
  public final ue<E>.b minHeap;
  public int modCount;
  public Object[] queue;
  public int size;
  
  public MinMaxPriorityQueue(ue.a paramA, int paramInt)
  {
    Object localObject = ue.a.access$getOrdering(paramA);
    minHeap = new ue.b(this, (Ordering)localObject);
    maxHeap = new ue.b(this, ((Ordering)localObject).reverse());
    localObject = minHeap;
    ue.b localB = maxHeap;
    otherHeap = localB;
    otherHeap = ((ue.b)localObject);
    maximumSize = maximumSize;
    queue = new Object[paramInt];
  }
  
  private ue.c add(int paramInt, Object paramObject)
  {
    ue.b localB = heapForIndex(paramInt);
    int i = localB.d(paramInt);
    int j = localB.a(i, paramObject);
    if (j == i) {
      return localB.a(paramInt, i, paramObject);
    }
    if (j < paramInt) {
      return new ue.c(paramObject, get(paramInt));
    }
    return null;
  }
  
  private int calculateNewCapacity()
  {
    int i = queue.length;
    if (i < 64) {
      i = (i + 1) * 2;
    } else {
      i = IntMath.checkedMultiply(i / 2, 3);
    }
    return capAtMaximumSize(i, maximumSize);
  }
  
  public static int capAtMaximumSize(int paramInt1, int paramInt2)
  {
    return Math.min(paramInt1 - 1, paramInt2) + 1;
  }
  
  public static ue.a compare(int paramInt)
  {
    return new ue.a(Ordering.natural()).compare(paramInt);
  }
  
  public static MinMaxPriorityQueue create()
  {
    return new ue.a(Ordering.natural()).create();
  }
  
  public static MinMaxPriorityQueue create(Iterable paramIterable)
  {
    return new ue.a(Ordering.natural()).create(paramIterable);
  }
  
  public static ue.a expectedSize(int paramInt)
  {
    return new ue.a(Ordering.natural()).expectedSize(paramInt);
  }
  
  private int getMaxElementIndex()
  {
    int i = size;
    if (i != 1)
    {
      if (i != 2)
      {
        if (maxHeap.add(1, 2) <= 0) {
          return 1;
        }
        return 2;
      }
    }
    else {
      return 0;
    }
    return 1;
  }
  
  private void growIfNeeded()
  {
    if (size > queue.length)
    {
      Object[] arrayOfObject1 = new Object[calculateNewCapacity()];
      Object[] arrayOfObject2 = queue;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, arrayOfObject2.length);
      queue = arrayOfObject1;
    }
  }
  
  private ue.b heapForIndex(int paramInt)
  {
    if (isEvenLevel(paramInt)) {
      return minHeap;
    }
    return maxHeap;
  }
  
  public static int initialQueueSize(int paramInt1, int paramInt2, Iterable paramIterable)
  {
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = 11;
    }
    paramInt1 = i;
    if ((paramIterable instanceof Collection)) {
      paramInt1 = Math.max(i, ((Collection)paramIterable).size());
    }
    return capAtMaximumSize(paramInt1, paramInt2);
  }
  
  public static boolean isEvenLevel(int paramInt)
  {
    paramInt += 1;
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "negative index");
    return (0x55555555 & paramInt) > (paramInt & 0xAAAAAAAA);
  }
  
  public static ue.a orderedBy(Comparator paramComparator)
  {
    return new ue.a(paramComparator);
  }
  
  private Object removeAndGet(int paramInt)
  {
    Object localObject = get(paramInt);
    removeAt(paramInt);
    return localObject;
  }
  
  public boolean add(Object paramObject)
  {
    offer(paramObject);
    return true;
  }
  
  public boolean addAll(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    for (boolean bool = false; paramCollection.hasNext(); bool = true) {
      offer(paramCollection.next());
    }
    return bool;
  }
  
  public int capacity()
  {
    return queue.length;
  }
  
  public void clear()
  {
    int i = 0;
    while (i < size)
    {
      queue[i] = null;
      i += 1;
    }
    size = 0;
  }
  
  public Comparator comparator()
  {
    return minHeap.m;
  }
  
  public Object get(int paramInt)
  {
    return queue[paramInt];
  }
  
  public boolean isIntact()
  {
    int i = 1;
    while (i < size)
    {
      if (!ue.b.access$getVerifyIndex(heapForIndex(i), i)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Iterator iterator()
  {
    return new ue.d(this);
  }
  
  public boolean offer(Object paramObject)
  {
    if (paramObject != null)
    {
      modCount += 1;
      int i = size;
      size = (i + 1);
      growIfNeeded();
      heapForIndex(i).bubbleUp(i, paramObject);
      if (size > maximumSize) {
        return pollLast() != paramObject;
      }
    }
    else
    {
      throw new NullPointerException();
    }
    return true;
  }
  
  public Object peek()
  {
    if (isEmpty()) {
      return null;
    }
    return get(0);
  }
  
  public Object peekFirst()
  {
    return peek();
  }
  
  public Object peekLast()
  {
    if (isEmpty()) {
      return null;
    }
    return get(getMaxElementIndex());
  }
  
  public Object poll()
  {
    if (isEmpty()) {
      return null;
    }
    return removeAndGet(0);
  }
  
  public Object pollFirst()
  {
    return poll();
  }
  
  public Object pollLast()
  {
    if (isEmpty()) {
      return null;
    }
    return removeAndGet(getMaxElementIndex());
  }
  
  public ue.c removeAt(int paramInt)
  {
    Preconditions.checkPositionIndex(paramInt, size, "index");
    modCount += 1;
    size -= 1;
    int i = size;
    if (i == paramInt)
    {
      queue[i] = null;
      return null;
    }
    Object localObject1 = get(i);
    i = heapForIndex(size).add(localObject1);
    Object localObject2 = get(size);
    queue[size] = null;
    ue.c localC = add(paramInt, localObject2);
    if (i < paramInt)
    {
      if (localC == null) {
        return new ue.c(localObject1, localObject2);
      }
      return new ue.c(localObject1, replaced);
    }
    return localC;
  }
  
  public Object removeFirst()
  {
    return remove();
  }
  
  public Object removeLast()
  {
    if (!isEmpty()) {
      return removeAndGet(getMaxElementIndex());
    }
    throw new NoSuchElementException();
  }
  
  public int size()
  {
    return size;
  }
  
  public Object[] toArray()
  {
    int i = size;
    Object[] arrayOfObject = new Object[i];
    System.arraycopy(queue, 0, arrayOfObject, 0, i);
    return arrayOfObject;
  }
}
