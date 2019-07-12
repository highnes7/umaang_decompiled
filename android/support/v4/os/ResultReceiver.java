package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import b.b.a.N;
import support.android.v4.app.IResultReceiver;
import support.android.v4.app.IResultReceiver.Stub;
import support.android.v4.app.VerticalProgressBar.SavedState.1;

@N({b.b.a.N.a.b})
public class ResultReceiver
  implements Parcelable
{
  public static final Parcelable.Creator<ResultReceiver> CREATOR = new VerticalProgressBar.SavedState.1();
  public final Handler mHandler;
  public final boolean mLocal;
  public IResultReceiver mReceiver;
  
  public ResultReceiver(Handler paramHandler)
  {
    mLocal = true;
    mHandler = paramHandler;
  }
  
  public ResultReceiver(Parcel paramParcel)
  {
    mLocal = false;
    mHandler = null;
    mReceiver = IResultReceiver.Stub.asInterface(paramParcel.readStrongBinder());
  }
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void send(int paramInt, Bundle paramBundle)
  {
    if (mLocal)
    {
      localObject = mHandler;
      if (localObject != null)
      {
        ((Handler)localObject).post(new b(paramInt, paramBundle));
        return;
      }
      a(paramInt, paramBundle);
      return;
    }
    Object localObject = mReceiver;
    if (localObject != null) {
      try
      {
        ((IResultReceiver)localObject).send(paramInt, paramBundle);
        return;
      }
      catch (RemoteException paramBundle) {}
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      if (mReceiver == null) {
        mReceiver = new a();
      }
      paramParcel.writeStrongBinder(mReceiver.asBinder());
      return;
    }
    catch (Throwable paramParcel)
    {
      throw paramParcel;
    }
  }
  
  public class a
    extends IResultReceiver.Stub
  {
    public a() {}
    
    public void send(int paramInt, Bundle paramBundle)
    {
      ResultReceiver localResultReceiver = ResultReceiver.this;
      Handler localHandler = mHandler;
      if (localHandler != null)
      {
        localHandler.post(new ResultReceiver.b(localResultReceiver, paramInt, paramBundle));
        return;
      }
      localResultReceiver.a(paramInt, paramBundle);
    }
  }
  
  public class b
    implements Runnable
  {
    public final int val$country;
    public final Bundle val$provider;
    
    public b(int paramInt, Bundle paramBundle)
    {
      val$country = paramInt;
      val$provider = paramBundle;
    }
    
    public void run()
    {
      a(val$country, val$provider);
    }
  }
}
