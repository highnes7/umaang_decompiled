package com.google.android.android.internal;

import com.google.android.android.analytics.Logger;

public final class zzanw
  implements Logger
{
  public boolean zzdkb;
  public int zzdqr = 2;
  
  public zzanw() {}
  
  public final void error(Exception paramException) {}
  
  public final void error(String paramString) {}
  
  public final int getLogLevel()
  {
    return zzdqr;
  }
  
  public final void info(String paramString) {}
  
  public final void setLogLevel(int paramInt)
  {
    zzdqr = paramInt;
    if (!zzdkb)
    {
      String str = (String)zzaod.zzdrb.setDoOutput();
      str = (String)zzaod.zzdrb.setDoOutput();
      StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, 91));
      localStringBuilder.append("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.");
      localStringBuilder.append(str);
      localStringBuilder.append(" DEBUG");
      localStringBuilder.toString();
      zzdkb = true;
    }
  }
  
  public final void verbose(String paramString) {}
  
  public final void warn(String paramString) {}
}
