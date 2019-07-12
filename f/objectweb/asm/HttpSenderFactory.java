package f.objectweb.asm;

import java.lang.reflect.Field;

public class HttpSenderFactory
{
  public HttpSenderFactory() {}
  
  public static Object create(Object paramObject, String paramString)
    throws NoSuchFieldException, IllegalAccessException
  {
    paramString = paramObject.getClass().getDeclaredField(paramString);
    paramString.setAccessible(true);
    return paramString.get(paramObject);
  }
}
