package f.g.c.package_10;

import f.g.c.a.d;
import f.g.c.b.G;
import f.g.c.b.G.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinalizableReferenceQueue
{
  public static final String FINALIZER_CLASS_NAME = "com.google.common.base.internal.Finalizer";
  public static final Logger logger = Logger.getLogger(G.class.getName());
  public static final Method startFinalizer = getStartFinalizer(loadFinalizer(new FinalizerLoader[] { new SystemLoader(), new DecoupledLoader(), new DirectLoader() }));
  public final ReferenceQueue<Object> queue;
  public final boolean threadStarted;
  
  /* Error */
  public FinalizableReferenceQueue()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 64	java/lang/Object:<init>	()V
    //   4: iconst_1
    //   5: istore_1
    //   6: getstatic 58	f/g/c/package_10/FinalizableReferenceQueue:startFinalizer	Ljava/lang/reflect/Method;
    //   9: astore_2
    //   10: aload_2
    //   11: aconst_null
    //   12: iconst_2
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: ldc 66
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_0
    //   24: aastore
    //   25: invokevirtual 72	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   28: astore_2
    //   29: aload_2
    //   30: checkcast 74	java/lang/ref/ReferenceQueue
    //   33: astore_2
    //   34: goto +26 -> 60
    //   37: astore_2
    //   38: getstatic 43	f/g/c/package_10/FinalizableReferenceQueue:logger	Ljava/util/logging/Logger;
    //   41: getstatic 80	java/util/logging/Level:INFO	Ljava/util/logging/Level;
    //   44: ldc 82
    //   46: aload_2
    //   47: invokevirtual 86	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   50: new 74	java/lang/ref/ReferenceQueue
    //   53: dup
    //   54: invokespecial 87	java/lang/ref/ReferenceQueue:<init>	()V
    //   57: astore_2
    //   58: iconst_0
    //   59: istore_1
    //   60: aload_0
    //   61: aload_2
    //   62: putfield 89	f/g/c/package_10/FinalizableReferenceQueue:queue	Ljava/lang/ref/ReferenceQueue;
    //   65: aload_0
    //   66: iload_1
    //   67: putfield 91	f/g/c/package_10/FinalizableReferenceQueue:threadStarted	Z
    //   70: return
    //   71: astore_2
    //   72: new 93	java/lang/AssertionError
    //   75: dup
    //   76: aload_2
    //   77: invokespecial 96	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	FinalizableReferenceQueue
    //   5	62	1	bool	boolean
    //   9	25	2	localObject	Object
    //   37	10	2	localThrowable	Throwable
    //   57	5	2	localReferenceQueue	ReferenceQueue
    //   71	6	2	localIllegalAccessException	IllegalAccessException
    // Exception table:
    //   from	to	target	type
    //   6	10	37	java/lang/Throwable
    //   10	29	37	java/lang/Throwable
    //   29	34	37	java/lang/Throwable
    //   10	29	71	java/lang/IllegalAccessException
  }
  
  public static Method getStartFinalizer(Class paramClass)
  {
    try
    {
      paramClass = paramClass.getMethod("startFinalizer", new Class[] { Class.class, Object.class });
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      throw new AssertionError(paramClass);
    }
  }
  
  public static Class loadFinalizer(FinalizerLoader... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = paramVarArgs[i].loadFinalizer();
      if (localClass != null) {
        return localClass;
      }
      i += 1;
    }
    paramVarArgs = new AssertionError();
    throw paramVarArgs;
  }
  
  public void cleanUp()
  {
    if (threadStarted) {
      return;
    }
    for (;;)
    {
      Reference localReference = queue.poll();
      if (localReference == null) {
        break;
      }
      localReference.clear();
      try
      {
        ((FinalizableReference)localReference).finalizeReferent();
      }
      catch (Throwable localThrowable)
      {
        logger.log(Level.SEVERE, "Error cleaning up after reference.", localThrowable);
      }
    }
  }
  
  public class DecoupledLoader
    implements FinalizableReferenceQueue.FinalizerLoader
  {
    public static final String LOADING_ERROR = "Could not load Finalizer in its own class loader.Loading Finalizer in the current class loader instead. As a result, you will not be ableto garbage collect this class loader. To support reclaiming this class loader, eitherresolve the underlying issue, or move Google Collections to your system class path.";
    
    public DecoupledLoader() {}
    
    public URL getBaseUrl()
      throws IOException
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("com.google.common.base.internal.Finalizer".replace('.', '/'));
      ((StringBuilder)localObject).append(".class");
      localObject = ((StringBuilder)localObject).toString();
      URL localURL = G.a.class.getClassLoader().getResource((String)localObject);
      if (localURL != null)
      {
        String str = localURL.toString();
        if (str.endsWith((String)localObject)) {
          return new URL(localURL, str.substring(0, str.length() - ((String)localObject).length()));
        }
        throw new IOException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Unsupported path style: ", str));
      }
      throw new FileNotFoundException((String)localObject);
    }
    
    public Class loadFinalizer()
    {
      try
      {
        Class localClass = newLoader(getBaseUrl()).loadClass("com.google.common.base.internal.Finalizer");
        return localClass;
      }
      catch (Exception localException)
      {
        FinalizableReferenceQueue.logger.log(Level.WARNING, "Could not load Finalizer in its own class loader.Loading Finalizer in the current class loader instead. As a result, you will not be ableto garbage collect this class loader. To support reclaiming this class loader, eitherresolve the underlying issue, or move Google Collections to your system class path.", localException);
      }
      return null;
    }
    
    public URLClassLoader newLoader(URL paramURL)
    {
      return new URLClassLoader(new URL[] { paramURL }, null);
    }
  }
  
  public class DirectLoader
    implements FinalizableReferenceQueue.FinalizerLoader
  {
    public DirectLoader() {}
    
    public Class loadFinalizer()
    {
      try
      {
        Class localClass = Class.forName("f.g.c.b.a.b");
        return localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new AssertionError(localClassNotFoundException);
      }
    }
  }
  
  public abstract interface FinalizerLoader
  {
    public abstract Class loadFinalizer();
  }
  
  public class SystemLoader
    implements FinalizableReferenceQueue.FinalizerLoader
  {
    @d
    public static boolean disabled;
    
    public SystemLoader() {}
    
    public Class loadFinalizer()
    {
      if (disabled) {
        return null;
      }
      try
      {
        localObject = ClassLoader.getSystemClassLoader();
        if (localObject == null) {}
      }
      catch (SecurityException localSecurityException)
      {
        Object localObject;
        for (;;) {}
      }
      try
      {
        localObject = ((ClassLoader)localObject).loadClass("com.google.common.base.internal.Finalizer");
        return localObject;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
      return null;
      FinalizableReferenceQueue.logger.info("Not allowed to access system class loader.");
      return null;
      return null;
    }
  }
}
