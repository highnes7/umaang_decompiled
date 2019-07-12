package com.google.android.android.internal;

import com.google.android.gms.internal.zzdpl;
import java.util.Iterator;

public final class zzdpj
  implements Iterable<zzdpl>
{
  public final int length;
  public long value;
  
  public zzdpj(int paramInt)
  {
    paramInt += 1;
    length = ((int)Math.floor(Math.log(paramInt) / Math.log(2.0D)));
    value = (Math.pow(2.0D, length) - 1L & paramInt);
  }
  
  public final Iterator iterator()
  {
    return new zzdpk(this);
  }
}
