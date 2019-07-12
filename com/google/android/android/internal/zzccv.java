package com.google.android.android.internal;

import com.google.android.android.common.internal.zzbp;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;

public final class zzccv
  extends Thread
{
  public final Object zzisp;
  public final BlockingQueue<FutureTask<?>> zzisq;
  
  public zzccv(zzccr paramZzccr, String paramString, BlockingQueue paramBlockingQueue)
  {
    zzbp.append(paramString);
    zzbp.append(paramBlockingQueue);
    zzisp = new Object();
    zzisq = paramBlockingQueue;
    setName(paramString);
  }
  
  private final void loadFile(InterruptedException paramInterruptedException)
  {
    zzism.zzaul().zzayf().append(String.valueOf(getName()).concat(" was interrupted"), paramInterruptedException);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: ifne +29 -> 32
    //   6: aload_0
    //   7: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   10: astore_3
    //   11: aload_3
    //   12: invokestatic 80	com/google/android/android/internal/zzccr:access$getMIsAvailable	(Lcom/google/android/android/internal/zzccr;)Ljava/util/concurrent/Semaphore;
    //   15: invokevirtual 85	java/util/concurrent/Semaphore:acquire	()V
    //   18: iconst_1
    //   19: istore_1
    //   20: goto -18 -> 2
    //   23: astore_3
    //   24: aload_0
    //   25: aload_3
    //   26: invokespecial 87	com/google/android/android/internal/zzccv:loadFile	(Ljava/lang/InterruptedException;)V
    //   29: goto -27 -> 2
    //   32: aload_0
    //   33: getfield 31	com/google/android/android/internal/zzccv:zzisq	Ljava/util/concurrent/BlockingQueue;
    //   36: invokeinterface 93 1 0
    //   41: checkcast 95	java/util/concurrent/FutureTask
    //   44: astore_3
    //   45: aload_3
    //   46: ifnull +10 -> 56
    //   49: aload_3
    //   50: invokevirtual 97	java/util/concurrent/FutureTask:run	()V
    //   53: goto -21 -> 32
    //   56: aload_0
    //   57: getfield 29	com/google/android/android/internal/zzccv:zzisp	Ljava/lang/Object;
    //   60: astore_3
    //   61: aload_3
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 31	com/google/android/android/internal/zzccv:zzisq	Ljava/util/concurrent/BlockingQueue;
    //   67: invokeinterface 100 1 0
    //   72: ifnonnull +40 -> 112
    //   75: aload_0
    //   76: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   79: invokestatic 104	com/google/android/android/internal/zzccr:isImportant	(Lcom/google/android/android/internal/zzccr;)Z
    //   82: istore_2
    //   83: iload_2
    //   84: ifne +28 -> 112
    //   87: aload_0
    //   88: getfield 29	com/google/android/android/internal/zzccv:zzisp	Ljava/lang/Object;
    //   91: astore 4
    //   93: aload 4
    //   95: ldc2_w 105
    //   98: invokevirtual 110	java/lang/Object:wait	(J)V
    //   101: goto +11 -> 112
    //   104: astore 4
    //   106: aload_0
    //   107: aload 4
    //   109: invokespecial 87	com/google/android/android/internal/zzccv:loadFile	(Ljava/lang/InterruptedException;)V
    //   112: aload_3
    //   113: monitorexit
    //   114: aload_0
    //   115: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   118: invokestatic 114	com/google/android/android/internal/zzccr:access$getMDecoderLock	(Lcom/google/android/android/internal/zzccr;)Ljava/lang/Object;
    //   121: astore_3
    //   122: aload_3
    //   123: monitorenter
    //   124: aload_0
    //   125: getfield 31	com/google/android/android/internal/zzccv:zzisq	Ljava/util/concurrent/BlockingQueue;
    //   128: invokeinterface 100 1 0
    //   133: ifnonnull +106 -> 239
    //   136: aload_3
    //   137: monitorexit
    //   138: aload_0
    //   139: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   142: invokestatic 114	com/google/android/android/internal/zzccr:access$getMDecoderLock	(Lcom/google/android/android/internal/zzccr;)Ljava/lang/Object;
    //   145: astore_3
    //   146: aload_3
    //   147: monitorenter
    //   148: aload_0
    //   149: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   152: invokestatic 80	com/google/android/android/internal/zzccr:access$getMIsAvailable	(Lcom/google/android/android/internal/zzccr;)Ljava/util/concurrent/Semaphore;
    //   155: invokevirtual 117	java/util/concurrent/Semaphore:release	()V
    //   158: aload_0
    //   159: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   162: invokestatic 114	com/google/android/android/internal/zzccr:access$getMDecoderLock	(Lcom/google/android/android/internal/zzccr;)Ljava/lang/Object;
    //   165: invokevirtual 120	java/lang/Object:notifyAll	()V
    //   168: aload_0
    //   169: aload_0
    //   170: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   173: invokestatic 124	com/google/android/android/internal/zzccr:getBasePath	(Lcom/google/android/android/internal/zzccr;)Lcom/google/android/android/internal/zzccv;
    //   176: if_acmpne +15 -> 191
    //   179: aload_0
    //   180: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   183: aconst_null
    //   184: invokestatic 128	com/google/android/android/internal/zzccr:getWordRangeAtCursor	(Lcom/google/android/android/internal/zzccr;Lcom/google/android/android/internal/zzccv;)Lcom/google/android/android/internal/zzccv;
    //   187: pop
    //   188: goto +41 -> 229
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   196: invokestatic 131	com/google/android/android/internal/zzccr:Zip	(Lcom/google/android/android/internal/zzccr;)Lcom/google/android/android/internal/zzccv;
    //   199: if_acmpne +15 -> 214
    //   202: aload_0
    //   203: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   206: aconst_null
    //   207: invokestatic 134	com/google/android/android/internal/zzccr:makeView	(Lcom/google/android/android/internal/zzccr;Lcom/google/android/android/internal/zzccv;)Lcom/google/android/android/internal/zzccv;
    //   210: pop
    //   211: goto +18 -> 229
    //   214: aload_0
    //   215: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   218: invokevirtual 44	com/google/android/android/internal/zzccr:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   221: invokevirtual 137	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   224: ldc -117
    //   226: invokevirtual 141	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;)V
    //   229: aload_3
    //   230: monitorexit
    //   231: return
    //   232: astore 4
    //   234: aload_3
    //   235: monitorexit
    //   236: aload 4
    //   238: athrow
    //   239: aload_3
    //   240: monitorexit
    //   241: goto -209 -> 32
    //   244: astore 4
    //   246: aload_3
    //   247: monitorexit
    //   248: aload 4
    //   250: athrow
    //   251: astore 4
    //   253: aload_3
    //   254: monitorexit
    //   255: aload 4
    //   257: athrow
    //   258: astore 4
    //   260: aload_0
    //   261: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   264: invokestatic 114	com/google/android/android/internal/zzccr:access$getMDecoderLock	(Lcom/google/android/android/internal/zzccr;)Ljava/lang/Object;
    //   267: astore_3
    //   268: aload_3
    //   269: monitorenter
    //   270: aload_0
    //   271: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   274: invokestatic 80	com/google/android/android/internal/zzccr:access$getMIsAvailable	(Lcom/google/android/android/internal/zzccr;)Ljava/util/concurrent/Semaphore;
    //   277: invokevirtual 117	java/util/concurrent/Semaphore:release	()V
    //   280: aload_0
    //   281: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   284: invokestatic 114	com/google/android/android/internal/zzccr:access$getMDecoderLock	(Lcom/google/android/android/internal/zzccr;)Ljava/lang/Object;
    //   287: invokevirtual 120	java/lang/Object:notifyAll	()V
    //   290: aload_0
    //   291: aload_0
    //   292: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   295: invokestatic 124	com/google/android/android/internal/zzccr:getBasePath	(Lcom/google/android/android/internal/zzccr;)Lcom/google/android/android/internal/zzccv;
    //   298: if_acmpeq +44 -> 342
    //   301: aload_0
    //   302: aload_0
    //   303: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   306: invokestatic 131	com/google/android/android/internal/zzccr:Zip	(Lcom/google/android/android/internal/zzccr;)Lcom/google/android/android/internal/zzccv;
    //   309: if_acmpne +15 -> 324
    //   312: aload_0
    //   313: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   316: aconst_null
    //   317: invokestatic 134	com/google/android/android/internal/zzccr:makeView	(Lcom/google/android/android/internal/zzccr;Lcom/google/android/android/internal/zzccv;)Lcom/google/android/android/internal/zzccv;
    //   320: pop
    //   321: goto +30 -> 351
    //   324: aload_0
    //   325: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   328: invokevirtual 44	com/google/android/android/internal/zzccr:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   331: invokevirtual 137	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   334: ldc -117
    //   336: invokevirtual 141	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;)V
    //   339: goto +12 -> 351
    //   342: aload_0
    //   343: getfield 15	com/google/android/android/internal/zzccv:zzism	Lcom/google/android/android/internal/zzccr;
    //   346: aconst_null
    //   347: invokestatic 128	com/google/android/android/internal/zzccr:getWordRangeAtCursor	(Lcom/google/android/android/internal/zzccr;Lcom/google/android/android/internal/zzccv;)Lcom/google/android/android/internal/zzccv;
    //   350: pop
    //   351: aload_3
    //   352: monitorexit
    //   353: aload 4
    //   355: athrow
    //   356: astore 4
    //   358: aload_3
    //   359: monitorexit
    //   360: goto +3 -> 363
    //   363: aload 4
    //   365: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	zzccv
    //   1	19	1	i	int
    //   82	2	2	bool	boolean
    //   10	2	3	localZzccr	zzccr
    //   23	3	3	localInterruptedException1	InterruptedException
    //   44	315	3	localObject1	Object
    //   91	3	4	localObject2	Object
    //   104	4	4	localInterruptedException2	InterruptedException
    //   232	5	4	localThrowable1	Throwable
    //   244	5	4	localThrowable2	Throwable
    //   251	5	4	localThrowable3	Throwable
    //   258	96	4	localThrowable4	Throwable
    //   356	8	4	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   11	18	23	java/lang/InterruptedException
    //   93	101	104	java/lang/InterruptedException
    //   148	188	232	java/lang/Throwable
    //   191	211	232	java/lang/Throwable
    //   214	229	232	java/lang/Throwable
    //   229	231	232	java/lang/Throwable
    //   234	236	232	java/lang/Throwable
    //   124	138	244	java/lang/Throwable
    //   239	241	244	java/lang/Throwable
    //   246	248	244	java/lang/Throwable
    //   63	83	251	java/lang/Throwable
    //   93	101	251	java/lang/Throwable
    //   106	112	251	java/lang/Throwable
    //   112	114	251	java/lang/Throwable
    //   253	255	251	java/lang/Throwable
    //   32	45	258	java/lang/Throwable
    //   49	53	258	java/lang/Throwable
    //   56	63	258	java/lang/Throwable
    //   114	124	258	java/lang/Throwable
    //   248	251	258	java/lang/Throwable
    //   255	258	258	java/lang/Throwable
    //   270	321	356	java/lang/Throwable
    //   324	339	356	java/lang/Throwable
    //   342	351	356	java/lang/Throwable
    //   351	353	356	java/lang/Throwable
    //   358	360	356	java/lang/Throwable
  }
  
  public final void zzml()
  {
    Object localObject = zzisp;
    try
    {
      zzisp.notifyAll();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
