package com.google.android.android.auth.account;

import android.app.Activity;
import android.content.Context;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.internal.zzaqy;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.internal.zzari;

public class WorkAccount
{
  public static final Api<Api.ApiOptions.NoOptions> IOERR = new Sample("WorkAccount.API", zzdwq, zzdwp);
  @Deprecated
  public static final WorkAccountApi WorkAccountApi = new zzaqy();
  public static final com.google.android.gms.common.api.Api.zzf<zzari> zzdwp = new com.google.android.android.common.package_9.Api.zzf();
  public static final Api.zza<zzari, Api.ApiOptions.NoOptions> zzdwq = new Configuration();
  
  public WorkAccount() {}
  
  public static WorkAccountClient getClient(Activity paramActivity)
  {
    return new WorkAccountClient(paramActivity);
  }
  
  public static WorkAccountClient getClient(Context paramContext)
  {
    return new WorkAccountClient(paramContext);
  }
}
