package android.support.v7.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class NavItemSelectedListener
  implements AdapterView.OnItemSelectedListener
{
  public final ActionBar.OnNavigationListener mListener;
  
  public NavItemSelectedListener(ActionBar.OnNavigationListener paramOnNavigationListener)
  {
    mListener = paramOnNavigationListener;
  }
  
  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = mListener;
    if (paramAdapterView != null) {
      paramAdapterView.onNavigationItemSelected(paramInt, paramLong);
    }
  }
  
  public void onNothingSelected(AdapterView paramAdapterView) {}
}
