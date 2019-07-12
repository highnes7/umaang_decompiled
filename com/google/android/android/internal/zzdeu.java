package com.google.android.android.internal;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzdeu
  extends ContentObserver
{
  public zzdeu(Handler paramHandler)
  {
    super(null);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    zzdet.zzkxx.set(true);
  }
}
