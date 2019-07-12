package com.google.android.android.auth.dashclock.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import b.b.a.F;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;

public final class IdToken
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.credentials.IdToken> CREATOR = new Point.1();
  @F
  public final String zzdzr;
  @F
  public final String zzeaw;
  
  public IdToken(String paramString1, String paramString2)
  {
    zzbp.get(TextUtils.isEmpty(paramString1) ^ true, "account type string cannot be null or empty");
    zzbp.get(TextUtils.isEmpty(paramString2) ^ true, "id token string cannot be null or empty");
    zzdzr = paramString1;
    zzeaw = paramString2;
  }
  
  public final String getAccountType()
  {
    return zzdzr;
  }
  
  public final String getIdToken()
  {
    return zzeaw;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.append(paramParcel, 1, getAccountType(), false);
    zzbcn.append(paramParcel, 2, getIdToken(), false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
