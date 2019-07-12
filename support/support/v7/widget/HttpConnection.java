package support.support.v7.widget;

import android.os.Handler;
import android.os.Looper;
import b.b.a.G;
import b.b.a.N;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@N({b.b.a.N.a.b})
public class HttpConnection
  extends AsyncHttpClient
{
  @G
  public volatile Handler handler;
  public ExecutorService pool = Executors.newFixedThreadPool(2);
  public final Object this$0 = new Object();
  
  public HttpConnection() {}
  
  public void execute(Runnable paramRunnable)
  {
    pool.execute(paramRunnable);
  }
  
  public boolean execute()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public void post(Runnable paramRunnable)
  {
    if (handler == null)
    {
      Object localObject = this$0;
      try
      {
        if (handler == null) {
          handler = new Handler(Looper.getMainLooper());
        }
      }
      catch (Throwable paramRunnable)
      {
        throw paramRunnable;
      }
    }
    handler.post(paramRunnable);
  }
}
