package views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public final class CordovaWebView
{
  public static final String KEY_EXTRAS = "extras";
  public static final String TAG = "target_url";
  public static final String baseUrl = "al_applink_data";
  
  public CordovaWebView() {}
  
  public static Bundle getExtras(Intent paramIntent)
  {
    paramIntent = paramIntent.getBundleExtra("al_applink_data");
    if (paramIntent == null) {
      return null;
    }
    return paramIntent.getBundle("extras");
  }
  
  public static Uri getUri(Intent paramIntent)
  {
    Object localObject = paramIntent.getBundleExtra("al_applink_data");
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("target_url");
      if (localObject != null) {
        return Uri.parse((String)localObject);
      }
    }
    return paramIntent.getData();
  }
  
  public static Uri handleIntent(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getBundleExtra("al_applink_data");
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("target_url");
      if (localObject != null)
      {
        LocalBroadcastManager.sendMessage(paramContext, "al_nav_in", paramIntent, null);
        return Uri.parse((String)localObject);
      }
    }
    return null;
  }
  
  public static Bundle setup(Intent paramIntent)
  {
    return paramIntent.getBundleExtra("al_applink_data");
  }
}
