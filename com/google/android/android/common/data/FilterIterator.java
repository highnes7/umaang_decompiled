package com.google.android.android.common.data;

import com.google.android.gms.common.data.zzb;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.NoSuchElementException;

public final class FilterIterator<T>
  extends zzb<T>
{
  public T zzfra;
  
  public FilterIterator(DataBuffer paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public final Object next()
  {
    if (hasNext())
    {
      zzfqf += 1;
      int i = zzfqf;
      if (i == 0)
      {
        zzfra = zzfqe.truncate(0);
        Object localObject = zzfra;
        if (!(localObject instanceof Table))
        {
          localObject = String.valueOf(localObject.getClass());
          throw new IllegalStateException(StringBuilder.append(((String)localObject).length() + 44, "DataBuffer reference of type ", (String)localObject, " is not movable"));
        }
      }
      else
      {
        ((Table)zzfra).zzbv(i);
      }
      return zzfra;
    }
    throw new NoSuchElementException(StringBuilder.add(46, "Cannot advance the iterator beyond ", zzfqf));
  }
}
