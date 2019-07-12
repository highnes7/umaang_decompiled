package com.google.android.android.internal;

import com.google.android.android.analytics.Log;
import com.google.android.gms.analytics.zzh;
import java.util.HashMap;
import java.util.Map;

public final class zzame
  extends zzh<com.google.android.gms.internal.zzame>
{
  public String zzdmw;
  public String zzdmx;
  public String zzdmy;
  public String zzdmz;
  public boolean zzdna;
  public String zzdnb;
  public boolean zzdnc;
  public double zzdnd;
  
  public zzame() {}
  
  public final String getUserId()
  {
    return zzdmy;
  }
  
  public final void setClientId(String paramString)
  {
    zzdmx = paramString;
  }
  
  public final void setUserId(String paramString)
  {
    zzdmy = paramString;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("hitType", zzdmw);
    localHashMap.put("clientId", zzdmx);
    localHashMap.put("userId", zzdmy);
    localHashMap.put("androidAdId", zzdmz);
    localHashMap.put("AdTargetingEnabled", Boolean.valueOf(zzdna));
    localHashMap.put("sessionControl", zzdnb);
    localHashMap.put("nonInteraction", Boolean.valueOf(zzdnc));
    localHashMap.put("sampleRate", Double.valueOf(zzdnd));
    return Log.getID(localHashMap);
  }
  
  public final void zzah(boolean paramBoolean)
  {
    zzdna = paramBoolean;
  }
  
  public final void zzai(boolean paramBoolean)
  {
    zzdnc = true;
  }
  
  public final void zzdh(String paramString)
  {
    zzdmw = paramString;
  }
  
  public final void zzdi(String paramString)
  {
    zzdmz = paramString;
  }
  
  public final String zzvd()
  {
    return zzdmw;
  }
  
  public final String zzve()
  {
    return zzdmx;
  }
  
  public final String zzvf()
  {
    return zzdmz;
  }
  
  public final boolean zzvg()
  {
    return zzdna;
  }
  
  public final String zzvh()
  {
    return zzdnb;
  }
  
  public final boolean zzvi()
  {
    return zzdnc;
  }
  
  public final double zzvj()
  {
    return zzdnd;
  }
}
