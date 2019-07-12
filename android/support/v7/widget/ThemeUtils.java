package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.util.TypedValue;
import support.android.v4.internal.ColorUtils;

public class ThemeUtils
{
  public static final int[] ACTIVATED_STATE_SET;
  public static final int[] CHECKED_STATE_SET;
  public static final int[] DISABLED_STATE_SET;
  public static final int[] EMPTY_STATE_SET = new int[0];
  public static final int[] FOCUSED_STATE_SET;
  public static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET;
  public static final int[] PRESSED_STATE_SET;
  public static final int[] SELECTED_STATE_SET;
  public static final int[] TEMP_ARRAY = new int[1];
  public static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal();
  
  static
  {
    DISABLED_STATE_SET = new int[] { -16842910 };
    FOCUSED_STATE_SET = new int[] { 16842908 };
    ACTIVATED_STATE_SET = new int[] { 16843518 };
    PRESSED_STATE_SET = new int[] { 16842919 };
    CHECKED_STATE_SET = new int[] { 16842912 };
    SELECTED_STATE_SET = new int[] { 16842913 };
    NOT_PRESSED_OR_FOCUSED_STATE_SET = new int[] { -16842919, -16842908 };
  }
  
  public ThemeUtils() {}
  
  public static ColorStateList createDisabledStateList(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { DISABLED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }
  
  public static int getDisabledThemeAttrColor(Context paramContext, int paramInt)
  {
    Object localObject = getThemeAttrColorStateList(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {
      return ((ColorStateList)localObject).getColorForState(DISABLED_STATE_SET, ((ColorStateList)localObject).getDefaultColor());
    }
    localObject = getTypedValue();
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    return getThemeAttrColor(paramContext, paramInt, ((TypedValue)localObject).getFloat());
  }
  
  public static int getThemeAttrColor(Context paramContext, int paramInt)
  {
    int[] arrayOfInt = TEMP_ARRAY;
    arrayOfInt[0] = paramInt;
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, null, arrayOfInt);
    try
    {
      paramInt = paramContext.getColor(0, 0);
      paramContext.recycle();
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      paramContext.recycle();
      throw localThrowable;
    }
  }
  
  public static int getThemeAttrColor(Context paramContext, int paramInt, float paramFloat)
  {
    paramInt = getThemeAttrColor(paramContext, paramInt);
    return ColorUtils.setAlphaComponent(paramInt, Math.round(Color.alpha(paramInt) * paramFloat));
  }
  
  public static ColorStateList getThemeAttrColorStateList(Context paramContext, int paramInt)
  {
    Object localObject = TEMP_ARRAY;
    localObject[0] = paramInt;
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, null, (int[])localObject);
    try
    {
      localObject = paramContext.getColorStateList(0);
      paramContext.recycle();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      paramContext.recycle();
      throw localThrowable;
    }
  }
  
  public static TypedValue getTypedValue()
  {
    TypedValue localTypedValue2 = (TypedValue)TL_TYPED_VALUE.get();
    TypedValue localTypedValue1 = localTypedValue2;
    if (localTypedValue2 == null)
    {
      localTypedValue1 = new TypedValue();
      TL_TYPED_VALUE.set(localTypedValue1);
    }
    return localTypedValue1;
  }
}
