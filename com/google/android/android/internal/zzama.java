package com.google.android.android.internal;

import com.google.android.android.analytics.Log;
import com.google.android.gms.analytics.zzh;
import java.util.HashMap;
import java.util.Map;

public final class zzama
  extends zzh<com.google.android.gms.internal.zzama>
{
  public int zzceu;
  public int zzcev;
  public String zzdmn;
  public int zzdmo;
  public int zzdmp;
  public int zzdmq;
  
  public zzama() {}
  
  public final String getLanguage()
  {
    return zzdmn;
  }
  
  public final void setLanguage(String paramString)
  {
    zzdmn = paramString;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("language", zzdmn);
    localHashMap.put("screenColors", Integer.valueOf(zzdmo));
    localHashMap.put("screenWidth", Integer.valueOf(zzceu));
    localHashMap.put("screenHeight", Integer.valueOf(zzcev));
    localHashMap.put("viewportWidth", Integer.valueOf(zzdmp));
    localHashMap.put("viewportHeight", Integer.valueOf(zzdmq));
    return Log.getID(localHashMap);
  }
}
