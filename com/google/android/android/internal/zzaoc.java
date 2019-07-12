package com.google.android.android.internal;

import android.os.Build.VERSION;

public final class zzaoc
{
  public static int version()
  {
    String str = Build.VERSION.SDK;
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    zzaom.doGet("Invalid version number", Build.VERSION.SDK);
    return 0;
  }
}
