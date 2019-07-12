package com.google.android.android.internal;

import java.util.Iterator;
import java.util.Map.Entry;

public final class zzewe<K>
  implements Iterator<Map.Entry<K, Object>>
{
  public Iterator<Map.Entry<K, Object>> zzlsn;
  
  public zzewe(Iterator paramIterator)
  {
    zzlsn = paramIterator;
  }
  
  public final boolean hasNext()
  {
    return zzlsn.hasNext();
  }
  
  public final void remove()
  {
    zzlsn.remove();
  }
}
