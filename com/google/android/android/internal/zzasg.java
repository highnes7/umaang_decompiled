package com.google.android.android.internal;

import com.google.android.android.auth.dashclock.credentials.Credential;
import com.google.android.android.auth.dashclock.credentials.CredentialRequestResult;
import com.google.android.android.common.package_9.Status;

public final class zzasg
  implements CredentialRequestResult
{
  public final Status mStatus;
  public final Credential zzebg;
  
  public zzasg(Status paramStatus, Credential paramCredential)
  {
    mStatus = paramStatus;
    zzebg = paramCredential;
  }
  
  public static zzasg substring(Status paramStatus)
  {
    return new zzasg(paramStatus, null);
  }
  
  public final Credential getCredential()
  {
    return zzebg;
  }
  
  public final Status getStatus()
  {
    return mStatus;
  }
}
