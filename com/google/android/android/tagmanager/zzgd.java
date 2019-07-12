package com.google.android.android.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

public final class zzgd
  implements ComponentCallbacks2
{
  public zzgd(TagManager paramTagManager) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt)
  {
    if (paramInt == 20) {
      zzjwa.dispatch();
    }
  }
}
