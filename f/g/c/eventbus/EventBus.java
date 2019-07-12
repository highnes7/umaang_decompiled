package f.g.c.eventbus;

import f.g.c.a.a;
import f.g.c.c.n;
import f.g.c.cache.CacheBuilder;
import f.g.c.cache.LoadingCache;
import f.g.c.d.bg;
import f.g.c.e.j;
import f.g.c.e.j.a;
import f.g.c.e.k;
import f.g.c.package_10.Throwables;
import f.g.c.package_8.Be.d;
import f.g.c.package_8.Multimap;
import f.g.c.package_8.SetMultimap;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

@a
public class EventBus
{
  public final ThreadLocal<ConcurrentLinkedQueue<j.a>> eventsToDispatch = new Dispatcher.PerThreadQueuedDispatcher.1(this);
  public final HandlerFindingStrategy finder = new AnnotatedHandlerFinder();
  public final n<Class<?>, Set<Class<?>>> flattenHierarchyCache = new CacheBuilder().weakKeys().build(new ProvisionListenerCallbackStore.1(this));
  public final bg<Class<?>, k> handlersByType = new Be.d(new ConcurrentHashMap(), new AbstractIdleService.ThreadNameSupplier(this));
  public final ThreadLocal<Boolean> isDispatching = new Dispatcher.PerThreadQueuedDispatcher.2(this);
  public final Logger logger;
  
  public EventBus()
  {
    this("default");
  }
  
  public EventBus(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j.class.getName());
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    logger = Logger.getLogger(localStringBuilder.toString());
  }
  
  public void dispatch(Object paramObject, EventHandler paramEventHandler)
  {
    try
    {
      paramEventHandler.handleEvent(paramObject);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Logger localLogger = logger;
      Level localLevel = Level.SEVERE;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not dispatch event: ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" to handler ");
      localStringBuilder.append(paramEventHandler);
      localLogger.log(localLevel, localStringBuilder.toString(), localInvocationTargetException);
    }
  }
  
  /* Error */
  public void dispatchQueuedEvents()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	f/g/c/eventbus/EventBus:isDispatching	Ljava/lang/ThreadLocal;
    //   4: invokevirtual 142	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   7: checkcast 144	java/lang/Boolean
    //   10: invokevirtual 148	java/lang/Boolean:booleanValue	()Z
    //   13: ifeq +4 -> 17
    //   16: return
    //   17: aload_0
    //   18: getfield 64	f/g/c/eventbus/EventBus:isDispatching	Ljava/lang/ThreadLocal;
    //   21: iconst_1
    //   22: invokestatic 152	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   25: invokevirtual 155	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   28: aload_0
    //   29: getfield 61	f/g/c/eventbus/EventBus:eventsToDispatch	Ljava/lang/ThreadLocal;
    //   32: invokevirtual 142	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   35: checkcast 157	java/util/concurrent/ConcurrentLinkedQueue
    //   38: invokevirtual 160	java/util/concurrent/ConcurrentLinkedQueue:poll	()Ljava/lang/Object;
    //   41: checkcast 8	f/g/c/eventbus/Bus$EventWithHandler
    //   44: astore_1
    //   45: aload_1
    //   46: ifnonnull +15 -> 61
    //   49: aload_0
    //   50: getfield 64	f/g/c/eventbus/EventBus:isDispatching	Ljava/lang/ThreadLocal;
    //   53: iconst_0
    //   54: invokestatic 152	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   57: invokevirtual 155	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   60: return
    //   61: aload_0
    //   62: aload_1
    //   63: getfield 164	f/g/c/eventbus/Bus$EventWithHandler:event	Ljava/lang/Object;
    //   66: aload_1
    //   67: getfield 168	f/g/c/eventbus/Bus$EventWithHandler:handler	Lf/g/c/eventbus/EventHandler;
    //   70: invokevirtual 170	f/g/c/eventbus/EventBus:dispatch	(Ljava/lang/Object;Lf/g/c/eventbus/EventHandler;)V
    //   73: goto -45 -> 28
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 64	f/g/c/eventbus/EventBus:isDispatching	Ljava/lang/ThreadLocal;
    //   81: iconst_0
    //   82: invokestatic 152	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   85: invokevirtual 155	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   88: goto +3 -> 91
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	EventBus
    //   44	23	1	localEventWithHandler	Bus.EventWithHandler
    //   76	16	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   28	45	76	java/lang/Throwable
    //   61	73	76	java/lang/Throwable
  }
  
  public void enqueueEvent(Object paramObject, EventHandler paramEventHandler)
  {
    ((ConcurrentLinkedQueue)eventsToDispatch.get()).offer(new Bus.EventWithHandler(paramObject, paramEventHandler));
  }
  
  public Set flattenHierarchy(Class paramClass)
  {
    LoadingCache localLoadingCache = flattenHierarchyCache;
    try
    {
      paramClass = localLoadingCache.get(paramClass);
      return (Set)paramClass;
    }
    catch (ExecutionException paramClass)
    {
      Throwables.propagate(paramClass.getCause());
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
  }
  
  public Set getHandlersForEventType(Class paramClass)
  {
    return handlersByType.get(paramClass);
  }
  
  public Set newHandlerSet()
  {
    return new CopyOnWriteArraySet();
  }
  
  public void post(Object paramObject)
  {
    Iterator localIterator = flattenHierarchy(paramObject.getClass()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = getHandlersForEventType((Class)localIterator.next());
      if ((localObject != null) && (!((Set)localObject).isEmpty()))
      {
        int j = 1;
        localObject = ((Set)localObject).iterator();
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          enqueueEvent(paramObject, (EventHandler)((Iterator)localObject).next());
        }
      }
    }
    if ((i == 0) && (!(paramObject instanceof ByteVector))) {
      post(new ByteVector(this, paramObject));
    }
    dispatchQueuedEvents();
  }
  
  public void register(Object paramObject)
  {
    handlersByType.putAll(finder.findAllHandlers(paramObject));
  }
  
  public void unregister(Object paramObject)
  {
    Iterator localIterator = finder.findAllHandlers(paramObject).asMap().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Set localSet = getHandlersForEventType((Class)localEntry.getKey());
      Collection localCollection = (Collection)localEntry.getValue();
      if ((localSet != null) && (localSet.containsAll((Collection)localEntry.getValue()))) {
        localSet.removeAll(localCollection);
      } else {
        throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("missing event handler for an annotated method. Is ", paramObject, " registered?"));
      }
    }
  }
}
