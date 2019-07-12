package com.google.android.android.dynamite;

import android.content.Context;

public final class Active
  implements DynamiteModule.zzd
{
  public Active() {}
  
  public final Msg getMessage(Context paramContext, String paramString, Weather paramWeather)
    throws DynamiteModule.zzc
  {
    Msg localMsg = new Msg();
    zzgpy = paramWeather.zzad(paramContext, paramString);
    if (zzgpy != 0)
    {
      zzgqa = -1;
      return localMsg;
    }
    zzgpz = paramWeather.getLocation(paramContext, paramString, true);
    if (zzgpz != 0) {
      zzgqa = 1;
    }
    return localMsg;
  }
}
