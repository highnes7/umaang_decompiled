package support.android.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnTouchListener;

public final class ListPopupWindow
{
  public ListPopupWindow() {}
  
  public static View.OnTouchListener createDragToOpenListener(android.widget.ListPopupWindow paramListPopupWindow, View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramListPopupWindow.createDragToOpenListener(paramView);
  }
  
  public static View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView)
  {
    return createDragToOpenListener((android.widget.ListPopupWindow)paramObject, paramView);
  }
}
