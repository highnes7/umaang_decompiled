package com.google.android.android.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.android.common.util.KeyguardManager;

public final class zzbeb
{
  public static Context zzfzq;
  public static Boolean zzfzr;
  
  public static boolean zzcp(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localContext = paramContext.getApplicationContext();
        if ((zzfzq != null) && (zzfzr != null) && (zzfzq == localContext))
        {
          bool = zzfzr.booleanValue();
          return bool;
        }
        zzfzr = null;
        if (KeyguardManager.isAtLeastO())
        {
          paramContext = Boolean.valueOf(localContext.getPackageManager().isInstantApp());
          zzfzr = paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        Context localContext;
        boolean bool;
        throw paramContext;
      }
      try
      {
        paramContext.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
        zzfzr = Boolean.valueOf(true);
      }
      catch (ClassNotFoundException paramContext)
      {
        continue;
      }
      paramContext = Boolean.valueOf(false);
    }
    zzfzq = localContext;
    bool = zzfzr.booleanValue();
    return bool;
  }
}
