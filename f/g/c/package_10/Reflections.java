package f.g.c.package_10;

import f.g.c.a.a;
import f.g.c.a.b;
import java.lang.reflect.Field;

@a
@b(emulated=true)
public final class Reflections
{
  public Reflections() {}
  
  public static Optional get(Class paramClass, String paramString)
  {
    if ((paramClass == null) || (paramString != null)) {}
    try
    {
      paramClass = Optional.of(Enum.valueOf(paramClass, paramString));
      return paramClass;
    }
    catch (IllegalArgumentException paramClass)
    {
      for (;;) {}
    }
    return Absent.INSTANCE;
    throw new NullPointerException();
    throw new NullPointerException();
  }
  
  public static Field getField(Enum paramEnum)
  {
    Class localClass = paramEnum.getDeclaringClass();
    try
    {
      paramEnum = localClass.getDeclaredField(paramEnum.name());
      return paramEnum;
    }
    catch (NoSuchFieldException paramEnum)
    {
      throw new AssertionError(paramEnum);
    }
  }
  
  public static Function instanceOf(Class paramClass)
  {
    return new Handle(paramClass, null);
  }
}
