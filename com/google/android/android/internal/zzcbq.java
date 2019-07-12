package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public final class zzcbq
  extends zzeb
  implements zzcbo
{
  public zzcbq(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
  }
  
  public final void addPackage(zzcav paramZzcav)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramZzcav);
    add(13, localParcel);
  }
  
  public final void bindToService(zzcas paramZzcas)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramZzcas);
    add(4, localParcel);
  }
  
  public final void getAbsoluteUrl(zzcas paramZzcas)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramZzcas);
    add(6, localParcel);
  }
  
  public final String getAttachment(zzcas paramZzcas)
    throws RemoteException
  {
    Object localObject = zzax();
    zzed.append((Parcel)localObject, paramZzcas);
    paramZzcas = get(11, (Parcel)localObject);
    localObject = paramZzcas.readString();
    paramZzcas.recycle();
    return localObject;
  }
  
  public final List getFromLocationName(zzcas paramZzcas, boolean paramBoolean)
    throws RemoteException
  {
    Object localObject = zzax();
    zzed.append((Parcel)localObject, paramZzcas);
    zzed.append((Parcel)localObject, paramBoolean);
    paramZzcas = get(7, (Parcel)localObject);
    localObject = paramZzcas.createTypedArrayList(zzcft.CREATOR);
    paramZzcas.recycle();
    return localObject;
  }
  
  public final List getFromLocationName(String paramString1, String paramString2, zzcas paramZzcas)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzed.append(localParcel, paramZzcas);
    paramString1 = get(16, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzcav.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final List getFromLocationName(String paramString1, String paramString2, String paramString3)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    paramString1 = get(17, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzcav.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final List getFromLocationName(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    zzed.append(localParcel, paramBoolean);
    paramString1 = get(15, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzcft.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final List getFromLocationName(String paramString1, String paramString2, boolean paramBoolean, zzcas paramZzcas)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzed.append(localParcel, paramBoolean);
    zzed.append(localParcel, paramZzcas);
    paramString1 = get(14, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzcft.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final void getPackageInfo(zzcav paramZzcav, zzcas paramZzcas)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramZzcav);
    zzed.append(localParcel, paramZzcas);
    add(12, localParcel);
  }
  
  public final void handleResult(zzcbk paramZzcbk, String paramString1, String paramString2)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramZzcbk);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    add(5, localParcel);
  }
  
  public final void onNetworkStateChanged(long paramLong, String paramString1, String paramString2, String paramString3)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeLong(paramLong);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    add(10, localParcel);
  }
  
  public final byte[] saveToFile(zzcbk paramZzcbk, String paramString)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramZzcbk);
    localParcel.writeString(paramString);
    paramZzcbk = get(9, localParcel);
    paramString = paramZzcbk.createByteArray();
    paramZzcbk.recycle();
    return paramString;
  }
  
  public final void trim(zzcbk paramZzcbk, zzcas paramZzcas)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramZzcbk);
    zzed.append(localParcel, paramZzcas);
    add(1, localParcel);
  }
  
  public final void trim(zzcft paramZzcft, zzcas paramZzcas)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramZzcft);
    zzed.append(localParcel, paramZzcas);
    add(2, localParcel);
  }
}
