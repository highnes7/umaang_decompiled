package com.google.android.android.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class zzdo
  extends BroadcastReceiver
{
  public static String zzdtj;
  public final zzfn zzjsu;
  
  public zzdo(zzfn paramZzfn)
  {
    zzjsu = paramZzfn;
  }
  
  public static void zzdx(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(paramContext.getPackageName());
    localIntent.putExtra(zzdtj, true);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      Bundle localBundle = paramIntent.getExtras();
      paramContext = Boolean.FALSE;
      if (localBundle != null) {
        paramContext = Boolean.valueOf(paramIntent.getExtras().getBoolean("noConnectivity"));
      }
      zzjsu.zzbv(paramContext.booleanValue() ^ true);
      return;
    }
    if (("com.google.analytics.RADIO_POWERED".equals(paramContext)) && (!paramIntent.hasExtra(zzdtj))) {
      zzjsu.zzbey();
    }
  }
}
