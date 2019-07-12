package support.android.v4.app;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;

public final class DefaultRequestListenerNotifier
{
  public DefaultRequestListenerNotifier() {}
  
  public static boolean post(Handler paramHandler, Runnable paramRunnable, Object paramObject, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramHandler.postDelayed(paramRunnable, paramObject, paramLong);
    }
    paramRunnable = Message.obtain(paramHandler, paramRunnable);
    obj = paramObject;
    return paramHandler.sendMessageDelayed(paramRunnable, paramLong);
  }
}
