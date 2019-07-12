package views;

import d.o;

public final class AtomicBoolean
  implements o<Object, Void>
{
  public AtomicBoolean(java.util.concurrent.atomic.AtomicBoolean paramAtomicBoolean, Task.TaskCompletionSource paramTaskCompletionSource) {}
  
  public Void then(Task paramTask)
  {
    if (this$0.compareAndSet(false, true)) {
      val$tcs.setResult(paramTask);
    }
    return null;
  }
}
