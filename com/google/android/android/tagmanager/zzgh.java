package com.google.android.android.tagmanager;

import com.google.android.android.analytics.Logger;

public final class zzgh
  implements Logger
{
  public zzgh() {}
  
  public final void error(Exception paramException)
  {
    zzdj.zzjss.e("", paramException);
  }
  
  public final void error(String paramString)
  {
    zzdj.zzjss.get(paramString);
  }
  
  public final int getLogLevel()
  {
    int i = zzdj.zzjst;
    if (i != 2)
    {
      if ((i != 3) && (i != 4))
      {
        if (i != 5)
        {
          if (i != 6) {
            return 3;
          }
        }
        else {
          return 2;
        }
      }
      else {
        return 1;
      }
    }
    else {
      return 0;
    }
    return 3;
  }
  
  public final void info(String paramString)
  {
    zzdj.zzjss.zzcq(paramString);
  }
  
  public final void setLogLevel(int paramInt)
  {
    zzdj.zzjss.zzcr("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
  }
  
  public final void verbose(String paramString)
  {
    zzdj.zzjss.append(paramString);
  }
  
  public final void warn(String paramString)
  {
    zzdj.zzjss.zzcr(paramString);
  }
}
