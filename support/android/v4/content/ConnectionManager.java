package support.android.v4.content;

import android.accessibilityservice.AccessibilityService;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import java.util.HashMap;

public final class ConnectionManager
{
  public static final HashMap<Class<?>, String> instance = new HashMap();
  
  static
  {
    if (Build.VERSION.SDK_INT > 22)
    {
      instance.put(SubscriptionManager.class, "telephony_subscription_service");
      instance.put(UsageStatsManager.class, "usagestats");
    }
    if (Build.VERSION.SDK_INT > 21)
    {
      instance.put(AppWidgetManager.class, "appwidget");
      instance.put(BatteryManager.class, "batterymanager");
      instance.put(CameraManager.class, "camera");
      instance.put(JobScheduler.class, "jobscheduler");
      instance.put(LauncherApps.class, "launcherapps");
      instance.put(MediaProjectionManager.class, "media_projection");
      instance.put(MediaSessionManager.class, "media_session");
      instance.put(RestrictionsManager.class, "restrictions");
      instance.put(TelecomManager.class, "telecom");
      instance.put(TvInputManager.class, "tv_input");
    }
    if (Build.VERSION.SDK_INT > 19)
    {
      instance.put(AppOpsManager.class, "appops");
      instance.put(CaptioningManager.class, "captioning");
      instance.put(ConsumerIrManager.class, "consumer_ir");
      instance.put(PrintManager.class, "print");
    }
    int i = Build.VERSION.SDK_INT;
    instance.put(BluetoothManager.class, "bluetooth");
    i = Build.VERSION.SDK_INT;
    instance.put(DisplayManager.class, "display");
    instance.put(UserManager.class, "user");
    i = Build.VERSION.SDK_INT;
    instance.put(InputManager.class, "input");
    instance.put(MediaRouter.class, "media_router");
    instance.put(NsdManager.class, "servicediscovery");
    instance.put(AccessibilityService.class, "accessibility");
    instance.put(AccountManager.class, "account");
    instance.put(ActivityManager.class, "activity");
    instance.put(AlarmManager.class, "alarm");
    instance.put(AudioManager.class, "audio");
    instance.put(ClipboardManager.class, "clipboard");
    instance.put(ConnectivityManager.class, "connectivity");
    instance.put(DevicePolicyManager.class, "device_policy");
    instance.put(DownloadManager.class, "download");
    instance.put(DropBoxManager.class, "dropbox");
    instance.put(InputMethodManager.class, "input_method");
    instance.put(KeyguardManager.class, "keyguard");
    instance.put(LayoutInflater.class, "layout_inflater");
    instance.put(LocationManager.class, "location");
    instance.put(NfcManager.class, "nfc");
    instance.put(NotificationManager.class, "notification");
    instance.put(PowerManager.class, "power");
    instance.put(SearchManager.class, "search");
    instance.put(SensorManager.class, "sensor");
    instance.put(StorageManager.class, "storage");
    instance.put(TelephonyManager.class, "phone");
    instance.put(TextServicesManager.class, "textservices");
    instance.put(UiModeManager.class, "uimode");
    instance.put(UsbManager.class, "usb");
    instance.put(Vibrator.class, "vibrator");
    instance.put(WallpaperManager.class, "wallpaper");
    instance.put(WifiP2pManager.class, "wifip2p");
    instance.put(WifiManager.class, "wifi");
    instance.put(WindowManager.class, "window");
  }
  
  public ConnectionManager() {}
}
