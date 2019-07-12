package com.google.android.android.common.package_9.internal;

import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.package_9.AvailabilityException;
import com.google.android.android.common.package_9.GoogleApi;
import com.google.android.android.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import support.android.v4.util.ArrayMap;

public final class zzaf
  implements OnCompleteListener<Void>
{
  public zzaf(zzad paramZzad) {}
  
  public final void onComplete(Task paramTask)
  {
    zzfky.zzfke.lock();
    try
    {
      boolean bool = zzfky.zzfkt;
      if (!bool)
      {
        zzfky.zzfke.unlock();
        return;
      }
      bool = paramTask.isSuccessful();
      if (bool)
      {
        zzfky.zzfku = new ArrayMap(zzfky.zzfkk.size());
        paramTask = zzfky.zzfkk.values().iterator();
        for (;;)
        {
          bool = paramTask.hasNext();
          if (!bool) {
            break;
          }
          localObject = (zzac)paramTask.next();
          zzfky.zzfku.put(((GoogleApi)localObject).zzafk(), ConnectionResult.zzfff);
        }
      }
      bool = paramTask.getException() instanceof AvailabilityException;
      if (bool)
      {
        AvailabilityException localAvailabilityException = (AvailabilityException)paramTask.getException();
        bool = zzfky.zzfkr;
        if (bool)
        {
          zzfky.zzfku = new ArrayMap(zzfky.zzfkk.size());
          Iterator localIterator = zzfky.zzfkk.values().iterator();
          bool = localIterator.hasNext();
          if (bool)
          {
            zzac localZzac = (zzac)localIterator.next();
            Msg localMsg = localZzac.zzafk();
            localObject = localAvailabilityException.getConnectionResult(localZzac);
            paramTask = (Task)localObject;
            bool = zzad.next(zzfky, localZzac, (ConnectionResult)localObject);
            if (bool)
            {
              localObject = zzfky.zzfku;
              paramTask = new ConnectionResult(16);
            }
            for (;;)
            {
              ((Map)localObject).put(localMsg, paramTask);
              break;
              localObject = zzfky.zzfku;
            }
          }
        }
        else
        {
          zzfky.zzfku = localAvailabilityException.zzafh();
        }
        paramTask = zzfky;
      }
      for (Object localObject = zzad.deleteChannel(zzfky);; localObject = new ConnectionResult(8))
      {
        zzfkx = ((ConnectionResult)localObject);
        break;
        paramTask.getException();
        zzfky.zzfku = Collections.emptyMap();
        paramTask = zzfky;
      }
      paramTask = zzfky.zzfkv;
      if (paramTask != null)
      {
        zzfky.zzfku.putAll(zzfky.zzfkv);
        zzfky.zzfkx = zzad.deleteChannel(zzfky);
      }
      paramTask = zzfky.zzfkx;
      if (paramTask == null)
      {
        zzad.joinRoom(zzfky);
        zzad.access$getShowToast(zzfky);
      }
      else
      {
        zzfky.zzfkt = false;
        zzfky.zzfkn.removeTask(zzfky.zzfkx);
      }
      zzfky.zzfkp.signalAll();
      zzfky.zzfke.unlock();
      return;
    }
    catch (Throwable paramTask)
    {
      zzfky.zzfke.unlock();
      throw paramTask;
    }
  }
}
