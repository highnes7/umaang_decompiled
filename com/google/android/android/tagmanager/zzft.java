package com.google.android.android.tagmanager;

import android.os.Handler.Callback;
import android.os.Message;

public final class zzft
  implements Handler.Callback
{
  public zzft(zzfs paramZzfs) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if ((1 == what) && (zzfo.zzjvf.equals(obj)))
    {
      zzjvt.zzjvs.dispatch();
      if (!zzfo.isPowerSaveMode(zzjvt.zzjvs))
      {
        paramMessage = zzjvt;
        paramMessage.queueNextRefresh(zzfo.loadView(zzjvs));
      }
    }
    return true;
  }
}
