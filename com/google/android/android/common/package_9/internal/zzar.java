package com.google.android.android.common.package_9.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.PingManager;
import com.google.android.android.common.internal.AccountInformation;
import com.google.android.android.common.internal.Service;
import com.google.android.android.common.internal.zzam;
import com.google.android.android.common.internal.zzbs;
import com.google.android.android.common.package_9.Api.zzd;
import com.google.android.android.common.package_9.Api.zze;
import com.google.android.android.common.package_9.GoogleApiClient.ConnectionCallbacks;
import com.google.android.android.common.package_9.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.internal.zzcqf;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzcpt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class zzar
  implements zzbk
{
  public final Context mContext;
  public final com.google.android.gms.common.api.Api.zza<? extends com.google.android.gms.internal.zzcps, zzcpt> zzfhm;
  public final Lock zzfke;
  public final AccountInformation zzfkj;
  public final Map<Api<?>, Boolean> zzfkm;
  public final PingManager zzfko;
  public ConnectionResult zzfkx;
  public final zzbl zzflh;
  public int zzflk;
  public int zzfll = 0;
  public int zzflm;
  public final Bundle zzfln = new Bundle();
  public final Set<com.google.android.gms.common.api.Api.zzc> zzflo = new HashSet();
  public com.google.android.android.internal.zzcps zzflp;
  public boolean zzflq;
  public boolean zzflr;
  public boolean zzfls;
  public zzam zzflt;
  public boolean zzflu;
  public boolean zzflv;
  public ArrayList<Future<?>> zzflw = new ArrayList();
  
  public zzar(zzbl paramZzbl, AccountInformation paramAccountInformation, Map paramMap, PingManager paramPingManager, com.google.android.android.common.package_9.Api.zza paramZza, Lock paramLock, Context paramContext)
  {
    zzflh = paramZzbl;
    zzfkj = paramAccountInformation;
    zzfkm = paramMap;
    zzfko = paramPingManager;
    zzfhm = paramZza;
    zzfke = paramLock;
    mContext = paramContext;
  }
  
  private final void doSync(zzcqf paramZzcqf)
  {
    if (!zzbr(0)) {
      return;
    }
    Object localObject = paramZzcqf.zzagd();
    if (((ConnectionResult)localObject).isSuccess())
    {
      localObject = paramZzcqf.zzbcc();
      paramZzcqf = ((zzbs)localObject).zzagd();
      if (!paramZzcqf.isSuccess())
      {
        localObject = String.valueOf(paramZzcqf);
        StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 48);
        localStringBuilder.append("Sign-in succeeded with resolve account failure: ");
        localStringBuilder.append((String)localObject);
        Log.wtf("GoogleApiClientConnecting", localStringBuilder.toString(), new Exception());
        removeTask(paramZzcqf);
        return;
      }
      zzfls = true;
      zzflt = ((zzbs)localObject).zzakl();
      zzflu = ((zzbs)localObject).zzakm();
      zzflv = ((zzbs)localObject).zzakn();
      zzahb();
      return;
    }
    if (f((ConnectionResult)localObject))
    {
      zzahd();
      zzahb();
      return;
    }
    removeTask((ConnectionResult)localObject);
  }
  
  private final boolean f(ConnectionResult paramConnectionResult)
  {
    return (zzflq) && (!paramConnectionResult.hasResolution());
  }
  
  private final void launch(ConnectionResult paramConnectionResult, Sample paramSample, boolean paramBoolean)
  {
    int m = paramSample.zzafc().getPriority();
    int k = 0;
    int j;
    if (paramBoolean)
    {
      if (paramConnectionResult.hasResolution()) {}
      while (zzfko.zzbn(paramConnectionResult.getErrorCode()) != null)
      {
        i = 1;
        break;
      }
      int i = 0;
      j = k;
      if (i == 0) {}
    }
    else if (zzfkx != null)
    {
      j = k;
      if (m >= zzflk) {}
    }
    else
    {
      j = 1;
    }
    if (j != 0)
    {
      zzfkx = paramConnectionResult;
      zzflk = m;
    }
    zzflh.zzfnc.put(paramSample.zzafe(), paramConnectionResult);
  }
  
  private final void removeTask(ConnectionResult paramConnectionResult)
  {
    zzahe();
    zzbf(paramConnectionResult.hasResolution() ^ true);
    zzflh.wakeup(paramConnectionResult);
    zzflh.zzfng.removeTask(paramConnectionResult);
  }
  
  private final boolean zzaha()
  {
    zzflm -= 1;
    int i = zzflm;
    if (i > 0) {
      return false;
    }
    ConnectionResult localConnectionResult;
    if (i < 0)
    {
      zzflh.zzfju.zzahk();
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      localConnectionResult = new ConnectionResult(8, null);
    }
    for (;;)
    {
      removeTask(localConnectionResult);
      return false;
      localConnectionResult = zzfkx;
      if (localConnectionResult == null) {
        break;
      }
      zzflh.zzfnf = zzflk;
    }
    return true;
  }
  
  private final void zzahb()
  {
    if (zzflm != 0) {
      return;
    }
    if ((!zzflr) || (zzfls))
    {
      ArrayList localArrayList = new ArrayList();
      zzfll = 1;
      zzflm = zzflh.zzfmn.size();
      Iterator localIterator = zzflh.zzfmn.keySet().iterator();
      while (localIterator.hasNext())
      {
        com.google.android.android.common.package_9.Api.zzc localZzc = (com.google.android.android.common.package_9.Api.zzc)localIterator.next();
        if (zzflh.zzfnc.containsKey(localZzc))
        {
          if (zzaha()) {
            zzahc();
          }
        }
        else {
          localArrayList.add((Api.zze)zzflh.zzfmn.get(localZzc));
        }
      }
      if (!localArrayList.isEmpty()) {
        zzflw.add(zzbo.zzfnj.submit(new zzax(this, localArrayList)));
      }
    }
  }
  
  private final void zzahc()
  {
    zzflh.zzahm();
    zzbo.zzfnj.execute(new zzas(this));
    Object localObject = zzflp;
    if (localObject != null)
    {
      if (zzflu) {
        ((com.google.android.android.internal.zzcps)localObject).removeTask(zzflt, zzflv);
      }
      zzbf(false);
    }
    localObject = zzflh.zzfnc.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.google.android.android.common.package_9.Api.zzc localZzc = (com.google.android.android.common.package_9.Api.zzc)((Iterator)localObject).next();
      ((Api.zze)zzflh.zzfmn.get(localZzc)).disconnect();
    }
    if (zzfln.isEmpty()) {
      localObject = null;
    } else {
      localObject = zzfln;
    }
    zzflh.zzfng.removeTask((Bundle)localObject);
  }
  
  private final void zzahd()
  {
    zzflr = false;
    zzflh.zzfju.zzfmo = Collections.emptySet();
    Iterator localIterator = zzflo.iterator();
    while (localIterator.hasNext())
    {
      com.google.android.android.common.package_9.Api.zzc localZzc = (com.google.android.android.common.package_9.Api.zzc)localIterator.next();
      if (!zzflh.zzfnc.containsKey(localZzc)) {
        zzflh.zzfnc.put(localZzc, new ConnectionResult(17, null));
      }
    }
  }
  
  private final void zzahe()
  {
    ArrayList localArrayList = zzflw;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = localArrayList.get(i);
      i += 1;
      ((Future)localObject).cancel(true);
    }
    zzflw.clear();
  }
  
  private final Set zzahf()
  {
    Object localObject = zzfkj;
    if (localObject == null) {
      return Collections.emptySet();
    }
    localObject = new HashSet(((AccountInformation)localObject).zzajr());
    Map localMap = zzfkj.zzajt();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Sample localSample = (Sample)localIterator.next();
      if (!zzflh.zzfnc.containsKey(localSample.zzafe())) {
        ((Set)localObject).addAll(getzzecm);
      }
    }
    return localObject;
  }
  
  private final void zzbf(boolean paramBoolean)
  {
    com.google.android.android.internal.zzcps localZzcps = zzflp;
    if (localZzcps != null)
    {
      if ((localZzcps.isConnected()) && (paramBoolean)) {
        zzflp.zzbbv();
      }
      zzflp.disconnect();
      zzflt = null;
    }
  }
  
  private final boolean zzbr(int paramInt)
  {
    if (zzfll != paramInt)
    {
      zzflh.zzfju.zzahk();
      Object localObject1 = String.valueOf(this);
      Object localObject2 = new StringBuilder(((String)localObject1).length() + 23);
      ((StringBuilder)localObject2).append("Unexpected callback in ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).toString();
      int i = zzflm;
      localObject1 = new StringBuilder(33);
      ((StringBuilder)localObject1).append("mRemainingConnections=");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).toString();
      localObject1 = zzbs(zzfll);
      localObject2 = zzbs(paramInt);
      paramInt = ((String)localObject1).length();
      StringBuilder localStringBuilder = new StringBuilder(((String)localObject2).length() + (paramInt + 70));
      localStringBuilder.append("GoogleApiClient connecting is in step ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" but received callback for step ");
      localStringBuilder.append((String)localObject2);
      Log.wtf("GoogleApiClientConnecting", localStringBuilder.toString(), new Exception());
      removeTask(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }
  
  public static String zzbs(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return "UNKNOWN";
      }
      return "STEP_GETTING_REMOTE_SERVICE";
    }
    return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
  }
  
  public final Logger add(Logger paramLogger)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final Logger addCollection(Logger paramLogger)
  {
    zzflh.zzfju.zzfks.add(paramLogger);
    return paramLogger;
  }
  
  public final void begin()
  {
    zzflh.zzfnc.clear();
    zzflr = false;
    zzfkx = null;
    zzfll = 0;
    zzflq = true;
    zzfls = false;
    zzflu = false;
    HashMap localHashMap = new HashMap();
    Object localObject1 = zzfkm.keySet().iterator();
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Sample)((Iterator)localObject1).next();
      localObject3 = (Api.zze)zzflh.zzfmn.get(((Sample)localObject2).zzafe());
      int j;
      if (((Sample)localObject2).zzafc().getPriority() == 1) {
        j = 1;
      } else {
        j = 0;
      }
      i |= j;
      boolean bool = ((Boolean)zzfkm.get(localObject2)).booleanValue();
      if (((Api.zze)localObject3).zzaac())
      {
        zzflr = true;
        if (bool) {
          zzflo.add(((Sample)localObject2).zzafe());
        } else {
          zzflq = false;
        }
      }
      localHashMap.put(localObject3, new zzat(this, (Sample)localObject2, bool));
    }
    if (i != 0) {
      zzflr = false;
    }
    if (zzflr)
    {
      zzfkj.setUserId(Integer.valueOf(System.identityHashCode(zzflh.zzfju)));
      localObject1 = new zzba(this, null);
      localObject2 = zzfhm;
      localObject3 = mContext;
      Looper localLooper = zzflh.zzfju.getLooper();
      AccountInformation localAccountInformation = zzfkj;
      zzflp = ((com.google.android.android.internal.zzcps)((com.google.android.android.common.package_9.Api.zza)localObject2).getTemplate((Context)localObject3, localLooper, localAccountInformation, localAccountInformation.zzajx(), (GoogleApiClient.ConnectionCallbacks)localObject1, (GoogleApiClient.OnConnectionFailedListener)localObject1));
    }
    zzflm = zzflh.zzfmn.size();
    zzflw.add(zzbo.zzfnj.submit(new zzau(this, localHashMap)));
  }
  
  public final void connect() {}
  
  public final boolean disconnect()
  {
    zzahe();
    zzbf(true);
    zzflh.wakeup(null);
    return true;
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    if (!zzbr(1)) {
      return;
    }
    if (paramBundle != null) {
      zzfln.putAll(paramBundle);
    }
    if (zzaha()) {
      zzahc();
    }
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    removeTask(new ConnectionResult(8, null));
  }
  
  public final void spawn(ConnectionResult paramConnectionResult, Sample paramSample, boolean paramBoolean)
  {
    if (!zzbr(1)) {
      return;
    }
    launch(paramConnectionResult, paramSample, paramBoolean);
    if (zzaha()) {
      zzahc();
    }
  }
}
