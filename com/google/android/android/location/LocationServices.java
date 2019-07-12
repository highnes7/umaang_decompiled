package com.google.android.android.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.GoogleApiClient;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.common.package_9.internal.Logger;
import com.google.android.android.internal.zzbym;
import com.google.android.android.internal.zzbzb;
import com.google.android.android.internal.zzcaf;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;

public class LocationServices
{
  @Deprecated
  public static final FusedLocationProviderApi FusedLocationApi = new zzbym();
  @Deprecated
  public static final GeofencingApi GeofencingApi = new zzbzb();
  @Deprecated
  public static final SettingsApi SettingsApi = new zzcaf();
  public static final Api<Api.ApiOptions.NoOptions> proxy;
  public static final com.google.android.gms.common.api.Api.zzf<com.google.android.gms.internal.zzbzu> zzdwp = new com.google.android.android.common.package_9.Api.zzf();
  public static final Api.zza<com.google.android.gms.internal.zzbzu, Api.ApiOptions.NoOptions> zzdwq = new Generator();
  
  static
  {
    proxy = new Sample("LocationServices.API", zzdwq, zzdwp);
  }
  
  public LocationServices() {}
  
  public static FusedLocationProviderClient getFusedLocationProviderClient(Activity paramActivity)
  {
    return new FusedLocationProviderClient(paramActivity);
  }
  
  public static FusedLocationProviderClient getFusedLocationProviderClient(Context paramContext)
  {
    return new FusedLocationProviderClient(paramContext);
  }
  
  public static GeofencingClient getGeofencingClient(Activity paramActivity)
  {
    return new GeofencingClient(paramActivity);
  }
  
  public static GeofencingClient getGeofencingClient(Context paramContext)
  {
    return new GeofencingClient(paramContext);
  }
  
  public static com.google.android.android.internal.zzbzu getPrefs(GoogleApiClient paramGoogleApiClient)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramGoogleApiClient != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    zzbp.get(bool1, "GoogleApiClient parameter is required.");
    paramGoogleApiClient = (com.google.android.android.internal.zzbzu)paramGoogleApiClient.getChange(zzdwp);
    if (paramGoogleApiClient != null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    zzbp.append(bool1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
    return paramGoogleApiClient;
  }
  
  public static SettingsClient getSettingsClient(Activity paramActivity)
  {
    return new SettingsClient(paramActivity);
  }
  
  public static SettingsClient getSettingsClient(Context paramContext)
  {
    return new SettingsClient(paramContext);
  }
  
  public abstract class zza<R extends Result>
    extends zzm<R, com.google.android.gms.internal.zzbzu>
  {
    public zza()
    {
      super(this$1);
    }
  }
}
