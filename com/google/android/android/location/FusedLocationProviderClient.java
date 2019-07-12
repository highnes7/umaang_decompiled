package com.google.android.android.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import com.google.android.android.common.internal.zzbi;
import com.google.android.android.common.package_9.internal.RealmObject;
import com.google.android.android.common.package_9.internal.zzcj;
import com.google.android.android.common.package_9.internal.zzcl;
import com.google.android.android.common.package_9.internal.zzcn;
import com.google.android.android.common.package_9.internal.zzcr;
import com.google.android.android.common.package_9.internal.zzde;
import com.google.android.android.common.package_9.internal.zzdn;
import com.google.android.android.internal.zzbyz;
import com.google.android.android.internal.zzbzg;
import com.google.android.android.internal.zzbzy;
import com.google.android.android.internal.zzcam;
import com.google.android.android.tasks.Task;
import com.google.android.android.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;

public class FusedLocationProviderClient
  extends com.google.android.gms.common.api.GoogleApi<Api.ApiOptions.NoOptions>
{
  public FusedLocationProviderClient(Activity paramActivity)
  {
    super(paramActivity, LocationServices.proxy, null, new RealmObject());
  }
  
  public FusedLocationProviderClient(Context paramContext)
  {
    super(paramContext, LocationServices.proxy, null, new RealmObject());
  }
  
  public Task flushLocations()
  {
    return zzbi.f(LocationServices.FusedLocationApi.flushLocations(zzafl()));
  }
  
  public Task getLastLocation()
  {
    return getLastKnownLocation(new Location(this));
  }
  
  public Task getLocationAvailability()
  {
    return getLastKnownLocation(new Marker(this));
  }
  
  public Task removeLocationUpdates(PendingIntent paramPendingIntent)
  {
    return zzbi.f(LocationServices.FusedLocationApi.removeLocationUpdates(zzafl(), paramPendingIntent));
  }
  
  public Task removeLocationUpdates(LocationCallback paramLocationCallback)
  {
    paramLocationCallback = zzcn.d(paramLocationCallback, com.google.android.gms.location.LocationCallback.class.getSimpleName());
    com.google.android.android.common.internal.zzbp.get(paramLocationCallback, "Listener key cannot be null.");
    return zzde.then(zzfgv.then(this, paramLocationCallback));
  }
  
  public Task requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
  {
    return zzbi.f(LocationServices.FusedLocationApi.requestLocationUpdates(zzafl(), paramLocationRequest, paramPendingIntent));
  }
  
  public Task requestLocationUpdates(LocationRequest paramLocationRequest, LocationCallback paramLocationCallback, Looper paramLooper)
  {
    paramLocationRequest = zzbzy.getSimpleName(paramLocationRequest);
    paramLocationCallback = zzcn.d(paramLocationCallback, zzcam.getElementValue(paramLooper), com.google.android.gms.location.LocationCallback.class.getSimpleName());
    paramLocationRequest = new AdapterHelper(this, paramLocationCallback, paramLocationRequest, paramLocationCallback);
    paramLocationCallback = new BackendHelper.Callback(this, paramLocationCallback.zzaik());
    com.google.android.android.common.internal.zzbp.append(paramLocationRequest);
    com.google.android.android.common.internal.zzbp.append(paramLocationCallback);
    com.google.android.android.common.internal.zzbp.get(paramLocationRequest.zzaik(), "Listener has already been released.");
    com.google.android.android.common.internal.zzbp.get(paramLocationCallback.zzaik(), "Listener has already been released.");
    com.google.android.android.common.internal.zzbp.get(paramLocationRequest.zzaik().equals(paramLocationCallback.zzaik()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
    return zzfgv.then(this, paramLocationRequest, paramLocationCallback);
  }
  
  public Task setMockLocation(android.location.Location paramLocation)
  {
    return zzbi.f(LocationServices.FusedLocationApi.setMockLocation(zzafl(), paramLocation));
  }
  
  public Task setMockMode(boolean paramBoolean)
  {
    return zzbi.f(LocationServices.FusedLocationApi.setMockMode(zzafl(), paramBoolean));
  }
  
  public final class zza
    extends zzbzg
  {
    public zza() {}
    
    public final void publishUpdate(zzbyz paramZzbyz)
    {
      zzde.status(paramZzbyz.getStatus(), null, FusedLocationProviderClient.this);
    }
  }
}
