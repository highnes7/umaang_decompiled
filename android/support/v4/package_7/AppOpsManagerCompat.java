package android.support.v4.package_7;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;

public final class AppOpsManagerCompat
{
  public static final int MODE_ALLOWED = 0;
  public static final int MODE_DEFAULT = 3;
  public static final int MODE_ERRORED = 2;
  public static final int MODE_IGNORED = 1;
  
  public AppOpsManagerCompat() {}
  
  public static int noteOp(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    int i = Build.VERSION.SDK_INT;
    return ((AppOpsManager)paramContext.getSystemService("appops")).noteOp(paramString1, paramInt, paramString2);
  }
  
  public static int noteOpNoThrow(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    int i = Build.VERSION.SDK_INT;
    return ((AppOpsManager)paramContext.getSystemService("appops")).noteOpNoThrow(paramString1, paramInt, paramString2);
  }
  
  public static int noteProxyOp(Context paramContext, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOp(paramString1, paramString2);
    }
    return 1;
  }
  
  public static int noteProxyOpNoThrow(Context paramContext, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(paramString1, paramString2);
    }
    return 1;
  }
  
  public static String permissionToOp(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return AppOpsManager.permissionToOp(paramString);
    }
    return null;
  }
}
