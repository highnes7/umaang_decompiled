package com.google.android.android.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.auth.dashclock.credentials.CredentialRequest;

public final class zzasv
  extends zzeb
  implements zzasu
{
  public zzasv(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
  }
  
  public final void clear(zzass paramZzass, zzasw paramZzasw)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzass);
    zzed.append(localParcel, paramZzasw);
    add(2, localParcel);
  }
  
  public final void loadCover(zzass paramZzass, zzasq paramZzasq)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzass);
    zzed.append(localParcel, paramZzasq);
    add(3, localParcel);
  }
  
  public final void makeView(zzass paramZzass, CredentialRequest paramCredentialRequest)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzass);
    zzed.append(localParcel, paramCredentialRequest);
    add(1, localParcel);
  }
  
  public final void processParameters(zzass paramZzass)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.get(localParcel, paramZzass);
    add(4, localParcel);
  }
}
