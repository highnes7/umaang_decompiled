package android.support.v4.package_7;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;

public final class NavUtils
{
  public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
  public static final String TAG = "NavUtils";
  
  public NavUtils() {}
  
  public static Intent getParentActivityIntent(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = paramActivity.getParentActivityIntent();
    if (localObject != null) {
      return localObject;
    }
    localObject = getParentActivityName(paramActivity);
    if (localObject == null) {
      return null;
    }
    ComponentName localComponentName = new ComponentName(paramActivity, (String)localObject);
    try
    {
      paramActivity = getParentActivityName(paramActivity, localComponentName);
      if (paramActivity == null)
      {
        paramActivity = Intent.makeMainActivity(localComponentName);
        return paramActivity;
      }
      paramActivity = new Intent().setComponent(localComponentName);
      return paramActivity;
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      for (;;) {}
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.toString("getParentActivityIntent: bad parentActivityName '", (String)localObject, "' in manifest");
    return null;
  }
  
  public static Intent getParentActivityIntent(Context paramContext, ComponentName paramComponentName)
    throws PackageManager.NameNotFoundException
  {
    String str = getParentActivityName(paramContext, paramComponentName);
    if (str == null) {
      return null;
    }
    paramComponentName = new ComponentName(paramComponentName.getPackageName(), str);
    if (getParentActivityName(paramContext, paramComponentName) == null) {
      return Intent.makeMainActivity(paramComponentName);
    }
    return new Intent().setComponent(paramComponentName);
  }
  
  public static Intent getParentActivityIntent(Context paramContext, Class paramClass)
    throws PackageManager.NameNotFoundException
  {
    paramClass = getParentActivityName(paramContext, new ComponentName(paramContext, paramClass));
    if (paramClass == null) {
      return null;
    }
    paramClass = new ComponentName(paramContext, paramClass);
    if (getParentActivityName(paramContext, paramClass) == null) {
      return Intent.makeMainActivity(paramClass);
    }
    return new Intent().setComponent(paramClass);
  }
  
  public static String getParentActivityName(Activity paramActivity)
  {
    try
    {
      paramActivity = getParentActivityName(paramActivity, paramActivity.getComponentName());
      return paramActivity;
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      throw new IllegalArgumentException(paramActivity);
    }
  }
  
  public static String getParentActivityName(Context paramContext, ComponentName paramComponentName)
    throws PackageManager.NameNotFoundException
  {
    paramComponentName = paramContext.getPackageManager().getActivityInfo(paramComponentName, 128);
    int i = Build.VERSION.SDK_INT;
    String str = parentActivityName;
    if (str != null) {
      return str;
    }
    if (metaData == null) {
      return null;
    }
    str = metaData.getString("android.support.PARENT_ACTIVITY");
    if (str == null) {
      return null;
    }
    paramComponentName = str;
    if (str.charAt(0) == '.')
    {
      paramComponentName = new StringBuilder();
      paramComponentName.append(paramContext.getPackageName());
      paramComponentName.append(str);
      paramComponentName = paramComponentName.toString();
    }
    return paramComponentName;
  }
  
  public static void navigateUpFromSameTask(Activity paramActivity)
  {
    Object localObject = getParentActivityIntent(paramActivity);
    if (localObject != null)
    {
      int i = Build.VERSION.SDK_INT;
      paramActivity.navigateUpTo((Intent)localObject);
      return;
    }
    localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Activity ");
    ((StringBuilder)localObject).append(paramActivity.getClass().getSimpleName());
    ((StringBuilder)localObject).append(" does not have a parent activity name specified.");
    ((StringBuilder)localObject).append(" (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> ");
    ((StringBuilder)localObject).append(" element in your manifest?)");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static void navigateUpTo(Activity paramActivity, Intent paramIntent)
  {
    int i = Build.VERSION.SDK_INT;
    paramActivity.navigateUpTo(paramIntent);
  }
  
  public static boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent)
  {
    int i = Build.VERSION.SDK_INT;
    return paramActivity.shouldUpRecreateTask(paramIntent);
  }
}
