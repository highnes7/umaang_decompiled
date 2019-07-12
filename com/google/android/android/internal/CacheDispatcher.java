package com.google.android.android.internal;

import android.os.Process;
import com.google.android.gms.internal.zzp;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public final class CacheDispatcher
  extends Thread
{
  public static final boolean DEBUG = zzab.DEBUG;
  public final Cache mCache;
  public final BlockingQueue<zzp<?>> mCacheQueue;
  public final ResponseDelivery mDelivery;
  public final BlockingQueue<zzp<?>> mNetworkQueue;
  public volatile boolean mQuit = false;
  
  public CacheDispatcher(BlockingQueue paramBlockingQueue1, BlockingQueue paramBlockingQueue2, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    mCacheQueue = paramBlockingQueue1;
    mNetworkQueue = paramBlockingQueue2;
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
    if (DEBUG) {
      zzab.v("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    mCache.initialize();
    label161:
    do
    {
      for (;;)
      {
        Object localObject1 = mCacheQueue;
        try
        {
          localObject1 = ((BlockingQueue)localObject1).take();
          Request localRequest = (Request)localObject1;
          localRequest.addMarker("cache-queue-take");
          localObject1 = mCache;
          localObject1 = ((Cache)localObject1).get(localRequest.getUrl());
          if (localObject1 == null) {
            localRequest.addMarker("cache-miss");
          }
          int i;
          for (localObject1 = mNetworkQueue;; localObject1 = mNetworkQueue)
          {
            ((BlockingQueue)localObject1).put(localRequest);
            break;
            l1 = ttl;
            l2 = System.currentTimeMillis();
            if (l1 < l2) {
              i = 1;
            } else {
              i = 0;
            }
            if (i == 0) {
              break label161;
            }
            localRequest.addMarker("cache-hit-expired");
            localRequest.setCacheEntry((Cache.Entry)localObject1);
          }
          localRequest.addMarker("cache-hit");
          Object localObject2 = data;
          Map localMap = responseHeaders;
          localObject2 = localRequest.parseNetworkResponse(new NetworkResponse((byte[])localObject2, localMap));
          localRequest.addMarker("cache-hit-parsed");
          long l1 = softTtl;
          long l2 = System.currentTimeMillis();
          if (l1 < l2) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            localObject1 = mDelivery;
            ((ResponseDelivery)localObject1).postResponse(localRequest, (Response)localObject2);
          }
          else
          {
            localRequest.addMarker("cache-hit-refresh-needed");
            localRequest.setCacheEntry((Cache.Entry)localObject1);
            zzbg = true;
            localObject1 = mDelivery;
            ((ResponseDelivery)localObject1).postResponse(localRequest, (Response)localObject2, new CacheDispatcher.1(this, localRequest));
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
