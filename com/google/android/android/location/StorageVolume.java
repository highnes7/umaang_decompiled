package com.google.android.android.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.location.zzy;
import java.util.Arrays;

public final class StorageVolume
  extends zzbck
{
  public static final Parcelable.Creator<zzy> CREATOR = new SpecialListsListNameProperty.1();
  public int zzhyt;
  public int zzhyu;
  public long zzhyv;
  public long zzhyw;
  
  public StorageVolume(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    zzhyt = paramInt1;
    zzhyu = paramInt2;
    zzhyv = paramLong1;
    zzhyw = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (zzy.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (StorageVolume)paramObject;
      if ((zzhyt == zzhyt) && (zzhyu == zzhyu) && (zzhyv == zzhyv) && (zzhyw == zzhyw)) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(zzhyu), Integer.valueOf(zzhyt), Long.valueOf(zzhyw), Long.valueOf(zzhyv) });
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NetworkLocationStatus:");
    localStringBuilder.append(" Wifi status: ");
    localStringBuilder.append(zzhyt);
    localStringBuilder.append(" Cell status: ");
    localStringBuilder.append(zzhyu);
    localStringBuilder.append(" elapsed time NS: ");
    localStringBuilder.append(zzhyw);
    localStringBuilder.append(" system time ms: ");
    localStringBuilder.append(zzhyv);
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzhyt);
    zzbcn.setCustomVar(paramParcel, 2, zzhyu);
    zzbcn.writeHeader(paramParcel, 3, zzhyv);
    zzbcn.writeHeader(paramParcel, 4, zzhyw);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
