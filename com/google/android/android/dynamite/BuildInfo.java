package com.google.android.android.dynamite;

import android.content.Context;

public final class BuildInfo
  implements DynamiteModule.zzd
{
  public BuildInfo() {}
  
  public final Msg getMessage(Context paramContext, String paramString, Weather paramWeather)
    throws DynamiteModule.zzc
  {
    Msg localMsg = new Msg();
    zzgpz = paramWeather.getLocation(paramContext, paramString, true);
    if (zzgpz != 0)
    {
      zzgqa = 1;
      return localMsg;
    }
    zzgpy = paramWeather.zzad(paramContext, paramString);
    if (zzgpy != 0) {
      zzgqa = -1;
    }
    return localMsg;
  }
}
