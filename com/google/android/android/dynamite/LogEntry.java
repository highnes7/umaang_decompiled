package com.google.android.android.dynamite;

import android.content.Context;

public final class LogEntry
  implements DynamiteModule.zzd
{
  public LogEntry() {}
  
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
      if (zzgpy < zzgpz) {
        break label84;
      }
      i = -1;
    }
    zzgqa = i;
    return localMsg;
    label84:
    zzgqa = 1;
    return localMsg;
  }
}
