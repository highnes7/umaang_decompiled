package com.google.android.android.internal;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Process;
import com.google.android.android.common.util.KeyguardManager;

public final class zzbec
{
  public Context mContext;
  
  public zzbec(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public final int checkCallingOrSelfPermission(String paramString)
  {
    return mContext.checkCallingOrSelfPermission(paramString);
  }
  
  public final int checkPermission(String paramString1, String paramString2)
  {
    return mContext.getPackageManager().checkPermission(paramString1, paramString2);
  }
  
  public final ApplicationInfo getApplicationInfo(String paramString, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return mContext.getPackageManager().getApplicationInfo(paramString, paramInt);
  }
  
  public final PackageInfo getPackageInfo(String paramString, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return mContext.getPackageManager().getPackageInfo(paramString, paramInt);
  }
  
  public final String[] getPackagesForUid(int paramInt)
  {
    return mContext.getPackageManager().getPackagesForUid(paramInt);
  }
  
  public final boolean open(int paramInt, String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = mContext;
    try
    {
      localObject = ((Context)localObject).getSystemService("appops");
      localObject = (AppOpsManager)localObject;
      ((AppOpsManager)localObject).checkPackage(paramInt, paramString);
      return true;
    }
    catch (SecurityException paramString)
    {
      for (;;) {}
    }
    return false;
  }
  
  public final boolean zzalq()
  {
    if (Binder.getCallingUid() == Process.myUid()) {
      return zzbeb.zzcp(mContext);
    }
    if (KeyguardManager.isAtLeastO())
    {
      String str = mContext.getPackageManager().getNameForUid(Binder.getCallingUid());
      if (str != null) {
        return mContext.getPackageManager().isInstantApp(str);
      }
    }
    return false;
  }
  
  public final CharSequence zzgn(String paramString)
    throws PackageManager.NameNotFoundException
  {
    return mContext.getPackageManager().getApplicationLabel(mContext.getPackageManager().getApplicationInfo(paramString, 0));
  }
}
