package f.g.c.cache;

import f.g.c.c.W;
import f.g.c.c.W.a;
import f.g.c.c.W.b;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Random;
import sun.misc.Unsafe;

public abstract class Striped64
  extends Number
{
  public static final int NCPU = Runtime.getRuntime().availableProcessors();
  public static final Unsafe UNSAFE;
  public static final long baseOffset;
  public static final long busyOffset;
  public static final ThreadHashCode threadHashCode = new ThreadHashCode();
  public volatile transient long base;
  public volatile transient int busy;
  public volatile transient Cell[] cells;
  
  static
  {
    try
    {
      Unsafe localUnsafe = getUnsafe();
      UNSAFE = localUnsafe;
      localUnsafe = UNSAFE;
      long l = localUnsafe.objectFieldOffset(W.class.getDeclaredField("g"));
      baseOffset = l;
      localUnsafe = UNSAFE;
      l = localUnsafe.objectFieldOffset(W.class.getDeclaredField("h"));
      busyOffset = l;
      return;
    }
    catch (Exception localException)
    {
      throw new Error(localException);
    }
  }
  
  public Striped64() {}
  
  public static Unsafe getUnsafe()
  {
    for (;;)
    {
      try
      {
        localObject = Unsafe.getUnsafe();
        return localObject;
      }
      catch (SecurityException localSecurityException)
      {
        Object localObject;
        continue;
      }
      try
      {
        localObject = AccessController.doPrivileged(new Striped64.1());
        return (Unsafe)localObject;
      }
      catch (PrivilegedActionException localPrivilegedActionException)
      {
        throw new RuntimeException("Could not initialize intrinsics", localPrivilegedActionException.getCause());
      }
    }
  }
  
  public final boolean casBase(long paramLong1, long paramLong2)
  {
    return UNSAFE.compareAndSwapLong(this, baseOffset, paramLong1, paramLong2);
  }
  
  public final boolean casBusy()
  {
    return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
  }
  
  public abstract long fn(long paramLong1, long paramLong2);
  
  public final void internalReset(long paramLong)
  {
    Cell[] arrayOfCell = cells;
    base = paramLong;
    if (arrayOfCell != null)
    {
      int j = arrayOfCell.length;
      int i = 0;
      while (i < j)
      {
        Cell localCell = arrayOfCell[i];
        if (localCell != null) {
          value = paramLong;
        }
        i += 1;
      }
    }
  }
  
  public final void retryUpdate(long paramLong, HashCode paramHashCode, boolean paramBoolean)
  {
    int j = code;
    int k = 0;
    label135:
    long l;
    do
    {
      for (;;)
      {
        Object localObject = cells;
        int m = 1;
        int i = 1;
        Cell[] arrayOfCell;
        if (localObject != null)
        {
          int n = localObject.length;
          if (n > 0)
          {
            arrayOfCell = localObject[(n - 1 & j)];
            if (arrayOfCell == null) {
              if (busy == 0)
              {
                localObject = new Cell(paramLong);
                if ((busy == 0) && (casBusy())) {
                  try
                  {
                    arrayOfCell = cells;
                    if (arrayOfCell != null)
                    {
                      m = arrayOfCell.length;
                      if (m > 0)
                      {
                        m = m - 1 & j;
                        if (arrayOfCell[m] == null)
                        {
                          arrayOfCell[m] = localObject;
                          break label135;
                        }
                      }
                    }
                    i = 0;
                    busy = 0;
                    if (i == 0) {
                      continue;
                    }
                  }
                  catch (Throwable paramHashCode)
                  {
                    busy = 0;
                    throw paramHashCode;
                  }
                }
              }
            }
            boolean bool;
            do
            {
              i = 0;
              bool = paramBoolean;
              break;
              if (!paramBoolean)
              {
                bool = true;
                i = k;
                break;
              }
              l = value;
              if (arrayOfCell.cas(l, fn(l, paramLong))) {
                break label502;
              }
            } while ((n >= NCPU) || (cells != localObject));
            if (k == 0)
            {
              i = 1;
              bool = paramBoolean;
            }
            else
            {
              i = k;
              bool = paramBoolean;
              if (busy == 0)
              {
                i = k;
                bool = paramBoolean;
                if (casBusy()) {
                  try
                  {
                    arrayOfCell = cells;
                    if (arrayOfCell == localObject)
                    {
                      arrayOfCell = new Cell[n << 1];
                      i = 0;
                      while (i < n)
                      {
                        arrayOfCell[i] = localObject[i];
                        i += 1;
                      }
                      cells = arrayOfCell;
                    }
                    busy = 0;
                  }
                  catch (Throwable paramHashCode)
                  {
                    busy = 0;
                    throw paramHashCode;
                  }
                }
              }
            }
            j ^= j << 13;
            j ^= j >>> 17;
            j ^= j << 5;
            k = i;
            paramBoolean = bool;
            continue;
          }
        }
        if ((busy == 0) && (cells == localObject) && (casBusy())) {
          try
          {
            arrayOfCell = cells;
            if (arrayOfCell == localObject)
            {
              localObject = new Cell[2];
              localObject[(j & 0x1)] = new Cell(paramLong);
              cells = ((Cell[])localObject);
              i = m;
            }
            else
            {
              i = 0;
            }
            busy = 0;
            if (i == 0) {}
          }
          catch (Throwable paramHashCode)
          {
            busy = 0;
            throw paramHashCode;
          }
        }
      }
      l = base;
    } while (!casBase(l, fn(l, paramLong)));
    label502:
    code = j;
  }
  
  public final class Cell
  {
    public static final Unsafe UNSAFE;
    public static final long valueOffset;
    public volatile long p0;
    public volatile long p1;
    public volatile long p2;
    public volatile long p3;
    public volatile long p4;
    public volatile long p5;
    public volatile long p6;
    public volatile long q0;
    public volatile long q1;
    public volatile long q2;
    public volatile long q3;
    public volatile long q4;
    public volatile long q5;
    public volatile long q6;
    public volatile long value;
    
    static
    {
      try
      {
        Unsafe localUnsafe = Striped64.getUnsafe();
        UNSAFE = localUnsafe;
        localUnsafe = UNSAFE;
        long l = localUnsafe.objectFieldOffset(W.a.class.getDeclaredField("j"));
        valueOffset = l;
        return;
      }
      catch (Exception localException)
      {
        throw new Error(localException);
      }
    }
    
    public Cell()
    {
      value = this$1;
    }
    
    public final boolean cas(long paramLong1, long paramLong2)
    {
      return UNSAFE.compareAndSwapLong(this, valueOffset, paramLong1, paramLong2);
    }
  }
  
  public final class HashCode
  {
    public static final Random rng = new Random();
    public int code;
    
    public HashCode()
    {
      Striped64 localStriped64 = rng.nextInt();
      this$1 = localStriped64;
      if (localStriped64 == 0) {
        this$1 = 1;
      }
      code = this$1;
    }
  }
  
  public final class ThreadHashCode
    extends ThreadLocal<W.b>
  {
    public ThreadHashCode() {}
    
    public Striped64.HashCode initialValue()
    {
      return new Striped64.HashCode();
    }
  }
}
