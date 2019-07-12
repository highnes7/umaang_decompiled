package support.android.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class CompoundButtonCompatDonut
{
  public static final String TAG = "CompoundButtonCompat";
  public static Field sButtonDrawableField;
  public static boolean sButtonDrawableFieldFetched;
  
  public CompoundButtonCompatDonut() {}
  
  public static Drawable getButtonDrawable(CompoundButton paramCompoundButton)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramCompoundButton.getButtonDrawable();
    }
    if (!sButtonDrawableFieldFetched) {}
    try
    {
      localField = CompoundButton.class.getDeclaredField("mButtonDrawable");
      sButtonDrawableField = localField;
      localField = sButtonDrawableField;
      localField.setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Field localField;
      for (;;) {}
    }
    sButtonDrawableFieldFetched = true;
    localField = sButtonDrawableField;
    if (localField != null)
    {
      try
      {
        paramCompoundButton = localField.get(paramCompoundButton);
        return (Drawable)paramCompoundButton;
      }
      catch (IllegalAccessException paramCompoundButton)
      {
        for (;;) {}
      }
      sButtonDrawableField = null;
      return null;
    }
    return null;
  }
  
  public static ColorStateList getButtonTintList(CompoundButton paramCompoundButton)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramCompoundButton.getButtonTintList();
    }
    if ((paramCompoundButton instanceof TintableCompoundButton)) {
      return ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintList();
    }
    return null;
  }
  
  public static PorterDuff.Mode getButtonTintMode(CompoundButton paramCompoundButton)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramCompoundButton.getButtonTintMode();
    }
    if ((paramCompoundButton instanceof TintableCompoundButton)) {
      return ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintMode();
    }
    return null;
  }
  
  public static void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramCompoundButton.setButtonTintList(paramColorStateList);
      return;
    }
    if ((paramCompoundButton instanceof TintableCompoundButton)) {
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
    }
  }
  
  public static void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramCompoundButton.setButtonTintMode(paramMode);
      return;
    }
    if ((paramCompoundButton instanceof TintableCompoundButton)) {
      ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintMode(paramMode);
    }
  }
}
