package views;

import d.F;
import d.o;

public class AtomicInteger
  implements o<TResult, F<TContinuationResult>>
{
  public AtomicInteger(Task paramTask, Label paramLabel, Continuation paramContinuation) {}
  
  public Task then(Task paramTask)
  {
    Label localLabel = val$tcs;
    if ((localLabel != null) && (localLabel.a())) {
      return Task.cancelled();
    }
    if (paramTask.isFaulted()) {
      return Task.forError(paramTask.getError());
    }
    if (paramTask.get()) {
      return Task.cancelled();
    }
    return paramTask.call(val$continuation);
  }
}
