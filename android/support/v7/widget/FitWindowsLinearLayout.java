package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import b.b.a.N;

@N({b.b.a.N.a.b})
public class FitWindowsLinearLayout
  extends LinearLayout
  implements FitWindowsViewGroup
{
  public FitWindowsViewGroup.OnFitSystemWindowsListener mListener;
  
  public FitWindowsLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FitWindowsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean fitSystemWindows(Rect paramRect)
  {
    FitWindowsViewGroup.OnFitSystemWindowsListener localOnFitSystemWindowsListener = mListener;
    if (localOnFitSystemWindowsListener != null) {
      localOnFitSystemWindowsListener.onFitSystemWindows(paramRect);
    }
    return super.fitSystemWindows(paramRect);
  }
  
  public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener paramOnFitSystemWindowsListener)
  {
    mListener = paramOnFitSystemWindowsListener;
  }
}
