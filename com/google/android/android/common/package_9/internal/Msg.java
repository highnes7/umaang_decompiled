package com.google.android.android.common.package_9.internal;

import com.google.android.android.common.internal.zzbf;
import com.google.android.android.common.package_9.Sample;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;

public final class Msg<O extends com.google.android.gms.common.api.Api.ApiOptions>
{
  public final Api<O> zzfdg;
  public final O zzfgr;
  public final boolean zzfii;
  public final int zzfij;
  
  public Msg(Sample paramSample)
  {
    zzfii = true;
    zzfdg = paramSample;
    zzfgr = null;
    zzfij = System.identityHashCode(this);
  }
  
  public Msg(Sample paramSample, com.google.android.android.common.package_9.Api.ApiOptions paramApiOptions)
  {
    zzfii = false;
    zzfdg = paramSample;
    zzfgr = paramApiOptions;
    zzfij = Arrays.hashCode(new Object[] { zzfdg, zzfgr });
  }
  
  public static Msg readMessage(Sample paramSample)
  {
    return new Msg(paramSample);
  }
  
  public static Msg readMessage(Sample paramSample, com.google.android.android.common.package_9.Api.ApiOptions paramApiOptions)
  {
    return new Msg(paramSample, paramApiOptions);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Msg)) {
      return false;
    }
    paramObject = (Msg)paramObject;
    return (!zzfii) && (!zzfii) && (zzbf.equal(zzfdg, zzfdg)) && (zzbf.equal(zzfgr, zzfgr));
  }
  
  public final int hashCode()
  {
    return zzfij;
  }
  
  public final String zzafv()
  {
    return zzfdg.getName();
  }
}
