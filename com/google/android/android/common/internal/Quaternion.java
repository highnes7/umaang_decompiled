package com.google.android.android.common.internal;

import android.accounts.Account;
import b.b.x.n.d;
import com.google.android.android.internal.zzcpt;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import support.android.v4.util.NodeList;

public final class Quaternion
{
  public Account zzduz;
  public String zzdxc;
  public int zzfhd = 0;
  public String zzfhf;
  public zzcpt zzftt = zzcpt.zzjno;
  public d<Scope> zzftv;
  
  public Quaternion() {}
  
  public final Quaternion add(Account paramAccount)
  {
    zzduz = paramAccount;
    return this;
  }
  
  public final Quaternion set(Collection paramCollection)
  {
    if (zzftv == null) {
      zzftv = new NodeList(0);
    }
    zzftv.addAll(paramCollection);
    return this;
  }
  
  public final AccountInformation zzajz()
  {
    return new AccountInformation(zzduz, zzftv, null, 0, null, zzdxc, zzfhf, zzftt);
  }
  
  public final Quaternion zzfz(String paramString)
  {
    zzdxc = paramString;
    return this;
  }
  
  public final Quaternion zzga(String paramString)
  {
    zzfhf = paramString;
    return this;
  }
}
