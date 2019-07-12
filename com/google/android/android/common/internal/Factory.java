package com.google.android.android.common.internal;

import android.app.Activity;
import android.content.Intent;

public final class Factory
  extends ListItem
{
  public Factory(Intent paramIntent, Activity paramActivity, int paramInt) {}
  
  public final void zzaka()
  {
    Intent localIntent = val$intent;
    if (localIntent != null) {
      val$activity.startActivityForResult(localIntent, val$requestCode);
    }
  }
}
