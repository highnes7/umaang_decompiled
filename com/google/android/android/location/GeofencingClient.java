package com.google.android.android.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.android.common.internal.zzbi;
import com.google.android.android.common.package_9.internal.RealmObject;
import com.google.android.android.tasks.Task;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import java.util.List;

public class GeofencingClient
  extends com.google.android.gms.common.api.GoogleApi<Api.ApiOptions.NoOptions>
{
  public GeofencingClient(Activity paramActivity)
  {
    super(paramActivity, LocationServices.proxy, null, new RealmObject());
  }
  
  public GeofencingClient(Context paramContext)
  {
    super(paramContext, LocationServices.proxy, null, new RealmObject());
  }
  
  public Task addGeofences(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent)
  {
    return zzbi.f(LocationServices.GeofencingApi.addGeofences(zzafl(), paramGeofencingRequest, paramPendingIntent));
  }
  
  public Task removeGeofences(PendingIntent paramPendingIntent)
  {
    return zzbi.f(LocationServices.GeofencingApi.removeGeofences(zzafl(), paramPendingIntent));
  }
  
  public Task removeGeofences(List paramList)
  {
    return zzbi.f(LocationServices.GeofencingApi.removeGeofences(zzafl(), paramList));
  }
}
