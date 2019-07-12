package com.google.android.android.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import java.io.File;

public final class zzas
{
  public static RequestQueue newRequestQueue(Context paramContext, zzan paramZzan)
  {
    paramZzan = new File(paramContext.getCacheDir(), "volley");
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      i = versionCode;
      int j = String.valueOf(str).length();
      paramContext = new StringBuilder(j + 12);
      paramContext.append(str);
      paramContext.append("/");
      paramContext.append(i);
      paramContext.toString();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      int i;
      for (;;) {}
    }
    i = Build.VERSION.SDK_INT;
    paramContext = new zzad(new zzao(null, null));
    paramContext = new RequestQueue(new zzag(paramZzan, 5242880), paramContext, 4);
    paramContext.start();
    return paramContext;
  }
}
