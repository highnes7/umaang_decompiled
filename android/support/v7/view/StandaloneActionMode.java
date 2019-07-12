package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import b.b.a.N;
import java.lang.ref.WeakReference;

@N({b.b.a.N.a.b})
public class StandaloneActionMode
  extends ActionMode
  implements MenuBuilder.Callback
{
  public ActionMode.Callback mCallback;
  public Context mContext;
  public ActionBarContextView mContextView;
  public WeakReference<View> mCustomView;
  public boolean mFinished;
  public boolean mFocusable;
  public MenuBuilder mMenu;
  
  public StandaloneActionMode(Context paramContext, ActionBarContextView paramActionBarContextView, ActionMode.Callback paramCallback, boolean paramBoolean)
  {
    mContext = paramContext;
    mContextView = paramActionBarContextView;
    mCallback = paramCallback;
    mMenu = new MenuBuilder(paramActionBarContextView.getContext()).setDefaultShowAsAction(1);
    mMenu.setCallback(this);
    mFocusable = paramBoolean;
  }
  
  public void finish()
  {
    if (mFinished) {
      return;
    }
    mFinished = true;
    mContextView.sendAccessibilityEvent(32);
    mCallback.onDestroyActionMode(this);
  }
  
  public View getCustomView()
  {
    WeakReference localWeakReference = mCustomView;
    if (localWeakReference != null) {
      return (View)localWeakReference.get();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    return mMenu;
  }
  
  public MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(mContextView.getContext());
  }
  
  public CharSequence getSubtitle()
  {
    return mContextView.getSubtitle();
  }
  
  public CharSequence getTitle()
  {
    return mContextView.getTitle();
  }
  
  public void invalidate()
  {
    mCallback.onPrepareActionMode(this, mMenu);
  }
  
  public boolean isTitleOptional()
  {
    return mContextView.isTitleOptional();
  }
  
  public boolean isUiFocusable()
  {
    return mFocusable;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onCloseSubMenu(SubMenuBuilder paramSubMenuBuilder) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return mCallback.onActionItemClicked(this, paramMenuItem);
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    invalidate();
    mContextView.showOverflowMenu();
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (!paramSubMenuBuilder.hasVisibleItems()) {
      return true;
    }
    new MenuPopupHelper(mContextView.getContext(), paramSubMenuBuilder).show();
    return true;
  }
  
  public void setCustomView(View paramView)
  {
    mContextView.setCustomView(paramView);
    if (paramView != null) {
      paramView = new WeakReference(paramView);
    } else {
      paramView = null;
    }
    mCustomView = paramView;
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(mContext.getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    mContextView.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(mContext.getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mContextView.setTitle(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    mTitleOptionalHint = paramBoolean;
    mContextView.setTitleOptional(paramBoolean);
  }
}
