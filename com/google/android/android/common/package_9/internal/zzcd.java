package com.google.android.android.common.package_9.internal;

import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.package_9.Sample;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public abstract interface zzcd
{
  public abstract Logger addTask(Logger paramLogger);
  
  public abstract boolean addTask(zzcv paramZzcv);
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract ConnectionResult getConnectionResult(Sample paramSample);
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract Logger removeTask(Logger paramLogger);
  
  public abstract void zzafp();
  
  public abstract void zzagi();
}
