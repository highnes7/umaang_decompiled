package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.List;
import support.android.v4.graphics.MathUtils;
import support.android.v4.view.ViewCompat;
import support.android.v4.view.WindowInsetsCompat;

public abstract class HeaderScrollingViewBehavior
  extends ViewOffsetBehavior<View>
{
  public int overlayTop;
  public final Rect tempRect1 = new Rect();
  public final Rect tempRect2 = new Rect();
  public int verticalLayoutGap = 0;
  
  public HeaderScrollingViewBehavior() {}
  
  public HeaderScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static int resolveGravity(int paramInt)
  {
    if (paramInt == 0) {
      return 8388659;
    }
    return paramInt;
  }
  
  public abstract View findFirstDependency(List paramList);
  
  public final int getOverlapPixelsForOffset(View paramView)
  {
    if (overlayTop == 0) {
      return 0;
    }
    float f = getOverlapRatioForOffset(paramView);
    int i = overlayTop;
    return MathUtils.constrain((int)(f * i), 0, i);
  }
  
  public float getOverlapRatioForOffset(View paramView)
  {
    return 1.0F;
  }
  
  public final int getOverlayTop()
  {
    return overlayTop;
  }
  
  public int getScrollRange(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  public final int getVerticalLayoutGap()
  {
    return verticalLayoutGap;
  }
  
  public void layoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    View localView = findFirstDependency(paramCoordinatorLayout.getDependencies(paramView));
    if (localView != null)
    {
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
      Rect localRect = tempRect1;
      int i = paramCoordinatorLayout.getPaddingLeft();
      int j = leftMargin;
      int k = localView.getBottom();
      int m = topMargin;
      int n = paramCoordinatorLayout.getWidth();
      int i1 = paramCoordinatorLayout.getPaddingRight();
      int i2 = rightMargin;
      int i3 = paramCoordinatorLayout.getHeight();
      localRect.set(i + j, k + m, n - i1 - i2, localView.getBottom() + i3 - paramCoordinatorLayout.getPaddingBottom() - bottomMargin);
      WindowInsetsCompat localWindowInsetsCompat = paramCoordinatorLayout.getLastWindowInsets();
      if ((localWindowInsetsCompat != null) && (ViewCompat.getFitsSystemWindows(paramCoordinatorLayout)) && (!ViewCompat.getFitsSystemWindows(paramView)))
      {
        i = left;
        left = (localWindowInsetsCompat.getSystemWindowInsetLeft() + i);
        right -= localWindowInsetsCompat.getSystemWindowInsetRight();
      }
      paramCoordinatorLayout = tempRect2;
      j = gravity;
      i = j;
      if (j == 0) {
        i = 8388659;
      }
      j = paramView.getMeasuredWidth();
      k = paramView.getMeasuredHeight();
      m = Build.VERSION.SDK_INT;
      Gravity.apply(i, j, k, localRect, paramCoordinatorLayout, paramInt);
      paramInt = getOverlapPixelsForOffset(localView);
      paramView.layout(left, top - paramInt, right, bottom - paramInt);
      verticalLayoutGap = (top - localView.getBottom());
      return;
    }
    paramCoordinatorLayout.onLayoutChild(paramView, paramInt);
    verticalLayoutGap = 0;
  }
  
  public boolean onMeasureChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getLayoutParamsheight;
    if ((j == -1) || (j == -2))
    {
      View localView = findFirstDependency(paramCoordinatorLayout.getDependencies(paramView));
      if (localView != null)
      {
        if ((ViewCompat.getFitsSystemWindows(localView)) && (!ViewCompat.getFitsSystemWindows(paramView)))
        {
          ViewCompat.setFitsSystemWindows(paramView, true);
          if (ViewCompat.getFitsSystemWindows(paramView))
          {
            paramView.requestLayout();
            return true;
          }
        }
        int i = View.MeasureSpec.getSize(paramInt3);
        paramInt3 = i;
        if (i == 0) {
          paramInt3 = paramCoordinatorLayout.getHeight();
        }
        int k = localView.getMeasuredHeight();
        int m = getScrollRange(localView);
        if (j == -1) {
          i = 1073741824;
        } else {
          i = Integer.MIN_VALUE;
        }
        paramCoordinatorLayout.onMeasureChild(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(m + (paramInt3 - k), i), paramInt4);
        return true;
      }
    }
    return false;
  }
  
  public final void setOverlayTop(int paramInt)
  {
    overlayTop = paramInt;
  }
}
