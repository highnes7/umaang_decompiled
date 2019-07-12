package com.google.android.android.common.package_9.internal;

import b.b.x.n.b;
import com.google.android.android.common.package_9.AvailabilityException;
import com.google.android.android.common.package_9.GoogleApi;
import com.google.android.android.tasks.Task;
import com.google.android.gms.common.api.internal.zzh;
import java.util.Iterator;
import java.util.Set;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.SimpleArrayMap;

public final class LogItem
{
  public final b<zzh<?>, com.google.android.gms.common.ConnectionResult> zzfgj = new ArrayMap();
  public final com.google.android.gms.tasks.TaskCompletionSource<Void> zzfip = new com.google.android.android.tasks.TaskCompletionSource();
  public int zzfiq;
  public boolean zzfir = false;
  
  public LogItem(Iterable paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      GoogleApi localGoogleApi = (GoogleApi)paramIterable.next();
      zzfgj.put(localGoogleApi.zzafk(), null);
    }
    zzfiq = zzfgj.keySet().size();
  }
  
  public final Task getTask()
  {
    return zzfip.getTask();
  }
  
  public final void setTimestamp(Msg paramMsg, com.google.android.android.common.ConnectionResult paramConnectionResult)
  {
    zzfgj.put(paramMsg, paramConnectionResult);
    zzfiq -= 1;
    if (!paramConnectionResult.isSuccess()) {
      zzfir = true;
    }
    if (zzfiq == 0)
    {
      if (zzfir)
      {
        paramMsg = new AvailabilityException(zzfgj);
        zzfip.setException(paramMsg);
        return;
      }
      zzfip.setResult(null);
    }
  }
  
  public final Set zzafx()
  {
    return zzfgj.keySet();
  }
  
  public final void zzafy()
  {
    zzfip.setResult(null);
  }
}
