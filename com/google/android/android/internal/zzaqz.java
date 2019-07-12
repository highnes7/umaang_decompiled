package com.google.android.android.internal;

import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.common.package_9.internal.Logger;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.internal.zzari;

public final class zzaqz
  extends zzm<com.google.android.gms.common.api.Result, zzari>
{
  public zzaqz(zzaqy paramZzaqy, Sample paramSample, GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    super(paramSample, paramGoogleApiClient);
  }
  
  public final com.google.android.android.common.package_9.Result getSheet(Status paramStatus)
  {
    return new zzarg(paramStatus);
  }
}
