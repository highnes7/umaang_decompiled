package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.appcompat.R.layout;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import b.b.a.N;
import java.util.ArrayList;

@N({b.b.a.N.a.b})
public class ListMenuPresenter
  implements MenuPresenter, AdapterView.OnItemClickListener
{
  public static final String TAG = "ListMenuPresenter";
  public static final String VIEWS_TAG = "android:menu:list";
  public MenuAdapter mAdapter;
  public MenuPresenter.Callback mCallback;
  public Context mContext;
  public int mId;
  public LayoutInflater mInflater;
  public int mItemIndexOffset;
  public int mItemLayoutRes;
  public MenuBuilder mMenu;
  public ExpandedMenuView mMenuView;
  public int mThemeRes;
  
  public ListMenuPresenter(int paramInt1, int paramInt2)
  {
    mItemLayoutRes = paramInt1;
    mThemeRes = paramInt2;
  }
  
  public ListMenuPresenter(Context paramContext, int paramInt)
  {
    mItemLayoutRes = paramInt;
    mThemeRes = 0;
    mContext = paramContext;
    mInflater = LayoutInflater.from(mContext);
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public ListAdapter getAdapter()
  {
    if (mAdapter == null) {
      mAdapter = new MenuAdapter();
    }
    return mAdapter;
  }
  
  public int getId()
  {
    return mId;
  }
  
  public int getItemIndexOffset()
  {
    return mItemIndexOffset;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (mMenuView == null)
    {
      mMenuView = ((ExpandedMenuView)mInflater.inflate(R.layout.abc_expanded_menu_layout, paramViewGroup, false));
      if (mAdapter == null) {
        mAdapter = new MenuAdapter();
      }
      mMenuView.setAdapter(mAdapter);
      mMenuView.setOnItemClickListener(this);
    }
    return mMenuView;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    int i = mThemeRes;
    if (i != 0)
    {
      mContext = new ContextThemeWrapper(paramContext, i);
      mInflater = LayoutInflater.from(mContext);
    }
    else if (mContext != null)
    {
      mContext = paramContext;
      if (mInflater == null) {
        mInflater = LayoutInflater.from(mContext);
      }
    }
    mMenu = paramMenuBuilder;
    paramContext = mAdapter;
    if (paramContext != null) {
      paramContext.notifyDataSetChanged();
    }
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    MenuPresenter.Callback localCallback = mCallback;
    if (localCallback != null) {
      localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    mMenu.performItemAction(mAdapter.getItem(paramInt), this, 0);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    restoreHierarchyState((Bundle)paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (mMenuView == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    saveHierarchyState(localBundle);
    return localBundle;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (!paramSubMenuBuilder.hasVisibleItems()) {
      return false;
    }
    new MenuDialogHelper(paramSubMenuBuilder).show(null);
    MenuPresenter.Callback localCallback = mCallback;
    if (localCallback != null) {
      localCallback.onOpenSubMenu(paramSubMenuBuilder);
    }
    return true;
  }
  
  public void restoreHierarchyState(Bundle paramBundle)
  {
    paramBundle = paramBundle.getSparseParcelableArray("android:menu:list");
    if (paramBundle != null) {
      mMenuView.restoreHierarchyState(paramBundle);
    }
  }
  
  public void saveHierarchyState(Bundle paramBundle)
  {
    SparseArray localSparseArray = new SparseArray();
    ExpandedMenuView localExpandedMenuView = mMenuView;
    if (localExpandedMenuView != null) {
      localExpandedMenuView.saveHierarchyState(localSparseArray);
    }
    paramBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    mCallback = paramCallback;
  }
  
  public void setId(int paramInt)
  {
    mId = paramInt;
  }
  
  public void setItemIndexOffset(int paramInt)
  {
    mItemIndexOffset = paramInt;
    if (mMenuView != null) {
      updateMenuView(false);
    }
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    MenuAdapter localMenuAdapter = mAdapter;
    if (localMenuAdapter != null) {
      localMenuAdapter.notifyDataSetChanged();
    }
  }
  
  private class MenuAdapter
    extends BaseAdapter
  {
    public int mExpandedIndex = -1;
    
    public MenuAdapter()
    {
      findExpandedIndex();
    }
    
    public void findExpandedIndex()
    {
      MenuItemImpl localMenuItemImpl = mMenu.getExpandedItem();
      if (localMenuItemImpl != null)
      {
        ArrayList localArrayList = mMenu.getNonActionItems();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((MenuItemImpl)localArrayList.get(i) == localMenuItemImpl)
          {
            mExpandedIndex = i;
            return;
          }
          i += 1;
        }
      }
      mExpandedIndex = -1;
    }
    
    public int getCount()
    {
      int i = mMenu.getNonActionItems().size() - mItemIndexOffset;
      if (mExpandedIndex < 0) {
        return i;
      }
      return i - 1;
    }
    
    public MenuItemImpl getItem(int paramInt)
    {
      ArrayList localArrayList = mMenu.getNonActionItems();
      int i = paramInt + mItemIndexOffset;
      int j = mExpandedIndex;
      paramInt = i;
      if (j >= 0)
      {
        paramInt = i;
        if (i >= j) {
          paramInt = i + 1;
        }
      }
      return (MenuItemImpl)localArrayList.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null)
      {
        paramView = ListMenuPresenter.this;
        localView = mInflater.inflate(mItemLayoutRes, paramViewGroup, false);
      }
      ((MenuView.ItemView)localView).initialize(getItem(paramInt), 0);
      return localView;
    }
    
    public void notifyDataSetChanged()
    {
      findExpandedIndex();
      super.notifyDataSetChanged();
    }
  }
}
