package com.google.android.android.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.internal.zzeb;
import com.google.android.android.internal.zzed;

public final class CopyOnWriteMap
  extends zzeb
  implements IFileWriteModuleService
{
  public CopyOnWriteMap(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.account.IWorkAccountService");
  }
  
  public final void clear(IPlayMedia_0_8 paramIPlayMedia_0_8, Account paramAccount)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramIPlayMedia_0_8);
    zzed.append(localParcel, paramAccount);
    add(3, localParcel);
  }
  
  public final void handleResult(IPlayMedia_0_8 paramIPlayMedia_0_8, String paramString)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramIPlayMedia_0_8);
    localParcel.writeString(paramString);
    add(2, localParcel);
  }
  
  public final void zzap(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramBoolean);
    add(1, localParcel);
  }
}
