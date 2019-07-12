package com.google.android.android.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.android.internal.zzccn;
import com.google.android.android.internal.zzccp;

public final class AppMeasurementInstallReferrerReceiver
  extends BroadcastReceiver
  implements zzccp
{
  public zzccn zziks;
  
  public AppMeasurementInstallReferrerReceiver() {}
  
  public final void doStartService(Context paramContext, Intent paramIntent) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (zziks == null) {
      zziks = new zzccn(this);
    }
    zziks.onReceive(paramContext, paramIntent);
  }
}
