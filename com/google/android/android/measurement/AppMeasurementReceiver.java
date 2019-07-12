package com.google.android.android.measurement;

import android.content.Context;
import android.content.Intent;
import com.google.android.android.internal.zzccn;
import com.google.android.android.internal.zzccp;
import support.android.v4.content.WakefulBroadcastReceiver;

public final class AppMeasurementReceiver
  extends WakefulBroadcastReceiver
  implements zzccp
{
  public zzccn zziks;
  
  public AppMeasurementReceiver() {}
  
  public final void doStartService(Context paramContext, Intent paramIntent)
  {
    WakefulBroadcastReceiver.startWakefulService(paramContext, paramIntent);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (zziks == null) {
      zziks = new zzccn(this);
    }
    zziks.onReceive(paramContext, paramIntent);
  }
}
