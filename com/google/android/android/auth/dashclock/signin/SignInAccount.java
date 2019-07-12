package com.google.android.android.auth.dashclock.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;

public class SignInAccount
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.signin.SignInAccount> CREATOR = new DiscreteSeekBar.CustomState.1();
  @Deprecated
  public String zzdmy;
  @Deprecated
  public String zzebw;
  public GoogleSignInAccount zzecp;
  
  public SignInAccount(String paramString1, GoogleSignInAccount paramGoogleSignInAccount, String paramString2)
  {
    zzecp = paramGoogleSignInAccount;
    zzbp.format(paramString1, "8.3 and 8.4 SDKs require non-null email");
    zzebw = paramString1;
    zzbp.format(paramString2, "8.3 and 8.4 SDKs require non-null userId");
    zzdmy = paramString2;
  }
  
  public final GoogleSignInAccount getGoogleSignInAccount()
  {
    return zzecp;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.append(paramParcel, 4, zzebw, false);
    zzbcn.addMenuItem(paramParcel, 7, zzecp, paramInt, false);
    zzbcn.append(paramParcel, 8, zzdmy, false);
    zzbcn.zzah(paramParcel, i);
  }
}
