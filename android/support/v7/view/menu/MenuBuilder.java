package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import b.b.a.N;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import support.android.v4.content.ContextCompat;
import support.android.v4.media.session.SupportMenu;
import support.android.v4.view.ActionProvider;
import support.android.v4.view.f;

@N({b.b.a.N.a.b})
public class MenuBuilder
  implements SupportMenu
{
  public static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
  public static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
  public static final String PRESENTER_KEY = "android:menu:presenters";
  public static final String TAG = "MenuBuilder";
  public static final int[] sCategoryToOrder = { 1, 4, 5, 3, 2, 0 };
  public ArrayList<MenuItemImpl> mActionItems;
  public Callback mCallback;
  public final Context mContext;
  public ContextMenu.ContextMenuInfo mCurrentMenuInfo;
  public int mDefaultShowAsAction = 0;
  public MenuItemImpl mExpandedItem;
  public SparseArray<Parcelable> mFrozenViewStates;
  public boolean mGroupDividerEnabled = false;
  public Drawable mHeaderIcon;
  public CharSequence mHeaderTitle;
  public View mHeaderView;
  public boolean mIsActionItemsStale;
  public boolean mIsClosing = false;
  public boolean mIsVisibleItemsStale;
  public ArrayList<MenuItemImpl> mItems;
  public boolean mItemsChangedWhileDispatchPrevented = false;
  public ArrayList<MenuItemImpl> mNonActionItems;
  public boolean mOptionalIconsVisible = false;
  public boolean mOverrideVisibleItems;
  public CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList();
  public boolean mPreventDispatchingItemsChanged = false;
  public boolean mQwertyMode;
  public final Resources mResources;
  public boolean mShortcutsVisible;
  public boolean mStructureChangedWhileDispatchPrevented = false;
  public ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList();
  public ArrayList<MenuItemImpl> mVisibleItems;
  
  public MenuBuilder(Context paramContext)
  {
    mContext = paramContext;
    mResources = paramContext.getResources();
    mItems = new ArrayList();
    mVisibleItems = new ArrayList();
    mIsVisibleItemsStale = true;
    mActionItems = new ArrayList();
    mNonActionItems = new ArrayList();
    mIsActionItemsStale = true;
    setShortcutsVisibleInner(true);
  }
  
  private MenuItemImpl createNewMenuItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    return new MenuItemImpl(this, paramInt1, paramInt2, paramInt3, paramInt4, paramCharSequence, paramInt5);
  }
  
  private void dispatchPresenterUpdate(boolean paramBoolean)
  {
    if (mPresenters.isEmpty()) {
      return;
    }
    stopDispatchingItemsChanged();
    Iterator localIterator = mPresenters.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null) {
        mPresenters.remove(localWeakReference);
      } else {
        localMenuPresenter.updateMenuView(paramBoolean);
      }
    }
    startDispatchingItemsChanged();
  }
  
  private void dispatchRestoreInstanceState(Bundle paramBundle)
  {
    paramBundle = paramBundle.getSparseParcelableArray("android:menu:presenters");
    if (paramBundle != null)
    {
      if (mPresenters.isEmpty()) {
        return;
      }
      Iterator localIterator = mPresenters.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        MenuPresenter localMenuPresenter = (MenuPresenter)((WeakReference)localObject).get();
        if (localMenuPresenter == null)
        {
          mPresenters.remove(localObject);
        }
        else
        {
          int i = localMenuPresenter.getId();
          if (i > 0)
          {
            localObject = (Parcelable)paramBundle.get(i);
            if (localObject != null) {
              localMenuPresenter.onRestoreInstanceState((Parcelable)localObject);
            }
          }
        }
      }
    }
  }
  
  private void dispatchSaveInstanceState(Bundle paramBundle)
  {
    if (mPresenters.isEmpty()) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    Iterator localIterator = mPresenters.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)((WeakReference)localObject).get();
      if (localMenuPresenter == null)
      {
        mPresenters.remove(localObject);
      }
      else
      {
        int i = localMenuPresenter.getId();
        if (i > 0)
        {
          localObject = localMenuPresenter.onSaveInstanceState();
          if (localObject != null) {
            localSparseArray.put(i, localObject);
          }
        }
      }
    }
    paramBundle.putSparseParcelableArray("android:menu:presenters", localSparseArray);
  }
  
  private boolean dispatchSubMenuSelected(SubMenuBuilder paramSubMenuBuilder, MenuPresenter paramMenuPresenter)
  {
    boolean bool2 = mPresenters.isEmpty();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramMenuPresenter != null) {
      bool1 = paramMenuPresenter.onSubMenuSelected(paramSubMenuBuilder);
    }
    paramMenuPresenter = mPresenters.iterator();
    while (paramMenuPresenter.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramMenuPresenter.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null) {
        mPresenters.remove(localWeakReference);
      } else if (!bool1) {
        bool1 = localMenuPresenter.onSubMenuSelected(paramSubMenuBuilder);
      }
    }
    return bool1;
  }
  
  public static int findInsertIndex(ArrayList paramArrayList, int paramInt)
  {
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      if (((MenuItemImpl)paramArrayList.get(i)).getOrdering() <= paramInt) {
        return i + 1;
      }
      i -= 1;
    }
    return 0;
  }
  
  public static int getOrdering(int paramInt)
  {
    int i = (0xFFFF0000 & paramInt) >> 16;
    if (i >= 0)
    {
      int[] arrayOfInt = sCategoryToOrder;
      if (i < arrayOfInt.length) {
        return paramInt & 0xFFFF | arrayOfInt[i] << 16;
      }
    }
    throw new IllegalArgumentException("order does not contain a valid category.");
  }
  
  private void removeItemAtInt(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= mItems.size()) {
        return;
      }
      mItems.remove(paramInt);
      if (paramBoolean) {
        onItemsChanged(true);
      }
    }
  }
  
  private void setHeaderInternal(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    Resources localResources = getResources();
    if (paramView != null)
    {
      mHeaderView = paramView;
      mHeaderTitle = null;
      mHeaderIcon = null;
    }
    else
    {
      if (paramInt1 > 0) {
        mHeaderTitle = localResources.getText(paramInt1);
      } else if (paramCharSequence != null) {
        mHeaderTitle = paramCharSequence;
      }
      if (paramInt2 > 0) {
        mHeaderIcon = ContextCompat.getDrawable(getContext(), paramInt2);
      } else if (paramDrawable != null) {
        mHeaderIcon = paramDrawable;
      }
      mHeaderView = null;
    }
    onItemsChanged(false);
  }
  
  private void setShortcutsVisibleInner(boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramBoolean) && (mResources.getConfiguration().keyboard != 1) && (f.get(ViewConfiguration.get(mContext), mContext))) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    mShortcutsVisible = paramBoolean;
  }
  
  public MenuItem add(int paramInt)
  {
    return addInternal(0, 0, 0, mResources.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addInternal(paramInt1, paramInt2, paramInt3, mResources.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return addInternal(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = mContext.getPackageManager();
    int k = 0;
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    int j = k;
    if ((paramInt4 & 0x1) == 0)
    {
      removeGroup(paramInt1);
      j = k;
    }
    while (j < i)
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localList.get(j);
      paramInt4 = specificIndex;
      if (paramInt4 < 0) {
        paramComponentName = paramIntent;
      } else {
        paramComponentName = paramArrayOfIntent[paramInt4];
      }
      paramComponentName = new Intent(paramComponentName);
      paramComponentName.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
      paramComponentName = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
      if (paramArrayOfMenuItem != null)
      {
        paramInt4 = specificIndex;
        if (paramInt4 >= 0) {
          paramArrayOfMenuItem[paramInt4] = paramComponentName;
        }
      }
      j += 1;
    }
    return i;
  }
  
  public MenuItem addInternal(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i = getOrdering(paramInt3);
    paramCharSequence = createNewMenuItem(paramInt1, paramInt2, paramInt3, i, paramCharSequence, mDefaultShowAsAction);
    Object localObject = mCurrentMenuInfo;
    if (localObject != null) {
      paramCharSequence.setMenuInfo((ContextMenu.ContextMenuInfo)localObject);
    }
    localObject = mItems;
    ((ArrayList)localObject).add(findInsertIndex((ArrayList)localObject, i), paramCharSequence);
    onItemsChanged(true);
    return paramCharSequence;
  }
  
  public void addMenuPresenter(MenuPresenter paramMenuPresenter)
  {
    addMenuPresenter(paramMenuPresenter, mContext);
  }
  
  public void addMenuPresenter(MenuPresenter paramMenuPresenter, Context paramContext)
  {
    mPresenters.add(new WeakReference(paramMenuPresenter));
    paramMenuPresenter.initForMenu(paramContext, this);
    mIsActionItemsStale = true;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, mResources.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, mResources.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (MenuItemImpl)addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
    SubMenuBuilder localSubMenuBuilder = new SubMenuBuilder(mContext, this, paramCharSequence);
    paramCharSequence.setSubMenu(localSubMenuBuilder);
    return localSubMenuBuilder;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public void changeMenuMode()
  {
    Callback localCallback = mCallback;
    if (localCallback != null) {
      localCallback.onMenuModeChange(this);
    }
  }
  
  public void clear()
  {
    MenuItemImpl localMenuItemImpl = mExpandedItem;
    if (localMenuItemImpl != null) {
      collapseItemActionView(localMenuItemImpl);
    }
    mItems.clear();
    onItemsChanged(true);
  }
  
  public void clearAll()
  {
    mPreventDispatchingItemsChanged = true;
    clear();
    clearHeader();
    mPresenters.clear();
    mPreventDispatchingItemsChanged = false;
    mItemsChangedWhileDispatchPrevented = false;
    mStructureChangedWhileDispatchPrevented = false;
    onItemsChanged(true);
  }
  
  public void clearHeader()
  {
    mHeaderIcon = null;
    mHeaderTitle = null;
    mHeaderView = null;
    onItemsChanged(false);
  }
  
  public void close()
  {
    close(true);
  }
  
  public final void close(boolean paramBoolean)
  {
    if (mIsClosing) {
      return;
    }
    mIsClosing = true;
    Iterator localIterator = mPresenters.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null) {
        mPresenters.remove(localWeakReference);
      } else {
        localMenuPresenter.onCloseMenu(this, paramBoolean);
      }
    }
    mIsClosing = false;
  }
  
  public boolean collapseItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    boolean bool2 = mPresenters.isEmpty();
    boolean bool1 = false;
    if (!bool2)
    {
      if (mExpandedItem != paramMenuItemImpl) {
        return false;
      }
      stopDispatchingItemsChanged();
      Iterator localIterator = mPresenters.iterator();
      boolean bool3;
      do
      {
        MenuPresenter localMenuPresenter;
        for (;;)
        {
          bool2 = bool1;
          if (!localIterator.hasNext()) {
            break label110;
          }
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          localMenuPresenter = (MenuPresenter)localWeakReference.get();
          if (localMenuPresenter != null) {
            break;
          }
          mPresenters.remove(localWeakReference);
        }
        bool3 = localMenuPresenter.collapseItemActionView(this, paramMenuItemImpl);
        bool2 = bool3;
        bool1 = bool2;
      } while (!bool3);
      label110:
      startDispatchingItemsChanged();
      if (bool2)
      {
        mExpandedItem = null;
        return bool2;
      }
    }
    else
    {
      return false;
    }
    return bool2;
  }
  
  public boolean dispatchMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    Callback localCallback = mCallback;
    return (localCallback != null) && (localCallback.onMenuItemSelected(paramMenuBuilder, paramMenuItem));
  }
  
  public boolean expandItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    boolean bool2 = mPresenters.isEmpty();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    stopDispatchingItemsChanged();
    Iterator localIterator = mPresenters.iterator();
    boolean bool3;
    do
    {
      MenuPresenter localMenuPresenter;
      for (;;)
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break label102;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        localMenuPresenter = (MenuPresenter)localWeakReference.get();
        if (localMenuPresenter != null) {
          break;
        }
        mPresenters.remove(localWeakReference);
      }
      bool3 = localMenuPresenter.expandItemActionView(this, paramMenuItemImpl);
      bool2 = bool3;
      bool1 = bool2;
    } while (!bool3);
    label102:
    startDispatchingItemsChanged();
    if (bool2) {
      mExpandedItem = paramMenuItemImpl;
    }
    return bool2;
  }
  
  public int findGroupIndex(int paramInt)
  {
    return findGroupIndex(paramInt, 0);
  }
  
  public int findGroupIndex(int paramInt1, int paramInt2)
  {
    int j = size();
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    while (i < j)
    {
      if (((MenuItemImpl)mItems.get(i)).getGroupId() == paramInt1) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public MenuItem findItem(int paramInt)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (MenuItemImpl)mItems.get(i);
      if (((MenuItemImpl)localObject).getItemId() == paramInt) {
        return localObject;
      }
      if (((MenuItemImpl)localObject).hasSubMenu())
      {
        localObject = ((MenuItemImpl)localObject).getSubMenu().findItem(paramInt);
        if (localObject != null) {
          return localObject;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public int findItemIndex(int paramInt)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (((MenuItemImpl)mItems.get(i)).getItemId() == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public MenuItemImpl findItemWithShortcutForKey(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = mTempShortcutItemList;
    localArrayList.clear();
    findItemsWithShortcutForKey(localArrayList, paramInt, paramKeyEvent);
    if (localArrayList.isEmpty()) {
      return null;
    }
    int k = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    paramKeyEvent.getKeyData(localKeyData);
    int m = localArrayList.size();
    if (m == 1) {
      return (MenuItemImpl)localArrayList.get(0);
    }
    boolean bool = isQwertyMode();
    int i = 0;
    while (i < m)
    {
      paramKeyEvent = (MenuItemImpl)localArrayList.get(i);
      int j;
      if (bool) {
        j = paramKeyEvent.getAlphabeticShortcut();
      } else {
        j = paramKeyEvent.getNumericShortcut();
      }
      if (((j == meta[0]) && ((k & 0x2) == 0)) || ((j == meta[2]) && ((k & 0x2) != 0))) {
        return paramKeyEvent;
      }
      if ((bool) && (j == 8) && (paramInt == 67)) {
        return paramKeyEvent;
      }
      i += 1;
    }
    return null;
    return paramKeyEvent;
  }
  
  public void findItemsWithShortcutForKey(List paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = isQwertyMode();
    int m = paramKeyEvent.getModifiers();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67)) {
      return;
    }
    int n = mItems.size();
    int i = 0;
    while (i < n)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)mItems.get(i);
      if (localMenuItemImpl.hasSubMenu()) {
        ((MenuBuilder)localMenuItemImpl.getSubMenu()).findItemsWithShortcutForKey(paramList, paramInt, paramKeyEvent);
      }
      int j;
      if (bool) {
        j = localMenuItemImpl.getAlphabeticShortcut();
      } else {
        j = localMenuItemImpl.getNumericShortcut();
      }
      int k;
      if (bool) {
        k = localMenuItemImpl.getAlphabeticModifiers();
      } else {
        k = localMenuItemImpl.getNumericModifiers();
      }
      if ((m & 0x1100F) == (k & 0x1100F)) {
        k = 1;
      } else {
        k = 0;
      }
      if ((k != 0) && (j != 0))
      {
        char[] arrayOfChar = meta;
        if (((j == arrayOfChar[0]) || (j == arrayOfChar[2]) || ((bool) && (j == 8) && (paramInt == 67))) && (localMenuItemImpl.isEnabled())) {
          paramList.add(localMenuItemImpl);
        }
      }
      i += 1;
    }
  }
  
  public void flagActionItems()
  {
    ArrayList localArrayList = getVisibleItems();
    if (!mIsActionItemsStale) {
      return;
    }
    Object localObject = mPresenters.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if (localMenuPresenter == null) {
        mPresenters.remove(localWeakReference);
      } else {
        i |= localMenuPresenter.flagActionItems();
      }
    }
    if (i != 0)
    {
      mActionItems.clear();
      mNonActionItems.clear();
      int k = localArrayList.size();
      i = 0;
      while (i < k)
      {
        localObject = (MenuItemImpl)localArrayList.get(i);
        if (((MenuItemImpl)localObject).isActionButton()) {
          mActionItems.add(localObject);
        } else {
          mNonActionItems.add(localObject);
        }
        int j;
        i += 1;
      }
    }
    mActionItems.clear();
    mNonActionItems.clear();
    mNonActionItems.addAll(getVisibleItems());
    mIsActionItemsStale = false;
  }
  
  public ArrayList getActionItems()
  {
    flagActionItems();
    return mActionItems;
  }
  
  public String getActionViewStatesKey()
  {
    return "android:menu:actionviewstates";
  }
  
  public Context getContext()
  {
    return mContext;
  }
  
  public MenuItemImpl getExpandedItem()
  {
    return mExpandedItem;
  }
  
  public Drawable getHeaderIcon()
  {
    return mHeaderIcon;
  }
  
  public CharSequence getHeaderTitle()
  {
    return mHeaderTitle;
  }
  
  public View getHeaderView()
  {
    return mHeaderView;
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)mItems.get(paramInt);
  }
  
  public ArrayList getNonActionItems()
  {
    flagActionItems();
    return mNonActionItems;
  }
  
  public boolean getOptionalIconsVisible()
  {
    return mOptionalIconsVisible;
  }
  
  public Resources getResources()
  {
    return mResources;
  }
  
  public MenuBuilder getRootMenu()
  {
    return this;
  }
  
  public ArrayList getVisibleItems()
  {
    if (!mIsVisibleItemsStale) {
      return mVisibleItems;
    }
    mVisibleItems.clear();
    int j = mItems.size();
    int i = 0;
    while (i < j)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)mItems.get(i);
      if (localMenuItemImpl.isVisible()) {
        mVisibleItems.add(localMenuItemImpl);
      }
      i += 1;
    }
    mIsVisibleItemsStale = false;
    mIsActionItemsStale = true;
    return mVisibleItems;
  }
  
  public boolean hasVisibleItems()
  {
    if (mOverrideVisibleItems) {
      return true;
    }
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (((MenuItemImpl)mItems.get(i)).isVisible()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isGroupDividerEnabled()
  {
    return mGroupDividerEnabled;
  }
  
  public boolean isQwertyMode()
  {
    return mQwertyMode;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return findItemWithShortcutForKey(paramInt, paramKeyEvent) != null;
  }
  
  public boolean isShortcutsVisible()
  {
    return mShortcutsVisible;
  }
  
  public void onItemActionRequestChanged(MenuItemImpl paramMenuItemImpl)
  {
    mIsActionItemsStale = true;
    onItemsChanged(true);
  }
  
  public void onItemVisibleChanged(MenuItemImpl paramMenuItemImpl)
  {
    mIsVisibleItemsStale = true;
    onItemsChanged(true);
  }
  
  public void onItemsChanged(boolean paramBoolean)
  {
    if (!mPreventDispatchingItemsChanged)
    {
      if (paramBoolean)
      {
        mIsVisibleItemsStale = true;
        mIsActionItemsStale = true;
      }
      dispatchPresenterUpdate(paramBoolean);
      return;
    }
    mItemsChangedWhileDispatchPrevented = true;
    if (paramBoolean) {
      mStructureChangedWhileDispatchPrevented = true;
    }
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return performItemAction(findItem(paramInt1), paramInt2);
  }
  
  public boolean performItemAction(MenuItem paramMenuItem, int paramInt)
  {
    return performItemAction(paramMenuItem, null, paramInt);
  }
  
  public boolean performItemAction(MenuItem paramMenuItem, MenuPresenter paramMenuPresenter, int paramInt)
  {
    Object localObject = (MenuItemImpl)paramMenuItem;
    boolean bool1;
    if (localObject != null)
    {
      if (!((MenuItemImpl)localObject).isEnabled()) {
        return false;
      }
      boolean bool2 = ((MenuItemImpl)localObject).invoke();
      paramMenuItem = ((MenuItemImpl)localObject).getSupportActionProvider();
      int i;
      if ((paramMenuItem != null) && (paramMenuItem.hasSubMenu())) {
        i = 1;
      } else {
        i = 0;
      }
      if (((MenuItemImpl)localObject).hasCollapsibleActionView())
      {
        bool2 |= ((MenuItemImpl)localObject).expandActionView();
        bool1 = bool2;
        if (bool2)
        {
          close(true);
          return bool2;
        }
      }
      else if ((!((MenuItemImpl)localObject).hasSubMenu()) && (i == 0))
      {
        bool1 = bool2;
        if ((paramInt & 0x1) == 0)
        {
          close(true);
          return bool2;
        }
      }
      else
      {
        if ((paramInt & 0x4) == 0) {
          close(false);
        }
        if (!((MenuItemImpl)localObject).hasSubMenu()) {
          ((MenuItemImpl)localObject).setSubMenu(new SubMenuBuilder(getContext(), this, (MenuItemImpl)localObject));
        }
        localObject = (SubMenuBuilder)((MenuItemImpl)localObject).getSubMenu();
        if (i != 0) {
          paramMenuItem.onPrepareSubMenu((SubMenu)localObject);
        }
        bool2 |= dispatchSubMenuSelected((SubMenuBuilder)localObject, paramMenuPresenter);
        bool1 = bool2;
        if (!bool2)
        {
          close(true);
          return bool2;
        }
      }
    }
    else
    {
      return false;
    }
    return bool1;
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = findItemWithShortcutForKey(paramInt1, paramKeyEvent);
    boolean bool;
    if (paramKeyEvent != null) {
      bool = performItemAction(paramKeyEvent, paramInt2);
    } else {
      bool = false;
    }
    if ((paramInt2 & 0x2) != 0) {
      close(true);
    }
    return bool;
  }
  
  public void removeGroup(int paramInt)
  {
    int j = findGroupIndex(paramInt);
    if (j >= 0)
    {
      int k = mItems.size();
      int i = 0;
      while ((i < k - j) && (((MenuItemImpl)mItems.get(j)).getGroupId() == paramInt))
      {
        removeItemAtInt(j, false);
        i += 1;
      }
      onItemsChanged(true);
    }
  }
  
  public void removeItem(int paramInt)
  {
    removeItemAtInt(findItemIndex(paramInt), true);
  }
  
  public void removeItemAt(int paramInt)
  {
    removeItemAtInt(paramInt, true);
  }
  
  public void removeMenuPresenter(MenuPresenter paramMenuPresenter)
  {
    Iterator localIterator = mPresenters.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      MenuPresenter localMenuPresenter = (MenuPresenter)localWeakReference.get();
      if ((localMenuPresenter == null) || (localMenuPresenter == paramMenuPresenter)) {
        mPresenters.remove(localWeakReference);
      }
    }
  }
  
  public void restoreActionViewStates(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    SparseArray localSparseArray = paramBundle.getSparseParcelableArray(getActionViewStatesKey());
    int j = size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = getItem(i);
      View localView = localMenuItem.getActionView();
      if ((localView != null) && (localView.getId() != -1)) {
        localView.restoreHierarchyState(localSparseArray);
      }
      if (localMenuItem.hasSubMenu()) {
        ((SubMenuBuilder)localMenuItem.getSubMenu()).restoreActionViewStates(paramBundle);
      }
      i += 1;
    }
    i = paramBundle.getInt("android:menu:expandedactionview");
    if (i > 0)
    {
      paramBundle = findItem(i);
      if (paramBundle != null) {
        paramBundle.expandActionView();
      }
    }
  }
  
  public void restorePresenterStates(Bundle paramBundle)
  {
    dispatchRestoreInstanceState(paramBundle);
  }
  
  public void saveActionViewStates(Bundle paramBundle)
  {
    int j = size();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = getItem(i);
      View localView = localMenuItem.getActionView();
      Object localObject3 = localObject1;
      if (localView != null)
      {
        localObject3 = localObject1;
        if (localView.getId() != -1)
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new SparseArray();
          }
          localView.saveHierarchyState((SparseArray)localObject2);
          localObject3 = localObject2;
          if (localMenuItem.isActionViewExpanded())
          {
            paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
            localObject3 = localObject2;
          }
        }
      }
      if (localMenuItem.hasSubMenu()) {
        ((SubMenuBuilder)localMenuItem.getSubMenu()).saveActionViewStates(paramBundle);
      }
      i += 1;
      localObject1 = localObject3;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(getActionViewStatesKey(), localObject1);
    }
  }
  
  public void savePresenterStates(Bundle paramBundle)
  {
    dispatchSaveInstanceState(paramBundle);
  }
  
  public void setCallback(Callback paramCallback)
  {
    mCallback = paramCallback;
  }
  
  public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    mCurrentMenuInfo = paramContextMenuInfo;
  }
  
  public MenuBuilder setDefaultShowAsAction(int paramInt)
  {
    mDefaultShowAsAction = paramInt;
    return this;
  }
  
  public void setExclusiveItemChecked(MenuItem paramMenuItem)
  {
    int j = paramMenuItem.getGroupId();
    int k = mItems.size();
    stopDispatchingItemsChanged();
    int i = 0;
    while (i < k)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)mItems.get(i);
      if ((localMenuItemImpl.getGroupId() == j) && (localMenuItemImpl.isExclusiveCheckable()) && (localMenuItemImpl.isCheckable()))
      {
        boolean bool;
        if (localMenuItemImpl == paramMenuItem) {
          bool = true;
        } else {
          bool = false;
        }
        localMenuItemImpl.setCheckedInt(bool);
      }
      i += 1;
    }
    startDispatchingItemsChanged();
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = mItems.size();
    int i = 0;
    while (i < j)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)mItems.get(i);
      if (localMenuItemImpl.getGroupId() == paramInt)
      {
        localMenuItemImpl.setExclusiveCheckable(paramBoolean2);
        localMenuItemImpl.setCheckable(paramBoolean1);
      }
      i += 1;
    }
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    mGroupDividerEnabled = paramBoolean;
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int j = mItems.size();
    int i = 0;
    while (i < j)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)mItems.get(i);
      if (localMenuItemImpl.getGroupId() == paramInt) {
        localMenuItemImpl.setEnabled(paramBoolean);
      }
      i += 1;
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int m = mItems.size();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)mItems.get(i);
      k = j;
      if (localMenuItemImpl.getGroupId() == paramInt)
      {
        k = j;
        if (localMenuItemImpl.setVisibleInt(paramBoolean)) {
          k = 1;
        }
      }
      i += 1;
    }
    if (j != 0) {
      onItemsChanged(true);
    }
  }
  
  public MenuBuilder setHeaderIconInt(int paramInt)
  {
    setHeaderInternal(0, null, paramInt, null, null);
    return this;
  }
  
  public MenuBuilder setHeaderIconInt(Drawable paramDrawable)
  {
    setHeaderInternal(0, null, 0, paramDrawable, null);
    return this;
  }
  
  public MenuBuilder setHeaderTitleInt(int paramInt)
  {
    setHeaderInternal(paramInt, null, 0, null, null);
    return this;
  }
  
  public MenuBuilder setHeaderTitleInt(CharSequence paramCharSequence)
  {
    setHeaderInternal(0, paramCharSequence, 0, null, null);
    return this;
  }
  
  public MenuBuilder setHeaderViewInt(View paramView)
  {
    setHeaderInternal(0, null, 0, null, paramView);
    return this;
  }
  
  public void setOptionalIconsVisible(boolean paramBoolean)
  {
    mOptionalIconsVisible = paramBoolean;
  }
  
  public void setOverrideVisibleItems(boolean paramBoolean)
  {
    mOverrideVisibleItems = paramBoolean;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    mQwertyMode = paramBoolean;
    onItemsChanged(false);
  }
  
  public void setShortcutsVisible(boolean paramBoolean)
  {
    if (mShortcutsVisible == paramBoolean) {
      return;
    }
    setShortcutsVisibleInner(paramBoolean);
    onItemsChanged(false);
  }
  
  public int size()
  {
    return mItems.size();
  }
  
  public void startDispatchingItemsChanged()
  {
    mPreventDispatchingItemsChanged = false;
    if (mItemsChangedWhileDispatchPrevented)
    {
      mItemsChangedWhileDispatchPrevented = false;
      onItemsChanged(mStructureChangedWhileDispatchPrevented);
    }
  }
  
  public void stopDispatchingItemsChanged()
  {
    if (!mPreventDispatchingItemsChanged)
    {
      mPreventDispatchingItemsChanged = true;
      mItemsChangedWhileDispatchPrevented = false;
      mStructureChangedWhileDispatchPrevented = false;
    }
  }
  
  @N({b.b.a.N.a.b})
  public static abstract interface Callback
  {
    public abstract boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem);
    
    public abstract void onMenuModeChange(MenuBuilder paramMenuBuilder);
  }
  
  @N({b.b.a.N.a.b})
  public static abstract interface ItemInvoker
  {
    public abstract boolean invokeItem(MenuItemImpl paramMenuItemImpl);
  }
}
