package com.google.android.android.common.internal;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.android.internal.zzbec;
import com.google.android.android.internal.zzbed;

public final class zzbe
{
  public static Object zzaqd = new Object();
  public static boolean zzclj;
  public static String zzfvo;
  public static int zzfvp;
  
  public static String zzcf(Context paramContext)
  {
    zzch(paramContext);
    return zzfvo;
  }
  
  public static int zzcg(Context paramContext)
  {
    zzch(paramContext);
    return zzfvp;
  }
  
  public static void zzch(Context paramContext)
  {
    Object localObject = zzaqd;
    try
    {
      if (zzclj) {
        return;
      }
      zzclj = true;
      String str = paramContext.getPackageName();
      paramContext = zzbed.zzcr(paramContext);
      try
      {
        paramContext = paramContext.getApplicationInfo(str, 128);
        paramContext = metaData;
        if (paramContext == null) {
          return;
        }
        str = paramContext.getString("com.google.app.id");
        zzfvo = str;
        int i = paramContext.getInt("com.google.android.gms.version");
        zzfvp = i;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.wtf("MetadataValueReader", "This should never happen.", paramContext);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
}
