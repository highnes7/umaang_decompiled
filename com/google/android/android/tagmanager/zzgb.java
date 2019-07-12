package com.google.android.android.tagmanager;

import java.util.Map;

public final class zzgb
  implements DataLayer.zzb
{
  public zzgb(TagManager paramTagManager) {}
  
  public final void changed(Map paramMap)
  {
    paramMap = paramMap.get("event");
    if (paramMap != null) {
      TagManager.rename(zzjwa, paramMap.toString());
    }
  }
}
