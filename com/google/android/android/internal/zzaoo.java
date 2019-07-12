package com.google.android.android.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.android.analytics.TerminalManager;
import com.google.android.android.common.internal.zzbp;

public class zzaoo
  extends BroadcastReceiver
{
  public static String zzdtj;
  public boolean mRegistered;
  public final zzamu zzdod;
  public boolean zzdtk;
  
  public zzaoo(zzamu paramZzamu)
  {
    zzbp.append(paramZzamu);
    zzdod = paramZzamu;
  }
  
  private final void zzyv()
  {
    zzdod.zzvy();
    zzdod.zzwc();
  }
  
  private final boolean zzyx()
  {
    Object localObject = (ConnectivityManager)zzdod.getContext().getSystemService("connectivity");
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        boolean bool = ((NetworkInfo)localObject).isConnected();
        if (bool) {
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    catch (SecurityException localSecurityException) {}
    return false;
  }
  
  public final boolean isConnected()
  {
    if (!mRegistered) {
      zzdod.zzvy().zzdp("Connectivity unknown. Receiver not registered");
    }
    return zzdtk;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    zzyv();
    paramContext = paramIntent.getAction();
    zzdod.zzvy().d("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      boolean bool = zzyx();
      if (zzdtk != bool)
      {
        zzdtk = bool;
        paramContext = zzdod.zzwc();
        paramContext.d("Network connectivity status changed", Boolean.valueOf(bool));
        paramContext.zzwa().d(new zzaml(paramContext, bool));
      }
    }
    else if ("com.google.analytics.RADIO_POWERED".equals(paramContext))
    {
      if (!paramIntent.hasExtra(zzdtj))
      {
        paramContext = zzdod.zzwc();
        paramContext.zzdm("Radio powered up");
        paramContext.zzvs();
      }
    }
    else
    {
      zzdod.zzvy().append("NetworkBroadcastReceiver received unknown action", paramContext);
    }
  }
  
  public final void unregister()
  {
    if (!mRegistered) {
      return;
    }
    zzdod.zzvy().zzdm("Unregistering connectivity change receiver");
    mRegistered = false;
    zzdtk = false;
    Context localContext = zzdod.getContext();
    try
    {
      localContext.unregisterReceiver(this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zzdod.zzvy().toString("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
    }
  }
  
  public final void zzyu()
  {
    zzyv();
    if (mRegistered) {
      return;
    }
    Context localContext = zzdod.getContext();
    localContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    IntentFilter localIntentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
    localIntentFilter.addCategory(localContext.getPackageName());
    localContext.registerReceiver(this, localIntentFilter);
    zzdtk = zzyx();
    zzdod.zzvy().d("Registering connectivity change receiver. Network connected", Boolean.valueOf(zzdtk));
    mRegistered = true;
  }
  
  public final void zzyw()
  {
    Context localContext = zzdod.getContext();
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(localContext.getPackageName());
    localIntent.putExtra(zzdtj, true);
    localContext.sendOrderedBroadcast(localIntent, null);
  }
}
