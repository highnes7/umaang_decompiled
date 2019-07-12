package com.google.android.android.common.internal;

import android.content.Intent;
import com.google.android.android.common.package_9.internal.zzcg;

public final class Delta
  extends ListItem
{
  public Delta(Intent paramIntent, zzcg paramZzcg, int paramInt) {}
  
  public final void zzaka()
  {
    Intent localIntent = val$intent;
    if (localIntent != null) {
      zzftx.startActivityForResult(localIntent, val$requestCode);
    }
  }
}
