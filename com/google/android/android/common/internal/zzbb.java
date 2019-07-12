package com.google.android.android.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.android.common.Element;
import com.google.android.android.dynamic.IObjectWrapper;
import com.google.android.android.internal.zzeb;
import com.google.android.android.internal.zzed;

public final class zzbb
  extends zzeb
  implements zzaz
{
  public zzbb(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
  }
  
  public final boolean getValue(Element paramElement, IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Parcel localParcel = zzax();
    zzed.append(localParcel, paramElement);
    zzed.get(localParcel, paramIObjectWrapper);
    paramElement = get(5, localParcel);
    boolean bool = zzed.readString(paramElement);
    paramElement.recycle();
    return bool;
  }
}
