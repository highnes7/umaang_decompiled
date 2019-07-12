package com.google.android.android.tagmanager;

import android.content.Context;
import com.google.android.android.common.util.Clock;
import com.google.android.android.common.util.Log;
import com.google.android.android.wifi.identifier.AdvertisingIdClient.Info;

public final class ScreenshotTaker
{
  public static Object zzjon = new Object();
  public static ScreenshotTaker zzjoo;
  public volatile boolean mClosed = false;
  public final Context mContext;
  public final Log zzasc;
  public final Thread zzdbe;
  public volatile AdvertisingIdClient.Info zzdnq;
  public volatile long zzjoh = 900000L;
  public volatile long zzjoi = 30000L;
  public volatile long zzjoj;
  public volatile long zzjok;
  public final Object zzjol = new Object();
  public ConnectionListener zzjom = new ReconnectionManager(this);
  
  public ScreenshotTaker(Context paramContext)
  {
    this(paramContext, null, Clock.zzfyr);
  }
  
  public ScreenshotTaker(Context paramContext, ConnectionListener paramConnectionListener, Log paramLog)
  {
    zzasc = paramLog;
    paramConnectionListener = paramContext;
    if (paramContext != null) {
      paramConnectionListener = paramContext.getApplicationContext();
    }
    mContext = paramConnectionListener;
    zzjoj = zzasc.currentTimeMillis();
    zzdbe = new Thread(new XMPPService.4(this));
  }
  
  private final void zzbce()
  {
    if (!mClosed) {}
    try
    {
      try
      {
        zzbcf();
        wait(500L);
      }
      catch (Throwable localThrowable)
      {
        break label30;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label30:
      for (;;) {}
    }
    return;
    throw localThrowable;
  }
  
  private final void zzbcf()
  {
    if (zzasc.currentTimeMillis() - zzjoj > zzjoi)
    {
      Object localObject = zzjol;
      try
      {
        zzjol.notify();
        zzjoj = zzasc.currentTimeMillis();
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
  }
  
  private final void zzbcg()
  {
    if (zzasc.currentTimeMillis() - zzjok > 3600000L) {
      zzdnq = null;
    }
  }
  
  /* Error */
  private final void zzbch()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 127	android/os/Process:setThreadPriority	(I)V
    //   5: aload_0
    //   6: getfield 54	com/google/android/android/tagmanager/ScreenshotTaker:mClosed	Z
    //   9: ifne +103 -> 112
    //   12: aload_0
    //   13: getfield 63	com/google/android/android/tagmanager/ScreenshotTaker:zzjom	Lcom/google/android/android/tagmanager/ConnectionListener;
    //   16: invokeinterface 133 1 0
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +31 -> 54
    //   26: aload_0
    //   27: aload_1
    //   28: putfield 121	com/google/android/android/tagmanager/ScreenshotTaker:zzdnq	Lcom/google/android/android/wifi/identifier/AdvertisingIdClient$Info;
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 65	com/google/android/android/tagmanager/ScreenshotTaker:zzasc	Lcom/google/android/android/common/util/Log;
    //   36: invokeinterface 79 1 0
    //   41: putfield 117	com/google/android/android/tagmanager/ScreenshotTaker:zzjok	J
    //   44: getstatic 139	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   47: ldc -115
    //   49: invokeinterface 147 2 0
    //   54: aload_0
    //   55: monitorenter
    //   56: aload_0
    //   57: invokevirtual 150	java/lang/Object:notifyAll	()V
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_0
    //   63: getfield 56	com/google/android/android/tagmanager/ScreenshotTaker:zzjol	Ljava/lang/Object;
    //   66: astore_1
    //   67: aload_1
    //   68: monitorenter
    //   69: aload_0
    //   70: getfield 56	com/google/android/android/tagmanager/ScreenshotTaker:zzjol	Ljava/lang/Object;
    //   73: aload_0
    //   74: getfield 48	com/google/android/android/tagmanager/ScreenshotTaker:zzjoh	J
    //   77: invokevirtual 111	java/lang/Object:wait	(J)V
    //   80: aload_1
    //   81: monitorexit
    //   82: goto -77 -> 5
    //   85: astore_2
    //   86: aload_1
    //   87: monitorexit
    //   88: aload_2
    //   89: athrow
    //   90: getstatic 139	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   93: ldc -104
    //   95: invokeinterface 147 2 0
    //   100: goto -95 -> 5
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: goto -19 -> 90
    //   112: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	ScreenshotTaker
    //   21	66	1	localObject	Object
    //   103	4	1	localThrowable1	Throwable
    //   108	1	1	localInterruptedException	InterruptedException
    //   85	4	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   69	82	85	java/lang/Throwable
    //   86	88	85	java/lang/Throwable
    //   56	62	103	java/lang/Throwable
    //   104	106	103	java/lang/Throwable
    //   88	90	108	java/lang/InterruptedException
  }
  
  public static ScreenshotTaker zzdp(Context paramContext)
  {
    if (zzjoo == null)
    {
      Object localObject = zzjon;
      try
      {
        if (zzjoo == null)
        {
          paramContext = new ScreenshotTaker(paramContext);
          zzjoo = paramContext;
          zzdbe.start();
        }
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
    return zzjoo;
  }
  
  public final void close()
  {
    mClosed = true;
    zzdbe.interrupt();
  }
  
  public final boolean isLimitAdTrackingEnabled()
  {
    if (zzdnq == null) {
      zzbce();
    } else {
      zzbcf();
    }
    zzbcg();
    if (zzdnq == null) {
      return true;
    }
    return zzdnq.isLimitAdTrackingEnabled();
  }
  
  public final String zzbcd()
  {
    if (zzdnq == null) {
      zzbce();
    } else {
      zzbcf();
    }
    zzbcg();
    if (zzdnq == null) {
      return null;
    }
    return zzdnq.getId();
  }
}
