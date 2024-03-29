package com.google.android.android.common.stats;

import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;

public final class Transport
{
  public static String get(PowerManager.WakeLock paramWakeLock, String paramString)
  {
    String str = String.valueOf(String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramWakeLock)));
    paramWakeLock = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramWakeLock = "";
    }
    paramWakeLock = String.valueOf(paramWakeLock);
    if (paramWakeLock.length() != 0) {
      return str.concat(paramWakeLock);
    }
    return new String(str);
  }
}
