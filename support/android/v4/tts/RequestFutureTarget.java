package support.android.v4.tts;

import android.os.Handler;
import java.util.concurrent.Callable;

public class RequestFutureTarget
  implements Runnable
{
  public RequestFutureTarget(f paramF, Callable paramCallable, Handler paramHandler, c paramC) {}
  
  public void run()
  {
    Object localObject = val$callable;
    try
    {
      localObject = ((Callable)localObject).call();
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    localObject = null;
    mainHandler.post(new SMTPAppenderBase.SenderRunnable(this, localObject));
  }
}
