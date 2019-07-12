package com.google.android.android.auth.dashclock.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.common.package_9.internal.RealmObject;
import com.google.android.android.tasks.Task;
import com.google.android.gms.auth.api.phone.SmsRetrieverApi;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.internal.zzati;

public abstract class SmsRetrieverClient
  extends com.google.android.gms.common.api.GoogleApi<Api.ApiOptions.NoOptions>
  implements SmsRetrieverApi
{
  public static final Api<Api.ApiOptions.NoOptions> content = new Sample("SmsRetriever.API", zzdwq, zzdwp);
  public static final com.google.android.gms.common.api.Api.zzf<zzati> zzdwp = new com.google.android.android.common.package_9.Api.zzf();
  public static final Api.zza<zzati, Api.ApiOptions.NoOptions> zzdwq = new ContactsAsyncHelper();
  
  public SmsRetrieverClient(Activity paramActivity)
  {
    super(paramActivity, content, null, new RealmObject());
  }
  
  public SmsRetrieverClient(Context paramContext)
  {
    super(paramContext, content, null, new RealmObject());
  }
  
  public abstract Task startSmsRetriever();
}
