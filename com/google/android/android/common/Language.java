package com.google.android.android.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.common.zzc;

public final class Language
  extends zzbck
{
  public static final Parcelable.Creator<zzc> CREATOR = new VerticalProgressBar.SavedState.1();
  public String name;
  public int version;
  
  public Language(String paramString, int paramInt)
  {
    name = paramString;
    version = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.append(paramParcel, 1, name, false);
    zzbcn.setCustomVar(paramParcel, 2, version);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
