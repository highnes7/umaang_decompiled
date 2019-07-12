package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import support.android.v4.view.VerticalProgressBar.SavedState.1;

public abstract class AbsSavedState
  implements Parcelable
{
  public static final Parcelable.Creator<AbsSavedState> CREATOR = new VerticalProgressBar.SavedState.1();
  public static final AbsSavedState EMPTY_STATE = new AbsSavedState() {};
  public final Parcelable mSuperState;
  
  public AbsSavedState()
  {
    mSuperState = null;
  }
  
  public AbsSavedState(Parcel paramParcel)
  {
    this(paramParcel, null);
  }
  
  public AbsSavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    paramClassLoader = paramParcel.readParcelable(paramClassLoader);
    paramParcel = paramClassLoader;
    if (paramClassLoader == null) {
      paramParcel = EMPTY_STATE;
    }
    mSuperState = paramParcel;
  }
  
  public AbsSavedState(Parcelable paramParcelable)
  {
    if (paramParcelable != null)
    {
      if (paramParcelable == EMPTY_STATE) {
        paramParcelable = null;
      }
      mSuperState = paramParcelable;
      return;
    }
    throw new IllegalArgumentException("superState must not be null");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final Parcelable getSuperState()
  {
    return mSuperState;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(mSuperState, paramInt);
  }
}
