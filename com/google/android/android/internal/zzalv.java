package com.google.android.android.internal;

import android.text.TextUtils;
import com.google.android.android.analytics.Log;
import com.google.android.gms.analytics.zzh;
import java.util.HashMap;
import java.util.Map;

public final class zzalv
  extends zzh<com.google.android.gms.internal.zzalv>
{
  public String mAppId;
  public String zzdmb;
  public String zzdmc;
  public String zzdmd;
  
  public zzalv() {}
  
  public final String getAppId()
  {
    return mAppId;
  }
  
  public final void setAppId(String paramString)
  {
    mAppId = paramString;
  }
  
  public final void setAppInstallerId(String paramString)
  {
    zzdmd = paramString;
  }
  
  public final void setAppName(String paramString)
  {
    zzdmb = paramString;
  }
  
  public final void setAppVersion(String paramString)
  {
    zzdmc = paramString;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appName", zzdmb);
    localHashMap.put("appVersion", zzdmc);
    localHashMap.put("appId", mAppId);
    localHashMap.put("appInstallerId", zzdmd);
    return Log.getID(localHashMap);
  }
  
  public final void updateButton(zzalv paramZzalv)
  {
    if (!TextUtils.isEmpty(zzdmb)) {
      zzdmb = zzdmb;
    }
    if (!TextUtils.isEmpty(zzdmc)) {
      zzdmc = zzdmc;
    }
    if (!TextUtils.isEmpty(mAppId)) {
      mAppId = mAppId;
    }
    if (!TextUtils.isEmpty(zzdmd)) {
      zzdmd = zzdmd;
    }
  }
  
  public final String zzun()
  {
    return zzdmb;
  }
  
  public final String zzuo()
  {
    return zzdmc;
  }
  
  public final String zzup()
  {
    return zzdmd;
  }
}
