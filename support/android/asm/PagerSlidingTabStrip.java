package support.android.asm;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;

@SuppressLint({"ViewConstructor"})
public class PagerSlidingTabStrip
  extends View
  implements b
{
  public View c;
  public int icon;
  public int k;
  public final ViewTreeObserver.OnPreDrawListener mPreDrawListener = new FloatingActionButton.2(this);
  public final Matrix matrix = new Matrix();
  public ViewGroup s;
  public Matrix savedMatrix;
  public int subtitle;
  public final View view;
  
  public PagerSlidingTabStrip(View paramView)
  {
    super(paramView.getContext());
    view = paramView;
    setLayerType(2, null);
  }
  
  public static FrameLayout a(ViewGroup paramViewGroup)
  {
    while (!(paramViewGroup instanceof FrameLayout))
    {
      paramViewGroup = paramViewGroup.getParent();
      if (!(paramViewGroup instanceof ViewGroup)) {
        return null;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
    }
    return (FrameLayout)paramViewGroup;
  }
  
  public static b a(View paramView, ViewGroup paramViewGroup)
  {
    PagerSlidingTabStrip localPagerSlidingTabStrip2 = onSaveInstanceState(paramView);
    PagerSlidingTabStrip localPagerSlidingTabStrip1 = localPagerSlidingTabStrip2;
    if (localPagerSlidingTabStrip2 == null)
    {
      paramViewGroup = a(paramViewGroup);
      if (paramViewGroup == null) {
        return null;
      }
      localPagerSlidingTabStrip1 = new PagerSlidingTabStrip(paramView);
      paramViewGroup.addView(localPagerSlidingTabStrip1);
    }
    k += 1;
    return localPagerSlidingTabStrip1;
  }
  
  public static void a(View paramView)
  {
    paramView = onSaveInstanceState(paramView);
    if (paramView != null)
    {
      k -= 1;
      if (k <= 0)
      {
        Object localObject = paramView.getParent();
        if ((localObject instanceof ViewGroup))
        {
          localObject = (ViewGroup)localObject;
          ((ViewGroup)localObject).endViewTransition(paramView);
          ((ViewGroup)localObject).removeView(paramView);
        }
      }
    }
  }
  
  public static void onDraw(View paramView, PagerSlidingTabStrip paramPagerSlidingTabStrip)
  {
    paramView.setTag(R.id.ghost_view, paramPagerSlidingTabStrip);
  }
  
  public static PagerSlidingTabStrip onSaveInstanceState(View paramView)
  {
    return (PagerSlidingTabStrip)paramView.getTag(R.id.ghost_view);
  }
  
  public void a(ViewGroup paramViewGroup, View paramView)
  {
    s = paramViewGroup;
    c = paramView;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    view.setTag(R.id.ghost_view, this);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    view.getLocationOnScreen(arrayOfInt2);
    arrayOfInt2[0] = ((int)(arrayOfInt2[0] - view.getTranslationX()));
    arrayOfInt2[1] = ((int)(arrayOfInt2[1] - view.getTranslationY()));
    subtitle = (arrayOfInt2[0] - arrayOfInt1[0]);
    icon = (arrayOfInt2[1] - arrayOfInt1[1]);
    view.getViewTreeObserver().addOnPreDrawListener(mPreDrawListener);
    view.setVisibility(4);
  }
  
  public void onDetachedFromWindow()
  {
    view.getViewTreeObserver().removeOnPreDrawListener(mPreDrawListener);
    view.setVisibility(0);
    view.setTag(R.id.ghost_view, null);
    super.onDetachedFromWindow();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    matrix.set(savedMatrix);
    matrix.postTranslate(subtitle, icon);
    paramCanvas.setMatrix(matrix);
    view.draw(paramCanvas);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    View localView = view;
    if (paramInt == 0) {
      paramInt = 4;
    } else {
      paramInt = 0;
    }
    localView.setVisibility(paramInt);
  }
}
