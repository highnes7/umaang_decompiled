package support.android.v4.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IResultReceiver
  extends IInterface
{
  public abstract void send(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public abstract class Stub
    extends Binder
    implements IResultReceiver
  {
    public static final String DESCRIPTOR = "android.support.v4.os.IResultReceiver";
    public static final int TRANSACTION_send = 1;
    
    public Stub()
    {
      attachInterface(this, "android.support.v4.os.IResultReceiver");
    }
    
    public static IResultReceiver asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
      if ((localIInterface != null) && ((localIInterface instanceof IResultReceiver))) {
        return (IResultReceiver)localIInterface;
      }
      return new f.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 1598968902) {
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }
        paramParcel2.writeString("android.support.v4.os.IResultReceiver");
        return true;
      }
      paramParcel1.enforceInterface("android.support.v4.os.IResultReceiver");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {
        paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      } else {
        paramParcel1 = null;
      }
      send(paramInt1, paramParcel1);
      return true;
    }
  }
}
