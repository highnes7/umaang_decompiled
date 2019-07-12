package com.google.android.android.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.location.IOnBufferingUpdateListenerCallback_0_8;
import com.google.android.android.location.LocationBackend;

public final class zzcaa
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzcaa> CREATOR = new zzcab();
  public PendingIntent mPendingIntent;
  public int zziaa;
  public zzbzy zziab;
  public LocationBackend zziac;
  public IOnBufferingUpdateListenerCallback_0_8 zziad;
  public zzbzf zziae;
  
  public zzcaa(int paramInt, zzbzy paramZzbzy, IBinder paramIBinder1, PendingIntent paramPendingIntent, IBinder paramIBinder2, IBinder paramIBinder3) {}
  
  public static zzcaa getAttachment(IOnBufferingUpdateListenerCallback_0_8 paramIOnBufferingUpdateListenerCallback_0_8, zzbzf paramZzbzf)
  {
    IBinder localIBinder = paramIOnBufferingUpdateListenerCallback_0_8.asBinder();
    if (paramZzbzf != null) {
      paramIOnBufferingUpdateListenerCallback_0_8 = paramZzbzf.asBinder();
    } else {
      paramIOnBufferingUpdateListenerCallback_0_8 = null;
    }
    return new zzcaa(2, null, null, null, localIBinder, paramIOnBufferingUpdateListenerCallback_0_8);
  }
  
  public static zzcaa getAttachment(LocationBackend paramLocationBackend, zzbzf paramZzbzf)
  {
    IBinder localIBinder = paramLocationBackend.asBinder();
    if (paramZzbzf != null) {
      paramLocationBackend = paramZzbzf.asBinder();
    } else {
      paramLocationBackend = null;
    }
    return new zzcaa(2, null, localIBinder, null, null, paramLocationBackend);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zziaa);
    zzbcn.addMenuItem(paramParcel, 2, zziab, paramInt, false);
    Object localObject1 = zziac;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    zzbcn.writeString(paramParcel, 3, (IBinder)localObject1, false);
    zzbcn.addMenuItem(paramParcel, 4, mPendingIntent, paramInt, false);
    localObject1 = zziad;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    zzbcn.writeString(paramParcel, 5, (IBinder)localObject1, false);
    localObject1 = zziae;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    zzbcn.writeString(paramParcel, 6, (IBinder)localObject1, false);
    zzbcn.zzah(paramParcel, i);
  }
}
