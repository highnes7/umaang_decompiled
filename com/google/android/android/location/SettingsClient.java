package com.google.android.android.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.android.common.internal.zzbi;
import com.google.android.android.common.package_9.internal.RealmObject;
import com.google.android.android.tasks.Task;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;

public class SettingsClient
  extends com.google.android.gms.common.api.GoogleApi<Api.ApiOptions.NoOptions>
{
  public SettingsClient(Activity paramActivity)
  {
    super(paramActivity, LocationServices.proxy, null, new RealmObject());
  }
  
  public SettingsClient(Context paramContext)
  {
    super(paramContext, LocationServices.proxy, null, new RealmObject());
  }
  
  public Task checkLocationSettings(LocationSettingsRequest paramLocationSettingsRequest)
  {
    return zzbi.f(LocationServices.SettingsApi.checkLocationSettings(zzafl(), paramLocationSettingsRequest), new LocationSettingsResponse());
  }
}
