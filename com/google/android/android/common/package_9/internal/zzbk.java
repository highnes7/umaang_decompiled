package com.google.android.android.common.package_9.internal;

import android.os.Bundle;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.package_9.Sample;

public abstract interface zzbk
{
  public abstract Logger add(Logger paramLogger);
  
  public abstract Logger addCollection(Logger paramLogger);
  
  public abstract void begin();
  
  public abstract void connect();
  
  public abstract boolean disconnect();
  
  public abstract void onConnected(Bundle paramBundle);
  
  public abstract void onConnectionSuspended(int paramInt);
  
  public abstract void spawn(ConnectionResult paramConnectionResult, Sample paramSample, boolean paramBoolean);
}
