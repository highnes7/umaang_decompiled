package com.google.android.android.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.android.common.DataProvider;
import com.google.android.android.internal.zzbec;
import com.google.android.android.internal.zzbed;

public final class Connection
{
  public static boolean connect(Context paramContext, int paramInt, String paramString)
  {
    return zzbed.zzcr(paramContext).open(paramInt, paramString);
  }
  
  public static boolean execute(Context paramContext, int paramInt)
  {
    if (!connect(paramContext, paramInt, "com.google.android.gms")) {
      return false;
    }
    Object localObject = paramContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo("com.google.android.gms", 64);
      return DataProvider.zzbz(paramContext).backup(paramContext.getPackageManager(), (PackageInfo)localObject);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    Log.isLoggable("UidVerifier", 3);
    return false;
  }
}
