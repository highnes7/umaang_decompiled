package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.layout;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.MenuPopupWindow;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import support.android.v4.view.ViewCompat;

public final class StandardMenuPopup
  extends MenuPopup
  implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener
{
  public static final int ITEM_LAYOUT = R.layout.abc_popup_menu_item_layout;
  public final MenuAdapter mAdapter;
  public View mAnchorView;
  public final View.OnAttachStateChangeListener mAttachStateChangeListener = new View.OnAttachStateChangeListener()
  {
    public void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public void onViewDetachedFromWindow(View paramAnonymousView)
    {
      Object localObject = mTreeObserver;
      if (localObject != null)
      {
        if (!((ViewTreeObserver)localObject).isAlive()) {
          mTreeObserver = paramAnonymousView.getViewTreeObserver();
        }
        localObject = StandardMenuPopup.this;
        mTreeObserver.removeGlobalOnLayoutListener(mGlobalLayoutListener);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  public int mContentWidth;
  public final Context mContext;
  public int mDropDownGravity = 0;
  public final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if ((isShowing()) && (!mPopup.isModal()))
      {
        View localView = mShownAnchorView;
        if ((localView != null) && (localView.isShown()))
        {
          mPopup.show();
          return;
        }
        dismiss();
      }
    }
  };
  public boolean mHasContentWidth;
  public final MenuBuilder mMenu;
  public PopupWindow.OnDismissListener mOnDismissListener;
  public final boolean mOverflowOnly;
  public final MenuPopupWindow mPopup;
  public final int mPopupMaxWidth;
  public final int mPopupStyleAttr;
  public final int mPopupStyleRes;
  public MenuPresenter.Callback mPresenterCallback;
  public boolean mShowTitle;
  public View mShownAnchorView;
  public ViewTreeObserver mTreeObserver;
  public boolean mWasDismissed;
  
  public StandardMenuPopup(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    mContext = paramContext;
    mMenu = paramMenuBuilder;
    mOverflowOnly = paramBoolean;
    mAdapter = new MenuAdapter(paramMenuBuilder, LayoutInflater.from(paramContext), mOverflowOnly, ITEM_LAYOUT);
    mPopupStyleAttr = paramInt1;
    mPopupStyleRes = paramInt2;
    Resources localResources = paramContext.getResources();
    mPopupMaxWidth = Math.max(getDisplayMetricswidthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    mAnchorView = paramView;
    mPopup = new MenuPopupWindow(mContext, null, mPopupStyleAttr, mPopupStyleRes);
    paramMenuBuilder.addMenuPresenter(this, paramContext);
  }
  
  private boolean tryShow()
  {
    if (isShowing()) {
      return true;
    }
    if (!mWasDismissed)
    {
      Object localObject = mAnchorView;
      if (localObject == null) {
        return false;
      }
      mShownAnchorView = ((View)localObject);
      mPopup.setOnDismissListener(this);
      mPopup.setOnItemClickListener(this);
      mPopup.setModal(true);
      localObject = mShownAnchorView;
      int i;
      if (mTreeObserver == null) {
        i = 1;
      } else {
        i = 0;
      }
      mTreeObserver = ((View)localObject).getViewTreeObserver();
      if (i != 0) {
        mTreeObserver.addOnGlobalLayoutListener(mGlobalLayoutListener);
      }
      ((View)localObject).addOnAttachStateChangeListener(mAttachStateChangeListener);
      mPopup.setAnchorView((View)localObject);
      mPopup.setDropDownGravity(mDropDownGravity);
      if (!mHasContentWidth)
      {
        mContentWidth = MenuPopup.measureIndividualMenuWidth(mAdapter, null, mContext, mPopupMaxWidth);
        mHasContentWidth = true;
      }
      mPopup.setContentWidth(mContentWidth);
      mPopup.setInputMethodMode(2);
      mPopup.setEpicenterBounds(getEpicenterBounds());
      mPopup.show();
      localObject = mPopup.getListView();
      ((View)localObject).setOnKeyListener(this);
      if ((mShowTitle) && (mMenu.getHeaderTitle() != null))
      {
        FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(mContext).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)localObject, false);
        TextView localTextView = (TextView)localFrameLayout.findViewById(16908310);
        if (localTextView != null) {
          localTextView.setText(mMenu.getHeaderTitle());
        }
        localFrameLayout.setEnabled(false);
        ((ListView)localObject).addHeaderView(localFrameLayout, null, false);
      }
      mPopup.setAdapter(mAdapter);
      mPopup.show();
      return true;
    }
    return false;
  }
  
