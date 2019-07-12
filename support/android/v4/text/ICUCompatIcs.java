package support.android.v4.text;

import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompatIcs
{
  public static final String TAG = "ICUCompat";
  public static Method sAddLikelySubtagsMethod;
  public static Method sGetScriptMethod;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        Object localObject1 = Class.forName("libcore.icu.ICU");
        localObject1 = ((Class)localObject1).getMethod("addLikelySubtags", new Class[] { Locale.class });
        sAddLikelySubtagsMethod = (Method)localObject1;
        return;
      }
      catch (Exception localException1)
      {
        throw new IllegalStateException(localException1);
      }
    }
    try
    {
      Object localObject2 = Class.forName("libcore.icu.ICU");
      if (localObject2 == null) {
        return;
      }
      Method localMethod = ((Class)localObject2).getMethod("getScript", new Class[] { String.class });
      sGetScriptMethod = localMethod;
      localObject2 = ((Class)localObject2).getMethod("addLikelySubtags", new Class[] { String.class });
      sAddLikelySubtagsMethod = (Method)localObject2;
      return;
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    sGetScriptMethod = null;
    sAddLikelySubtagsMethod = null;
    return;
  }
  
  public ICUCompatIcs() {}
  
  public static String addLikelySubtags(Locale paramLocale)
  {
    String str = paramLocale.toString();
    paramLocale = str;
    if (sAddLikelySubtagsMethod != null) {
      paramLocale = sAddLikelySubtagsMethod;
    }
    try
    {
      paramLocale = paramLocale.invoke(null, new Object[] { str });
      paramLocale = (String)paramLocale;
      return paramLocale;
    }
    catch (IllegalAccessException paramLocale)
    {
      return str;
    }
    catch (InvocationTargetException paramLocale) {}
    return str;
  }
  
  public static String getScript(String paramString)
  {
    Method localMethod;
    if (sGetScriptMethod != null) {
      localMethod = sGetScriptMethod;
    }
    try
    {
      paramString = localMethod.invoke(null, new Object[] { paramString });
      return (String)paramString;
    }
    catch (IllegalAccessException paramString)
    {
      return null;
    }
    catch (InvocationTargetException paramString) {}
    return null;
    return null;
  }
  
  public static String maximizeAndGetScript(Locale paramLocale)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = sAddLikelySubtagsMethod;
    }
    try
    {
      localObject = ((Method)localObject).invoke(null, new Object[] { paramLocale });
      localObject = (Locale)localObject;
      localObject = ((Locale)localObject).getScript();
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    return paramLocale.getScript();
    paramLocale = addLikelySubtags(paramLocale);
    if (paramLocale != null) {
      return getScript(paramLocale);
    }
    return null;
  }
}
