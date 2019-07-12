package android.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.b.a.N;
import java.util.ArrayList;

@N({b.b.a.N.a.b})
public abstract class BaseMenuPresenter
  implements MenuPresenter
{
  public MenuPresenter.Callback mCallback;
  public Context mContext;
  public int mId;
  public LayoutInflater mInflater;
  public int mItemLayoutRes;
  public MenuBuilder mMenu;
  public int mMenuLayoutRes;
  public MenuView mMenuView;
  public Context mSystemContext;
  public LayoutInflater mSystemInflater;
  
  public BaseMenuPresenter(Context paramContext, int paramInt1, int paramInt2)
  {
    mSystemContext = paramContext;
    mSystemInflater = LayoutInflater.from(paramContext);
    mMenuLayoutRes = paramInt1;
    mItemLayoutRes = paramInt2;
  }
  
  public void addItemView(View paramView, int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramView);
    }
    ((ViewGroup)mMenuView).addView(paramView, paramInt);
  }
  
  public abstract void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView);
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public MenuView.ItemView createItemView(ViewGroup paramViewGroup)
  {
    return (MenuView.ItemView)mSystemInflater.inflate(mItemLayoutRes, paramViewGroup, false);
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public MenuPresenter.Callback getCallback()
  {
    return mCallback;
  }
  
  public int getId()
  {
    return mId;
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof MenuView.ItemView)) {
      paramView = (MenuView.ItemView)paramView;
    } else {
      paramView = createItemView(paramViewGroup);
    }
    bindItemView(paramMenuItemImpl, paramView);
    return (View)paramView;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (mMenuView == null)
    {
      mMenuView = ((MenuView)mSystemInflater.inflate(mMenuLayoutRes, paramViewGroup, false));
      mMenuView.initialize(mMenu);
      updateMenuView(true);
    }
    return mMenuView;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    mContext = paramContext;
    mInflater = LayoutInflater.from(mContext);
    mMenu = paramMenuBuilder;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    MenuPresenter.Callback localCallback = mCallback;
    if (localCallback != null) {
      localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    MenuPresenter.Callback localCallback = mCallback;
    if (localCallback != null) {
      return localCallback.onOpenSubMenu(paramSubMenuBuilder);
    }
    return false;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    mCallback = paramCallback;
  }
  
  public void setId(int paramInt)
  {
    mId = paramInt;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return true;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)mMenuView;
    if (localViewGroup == null) {
      return;
    }
    Object localObject = mMenu;
    int i = 0;
    if (localObject != null)
    {
      ((MenuBuilder)localObject).flagActionItems();
      ArrayList localArrayList = mMenu.getVisibleItems();
      int m = localArrayList.size();
      int j = 0;
      int k;
      for (i = 0; j < m; i = k)
      {
        MenuItemImpl localMenuItemImpl = (MenuItemImpl)localArrayList.get(j);
        k = i;
        if (shouldIncludeItem(i, localMenuItemImpl))
        {
          View localView1 = localViewGroup.getChildAt(i);
          if ((localView1 instanceof MenuView.ItemView)) {
            localObject = ((MenuView.ItemView)localView1).getItemData();
          } else {
            localObject = null;
          }
          View localView2 = getItemView(localMenuItemImpl, localView1, localViewGroup);
          if (localMenuItemImpl != localObject)
          {
            localView2.setPressed(false);
            localView2.jumpDrawablesToCurrentState();
          }
          if (localView2 != localView1) {
            addItemView(localView2, i);
          }
          k = i + 1;
        }
        j += 1;
      }
    }
    while (i < localViewGroup.getChildCount()) {
      if (!filterLeftoverView(localViewGroup, i)) {
        i += 1;
      }
    }
  }
}
