package com.google.android.android.internal;

import java.util.Map.Entry;

public final class zzewd<K>
  implements Map.Entry<K, Object>
{
  public Map.Entry<K, com.google.android.gms.internal.zzewb> zzoph;
  
  public zzewd(Map.Entry paramEntry)
  {
    zzoph = paramEntry;
  }
  
  public final Object getKey()
  {
    return zzoph.getKey();
  }
  
  public final Object getValue()
  {
    if ((zzewb)zzoph.getValue() == null) {
      return null;
    }
    zzewb.zzcuv();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final Object setValue(Object paramObject)
  {
    if ((paramObject instanceof zzewl)) {
      return ((zzewb)zzoph.getValue()).addValue((zzewl)paramObject);
    }
    throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
  }
}
