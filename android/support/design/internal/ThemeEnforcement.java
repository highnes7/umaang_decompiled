package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R.attr;
import android.support.design.R.styleable;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import b.b.a.N;
import f.sufficientlysecure.rootcommands.util.StringBuilder;

@N({b.b.a.N.a.b})
public final class ThemeEnforcement
{
  public static final int[] APPCOMPAT_CHECK_ATTRS = { R.attr.colorPrimary };
  public static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
  public static final int[] MATERIAL_CHECK_ATTRS = { R.attr.colorSecondary };
  public static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";
  
  public ThemeEnforcement() {}
  
  public static void checkAppCompatTheme(Context paramContext)
  {
    checkTheme(paramContext, APPCOMPAT_CHECK_ATTRS, "Theme.AppCompat");
  }
  
  public static void checkCompatibleTheme(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    boolean bool = paramAttributeSet.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
    paramAttributeSet.recycle();
    if (bool) {
      checkMaterialTheme(paramContext);
    }
    checkAppCompatTheme(paramContext);
  }
  
  public static void checkMaterialTheme(Context paramContext)
  {
    checkTheme(paramContext, MATERIAL_CHECK_ATTRS, "Theme.MaterialComponents");
  }
  
  public static void checkTextAppearance(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    if (!localTypedArray.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false))
    {
      localTypedArray.recycle();
      return;
    }
    boolean bool;
    if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
      bool = isCustomTextAppearanceValid(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    } else if (localTypedArray.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1) {
      bool = true;
    } else {
      bool = false;
    }
    localTypedArray.recycle();
    if (bool) {
      return;
    }
    throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
  }
  
  public static void checkTheme(Context paramContext, int[] paramArrayOfInt, String paramString)
  {
    paramContext = paramContext.obtainStyledAttributes(paramArrayOfInt);
    boolean bool = paramContext.hasValue(0);
    paramContext.recycle();
    if (bool) {
      return;
    }
    throw new IllegalArgumentException(StringBuilder.append("The style on this component requires your app theme to be ", paramString, " (or a descendant)."));
  }
  
  public static boolean isAppCompatTheme(Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
    boolean bool = paramContext.hasValue(0);
    paramContext.recycle();
    return bool;
  }
  
  public static boolean isCustomTextAppearanceValid(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    paramInt2 = paramVarArgs.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (paramContext.getResourceId(paramVarArgs[paramInt1], -1) == -1)
      {
        paramContext.recycle();
        return false;
      }
      paramInt1 += 1;
    }
    paramContext.recycle();
    return true;
  }
  
  public static boolean isMaterialTheme(Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(MATERIAL_CHECK_ATTRS);
    boolean bool = paramContext.hasValue(0);
    paramContext.recycle();
    return bool;
  }
  
  public static boolean isTheme(Context paramContext, int[] paramArrayOfInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramArrayOfInt);
    boolean bool = paramContext.hasValue(0);
    paramContext.recycle();
    return bool;
  }
  
  public static TypedArray obtainStyledAttributes(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    checkCompatibleTheme(paramContext, paramAttributeSet, paramInt1, paramInt2);
    checkTextAppearance(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    return paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
  
  public static TintTypedArray obtainTintedStyledAttributes(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    checkCompatibleTheme(paramContext, paramAttributeSet, paramInt1, paramInt2);
    checkTextAppearance(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    return TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
}
