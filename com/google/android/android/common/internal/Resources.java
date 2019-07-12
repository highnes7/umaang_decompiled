package com.google.android.android.common.internal;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.text.TextUtils;
import b.b.x.n.t;
import com.google.android.android.R.string;
import com.google.android.android.common.GooglePlayServicesUtil;
import com.google.android.android.common.util.IpAddress;
import com.google.android.android.internal.zzbec;
import com.google.android.android.internal.zzbed;
import support.android.v4.util.SimpleArrayMap;

public final class Resources
{
  public static final t<String, String> zzftw = new SimpleArrayMap();
  
  public static String format(Context paramContext, String paramString1, String paramString2)
  {
    android.content.res.Resources localResources = paramContext.getResources();
    paramString1 = toString(paramContext, paramString1);
    paramContext = paramString1;
    if (paramString1 == null) {
      paramContext = localResources.getString(R.string.common_google_play_services_unknown_issue);
    }
    return String.format(getConfigurationlocale, paramContext, new Object[] { paramString2 });
  }
  
  public static String getString(Context paramContext, int paramInt)
  {
    android.content.res.Resources localResources = paramContext.getResources();
    switch (paramInt)
    {
    default: 
      break;
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 19: 
      paramContext = new StringBuilder(33);
      paramContext.append("Unexpected error code ");
      paramContext.append(paramInt);
      paramContext.toString();
      return null;
    case 20: 
      return toString(paramContext, "common_google_play_services_restricted_profile_title");
    case 17: 
      return toString(paramContext, "common_google_play_services_sign_in_failed_title");
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 16: 
      return null;
    case 7: 
      return toString(paramContext, "common_google_play_services_network_error_title");
    case 5: 
      return toString(paramContext, "common_google_play_services_invalid_account_title");
    case 4: 
    case 6: 
    case 18: 
      return null;
    case 3: 
      return localResources.getString(R.string.common_google_play_services_enable_title);
    case 2: 
      return localResources.getString(R.string.common_google_play_services_update_title);
    }
    return localResources.getString(R.string.common_google_play_services_install_title);
  }
  
  public static String getText(Context paramContext, int paramInt)
  {
    String str1;
    if (paramInt == 6) {
      str1 = toString(paramContext, "common_google_play_services_resolution_required_title");
    } else {
      str1 = getString(paramContext, paramInt);
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = paramContext.getResources().getString(R.string.common_google_play_services_notification_ticker);
    }
    return str2;
  }
  
  public static String getTitle(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          paramInt = 17039370;
        }
      }
    }
    for (;;)
    {
      return paramContext.getString(paramInt);
      paramInt = R.string.common_google_play_services_enable_button;
      continue;
      paramInt = R.string.common_google_play_services_update_button;
      continue;
      paramInt = R.string.common_google_play_services_install_button;
    }
  }
  
  public static String getValue(Context paramContext, int paramInt)
  {
    android.content.res.Resources localResources = paramContext.getResources();
    String str = zzcd(paramContext);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 5)
          {
            if (paramInt != 7)
            {
              if (paramInt != 9)
              {
                if (paramInt != 20)
                {
                  switch (paramInt)
                  {
                  default: 
                    return localResources.getString(R.string.common_google_play_services_unknown_issue, new Object[] { str });
                  case 18: 
                    return localResources.getString(R.string.common_google_play_services_updating_text, new Object[] { str });
                  case 17: 
                    return format(paramContext, "common_google_play_services_sign_in_failed_text", str);
                  }
                  return format(paramContext, "common_google_play_services_api_unavailable_text", str);
                }
                return format(paramContext, "common_google_play_services_restricted_profile_text", str);
              }
              return localResources.getString(R.string.common_google_play_services_unsupported_text, new Object[] { str });
            }
            return format(paramContext, "common_google_play_services_network_error_text", str);
          }
          return format(paramContext, "common_google_play_services_invalid_account_text", str);
        }
        return localResources.getString(R.string.common_google_play_services_enable_text, new Object[] { str });
      }
      if (IpAddress.zzcj(paramContext)) {
        return localResources.getString(R.string.common_google_play_services_wear_update_text);
      }
      return localResources.getString(R.string.common_google_play_services_update_text, new Object[] { str });
    }
    return localResources.getString(R.string.common_google_play_services_install_text, new Object[] { str });
  }
  
  public static String toString(Context paramContext, int paramInt)
  {
    if (paramInt == 6) {
      return format(paramContext, "common_google_play_services_resolution_required_text", zzcd(paramContext));
    }
    return getValue(paramContext, paramInt);
  }
  
  public static String toString(Context paramContext, String paramString)
  {
    SimpleArrayMap localSimpleArrayMap = zzftw;
    try
    {
      String str = (String)zzftw.get(paramString);
      if (str != null) {
        return str;
      }
      paramContext = GooglePlayServicesUtil.getRemoteResource(paramContext);
      if (paramContext == null) {
        return null;
      }
      int i = paramContext.getIdentifier(paramString, "string", "com.google.android.gms");
      if (i == 0)
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0) {
          "Missing resource: ".concat(paramContext);
        } else {
          new String("Missing resource: ");
        }
        return null;
      }
      paramContext = paramContext.getString(i);
      if (TextUtils.isEmpty(paramContext))
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0) {
          "Got empty resource: ".concat(paramContext);
        } else {
          new String("Got empty resource: ");
        }
        return null;
      }
      zzftw.put(paramString, paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static String zzcd(Context paramContext)
  {
    String str1 = paramContext.getPackageName();
    try
    {
      String str2 = zzbed.zzcr(paramContext).zzgn(str1).toString();
      return str2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;) {}
    }
    paramContext = getApplicationInfoname;
    if (TextUtils.isEmpty(paramContext)) {
      return str1;
    }
    return paramContext;
  }
}
