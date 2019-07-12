package com.google.android.android.wifi.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.android.common.TransactionInput;

public final class Row
{
  public SharedPreferences zzamc;
  
  public Row(Context paramContext)
  {
    try
    {
      paramContext = TransactionInput.getRemoteContext(paramContext);
      if (paramContext == null) {
        paramContext = null;
      } else {
        paramContext = paramContext.getSharedPreferences("google_ads_flags", 0);
      }
      zzamc = paramContext;
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    zzamc = null;
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    try
    {
      SharedPreferences localSharedPreferences = zzamc;
      if (localSharedPreferences == null) {
        return false;
      }
      paramBoolean = zzamc.getBoolean(paramString, false);
      return paramBoolean;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public final float getFloat(String paramString, float paramFloat)
  {
    try
    {
      SharedPreferences localSharedPreferences = zzamc;
      if (localSharedPreferences == null) {
        return 0.0F;
      }
      paramFloat = zzamc.getFloat(paramString, 0.0F);
      return paramFloat;
    }
    catch (Throwable paramString) {}
    return 0.0F;
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    try
    {
      SharedPreferences localSharedPreferences = zzamc;
      if (localSharedPreferences == null) {
        return paramString2;
      }
      paramString1 = zzamc.getString(paramString1, paramString2);
      return paramString1;
    }
    catch (Throwable paramString1) {}
    return paramString2;
  }
}
