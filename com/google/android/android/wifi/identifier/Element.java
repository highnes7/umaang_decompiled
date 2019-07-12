package com.google.android.android.wifi.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.google.android.android.common.TransactionInput;

public class Element
{
  public static Element zzaly;
  public final Context zzahz;
  
  public Element(Context paramContext)
  {
    zzahz = paramContext;
  }
  
  public static Element getChild(Context paramContext)
  {
    try
    {
      if (zzaly == null) {
        zzaly = new Element(paramContext);
      }
      paramContext = zzaly;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  private final void write(AdvertisingIdClient.Info paramInfo, boolean paramBoolean, long paramLong)
  {
    Object localObject2 = zzahz;
    Object localObject1 = null;
    try
    {
      localObject2 = TransactionInput.getRemoteContext((Context)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((Context)localObject2).getSharedPreferences("google_ads_flags", 0);
        localObject1 = localObject2;
      }
    }
    catch (Throwable localThrowable2)
    {
      float f1;
      for (;;) {}
    }
    f1 = 0.0F;
    if (localObject1 != null) {}
    try
    {
      float f2 = localObject1.getFloat("gads:ad_id_use_shared_preference:ping_ratio", 0.0F);
      f1 = f2;
    }
    catch (Throwable localThrowable1)
    {
      for (;;) {}
    }
    if (Math.random() > f1) {
      return;
    }
    new Thread(new IonBitmapRequestBuilder.1(paramInfo, paramBoolean, paramLong)).start();
  }
  
  public final AdvertisingIdClient.Info getInfo()
  {
    Object localObject1 = TransactionInput.getRemoteContext(zzahz);
    Object localObject2 = null;
    if (localObject1 == null)
    {
      write(null, false, -1L);
      return null;
    }
    SharedPreferences localSharedPreferences = ((Context)localObject1).getSharedPreferences("adid_settings", 0);
    if (localSharedPreferences == null)
    {
      write(null, false, -1L);
      return null;
    }
    long l = SystemClock.elapsedRealtime();
    localObject1 = localObject2;
    if (localSharedPreferences.contains("adid_key")) {
      if (!localSharedPreferences.contains("enable_limit_ad_tracking")) {
        localObject1 = localObject2;
      } else {
        localObject1 = new AdvertisingIdClient.Info(localSharedPreferences.getString("adid_key", ""), localSharedPreferences.getBoolean("enable_limit_ad_tracking", false));
      }
    }
    write((AdvertisingIdClient.Info)localObject1, true, SystemClock.elapsedRealtime() - l);
    return localObject1;
  }
}
