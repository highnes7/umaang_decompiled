package com.google.android.android.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.location.GeofencingRequest;
import com.google.android.android.location.LocationAvailability;
import com.google.android.android.location.LocationSettingsRequest;
import com.google.android.android.location.zzaa;

public final class zzbzl
  extends zzeb
  implements zzbzk
{
  public zzbzl(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
  }
  
  public final void handleResult(LocationSettingsRequest paramLocationSettingsRequest, zzbzm paramZzbzm, String paramString)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramLocationSettingsRequest);
    zzed.get(localParcel, paramZzbzm);
    localParcel.writeString(paramString);
    add(63, localParcel);
  }
  
  public final void next(zzcaa paramZzcaa)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramZzcaa);
    add(59, localParcel);
  }
  
  public final void remainder(zzbzf paramZzbzf)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzbzf);
    add(67, localParcel);
  }
  
  public final void removeTask(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramPendingIntent);
    add(6, localParcel);
  }
  
  public final void removeTask(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, zzbzi paramZzbzi)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramGeofencingRequest);
    zzed.append(localParcel, paramPendingIntent);
    zzed.get(localParcel, paramZzbzi);
    add(57, localParcel);
  }
  
  public final void removeTask(zzaa paramZzaa, zzbzi paramZzbzi)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramZzaa);
    zzed.get(localParcel, paramZzbzi);
    add(74, localParcel);
  }
  
  public final void replaceFragment(Location paramLocation)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramLocation);
    add(13, localParcel);
  }
  
  public final void scheduleAlarm(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeLong(paramLong);
    zzed.append(localParcel, true);
    zzed.append(localParcel, paramPendingIntent);
    add(5, localParcel);
  }
  
  public final void zzbk(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramBoolean);
    add(12, localParcel);
  }
  
  public final Location zzia(String paramString)
    throws RemoteException
  {
    Object localObject = zzax();
    ((Parcel)localObject).writeString(paramString);
    paramString = get(21, (Parcel)localObject);
    localObject = (Location)zzed.get(paramString, Location.CREATOR);
    paramString.recycle();
    return localObject;
  }
  
  public final LocationAvailability zzib(String paramString)
    throws RemoteException
  {
    Object localObject = zzax();
    ((Parcel)localObject).writeString(paramString);
    paramString = get(34, (Parcel)localObject);
    localObject = (LocationAvailability)zzed.get(paramString, LocationAvailability.CREATOR);
    paramString.recycle();
    return localObject;
  }
}
