package f.g.c.package_10.gamelogic;

import f.g.c.b.a.b;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Finalizer
  implements Runnable
{
  public static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";
  public static final Field inheritableThreadLocals = getInheritableThreadLocalsField();
  public static final Logger logger = Logger.getLogger(b.class.getName());
  public final WeakReference<Class<?>> finalizableReferenceClassReference;
  public final PhantomReference<Object> frqReference;
  public final ReferenceQueue<Object> queue = new ReferenceQueue();
  
  public Finalizer(Class paramClass, Object paramObject)
  {
    finalizableReferenceClassReference = new WeakReference(paramClass);
    frqReference = new PhantomReference(paramObject, queue);
  }
  
  private void cleanUp(Reference paramReference)
    throws Finalizer.ShutDown
  {
    Method localMethod = getFinalizeReferentMethod();
    Reference localReference;
    do
    {
      paramReference.clear();
      if (paramReference == frqReference) {
        break;
      }
      try
      {
        localMethod.invoke(paramReference, new Object[0]);
      }
      catch (Throwable paramReference)
      {
        logger.log(Level.SEVERE, "Error cleaning up after reference.", paramReference);
      }
      localReference = queue.poll();
      paramReference = localReference;
    } while (localReference != null);
    return;
    paramReference = new ShutDown(null);
    throw paramReference;
  }
  
  private Method getFinalizeReferentMethod()
    throws Finalizer.ShutDown
  {
    Object localObject = (Class)finalizableReferenceClassReference.get();
    if (localObject != null) {
      try
      {
        localObject = ((Class)localObject).getMethod("finalizeReferent", new Class[0]);
        return localObject;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new AssertionError(localNoSuchMethodException);
      }
    }
    throw new ShutDown(null);
  }
  
  public static Field getInheritableThreadLocalsField()
  {
    try
    {
      Field localField = Thread.class.getDeclaredField("inheritableThreadLocals");
      localField.setAccessible(true);
      return localField;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
    return null;
  }
  
  public static ReferenceQueue startFinalizer(Class paramClass, Object paramObject)
  {
    if (paramClass.getName().equals("com.google.common.base.FinalizableReference"))
    {
      paramClass = new Finalizer(paramClass, paramObject);
      paramObject = new Thread(paramClass);
      paramObject.setName(b.class.getName());
      paramObject.setDaemon(true);
      try
      {
        Field localField = inheritableThreadLocals;
        if (localField != null) {
          inheritableThreadLocals.set(paramObject, null);
        }
      }
      catch (Throwable localThrowable)
      {
        logger.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", localThrowable);
      }
      paramObject.start();
      return queue;
    }
    throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
  }
  
  public void run()
  {
    for (;;)
    {
      ReferenceQueue localReferenceQueue = queue;
      try
      {
        cleanUp(localReferenceQueue.remove());
      }
      catch (InterruptedException localInterruptedException) {}catch (ShutDown localShutDown) {}
    }
  }
  
  public class ShutDown
    extends Exception
  {
    public ShutDown() {}
  }
}
