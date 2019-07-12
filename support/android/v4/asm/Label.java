package support.android.v4.asm;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.provider.Settings.Secure;

public class Label
  implements ea.a
{
  public static final String RESOLVED = "android.permission.STATUS_BAR_SERVICE";
  public static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
  public static final String TARGET = "MediaSessionManager";
  public static final boolean b = c.b;
  public static final String start = "android.permission.MEDIA_CONTENT_CONTROL";
  public ContentResolver mContentResolver;
  public Context mContext;
  
  public Label(Context paramContext)
  {
    mContext = paramContext;
    mContentResolver = mContext.getContentResolver();
  }
  
  private boolean a(ea.c paramC, String paramString)
  {
    if (paramC.b() < 0) {
      return mContext.getPackageManager().checkPermission(paramString, paramC.getPackageName()) == 0;
    }
    return mContext.checkPermission(paramString, paramC.b(), paramC.getUid()) == 0;
  }
  
  public boolean a(ea.c paramC)
  {
    Object localObject = mContext;
    try
    {
      localObject = ((Context)localObject).getPackageManager().getApplicationInfo(paramC.getPackageName(), 0);
      if (uid != paramC.getUid())
      {
        if (!b) {
          break label164;
        }
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Package name ");
        ((StringBuilder)localObject).append(paramC.getPackageName());
        ((StringBuilder)localObject).append(" doesn't match with the uid ");
        ((StringBuilder)localObject).append(paramC.getUid());
        ((StringBuilder)localObject).toString();
        return false;
      }
      if ((!a(paramC, "android.permission.STATUS_BAR_SERVICE")) && (!a(paramC, "android.permission.MEDIA_CONTENT_CONTROL")) && (paramC.getUid() != 1000) && (!fill(paramC))) {
        break label164;
      }
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
    if (b)
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Package ");
      ((StringBuilder)localObject).append(paramC.getPackageName());
      ((StringBuilder)localObject).append(" doesn't exist");
      ((StringBuilder)localObject).toString();
      return false;
    }
    label164:
    return false;
  }
  
  public boolean fill(ea.c paramC)
  {
    Object localObject = Settings.Secure.getString(mContentResolver, "enabled_notification_listeners");
    if (localObject != null)
    {
      localObject = ((String)localObject).split(":");
      int i = 0;
      while (i < localObject.length)
      {
        ComponentName localComponentName = ComponentName.unflattenFromString(localObject[i]);
        if ((localComponentName != null) && (localComponentName.getPackageName().equals(paramC.getPackageName()))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public Context getContext()
  {
    return mContext;
  }
}
