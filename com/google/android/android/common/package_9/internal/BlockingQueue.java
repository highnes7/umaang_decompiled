package com.google.android.android.common.package_9.internal;

import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.Sample;

public abstract interface BlockingQueue
  extends GoogleApiClient.ConnectionCallbacks
{
  public abstract void handleResult(ConnectionResult paramConnectionResult, Sample paramSample, boolean paramBoolean);
}
