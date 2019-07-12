package com.google.android.android.analytics;

import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;
import com.google.android.gms.analytics.zzi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataHandler<T extends zzi>
{
  public final TerminalManager zzdku;
  public final PingManager zzdkv;
  public final List<Object> zzdkw;
  
  public DataHandler(TerminalManager paramTerminalManager, Log paramLog)
  {
    zzbp.append(paramTerminalManager);
    zzdku = paramTerminalManager;
    zzdkw = new ArrayList();
    paramTerminalManager = new PingManager(this, paramLog);
    paramTerminalManager.zzuf();
    zzdkv = paramTerminalManager;
  }
  
  public void isLoggable(PingManager paramPingManager) {}
  
  public final void writeTo(PingManager paramPingManager)
  {
    paramPingManager = zzdkw.iterator();
    while (paramPingManager.hasNext()) {
      paramPingManager.next();
    }
  }
  
  public PingManager zzts()
  {
    PingManager localPingManager = zzdkv.zztx();
    writeTo(localPingManager);
    return localPingManager;
  }
  
  public final TerminalManager zzug()
  {
    return zzdku;
  }
}
