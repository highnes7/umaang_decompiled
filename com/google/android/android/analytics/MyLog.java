package com.google.android.android.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzami;
import com.google.android.android.internal.zzamu;
import com.google.android.android.internal.zzanf;
import com.google.android.android.internal.zzanm;
import com.google.android.android.internal.zzanz;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.analytics.zzi;
import java.util.List;
import java.util.ListIterator;

public class MyLog
  extends zzi<zza>
{
  public final zzamu zzdjj;
  public boolean zzdjk;
  
  public MyLog(zzamu paramZzamu)
  {
    super(paramZzamu.zzwa(), paramZzamu.zzvx());
    zzdjj = paramZzamu;
  }
  
  public final void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    zzdjk = paramBoolean;
  }
  
  public final void isLoggable(PingManager paramPingManager)
  {
    paramPingManager = (com.google.android.android.internal.zzame)paramPingManager.getInstance(com.google.android.gms.internal.zzame.class);
    if (TextUtils.isEmpty(paramPingManager.zzve())) {
      paramPingManager.setClientId(zzdjj.zzwq().zzxp());
    }
    if ((zzdjk) && (TextUtils.isEmpty(paramPingManager.zzvf())))
    {
      zzami localZzami = zzdjj.zzwp();
      paramPingManager.zzdi(localZzami.zzvn());
      paramPingManager.zzah(localZzami.zzvg());
    }
  }
  
  public final void zzcw(String paramString)
  {
    zzbp.zzgg(paramString);
    Uri localUri = JSONObject.zzcx(paramString);
    ListIterator localListIterator = zzdkv.getTransports().listIterator();
    while (localListIterator.hasNext()) {
      if (localUri.equals(((Dictionary)localListIterator.next()).zztu())) {
        localListIterator.remove();
      }
    }
    zzdkv.getTransports().add(new JSONObject(zzdjj, paramString));
  }
  
  public final zzamu zztr()
  {
    return zzdjj;
  }
  
  public final PingManager zzts()
  {
    PingManager localPingManager = zzdkv.zztx();
    localPingManager.init(zzdjj.zzwi().zzxd());
    localPingManager.init(zzdjj.zzwj().zzyh());
    writeTo(localPingManager);
    return localPingManager;
  }
}
