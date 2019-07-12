package f.g.c.package_8;

import f.g.c.a.a;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

@a
public final class Queues
{
  public Queues() {}
  
  public static int drain(BlockingQueue paramBlockingQueue, Collection paramCollection, int paramInt, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (paramCollection != null)
    {
      long l = System.nanoTime();
      paramLong = paramTimeUnit.toNanos(paramLong);
      int i = 0;
      while (i < paramInt)
      {
        int j = i + paramBlockingQueue.drainTo(paramCollection, paramInt - i);
        i = j;
        if (j < paramInt)
        {
          paramTimeUnit = paramBlockingQueue.poll(paramLong + l - System.nanoTime(), TimeUnit.NANOSECONDS);
          if (paramTimeUnit == null) {
            return j;
          }
          paramCollection.add(paramTimeUnit);
          i = j + 1;
        }
      }
      return i;
    }
    paramBlockingQueue = new NullPointerException();
    throw paramBlockingQueue;
  }
  
  public static int drainUninterruptibly(BlockingQueue paramBlockingQueue, Collection paramCollection, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    int k;
    if (paramCollection != null)
    {
      long l1 = System.nanoTime();
      paramLong = paramTimeUnit.toNanos(paramLong);
      int i = 0;
      int j = 0;
      k = i;
      int m = j;
      if (i < paramInt)
      {
        m = j;
        for (;;)
        {
          try
          {
            k = paramBlockingQueue.drainTo(paramCollection, paramInt - i);
            k = i + k;
            i = k;
            if (k >= paramInt) {
              break;
            }
            m = j;
          }
          catch (Throwable paramBlockingQueue)
          {
            long l2;
            if (m != 0) {
              Thread.currentThread().interrupt();
            }
            throw paramBlockingQueue;
          }
          try
          {
            l2 = System.nanoTime();
            paramTimeUnit = TimeUnit.NANOSECONDS;
            m = j;
            paramTimeUnit = paramBlockingQueue.poll(paramLong + l1 - l2, paramTimeUnit);
            if (paramTimeUnit == null)
            {
              m = j;
              break label159;
            }
            m = j;
            paramCollection.add(paramTimeUnit);
            i = k + 1;
          }
          catch (InterruptedException paramTimeUnit)
          {
            continue;
          }
          j = 1;
        }
      }
      label159:
      if (m != 0)
      {
        Thread.currentThread().interrupt();
        return k;
      }
    }
    else
    {
      paramBlockingQueue = new NullPointerException();
      throw paramBlockingQueue;
    }
    return k;
  }
  
  public static ArrayBlockingQueue newArrayBlockingQueue(int paramInt)
  {
    return new ArrayBlockingQueue(paramInt);
  }
  
  public static ConcurrentLinkedQueue newConcurrentLinkedQueue()
  {
    return new ConcurrentLinkedQueue();
  }
  
  public static ConcurrentLinkedQueue newConcurrentLinkedQueue(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new ConcurrentLinkedQueue(Collections2.cast(paramIterable));
    }
    ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    Iterables.addAll(localConcurrentLinkedQueue, paramIterable);
    return localConcurrentLinkedQueue;
  }
  
  public static LinkedBlockingQueue newLinkedBlockingQueue()
  {
    return new LinkedBlockingQueue();
  }
  
  public static LinkedBlockingQueue newLinkedBlockingQueue(int paramInt)
  {
    return new LinkedBlockingQueue(paramInt);
  }
  
  public static LinkedBlockingQueue newLinkedBlockingQueue(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new LinkedBlockingQueue(Collections2.cast(paramIterable));
    }
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
    Iterables.addAll(localLinkedBlockingQueue, paramIterable);
    return localLinkedBlockingQueue;
  }
  
  public static PriorityBlockingQueue newPriorityBlockingQueue()
  {
    return new PriorityBlockingQueue();
  }
  
  public static PriorityBlockingQueue newPriorityBlockingQueue(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new PriorityBlockingQueue(Collections2.cast(paramIterable));
    }
    PriorityBlockingQueue localPriorityBlockingQueue = new PriorityBlockingQueue();
    Iterables.addAll(localPriorityBlockingQueue, paramIterable);
    return localPriorityBlockingQueue;
  }
  
  public static PriorityQueue newPriorityQueue()
  {
    return new PriorityQueue();
  }
  
  public static PriorityQueue newPriorityQueue(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new PriorityQueue(Collections2.cast(paramIterable));
    }
    PriorityQueue localPriorityQueue = new PriorityQueue();
    Iterables.addAll(localPriorityQueue, paramIterable);
    return localPriorityQueue;
  }
  
  public static SynchronousQueue newSynchronousQueue()
  {
    return new SynchronousQueue();
  }
}
