package com.google.android.android.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.android.internal.zzbcp;

public final class LocationSettingsStates
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.location.LocationSettingsStates> CREATOR = new SpecialListsDueExistsProperty.1();
  public final boolean zzhyn;
  public final boolean zzhyo;
  public final boolean zzhyp;
  public final boolean zzhyq;
  public final boolean zzhyr;
  public final boolean zzhys;
  
  public LocationSettingsStates(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    zzhyn = paramBoolean1;
    zzhyo = paramBoolean2;
    zzhyp = paramBoolean3;
    zzhyq = paramBoolean4;
    zzhyr = paramBoolean5;
    zzhys = paramBoolean6;
  }
  
  public static LocationSettingsStates fromIntent(Intent paramIntent)
  {
    return (LocationSettingsStates)zzbcp.load(paramIntent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
  }
  
  public final boolean isBlePresent()
  {
    return zzhys;
  }
  
  public final boolean isBleUsable()
  {
    return zzhyp;
  }
  
  public final boolean isGpsPresent()
  {
    return zzhyq;
  }
  
  public final boolean isGpsUsable()
  {
    return zzhyn;
  }
  
  public final boolean isLocationPresent()
  {
    return (zzhyq) || (zzhyr);
  }
  
  public final boolean isLocationUsable()
  {
    return (zzhyn) || (zzhyo);
  }
  
  public final boolean isNetworkLocationPresent()
  {
    return zzhyr;
  }
  
  public final boolean isNetworkLocationUsable()
  {
    return zzhyo;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.onAction(paramParcel, 1, isGpsUsable());
    zzbcn.onAction(paramParcel, 2, isNetworkLocationUsable());
    zzbcn.onAction(paramParcel, 3, isBleUsable());
    zzbcn.onAction(paramParcel, 4, isGpsPresent());
    zzbcn.onAction(paramParcel, 5, isNetworkLocationPresent());
    zzbcn.onAction(paramParcel, 6, isBlePresent());
    zzbcn.zzah(paramParcel, paramInt);
  }
}
