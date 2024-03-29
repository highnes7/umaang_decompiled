package android.support.v4.package_7;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<android.support.v4.app.FragmentManagerState> CREATOR = new Parcelable.Creator()
  {
    public FragmentManagerState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new FragmentManagerState(paramAnonymousParcel);
    }
    
    public FragmentManagerState[] newArray(int paramAnonymousInt)
    {
      return new FragmentManagerState[paramAnonymousInt];
    }
  };
  public FragmentState[] mActive;
  public int[] mAdded;
  public BackStackState[] mBackStack;
  public int mNextFragmentIndex;
  public int mPrimaryNavActiveIndex = -1;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    mActive = ((FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR));
    mAdded = paramParcel.createIntArray();
    mBackStack = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    mPrimaryNavActiveIndex = paramParcel.readInt();
    mNextFragmentIndex = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(mActive, paramInt);
    paramParcel.writeIntArray(mAdded);
    paramParcel.writeTypedArray(mBackStack, paramInt);
    paramParcel.writeInt(mPrimaryNavActiveIndex);
    paramParcel.writeInt(mNextFragmentIndex);
  }
}
