package com.google.android.android.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.common.internal.zzbf;
import com.google.android.android.common.internal.zzbh;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.util.Arrays;

public class PlaceReport
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.location.places.PlaceReport> CREATOR = new VerticalProgressBar.SavedState.1();
  public final String mTag;
  public final String zzdme;
  public int zzdxs;
  public final String zzibj;
  
  public PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    zzdxs = paramInt;
    zzibj = paramString1;
    mTag = paramString2;
    zzdme = paramString3;
  }
  
  public static PlaceReport create(String paramString1, String paramString2)
  {
    zzbp.append(paramString1);
    zzbp.zzgg(paramString2);
    zzbp.zzgg("unknown");
    int i = "unknown".hashCode();
    boolean bool = false;
    switch (i)
    {
    default: 
      break;
    case -284840886: 
      i = 0;
      break;
    }
    i = -1;
    if ((i == 0) || (i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5)) {
      bool = true;
    }
    zzbp.get(bool, "Invalid source");
    return new PlaceReport(1, paramString1, paramString2, "unknown");
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlaceReport)) {
      return false;
    }
    paramObject = (PlaceReport)paramObject;
    return (zzbf.equal(zzibj, zzibj)) && (zzbf.equal(mTag, mTag)) && (zzbf.equal(zzdme, zzdme));
  }
  
  public String getPlaceId()
  {
    return zzibj;
  }
  
  public String getTag()
  {
    return mTag;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { zzibj, mTag, zzdme });
  }
  
  public String toString()
  {
    zzbh localZzbh = zzbf.peekPersisted(this);
    localZzbh.add("placeId", zzibj);
    localZzbh.add("tag", mTag);
    if (!"unknown".equals(zzdme)) {
      localZzbh.add("source", zzdme);
    }
    return localZzbh.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.append(paramParcel, 2, getPlaceId(), false);
    zzbcn.append(paramParcel, 3, getTag(), false);
    zzbcn.append(paramParcel, 4, zzdme, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
