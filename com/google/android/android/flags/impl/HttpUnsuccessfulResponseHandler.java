package com.google.android.android.flags.impl;

import android.content.SharedPreferences;
import com.google.android.android.internal.zzbvp;
import com.google.android.gms.flags.impl.zza;

public final class HttpUnsuccessfulResponseHandler
  extends zza<String>
{
  public static String handleResponse(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    try
    {
      paramSharedPreferences = zzbvp.run(new Preferences.1(paramSharedPreferences, paramString1, paramString2));
      return (String)paramSharedPreferences;
    }
    catch (Exception paramSharedPreferences)
    {
      paramSharedPreferences = String.valueOf(paramSharedPreferences.getMessage());
      if (paramSharedPreferences.length() != 0)
      {
        "Flag value not available, returning default: ".concat(paramSharedPreferences);
        return paramString2;
      }
      new String("Flag value not available, returning default: ");
    }
    return paramString2;
  }
}
