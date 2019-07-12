package com.google.android.android.internal;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.accounttransfer.DeviceMetaData;
import com.google.android.android.auth.dashclock.accounttransfer.MapPack;
import com.google.android.android.auth.dashclock.accounttransfer.Profile;
import com.google.android.android.common.package_9.Status;

public abstract class zzaru
  extends zzec
  implements zzart
{
  public zzaru()
  {
    attachInterface(this, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferCallbacks");
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
      return false;
    case 7: 
      onException((DeviceMetaData)zzed.get(paramParcel1, DeviceMetaData.CREATOR));
      return true;
    case 6: 
      generateKey(paramParcel1.createByteArray());
      return true;
    case 5: 
      onFailure((Status)zzed.get(paramParcel1, Status.CREATOR));
      return true;
    case 4: 
      zzzy();
      return true;
    case 3: 
      addProfile((Status)zzed.get(paramParcel1, Status.CREATOR), (Profile)zzed.get(paramParcel1, Profile.CREATOR));
      return true;
    case 2: 
      write((Status)zzed.get(paramParcel1, Status.CREATOR), (MapPack)zzed.get(paramParcel1, MapPack.CREATOR));
      return true;
    }
    write((Status)zzed.get(paramParcel1, Status.CREATOR));
    return true;
  }
}
