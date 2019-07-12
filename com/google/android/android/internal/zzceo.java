package com.google.android.android.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import com.google.android.android.common.PingManager;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.stats.Connector;
import com.google.android.android.measurement.AppMeasurement.zzb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class zzceo
  extends zzcdu
{
  public final zzcfb zzivy;
  public zzcbo zzivz;
  public Boolean zziwa;
  public final zzcbc zziwb;
  public final zzcfq zziwc;
  public final List<Runnable> zziwd = new ArrayList();
  public final zzcbc zziwe;
  
  public zzceo(zzccw paramZzccw)
  {
    super(paramZzccw);
    zziwc = new zzcfq(paramZzccw.zzvx());
    zzivy = new zzcfb(this);
    zziwb = new zzcep(this, paramZzccw);
    zziwe = new zzcet(this, paramZzccw);
  }
  
  private final void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzuj();
    if (zzivz != null)
    {
      zzivz = null;
      zzaul().zzayj().append("Disconnected from device MeasurementService", paramComponentName);
      zzuj();
      zzxh();
    }
  }
  
  private final void trim(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzuj();
    if (isConnected())
    {
      paramRunnable.run();
      return;
    }
    long l = zziwd.size();
    zzcax.zzawp();
    if (l >= 1000L)
    {
      zzaul().zzayd().append("Discarding data. Max runnable queue size reached");
      return;
    }
    zziwd.add(paramRunnable);
    zziwe.setAlarm(60000L);
    zzxh();
  }
  
  private final void zzazr()
  {
    zzuj();
    zzaul().zzayj().append("Processing queued up service tasks", Integer.valueOf(zziwd.size()));
    Iterator localIterator = zziwd.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      try
      {
        localRunnable.run();
      }
      catch (Throwable localThrowable)
      {
        zzaul().zzayd().append("Task exception while flushing queue", localThrowable);
      }
    }
    zziwd.clear();
    zziwe.cancel();
  }
  
  private final zzcas zzbr(boolean paramBoolean)
  {
    zzcax.zzawk();
    zzcbr localZzcbr = zzaua();
    String str;
    if (paramBoolean) {
      str = zzaul().zzayk();
    } else {
      str = null;
    }
    return localZzcbr.zzjb(str);
  }
  
  private final void zzww()
  {
    zzuj();
    zziwc.start();
    zziwb.setAlarm(zzcax.zzawh());
  }
  
  private final void zzwx()
  {
    zzuj();
    if (!isConnected()) {
      return;
    }
    zzaul().zzayj().append("Inactivity, disconnecting from the service");
    disconnect();
  }
  
  public final void Refresh(AppMeasurement.zzb paramZzb)
  {
    zzuj();
    zzwk();
    trim(new zzces(this, paramZzb));
  }
  
  public final void Refresh(AtomicReference paramAtomicReference)
  {
    zzuj();
    zzwk();
    trim(new zzceq(this, paramAtomicReference, zzbr(false)));
  }
  
  public final void body(AtomicReference paramAtomicReference, String paramString1, String paramString2, String paramString3)
  {
    zzuj();
    zzwk();
    trim(new zzcex(this, paramAtomicReference, paramString1, paramString2, paramString3, zzbr(false)));
  }
  
  public final void body(AtomicReference paramAtomicReference, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    zzuj();
    zzwk();
    trim(new zzcey(this, paramAtomicReference, paramString1, paramString2, paramString3, paramBoolean, zzbr(false)));
  }
  
  public final void body(AtomicReference paramAtomicReference, boolean paramBoolean)
  {
    zzuj();
    zzwk();
    trim(new zzcfa(this, paramAtomicReference, zzbr(false), paramBoolean));
  }
  
  public final void disconnect()
  {
    zzuj();
    zzwk();
    try
    {
      Connector.zzaky();
      Context localContext = getContext();
      zzcfb localZzcfb = zzivy;
      localContext.unbindService(localZzcfb);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    zzivz = null;
  }
  
  public final void f(zzcbk paramZzcbk, String paramString)
  {
    zzbp.append(paramZzcbk);
    zzuj();
    zzwk();
    zzcax.zzawk();
    trim(new zzcev(this, true, zzaue().a(paramZzcbk), paramZzcbk, zzbr(true), paramString));
  }
  
  public final void i(zzcav paramZzcav)
  {
    zzbp.append(paramZzcav);
    zzuj();
    zzwk();
    zzcax.zzawk();
    trim(new zzcew(this, true, zzaue().c(paramZzcav), new zzcav(paramZzcav), zzbr(true), paramZzcav));
  }
  
  public final boolean isConnected()
  {
    zzuj();
    zzwk();
    return zzivz != null;
  }
  
  public final void makeView(zzcbo paramZzcbo)
  {
    zzuj();
    zzbp.append(paramZzcbo);
    zzivz = paramZzcbo;
    zzww();
    zzazr();
  }
  
  public final void processData(zzcbo paramZzcbo, zzbck paramZzbck, zzcas paramZzcas)
  {
    zzuj();
    zzatv();
    zzwk();
    zzcax.zzawk();
    ArrayList localArrayList = new ArrayList();
    zzcax.zzawt();
    int j = 0;
    int i = 100;
    while ((j < 1001) && (i == 100))
    {
      Object localObject = zzaue().zzdw(100);
      if (localObject != null)
      {
        localArrayList.addAll((Collection)localObject);
        i = ((List)localObject).size();
      }
      else
      {
        i = 0;
      }
      if ((paramZzbck != null) && (i < 100)) {
        localArrayList.add(paramZzbck);
      }
      int m = localArrayList.size();
      int k = 0;
      while (k < m)
      {
        localObject = localArrayList.get(k);
        k += 1;
        localObject = (zzbck)localObject;
        zzcby localZzcby;
        String str;
        if ((localObject instanceof zzcbk))
        {
          localObject = (zzcbk)localObject;
          try
          {
            paramZzcbo.trim((zzcbk)localObject, paramZzcas);
          }
          catch (RemoteException localRemoteException1)
          {
            localZzcby = zzaul().zzayd();
            str = "Failed to send event to the service";
          }
        }
        else
        {
          for (;;)
          {
            localZzcby.append(str, localRemoteException1);
            break;
            if ((localRemoteException1 instanceof zzcft))
            {
              zzcft localZzcft = (zzcft)localRemoteException1;
              try
              {
                paramZzcbo.trim(localZzcft, paramZzcas);
              }
              catch (RemoteException localRemoteException2)
              {
                localZzcby = zzaul().zzayd();
                str = "Failed to send attribute to the service";
              }
              continue;
            }
            if (!(localRemoteException2 instanceof zzcav)) {
              break label298;
            }
            zzcav localZzcav = (zzcav)localRemoteException2;
            try
            {
              paramZzcbo.getPackageInfo(localZzcav, paramZzcas);
            }
            catch (RemoteException localRemoteException3)
            {
              localZzcby = zzaul().zzayd();
              str = "Failed to send conditional property to the service";
            }
          }
          label298:
          zzaul().zzayd().append("Discarding data. Unrecognized parcel type.");
        }
      }
      j += 1;
    }
  }
  
  public final void quote(zzcft paramZzcft)
  {
    zzuj();
    zzwk();
    zzcax.zzawk();
    trim(new zzcez(this, zzaue().startSession(paramZzcft), paramZzcft, zzbr(true)));
  }
  
  public final void zzatu()
  {
    zzccw.zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void zzatv()
  {
    zzcax.zzawk();
  }
  
  public final void zzazp()
  {
    zzuj();
    zzwk();
    trim(new zzceu(this, zzbr(true)));
  }
  
  public final void zzazq()
  {
    zzuj();
    zzwk();
    trim(new zzcer(this, zzbr(true)));
  }
  
  public final void zzuk() {}
  
  public final void zzxh()
  {
    zzuj();
    zzwk();
    if (isConnected()) {
      return;
    }
    Object localObject1 = zziwa;
    int j = 0;
    Object localObject2;
    if (localObject1 == null)
    {
      zziwa = zzaum().zzayo();
      if (zziwa == null)
      {
        zzaul().zzayj().append("State of service unknown");
        zzuj();
        zzwk();
        zzcax.zzawk();
        zzaul().zzayj().append("Checking service availability");
        i = PingManager.zzffk.isGooglePlayServicesAvailable(getContext());
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 9)
                {
                  if (i != 18) {
                    break label219;
                  }
                  localObject1 = zzaul().zzayf();
                  localObject2 = "Service updating";
                  break label238;
                }
                localObject1 = zzaul().zzayf();
                localObject2 = "Service invalid";
              }
              else
              {
                localObject1 = zzaul().zzayf();
                localObject2 = "Service disabled";
              }
            }
            else
            {
              localObject1 = zzaul().zzayi();
              localObject2 = "Service container out of date";
              break label238;
            }
          }
          else
          {
            localObject1 = zzaul().zzayj();
            localObject2 = "Service missing";
          }
          ((zzcby)localObject1).append((String)localObject2);
          label219:
          bool = false;
          break label247;
        }
        else
        {
          localObject1 = zzaul().zzayj();
          localObject2 = "Service available";
        }
        label238:
        ((zzcby)localObject1).append((String)localObject2);
        boolean bool = true;
        label247:
        zziwa = Boolean.valueOf(bool);
        zzaum().zzbm(zziwa.booleanValue());
      }
    }
    if (zziwa.booleanValue())
    {
      zzaul().zzayj().append("Using measurement service");
      zzivy.zzazs();
      return;
    }
    zzcax.zzawk();
    localObject1 = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
    int i = j;
    if (localObject1 != null)
    {
      i = j;
      if (((List)localObject1).size() > 0) {
        i = 1;
      }
    }
    if (i != 0)
    {
      zzaul().zzayj().append("Using local app measurement service");
      localObject1 = new Intent("com.google.android.gms.measurement.START");
      localObject2 = getContext();
      zzcax.zzawk();
      ((Intent)localObject1).setComponent(new ComponentName((Context)localObject2, "com.google.android.gms.measurement.AppMeasurementService"));
      zzivy.parseFeed((Intent)localObject1);
      return;
    }
    zzaul().zzayd().append("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
  }
}
