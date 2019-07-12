package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbp;

public final class zzcft
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzcft> CREATOR = new zzcfu();
  public final String name;
  public int versionCode;
  public String zzfwo;
  public final String zzimg;
  public final long zziwz;
  public Long zzixa;
  public Float zzixb;
  public Double zzixc;
  
  public zzcft(int paramInt, String paramString1, long paramLong, Long paramLong1, Float paramFloat, String paramString2, String paramString3, Double paramDouble)
  {
    versionCode = paramInt;
    name = paramString1;
    zziwz = paramLong;
    zzixa = paramLong1;
    paramString1 = null;
    zzixb = null;
    if (paramInt == 1)
    {
      if (paramFloat != null) {
        paramString1 = Double.valueOf(paramFloat.doubleValue());
      }
      zzixc = paramString1;
    }
    else
    {
      zzixc = paramDouble;
    }
    zzfwo = paramString2;
    zzimg = paramString3;
  }
  
  public zzcft(zzcfv paramZzcfv)
  {
    this(mName, zzixd, mValue, mOrigin);
  }
  
  public zzcft(String paramString1, long paramLong, Object paramObject, String paramString2)
  {
    zzbp.zzgg(paramString1);
    versionCode = 2;
    name = paramString1;
    zziwz = paramLong;
    zzimg = paramString2;
    if (paramObject == null)
    {
      zzixa = null;
      zzixb = null;
      zzixc = null;
      zzfwo = null;
      return;
    }
    if ((paramObject instanceof Long))
    {
      zzixa = ((Long)paramObject);
      zzixb = null;
      zzixc = null;
      zzfwo = null;
      return;
    }
    if ((paramObject instanceof String))
    {
      zzixa = null;
      zzixb = null;
      zzixc = null;
      zzfwo = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      zzixa = null;
      zzixb = null;
      zzixc = ((Double)paramObject);
      zzfwo = null;
      return;
    }
    throw new IllegalArgumentException("User attribute given of un-supported type");
  }
  
  public final Object getValue()
  {
    Object localObject = zzixa;
    if (localObject != null) {
      return localObject;
    }
    localObject = zzixc;
    if (localObject != null) {
      return localObject;
    }
    localObject = zzfwo;
    if (localObject != null) {
      return localObject;
    }
    return null;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, versionCode);
    zzbcn.append(paramParcel, 2, name, false);
    zzbcn.writeHeader(paramParcel, 3, zziwz);
    zzbcn.writeValue(paramParcel, 4, zzixa, false);
    zzbcn.writeValue(paramParcel, 5, null, false);
    zzbcn.append(paramParcel, 6, zzfwo, false);
    zzbcn.append(paramParcel, 7, zzimg, false);
    zzbcn.writeValue(paramParcel, 8, zzixc, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
