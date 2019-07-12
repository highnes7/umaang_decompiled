package support.android.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public final class ViewParentCompat
{
  public static final String TAG = "ViewParentCompat";
  
  public ViewParentCompat() {}
  
  public static void notifySubtreeAccessibilityStateChanged(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramViewParent.notifySubtreeAccessibilityStateChanged(paramView1, paramView2, paramInt);
  }
  
  public static boolean onNestedFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      paramBoolean = paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      return paramBoolean;
    }
    catch (AbstractMethodError paramView)
    {
      for (;;) {}
    }
    paramView = new StringBuilder();
    paramView.append("ViewParent ");
    paramView.append(paramViewParent);
    paramView.append(" does not implement interface ");
    paramView.append("method onNestedFling");
    paramView.toString();
    break label89;
    if ((paramViewParent instanceof NestedScrollingParent)) {
      return ((NestedScrollingParent)paramViewParent).onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    }
    label89:
    return false;
  }
  
  public static boolean onNestedPreFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      boolean bool = paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
      return bool;
    }
    catch (AbstractMethodError paramView)
    {
      for (;;) {}
    }
    paramView = new StringBuilder();
    paramView.append("ViewParent ");
    paramView.append(paramViewParent);
    paramView.append(" does not implement interface ");
    paramView.append("method onNestedPreFling");
    paramView.toString();
    break label85;
    if ((paramViewParent instanceof NestedScrollingParent)) {
      return ((NestedScrollingParent)paramViewParent).onNestedPreFling(paramView, paramFloat1, paramFloat2);
    }
    label85:
    return false;
  }
  
  public static void onNestedPreScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    onNestedPreScroll(paramViewParent, paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public static void onNestedPreScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if ((paramViewParent instanceof ViewParentCompat.ViewParentCompatImpl))
    {
      ((ViewParentCompat.ViewParentCompatImpl)paramViewParent).onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
      return;
    }
    if (paramInt3 == 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {}
      try
      {
        paramViewParent.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
        return;
      }
      catch (AbstractMethodError paramView)
      {
        for (;;) {}
      }
      paramView = new StringBuilder();
      paramView.append("ViewParent ");
      paramView.append(paramViewParent);
      paramView.append(" does not implement interface ");
      paramView.append("method onNestedPreScroll");
      paramView.toString();
      return;
      if ((paramViewParent instanceof NestedScrollingParent))
      {
        ((NestedScrollingParent)paramViewParent).onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
        return;
      }
    }
  }
  
  public static void onNestedScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onNestedScroll(paramViewParent, paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public static void onNestedScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramViewParent instanceof ViewParentCompat.ViewParentCompatImpl))
    {
      ((ViewParentCompat.ViewParentCompatImpl)paramViewParent).onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      return;
    }
    if (paramInt5 == 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {}
      try
      {
        paramViewParent.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      catch (AbstractMethodError paramView)
      {
        for (;;) {}
      }
      paramView = new StringBuilder();
      paramView.append("ViewParent ");
      paramView.append(paramViewParent);
      paramView.append(" does not implement interface ");
      paramView.append("method onNestedScroll");
      paramView.toString();
      return;
      if ((paramViewParent instanceof NestedScrollingParent))
      {
        ((NestedScrollingParent)paramViewParent).onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
    }
  }
  
  public static void onNestedScrollAccepted(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
  {
    onNestedScrollAccepted(paramViewParent, paramView1, paramView2, paramInt, 0);
  }
  
  public static void onNestedScrollAccepted(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof ViewParentCompat.ViewParentCompatImpl))
    {
      ((ViewParentCompat.ViewParentCompatImpl)paramViewParent).onNestedScrollAccepted(paramView1, paramView2, paramInt1, paramInt2);
      return;
    }
    if (paramInt2 == 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {}
      try
      {
        paramViewParent.onNestedScrollAccepted(paramView1, paramView2, paramInt1);
        return;
      }
      catch (AbstractMethodError paramView1)
      {
        for (;;) {}
      }
      paramView1 = new StringBuilder();
      paramView1.append("ViewParent ");
      paramView1.append(paramViewParent);
      paramView1.append(" does not implement interface ");
      paramView1.append("method onNestedScrollAccepted");
      paramView1.toString();
      return;
      if ((paramViewParent instanceof NestedScrollingParent))
      {
        ((NestedScrollingParent)paramViewParent).onNestedScrollAccepted(paramView1, paramView2, paramInt1);
        return;
      }
    }
  }
  
  public static boolean onStartNestedScroll(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
  {
    return onStartNestedScroll(paramViewParent, paramView1, paramView2, paramInt, 0);
  }
  
  public static boolean onStartNestedScroll(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof ViewParentCompat.ViewParentCompatImpl)) {
      return ((ViewParentCompat.ViewParentCompatImpl)paramViewParent).onStartNestedScroll(paramView1, paramView2, paramInt1, paramInt2);
    }
    if ((paramInt2 != 0) || (Build.VERSION.SDK_INT >= 21)) {}
    try
    {
      boolean bool = paramViewParent.onStartNestedScroll(paramView1, paramView2, paramInt1);
      return bool;
    }
    catch (AbstractMethodError paramView1)
    {
      for (;;) {}
    }
    paramView1 = new StringBuilder();
    paramView1.append("ViewParent ");
    paramView1.append(paramViewParent);
    paramView1.append(" does not implement interface ");
    paramView1.append("method onStartNestedScroll");
    paramView1.toString();
    break label112;
    if ((paramViewParent instanceof NestedScrollingParent)) {
      return ((NestedScrollingParent)paramViewParent).onStartNestedScroll(paramView1, paramView2, paramInt1);
    }
    label112:
    return false;
  }
  
  public static void onStopNestedScroll(ViewParent paramViewParent, View paramView)
  {
    onStopNestedScroll(paramViewParent, paramView, 0);
  }
  
  public static void onStopNestedScroll(ViewParent paramViewParent, View paramView, int paramInt)
  {
    if ((paramViewParent instanceof ViewParentCompat.ViewParentCompatImpl))
    {
      ((ViewParentCompat.ViewParentCompatImpl)paramViewParent).onStopNestedScroll(paramView, paramInt);
      return;
    }
    if (paramInt == 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {}
      try
      {
        paramViewParent.onStopNestedScroll(paramView);
        return;
      }
      catch (AbstractMethodError paramView)
      {
        for (;;) {}
      }
      paramView = new StringBuilder();
      paramView.append("ViewParent ");
      paramView.append(paramViewParent);
      paramView.append(" does not implement interface ");
      paramView.append("method onStopNestedScroll");
      paramView.toString();
      return;
      if ((paramViewParent instanceof NestedScrollingParent))
      {
        ((NestedScrollingParent)paramViewParent).onStopNestedScroll(paramView);
        return;
      }
    }
  }
  
  public static boolean requestSendAccessibilityEvent(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return paramViewParent.requestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
}
