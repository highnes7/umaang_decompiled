package com.google.android.android.tagmanager;

import android.content.Context;
import com.google.android.android.analytics.CampaignTrackingReceiver;

public final class InstallReferrerReceiver
  extends CampaignTrackingReceiver
{
  public InstallReferrerReceiver() {}
  
  public final void sendSms(Context paramContext, String paramString)
  {
    zzcx.zzlu(paramString);
    zzcx.zzak(paramContext, paramString);
  }
}
