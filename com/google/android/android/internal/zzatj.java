package com.google.android.android.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.android.auth.dashclock.phone.SmsRetrieverClient;
import com.google.android.android.common.package_9.GoogleApi;
import com.google.android.android.tasks.Task;

public final class zzatj
  extends SmsRetrieverClient
{
  public zzatj(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public zzatj(Context paramContext)
  {
    super(paramContext);
  }
  
  public final Task startSmsRetriever()
  {
    return sendData(new zzatk(this));
  }
}
