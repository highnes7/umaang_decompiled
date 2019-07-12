package com.google.android.android.common.package_9.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.android.R.string;
import com.google.android.android.common.internal.zzbe;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.Status;

@Deprecated
public final class zzca
{
  public static final Object zzaqd = new Object();
  public static zzca zzfoj;
  public final String mAppId;
  public final Status zzfok;
  public final boolean zzfol;
  public final boolean zzfom;
  
  public zzca(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("google_app_measurement_enable", "integer", ((Resources)localObject).getResourcePackageName(R.string.common_google_play_services_unknown_issue));
    boolean bool2 = true;
    boolean bool1 = true;
    if (i != 0)
    {
      if (((Resources)localObject).getInteger(i) == 0) {
        bool1 = false;
      }
      zzfom = (bool1 ^ true);
    }
    else
    {
      zzfom = false;
      bool1 = bool2;
    }
    zzfol = bool1;
    zzbe.zzch(paramContext);
    String str = zzbe.zzfvo;
    localObject = str;
    if (str == null)
    {
      zzbp.append(paramContext);
      paramContext = paramContext.getResources();
      i = paramContext.getIdentifier("google_app_id", "string", paramContext.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
      if (i == 0) {
        localObject = null;
      } else {
        localObject = paramContext.getString(i);
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      zzfok = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
      mAppId = null;
      return;
    }
    mAppId = ((String)localObject);
    zzfok = Status.zzfhv;
  }
  
  public static String zzaie()
  {
    return zzft"getGoogleAppId"mAppId;
  }
  
  public static boolean zzaif()
  {
    return zzft"isMeasurementExplicitlyDisabled"zzfom;
  }
  
  public static Status zzcb(Context paramContext)
  {
    zzbp.get(paramContext, "Context must not be null.");
    Object localObject = zzaqd;
    try
    {
      if (zzfoj == null) {
        zzfoj = new zzca(paramContext);
      }
      paramContext = zzfojzzfok;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static zzca zzft(String paramString)
  {
    Object localObject = zzaqd;
    try
    {
      if (zzfoj != null)
      {
        paramString = zzfoj;
        return paramString;
      }
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 34);
      localStringBuilder.append("Initialize must be called before ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
}
