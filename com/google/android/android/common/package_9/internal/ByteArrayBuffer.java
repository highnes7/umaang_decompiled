package com.google.android.android.common.package_9.internal;

import android.os.Bundle;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.android.common.package_9.Sample;
import com.google.android.gms.common.api.Api;

public final class ByteArrayBuffer
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public final Api<?> zzfdg;
  public final boolean zzfjs;
  public BlockingQueue zzfjt;
  
  public ByteArrayBuffer(Sample paramSample, boolean paramBoolean)
  {
    zzfdg = paramSample;
    zzfjs = paramBoolean;
  }
  
  private final void zzagh()
  {
    zzbp.get(zzfjt, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
  }
  
  public final void append(BlockingQueue paramBlockingQueue)
  {
    zzfjt = paramBlockingQueue;
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    zzagh();
    zzfjt.onConnected(paramBundle);
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzagh();
    zzfjt.handleResult(paramConnectionResult, zzfdg, zzfjs);
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    zzagh();
    zzfjt.onConnectionSuspended(paramInt);
  }
}
