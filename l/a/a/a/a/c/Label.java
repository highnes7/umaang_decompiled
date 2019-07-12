package l.a.a.a.a.c;

import java.util.Collection;
import java.util.concurrent.ExecutorService;

public abstract class Label<Params, Progress, Result>
  extends e<Params, Progress, Result>
  implements h<t>, p, t, g
{
  public final ClassWriter a = new ClassWriter();
  
  public Label() {}
  
  public void a(Throwable paramThrowable)
  {
    ((l)getValue()).a(paramThrowable);
  }
  
  public final void a(ExecutorService paramExecutorService, Object... paramVarArgs)
  {
    super.executeOnExecutor(new ExecutorDelivery.1(paramExecutorService, this), paramVarArgs);
  }
  
  public void a(l paramL)
  {
    if (getStatus() == ModernAsyncTask.Status.PENDING)
    {
      ((Type)getValue()).b(paramL);
      return;
    }
    throw new IllegalStateException("Must not add Dependency after task is running");
  }
  
  public void a(boolean paramBoolean)
  {
    ((l)getValue()).a(paramBoolean);
  }
  
  public boolean a()
  {
    return ((Type)getValue()).a();
  }
  
  public boolean b()
  {
    return ((l)getValue()).b();
  }
  
  public int compareTo(Object paramObject)
  {
    return Request.Priority.compareTo(this, paramObject);
  }
  
  public Collection get()
  {
    return ((Type)getValue()).get();
  }
  
  public Throwable getError()
  {
    return ((l)getValue()).getError();
  }
  
  public Request.Priority getPriority()
  {
    return ((Segment)getValue()).getPriority();
  }
  
  public Type getValue()
  {
    return a;
  }
}
