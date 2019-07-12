package com.google.android.android.internal;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import com.google.android.gms.internal.zzp;
import java.util.concurrent.BlockingQueue;

public final class NetworkDispatcher
  extends Thread
{
  public final Cache mCache;
  public final ResponseDelivery mDelivery;
  public final Network mNetwork;
  public final BlockingQueue<zzp<?>> mQueue;
  public volatile boolean mQuit = false;
  
  public NetworkDispatcher(BlockingQueue paramBlockingQueue, Network paramNetwork, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    mQueue = paramBlockingQueue;
    mNetwork = paramNetwork;
    mCache = paramCache;
    mDelivery = paramResponseDelivery;
  }
  
  public final void quit()
  {
    mQuit = true;
    interrupt();
  }
  
  public final void run()
  {
    Process.setThreadPriority(10);
    do
    {
      for (;;)
      {
        long l = SystemClock.elapsedRealtime();
        Object localObject1 = mQueue;
        try
        {
          localObject1 = ((BlockingQueue)localObject1).take();
          localObject1 = (Request)localObject1;
          try
          {
            ((Request)localObject1).addMarker("network-queue-take");
            TrafficStats.setThreadStatsTag(((Request)localObject1).getTrafficStatsTag());
            Object localObject2 = mNetwork;
            localObject2 = ((Network)localObject2).performRequest((Request)localObject1);
            ((Request)localObject1).addMarker("network-http-complete");
            if (notModified)
            {
              bool = ((Request)localObject1).hasHadResponseDelivered();
              if (bool)
              {
                ((Request)localObject1).finish("not-modified");
                continue;
              }
            }
            localObject2 = ((Request)localObject1).parseNetworkResponse((NetworkResponse)localObject2);
            ((Request)localObject1).addMarker("network-parse-complete");
            boolean bool = ((Request)localObject1).shouldCache();
            if ((bool) && (zzbe != null))
            {
              localObject3 = mCache;
              str = ((Request)localObject1).getUrl();
              Cache.Entry localEntry = zzbe;
              ((Cache)localObject3).put(str, localEntry);
              ((Request)localObject1).addMarker("network-cache-written");
            }
            ((Request)localObject1).addMarker();
            localObject3 = mDelivery;
            ((ResponseDelivery)localObject3).postResponse((Request)localObject1, (Response)localObject2);
          }
          catch (Exception localException)
          {
            Object localObject3 = localException.toString();
            String str = zzab.data;
            zzab.get("Unhandled exception %s", new Object[] { localObject3 });
            zzaa localZzaa1 = new zzaa(localException);
            localZzaa1.setLastTrackTime(SystemClock.elapsedRealtime() - l);
            mDelivery.postError((Request)localObject1, localZzaa1);
          }
          catch (zzaa localZzaa2)
          {
            localZzaa2.setLastTrackTime(SystemClock.elapsedRealtime() - l);
            mDelivery.postError((Request)localObject1, localZzaa2);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
      }
    } while (!mQuit);
  }
}
