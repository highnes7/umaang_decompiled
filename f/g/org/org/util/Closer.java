package f.g.org.org.util;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Throwables;

public final class Closer
{
  public Closer() {}
  
  public static void close(Throwable paramThrowable)
  {
    Throwables.propagateIfPossible(paramThrowable);
  }
  
  public static void propagateIfPossible(Throwable paramThrowable, Class paramClass)
    throws Throwable
  {
    Throwables.propagateIfInstanceOf(paramThrowable, paramClass);
    Throwables.propagateIfPossible(paramThrowable);
  }
  
  public static RuntimeException rethrow(Throwable paramThrowable)
  {
    Throwables.propagate(paramThrowable);
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
}
