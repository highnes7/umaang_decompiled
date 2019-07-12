package com.google.android.android.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.auth.dashclock.signin.GoogleSignInAccount;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;

public final class zzbq
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.common.internal.zzbq> CREATOR = new zzbr();
  public final Account zzduz;
  public int zzdxs;
  public final int zzfvx;
  public final GoogleSignInAccount zzfvy;
  
  public zzbq(int paramInt1, Account paramAccount, int paramInt2, GoogleSignInAccount paramGoogleSignInAccount)
  {
    zzdxs = paramInt1;
    zzduz = paramAccount;
    zzfvx = paramInt2;
    zzfvy = paramGoogleSignInAccount;
  }
  
  public zzbq(Account paramAccount, int paramInt, GoogleSignInAccount paramGoogleSignInAccount)
  {
    this(2, paramAccount, paramInt, paramGoogleSignInAccount);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.addMenuItem(paramParcel, 2, zzduz, paramInt, false);
    zzbcn.setCustomVar(paramParcel, 3, zzfvx);
    zzbcn.addMenuItem(paramParcel, 4, zzfvy, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
