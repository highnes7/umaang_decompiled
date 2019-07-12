package com.google.android.android.common.data;

import com.google.android.android.common.internal.zzbp;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AbstractIterator<T>
  implements Iterator<T>
{
  public final com.google.android.gms.common.data.DataBuffer<T> zzfqe;
  public int zzfqf;
  
  public AbstractIterator(DataBuffer paramDataBuffer)
  {
    zzbp.append(paramDataBuffer);
    zzfqe = ((DataBuffer)paramDataBuffer);
    zzfqf = -1;
  }
  
  public boolean hasNext()
  {
    return zzfqf < zzfqe.getCount() - 1;
  }
  
  public Object next()
  {
    if (hasNext())
    {
      DataBuffer localDataBuffer = zzfqe;
      int i = zzfqf + 1;
      zzfqf = i;
      return localDataBuffer.truncate(i);
    }
    throw new NoSuchElementException(StringBuilder.add(46, "Cannot advance the iterator beyond ", zzfqf));
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}
