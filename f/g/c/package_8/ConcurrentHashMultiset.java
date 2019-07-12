package f.g.c.package_8;

import f.g.c.d.fa;
import f.g.c.d.t;
import f.g.c.j.g;
import f.g.c.navigation.IntMath;
import f.g.c.package_10.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class ConcurrentHashMultiset<E>
  extends t<E>
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  public final transient ConcurrentMap<E, AtomicInteger> countMap;
  public transient fa<E>.a entrySet;
  
  public ConcurrentHashMultiset(ConcurrentMap paramConcurrentMap)
  {
    Preconditions.checkArgument(paramConcurrentMap.isEmpty());
    countMap = paramConcurrentMap;
  }
  
  public static ConcurrentHashMultiset create()
  {
    return new ConcurrentHashMultiset(new ConcurrentHashMap());
  }
  
  public static ConcurrentHashMultiset create(GenericMapMaker paramGenericMapMaker)
  {
    return new ConcurrentHashMultiset(paramGenericMapMaker.makeMap());
  }
  
  public static ConcurrentHashMultiset create(Iterable paramIterable)
  {
    ConcurrentHashMultiset localConcurrentHashMultiset = create();
    Iterables.addAll(localConcurrentHashMultiset, paramIterable);
    return localConcurrentHashMultiset;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    paramObjectInputStream = (ConcurrentMap)paramObjectInputStream.readObject();
    fa.b.MAP_FIELD_SETTER.set(this, paramObjectInputStream);
  }
  
  private AtomicInteger safeGet(Object paramObject)
  {
    try
    {
      ConcurrentMap localConcurrentMap = countMap;
      return null;
    }
    catch (NullPointerException paramObject)
    {
      try
      {
        paramObject = localConcurrentMap.get(paramObject);
        paramObject = (AtomicInteger)paramObject;
        return paramObject;
      }
      catch (ClassCastException paramObject) {}
      paramObject = paramObject;
      return null;
    }
  }
  
  private List snapshot()
  {
    ArrayList localArrayList = Lists.newArrayListWithExpectedSize(size());
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Ye.a localA = (Ye.a)localIterator.next();
      Object localObject = localA.getElement();
      int i = localA.getCount();
      while (i > 0)
      {
        localArrayList.add(localObject);
        i -= 1;
      }
    }
    return localArrayList;
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(countMap);
  }
  
  public int add(Object paramObject, int paramInt)
  {
    if (paramObject != null)
    {
      if (paramInt == 0) {
        return count(paramObject);
      }
      boolean bool;
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid occurrences: %s", new Object[] { Integer.valueOf(paramInt) });
      AtomicInteger localAtomicInteger2;
      AtomicInteger localAtomicInteger1;
      label171:
      do
      {
        localAtomicInteger2 = safeGet(paramObject);
        localAtomicInteger1 = localAtomicInteger2;
        if (localAtomicInteger2 == null)
        {
          localAtomicInteger2 = (AtomicInteger)countMap.putIfAbsent(paramObject, new AtomicInteger(paramInt));
          localAtomicInteger1 = localAtomicInteger2;
          if (localAtomicInteger2 == null) {
            return 0;
          }
        }
        for (;;)
        {
          int i = localAtomicInteger1.get();
          if (i == 0) {
            break label171;
          }
          try
          {
            bool = localAtomicInteger1.compareAndSet(i, IntMath.checkedAdd(i, paramInt));
            if (bool) {
              return i;
            }
          }
          catch (ArithmeticException paramObject)
          {
            for (;;) {}
          }
        }
        paramObject = new StringBuilder();
        paramObject.append("Overflow adding ");
        paramObject.append(paramInt);
        paramObject.append(" occurrences to a count of ");
        paramObject.append(i);
        throw new IllegalArgumentException(paramObject.toString());
        localAtomicInteger2 = new AtomicInteger(paramInt);
        if (countMap.putIfAbsent(paramObject, localAtomicInteger2) == null) {
          break;
        }
      } while (!countMap.replace(paramObject, localAtomicInteger1, localAtomicInteger2));
      return 0;
    }
    paramObject = new NullPointerException();
    throw paramObject;
    return 0;
  }
  
  public boolean add(Object paramObject)
  {
    add(paramObject, 1);
    return true;
  }
  
  public boolean addAll(Collection paramCollection)
  {
    return Multisets.addAllImpl(this, paramCollection);
  }
  
  public void clear()
  {
    countMap.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return count(paramObject) > 0;
  }
  
  public int count(Object paramObject)
  {
    paramObject = safeGet(paramObject);
    if (paramObject == null) {
      return 0;
    }
    return paramObject.get();
  }
  
  public Set createElementSet()
  {
    return new ConcurrentHashMultiset.1(this, countMap.keySet());
  }
  
  public int distinctElements()
  {
    return countMap.size();
  }
  
  public Iterator entryIterator()
  {
    return new ConcurrentHashMultiset.3(this, new ConcurrentHashMultiset.2(this));
  }
  
  public Set entrySet()
  {
    fa.a localA2 = entrySet;
    fa.a localA1 = localA2;
    if (localA2 == null)
    {
      localA1 = new fa.a(this, null);
      entrySet = localA1;
    }
    return localA1;
  }
  
  public boolean equals(Object paramObject)
  {
    return Multisets.equalsImpl(this, paramObject);
  }
  
  public boolean isEmpty()
  {
    return countMap.isEmpty();
  }
  
  public Iterator iterator()
  {
    return Multisets.iteratorImpl(this);
  }
  
  public int remove(Object paramObject, int paramInt)
  {
    if (paramInt == 0) {
      return count(paramObject);
    }
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Invalid occurrences: %s", new Object[] { Integer.valueOf(paramInt) });
    AtomicInteger localAtomicInteger = safeGet(paramObject);
    if (localAtomicInteger == null) {
      return 0;
    }
    int i;
    int j;
    do
    {
      i = localAtomicInteger.get();
      if (i == 0) {
        break;
      }
      j = Math.max(0, i - paramInt);
    } while (!localAtomicInteger.compareAndSet(i, j));
    if (j == 0)
    {
      countMap.remove(paramObject, localAtomicInteger);
      return i;
      return 0;
    }
    return i;
  }
  
  public boolean remove(Object paramObject)
  {
    return remove(paramObject, 1) > 0;
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    return Multisets.removeAllImpl(this, paramCollection);
  }
  
  public boolean removeExactly(Object paramObject, int paramInt)
  {
    if (paramInt == 0) {
      return true;
    }
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Invalid occurrences: %s", new Object[] { Integer.valueOf(paramInt) });
    AtomicInteger localAtomicInteger = safeGet(paramObject);
    if (localAtomicInteger == null) {
      return false;
    }
    int i;
    int j;
    do
    {
      i = localAtomicInteger.get();
      if (i < paramInt) {
        return false;
      }
      j = i - paramInt;
    } while (!localAtomicInteger.compareAndSet(i, j));
    if (j == 0) {
      countMap.remove(paramObject, localAtomicInteger);
    }
    return true;
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    return Multisets.retainAllImpl(this, paramCollection);
  }
  
  public int setCount(Object paramObject, int paramInt)
  {
    int i;
    if (paramObject != null)
    {
      Multisets.checkNonnegative(paramInt, "count");
      AtomicInteger localAtomicInteger2 = safeGet(paramObject);
      AtomicInteger localAtomicInteger1 = localAtomicInteger2;
      if (localAtomicInteger2 == null)
      {
        if (paramInt == 0) {
          return 0;
        }
        localAtomicInteger2 = (AtomicInteger)countMap.putIfAbsent(paramObject, new AtomicInteger(paramInt));
        localAtomicInteger1 = localAtomicInteger2;
        if (localAtomicInteger2 == null) {
          return 0;
        }
      }
      do
      {
        i = localAtomicInteger1.get();
        if (i == 0)
        {
          if (paramInt == 0) {
            return 0;
          }
          localAtomicInteger2 = new AtomicInteger(paramInt);
          if (countMap.putIfAbsent(paramObject, localAtomicInteger2) == null) {
            break label169;
          }
          if (!countMap.replace(paramObject, localAtomicInteger1, localAtomicInteger2)) {
            break;
          }
          return 0;
        }
      } while (!localAtomicInteger1.compareAndSet(i, paramInt));
      if (paramInt == 0)
      {
        countMap.remove(paramObject, localAtomicInteger1);
        return i;
      }
    }
    else
    {
      paramObject = new NullPointerException();
      throw paramObject;
      label169:
      return 0;
    }
    return i;
  }
  
  public boolean setCount(Object paramObject, int paramInt1, int paramInt2)
  {
    if (paramObject != null)
    {
      Multisets.checkNonnegative(paramInt1, "oldCount");
      Multisets.checkNonnegative(paramInt2, "newCount");
      AtomicInteger localAtomicInteger1 = safeGet(paramObject);
      if (localAtomicInteger1 == null)
      {
        if (paramInt1 != 0) {
          return false;
        }
        if (paramInt2 == 0) {
          return true;
        }
        if (countMap.putIfAbsent(paramObject, new AtomicInteger(paramInt2)) == null) {
          return true;
        }
      }
      else
      {
        int i = localAtomicInteger1.get();
        if (i == paramInt1)
        {
          if (i == 0)
          {
            if (paramInt2 == 0)
            {
              countMap.remove(paramObject, localAtomicInteger1);
              return true;
            }
            AtomicInteger localAtomicInteger2 = new AtomicInteger(paramInt2);
            if ((countMap.putIfAbsent(paramObject, localAtomicInteger2) == null) || (countMap.replace(paramObject, localAtomicInteger1, localAtomicInteger2))) {
              return true;
            }
          }
          else if (localAtomicInteger1.compareAndSet(i, paramInt2))
          {
            if (paramInt2 != 0) {
              break label188;
            }
            countMap.remove(paramObject, localAtomicInteger1);
            return true;
          }
        }
        else {
          return false;
        }
      }
    }
    else
    {
      throw new NullPointerException();
    }
    return false;
    label188:
    return true;
  }
  
  public int size()
  {
    Iterator localIterator = countMap.values().iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((AtomicInteger)localIterator.next()).get()) {}
    return g.b(l);
  }
  
  public Object[] toArray()
  {
    return snapshot().toArray();
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    return snapshot().toArray(paramArrayOfObject);
  }
}
