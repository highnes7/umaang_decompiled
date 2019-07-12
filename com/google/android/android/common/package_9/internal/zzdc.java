package com.google.android.android.common.package_9.internal;

import android.os.Bundle;

public final class zzdc
  implements Runnable
{
  public zzdc(zzdb paramZzdb, LifecycleCallback paramLifecycleCallback, String paramString) {}
  
  public final void run()
  {
    if (zzdb.saveData(zzfpg) > 0)
    {
      LifecycleCallback localLifecycleCallback = zzfos;
      Bundle localBundle;
      if (zzdb.getArguments(zzfpg) != null) {
        localBundle = zzdb.getArguments(zzfpg).getBundle(zzao);
      } else {
        localBundle = null;
      }
      localLifecycleCallback.onCreate(localBundle);
    }
    if (zzdb.saveData(zzfpg) >= 2) {
      zzfos.onStart();
    }
    if (zzdb.saveData(zzfpg) >= 3) {
      zzfos.onResume();
    }
    if (zzdb.saveData(zzfpg) >= 4) {
      zzfos.onStop();
    }
    if (zzdb.saveData(zzfpg) >= 5) {
      zzfos.onDestroy();
    }
  }
}
