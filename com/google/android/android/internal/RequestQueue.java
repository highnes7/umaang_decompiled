package com.google.android.android.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.zzp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class RequestQueue
{
  public final Cache mCache;
  public final ResponseDelivery mDelivery;
  public final Network mNetwork;
  public AtomicInteger zzaw = new AtomicInteger();
  public final Map<String, Queue<zzp<?>>> zzax = new HashMap();
  public final Set<zzp<?>> zzay = new HashSet();
  public final PriorityBlockingQueue<zzp<?>> zzaz = new PriorityBlockingQueue();
  public final PriorityBlockingQueue<zzp<?>> zzba = new PriorityBlockingQueue();
  public NetworkDispatcher[] zzbb;
  public CacheDispatcher zzbc;
  public List<Object> zzbd = new ArrayList();
  
  public RequestQueue(Cache paramCache, Network paramNetwork)
  {
    this(paramCache, paramNetwork, 4);
  }
  
  public RequestQueue(Cache paramCache, Network paramNetwork, int paramInt)
  {
    this(paramCache, paramNetwork, 4, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
  }
  
  public RequestQueue(Cache paramCache, Network paramNetwork, int paramInt, ResponseDelivery paramResponseDelivery)
  {
    mCache = paramCache;
    mNetwork = paramNetwork;
    zzbb = new NetworkDispatcher[4];
    mDelivery = paramResponseDelivery;
  }
  
  public final Request add(Request paramRequest)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a7 = a6\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  /* Error */
  public final void finish(Request paramRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/google/android/android/internal/RequestQueue:zzay	Ljava/util/Set;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 72	com/google/android/android/internal/RequestQueue:zzay	Ljava/util/Set;
    //   11: aload_1
    //   12: invokeinterface 115 2 0
    //   17: pop
    //   18: aload_2
    //   19: monitorexit
    //   20: aload_0
    //   21: getfield 84	com/google/android/android/internal/RequestQueue:zzbd	Ljava/util/List;
    //   24: astore_2
    //   25: aload_2
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 84	com/google/android/android/internal/RequestQueue:zzbd	Ljava/util/List;
    //   31: invokeinterface 121 1 0
    //   36: astore_3
    //   37: aload_3
    //   38: invokeinterface 127 1 0
    //   43: ifeq +13 -> 56
    //   46: aload_3
    //   47: invokeinterface 131 1 0
    //   52: pop
    //   53: goto -16 -> 37
    //   56: aload_2
    //   57: monitorexit
    //   58: aload_1
    //   59: invokevirtual 136	com/google/android/android/internal/Request:shouldCache	()Z
    //   62: ifeq +94 -> 156
    //   65: aload_0
    //   66: getfield 67	com/google/android/android/internal/RequestQueue:zzax	Ljava/util/Map;
    //   69: astore_2
    //   70: aload_2
    //   71: monitorenter
    //   72: aload_1
    //   73: invokevirtual 140	com/google/android/android/internal/Request:getCacheKey	()Ljava/lang/String;
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 67	com/google/android/android/internal/RequestQueue:zzax	Ljava/util/Map;
    //   81: aload_1
    //   82: invokeinterface 145 2 0
    //   87: checkcast 147	java/util/Queue
    //   90: astore_3
    //   91: aload_3
    //   92: ifnull +43 -> 135
    //   95: getstatic 153	com/google/android/android/internal/zzab:DEBUG	Z
    //   98: ifeq +28 -> 126
    //   101: ldc -101
    //   103: iconst_2
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_3
    //   110: invokeinterface 159 1 0
    //   115: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: aload_1
    //   122: aastore
    //   123: invokestatic 169	com/google/android/android/internal/zzab:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aload_0
    //   127: getfield 77	com/google/android/android/internal/RequestQueue:zzaz	Ljava/util/concurrent/PriorityBlockingQueue;
    //   130: aload_3
    //   131: invokevirtual 173	java/util/concurrent/PriorityBlockingQueue:addAll	(Ljava/util/Collection;)Z
    //   134: pop
    //   135: aload_2
    //   136: monitorexit
    //   137: return
    //   138: astore_1
    //   139: aload_2
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    //   143: astore_1
    //   144: aload_2
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    //   148: astore_1
    //   149: aload_2
    //   150: monitorexit
    //   151: goto +3 -> 154
    //   154: aload_1
    //   155: athrow
    //   156: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	RequestQueue
    //   0	157	1	paramRequest	Request
    //   4	146	2	localObject1	Object
    //   36	95	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   72	91	138	java/lang/Throwable
    //   95	126	138	java/lang/Throwable
    //   126	135	138	java/lang/Throwable
    //   135	137	138	java/lang/Throwable
    //   139	141	138	java/lang/Throwable
    //   27	37	143	java/lang/Throwable
    //   37	53	143	java/lang/Throwable
    //   56	58	143	java/lang/Throwable
    //   144	146	143	java/lang/Throwable
    //   7	20	148	java/lang/Throwable
    //   149	151	148	java/lang/Throwable
  }
  
  public final void start()
  {
    Object localObject = zzbc;
    if (localObject != null) {
      ((CacheDispatcher)localObject).quit();
    }
    int j = 0;
    int i = 0;
    for (;;)
    {
      localObject = zzbb;
      if (i >= localObject.length) {
        break;
      }
      if (localObject[i] != null) {
        localObject[i].quit();
      }
      i += 1;
    }
    zzbc = new CacheDispatcher(zzaz, zzba, mCache, mDelivery);
    zzbc.start();
    i = j;
    while (i < zzbb.length)
    {
      localObject = new NetworkDispatcher(zzba, mNetwork, mCache, mDelivery);
      zzbb[i] = localObject;
      ((Thread)localObject).start();
      i += 1;
    }
  }
}
