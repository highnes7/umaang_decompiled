package com.google.android.android.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.android.common.internal.zzbp;

public final class zzccn
{
  public final zzccp zzirq;
  
  public zzccn(zzccp paramZzccp)
  {
    zzbp.append(paramZzccp);
    zzirq = paramZzccp;
  }
  
  public static boolean listen(Context paramContext, boolean paramBoolean)
  {
    zzbp.append(paramContext);
    return zzcfw.start(paramContext, "com.google.android.gms.measurement.AppMeasurementReceiver", false);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    zzccw localZzccw = zzccw.zzdn(paramContext);
    zzcbw localZzcbw = localZzccw.zzaul();
    if (paramIntent == null)
    {
      localZzcbw.zzayf().append("Receiver called with null intent");
      return;
    }
    zzcax.zzawk();
    Object localObject = paramIntent.getAction();
    localZzcbw.zzayj().append("Local receiver got", localObject);
    if ("com.google.android.gms.measurement.UPLOAD".equals(localObject))
    {
      zzcfh.load(paramContext, false);
      paramIntent = new Intent().setClassName(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
      paramIntent.setAction("com.google.android.gms.measurement.UPLOAD");
      zzirq.doStartService(paramContext, paramIntent);
      return;
    }
    if ("com.android.vending.INSTALL_REFERRER".equals(localObject))
    {
      String str = paramIntent.getStringExtra("referrer");
      localObject = str;
      if (str == null)
      {
        localZzcbw.zzayj().append("Install referrer extras are null");
        return;
      }
      localZzcbw.zzayh().append("Install referrer extras are", str);
      if (!str.contains("?")) {
        if (str.length() != 0) {
          localObject = "?".concat(str);
        } else {
          localObject = new String("?");
        }
      }
      localObject = Uri.parse((String)localObject);
      localObject = localZzccw.zzauh().parse((Uri)localObject);
      if (localObject == null)
      {
        localZzcbw.zzayj().append("No campaign defined in install referrer broadcast");
        return;
      }
      long l = paramIntent.getLongExtra("referrer_timestamp_seconds", 0L) * 1000L;
      if (l == 0L) {
        localZzcbw.zzayf().append("Install referrer is missing timestamp");
      }
      localZzccw.zzauk().e(new zzcco(this, localZzccw, l, (Bundle)localObject, paramContext, localZzcbw));
    }
  }
}
