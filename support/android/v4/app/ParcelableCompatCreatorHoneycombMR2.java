package support.android.v4.app;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import b.b.x.j.n;

public class ParcelableCompatCreatorHoneycombMR2<T>
  implements Parcelable.ClassLoaderCreator<T>
{
  public final n<T> mCallbacks;
  
  public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks paramParcelableCompatCreatorCallbacks)
  {
    mCallbacks = paramParcelableCompatCreatorCallbacks;
  }
  
  public Object createFromParcel(Parcel paramParcel)
  {
    return mCallbacks.createFromParcel(paramParcel, null);
  }
  
  public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return mCallbacks.createFromParcel(paramParcel, paramClassLoader);
  }
  
  public Object[] newArray(int paramInt)
  {
    return mCallbacks.newArray(paramInt);
  }
}
