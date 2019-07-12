package com.google.android.android.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class IpAddress
{
  public static Boolean zzfys;
  public static Boolean zzfyt;
  public static Boolean zzfyu;
  public static Boolean zzfyv;
  public static Boolean zzfyw;
  
  public static boolean init(Resources paramResources)
  {
    boolean bool2 = false;
    if (paramResources == null) {
      return false;
    }
    if (zzfys == null)
    {
      int i;
      if ((getConfigurationscreenLayout & 0xF) > 3) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool1;
      if (i == 0)
      {
        if (zzfyt == null)
        {
          paramResources = paramResources.getConfiguration();
          if (((screenLayout & 0xF) <= 3) && (smallestScreenWidthDp >= 600)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          zzfyt = Boolean.valueOf(bool1);
        }
        bool1 = bool2;
        if (!zzfyt.booleanValue()) {}
      }
      else
      {
        bool1 = true;
      }
      zzfys = Boolean.valueOf(bool1);
    }
    return zzfys.booleanValue();
  }
  
  public static boolean zzci(Context paramContext)
  {
    if (zzfyu == null)
    {
      boolean bool;
      if ((KeyguardManager.zzali()) && (paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch"))) {
        bool = true;
      } else {
        bool = false;
      }
      zzfyu = Boolean.valueOf(bool);
    }
    return zzfyu.booleanValue();
  }
  
  public static boolean zzcj(Context paramContext)
  {
    return ((!KeyguardManager.isAtLeastN()) || (zzck(paramContext))) && (zzci(paramContext));
  }
  
  public static boolean zzck(Context paramContext)
  {
    if (zzfyv == null)
    {
      boolean bool;
      if ((KeyguardManager.zzalj()) && (paramContext.getPackageManager().hasSystemFeature("cn.google"))) {
        bool = true;
      } else {
        bool = false;
      }
      zzfyv = Boolean.valueOf(bool);
    }
    return zzfyv.booleanValue();
  }
  
  public static boolean zzcl(Context paramContext)
  {
    if (zzfyw == null)
    {
      boolean bool;
      if ((!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.iot")) && (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.embedded"))) {
        bool = false;
      } else {
        bool = true;
      }
      zzfyw = Boolean.valueOf(bool);
    }
    return zzfyw.booleanValue();
  }
}
