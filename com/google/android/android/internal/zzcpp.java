package com.google.android.android.internal;

import com.google.android.android.common.package_9.Sample;
import com.google.android.android.common.package_9.Scope;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.internal.zzcpt;
import com.google.android.gms.internal.zzcqc;

public final class zzcpp
{
  public static final Api<zzcpt> CURSOR_POSITION = new Sample("SignIn.API", zzdwq, zzdwp);
  public static com.google.android.gms.common.api.Api.zzf<zzcqc> zzdwp = new com.google.android.android.common.package_9.Api.zzf();
  public static final Api.zza<zzcqc, zzcpt> zzdwq;
  public static Scope zzecd;
  public static Scope zzece;
  public static Api<Object> zzgdn = new Sample("SignIn.INTERNAL_API", zzjnn, zzjnm);
  public static com.google.android.gms.common.api.Api.zzf<zzcqc> zzjnm = new com.google.android.android.common.package_9.Api.zzf();
  public static Api.zza<zzcqc, Object> zzjnn;
  
  static
  {
    zzdwq = new zzcpq();
    zzjnn = new zzcpr();
    zzecd = new Scope(1, "profile");
    zzece = new Scope(1, "email");
  }
}
