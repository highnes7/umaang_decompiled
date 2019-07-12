package android.support.v7.widget;

import android.view.View;

public class LayoutState
{
  public static final int INVALID_LAYOUT = Integer.MIN_VALUE;
  public static final int ITEM_DIRECTION_HEAD = -1;
  public static final int ITEM_DIRECTION_TAIL = 1;
  public static final int LAYOUT_END = 1;
  public static final int LAYOUT_START = -1;
  public static final String TAG = "LayoutState";
  public int mAvailable;
  public int mCurrentPosition;
  public int mEndLine = 0;
  public boolean mInfinite;
  public int mItemDirection;
  public int mLayoutDirection;
  public boolean mRecycle = true;
  public int mStartLine = 0;
  public boolean mStopInFocusable;
  
  public LayoutState() {}
  
  public boolean hasMore(RecyclerView.State paramState)
  {
    int i = mCurrentPosition;
    return (i >= 0) && (i < paramState.getItemCount());
  }
  
  public View next(RecyclerView.Recycler paramRecycler)
  {
    paramRecycler = paramRecycler.getViewForPosition(mCurrentPosition);
    mCurrentPosition += mItemDirection;
    return paramRecycler;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("LayoutState{mAvailable=");
    localStringBuilder.append(mAvailable);
    localStringBuilder.append(", mCurrentPosition=");
    localStringBuilder.append(mCurrentPosition);
    localStringBuilder.append(", mItemDirection=");
    localStringBuilder.append(mItemDirection);
    localStringBuilder.append(", mLayoutDirection=");
    localStringBuilder.append(mLayoutDirection);
    localStringBuilder.append(", mStartLine=");
    localStringBuilder.append(mStartLine);
    localStringBuilder.append(", mEndLine=");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, mEndLine, '}');
  }
}
