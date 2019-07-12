package com.google.android.android.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.android.internal.zzbvp;

public final class IpAddress
{
  public static SharedPreferences zzhbi;
  
  public static SharedPreferences zzcy(Context paramContext)
    throws Exception
  {
    try
    {
      if (zzhbi == null) {
        zzhbi = (SharedPreferences)zzbvp.run(new Function(paramContext));
      }
      paramContext = zzhbi;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
}
