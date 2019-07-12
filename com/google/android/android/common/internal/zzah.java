package com.google.android.android.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.google.android.android.common.stats.Connector;
import java.util.HashMap;

public final class zzah
  extends zzaf
  implements Handler.Callback
{
  public final Context mApplicationContext;
  public final Handler mHandler;
  public final HashMap<com.google.android.gms.common.internal.zzag, com.google.android.gms.common.internal.zzai> zzfuy = new HashMap();
  public final Connector zzfuz;
  public final long zzfva;
  public final long zzfvb;
  
  public zzah(Context paramContext)
  {
    mApplicationContext = paramContext.getApplicationContext();
    mHandler = new Handler(paramContext.getMainLooper(), this);
    zzfuz = Connector.zzaky();
    zzfva = 5000L;
    zzfvb = 300000L;
  }
  
  public final void close(zzag paramZzag, ServiceConnection paramServiceConnection, String paramString)
  {
    zzbp.get(paramServiceConnection, "ServiceConnection must not be null");
    HashMap localHashMap = zzfuy;
    try
    {
      zzai localZzai = (zzai)zzfuy.get(paramZzag);
      if (localZzai != null)
      {
        if (localZzai.isTagged(paramServiceConnection))
        {
          localZzai.bind(paramServiceConnection, paramString);
          if (localZzai.zzaki())
          {
            paramZzag = mHandler.obtainMessage(0, paramZzag);
            mHandler.sendMessageDelayed(paramZzag, zzfva);
          }
          return;
        }
        paramZzag = String.valueOf(paramZzag);
        paramServiceConnection = new StringBuilder(paramZzag.length() + 76);
        paramServiceConnection.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
        paramServiceConnection.append(paramZzag);
        throw new IllegalStateException(paramServiceConnection.toString());
      }
      paramZzag = String.valueOf(paramZzag);
      paramServiceConnection = new StringBuilder(paramZzag.length() + 50);
      paramServiceConnection.append("Nonexistent connection status for service config: ");
      paramServiceConnection.append(paramZzag);
      throw new IllegalStateException(paramServiceConnection.toString());
    }
    catch (Throwable paramZzag)
    {
      throw paramZzag;
    }
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    int i = what;
    Object localObject2;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      localObject2 = zzfuy;
      try
      {
        zzag localZzag = (zzag)obj;
        zzai localZzai = (zzai)zzfuy.get(localZzag);
        if ((localZzai != null) && (localZzai.getState() == 3))
        {
          paramMessage = String.valueOf(localZzag);
          localObject1 = new StringBuilder(paramMessage.length() + 47);
          ((StringBuilder)localObject1).append("Timeout waiting for ServiceConnection callback ");
          ((StringBuilder)localObject1).append(paramMessage);
          Log.wtf("GmsClientSupervisor", ((StringBuilder)localObject1).toString(), new Exception());
          localObject1 = localZzai.getComponentName();
          paramMessage = (Message)localObject1;
          if (localObject1 == null) {
            paramMessage = localZzag.getComponentName();
          }
          localObject1 = paramMessage;
          if (paramMessage == null) {
            localObject1 = new ComponentName(localZzag.getPackage(), "unknown");
          }
          localZzai.onServiceDisconnected((ComponentName)localObject1);
        }
        return true;
      }
      catch (Throwable paramMessage)
      {
        throw paramMessage;
      }
    }
    Object localObject1 = zzfuy;
    try
    {
      paramMessage = (zzag)obj;
      localObject2 = (zzai)zzfuy.get(paramMessage);
      if ((localObject2 != null) && (((zzai)localObject2).zzaki()))
      {
        if (((zzai)localObject2).isBound()) {
          ((zzai)localObject2).zzgd("GmsClientSupervisor");
        }
        zzfuy.remove(paramMessage);
      }
      return true;
    }
    catch (Throwable paramMessage)
    {
      throw paramMessage;
    }
  }
  
  public final boolean open(zzag paramZzag, ServiceConnection paramServiceConnection, String paramString)
  {
    zzbp.get(paramServiceConnection, "ServiceConnection must not be null");
    HashMap localHashMap = zzfuy;
    try
    {
      zzai localZzai = (zzai)zzfuy.get(paramZzag);
      if (localZzai == null)
      {
        localZzai = new zzai(this, paramZzag);
        localZzai.bindToService(paramServiceConnection, paramString);
        localZzai.zzgc(paramString);
        zzfuy.put(paramZzag, localZzai);
        paramZzag = localZzai;
      }
      else
      {
        mHandler.removeMessages(0, paramZzag);
        if (localZzai.isTagged(paramServiceConnection)) {
          break label168;
        }
        localZzai.bindToService(paramServiceConnection, paramString);
        int i = localZzai.getState();
        if (i != 1)
        {
          if (i != 2)
          {
            paramZzag = localZzai;
          }
          else
          {
            localZzai.zzgc(paramString);
            paramZzag = localZzai;
          }
        }
        else
        {
          paramServiceConnection.onServiceConnected(localZzai.getComponentName(), localZzai.getBinder());
          paramZzag = localZzai;
        }
      }
      boolean bool = paramZzag.isBound();
      return bool;
      label168:
      paramZzag = String.valueOf(paramZzag);
      paramServiceConnection = new StringBuilder(paramZzag.length() + 81);
      paramServiceConnection.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
      paramServiceConnection.append(paramZzag);
      throw new IllegalStateException(paramServiceConnection.toString());
    }
    catch (Throwable paramZzag)
    {
      throw paramZzag;
    }
  }
}
