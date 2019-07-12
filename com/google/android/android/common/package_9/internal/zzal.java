package com.google.android.android.common.package_9.internal;

import com.google.android.android.common.data.DataHolder;
import com.google.android.gms.common.api.internal.zzcm;

public abstract class zzal<L>
  implements zzcm<L>
{
  public final DataHolder zzflf;
  
  public zzal(DataHolder paramDataHolder)
  {
    zzflf = paramDataHolder;
  }
  
  public final void forceFinished(Object paramObject)
  {
    marshal(paramObject, zzflf);
  }
  
  public abstract void marshal(Object paramObject, DataHolder paramDataHolder);
  
  public final void zzagx()
  {
    DataHolder localDataHolder = zzflf;
    if (localDataHolder != null) {
      localDataHolder.close();
    }
  }
}
