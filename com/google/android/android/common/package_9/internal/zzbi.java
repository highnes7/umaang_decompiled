package com.google.android.android.common.package_9.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class zzbi
  extends Handler
{
  public zzbi(zzbd paramZzbd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = what;
    if (i != 1)
    {
      if (i != 2)
      {
        paramMessage = new StringBuilder(31);
        paramMessage.append("Unknown message id: ");
        paramMessage.append(i);
        paramMessage.toString();
        return;
      }
      zzbd.access$1500(zzfmv);
      return;
    }
    zzbd.onResultReceived(zzfmv);
  }
}
