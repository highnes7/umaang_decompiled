package views;

import d.F;
import d.o;

public class x
  implements o<TResult, F<Void>>
{
  public x(Task paramTask) {}
  
  public Task then(Task paramTask)
    throws Exception
  {
    if (paramTask.get()) {
      return Task.cancelled();
    }
    if (paramTask.isFaulted()) {
      return Task.forError(paramTask.getError());
    }
    return Task.call(null);
  }
}
