package com.google.android.android.tagmanager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class Machine
  extends zzbr
{
  public static final String TAG = zzbd.zzlt.toString();
  public final Context mContext;
  
  public Machine(Context paramContext)
  {
    super(TAG, new String[0]);
    mContext = paramContext;
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    paramMap = mContext;
    try
    {
      paramMap = paramMap.getPackageManager();
      Context localContext = mContext;
      paramMap = paramMap.getPackageInfo(localContext.getPackageName(), 0);
      paramMap = versionName;
      paramMap = zzgk.zzah(paramMap);
      return paramMap;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      paramMap = mContext.getPackageName();
      String str = localNameNotFoundException.getMessage();
      StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramMap, 25)));
      localStringBuilder.append("Package name ");
      localStringBuilder.append(paramMap);
      localStringBuilder.append(" not found. ");
      localStringBuilder.append(str);
      paramMap = localStringBuilder.toString();
      zzdj.zzjss.get(paramMap);
    }
    return zzgk.zzjwp;
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
