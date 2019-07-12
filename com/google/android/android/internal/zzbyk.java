package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbf;

public final class zzbyk
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzbyk> CREATOR = new zzbyl();
  public String packageName;
  public int pid;
  
  public zzbyk(int paramInt, String paramString)
  {
    pid = paramInt;
    packageName = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject != null)
    {
      if (!(paramObject instanceof zzbyk)) {
        return false;
      }
      paramObject = (zzbyk)paramObject;
      if ((pid == pid) && (zzbf.equal(packageName, packageName))) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return pid;
  }
  
  public final String toString()
  {
    return String.format("%d:%s", new Object[] { Integer.valueOf(pid), packageName });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, pid);
    zzbcn.append(paramParcel, 2, packageName, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
