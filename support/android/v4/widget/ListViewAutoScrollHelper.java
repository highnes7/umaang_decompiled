package support.android.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListViewAutoScrollHelper
  extends AutoScrollHelper
{
  public final ListView mTarget;
  
  public ListViewAutoScrollHelper(ListView paramListView)
  {
    super(paramListView);
    mTarget = paramListView;
  }
  
  public boolean canTargetScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public boolean canTargetScrollVertically(int paramInt)
  {
    ListView localListView = mTarget;
    int i = localListView.getCount();
    if (i == 0) {
      return false;
    }
    int j = localListView.getChildCount();
    int k = localListView.getFirstVisiblePosition();
    if (paramInt > 0)
    {
      if (k + j >= i)
      {
        if (localListView.getChildAt(j - 1).getBottom() > localListView.getHeight()) {
          break label91;
        }
        return false;
      }
    }
    else
    {
      if (paramInt >= 0) {
        break label89;
      }
      if ((k > 0) || (localListView.getChildAt(0).getTop() < 0)) {
        break label91;
      }
      return false;
    }
    return true;
    label89:
    return false;
    label91:
    return true;
  }
  
  public void scrollTargetBy(int paramInt1, int paramInt2)
  {
    ListView localListView = mTarget;
    paramInt1 = Build.VERSION.SDK_INT;
    localListView.scrollListBy(paramInt2);
  }
}
