package com.google.android.android.auth.dashclock;

import android.os.Bundle;
import b.b.a.F;
import com.google.android.android.auth.dashclock.credentials.CredentialsApi;
import com.google.android.android.auth.dashclock.credentials.PasswordSpecification;
import com.google.android.android.auth.dashclock.proxy.ProxyApi;
import com.google.android.android.auth.dashclock.signin.GoogleSignInApi;
import com.google.android.android.auth.dashclock.signin.internal.SolidColor;
import com.google.android.android.common.package_9.Api.ApiOptions.Optional;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.internal.zzarj;
import com.google.android.android.internal.zzark;
import com.google.android.android.internal.zzash;
import com.google.android.android.internal.zzato;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.internal.zzarl;
import com.google.android.gms.internal.zzasp;
import f.sufficientlysecure.rootcommands.util.StringBuilder;

public final class Auth
{
  public static final Api<com.google.android.gms.auth.api.Auth.AuthCredentialsOptions> CREDENTIALS_API;
  public static final CredentialsApi CredentialsApi;
  public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API;
  public static final GoogleSignInApi GoogleSignInApi = new SolidColor();
  @KeepForSdk
  public static final Api<zzf> PROXY_API;
  @KeepForSdk
  public static final ProxyApi ProxyApi;
  public static final com.google.android.gms.common.api.Api.zzf<zzasp> zzdyc = new com.google.android.android.common.package_9.Api.zzf();
  public static com.google.android.gms.common.api.Api.zzf<zzarl> zzdyd = new com.google.android.android.common.package_9.Api.zzf();
  public static final com.google.android.gms.common.api.Api.zzf<zzd> zzdye = new com.google.android.android.common.package_9.Api.zzf();
  public static final Api.zza<zzasp, com.google.android.gms.auth.api.Auth.AuthCredentialsOptions> zzdyf = new Generator();
  public static final Api.zza<zzarl, Api.ApiOptions.NoOptions> zzdyg = new ColorPreference();
  public static final Api.zza<zzd, GoogleSignInOptions> zzdyh = new Property();
  public static Api<Api.ApiOptions.NoOptions> zzdyi;
  public static zzarj zzdyj;
  
  static
  {
    PROXY_API = DAO._id;
    CREDENTIALS_API = new Sample("Auth.CREDENTIALS_API", zzdyf, zzdyc);
    GOOGLE_SIGN_IN_API = new Sample("Auth.GOOGLE_SIGN_IN_API", zzdyh, zzdye);
    zzdyi = new Sample("Auth.ACCOUNT_STATUS_API", zzdyg, zzdyd);
    ProxyApi = new zzato();
    CredentialsApi = new zzash();
    zzdyj = (zzarj)new zzark();
  }
  
  public Auth() {}
  
  public final class AuthCredentialsOptions
    implements Api.ApiOptions.Optional
  {
    public static AuthCredentialsOptions zzdyk = new AuthCredentialsOptions(new Builder());
    public final String zzdyl = null;
    public final PasswordSpecification zzdym;
    
    public AuthCredentialsOptions()
    {
      zzdym = zzdym;
    }
    
    public final Bundle zzzu()
    {
      Bundle localBundle = StringBuilder.put("consumer_package", null);
      localBundle.putParcelable("password_specification", zzdym);
      return localBundle;
    }
    
    public final PasswordSpecification zzzx()
    {
      return zzdym;
    }
    
    public class Builder
    {
      @F
      public PasswordSpecification zzdym = PasswordSpecification.zzeax;
      
      public Builder() {}
    }
  }
}
