package support.android.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;

public final class e
{
  public static final int b = 2;
  public static final int c = 3;
  public static final int f = 1;
  
  public e() {}
  
  public static int a(ConnectivityManager paramConnectivityManager)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramConnectivityManager.getRestrictBackgroundStatus();
    }
    return 3;
  }
  
  public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager paramConnectivityManager, Intent paramIntent)
  {
    paramIntent = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
    if (paramIntent != null) {
      return paramConnectivityManager.getNetworkInfo(paramIntent.getType());
    }
    return null;
  }
  
  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    int i = Build.VERSION.SDK_INT;
    return paramConnectivityManager.isActiveNetworkMetered();
  }
}
