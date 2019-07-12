package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.ja;
import f.g.c.d.t;
import f.g.c.j.g;
import f.g.c.package_10.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@b(emulated=true)
public abstract class AbstractMapBasedMultiset<E>
  extends t<E>
  implements Serializable
{
  @c("not needed in emulated source.")
  public static final long serialVersionUID = -2250766705698539974L;
  public transient Map<E, ja> backingMap;
  public transient long size;
  
  public AbstractMapBasedMultiset(Map paramMap)
  {
    if (paramMap != null)
    {
      backingMap = paramMap;
      size = Multisets.sizeImpl(this);
      return;
    }
    throw new NullPointerException();
  }
  
  public static int getAndSet(Count paramCount, int paramInt)
  {
    if (paramCount == null) {
      return 0;
    }
    return paramCount.getAndSet(paramInt);
  }
  
  private void readObjectNoData()
    throws ObjectStreamException
  {
    throw new InvalidObjectException("Stream data required");
  }
  
  public int add(Object paramObject, int paramInt)
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
    Preconditions.checkArgument(bool, "occurrences cannot be negative: %s", new Object[] { Integer.valueOf(paramInt) });
    Count localCount = (Count)backingMap.get(paramObject);
    int i;
    if (localCount == null)
    {
      backingMap.put(paramObject, new Count(paramInt));
      i = 0;
    }
    else
    {
      int j = localCount.get();
      i = j;
      long l = j + paramInt;
      if (l <= 2147483647L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "too many occurrences: %s", new Object[] { Long.valueOf(l) });
      localCount.getAndAdd(paramInt);
    }
    size += paramInt;
    return i;
  }
  
  public Map backingMap()
  {
    return backingMap;
  }
  
  public void clear()
  {
    Iterator localIterator = backingMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Count)localIterator.next()).set(0);
    }
    backingMap.clear();
    size = 0L;
  }
  
  public int count(Object paramObject)
  {
    try
    {
      Map localMap = backingMap;
      int i;
      return 0;
    }
    catch (NullPointerException paramObject)
    {
      try
      {
        paramObject = localMap.get(paramObject);
        paramObject = (Count)paramObject;
        if (paramObject == null) {
          return 0;
        }
        i = paramObject.get();
        return i;
      }
      catch (ClassCastException paramObject) {}
      paramObject = paramObject;
      return 0;
    }
  }
  
  public Set createElementSet()
  {
    return new FilteredEntryMultimap.Keys.1(this);
  }
  
  public int distinctElements()
  {
    return backingMap.size();
  }
  
  public Iterator entryIterator()
  {
    return new AbstractMapBasedMultiset.1(this, backingMap.entrySet().iterator());
  }
  
  public Set entrySet()
  {
    return super.entrySet();
  }
  
  public Iterator iterator()
  {
    return new LinkedListMultimap.ValueForKeyIterator(this);
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
    Preconditions.checkArgument(bool, "occurrences cannot be negative: %s", new Object[] { Integer.valueOf(paramInt) });
    Count localCount = (Count)backingMap.get(paramObject);
    if (localCount == null) {
      return 0;
    }
    int i = localCount.get();
    if (i <= paramInt)
    {
      backingMap.remove(paramObject);
      paramInt = i;
    }
    localCount.addAndGet(-paramInt);
    size -= paramInt;
    return i;
  }
  
  public void setBackingMap(Map paramMap)
  {
    backingMap = paramMap;
  }
  
  public int setCount(Object paramObject, int paramInt)
  {
    Multisets.checkNonnegative(paramInt, "count");
    int i;
    if (paramInt == 0)
    {
      i = getAndSet((Count)backingMap.remove(paramObject), paramInt);
    }
    else
    {
      Count localCount = (Count)backingMap.get(paramObject);
      int j = getAndSet(localCount, paramInt);
      i = j;
      if (localCount == null)
      {
        backingMap.put(paramObject, new Count(paramInt));
        i = j;
      }
    }
    size += paramInt - i;
    return i;
  }
  
  public int size()
  {
    return g.b(size);
  }
}
