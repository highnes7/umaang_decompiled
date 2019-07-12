package android.support.v7.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortedList<T>
{
  public static final int CAPACITY_GROWTH = 10;
  public static final int DELETION = 2;
  public static final int INSERTION = 1;
  public static final int INVALID_POSITION = -1;
  public static final int LOOKUP = 4;
  public static final int MIN_CAPACITY = 10;
  public BatchedCallback mBatchedCallback;
  public Callback mCallback;
  public T[] mData;
  public int mNewDataStart;
  public T[] mOldData;
  public int mOldDataSize;
  public int mOldDataStart;
  public int mSize;
  public final Class<T> mTClass;
  
  public SortedList(Class paramClass, Callback paramCallback)
  {
    this(paramClass, paramCallback, 10);
  }
  
  public SortedList(Class paramClass, Callback paramCallback, int paramInt)
  {
    mTClass = paramClass;
    mData = ((Object[])Array.newInstance(paramClass, paramInt));
    mCallback = paramCallback;
    mSize = 0;
  }
  
  private int add(Object paramObject, boolean paramBoolean)
  {
    int k = findIndexOf(paramObject, mData, 0, mSize, 1);
    int i = k;
    int j;
    if (k == -1)
    {
      j = 0;
    }
    else
    {
      j = i;
      if (k < mSize)
      {
        Object localObject = mData[k];
        j = i;
        if (mCallback.areItemsTheSame(localObject, paramObject))
        {
          if (mCallback.areContentsTheSame(localObject, paramObject))
          {
            mData[k] = paramObject;
            return k;
          }
          mData[k] = paramObject;
          Callback localCallback = mCallback;
          localCallback.onChanged(k, 1, localCallback.getChangePayload(localObject, paramObject));
          return k;
        }
      }
    }
    addToData(j, paramObject);
    if (paramBoolean) {
      mCallback.onInserted(j, 1);
    }
    return j;
  }
  
  private void addAllInternal(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length < 1) {
      return;
    }
    int i = sortAndDedup(paramArrayOfObject);
    if (mSize == 0)
    {
      mData = paramArrayOfObject;
      mSize = i;
      mCallback.onInserted(0, i);
      return;
    }
    merge(paramArrayOfObject, i);
  }
  
  private void addToData(int paramInt, Object paramObject)
  {
    int i = mSize;
    if (paramInt <= i)
    {
      Object[] arrayOfObject = mData;
      if (i == arrayOfObject.length)
      {
        arrayOfObject = (Object[])Array.newInstance(mTClass, arrayOfObject.length + 10);
        System.arraycopy(mData, 0, arrayOfObject, 0, paramInt);
        arrayOfObject[paramInt] = paramObject;
        System.arraycopy(mData, paramInt, arrayOfObject, paramInt + 1, mSize - paramInt);
        mData = arrayOfObject;
      }
      else
      {
        System.arraycopy(arrayOfObject, paramInt, arrayOfObject, paramInt + 1, i - paramInt);
        mData[paramInt] = paramObject;
      }
      mSize += 1;
      return;
    }
    paramObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("cannot add item to ", paramInt, " because size is ");
    paramObject.append(mSize);
    throw new IndexOutOfBoundsException(paramObject.toString());
  }
  
  private Object[] copyArray(Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = (Object[])Array.newInstance(mTClass, paramArrayOfObject.length);
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramArrayOfObject.length);
    return arrayOfObject;
  }
  
  private int findIndexOf(Object paramObject, Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    while (paramInt1 < paramInt2)
    {
      int i = (paramInt1 + paramInt2) / 2;
      Object localObject = paramArrayOfObject[i];
      int j = mCallback.compare(localObject, paramObject);
      if (j < 0)
      {
        paramInt1 = i + 1;
      }
      else
      {
        if (j == 0)
        {
          if (mCallback.areItemsTheSame(localObject, paramObject)) {
            return i;
          }
          paramInt1 = linearEqualitySearch(paramObject, i, paramInt1, paramInt2);
          if ((paramInt3 != 1) || (paramInt1 != -1)) {
            return paramInt1;
          }
          return i;
        }
        paramInt2 = i;
      }
    }
    if (paramInt3 == 1) {
      return paramInt1;
    }
    return -1;
    return paramInt1;
  }
  
  private int findSameItem(Object paramObject, Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (mCallback.areItemsTheSame(paramArrayOfObject[paramInt1], paramObject)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  private int linearEqualitySearch(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramInt1 - 1;
    int i;
    Object localObject;
    for (;;)
    {
      i = paramInt1;
      if (j < paramInt2) {
        break;
      }
      localObject = mData[j];
      if (mCallback.compare(localObject, paramObject) != 0)
      {
        i = paramInt1;
        break;
      }
      if (mCallback.areItemsTheSame(localObject, paramObject)) {
        return j;
      }
      j -= 1;
    }
    do
    {
      paramInt1 = i + 1;
      if (paramInt1 >= paramInt3) {
        break;
      }
      localObject = mData[paramInt1];
      if (mCallback.compare(localObject, paramObject) != 0) {
        break;
      }
      i = paramInt1;
    } while (!mCallback.areItemsTheSame(localObject, paramObject));
    return paramInt1;
    return -1;
  }
  
  private void merge(Object[] paramArrayOfObject, int paramInt)
  {
    boolean bool = mCallback instanceof BatchedCallback;
    int i = 0;
    int j;
    if (!bool) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      beginBatchedUpdates();
    }
    mOldData = mData;
    mOldDataStart = 0;
    int k = mSize;
    mOldDataSize = k;
    mData = ((Object[])Array.newInstance(mTClass, k + paramInt + 10));
    mNewDataStart = 0;
    for (;;)
    {
      if ((mOldDataStart < mOldDataSize) || (i < paramInt))
      {
        k = mOldDataStart;
        int m = mOldDataSize;
        if (k == m)
        {
          paramInt -= i;
          System.arraycopy(paramArrayOfObject, i, mData, mNewDataStart, paramInt);
          mNewDataStart += paramInt;
          mSize += paramInt;
          mCallback.onInserted(mNewDataStart - paramInt, paramInt);
        }
        else
        {
          if (i != paramInt) {
            break label231;
          }
          paramInt = m - k;
          System.arraycopy(mOldData, k, mData, mNewDataStart, paramInt);
          mNewDataStart += paramInt;
        }
      }
      mOldData = null;
      if (j == 0) {
        break;
      }
      endBatchedUpdates();
      return;
      label231:
      Object localObject1 = mOldData[k];
      Object localObject2 = paramArrayOfObject[i];
      k = mCallback.compare(localObject1, localObject2);
      if (k > 0)
      {
        localObject1 = mData;
        k = mNewDataStart;
        mNewDataStart = (k + 1);
        localObject1[k] = localObject2;
        mSize += 1;
        i += 1;
        mCallback.onInserted(mNewDataStart - 1, 1);
      }
      else if ((k == 0) && (mCallback.areItemsTheSame(localObject1, localObject2)))
      {
        Object localObject3 = mData;
        k = mNewDataStart;
        mNewDataStart = (k + 1);
        localObject3[k] = localObject2;
        k = i + 1;
        mOldDataStart += 1;
        i = k;
        if (!mCallback.areContentsTheSame(localObject1, localObject2))
        {
          localObject3 = mCallback;
          ((Callback)localObject3).onChanged(mNewDataStart - 1, 1, ((Callback)localObject3).getChangePayload(localObject1, localObject2));
          i = k;
        }
      }
      else
      {
        localObject2 = mData;
        k = mNewDataStart;
        mNewDataStart = (k + 1);
        localObject2[k] = localObject1;
        mOldDataStart += 1;
      }
    }
  }
  
  private boolean remove(Object paramObject, boolean paramBoolean)
  {
    int i = findIndexOf(paramObject, mData, 0, mSize, 2);
    if (i == -1) {
      return false;
    }
    removeItemAtIndex(i, paramBoolean);
    return true;
  }
  
  private void removeItemAtIndex(int paramInt, boolean paramBoolean)
  {
    Object[] arrayOfObject = mData;
    f.sufficientlysecure.rootcommands.util.StringBuilder.fill(mSize, paramInt, 1, arrayOfObject, paramInt + 1, arrayOfObject, paramInt);
    mSize -= 1;
    mData[mSize] = null;
    if (paramBoolean) {
      mCallback.onRemoved(paramInt, 1);
    }
  }
  
  private void replaceAllInsert(Object paramObject)
  {
    Object[] arrayOfObject = mData;
    int i = mNewDataStart;
    arrayOfObject[i] = paramObject;
    mNewDataStart = (i + 1);
    mSize += 1;
    mCallback.onInserted(mNewDataStart - 1, 1);
  }
  
  private void replaceAllInternal(Object[] paramArrayOfObject)
  {
    int i;
    if (!(mCallback instanceof BatchedCallback)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      beginBatchedUpdates();
    }
    mOldDataStart = 0;
    mOldDataSize = mSize;
    mOldData = mData;
    mNewDataStart = 0;
    int j = sortAndDedup(paramArrayOfObject);
    mData = ((Object[])Array.newInstance(mTClass, j));
    for (;;)
    {
      int m;
      if ((mNewDataStart < j) || (mOldDataStart < mOldDataSize))
      {
        m = mOldDataStart;
        int n = mOldDataSize;
        if (m >= n)
        {
          k = mNewDataStart;
          j -= k;
          System.arraycopy(paramArrayOfObject, k, mData, k, j);
          mNewDataStart += j;
          mSize += j;
          mCallback.onInserted(k, j);
        }
        else
        {
          k = mNewDataStart;
          if (k < j) {
            break label223;
          }
          j = n - m;
          mSize -= j;
          mCallback.onRemoved(k, j);
        }
      }
      mOldData = null;
      if (i == 0) {
        break;
      }
      endBatchedUpdates();
      return;
      label223:
      Object localObject1 = mOldData[m];
      Object localObject2 = paramArrayOfObject[k];
      int k = mCallback.compare(localObject1, localObject2);
      if (k < 0)
      {
        replaceAllRemove();
      }
      else if (k > 0)
      {
        replaceAllInsert(localObject2);
      }
      else if (!mCallback.areItemsTheSame(localObject1, localObject2))
      {
        replaceAllRemove();
        replaceAllInsert(localObject2);
      }
      else
      {
        Object localObject3 = mData;
        k = mNewDataStart;
        localObject3[k] = localObject2;
        mOldDataStart += 1;
        mNewDataStart = (k + 1);
        if (!mCallback.areContentsTheSame(localObject1, localObject2))
        {
          localObject3 = mCallback;
          ((Callback)localObject3).onChanged(mNewDataStart - 1, 1, ((Callback)localObject3).getChangePayload(localObject1, localObject2));
        }
      }
    }
  }
  
  private void replaceAllRemove()
  {
    mSize -= 1;
    mOldDataStart += 1;
    mCallback.onRemoved(mNewDataStart, 1);
  }
  
  private int sortAndDedup(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length == 0) {
      return 0;
    }
    Arrays.sort(paramArrayOfObject, mCallback);
    int j = 1;
    int i = 1;
    int k = 0;
    while (j < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[j];
      if (mCallback.compare(paramArrayOfObject[k], localObject) == 0)
      {
        int m = findSameItem(localObject, paramArrayOfObject, k, i);
        if (m != -1)
        {
          paramArrayOfObject[m] = localObject;
        }
        else
        {
          if (i != j) {
            paramArrayOfObject[i] = localObject;
          }
          i += 1;
        }
      }
      else
      {
        if (i != j) {
          paramArrayOfObject[i] = localObject;
        }
        k = i;
        i += 1;
      }
      j += 1;
    }
    return i;
  }
  
  private void throwIfInMutationOperation()
  {
    if (mOldData == null) {
      return;
    }
    throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
  }
  
  public int add(Object paramObject)
  {
    throwIfInMutationOperation();
    return add(paramObject, true);
  }
  
  public void addAll(Collection paramCollection)
  {
    addAll(paramCollection.toArray((Object[])Array.newInstance(mTClass, paramCollection.size())), true);
  }
  
  public void addAll(Object... paramVarArgs)
  {
    addAll(paramVarArgs, false);
  }
  
  public void addAll(Object[] paramArrayOfObject, boolean paramBoolean)
  {
    throwIfInMutationOperation();
    if (paramArrayOfObject.length == 0) {
      return;
    }
    if (paramBoolean)
    {
      addAllInternal(paramArrayOfObject);
      return;
    }
    addAllInternal(copyArray(paramArrayOfObject));
  }
  
  public void beginBatchedUpdates()
  {
    throwIfInMutationOperation();
    Callback localCallback = mCallback;
    if ((localCallback instanceof BatchedCallback)) {
      return;
    }
    if (mBatchedCallback == null) {
      mBatchedCallback = new BatchedCallback(localCallback);
    }
    mCallback = mBatchedCallback;
  }
  
  public void clear()
  {
    throwIfInMutationOperation();
    int i = mSize;
    if (i == 0) {
      return;
    }
    Arrays.fill(mData, 0, i, null);
    mSize = 0;
    mCallback.onRemoved(0, i);
  }
  
  public void endBatchedUpdates()
  {
    throwIfInMutationOperation();
    Callback localCallback = mCallback;
    if ((localCallback instanceof BatchedCallback)) {
      ((BatchedCallback)localCallback).dispatchLastEvent();
    }
    localCallback = mCallback;
    BatchedCallback localBatchedCallback = mBatchedCallback;
    if (localCallback == localBatchedCallback) {
      mCallback = mWrappedCallback;
    }
  }
  
  public Object get(int paramInt)
    throws IndexOutOfBoundsException
  {
    if ((paramInt < mSize) && (paramInt >= 0))
    {
      localObject = mOldData;
      if (localObject != null)
      {
        int i = mNewDataStart;
        if (paramInt >= i) {
          return localObject[(paramInt - i + mOldDataStart)];
        }
      }
      return mData[paramInt];
    }
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Asked to get item at ", paramInt, " but size is ");
    ((StringBuilder)localObject).append(mSize);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public int indexOf(Object paramObject)
  {
    if (mOldData != null)
    {
      int i = findIndexOf(paramObject, mData, 0, mNewDataStart, 4);
      if (i != -1) {
        return i;
      }
      i = findIndexOf(paramObject, mOldData, mOldDataStart, mOldDataSize, 4);
      if (i != -1) {
        return i - mOldDataStart + mNewDataStart;
      }
      return -1;
    }
    return findIndexOf(paramObject, mData, 0, mSize, 4);
  }
  
  public void recalculatePositionOfItemAt(int paramInt)
  {
    throwIfInMutationOperation();
    Object localObject = get(paramInt);
    removeItemAtIndex(paramInt, false);
    int i = add(localObject, false);
    if (paramInt != i) {
      mCallback.onMoved(paramInt, i);
    }
  }
  
  public boolean remove(Object paramObject)
  {
    throwIfInMutationOperation();
    return remove(paramObject, true);
  }
  
  public Object removeItemAt(int paramInt)
  {
    throwIfInMutationOperation();
    Object localObject = get(paramInt);
    removeItemAtIndex(paramInt, true);
    return localObject;
  }
  
  public void replaceAll(Collection paramCollection)
  {
    replaceAll(paramCollection.toArray((Object[])Array.newInstance(mTClass, paramCollection.size())), true);
  }
  
  public void replaceAll(Object... paramVarArgs)
  {
    replaceAll(paramVarArgs, false);
  }
  
  public void replaceAll(Object[] paramArrayOfObject, boolean paramBoolean)
  {
    throwIfInMutationOperation();
    if (paramBoolean)
    {
      replaceAllInternal(paramArrayOfObject);
      return;
    }
    replaceAllInternal(copyArray(paramArrayOfObject));
  }
  
  public int size()
  {
    return mSize;
  }
  
  public void updateItemAt(int paramInt, Object paramObject)
  {
    throwIfInMutationOperation();
    Object localObject = get(paramInt);
    int i;
    if ((localObject != paramObject) && (mCallback.areContentsTheSame(localObject, paramObject))) {
      i = 0;
    } else {
      i = 1;
    }
    Callback localCallback;
    if ((localObject != paramObject) && (mCallback.compare(localObject, paramObject) == 0))
    {
      mData[paramInt] = paramObject;
      if (i != 0)
      {
        localCallback = mCallback;
        localCallback.onChanged(paramInt, 1, localCallback.getChangePayload(localObject, paramObject));
      }
    }
    else
    {
      if (i != 0)
      {
        localCallback = mCallback;
        localCallback.onChanged(paramInt, 1, localCallback.getChangePayload(localObject, paramObject));
      }
      removeItemAtIndex(paramInt, false);
      i = add(paramObject, false);
      if (paramInt != i) {
        mCallback.onMoved(paramInt, i);
      }
    }
  }
  
  public static class BatchedCallback<T2>
    extends SortedList.Callback<T2>
  {
    public final BatchingListUpdateCallback mBatchingListUpdateCallback;
    public final SortedList.Callback<T2> mWrappedCallback;
    
    public BatchedCallback(SortedList.Callback paramCallback)
    {
      mWrappedCallback = paramCallback;
      mBatchingListUpdateCallback = new BatchingListUpdateCallback(mWrappedCallback);
    }
    
    public boolean areContentsTheSame(Object paramObject1, Object paramObject2)
    {
      return mWrappedCallback.areContentsTheSame(paramObject1, paramObject2);
    }
    
    public boolean areItemsTheSame(Object paramObject1, Object paramObject2)
    {
      return mWrappedCallback.areItemsTheSame(paramObject1, paramObject2);
    }
    
    public int compare(Object paramObject1, Object paramObject2)
    {
      return mWrappedCallback.compare(paramObject1, paramObject2);
    }
    
    public void dispatchLastEvent()
    {
      mBatchingListUpdateCallback.dispatchLastEvent();
    }
    
    public Object getChangePayload(Object paramObject1, Object paramObject2)
    {
      return mWrappedCallback.getChangePayload(paramObject1, paramObject2);
    }
    
    public void onChanged(int paramInt1, int paramInt2)
    {
      mBatchingListUpdateCallback.onChanged(paramInt1, paramInt2, null);
    }
    
    public void onChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      mBatchingListUpdateCallback.onChanged(paramInt1, paramInt2, paramObject);
    }
    
    public void onInserted(int paramInt1, int paramInt2)
    {
      mBatchingListUpdateCallback.onInserted(paramInt1, paramInt2);
    }
    
    public void onMoved(int paramInt1, int paramInt2)
    {
      mBatchingListUpdateCallback.onMoved(paramInt1, paramInt2);
    }
    
    public void onRemoved(int paramInt1, int paramInt2)
    {
      mBatchingListUpdateCallback.onRemoved(paramInt1, paramInt2);
    }
  }
  
  public static abstract class Callback<T2>
    implements Comparator<T2>, ListUpdateCallback
  {
    public Callback() {}
    
    public abstract boolean areContentsTheSame(Object paramObject1, Object paramObject2);
    
    public abstract boolean areItemsTheSame(Object paramObject1, Object paramObject2);
    
    public abstract int compare(Object paramObject1, Object paramObject2);
    
    public Object getChangePayload(Object paramObject1, Object paramObject2)
    {
      return null;
    }
    
    public abstract void onChanged(int paramInt1, int paramInt2);
    
    public void onChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      onChanged(paramInt1, paramInt2);
    }
  }
}
