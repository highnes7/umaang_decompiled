package com.google.android.android.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.android.common.util.Log;

public final class zzcfl
  extends zzcdu
{
  public Handler mHandler;
  public long zziwt = zzvx().elapsedRealtime();
  public final zzcbc zziwu = new zzcfm(this, zziki);
  public final zzcbc zziwv = new zzcfn(this, zziki);
  
  public zzcfl(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  private final void zzazt()
  {
    try
    {
      if (mHandler == null) {
        mHandler = new Handler(Looper.getMainLooper());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private final void zzazu()
  {
    zzuj();
    zzbs(false);
    zzatx().zzaj(zzvx().elapsedRealtime());
  }
  
  private final void zzbd(long paramLong)
  {
    zzuj();
    zzazt();
    zziwu.cancel();
    zziwv.cancel();
    zzaul().zzayj().append("Activity resumed, time", Long.valueOf(paramLong));
    zziwt = paramLong;
    if (zzvx().currentTimeMillis() - zzaumzzird.lastModified() > zzaumzzirf.lastModified())
    {
      zzaumzzire.updatePreferences(true);
      zzaumzzirg.setDefaultAccount(0L);
    }
    zzcbc localZzcbc;
    if (zzaumzzire.getActiveAccount()) {
      localZzcbc = zziwu;
    }
    for (paramLong = zzaumzzirc.lastModified();; paramLong = 3600000L)
    {
      localZzcbc.setAlarm(Math.max(0L, paramLong - zzaumzzirg.lastModified()));
      return;
      localZzcbc = zziwv;
    }
  }
  
  private final void zzbe(long paramLong)
  {
    zzuj();
    zzazt();
    zziwu.cancel();
    zziwv.cancel();
    zzaul().zzayj().append("Activity paused, time", Long.valueOf(paramLong));
    if (zziwt != 0L)
    {
      zzcck localZzcck = zzaumzzirg;
      long l = zzaumzzirg.lastModified();
      localZzcck.setDefaultAccount(paramLong - zziwt + l);
    }
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
  
  public final boolean zzbs(boolean paramBoolean)
  {
    zzuj();
    zzwk();
    long l1 = zzvx().elapsedRealtime();
    zzaumzzirf.setDefaultAccount(zzvx().currentTimeMillis());
    long l2 = l1 - zziwt;
    if ((!paramBoolean) && (l2 < 1000L))
    {
      zzaul().zzayj().append("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(l2));
      return false;
    }
    zzaumzzirg.setDefaultAccount(l2);
    zzaul().zzayj().append("Recording user engagement, ms", Long.valueOf(l2));
    Bundle localBundle = new Bundle();
    localBundle.putLong("_et", l2);
    zzcek.add(zzaud().zzazn(), localBundle);
    zzatz().put("auto", "_e", localBundle);
    zziwt = l1;
    zziwv.cancel();
    zziwv.setAlarm(Math.max(0L, 3600000L - zzaumzzirg.lastModified()));
    return true;
  }
  
  public final void zzuk() {}
}
