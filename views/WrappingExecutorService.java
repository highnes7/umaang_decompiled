package views;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class WrappingExecutorService
  implements Executor
{
  public WrappingExecutorService() {}
  
  public void execute(Runnable paramRunnable)
  {
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
}
