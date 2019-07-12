package android.support.v7.widget;

import b.b.a.G;
import b.b.a.W;
import b.b.x.n.b;
import b.b.x.n.l;
import b.b.x.n.r.a;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.LongSparseArray;
import support.android.v4.util.Pools.Pool;
import support.android.v4.util.Pools.SimplePool;
import support.android.v4.util.SimpleArrayMap;

public class ViewInfoStore
{
  public static final boolean DEBUG = false;
  @W
  public final b<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap = new ArrayMap();
  @W
  public final l<RecyclerView.ViewHolder> mOldChangedHolders = new LongSparseArray(10);
  
  public ViewInfoStore() {}
  
  private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = mLayoutHolderMap.indexOfKey(paramViewHolder);
    if (i < 0) {
      return null;
    }
    InfoRecord localInfoRecord = (InfoRecord)mLayoutHolderMap.get(i);
    if (localInfoRecord != null)
    {
      int j = flags;
      if ((j & paramInt) != 0)
      {
        flags = (paramInt & j);
        if (paramInt == 4)
        {
          paramViewHolder = preInfo;
        }
        else
        {
          if (paramInt != 8) {
            break label109;
          }
          paramViewHolder = postInfo;
        }
        if ((flags & 0xC) != 0) {
          return paramViewHolder;
        }
        mLayoutHolderMap.removeAt(i);
        InfoRecord.recycle(localInfoRecord);
        return paramViewHolder;
        label109:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
      }
    }
    return null;
    return paramViewHolder;
  }
  
  public void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord2 = InfoRecord.obtain();
      localInfoRecord1 = localInfoRecord2;
      mLayoutHolderMap.put(paramViewHolder, localInfoRecord2);
    }
    flags |= 0x2;
    preInfo = paramItemHolderInfo;
  }
  
  public void addToDisappearedInLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord2 = InfoRecord.obtain();
      localInfoRecord1 = localInfoRecord2;
      mLayoutHolderMap.put(paramViewHolder, localInfoRecord2);
    }
    flags |= 0x1;
  }
  
  public void addToOldChangeHolders(long paramLong, RecyclerView.ViewHolder paramViewHolder)
  {
    mOldChangedHolders.put(paramLong, paramViewHolder);
  }
  
  public void addToPostLayout(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord2 = InfoRecord.obtain();
      localInfoRecord1 = localInfoRecord2;
      mLayoutHolderMap.put(paramViewHolder, localInfoRecord2);
    }
    postInfo = paramItemHolderInfo;
    flags |= 0x8;
  }
  
  public void addToPreLayout(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord2 = InfoRecord.obtain();
      localInfoRecord1 = localInfoRecord2;
      mLayoutHolderMap.put(paramViewHolder, localInfoRecord2);
    }
    preInfo = paramItemHolderInfo;
    flags |= 0x4;
  }
  
  public void clear()
  {
    mLayoutHolderMap.clear();
    mOldChangedHolders.clear();
  }
  
  public RecyclerView.ViewHolder getFromOldChangeHolders(long paramLong)
  {
    return (RecyclerView.ViewHolder)mOldChangedHolders.get(paramLong);
  }
  
  public boolean isDisappearing(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (InfoRecord)mLayoutHolderMap.get(paramViewHolder);
    return (paramViewHolder != null) && ((flags & 0x1) != 0);
  }
  
  public boolean isInPreLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (InfoRecord)mLayoutHolderMap.get(paramViewHolder);
    return (paramViewHolder != null) && ((flags & 0x4) != 0);
  }
  
  public void onDetach() {}
  
  public void onViewDetached(RecyclerView.ViewHolder paramViewHolder)
  {
    removeFromDisappearedInLayout(paramViewHolder);
  }
  
  public RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    return popFromLayoutStep(paramViewHolder, 8);
  }
  
  public RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    return popFromLayoutStep(paramViewHolder, 4);
  }
  
  public void process(ProcessCallback paramProcessCallback)
  {
    int i = mLayoutHolderMap.size() - 1;
    while (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)mLayoutHolderMap.keyAt(i);
      InfoRecord localInfoRecord = (InfoRecord)mLayoutHolderMap.removeAt(i);
      int j = flags;
      if ((j & 0x3) == 3)
      {
        paramProcessCallback.unused(localViewHolder);
      }
      else if ((j & 0x1) != 0)
      {
        RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo = preInfo;
        if (localItemHolderInfo == null) {
          paramProcessCallback.unused(localViewHolder);
        } else {
          paramProcessCallback.processDisappeared(localViewHolder, localItemHolderInfo, postInfo);
        }
      }
      else if ((j & 0xE) == 14)
      {
        paramProcessCallback.processAppeared(localViewHolder, preInfo, postInfo);
      }
      else if ((j & 0xC) == 12)
      {
        paramProcessCallback.processPersistent(localViewHolder, preInfo, postInfo);
      }
      else if ((j & 0x4) != 0)
      {
        paramProcessCallback.processDisappeared(localViewHolder, preInfo, null);
      }
      else if ((j & 0x8) != 0)
      {
        paramProcessCallback.processAppeared(localViewHolder, preInfo, postInfo);
      }
      InfoRecord.recycle(localInfoRecord);
      i -= 1;
    }
  }
  
  public void removeFromDisappearedInLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (InfoRecord)mLayoutHolderMap.get(paramViewHolder);
    if (paramViewHolder == null) {
      return;
    }
    flags &= 0xFFFFFFFE;
  }
  
  public void removeViewHolder(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = mOldChangedHolders.size() - 1;
    while (i >= 0)
    {
      if (paramViewHolder == mOldChangedHolders.valueAt(i))
      {
        mOldChangedHolders.removeAt(i);
        break;
      }
      i -= 1;
    }
    paramViewHolder = (InfoRecord)mLayoutHolderMap.remove(paramViewHolder);
    if (paramViewHolder != null) {
      InfoRecord.recycle(paramViewHolder);
    }
  }
  
  public static class InfoRecord
  {
    public static final int FLAG_APPEAR = 2;
    public static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
    public static final int FLAG_APPEAR_PRE_AND_POST = 14;
    public static final int FLAG_DISAPPEARED = 1;
    public static final int FLAG_POST = 8;
    public static final int FLAG_PRE = 4;
    public static final int FLAG_PRE_AND_POST = 12;
    public static r.a<InfoRecord> sPool = new Pools.SimplePool(20);
    public int flags;
    @G
    public RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
    @G
    public RecyclerView.ItemAnimator.ItemHolderInfo preInfo;
    
    public InfoRecord() {}
    
    public static void drainCache()
    {
      while (sPool.acquire() != null) {}
    }
    
    public static InfoRecord obtain()
    {
      InfoRecord localInfoRecord2 = (InfoRecord)sPool.acquire();
      InfoRecord localInfoRecord1 = localInfoRecord2;
      if (localInfoRecord2 == null) {
        localInfoRecord1 = new InfoRecord();
      }
      return localInfoRecord1;
    }
    
    public static void recycle(InfoRecord paramInfoRecord)
    {
      flags = 0;
      preInfo = null;
      postInfo = null;
      sPool.release(paramInfoRecord);
    }
  }
  
  public static abstract interface ProcessCallback
  {
    public abstract void processAppeared(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void processDisappeared(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void processPersistent(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void unused(RecyclerView.ViewHolder paramViewHolder);
  }
}
