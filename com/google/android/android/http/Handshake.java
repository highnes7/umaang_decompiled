package com.google.android.android.http;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.internal.zzeb;
import com.google.android.android.internal.zzed;

public final class Handshake
  extends zzeb
  implements HttpRequest
{
  public Handshake(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.iid.IMessengerCompat");
  }
  
  public final void send(Message paramMessage)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramMessage);
    set(1, localParcel);
  }
}
