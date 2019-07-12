package support.android.v4.internal.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat
{
  public static final String a = "DrawableCompat";
  public static Method sGetLayoutDirectionMethod;
  public static boolean sGetLayoutDirectionMethodFetched;
  public static Method sSetLayoutDirectionMethod;
  public static boolean sSetLayoutDirectionMethodFetched;
  
  public DrawableCompat() {}
  
  public static void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.applyTheme(paramTheme);
    }
  }
  
  public static boolean canApplyTheme(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramDrawable.canApplyTheme();
    }
    return false;
  }
  
  public static void canSafelyMutateDrawable(Drawable paramDrawable)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      paramDrawable.clearColorFilter();
      return;
    }
    if (i >= 21)
    {
      paramDrawable.clearColorFilter();
      if ((paramDrawable instanceof InsetDrawable))
      {
        canSafelyMutateDrawable(((InsetDrawable)paramDrawable).getDrawable());
        return;
      }
      if ((paramDrawable instanceof DrawableWrapper))
      {
        canSafelyMutateDrawable(((DrawableWrapper)paramDrawable).getWrappedDrawable());
        return;
      }
      if ((paramDrawable instanceof DrawableContainer))
      {
        paramDrawable = (DrawableContainer.DrawableContainerState)((DrawableContainer)paramDrawable).getConstantState();
        if (paramDrawable != null)
        {
          i = 0;
          int j = paramDrawable.getChildCount();
          while (i < j)
          {
            Drawable localDrawable = paramDrawable.getChild(i);
            if (localDrawable != null) {
              canSafelyMutateDrawable(localDrawable);
            }
            i += 1;
          }
        }
      }
    }
    else
    {
      paramDrawable.clearColorFilter();
    }
  }
  
  public static int getAlpha(Drawable paramDrawable)
  {
    int i = Build.VERSION.SDK_INT;
    return paramDrawable.getAlpha();
  }
  
  public static ColorFilter getColorFilter(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramDrawable.getColorFilter();
    }
    return null;
  }
  
  public static int getLayoutDirection(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramDrawable.getLayoutDirection();
    }
    if (!sGetLayoutDirectionMethodFetched) {}
    try
    {
      localMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
      sGetLayoutDirectionMethod = localMethod;
      localMethod = sGetLayoutDirectionMethod;
      localMethod.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      for (;;) {}
    }
    sGetLayoutDirectionMethodFetched = true;
    localMethod = sGetLayoutDirectionMethod;
    if (localMethod != null)
    {
      try
      {
        paramDrawable = localMethod.invoke(paramDrawable, new Object[0]);
        paramDrawable = (Integer)paramDrawable;
        int i = paramDrawable.intValue();
        return i;
      }
      catch (Exception paramDrawable)
      {
        for (;;) {}
      }
      sGetLayoutDirectionMethod = null;
      return 0;
    }
    return 0;
  }
  
  public static void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }
  
  public static boolean isAutoMirrored(Drawable paramDrawable)
  {
    int i = Build.VERSION.SDK_INT;
    return paramDrawable.isAutoMirrored();
  }
  
  public static void jumpToCurrentState(Drawable paramDrawable)
  {
    paramDrawable.jumpToCurrentState();
  }
  
  public static void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    paramDrawable.setAutoMirrored(paramBoolean);
  }
  
  public static void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  public static void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public static boolean setLayoutDirection(Drawable paramDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramDrawable.setLayoutDirection(paramInt);
    }
    if (!sSetLayoutDirectionMethodFetched) {
      localObject = Integer.TYPE;
    }
    try
    {
      localObject = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[] { localObject });
      sSetLayoutDirectionMethod = (Method)localObject;
      localObject = sSetLayoutDirectionMethod;
      ((Method)localObject).setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    sSetLayoutDirectionMethodFetched = true;
    Object localObject = sSetLayoutDirectionMethod;
    if (localObject != null)
    {
      try
      {
        ((Method)localObject).invoke(paramDrawable, new Object[] { Integer.valueOf(paramInt) });
        return true;
      }
      catch (Exception paramDrawable)
      {
        for (;;) {}
      }
      sSetLayoutDirectionMethod = null;
      return false;
    }
    return false;
  }
  
  public static void setTint(Drawable paramDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.setTint(paramInt);
      return;
    }
    if ((paramDrawable instanceof DrawableCompat.DrawableImpl)) {
      ((DrawableCompat.DrawableImpl)paramDrawable).setTint(paramInt);
    }
  }
  
  public static void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.setTintList(paramColorStateList);
      return;
    }
    if ((paramDrawable instanceof DrawableCompat.DrawableImpl)) {
      ((DrawableCompat.DrawableImpl)paramDrawable).setTintList(paramColorStateList);
    }
  }
  
  public static void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.setTintMode(paramMode);
      return;
    }
    if ((paramDrawable instanceof DrawableCompat.DrawableImpl)) {
      ((DrawableCompat.DrawableImpl)paramDrawable).setTintMode(paramMode);
    }
  }
  
  public static Drawable unwrap(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if ((paramDrawable instanceof DrawableWrapper)) {
      localDrawable = ((DrawableWrapper)paramDrawable).getWrappedDrawable();
    }
    return localDrawable;
  }
  
  public static Drawable wrap(Drawable paramDrawable)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      return paramDrawable;
    }
    if (i >= 21)
    {
      if (!(paramDrawable instanceof DrawableCompat.DrawableImpl)) {
        return new DrawableWrapperLollipop(paramDrawable);
      }
      return paramDrawable;
    }
    if (!(paramDrawable instanceof DrawableCompat.DrawableImpl)) {
      return new DrawableWrapperDonut(paramDrawable);
    }
    return paramDrawable;
  }
}
