package com.google.android.android.internal;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzcbp
  extends zzec
  implements zzcbo
{
  public zzcbp()
  {
    attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (connect(paramInt1, paramParcel1, paramParcel2, paramInt2)) {
      return true;
    }
    switch (paramInt1)
    {
    default: 
      break;
    case 3: 
    case 8: 
      return false;
    case 17: 
      paramParcel1 = getFromLocationName(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      break;
    case 16: 
      paramParcel1 = getFromLocationName(paramParcel1.readString(), paramParcel1.readString(), (zzcas)zzed.get(paramParcel1, zzcas.CREATOR));
      break;
    case 15: 
      paramParcel1 = getFromLocationName(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), zzed.readString(paramParcel1));
      break;
    case 14: 
      paramParcel1 = getFromLocationName(paramParcel1.readString(), paramParcel1.readString(), zzed.readString(paramParcel1), (zzcas)zzed.get(paramParcel1, zzcas.CREATOR));
      break;
    case 13: 
      addPackage((zzcav)zzed.get(paramParcel1, zzcav.CREATOR));
      break;
    case 12: 
      getPackageInfo((zzcav)zzed.get(paramParcel1, zzcav.CREATOR), (zzcas)zzed.get(paramParcel1, zzcas.CREATOR));
      break;
    case 11: 
      paramParcel1 = getAttachment((zzcas)zzed.get(paramParcel1, zzcas.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 10: 
      onNetworkStateChanged(paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      break;
    case 9: 
      paramParcel1 = saveToFile((zzcbk)zzed.get(paramParcel1, zzcbk.CREATOR), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    case 7: 
      paramParcel1 = getFromLocationName((zzcas)zzed.get(paramParcel1, zzcas.CREATOR), zzed.readString(paramParcel1));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      return true;
    case 6: 
      getAbsoluteUrl((zzcas)zzed.get(paramParcel1, zzcas.CREATOR));
      break;
    case 5: 
      handleResult((zzcbk)zzed.get(paramParcel1, zzcbk.CREATOR), paramParcel1.readString(), paramParcel1.readString());
      break;
    case 4: 
      bindToService((zzcas)zzed.get(paramParcel1, zzcas.CREATOR));
      break;
    case 2: 
      trim((zzcft)zzed.get(paramParcel1, zzcft.CREATOR), (zzcas)zzed.get(paramParcel1, zzcas.CREATOR));
      break;
    }
    trim((zzcbk)zzed.get(paramParcel1, zzcbk.CREATOR), (zzcas)zzed.get(paramParcel1, zzcas.CREATOR));
    paramParcel2.writeNoException();
    return true;
  }
}
