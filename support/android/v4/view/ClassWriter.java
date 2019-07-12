package support.android.v4.view;

import b.b.x.n.r.c;
import b.b.x.o.e.b;
import java.util.concurrent.ArrayBlockingQueue;
import support.android.v4.util.Pools.SynchronizedPool;

public class ClassWriter
  extends Thread
{
  public static final ClassWriter a = new ClassWriter();
  public ArrayBlockingQueue<e.b> m = new ArrayBlockingQueue(10);
  public r.c<e.b> w = new Pools.SynchronizedPool(10);
  
  static
  {
    a.start();
  }
  
  public ClassWriter() {}
  
  public static ClassWriter toByteArray()
  {
    return a;
  }
  
  public e a()
  {
    e localE2 = (e)w.acquire();
    e localE1 = localE2;
    if (localE2 == null) {
      localE1 = new e();
    }
    return localE1;
  }
  
  public void a(e paramE)
  {
    k = null;
    c = null;
    b = null;
    l = 0;
    a = null;
    w.release(paramE);
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	support/android/v4/view/ClassWriter:m	Ljava/util/concurrent/ArrayBlockingQueue;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual 79	java/util/concurrent/ArrayBlockingQueue:take	()Ljava/lang/Object;
    //   9: astore_1
    //   10: aload_1
    //   11: checkcast 47	support/android/v4/view/e
    //   14: astore_1
    //   15: aload_1
    //   16: aload_1
    //   17: getfield 57	support/android/v4/view/e:c	Lsupport/android/v4/view/b;
    //   20: getfield 82	support/android/v4/view/b:b	Landroid/view/LayoutInflater;
    //   23: aload_1
    //   24: getfield 65	support/android/v4/view/e:l	I
    //   27: aload_1
    //   28: getfield 61	support/android/v4/view/e:b	Landroid/view/ViewGroup;
    //   31: iconst_0
    //   32: invokevirtual 88	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   35: putfield 68	support/android/v4/view/e:a	Landroid/view/View;
    //   38: aload_1
    //   39: getfield 57	support/android/v4/view/e:c	Lsupport/android/v4/view/b;
    //   42: getfield 92	support/android/v4/view/b:f	Landroid/os/Handler;
    //   45: iconst_0
    //   46: aload_1
    //   47: invokestatic 98	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   50: invokevirtual 101	android/os/Message:sendToTarget	()V
    //   53: return
    //   54: astore_1
    //   55: return
    //   56: astore_2
    //   57: goto -19 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	ClassWriter
    //   4	43	1	localObject	Object
    //   54	1	1	localInterruptedException	InterruptedException
    //   56	1	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   5	10	54	java/lang/InterruptedException
    //   15	38	56	java/lang/RuntimeException
  }
  
  public void put(e paramE)
  {
    ArrayBlockingQueue localArrayBlockingQueue = m;
    try
    {
      localArrayBlockingQueue.put(paramE);
      return;
    }
    catch (InterruptedException paramE)
    {
      throw new RuntimeException("Failed to enqueue async inflate request", paramE);
    }
  }
  
  public void run()
  {
    for (;;)
    {
      b();
    }
  }
}
