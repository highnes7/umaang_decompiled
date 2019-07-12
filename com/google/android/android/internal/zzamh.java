package com.google.android.android.internal;

import com.google.android.android.analytics.Log;
import com.google.android.gms.analytics.zzh;
import java.util.HashMap;
import java.util.Map;

public final class zzamh
  extends zzh<com.google.android.gms.internal.zzamh>
{
  public String mCategory;
  public String zzdms;
  public String zzdnm;
  public long zzdnn;
  
  public zzamh() {}
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("variableName", zzdnm);
    localHashMap.put("timeInMillis", Long.valueOf(zzdnn));
    localHashMap.put("category", mCategory);
    localHashMap.put("label", zzdms);
    return Log.getID(localHashMap);
  }
}
