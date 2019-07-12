package com.google.android.android.internal;

import java.util.Iterator;
import java.util.Map.Entry;

public final class zzdoy<T>
  implements Iterator<T>
{
  public Iterator<Map.Entry<T, Void>> zzlsn;
  
  public zzdoy(Iterator paramIterator)
  {
    zzlsn = paramIterator;
  }
  
  public final boolean hasNext()
  {
    return zzlsn.hasNext();
  }
  
  public final Object next()
  {
    return ((Map.Entry)zzlsn.next()).getKey();
  }
  
  public final void remove()
  {
    zzlsn.remove();
  }
}
