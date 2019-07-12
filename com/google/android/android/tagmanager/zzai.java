package com.google.android.android.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.android.common.internal.zzbp;
import java.util.Random;

public final class zzai
{
  public final Context mContext;
  public final Random zzbds;
  public final String zzjoz;
  
  public zzai(Context paramContext, String paramString)
  {
    this(paramContext, paramString, new Random());
  }
  
  public zzai(Context paramContext, String paramString, Random paramRandom)
  {
    zzbp.append(paramContext);
    mContext = ((Context)paramContext);
    zzbp.append(paramString);
    zzjoz = ((String)paramString);
    zzbds = paramRandom;
  }
  
  private final long tick(long paramLong1, long paramLong2)
  {
    SharedPreferences localSharedPreferences = zzbdb();
    long l1 = Math.max(0L, localSharedPreferences.getLong("FORBIDDEN_COUNT", 0L));
    long l2 = Math.max(0L, localSharedPreferences.getLong("SUCCESSFUL_COUNT", 0L));
    paramLong2 = ((float)l1 / (float)(l1 + l2 + 1L) * (float)(paramLong2 - paramLong1));
    return (zzbds.nextFloat() * (float)(paramLong1 + paramLong2));
  }
  
  private final SharedPreferences zzbdb()
  {
    Context localContext = mContext;
    String str = String.valueOf(zzjoz);
    if (str.length() != 0) {
      str = "_gtmContainerRefreshPolicy_".concat(str);
    } else {
      str = new String("_gtmContainerRefreshPolicy_");
    }
    return localContext.getSharedPreferences(str, 0);
  }
  
  public final long zzbcx()
  {
    return tick(7200000L, 259200000L) + 43200000L;
  }
  
  public final long zzbcy()
  {
    return tick(600000L, 86400000L) + 3600000L;
  }
  
  public final void zzbcz()
  {
    Object localObject = zzbdb();
    long l1 = ((SharedPreferences)localObject).getLong("FORBIDDEN_COUNT", 0L);
    long l2 = ((SharedPreferences)localObject).getLong("SUCCESSFUL_COUNT", 0L);
    localObject = ((SharedPreferences)localObject).edit();
    if (l1 == 0L) {
      l1 = 3L;
    } else {
      l1 = Math.min(10L, l1 + 1L);
    }
    l2 = Math.max(0L, Math.min(l2, 10L - l1));
    ((SharedPreferences.Editor)localObject).putLong("FORBIDDEN_COUNT", l1);
    ((SharedPreferences.Editor)localObject).putLong("SUCCESSFUL_COUNT", l2);
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  public final void zzbda()
  {
    Object localObject = zzbdb();
    long l2 = ((SharedPreferences)localObject).getLong("SUCCESSFUL_COUNT", 0L);
    long l1 = ((SharedPreferences)localObject).getLong("FORBIDDEN_COUNT", 0L);
    l2 = Math.min(10L, l2 + 1L);
    l1 = Math.max(0L, Math.min(l1, 10L - l2));
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("SUCCESSFUL_COUNT", l2);
    ((SharedPreferences.Editor)localObject).putLong("FORBIDDEN_COUNT", l1);
    ((SharedPreferences.Editor)localObject).apply();
  }
}
