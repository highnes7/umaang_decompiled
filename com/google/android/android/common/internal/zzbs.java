package com.google.android.android.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;

public final class zzbs
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.common.internal.zzbs> CREATOR = new zzbt();
  public int zzdxs;
  public ConnectionResult zzfiz;
  public boolean zzflu;
  public IBinder zzfvz;
  public boolean zzfwa;
  
  public zzbs(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    zzdxs = paramInt;
    zzfvz = paramIBinder;
    zzfiz = paramConnectionResult;
    zzflu = paramBoolean1;
    zzfwa = paramBoolean2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzbs)) {
      return false;
    }
    paramObject = (zzbs)paramObject;
    return (zzfiz.equals(zzfiz)) && (zzakl().equals(paramObject.zzakl()));
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.writeString(paramParcel, 2, zzfvz, false);
    zzbcn.addMenuItem(paramParcel, 3, zzfiz, paramInt, false);
    zzbcn.onAction(paramParcel, 4, zzflu);
    zzbcn.onAction(paramParcel, 5, zzfwa);
    zzbcn.zzah(paramParcel, i);
  }
  
  public final ConnectionResult zzagd()
  {
    return zzfiz;
  }
  
  public final zzam zzakl()
  {
    IBinder localIBinder = zzfvz;
    if (localIBinder == null) {
      return null;
    }
    IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
    if ((localIInterface instanceof zzam)) {
      return (zzam)localIInterface;
    }
    return new zzao(localIBinder);
  }
  
  public final boolean zzakm()
  {
    return zzflu;
  }
  
  public final boolean zzakn()
  {
    return zzfwa;
  }
}
