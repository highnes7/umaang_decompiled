package com.google.android.android.common.util;

import android.os.Build.VERSION;

public final class KeyguardManager
{
  public static boolean isAtLeastN()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  public static boolean isAtLeastO()
  {
    return (Build.VERSION.SDK_INT >= 26) || ("O".equals(Build.VERSION.CODENAME)) || (Build.VERSION.CODENAME.startsWith("OMR")) || (Build.VERSION.CODENAME.startsWith("ODR"));
  }
  
  public static boolean zzald()
  {
    int i = Build.VERSION.SDK_INT;
    return true;
  }
  
  public static boolean zzale()
  {
    int i = Build.VERSION.SDK_INT;
    return true;
  }
  
  public static boolean zzalf()
  {
    int i = Build.VERSION.SDK_INT;
    return true;
  }
  
  public static boolean zzalg()
  {
    int i = Build.VERSION.SDK_INT;
    return true;
  }
  
  public static boolean zzalh()
  {
    int i = Build.VERSION.SDK_INT;
    return true;
  }
  
  public static boolean zzali()
  {
    return Build.VERSION.SDK_INT >= 20;
  }
  
  public static boolean zzalj()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
}
