package com.google.android.android.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.android.common.GoogleApiAvailability;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.internal.zzcpp;
import com.google.android.android.internal.zzcpt;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import support.android.v4.util.ArrayMap;

public final class AccountInformation
{
  public final Account zzduz;
  public final String zzdxc;
  public final Set<Scope> zzfhb;
  public final int zzfhd;
  public final View zzfhe;
  public final String zzfhf;
  public final Set<Scope> zzftr;
  public final Map<Api<?>, zzs> zzfts;
  public final zzcpt zzftt;
  public Integer zzftu;
  
  public AccountInformation(Account paramAccount, Set paramSet, Map paramMap, int paramInt, View paramView, String paramString1, String paramString2, zzcpt paramZzcpt)
  {
    zzduz = paramAccount;
    if (paramSet == null) {
      paramAccount = Collections.EMPTY_SET;
    } else {
      paramAccount = Collections.unmodifiableSet(paramSet);
    }
    zzfhb = paramAccount;
    paramAccount = paramMap;
    if (paramMap == null) {
      paramAccount = Collections.EMPTY_MAP;
    }
    zzfts = paramAccount;
    zzfhe = paramView;
    zzfhd = paramInt;
    zzdxc = paramString1;
    zzfhf = paramString2;
    zzftt = paramZzcpt;
    paramAccount = new HashSet(zzfhb);
    paramSet = zzfts.values().iterator();
    while (paramSet.hasNext()) {
      paramAccount.addAll(nextzzecm);
    }
    zzftr = Collections.unmodifiableSet(paramAccount);
  }
  
  public static AccountInformation zzcc(Context paramContext)
  {
    HashSet localHashSet = new HashSet();
    new HashSet();
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    Object localObject = GoogleApiAvailability.zzffi;
    localObject = zzcpp.zzdwq;
    new ArrayList();
    new ArrayList();
    paramContext.getMainLooper();
    localObject = paramContext.getPackageName();
    String str = paramContext.getClass().getName();
    paramContext = zzcpt.zzjno;
    if (localArrayMap2.containsKey(zzcpp.CURSOR_POSITION)) {
      paramContext = (zzcpt)localArrayMap2.get(zzcpp.CURSOR_POSITION);
    }
    return new AccountInformation(null, localHashSet, localArrayMap1, 0, null, (String)localObject, str, paramContext);
  }
  
  public final Set find(Sample paramSample)
  {
    paramSample = (Service)zzfts.get(paramSample);
    if ((paramSample != null) && (!zzecm.isEmpty()))
    {
      HashSet localHashSet = new HashSet(zzfhb);
      localHashSet.addAll(zzecm);
      return localHashSet;
    }
    return zzfhb;
  }
  
  public final Account getAccount()
  {
    return zzduz;
  }
  
  public final String getAccountName()
  {
    Account localAccount = zzduz;
    if (localAccount != null) {
      return name;
    }
    return null;
  }
  
  public final void setUserId(Integer paramInteger)
  {
    zzftu = paramInteger;
  }
  
  public final Account zzajp()
  {
    Account localAccount = zzduz;
    if (localAccount != null) {
      return localAccount;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  public final int zzajq()
  {
    return zzfhd;
  }
  
  public final Set zzajr()
  {
    return zzfhb;
  }
  
  public final Set zzajs()
  {
    return zzftr;
  }
  
  public final Map zzajt()
  {
    return zzfts;
  }
  
  public final String zzaju()
  {
    return zzdxc;
  }
  
  public final String zzajv()
  {
    return zzfhf;
  }
  
  public final View zzajw()
  {
    return zzfhe;
  }
  
  public final zzcpt zzajx()
  {
    return zzftt;
  }
  
  public final Integer zzajy()
  {
    return zzftu;
  }
}
