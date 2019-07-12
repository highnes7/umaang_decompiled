package com.google.android.android.auth.dashclock.accounttransfer;

import android.os.RemoteException;
import com.google.android.android.internal.zzarr;
import com.google.android.android.internal.zzarv;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;

public final class NavitMapDownloader
  extends com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zzb<DeviceMetaData>
{
  public NavitMapDownloader(AccountTransferClient paramAccountTransferClient, zzarr paramZzarr)
  {
    super(null);
  }
  
  public final void downloadData(zzarv paramZzarv)
    throws RemoteException
  {
    paramZzarv.addElement(new MainActivity.8(this, this), zzdyx);
  }
}
