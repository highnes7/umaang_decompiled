package com.google.android.android.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

public final class zzfs
  implements zzfr
{
  public Handler handler = new Handler(zzfo.context(zzjvs).getMainLooper(), new zzft(this));
  
  public zzfs(zzfo paramZzfo) {}
  
  private final Message obtainMessage()
  {
    return handler.obtainMessage(1, zzfo.zzjvf);
  }
  
  public final void cancel()
  {
    handler.removeMessages(1, zzfo.zzjvf);
  }
  
  public final void queueNextRefresh(long paramLong)
  {
    handler.removeMessages(1, zzfo.zzjvf);
    handler.sendMessageDelayed(obtainMessage(), paramLong);
  }
  
  public final void zzbfc()
  {
    handler.removeMessages(1, zzfo.zzjvf);
    handler.sendMessage(obtainMessage());
  }
}
