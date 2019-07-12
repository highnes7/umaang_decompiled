package com.google.android.android.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.location.GeofencingRequest;
import com.google.android.android.location.LocationAvailability;
import com.google.android.android.location.LocationSettingsRequest;
import com.google.android.android.location.zzaa;

public abstract interface zzbzk
  extends IInterface
{
  public abstract void handleResult(LocationSettingsRequest paramLocationSettingsRequest, zzbzm paramZzbzm, String paramString)
    throws RemoteException;
  
  public abstract void next(zzcaa paramZzcaa)
    throws RemoteException;
  
  public abstract void remainder(zzbzf paramZzbzf)
    throws RemoteException;
  
  public abstract void removeTask(PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void removeTask(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, zzbzi paramZzbzi)
    throws RemoteException;
  
  public abstract void removeTask(zzaa paramZzaa, zzbzi paramZzbzi)
    throws RemoteException;
  
  public abstract void replaceFragment(Location paramLocation)
    throws RemoteException;
  
  public abstract void scheduleAlarm(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void zzbk(boolean paramBoolean)
    throws RemoteException;
  
  public abstract Location zzia(String paramString)
    throws RemoteException;
  
  public abstract LocationAvailability zzib(String paramString)
    throws RemoteException;
}
