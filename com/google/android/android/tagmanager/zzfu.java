package com.google.android.android.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class zzfu
{
  public static void store(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putString(paramString2, paramString3);
    paramContext.apply();
  }
}
