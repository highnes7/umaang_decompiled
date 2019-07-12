package com.google.android.android.auth.dashclock.accounttransfer;

import android.app.Activity;
import android.content.Context;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.internal.zzarp;
import com.google.android.gms.auth.api.accounttransfer.zzo;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.internal.zzarq;

public final class AccountTransfer
{
  public static final String ACTION_ACCOUNT_EXPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_EXPORT_DATA_AVAILABLE";
  public static final String ACTION_ACCOUNT_IMPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_IMPORT_DATA_AVAILABLE";
  public static final String ACTION_START_ACCOUNT_EXPORT = "com.google.android.gms.auth.START_ACCOUNT_EXPORT";
  public static final com.google.android.gms.common.api.Api.zzf<zzarq> zzdyp = new com.google.android.android.common.package_9.Api.zzf();
  public static final Api.zza<zzarq, zzo> zzdyq = new Note();
  public static Api<zzo> zzdyr = new Sample("AccountTransfer.ACCOUNT_TRANSFER_API", zzdyq, zzdyp);
  @Deprecated
  public static DiskBasedCache zzdys = (DiskBasedCache)new zzarp();
  public static DecoderFactory zzdyt = (DecoderFactory)new zzarp();
  
  public AccountTransfer() {}
  
  public static AccountTransferClient getAccountTransferClient(Activity paramActivity)
  {
    return new AccountTransferClient(paramActivity);
  }
  
  public static AccountTransferClient getAccountTransferClient(Context paramContext)
  {
    return new AccountTransferClient(paramContext);
  }
}
