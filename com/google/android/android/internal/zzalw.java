package com.google.android.android.internal;

import com.google.android.android.analytics.Log;
import com.google.android.gms.analytics.zzh;
import java.util.HashMap;
import java.util.Map;

public final class zzalw
  extends zzh<com.google.android.gms.internal.zzalw>
{
  public String mName;
  public String zzbqs;
  public String zzbsx;
  public String zzdme;
  public String zzdmf;
  public String zzdmg;
  public String zzdmh;
  public String zzdmi;
  public String zzdmj;
  public String zzdmk;
  
  public zzalw() {}
  
  public final String getContent()
  {
    return zzbqs;
  }
  
  public final String getId()
  {
    return zzbsx;
  }
  
  public final String getName()
  {
    return mName;
  }
  
  public final String getSource()
  {
    return zzdme;
  }
  
  public final void setName(String paramString)
  {
    mName = paramString;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", mName);
    localHashMap.put("source", zzdme);
    localHashMap.put("medium", zzdmf);
    localHashMap.put("keyword", zzdmg);
    localHashMap.put("content", zzbqs);
    localHashMap.put("id", zzbsx);
    localHashMap.put("adNetworkId", zzdmh);
    localHashMap.put("gclid", zzdmi);
    localHashMap.put("dclid", zzdmj);
    localHashMap.put("aclid", zzdmk);
    return Log.getID(localHashMap);
  }
  
  public final void zzcy(String paramString)
  {
    zzdme = paramString;
  }
  
  public final void zzcz(String paramString)
  {
    zzdmf = paramString;
  }
  
  public final void zzda(String paramString)
  {
    zzdmg = paramString;
  }
  
  public final void zzdb(String paramString)
  {
    zzbqs = paramString;
  }
  
  public final void zzdc(String paramString)
  {
    zzbsx = paramString;
  }
  
  public final void zzdd(String paramString)
  {
    zzdmh = paramString;
  }
  
  public final void zzde(String paramString)
  {
    zzdmi = paramString;
  }
  
  public final void zzdf(String paramString)
  {
    zzdmj = paramString;
  }
  
  public final void zzdg(String paramString)
  {
    zzdmk = paramString;
  }
  
  public final String zzuq()
  {
    return zzdmf;
  }
  
  public final String zzur()
  {
    return zzdmg;
  }
  
  public final String zzus()
  {
    return zzdmh;
  }
  
  public final String zzut()
  {
    return zzdmi;
  }
  
  public final String zzuu()
  {
    return zzdmj;
  }
  
  public final String zzuv()
  {
    return zzdmk;
  }
}
