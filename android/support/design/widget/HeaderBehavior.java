package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import support.android.v4.graphics.MathUtils;
import support.android.v4.view.ViewCompat;

public abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  public static final int INVALID_POINTER = -1;
  public int activePointerId = -1;
  public Runnable flingRunnable;
  public boolean isBeingDragged;
  public int lastMotionY;
  public OverScroller scroller;
  public int touchSlop = -1;
  public VelocityTracker velocityTracker;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void ensureVelocityTracker()
  {
    if (velocityTracker == null) {
      velocityTracker = VelocityTracker.obtain();
    }
  }
  
  public boolean canDragView(View paramView)
  {
    return false;
  }
  
  public final boolean fling(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, float paramFloat)
  {
    Runnable localRunnable = flingRunnable;
    if (localRunnable != null)
    {
      paramView.removeCallbacks(localRunnable);
      flingRunnable = null;
    }
    if (scroller == null) {
      scroller = new OverScroller(paramView.getContext());
    }
    scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(paramFloat), 0, 0, paramInt1, paramInt2);
    if (scroller.computeScrollOffset())
    {
      flingRunnable = new FlingRunnable(paramCoordinatorLayout, paramView);
      ViewCompat.postOnAnimation(paramView, flingRunnable);
      return true;
    }
    onFlingFinished(paramCoordinatorLayout, paramView);
    return false;
  }
  
  public int getMaxDragOffset(View paramView)
  {
    return -paramView.getHeight();
  }
  
  public int getScrollRangeForDragFling(View paramView)
  {
    return paramView.getHeight();
  }
  
  public int getTopBottomOffsetForScrollingSibling()
  {
    return getTopAndBottomOffset();
  }
  
  public void onFlingFinished(CoordinatorLayout paramCoordinatorLayout, View paramView) {}
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    if (touchSlop < 0) {
      touchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (isBeingDragged)) {
      return true;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label231;
          }
        }
        else
        {
          i = activePointerId;
          if (i == -1) {
            break label231;
          }
          i = paramMotionEvent.findPointerIndex(i);
          if (i == -1) {
            break label231;
          }
          i = (int)paramMotionEvent.getY(i);
          if (Math.abs(i - lastMotionY) <= touchSlop) {
            break label231;
          }
          isBeingDragged = true;
          lastMotionY = i;
          break label231;
        }
      }
      isBeingDragged = false;
      activePointerId = -1;
      paramCoordinatorLayout = velocityTracker;
      if (paramCoordinatorLayout != null)
      {
        paramCoordinatorLayout.recycle();
        velocityTracker = null;
      }
    }
    else
    {
      isBeingDragged = false;
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((canDragView(paramView)) && (paramCoordinatorLayout.isPointInChildBounds(paramView, i, j)))
      {
        lastMotionY = j;
        activePointerId = paramMotionEvent.getPointerId(0);
        ensureVelocityTracker();
      }
    }
    label231:
    paramCoordinatorLayout = velocityTracker;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    return isBeingDragged;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    if (touchSlop < 0) {
      touchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i = paramMotionEvent.getActionMasked();
    int j;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            break label322;
          }
        }
        else
        {
          i = paramMotionEvent.findPointerIndex(activePointerId);
          if (i == -1) {
            return false;
          }
          int k = (int)paramMotionEvent.getY(i);
          j = lastMotionY - k;
          i = j;
          if (!isBeingDragged)
          {
            int m = Math.abs(j);
            int n = touchSlop;
            i = j;
            if (m > n)
            {
              isBeingDragged = true;
              if (j > 0) {
                i = j - n;
              } else {
                i = j + n;
              }
            }
          }
          if (!isBeingDragged) {
            break label322;
          }
          lastMotionY = k;
          scroll(paramCoordinatorLayout, paramView, i, getMaxDragOffset(paramView), 0);
          break label322;
        }
      }
      else
      {
        VelocityTracker localVelocityTracker = velocityTracker;
        if (localVelocityTracker != null)
        {
          localVelocityTracker.addMovement(paramMotionEvent);
          velocityTracker.computeCurrentVelocity(1000);
          float f = velocityTracker.getYVelocity(activePointerId);
          fling(paramCoordinatorLayout, paramView, -getScrollRangeForDragFling(paramView), 0, f);
        }
      }
      isBeingDragged = false;
      activePointerId = -1;
      paramCoordinatorLayout = velocityTracker;
      if (paramCoordinatorLayout != null)
      {
        paramCoordinatorLayout.recycle();
        velocityTracker = null;
      }
    }
    else
    {
      i = (int)paramMotionEvent.getX();
      j = (int)paramMotionEvent.getY();
      if ((!paramCoordinatorLayout.isPointInChildBounds(paramView, i, j)) || (!canDragView(paramView))) {
        break label338;
      }
      lastMotionY = j;
      activePointerId = paramMotionEvent.getPointerId(0);
      ensureVelocityTracker();
    }
    label322:
    paramCoordinatorLayout = velocityTracker;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
      return true;
      label338:
      return false;
    }
    return true;
  }
  
  public final int scroll(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramView, getTopBottomOffsetForScrollingSibling() - paramInt1, paramInt2, paramInt3);
  }
  
  public int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramView, paramInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  public int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getTopAndBottomOffset();
    if ((paramInt2 != 0) && (i >= paramInt2) && (i <= paramInt3))
    {
      paramInt1 = MathUtils.constrain(paramInt1, paramInt2, paramInt3);
      if (i != paramInt1)
      {
        setTopAndBottomOffset(paramInt1);
        return i - paramInt1;
      }
    }
    return 0;
  }
  
  private class FlingRunnable
    implements Runnable
  {
    public final V layout;
    public final CoordinatorLayout parent;
    
    public FlingRunnable(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      parent = paramCoordinatorLayout;
      layout = paramView;
    }
    
    public void run()
    {
      if (layout != null)
      {
        Object localObject = scroller;
        if (localObject != null)
        {
          if (((OverScroller)localObject).computeScrollOffset())
          {
            localObject = HeaderBehavior.this;
            ((HeaderBehavior)localObject).setHeaderTopBottomOffset(parent, layout, scroller.getCurrY());
            ViewCompat.postOnAnimation(layout, this);
            return;
          }
          onFlingFinished(parent, layout);
        }
      }
    }
  }
}
