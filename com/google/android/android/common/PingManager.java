package com.google.android.android.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.android.common.internal.zzaj;
import com.google.android.android.common.util.IpAddress;
import com.google.android.android.internal.zzbec;
import com.google.android.android.internal.zzbed;

public class PingManager
{
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = TransactionInput.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  public static final PingManager zzffk = new PingManager();
  
  public PingManager() {}
  
  public static boolean create(Context paramContext, int paramInt)
  {
    return TransactionInput.parse(paramContext, paramInt);
  }
  
  public static Intent get(Context paramContext, int paramInt, String paramString)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3) {
        return null;
      }
      return zzaj.zzge("com.google.android.gms");
    }
    if ((paramContext != null) && (IpAddress.zzcj(paramContext))) {
      return zzaj.zzakj();
    }
    return zzaj.execute("com.google.android.gms", getVersionCode(paramContext, paramString));
  }
  
  public static String getVersionCode(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("gcore_");
    localStringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    localStringBuilder.append("-");
    if (!TextUtils.isEmpty(paramString)) {
      localStringBuilder.append(paramString);
    }
    localStringBuilder.append("-");
    if (paramContext != null) {
      localStringBuilder.append(paramContext.getPackageName());
    }
    localStringBuilder.append("-");
    if (paramContext != null) {}
    try
    {
      paramContext = zzbed.zzcr(paramContext).getPackageInfo(paramContext.getPackageName(), 0);
      int i = versionCode;
      localStringBuilder.append(i);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return localStringBuilder.toString();
  }
  
  public static PingManager zzaex()
  {
    return zzffk;
  }
  
  public static void zzbu(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    TransactionInput.zzbj(paramContext);
  }
  
  public static void zzbv(Context paramContext)
  {
    TransactionInput.zzbv(paramContext);
  }
  
  public static int zzbw(Context paramContext)
  {
    return TransactionInput.zzbw(paramContext);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return init(paramContext, paramInt1, paramInt2, null);
  }
  
  public String getErrorString(int paramInt)
  {
    return TransactionInput.getErrorString(paramInt);
  }
  
  public final PendingIntent init(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    paramString = get(paramContext, paramInt1, paramString);
    if (paramString == null) {
      return null;
    }
    return PendingIntent.getActivity(paramContext, paramInt2, paramString, 268435456);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    int i = TransactionInput.isGooglePlayServicesAvailable(paramContext);
    if (TransactionInput.parse(paramContext, i)) {
      return 18;
    }
    return i;
  }
  
  public boolean isUserResolvableError(int paramInt)
  {
    return TransactionInput.isUserRecoverableError(paramInt);
  }
  
  public final Intent zzbn(int paramInt)
  {
    return get(null, paramInt, null);
  }
}
