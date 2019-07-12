package com.google.android.android.internal;

import android.accounts.Account;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.common.package_9.internal.Log;

public final class zzarb
  extends zzare
{
  public zzarb(zzara paramZzara) {}
  
  public final void startSession(Account paramAccount)
  {
    zzara localZzara = zzdya;
    Status localStatus;
    if (paramAccount != null) {
      localStatus = Status.zzfhv;
    } else {
      localStatus = zzaqy.zzdxz;
    }
    localZzara.setResult(new zzarf(localStatus, paramAccount));
  }
}
