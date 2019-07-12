package k.a.a.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import in.spicedigital.umang.application.MyApplication;
import java.util.Locale;

public class Config
{
  public static final String ABOUT_URL = "Locale.Helper.Selected.Language";
  
  public Config() {}
  
  public static String get(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("Locale.Helper.Selected.Language", paramString);
  }
  
  public static String getInstance(Context paramContext)
  {
    return get(paramContext, Locale.getDefault().getLanguage());
  }
  
  public static Context init(Context paramContext)
  {
    String str = get(paramContext, Locale.getDefault().getLanguage());
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append("lang: ");
    localStringBuilder.append(str);
    localStringBuilder.toString();
    return init(paramContext, str);
  }
  
  public static Context init(Context paramContext, String paramString)
  {
    setInt(paramContext, paramString);
    if (Build.VERSION.SDK_INT >= 25) {
      return onCreateView(paramContext, paramString);
    }
    setLocale(paramContext, paramString);
    return paramContext;
  }
  
  public static Context onCreateView(Context paramContext, String paramString)
  {
    Object localObject = new java.lang.StringBuilder();
    ((java.lang.StringBuilder)localObject).append("language : ");
    ((java.lang.StringBuilder)localObject).append(paramString);
    ((java.lang.StringBuilder)localObject).toString();
    paramString = new Locale(paramString);
    Locale.setDefault(paramString);
    localObject = new f(paramContext);
    Configuration localConfiguration = paramContext.getResources().getConfiguration();
    localConfiguration.setLocale(paramString);
    if (!MyApplication.s.equalsIgnoreCase(""))
    {
      java.lang.StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("orientation : ");
      localStringBuilder.append(((f)localObject).get("orientation", "1"));
      localStringBuilder.toString();
      localConfiguration.setLayoutDirection(paramString);
      if (((f)localObject).get(f.a, "normal").equalsIgnoreCase("small")) {
        fontScale = 0.85F;
      } else if (((f)localObject).get(f.a, "normal").equalsIgnoreCase("normal")) {
        fontScale = 1.0F;
      } else {
        fontScale = 1.15F;
      }
    }
    return paramContext.createConfigurationContext(localConfiguration);
  }
  
  public static void setInt(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("Locale.Helper.Selected.Language", paramString);
    paramContext.apply();
  }
  
  public static Context setLocale(Context paramContext, String paramString)
  {
    try
    {
      paramString = new Locale(paramString);
      Locale.setDefault(paramString);
      Resources localResources = paramContext.getResources();
      Configuration localConfiguration = localResources.getConfiguration();
      locale = paramString;
      f localF = new f(paramContext);
      String str = MyApplication.s;
      boolean bool = str.equalsIgnoreCase("");
      if (!bool)
      {
        str = f.a;
        bool = localF.get(str, "normal").equalsIgnoreCase("small");
        if (bool)
        {
          fontScale = 0.85F;
        }
        else
        {
          str = f.a;
          bool = localF.get(str, "normal").equalsIgnoreCase("normal");
          if (bool) {
            fontScale = 1.0F;
          } else {
            fontScale = 1.15F;
          }
        }
      }
      localConfiguration.setLayoutDirection(paramString);
      localResources.updateConfiguration(localConfiguration, localResources.getDisplayMetrics());
      return paramContext;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
    return paramContext;
  }
  
  public static Context wrap(Context paramContext, String paramString)
  {
    paramString = get(paramContext, paramString);
    java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
    localStringBuilder.append("lang: ");
    localStringBuilder.append(paramString);
    localStringBuilder.toString();
    return init(paramContext, paramString);
  }
}
