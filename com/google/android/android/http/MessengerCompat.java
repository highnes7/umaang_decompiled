package com.google.android.android.http;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.android.common.internal.ReflectedParcelable;

public class MessengerCompat
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.iid.MessengerCompat> CREATOR = new VerticalProgressBar.SavedState.1();
  public Messenger zzhtu;
  public HttpRequest zzhtv;
  
  public MessengerCompat(IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      zzhtu = new Messenger(paramIBinder);
      return;
    }
    if (paramIBinder == null)
    {
      paramIBinder = null;
    }
    else
    {
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
      if ((localIInterface instanceof HttpRequest)) {
        paramIBinder = (HttpRequest)localIInterface;
      } else {
        paramIBinder = new Handshake(paramIBinder);
      }
    }
    zzhtv = paramIBinder;
  }
  
  private final IBinder getBinder()
  {
    Messenger localMessenger = zzhtu;
    if (localMessenger != null) {
      return localMessenger.getBinder();
    }
    return zzhtv.asBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      boolean bool = getBinder().equals(((MessengerCompat)paramObject).getBinder());
      return bool;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public int hashCode()
  {
    return getBinder().hashCode();
  }
  
  public final void send(Message paramMessage)
    throws RemoteException
  {
    Messenger localMessenger = zzhtu;
    if (localMessenger != null)
    {
      localMessenger.send(paramMessage);
      return;
    }
    zzhtv.send(paramMessage);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject = zzhtu;
    if (localObject != null) {}
    for (localObject = ((Messenger)localObject).getBinder();; localObject = zzhtv.asBinder())
    {
      paramParcel.writeStrongBinder((IBinder)localObject);
      return;
    }
  }
}
