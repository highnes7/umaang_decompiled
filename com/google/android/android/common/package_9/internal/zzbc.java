package com.google.android.android.common.package_9.internal;

import android.os.Bundle;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.package_9.Api.zze;
import com.google.android.android.common.package_9.Sample;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

public final class zzbc
  implements zzbk
{
  public final zzbl zzflh;
  
  public zzbc(zzbl paramZzbl)
  {
    zzflh = paramZzbl;
  }
  
  public final Logger add(Logger paramLogger)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final Logger addCollection(Logger paramLogger)
  {
    zzflh.zzfju.zzfks.add(paramLogger);
    return paramLogger;
  }
  
  public final void begin()
  {
    Iterator localIterator = zzflh.zzfmn.values().iterator();
    while (localIterator.hasNext()) {
      ((Api.zze)localIterator.next()).disconnect();
    }
    zzflh.zzfju.zzfmo = Collections.emptySet();
  }
  
  public final void connect()
  {
    zzflh.zzahl();
  }
  
  public final boolean disconnect()
  {
    return true;
  }
  
  public final void onConnected(Bundle paramBundle) {}
  
  public final void onConnectionSuspended(int paramInt) {}
  
  public final void spawn(ConnectionResult paramConnectionResult, Sample paramSample, boolean paramBoolean) {}
}
