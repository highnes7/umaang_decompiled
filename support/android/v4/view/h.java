package support.android.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.MenuItem;
import android.view.View;
import support.android.v4.media.session.SupportMenuItem;

public final class h
{
  public static final String TAG = "MenuItemCompat";
  @Deprecated
  public static final int d = 0;
  @Deprecated
  public static final int l = 4;
  @Deprecated
  public static final int q = 2;
  @Deprecated
  public static final int s = 8;
  @Deprecated
  public static final int t = 1;
  
  public h() {}
  
  public static CharSequence a(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getContentDescription();
    }
    if (Build.VERSION.SDK_INT >= 26) {
      return paramMenuItem.getContentDescription();
    }
    return null;
  }
  
  public static void a(MenuItem paramMenuItem, char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    }
  }
  
  public static void a(MenuItem paramMenuItem, char paramChar, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setAlphabeticShortcut(paramChar, paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setAlphabeticShortcut(paramChar, paramInt);
    }
  }
  
  public static void a(MenuItem paramMenuItem, ColorStateList paramColorStateList)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setIconTintList(paramColorStateList);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setIconTintList(paramColorStateList);
    }
  }
  
  public static void a(MenuItem paramMenuItem, PorterDuff.Mode paramMode)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setIconTintMode(paramMode);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setIconTintMode(paramMode);
    }
  }
  
  public static void a(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setContentDescription(paramCharSequence);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setContentDescription(paramCharSequence);
    }
  }
  
  public static boolean collapseActionView(MenuItem paramMenuItem)
  {
    return paramMenuItem.collapseActionView();
  }
  
  public static PorterDuff.Mode createView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getIconTintMode();
    }
    if (Build.VERSION.SDK_INT >= 26) {
      return paramMenuItem.getIconTintMode();
    }
    return null;
  }
  
  public static boolean expandActionView(MenuItem paramMenuItem)
  {
    return paramMenuItem.expandActionView();
  }
  
  public static ActionProvider getActionProvider(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getSupportActionProvider();
    }
    return null;
  }
  
  public static View getActionView(MenuItem paramMenuItem)
  {
    return paramMenuItem.getActionView();
  }
  
  public static ColorStateList getIcon(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getIconTintList();
    }
    if (Build.VERSION.SDK_INT >= 26) {
      return paramMenuItem.getIconTintList();
    }
    return null;
  }
  
  public static CharSequence getMenuItemWrapper(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getTooltipText();
    }
    if (Build.VERSION.SDK_INT >= 26) {
      return paramMenuItem.getTooltipText();
    }
    return null;
  }
  
  public static boolean isActionViewExpanded(MenuItem paramMenuItem)
  {
    return paramMenuItem.isActionViewExpanded();
  }
  
  public static int onActionItemClicked(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getNumericModifiers();
    }
    if (Build.VERSION.SDK_INT >= 26) {
      return paramMenuItem.getNumericModifiers();
    }
    return 0;
  }
  
  public static MenuItem setActionProvider(MenuItem paramMenuItem, ActionProvider paramActionProvider)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).setSupportActionProvider(paramActionProvider);
    }
    return paramMenuItem;
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
  {
    return paramMenuItem.setActionView(paramInt);
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, View paramView)
  {
    return paramMenuItem.setActionView(paramView);
  }
  
  public static MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompatIcs.SupportActionExpandProxy paramSupportActionExpandProxy)
  {
    return paramMenuItem.setOnActionExpandListener(new MenuItemCompatIcs.OnActionExpandListenerWrapper(paramSupportActionExpandProxy));
  }
  
  public static void setShowAsAction(MenuItem paramMenuItem, char paramChar, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setNumericShortcut(paramChar, paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setNumericShortcut(paramChar, paramInt);
    }
  }
  
  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem.setShowAsAction(paramInt);
  }
  
  public static void setShowAsAction(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      ((SupportMenuItem)paramMenuItem).setTooltipText(paramCharSequence);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setTooltipText(paramCharSequence);
    }
  }
  
  public static int update(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      return ((SupportMenuItem)paramMenuItem).getAlphabeticModifiers();
    }
    if (Build.VERSION.SDK_INT >= 26) {
      return paramMenuItem.getAlphabeticModifiers();
    }
    return 0;
  }
}
