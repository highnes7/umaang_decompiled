package android.support.v7.util;

import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DiffUtil
{
  public static final Comparator<Snake> SNAKE_COMPARATOR = new Comparator()
  {
    public int compare(DiffUtil.Snake paramAnonymousSnake1, DiffUtil.Snake paramAnonymousSnake2)
    {
      int j = tail - tail;
      int i = j;
      if (j == 0) {
        i = head - head;
      }
      return i;
    }
  };
  
  public DiffUtil() {}
  
  public static DiffResult calculateDiff(Callback paramCallback)
  {
    return calculateDiff(paramCallback, true);
  }
  
  public static DiffResult calculateDiff(Callback paramCallback, boolean paramBoolean)
  {
    int i = paramCallback.getOldListSize();
    int j = paramCallback.getNewListSize();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new Range(0, i, 0, j));
    i = Math.abs(i - j) + (i + j);
    j = i * 2;
    int[] arrayOfInt1 = new int[j];
    int[] arrayOfInt2 = new int[j];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      Range localRange2 = (Range)localArrayList2.remove(localArrayList2.size() - 1);
      Snake localSnake = diffPartial(paramCallback, oldListStart, oldListEnd, newListStart, newListEnd, arrayOfInt1, arrayOfInt2, i);
      if (localSnake != null)
      {
        if (size > 0) {
          localArrayList1.add(localSnake);
        }
        tail += oldListStart;
        head += newListStart;
        Range localRange1;
        if (localArrayList3.isEmpty()) {
          localRange1 = new Range();
        } else {
          localRange1 = (Range)localArrayList3.remove(localArrayList3.size() - 1);
        }
        oldListStart = oldListStart;
        newListStart = newListStart;
        if (reverse)
        {
          oldListEnd = tail;
          newListEnd = head;
        }
        else if (removal)
        {
          oldListEnd = (tail - 1);
          newListEnd = head;
        }
        else
        {
          oldListEnd = tail;
          newListEnd = (head - 1);
        }
        localArrayList2.add(localRange1);
        int k;
        if (reverse)
        {
          if (removal)
          {
            j = tail;
            k = size;
            oldListStart = (j + k + 1);
            newListStart = (head + k);
          }
          else
          {
            j = tail;
            k = size;
            oldListStart = (j + k);
            newListStart = (head + k + 1);
          }
        }
        else
        {
          j = tail;
          k = size;
          oldListStart = (j + k);
          newListStart = (head + k);
        }
        localArrayList2.add(localRange2);
      }
      else
      {
        localArrayList3.add(localRange2);
      }
    }
    Collections.sort(localArrayList1, SNAKE_COMPARATOR);
    return new DiffResult(paramCallback, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  public static Snake diffPartial(Callback paramCallback, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
  {
    int k = paramInt2 - paramInt1;
    int i1 = paramInt4 - paramInt3;
    if ((k >= 1) && (i1 >= 1))
    {
      int i2 = k - i1;
      int i3 = (k + i1 + 1) / 2;
      paramInt2 = paramInt5 - i3 - 1;
      paramInt4 = paramInt5 + i3 + 1;
      Arrays.fill(paramArrayOfInt1, paramInt2, paramInt4, 0);
      Arrays.fill(paramArrayOfInt2, paramInt2 + i2, paramInt4 + i2, k);
      if (i2 % 2 != 0) {
        paramInt4 = 1;
      } else {
        paramInt4 = 0;
      }
      int i = 0;
      while (i <= i3)
      {
        int j = -i;
        int m = j;
        boolean bool;
        label199:
        int n;
        while (m <= i)
        {
          if (m != j) {
            if (m != i)
            {
              paramInt2 = paramInt5 + m;
              if (paramArrayOfInt1[(paramInt2 - 1)] < paramArrayOfInt1[(paramInt2 + 1)]) {}
            }
            else
            {
              paramInt2 = paramArrayOfInt1[(paramInt5 + m - 1)] + 1;
              bool = true;
              break label199;
            }
          }
          paramInt2 = paramArrayOfInt1[(paramInt5 + m + 1)];
          bool = false;
          n = paramInt2 - m;
          while ((paramInt2 < k) && (n < i1) && (paramCallback.areItemsTheSame(paramInt1 + paramInt2, paramInt3 + n)))
          {
            paramInt2 += 1;
            n += 1;
          }
          n = paramInt5 + m;
          paramArrayOfInt1[n] = paramInt2;
          if ((paramInt4 != 0) && (m >= i2 - i + 1) && (m <= i2 + i - 1) && (paramArrayOfInt1[n] >= paramArrayOfInt2[n]))
          {
            paramCallback = new Snake();
            tail = paramArrayOfInt2[n];
            head = (tail - m);
            size = (paramArrayOfInt1[n] - paramArrayOfInt2[n]);
            removal = bool;
            reverse = false;
            return paramCallback;
          }
          m += 2;
        }
        m = j;
        while (m <= i)
        {
          int i4 = m + i2;
          if (i4 != i + i2) {
            if (i4 != j + i2)
            {
              paramInt2 = paramInt5 + i4;
              if (paramArrayOfInt2[(paramInt2 - 1)] < paramArrayOfInt2[(paramInt2 + 1)]) {}
            }
            else
            {
              paramInt2 = paramArrayOfInt2[(paramInt5 + i4 + 1)] - 1;
              bool = true;
              break label460;
            }
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i4 - 1)];
          bool = false;
          label460:
          n = paramInt2 - i4;
          while ((paramInt2 > 0) && (n > 0) && (paramCallback.areItemsTheSame(paramInt1 + paramInt2 - 1, paramInt3 + n - 1)))
          {
            paramInt2 -= 1;
            n -= 1;
          }
          n = paramInt5 + i4;
          paramArrayOfInt2[n] = paramInt2;
          if ((paramInt4 == 0) && (i4 >= j) && (i4 <= i) && (paramArrayOfInt1[n] >= paramArrayOfInt2[n]))
          {
            paramCallback = new Snake();
            tail = paramArrayOfInt2[n];
            head = (tail - i4);
            size = (paramArrayOfInt1[n] - paramArrayOfInt2[n]);
            removal = bool;
            reverse = true;
            return paramCallback;
          }
          m += 2;
        }
        i += 1;
      }
      throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
    return null;
  }
  
  public static abstract class Callback
  {
    public Callback() {}
    
    public abstract boolean areContentsTheSame(int paramInt1, int paramInt2);
    
    public abstract boolean areItemsTheSame(int paramInt1, int paramInt2);
    
    public Object getChangePayload(int paramInt1, int paramInt2)
    {
      return null;
    }
    
    public abstract int getNewListSize();
    
    public abstract int getOldListSize();
  }
  
  public static class DiffResult
  {
    public static final int FLAG_CHANGED = 2;
    public static final int FLAG_IGNORE = 16;
    public static final int FLAG_MASK = 31;
    public static final int FLAG_MOVED_CHANGED = 4;
    public static final int FLAG_MOVED_NOT_CHANGED = 8;
    public static final int FLAG_NOT_CHANGED = 1;
    public static final int FLAG_OFFSET = 5;
    public static final int NO_POSITION = -1;
    public final DiffUtil.Callback mCallback;
    public final boolean mDetectMoves;
    public final int[] mNewItemStatuses;
    public final int mNewListSize;
    public final int[] mOldItemStatuses;
    public final int mOldListSize;
    public final List<DiffUtil.Snake> mSnakes;
    
    public DiffResult(DiffUtil.Callback paramCallback, List paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
    {
      mSnakes = paramList;
      mOldItemStatuses = paramArrayOfInt1;
      mNewItemStatuses = paramArrayOfInt2;
      Arrays.fill(mOldItemStatuses, 0);
      Arrays.fill(mNewItemStatuses, 0);
      mCallback = paramCallback;
      mOldListSize = paramCallback.getOldListSize();
      mNewListSize = paramCallback.getNewListSize();
      mDetectMoves = paramBoolean;
      addRootSnake();
      findMatchingItems();
    }
    
    private void addRootSnake()
    {
      DiffUtil.Snake localSnake;
      if (mSnakes.isEmpty()) {
        localSnake = null;
      } else {
        localSnake = (DiffUtil.Snake)mSnakes.get(0);
      }
      if ((localSnake == null) || (tail != 0) || (head != 0))
      {
        localSnake = new DiffUtil.Snake();
        tail = 0;
        head = 0;
        removal = false;
        size = 0;
        reverse = false;
        mSnakes.add(0, localSnake);
      }
    }
    
    private void dispatchAdditions(List paramList, ListUpdateCallback paramListUpdateCallback, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!mDetectMoves)
      {
        paramListUpdateCallback.onInserted(paramInt1, paramInt2);
        return;
      }
      paramInt2 -= 1;
      while (paramInt2 >= 0)
      {
        Object localObject = mNewItemStatuses;
        int i = paramInt3 + paramInt2;
        int j = localObject[i] & 0x1F;
        if (j != 0)
        {
          if ((j != 4) && (j != 8))
          {
            if (j == 16)
            {
              paramList.add(new DiffUtil.PostponedUpdate(i, paramInt1, false));
            }
            else
            {
              paramList = f.sufficientlysecure.rootcommands.util.StringBuilder.append("unknown flag for pos ", i, " ");
              paramList.append(Long.toBinaryString(j));
              throw new IllegalStateException(paramList.toString());
            }
          }
          else
          {
            int k = mNewItemStatuses[i] >> 5;
            paramListUpdateCallback.onMoved(removePostponedUpdatecurrentPos, paramInt1);
            if (j == 4) {
              paramListUpdateCallback.onChanged(paramInt1, 1, mCallback.getChangePayload(k, i));
            }
          }
        }
        else
        {
          paramListUpdateCallback.onInserted(paramInt1, 1);
          localObject = paramList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            DiffUtil.PostponedUpdate localPostponedUpdate = (DiffUtil.PostponedUpdate)((Iterator)localObject).next();
            currentPos += 1;
          }
        }
        paramInt2 -= 1;
      }
    }
    
    private void dispatchRemovals(List paramList, ListUpdateCallback paramListUpdateCallback, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!mDetectMoves)
      {
        paramListUpdateCallback.onRemoved(paramInt1, paramInt2);
        return;
      }
      paramInt2 -= 1;
      while (paramInt2 >= 0)
      {
        Object localObject = mOldItemStatuses;
        int i = paramInt3 + paramInt2;
        int j = localObject[i] & 0x1F;
        if (j != 0)
        {
          if ((j != 4) && (j != 8))
          {
            if (j == 16)
            {
              paramList.add(new DiffUtil.PostponedUpdate(i, paramInt1 + paramInt2, true));
            }
            else
            {
              paramList = f.sufficientlysecure.rootcommands.util.StringBuilder.append("unknown flag for pos ", i, " ");
              paramList.append(Long.toBinaryString(j));
              throw new IllegalStateException(paramList.toString());
            }
          }
          else
          {
            int k = mOldItemStatuses[i] >> 5;
            localObject = removePostponedUpdate(paramList, k, false);
            paramListUpdateCallback.onMoved(paramInt1 + paramInt2, currentPos - 1);
            if (j == 4) {
              paramListUpdateCallback.onChanged(currentPos - 1, 1, mCallback.getChangePayload(i, k));
            }
          }
        }
        else
        {
          paramListUpdateCallback.onRemoved(paramInt1 + paramInt2, 1);
          localObject = paramList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            DiffUtil.PostponedUpdate localPostponedUpdate = (DiffUtil.PostponedUpdate)((Iterator)localObject).next();
            currentPos -= 1;
          }
        }
        paramInt2 -= 1;
      }
    }
    
    private void findAddition(int paramInt1, int paramInt2, int paramInt3)
    {
      if (mOldItemStatuses[(paramInt1 - 1)] != 0) {
        return;
      }
      findMatchingItem(paramInt1, paramInt2, paramInt3, false);
    }
    
    private boolean findMatchingItem(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int i;
      int j;
      int k;
      if (paramBoolean)
      {
        i = paramInt2 - 1;
        paramInt2 = paramInt1;
        j = i;
      }
      else
      {
        k = paramInt1 - 1;
        j = k;
        i = paramInt2;
        paramInt2 = k;
      }
      while (paramInt3 >= 0)
      {
        Object localObject = (DiffUtil.Snake)mSnakes.get(paramInt3);
        int n = tail;
        int m = size;
        int i1 = head;
        k = 8;
        if (paramBoolean)
        {
          paramInt2 -= 1;
          while (paramInt2 >= n + m)
          {
            if (mCallback.areItemsTheSame(paramInt2, j))
            {
              if (!mCallback.areContentsTheSame(paramInt2, j)) {
                k = 4;
              }
              mNewItemStatuses[j] = (paramInt2 << 5 | 0x10);
              mOldItemStatuses[paramInt2] = (j << 5 | k);
              return true;
            }
            paramInt2 -= 1;
          }
        }
        paramInt2 = i - 1;
        while (paramInt2 >= i1 + m)
        {
          if (mCallback.areItemsTheSame(j, paramInt2))
          {
            if (!mCallback.areContentsTheSame(j, paramInt2)) {
              k = 4;
            }
            localObject = mOldItemStatuses;
            paramInt1 -= 1;
            localObject[paramInt1] = (paramInt2 << 5 | 0x10);
            mNewItemStatuses[paramInt2] = (paramInt1 << 5 | k);
            return true;
          }
          paramInt2 -= 1;
        }
        paramInt2 = tail;
        i = head;
        paramInt3 -= 1;
      }
      return false;
    }
    
    private void findMatchingItems()
    {
      int j = mOldListSize;
      int i = mNewListSize;
      int k = mSnakes.size() - 1;
      while (k >= 0)
      {
        DiffUtil.Snake localSnake = (DiffUtil.Snake)mSnakes.get(k);
        int i2 = tail;
        int n = size;
        int i1 = head;
        int m;
        if (mDetectMoves)
        {
          for (;;)
          {
            m = i;
            if (j <= i2 + n) {
              break;
            }
            findAddition(j, i, k);
            j -= 1;
          }
          while (m > i1 + n)
          {
            findRemoval(j, m, k);
            m -= 1;
          }
        }
        i = 0;
        while (i < size)
        {
          m = tail + i;
          n = head + i;
          if (mCallback.areContentsTheSame(m, n)) {
            j = 1;
          } else {
            j = 2;
          }
          mOldItemStatuses[m] = (n << 5 | j);
          mNewItemStatuses[n] = (m << 5 | j);
          i += 1;
        }
        j = tail;
        i = head;
        k -= 1;
      }
    }
    
    private void findRemoval(int paramInt1, int paramInt2, int paramInt3)
    {
      if (mNewItemStatuses[(paramInt2 - 1)] != 0) {
        return;
      }
      findMatchingItem(paramInt1, paramInt2, paramInt3, true);
    }
    
    public static DiffUtil.PostponedUpdate removePostponedUpdate(List paramList, int paramInt, boolean paramBoolean)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        DiffUtil.PostponedUpdate localPostponedUpdate1 = (DiffUtil.PostponedUpdate)paramList.get(i);
        if ((posInOwnerList == paramInt) && (removal == paramBoolean))
        {
          paramList.remove(i);
          while (i < paramList.size())
          {
            DiffUtil.PostponedUpdate localPostponedUpdate2 = (DiffUtil.PostponedUpdate)paramList.get(i);
            int j = currentPos;
            if (paramBoolean) {
              paramInt = 1;
            } else {
              paramInt = -1;
            }
            currentPos = (j + paramInt);
            i += 1;
          }
          return localPostponedUpdate1;
        }
        i -= 1;
      }
      return null;
    }
    
    public int convertNewPositionToOld(int paramInt)
    {
      if (paramInt >= 0)
      {
        localObject = mNewItemStatuses;
        if (paramInt < localObject.length)
        {
          paramInt = localObject[paramInt];
          if ((paramInt & 0x1F) == 0) {
            return -1;
          }
          return paramInt >> 5;
        }
      }
      Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Index out of bounds - passed position = ", paramInt, ", new list size = ");
      ((StringBuilder)localObject).append(mNewItemStatuses.length);
      throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
    }
    
    public int convertOldPositionToNew(int paramInt)
    {
      if (paramInt >= 0)
      {
        localObject = mOldItemStatuses;
        if (paramInt < localObject.length)
        {
          paramInt = localObject[paramInt];
          if ((paramInt & 0x1F) == 0) {
            return -1;
          }
          return paramInt >> 5;
        }
      }
      Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Index out of bounds - passed position = ", paramInt, ", old list size = ");
      ((StringBuilder)localObject).append(mOldItemStatuses.length);
      throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
    }
    
    public void dispatchUpdatesTo(ListUpdateCallback paramListUpdateCallback)
    {
      if ((paramListUpdateCallback instanceof BatchingListUpdateCallback)) {
        paramListUpdateCallback = (BatchingListUpdateCallback)paramListUpdateCallback;
      } else {
        paramListUpdateCallback = new BatchingListUpdateCallback(paramListUpdateCallback);
      }
      ArrayList localArrayList = new ArrayList();
      int j = mOldListSize;
      int k = mNewListSize;
      int i = mSnakes.size();
      i -= 1;
      while (i >= 0)
      {
        DiffUtil.Snake localSnake = (DiffUtil.Snake)mSnakes.get(i);
        int m = size;
        int n = tail + m;
        int i1 = head + m;
        if (n < j) {
          dispatchRemovals(localArrayList, paramListUpdateCallback, n, j - n, n);
        }
        if (i1 < k) {
          dispatchAdditions(localArrayList, paramListUpdateCallback, n, k - i1, i1);
        }
        j = m - 1;
        while (j >= 0)
        {
          int[] arrayOfInt = mOldItemStatuses;
          k = tail;
          if ((arrayOfInt[(k + j)] & 0x1F) == 2) {
            paramListUpdateCallback.onChanged(k + j, 1, mCallback.getChangePayload(k + j, head + j));
          }
          j -= 1;
        }
        j = tail;
        k = head;
        i -= 1;
      }
      paramListUpdateCallback.dispatchLastEvent();
    }
    
    public void dispatchUpdatesTo(RecyclerView.Adapter paramAdapter)
    {
      dispatchUpdatesTo(new AdapterListUpdateCallback(paramAdapter));
    }
    
    public List getSnakes()
    {
      return mSnakes;
    }
  }
  
  public static abstract class ItemCallback<T>
  {
    public ItemCallback() {}
    
    public abstract boolean areContentsTheSame(Object paramObject1, Object paramObject2);
    
    public abstract boolean areItemsTheSame(Object paramObject1, Object paramObject2);
    
    public Object getChangePayload(Object paramObject1, Object paramObject2)
    {
      return null;
    }
  }
  
  private static class PostponedUpdate
  {
    public int currentPos;
    public int posInOwnerList;
    public boolean removal;
    
    public PostponedUpdate(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      posInOwnerList = paramInt1;
      currentPos = paramInt2;
      removal = paramBoolean;
    }
  }
  
  public static class Range
  {
    public int newListEnd;
    public int newListStart;
    public int oldListEnd;
    public int oldListStart;
    
    public Range() {}
    
    public Range(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      oldListStart = paramInt1;
      oldListEnd = paramInt2;
      newListStart = paramInt3;
      newListEnd = paramInt4;
    }
  }
  
  public static class Snake
  {
    public int head;
    public boolean removal;
    public boolean reverse;
    public int size;
    public int tail;
    
    public Snake() {}
  }
}
