package com.google.android.android.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.package_9.Result;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;

public final class LocationSettingsResult
  extends zzbck
  implements Result
{
  public static final Parcelable.Creator<com.google.android.gms.location.LocationSettingsResult> CREATOR = new PaymentIntent.1();
  public final Status mStatus;
  public final LocationSettingsStates zzhym;
  
  public LocationSettingsResult(Status paramStatus)
  {
    mStatus = paramStatus;
    zzhym = null;
  }
  
  public LocationSettingsResult(Status paramStatus, LocationSettingsStates paramLocationSettingsStates)
  {
    mStatus = paramStatus;
    zzhym = paramLocationSettingsStates;
  }
  
  public final LocationSettingsStates getLocationSettingsStates()
  {
    return zzhym;
  }
  
  public final Status getStatus()
  {
    return mStatus;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.addMenuItem(paramParcel, 1, getStatus(), paramInt, false);
    zzbcn.addMenuItem(paramParcel, 2, getLocationSettingsStates(), paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
