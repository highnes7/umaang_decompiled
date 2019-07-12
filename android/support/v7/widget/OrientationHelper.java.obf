package android.support.v7.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public abstract class OrientationHelper
{
  public static final int HORIZONTAL = 0;
  public static final int INVALID_SIZE = Integer.MIN_VALUE;
  public static final int VERTICAL = 1;
  public int mLastTotalSpace = Integer.MIN_VALUE;
  public final RecyclerView.LayoutManager mLayoutManager;
  public final Rect mTmpRect = new Rect();
  
  public OrientationHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    mLayoutManager = paramLayoutManager;
  }
  
  public static OrientationHelper createHorizontalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    new OrientationHelper(paramLayoutManager)
    {
      public int getDecoratedEnd(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return mLayoutManager.getDecoratedRight(paramAnonymousView) + rightMargin;
      }
      
      public int getDecoratedMeasurement(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return mLayoutManager.getDecoratedMeasuredWidth(paramAnonymousView) + leftMargin + rightMargin;
      }
      
      public int getDecoratedMeasurementInOther(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return mLayoutManager.getDecoratedMeasuredHeight(paramAnonymousView) + topMargin + bottomMargin;
      }
      
      public int getDecoratedStart(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return mLayoutManager.getDecoratedLeft(paramAnonymousView) - leftMargin;
      }
      
      public int getEnd()
      {
        return mLayoutManager.getWidth();
      }
      
      public int getEndAfterPadding()
      {
        return mLayoutManager.getWidth() - mLayoutManager.getPaddingRight();
      }
      
      public int getEndPadding()
      {
        return mLayoutManager.getPaddingRight();
      }
      
      public int getMode()
      {
        return mLayoutManager.getWidthMode();
      }
      
      public int getModeInOther()
      {
        return mLayoutManager.getHeightMode();
      }
      
      public int getStartAfterPadding()
      {
        return mLayoutManager.getPaddingLeft();
      }
      
      public int getTotalSpace()
      {
        return mLayoutManager.getWidth() - mLayoutManager.getPaddingLeft() - mLayoutManager.getPaddingRight();
      }
      
      public int getTransformedEndWithDecoration(View paramAnonymousView)
      {
        mLayoutManager.getTransformedBoundingBox(paramAnonymousView, true, mTmpRect);
        return mTmpRect.right;
      }
      
      public int getTransformedStartWithDecoration(View paramAnonymousView)
      {
        mLayoutManager.getTransformedBoundingBox(paramAnonymousView, true, mTmpRect);
        return mTmpRect.left;
      }
      
      public void offsetChild(View paramAnonymousView, int paramAnonymousInt)
      {
        paramAnonymousView.offsetLeftAndRight(paramAnonymousInt);
      }
      
      public void offsetChildren(int paramAnonymousInt)
      {
        mLayoutManager.offsetChildrenHorizontal(paramAnonymousInt);
      }
    };
  }
  
  public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager paramLayoutManager, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        new OrientationHelper(paramLayoutManager)
        {
          public int getDecoratedEnd(View paramAnonymousView)
          {
            RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
            return mLayoutManager.getDecoratedBottom(paramAnonymousView) + bottomMargin;
          }
          
          public int getDecoratedMeasurement(View paramAnonymousView)
          {
            RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
            return mLayoutManager.getDecoratedMeasuredHeight(paramAnonymousView) + topMargin + bottomMargin;
          }
          
          public int getDecoratedMeasurementInOther(View paramAnonymousView)
          {
            RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
            return mLayoutManager.getDecoratedMeasuredWidth(paramAnonymousView) + leftMargin + rightMargin;
          }
          
          public int getDecoratedStart(View paramAnonymousView)
          {
            RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
            return mLayoutManager.getDecoratedTop(paramAnonymousView) - topMargin;
          }
          
          public int getEnd()
          {
            return mLayoutManager.getHeight();
          }
          
          public int getEndAfterPadding()
          {
            return mLayoutManager.getHeight() - mLayoutManager.getPaddingBottom();
          }
          
          public int getEndPadding()
          {
            return mLayoutManager.getPaddingBottom();
          }
          
          public int getMode()
          {
            return mLayoutManager.getHeightMode();
          }
          
          public int getModeInOther()
          {
            return mLayoutManager.getWidthMode();
          }
          
          public int getStartAfterPadding()
          {
            return mLayoutManager.getPaddingTop();
          }
          
          public int getTotalSpace()
          {
            return mLayoutManager.getHeight() - mLayoutManager.getPaddingTop() - mLayoutManager.getPaddingBottom();
          }
          
          public int getTransformedEndWithDecoration(View paramAnonymousView)
          {
            mLayoutManager.getTransformedBoundingBox(paramAnonymousView, true, mTmpRect);
            return mTmpRect.bottom;
          }
          
          public int getTransformedStartWithDecoration(View paramAnonymousView)
          {
            mLayoutManager.getTransformedBoundingBox(paramAnonymousView, true, mTmpRect);
            return mTmpRect.top;
          }
          
          public void offsetChild(View paramAnonymousView, int paramAnonymousInt)
          {
            paramAnonymousView.offsetTopAndBottom(paramAnonymousInt);
          }
          
          public void offsetChildren(int paramAnonymousInt)
          {
            mLayoutManager.offsetChildrenVertical(paramAnonymousInt);
          }
        };
      }
      throw new IllegalArgumentException("invalid orientation");
    }
    new OrientationHelper(paramLayoutManager)
    {
      public int getDecoratedEnd(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return mLayoutManager.getDecoratedRight(paramAnonymousView) + rightMargin;
      }
      
      public int getDecoratedMeasurement(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return mLayoutManager.getDecoratedMeasuredWidth(paramAnonymousView) + leftMargin + rightMargin;
      }
      
      public int getDecoratedMeasurementInOther(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return mLayoutManager.getDecoratedMeasuredHeight(paramAnonymousView) + topMargin + bottomMargin;
      }
      
      public int getDecoratedStart(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return mLayoutManager.getDecoratedLeft(paramAnonymousView) - leftMargin;
      }
      
      public int getEnd()
      {
        return mLayoutManager.getWidth();
      }
      
      public int getEndAfterPadding()
      {
        return mLayoutManager.getWidth() - mLayoutManager.getPaddingRight();
      }
      
      public int getEndPadding()
      {
        return mLayoutManager.getPaddingRight();
      }
      
      public int getMode()
      {
        return mLayoutManager.getWidthMode();
      }
      
      public int getModeInOther()
      {
        return mLayoutManager.getHeightMode();
      }
      
      public int getStartAfterPadding()
      {
        return mLayoutManager.getPaddingLeft();
      }
      
      public int getTotalSpace()
      {
        return mLayoutManager.getWidth() - mLayoutManager.getPaddingLeft() - mLayoutManager.getPaddingRight();
      }
      
      public int getTransformedEndWithDecoration(View paramAnonymousView)
      {
        mLayoutManager.getTransformedBoundingBox(paramAnonymousView, true, mTmpRect);
        return mTmpRect.right;
      }
      
      public int getTransformedStartWithDecoration(View paramAnonymousView)
      {
        mLayoutManager.getTransformedBoundingBox(paramAnonymousView, true, mTmpRect);
        return mTmpRect.left;
      }
      
      public void offsetChild(View paramAnonymousView, int paramAnonymousInt)
      {
        paramAnonymousView.offsetLeftAndRight(paramAnonymousInt);
      }
      
      public void offsetChildren(int paramAnonymousInt)
      {
        mLayoutManager.offsetChildrenHorizontal(paramAnonymousInt);
      }
    };
  }
  
  public static OrientationHelper createVerticalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    new OrientationHelper(paramLayoutManager)
    {
      public int getDecoratedEnd(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return mLayoutManager.getDecoratedBottom(paramAnonymousView) + bottomMargin;
      }
      
      public int getDecoratedMeasurement(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return mLayoutManager.getDecoratedMeasuredHeight(paramAnonymousView) + topMargin + bottomMargin;
      }
      
      public int getDecoratedMeasurementInOther(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return mLayoutManager.getDecoratedMeasuredWidth(paramAnonymousView) + leftMargin + rightMargin;
      }
      
      public int getDecoratedStart(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return mLayoutManager.getDecoratedTop(paramAnonymousView) - topMargin;
      }
      
      public int getEnd()
      {
        return mLayoutManager.getHeight();
      }
      
      public int getEndAfterPadding()
      {
        return mLayoutManager.getHeight() - mLayoutManager.getPaddingBottom();
      }
      
      public int getEndPadding()
      {
        return mLayoutManager.getPaddingBottom();
      }
      
      public int getMode()
      {
        return mLayoutManager.getHeightMode();
      }
      
      public int getModeInOther()
      {
        return mLayoutManager.getWidthMode();
      }
      
      public int getStartAfterPadding()
      {
        return mLayoutManager.getPaddingTop();
      }
      
      public int getTotalSpace()
      {
        return mLayoutManager.getHeight() - mLayoutManager.getPaddingTop() - mLayoutManager.getPaddingBottom();
      }
      
      public int getTransformedEndWithDecoration(View paramAnonymousView)
      {
        mLayoutManager.getTransformedBoundingBox(paramAnonymousView, true, mTmpRect);
        return mTmpRect.bottom;
      }
      
      public int getTransformedStartWithDecoration(View paramAnonymousView)
      {
        mLayoutManager.getTransformedBoundingBox(paramAnonymousView, true, mTmpRect);
        return mTmpRect.top;
      }
      
      public void offsetChild(View paramAnonymousView, int paramAnonymousInt)
      {
        paramAnonymousView.offsetTopAndBottom(paramAnonymousInt);
      }
      
      public void offsetChildren(int paramAnonymousInt)
      {
        mLayoutManager.offsetChildrenVertical(paramAnonymousInt);
      }
    };
  }
  
  public abstract int getDecoratedEnd(View paramView);
  
  public abstract int getDecoratedMeasurement(View paramView);
  
  public abstract int getDecoratedMeasurementInOther(View paramView);
  
  public abstract int getDecoratedStart(View paramView);
  
  public abstract int getEnd();
  
  public abstract int getEndAfterPadding();
  
  public abstract int getEndPadding();
  
  public RecyclerView.LayoutManager getLayoutManager()
  {
    return mLayoutManager;
  }
  
  public abstract int getMode();
  
  public abstract int getModeInOther();
  
  public abstract int getStartAfterPadding();
  
  public abstract int getTotalSpace();
  
  public int getTotalSpaceChange()
  {
    if (Integer.MIN_VALUE == mLastTotalSpace) {
      return 0;
    }
    return getTotalSpace() - mLastTotalSpace;
  }
  
  public abstract int getTransformedEndWithDecoration(View paramView);
  
  public abstract int getTransformedStartWithDecoration(View paramView);
  
  public abstract void offsetChild(View paramView, int paramInt);
  
  public abstract void offsetChildren(int paramInt);
  
  public void onLayoutComplete()
  {
    mLastTotalSpace = getTotalSpace();
  }
}
