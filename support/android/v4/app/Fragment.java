package support.android.v4.app;

import android.os.Parcelable.Creator;

@Deprecated
public final class Fragment
{
  public Fragment() {}
  
  public static Parcelable.Creator instantiate(ParcelableCompatCreatorCallbacks paramParcelableCompatCreatorCallbacks)
  {
    return new ParcelableCompatCreatorHoneycombMR2(paramParcelableCompatCreatorCallbacks);
  }
}
