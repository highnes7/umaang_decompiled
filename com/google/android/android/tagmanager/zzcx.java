package com.google.android.android.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public class zzcx
{
  public static String zzjsa;
  public static Map<String, String> zzjsb = new HashMap();
  
  public zzcx() {}
  
  public static void zzak(Context paramContext, String paramString)
  {
    zzfu.store(paramContext, "gtm_install_referrer", "referrer", paramString);
    zzam(paramContext, paramString);
  }
  
  public static String zzal(Context paramContext, String paramString)
  {
    if (zzjsa == null) {}
    for (;;)
    {
      try
      {
        if (zzjsa == null)
        {
          paramContext = paramContext.getSharedPreferences("gtm_install_referrer", 0);
          if (paramContext == null) {
            break label65;
          }
          paramContext = paramContext.getString("referrer", "");
          zzjsa = paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
      return zzaw(zzjsa, paramString);
      label65:
      paramContext = "";
    }
  }
  
  public static void zzam(Context paramContext, String paramString)
  {
    String str = zzaw(paramString, "conv");
    if ((str != null) && (str.length() > 0))
    {
      zzjsb.put(str, paramString);
      zzfu.store(paramContext, "gtm_click_referrers", str, paramString);
    }
  }
  
  public static String zzaw(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      if (paramString1.length() > 0) {
        return paramString1;
      }
      return null;
    }
    paramString1 = String.valueOf(paramString1);
    if (paramString1.length() != 0) {
      paramString1 = "http://hostname/?".concat(paramString1);
    } else {
      paramString1 = new String("http://hostname/?");
    }
    return Uri.parse(paramString1).getQueryParameter(paramString2);
  }
  
  public static void zzlu(String paramString)
  {
    try
    {
      zzjsa = paramString;
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
}
