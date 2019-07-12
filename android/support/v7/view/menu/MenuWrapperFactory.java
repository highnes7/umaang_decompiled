package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import b.b.a.N;
import support.android.v4.media.session.SupportMenu;
import support.android.v4.media.session.SupportMenuItem;
import support.android.v4.media.session.SupportSubMenu;

@N({b.b.a.N.a.b})
public final class MenuWrapperFactory
{
  public MenuWrapperFactory() {}
  
  public static Menu wrapSupportMenu(Context paramContext, SupportMenu paramSupportMenu)
  {
    return new MenuWrapperICS(paramContext, paramSupportMenu);
  }
  
  public static MenuItem wrapSupportMenuItem(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    int i = Build.VERSION.SDK_INT;
    return new MenuItemWrapperJB(paramContext, paramSupportMenuItem);
  }
  
  public static SubMenu wrapSupportSubMenu(Context paramContext, SupportSubMenu paramSupportSubMenu)
  {
    return new SubMenuWrapperICS(paramContext, paramSupportSubMenu);
  }
}
