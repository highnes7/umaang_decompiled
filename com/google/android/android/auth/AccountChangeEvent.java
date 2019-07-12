package com.google.android.android.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbf;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.util.Arrays;

public class AccountChangeEvent
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.auth.AccountChangeEvent> CREATOR = new VerticalProgressBar.SavedState.1();
  public int mVersion;
  public long zzdxe;
  public String zzdxf;
  public int zzdxg;
  public int zzdxh;
  public String zzdxi;
  
  public AccountChangeEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    mVersion = paramInt1;
    zzdxe = paramLong;
    zzbp.append(paramString1);
    zzdxf = ((String)paramString1);
    zzdxg = paramInt2;
    zzdxh = paramInt3;
    zzdxi = paramString2;
  }
  
  public AccountChangeEvent(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    mVersion = 1;
    zzdxe = paramLong;
    zzbp.append(paramString1);
    zzdxf = ((String)paramString1);
    zzdxg = paramInt1;
    zzdxh = paramInt2;
    zzdxi = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof AccountChangeEvent))
    {
      paramObject = (AccountChangeEvent)paramObject;
      if ((mVersion == mVersion) && (zzdxe == zzdxe) && (zzbf.equal(zzdxf, zzdxf)) && (zzdxg == zzdxg) && (zzdxh == zzdxh) && (zzbf.equal(zzdxi, zzdxi))) {
        return true;
      }
    }
    return false;
  }
  
  public String getAccountName()
  {
    return zzdxf;
  }
  
  public String getChangeData()
  {
    return zzdxi;
  }
  
  public int getChangeType()
  {
    return zzdxg;
  }
  
  public int getEventIndex()
  {
    return zzdxh;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(mVersion), Long.valueOf(zzdxe), zzdxf, Integer.valueOf(zzdxg), Integer.valueOf(zzdxh), zzdxi });
  }
  
  public String toString()
  {
    int i = zzdxg;
    String str1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            str1 = "UNKNOWN";
          } else {
            str1 = "RENAMED_TO";
          }
        }
        else {
          str1 = "RENAMED_FROM";
        }
      }
      else {
        str1 = "REMOVED";
      }
    }
    else {
      str1 = "ADDED";
    }
    String str2 = zzdxf;
    String str3 = zzdxi;
    i = zzdxh;
    int j = f.sufficientlysecure.rootcommands.util.StringBuilder.append(str2, 91);
    StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str3, str1.length() + j));
    localStringBuilder.append("AccountChangeEvent {accountName = ");
    localStringBuilder.append(str2);
    localStringBuilder.append(", changeType = ");
    localStringBuilder.append(str1);
    localStringBuilder.append(", changeData = ");
    localStringBuilder.append(str3);
    localStringBuilder.append(", eventIndex = ");
    localStringBuilder.append(i);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, mVersion);
    zzbcn.writeHeader(paramParcel, 2, zzdxe);
    zzbcn.append(paramParcel, 3, zzdxf, false);
    zzbcn.setCustomVar(paramParcel, 4, zzdxg);
    zzbcn.setCustomVar(paramParcel, 5, zzdxh);
    zzbcn.append(paramParcel, 6, zzdxi, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
