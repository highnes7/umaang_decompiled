package com.google.android.android.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;

public class AccountChangeEventsRequest
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.auth.AccountChangeEventsRequest> CREATOR = new DownloadProgressInfo.1();
  public int mVersion;
  public Account zzduz;
  @Deprecated
  public String zzdxf;
  public int zzdxh;
  
  public AccountChangeEventsRequest()
  {
    mVersion = 1;
  }
  
  public AccountChangeEventsRequest(int paramInt1, int paramInt2, String paramString, Account paramAccount)
  {
    mVersion = paramInt1;
    zzdxh = paramInt2;
    zzdxf = paramString;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString)))
    {
      zzduz = new Account(paramString, "com.google");
      return;
    }
    zzduz = paramAccount;
  }
  
  public Account getAccount()
  {
    return zzduz;
  }
  
  public String getAccountName()
  {
    return zzdxf;
  }
  
  public int getEventIndex()
  {
    return zzdxh;
  }
  
  public AccountChangeEventsRequest setAccount(Account paramAccount)
  {
    zzduz = paramAccount;
    return this;
  }
  
  public AccountChangeEventsRequest setAccountName(String paramString)
  {
    zzdxf = paramString;
    return this;
  }
  
  public AccountChangeEventsRequest setEventIndex(int paramInt)
  {
    zzdxh = paramInt;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, mVersion);
    zzbcn.setCustomVar(paramParcel, 2, zzdxh);
    zzbcn.append(paramParcel, 3, zzdxf, false);
    zzbcn.addMenuItem(paramParcel, 4, zzduz, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
}
