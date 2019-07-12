package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.auth.dashclock.credentials.Credential;

public final class zzasw
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzasw> CREATOR = new zzasx();
  public final Credential zzebg;
  
  public zzasw(Credential paramCredential)
  {
    zzebg = paramCredential;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.addMenuItem(paramParcel, 1, zzebg, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
