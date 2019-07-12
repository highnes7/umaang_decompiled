package com.google.android.android.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public abstract interface DataBuffer<T>
  extends Releasable, Iterable<T>
{
  public abstract void close();
  
  public abstract int getCount();
  
  public abstract boolean isClosed();
  
  public abstract Iterator iterator();
  
  public abstract void release();
  
  public abstract Iterator singleRefIterator();
  
  public abstract Object truncate(int paramInt);
  
  public abstract Bundle zzafi();
}
