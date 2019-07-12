package com.google.android.android.tagmanager;

import android.content.Context;
import com.google.android.android.internal.zzdjq;
import com.google.android.android.internal.zzdjr;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

public final class zzca
  extends Thread
  implements zzbz
{
  public static zzca zzjrv;
  public volatile boolean mClosed = false;
  public final Context mContext;
  public volatile boolean zzcgv = false;
  public final LinkedBlockingQueue<Runnable> zzjru = new LinkedBlockingQueue();
  public volatile zzcc zzjrw;
  
  public zzca(Context paramContext)
  {
    super("GAThread");
    Context localContext = paramContext;
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    mContext = localContext;
    start();
  }
  
  public static zzca zzdw(Context paramContext)
  {
    if (zzjrv == null) {
      zzjrv = new zzca(paramContext);
    }
    return zzjrv;
  }
  
  public final void queueEvent(Runnable paramRunnable)
  {
    zzjru.add(paramRunnable);
  }
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        localObject = zzjru;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          Object localObject = ((LinkedBlockingQueue)localObject).take();
          localObject = (Runnable)localObject;
          boolean bool = zzcgv;
          if (bool) {
            continue;
          }
          ((Runnable)localObject).run();
        }
        catch (InterruptedException localInterruptedException)
        {
          str = localInterruptedException.toString();
          zzdj.zzjss.zzcq(str);
        }
        localThrowable = localThrowable;
        continue;
        continue;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
        zzdjq.zzlhx.printStackTrace(str, localPrintStream);
        localPrintStream.flush();
        String str = new String(localByteArrayOutputStream.toByteArray());
        if (str.length() != 0) {
          str = "Error on Google TagManager Thread: ".concat(str);
        } else {
          str = new String("Error on Google TagManager Thread: ");
        }
        zzdj.zzjss.get(str);
        zzdj.zzjss.get("Google TagManager is shutting down.");
        zzcgv = true;
      }
    }
  }
  
  public final void zzlt(String paramString)
  {
    queueEvent(new zzcb(this, this, System.currentTimeMillis(), paramString));
  }
}
