package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.location.Geofence;
import java.util.Locale;

public final class zzcac
  extends zzbck
  implements Geofence
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzcac> CREATOR = new zzcad();
  public final String zzcjw;
  public final int zzhxf;
  public final short zzhxh;
  public final double zzhxi;
  public final double zzhxj;
  public final float zzhxk;
  public final int zzhxl;
  public final int zzhxm;
  public final long zziaf;
  
  public zzcac(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
  {
    if ((paramString != null) && (paramString.length() <= 100))
    {
      if (paramFloat > 0.0F)
      {
        if ((paramDouble1 <= 90.0D) && (paramDouble1 >= -90.0D))
        {
          if ((paramDouble2 <= 180.0D) && (paramDouble2 >= -180.0D))
          {
            int i = paramInt1 & 0x7;
            if (i != 0)
            {
              zzhxh = paramShort;
              zzcjw = paramString;
              zzhxi = paramDouble1;
              zzhxj = paramDouble2;
              zzhxk = paramFloat;
              zziaf = paramLong;
              zzhxf = i;
              zzhxl = paramInt2;
              zzhxm = paramInt3;
              return;
            }
            throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(46, "No supported transition specified: ", paramInt1));
          }
          paramString = new StringBuilder(43);
          paramString.append("invalid longitude: ");
          paramString.append(paramDouble2);
          throw new IllegalArgumentException(paramString.toString());
        }
        paramString = new StringBuilder(42);
        paramString.append("invalid latitude: ");
        paramString.append(paramDouble1);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder(31);
      paramString.append("invalid radius: ");
      paramString.append(paramFloat);
      throw new IllegalArgumentException(paramString.toString());
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "requestId is null or too long: ".concat(paramString);
    } else {
      paramString = new String("requestId is null or too long: ");
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static zzcac obtain(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (zzcac)CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof zzcac)) {
      return false;
    }
    paramObject = (zzcac)paramObject;
    if (zzhxk != zzhxk) {
      return false;
    }
    if (zzhxi != zzhxi) {
      return false;
    }
    if (zzhxj != zzhxj) {
      return false;
    }
    return zzhxh == zzhxh;
  }
  
  public final String getRequestId()
  {
    return zzcjw;
  }
  
  public final int hashCode()
  {
    long l = Double.doubleToLongBits(zzhxi);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(zzhxj);
    int j = (int)(l ^ l >>> 32);
    return ((Float.floatToIntBits(zzhxk) + ((i + 31) * 31 + j) * 31) * 31 + zzhxh) * 31 + zzhxf;
  }
  
  public final String toString()
  {
    Locale localLocale = Locale.US;
    String str;
    if (zzhxh != 1) {
      str = null;
    } else {
      str = "CIRCLE";
    }
    return String.format(localLocale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { str, zzcjw, Integer.valueOf(zzhxf), Double.valueOf(zzhxi), Double.valueOf(zzhxj), Float.valueOf(zzhxk), Integer.valueOf(zzhxl / 1000), Integer.valueOf(zzhxm), Long.valueOf(zziaf) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.append(paramParcel, 1, getRequestId(), false);
    zzbcn.writeHeader(paramParcel, 2, zziaf);
    zzbcn.writeValue(paramParcel, 3, zzhxh);
    zzbcn.writeDouble(paramParcel, 4, zzhxi);
    zzbcn.writeDouble(paramParcel, 5, zzhxj);
    zzbcn.set(paramParcel, 6, zzhxk);
    zzbcn.setCustomVar(paramParcel, 7, zzhxf);
    zzbcn.setCustomVar(paramParcel, 8, zzhxl);
    zzbcn.setCustomVar(paramParcel, 9, zzhxm);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
