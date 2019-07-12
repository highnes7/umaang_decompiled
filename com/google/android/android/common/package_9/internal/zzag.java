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

public final class zzag
  implements OnCompleteListener<Void>
{
  public zzcv zzfkz;
  
  public zzag(zzad paramZzad, zzcv paramZzcv)
  {
    zzfkz = paramZzcv;
  }
  
  public final void cancel()
  {
    zzfkz.zzaak();
  }
  
  public final void onComplete(Task paramTask)
  {
    zzfky.zzfke.lock();
    try
    {
      boolean bool = zzfky.zzfkt;
      if (!bool)
      {
        zzfkz.zzaak();
        zzfky.zzfke.unlock();
        return;
      }
      bool = paramTask.isSuccessful();
      Object localObject;
      if (bool)
      {
        zzfky.zzfkv = new ArrayMap(zzfky.zzfkl.size());
        paramTask = zzfky.zzfkl.values().iterator();
        for (;;)
        {
          bool = paramTask.hasNext();
          if (!bool) {
            break;
          }
          localObject = (zzac)paramTask.next();
          zzfky.zzfkv.put(((GoogleApi)localObject).zzafk(), ConnectionResult.zzfff);
        }
      }
      bool = paramTask.getException() instanceof AvailabilityException;
      if (bool)
      {
        AvailabilityException localAvailabilityException = (AvailabilityException)paramTask.getException();
        bool = zzfky.zzfkr;
        if (bool)
        {
          zzfky.zzfkv = new ArrayMap(zzfky.zzfkl.size());
          Iterator localIterator = zzfky.zzfkl.values().iterator();
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
              localObject = zzfky.zzfkv;
              paramTask = new ConnectionResult(16);
            }
            for (;;)
            {
              ((Map)localObject).put(localMsg, paramTask);
              break;
              localObject = zzfky.zzfkv;
            }
          }
        }
        else
        {
          zzfky.zzfkv = localAvailabilityException.zzafh();
        }
      }
      else
      {
        paramTask.getException();
        zzfky.zzfkv = Collections.emptyMap();
      }
      bool = zzfky.isConnected();
      if (bool)
      {
        zzfky.zzfku.putAll(zzfky.zzfkv);
        paramTask = zzad.deleteChannel(zzfky);
        if (paramTask == null)
        {
          zzad.joinRoom(zzfky);
          zzad.access$getShowToast(zzfky);
          zzfky.zzfkp.signalAll();
        }
      }
      zzfkz.zzaak();
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
