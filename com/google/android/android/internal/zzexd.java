package com.google.android.android.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzexd
  implements Iterator<Map.Entry<K, V>>
{
  public int idx = -1;
  public boolean zzoqr;
  public Iterator<Map.Entry<K, V>> zzoqs;
  
  public zzexd(zzewx paramZzewx) {}
  
  private final Iterator zzcvk()
  {
    if (zzoqs == null) {
      zzoqs = zzewx.getPresences(zzoqq).entrySet().iterator();
    }
    return zzoqs;
  }
  
  public final boolean hasNext()
  {
    if (idx + 1 >= zzewx.access$getEntryList(zzoqq).size()) {
      return zzcvk().hasNext();
    }
    return true;
  }
  
  public final void remove()
  {
    if (zzoqr)
    {
      zzoqr = false;
      zzewx.setAnswer(zzoqq);
      if (idx < zzewx.access$getEntryList(zzoqq).size())
      {
        zzewx localZzewx = zzoqq;
        int i = idx;
        idx = (i - 1);
        zzewx.getPage(localZzewx, i);
        return;
      }
      zzcvk().remove();
      return;
    }
    throw new IllegalStateException("remove() was called before next()");
  }
}
