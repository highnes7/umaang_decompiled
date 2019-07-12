package com.google.android.android.internal;

import com.google.android.android.analytics.TerminalManager;

public final class zzanf
  extends zzams
{
  public final zzalv zzdlb = new zzalv();
  
  public zzanf(zzamu paramZzamu)
  {
    super(paramZzamu);
  }
  
  public final void zzuk()
  {
    zzwa().zzuh().updateButton(zzdlb);
    Object localObject = zzwe();
    String str = ((zzape)localObject).zzun();
    if (str != null) {
      zzdlb.setAppName(str);
    }
    localObject = ((zzape)localObject).zzuo();
    if (localObject != null) {
      zzdlb.setAppVersion((String)localObject);
    }
  }
  
  public final zzalv zzxd()
  {
    zzwk();
    return zzdlb;
  }
}
