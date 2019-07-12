package com.google.android.android.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class Transform
  extends zzbr
{
  public static final String locale = zzbd.zzhl.toString();
  public final Context mContext;
  
  public Transform(Context paramContext)
  {
    super(locale, new String[0]);
    mContext = paramContext;
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    paramMap = mContext;
    try
    {
      paramMap = paramMap.getPackageManager();
      Context localContext = mContext;
      paramMap = zzgk.zzah(paramMap.getApplicationLabel(paramMap.getApplicationInfo(localContext.getPackageName(), 0)).toString());
      return paramMap;
    }
    catch (PackageManager.NameNotFoundException paramMap)
    {
      zzdj.zzjss.e("App name is not found.", paramMap);
    }
    return zzgk.zzjwp;
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
