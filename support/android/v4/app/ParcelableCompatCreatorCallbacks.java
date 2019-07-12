package support.android.v4.app;

import android.os.Parcel;

@Deprecated
public abstract interface ParcelableCompatCreatorCallbacks<T>
{
  public abstract Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader);
  
  public abstract Object[] newArray(int paramInt);
}
