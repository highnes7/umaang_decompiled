package com.google.android.android.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.android.common.internal.zzbp;

public class zzccf
  extends BroadcastReceiver
{
  public static String zzdtj;
  public boolean mRegistered;
  public boolean zzdtk;
  public final zzccw zziki;
  
  public zzccf(zzccw paramZzccw)
  {
    zzbp.append(paramZzccw);
    zziki = paramZzccw;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    zziki.zzwk();
    paramContext = paramIntent.getAction();
    zziki.zzaul().zzayj().append("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      boolean bool = zziki.zzaza().zzyx();
      if (zzdtk != bool)
      {
        zzdtk = bool;
        zziki.zzauk().e(new zzccg(this, bool));
      }
    }
    else
    {
      zziki.zzaul().zzayf().append("NetworkBroadcastReceiver received unknown action", paramContext);
    }
  }
  
  public final void unregister()
  {
    zziki.zzwk();
    zziki.zzauk().zzuj();
    zziki.zzauk().zzuj();
    if (!mRegistered) {
      return;
    }
    zziki.zzaul().zzayj().append("Unregistering connectivity change receiver");
    mRegistered = false;
    zzdtk = false;
    Context localContext = zziki.getContext();
    try
    {
      localContext.unregisterReceiver(this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zziki.zzaul().zzayd().append("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
    }
  }
  
  public final void zzyu()
  {
    zziki.zzwk();
    zziki.zzauk().zzuj();
    if (mRegistered) {
      return;
    }
    zziki.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    zzdtk = zziki.zzaza().zzyx();
    zziki.zzaul().zzayj().append("Registering connectivity change receiver. Network connected", Boolean.valueOf(zzdtk));
    mRegistered = true;
  }
}
