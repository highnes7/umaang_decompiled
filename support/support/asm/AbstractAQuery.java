package support.support.asm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AbstractAQuery
  extends ClassType
{
  public static AbstractAQuery root;
  public Application context;
  
  public AbstractAQuery(Application paramApplication)
  {
    context = paramApplication;
  }
  
  public static AbstractAQuery create(Application paramApplication)
  {
    if (root == null) {
      root = new AbstractAQuery(paramApplication);
    }
    return root;
  }
  
  public Track create(Class paramClass)
  {
    if (AndroidViewModel.class.isAssignableFrom(paramClass)) {
      try
      {
        Object localObject = paramClass.getConstructor(new Class[] { Application.class });
        Application localApplication = context;
        localObject = ((Constructor)localObject).newInstance(new Object[] { localApplication });
        return (Track)localObject;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(StringBuilder.toString("Cannot create an instance of ", paramClass), localInvocationTargetException);
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new RuntimeException(StringBuilder.toString("Cannot create an instance of ", paramClass), localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException(StringBuilder.toString("Cannot create an instance of ", paramClass), localIllegalAccessException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new RuntimeException(StringBuilder.toString("Cannot create an instance of ", paramClass), localNoSuchMethodException);
      }
    }
    return super.create(paramClass);
  }
}
