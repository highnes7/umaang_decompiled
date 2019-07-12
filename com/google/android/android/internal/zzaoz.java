package com.google.android.android.internal;

import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;

public final class zzaoz
{
  public long mStartTime;
  public final Log zzasc;
  
  public zzaoz(Log paramLog)
  {
    zzbp.append(paramLog);
    zzasc = paramLog;
  }
  
  public zzaoz(Log paramLog, long paramLong)
  {
    zzbp.append(paramLog);
    zzasc = paramLog;
    mStartTime = paramLong;
  }
  
  public final boolean calculate(long paramLong)
  {
    if (mStartTime == 0L) {
      return true;
    }
    return zzasc.elapsedRealtime() - mStartTime > paramLong;
  }
  
  public final void clear()
  {
    mStartTime = 0L;
  }
  
  public final void start()
  {
    mStartTime = zzasc.elapsedRealtime();
  }
}