  public void addMenu(MenuBuilder paramMenuBuilder) {}
  
  public void dismiss()
  {
    if (isShowing()) {
      mPopup.dismiss();
    }
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public ListView getListView()
  {
    return mPopup.getListView();
  }
  
  public boolean isShowing()
  {
    return (!mWasDismissed) && (mPopup.isShowing());
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (paramMenuBuilder != mMenu) {
      return;
    }
    dismiss();
    MenuPresenter.Callback localCallback = mPresenterCallback;
    if (localCallback != null) {
      localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public void onDismiss()
  {
    mWasDismissed = true;
    mMenu.close();
    Object localObject = mTreeObserver;
    if (localObject != null)
    {
      if (!((ViewTreeObserver)localObject).isAlive()) {
        mTreeObserver = mShownAnchorView.getViewTreeObserver();
      }
      mTreeObserver.removeGlobalOnLayoutListener(mGlobalLayoutListener);
      mTreeObserver = null;
    }
    mShownAnchorView.removeOnAttachStateChangeListener(mAttachStateChangeListener);
    localObject = mOnDismissListener;
    if (localObject != null) {
      ((PopupWindow.OnDismissListener)localObject).onDismiss();
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (paramSubMenuBuilder.hasVisibleItems())
    {
      Object localObject = new MenuPopupHelper(mContext, paramSubMenuBuilder, mShownAnchorView, mOverflowOnly, mPopupStyleAttr, mPopupStyleRes);
      ((MenuPopupHelper)localObject).setPresenterCallback(mPresenterCallback);
      ((MenuPopupHelper)localObject).setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(paramSubMenuBuilder));
      ((MenuPopupHelper)localObject).setOnDismissListener(mOnDismissListener);
      mOnDismissListener = null;
      mMenu.close(false);
      int j = mPopup.getHorizontalOffset();
      int i = j;
      int k = mPopup.getVerticalOffset();
      if ((Gravity.getAbsoluteGravity(mDropDownGravity, ViewCompat.getLayoutDirection(mAnchorView)) & 0x7) == 5) {
        i = j + mAnchorView.getWidth();
      }
      if (((MenuPopupHelper)localObject).tryShow(i, k))
      {
        localObject = mPresenterCallback;
        if (localObject != null) {
          ((MenuPresenter.Callback)localObject).onOpenSubMenu(paramSubMenuBuilder);
        }
        return true;
      }
    }
    return false;
  }
  
  public void setAnchorView(View paramView)
  {
    mAnchorView = paramView;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    mPresenterCallback = paramCallback;
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    mAdapter.setForceShowIcon(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    mDropDownGravity = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    mPopup.setHorizontalOffset(paramInt);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    mOnDismissListener = paramOnDismissListener;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    mShowTitle = paramBoolean;
  }
  
  public void setVerticalOffset(int paramInt)
  {
    mPopup.setVerticalOffset(paramInt);
  }
  
  public void show()
  {
    if (tryShow()) {
      return;
    }
    throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    mHasContentWidth = false;
    MenuAdapter localMenuAdapter = mAdapter;
    if (localMenuAdapter != null) {
      localMenuAdapter.notifyDataSetChanged();
    }
  }
}
