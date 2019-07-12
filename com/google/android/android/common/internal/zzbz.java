package com.google.android.android.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.android.R.string;

public final class zzbz
{
  public final Resources zzfwf;
  public final String zzfwg;
  
  public zzbz(Context paramContext)
  {
    zzbp.append(paramContext);
    zzfwf = paramContext.getResources();
    zzfwg = zzfwf.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
  }
  
  public final String getString(String paramString)
  {
    int i = zzfwf.getIdentifier(paramString, "string", zzfwg);
    if (i == 0) {
      return null;
    }
    return zzfwf.getString(i);
  }
}
