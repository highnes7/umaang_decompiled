package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import b.b.a.G;
import com.google.android.android.common.internal.zzbf;
import com.google.android.android.location.LocationRequest;
import com.google.android.gms.internal.zzbyk;
import java.util.Collections;
import java.util.List;

public final class zzbzy
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzbzy> CREATOR = new zzbzz();
  public static final List<zzbyk> zzhzu = ;
  @G
  public String mTag;
  @G
  public String zzeft;
  public LocationRequest zzgzt;
  public List<zzbyk> zzhzv;
  public boolean zzhzw;
  public boolean zzhzx;
  public boolean zzhzy;
  public boolean zzhzz = true;
  
  public zzbzy(LocationRequest paramLocationRequest, List paramList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    zzgzt = paramLocationRequest;
    zzhzv = paramList;
    mTag = paramString1;
    zzhzw = paramBoolean1;
    zzhzx = paramBoolean2;
    zzhzy = paramBoolean3;
    zzeft = paramString2;
  }
  
  public static zzbzy getSimpleName(LocationRequest paramLocationRequest)
  {
    return new zzbzy(paramLocationRequest, zzhzu, null, false, false, false, null);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzbzy)) {
      return false;
    }
    paramObject = (zzbzy)paramObject;
    return (zzbf.equal(zzgzt, zzgzt)) && (zzbf.equal(zzhzv, zzhzv)) && (zzbf.equal(mTag, mTag)) && (zzhzw == zzhzw) && (zzhzx == zzhzx) && (zzhzy == zzhzy) && (zzbf.equal(zzeft, zzeft));
  }
  
  public final int hashCode()
  {
    return zzgzt.hashCode();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(zzgzt.toString());
    if (mTag != null)
    {
      localStringBuilder.append(" tag=");
      localStringBuilder.append(mTag);
    }
    if (zzeft != null)
    {
      localStringBuilder.append(" moduleId=");
      localStringBuilder.append(zzeft);
    }
    localStringBuilder.append(" hideAppOps=");
    localStringBuilder.append(zzhzw);
    localStringBuilder.append(" clients=");
    localStringBuilder.append(zzhzv);
    localStringBuilder.append(" forceCoarseLocation=");
    localStringBuilder.append(zzhzx);
    if (zzhzy) {
      localStringBuilder.append(" exemptFromBackgroundThrottle");
    }
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.addMenuItem(paramParcel, 1, zzgzt, paramInt, false);
    zzbcn.save(paramParcel, 5, zzhzv, false);
    zzbcn.append(paramParcel, 6, mTag, false);
    zzbcn.onAction(paramParcel, 7, zzhzw);
    zzbcn.onAction(paramParcel, 8, zzhzx);
    zzbcn.onAction(paramParcel, 9, zzhzy);
    zzbcn.append(paramParcel, 10, zzeft, false);
    zzbcn.zzah(paramParcel, i);
  }
}
