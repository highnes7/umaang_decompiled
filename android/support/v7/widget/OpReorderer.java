package android.support.v7.widget;

import java.util.List;

public class OpReorderer
{
  public final Callback mCallback;
  
  public OpReorderer(Callback paramCallback)
  {
    mCallback = paramCallback;
  }
  
  private int getLastMoveOutOfOrder(List paramList)
  {
    int i = paramList.size() - 1;
    int k;
    for (int j = 0; i >= 0; j = k)
    {
      if (getcmd == 8)
      {
        k = j;
        if (j != 0) {
          return i;
        }
      }
      else
      {
        k = 1;
      }
      i -= 1;
    }
    return -1;
  }
  
  private void swapMoveAdd(List paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    if (itemCount < positionStart) {
      i = -1;
    } else {
      i = 0;
    }
    int j = i;
    if (positionStart < positionStart) {
      j = i + 1;
    }
    int i = positionStart;
    int k = positionStart;
    if (i <= k) {
      positionStart = (k + itemCount);
    }
    i = positionStart;
    k = itemCount;
    if (i <= k) {
      itemCount = (k + itemCount);
    }
    positionStart += j;
    paramList.set(paramInt1, paramUpdateOp2);
    paramList.set(paramInt2, paramUpdateOp1);
  }
  
  private void swapMoveOp(List paramList, int paramInt1, int paramInt2)
  {
    AdapterHelper.UpdateOp localUpdateOp1 = (AdapterHelper.UpdateOp)paramList.get(paramInt1);
    AdapterHelper.UpdateOp localUpdateOp2 = (AdapterHelper.UpdateOp)paramList.get(paramInt2);
    int i = cmd;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4) {
          return;
        }
        swapMoveUpdate(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
        return;
      }
      swapMoveRemove(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
      return;
    }
    swapMoveAdd(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
  }
  
  public void reorderOps(List paramList)
  {
    for (;;)
    {
      int i = getLastMoveOutOfOrder(paramList);
      if (i == -1) {
        break;
      }
      swapMoveOp(paramList, i, i + 1);
    }
  }
  
  public void swapMoveRemove(List paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    int i = positionStart;
    int k = itemCount;
    int j = 0;
    if (i < k)
    {
      if ((positionStart == i) && (itemCount == k - i))
      {
        i = 0;
      }
      else
      {
        i = 0;
        break label94;
      }
    }
    else
    {
      if ((positionStart != k + 1) || (itemCount != i - k)) {
        break label91;
      }
      i = 1;
    }
    j = 1;
    break label94;
    label91:
    i = 1;
    label94:
    k = itemCount;
    int m = positionStart;
    int n;
    if (k < m)
    {
      positionStart = (m - 1);
    }
    else
    {
      n = itemCount;
      if (k < m + n)
      {
        itemCount = (n - 1);
        cmd = 2;
        itemCount = 1;
        if (itemCount != 0) {
          return;
        }
        paramList.remove(paramInt2);
        mCallback.recycleUpdateOp(paramUpdateOp2);
        return;
      }
    }
    k = positionStart;
    m = positionStart;
    AdapterHelper.UpdateOp localUpdateOp = null;
    if (k <= m)
    {
      positionStart = (m + 1);
    }
    else
    {
      n = itemCount;
      if (k < m + n)
      {
        localUpdateOp = mCallback.obtainUpdateOp(2, k + 1, m + n - k, null);
        itemCount = (positionStart - positionStart);
      }
    }
    if (j != 0)
    {
      paramList.set(paramInt1, paramUpdateOp2);
      paramList.remove(paramInt2);
      mCallback.recycleUpdateOp(paramUpdateOp1);
      return;
    }
    if (i != 0)
    {
      if (localUpdateOp != null)
      {
        i = positionStart;
        if (i > positionStart) {
          positionStart = (i - itemCount);
        }
        i = itemCount;
        if (i > positionStart) {
          itemCount = (i - itemCount);
        }
      }
      i = positionStart;
      if (i > positionStart) {
        positionStart = (i - itemCount);
      }
      i = itemCount;
      if (i > positionStart) {
        itemCount = (i - itemCount);
      }
    }
    else
    {
      if (localUpdateOp != null)
      {
        i = positionStart;
        if (i >= positionStart) {
          positionStart = (i - itemCount);
        }
        i = itemCount;
        if (i >= positionStart) {
          itemCount = (i - itemCount);
        }
      }
      i = positionStart;
      if (i >= positionStart) {
        positionStart = (i - itemCount);
      }
      i = itemCount;
      if (i >= positionStart) {
        itemCount = (i - itemCount);
      }
    }
    paramList.set(paramInt1, paramUpdateOp2);
    if (positionStart != itemCount) {
      paramList.set(paramInt2, paramUpdateOp1);
    } else {
      paramList.remove(paramInt2);
    }
    if (localUpdateOp != null) {
      paramList.add(paramInt1, localUpdateOp);
    }
  }
  
  public void swapMoveUpdate(List paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    int i = itemCount;
    int j = positionStart;
    AdapterHelper.UpdateOp localUpdateOp2 = null;
    int k;
    if (i < j)
    {
      positionStart = (j - 1);
    }
    else
    {
      k = itemCount;
      if (i < j + k)
      {
        itemCount = (k - 1);
        localUpdateOp1 = mCallback.obtainUpdateOp(4, positionStart, 1, payload);
        break label89;
      }
    }
    AdapterHelper.UpdateOp localUpdateOp1 = null;
    label89:
    i = positionStart;
    j = positionStart;
    if (i <= j)
    {
      positionStart = (j + 1);
    }
    else
    {
      k = itemCount;
      if (i < j + k)
      {
        j = j + k - i;
        localUpdateOp2 = mCallback.obtainUpdateOp(4, i + 1, j, payload);
        itemCount -= j;
      }
    }
    paramList.set(paramInt2, paramUpdateOp1);
    if (itemCount > 0)
    {
      paramList.set(paramInt1, paramUpdateOp2);
    }
    else
    {
      paramList.remove(paramInt1);
      mCallback.recycleUpdateOp(paramUpdateOp2);
    }
    if (localUpdateOp1 != null) {
      paramList.add(paramInt1, localUpdateOp1);
    }
    if (localUpdateOp2 != null) {
      paramList.add(paramInt1, localUpdateOp2);
    }
  }
  
  public static abstract interface Callback
  {
    public abstract AdapterHelper.UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
    
    public abstract void recycleUpdateOp(AdapterHelper.UpdateOp paramUpdateOp);
  }
}
