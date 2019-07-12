package f.g.org.org.util;

import java.util.AbstractMap;
import java.util.Set;

public class ArrayMap<K, V>
  extends AbstractMap<K, V>
  implements Cloneable
{
  public Object[] data;
  public int size;
  
  public ArrayMap() {}
  
  public static ArrayMap create()
  {
    return new ArrayMap();
  }
  
  public static ArrayMap create(int paramInt)
  {
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.ensureCapacity(paramInt);
    return localArrayMap;
  }
  
  private int getDataIndexOfKey(Object paramObject)
  {
    int j = size;
    Object[] arrayOfObject = data;
    int i = 0;
    while (i < j << 1)
    {
      Object localObject = arrayOfObject[i];
      if (paramObject == null)
      {
        if (localObject == null) {
          return i;
        }
      }
      else if (paramObject.equals(localObject)) {
        return i;
      }
      i += 2;
    }
    return -2;
  }
  
  public static ArrayMap of(Object... paramVarArgs)
  {
    ArrayMap localArrayMap = create(1);
    int i = paramVarArgs.length;
    if (1 != i % 2)
    {
      size = (paramVarArgs.length / 2);
      Object[] arrayOfObject = new Object[i];
      data = arrayOfObject;
      System.arraycopy(paramVarArgs, 0, arrayOfObject, 0, i);
      return localArrayMap;
    }
    paramVarArgs = String.valueOf(paramVarArgs[(i - 1)]);
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(paramVarArgs.length() + 28), "missing value for last key: ", paramVarArgs));
  }
  
  private Object removeFromDataIndexOfKey(int paramInt)
  {
    int i = size << 1;
    if (paramInt >= 0)
    {
      if (paramInt >= i) {
        return null;
      }
      Object localObject = valueAtDataIndex(paramInt + 1);
      Object[] arrayOfObject = data;
      int j = i - paramInt - 2;
      if (j != 0) {
        System.arraycopy(arrayOfObject, paramInt + 2, arrayOfObject, paramInt, j);
      }
      size -= 1;
      setData(i - 2, null, null);
      return localObject;
    }
    return null;
  }
  
  private void setData(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object[] arrayOfObject = data;
    arrayOfObject[paramInt] = paramObject1;
    arrayOfObject[(paramInt + 1)] = paramObject2;
  }
  
  private void setDataCapacity(int paramInt)
  {
    if (paramInt == 0)
    {
      data = null;
      return;
    }
    int i = size;
    Object[] arrayOfObject1 = data;
    if ((i == 0) || (paramInt != arrayOfObject1.length))
    {
      Object[] arrayOfObject2 = new Object[paramInt];
      data = arrayOfObject2;
      if (i != 0) {
        System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i << 1);
      }
    }
  }
  
  private Object valueAtDataIndex(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    return data[paramInt];
  }
  
  public void clear()
  {
    size = 0;
    data = null;
  }
  
  public ArrayMap clone()
  {
    try
    {
      Object localObject = super.clone();
      localObject = (ArrayMap)localObject;
      Object[] arrayOfObject1 = data;
      if (arrayOfObject1 == null) {
        return localObject;
      }
      int i = arrayOfObject1.length;
      Object[] arrayOfObject2 = new Object[i];
      data = arrayOfObject2;
      System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;) {}
      return localCloneNotSupportedException;
    }
    return null;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return -2 != getDataIndexOfKey(paramObject);
  }
  
  public final boolean containsValue(Object paramObject)
  {
    int j = size;
    Object[] arrayOfObject = data;
    int i = 1;
    while (i < j << 1)
    {
      Object localObject = arrayOfObject[i];
      if (paramObject == null)
      {
        if (localObject == null) {
          return true;
        }
      }
      else if (paramObject.equals(localObject)) {
        return true;
      }
      i += 2;
    }
    return false;
  }
  
  public final void ensureCapacity(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object[] arrayOfObject = data;
      int i = paramInt << 1;
      if (arrayOfObject == null) {
        paramInt = 0;
      } else {
        paramInt = arrayOfObject.length;
      }
      if (i > paramInt)
      {
        int j = paramInt / 2 * 3 + 1;
        paramInt = j;
        if (j % 2 != 0) {
          paramInt = j + 1;
        }
        if (paramInt < i) {
          paramInt = i;
        }
        setDataCapacity(paramInt);
      }
    }
    else
    {
      throw new IndexOutOfBoundsException();
    }
  }
  
  public final Set entrySet()
  {
    return new TIntCharMapDecorator.1(this);
  }
  
  public final Object get(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < size)) {
      return valueAtDataIndex((paramInt << 1) + 1);
    }
    return null;
  }
  
  public final Object get(Object paramObject)
  {
    return valueAtDataIndex(getDataIndexOfKey(paramObject) + 1);
  }
  
  public final int getIndexOfKey(Object paramObject)
  {
    return getDataIndexOfKey(paramObject) >> 1;
  }
  
  public final Object getKey(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < size)) {
      return data[(paramInt << 1)];
    }
    return null;
  }
  
  public final Object put(Object paramObject1, Object paramObject2)
  {
    int j = getIndexOfKey(paramObject1);
    int i = j;
    if (j == -1) {
      i = size;
    }
    return set(i, paramObject1, paramObject2);
  }
  
  public final Object remove(int paramInt)
  {
    return removeFromDataIndexOfKey(paramInt << 1);
  }
  
  public final Object remove(Object paramObject)
  {
    return removeFromDataIndexOfKey(getDataIndexOfKey(paramObject));
  }
  
  public final Object set(int paramInt, Object paramObject)
  {
    int i = size;
    if ((paramInt >= 0) && (paramInt < i))
    {
      paramInt = (paramInt << 1) + 1;
      Object localObject = valueAtDataIndex(paramInt);
      data[paramInt] = paramObject;
      return localObject;
    }
    throw new IndexOutOfBoundsException();
  }
  
  public final Object set(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject;
    if (paramInt >= 0)
    {
      int i = paramInt + 1;
      ensureCapacity(i);
      paramInt <<= 1;
      localObject = valueAtDataIndex(paramInt + 1);
      setData(paramInt, paramObject1, paramObject2);
      if (i > size)
      {
        size = i;
        return localObject;
      }
    }
    else
    {
      throw new IndexOutOfBoundsException();
    }
    return localObject;
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    set(size, paramObject1, paramObject2);
  }
  
  public final int size()
  {
    return size;
  }
  
  public final void trim()
  {
    setDataCapacity(size << 1);
  }
}
