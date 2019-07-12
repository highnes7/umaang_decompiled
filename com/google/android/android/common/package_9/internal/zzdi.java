package com.google.android.android.common.package_9.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.android.common.package_9.PendingResult;
import com.google.android.android.common.package_9.Status;

public final class zzdi
  extends Handler
{
  public zzdi(zzdg paramZzdg, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = what;
    if (i != 0)
    {
      if (i != 1)
      {
        paramMessage = new StringBuilder(70);
        paramMessage.append("TransformationResultHandler received unknown message type: ");
        paramMessage.append(i);
        paramMessage.toString();
        return;
      }
      paramMessage = (RuntimeException)obj;
      localObject = String.valueOf(paramMessage.getMessage());
      if (((String)localObject).length() != 0) {
        "Runtime exception on the transformation worker thread: ".concat((String)localObject);
      } else {
        new String("Runtime exception on the transformation worker thread: ");
      }
      throw paramMessage;
    }
    Object localObject = (PendingResult)obj;
    paramMessage = zzfpp.zzfjf;
    if (localObject == null) {}
    try
    {
      zzdg.addRow(zzfpp.zzfpi, new Status(13, "Transform returned null"));
      break label172;
      if ((localObject instanceof zzcu)) {
        zzdg.addRow(zzfpp.zzfpi, ((zzcu)localObject).getStatus());
      } else {
        zzfpp.zzfpi.onResultReceived((PendingResult)localObject);
      }
      label172:
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
