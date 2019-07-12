package com.google.android.android.internal;

import com.google.android.android.analytics.Log;
import com.google.android.android.common.internal.zzbp;
import com.google.android.gms.analytics.zzh;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzalz
  extends zzh<com.google.android.gms.internal.zzalz>
{
  public final Map<String, Object> zzbqm = new HashMap();
  
  public zzalz() {}
  
  public final String toString()
  {
    return Log.getID(zzbqm);
  }
  
  public final void write(String paramString1, String paramString2)
  {
    zzbp.zzgg(paramString1);
    String str = paramString1;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString1.startsWith("&")) {
        str = paramString1.substring(1);
      }
    }
    zzbp.format(str, "Name can not be empty or \"&\"");
    zzbqm.put(str, paramString2);
  }
  
  public final Map zzuy()
  {
    return Collections.unmodifiableMap(zzbqm);
  }
}
