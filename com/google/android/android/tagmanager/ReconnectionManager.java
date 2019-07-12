package com.google.android.android.tagmanager;

import com.google.android.android.common.GooglePlayServicesNotAvailableException;
import com.google.android.android.common.GooglePlayServicesRepairableException;
import com.google.android.android.wifi.identifier.AdvertisingIdClient;
import com.google.android.android.wifi.identifier.AdvertisingIdClient.Info;
import java.io.IOException;

public final class ReconnectionManager
  implements ConnectionListener
{
  public ReconnectionManager(ScreenshotTaker paramScreenshotTaker) {}
  
  public final AdvertisingIdClient.Info zzbci()
  {
    Object localObject = zzjop;
    try
    {
      localObject = AdvertisingIdClient.getAdvertisingIdInfo(ScreenshotTaker.access$getMContext((ScreenshotTaker)localObject));
      return localObject;
    }
    catch (Exception localException)
    {
      localZzdk = zzdj.zzjss;
      str = "Unknown exception. Could not get the Advertising Id Info.";
      localZzdk.closeSession(str, localException);
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      for (;;)
      {
        zzjop.close();
        localZzdk = zzdj.zzjss;
        str = "GooglePlayServicesNotAvailableException getting Advertising Id Info";
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localZzdk = zzdj.zzjss;
        str = "IOException getting Ad Id Info";
      }
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      for (;;)
      {
        localZzdk = zzdj.zzjss;
        str = "GooglePlayServicesRepairableException getting Advertising Id Info";
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        zzdk localZzdk = zzdj.zzjss;
        String str = "IllegalStateException getting Advertising Id Info";
      }
    }
    return null;
  }
}
