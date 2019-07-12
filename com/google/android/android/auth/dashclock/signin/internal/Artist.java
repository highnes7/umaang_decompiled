package com.google.android.android.auth.dashclock.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptionsExtension;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.auth.api.signin.internal.zzn;

public final class Artist
  extends zzbck
{
  public static final Parcelable.Creator<zzn> CREATOR = new VerticalProgressBar.SavedState.1();
  public Bundle mBundle;
  public int versionCode;
  public int zzecz;
  
  public Artist(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    versionCode = paramInt1;
    zzecz = paramInt2;
    mBundle = paramBundle;
  }
  
  public Artist(GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    this(1, 1, paramGoogleSignInOptionsExtension.toBundle());
  }
  
  public final int getType()
  {
    return zzecz;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, versionCode);
    zzbcn.setCustomVar(paramParcel, 2, zzecz);
    zzbcn.writeString(paramParcel, 3, mBundle, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
