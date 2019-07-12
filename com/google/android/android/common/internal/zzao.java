package com.google.android.android.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.internal.zzeb;
import com.google.android.android.internal.zzed;

public final class zzao
  extends zzeb
  implements zzam
{
  public zzao(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.IAccountAccessor");
  }
  
  public final Account getAccount()
    throws RemoteException
  {
    Parcel localParcel = get(2, zzax());
    Account localAccount = (Account)zzed.get(localParcel, Account.CREATOR);
    localParcel.recycle();
    return localAccount;
  }
}
