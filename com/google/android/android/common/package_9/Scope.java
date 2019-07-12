package com.google.android.android.common.package_9;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;

public final class Scope
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.common.api.Scope> CREATOR = new Server.1();
  public int zzdxs;
  public final String zzfhu;
  
  public Scope(int paramInt, String paramString)
  {
    zzbp.format(paramString, "scopeUri must not be null or empty");
    zzdxs = paramInt;
    zzfhu = paramString;
  }
  
  public Scope(String paramString)
  {
    this(1, paramString);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Scope)) {
      return false;
    }
    return zzfhu.equals(zzfhu);
  }
  
  public final int hashCode()
  {
    return zzfhu.hashCode();
  }
  
  public final String toString()
  {
    return zzfhu;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.append(paramParcel, 2, zzfhu, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
  
  public final String zzaft()
  {
    return zzfhu;
  }
}
