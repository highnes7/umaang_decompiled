package com.google.android.android.flags.impl;

import android.content.SharedPreferences;
import com.google.android.android.internal.zzbvp;
import com.google.android.gms.flags.impl.zza;

public final class OperatorSwitch
  extends zza<Boolean>
{
  public static Boolean call(SharedPreferences paramSharedPreferences, String paramString, Boolean paramBoolean)
  {
    try
    {
      paramSharedPreferences = zzbvp.run(new Downloader(paramSharedPreferences, paramString, paramBoolean));
      return (Boolean)paramSharedPreferences;
    }
    catch (Exception paramSharedPreferences)
    {
      paramSharedPreferences = String.valueOf(paramSharedPreferences.getMessage());
      if (paramSharedPreferences.length() != 0)
      {
        "Flag value not available, returning default: ".concat(paramSharedPreferences);
        return paramBoolean;
      }
      new String("Flag value not available, returning default: ");
    }
    return paramBoolean;
  }
}
