package com.google.android.android.internal;

import com.google.android.android.analytics.Log;
import com.google.android.gms.analytics.zzh;
import java.util.HashMap;
import java.util.Map;

public final class zzamc
  extends zzh<com.google.android.gms.internal.zzamc>
{
  public String mCategory;
  public String zzdmr;
  public String zzdms;
  public long zzdmt;
  
  public zzamc() {}
  
  public final String getAction()
  {
    return zzdmr;
  }
  
  public final String getCategory()
  {
    return mCategory;
  }
  
  public final String getLabel()
  {
    return zzdms;
  }
  
  public final long getValue()
  {
    return zzdmt;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("category", mCategory);
    localHashMap.put("action", zzdmr);
    localHashMap.put("label", zzdms);
    localHashMap.put("value", Long.valueOf(zzdmt));
    return Log.getID(localHashMap);
  }
}
