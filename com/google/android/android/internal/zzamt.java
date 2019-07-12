package com.google.android.android.internal;

import com.google.android.android.common.PingManager;

public final class zzamt
{
  public static final String VERSION = String.valueOf(PingManager.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
  public static final String zzdof;
  
  static
  {
    String str = String.valueOf(VERSION);
    if (str.length() != 0) {
      str = "ma".concat(str);
    } else {
      str = new String("ma");
    }
    zzdof = str;
  }
}
