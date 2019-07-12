package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;

public class PopupMenu
{
  public final View mAnchor;
  public final Context mContext;
  public View.OnTouchListener mDragListener;
  public final MenuBuilder mMenu;
  public OnMenuItemClickListener mMenuItemClickListener;
  public OnDismissListener mOnDismissListener;
  public final MenuPopupHelper mPopup;
  
  public PopupMenu(Context paramContext, View paramView)
  {
    this(paramContext, paramView, 0);
  }
  
  public PopupMenu(Context paramContext, View paramView, int paramInt)
  {
    this(paramContext, paramView, paramInt, R.attr.popupMenuStyle, 0);
  }
  
  public PopupMenu(Context paramContext, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    mContext = paramContext;
    mAnchor = paramView;
    mMenu = new MenuBuilder(paramContext);
    mMenu.setCallback(new MenuBuilder.Callback()
    {
      public boolean onMenuItemSelected(MenuBuilder paramAnonymousMenuBuilder, MenuItem paramAnonymousMenuItem)
      {
        paramAnonymousMenuBuilder = mMenuItemClickListener;
        if (paramAnonymousMenuBuilder != null) {
          return paramAnonymousMenuBuilder.onMenuItemClick(paramAnonymousMenuItem);
        }
        return false;
      }
      
      public void onMenuModeChange(MenuBuilder paramAnonymousMenuBuilder) {}
    });
    mPopup = new MenuPopupHelper(paramContext, mMenu, paramView, false, paramInt2, paramInt3);
    mPopup.setGravity(paramInt1);
    mPopup.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        PopupMenu localPopupMenu = PopupMenu.this;
        PopupMenu.OnDismissListener localOnDismissListener = mOnDismissListener;
        if (localOnDismissListener != null) {
          localOnDismissListener.onDismiss(localPopupMenu);
        }
      }
    });
  }
  
  public void dismiss()
  {
    mPopup.dismiss();
  }
  
  public View.OnTouchListener getDragToOpenListener()
  {
    if (mDragListener == null) {
      mDragListener = new ForwardingListener(mAnchor)
      {
        public ShowableListMenu getPopup()
        {
          return mPopup.getPopup();
        }
        
        public boolean onForwardingStarted()
        {
          show();
          return true;
        }
        
        public boolean onForwardingStopped()
        {
          dismiss();
          return true;
        }
      };
    }
    return mDragListener;
  }
  
  public int getGravity()
  {
    return mPopup.getGravity();
  }
  
  public Menu getMenu()
  {
    return mMenu;
  }
  
  public MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(mContext);
  }
  
  public ListView getMenuListView()
  {
    if (!mPopup.isShowing()) {
      return null;
    }
    return mPopup.getListView();
  }
  
  public void inflate(int paramInt)
  {
    getMenuInflater().inflate(paramInt, mMenu);
  }
  
  public void setGravity(int paramInt)
  {
    mPopup.setGravity(paramInt);
  }
  
  public void setOnDismissListener(OnDismissListener paramOnDismissListener)
  {
    mOnDismissListener = paramOnDismissListener;
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    mMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void show()
  {
    mPopup.show();
  }
  
  public static abstract interface OnDismissListener
  {
    public abstract void onDismiss(PopupMenu paramPopupMenu);
  }
  
  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}
