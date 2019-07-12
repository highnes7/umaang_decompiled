package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class zzanp
  implements Parcelable
{
  @Deprecated
  public static final Parcelable.Creator<com.google.android.gms.internal.zzanp> CREATOR = new zzanq();
  public String mValue;
  public String zzbsx;
  public String zzdqj;
  
  public zzanp() {}
  
  public zzanp(Parcel paramParcel)
  {
    zzbsx = paramParcel.readString();
    zzdqj = paramParcel.readString();
    mValue = paramParcel.readString();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String getId()
  {
    return zzbsx;
  }
  
  public final String getValue()
  {
    return mValue;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(zzbsx);
    paramParcel.writeString(zzdqj);
    paramParcel.writeString(mValue);
  }
}
