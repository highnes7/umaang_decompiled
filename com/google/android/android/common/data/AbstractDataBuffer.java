package com.google.android.android.common.data;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
  implements DataBuffer<T>
{
  public final DataHolder zzflf;
  
  public AbstractDataBuffer(DataHolder paramDataHolder)
  {
    zzflf = paramDataHolder;
  }
  
  public final void close()
  {
    release();
  }
  
  public int getCount()
  {
    DataHolder localDataHolder = zzflf;
    if (localDataHolder == null) {
      return 0;
    }
    return zzfqq;
  }
  
  public boolean isClosed()
  {
    DataHolder localDataHolder = zzflf;
    return (localDataHolder == null) || (localDataHolder.isClosed());
  }
  
  public Iterator iterator()
  {
    return new AbstractIterator(this);
  }
  
  public void release()
  {
    DataHolder localDataHolder = zzflf;
    if (localDataHolder != null) {
      localDataHolder.close();
    }
  }
  
  public Iterator singleRefIterator()
  {
    return new FilterIterator(this);
  }
  
  public abstract Object truncate(int paramInt);
  
  public final Bundle zzafi()
  {
    return zzflf.zzafi();
  }
}
