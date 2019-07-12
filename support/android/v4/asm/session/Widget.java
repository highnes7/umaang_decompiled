package support.android.v4.asm.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import java.util.List;

public class Widget
  extends BroadcastReceiver
{
  public static final String a = "MediaButtonReceiver";
  
  public Widget() {}
  
  public static PendingIntent a(Context paramContext, long paramLong)
  {
    ComponentName localComponentName = start(paramContext);
    if (localComponentName == null) {
      return null;
    }
    return a(paramContext, localComponentName, paramLong);
  }
  
  public static PendingIntent a(Context paramContext, ComponentName paramComponentName, long paramLong)
  {
    if (paramComponentName == null) {
      return null;
    }
    int i = PlaybackStateCompat.getToken(paramLong);
    if (i == 0)
    {
      paramContext = new StringBuilder();
      paramContext.append("Cannot build a media button pending intent with the given action: ");
      paramContext.append(paramLong);
      paramContext.toString();
      return null;
    }
    Intent localIntent = new Intent("android.intent.action.MEDIA_BUTTON");
    localIntent.setComponent(paramComponentName);
    localIntent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, i));
    return PendingIntent.getBroadcast(paramContext, i, localIntent, 0);
  }
  
  public static KeyEvent handleIntent(MediaSessionCompat paramMediaSessionCompat, Intent paramIntent)
  {
    if ((paramMediaSessionCompat != null) && (paramIntent != null) && ("android.intent.action.MEDIA_BUTTON".equals(paramIntent.getAction())) && (paramIntent.hasExtra("android.intent.extra.KEY_EVENT")))
    {
      paramIntent = (KeyEvent)paramIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
      paramMediaSessionCompat.getController().dispatchMediaButtonEvent(paramIntent);
      return paramIntent;
    }
    return null;
  }
  
  public static ComponentName start(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_BUTTON");
    localIntent.setPackage(paramContext.getPackageName());
    paramContext = paramContext.getPackageManager().queryBroadcastReceivers(localIntent, 0);
    if (paramContext.size() == 1)
    {
      paramContext = (ResolveInfo)paramContext.get(0);
      return new ComponentName(activityInfo.packageName, activityInfo.name);
    }
    paramContext.size();
    return null;
  }
  
  public static ComponentName start(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getPackageManager();
    Intent localIntent = new Intent(paramString);
    localIntent.setPackage(paramContext.getPackageName());
    paramContext = ((PackageManager)localObject).queryIntentServices(localIntent, 0);
    if (paramContext.size() == 1)
    {
      paramContext = (ResolveInfo)paramContext.get(0);
      return new ComponentName(serviceInfo.packageName, serviceInfo.name);
    }
    if (paramContext.isEmpty()) {
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected 1 service that handles ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", found ");
    ((StringBuilder)localObject).append(paramContext.size());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public static void start(Context paramContext, Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramContext.startForegroundService(paramIntent);
      return;
    }
    paramContext.startService(paramIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("android.intent.action.MEDIA_BUTTON".equals(paramIntent.getAction())) && (paramIntent.hasExtra("android.intent.extra.KEY_EVENT")))
    {
      ComponentName localComponentName = start(paramContext, "android.intent.action.MEDIA_BUTTON");
      if (localComponentName != null)
      {
        paramIntent.setComponent(localComponentName);
        start(paramContext, paramIntent);
        return;
      }
      localComponentName = start(paramContext, "android.media.browse.MediaBrowserService");
      if (localComponentName != null)
      {
        BroadcastReceiver.PendingResult localPendingResult = goAsync();
        paramContext = paramContext.getApplicationContext();
        paramIntent = new AnnotationWriter(paramContext, paramIntent, localPendingResult);
        paramContext = new MediaBrowserCompat(paramContext, localComponentName, paramIntent, null);
        paramIntent.visitEnum(paramContext);
        paramContext.connect();
        return;
      }
      throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.append("Ignore unsupported intent: ", paramIntent);
  }
}
