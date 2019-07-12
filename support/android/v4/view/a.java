package support.android.v4.view;

import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;
import support.android.v4.media.session.SupportMenu;

public final class a
{
  public a() {}
  
  public static void a(Menu paramMenu, boolean paramBoolean)
  {
    if ((paramMenu instanceof SupportMenu))
    {
      ((SupportMenu)paramMenu).setGroupDividerEnabled(paramBoolean);
      return;
    }
    if (Build.VERSION.SDK_INT >= 28) {
      paramMenu.setGroupDividerEnabled(paramBoolean);
    }
  }
  
  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem.setShowAsAction(paramInt);
  }
}
