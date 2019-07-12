package com.google.android.android.internal;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.android.analytics.TerminalManager;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.stats.Connector;
import java.util.Collections;
import java.util.List;

public final class zzamy
  extends zzams
{
  public final zzana zzdpa;
  public zzaoj zzdpb;
  public final zzanx zzdpc;
  public final zzaoz zzdpd;
  
  public zzamy(zzamu paramZzamu)
  {
    super(paramZzamu);
    zzdpd = new zzaoz(paramZzamu.zzvx());
    zzdpa = new zzana(this);
    zzdpc = new zzamz(this, paramZzamu);
  }
  
  private final void addKey(zzaoj paramZzaoj)
  {
    TerminalManager.zzuj();
    zzdpb = paramZzaoj;
    zzww();
    zzwc().onServiceConnected();
  }
  
  private final void onServiceDisconnected(ComponentName paramComponentName)
  {
    
    if (zzdpb != null)
    {
      zzdpb = null;
      d("Disconnected from device AnalyticsService", paramComponentName);
      zzwc().zzvu();
    }
  }
  
  private final void zzww()
  {
    zzdpd.start();
    zzdpc.updateTimer(((Long)zzaod.zzdsj.setDoOutput()).longValue());
  }
  
  private final void zzwx()
  {
    
    if (!isConnected()) {
      return;
    }
    zzdm("Inactivity, disconnecting from device AnalyticsService");
    disconnect();
  }
  
  public final boolean connect()
  {
    TerminalManager.zzuj();
    zzwk();
    if (zzdpb != null) {
      return true;
    }
    zzaoj localZzaoj = zzdpa.zzwy();
    if (localZzaoj != null)
    {
      zzdpb = localZzaoj;
      zzww();
      return true;
    }
    return false;
  }
  
  public final void disconnect()
  {
    TerminalManager.zzuj();
    zzwk();
    try
    {
      Connector.zzaky();
      Context localContext = getContext();
      zzana localZzana = zzdpa;
      localContext.unbindService(localZzana);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    if (zzdpb != null)
    {
      zzdpb = null;
      zzwc().zzvu();
      return;
    }
  }
  
  public final boolean isConnected()
  {
    TerminalManager.zzuj();
    zzwk();
    return zzdpb != null;
  }
  
  public final boolean ready(zzaoi paramZzaoi)
  {
    zzbp.append(paramZzaoi);
    TerminalManager.zzuj();
    zzwk();
    zzaoj localZzaoj = zzdpb;
    if (localZzaoj == null) {
      return false;
    }
    String str;
    if (paramZzaoi.zzyp()) {
      str = zzanv.zzyb();
    } else {
      str = zzanv.zzyc();
    }
    List localList = Collections.emptyList();
    try
    {
      localZzaoj.sendHit(paramZzaoi.zziy(), paramZzaoi.zzyn(), str, localList);
      zzww();
      return true;
    }
    catch (RemoteException paramZzaoi)
    {
      for (;;) {}
    }
    zzdm("Failed to send hits to AnalyticsService");
    return false;
  }
  
  public final void zzuk() {}
  
  public final boolean zzwv()
  {
    TerminalManager.zzuj();
    zzwk();
    zzaoj localZzaoj = zzdpb;
    if (localZzaoj == null) {
      return false;
    }
    try
    {
      localZzaoj.zzvr();
      zzww();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
    zzdm("Failed to clear hits from AnalyticsService");
    return false;
  }
}
