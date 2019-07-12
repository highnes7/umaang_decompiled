package com.google.android.android.common.package_9.internal;

import android.os.Bundle;

public final class zzci
  implements Runnable
{
  public zzci(zzch paramZzch, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run()
  {
    if (zzch.saveData(zzfot) > 0)
    {
      LifecycleCallback localLifecycleCallback = zzfos;
      Bundle localBundle;
      if (zzch.getArguments(zzfot) != null) {
        localBundle = zzch.getArguments(zzfot).getBundle(zzao);
      } else {
        localBundle = null;
      }
      localLifecycleCallback.onCreate(localBundle);
    }
    if (zzch.saveData(zzfot) >= 2) {
      zzfos.onStart();
    }
    if (zzch.saveData(zzfot) >= 3) {
      zzfos.onResume();
    }
    if (zzch.saveData(zzfot) >= 4) {
      zzfos.onStop();
    }
    if (zzch.saveData(zzfot) >= 5) {
      zzfos.onDestroy();
    }
  }
}
