package com.google.android.android.common.package_9;

import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

public class Dictionary<T, R extends com.google.android.gms.common.data.AbstractDataBuffer<T>,  extends Result>
  extends com.google.android.gms.common.api.Response<R>
  implements DataBuffer<T>
{
  public Dictionary() {}
  
  public void close()
  {
    ((com.google.android.android.common.data.AbstractDataBuffer)getResult()).close();
  }
  
  public int getCount()
  {
    return ((com.google.android.android.common.data.AbstractDataBuffer)getResult()).getCount();
  }
  
  public boolean isClosed()
  {
    return ((com.google.android.android.common.data.AbstractDataBuffer)getResult()).isClosed();
  }
  
  public Iterator iterator()
  {
    return ((com.google.android.android.common.data.AbstractDataBuffer)getResult()).iterator();
  }
  
  public void release()
  {
    ((com.google.android.android.common.data.AbstractDataBuffer)getResult()).release();
  }
  
  public Iterator singleRefIterator()
  {
    return ((com.google.android.android.common.data.AbstractDataBuffer)getResult()).singleRefIterator();
  }
  
  public Object truncate(int paramInt)
  {
    return ((com.google.android.android.common.data.AbstractDataBuffer)getResult()).truncate(paramInt);
  }
  
  public final Bundle zzafi()
  {
    return ((com.google.android.android.common.data.AbstractDataBuffer)getResult()).zzafi();
  }
}
