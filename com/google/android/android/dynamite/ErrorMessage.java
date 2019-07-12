package com.google.android.android.dynamite;

import android.content.Context;

public final class ErrorMessage
  implements DynamiteModule.zzd
{
  public ErrorMessage() {}
  
  public final Msg getMessage(Context paramContext, String paramString, Weather paramWeather)
    throws DynamiteModule.zzc
  {
    Msg localMsg = new Msg();
    zzgpy = paramWeather.zzad(paramContext, paramString);
    int i;
    if (zzgpy != 0) {
      i = paramWeather.getLocation(paramContext, paramString, false);
    } else {
      i = paramWeather.getLocation(paramContext, paramString, true);
    }
    zzgpz = i;
    if ((zzgpy == 0) && (zzgpz == 0))
    {
      zzgqa = 0;
      return localMsg;
    }
    if (zzgpz >= zzgpy)
    {
      zzgqa = 1;
      return localMsg;
    }
    zzgqa = -1;
    return localMsg;
  }
}
