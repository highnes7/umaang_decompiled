package com.google.android.android.internal;

import com.google.android.android.auth.dashclock.credentials.Credential;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.common.package_9.internal.Log;

public final class zzasj
  extends zzasf
{
  public zzasj(zzasi paramZzasi) {}
  
  public final void saveAndExit(Status paramStatus)
  {
    zzebi.setResult(zzasg.substring(paramStatus));
  }
  
  public final void saveOutput(Status paramStatus, Credential paramCredential)
  {
    zzebi.setResult(new zzasg(paramStatus, paramCredential));
  }
}
