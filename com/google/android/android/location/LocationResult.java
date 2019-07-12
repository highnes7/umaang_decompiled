package com.google.android.android.location;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.location.LocationResult> CREATOR = new AddressAndLabel.1();
  public static final List<Location> zzhyc = ;
  public final List<Location> zzhyd;
  
  public LocationResult(List paramList)
  {
    zzhyd = paramList;
  }
  
  public static LocationResult create(List paramList)
  {
    List localList = paramList;
    if (paramList == null) {
      localList = zzhyc;
    }
    return new LocationResult(localList);
  }
  
  public static LocationResult extractResult(Intent paramIntent)
  {
    if (!hasResult(paramIntent)) {
      return null;
    }
    return (LocationResult)paramIntent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
  }
  
  public static boolean hasResult(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationResult)) {
      return false;
    }
    paramObject = (LocationResult)paramObject;
    if (zzhyd.size() != zzhyd.size()) {
      return false;
    }
    paramObject = zzhyd.iterator();
    Iterator localIterator = zzhyd.iterator();
    while (paramObject.hasNext())
    {
      Location localLocation1 = (Location)localIterator.next();
      Location localLocation2 = (Location)paramObject.next();
      if (localLocation1.getTime() != localLocation2.getTime()) {
        return false;
      }
    }
    return true;
  }
  
  public final Location getLastLocation()
  {
    int i = zzhyd.size();
    if (i == 0) {
      return null;
    }
    return (Location)zzhyd.get(i - 1);
  }
  
  public final List getLocations()
  {
    return zzhyd;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = zzhyd.iterator();
    long l;
    for (int i = 17; localIterator.hasNext(); i = i * 31 + (int)(l ^ l >>> 32)) {
      l = ((Location)localIterator.next()).getTime();
    }
    return i;
  }
  
  public final String toString()
  {
    String str = String.valueOf(zzhyd);
    return StringBuilder.append(str.length() + 27, "LocationResult[locations: ", str, "]");
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.save(paramParcel, 1, getLocations(), false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
