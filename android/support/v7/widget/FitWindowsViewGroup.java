package android.support.v7.widget;

import android.graphics.Rect;
import b.b.a.N;

@N({b.b.a.N.a.b})
public abstract interface FitWindowsViewGroup
{
  public abstract void setOnFitSystemWindowsListener(OnFitSystemWindowsListener paramOnFitSystemWindowsListener);
  
  public static abstract interface OnFitSystemWindowsListener
  {
    public abstract void onFitSystemWindows(Rect paramRect);
  }
}
