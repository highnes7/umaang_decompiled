package com.google.android.android.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class zzewy
  extends com.google.android.gms.internal.zzewx<FieldDescriptorType, Object>
{
  public zzewy(int paramInt)
  {
    super(paramInt);
  }
  
  public final void zzbhs()
  {
    if (!isImmutable())
    {
      int i = 0;
      while (i < zzcve())
      {
        localObject = zzkv(i);
        if (((zzevg)((Map.Entry)localObject).getKey()).zzctx()) {
          ((Map.Entry)localObject).setValue(Collections.unmodifiableList((List)((Map.Entry)localObject).getValue()));
        }
        i += 1;
      }
      Object localObject = zzcvf().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((zzevg)localEntry.getKey()).zzctx()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
    }
    super.zzbhs();
  }
}
