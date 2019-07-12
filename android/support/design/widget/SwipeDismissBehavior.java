package android.support.design.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import support.android.v4.view.ViewCompat;
import support.android.v4.widget.ViewDragHelper;
import support.android.v4.widget.ViewDragHelper.Callback;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  public static final float DEFAULT_ALPHA_END_DISTANCE = 0.5F;
  public static final float DEFAULT_ALPHA_START_DISTANCE = 0.0F;
  public static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5F;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  public static final int SWIPE_DIRECTION_ANY = 2;
  public static final int SWIPE_DIRECTION_END_TO_START = 1;
  public static final int SWIPE_DIRECTION_START_TO_END = 0;
  public float alphaEndSwipeDistance = 0.5F;
  public float alphaStartSwipeDistance = 0.0F;
  public final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback()
  {
    public static final int INVALID_POINTER_ID = -1;
    public int activePointerId = -1;
    public int originalCapturedViewLeft;
    
    private boolean shouldDismiss(View paramAnonymousView, float paramAnonymousFloat)
    {
      int i;
      int j;
      if (paramAnonymousFloat != 0.0F)
      {
        if (ViewCompat.getLayoutDirection(paramAnonymousView) == 1) {
          i = 1;
        } else {
          i = 0;
        }
        j = swipeDirection;
        if (j == 2) {
          return true;
        }
        if (j == 0)
        {
          if (i != 0 ? paramAnonymousFloat < 0.0F : paramAnonymousFloat > 0.0F) {
            return true;
          }
        }
        else if ((j == 1) && (i != 0 ? paramAnonymousFloat > 0.0F : paramAnonymousFloat < 0.0F)) {
          return true;
        }
      }
      else
      {
        i = paramAnonymousView.getLeft();
        j = originalCapturedViewLeft;
        int k = Math.round(paramAnonymousView.getWidth() * dragDismissThreshold);
        if (Math.abs(i - j) >= k) {
          return true;
        }
      }
      return false;
    }
    
    public int clampViewPositionHorizontal(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (ViewCompat.getLayoutDirection(paramAnonymousView) == 1) {
        paramAnonymousInt2 = 1;
      } else {
        paramAnonymousInt2 = 0;
      }
      int i = swipeDirection;
      if (i == 0)
      {
        if (paramAnonymousInt2 != 0)
        {
          i = originalCapturedViewLeft - paramAnonymousView.getWidth();
          paramAnonymousInt2 = originalCapturedViewLeft;
        }
        else
        {
          i = originalCapturedViewLeft;
        }
      }
      else
      {
        for (paramAnonymousInt2 = paramAnonymousView.getWidth();; paramAnonymousInt2 = paramAnonymousView.getWidth())
        {
          paramAnonymousInt2 += i;
          break label137;
          if (i != 1) {
            break label114;
          }
          if (paramAnonymousInt2 == 0) {
            break;
          }
          i = originalCapturedViewLeft;
        }
        i = originalCapturedViewLeft - paramAnonymousView.getWidth();
        paramAnonymousInt2 = originalCapturedViewLeft;
        break label137;
        label114:
        i = originalCapturedViewLeft - paramAnonymousView.getWidth();
        paramAnonymousInt2 = originalCapturedViewLeft;
        paramAnonymousInt2 = paramAnonymousView.getWidth() + paramAnonymousInt2;
      }
      label137:
      return SwipeDismissBehavior.clamp(i, paramAnonymousInt1, paramAnonymousInt2);
    }
    
    public int clampViewPositionVertical(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousView.getTop();
    }
    
    public int getViewHorizontalDragRange(View paramAnonymousView)
    {
      return paramAnonymousView.getWidth();
    }
    
    public void onViewCaptured(View paramAnonymousView, int paramAnonymousInt)
    {
      activePointerId = paramAnonymousInt;
      originalCapturedViewLeft = paramAnonymousView.getLeft();
      paramAnonymousView = paramAnonymousView.getParent();
      if (paramAnonymousView != null) {
        paramAnonymousView.requestDisallowInterceptTouchEvent(true);
      }
    }
    
    public void onViewDragStateChanged(int paramAnonymousInt)
    {
      SwipeDismissBehavior.OnDismissListener localOnDismissListener = listener;
      if (localOnDismissListener != null) {
        localOnDismissListener.onDragStateChanged(paramAnonymousInt);
      }
    }
    
    public void onViewPositionChanged(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      float f1 = originalCapturedViewLeft;
      f1 = paramAnonymousView.getWidth() * alphaStartSwipeDistance + f1;
      float f2 = originalCapturedViewLeft;
      f2 = paramAnonymousView.getWidth() * alphaEndSwipeDistance + f2;
      float f3 = paramAnonymousInt1;
      if (f3 <= f1)
      {
        paramAnonymousView.setAlpha(1.0F);
        return;
      }
      if (f3 >= f2)
      {
        paramAnonymousView.setAlpha(0.0F);
        return;
      }
      paramAnonymousView.setAlpha(SwipeDismissBehavior.clamp(0.0F, 1.0F - SwipeDismissBehavior.fraction(f1, f2, f3), 1.0F));
    }
    
    public void onViewReleased(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      activePointerId = -1;
      int i = paramAnonymousView.getWidth();
      boolean bool;
      if (shouldDismiss(paramAnonymousView, paramAnonymousFloat1))
      {
        int j = paramAnonymousView.getLeft();
        int k = originalCapturedViewLeft;
        if (j < k) {
          i = k - i;
        } else {
          i = k + i;
        }
        bool = true;
      }
      else
      {
        i = originalCapturedViewLeft;
        bool = false;
      }
      if (viewDragHelper.settleCapturedViewAt(i, paramAnonymousView.getTop()))
      {
        ViewCompat.postOnAnimation(paramAnonymousView, new SwipeDismissBehavior.SettleRunnable(SwipeDismissBehavior.this, paramAnonymousView, bool));
        return;
      }
      if (bool)
      {
        SwipeDismissBehavior.OnDismissListener localOnDismissListener = listener;
        if (localOnDismissListener != null) {
          localOnDismissListener.onDismiss(paramAnonymousView);
        }
      }
    }
    
    public boolean tryCaptureView(View paramAnonymousView, int paramAnonymousInt)
    {
      return (activePointerId == -1) && (canSwipeDismissView(paramAnonymousView));
    }
  };
  public float dragDismissThreshold = 0.5F;
  public boolean interceptingEvents;
  public OnDismissListener listener;
  public float sensitivity = 0.0F;
  public boolean sensitivitySet;
  public int swipeDirection = 2;
  public ViewDragHelper viewDragHelper;
  
  public SwipeDismissBehavior() {}
  
  public static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  public static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  private void ensureViewDragHelper(ViewGroup paramViewGroup)
  {
    if (viewDragHelper == null)
    {
      if (sensitivitySet) {
        paramViewGroup = ViewDragHelper.create(paramViewGroup, sensitivity, dragCallback);
      } else {
        paramViewGroup = ViewDragHelper.create(paramViewGroup, dragCallback);
      }
      viewDragHelper = paramViewGroup;
    }
  }
  
  public static float fraction(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  public boolean canSwipeDismissView(View paramView)
  {
    return true;
  }
  
  public int getDragState()
  {
    ViewDragHelper localViewDragHelper = viewDragHelper;
    if (localViewDragHelper != null) {
      return localViewDragHelper.getViewDragState();
    }
    return 0;
  }
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = interceptingEvents;
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        interceptingEvents = false;
      }
    }
    else
    {
      interceptingEvents = paramCoordinatorLayout.isPointInChildBounds(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool = interceptingEvents;
    }
    if (bool)
    {
      ensureViewDragHelper(paramCoordinatorLayout);
      return viewDragHelper.shouldInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    paramCoordinatorLayout = viewDragHelper;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.processTouchEvent(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public void setDragDismissDistance(float paramFloat)
  {
    dragDismissThreshold = clamp(0.0F, paramFloat, 1.0F);
  }
  
  public void setEndAlphaSwipeDistance(float paramFloat)
  {
    alphaEndSwipeDistance = clamp(0.0F, paramFloat, 1.0F);
  }
  
  public void setListener(OnDismissListener paramOnDismissListener)
  {
    listener = paramOnDismissListener;
  }
  
  public void setSensitivity(float paramFloat)
  {
    sensitivity = paramFloat;
    sensitivitySet = true;
  }
  
  public void setStartAlphaSwipeDistance(float paramFloat)
  {
    alphaStartSwipeDistance = clamp(0.0F, paramFloat, 1.0F);
  }
  
  public void setSwipeDirection(int paramInt)
  {
    swipeDirection = paramInt;
  }
  
  public static abstract interface OnDismissListener
  {
    public abstract void onDismiss(View paramView);
    
    public abstract void onDragStateChanged(int paramInt);
  }
  
  private class SettleRunnable
    implements Runnable
  {
    public final boolean dismiss;
    public final View view;
    
    public SettleRunnable(View paramView, boolean paramBoolean)
    {
      view = paramView;
      dismiss = paramBoolean;
    }
    
    public void run()
    {
      Object localObject = viewDragHelper;
      if ((localObject != null) && (((ViewDragHelper)localObject).continueSettling(true)))
      {
        ViewCompat.postOnAnimation(view, this);
        return;
      }
      if (dismiss)
      {
        localObject = listener;
        if (localObject != null) {
          ((SwipeDismissBehavior.OnDismissListener)localObject).onDismiss(view);
        }
      }
    }
  }
}
