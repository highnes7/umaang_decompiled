package com.google.android.android.internal;

import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;

public final class zzcfq
{
  public long mStartTime;
  public final Log zzasc;
  
  public zzcfq(Log paramLog)
  {
    zzbp.append(paramLog);
    zzasc = paramLog;
  }
  
  public final void clear()
  {
    mStartTime = 0L;
  }
  
  public final void start()
  {
    mStartTime = zzasc.elapsedRealtime();
  }
  
  public final boolean start(long paramLong)
  {
    if (mStartTime == 0L) {
      return true;
    }
    return zzasc.elapsedRealtime() - mStartTime >= paramLong;
  }
}
