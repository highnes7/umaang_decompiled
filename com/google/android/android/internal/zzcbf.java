package com.google.android.android.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.android.common.internal.zzbp;
import java.util.Iterator;
import java.util.Set;

public final class zzcbf
{
  public final String mAppId;
  public final String mName;
  public String mOrigin;
  public final long zzfdc;
  public final long zzinj;
  public final zzcbh zzink;
  
  public zzcbf(zzccw paramZzccw, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    zzbp.zzgg(paramString2);
    zzbp.zzgg(paramString3);
    mAppId = paramString2;
    mName = paramString3;
    paramString3 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString3 = null;
    }
    mOrigin = paramString3;
    zzfdc = paramLong1;
    zzinj = paramLong2;
    paramLong1 = zzinj;
    if ((paramLong1 != 0L) && (paramLong1 > zzfdc)) {
      paramZzccw.zzaul().zzayf().append("Event created with reverse previous/current timestamps. appId", zzcbw.zzjf(paramString2));
    }
    zzink = internalAdd(paramZzccw, paramBundle);
  }
  
  public zzcbf(zzccw paramZzccw, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, zzcbh paramZzcbh)
  {
    zzbp.zzgg(paramString2);
    zzbp.zzgg(paramString3);
    zzbp.append(paramZzcbh);
    mAppId = paramString2;
    mName = paramString3;
    paramString3 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString3 = null;
    }
    mOrigin = paramString3;
    zzfdc = paramLong1;
    zzinj = paramLong2;
    paramLong1 = zzinj;
    if ((paramLong1 != 0L) && (paramLong1 > zzfdc)) {
      paramZzccw.zzaul().zzayf().append("Event created with reverse previous/current timestamps. appId", zzcbw.zzjf(paramString2));
    }
    zzink = paramZzcbh;
  }
  
  public static zzcbh internalAdd(zzccw paramZzccw, Bundle paramBundle)
  {
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      paramBundle = new Bundle(paramBundle);
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str == null) {
          paramZzccw.zzaul().zzayd().append("Param name can't be null");
        }
        Object localObject;
        for (;;)
        {
          localIterator.remove();
          break;
          localObject = paramZzccw.zzauh().get(str, paramBundle.get(str));
          if (localObject != null) {
            break label117;
          }
          paramZzccw.zzaul().zzayf().append("Param value can't be null", paramZzccw.zzaug().zzjd(str));
        }
        label117:
        paramZzccw.zzauh().add(paramBundle, str, localObject);
      }
      return new zzcbh(paramBundle);
    }
    return new zzcbh(new Bundle());
  }
  
  public final zzcbf getSharedPreferences(zzccw paramZzccw, long paramLong)
  {
    return new zzcbf(paramZzccw, mOrigin, mAppId, mName, zzfdc, paramLong, zzink);
  }
  
  public final String toString()
  {
    String str1 = mAppId;
    String str2 = mName;
    String str3 = String.valueOf(zzink);
    int i = f.sufficientlysecure.rootcommands.util.StringBuilder.append(str2, f.sufficientlysecure.rootcommands.util.StringBuilder.append(str1, 33));
    StringBuilder localStringBuilder = new StringBuilder(str3.length() + i);
    localStringBuilder.append("Event{appId='");
    localStringBuilder.append(str1);
    localStringBuilder.append("', name='");
    localStringBuilder.append(str2);
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, "', params=", str3, "}");
  }
}
