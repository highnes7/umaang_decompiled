package com.google.android.android.common.package_9.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.GoogleApiAvailability;
import com.google.android.android.common.internal.Track;
import com.google.android.android.common.internal.zzby;
import com.google.android.android.common.package_9.Api.zzb;
import com.google.android.android.common.package_9.Api.zze;
import com.google.android.android.common.package_9.GoogleApi;
import com.google.android.android.common.package_9.Sample;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.internal.zzcps;
import com.google.android.android.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.api.internal.zzj;
import com.google.android.gms.common.api.internal.zzx;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class zzbr<O extends Api.ApiOptions>
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zzx
{
  public final zzh<O> zzfgs;
  public final Api.zze zzfkh;
  public boolean zzfmi;
  public final Queue<zza> zzfnv = new LinkedList();
  public final Api.zzb zzfnw;
  public final zzah zzfnx;
  public final Set<zzj> zzfny = new HashSet();
  public final Map<com.google.android.gms.common.api.internal.zzcl<?>, com.google.android.gms.common.api.internal.zzcs> zzfnz = new HashMap();
  public final int zzfoa;
  public final zzcw zzfob;
  public ConnectionResult zzfoc = null;
  
  public zzbr(zzbp paramZzbp, GoogleApi paramGoogleApi)
  {
    zzfkh = paramGoogleApi.getTemplate(zzbp.access$getMHandler(paramZzbp).getLooper(), this);
    Api.zze localZze = zzfkh;
    if (!(localZze instanceof zzby))
    {
      zzfnw = localZze;
      zzfgs = paramGoogleApi.zzafk();
      zzfnx = new zzah();
      zzfoa = paramGoogleApi.getInstanceId();
      if (zzfkh.zzaac())
      {
        zzfob = paramGoogleApi.requestSync(zzbp.discover(paramZzbp), zzbp.access$getMHandler(paramZzbp));
        return;
      }
      zzfob = null;
      return;
    }
    zzby.zzako();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  private final void addAttributes(Vector paramVector)
  {
    paramVector.add(zzfnx, zzaac());
    try
    {
      paramVector.add(this);
      return;
    }
    catch (DeadObjectException paramVector)
    {
      for (;;) {}
    }
    onConnectionSuspended(1);
    zzfkh.disconnect();
  }
  
  private final void sendLog(ConnectionResult paramConnectionResult)
  {
    Iterator localIterator = zzfny.iterator();
    while (localIterator.hasNext()) {
      ((LogItem)localIterator.next()).setTimestamp(zzfgs, paramConnectionResult);
    }
    zzfny.clear();
  }
  
  private final void zzahu()
  {
    zzahx();
    sendLog(ConnectionResult.zzfff);
    zzahz();
    Iterator localIterator = zzfnz.values().iterator();
    while (localIterator.hasNext())
    {
      zzcr localZzcr = nextzzfid;
      Api.zzb localZzb = zzfnw;
      try
      {
        localZzcr.applyUpdate(localZzb, new TaskCompletionSource());
      }
      catch (DeadObjectException localDeadObjectException)
      {
        for (;;) {}
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      continue;
      onConnectionSuspended(1);
      zzfkh.disconnect();
    }
    while ((zzfkh.isConnected()) && (!zzfnv.isEmpty())) {
      addAttributes((Vector)zzfnv.remove());
    }
    zzaia();
  }
  
  private final void zzahv()
  {
    zzahx();
    zzfmi = true;
    zzfnx.zzagu();
    zzbp.access$getMHandler(zzfnu).sendMessageDelayed(Message.obtain(zzbp.access$getMHandler(zzfnu), 9, zzfgs), zzbp.saveData(zzfnu));
    zzbp.access$getMHandler(zzfnu).sendMessageDelayed(Message.obtain(zzbp.access$getMHandler(zzfnu), 11, zzfgs), zzbp.createId(zzfnu));
    zzbp.log(zzfnu, -1);
  }
  
  private final void zzahz()
  {
    if (zzfmi)
    {
      zzbp.access$getMHandler(zzfnu).removeMessages(11, zzfgs);
      zzbp.access$getMHandler(zzfnu).removeMessages(9, zzfgs);
      zzfmi = false;
    }
  }
  
  private final void zzaia()
  {
    zzbp.access$getMHandler(zzfnu).removeMessages(12, zzfgs);
    zzbp.access$getMHandler(zzfnu).sendMessageDelayed(zzbp.access$getMHandler(zzfnu).obtainMessage(12, zzfgs), zzbp.getMetadataId(zzfnu));
  }
  
  public final void connect()
  {
    com.google.android.android.common.internal.zzbp.remove(zzbp.access$getMHandler(zzfnu));
    if (!zzfkh.isConnected())
    {
      if (zzfkh.isConnecting()) {
        return;
      }
      if ((zzfkh.zzaff()) && (zzbp.getDisplayTitle(zzfnu) != 0))
      {
        localObject = zzfnu;
        zzbp.log((zzbp)localObject, zzbp.get0((zzbp)localObject).isGooglePlayServicesAvailable(zzbp.discover(zzfnu)));
        if (zzbp.getDisplayTitle(zzfnu) != 0)
        {
          onConnectionFailed(new ConnectionResult(zzbp.getDisplayTitle(zzfnu), null));
          return;
        }
      }
      Object localObject = new zzbv(zzfnu, zzfkh, zzfgs);
      if (zzfkh.zzaac()) {
        zzfob.quit((zzcy)localObject);
      }
      zzfkh.disconnect((Track)localObject);
    }
  }
  
  public final int getInstanceId()
  {
    return zzfoa;
  }
  
  public final void handleReceive(Vector paramVector)
  {
    com.google.android.android.common.internal.zzbp.remove(zzbp.access$getMHandler(zzfnu));
    if (zzfkh.isConnected())
    {
      addAttributes(paramVector);
      zzaia();
      return;
    }
    zzfnv.add(paramVector);
    paramVector = zzfoc;
    if ((paramVector != null) && (paramVector.hasResolution()))
    {
      onConnectionFailed(zzfoc);
      return;
    }
    connect();
  }
  
  public final void handleResult(ConnectionResult paramConnectionResult, Sample paramSample, boolean paramBoolean)
  {
    if (Looper.myLooper() == zzbp.access$getMHandler(zzfnu).getLooper())
    {
      onConnectionFailed(paramConnectionResult);
      return;
    }
    zzbp.access$getMHandler(zzfnu).post(new zzbu(this, paramConnectionResult));
  }
  
  public final void ignore(ConnectionResult paramConnectionResult)
  {
    com.google.android.android.common.internal.zzbp.remove(zzbp.access$getMHandler(zzfnu));
    zzfkh.disconnect();
    onConnectionFailed(paramConnectionResult);
  }
  
  public final boolean isConnected()
  {
    return zzfkh.isConnected();
  }
  
  public final void onConnected(Bundle paramBundle)
  {
    if (Looper.myLooper() == zzbp.access$getMHandler(zzfnu).getLooper())
    {
      zzahu();
      return;
    }
    zzbp.access$getMHandler(zzfnu).post(new zzbs(this));
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    com.google.android.android.common.internal.zzbp.remove(zzbp.access$getMHandler(zzfnu));
    Object localObject = zzfob;
    if (localObject != null) {
      ((zzcw)localObject).zzaim();
    }
    zzahx();
    zzbp.log(zzfnu, -1);
    sendLog(paramConnectionResult);
    if (paramConnectionResult.getErrorCode() == 4)
    {
      write(zzbp.zzfnl);
      return;
    }
    if (zzfnv.isEmpty())
    {
      zzfoc = paramConnectionResult;
      return;
    }
    localObject = zzbp.zzaqd;
    try
    {
      if ((zzbp.getRequest(zzfnu) != null) && (zzbp.access$getMProducts(zzfnu).contains(zzfgs)))
      {
        zzbp.getRequest(zzfnu).clear(paramConnectionResult, zzfoa);
        return;
      }
      if (!zzfnu.setCurrentTheme(paramConnectionResult, zzfoa))
      {
        if (paramConnectionResult.getErrorCode() == 18) {
          zzfmi = true;
        }
        if (zzfmi)
        {
          zzbp.access$getMHandler(zzfnu).sendMessageDelayed(Message.obtain(zzbp.access$getMHandler(zzfnu), 9, zzfgs), zzbp.saveData(zzfnu));
          return;
        }
        paramConnectionResult = zzfgs.zzafv();
        write(new Status(17, StringBuilder.append(StringBuilder.append(paramConnectionResult, 38), "API: ", paramConnectionResult, " is not available on this device.")));
        return;
      }
    }
    catch (Throwable paramConnectionResult)
    {
      throw paramConnectionResult;
    }
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    if (Looper.myLooper() == zzbp.access$getMHandler(zzfnu).getLooper())
    {
      zzahv();
      return;
    }
    zzbp.access$getMHandler(zzfnu).post(new zzbt(this));
  }
  
  public final void registerCallbacks(LogItem paramLogItem)
  {
    com.google.android.android.common.internal.zzbp.remove(zzbp.access$getMHandler(zzfnu));
    zzfny.add(paramLogItem);
  }
  
  public final void resume()
  {
    com.google.android.android.common.internal.zzbp.remove(zzbp.access$getMHandler(zzfnu));
    if (zzfmi) {
      connect();
    }
  }
  
  public final void signOut()
  {
    com.google.android.android.common.internal.zzbp.remove(zzbp.access$getMHandler(zzfnu));
    write(zzbp.zzfnk);
    zzfnx.zzagt();
    Iterator localIterator = zzfnz.keySet().iterator();
    while (localIterator.hasNext()) {
      handleReceive(new Curve25519FieldElement((zzcl)localIterator.next(), new TaskCompletionSource()));
    }
    sendLog(new ConnectionResult(4));
    zzfkh.disconnect();
  }
  
  public final void write(Status paramStatus)
  {
    com.google.android.android.common.internal.zzbp.remove(zzbp.access$getMHandler(zzfnu));
    Iterator localIterator = zzfnv.iterator();
    while (localIterator.hasNext()) {
      ((Vector)localIterator.next()).add(paramStatus);
    }
    zzfnv.clear();
  }
  
  public final boolean zzaac()
  {
    return zzfkh.zzaac();
  }
  
  public final Api.zze zzagn()
  {
    return zzfkh;
  }
  
  public final void zzahh()
  {
    com.google.android.android.common.internal.zzbp.remove(zzbp.access$getMHandler(zzfnu));
    if (zzfmi)
    {
      zzahz();
      Status localStatus;
      if (zzbp.get0(zzfnu).isGooglePlayServicesAvailable(zzbp.discover(zzfnu)) == 18) {
        localStatus = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
      } else {
        localStatus = new Status(8, "API failed to connect while resuming due to an unknown error.");
      }
      write(localStatus);
      zzfkh.disconnect();
    }
  }
  
  public final Map zzahw()
  {
    return zzfnz;
  }
  
  public final void zzahx()
  {
    com.google.android.android.common.internal.zzbp.remove(zzbp.access$getMHandler(zzfnu));
    zzfoc = null;
  }
  
  public final ConnectionResult zzahy()
  {
    com.google.android.android.common.internal.zzbp.remove(zzbp.access$getMHandler(zzfnu));
    return zzfoc;
  }
  
  public final void zzaib()
  {
    com.google.android.android.common.internal.zzbp.remove(zzbp.access$getMHandler(zzfnu));
    if ((zzfkh.isConnected()) && (zzfnz.size() == 0))
    {
      if (zzfnx.zzags())
      {
        zzaia();
        return;
      }
      zzfkh.disconnect();
    }
  }
  
  public final zzcps zzaic()
  {
    zzcw localZzcw = zzfob;
    if (localZzcw == null) {
      return null;
    }
    return localZzcw.zzaic();
  }
}
