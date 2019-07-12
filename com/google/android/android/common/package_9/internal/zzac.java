package com.google.android.android.common.package_9.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.package_9.Api.zze;
import com.google.android.android.common.package_9.Sample;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.internal.zzcps;
import com.google.android.gms.internal.zzcpt;

public final class zzac<O extends Api.ApiOptions>
  extends com.google.android.gms.common.api.GoogleApi<O>
{
  public final com.google.android.gms.common.api.Api.zza<? extends zzcps, zzcpt> zzfhm;
  public final Api.zze zzfkh;
  public final ByteArrayBuffer zzfki;
  public final AccountInformation zzfkj;
  
  public zzac(Context paramContext, Sample paramSample, Looper paramLooper, Api.zze paramZze, ByteArrayBuffer paramByteArrayBuffer, AccountInformation paramAccountInformation, com.google.android.android.common.package_9.Api.zza paramZza)
  {
    super(paramContext, paramSample, paramLooper);
    zzfkh = paramZze;
    zzfki = paramByteArrayBuffer;
    zzfkj = paramAccountInformation;
    zzfhm = paramZza;
    zzfgv.notifyError(this);
  }
  
  public final Api.zze getTemplate(Looper paramLooper, zzbr paramZzbr)
  {
    zzfki.append(paramZzbr);
    return zzfkh;
  }
  
  public final zzcw requestSync(Context paramContext, Handler paramHandler)
  {
    return new zzcw(paramContext, paramHandler, zzfkj, zzfhm);
  }
  
  public final Api.zze zzagn()
  {
    return zzfkh;
  }
}
