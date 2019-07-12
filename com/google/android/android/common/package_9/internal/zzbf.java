package com.google.android.android.common.package_9.internal;

import android.os.Bundle;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbf
  implements GoogleApiClient.ConnectionCallbacks
{
  public zzbf(zzbd paramZzbd, AtomicReference paramAtomicReference, zzda paramZzda) {}
  
  public final void onConnected(Bundle paramBundle)
  {
    zzbd.printStackTrace(zzfmv, (GoogleApiClient)zzfmw.get(), zzfmx, true);
  }
  
  public final void onConnectionSuspended(int paramInt) {}
}
