package f.g.c.eventbus;

import f.g.c.a.a;
import f.g.c.e.j.a;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

@a
public class AsyncEventBus
  extends EventBus
{
  public final ConcurrentLinkedQueue<j.a> eventsToDispatch = new ConcurrentLinkedQueue();
  public final Executor executor;
  
  public AsyncEventBus(String paramString, Executor paramExecutor)
  {
    super(paramString);
    executor = paramExecutor;
  }
  
  public AsyncEventBus(Executor paramExecutor)
  {
    super("default");
    executor = paramExecutor;
  }
  
  public void dispatch(Object paramObject, EventHandler paramEventHandler)
  {
    executor.execute(new AsyncEventBus.1(this, paramObject, paramEventHandler));
  }
  
  public void dispatchQueuedEvents()
  {
    for (;;)
    {
      Bus.EventWithHandler localEventWithHandler = (Bus.EventWithHandler)eventsToDispatch.poll();
      if (localEventWithHandler == null) {
        return;
      }
      dispatch(event, handler);
    }
  }
  
  public void enqueueEvent(Object paramObject, EventHandler paramEventHandler)
  {
    eventsToDispatch.offer(new Bus.EventWithHandler(paramObject, paramEventHandler));
  }
}
