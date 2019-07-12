package android.support.v7.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import b.b.x.f.a.b;
import b.b.x.f.a.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import support.android.v4.media.session.SupportMenuItem;
import support.android.v4.media.session.SupportSubMenu;
import support.android.v4.util.ArrayMap;

public abstract class BaseMenuWrapper<T>
  extends BaseWrapper<T>
{
  public final Context mContext;
  public Map<b, MenuItem> mMenuItems;
  public Map<c, SubMenu> mSubMenus;
  
  public BaseMenuWrapper(Context paramContext, Object paramObject)
  {
    super(paramObject);
    mContext = paramContext;
  }
  
  public final MenuItem getMenuItemWrapper(MenuItem paramMenuItem)
  {
    MenuItem localMenuItem = paramMenuItem;
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      SupportMenuItem localSupportMenuItem = (SupportMenuItem)paramMenuItem;
      if (mMenuItems == null) {
        mMenuItems = new ArrayMap();
      }
      paramMenuItem = (MenuItem)mMenuItems.get(paramMenuItem);
      localMenuItem = paramMenuItem;
      if (paramMenuItem == null)
      {
        localMenuItem = MenuWrapperFactory.wrapSupportMenuItem(mContext, localSupportMenuItem);
        mMenuItems.put(localSupportMenuItem, localMenuItem);
      }
    }
    return localMenuItem;
  }
  
  public final SubMenu getSubMenuWrapper(SubMenu paramSubMenu)
  {
    SubMenu localSubMenu = paramSubMenu;
    if ((paramSubMenu instanceof SupportSubMenu))
    {
      SupportSubMenu localSupportSubMenu = (SupportSubMenu)paramSubMenu;
      if (mSubMenus == null) {
        mSubMenus = new ArrayMap();
      }
      paramSubMenu = (SubMenu)mSubMenus.get(localSupportSubMenu);
      localSubMenu = paramSubMenu;
      if (paramSubMenu == null)
      {
        paramSubMenu = new SubMenuWrapperICS(mContext, localSupportSubMenu);
        mSubMenus.put(localSupportSubMenu, paramSubMenu);
        return paramSubMenu;
      }
    }
    return localSubMenu;
  }
  
  public final void internalClear()
  {
    Map localMap = mMenuItems;
    if (localMap != null) {
      localMap.clear();
    }
    localMap = mSubMenus;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  public final void internalRemoveGroup(int paramInt)
  {
    Object localObject = mMenuItems;
    if (localObject == null) {
      return;
    }
    localObject = ((Map)localObject).keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramInt == ((MenuItem)((Iterator)localObject).next()).getGroupId()) {
        ((Iterator)localObject).remove();
      }
    }
  }
  
  public final void internalRemoveItem(int paramInt)
  {
    Object localObject = mMenuItems;
    if (localObject == null) {
      return;
    }
    localObject = ((Map)localObject).keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramInt == ((MenuItem)((Iterator)localObject).next()).getItemId()) {
        ((Iterator)localObject).remove();
      }
    }
  }
}
