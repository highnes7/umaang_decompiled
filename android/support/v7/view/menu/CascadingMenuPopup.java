package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.layout;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.MenuItemHoverListener;
import android.support.v7.widget.MenuPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import support.android.v4.view.GravityCompat;
import support.android.v4.view.ViewCompat;

public final class CascadingMenuPopup
  extends MenuPopup
  implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener
{
  public static final int HORIZ_POSITION_LEFT = 0;
  public static final int HORIZ_POSITION_RIGHT = 1;
  public static final int ITEM_LAYOUT = R.layout.abc_cascading_menu_item_layout;
  public static final int SUBMENU_TIMEOUT_MS = 200;
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
        localObject = CascadingMenuPopup.this;
        mTreeObserver.removeGlobalOnLayoutListener(mGlobalLayoutListener);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  public final Context mContext;
  public int mDropDownGravity = 0;
  public boolean mForceShowIcon;
  public final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if ((isShowing()) && (mShowingMenus.size() > 0) && (!mShowingMenus.get(0)).window.isModal()))
      {
        Object localObject = mShownAnchorView;
        if ((localObject != null) && (((View)localObject).isShown())) {
          localObject = mShowingMenus.iterator();
        }
        while (((Iterator)localObject).hasNext())
        {
          nextwindow.show();
          continue;
          dismiss();
        }
      }
    }
  };
  public boolean mHasXOffset;
  public boolean mHasYOffset;
  public int mLastPosition;
  public final MenuItemHoverListener mMenuItemHoverListener = new MenuItemHoverListener()
  {
    public void onItemHoverEnter(final MenuBuilder paramAnonymousMenuBuilder, final MenuItem paramAnonymousMenuItem)
    {
      Handler localHandler = mSubMenuHoverHandler;
      final CascadingMenuPopup.CascadingMenuInfo localCascadingMenuInfo = null;
      localHandler.removeCallbacksAndMessages(null);
      int j = mShowingMenus.size();
      int i = 0;
      while (i < j)
      {
        if (paramAnonymousMenuBuilder == mShowingMenus.get(i)).menu) {
          break label75;
        }
        i += 1;
      }
      i = -1;
      label75:
      if (i == -1) {
        return;
      }
      i += 1;
      if (i < mShowingMenus.size()) {
        localCascadingMenuInfo = (CascadingMenuPopup.CascadingMenuInfo)mShowingMenus.get(i);
      }
      paramAnonymousMenuItem = new Runnable()
      {
        public void run()
        {
          CascadingMenuPopup.CascadingMenuInfo localCascadingMenuInfo = localCascadingMenuInfo;
          if (localCascadingMenuInfo != null)
          {
            mShouldCloseImmediately = true;
            menu.close(false);
            mShouldCloseImmediately = false;
          }
          if ((paramAnonymousMenuItem.isEnabled()) && (paramAnonymousMenuItem.hasSubMenu())) {
            paramAnonymousMenuBuilder.performItemAction(paramAnonymousMenuItem, 4);
          }
        }
      };
      long l = SystemClock.uptimeMillis();
      mSubMenuHoverHandler.postAtTime(paramAnonymousMenuItem, paramAnonymousMenuBuilder, l + 200L);
    }
    
    public void onItemHoverExit(MenuBuilder paramAnonymousMenuBuilder, MenuItem paramAnonymousMenuItem)
    {
      mSubMenuHoverHandler.removeCallbacksAndMessages(paramAnonymousMenuBuilder);
    }
  };
  public final int mMenuMaxWidth;
  public PopupWindow.OnDismissListener mOnDismissListener;
  public final boolean mOverflowOnly;
  public final List<MenuBuilder> mPendingMenus = new ArrayList();
  public final int mPopupStyleAttr;
  public final int mPopupStyleRes;
  public MenuPresenter.Callback mPresenterCallback;
  public int mRawDropDownGravity = 0;
  public boolean mShouldCloseImmediately;
  public boolean mShowTitle;
  public final List<CascadingMenuInfo> mShowingMenus = new ArrayList();
  public View mShownAnchorView;
  public final Handler mSubMenuHoverHandler;
  public ViewTreeObserver mTreeObserver;
  public int mXOffset;
  public int mYOffset;
  
  public CascadingMenuPopup(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    mContext = paramContext;
    mAnchorView = paramView;
    mPopupStyleAttr = paramInt1;
    mPopupStyleRes = paramInt2;
    mOverflowOnly = paramBoolean;
    mForceShowIcon = false;
    mLastPosition = getInitialMenuPosition();
    paramContext = paramContext.getResources();
    mMenuMaxWidth = Math.max(getDisplayMetricswidthPixels / 2, paramContext.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    mSubMenuHoverHandler = new Handler();
  }
  
  private MenuPopupWindow createPopupWindow()
  {
    MenuPopupWindow localMenuPopupWindow = new MenuPopupWindow(mContext, null, mPopupStyleAttr, mPopupStyleRes);
    localMenuPopupWindow.setHoverListener(mMenuItemHoverListener);
    localMenuPopupWindow.setOnItemClickListener(this);
    localMenuPopupWindow.setOnDismissListener(this);
    localMenuPopupWindow.setAnchorView(mAnchorView);
    localMenuPopupWindow.setDropDownGravity(mDropDownGravity);
    localMenuPopupWindow.setModal(true);
    localMenuPopupWindow.setInputMethodMode(2);
    return localMenuPopupWindow;
  }
  
  private int findIndexOfAddedMenu(MenuBuilder paramMenuBuilder)
  {
    int j = mShowingMenus.size();
    int i = 0;
    while (i < j)
    {
      if (paramMenuBuilder == mShowingMenus.get(i)).menu) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private MenuItem findMenuItemForSubmenu(MenuBuilder paramMenuBuilder1, MenuBuilder paramMenuBuilder2)
  {
    int j = paramMenuBuilder1.size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = paramMenuBuilder1.getItem(i);
      if ((localMenuItem.hasSubMenu()) && (paramMenuBuilder2 == localMenuItem.getSubMenu())) {
        return localMenuItem;
      }
      i += 1;
    }
    return null;
  }
  
  private View findParentViewForSubmenu(CascadingMenuInfo paramCascadingMenuInfo, MenuBuilder paramMenuBuilder)
  {
    paramMenuBuilder = findMenuItemForSubmenu(menu, paramMenuBuilder);
    if (paramMenuBuilder == null) {
      return null;
    }
    ListView localListView = paramCascadingMenuInfo.getListView();
    paramCascadingMenuInfo = localListView.getAdapter();
    boolean bool = paramCascadingMenuInfo instanceof HeaderViewListAdapter;
    int i = 0;
    int j;
    if (bool)
    {
      paramCascadingMenuInfo = (HeaderViewListAdapter)paramCascadingMenuInfo;
      j = paramCascadingMenuInfo.getHeadersCount();
      paramCascadingMenuInfo = (MenuAdapter)paramCascadingMenuInfo.getWrappedAdapter();
    }
    else
    {
      paramCascadingMenuInfo = (MenuAdapter)paramCascadingMenuInfo;
      j = 0;
    }
    int k = paramCascadingMenuInfo.getCount();
    while (i < k)
    {
      if (paramMenuBuilder == paramCascadingMenuInfo.getItem(i)) {
        break label104;
      }
      i += 1;
    }
    i = -1;
    label104:
    if (i == -1) {
      return null;
    }
    i = i + j - localListView.getFirstVisiblePosition();
    if (i >= 0)
    {
      if (i >= localListView.getChildCount()) {
        return null;
      }
      return localListView.getChildAt(i);
    }
    return null;
  }
  
  private int getInitialMenuPosition()
  {
    if (ViewCompat.getLayoutDirection(mAnchorView) == 1) {
      return 0;
    }
    return 1;
  }
  
  private int getNextMenuPosition(int paramInt)
  {
    Object localObject = mShowingMenus;
    localObject = ((CascadingMenuInfo)((List)localObject).get(((List)localObject).size() - 1)).getListView();
    int[] arrayOfInt = new int[2];
    ((View)localObject).getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    mShownAnchorView.getWindowVisibleDisplayFrame(localRect);
    if (mLastPosition == 1)
    {
      int i = arrayOfInt[0];
      if (((View)localObject).getWidth() + i + paramInt > right) {
        return 0;
      }
      return 1;
    }
    if (arrayOfInt[0] - paramInt < 0) {
      return 1;
    }
    return 0;
  }
  
  private void showMenu(MenuBuilder paramMenuBuilder)
  {
    Object localObject3 = LayoutInflater.from(mContext);
    Object localObject1 = new MenuAdapter(paramMenuBuilder, (LayoutInflater)localObject3, mOverflowOnly, ITEM_LAYOUT);
    if ((!isShowing()) && (mForceShowIcon)) {
      ((MenuAdapter)localObject1).setForceShowIcon(true);
    } else if (isShowing()) {
      ((MenuAdapter)localObject1).setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(paramMenuBuilder));
    }
    int n = MenuPopup.measureIndividualMenuWidth((ListAdapter)localObject1, null, mContext, mMenuMaxWidth);
    int i = n;
    MenuPopupWindow localMenuPopupWindow = createPopupWindow();
    localMenuPopupWindow.setAdapter((ListAdapter)localObject1);
    localMenuPopupWindow.setContentWidth(n);
    localMenuPopupWindow.setDropDownGravity(mDropDownGravity);
    if (mShowingMenus.size() > 0)
    {
      localObject1 = mShowingMenus;
      localObject1 = (CascadingMenuInfo)((List)localObject1).get(((List)localObject1).size() - 1);
      localObject2 = findParentViewForSubmenu((CascadingMenuInfo)localObject1, paramMenuBuilder);
    }
    else
    {
      localObject1 = null;
      localObject2 = null;
    }
    if (localObject2 != null)
    {
      localMenuPopupWindow.setTouchModal(false);
      localMenuPopupWindow.setEnterTransition(null);
      int k = getNextMenuPosition(n);
      int j;
      if (k == 1) {
        j = 1;
      } else {
        j = 0;
      }
      mLastPosition = k;
      int m;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localMenuPopupWindow.setAnchorView((View)localObject2);
        k = 0;
        m = 0;
      }
      else
      {
        int[] arrayOfInt1 = new int[2];
        mAnchorView.getLocationOnScreen(arrayOfInt1);
        int[] arrayOfInt2 = new int[2];
        ((View)localObject2).getLocationOnScreen(arrayOfInt2);
        if ((mDropDownGravity & 0x7) == 5)
        {
          k = arrayOfInt1[0];
          arrayOfInt1[0] = (mAnchorView.getWidth() + k);
          k = arrayOfInt2[0];
          arrayOfInt2[0] = (((View)localObject2).getWidth() + k);
        }
        m = arrayOfInt2[0] - arrayOfInt1[0];
        k = arrayOfInt2[1] - arrayOfInt1[1];
      }
      if ((mDropDownGravity & 0x5) == 5)
      {
        if (j != 0)
        {
          i = m + n;
          break label390;
        }
        i = ((View)localObject2).getWidth();
      }
      else if (j != 0)
      {
        i = m + ((View)localObject2).getWidth();
        break label390;
      }
      i = m - i;
      label390:
      localMenuPopupWindow.setHorizontalOffset(i);
      localMenuPopupWindow.setOverlapAnchor(true);
      localMenuPopupWindow.setVerticalOffset(k);
    }
    else
    {
      if (mHasXOffset) {
        localMenuPopupWindow.setHorizontalOffset(mXOffset);
      }
      if (mHasYOffset) {
        localMenuPopupWindow.setVerticalOffset(mYOffset);
      }
      localMenuPopupWindow.setEpicenterBounds(getEpicenterBounds());
    }
    Object localObject2 = new CascadingMenuInfo(localMenuPopupWindow, paramMenuBuilder, mLastPosition);
    mShowingMenus.add(localObject2);
    localMenuPopupWindow.show();
    localObject2 = localMenuPopupWindow.getListView();
    ((View)localObject2).setOnKeyListener(this);
    if ((localObject1 == null) && (mShowTitle) && (paramMenuBuilder.getHeaderTitle() != null))
    {
      localObject1 = (FrameLayout)((LayoutInflater)localObject3).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)localObject2, false);
      localObject3 = (TextView)((View)localObject1).findViewById(16908310);
      ((View)localObject1).setEnabled(false);
      ((TextView)localObject3).setText(paramMenuBuilder.getHeaderTitle());
      ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
      localMenuPopupWindow.show();
    }
  }
  
  public void addMenu(MenuBuilder paramMenuBuilder)
  {
    paramMenuBuilder.addMenuPresenter(this, mContext);
    if (isShowing())
    {
      showMenu(paramMenuBuilder);
      return;
    }
    mPendingMenus.add(paramMenuBuilder);
  }
  
  public boolean closeMenuOnSubMenuOpened()
  {
    return false;
  }
  
  public void dismiss()
  {
    int i = mShowingMenus.size();
    if (i > 0)
    {
      CascadingMenuInfo[] arrayOfCascadingMenuInfo = (CascadingMenuInfo[])mShowingMenus.toArray(new CascadingMenuInfo[i]);
      i -= 1;
      while (i >= 0)
      {
        CascadingMenuInfo localCascadingMenuInfo = arrayOfCascadingMenuInfo[i];
        if (window.isShowing()) {
          window.dismiss();
        }
        i -= 1;
      }
    }
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public ListView getListView()
  {
    if (mShowingMenus.isEmpty()) {
      return null;
    }
    return ((CascadingMenuInfo)StringBuilder.get(mShowingMenus, -1)).getListView();
  }
  
  public boolean isShowing()
  {
    return (mShowingMenus.size() > 0) && (mShowingMenus.get(0)).window.isShowing());
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    int i = findIndexOfAddedMenu(paramMenuBuilder);
    if (i < 0) {
      return;
    }
    int j = i + 1;
    if (j < mShowingMenus.size()) {
      mShowingMenus.get(j)).menu.close(false);
    }
    Object localObject = (CascadingMenuInfo)mShowingMenus.remove(i);
    menu.removeMenuPresenter(this);
    if (mShouldCloseImmediately)
    {
      window.setExitTransition(null);
      window.setAnimationStyle(0);
    }
    window.dismiss();
    i = mShowingMenus.size();
    if (i > 0) {
      mLastPosition = mShowingMenus.get(i - 1)).position;
    } else {
      mLastPosition = getInitialMenuPosition();
    }
    if (i == 0)
    {
      dismiss();
      localObject = mPresenterCallback;
      if (localObject != null) {
        ((MenuPresenter.Callback)localObject).onCloseMenu(paramMenuBuilder, true);
      }
      paramMenuBuilder = mTreeObserver;
      if (paramMenuBuilder != null)
      {
        if (paramMenuBuilder.isAlive()) {
          mTreeObserver.removeGlobalOnLayoutListener(mGlobalLayoutListener);
        }
        mTreeObserver = null;
      }
      mShownAnchorView.removeOnAttachStateChangeListener(mAttachStateChangeListener);
      mOnDismissListener.onDismiss();
      return;
    }
    if (paramBoolean) {
      mShowingMenus.get(0)).menu.close(false);
    }
  }
  
  public void onDismiss()
  {
    int j = mShowingMenus.size();
    int i = 0;
    while (i < j)
    {
      localCascadingMenuInfo = (CascadingMenuInfo)mShowingMenus.get(i);
      if (!window.isShowing()) {
        break label53;
      }
      i += 1;
    }
    CascadingMenuInfo localCascadingMenuInfo = null;
    label53:
    if (localCascadingMenuInfo != null) {
      menu.close(false);
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
    Object localObject = mShowingMenus.iterator();
    while (((Iterator)localObject).hasNext())
    {
      CascadingMenuInfo localCascadingMenuInfo = (CascadingMenuInfo)((Iterator)localObject).next();
      if (paramSubMenuBuilder == menu)
      {
        localCascadingMenuInfo.getListView().requestFocus();
        return true;
      }
    }
    if (paramSubMenuBuilder.hasVisibleItems())
    {
      addMenu(paramSubMenuBuilder);
      localObject = mPresenterCallback;
      if (localObject != null)
      {
        ((MenuPresenter.Callback)localObject).onOpenSubMenu(paramSubMenuBuilder);
        return true;
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  public void setAnchorView(View paramView)
  {
    if (mAnchorView != paramView)
    {
      mAnchorView = paramView;
      mDropDownGravity = GravityCompat.getAbsoluteGravity(mRawDropDownGravity, ViewCompat.getLayoutDirection(mAnchorView));
    }
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    mPresenterCallback = paramCallback;
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    mForceShowIcon = paramBoolean;
  }
  
  public void setGravity(int paramInt)
  {
    if (mRawDropDownGravity != paramInt)
    {
      mRawDropDownGravity = paramInt;
      mDropDownGravity = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(mAnchorView));
    }
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    mHasXOffset = true;
    mXOffset = paramInt;
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
    mHasYOffset = true;
    mYOffset = paramInt;
  }
  
  public void show()
  {
    if (isShowing()) {
      return;
    }
    Iterator localIterator = mPendingMenus.iterator();
    while (localIterator.hasNext()) {
      showMenu((MenuBuilder)localIterator.next());
    }
    mPendingMenus.clear();
    mShownAnchorView = mAnchorView;
    if (mShownAnchorView != null)
    {
      int i;
      if (mTreeObserver == null) {
        i = 1;
      } else {
        i = 0;
      }
      mTreeObserver = mShownAnchorView.getViewTreeObserver();
      if (i != 0) {
        mTreeObserver.addOnGlobalLayoutListener(mGlobalLayoutListener);
      }
      mShownAnchorView.addOnAttachStateChangeListener(mAttachStateChangeListener);
    }
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    Iterator localIterator = mShowingMenus.iterator();
    while (localIterator.hasNext()) {
      MenuPopup.toMenuAdapter(((CascadingMenuInfo)localIterator.next()).getListView().getAdapter()).notifyDataSetChanged();
    }
  }
  
  private static class CascadingMenuInfo
  {
    public final MenuBuilder menu;
    public final int position;
    public final MenuPopupWindow window;
    
    public CascadingMenuInfo(MenuPopupWindow paramMenuPopupWindow, MenuBuilder paramMenuBuilder, int paramInt)
    {
      window = paramMenuPopupWindow;
      menu = paramMenuBuilder;
      position = paramInt;
    }
    
    public ListView getListView()
    {
      return window.getListView();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface HorizPosition {}
}
