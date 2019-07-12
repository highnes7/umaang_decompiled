package com.google.android.android.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.util.Arrays;
import java.util.Comparator;

public class DetectedActivity
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.location.DetectedActivity> CREATOR = new VerticalProgressBar.SavedState.1();
  public static final int IN_VEHICLE = 0;
  public static final int ON_BICYCLE = 1;
  public static final int ON_FOOT = 2;
  public static final int RUNNING = 8;
  public static final int STILL = 3;
  public static final int TILTING = 5;
  public static final int UNKNOWN = 4;
  public static final int WALKING = 7;
  public static Comparator<com.google.android.gms.location.DetectedActivity> zzhwy = new BackendFuser.LocationComparator();
  public static int[] zzhwz = { 9, 10 };
  public static int[] zzhxa = { 0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17 };
  public int zzhxb;
  public int zzhxc;
  
  public DetectedActivity(int paramInt1, int paramInt2)
  {
    zzhxb = paramInt1;
    zzhxc = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (com.google.android.gms.location.DetectedActivity.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (DetectedActivity)paramObject;
      if ((zzhxb == zzhxb) && (zzhxc == zzhxc)) {
        return true;
      }
    }
    return false;
  }
  
  public int getConfidence()
  {
    return zzhxc;
  }
  
  public int getType()
  {
    int i = zzhxb;
    if (i > 17) {
      return 4;
    }
    return i;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(zzhxb), Integer.valueOf(zzhxc) });
  }
  
  public String toString()
  {
    int i = getType();
    String str;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                if (i != 7)
                {
                  if (i != 8)
                  {
                    if (i != 16)
                    {
                      if (i != 17) {
                        str = Integer.toString(i);
                      } else {
                        str = "IN_RAIL_VEHICLE";
                      }
                    }
                    else {
                      str = "IN_ROAD_VEHICLE";
                    }
                  }
                  else {
                    str = "RUNNING";
                  }
                }
                else {
                  str = "WALKING";
                }
              }
              else {
                str = "TILTING";
              }
            }
            else {
              str = "UNKNOWN";
            }
          }
          else {
            str = "STILL";
          }
        }
        else {
          str = "ON_FOOT";
        }
      }
      else {
        str = "ON_BICYCLE";
      }
    }
    else {
      str = "IN_VEHICLE";
    }
    i = zzhxc;
    StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, 48));
    localStringBuilder.append("DetectedActivity [type=");
    localStringBuilder.append(str);
    localStringBuilder.append(", confidence=");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzhxb);
    zzbcn.setCustomVar(paramParcel, 2, zzhxc);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
