package com.google.android.android.tagmanager;

import android.content.Context;
import com.google.android.android.analytics.GoogleAnalytics;
import com.google.android.android.analytics.Tracker;

public final class zzgg
{
  public Context mContext;
  public Tracker zzdjt;
  public GoogleAnalytics zzdjv;
  
  public zzgg(Context paramContext)
  {
    mContext = paramContext;
  }
  
  private final void zzmd(String paramString)
  {
    try
    {
      if (zzdjv == null)
      {
        zzdjv = GoogleAnalytics.getInstance(mContext);
        zzdjv.setLogger(new zzgh());
        zzdjt = zzdjv.newTracker(paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final Tracker zzmc(String paramString)
  {
    zzmd(paramString);
    return zzdjt;
  }
}
