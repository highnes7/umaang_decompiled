package com.google.android.android.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.android.internal.zzbec;
import com.google.android.android.internal.zzbed;

public final class Filter
{
  public static int getIcon(Context paramContext, String paramString)
  {
    paramContext = zzaa(paramContext, paramString);
    if (paramContext != null)
    {
      paramContext = applicationInfo;
      if (paramContext == null) {
        return -1;
      }
      paramContext = metaData;
      if (paramContext == null) {
        return -1;
      }
      return paramContext.getInt("com.google.android.gms.version", -1);
    }
    return -1;
  }
  
  public static PackageInfo zzaa(Context paramContext, String paramString)
  {
    try
    {
      paramContext = zzbed.zzcr(paramContext).getPackageInfo(paramString, 128);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static boolean zzab(Context paramContext, String paramString)
  {
    "com.google.android.gms".equals(paramString);
    try
    {
      paramContext = zzbed.zzcr(paramContext).getApplicationInfo(paramString, 0);
      return (flags & 0x200000) != 0;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
}
