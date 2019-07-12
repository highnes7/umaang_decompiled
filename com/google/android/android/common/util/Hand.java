package com.google.android.android.common.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class Hand
{
  public static IntentFilter zzfyx = new IntentFilter("android.intent.action.BATTERY_CHANGED");
  public static long zzfyy;
  public static float zzfyz = NaN.0F;
  
  public static int zzcm(Context paramContext)
  {
    if (paramContext != null)
    {
      if (paramContext.getApplicationContext() == null) {
        return -1;
      }
      Intent localIntent = paramContext.getApplicationContext().registerReceiver(null, zzfyx);
      int j = 0;
      int i;
      if (localIntent == null) {
        i = 0;
      } else {
        i = localIntent.getIntExtra("plugged", 0);
      }
      if ((i & 0x7) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      paramContext = (PowerManager)paramContext.getSystemService("power");
      if (paramContext == null) {
        return -1;
      }
      boolean bool;
      if (KeyguardManager.zzali()) {
        bool = paramContext.isInteractive();
      } else {
        bool = paramContext.isScreenOn();
      }
      if (bool) {
        j = 1;
      }
      return j << 1 | i;
    }
    return -1;
  }
  
  public static float zzcn(Context paramContext)
  {
    try
    {
      if ((SystemClock.elapsedRealtime() - zzfyy < 60000L) && (!Float.isNaN(zzfyz)))
      {
        f = zzfyz;
        return f;
      }
      paramContext = paramContext.getApplicationContext().registerReceiver(null, zzfyx);
      if (paramContext != null)
      {
        int i = paramContext.getIntExtra("level", -1);
        int j = paramContext.getIntExtra("scale", -1);
        zzfyz = i / j;
      }
      zzfyy = SystemClock.elapsedRealtime();
      float f = zzfyz;
      return f;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
}
