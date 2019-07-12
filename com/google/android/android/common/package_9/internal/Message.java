package com.google.android.android.common.package_9.internal;

import android.os.DeadObjectException;
import com.google.android.android.common.package_9.Status;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzm;

public final class Message<A extends zzm<? extends Result, Api.zzb>>
  extends zza
{
  public A zzfic;
  
  public Message(int paramInt, Logger paramLogger)
  {
    super(paramInt);
    zzfic = paramLogger;
  }
  
  public final void add(Status paramStatus)
  {
    zzfic.remove(paramStatus);
  }
  
  public final void add(zzah paramZzah, boolean paramBoolean)
  {
    paramZzah.execute(zzfic, paramBoolean);
  }
  
  public final void add(zzbr paramZzbr)
    throws DeadObjectException
  {
    zzfic.debug(paramZzbr.zzagn());
  }
}
