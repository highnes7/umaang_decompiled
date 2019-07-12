package com.google.android.android.internal;

import java.util.Iterator;
import java.util.Map.Entry;

public final class zzdor
  implements Iterator<Map.Entry<K, V>>
{
  public int zzlsf = zzlsg;
  
  public zzdor(zzdoq paramZzdoq, int paramInt, boolean paramBoolean) {}
  
  public final boolean hasNext()
  {
    if (zzlsh) {
      return zzlsf >= 0;
    }
    return zzlsf < zzdoq.access$getElements(zzlsi).length;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
  }
}
