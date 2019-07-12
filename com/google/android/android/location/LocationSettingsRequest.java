package com.google.android.android.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationSettingsRequest
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.location.LocationSettingsRequest> CREATOR = new SpecialListsProgressProperty.1();
  public final List<com.google.android.gms.location.LocationRequest> zzgzq;
  public final boolean zzhyi;
  public final boolean zzhyj;
  public StatusBarPanelCustomTile zzhyk;
  
  public LocationSettingsRequest(List paramList, boolean paramBoolean1, boolean paramBoolean2, StatusBarPanelCustomTile paramStatusBarPanelCustomTile)
  {
    zzgzq = paramList;
    zzhyi = paramBoolean1;
    zzhyj = paramBoolean2;
    zzhyk = paramStatusBarPanelCustomTile;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.save(paramParcel, 1, Collections.unmodifiableList(zzgzq), false);
    zzbcn.onAction(paramParcel, 2, zzhyi);
    zzbcn.onAction(paramParcel, 3, zzhyj);
    zzbcn.addMenuItem(paramParcel, 5, zzhyk, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
  
  public final class Builder
  {
    public boolean zzhyi = false;
    public boolean zzhyj = false;
    public StatusBarPanelCustomTile zzhyk = null;
    public final ArrayList<com.google.android.gms.location.LocationRequest> zzhyl = new ArrayList();
    
    public Builder() {}
    
    public final Builder addAllLocationRequests(Collection paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        LocationRequest localLocationRequest = (LocationRequest)paramCollection.next();
        if (localLocationRequest != null) {
          zzhyl.add(localLocationRequest);
        }
      }
      return this;
    }
    
    public final Builder addLocationRequest(LocationRequest paramLocationRequest)
    {
      if (paramLocationRequest != null) {
        zzhyl.add(paramLocationRequest);
      }
      return this;
    }
    
    public final LocationSettingsRequest build()
    {
      return new LocationSettingsRequest(zzhyl, zzhyi, zzhyj, null);
    }
    
    public final Builder setAlwaysShow(boolean paramBoolean)
    {
      zzhyi = paramBoolean;
      return this;
    }
    
    public final Builder setNeedBle(boolean paramBoolean)
    {
      zzhyj = paramBoolean;
      return this;
    }
  }
}
