package com.google.android.android.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;

public final class ID3v1Tag
  implements Dictionary
{
  public static final Uri zzdki;
  public final LogPrinter zzdkj = new LogPrinter(4, "GA/LogCatTransport");
  
  static
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("uri");
    localBuilder.authority("local");
    zzdki = localBuilder.build();
  }
  
  public ID3v1Tag() {}
  
  public final void write(PingManager paramPingManager)
  {
    paramPingManager = new ArrayList(paramPingManager.zzty());
    Collections.sort(paramPingManager, new AbstractListArretByPosition.3.1(this));
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramPingManager.size();
    int i = 0;
    while (i < k)
    {
      Object localObject = paramPingManager.get(i);
      int j = i + 1;
      localObject = ((Log)localObject).toString();
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (localStringBuilder.length() != 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append((String)localObject);
        i = j;
      }
    }
    zzdkj.println(localStringBuilder.toString());
  }
  
  public final Uri zztu()
  {
    return zzdki;
  }
}
