package support.android.v4.asm.session;

import android.media.session.MediaSession;
import b.b.a.K;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@K(24)
public class d
{
  public static final String F = "MediaSessionCompatApi24";
  
  public d() {}
  
  public static String a(Object paramObject)
  {
    paramObject = (MediaSession)paramObject;
    try
    {
      Object localObject = paramObject.getClass();
      localObject = ((Class)localObject).getMethod("getCallingPackage", new Class[0]);
      paramObject = ((Method)localObject).invoke(paramObject, new Object[0]);
      return (String)paramObject;
    }
    catch (NoSuchMethodException paramObject)
    {
      for (;;) {}
    }
    catch (InvocationTargetException paramObject)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Object b(Label paramLabel)
  {
    return new PositionMetric(paramLabel);
  }
}
