package com.google.android.android.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.android.common.util.Hand;
import java.util.List;

public final class Vector3
{
  public static boolean zzfxk = false;
  public static Vector3 zzfyk = new Vector3();
  public static Boolean zzfyl;
  
  public Vector3() {}
  
  public static void add(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List paramList)
  {
    add(paramContext, paramString1, 8, paramString2, paramString3, paramString4, paramInt2, paramList, 0L);
  }
  
  public static void add(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List paramList, long paramLong)
  {
    List localList2 = paramList;
    if (zzfyl == null) {
      zzfyl = Boolean.valueOf(false);
    }
    if (!zzfyl.booleanValue()) {
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramContext = String.valueOf(paramString1);
      if (paramContext.length() != 0)
      {
        "missing wakeLock key. ".concat(paramContext);
        return;
      }
      new String("missing wakeLock key. ");
      return;
    }
    long l1 = System.currentTimeMillis();
    if ((7 == paramInt1) || (8 == paramInt1) || (10 == paramInt1) || (11 == paramInt1))
    {
      List localList1 = localList2;
      if (paramList != null)
      {
        localList1 = localList2;
        if (paramList.size() == 1)
        {
          localList1 = localList2;
          if ("com.google.android.gms".equals(paramList.get(0))) {
            localList1 = null;
          }
        }
      }
      long l2 = SystemClock.elapsedRealtime();
      int i = Hand.zzcm(paramContext);
      paramList = paramContext.getPackageName();
      if ("com.google.android.gms".equals(paramList)) {
        paramList = null;
      }
      paramString1 = new WakeLockEvent(l1, paramInt1, paramString2, paramInt2, localList1, paramString1, l2, i, paramString3, paramList, Hand.zzcn(paramContext), paramLong, paramString4);
      try
      {
        paramString2 = new Intent();
        paramString3 = Table.1.zzfxp;
        paramContext.startService(paramString2.setComponent(paramString3).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramString1));
        return;
      }
      catch (Exception paramContext)
      {
        Log.wtf("WakeLockTracker", paramContext);
      }
    }
  }
  
  public static Vector3 zzalb()
  {
    return zzfyk;
  }
}
