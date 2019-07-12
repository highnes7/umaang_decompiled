package android.support.v7.view.menu;

import android.widget.ListView;
import b.b.a.N;

@N({b.b.a.N.a.b})
public abstract interface ShowableListMenu
{
  public abstract void dismiss();
  
  public abstract ListView getListView();
  
  public abstract boolean isShowing();
  
  public abstract void show();
}
