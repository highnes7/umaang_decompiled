package f.h.a;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Factory
{
  static
  {
    try
    {
      makeSJP();
      return;
    }
    catch (Throwable localThrowable)
    {
      t = localThrowable;
    }
  }
  
  public Factory() {}
  
  public static Factory aspectOf()
  {
    Factory localFactory = count;
    if (localFactory != null) {
      return localFactory;
    }
    throw ((Throwable)new NoAspectBoundException("com.googlecode.mp4parser.RequiresParseDetailAspect", t));
  }
  
  public static boolean get()
  {
    return count != null;
  }
  
  public void before(JoinPoint paramJoinPoint)
  {
    if ((paramJoinPoint.getTarget() instanceof Message))
    {
      if (!((Message)paramJoinPoint.getTarget()).isParsed()) {
        ((Message)paramJoinPoint.getTarget()).parseDetails();
      }
    }
    else {
      throw new RuntimeException(f.sufficientlysecure.rootcommands.util.StringBuilder.get(a.class, new StringBuilder("Only methods in subclasses of "), " can  be annotated with ParseDetail"));
    }
  }
}
