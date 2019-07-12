package f.g.c.cache;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class LongAdder
  extends Striped64
  implements Serializable
{
  public static final long serialVersionUID = 7249069246863182397L;
  
  public LongAdder() {}
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    busy = 0;
    cells = null;
    base = paramObjectInputStream.readLong();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeLong(sum());
  }
  
  public void add(long paramLong)
  {
    Object localObject = cells;
    long l;
    if (localObject == null)
    {
      l = base;
      if (casBase(l, l + paramLong)) {}
    }
    else
    {
      Striped64.HashCode localHashCode = (Striped64.HashCode)Striped64.threadHashCode.get();
      int i = code;
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (localObject != null)
      {
        int j = localObject.length;
        bool1 = bool2;
        if (j >= 1)
        {
          localObject = localObject[(i & j - 1)];
          bool1 = bool2;
          if (localObject != null)
          {
            l = value;
            bool2 = ((Striped64.Cell)localObject).cas(l, l + paramLong);
            bool1 = bool2;
            if (bool2) {
              return;
            }
          }
        }
      }
      retryUpdate(paramLong, localHashCode, bool1);
    }
  }
  
  public void decrement()
  {
    add(-1L);
  }
  
  public double doubleValue()
  {
    return sum();
  }
  
  public float floatValue()
  {
    return (float)sum();
  }
  
  public final long fn(long paramLong1, long paramLong2)
  {
    return paramLong1 + paramLong2;
  }
  
  public void increment()
  {
    add(1L);
  }
  
  public int intValue()
  {
    return (int)sum();
  }
  
  public long longValue()
  {
    return sum();
  }
  
  public void reset()
  {
    internalReset(0L);
  }
  
  public long sum()
  {
    long l1 = base;
    Striped64.Cell[] arrayOfCell = cells;
    long l2 = l1;
    if (arrayOfCell != null)
    {
      int j = arrayOfCell.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        Striped64.Cell localCell = arrayOfCell[i];
        l2 = l1;
        if (localCell != null) {
          l2 = l1 + value;
        }
        i += 1;
        l1 = l2;
      }
    }
    return l2;
  }
  
  public long sumThenReset()
  {
    long l1 = base;
    Striped64.Cell[] arrayOfCell = cells;
    base = 0L;
    long l2 = l1;
    if (arrayOfCell != null)
    {
      int j = arrayOfCell.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        Striped64.Cell localCell = arrayOfCell[i];
        l2 = l1;
        if (localCell != null)
        {
          l2 = l1 + value;
          value = 0L;
        }
        i += 1;
        l1 = l2;
      }
    }
    return l2;
  }
  
  public String toString()
  {
    return Long.toString(sum());
  }
}
