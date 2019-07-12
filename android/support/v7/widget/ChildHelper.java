package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class ChildHelper
{
  public static final boolean DEBUG = false;
  public static final String TAG = "ChildrenHelper";
  public final Bucket mBucket;
  public final Callback mCallback;
  public final List<View> mHiddenViews;
  
  public ChildHelper(Callback paramCallback)
  {
    mCallback = paramCallback;
    mBucket = new Bucket();
    mHiddenViews = new ArrayList();
  }
  
  private int getOffset(int paramInt)
  {
    if (paramInt < 0) {
      return -1;
    }
    int j = mCallback.getChildCount();
    int i = paramInt;
    while (i < j)
    {
      int k = paramInt - (i - mBucket.countOnesBefore(i));
      if (k == 0)
      {
        while (mBucket.get(i)) {
          i += 1;
        }
        return i;
      }
      i += k;
    }
    return -1;
  }
  
  private void hideViewInternal(View paramView)
  {
    mHiddenViews.add(paramView);
    mCallback.onEnteredHiddenState(paramView);
  }
  
  private boolean unhideViewInternal(View paramView)
  {
    if (mHiddenViews.remove(paramView))
    {
      mCallback.onLeftHiddenState(paramView);
      return true;
    }
    return false;
  }
  
  public void addView(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {
      paramInt = mCallback.getChildCount();
    } else {
      paramInt = getOffset(paramInt);
    }
    mBucket.insert(paramInt, paramBoolean);
    if (paramBoolean)
    {
      mHiddenViews.add(paramView);
      mCallback.onEnteredHiddenState(paramView);
    }
    mCallback.addView(paramView, paramInt);
  }
  
  public void addView(View paramView, boolean paramBoolean)
  {
    addView(paramView, -1, paramBoolean);
  }
  
  public void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramInt < 0) {
      paramInt = mCallback.getChildCount();
    } else {
      paramInt = getOffset(paramInt);
    }
    mBucket.insert(paramInt, paramBoolean);
    if (paramBoolean)
    {
      mHiddenViews.add(paramView);
      mCallback.onEnteredHiddenState(paramView);
    }
    mCallback.attachViewToParent(paramView, paramInt, paramLayoutParams);
  }
  
  public void detachViewFromParent(int paramInt)
  {
    paramInt = getOffset(paramInt);
    mBucket.remove(paramInt);
    mCallback.detachViewFromParent(paramInt);
  }
  
  public View findHiddenNonRemovedView(int paramInt)
  {
    int j = mHiddenViews.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)mHiddenViews.get(i);
      RecyclerView.ViewHolder localViewHolder = mCallback.getChildViewHolder(localView);
      if ((localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.isInvalid()) && (!localViewHolder.isRemoved())) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public View getChildAt(int paramInt)
  {
    paramInt = getOffset(paramInt);
    return mCallback.getChildAt(paramInt);
  }
  
  public int getChildCount()
  {
    return mCallback.getChildCount() - mHiddenViews.size();
  }
  
  public View getUnfilteredChildAt(int paramInt)
  {
    return mCallback.getChildAt(paramInt);
  }
  
  public int getUnfilteredChildCount()
  {
    return mCallback.getChildCount();
  }
  
  public void hide(View paramView)
  {
    int i = mCallback.indexOfChild(paramView);
    if (i >= 0)
    {
      mBucket.set(i);
      mHiddenViews.add(paramView);
      mCallback.onEnteredHiddenState(paramView);
      return;
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("view is not a child, cannot hide ", paramView));
  }
  
  public int indexOfChild(View paramView)
  {
    int i = mCallback.indexOfChild(paramView);
    if (i == -1) {
      return -1;
    }
    if (mBucket.get(i)) {
      return -1;
    }
    return i - mBucket.countOnesBefore(i);
  }
  
  public boolean isHidden(View paramView)
  {
    return mHiddenViews.contains(paramView);
  }
  
  public void removeAllViewsUnfiltered()
  {
    mBucket.reset();
    int i = mHiddenViews.size() - 1;
    while (i >= 0)
    {
      mCallback.onLeftHiddenState((View)mHiddenViews.get(i));
      mHiddenViews.remove(i);
      i -= 1;
    }
    mCallback.removeAllViews();
  }
  
  public void removeView(View paramView)
  {
    int i = mCallback.indexOfChild(paramView);
    if (i < 0) {
      return;
    }
    if (mBucket.remove(i)) {
      unhideViewInternal(paramView);
    }
    mCallback.removeViewAt(i);
  }
  
  public void removeViewAt(int paramInt)
  {
    paramInt = getOffset(paramInt);
    View localView = mCallback.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    if (mBucket.remove(paramInt)) {
      unhideViewInternal(localView);
    }
    mCallback.removeViewAt(paramInt);
  }
  
  public boolean removeViewIfHidden(View paramView)
  {
    int i = mCallback.indexOfChild(paramView);
    if (i == -1)
    {
      unhideViewInternal(paramView);
      return true;
    }
    if (mBucket.get(i))
    {
      mBucket.remove(i);
      unhideViewInternal(paramView);
      mCallback.removeViewAt(i);
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(mBucket.toString());
    localStringBuilder.append(", hidden list:");
    localStringBuilder.append(mHiddenViews.size());
    return localStringBuilder.toString();
  }
  
  public void unhide(View paramView)
  {
    int i = mCallback.indexOfChild(paramView);
    if (i >= 0)
    {
      if (mBucket.get(i))
      {
        mBucket.clear(i);
        unhideViewInternal(paramView);
        return;
      }
      throw new RuntimeException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("trying to unhide a view that was not hidden", paramView));
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("view is not a child, cannot hide ", paramView));
  }
  
  public static class Bucket
  {
    public static final int BITS_PER_WORD = 64;
    public static final long LAST_BIT = Long.MIN_VALUE;
    public long mData = 0L;
    public Bucket mNext;
    
    public Bucket() {}
    
    private void ensureNext()
    {
      if (mNext == null) {
        mNext = new Bucket();
      }
    }
    
    public void clear(int paramInt)
    {
      if (paramInt >= 64)
      {
        Bucket localBucket = mNext;
        if (localBucket != null) {
          localBucket.clear(paramInt - 64);
        }
      }
      else
      {
        mData &= 1L << paramInt;
      }
    }
    
    public int countOnesBefore(int paramInt)
    {
      Bucket localBucket = mNext;
      if (localBucket == null)
      {
        if (paramInt >= 64) {
          return Long.bitCount(mData);
        }
        return Long.bitCount(mData & (1L << paramInt) - 1L);
      }
      if (paramInt < 64) {
        return Long.bitCount(mData & (1L << paramInt) - 1L);
      }
      paramInt = localBucket.countOnesBefore(paramInt - 64);
      return Long.bitCount(mData) + paramInt;
    }
    
    public boolean get(int paramInt)
    {
      if (paramInt >= 64)
      {
        ensureNext();
        return mNext.get(paramInt - 64);
      }
      return (mData & 1L << paramInt) != 0L;
    }
    
    public void insert(int paramInt, boolean paramBoolean)
    {
      if (paramInt >= 64)
      {
        ensureNext();
        mNext.insert(paramInt - 64, paramBoolean);
        return;
      }
      boolean bool;
      if ((mData & 0x8000000000000000) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      long l1 = (1L << paramInt) - 1L;
      long l2 = mData;
      mData = ((l2 & l1) << 1 | l2 & l1);
      if (paramBoolean) {
        set(paramInt);
      } else {
        clear(paramInt);
      }
      if ((bool) || (mNext != null))
      {
        ensureNext();
        mNext.insert(0, bool);
      }
    }
    
    public boolean remove(int paramInt)
    {
      if (paramInt >= 64)
      {
        ensureNext();
        return mNext.remove(paramInt - 64);
      }
      long l1 = 1L << paramInt;
      boolean bool;
      if ((mData & l1) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      mData &= l1;
      l1 -= 1L;
      long l2 = mData;
      mData = (Long.rotateRight(l2 & l1, 1) | l2 & l1);
      Bucket localBucket = mNext;
      if (localBucket != null)
      {
        if (localBucket.get(0)) {
          set(63);
        }
        mNext.remove(0);
      }
      return bool;
    }
    
    public void reset()
    {
      mData = 0L;
      Bucket localBucket = mNext;
      if (localBucket != null) {
        localBucket.reset();
      }
    }
    
    public void set(int paramInt)
    {
      if (paramInt >= 64)
      {
        ensureNext();
        mNext.set(paramInt - 64);
        return;
      }
      mData |= 1L << paramInt;
    }
    
    public String toString()
    {
      if (mNext == null) {
        return Long.toBinaryString(mData);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(mNext.toString());
      localStringBuilder.append("xx");
      localStringBuilder.append(Long.toBinaryString(mData));
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void addView(View paramView, int paramInt);
    
    public abstract void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams);
    
    public abstract void detachViewFromParent(int paramInt);
    
    public abstract View getChildAt(int paramInt);
    
    public abstract int getChildCount();
    
    public abstract RecyclerView.ViewHolder getChildViewHolder(View paramView);
    
    public abstract int indexOfChild(View paramView);
    
    public abstract void onEnteredHiddenState(View paramView);
    
    public abstract void onLeftHiddenState(View paramView);
    
    public abstract void removeAllViews();
    
    public abstract void removeViewAt(int paramInt);
  }
}
