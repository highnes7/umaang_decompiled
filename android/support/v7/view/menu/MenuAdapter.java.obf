package android.support.v7.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import b.b.a.N;
import java.util.ArrayList;

@N({b.b.a.N.a.b})
public class MenuAdapter
  extends BaseAdapter
{
  public MenuBuilder mAdapterMenu;
  public int mExpandedIndex = -1;
  public boolean mForceShowIcon;
  public final LayoutInflater mInflater;
  public final int mItemLayoutRes;
  public final boolean mOverflowOnly;
  
  public MenuAdapter(MenuBuilder paramMenuBuilder, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    mOverflowOnly = paramBoolean;
    mInflater = paramLayoutInflater;
    mAdapterMenu = paramMenuBuilder;
    mItemLayoutRes = paramInt;
    findExpandedIndex();
  }
  
  public void findExpandedIndex()
  {
    MenuItemImpl localMenuItemImpl = mAdapterMenu.getExpandedItem();
    if (localMenuItemImpl != null)
    {
      ArrayList localArrayList = mAdapterMenu.getNonActionItems();
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
  
  public MenuBuilder getAdapterMenu()
  {
    return mAdapterMenu;
  }
  
  public int getCount()
  {
    ArrayList localArrayList;
    if (mOverflowOnly) {
      localArrayList = mAdapterMenu.getNonActionItems();
    } else {
      localArrayList = mAdapterMenu.getVisibleItems();
    }
    if (mExpandedIndex < 0) {
      return localArrayList.size();
    }
    return localArrayList.size() - 1;
  }
  
  public boolean getForceShowIcon()
  {
    return mForceShowIcon;
  }
  
  public MenuItemImpl getItem(int paramInt)
  {
    ArrayList localArrayList;
    if (mOverflowOnly) {
      localArrayList = mAdapterMenu.getNonActionItems();
    } else {
      localArrayList = mAdapterMenu.getVisibleItems();
    }
    int j = mExpandedIndex;
    int i = paramInt;
    if (j >= 0)
    {
      i = paramInt;
      if (paramInt >= j) {
        i = paramInt + 1;
      }
    }
    return (MenuItemImpl)localArrayList.get(i);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = mInflater.inflate(mItemLayoutRes, paramViewGroup, false);
    }
    int j = getItem(paramInt).getGroupId();
    int i = paramInt - 1;
    if (i >= 0) {
      i = getItem(i).getGroupId();
    } else {
      i = j;
    }
    paramView = (ListMenuItemView)localView;
    boolean bool;
    if ((mAdapterMenu.isGroupDividerEnabled()) && (j != i)) {
      bool = true;
    } else {
      bool = false;
    }
    paramView.setGroupDividerEnabled(bool);
    paramViewGroup = (MenuView.ItemView)localView;
    if (mForceShowIcon) {
      paramView.setForceShowIcon(true);
    }
    paramViewGroup.initialize(getItem(paramInt), 0);
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    findExpandedIndex();
    super.notifyDataSetChanged();
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    mForceShowIcon = paramBoolean;
  }
}
