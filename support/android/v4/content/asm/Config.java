package support.android.v4.content.asm;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import support.android.v4.internal.Type;

public final class Config
{
  public static final String TAG = "ResourcesCompat";
  
  public Config() {}
  
  public static Typeface get(Context paramContext, int paramInt)
    throws Resources.NotFoundException
  {
    if (paramContext.isRestricted()) {
      return null;
    }
    return load(paramContext, paramInt, new TypedValue(), 0, null, null, false);
  }
  
  public static Typeface get(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, Label paramLabel)
    throws Resources.NotFoundException
  {
    if (paramContext.isRestricted()) {
      return null;
    }
    return load(paramContext, paramInt1, paramTypedValue, paramInt2, paramLabel, null, true);
  }
  
  public static Typeface get(Context paramContext, android.content.res.Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, Label paramLabel, Handler paramHandler, boolean paramBoolean)
  {
    java.lang.Object localObject = string;
    if (localObject != null)
    {
      paramTypedValue = ((CharSequence)localObject).toString();
      if (!paramTypedValue.startsWith("res/"))
      {
        if (paramLabel == null) {
          break label278;
        }
        paramLabel.callbackFailAsync(-3, paramHandler);
        return null;
      }
      localObject = Type.get(paramResources, paramInt1, paramInt2);
      if (localObject != null)
      {
        if (paramLabel == null) {
          break label280;
        }
        paramLabel.callbackSuccessAsync((Typeface)localObject, paramHandler);
        return localObject;
      }
    }
    try
    {
      boolean bool = paramTypedValue.toLowerCase().endsWith(".xml");
      if (bool)
      {
        localObject = Resources.createFromXml(paramResources.getXml(paramInt1), paramResources);
        if (localObject == null)
        {
          if (paramLabel == null) {
            break label283;
          }
          paramLabel.callbackFailAsync(-3, paramHandler);
          return null;
        }
        paramContext = Type.a(paramContext, (Object)localObject, paramResources, paramInt1, paramInt2, paramLabel, paramHandler, paramBoolean);
        return paramContext;
      }
      paramContext = Type.a(paramContext, paramResources, paramInt1, paramTypedValue, paramInt2);
      if (paramLabel == null) {
        break label285;
      }
      if (paramContext != null)
      {
        paramLabel.callbackSuccessAsync(paramContext, paramHandler);
        return paramContext;
      }
      paramLabel.callbackFailAsync(-3, paramHandler);
      return paramContext;
    }
    catch (XmlPullParserException paramContext)
    {
      for (;;) {}
    }
    catch (IOException paramContext)
    {
      for (;;) {}
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("Failed to read xml resource ", paramTypedValue);
    break label197;
    f.sufficientlysecure.rootcommands.util.StringBuilder.get("Failed to parse xml resource ", paramTypedValue);
    label197:
    if (paramLabel != null)
    {
      paramLabel.callbackFailAsync(-3, paramHandler);
      return null;
      paramContext = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Resource \"");
      paramContext.append(paramResources.getResourceName(paramInt1));
      paramContext.append("\" (");
      paramContext.append(Integer.toHexString(paramInt1));
      paramContext.append(") is not a Font: ");
      paramContext.append(paramTypedValue);
      throw new Resources.NotFoundException(paramContext.toString());
      label278:
      return null;
      label280:
      return localObject;
      label283:
      return null;
      label285:
      return paramContext;
    }
    return null;
  }
  
  public static int getColor(android.content.res.Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramResources.getColor(paramInt, paramTheme);
    }
    return paramResources.getColor(paramInt);
  }
  
  public static ColorStateList getColorStateList(android.content.res.Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramResources.getColorStateList(paramInt, paramTheme);
    }
    return paramResources.getColorStateList(paramInt);
  }
  
  public static Drawable getDrawable(android.content.res.Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramResources.getDrawable(paramInt, paramTheme);
    }
    return paramResources.getDrawable(paramInt);
  }
  
  public static Drawable getDrawableForDensity(android.content.res.Resources paramResources, int paramInt1, int paramInt2, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramResources.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
    }
    return paramResources.getDrawableForDensity(paramInt1, paramInt2);
  }
  
  public static void init(Context paramContext, int paramInt, Label paramLabel, Handler paramHandler)
    throws Resources.NotFoundException
  {
    if (paramLabel != null)
    {
      if (paramContext.isRestricted())
      {
        paramLabel.callbackFailAsync(-4, paramHandler);
        return;
      }
      load(paramContext, paramInt, new TypedValue(), 0, paramLabel, paramHandler, false);
      return;
    }
    throw new NullPointerException();
  }
  
  public static Typeface load(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, Label paramLabel, Handler paramHandler, boolean paramBoolean)
  {
    android.content.res.Resources localResources = paramContext.getResources();
    localResources.getValue(paramInt1, paramTypedValue, true);
    paramContext = get(paramContext, localResources, paramTypedValue, paramInt1, paramInt2, paramLabel, paramHandler, paramBoolean);
    if (paramContext == null)
    {
      if (paramLabel != null) {
        return paramContext;
      }
      paramContext = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Font resource ID #0x");
      paramContext.append(Integer.toHexString(paramInt1));
      paramContext.append(" could not be retrieved.");
      throw new Resources.NotFoundException(paramContext.toString());
    }
    return paramContext;
  }
}
