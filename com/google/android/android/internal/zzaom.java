package com.google.android.android.internal;

import com.google.android.android.analytics.Logger;

@Deprecated
public final class zzaom
{
  public static volatile Logger zzdth = new zzanw();
  
  public static void doGet(String paramString, Object paramObject)
  {
    Object localObject = zzaon.zzdti;
    if (localObject != null)
    {
      ((zzamr)localObject).toString(paramString, paramObject);
    }
    else if (zzad(3))
    {
      if (paramObject != null)
      {
        paramObject = String.valueOf(paramObject);
        int i = f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, 1);
        localObject = new StringBuilder(paramObject.length() + i);
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(paramObject);
        ((StringBuilder)localObject).toString();
      }
      paramObject = (String)zzaod.zzdrb.setDoOutput();
    }
    paramObject = zzdth;
    if (paramObject != null) {
      paramObject.error(paramString);
    }
  }
  
  public static Logger getLogger()
  {
    return zzdth;
  }
  
  public static void setLogger(Logger paramLogger)
  {
    zzdth = paramLogger;
  }
  
  public static void url(String paramString)
  {
    Object localObject = zzaon.zzdti;
    if (localObject != null) {
      ((zzamr)localObject).zzdm(paramString);
    } else if (zzad(0)) {
      localObject = (String)zzaod.zzdrb.setDoOutput();
    }
    localObject = zzdth;
    if (localObject != null) {
      ((Logger)localObject).verbose(paramString);
    }
  }
  
  public static boolean zzad(int paramInt)
  {
    return (zzdth != null) && (zzdth.getLogLevel() <= paramInt);
  }
  
  public static void zzcr(String paramString)
  {
    Object localObject = zzaon.zzdti;
    if (localObject != null) {
      ((zzamr)localObject).zzdp(paramString);
    } else if (zzad(2)) {
      localObject = (String)zzaod.zzdrb.setDoOutput();
    }
    localObject = zzdth;
    if (localObject != null) {
      ((Logger)localObject).warn(paramString);
    }
  }
}
