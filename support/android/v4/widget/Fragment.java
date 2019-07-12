package support.android.v4.widget;

import android.os.Build.VERSION;
import android.widget.AbsListView;
import android.widget.ListView;

public final class Fragment
{
  public Fragment() {}
  
  public static void scrollListBy(ListView paramListView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramListView.scrollListBy(paramInt);
  }
  
  public static boolean update(ListView paramListView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    return paramListView.canScrollList(paramInt);
  }
}
