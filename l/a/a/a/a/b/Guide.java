package l.a.a.a.a.b;

import android.os.Process;

public abstract class Guide
  implements Runnable
{
  public Guide() {}
  
  public abstract void add();
  
  public final void run()
  {
    Process.setThreadPriority(10);
    add();
  }
}
