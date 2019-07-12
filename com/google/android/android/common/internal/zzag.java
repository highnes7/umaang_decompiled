package com.google.android.android.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;

public final class zzag
{
  public final String zzdmr;
  public final String zzfuv;
  public final ComponentName zzfuw;
  public final int zzfux;
  
  public zzag(ComponentName paramComponentName, int paramInt)
  {
    zzdmr = null;
    zzfuv = null;
    zzbp.append(paramComponentName);
    zzfuw = ((ComponentName)paramComponentName);
    zzfux = 129;
  }
  
  public zzag(String paramString1, String paramString2, int paramInt)
  {
    zzbp.zzgg(paramString1);
    zzdmr = paramString1;
    zzbp.zzgg(paramString2);
    zzfuv = paramString2;
    zzfuw = null;
    zzfux = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzag)) {
      return false;
    }
    paramObject = (zzag)paramObject;
    return (zzbf.equal(zzdmr, zzdmr)) && (zzbf.equal(zzfuv, zzfuv)) && (zzbf.equal(zzfuw, zzfuw)) && (zzfux == zzfux);
  }
  
  public final ComponentName getComponentName()
  {
    return zzfuw;
  }
  
  public final String getPackage()
  {
    return zzfuv;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { zzdmr, zzfuv, zzfuw, Integer.valueOf(zzfux) });
  }
  
  public final String toString()
  {
    String str2 = zzdmr;
    String str1 = str2;
    if (str2 == null) {
      str1 = zzfuw.flattenToString();
    }
    return str1;
  }
  
  public final int zzakg()
  {
    return zzfux;
  }
  
  public final Intent zzakh()
  {
    String str = zzdmr;
    if (str != null) {
      return new Intent(str).setPackage(zzfuv);
    }
    return new Intent().setComponent(zzfuw);
  }
}
