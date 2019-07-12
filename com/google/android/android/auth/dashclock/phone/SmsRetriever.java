package com.google.android.android.auth.dashclock.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.android.internal.zzatj;

public final class SmsRetriever
{
  public static final String EXTRA_SMS_MESSAGE = "com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE";
  public static final String EXTRA_STATUS = "com.google.android.gms.auth.api.phone.EXTRA_STATUS";
  public static final String SMS_RETRIEVED_ACTION = "com.google.android.gms.auth.api.phone.SMS_RETRIEVED";
  
  public SmsRetriever() {}
  
  public static SmsRetrieverClient getClient(Activity paramActivity)
  {
    return new zzatj(paramActivity);
  }
  
  public static SmsRetrieverClient getClient(Context paramContext)
  {
    return new zzatj(paramContext);
  }
}
