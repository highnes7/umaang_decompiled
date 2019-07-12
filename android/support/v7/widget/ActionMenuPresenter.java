package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.layout;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.PopupCallback;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import support.android.v4.internal.drawable.DrawableCompat;
import support.android.v4.view.ActionProvider;
import support.android.v4.view.ActionProvider.SubUiVisibilityListener;

public class ActionMenuPresenter
  extends BaseMenuPresenter
  implements ActionProvider.SubUiVisibilityListener
{
  public static final String TAG = "ActionMenuPresenter";
  public final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
  public ActionButtonSubmenu mActionButtonPopup;
  public int mActionItemWidthLimit;
  public boolean mExpandedActionViewsExclusive;
  public int mMaxItems;
  public boolean mMaxItemsSet;
  public int mMinCellSize;
  public int mOpenSubMenuId;
  public OverflowMenuButton mOverflowButton;
  public OverflowPopup mOverflowPopup;
  public Drawable mPendingOverflowIcon;
  public boolean mPendingOverflowIconSet;
  public ActionMenuPopupCallback mPopupCallback;
  public final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback();
  public OpenOverflowRunnable mPostedOpenRunnable;
  public boolean mReserveOverflow;
  public boolean mReserveOverflowSet;
  public View mScrapActionButtonView;
  public boolean mStrictWidthLimit;
  public int mWidthLimit;
  public boolean mWidthLimitSet;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }
  
  private View findViewForItem(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)mMenuView;
    if (localViewGroup == null) {
      return null;
    }
    int j = localViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = localViewGroup.getChildAt(i);
      if (((localView instanceof MenuView.ItemView)) && (((MenuView.ItemView)localView).getItemData() == paramMenuItem)) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView)
  {
    paramItemView.initialize(paramMenuItemImpl, 0);
    paramMenuItemImpl = (ActionMenuView)mMenuView;
    paramItemView = (ActionMenuItemView)paramItemView;
    paramItemView.setItemInvoker(paramMenuItemImpl);
    if (mPopupCallback == null) {
      mPopupCallback = new ActionMenuPopupCallback();
    }
    paramItemView.setPopupCallback(mPopupCallback);
  }
  
  public boolean dismissPopupMenus()
  {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == mOverflowButton) {
      return false;
    }
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public boolean flagActionItems()
  {
    Object localObject1 = mMenu;
    Object localObject2;
    int i3;
    if (localObject1 != null)
    {
      localObject2 = ((MenuBuilder)localObject1).getVisibleItems();
      localObject1 = localObject2;
      i3 = ((ArrayList)localObject2).size();
    }
    else
    {
      localObject1 = null;
      i3 = 0;
    }
    int i = mMaxItems;
    int i2 = mActionItemWidthLimit;
    int i6 = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)mMenuView;
    int j = 0;
    int n = 0;
    int k = 0;
    int m = 0;
    int i1;
    while (j < i3)
    {
      localObject2 = (MenuItemImpl)((ArrayList)localObject1).get(j);
      if (((MenuItemImpl)localObject2).requiresActionButton()) {
        k += 1;
      } else if (((MenuItemImpl)localObject2).requestsActionButton()) {
        m += 1;
      } else {
        n = 1;
      }
      i1 = i;
      if (mExpandedActionViewsExclusive)
      {
        i1 = i;
        if (((MenuItemImpl)localObject2).isActionViewExpanded()) {
          i1 = 0;
        }
      }
      j += 1;
      i = i1;
    }
    j = i;
    if (mReserveOverflow) {
      if (n == 0)
      {
        j = i;
        if (m + k <= i) {}
      }
      else
      {
        j = i - 1;
      }
    }
    i = j - k;
    SparseBooleanArray localSparseBooleanArray = mActionButtonGroups;
    localSparseBooleanArray.clear();
    int i4;
    if (mStrictWidthLimit)
    {
      j = mMinCellSize;
      k = i2 / j;
      i4 = j + i2 % j / k;
    }
    else
    {
      i4 = 0;
      k = 0;
    }
    int i5 = 0;
    j = 0;
    for (;;)
    {
      localObject2 = this;
      if (i5 >= i3) {
        break;
      }
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)((ArrayList)localObject1).get(i5);
      View localView;
      if (localMenuItemImpl.requiresActionButton())
      {
        localView = ((ActionMenuPresenter)localObject2).getItemView(localMenuItemImpl, mScrapActionButtonView, localViewGroup);
        if (mScrapActionButtonView == null) {
          mScrapActionButtonView = localView;
        }
        if (mStrictWidthLimit) {
          k -= ActionMenuView.measureChildForCells(localView, i4, k, i6, 0);
        } else {
          localView.measure(i6, i6);
        }
        n = localView.getMeasuredWidth();
        m = n;
        n = i2 - n;
        if (j == 0) {
          j = m;
        }
        m = localMenuItemImpl.getGroupId();
        if (m != 0) {
          localSparseBooleanArray.put(m, true);
        }
        localMenuItemImpl.setIsActionButton(true);
        i1 = j;
        m = n;
      }
      for (;;)
      {
        j = i1;
        break label773;
        if (!localMenuItemImpl.requestsActionButton()) {
          break;
        }
        int i7 = localMenuItemImpl.getGroupId();
        boolean bool = localSparseBooleanArray.get(i7);
        int i8;
        if (((i > 0) || (bool)) && (i2 > 0) && ((!mStrictWidthLimit) || (k > 0))) {
          i8 = 1;
        } else {
          i8 = 0;
        }
        m = i2;
        n = k;
        int i9 = i8;
        i1 = j;
        if (i8 != 0)
        {
          localView = ((ActionMenuPresenter)localObject2).getItemView(localMenuItemImpl, mScrapActionButtonView, localViewGroup);
          if (mScrapActionButtonView == null) {
            mScrapActionButtonView = localView;
          }
          if (mStrictWidthLimit)
          {
            n = ActionMenuView.measureChildForCells(localView, i4, k, i6, 0);
            m = k - n;
            k = m;
            if (n == 0)
            {
              i8 = 0;
              k = m;
            }
          }
          else
          {
            localView.measure(i6, i6);
          }
          n = localView.getMeasuredWidth();
          m = i2 - n;
          i1 = j;
          if (j == 0) {
            i1 = n;
          }
          if (mStrictWidthLimit ? m >= 0 : m + i1 > 0) {
            j = 1;
          } else {
            j = 0;
          }
          i9 = i8 & j;
          n = k;
        }
        if ((i9 != 0) && (i7 != 0))
        {
          localSparseBooleanArray.put(i7, true);
          j = i;
        }
        else
        {
          j = i;
          if (bool)
          {
            localSparseBooleanArray.put(i7, false);
            k = 0;
            for (;;)
            {
              j = i;
              if (k >= i5) {
                break;
              }
              localObject2 = (MenuItemImpl)((ArrayList)localObject1).get(k);
              j = i;
              if (((MenuItemImpl)localObject2).getGroupId() == i7)
              {
                j = i;
                if (((MenuItemImpl)localObject2).isActionButton()) {
                  j = i + 1;
                }
                ((MenuItemImpl)localObject2).setIsActionButton(false);
              }
              k += 1;
              i = j;
            }
          }
        }
        i = j;
        if (i9 != 0) {
          i = j - 1;
        }
        localMenuItemImpl.setIsActionButton(i9);
        k = n;
      }
      localMenuItemImpl.setIsActionButton(false);
      m = i2;
      label773:
      i5 += 1;
      i2 = m;
    }
    return true;
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    View localView2 = paramMenuItemImpl.getActionView();
    View localView1 = localView2;
    if ((localView2 == null) || (paramMenuItemImpl.hasCollapsibleActionView())) {
      localView1 = super.getItemView(paramMenuItemImpl, paramView, paramViewGroup);
    }
    int i;
    if (paramMenuItemImpl.isActionViewExpanded()) {
      i = 8;
    } else {
      i = 0;
    }
    localView1.setVisibility(i);
    paramMenuItemImpl = (ActionMenuView)paramViewGroup;
    paramView = localView1.getLayoutParams();
    if (!paramMenuItemImpl.checkLayoutParams(paramView)) {
      localView1.setLayoutParams(paramMenuItemImpl.generateLayoutParams(paramView));
    }
    return localView1;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    MenuView localMenuView = mMenuView;
    paramViewGroup = super.getMenuView(paramViewGroup);
    if (localMenuView != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    return paramViewGroup;
  }
  
  public Drawable getOverflowIcon()
  {
    OverflowMenuButton localOverflowMenuButton = mOverflowButton;
    if (localOverflowMenuButton != null) {
      return localOverflowMenuButton.getDrawable();
    }
    if (mPendingOverflowIconSet) {
      return mPendingOverflowIcon;
    }
    return null;
  }
  
  public boolean hideOverflowMenu()
  {
    Object localObject = mPostedOpenRunnable;
    if (localObject != null)
    {
      MenuView localMenuView = mMenuView;
      if (localMenuView != null)
      {
        ((View)localMenuView).removeCallbacks((Runnable)localObject);
        mPostedOpenRunnable = null;
        return true;
      }
    }
    localObject = mOverflowPopup;
    if (localObject != null)
    {
      ((MenuPopupHelper)localObject).dismiss();
      return true;
    }
    return false;
  }
  
  public boolean hideSubMenus()
  {
    ActionButtonSubmenu localActionButtonSubmenu = mActionButtonPopup;
    if (localActionButtonSubmenu != null)
    {
      localActionButtonSubmenu.dismiss();
      return true;
    }
    return false;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    mContext = paramContext;
    mInflater = LayoutInflater.from(mContext);
    mMenu = paramMenuBuilder;
    paramMenuBuilder = paramContext.getResources();
    if (!mReserveOverflowSet)
    {
      i = Build.VERSION.SDK_INT;
      mReserveOverflow = true;
    }
    boolean bool = mWidthLimitSet;
    int i = 2;
    if (!bool) {
      mWidthLimit = (getResourcesgetDisplayMetricswidthPixels / 2);
    }
    int j;
    if (!mMaxItemsSet)
    {
      paramContext = paramContext.getResources().getConfiguration();
      j = screenWidthDp;
      int k = screenHeightDp;
      if ((smallestScreenWidthDp <= 600) && (j <= 600) && ((j <= 960) || (k <= 720)) && ((j <= 720) || (k <= 960)))
      {
        if ((j < 500) && ((j <= 640) || (k <= 480)) && ((j <= 480) || (k <= 640)))
        {
          if (j >= 360) {
            i = 3;
          }
        }
        else {
          i = 4;
        }
      }
      else {
        i = 5;
      }
      mMaxItems = i;
    }
    i = mWidthLimit;
    if (mReserveOverflow)
    {
      if (mOverflowButton == null)
      {
        mOverflowButton = new OverflowMenuButton(mSystemContext);
        if (mPendingOverflowIconSet)
        {
          mOverflowButton.setImageDrawable(mPendingOverflowIcon);
          mPendingOverflowIcon = null;
          mPendingOverflowIconSet = false;
        }
        j = View.MeasureSpec.makeMeasureSpec(0, 0);
        mOverflowButton.measure(j, j);
      }
      i -= mOverflowButton.getMeasuredWidth();
    }
    else
    {
      mOverflowButton = null;
    }
    mActionItemWidthLimit = i;
    mMinCellSize = ((int)(getDisplayMetricsdensity * 56.0F));
    mScrapActionButtonView = null;
  }
  
  public boolean isOverflowMenuShowPending()
  {
    return (mPostedOpenRunnable != null) || (isOverflowMenuShowing());
  }
  
  public boolean isOverflowMenuShowing()
  {
    OverflowPopup localOverflowPopup = mOverflowPopup;
    return (localOverflowPopup != null) && (localOverflowPopup.isShowing());
  }
  
  public boolean isOverflowReserved()
  {
    return mReserveOverflow;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    dismissPopupMenus();
    MenuPresenter.Callback localCallback = mCallback;
    if (localCallback != null) {
      localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!mMaxItemsSet)
    {
      paramConfiguration = mContext.getResources().getConfiguration();
      int i = screenWidthDp;
      int j = screenHeightDp;
      if ((smallestScreenWidthDp <= 600) && (i <= 600) && ((i <= 960) || (j <= 720)) && ((i <= 720) || (j <= 960)))
      {
        if ((i < 500) && ((i <= 640) || (j <= 480)) && ((i <= 480) || (j <= 640)))
        {
          if (i >= 360) {
            i = 3;
          } else {
            i = 2;
          }
        }
        else {
          i = 4;
        }
      }
      else {
        i = 5;
      }
      mMaxItems = i;
    }
    paramConfiguration = mMenu;
    if (paramConfiguration != null) {
      paramConfiguration.onItemsChanged(true);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      return;
    }
    int i = openSubMenuId;
    if (i > 0)
    {
      paramParcelable = mMenu.findItem(i);
      if (paramParcelable != null) {
        onSubMenuSelected((SubMenuBuilder)paramParcelable.getSubMenu());
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    openSubMenuId = mOpenSubMenuId;
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    boolean bool1 = paramSubMenuBuilder.hasVisibleItems();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    for (Object localObject = paramSubMenuBuilder; ((SubMenuBuilder)localObject).getParentMenu() != mMenu; localObject = (SubMenuBuilder)((SubMenuBuilder)localObject).getParentMenu()) {}
    localObject = findViewForItem(((SubMenuBuilder)localObject).getItem());
    if (localObject == null) {
      return false;
    }
    mOpenSubMenuId = paramSubMenuBuilder.getItem().getItemId();
    int j = paramSubMenuBuilder.size();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      MenuItem localMenuItem = paramSubMenuBuilder.getItem(i);
      if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null))
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    mActionButtonPopup = new ActionButtonSubmenu(mContext, paramSubMenuBuilder, (View)localObject);
    mActionButtonPopup.setForceShowIcon(bool1);
    mActionButtonPopup.show();
    localObject = mCallback;
    if (localObject != null) {
      ((MenuPresenter.Callback)localObject).onOpenSubMenu(paramSubMenuBuilder);
    }
    return true;
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.onSubMenuSelected(null);
      return;
    }
    MenuBuilder localMenuBuilder = mMenu;
    if (localMenuBuilder != null) {
      localMenuBuilder.close(false);
    }
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    mExpandedActionViewsExclusive = paramBoolean;
  }
  
  public void setItemLimit(int paramInt)
  {
    mMaxItems = paramInt;
    mMaxItemsSet = true;
  }
  
  public void setMenuView(ActionMenuView paramActionMenuView)
  {
    mMenuView = paramActionMenuView;
    paramActionMenuView.initialize(mMenu);
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    OverflowMenuButton localOverflowMenuButton = mOverflowButton;
    if (localOverflowMenuButton != null)
    {
      localOverflowMenuButton.setImageDrawable(paramDrawable);
      return;
    }
    mPendingOverflowIconSet = true;
    mPendingOverflowIcon = paramDrawable;
  }
  
  public void setReserveOverflow(boolean paramBoolean)
  {
    mReserveOverflow = paramBoolean;
    mReserveOverflowSet = true;
  }
  
  public void setWidthLimit(int paramInt, boolean paramBoolean)
  {
    mWidthLimit = paramInt;
    mStrictWidthLimit = paramBoolean;
    mWidthLimitSet = true;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return paramMenuItemImpl.isActionButton();
  }
  
  public boolean showOverflowMenu()
  {
    if ((mReserveOverflow) && (!isOverflowMenuShowing()))
    {
      MenuBuilder localMenuBuilder = mMenu;
      if ((localMenuBuilder != null) && (mMenuView != null) && (mPostedOpenRunnable == null) && (!localMenuBuilder.getNonActionItems().isEmpty()))
      {
        mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(mContext, mMenu, mOverflowButton, true));
        ((View)mMenuView).post(mPostedOpenRunnable);
        super.onSubMenuSelected(null);
        return true;
      }
    }
    return false;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    super.updateMenuView(paramBoolean);
    ((View)mMenuView).requestLayout();
    Object localObject1 = mMenu;
    int j = 0;
    int k;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((MenuBuilder)localObject1).getActionItems();
      k = ((ArrayList)localObject1).size();
      i = 0;
      while (i < k)
      {
        localObject2 = ((MenuItemImpl)((ArrayList)localObject1).get(i)).getSupportActionProvider();
        if (localObject2 != null) {
          ((ActionProvider)localObject2).setSubUiVisibilityListener(this);
        }
        i += 1;
      }
    }
    localObject1 = mMenu;
    if (localObject1 != null) {
      localObject1 = ((MenuBuilder)localObject1).getNonActionItems();
    } else {
      localObject1 = null;
    }
    int i = j;
    boolean bool;
    if (mReserveOverflow)
    {
      i = j;
      if (localObject1 != null)
      {
        k = ((ArrayList)localObject1).size();
        if (k == 1)
        {
          bool = ((MenuItemImpl)((ArrayList)localObject1).get(0)).isActionViewExpanded() ^ true;
        }
        else
        {
          bool = j;
          if (k > 0) {
            bool = true;
          }
        }
      }
    }
    if (bool)
    {
      if (mOverflowButton == null) {
        mOverflowButton = new OverflowMenuButton(mSystemContext);
      }
      localObject1 = (ViewGroup)mOverflowButton.getParent();
      if (localObject1 != mMenuView)
      {
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView(mOverflowButton);
        }
        localObject1 = (ActionMenuView)mMenuView;
        ((ViewGroup)localObject1).addView(mOverflowButton, ((ActionMenuView)localObject1).generateOverflowButtonLayoutParams());
      }
    }
    else
    {
      localObject1 = mOverflowButton;
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).getParent();
        localObject2 = mMenuView;
        if (localObject1 == localObject2) {
          ((ViewGroup)localObject2).removeView(mOverflowButton);
        }
      }
    }
    ((ActionMenuView)mMenuView).setOverflowReserved(mReserveOverflow);
  }
  
  private class ActionButtonSubmenu
    extends MenuPopupHelper
  {
    public ActionButtonSubmenu(Context paramContext, SubMenuBuilder paramSubMenuBuilder, View paramView)
    {
      super(paramSubMenuBuilder, paramView, false, R.attr.actionOverflowMenuStyle);
      if (!((MenuItemImpl)paramSubMenuBuilder.getItem()).isActionButton())
      {
        paramSubMenuBuilder = mOverflowButton;
        paramContext = paramSubMenuBuilder;
        if (paramSubMenuBuilder == null) {
          paramContext = (View)ActionMenuPresenter.access$200(ActionMenuPresenter.this);
        }
        setAnchorView(paramContext);
      }
      setPresenterCallback(mPopupPresenterCallback);
    }
    
    public void onDismiss()
    {
      ActionMenuPresenter localActionMenuPresenter = ActionMenuPresenter.this;
      mActionButtonPopup = null;
      mOpenSubMenuId = 0;
      super.onDismiss();
    }
  }
  
  private class ActionMenuPopupCallback
    extends ActionMenuItemView.PopupCallback
  {
    public ActionMenuPopupCallback() {}
    
    public ShowableListMenu getPopup()
    {
      ActionMenuPresenter.ActionButtonSubmenu localActionButtonSubmenu = mActionButtonPopup;
      if (localActionButtonSubmenu != null) {
        return localActionButtonSubmenu.getPopup();
      }
      return null;
    }
  }
  
  private class OpenOverflowRunnable
    implements Runnable
  {
    public ActionMenuPresenter.OverflowPopup mPopup;
    
    public OpenOverflowRunnable(ActionMenuPresenter.OverflowPopup paramOverflowPopup)
    {
      mPopup = paramOverflowPopup;
    }
    
    public void run()
    {
      if (ActionMenuPresenter.access$300(ActionMenuPresenter.this) != null) {
        ActionMenuPresenter.access$400(ActionMenuPresenter.this).changeMenuMode();
      }
      View localView = (View)ActionMenuPresenter.access$500(ActionMenuPresenter.this);
      if ((localView != null) && (localView.getWindowToken() != null) && (mPopup.tryShow())) {
        mOverflowPopup = mPopup;
      }
      mPostedOpenRunnable = null;
    }
  }
  
  private class OverflowMenuButton
    extends AppCompatImageView
    implements ActionMenuView.ActionMenuChildView
  {
    public final float[] mTempPts = new float[2];
    
    public OverflowMenuButton(Context paramContext)
    {
      super(null, R.attr.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      TooltipCompat.setTooltipText(this, getContentDescription());
      setOnTouchListener(new ForwardingListener(this)
      {
        public ShowableListMenu getPopup()
        {
          ActionMenuPresenter.OverflowPopup localOverflowPopup = mOverflowPopup;
          if (localOverflowPopup == null) {
            return null;
          }
          return localOverflowPopup.getPopup();
        }
        
        public boolean onForwardingStarted()
        {
          showOverflowMenu();
          return true;
        }
        
        public boolean onForwardingStopped()
        {
          ActionMenuPresenter localActionMenuPresenter = ActionMenuPresenter.this;
          if (mPostedOpenRunnable != null) {
            return false;
          }
          localActionMenuPresenter.hideOverflowMenu();
          return true;
        }
      });
    }
    
    public boolean needsDividerAfter()
    {
      return false;
    }
    
    public boolean needsDividerBefore()
    {
      return false;
    }
    
    public boolean performClick()
    {
      if (super.performClick()) {
        return true;
      }
      playSoundEffect(0);
      showOverflowMenu();
      return true;
    }
    
    public boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      Drawable localDrawable1 = getDrawable();
      Drawable localDrawable2 = getBackground();
      if ((localDrawable1 != null) && (localDrawable2 != null))
      {
        int i = getWidth();
        paramInt2 = getHeight();
        paramInt1 = Math.max(i, paramInt2) / 2;
        int j = getPaddingLeft();
        int k = getPaddingRight();
        paramInt3 = getPaddingTop();
        paramInt4 = getPaddingBottom();
        i = (i + (j - k)) / 2;
        paramInt2 = (paramInt2 + (paramInt3 - paramInt4)) / 2;
        DrawableCompat.setHotspotBounds(localDrawable2, i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
      }
      return bool;
    }
  }
  
  private class OverflowPopup
    extends MenuPopupHelper
  {
    public OverflowPopup(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean)
    {
      super(paramMenuBuilder, paramView, paramBoolean, R.attr.actionOverflowMenuStyle);
      setGravity(8388613);
      setPresenterCallback(mPopupPresenterCallback);
    }
    
    public void onDismiss()
    {
      if (ActionMenuPresenter.access$000(ActionMenuPresenter.this) != null) {
        ActionMenuPresenter.access$100(ActionMenuPresenter.this).close();
      }
      mOverflowPopup = null;
      super.onDismiss();
    }
  }
  
  private class PopupPresenterCallback
    implements MenuPresenter.Callback
  {
    public PopupPresenterCallback() {}
    
    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      if ((paramMenuBuilder instanceof SubMenuBuilder)) {
        paramMenuBuilder.getRootMenu().close(false);
      }
      MenuPresenter.Callback localCallback = getCallback();
      if (localCallback != null) {
        localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
      }
    }
    
    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      if (paramMenuBuilder == null) {
        return false;
      }
      mOpenSubMenuId = ((SubMenuBuilder)paramMenuBuilder).getItem().getItemId();
      MenuPresenter.Callback localCallback = getCallback();
      if (localCallback != null) {
        return localCallback.onOpenSubMenu(paramMenuBuilder);
      }
      return false;
    }
  }
  
  private static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ActionMenuPresenter.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ActionMenuPresenter.SavedState(paramAnonymousParcel);
      }
      
      public ActionMenuPresenter.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ActionMenuPresenter.SavedState[paramAnonymousInt];
      }
    };
    public int openSubMenuId;
    
    public SavedState() {}
    
    public SavedState(Parcel paramParcel)
    {
      openSubMenuId = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(openSubMenuId);
    }
  }
}
