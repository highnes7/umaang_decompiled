package com.google.android.android.internal;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public final class zzape
  extends zzams
{
  public boolean zzdjz;
  public String zzdmb;
  public String zzdmc;
  public int zzdqr;
  public int zzdsu;
  public boolean zzdun;
  public boolean zzduo;
  
  public zzape(zzamu paramZzamu)
  {
    super(paramZzamu);
  }
  
  public final void zzuk()
  {
    Object localObject1 = getContext();
    try
    {
      localObject1 = ((Context)localObject1).getPackageManager().getApplicationInfo(((Context)localObject1).getPackageName(), 129);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      append("PackageManager doesn't know about the app package", localNameNotFoundException);
      localObject2 = null;
    }
    if (localObject2 == null)
    {
      zzdp("Couldn't get ApplicationInfo to load global config");
      return;
    }
    Object localObject2 = metaData;
    if (localObject2 != null)
    {
      int i = ((Bundle)localObject2).getInt("com.google.android.gms.analytics.globalConfigResource");
      if (i > 0)
      {
        localObject2 = (zzaoh)new zzaof(zzvw()).zzat(i);
        if (localObject2 != null)
        {
          zzdm("Loading global XML config values");
          String str = zzdmb;
          boolean bool = false;
          if (str != null) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            str = zzdmb;
            zzdmb = str;
            add("XML config - app name", str);
          }
          if (zzdmc != null) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            str = zzdmc;
            zzdmc = str;
            add("XML config - app version", str);
          }
          if (zzdst != null) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            str = zzdst.toLowerCase();
            if ("verbose".equals(str)) {
              i = 0;
            } else if ("info".equals(str)) {
              i = 1;
            } else if ("warning".equals(str)) {
              i = 2;
            } else if ("error".equals(str)) {
              i = 3;
            } else {
              i = -1;
            }
            if (i >= 0)
            {
              zzdqr = i;
              d("XML config - log level", Integer.valueOf(i));
            }
          }
          if (zzdsu >= 0) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            i = zzdsu;
            zzdsu = i;
            zzdun = true;
            add("XML config - dispatch period (sec)", Integer.valueOf(i));
          }
          i = zzdsv;
          if (i != -1)
          {
            if (i == 1) {
              bool = true;
            }
            zzdjz = bool;
            zzduo = true;
            add("XML config - dry run", Boolean.valueOf(bool));
          }
        }
      }
    }
  }
  
  public final String zzun()
  {
    zzwk();
    return zzdmb;
  }
  
  public final String zzuo()
  {
    zzwk();
    return zzdmc;
  }
  
  public final boolean zzzn()
  {
    zzwk();
    return false;
  }
  
  public final boolean zzzo()
  {
    zzwk();
    return zzduo;
  }
  
  public final boolean zzzp()
  {
    zzwk();
    return zzdjz;
  }
}
