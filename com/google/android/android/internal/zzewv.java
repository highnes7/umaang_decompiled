package com.google.android.android.internal;

import java.util.Iterator;
import java.util.Stack;

public final class zzewv
  implements Iterator<com.google.android.gms.internal.zzeuq>
{
  public final Stack<com.google.android.gms.internal.zzews> zzoqa = new Stack();
  public zzeuq zzoqb = zzap(paramZzeuk);
  
  public zzewv(zzeuk paramZzeuk) {}
  
  private final zzeuq zzap(zzeuk paramZzeuk)
  {
    while ((paramZzeuk instanceof zzews))
    {
      paramZzeuk = (zzews)paramZzeuk;
      zzoqa.push(paramZzeuk);
      paramZzeuk = zzews.getSide(paramZzeuk);
    }
    return (zzeuq)paramZzeuk;
  }
  
  private final zzeuq zzcvc()
  {
    zzeuq localZzeuq;
    do
    {
      if (zzoqa.isEmpty()) {
        return null;
      }
      localZzeuq = zzap(zzews.take((zzews)zzoqa.pop()));
    } while (localZzeuq.isEmpty());
    return localZzeuq;
  }
  
  public final boolean hasNext()
  {
    return zzoqb != null;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}
