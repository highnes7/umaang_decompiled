package com.google.android.android.auth.account;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import com.google.android.android.common.internal.zzbi;
import com.google.android.android.common.package_9.GoogleApi.zza;
import com.google.android.android.internal.zzaqy;
import com.google.android.android.tasks.Task;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;

public class WorkAccountClient
  extends com.google.android.gms.common.api.GoogleApi<Api.ApiOptions.NoOptions>
{
  public final WorkAccountApi zzdxy = new zzaqy();
  
  public WorkAccountClient(Activity paramActivity)
  {
    super(paramActivity, WorkAccount.IOERR, null, GoogleApi.zza.zzfgw);
  }
  
  public WorkAccountClient(Context paramContext)
  {
    super(paramContext, WorkAccount.IOERR, null, GoogleApi.zza.zzfgw);
  }
  
  public Task addWorkAccount(String paramString)
  {
    return zzbi.f(zzdxy.addWorkAccount(zzafl(), paramString), new Task.7(this));
  }
  
  public Task removeWorkAccount(Account paramAccount)
  {
    return zzbi.f(zzdxy.removeWorkAccount(zzafl(), paramAccount));
  }
  
  public Task setWorkAuthenticatorEnabled(boolean paramBoolean)
  {
    return zzbi.f(zzdxy.setWorkAuthenticatorEnabledWithResult(zzafl(), paramBoolean));
  }
}
