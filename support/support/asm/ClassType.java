package support.support.asm;

import f.sufficientlysecure.rootcommands.util.StringBuilder;

public class ClassType
  implements Type
{
  public ClassType() {}
  
  public Track create(Class paramClass)
  {
    try
    {
      Object localObject = paramClass.newInstance();
      return (Track)localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(StringBuilder.toString("Cannot create an instance of ", paramClass), localIllegalAccessException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(StringBuilder.toString("Cannot create an instance of ", paramClass), localInstantiationException);
    }
  }
}
