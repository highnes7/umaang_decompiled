package com.google.android.android.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.Language;
import com.google.android.android.common.PingManager;
import com.google.android.android.common.package_9.Scope;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.common.internal.zzy;

public final class CommandResult
  extends zzbck
{
  public static final Parcelable.Creator<zzy> CREATOR = new VerticalProgressBar.SavedState.1();
  public int version = 3;
  public int zzfuc;
  public int zzfud = PingManager.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  public String zzfue;
  public IBinder zzfuf;
  public Scope[] zzfug;
  public Bundle zzfuh;
  public Account zzfui;
  public Language[] zzfuj;
  
  public CommandResult(int paramInt)
  {
    zzfuc = paramInt;
  }
  
  public CommandResult(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount, Language[] paramArrayOfLanguage) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, version);
    zzbcn.setCustomVar(paramParcel, 2, zzfuc);
    zzbcn.setCustomVar(paramParcel, 3, zzfud);
    zzbcn.append(paramParcel, 4, zzfue, false);
    zzbcn.writeString(paramParcel, 5, zzfuf, false);
    zzbcn.writeHeader(paramParcel, 6, zzfug, paramInt, false);
    zzbcn.writeString(paramParcel, 7, zzfuh, false);
    zzbcn.addMenuItem(paramParcel, 8, zzfui, paramInt, false);
    zzbcn.writeHeader(paramParcel, 10, zzfuj, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
