package support.android.v4.util;

import b.b.a.G;
import b.b.x.n.n;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class MapCollections<K, V>
{
  @G
  public n<K, V>.b mEntrySet;
  @G
  public n<K, V>.c mKeySet;
  @G
  public n<K, V>.e mValues;
  
  public MapCollections() {}
  
  public static boolean containsAllHelper(Map paramMap, Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!paramMap.containsKey(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean equalsSetHelper(Set paramSet, Object paramObject)
  {
    if (paramSet == paramObject) {
      return true;
    }
    if ((paramObject instanceof Set)) {
      paramObject = (Set)paramObject;
    }
    try
    {
      int i = paramSet.size();
      int j = paramObject.size();
      if (i == j)
      {
        boolean bool = paramSet.containsAll(paramObject);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (NullPointerException paramSet)
    {
      return false;
    }
    catch (ClassCastException paramSet) {}
    return false;
    return false;
  }
  
  public static boolean removeAllHelper(Map paramMap, Collection paramCollection)
  {
    int i = paramMap.size();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      paramMap.remove(paramCollection.next());
    }
    return i != paramMap.size();
  }
  
  public static boolean retainAllHelper(Map paramMap, Collection paramCollection)
  {
    int i = paramMap.size();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!paramCollection.contains(localIterator.next())) {
        localIterator.remove();
      }
    }
    return i != paramMap.size();
  }
  
  public abstract void colClear();
  
  public abstract Object colGetEntry(int paramInt1, int paramInt2);
  
  public abstract Map colGetMap();
  
  public abstract int colGetSize();
  
  public abstract int colIndexOfKey(Object paramObject);
  
  public abstract int colIndexOfValue(Object paramObject);
  
  public abstract void colPut(Object paramObject1, Object paramObject2);
  
  public abstract void colRemoveAt(int paramInt);
  
  public abstract Object colSetValue(int paramInt, Object paramObject);
  
  public Set getEntrySet()
  {
    if (mEntrySet == null) {
      mEntrySet = new EntrySet();
    }
    return mEntrySet;
  }
  
  public Set getKeySet()
  {
    if (mKeySet == null) {
      mKeySet = new KeySet();
    }
    return mKeySet;
  }
  
  public Collection getValues()
  {
    if (mValues == null) {
      mValues = new ValuesCollection();
    }
    return mValues;
  }
  
  public Object[] toArrayHelper(int paramInt)
  {
    int j = colGetSize();
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = colGetEntry(i, paramInt);
      i += 1;
    }
    return arrayOfObject;
  }
  
  public Object[] toArrayHelper(Object[] paramArrayOfObject, int paramInt)
  {
    int j = colGetSize();
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject.length < j) {
      arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), j);
    }
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = colGetEntry(i, paramInt);
      i += 1;
    }
    if (arrayOfObject.length > j) {
      arrayOfObject[j] = null;
    }
    return arrayOfObject;
  }
  
  public final class ArrayIterator<T>
    implements Iterator<T>
  {
    public boolean mCanRemove = false;
    public int mIndex;
    public final int mOffset;
    public int mSize;
    
    public ArrayIterator(int paramInt)
    {
      mOffset = paramInt;
      mSize = colGetSize();
    }
    
    public boolean hasNext()
    {
      return mIndex < mSize;
    }
    
    public Object next()
    {
      if (hasNext())
      {
        Object localObject = colGetEntry(mIndex, mOffset);
        mIndex += 1;
        mCanRemove = true;
        return localObject;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      if (mCanRemove)
      {
        mIndex -= 1;
        mSize -= 1;
        mCanRemove = false;
        colRemoveAt(mIndex);
        return;
      }
      throw new IllegalStateException();
    }
  }
  
  public final class EntrySet
    implements Set<Map.Entry<K, V>>
  {
    public EntrySet() {}
    
    public boolean add(Map.Entry paramEntry)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection paramCollection)
    {
      int i = colGetSize();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCollection.next();
        colPut(localEntry.getKey(), localEntry.getValue());
      }
      return i != colGetSize();
    }
    
    public void clear()
    {
      colClear();
    }
    
    public boolean contains(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      int i = colIndexOfKey(paramObject.getKey());
      if (i < 0) {
        return false;
      }
      return ContainerHelpers.equal(colGetEntry(i, 1), paramObject.getValue());
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
      return MapCollections.equalsSetHelper(this, paramObject);
    }
    
    public int hashCode()
    {
      int i = colGetSize() - 1;
      int j = 0;
      while (i >= 0)
      {
        Object localObject1 = colGetEntry(i, 0);
        Object localObject2 = colGetEntry(i, 1);
        int k;
        if (localObject1 == null) {
          k = 0;
        } else {
          k = localObject1.hashCode();
        }
        int m;
        if (localObject2 == null) {
          m = 0;
        } else {
          m = localObject2.hashCode();
        }
        j += (k ^ m);
        i -= 1;
      }
      return j;
    }
    
    public boolean isEmpty()
    {
      return colGetSize() == 0;
    }
    
    public Iterator iterator()
    {
      return new MapCollections.MapIterator(MapCollections.this);
    }
    
    public boolean remove(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(Collection paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(Collection paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public int size()
    {
      return colGetSize();
    }
    
    public Object[] toArray()
    {
      throw new UnsupportedOperationException();
    }
    
    public Object[] toArray(Object[] paramArrayOfObject)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  public final class KeySet
    implements Set<K>
  {
    public KeySet() {}
    
    public boolean add(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      colClear();
    }
    
    public boolean contains(Object paramObject)
    {
      return colIndexOfKey(paramObject) >= 0;
    }
    
    public boolean containsAll(Collection paramCollection)
    {
      return MapCollections.containsAllHelper(colGetMap(), paramCollection);
    }
    
    public boolean equals(Object paramObject)
    {
      return MapCollections.equalsSetHelper(this, paramObject);
    }
    
    public int hashCode()
    {
      int i = colGetSize() - 1;
      int j = 0;
      while (i >= 0)
      {
        Object localObject = colGetEntry(i, 0);
        int k;
        if (localObject == null) {
          k = 0;
        } else {
          k = localObject.hashCode();
        }
        j += k;
        i -= 1;
      }
      return j;
    }
    
    public boolean isEmpty()
    {
      return colGetSize() == 0;
    }
    
    public Iterator iterator()
    {
      return new MapCollections.ArrayIterator(MapCollections.this, 0);
    }
    
    public boolean remove(Object paramObject)
    {
      int i = colIndexOfKey(paramObject);
      if (i >= 0)
      {
        colRemoveAt(i);
        return true;
      }
      return false;
    }
    
    public boolean removeAll(Collection paramCollection)
    {
      return MapCollections.removeAllHelper(colGetMap(), paramCollection);
    }
    
    public boolean retainAll(Collection paramCollection)
    {
      return MapCollections.retainAllHelper(colGetMap(), paramCollection);
    }
    
    public int size()
    {
      return colGetSize();
    }
    
    public Object[] toArray()
    {
      return toArrayHelper(0);
    }
    
    public Object[] toArray(Object[] paramArrayOfObject)
    {
      return toArrayHelper(paramArrayOfObject, 0);
    }
  }
  
  public final class MapIterator
    implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
  {
    public int mEnd = colGetSize() - 1;
    public boolean mEntryValid = false;
    public int mIndex = -1;
    
    public MapIterator() {}
    
    public boolean equals(Object paramObject)
    {
      if (mEntryValid)
      {
        if (!(paramObject instanceof Map.Entry)) {
          return false;
        }
        paramObject = (Map.Entry)paramObject;
        if ((ContainerHelpers.equal(paramObject.getKey(), colGetEntry(mIndex, 0))) && (ContainerHelpers.equal(paramObject.getValue(), colGetEntry(mIndex, 1)))) {
          return true;
        }
      }
      else
      {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      return false;
    }
    
    public Object getKey()
    {
      if (mEntryValid) {
        return colGetEntry(mIndex, 0);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public Object getValue()
    {
      if (mEntryValid) {
        return colGetEntry(mIndex, 1);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public boolean hasNext()
    {
      return mIndex < mEnd;
    }
    
    public int hashCode()
    {
      if (mEntryValid)
      {
        Object localObject1 = MapCollections.this;
        int i = mIndex;
        int j = 0;
        localObject1 = ((MapCollections)localObject1).colGetEntry(i, 0);
        Object localObject2 = colGetEntry(mIndex, 1);
        if (localObject1 == null) {
          i = 0;
        } else {
          i = localObject1.hashCode();
        }
        if (localObject2 != null) {
          j = localObject2.hashCode();
        }
        return i ^ j;
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public Map.Entry next()
    {
      if (hasNext())
      {
        mIndex += 1;
        mEntryValid = true;
        return this;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      if (mEntryValid)
      {
        colRemoveAt(mIndex);
        mIndex -= 1;
        mEnd -= 1;
        mEntryValid = false;
        return;
      }
      throw new IllegalStateException();
    }
    
    public Object setValue(Object paramObject)
    {
      if (mEntryValid) {
        return colSetValue(mIndex, paramObject);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getKey());
      localStringBuilder.append("=");
      localStringBuilder.append(getValue());
      return localStringBuilder.toString();
    }
  }
  
  public final class ValuesCollection
    implements Collection<V>
  {
    public ValuesCollection() {}
    
    public boolean add(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      colClear();
    }
    
    public boolean contains(Object paramObject)
    {
      return colIndexOfValue(paramObject) >= 0;
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
    
    public boolean isEmpty()
    {
      return colGetSize() == 0;
    }
    
    public Iterator iterator()
    {
      return new MapCollections.ArrayIterator(MapCollections.this, 1);
    }
    
    public boolean remove(Object paramObject)
    {
      int i = colIndexOfValue(paramObject);
      if (i >= 0)
      {
        colRemoveAt(i);
        return true;
      }
      return false;
    }
    
    public boolean removeAll(Collection paramCollection)
    {
      int j = colGetSize();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int k = j;
        int m = i;
        if (paramCollection.contains(colGetEntry(i, 1)))
        {
          colRemoveAt(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      return bool;
    }
    
    public boolean retainAll(Collection paramCollection)
    {
      int j = colGetSize();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        int k = j;
        int m = i;
        if (!paramCollection.contains(colGetEntry(i, 1)))
        {
          colRemoveAt(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      return bool;
    }
    
    public int size()
    {
      return colGetSize();
    }
    
    public Object[] toArray()
    {
      return toArrayHelper(1);
    }
    
    public Object[] toArray(Object[] paramArrayOfObject)
    {
      return toArrayHelper(paramArrayOfObject, 1);
    }
  }
}
