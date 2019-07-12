package support.android.v4.widget;

import android.os.Build.VERSION;
import android.view.View.OnTouchListener;

public final class PopupMenu
{
  public PopupMenu() {}
  
  public static View.OnTouchListener getDragToOpenListener(Object paramObject)
  {
    int i = Build.VERSION.SDK_INT;
    return ((android.widget.PopupMenu)paramObject).getDragToOpenListener();
  }
}
