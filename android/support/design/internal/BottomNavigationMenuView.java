package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.design.R.dimen;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionSet;
import android.support.v7.appcompat.R.attr;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import b.b.a.N;
import b.b.a.S;
import b.b.a.o;
import b.b.x.n.r.a;
import java.util.ArrayList;
import support.android.asm.ClassWriter;
import support.android.v4.util.Pools.Pool;
import support.android.v4.util.Pools.SynchronizedPool;
import support.android.v4.view.ViewCompat;
import support.android.v4.view.animation.FastOutLinearInInterpolator;

@N({b.b.a.N.a.b})
public class BottomNavigationMenuView
  extends ViewGroup
  implements MenuView
{
  public static final long ACTIVE_ANIMATION_DURATION_MS = 115L;
  public static final int[] CHECKED_STATE_SET = { 16842912 };
  public static final int[] DISABLED_STATE_SET = { -16842910 };
  public final int activeItemMaxWidth;
  public final int activeItemMinWidth;
  public BottomNavigationItemView[] buttons;
  public final int inactiveItemMaxWidth;
  public final int inactiveItemMinWidth;
  public Drawable itemBackground;
  public int itemBackgroundRes;
  public final int itemHeight;
  public boolean itemHorizontalTranslationEnabled;
  @o
  public int itemIconSize;
  public ColorStateList itemIconTint;
  public final r.a<BottomNavigationItemView> itemPool = new Pools.SynchronizedPool(5);
  @S
  public int itemTextAppearanceActive;
  @S
  public int itemTextAppearanceInactive;
  public final ColorStateList itemTextColorDefault;
  public ColorStateList itemTextColorFromUser;
  public int labelVisibilityMode;
  public MenuBuilder menu;
  public final TransitionSet o;
  public final View.OnClickListener onClickListener;
  public BottomNavigationPresenter presenter;
  public int selectedItemId = 0;
  public int selectedItemPosition = 0;
  public int[] tempChildWidths;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    inactiveItemMaxWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
    inactiveItemMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
    activeItemMaxWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
    activeItemMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    itemHeight = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
    itemTextColorDefault = createDefaultColorStateList(16842808);
    o = new AutoTransition();
    o.a(0);
    o.setDuration(115L);
    o.setInterpolator(new FastOutLinearInInterpolator());
    o.add(new TextScale());
    onClickListener = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = ((BottomNavigationItemView)paramAnonymousView).getItemData();
        if (!BottomNavigationMenuView.access$100(BottomNavigationMenuView.this).performItemAction(paramAnonymousView, BottomNavigationMenuView.access$000(BottomNavigationMenuView.this), 0)) {
          paramAnonymousView.setChecked(true);
        }
      }
    };
    tempChildWidths = new int[5];
  }
  
  private BottomNavigationItemView getNewItem()
  {
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)itemPool.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView1;
  }
  
  private boolean isShifting(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1)
    {
      if (paramInt2 > 3) {
        return true;
      }
    }
    else if (paramInt1 == 0) {
      return true;
    }
    return false;
  }
  
  public void buildMenuView()
  {
    removeAllViews();
    Object localObject1 = buttons;
    BottomNavigationMenuView localBottomNavigationMenuView = this;
    Object localObject2;
    if (localObject1 != null)
    {
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null) {
          itemPool.release(localObject2);
        }
        i += 1;
      }
    }
    if (menu.size() == 0)
    {
      selectedItemId = 0;
      selectedItemPosition = 0;
      buttons = null;
      return;
    }
    buttons = new BottomNavigationItemView[menu.size()];
    boolean bool = localBottomNavigationMenuView.isShifting(labelVisibilityMode, menu.getVisibleItems().size());
    int i = 0;
    while (i < menu.size())
    {
      presenter.setUpdateSuspended(true);
      menu.getItem(i).setCheckable(true);
      presenter.setUpdateSuspended(false);
      localObject1 = localBottomNavigationMenuView.getNewItem();
      localObject2 = buttons;
      localObject2[i] = localObject1;
      ((BottomNavigationItemView)localObject1).setIconTintList(itemIconTint);
      ((BottomNavigationItemView)localObject1).setIconSize(itemIconSize);
      ((BottomNavigationItemView)localObject1).setTextColor(itemTextColorDefault);
      ((BottomNavigationItemView)localObject1).setTextAppearanceInactive(itemTextAppearanceInactive);
      ((BottomNavigationItemView)localObject1).setTextAppearanceActive(itemTextAppearanceActive);
      ((BottomNavigationItemView)localObject1).setTextColor(itemTextColorFromUser);
      localObject2 = itemBackground;
      if (localObject2 != null) {
        ((BottomNavigationItemView)localObject1).setItemBackground((Drawable)localObject2);
      } else {
        ((BottomNavigationItemView)localObject1).setItemBackground(itemBackgroundRes);
      }
      ((BottomNavigationItemView)localObject1).setShifting(bool);
      ((BottomNavigationItemView)localObject1).setLabelVisibilityMode(labelVisibilityMode);
      ((BottomNavigationItemView)localObject1).initialize((MenuItemImpl)menu.getItem(i), 0);
      ((BottomNavigationItemView)localObject1).setItemPosition(i);
      ((View)localObject1).setOnClickListener(onClickListener);
      localBottomNavigationMenuView.addView((View)localObject1);
      i += 1;
    }
    selectedItemPosition = Math.min(menu.size() - 1, selectedItemPosition);
    menu.getItem(selectedItemPosition).setChecked(true);
  }
  
  public ColorStateList createDefaultColorStateList(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {
      return null;
    }
    ColorStateList localColorStateList = AppCompatResources.getColorStateList(getContext(), resourceId);
    if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, (TypedValue)localObject, true)) {
      return null;
    }
    paramInt = data;
    int i = localColorStateList.getDefaultColor();
    localObject = DISABLED_STATE_SET;
    int[] arrayOfInt1 = CHECKED_STATE_SET;
    int[] arrayOfInt2 = View.EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(DISABLED_STATE_SET, i);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
  }
  
  public ColorStateList getIconTintList()
  {
    return itemIconTint;
  }
  
  public Drawable getItemBackground()
  {
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = buttons;
    if ((arrayOfBottomNavigationItemView != null) && (arrayOfBottomNavigationItemView.length > 0)) {
      return arrayOfBottomNavigationItemView[0].getBackground();
    }
    return itemBackground;
  }
  
  public int getItemBackgroundRes()
  {
    return itemBackgroundRes;
  }
  
  public int getItemIconSize()
  {
    return itemIconSize;
  }
  
  public int getItemTextAppearanceActive()
  {
    return itemTextAppearanceActive;
  }
  
  public int getItemTextAppearanceInactive()
  {
    return itemTextAppearanceInactive;
  }
  
  public ColorStateList getItemTextColor()
  {
    return itemTextColorFromUser;
  }
  
  public int getLabelVisibilityMode()
  {
    return labelVisibilityMode;
  }
  
  public int getSelectedItemId()
  {
    return selectedItemId;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    menu = paramMenuBuilder;
  }
  
  public boolean isItemHorizontalTranslationEnabled()
  {
    return itemHorizontalTranslationEnabled;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = paramInt4 - paramInt2;
    paramInt2 = 0;
    paramInt4 = 0;
    while (paramInt2 < i)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        if (ViewCompat.getLayoutDirection(this) == 1)
        {
          int k = paramInt3 - paramInt1 - paramInt4;
          localView.layout(k - localView.getMeasuredWidth(), 0, k, j);
        }
        else
        {
          localView.layout(paramInt4, 0, localView.getMeasuredWidth() + paramInt4, j);
        }
        paramInt4 = localView.getMeasuredWidth() + paramInt4;
      }
      paramInt2 += 1;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getSize(paramInt1);
    int i = menu.getVisibleItems().size();
    int m = getChildCount();
    int n = View.MeasureSpec.makeMeasureSpec(itemHeight, 1073741824);
    Object localObject;
    int j;
    if ((isShifting(labelVisibilityMode, i)) && (itemHorizontalTranslationEnabled))
    {
      localObject = getChildAt(selectedItemPosition);
      paramInt2 = activeItemMinWidth;
      paramInt1 = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(activeItemMaxWidth, Integer.MIN_VALUE), n);
        paramInt1 = Math.max(paramInt2, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramInt2 = i - paramInt2;
      j = Math.min(k - inactiveItemMinWidth * paramInt2, Math.min(paramInt1, activeItemMaxWidth));
      i = k - j;
      if (paramInt2 == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = paramInt2;
      }
      k = Math.min(i / paramInt1, inactiveItemMaxWidth);
      paramInt2 = i - paramInt2 * k;
      paramInt1 = 0;
    }
    while (paramInt1 < m)
    {
      if (getChildAt(paramInt1).getVisibility() != 8)
      {
        localObject = tempChildWidths;
        if (paramInt1 == selectedItemPosition) {
          i = j;
        } else {
          i = k;
        }
        localObject[paramInt1] = i;
        i = paramInt2;
        if (paramInt2 > 0)
        {
          localObject = tempChildWidths;
          localObject[paramInt1] += 1;
          i = paramInt2 - 1;
        }
      }
      else
      {
        tempChildWidths[paramInt1] = 0;
        i = paramInt2;
      }
      paramInt1 += 1;
      paramInt2 = i;
      continue;
      if (i == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = i;
      }
      j = Math.min(k / paramInt1, activeItemMaxWidth);
      paramInt2 = k - i * j;
      paramInt1 = 0;
      while (paramInt1 < m)
      {
        if (getChildAt(paramInt1).getVisibility() != 8)
        {
          localObject = tempChildWidths;
          localObject[paramInt1] = j;
          i = paramInt2;
          if (paramInt2 > 0)
          {
            localObject[paramInt1] += 1;
            i = paramInt2 - 1;
          }
        }
        else
        {
          tempChildWidths[paramInt1] = 0;
          i = paramInt2;
        }
        paramInt1 += 1;
        paramInt2 = i;
      }
    }
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < m)
    {
      localObject = getChildAt(paramInt1);
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(tempChildWidths[paramInt1], 1073741824), n);
        getLayoutParamswidth = ((View)localObject).getMeasuredWidth();
        paramInt2 = ((View)localObject).getMeasuredWidth() + paramInt2;
      }
      paramInt1 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(itemHeight, n, 0));
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    itemIconTint = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconTintList(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    itemBackground = paramDrawable;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramDrawable);
        i += 1;
      }
    }
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    itemBackgroundRes = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramInt);
        i += 1;
      }
    }
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    itemHorizontalTranslationEnabled = paramBoolean;
  }
  
  public void setItemIconSize(int paramInt)
  {
    itemIconSize = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconSize(paramInt);
        i += 1;
      }
    }
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    itemTextAppearanceActive = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceActive(paramInt);
        ColorStateList localColorStateList = itemTextColorFromUser;
        if (localColorStateList != null) {
          localBottomNavigationItemView.setTextColor(localColorStateList);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    itemTextAppearanceInactive = paramInt;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceInactive(paramInt);
        ColorStateList localColorStateList = itemTextColorFromUser;
        if (localColorStateList != null) {
          localBottomNavigationItemView.setTextColor(localColorStateList);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    itemTextColorFromUser = paramColorStateList;
    BottomNavigationItemView[] arrayOfBottomNavigationItemView = buttons;
    if (arrayOfBottomNavigationItemView != null)
    {
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setTextColor(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    labelVisibilityMode = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    presenter = paramBottomNavigationPresenter;
  }
  
  public void tryRestoreSelectedItemId(int paramInt)
  {
    int j = menu.size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = menu.getItem(i);
      if (paramInt == localMenuItem.getItemId())
      {
        selectedItemId = paramInt;
        selectedItemPosition = i;
        localMenuItem.setChecked(true);
        return;
      }
      i += 1;
    }
  }
  
  public void updateMenuView()
  {
    Object localObject = menu;
    if (localObject != null)
    {
      if (buttons == null) {
        return;
      }
      int j = ((MenuBuilder)localObject).size();
      if (j != buttons.length)
      {
        buildMenuView();
        return;
      }
      int k = selectedItemId;
      int i = 0;
      while (i < j)
      {
        localObject = menu.getItem(i);
        if (((MenuItem)localObject).isChecked())
        {
          selectedItemId = ((MenuItem)localObject).getItemId();
          selectedItemPosition = i;
        }
        i += 1;
      }
      if (k != selectedItemId) {
        ClassWriter.a(this, o);
      }
      boolean bool = isShifting(labelVisibilityMode, menu.getVisibleItems().size());
      i = 0;
      while (i < j)
      {
        presenter.setUpdateSuspended(true);
        buttons[i].setLabelVisibilityMode(labelVisibilityMode);
        buttons[i].setShifting(bool);
        buttons[i].initialize((MenuItemImpl)menu.getItem(i), 0);
        presenter.setUpdateSuspended(false);
        i += 1;
      }
    }
  }
}
