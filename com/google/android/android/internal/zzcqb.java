package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.common.internal.zzam;

public final class zzcqb
  extends zzeb
  implements zzcqa
{
  public zzcqb(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.signin.internal.ISignInService");
  }
  
  public final void printStackTrace(zzcqd paramZzcqd, zzcpy paramZzcpy)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramZzcqd);
    zzed.get(localParcel, paramZzcpy);
    add(12, localParcel);
  }
  
  public final void remove(zzam paramZzam, int paramInt, boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzam);
    localParcel.writeInt(paramInt);
    zzed.append(localParcel, paramBoolean);
    add(9, localParcel);
  }
  
  public final void zzec(int paramInt)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    localParcel.writeInt(paramInt);
    add(7, localParcel);
  }
}
