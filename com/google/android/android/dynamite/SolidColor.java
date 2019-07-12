package com.google.android.android.dynamite;

import android.content.Context;

public final class SolidColor
  implements DynamiteModule.zzd
{
  public SolidColor() {}
  
  public final Msg getMessage(Context paramContext, String paramString, Weather paramWeather)
    throws DynamiteModule.zzc
  {
    Msg localMsg = new Msg();
    zzgpy = paramWeather.zzad(paramContext, paramString);
    zzgpz = paramWeather.getLocation(paramContext, paramString, true);
    int i;
    if ((zzgpy == 0) && (zzgpz == 0))
    {
      i = 0;
    }
    else
    {
      if (zzgpz >= zzgpy)
      {
        zzgqa = 1;
        return localMsg;
      }
      i = -1;
    }
    zzgqa = i;
    return localMsg;
  }
}
