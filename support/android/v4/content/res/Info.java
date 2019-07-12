package support.android.v4.content.res;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import b.b.a.W;
import java.util.Iterator;
import java.util.List;
import support.android.v4.content.ContextCompat;

public class Info
{
  @W
  public static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
  @W
  public static final String url = "com.android.launcher.permission.INSTALL_SHORTCUT";
  
  public Info() {}
  
  public static boolean init(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
    }
    if (ContextCompat.checkSelfPermission(paramContext, "com.android.launcher.permission.INSTALL_SHORTCUT") != 0) {
      return false;
    }
    paramContext = paramContext.getPackageManager().queryBroadcastReceivers(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"), 0).iterator();
    while (paramContext.hasNext())
    {
      String str = nextactivityInfo.permission;
      if ((TextUtils.isEmpty(str)) || ("com.android.launcher.permission.INSTALL_SHORTCUT".equals(str))) {
        return true;
      }
    }
    return false;
  }
  
  public static Intent onCreateView(Context paramContext, h paramH)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramContext = ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).createShortcutResultIntent(paramH.e());
    } else {
      paramContext = null;
    }
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = new Intent();
    }
    return paramH.a((Intent)localObject);
  }
  
  public static boolean onCreateView(Context paramContext, h paramH, IntentSender paramIntentSender)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return ((ShortcutManager)paramContext.getSystemService(ShortcutManager.class)).requestPinShortcut(paramH.e(), paramIntentSender);
    }
    if (!init(paramContext)) {
      return false;
    }
    paramH = paramH.a(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"));
    if (paramIntentSender == null)
    {
      paramContext.sendBroadcast(paramH);
      return true;
    }
    paramContext.sendOrderedBroadcast(paramH, null, new BluetoothManager.1(paramIntentSender), null, -1, null, null);
    return true;
  }
}
