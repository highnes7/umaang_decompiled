package com.google.android.android.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.android.internal.zzaou;

public final class AnalyticsReceiver
  extends BroadcastReceiver
{
  public zzaou zzdjm;
  
  public AnalyticsReceiver() {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (zzdjm == null) {
      zzdjm = new zzaou();
    }
    zzaou.onReceive(paramContext, paramIntent);
  }
}
