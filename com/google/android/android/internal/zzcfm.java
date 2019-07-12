package com.google.android.android.internal;

import android.os.Bundle;
import com.google.android.android.common.util.Log;

public final class zzcfm
  extends zzcbc
{
  public zzcfm(zzcfl paramZzcfl, zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  public final void startSession()
  {
    zzcfl localZzcfl = zziww;
    localZzcfl.zzuj();
    long l = localZzcfl.zzvx().elapsedRealtime();
    localZzcfl.zzaul().zzayj().append("Session started, time", Long.valueOf(l));
    zzaumzzire.updatePreferences(false);
    localZzcfl.zzatz().put("auto", "_s", new Bundle());
    zzaumzzirf.setDefaultAccount(localZzcfl.zzvx().currentTimeMillis());
  }
}
