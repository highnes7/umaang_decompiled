package com.google.android.android.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzamj;
import com.google.android.android.internal.zzamr;
import com.google.android.android.internal.zzamu;
import com.google.android.android.internal.zzanv;
import com.google.android.android.internal.zzaon;
import com.google.android.android.internal.zzapd;

public class CampaignTrackingReceiver
  extends BroadcastReceiver
{
  public static Boolean zzdjq;
  
  public CampaignTrackingReceiver() {}
  
  public static boolean zzbe(Context paramContext)
  {
    zzbp.append(paramContext);
    Boolean localBoolean = zzdjq;
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    boolean bool = zzapd.enable(paramContext, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
    zzdjq = Boolean.valueOf(bool);
    return bool;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    zzamu localZzamu = zzamu.zzbg(paramContext);
    zzaon localZzaon = localZzamu.zzvy();
    if (paramIntent == null)
    {
      localZzaon.zzdp("CampaignTrackingReceiver received null intent");
      return;
    }
    String str2 = paramIntent.getStringExtra("referrer");
    String str1 = str2;
    paramIntent = paramIntent.getAction();
    localZzaon.d("CampaignTrackingReceiver received", paramIntent);
    if (("com.android.vending.INSTALL_REFERRER".equals(paramIntent)) && (!TextUtils.isEmpty(str2)))
    {
      sendSms(paramContext, str2);
      int i = zzanv.zzxw();
      if (str2.length() > i)
      {
        localZzaon.append("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str2.length()), Integer.valueOf(i));
        str1 = str2.substring(0, i);
      }
      paramContext = goAsync();
      localZzamu.zzwc().removeKey(str1, new AlarmReceiver.1(this, paramContext));
      return;
    }
    localZzaon.zzdp("CampaignTrackingReceiver received unexpected intent without referrer extra");
  }
  
  public void sendSms(Context paramContext, String paramString) {}
}
