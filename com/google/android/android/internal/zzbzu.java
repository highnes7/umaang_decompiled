package com.google.android.android.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.internal.TaskManager;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.android.common.package_9.internal.c;
import com.google.android.android.common.package_9.internal.zzcj;
import com.google.android.android.common.package_9.internal.zzcl;
import com.google.android.android.location.GeofencingRequest;
import com.google.android.android.location.LocationAvailability;
import com.google.android.android.location.LocationRequest;
import com.google.android.android.location.LocationSettingsRequest;
import com.google.android.android.location.zzaa;

public final class zzbzu
  extends zzbyi
{
  public final zzbzo zzhzs = new zzbzo(paramContext, zzhzb);
  
  public zzbzu(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, AccountInformation.zzcc(paramContext));
  }
  
  public zzbzu(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, AccountInformation paramAccountInformation)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, paramAccountInformation);
  }
  
  public final void addMenuItem(PendingIntent paramPendingIntent, zzbzf paramZzbzf)
    throws RemoteException
  {
    zzhzs.addMenuItem(paramPendingIntent, paramZzbzf);
  }
  
  public final void disconnect()
  {
    localZzbzo1 = zzhzs;
    try
    {
      boolean bool = isConnected();
      if (bool) {
        localZzbzo2 = zzhzs;
      }
    }
    catch (Throwable localThrowable)
    {
      zzbzo localZzbzo2;
      label34:
      throw localThrowable;
    }
    try
    {
      localZzbzo2.removeAllListeners();
      localZzbzo2 = zzhzs;
      localZzbzo2.zzasx();
    }
    catch (Exception localException)
    {
      break label34;
    }
    super.disconnect();
  }
  
  public final void finish(long paramLong, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    zzaji();
    zzbp.append(paramPendingIntent);
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.get(bool, "detectionIntervalMillis must be >= 0");
    ((zzbzk)zzajj()).scheduleAlarm(paramLong, true, paramPendingIntent);
  }
  
  public final Location getLastLocation()
  {
    return zzhzs.getLastLocation();
  }
  
  public final void registerRenderer(zzcl paramZzcl, zzbzf paramZzbzf)
    throws RemoteException
  {
    zzhzs.zoomChanged(paramZzcl, paramZzbzf);
  }
  
  public final void registerRenderer(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent, zzbzf paramZzbzf)
    throws RemoteException
  {
    zzhzs.registerRenderer(paramLocationRequest, paramPendingIntent, paramZzbzf);
  }
  
  public final void remainder(zzbzf paramZzbzf)
    throws RemoteException
  {
    zzhzs.remainder(paramZzbzf);
  }
  
  public final void removeTask(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    zzaji();
    zzbp.append(paramPendingIntent);
    ((zzbzk)zzajj()).removeTask(paramPendingIntent);
  }
  
  public final void removeTask(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, c paramC)
    throws RemoteException
  {
    zzaji();
    zzbp.get(paramGeofencingRequest, "geofencingRequest can't be null.");
    zzbp.get(paramPendingIntent, "PendingIntent must be specified.");
    zzbp.get(paramC, "ResultHolder not provided.");
    paramC = new zzbzv(paramC);
    ((zzbzk)zzajj()).removeTask(paramGeofencingRequest, paramPendingIntent, paramC);
  }
  
  public final void removeTask(LocationSettingsRequest paramLocationSettingsRequest, c paramC, String paramString)
    throws RemoteException
  {
    zzaji();
    boolean bool2 = true;
    boolean bool1;
    if (paramLocationSettingsRequest != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    zzbp.get(bool1, "locationSettingsRequest can't be null nor empty.");
    if (paramC != null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    zzbp.get(bool1, "listener can't be null.");
    paramC = new zzbzx(paramC);
    ((zzbzk)zzajj()).handleResult(paramLocationSettingsRequest, paramC, paramString);
  }
  
  public final void removeTask(zzaa paramZzaa, c paramC)
    throws RemoteException
  {
    zzaji();
    zzbp.get(paramZzaa, "removeGeofencingRequest can't be null.");
    zzbp.get(paramC, "ResultHolder not provided.");
    paramC = new zzbzw(paramC);
    ((zzbzk)zzajj()).removeTask(paramZzaa, paramC);
  }
  
  public final void savePage(LocationRequest paramLocationRequest, zzcj paramZzcj, zzbzf paramZzbzf)
    throws RemoteException
  {
    zzbzo localZzbzo = zzhzs;
    try
    {
      zzhzs.estimateSize(paramLocationRequest, paramZzcj, paramZzbzf);
      return;
    }
    catch (Throwable paramLocationRequest)
    {
      throw paramLocationRequest;
    }
  }
  
  public final void setView(zzcl paramZzcl, zzbzf paramZzbzf)
    throws RemoteException
  {
    zzhzs.repaint(paramZzcl, paramZzbzf);
  }
  
  public final void setViewPort(Location paramLocation)
    throws RemoteException
  {
    zzhzs.createNote(paramLocation);
  }
  
  public final void startSession(zzbzy paramZzbzy, zzcj paramZzcj, zzbzf paramZzbzf)
    throws RemoteException
  {
    zzbzo localZzbzo = zzhzs;
    try
    {
      zzhzs.startSession(paramZzbzy, paramZzcj, paramZzbzf);
      return;
    }
    catch (Throwable paramZzbzy)
    {
      throw paramZzbzy;
    }
  }
  
  public final LocationAvailability zzasw()
  {
    return zzhzs.zzasw();
  }
  
  public final void zzbk(boolean paramBoolean)
    throws RemoteException
  {
    zzhzs.zzbk(paramBoolean);
  }
}
