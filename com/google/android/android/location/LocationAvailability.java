package com.google.android.android.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.util.Arrays;

public final class LocationAvailability
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.location.LocationAvailability> CREATOR = new Point.1();
  @Deprecated
  public int zzhxs;
  @Deprecated
  public int zzhxt;
  public long zzhxu;
  public int zzhxv;
  public StorageVolume[] zzhxw;
  
  public LocationAvailability(int paramInt1, int paramInt2, int paramInt3, long paramLong, StorageVolume[] paramArrayOfStorageVolume)
  {
    zzhxv = paramInt1;
    zzhxs = paramInt2;
    zzhxt = paramInt3;
    zzhxu = paramLong;
    zzhxw = paramArrayOfStorageVolume;
  }
  
  public static LocationAvailability extractLocationAvailability(Intent paramIntent)
  {
    if (!hasLocationAvailability(paramIntent)) {
      return null;
    }
    return (LocationAvailability)paramIntent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
  }
  
  public static boolean hasLocationAvailability(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (com.google.android.gms.location.LocationAvailability.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (LocationAvailability)paramObject;
      if ((zzhxs == zzhxs) && (zzhxt == zzhxt) && (zzhxu == zzhxu) && (zzhxv == zzhxv) && (Arrays.equals(zzhxw, zzhxw))) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(zzhxv), Integer.valueOf(zzhxs), Integer.valueOf(zzhxt), Long.valueOf(zzhxu), zzhxw });
  }
  
  public final boolean isLocationAvailable()
  {
    return zzhxv < 1000;
  }
  
  public final String toString()
  {
    boolean bool = isLocationAvailable();
    StringBuilder localStringBuilder = new StringBuilder(48);
    localStringBuilder.append("LocationAvailability[isLocationAvailable: ");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzhxs);
    zzbcn.setCustomVar(paramParcel, 2, zzhxt);
    zzbcn.writeHeader(paramParcel, 3, zzhxu);
    zzbcn.setCustomVar(paramParcel, 4, zzhxv);
    zzbcn.writeHeader(paramParcel, 5, zzhxw, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
