package com.google.android.android.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.android.common.internal.zzbp;

public final class zzaou
{
  public static Object zzaqd = new Object();
  public static Boolean zzdjq;
  public static zzcqh zzdtw;
  
  public zzaou() {}
  
  public static void onReceive(Context paramContext, Intent paramIntent)
  {
    zzaon localZzaon = zzamu.zzbg(paramContext).zzvy();
    if (paramIntent == null)
    {
      localZzaon.zzdp("AnalyticsReceiver called with null intent");
      return;
    }
    paramIntent = paramIntent.getAction();
    localZzaon.d("Local AnalyticsReceiver got", paramIntent);
    if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(paramIntent))
    {
      boolean bool = zzaov.zzbi(paramContext);
      Intent localIntent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
      localIntent.setComponent(new ComponentName(paramContext, "com.google.android.gms.analytics.AnalyticsService"));
      localIntent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
      paramIntent = zzaqd;
      for (;;)
      {
        try
        {
          paramContext.startService(localIntent);
          if (!bool) {
            return;
          }
          if (zzdtw != null) {}
        }
        catch (Throwable paramContext)
        {
          throw paramContext;
        }
        try
        {
          paramContext = new zzcqh(paramContext, 1, "Analytics WakeLock");
          zzdtw = paramContext;
          paramContext.setReferenceCounted(false);
          paramContext = zzdtw;
          paramContext.acquire(1000L);
        }
        catch (SecurityException paramContext) {}
      }
      localZzaon.zzdp("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
      return;
    }
  }
  
  public static boolean zzbe(Context paramContext)
  {
    zzbp.append(paramContext);
    Boolean localBoolean = zzdjq;
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    boolean bool = zzapd.enable(paramContext, "com.google.android.gms.analytics.AnalyticsReceiver", false);
    zzdjq = Boolean.valueOf(bool);
    return bool;
  }
}
