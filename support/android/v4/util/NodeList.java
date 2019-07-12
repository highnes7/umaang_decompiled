package support.android.v4.util;

import b.b.a.G;
import b.b.x.n.n;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class NodeList<E>
  implements Collection<E>, Set<E>
{
  public static final boolean DEFAULT_SHOW_WEEK_NUM = false;
  public static final String EVENTLOG_URL = "ArraySet";
  public static final int INITIAL_CAPACITY = 10;
  public static final int MAX_LOCATION_SUGGESTIONS = 4;
  public static final int[] a = new int[0];
  public static int container;
  @G
  public static Object[] index;
  public static int length;
  public static final Object[] q = new Object[0];
  @G
  public static Object[] value;
  public n<E, E> capacity;
  public int[] data;
  public Object[] next;
  public int size;
  
  public NodeList()
  {
    this(0);
  }
  
  public NodeList(int paramInt)
  {
    if (paramInt == 0)
    {
      data = a;
      next = q;
    }
    else
    {
      update(paramInt);
    }
    size = 0;
  }
  
  public NodeList(Collection paramCollection)
  {
    this(0);
    if (paramCollection != null) {
      addAll(paramCollection);
    }
  }
  
  public NodeList(NodeList paramNodeList)
  {
    this(0);
    if (paramNodeList != null) {
      add(paramNodeList);
    }
  }
  
  private MapCollections add()
  {
    if (capacity == null) {
      capacity = new ExclusiveRange.RangeIterator(this);
    }
    return capacity;
  }
  
  public static void add(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (length < 10)
        {
          paramArrayOfObject[0] = value;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label114;
          value = paramArrayOfObject;
          length += 1;
        }
        return;
      }
      catch (Throwable paramArrayOfInt)
      {
        throw paramArrayOfInt;
      }
    }
    if (paramArrayOfInt.length == 4) {}
    for (;;)
    {
      try
      {
        if (container < 10)
        {
          paramArrayOfObject[0] = index;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label130;
          index = paramArrayOfObject;
          container += 1;
        }
        return;
      }
      catch (Throwable paramArrayOfInt)
      {
        throw paramArrayOfInt;
      }
      return;
      label114:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label130:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  private int indexOf()
  {
    int j = size;
    if (j == 0) {
      return -1;
    }
    int k = ContainerHelpers.binarySearch(data, j, 0);
    if (k < 0) {
      return k;
    }
    if (next[k] == null) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (data[i] == 0))
    {
      if (next[i] == null) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (data[j] == 0))
    {
      if (next[j] == null) {
        return j;
      }
      j -= 1;
    }
    return i;
  }
  
  private int indexOf(Object paramObject, int paramInt)
  {
    int j = size;
    if (j == 0) {
      return -1;
    }
    int k = ContainerHelpers.binarySearch(data, j, paramInt);
    if (k < 0) {
      return k;
    }
    if (paramObject.equals(next[k])) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (data[i] == paramInt))
    {
      if (paramObject.equals(next[i])) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (data[j] == paramInt))
    {
      if (paramObject.equals(next[j])) {
        return j;
      }
      j -= 1;
    }
    return i;
  }
  
  private void update(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        if (value != null)
        {
          Object[] arrayOfObject1 = value;
          next = arrayOfObject1;
          value = (Object[])arrayOfObject1[0];
          data = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          length -= 1;
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        throw localThrowable1;
      }
    }
    if (paramInt == 4) {
      try
      {
        if (index != null)
        {
          Object[] arrayOfObject2 = index;
          next = arrayOfObject2;
          index = (Object[])arrayOfObject2[0];
          data = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          container -= 1;
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        throw localThrowable2;
      }
    }
    data = new int[paramInt];
    next = new Object[paramInt];
  }
  
  public Object add(int paramInt)
  {
    Object localObject2 = next;
    Object localObject1 = localObject2[paramInt];
    int j = size;
    if (j <= 1)
    {
      add(data, (Object[])localObject2, j);
      data = a;
      next = q;
      size = 0;
      return localObject1;
    }
    localObject2 = data;
    int k = localObject2.length;
    int i = 8;
    if ((k > 8) && (j < localObject2.length / 3))
    {
      if (j > 8) {
        i = j + (j >> 1);
      }
      localObject2 = data;
      Object[] arrayOfObject = next;
      update(i);
      size -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(localObject2, 0, data, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, next, 0, paramInt);
      }
      i = size;
      if (paramInt < i)
      {
        j = paramInt + 1;
        System.arraycopy(localObject2, j, data, paramInt, i - paramInt);
        System.arraycopy(arrayOfObject, j, next, paramInt, size - paramInt);
        return localObject1;
      }
    }
    else
    {
      size -= 1;
      i = size;
      if (paramInt < i)
      {
        localObject2 = data;
        j = paramInt + 1;
        System.arraycopy(localObject2, j, localObject2, paramInt, i - paramInt);
        localObject2 = next;
        System.arraycopy(localObject2, j, localObject2, paramInt, size - paramInt);
      }
      next[size] = null;
    }
    return localObject1;
  }
  
  public void add(NodeList paramNodeList)
  {
    int j = size;
    set(size + j);
    int k = size;
    int i = 0;
    if (k == 0)
    {
      if (j > 0)
      {
        System.arraycopy(data, 0, data, 0, j);
        System.arraycopy(next, 0, next, 0, j);
        size = j;
      }
    }
    else {
      while (i < j)
      {
        add(paramNodeList.get(i));
        i += 1;
      }
    }
  }
  
  public boolean add(Object paramObject)
  {
    int j;
    if (paramObject == null)
    {
      i = indexOf();
      j = 0;
    }
    else
    {
      j = paramObject.hashCode();
      i = indexOf(paramObject, j);
    }
    if (i >= 0) {
      return false;
    }
    int k = i;
    int m = size;
    Object localObject;
    if (m >= data.length)
    {
      i = 4;
      if (m >= 8) {
        i = (m >> 1) + m;
      } else if (m >= 4) {
        i = 8;
      }
      localObject = data;
      Object[] arrayOfObject = next;
      update(i);
      int[] arrayOfInt = data;
      if (arrayOfInt.length > 0)
      {
        System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
        System.arraycopy(arrayOfObject, 0, next, 0, arrayOfObject.length);
      }
      add((int[])localObject, arrayOfObject, size);
    }
    int i = size;
    if (k < i)
    {
      localObject = data;
      m = k + 1;
      System.arraycopy(localObject, k, localObject, m, i - k);
      localObject = next;
      System.arraycopy(localObject, k, localObject, m, size - k);
    }
    data[k] = j;
    next[k] = paramObject;
    size += 1;
    return true;
  }
  
  public boolean addAll(Collection paramCollection)
  {
    int i = size;
    set(paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    while (paramCollection.hasNext()) {
      bool |= add(paramCollection.next());
    }
    return bool;
  }
  
  public void clear()
  {
    int i = size;
    if (i != 0)
    {
      add(data, next, i);
      data = a;
      next = q;
      size = 0;
    }
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
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
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    int i;
    if ((paramObject instanceof Set))
    {
      paramObject = (Set)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
      i = 0;
    }
    for (;;)
    {
      try
      {
        int j = size;
        if (i >= j) {}
      }
      catch (NullPointerException paramObject)
      {
        boolean bool;
        return false;
      }
      try
      {
        bool = paramObject.contains(get(i));
        if (!bool) {
          return false;
        }
        i += 1;
      }
      catch (ClassCastException paramObject) {}
    }
    return true;
    return false;
    return false;
  }
  
  public Object get(int paramInt)
  {
    return next[paramInt];
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = data;
    int k = size;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += arrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  public int indexOf(Object paramObject)
  {
    if (paramObject == null) {
      return indexOf();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  public boolean isEmpty()
  {
    return size <= 0;
  }
  
  public Iterator iterator()
  {
    return add().getKeySet().iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    int i = indexOf(paramObject);
    if (i >= 0)
    {
      add(i);
      return true;
    }
    return false;
  }
  
  public boolean remove(NodeList paramNodeList)
  {
    int j = size;
    int k = size;
    int i = 0;
    while (i < j)
    {
      remove(paramNodeList.get(i));
      i += 1;
    }
    return k != size;
  }
  
  public boolean removeAll(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    while (paramCollection.hasNext()) {
      bool |= remove(paramCollection.next());
    }
    return bool;
  }
  
  public boolean retainAll(Collection paramCollection)
  {
    int i = size - 1;
    boolean bool = false;
    while (i >= 0)
    {
      if (!paramCollection.contains(next[i]))
      {
        add(i);
        bool = true;
      }
      i -= 1;
    }
    return bool;
  }
  
  public void set(int paramInt)
  {
    int[] arrayOfInt = data;
    if (arrayOfInt.length < paramInt)
    {
      Object[] arrayOfObject = next;
      update(paramInt);
      paramInt = size;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, data, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, next, 0, size);
      }
      add(arrayOfInt, arrayOfObject, size);
    }
  }
  
  public void set(Object paramObject)
  {
    int j = size;
    int i;
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.hashCode();
    }
    int[] arrayOfInt = data;
    if (j < arrayOfInt.length)
    {
      if ((j > 0) && (arrayOfInt[(j - 1)] > i))
      {
        add(paramObject);
        return;
      }
      size = (j + 1);
      data[j] = i;
      next[j] = paramObject;
      return;
    }
    throw new IllegalStateException("Array is full");
  }
  
  public int size()
  {
    return size;
  }
  
  public Object[] toArray()
  {
    int i = size;
    Object[] arrayOfObject = new Object[i];
    System.arraycopy(next, 0, arrayOfObject, 0, i);
    return arrayOfObject;
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject.length < size) {
      arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), size);
    }
    System.arraycopy(next, 0, arrayOfObject, 0, size);
    int i = arrayOfObject.length;
    int j = size;
    if (i > j) {
      arrayOfObject[j] = null;
    }
    return arrayOfObject;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(size * 14);
    localStringBuilder.append('{');
    int i = 0;
    while (i < size)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = get(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Set)");
      }
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
