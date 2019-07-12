package com.google.android.android.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class zzbc
  extends zzbr
{
  public static final String cachePath = zzbd.zziq.toString();
  public final Context mContext;
  
  public zzbc(Context paramContext)
  {
    super(cachePath, new String[0]);
    mContext = paramContext;
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    paramMap = Settings.Secure.getString(mContext.getContentResolver(), "android_id");
    if (paramMap == null) {
      return zzgk.zzjwp;
    }
    return zzgk.zzah(paramMap);
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
