package com.google.android.android.auth.dashclock.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;

public final class SignInConfiguration
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.signin.internal.SignInConfiguration> CREATOR = new DiscreteSeekBar.CustomState.1();
  public final String zzedc;
  public GoogleSignInOptions zzedd;
  
  public SignInConfiguration(String paramString, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzbp.zzgg(paramString);
    zzedc = paramString;
    zzedd = paramGoogleSignInOptions;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      paramObject = (SignInConfiguration)paramObject;
      Object localObject = zzedc;
      String str = zzedc;
      boolean bool = ((String)localObject).equals(str);
      if (bool)
      {
        if (zzedd == null)
        {
          if (zzedd != null) {
            break label75;
          }
        }
        else
        {
          localObject = zzedd;
          paramObject = zzedd;
          bool = ((GoogleSignInOptions)localObject).equals(paramObject);
          if (!bool) {
            break label75;
          }
        }
        return true;
      }
      else
      {
        return false;
      }
    }
    catch (ClassCastException paramObject) {}
    label75:
    return false;
  }
  
  public final int hashCode()
  {
    return new IonBitmapRequestBuilder().transform(zzedc).transform(zzedd).zzaao();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.append(paramParcel, 2, zzedc, false);
    zzbcn.addMenuItem(paramParcel, 5, zzedd, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
  
  public final GoogleSignInOptions zzaaq()
  {
    return zzedd;
  }
}
