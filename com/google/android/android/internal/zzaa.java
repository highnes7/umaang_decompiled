package com.google.android.android.internal;

public class zzaa
  extends Exception
{
  public long zzaa;
  public NetworkResponse zzbh;
  
  public zzaa()
  {
    zzbh = null;
  }
  
  public zzaa(NetworkResponse paramNetworkResponse)
  {
    zzbh = paramNetworkResponse;
  }
  
  public zzaa(Throwable paramThrowable)
  {
    super(paramThrowable);
    zzbh = null;
  }
  
  public final void setLastTrackTime(long paramLong)
  {
    zzaa = paramLong;
  }
}
